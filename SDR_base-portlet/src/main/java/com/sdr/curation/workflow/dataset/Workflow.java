package com.sdr.curation.workflow.dataset;


import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionList;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.sdr.common.util.SearchStaticInitalize;
import com.sdr.curation.manage.CurationManager;
import com.sdr.metadata.model.Collection;
import com.sdr.metadata.model.DataType;
import com.sdr.metadata.model.Dataset;
import com.sdr.metadata.model.PpLogic;
import com.sdr.metadata.service.CollectionLocalServiceUtil;
import com.sdr.metadata.service.DataTypeServiceUtil;
import com.sdr.metadata.service.DatasetLocalServiceUtil;
import com.sdr.metadata.service.PpLogicServiceUtil;
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
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * The type Workflow.
 */
@Controller
@RequestMapping("VIEW")
public class Workflow {

	private static Log _log = LogFactoryUtil.getLog(Workflow.class);

	/**
	 * Workflow main string.
	 *
	 * @param renderRequest  the render request
	 * @param renderResponse the render response
	 * @param model          the model
	 * @return the string
	 * @throws PortalException the portal exception
	 * @throws SystemException the system exception
	 */
	@RenderMapping
	public String workflowMain(RenderRequest renderRequest, RenderResponse renderResponse, Model model) throws PortalException, SystemException {

		_log.debug("### Workflow Main Renderer");

		workflowCore(renderRequest, renderResponse, model);

		return "workflow/view";
	}

	/**
	 * Workflow core model
	 *
	 * @param renderRequest
	 * @param renderResponse
	 * @param model
	 * @return model
	 * @throws SystemException
	 * @throws PortalException
	 */
	private Model workflowCore(RenderRequest renderRequest, RenderResponse renderResponse, Model model) throws SystemException, PortalException {
		_log.debug(" ### workflowCore Administrator ###");
		String workflowId = PortalUUIDUtil.generate();
		String depth = ParamUtil.getString(renderRequest, "depth");

		String tabList = ParamUtil.getString(renderRequest, "tabList");

        String defaultTab = "My Data";
        if (tabList.isEmpty()) {
            if (renderRequest.isUserInRole("administrator")) {
                tabList = "Administrator,Reviewer,My Data";
                defaultTab = "Administrator";
            } else if (renderRequest.isUserInRole("site-content-reviewer")) {
                tabList = "Reviewer,My Data";
                defaultTab = "Reviewer";
            } else {
                tabList = "My Data";
            }
        }

		String tabs = ParamUtil.getString(renderRequest, "tabs", defaultTab);

		if (depth.equals("dataset")) {
			datasetWorkflowList(tabs, renderRequest, renderResponse, model);
		} else {
			collectionWorkflowList(tabs, renderRequest, renderResponse, model);
		}

		model.addAttribute("workflowId", workflowId);
		model.addAttribute("tabList", tabList);

		return model;
	}

