package com.sdr.ext.material.visualization.portlet;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.sdr.ext.material.util.CommonUtil;
import com.sdr.ext.material.util.MaterialUtils;
import com.sdr.ext.material.visualization.action.VParam;
import com.sdr.metadata.model.DataType;
import com.sdr.metadata.model.DataTypeClp;
import com.sdr.metadata.service.DataTypeServiceUtil;
import com.sdr.metadata.service.DatasetLocalServiceUtil;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import javax.portlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@Controller
@RequestMapping("VIEW")
public class VisualizationChartController {

    private static Log _log = LogFactoryUtil.getLog(VisualizationChartController.class);

    @RenderMapping
    public String render(RenderRequest renderRequest, RenderResponse renderResponse, Model model) throws PortalException, SystemException {
        _log.debug("### Chart default render");

        // Get preferences data
        HashMap<String, String> vpMap = getVPParam(renderRequest);

        // Get DataType
        ServiceContext serviceContext = ServiceContextFactory.getInstance(renderRequest);
        List<DataType> typeList = new ArrayList<>();

        String prefDatatypes = vpMap.get("prefDatatypes");

        // Preferences 데이터타입이 비어있으면 전체 데이터 타입 가져오기
        if (Validator.isBlank(prefDatatypes)) {
            typeList = DataTypeServiceUtil.getDataTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS, serviceContext);
        } else {
            String[] array = vpMap.get("prefDatatypes").split(",");
            for (int i = 0; i < array.length; ++i) {
                DataType datatype = new DataTypeClp();
                String title = array[i].split("\\|")[0];
                long dataTypeId = Long.parseLong(array[i].split("\\|")[1]);
                datatype.setDataTypeId(dataTypeId);
                datatype.setTitle(title);
                typeList.add(i, datatype);
            }
        }

        model.addAttribute("vpMap", vpMap);
        model.addAttribute("typeList", typeList);

