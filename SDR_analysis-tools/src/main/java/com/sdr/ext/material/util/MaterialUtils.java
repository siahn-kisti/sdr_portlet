package com.sdr.ext.material.util;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.*;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.portlet.PortletProps;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.sdr.metadata.model.DataTypeSchema;
import com.sdr.metadata.model.Dataset;
import com.sdr.metadata.service.DataTypeSchemaLocalServiceUtil;
import com.sdr.metadata.service.DatasetServiceUtil;
import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.exec.ExecuteException;
import org.apache.commons.exec.PumpStreamHandler;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import javax.portlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.*;

public class MaterialUtils {

    private static Log log = LogFactoryUtil.getLog(MaterialUtils.class);

    public MaterialUtils() {
    }

    /**
     * @Methods Name : getSameResultsUploadedFilesMaterialExplorer
     * @작성일 : 2017. 7. 20.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : Material Explorer에서 요청한 파일과 같은 Dataset 검색 결과 받기
     */
    public static Map<String, Object> getSameResultsUploadedFilesMaterialExplorer(Map<String, Object> om, RenderRequest renderRequest, RenderResponse renderResponse) throws Exception {
        String condition = om.get("condition").toString();
        List<DMDatasetVO> datasetList = (List<DMDatasetVO>) om.get("datasetList");
        String uploadedFileName = om.get("uploadedFileName").toString();

        int delta = 0;
        if (renderRequest.getAttribute("delta") != null) {
            delta = Integer.parseInt((String) renderRequest.getAttribute("delta"));
        } else {
            delta = SearchStaticInitalize.getDelta();
        }
        SearchContainer<DMDatasetVO> searchContainer = new SearchContainer<DMDatasetVO>(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchStaticInitalize.getCur(), delta, renderResponse.createRenderURL(), null, "No data found.");

        Map<String, Object> op = null;
        List<DMDatasetVO> datasetNewList = new ArrayList<DMDatasetVO>();
        // extract 4. 추출한 첨부파일 정보와 업로드한 POSCAR 파일 비교 (post_bystructure.py)
        for (DMDatasetVO dataset : datasetList) {

            String inputRealFileLocation = getAnalysisInputTempRealPath(condition) + File.separator + uploadedFileName;
            String outputWebTempLocation = dataset.getLocation() + File.separator + PortletProps.get("poscarFileName");

            String[] cmd = {getPythonCommand(), getAnalysisScriptPath("materials-explorer"), "\"" + inputRealFileLocation + "\"", "\"" + inputRealFileLocation + "\"", "\"" + outputWebTempLocation + "\""};
            String[] arg = null;
            // python 스크립트 실행
            String compare = byCommonsExec(cmd, arg).get("compare").toString();
            // extract 5. 일치하는 dataset 목록 가져와서 응답하기
            if (compare.equals("true")) {
                datasetNewList.add(dataset);
            }
        }

        searchContainer.setTotal(datasetNewList.size());
        searchContainer.setResults(datasetNewList);

        om.put("datasetList", datasetNewList);
        om.put("total", datasetNewList.size());
        om.put("searchContainer", searchContainer);

        return om;
    }

    /**
     * @Methods Name : getDatasetSearchIndexedResultsMaterialsExplorer
     * @작성일 : 2017. 7. 20.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : Material Explorer에서 요청한 엘리먼트로 색인된 Dataset 검색 결과 받기
     */
    public static Map<String, Object> getDatasetSearchIndexedResultsMaterialsExplorer(Map<String, Object> om, RenderRequest renderRequest, RenderResponse renderResponse) throws Exception {
        String condition = MaterialUtils.isNullToString(om.get("condition"));
        String searchValue = MaterialUtils.isNullToString(om.get("searchValue"));
        String nelementsSelect = MaterialUtils.isNullToString(om.get("nelementsSelect"));
        Map<String, String> density = getHyphenSplitMaterialsExplorerParameter(om.get("densityValue"));
        Map<String, String> nelements = getHyphenSplitMaterialsExplorerParameter(om.get("nelementsValue"));
        Map<String, String> bandgap = getHyphenSplitMaterialsExplorerParameter(om.get("bandgapValue"));
        Map<String, String> volume = getHyphenSplitMaterialsExplorerParameter(om.get("volumeValue"));

        SearchContext searchContext = SearchStaticInitalize.getSearchContext(Dataset.class);
        ServiceContext serviceContext = SearchStaticInitalize.getServiceContext(Dataset.class);

        // common query
        BooleanQuery mainQuery = BooleanQueryFactoryUtil.create(searchContext);

        if (nelementsSelect.equals("y")) {
            mainQuery = addSubRangeQuery(searchContext, mainQuery, "nelements_sortable", Integer.class, nelements, BooleanClauseOccur.MUST);
        }

        mainQuery = addSubRangeQuery(searchContext, mainQuery, "density_sortable", Double.class, density, BooleanClauseOccur.MUST);
        mainQuery = addSubRangeQuery(searchContext, mainQuery, "bandgap_sortable", Double.class, bandgap, BooleanClauseOccur.MUST);
        mainQuery = addSubRangeQuery(searchContext, mainQuery, "volume_sortable", Double.class, volume, BooleanClauseOccur.MUST);

        if (condition.equals("elements")) {
            String[] searchArray = getCommaSplitMaterialsExplorerParameter(searchValue);

            for (String value : searchArray) {
                mainQuery = addSubExactQuery(searchContext, mainQuery, condition, String.class, value, BooleanClauseOccur.MUST);
            }

            if (!nelementsSelect.equals("y")) {
                mainQuery = addSubExactQuery(searchContext, mainQuery, "nelements_sortable", Integer.class, searchArray.length, BooleanClauseOccur.MUST);
            }

        } else if (condition.equals("reducedformula")) {
            mainQuery = addSubExactQuery(searchContext, mainQuery, condition, String.class, searchValue, BooleanClauseOccur.MUST);
        }
        // by Structure (extract) query
        else {
            mainQuery = addSubExactQuery(searchContext, mainQuery, "nsites_sortable", Integer.class, om.get("sites"), BooleanClauseOccur.MUST);
            mainQuery = addSubExactQuery(searchContext, mainQuery, "reducedformula", String.class, om.get("reducedformula"), BooleanClauseOccur.MUST);
        }

        PortletURL iteratorURL = renderResponse.createRenderURL();
        for (String key : om.keySet()) {
            iteratorURL.setParameter(key, om.get(key).toString());
        }

        int delta;
        if (renderRequest.getAttribute("delta") != null) {
            delta = Integer.parseInt((String) renderRequest.getAttribute("delta"));
        } else {
            delta = SearchStaticInitalize.getDelta();
        }

        SearchContainer<DMDatasetVO> searchContainer = new SearchContainer<DMDatasetVO>(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchStaticInitalize.getCur(), delta, iteratorURL, null, "No data found.");

        searchContext.setStart(searchContainer.getStart());
        searchContext.setEnd(searchContainer.getEnd());

        Hits hits;
        try {
            hits = DatasetServiceUtil.querySearchEngine(serviceContext, searchContext, mainQuery);
        } catch (SearchException | ParseException e) {
            log.error(e.getMessage());
            throw e;
        }

        List<DMDatasetVO> datasetList = new ArrayList<DMDatasetVO>();

        int total = hits.getLength();

        for (int i = 0; i < hits.getDocs().length; i++) {
            DMDatasetVO dataset = new DMDatasetVO();
            dataset.setAll(hits.doc(i));
            datasetList.add(dataset);
        }

        searchContainer.setTotal(total);
        searchContainer.setResults(datasetList);

        // Permission Check
        boolean isGuest = PermissionConstant.checkGuest(serviceContext);
        if (isGuest) {
            searchContainer.setEmptyResultsMessage("You do not have permission.");
        }

        om.put("datasetList", datasetList);
        om.put("searchValue", searchValue);
        om.put("total", total);
        om.put("searchContainer", searchContainer);

        return om;
    }