	/**
	 * Collection workflow list
	 *
	 * @param tabs
	 * @param renderRequest
	 * @param renderResponse
	 * @param model
	 * @return model
	 * @throws PortalException
	 * @throws SystemException
	 */
	private Model collectionWorkflowList(String tabs, RenderRequest renderRequest, RenderResponse renderResponse, Model model) throws PortalException, SystemException {

		// Do not have Access Control for Workflow

		ServiceContext serviceContext = ServiceContextFactory.getInstance(Dataset.class.getName(), renderRequest);
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		SearchContainer<Dataset> searchContainer = new SearchContainer<Dataset>(renderRequest, renderResponse.createRenderURL(), null, "there are no collections");

		if (ParamUtil.getInteger(renderRequest, "delta") == 0) {
			searchContainer.setDelta(5);
		} else {
			searchContainer.setDelta(searchContainer.getDelta());
		}

		List<Collection> collectionList = new ArrayList<Collection>();
		List<Map<String, Object>> wfCollList = new ArrayList<Map<String, Object>>();

		long scopeGroupId = 0;
		long ownerUserId = 0;

		if (tabs.equals("Administrator")) {
			collectionList.addAll(CollectionLocalServiceUtil.getList());
		} else if (tabs.equals("Reviewer")) {
			//TODO group 아이디가 개인 페이지 ID로 박힘 확인필요
			scopeGroupId = serviceContext.getScopeGroupId();

            collectionList.addAll(CollectionLocalServiceUtil.getList(scopeGroupId));
        } else if (tabs.equals("My Data")) {
            ownerUserId = themeDisplay.getUserId();
            collectionList.addAll(CollectionLocalServiceUtil.getListByDatasetUserId(ownerUserId));
        }

		Collections.sort(collectionList);
		_log.debug("Me: " + ownerUserId + " collection " + collectionList);

		for (Collection collection : collectionList) {
			long collectionId = collection.getCollectionId();
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("collectionId", collectionId);
			map.put("title", collection.getTitle());
			map.put("skipCurate", collection.getSkipCurate());
			map.put("draft", DatasetLocalServiceUtil.getCount(scopeGroupId, collectionId, ownerUserId, WorkflowConstants.STATUS_DRAFT));
			map.put("scheduled", DatasetLocalServiceUtil.getCount(scopeGroupId, collectionId, ownerUserId, WorkflowConstants.STATUS_SCHEDULED));

			int pendingCnt = DatasetLocalServiceUtil.getCount(scopeGroupId, collectionId, ownerUserId, WorkflowConstants.STATUS_PENDING);
			map.put("pending", pendingCnt);
			map.put("approved", DatasetLocalServiceUtil.getCount(scopeGroupId, collectionId, ownerUserId, WorkflowConstants.STATUS_APPROVED));
			map.put("denied", DatasetLocalServiceUtil.getCount(scopeGroupId, collectionId, ownerUserId, WorkflowConstants.STATUS_DENIED));
			map.put("inComplete", DatasetLocalServiceUtil.getCount(scopeGroupId, collectionId, ownerUserId, WorkflowConstants.STATUS_INCOMPLETE));

            int datasetCnt = DatasetLocalServiceUtil.getCount(collectionId);
            //if (((tabs.equals("Administrator") || tabs.equals("My Data")) && datasetCnt != 0) || (tabs.equals("Reviewer") && pendingCnt != 0)) {
                map.put("datasetCnt", datasetCnt);
                wfCollList.add(map);
            //}

		}

		int end = searchContainer.getEnd() > wfCollList.size() ? wfCollList.size() : searchContainer.getEnd();

		model.addAttribute("tabs", tabs);
		model.addAttribute("delta", searchContainer.getDelta());
		model.addAttribute("total", wfCollList.size());
		model.addAttribute("searchContainer", searchContainer);
		model.addAttribute("wfCollList", wfCollList.subList(searchContainer.getStart(), end));

		return model;
	}


	/**
	 * Dataset workflow list
	 *
	 * @param tabs
	 * @param renderRequest
	 * @param renderResponse
	 * @param model
	 * @return model
	 * @throws NumberFormatException
	 * @throws PortalException
	 * @throws SystemException
	 */

	private Model datasetWorkflowList(String tabs, RenderRequest renderRequest, RenderResponse renderResponse, Model model) throws NumberFormatException, PortalException, SystemException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(Dataset.class.getName(), renderRequest);

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long collectionId = ParamUtil.getLong(renderRequest, "collectionId");

		_log.debug(" ### dataset Workflow List ::: colectionId : " + collectionId);

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

		long scopeGroupId = 0;
		long ownerUserId = 0;


		Criterion criterion = null;

		criterion = RestrictionsFactoryUtil.eq("collectionId", collectionId);
		//criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.ne("status", WorkflowConstants.STATUS_INACTIVE));