        return "analysis-tools/visualization/visualization-chart-view";
    }

    @ResourceMapping(value = "keyList")
    public void getKeyList(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortalException, IOException, SystemException {
        String param = "data-types";
        String dataTypes = ParamUtil.getString(resourceRequest, param);

        // Configuration 포틀릿(또는 타 포틀릿)에서 호출하기 위한 코드 추가
        if (dataTypes.equals("") || dataTypes == null) {
            dataTypes = MaterialUtils.getHttpServletRequestParameter(resourceRequest, param);
        }

        JSONObject jsonObject = MaterialUtils.getDataTypeKeyList(dataTypes);

        resourceResponse.setContentType("text/html;charset=utf-8");
        PrintWriter out = resourceResponse.getWriter();
        out.print(jsonObject.toString());
    }


    @ResourceMapping(value = "makechart")
    public void chartDataJson(ResourceRequest resourceRequest, ResourceResponse response, Model model) throws IOException, PortalException, SystemException, ParseException {

        String dataTypes = ParamUtil.getString(resourceRequest, "data-types");
        String xAxis = ParamUtil.getString(resourceRequest, "x-axis");
        String yAxis = ParamUtil.getString(resourceRequest, "y-axis");
        String zAxis = ParamUtil.getString(resourceRequest, "z-axis");
        String keywords = ParamUtil.getString(resourceRequest, "keywords");
        String maxLength = ParamUtil.getString(resourceRequest, "max-length", "1000");
        String categorys = ParamUtil.getString(resourceRequest, "pref-categorys");

        JSONArray categoryJSONArray = JSONFactoryUtil.createJSONArray(categorys);

        if (Validator.isBlank(dataTypes)) {
            // Do Nothing
            response.getWriter().println("Error");
        } else {
            _log.debug("### make chart resource URL :::" + xAxis + " " + yAxis + " " + zAxis + " " + dataTypes + " " + keywords + " " + maxLength);

            // Get preferences data
            HashMap<String, String> vpMap = getVPParam(resourceRequest);

            String prefConditionUse = vpMap.get("prefConditionUse");
            String prefCondition = vpMap.get("prefCondition");

            String searchKeywords = keywords;

            // Configuration 컨디션 설정이 true 이고 검색 조건이 있을 시에 검색 키워드에 붙인다.
            if (prefConditionUse.equals("true") && !Validator.isBlank(prefCondition)) {
                searchKeywords = keywords.trim() + " " + prefCondition.trim();
            }

            JSONArray jsonArray;
            JSONArray result = JSONFactoryUtil.createJSONArray();

            if (categoryJSONArray.length() > 0) {
                for (int i = 0; i < categoryJSONArray.length(); ++i) {
                    String condition = categoryJSONArray.getJSONObject(i).getString("condition");
                    if (!Validator.isBlank(condition)) {
                        String searchCondition = searchKeywords + " " + condition;
                        jsonArray = DatasetLocalServiceUtil.searchForChart(resourceRequest, response, Long.parseLong(dataTypes), xAxis, yAxis, zAxis, searchCondition, Integer.parseInt(maxLength));
                        result.put(jsonArray);
                    }
                }
            } else {
                jsonArray = DatasetLocalServiceUtil.searchForChart(resourceRequest, response, Long.parseLong(dataTypes), xAxis, yAxis, zAxis, searchKeywords, Integer.parseInt(maxLength));
                result.put(jsonArray);
            }

            if (result == null) { // Parse Exception
                response.getWriter().println("LuceneError");
            } else {
                //_log.debug("### JSON Result ::: " + result);
                response.getWriter().println(result);
            }
        }
    }

    @ResourceMapping(value = "typeList")
    public void getTypeList(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortalException, IOException, SystemException {
        // Get DataType
        ServiceContext serviceContext = ServiceContextFactory.getInstance(resourceRequest);
        List<DataType> typeList = DataTypeServiceUtil.getDataTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS, serviceContext);

        org.json.simple.JSONArray jsonArray = new org.json.simple.JSONArray();
        if (typeList != null) {
            int len = typeList.size();
            for (int i = 0; i < len; i++) {
                JSONObject json = JSONFactoryUtil.createJSONObject();
                json.put("dataTypeId", typeList.get(i).getDataTypeId());
                json.put("title", typeList.get(i).getTitle());
                json.put("required", typeList.get(i).getCurateRequired());
                jsonArray.add(json);
            }
        }

        resourceResponse.setContentType("text/html;charset=utf-8");
        PrintWriter out = resourceResponse.getWriter();
        out.print(jsonArray.toString());
    }

    private HashMap<String, String> getVPParam(PortletRequest portletRequest) throws SystemException, PortalException {
        // Get preferences data
        PortletPreferences preferences = CommonUtil.getPreference(portletRequest, null);

        String prefLeftTabUse = preferences.getValue(VParam.SETTINGS_LEFTTAB_USE, "true");
        String prefTitleUse = preferences.getValue(VParam.SETTINGS_TITLE_USE, "true");
        String prefTitle = preferences.getValue(VParam.SETTINGS_TITLE, "3D Visualization Chart");
        String prefAdvancedSearchUse = preferences.getValue(VParam.SETTINGS_ADVANCEDSEARCH_USE, "true");
        String prefDatatypeUse = preferences.getValue(VParam.SETTINGS_DATATYPE_USE, "true");
        String prefDatatypes = preferences.getValue(VParam.SETTINGS_DATATYPE, null);
        String prefConditionUse = preferences.getValue(VParam.SETTINGS_CONDITION_USE, "true");
        String prefCondition = preferences.getValue(VParam.SETTINGS_CONDITION, null);
        String prefCategorys = preferences.getValue(VParam.SETTINGS_CATEGORY, null);
        ;
        String prefZAxisUse = preferences.getValue(VParam.SETTINGS_ZAXIS_USE, "true");
        String prefMaxLengthUse = preferences.getValue(VParam.SETTINGS_MAXLENGTH_USE, "true");
        String prefMaxLengthDefault = preferences.getValue(VParam.SETTINGS_MAXLENGTH_DEFAULT, "1000");

        HashMap<String, String> map = new HashMap();

        map.put("prefLeftTabUse", prefLeftTabUse);
        map.put("prefTitleUse", prefTitleUse);
        map.put("prefTitle", prefTitle);
        map.put("prefAdvancedSearchUse", prefAdvancedSearchUse);
        map.put("prefDatatypeUse", prefDatatypeUse);
        map.put("prefDatatypes", prefDatatypes);
        map.put("prefConditionUse", prefConditionUse);
        map.put("prefCondition", prefCondition);
        map.put("prefCategorys", prefCategorys);
        map.put("prefZAxisUse", prefZAxisUse);
        map.put("prefMaxLengthUse", prefMaxLengthUse);
        map.put("prefMaxLengthDefault", prefMaxLengthDefault);

        return map;
    }

    /*
	private List<String> mkFullKeyList(ServiceContext serviceContext, String dataType)
			throws SystemException, SearchException, PortalException {

		SearchContext searchContext = new SearchContext();
		searchContext.setLike(false);
		searchContext.setAndSearch(false);
		searchContext.setCompanyId(serviceContext.getCompanyId());

		BooleanQuery query = BooleanQueryFactoryUtil.create(searchContext);
		query.addExactTerm("dataTypeId", dataType);

		Hits hits = null;
		try {
			hits = DatasetServiceUtil.querySearchEngine(serviceContext, searchContext, query);
		} catch (SearchException | ParseException e) {
			// TODO : Error Handling
			_log.error(e.getMessage());
			throw e;
		}

		List<String> keyList = new ArrayList<String>();

		for (int i = 0; i < hits.getDocs().length; i++){

			Document doc = hits.doc(i);
			keyList.addAll(doc.getFields().keySet());
		}

		Iterator<String> iterator = keyList.iterator();

		while (iterator.hasNext()) {

			String s = iterator.next();

			if(s.contains("_sortable")
					||s.equals("FileNum")
					|| s.equals("classPK")
					|| s.equals("companyId")
					|| s.equals("dataTypeId")
					|| s.equals("portletId")
					|| s.equals("entryClassName")
					|| s.equals("entryClassPK")
					|| s.equals("groupId")
					|| s.equals("scopeGroupId")
					|| s.equals("stagingGroup")
					|| s.equals("uid")
					|| s.equals("ratings")
					|| s.equals("assetTagIds")
					|| s.equals("assetTagNames")
					|| s.equals("location")
					|| s.equals("modified")
					|| s.equals("priority")
					|| s.equals("viewCount")
					|| s.equals("visible")
					){
				iterator.remove();
			}
		}

		keyList = new ArrayList<String>(new HashSet<String>(keyList));
		Collections.sort(keyList);

		return keyList;
	}
	*/
}