    /**
     * @Methods Name : getDatasetSearchIndexedResultsBatteryExplorer
     * @작성일 : 2017. 11. 09.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : Battery Explorer에서 요청한 엘리먼트로 색인된 Dataset 검색 결과 받기
     */
    public static Map<String, Object> getDatasetSearchIndexedResultsBatteryExplorer(Map<String, Object> om, RenderRequest renderRequest, RenderResponse renderResponse) throws Exception {
        String condition = isNullToString(om.get("condition"));
        String workingIon = isNullToString(om.get("workingIon"));
        String searchValue = isNullToString(om.get("searchValue"));
        String nelementsSelect = isNullToString(om.get("nelementsSelect"));

        Map<String, String> avgVoltage = getHyphenSplitMaterialsExplorerParameter(om.get("avgVoltageValue"));
        Map<String, String> volumetricCapacity = getHyphenSplitMaterialsExplorerParameter(om.get("volumetricCapacityValue"));
        Map<String, String> gravimetricCapacity = getHyphenSplitMaterialsExplorerParameter(om.get("gravimetricCapacityValue"));
        Map<String, String> nelements = getHyphenSplitMaterialsExplorerParameter(om.get("nelementsValue"));

        SearchContext searchContext = SearchStaticInitalize.getSearchContext(Dataset.class);
        ServiceContext serviceContext = SearchStaticInitalize.getServiceContext(Dataset.class);

        // common query
        BooleanQuery mainQuery = BooleanQueryFactoryUtil.create(searchContext);
        BooleanQuery subQuery;

        if (nelementsSelect.equals("y")) {
            mainQuery = addSubRangeQuery(searchContext, mainQuery, "nelements_sortable", Integer.class, nelements, BooleanClauseOccur.MUST);
        }

        // Battery Type
        Map<String, String> volumeChange = new HashMap<>();
        volumeChange.put("min", String.valueOf(Double.MIN_VALUE));
        volumeChange.put("max", String.valueOf(Double.MAX_VALUE));
        mainQuery = addSubRangeQuery(searchContext, mainQuery, "volumn_change_sortable", Double.class, volumeChange, BooleanClauseOccur.MUST);

        if (!workingIon.isEmpty()) {
            subQuery = BooleanQueryFactoryUtil.create(searchContext);
            String[] array = workingIon.split(",");
            for (int i = 0; i < array.length; i++) {
                subQuery.addTerm("working_ion", array[i], false, BooleanClauseOccur.SHOULD);
            }
            mainQuery.add(subQuery, BooleanClauseOccur.MUST);
        }

        mainQuery = addSubRangeQuery(searchContext, mainQuery, "voltage_sortable", Double.class, avgVoltage, BooleanClauseOccur.MUST);
        mainQuery = addSubRangeQuery(searchContext, mainQuery, "volumetric_capacity_sortable", Double.class, volumetricCapacity, BooleanClauseOccur.MUST);
        mainQuery = addSubRangeQuery(searchContext, mainQuery, "gravimetric_capacity_sortable", Double.class, gravimetricCapacity, BooleanClauseOccur.MUST);

        if (condition.equals("elements")) {
            String[] searchArray = getCommaSplitMaterialsExplorerParameter(searchValue);

            for (String value : searchArray) {
                mainQuery = addSubExactQuery(searchContext, mainQuery, condition, String.class, value, BooleanClauseOccur.MUST);
            }

            if (!nelementsSelect.equals("y")) {
                mainQuery = addSubExactQuery(searchContext, mainQuery, "nelements_sortable", Integer.class, searchArray.length, BooleanClauseOccur.MUST);
            }

        } else if (condition.equals("material")) {
            mainQuery = addSubExactQuery(searchContext, mainQuery, condition, String.class, searchValue, BooleanClauseOccur.MUST);
        } else if (condition.equals("materialids")) {

        }

        PortletURL iteratorURL = renderResponse.createRenderURL();
        for (String key : om.keySet()) {
            iteratorURL.setParameter(key, om.get(key).toString());
        }

        int delta;
        if (renderRequest.getAttribute("delta") != null) {
            delta = Integer.parseInt((String) renderRequest.getAttribute("delta"));
        } else {
            delta = SearchStaticInitalize.getDelta();
        }
        SearchContainer<BatteryVO> searchContainer = new SearchContainer<BatteryVO>(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchStaticInitalize.getCur(), delta, iteratorURL, null, "No data found.");

        searchContext.setStart(searchContainer.getStart());
        searchContext.setEnd(searchContainer.getEnd());

        Hits hits;
        try {
            hits = DatasetServiceUtil.querySearchEngine(serviceContext, searchContext, mainQuery);
        } catch (SearchException | ParseException e) {
            log.error(e.getMessage());
            throw e;
        }

        List<BatteryVO> datasetList = new ArrayList<>();

        int total = hits.getLength();

        for (int i = 0; i < hits.getDocs().length; i++) {
            BatteryVO dataset = new BatteryVO();
            dataset.setAll(hits.doc(i));
            datasetList.add(dataset);
        }

        searchContainer.setTotal(total);
        searchContainer.setResults(datasetList);

        // Permission Check
        boolean isGuest = PermissionConstant.checkGuest(serviceContext);
        if (isGuest) {
            searchContainer.setEmptyResultsMessage("You do not have permission.");
        }

        om.put("workingIon", workingIon);
        om.put("datasetList", datasetList);
        om.put("searchValue", searchValue);
        om.put("total", total);
        om.put("searchContainer", searchContainer);

        return om;
    }

    /**
     * @Methods Name : getDatasetSearchIndexedResultsNanoporousExplorer
     * @작성일 : 2018. 10. 08.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : Nanoporous Explorer에서 요청한 엘리먼트로 색인된 Dataset 검색 결과 받기
     */
    public static Map<String, Object> getDatasetSearchIndexedResultsNanoporousExplorer(Map<String, Object> om, RenderRequest renderRequest, RenderResponse renderResponse) throws Exception {
        log.debug("getDatasetSearchIndexedResultsNanoporousExplorer");

        String condition = MaterialUtils.isNullToString(om.get("condition"));
        String searchValue = MaterialUtils.isNullToString(om.get("searchValue"));

        SearchContext searchContext = SearchStaticInitalize.getSearchContext(Dataset.class);
        ServiceContext serviceContext = SearchStaticInitalize.getServiceContext(Dataset.class);

        // common query
        BooleanQuery mainQuery = BooleanQueryFactoryUtil.create(searchContext);



        if (condition.equals("elements")) {
            String[] searchArray = getCommaSplitMaterialsExplorerParameter(searchValue);

            for (String value : searchArray) {
                mainQuery = addSubExactQuery(searchContext, mainQuery, condition, String.class, value, BooleanClauseOccur.MUST);
            }

        } else if (condition.equals("reducedformula")) {
            mainQuery = addSubExactQuery(searchContext, mainQuery, condition, String.class, searchValue, BooleanClauseOccur.MUST);
        }
        // by Structure (extract) query
        else {
            mainQuery = addSubExactQuery(searchContext, mainQuery, "nsites_sortable", Integer.class, om.get("sites"), BooleanClauseOccur.MUST);
            mainQuery = addSubExactQuery(searchContext, mainQuery, "reducedformula", String.class, om.get("reducedformula"), BooleanClauseOccur.MUST);
        }

        PortletURL iteratorURL = renderResponse.createRenderURL();
        for (String key : om.keySet()) {
            iteratorURL.setParameter(key, om.get(key).toString());
        }

        int delta;
        if (renderRequest.getAttribute("delta") != null) {
            delta = Integer.parseInt((String) renderRequest.getAttribute("delta"));
        } else {
            delta = SearchStaticInitalize.getDelta();
        }

        SearchContainer<DMDatasetVO> searchContainer = new SearchContainer<DMDatasetVO>(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchStaticInitalize.getCur(), delta, iteratorURL, null, "No data found.");

        searchContext.setStart(searchContainer.getStart());
        searchContext.setEnd(searchContainer.getEnd());

        Hits hits;
        try {
            hits = DatasetServiceUtil.querySearchEngine(serviceContext, searchContext, mainQuery);
        } catch (SearchException | ParseException e) {
            log.error(e.getMessage());
            throw e;
        }

        List<DMDatasetVO> datasetList = new ArrayList<DMDatasetVO>();

        int total = hits.getLength();

        for (int i = 0; i < hits.getDocs().length; i++) {
            DMDatasetVO dataset = new DMDatasetVO();
            dataset.setAll(hits.doc(i));
            datasetList.add(dataset);
        }

        searchContainer.setTotal(total);
        searchContainer.setResults(datasetList);

        // Permission Check
        boolean isGuest = PermissionConstant.checkGuest(serviceContext);
        if (isGuest) {
            searchContainer.setEmptyResultsMessage("You do not have permission.");
        }

        om.put("datasetList", datasetList);
        om.put("searchValue", searchValue);
        om.put("total", total);
        om.put("searchContainer", searchContainer);

        return om;
    }