		if (tabs.equals("Reviewer")) {
			scopeGroupId = serviceContext.getScopeGroupId();

			criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("groupId", scopeGroupId));
			criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("status", WorkflowConstants.STATUS_PENDING));

        } else if (tabs.equals("My Data")) {
            ownerUserId = themeDisplay.getUserId();

			criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("userId", ownerUserId));
		}
		if (!keyword.isEmpty()) {
			try {
				Long.parseLong(keyword);
				criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.or(RestrictionsFactoryUtil.like("title", "%" + keyword + "%"), RestrictionsFactoryUtil.eq("datasetId", Long.parseLong(keyword))));
			} catch (NumberFormatException e) {
				criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.like("title", "%" + keyword + "%"));
			}
		}
		if (!statusFilter.isEmpty()) {
			criterion = RestrictionsFactoryUtil.and(criterion, RestrictionsFactoryUtil.eq("status", WorkflowConstants.getLabelStatus(statusFilter)));
		}


		// Count total first
		DynamicQuery dynamicQuery = DatasetLocalServiceUtil.dynamicQuery();

		ProjectionList projectionList = ProjectionFactoryUtil.projectionList();
		projectionList.add(ProjectionFactoryUtil.rowCount(), "_count");
		dynamicQuery.setProjection(projectionList);

		dynamicQuery.add(criterion);

		List<Long> row = DatasetLocalServiceUtil.dynamicQuery(dynamicQuery);
		searchContainer.setTotal((int) (long) row.get(0));


		// query limited set
		DynamicQuery dynamicQuery2 = DatasetLocalServiceUtil.dynamicQuery();
		dynamicQuery2.add(criterion);

		if (orderByType.equalsIgnoreCase("desc")) {
			dynamicQuery2.addOrder(OrderFactoryUtil.desc(orderByCol));
		} else {
			dynamicQuery2.addOrder(OrderFactoryUtil.asc(orderByCol));
		}

		dynamicQuery2.setLimit(searchContainer.getStart(), searchContainer.getEnd());

		List<Dataset> datasetList = DatasetLocalServiceUtil.dynamicQuery(dynamicQuery2);

		model.addAttribute("draftCnt", DatasetLocalServiceUtil.getCount(scopeGroupId, collectionId, ownerUserId, WorkflowConstants.STATUS_DRAFT));
		model.addAttribute("scheduledCnt", DatasetLocalServiceUtil.getCount(scopeGroupId, collectionId, ownerUserId, WorkflowConstants.STATUS_SCHEDULED));
		model.addAttribute("pendingCnt", DatasetLocalServiceUtil.getCount(scopeGroupId, collectionId, ownerUserId, WorkflowConstants.STATUS_PENDING));
		model.addAttribute("approvedCnt", DatasetLocalServiceUtil.getCount(scopeGroupId, collectionId, ownerUserId, WorkflowConstants.STATUS_APPROVED));
		model.addAttribute("deniedCnt", DatasetLocalServiceUtil.getCount(scopeGroupId, collectionId, ownerUserId, WorkflowConstants.STATUS_DENIED));
		model.addAttribute("inCompleteCnt", DatasetLocalServiceUtil.getCount(scopeGroupId, collectionId, ownerUserId, WorkflowConstants.STATUS_INCOMPLETE));

		_log.debug(" ### list : " + collectionId);

		Map<String, String> paramMap = new HashMap<String, String>();
		paramMap.put("tabs", tabs);
		paramMap.put("depth", ParamUtil.getString(renderRequest, "depth"));
		paramMap.put("collectionId", Long.toString(collectionId));
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
		model.addAttribute("collectionId", collectionId);
		model.addAttribute("collectionTitle", CollectionLocalServiceUtil.getCollection(collectionId).getTitle());
		model.addAttribute("tabs", tabs);
		model.addAttribute("depth", ParamUtil.getString(renderRequest, "depth"));
		model.addAttribute("datasetList", datasetList);
		model.addAttribute("orderByCol", orderByCol);
		model.addAttribute("orderByType", orderByType);
		model.addAttribute("statusFilter", statusFilter);
		model.addAttribute("searchContainer", searchContainer);

		return model;
	}

	/**
	 * Collection workflow.
	 *
	 * @param request  the request
	 * @param response the response
	 * @throws PortalException the portal exception
	 * @throws SystemException the system exception
	 * @throws IOException     the io exception
	 */
	@ResourceMapping(value = "collectionWorkflow")
	public void collectionWorkflow(ResourceRequest request, ResourceResponse response) throws IOException {
		_log.debug(" ### collectionWorkflow ###");

		// newCurationId 셋팅
		String newCurationId = request.getParameter("curationId");
		List<Long> curationIdList = new ArrayList<Long>();
		if(newCurationId != null && "".equals(newCurationId)){
			curationIdList.add(Long.parseLong(newCurationId));
		}
		_log.debug("new CurationId : " + newCurationId);

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		long scopeGroupId = themeDisplay.getScopeGroupId();
		long userId = themeDisplay.getUserId();
		long collectionId = GetterUtil.getLong(request.getParameter("collectionId"));
		String tabs = GetterUtil.getString(request.getParameter("tabs"));
		String flag = request.getParameter("flag");

		JSONObject result = new JSONObject();

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Dataset.class.getName(), request);
			String workflowId = GetterUtil.getString(request.getParameter("workflowId"));

			_log.debug("### workflowId :" + workflowId);


			PortletSession portSession = request.getPortletSession();

			_log.debug("Collection Workflow : " + flag + " ::: " + collectionId);

            List<Dataset> list = new ArrayList<Dataset>();
            if (flag.equals("skipCurate")) {
                Collection collection = CollectionLocalServiceUtil.getCollection(collectionId);
                boolean skipCurate = collection.getSkipCurate();
                if (skipCurate == true) {
                    collection.setSkipCurate(false);
                } else {
                    collection.setSkipCurate(true);
                }
                CollectionLocalServiceUtil.updateCollection(collection);
            } else if (flag.equals("reindexCollection")) {
                _log.debug("reindex collection only");
                CollectionLocalServiceUtil.reindexAllCollections();
            } else if (flag.equals("dropCollection")) {
                _log.debug("drop collection");
                CollectionLocalServiceUtil.delete(collectionId, serviceContext);
            } else {
                if (flag.equals("reindex")) {
                    list = DatasetLocalServiceUtil.getList(collectionId);
                } else if (flag.equals("resubmit") || flag.contains("drop")) {
                    if (tabs.equals("Administrator")) {
                        list = DatasetLocalServiceUtil.getList(collectionId);
                    } else if (tabs.equals("My Data")) {
                        list = DatasetLocalServiceUtil.getListByU_C_S(userId, collectionId, WorkflowConstants.STATUS_DRAFT);
                    }
                } else {
                    if (tabs.equals("Administrator")) {
                        list = DatasetLocalServiceUtil.getList(collectionId, WorkflowConstants.STATUS_PENDING);
                    } else if (tabs.equals("Reviewer")) {
                        list = DatasetLocalServiceUtil.getList(scopeGroupId, collectionId, WorkflowConstants.STATUS_PENDING);
                    } else if (tabs.equals("My Data")) {
                        list = DatasetLocalServiceUtil.getList(userId, collectionId, WorkflowConstants.STATUS_PENDING);
                    }
                }
                themeDisplay.getUserId();
                DatasetWorkflow.statusUpdate(list, flag, themeDisplay, serviceContext, portSession, workflowId, curationIdList);
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
	 * Dataset workflow.
	 *
	 * @param request  the request
	 * @param response the response
	 * @throws PortalException the portal exception
	 * @throws SystemException the system exception
	 * @throws IOException     the io exception
	 */
	@ResourceMapping(value = "datasetWorkflow")
	public void datasetWorkflow(ResourceRequest request, ResourceResponse response) throws PortalException, SystemException, IOException {
		_log.debug(" ### datasetWorkflow ###");

		// newCurationId 셋팅
		String newCurationId = request.getParameter("curationId");
		List<Long> curationIdList = new ArrayList<Long>();
		if(newCurationId != null && "".equals(newCurationId)){
			curationIdList.add(Long.parseLong(newCurationId));
		}
		_log.debug(" ### datasetWorkflow ### newCurationId : " + newCurationId);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(Dataset.class.getName(), request);
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		String flag = ParamUtil.getString(request, "flag");
		flag = flag.toLowerCase();
		String datasetIdList = ParamUtil.getString(request, "datasetIdList");
		String status = ParamUtil.getString(request, "status");

		JSONObject result = new JSONObject();
		PortletSession portSession = request.getPortletSession();
		String workflowId = GetterUtil.getString(request.getParameter("workflowId"));

		if (flag != null && flag != "") {

			_log.debug("::: dataset Workflow ::: status = " + flag);

			List<Dataset> datasetlist = new ArrayList<Dataset>();

			if (!datasetIdList.isEmpty()) {
				_log.debug("::: dataset Workflow ::: dataset Id List = " + datasetIdList);

				String[] datasets = datasetIdList.split(",");

				for (int i = 0; i < datasets.length; i++) {

					Dataset dataset = DatasetLocalServiceUtil.getDataset(Long.parseLong(datasets[i]));

                    if (flag.equals("resubmit") || flag.contains("drop")) {
//                        if (!request.isUserInRole("administrator") && dataset.getStatus() != WorkflowConstants.STATUS_DRAFT) {
//                            continue;
//                        }
                    } else {
                        if (dataset.getStatus() != WorkflowConstants.STATUS_PENDING) {
                            continue;
                        }
                    }
                    datasetlist.add(dataset);
                }
            } else {
                if (datasetIdList.isEmpty() && !status.isEmpty()) {
                    _log.debug("::: dataset Workflow ::: dataset stataus = " + status);

					String tabs = ParamUtil.getString(request, "tabs");
					long collectionId = ParamUtil.getLong(request, "collectionId");
					long userId = themeDisplay.getUserId();
					long scopeGroupId = themeDisplay.getScopeGroupId();

                    if (flag.equals("resubmit") || flag.contains("drop")) {
                        if (tabs.equals("Administrator")) {
                            datasetlist = DatasetLocalServiceUtil.getList(collectionId, WorkflowConstants.getLabelStatus(status));
                        } else if (tabs.equals("My Data")) {
                            datasetlist = DatasetLocalServiceUtil.getListByU_C_S(userId, collectionId, WorkflowConstants.getLabelStatus(status));
                        }
                    } else {
                        if (tabs.equals("Administrator")) {
                            datasetlist = DatasetLocalServiceUtil.getList(collectionId, WorkflowConstants.getLabelStatus(status));
                        } else if (tabs.equals("Reviewer")) {
                            datasetlist = DatasetLocalServiceUtil.getList(scopeGroupId, collectionId, WorkflowConstants.getLabelStatus(status));
                        } else if (tabs.equals("My Data")) {
                            datasetlist = DatasetLocalServiceUtil.getList(userId, collectionId, WorkflowConstants.getLabelStatus(status));
                        }
                    }

				}
			}

			try {
				DatasetWorkflow.statusUpdate(datasetlist, flag, themeDisplay, serviceContext, portSession, workflowId, curationIdList);
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


	/**
	 * reSubmitPopup
	 *
	 *	DataManagement Dataset 목록 화면 CustCurate Curation List 목록 reSubmitPopup
	 *
	 * @param keyword
	 * @param ppId
	 * @param dataTypeName
	 * @param dataTypeId
	 * @param curationIdList
	 * @param popupFlag
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	@RenderMapping(params = "action=reSubmitPopup")
	public String reSubmitPopup(@RequestParam(value = "keyword", required = false) String keyword, @RequestParam(value = "ppId", required = false) String ppId,
								@RequestParam(value = "dataTypeName", required = false) String dataTypeName,
								@RequestParam(value = "dataTypeId", required = false) String dataTypeId,
								@RequestParam(value = "curationIdList", required = false) String curationIdList,
								@RequestParam(value = "popupFlag", required = false) String popupFlag,
								RenderRequest request, RenderResponse response, Model model) throws SystemException, PortalException {
		_log.debug("### reSubmitPopup ### keyword : " + keyword + " : dataTypeName : " + dataTypeName + " : dataTypeId : " + dataTypeId + " : curationIdList : " + curationIdList + " : ppId : " + ppId);
		_log.debug(" ==================================> popupFlag : " + popupFlag);

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(com.liferay.portal.kernel.util.WebKeys.THEME_DISPLAY);

		new SearchStaticInitalize(request);
		SearchContext searchContext = SearchStaticInitalize.getSearchContext(CurationManager.class);

		PortletURL iteratorURL = response.createRenderURL();
		iteratorURL.setParameter("action", "reSubmitPopup");
		iteratorURL.setParameter("keyword", ParamUtil.getString(request, "keyword"));
		iteratorURL.setParameter("dataTypeId", ParamUtil.getString(request, "dataTypeId"));
		iteratorURL.setParameter("popupFlag", ParamUtil.getString(request, "popupFlag"));

		SearchContainer<PpLogic> searchContainer = new SearchContainer<PpLogic>(request, null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchStaticInitalize.getCur(), SearchStaticInitalize.getDelta(), iteratorURL, null, "검색된 데이터가 없습니다.");

		searchContext.setStart(searchContainer.getStart());
		searchContext.setEnd(searchContainer.getEnd());

		ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
		int count;
		List<PpLogic> list;

		if (dataTypeId != null && !"".equals(dataTypeId)) {
			_log.debug("======= dataTypeId true =======");
			count = PpLogicServiceUtil.getCount(keyword, Long.parseLong(dataTypeId), popupFlag);
			list = PpLogicServiceUtil.getList(searchContainer.getStart(), searchContainer.getEnd(), keyword, Long.parseLong(dataTypeId), popupFlag);
		} else {
			_log.debug("======= dataTypeId false =======");
			count = PpLogicServiceUtil.getCount(keyword);
			list = PpLogicServiceUtil.getList(searchContainer.getStart(), searchContainer.getEnd(), keyword);
		}

		// dataType DufaultPpLogicId 정보 조회
		if (dataTypeId != null && !"".equals(dataTypeId)) {
			_log.debug("DufaultPpLogicId 정보 조회");
			DataType dataType = DataTypeServiceUtil.getDataType(Integer.parseInt(dataTypeId), serviceContext);
			PpLogic ppLogic = PpLogicServiceUtil.getPpLogic(dataType.getDefaultPpLogicId());
			model.addAttribute("ppLogic", ppLogic);
			_log.debug("DufaultPpLogicId 정보 조회 : " + ppLogic.toString());
		}

		List<DataType> dataTypeList = DataTypeServiceUtil.getList(serviceContext);
		model.addAttribute("dataTypeList", dataTypeList);

		searchContainer.setTotal(count);
		searchContainer.setResults(list);

		model.addAttribute("keyword", keyword);
		model.addAttribute("ppId", ppId);
		model.addAttribute("dataTypeId", dataTypeId);
		model.addAttribute("popupFlag", popupFlag);
		model.addAttribute("searchContainer", searchContainer);

		return "workflow/reSubmitPopup";
	}


}
