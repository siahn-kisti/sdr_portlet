package com.sdr.curation.workflow.datatype;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Role;
import com.liferay.portal.service.RoleServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.sdr.metadata.model.DataType;
import com.sdr.metadata.model.Dataset;
import com.sdr.metadata.service.DataTypeLocalServiceUtil;
import com.sdr.metadata.service.DatasetLocalServiceUtil;
import com.sdr.workflow.DatasetWorkflow;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import javax.portlet.PortletSession;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/* Let;s avoid Access Control for the Workflow */


/**
 * The type Datatype workflow.
 */

@Controller
@RequestMapping("VIEW")
public class DatatypeWorkflow {
    private static Log _log = LogFactoryUtil.getLog(DatatypeWorkflow.class);

    /**
     * Datatype workflow main string.
     *
     * @param renderRequest  the render request
     * @param renderResponse the render response
     * @param model          the model
     * @return the string
     * @throws PortalException the portal exception
     * @throws SystemException the system exception
     */
    @RenderMapping
    public String datatypeWorkflowMain(RenderRequest renderRequest, RenderResponse renderResponse, Model model) throws PortalException, SystemException {

        String workflowId = PortalUUIDUtil.generate();
        String depth = ParamUtil.getString(renderRequest, "depth");

        model.addAttribute("workflowId", workflowId);
        if (depth.equals("dataset")) {
            dataTypeDatasetWorkflowList(renderRequest, renderResponse, model);
            return "workflow/datatypeWorkflow/list_workflow_datatype_dataset";
        } else {
            dataTypeWorkflowList(renderRequest, renderResponse, model);
            return "workflow/datatypeWorkflow/view";
        }
    }

    /**
     * Datatype workflow list
     *
     * @param renderRequest
     * @param renderResponse
     * @param model
     * @return model
     * @throws SystemException
     * @throws PortalException
     */
    private Model dataTypeWorkflowList(RenderRequest renderRequest, RenderResponse renderResponse, Model model) throws SystemException, PortalException {
        _log.debug("### DataType Workflow Main Renderer");

        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        List<Role> userRoles = RoleServiceUtil.getUserRoles(themeDisplay.getUserId());

        SearchContainer<Dataset> searchContainer = new SearchContainer<Dataset>(renderRequest, renderResponse.createRenderURL(), null, "there are no collections");

        if (ParamUtil.getInteger(renderRequest, "delta") == 0) {
            searchContainer.setDelta(5);
        } else {
            searchContainer.setDelta(searchContainer.getDelta());
        }

        List<DataType> dataTypeList = new ArrayList<DataType>();
        List<Map<String, Object>> wfCollList = new ArrayList<Map<String, Object>>();

        dataTypeList.addAll(DataTypeLocalServiceUtil.getList());

        for (DataType dataType : dataTypeList) {
            long dataTypeId = dataType.getDataTypeId();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("dataTypeId", dataTypeId);
            map.put("title", dataType.getTitle());
            map.put("draft", DatasetLocalServiceUtil.getCountByD_S(dataTypeId, WorkflowConstants.STATUS_DRAFT));
            map.put("scheduled", DatasetLocalServiceUtil.getCountByD_S(dataTypeId, WorkflowConstants.STATUS_SCHEDULED));

            int pendingCnt = DatasetLocalServiceUtil.getCountByD_S(dataTypeId, WorkflowConstants.STATUS_PENDING);
            map.put("pending", pendingCnt);
            map.put("approved", DatasetLocalServiceUtil.getCountByD_S(dataTypeId, WorkflowConstants.STATUS_APPROVED));
            map.put("denied", DatasetLocalServiceUtil.getCountByD_S(dataTypeId, WorkflowConstants.STATUS_DENIED));
            map.put("inComplete", DatasetLocalServiceUtil.getCountByD_S(dataTypeId, WorkflowConstants.STATUS_INCOMPLETE));

            int datasetCnt = DatasetLocalServiceUtil.getCountByDataTypeId(dataTypeId);
            if (datasetCnt != 0) {
                map.put("datasetCnt", datasetCnt);
                wfCollList.add(map);
            }
        }
        searchContainer.setTotal(wfCollList.size());
        int end = searchContainer.getEnd() > wfCollList.size() ? wfCollList.size() : searchContainer.getEnd();

        model.addAttribute("tabs", "dataType");
        model.addAttribute("delta", searchContainer.getDelta());
        model.addAttribute("total", wfCollList.size());
        model.addAttribute("searchContainer", searchContainer);
        model.addAttribute("wfCollList", wfCollList.subList(searchContainer.getStart(), end));

        return model;
    }