    /**
     * @Methods Name : getNumericMinMax
     * @작성일 : 2017. 11. 29.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : 인덱싱된 숫자형 데이터에서 Min/Max 값 조회하기
     */
    public static Object getNumericMinMax(Class<?> c, String field, int type, Boolean reverse, String dataType) throws ParseException, SearchException {
        String sortableField = field + "_sortable";

        SearchContext searchContext = SearchStaticInitalize.getSearchContext(c);
        searchContext.setStart(0);
        searchContext.setEnd(1);
        searchContext.setSorts(SortFactoryUtil.create(sortableField, type, reverse));
        BooleanQuery mainQuery = BooleanQueryFactoryUtil.create(searchContext);
        BooleanQuery subQuery = BooleanQueryFactoryUtil.create(searchContext);

        if (dataType.equals("vasp_battery")) {
            // Battery Type
            Map<String, String> volumeChange = new HashMap<>();
            volumeChange.put("min", String.valueOf(Double.MIN_VALUE));
            volumeChange.put("max", String.valueOf(Double.MAX_VALUE));
            mainQuery = addSubRangeQuery(searchContext, mainQuery, "volumn_change_sortable", Double.class, volumeChange, BooleanClauseOccur.MUST);
        }

        if (type == Sort.DOUBLE_TYPE) {
            subQuery.addNumericRangeTerm(sortableField, Double.MIN_VALUE, Double.MAX_VALUE);
        } else if (type == Sort.INT_TYPE) {
            subQuery.addNumericRangeTerm(sortableField, Integer.MIN_VALUE, Integer.MAX_VALUE);
        } else {
            try {
                throw new Exception("Invalid data type : " + type);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        mainQuery.add(subQuery, BooleanClauseOccur.MUST);
        Hits hits = SearchEngineUtil.search(searchContext, mainQuery);

        Object returnValue = getChangeDataType(type, null, 0);

        if (hits.getLength() > 0) {

            Document doc = hits.doc(0);

            if (reverse) {
                returnValue = getChangeDataType(type, "ceil", doc.get(sortableField));
            } else {
                returnValue = getChangeDataType(type, "floor", doc.get(sortableField));
            }

        } else if (reverse == true) {
            returnValue = getChangeDataType(type, null, Integer.MAX_VALUE);
        }
        return returnValue;
    }

    /**
     * @Methods Name : getDataJsonBatteryExplorer
     * @작성일 : 2017. 8. 29.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : Battery Explorer JSON data 생성

    public static Map<String, Object> getDataJsonBatteryExplorer(Map<String, Object> om) {
    Map<String, Object> dm = new HashMap<String, Object>();

    long datasetId = Long.parseLong(om.get("datasetId").toString());

    dm = getDatasetDescriptiveMetadata(datasetId);
    return dm;
    }
     */

    /**
     * @Methods Name : getDataJsonReactionCalculator
     * @작성일 : 2017. 8. 29.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : Reaction calculator JSON data 생성
     */
    public static void getDataJsonReactionCalculator(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
            throws SystemException, PortalException, IOException {

        String reactants = ParamUtil.getString(resourceRequest, "reactants");
        String products = ParamUtil.getString(resourceRequest, "products");
        String condition = "reaction-calculator";

        String outputWebTempLocation = getAnalysisOutputTempRealPath(condition);
        String outputFullPath = outputWebTempLocation + File.separator + PortletProps.get("outputJsonName");

        // pre-reaction.py 실행 : reactions 입력 원소 콤마 Join
        String[] cmd = {getPythonCommand(), "\"" + getAnalysisPath("reaction-calculator") + File.separator + "pre-reaction.py" + "\"", "\"" + reactants + "\"", "\"" + products + "\"", "\"" + outputWebTempLocation + "\""};
        String[] arg = null;

        Map<String, Object> preResultMap = byCommonsExec(cmd, arg);

        String elements;
        if (preResultMap.containsKey("elements")) {
            elements = preResultMap.get("elements").toString();

            ServiceContext serviceContext = ServiceContextFactory.getInstance(resourceRequest);
            Map<String, Object> map = getDistinctElementsList(serviceContext, elements);
            List<DMDatasetVO> datasetList = (ArrayList<DMDatasetVO>) map.get("datasetList");
            Boolean result = (Boolean) map.get("result");

            if (result) {
                String inputRealFileLocation = getAnalysisInputTempRealPath(condition) + File.separator + "input.json";

                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String resultString = gson.toJson(datasetList);

                MaterialFileUtils.writeFile(resultString, inputRealFileLocation);

                // post-reaction.py 실행
                String[] cmd2 = {getPythonCommand(), "\"" + getAnalysisPath("reaction-calculator") + File.separator + "post-reaction.py" + "\""};
                String[] arg2 = {"\"" + reactants + "\"", "\"" + products + "\"", "\"" + inputRealFileLocation + "\"", "\"" + outputWebTempLocation + "\""};
                byCommonsExec(cmd2, arg2);

                MaterialFileUtils.jsonToArrayFile(outputFullPath);
            } else {
                MaterialFileUtils.writeFile("[{'error':'No results were found for your search.'}]", outputFullPath);
            }
        } else if (preResultMap.containsKey("error")) {
            MaterialFileUtils.writeFile("[{'error':'" + preResultMap.get("error").toString() + "'}]", outputFullPath);
        }

        getWriteRealFileRootPath(resourceResponse, outputFullPath, null);
    }

    /**
     * @Methods Name : getSearchDataJsonPhaseDiagram
     * @작성일 : 2017. 8. 21.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : 차트 데이터 생성
     */
    public static void getSearchDataJsonPhaseDiagram(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
            throws SystemException, PortalException, IOException {

        // TODO : Error Handling

        String condition = ParamUtil.getString(resourceRequest, "condition");
        String searchValue = ParamUtil.getString(resourceRequest, "searchValue");

        // TODO Dataset Permission
        // boolean hasAddRight = DatasetPermission.contains(MaterialCommonVO.getPermissionChecker(), MaterialCommonVO.getScopeGroupId(), "ADD_DATASET");
        ServiceContext serviceContext = ServiceContextFactory.getInstance(resourceRequest);
        Map<String, Object> map = getDistinctElementsList(serviceContext, searchValue);

        List<DMDatasetVO> datasetList = (ArrayList<DMDatasetVO>) map.get("datasetList");
        Boolean result = (Boolean) map.get("result");

        String outputWebTempLocation = getAnalysisOutputTempRealPath(condition);
        String outputFullPath = outputWebTempLocation + File.separator + PortletProps.get("outputJsonName");

        if (result) {
            String inputRealFileLocation = getAnalysisInputTempRealPath(condition) + File.separator + "phase_input.json";

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String resultString = gson.toJson(datasetList);

            MaterialFileUtils.writeFile(resultString, inputRealFileLocation);

            String[] cmd = {getPythonCommand(), getAnalysisScriptPath("phase-diagram"), "\"" + inputRealFileLocation + "\"", "\"" + outputWebTempLocation + "\""};
            String[] arg = null;

            byCommonsExec(cmd, arg);

            MaterialFileUtils.jsonToArrayFile(outputFullPath);
        } else {
            MaterialFileUtils.writeFile("[{'error':'No results were found for your search.'}]", outputFullPath);
        }

        getWriteRealFileRootPath(resourceResponse, outputFullPath, null);
    }

    /**
     * @Methods Name : getSearchDataJsonNanoporousExplorer
     * @작성일 : 2018. 7. 10.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : 나노전자소재 데이터 생성
     */
    public static void getSearchDataJsonNanoporousAnalysis(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

        String condition = ParamUtil.getString(resourceRequest, "condition");
        String searchValue = ParamUtil.getString(resourceRequest, "searchValue");
        String nelementsSelect = ParamUtil.getString(resourceRequest, "nelementsSelect");

        Map<String, String> density = getHyphenSplitMaterialsExplorerParameter(resourceRequest.getParameter("densityValue"));
        Map<String, String> nelements = getHyphenSplitMaterialsExplorerParameter(resourceRequest.getParameter("nelementsValue"));
        Map<String, String> bandgap = getHyphenSplitMaterialsExplorerParameter(resourceRequest.getParameter("bandgapValue"));
        Map<String, String> volume = getHyphenSplitMaterialsExplorerParameter(resourceRequest.getParameter("volumeValue"));

        SearchContext searchContext = SearchStaticInitalize.getSearchContext(Dataset.class);
        ServiceContext serviceContext = SearchStaticInitalize.getServiceContext(Dataset.class);

        // common query
        BooleanQuery mainQuery = BooleanQueryFactoryUtil.create(searchContext);

        if (nelementsSelect.equals("y")) {
            mainQuery = addSubRangeQuery(searchContext, mainQuery, "nelements_sortable", Integer.class, nelements, BooleanClauseOccur.MUST);
        }

        mainQuery = addSubRangeQuery(searchContext, mainQuery, "density_sortable", Double.class, density, BooleanClauseOccur.MUST);
        mainQuery = addSubRangeQuery(searchContext, mainQuery, "bandgap_sortable", Double.class, bandgap, BooleanClauseOccur.MUST);
        mainQuery = addSubRangeQuery(searchContext, mainQuery, "volume_sortable", Double.class, volume, BooleanClauseOccur.MUST);

        if (condition.equals("elements")) {
            String[] searchArray = getCommaSplitMaterialsExplorerParameter(searchValue);

            for (String value : searchArray) {
                mainQuery = addSubExactQuery(searchContext, mainQuery, condition, String.class, value, BooleanClauseOccur.MUST);
            }

            if (!nelementsSelect.equals("y")) {
                mainQuery = addSubExactQuery(searchContext, mainQuery, "nelements_sortable", Integer.class, searchArray.length, BooleanClauseOccur.MUST);
            }

        } else if (condition.equals("reducedformula")) {
            mainQuery = addSubExactQuery(searchContext, mainQuery, condition, Integer.class, searchValue, BooleanClauseOccur.MUST);
        }
        // by Structure (extract) query
        else {
            mainQuery = addSubExactQuery(searchContext, mainQuery, "nsites_sortable", Integer.class, ParamUtil.getString(resourceRequest, "sites"), BooleanClauseOccur.MUST);
            mainQuery = addSubExactQuery(searchContext, mainQuery, "reducedformula", String.class, ParamUtil.getString(resourceRequest, "reducedformula"), BooleanClauseOccur.MUST);
        }

        Hits hits = new HitsImpl();

        // Data search
        try {
            hits = DatasetServiceUtil.querySearchEngine(serviceContext, searchContext, mainQuery);
        } catch (PortalException e) {
            e.printStackTrace();
        }

        List<DMDatasetVO> datasetList = new ArrayList<DMDatasetVO>();

        int total = hits.getLength();

        // 입력 CSV 파일 전체 경로
        String inputRealFileLocation = getAnalysisInputTempRealPath(condition) + File.separator + "nanoporous_input.csv";
        // 임시 디렉토리 생성
        String outputWebTempLocation = getAnalysisOutputTempRealPath(condition);
        // 출력 JSON 파일 전체 경로
        String outputFullPath = outputWebTempLocation + File.separator + "output.html";

        if (total > 0) {


            // List<MyBean> beans comes from somewhere earlier in your code.
            Writer writer = null;
            try {
                writer = new FileWriter(inputRealFileLocation);
            } catch (IOException e) {
                e.printStackTrace();
            }

            // CSV 형태 만들기
            //StatefulBeanToCsv<DMDatasetVO> beanToCsv = new StatefulBeanToCsvBuilder(writer).withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).build();
            StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).build();

            // 필요 메타 데이터 추출
            for (int i = 0; i < total; i++) {
                DMDatasetVO dataset = new DMDatasetVO();
                dataset.setAll(hits.doc(i));
                datasetList.add(dataset);
            }

            try {
                // CSV 형태로 데이터 쓰기
                beanToCsv.write(datasetList);
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (CsvDataTypeMismatchException e) {
                e.printStackTrace();
            } catch (CsvRequiredFieldEmptyException e) {
                e.printStackTrace();
            }

            String[] cmd = {getPythonCommand(), getAnalysisScriptPath("nanoporous-analysis"), "\"" + inputRealFileLocation + "\"", "\"" + outputFullPath + "\""};
            String[] arg = null;

            try {
                byCommonsExec(cmd, arg);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {

        }

        // Return values
        Map<String, Object> om = new HashMap<>();

        om.put("searchValue", searchValue);
        om.put("total", total);
        om.put("datasetList", datasetList);
        om.put("permission", true);

        // Permission Check
        boolean isGuest = PermissionConstant.checkGuest(serviceContext);
        if (isGuest) {
            om.put("permission", false);
        }
/*
        try {
            resourceResponse.getWriter().println(writer);
        } catch (IOException e) {
            log.error(e.getMessage());
        }*/
    }

    public static List<String[]> toStringArray(List<DMDatasetVO> dats) {
        List<String[]> records = new ArrayList<String[]>();

        // adding header record
        //records.add(new String[] { "materialId", "dataType", "location", "fullFormula", "spaceGroup", "bandGap", "density", "nsites", "volume", "finalEnergyPerAtom", "finalEnergy", "formationEnergy", "reducedFormula", "unitCellFormula" });

        Iterator<DMDatasetVO> it = dats.iterator();
        while (it.hasNext()) {
            DMDatasetVO dat = it.next();
            records.add(new String[] {
                    String.valueOf(dat.getMaterialId()),
                    dat.getDataType(),
                    dat.getLocation(),
                    dat.getFullFormula(),
                    dat.getSpaceGroup(),
                    String.valueOf(dat.getBandGap()),
                    String.valueOf(dat.getDensity()),
                    String.valueOf(dat.getNsites()),
                    String.valueOf(dat.getVolume()),
                    String.valueOf(dat.getFinalEnergyPerAtom()),
                    String.valueOf(dat.getFinalEnergy()),
                    String.valueOf(dat.getFormationenergy()),
                    dat.getReducedFormula(),
                    String.valueOf(dat.getUnitCellFormula())
            });
        }
        return records;
    }

    /**
     * @Methods Name : getDistinctElementsList
     * @작성일 : 2017. 10. 13.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : 원소의 조합을 String 콤마 형태로 받아, 해당 조합으로 구성할 수 있는 모든 경우의 DB Dataset 가져오기
     */
    public static Map<String, Object> getDistinctElementsList(ServiceContext serviceContext, String elements)
            throws PortalException {

        SearchContext searchContext = SearchStaticInitalize.getSearchContext(Dataset.class);

        String[] searchArray = getCommaSplitMaterialsExplorerParameter(elements);

        List<DMDatasetVO> datasetList = new ArrayList<DMDatasetVO>();

        BooleanQuery mainQuery = null;
        BooleanQuery subQuery = null;
        int count = 0;
        Boolean result = true;

        // 엘리먼트들의 수 만큼 반복
        for (int k = 1; k <= searchArray.length; k++) {
            // 엘리먼트들의 모든 조합을 찾아서 List<String[]> 형태로 파싱
            List<String[]> list = getCombination(searchArray, k);

            // 조합의 수만큼 반복
            for (int i = 0; i < list.size(); i++) {
                // common query
                mainQuery = BooleanQueryFactoryUtil.create(searchContext);
                // 한 조합의 엘리먼트들에 대한 검색 쿼리 추가
                String[] array = list.get(i);
                for (String a : array) {

                    subQuery = BooleanQueryFactoryUtil.create(searchContext);
                    subQuery.addExactTerm("elements", a);
                    try {
                        mainQuery.add(subQuery, BooleanClauseOccur.MUST);
                    } catch (ParseException e) {
                        log.error(e.getMessage());
                    }
                }

                subQuery = BooleanQueryFactoryUtil.create(searchContext);
                subQuery.addExactTerm("elements_count", array.length);
                try {
                    mainQuery.add(subQuery, BooleanClauseOccur.MUST);
                } catch (ParseException e) {
                    log.error(e.getMessage());
                }

                Hits hits = null;
                try {
                    hits = DatasetServiceUtil.querySearchEngine(serviceContext, searchContext, mainQuery);
                } catch (SearchException | ParseException e) {
                    // TODO : Error Handling
                    log.error(e.getMessage());
                    throw e;
                }

                count = hits.getDocs().length;

                // 기본 원소는 최소 하나 이상의 데이터가 있어야 함.
                if (k == 1 && count == 0) {
                    result = false;
                    break;
                }

                for (int j = 0; j < count; j++) {
                    DMDatasetVO dataset = new DMDatasetVO();
                    dataset.setAll(hits.doc(j));
                    // 엘리먼트들의 수 만큼, 모든 조합의 검색 결과를 구함
                    datasetList.add(dataset);
                }
            }
        }

        Map<String, Object> map = new HashMap<String, Object>();

        map.put("datasetList", datasetList);
        map.put("result", result);

        return map;
    }

    /**
     * @Methods Name : getPredictionDataJsonMLPredictor
     * @작성일 : 2017. 8. 21.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : 예상 데이터 생성
     */
    public static void getPredictionDataJsonMLPredictor(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException {
        String poscarString = ParamUtil.getString(resourceRequest, "poscar");

        String portletName = PortletProps.get("mlPredictorName");

        String inputRealFileLocation = getAnalysisInputTempRealPath(portletName) + File.separator + PortletProps.get("poscarFileName");
        String outputWebTempFilePath = getAnalysisOutputTempRealPath(portletName);
        String outputFullPath = outputWebTempFilePath + File.separator + PortletProps.get("outputJsonName");

        MaterialFileUtils.writeFile(poscarString, inputRealFileLocation);

        String[] cmd = {getPythonCommand(), getAnalysisScriptPath(portletName), "\"" + getAnalysisPath(portletName) + "\"", "\"" + inputRealFileLocation + "\"", "\"" + outputWebTempFilePath + "\""};
        String[] arg = null;

        String inputRealFolderLocation = getAnalysisInputTempRealPath(portletName);
        //byCommonsExec(cmd, arg);
        runDocker(inputRealFolderLocation, outputWebTempFilePath, "ml_predictor");

        MaterialFileUtils.jsonToArrayFile(outputFullPath);

        // 생성된 JSON에 JSMOL 출력을 위한 POSCAR Resource URL 생성
        ResourceURL jsmolURL = resourceResponse.createResourceURL();
        jsmolURL.setResourceID("jsmolFileRender");
        jsmolURL.setParameter("condition", portletName);
        jsmolURL.setParameter("outputFileName", PortletProps.get("poscarFileName"));

        // 생성된 JSON 파일에 값 추가
        JsonObject addJsonObject = new JsonObject();
        addJsonObject.addProperty("jsmolURL", jsmolURL.toString());

        getWriteRealFileRootPath(resourceResponse, outputFullPath, addJsonObject);
    }

    private static int runDocker(String inputPath, String outputPath, String dockerImage) {

        int _errCode = 0;
        String _errorMessage = "";
        // TODO : what about docker is not installed or not specified properly
        String dockerCommand = "docker";
        String ret = null;
        /* TODO : extension */

        String finalInputPath = inputPath.replace("c:", "/c").replace("C:", "/c").replace("e:", "/e").replace("E:", "/e").replace("d:", "/d").replace("D:", "/d").replace("\\", "/");
        String finalOutputPath = outputPath.replace("c:", "/c").replace("C:", "/c").replace("e:", "/e").replace("E:", "/e").replace("d:", "/d").replace("D:", "/d").replace("\\", "/");
//		String dockerRun = dockerCommand + " --host tcp://192.168.99.100:2376 --tls --tlscacert=c:/Users/admin/.docker/machine/machines/default/ca.pem --tlscert=c:/Users/admin/.docker/machine/machines/default/cert.pem "
//				+ "--tlskey=c:/Users/admin/.docker/machine/machines/default/key.pem run --rm -v " + finalInputPath + ":/curate/input"
//				+ " -v " + finalOutputPath + ":/curate/output"
//				+ " --entrypoint /bin/bash"
//				+ " " + dockerImage + " /curate/curate.sh";
        String dockerRun = dockerCommand + " run --rm -v " + finalInputPath + ":/curate/input"
                + " -v " + finalOutputPath + ":/curate/output"
                + " --entrypoint /bin/bash"
                + " " + dockerImage + " /curate/curate.sh";
        log.debug("docker Command : " + dockerRun);

        for (int i = 0; i < 1; i++) {

            Process p = null;
            InputStream error = null;

            try {
                p = Runtime.getRuntime().exec(dockerRun);
                // p.waitFor(2, TimeUnit.MINUTES);
                p.waitFor();

                int pret = p.exitValue();
                error = p.getErrorStream();

                if ((pret != 0) && (error != null) && (error.available() > 0)) {

                    if (i + 1 == 1) {
                        BufferedReader br = new BufferedReader(new InputStreamReader(p.getErrorStream()));
                        String str = null;
                        while ((str = br.readLine()) != null) {
                            ret += str;
                        }
                        log.error(ret);
                        br.close();
                        error.close();
                        // return ret;
                        _errorMessage = ret;
                        _errCode = 101;
                        break;
                    } else {
                        error.close();
                        continue;
                    }
                }
                error.close();
                // return null;
            } catch (Exception e) {
                log.error("docker run error : " + i);
                if (i + 1 == 1) {
                    _errorMessage = Arrays.toString(e.getStackTrace());
                    //return ret;
                    _errCode = 101;
                } else {
                    continue;
                }
            } finally {
                p.destroy();
            }
        }

        if (_errCode != 0) {
            log.debug("error message : " + _errCode);
            return _errCode;
        } else {
            log.debug("no error message");
        }

        return 0;
    }

    /**
     * @Methods Name : getChangeDataType
     * @작성일 : 2018. 08. 23.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : 파라미터에 따른 리턴 데이터 타입 값 대응
     */
    public static Object getChangeDataType(int type, String point, Object num) {
        Object data = null;
        if (type == Sort.DOUBLE_TYPE && point == "ceil") {
            data = Math.ceil(GetterUtil.getDouble(num));
        } else if (type == Sort.DOUBLE_TYPE && point == "floor") {
            data = Math.floor(GetterUtil.getDouble(num));
        } else if (type == Sort.DOUBLE_TYPE) {
            data = GetterUtil.getDouble(num);
        } else if (type == Sort.INT_TYPE) {
            data = GetterUtil.getInteger(num);
        } else {
            try {
                throw new Exception("Invalid data type type : " + type + " point : " + point + " num : " + num);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    /**
     * @Methods Name : addSubRangeQuery
     * @작성일 : 2018. 8. 24.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : addNumericRangeTerm 쿼리 코드
     */
    public static BooleanQuery addSubRangeQuery(SearchContext searchContext, BooleanQuery mainQuery, String field, Class<?> t, Map<String, String> param, BooleanClauseOccur booleanClauseOccur) {
        BooleanQuery subQuery = BooleanQueryFactoryUtil.create(searchContext);
        if (t == Double.class) {
            subQuery.addNumericRangeTerm(field, Double.parseDouble(param.get("min")), Double.parseDouble(param.get("max")));
        } else if (t == Integer.class) {
            subQuery.addNumericRangeTerm(field, Integer.parseInt(param.get("min")), Integer.parseInt(param.get("max")));
        }
        try {
            mainQuery.add(subQuery, booleanClauseOccur);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return mainQuery;
    }

    /**
     * @Methods Name : addSubExactQuery
     * @작성일 : 2018. 8. 24.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : addSubExactQuery 쿼리 코드
     */
    public static BooleanQuery addSubExactQuery(SearchContext searchContext, BooleanQuery mainQuery, String field, Class<?> t, Object param, BooleanClauseOccur booleanClauseOccur) {
        BooleanQuery subQuery = BooleanQueryFactoryUtil.create(searchContext);
        if (t == Double.class) {
            subQuery.addExactTerm(field, (Double) param);
        } else if (t == Integer.class) {
            subQuery.addExactTerm(field, (Integer) param);
        } else if (t == String.class) {
            subQuery.addExactTerm(field, (String) param);
        }
        try {
            mainQuery.add(subQuery, booleanClauseOccur);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return mainQuery;
    }


    /**
     * @Methods Name : getDataTypeKeyList
     * @작성일 : 2018. 7. 19.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : 지정한 데이터 타입에서 숫자형 키를 가져온다.
     */
    public static JSONObject getDataTypeKeyList(String dataType) throws SystemException, PortalException {
        JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
        if (dataType == null || dataType == "") {
            jsonObject.put("searchKeyList", "");
        } else {
            log.debug("### DataTypes ::: " + dataType);
            long dataTypeId = Long.parseLong(dataType);

            // Get Numeric field in DataTypeSchema (Query parameters : dataTypeId)
            List<DataTypeSchema> schemaList = DataTypeSchemaLocalServiceUtil.getNumericField(dataTypeId, "number");

            JSONArray jsonArray = getSchemaToJsonArray(schemaList);

            jsonObject.put("searchKeyList", jsonArray);
        }

        jsonObject.put("searchAllKeyList", getDataTypeAllKeyList(dataType));
        return jsonObject;
    }

    /**
     * @Methods Name : getDataTypeAllKeyList
     * @작성일 : 2018. 7. 19.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : 지정한 데이터 타입에서 모든 키를 가져온다.
     */
    public static JSONArray getDataTypeAllKeyList(String dataTypes) throws SystemException, PortalException {

        List<DataTypeSchema> schemaList = DataTypeSchemaLocalServiceUtil.getList(Long.parseLong(dataTypes));

        JSONArray jsonArray = getSchemaToJsonArray(schemaList);

        return jsonArray;
    }

    /**
     * @Methods Name : getSchemaToJsonArray
     * @작성일 : 2018. 7. 19.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : DataTypeSchema 형을 JSONArray 형태로 바꾼다.
     */
    public static JSONArray getSchemaToJsonArray(List<DataTypeSchema> schemaList) {

        Collections.sort(schemaList, new Comparator<DataTypeSchema>() {
            @Override
            public int compare(DataTypeSchema o1, DataTypeSchema o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        });

        JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
        if (schemaList != null) {
            int len = schemaList.size();
            for (int i = 0; i < len; i++) {
                JSONObject json = JSONFactoryUtil.createJSONObject();
                json.put("dataTypeSchemaId", schemaList.get(i).getDataTypeSchemaId());
                json.put("title", schemaList.get(i).getTitle());
                json.put("variableType", schemaList.get(i).getVariableType());

                jsonArray.put(json);
            }
        }

        return jsonArray;
    }

    /**
     * @Methods Name : getHttpServletRequestParameter
     * @작성일 : 2018. 7. 20.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : HttpServletRequest 로 파라미터 받기
     */
    public static String getHttpServletRequestParameter(PortletRequest portletRequest, String param) {
        HttpServletRequest httpRequest = PortalUtil.getHttpServletRequest(portletRequest);
        httpRequest = PortalUtil.getOriginalServletRequest(httpRequest);
        return httpRequest.getParameter(param);
    }

    /**
     * @Methods Name : getCommaSplitMaterialsExplorerParameter
     * @작성일 : 2017. 7. 20.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : 쉼표가 포함된 문자열을 배열로 반환
     */
    public static String[] getCommaSplitMaterialsExplorerParameter(String param) {
        String[] arrayParam = param.split("\\s*,\\s*");

        return arrayParam;
    }

    /**
     * @Methods Name : isNullToString
     * @작성일 : 2017. 7. 20.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : Object가 Null인 경우 ""로 반환
     */
    public static String isNullToString(Object object) {
        String string = "";
        if (object != null) {
            string = object.toString().trim();
        }
        return string;
    }

    /**
     * @Methods Name : objectToLong
     * @작성일 : 2017. 7. 20.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : Object 형을 원하는 타입으로 치환
     */
    public static Long objectToLong(Object o) {
        String stringToConvert = String.valueOf(o);
        Long convertedLong = Long.parseLong(stringToConvert);
        return convertedLong;
    }

    /**
     * @Methods Name : getHyphenSplitMaterialsExplorerParameter
     * @작성일 : 2017. 7. 20.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : [숫자-숫자] 형태의 파라미터를 맵으로 분리
     */
    public static Map<String, String> getHyphenSplitMaterialsExplorerParameter(Object object) {

        String str = (String) object;

        try {
            if (!str.matches(".*-.*") && Validator.isBlank(str)) {
                throw new Exception("값 '" + str + "'이 올바르지 않습니다. 하이픈(-) 미포함");
            }
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        String[] arrayParam = str.split("-");

        Map<String, String> mapParam = new HashMap<String, String>();

        int i = 0;
        for (String key : new String[]{"min", "max"}) {

            try {
                if (arrayParam[i].matches("(^[0-9]*$)")) {
                    mapParam.put(key, arrayParam[i++]);
                } else {
                    throw new Exception("값 '" + arrayParam[i] + "'이 올바르지 않습니다. 숫자만 가능");
                }
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }

        return mapParam;
    }

    /**
     * @Methods Name : getParameterMap
     * @작성일 : 2017. 7. 20.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : 요청 파라미터를 Map<String, String[]>형으로 받은 후, 키 값을 오브젝트형으로 치환
     */
    public static Map<String, Object> getParameterMap(Map<String, String[]> pm) {
        Map<String, String> op = new HashMap<String, String>();

        for (String key : pm.keySet()) {
            String[] value = pm.get(key);
            if (value != null && value.length == 1) {
                op.put(key, StringUtils.join(value));
            } else if (value != null && value.length > 1) {
                op.put(key, StringUtils.join(value, ","));
            }
        }

        Map<String, Object> om = new HashMap<String, Object>();

        om.putAll(op);

        return om;
    }

    /**
     * @Methods Name : objectToIntString
     * @작성일 : 2017. 7. 20.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : 오브젝트형을 정수형 스트링으로 반환
     */
    public static String objectToIntString(Object obj) throws Exception {

        if (obj == null) {
            throw new NullPointerException();
        }

        String str = obj.toString();

        int num = 0;

        if (obj instanceof Double) {
            num = (int) Double.parseDouble(str);
        } else if (obj instanceof Integer) {
            num = Integer.parseInt(str);
        } else {
            throw new Exception("값 " + obj.toString() + "은 지원하지 않는 데이터 타입입니다.");
        }

        return String.valueOf(num);
    }

    /**
     * @Methods Name : getCrystalToolkitMaterialOutputModel
     * @작성일 : 2017. 7. 20.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : datasetId를 받아 dataset에 첨부된 파일을 임시 디렉토리로 이동
     */
    public static Map<String, Object> getCrystalToolkitMaterialOutputModel(UploadPortletRequest uploadPortletRequest) throws Exception {
        Long datasetId = ParamUtil.getLong(uploadPortletRequest, "datasetId");
        String condition = uploadPortletRequest.getParameter("condition");

        Map<String, Object> dm = new HashMap<String, Object>();

        ServiceContext serviceContext = ServiceContextFactory.getInstance(uploadPortletRequest);
        dm = getDatasetDescriptiveMetadata(datasetId, serviceContext);

        if (dm.get("errorMessage") == null) {

            String inputRealFileLocation = (String) dm.get("location");
            String inputMetaRealFileLocation = (String) (dm.get("metaLocation") + File.separator + "derived");
            String outputWebTempLocation = getAnalysisTempRealPath() + File.separator + condition;

            List<String> path = new ArrayList<String>();
            path.add(inputRealFileLocation);
            path.add(inputMetaRealFileLocation);

            List<String> fileName = new ArrayList<String>();
            fileName.add("POSCAR");
            fileName.add("CONTCAR");

            for (String eachPath : path) {
                for (String eachFileName : fileName) {
                    File structFile = new File(eachPath + File.separator + eachFileName);
                    if (structFile.exists()) {
                        log.debug("HIT ::: " + eachPath + File.separator + eachFileName);
                        // 임시 웹 /temp/datasetId 폴더로 복사 성공 시
                        if (MaterialFileUtils.multiFileCopy(eachPath, outputWebTempLocation)) {
                            dm.put("datasetId", datasetId);
                            dm.put("outputFileName", eachFileName);
                        } else {
                            throw new Exception("Failed to copy input file " + inputRealFileLocation + " to " + outputWebTempLocation + ".");
                        }
                    }

                }
            }

//            // 임시 웹 /temp/datasetId 폴더로 복사 성공 시
//            if (MaterialFileUtils.multiFileCopy(inputRealFileLocation, outputWebTempLocation)) {
//                dm.put("datasetId", datasetId);
//                dm.put("outputFileName", PortletProps.get("poscarFileName"));
//            } else {
//                throw new Exception("Failed to copy input file " + inputRealFileLocation + " to " + outputWebTempLocation + ".");
//            }
        }

        dm.put("beforeCondition", "material");

        return dm;
    }

    /**
     * @Methods Name : getExtractOutputModel
     * @작성일 : 2017. 7. 20.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : 파일을 받아 파이썬 스크립트로 구조 정보 추출
     */
    public static Map<String, Object> getCrystalToolkitExtractOutputModel(UploadPortletRequest uploadPortletRequest, String inputExtractFileParamName) throws PortalException, SystemException, IOException {
        String condition = uploadPortletRequest.getParameter("condition");

        // 업로드 파일을 File Class에 담기, 업로드 된 파일을 디스크에 강제로 기록 = true
        File uploadedFile = uploadPortletRequest.getFile(inputExtractFileParamName, true);
        // 업로드 파일명 담기
        String extractFileName = uploadPortletRequest.getFileName(inputExtractFileParamName);

        // 저장공간 확인
        if (new File("/").getFreeSpace() < uploadPortletRequest.getSize(inputExtractFileParamName)) {
            throw new IOException("저장 공간이 부족합니다 확인해주세요!");
        }

        // 최종 저장 파일 경로
        String finalFilePath = getAnalysisInputTempRealPath(condition) + File.separator + extractFileName;

        File finalSavefilePath = new File(finalFilePath);

        // 기존 임시 파일을 새 위치로 이동합니다.
        FileUtils.copyFile(uploadedFile, finalSavefilePath);

        // Extract는 첨부된 파일에서 메타데이터만 추출
        String[] cmd = {getPythonCommand(), getAnalysisScriptPath("crystal-toolkit"), condition, "\"" + finalFilePath + "\"", "\"" + getAnalysisOutputTempRealPath(condition) + "\""};
        String[] arg = null;

        // python 스크립트 실행
        Map<String, Object> dm = byCommonsExec(cmd, arg);

        dm.put("uploadedFileName", extractFileName);
        dm.put("beforeCondition", "extract");

        return dm;
    }

    /**
     * @throws Exception
     * @Methods Name : getSubstituteOutputModel
     * @작성일 : 2017. 7. 20.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : Supercell 및 Substitute 정보 추출
     */
    public static Map<String, Object> getCrystalToolkitSubstituteOutputModel(UploadPortletRequest uploadPortletRequest)
            throws Exception {
        String condition = uploadPortletRequest.getParameter("condition");
        String beforeCondition = MaterialUtils.defaultString(uploadPortletRequest.getParameter("beforeCondition"), condition);

        // Supercell
        String supercellData = uploadPortletRequest.getParameter("supercellData");
        String supercell = uploadPortletRequest.getParameter("supercell");
        // Substitute
        String substituteFlag = uploadPortletRequest.getParameter("substituteFlag"); // 필수
        String removeEelement = uploadPortletRequest.getParameter("removeEelement");
        String changeEelement = uploadPortletRequest.getParameter("changeEelement");
        String outputFileName = uploadPortletRequest.getParameter("outputFileName"); // 필수

        String inputRealFileLocation = null;

        // 이전 condition 이 material 인 경우는 입력 파일을 DB에서 조회
        if (beforeCondition.equals("material")) {
            Long datasetId = ParamUtil.getLong(uploadPortletRequest, "datasetId");

            Map<String, Object> dm = new HashMap<String, Object>();

            ServiceContext serviceContext = ServiceContextFactory.getInstance(uploadPortletRequest);
            dm = getDatasetDescriptiveMetadata(datasetId, serviceContext);

            String location = (String) dm.get("location");

            inputRealFileLocation = MaterialFileUtils.dirFileSearch(location, outputFileName);
            if (inputRealFileLocation == null) {
                // In case of "derived/CONTCAR"
                String metaLocation = (String) (dm.get("metaLocation") + File.separator + "derived");
                inputRealFileLocation = MaterialFileUtils.dirFileSearch(metaLocation, outputFileName);
                if (inputRealFileLocation == null) {
                    throw new Exception("Cannot find input file.");
                }
            }
        } else {
            // webapps/temp 디렉토리 하위 폴더에서 파일 검색
            inputRealFileLocation = MaterialFileUtils.dirFileSearch(getAnalysisTempRealPath() + File.separator + beforeCondition, outputFileName);
        }

        String[] cmd = {getPythonCommand(), getAnalysisScriptPath("crystal-toolkit"), condition, "\"" + inputRealFileLocation + "\"", "\"" + getAnalysisOutputTempRealPath(condition) + "\""};
        String[] arg = null;

        if (condition.equals("supercell")) {
            arg = new String[]{supercellData};
        } else if (condition.equals("substitution")) {
            if (substituteFlag.equals("change")) {
                arg = changeEelement.split(",");
            } else if (substituteFlag.equals("remove")) {
                arg = new String[]{removeEelement};
            }
        }

        // python 스크립트 실행
        Map<String, Object> dm = byCommonsExec(cmd, arg);

        // 이전 condition에 현재 condition 설정
        dm.put("beforeCondition", condition);
        dm.put("supercell", supercellData.replaceAll("\\[", "").replaceAll("\\]", ""));

        return dm;
    }

    /**
     * @Methods Name : pythonFileDownload
     * @작성일 : 2017. 7. 20.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 :
     */
    public static void pythonFileDownload(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException {

        // Ajax request 버그로인해서 PortalUtil 사용
        HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(resourceRequest);
        String condition = PortalUtil.getOriginalServletRequest(httpReq).getParameter("condition");
        String beforeCondition = PortalUtil.getOriginalServletRequest(httpReq).getParameter("beforeCondition");
        String chooseFileFormat = PortalUtil.getOriginalServletRequest(httpReq).getParameter("chooseFileFormat");
        String outputFileName = PortalUtil.getOriginalServletRequest(httpReq).getParameter("outputFileName");

        // webapps/temp 디렉토리 하위 폴더에서 파일 검색
        String inputRealFileLocation = MaterialFileUtils.dirFileSearch(getAnalysisTempRealPath() + File.separator + beforeCondition, outputFileName);

        String[] cmd = {getPythonCommand(), getAnalysisScriptPath("crystal-toolkit"), condition, "\"" + inputRealFileLocation + "\"", "\"" + getAnalysisOutputTempRealPath(condition) + "\""};
        String[] arg = new String[]{chooseFileFormat};

        // python 스크립트 실행
        Map<String, Object> dm = byCommonsExec(cmd, arg);

        String newOutputFileName = (String) dm.get("outputFileName");

        String downloadFilePath = getAnalysisOutputTempRealPath(condition) + File.separator + newOutputFileName;

        MaterialFileUtils.outputStream(newOutputFileName, downloadFilePath, resourceResponse);
    }

    /**
     * @Methods Name : getTemporaryPoscar
     * @작성일 : 2017. 12. 05.
     * @작성자 : jaesung
     * @변경이력 :
     * @Method 설명 :
     */
    public static String getTemporaryPoscar(String beforeCondition, String outputFileName) throws IOException {
        String inputRealFileLocation = null;
        if (outputFileName.equals("POSCAR")) {
            inputRealFileLocation = MaterialFileUtils.dirFileSearch(getAnalysisTempRealPath() + File.separator + beforeCondition, outputFileName);

            int lastIndex = inputRealFileLocation.indexOf("POSCAR");
            String path = inputRealFileLocation.substring(0, lastIndex);

            Date today = new Date();
            SimpleDateFormat prefix = new SimpleDateFormat("yyyyMMddhhmmss");
            String prefix_name = prefix.format(today);

            String poscar = "POSCAR_".concat(prefix_name);
            String realPath = path.concat(poscar);
            MaterialFileUtils.fileCopy(inputRealFileLocation, realPath);

            return realPath;

        } else {
            inputRealFileLocation = MaterialFileUtils.dirFileSearch(getAnalysisTempRealPath() + File.separator + beforeCondition, outputFileName);
            return inputRealFileLocation;
        }
    }

	/**
	 * @Methods Name : createComputation
	 * @작성일 : 2018. 11. 27.
	 * @작성자 : leegyuseong
	 * @변경이력 :
	 * @Method 설명 :
	 */
	public static void createComputation(String beforeCondition, String outputFileName, Map<String, Integer>paramMap) throws IOException {
		String inputRealFileLocation = null;
		String outString = null;

		inputRealFileLocation = getAnalysisTempRealPath() + File.separator + beforeCondition + File.separator + "computation.conf";
		log.debug("inputRealFileLocation  : " + inputRealFileLocation );
		outString = "[property]\nkptest=1\ncutoff=1\n"
			+"relax="+paramMap.get("relax")+"\n"
			+"band="+paramMap.get("band")+"\n"
			+"dos="+paramMap.get("dos")+"\n"
			+"effm="+paramMap.get("effm")+"\n"
			+"diel="+paramMap.get("diel")+"\n\n"
			+"[kptest]\nenergy_conv = 10\npressure_conv = 10\nmax_KPL = 10\n\n"
			+"[cutoff]\nenergy_conv = 10\npressure_conv = 10\nmax_ECUT = 200\nenergy_interval = 5";

		MaterialFileUtils.writeFile(outString,inputRealFileLocation);

	}


    /**
     * @Methods Name : jsmolFileOutputStream
     * @작성일 : 2017. 7. 20.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : jsmol 파일 렌더링
     */
    public static void jsmolFileOutputStream(String condition, long datasetId, String outputFileName,
                                             ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

        String filePath = null;

        if (condition.equals("material")) {
            Dataset dataset = null;
            try {
                ServiceContext serviceContext = ServiceContextFactory.getInstance(resourceRequest);
                dataset = DatasetServiceUtil.getDataset(datasetId, serviceContext);
            } catch (PortalException e) {
                // if a dataset with the primary key could not be found
                log.error(e.getMessage());
            } catch (SystemException e) {
                // if a system exception occurred
                log.error(e.getMessage());
            }

            String inputRealFileLocation = dataset.getLocation();
            String inputMetaRealFileLocation = dataset.getMetalocation() + File.separator + "derived";

            List<String> path = new ArrayList<String>();
            path.add(inputRealFileLocation);
            path.add(inputMetaRealFileLocation);

            for (String eachPath : path) {
                File structFile = new File(eachPath + File.separator + outputFileName);
                if (structFile.exists()) {
                    filePath = eachPath + File.separator + outputFileName;
                }
            }

            //filePath = dataset.getLocation() + File.separator + outputFileName;
        } else if (condition.equals(PortletProps.get("mlPredictorName"))) {
            filePath = getAnalysisInputTempRealPath(condition) + File.separator + outputFileName;    // ML Predictor은 input으로 받음
        } else {
            filePath = getAnalysisOutputTempRealPath(condition) + File.separator + outputFileName;
        }

        try {
            MaterialFileUtils.outputStream(outputFileName, filePath, resourceResponse);
        } catch (FileNotFoundException e) {
            // File Not Found
            log.error(e.getMessage());
        } catch (IOException e) {
            // IO Exception
            log.error(e.getMessage());
        }
    }

    /**
     * @Methods Name : byCommonsExec
     * @작성일 : 2017. 7. 20.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : commond 명령 실행
     */
    public static Map<String, Object> byCommonsExec(String[] defaultCommand, String[] addArgument) throws IOException {

        DefaultExecutor executor = new DefaultExecutor();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PumpStreamHandler streamHandler = new PumpStreamHandler(outputStream);

        executor.setStreamHandler(streamHandler);

        log.debug(">>>" + defaultCommand);
        CommandLine cmdLine = CommandLine.parse(defaultCommand[0]);

        // 기본 커멘드
        for (int i = 1, n = defaultCommand.length; i < n; i++) {
            cmdLine.addArgument(defaultCommand[i]);
        }
        // 추가 아귀먼트가 비어있지 않으면
        if (!objectEmptyCheck(addArgument)) {
            for (int i = 0, n = addArgument.length; i < n; i++) {
                cmdLine.addArgument(addArgument[i]);
            }
        }

        try {
            log.debug("##### byCommonsExec : " + cmdLine);
            executor.execute(cmdLine);
        } catch (ExecuteException ee) {
            log.error(ee.getMessage());
        }

        log.debug("##### byCommonsExec : " + outputStream.toString());

        Map<String, Object> dm = jsonToMap(outputStream.toString());

        // 특정 시간이 지난 Temp 파일 삭제
        MaterialFileUtils.deleteFilesOlderThan24Hours(new File(getAnalysisTempRealPath()), -24);

        return (dm);
    }

    /**
     * @Methods Name : jsonToMap
     * @작성일 : 2017. 7. 20.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : JSON 타입을 Map 형태로 파싱
     */
    public static Map<String, Object> jsonToMap(String jsonString) {
        String jsonData = "{ descriptiveMetadata : " + jsonString + "}";

        JsonParser jsonParser = new JsonParser();
        JsonObject json = null;
        try {
            json = (JsonObject) jsonParser.parse(jsonData);
        } catch (JsonSyntaxException e) {
            json = (JsonObject) jsonParser.parse("{ descriptiveMetadata : {'error': 'It is not a json type.'}}");
        }

        Gson gson = new Gson();

        Type mapType = new TypeToken<Map<String, Map<String, Object>>>() {
        }.getType();

        Map<String, Map<String, Object>> map = gson.fromJson(json, mapType);

        Map<String, Object> descriptiveMetadata = map.get("descriptiveMetadata");

        return descriptiveMetadata;
    }

    /**
     * @Methods Name : getDatasetDescriptiveMetadata
     * @작성일 : 2017. 7. 20.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : datasetId를 받아 dataset의 서술형 메타데이터와 파일 위치 받기
     */
    public static Map<String, Object> getDatasetDescriptiveMetadata(long datasetId, ServiceContext serviceContext) {
        Dataset dataset = null;

        Map<String, Object> dm = new HashMap<String, Object>();

        try {
            dataset = DatasetServiceUtil.getDataset(datasetId, serviceContext);
            dm = jsonToMap(dataset.getDescriptiveMetadata());
            dm.put("location", dataset.getLocation());
            dm.put("metaLocation", dataset.getMetalocation());
            dm.put("stringDescriptiveMetadata", dataset.getDescriptiveMetadata());
        } catch (PortalException e) {
            // if a dataset with the primary key could not be found
            log.error(e.getMessage());
            dm.put("errorMessage", e.getMessage());
        } catch (SystemException e) {
            // if a system exception occurred
            log.error(e.getMessage());
            dm.put("errorMessage", e.getMessage());
        }
        return dm;
    }

    /**
     * @Methods Name : getPythonCommand
     * @작성일 : 2017. 7. 20.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : 파이썬 실행기 이름 프로퍼티에서 가져오기
     */
    protected static String getPythonCommand() {
        String pythonCommand = null;
        try {
            pythonCommand = PortletProps.get("pythonCommand");
        } catch (Exception e) {
            log.error(e.getMessage());
        }

        return pythonCommand;
    }

    /**
     * @Methods Name : getAnalysisInputTempRealPath
     * @작성일 : 2017. 7. 20.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : Analysis 임시 생성 파일 생성 위치 Get
     */
    public static String getAnalysisInputTempRealPath(String condition) {
        String dirPath = getAnalysisTempRealPath() + File.separator + condition + File.separator + "input";
        MaterialFileUtils.mkdirs(dirPath);
        return dirPath;
    }

    /**
     * @Methods Name : getAnalysisOutputTempRealPath
     * @작성일 : 2017. 7. 20.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : Analysis 임시 출력 파일 변환 위치 Get
     */
    public static String getAnalysisOutputTempRealPath(String condition) {
        String dirPath = getAnalysisTempRealPath() + File.separator + condition + File.separator + "output";
        MaterialFileUtils.mkdirs(dirPath);
        return dirPath;
    }

    /**
     * @Methods Name : getAnalysisOutputTempRealPath
     * @작성일 : 2017. 7. 20.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : Analysis 임시 출력 파일 변환 위치 Get
     */
    public static String getAnalysisMonitoringTempRealPath(String condition) {
        String dateTime = CommonUtil.getDateTime();
        String dirPath = getAnalysisTempRealPath() + File.separator + condition + File.separator + dateTime;
        MaterialFileUtils.mkdirs(dirPath);
        return dirPath;
    }

    /**
     * @Methods Name : getAnalysisTempRealPath
     * @작성일 : 2017. 7. 20.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : Analysis 임시 파일 변환 위치 Get
     */
    public static String getAnalysisTempRealPath() {
		String OS = System.getProperty("os.name").toLowerCase();

		String _root = PortletProps.get("analysisLocation");

		if (StringUtils.isBlank(_root)) {
			if (OS.indexOf("win") >= 0) {
				_root = "c:/Users/leegyuseong/root";
			} else {
				_root = "/root";
			}
		}

        //String dirPath = CommonStaticInitalize.getWebappsRealPath() + File.separator + "temp" + File.separator + CommonStaticInitalize.getUserId();
        String dirPath = _root + File.separator + "analysis" +  File.separator + "temp" + File.separator + CommonStaticInitalize.getUserId();

        MaterialFileUtils.mkdirs(dirPath);
        return dirPath;
    }

    /**
     * @Methods Name : getReadFileJson
     * @작성일 : 2017. 11. 20.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : 파일을 읽어서 JSON 으로 반환
     */

    public static JsonArray getReadFileJson(String fileFullPath, JsonObject addJsonObject) {
        FileReader file = null;
        try {
            file = new FileReader(fileFullPath);
        } catch (FileNotFoundException e) {
            log.error(e.getMessage());
        }
        BufferedReader br = new BufferedReader(file);
        JsonParser parser = new JsonParser();
        JsonArray array = parser.parse(br).getAsJsonArray();

        if (addJsonObject != null) {
            array.add(addJsonObject);
        }

        return array;
    }


    /**
     * @Methods Name : getWriteRealFileRootPath
     * @작성일 : 2017. 7. 20.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : 파일을 읽어서 JSON 형태로 변환 후 응답
     */
    public static void getWriteRealFileRootPath(MimeResponse response, String fileFullPath, JsonObject addJsonObject) {
        JsonArray array = getReadFileJson(fileFullPath, addJsonObject);

        if (addJsonObject != null) {
            array.add(addJsonObject);
        }

        try {
            response.getWriter().println(array);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    }

    /**
     * @Methods Name : getAnalysisScriptPath
     * @작성일 : 2017. 7. 20.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : Python 스크립트 위치 Get
     */
    public static String getAnalysisScriptPath(String script) {
        return "\"" + getAnalysisPath(script) + File.separator + script + ".py" + "\"";
    }

    /**
     * @Methods Name : getAnalysisPath
     * @작성일 : 2017. 7. 20.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : Python 공통 위치 Get
     */
    public static String getAnalysisPath(String script) {
        return CommonStaticInitalize.getWebappsRealPath() + File.separator + "WEB-INF" + File.separator + "python" + File.separator + script;
    }

    /**
     * @Methods Name : objectEmptyCheck
     * @작성일 : 2017. 7. 20.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : Object type 변수가 비어있는지 체크
     */
    public static Boolean objectEmptyCheck(Object obj) {
        if (obj instanceof String)
            return obj == null || "".equals(obj.toString().trim());
        else if (obj instanceof List)
            return obj == null || ((List) obj).isEmpty();
        else if (obj instanceof Map)
            return obj == null || ((Map) obj).isEmpty();
        else if (obj instanceof Object[])
            return obj == null || Array.getLength(obj) == 0;
        else
            return obj == null;
    }

    /**
     * @Methods Name : getUserId
     * @작성일 : 2017. 7. 20.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : 사용자 ID Get
     */
    public static long getUserId(ClientDataRequest request) {
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        long userId = themeDisplay.getUserId();
        return userId;
    }

    /**
     * @param input (ex, {"Ca", "C", "O", "N})
     * @param k     (ex, 3)
     * @Method Name : getCombination
     * @작성일 : 2017. 7. 31
     * @작성자 : jaesung
     * @Method 설명 : 선택한 Element의 K개 조합을 만듦
     */
    public static List<String[]> getCombination(String[] input, int k) {
        List<String[]> subsets = new ArrayList<>();

        int[] s = new int[k];

        if (k <= input.length) {
            // first index sequence: 0, 1, 2, ...
            for (int i = 0; (s[i] = i) < k - 1; i++)
                ;
            subsets.add(getSubset(input, s));
            for (; ; ) {
                int i;
                // find position of item that can be incremented
                for (i = k - 1; i >= 0 && s[i] == input.length - k + i; i--)
                    ;
                if (i < 0) {
                    break;
                }
                s[i]++; // increment this item
                for (++i; i < k; i++) { // fill up remaining items
                    s[i] = s[i - 1] + 1;
                }
                subsets.add(getSubset(input, s));
            }
        }
        return subsets;
    }

    /**
     * @Methods Name : splitD
     * @작성일 : 2017. 11. 27.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : 사용자 ID Get
     */
    public static Double[] splitD(String str) {
        String[] strArray = str.split(",");
        Double[] doubles = new Double[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            doubles[i] = Double.parseDouble(strArray[i]);
        }
        return doubles;
    }

    /**
     * @Method Name : getSubset
     * @작성일 : 2017. 7. 31
     * @작성자 : jaesung
     * @Method 설명 : input 배열의 subset을 구하는 함수
     */
    public static String[] getSubset(String[] input, int[] subset) {
        String[] result = new String[subset.length];
        for (int i = 0; i < subset.length; i++)
            result[i] = input[subset[i]];
        return result;
    }

    public static String defaultString(String str, String defaultString) {
        if (StringUtils.isEmpty(str)) {
            str = defaultString;
        }
        return str;
    }
}