    /**
     * DataType dataset workflow list
     *
     * @param renderRequest
     * @param renderResponse
     * @param model
     * @return model
     * @throws SystemException
     * @throws PortalException
     */
    private Model dataTypeDatasetWorkflowList(RenderRequest renderRequest, RenderResponse renderResponse, Model model) throws SystemException, PortalException {

        long dataTypeId = ParamUtil.getLong(renderRequest, "dataTypeId");

        _log.debug(" ### datatype dataset Workflow List ::: dataTypeId : " + dataTypeId);

        String keyword = ParamUtil.getString(renderRequest, "keywords", "");
        String statusFilter = ParamUtil.getString(renderRequest, "statusFilter");

        String orderByCol = ParamUtil.getString(renderRequest, "orderByCol", "title");
        String orderByType = ParamUtil.getString(renderRequest, "orderByType", "asc");

        SearchContainer<Dataset> searchContainer = new SearchContainer<Dataset>(renderRequest, renderResponse.createRenderURL(), null, "there are no dataset");

        if (orderByType == "" || orderByType.equals("asc")) {
            orderByType = "asc";
        } else {
            orderByType = "desc";
        }

        int delta = ParamUtil.getInteger(renderRequest, "delta");

        if (delta == 0) {
            searchContainer.setDelta(10);
        } else {
            searchContainer.setDelta(delta);
        }

        DynamicQuery dynamicQuery = DatasetLocalServiceUtil.dynamicQuery();
        Criterion criterion = null;

        criterion = RestrictionsFactoryUtil.eq("dataTypeId", dataTypeId);

        if (!keyword.isEmpty()) {
            RestrictionsFactoryUtil.like("title", "%" + keyword + "%");
            RestrictionsFactoryUtil.eq("datasetId", keyword);
            criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.or(RestrictionsFactoryUtil.like("title", "%" + keyword + "%"), RestrictionsFactoryUtil.eq("datasetId", keyword)));
        }
        if (!statusFilter.isEmpty()) {
            criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("status", WorkflowConstants.getLabelStatus(statusFilter)));
        }

        searchContainer.setTotal((int) (long) DatasetLocalServiceUtil.dynamicQuery(dynamicQuery.setProjection(ProjectionFactoryUtil.rowCount())).get(0));

        dynamicQuery = DatasetLocalServiceUtil.dynamicQuery();
        dynamicQuery.add(criterion);

        if (orderByType.equalsIgnoreCase("desc")) {
            dynamicQuery.addOrder(OrderFactoryUtil.desc(orderByCol));
        } else {
            dynamicQuery.addOrder(OrderFactoryUtil.asc(orderByCol));
        }

        dynamicQuery.setLimit(searchContainer.getStart(), searchContainer.getEnd());

        List<Dataset> datasetList = DatasetLocalServiceUtil.dynamicQuery(dynamicQuery);

        model.addAttribute("draftCnt", DatasetLocalServiceUtil.getCountByD_S(dataTypeId, WorkflowConstants.STATUS_DRAFT));
        model.addAttribute("scheduledCnt", DatasetLocalServiceUtil.getCountByD_S(dataTypeId, WorkflowConstants.STATUS_SCHEDULED));
        model.addAttribute("pendingCnt", DatasetLocalServiceUtil.getCountByD_S(dataTypeId, WorkflowConstants.STATUS_PENDING));
        model.addAttribute("approvedCnt", DatasetLocalServiceUtil.getCountByD_S(dataTypeId, WorkflowConstants.STATUS_APPROVED));
        model.addAttribute("deniedCnt", DatasetLocalServiceUtil.getCountByD_S(dataTypeId, WorkflowConstants.STATUS_DENIED));
        model.addAttribute("inCompleteCnt", DatasetLocalServiceUtil.getCountByD_S(dataTypeId, WorkflowConstants.STATUS_INCOMPLETE));

        Map<String, String> paramMap = new HashMap<String, String>();
        paramMap.put("depth", ParamUtil.getString(renderRequest, "depth"));
        paramMap.put("dataTypeId", Long.toString(dataTypeId));
        paramMap.put("delta", Integer.toString(searchContainer.getDelta()));
        paramMap.put("statusFilter", statusFilter);
        paramMap.put("orderByCol", orderByCol);
        paramMap.put("orderByType", orderByType);

        PortletURL iteratorURL = renderResponse.createRenderURL();
        Iterator<Map.Entry<String, String>> entries = paramMap.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, String> entry = entries.next();
            iteratorURL.setParameter(entry.getKey(), entry.getValue());
        }

        model.addAttribute("iteratorURL", iteratorURL);
        model.addAttribute("dataTypeId", dataTypeId);
        model.addAttribute("dataTypeTitle", DataTypeLocalServiceUtil.getDataType(dataTypeId).getTitle());
        model.addAttribute("depth", ParamUtil.getString(renderRequest, "depth"));
        model.addAttribute("delta", searchContainer.getDelta());
        model.addAttribute("datasetList", datasetList);
        model.addAttribute("statusFilter", statusFilter);
        model.addAttribute("searchContainer", searchContainer);

        return model;
    }

    /**
     * Data type workflow.
     *
     * @param request  the request
     * @param response the response
     * @throws PortalException the portal exception
     * @throws SystemException the system exception
     * @throws IOException     the io exception
     */
    @ResourceMapping(value = "dataTypeWorkflow")
    public void dataTypeWorkflow(ResourceRequest request, ResourceResponse response) throws IOException {

        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        long dataTypeId = GetterUtil.getLong(request.getParameter("dataTypeId"));
        String flag = request.getParameter("flag");

        JSONObject result = new JSONObject();

        try {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(Dataset.class.getName(), request);
            String workflowId = GetterUtil.getString(request.getParameter("workflowId"));

            _log.debug("### workflowId :" + workflowId);

            PortletSession portSession = request.getPortletSession();

            _log.debug("DataType Workflow : " + flag + " : " + dataTypeId);

            List<Dataset> list = new ArrayList<Dataset>();

            if (flag.equals("resubmit") || flag.contains("drop")) {
                list = DatasetLocalServiceUtil.getDatasetsByDataType(dataTypeId);
            } else {
                list = DatasetLocalServiceUtil.getListByD_S(dataTypeId, WorkflowConstants.STATUS_PENDING);
            }

            SessionMessages.add(request, flag + "_success");
        } catch (PortalException | SystemException e) {
            SessionErrors.add(request, flag + "_error");
            SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
        } finally {
            response.getWriter().print(result);
        }

    }

    /**
     * Datatype dataset workflow.
     *
     * @param request  the request
     * @param response the response
     * @throws PortalException the portal exception
     * @throws SystemException the system exception
     * @throws IOException     the io exception
     */
    @ResourceMapping(value = "datatypeDatasetWorkflow")
    public void datatypeDatasetWorkflow(ResourceRequest request, ResourceResponse response) throws PortalException, SystemException, IOException {
		_log.debug(" ##### datatypeDatasetWorkflow #####");

        ServiceContext serviceContext = ServiceContextFactory.getInstance(Dataset.class.getName(), request);
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

        String flag = ParamUtil.getString(request, "flag");
        String dataTypeDatasetIdList = ParamUtil.getString(request, "datasetIdList");
        String status = ParamUtil.getString(request, "status");
        long dataTypeId = ParamUtil.getLong(request, "dataTypeId");

        JSONObject result = new JSONObject();
        PortletSession portSession = request.getPortletSession();
        String workflowId = GetterUtil.getString(request.getParameter("workflowId"));


        if (flag != null && flag != "") {
            _log.debug("DataType Dataset Workflow : " + flag + " : " + dataTypeId);

            List<Dataset> datasetlist = new ArrayList<Dataset>();

            if (!dataTypeDatasetIdList.isEmpty()) {

                _log.debug("::: datatype dataset Workflow ::: dataset Id List = " + dataTypeDatasetIdList);

                String[] datasets = dataTypeDatasetIdList.split(",");

                _log.debug("### flag: " + flag + " ### dataset count: " + datasets.length);

                for (int i = 0; i < datasets.length; i++) {

                    Dataset dataset = DatasetLocalServiceUtil.getDataset(Long.parseLong(datasets[i]));

                    if ((flag.equals("approved") || flag.equals("reject")) && dataset.getStatus() != WorkflowConstants.STATUS_PENDING) {
                        continue;
                    }
                    datasetlist.add(dataset);
                }
            } else {
                if (dataTypeDatasetIdList.isEmpty() && !status.isEmpty()) {
                    _log.debug("::: datatype dataset Workflow ::: dataset stataus = " + status);
                    datasetlist = DatasetLocalServiceUtil.getListByD_S(dataTypeId, WorkflowConstants.getLabelStatus(status));
                }
            }

            try {
                System.out.println(flag);
                _log.info("status flag: " + flag);
                //TODO curationIdList 임시 null
                DatasetWorkflow.statusUpdate(datasetlist, flag, themeDisplay, serviceContext, null, null, null);
                SessionMessages.add(request, flag + "_success");
            } catch (Exception e) {
                SessionErrors.add(request, flag + "_error");
                SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
            } finally {
                response.getWriter().print(result);
            }

        }

    }

    /**
     * Progress.
     *
     * @param workflowId the workflow id
     * @param request    the request
     * @param response   the response
     * @throws IOException the io exception
     */
    @ResourceMapping(value = "progress")
    public void progress(@RequestParam String workflowId, ResourceRequest request, ResourceResponse response) throws IOException {

        JSONObject result = new JSONObject();
        try {
            PortletSession portSession = request.getPortletSession();
            Map map = (Map) portSession.getAttribute(workflowId);
            result.put("map", map);

        } catch (Exception e) {
            result.put("error", true);
            SessionErrors.add(request, "error");
            _log.error(e.getMessage());
        } finally {
            response.getWriter().print(result);
        }
    }

}
