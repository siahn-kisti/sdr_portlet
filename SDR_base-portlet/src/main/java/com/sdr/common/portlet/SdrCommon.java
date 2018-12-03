package com.sdr.common.portlet;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.GroupServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.asset.model.AssetTag;
import com.liferay.portlet.asset.service.AssetTagServiceUtil;
import com.sdr.ac.CollectionModelPermission;
import com.sdr.ac.PermissionConstant;
import com.sdr.common.model.CollectionVo;
import com.sdr.common.util.CommonUtil;
import com.sdr.common.util.ErrorHandler;
import com.sdr.common.util.SearchStaticInitalize;
import com.sdr.curation.manage.CurationManager;
import com.sdr.file.FileService;
import com.sdr.metadata.datatype.DataTypeManagement;
import com.sdr.metadata.model.Collection;
import com.sdr.metadata.model.Collection_User;
import com.sdr.metadata.model.DataType;
import com.sdr.metadata.model.DataTypeSchema;
import com.sdr.metadata.model.DataView;
import com.sdr.metadata.model.Dataset;
import com.sdr.metadata.model.PpLogic;
import com.sdr.metadata.model.SdrUsers;
import com.sdr.metadata.model.SdrUsersClp;
import com.sdr.metadata.service.CollectionLocalServiceUtil;
import com.sdr.metadata.service.CollectionServiceUtil;
import com.sdr.metadata.service.Collection_UserLocalServiceUtil;
import com.sdr.metadata.service.DataTypeLocalServiceUtil;
import com.sdr.metadata.service.DataTypeSchemaServiceUtil;
import com.sdr.metadata.service.DataTypeServiceUtil;
import com.sdr.metadata.service.DataViewServiceUtil;
import com.sdr.metadata.service.DatasetLocalServiceUtil;
import com.sdr.metadata.service.DatasetServiceUtil;
import com.sdr.metadata.service.PpLogicServiceUtil;
import com.sdr.metadata.service.SdrUsersLocalServiceUtil;
import com.sdr.metadata.service.SdrUsersServiceUtil;
import com.sdr.metadata.util.WebKeys;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ResourceURL;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Portlet implementation class SdrCommonPortlet
 */
@Controller
@RequestMapping("VIEW")
public class SdrCommon {

    private static Log _log = LogFactoryUtil.getLog(SdrCommon.class);
    private static final String _temp_folder_name = SdrCommon.class.getName();

    /**
     * Render string.
     *
     * @param request  the request
     * @param response the response
     * @param model    the model
     * @return the string
     */
    @RenderMapping
    public String render(RenderRequest request, RenderResponse response, Model model) {
        _log.debug("### SdrCommonPortlet render");
        return "sdrcommon/view";
    }


	//-----------------------------------------------------------------
	// Popup
	//-----------------------------------------------------------------

    /**
     * Collection popup string.
     *
     * @param request  the request
     * @param response the response
     * @param model    the model
     * @return the string
     */
    @RenderMapping(params = "action=collectionPopup")
    public String collectionPopup(@RequestParam(value = "keyword", required = false) String keyword,
                                  RenderRequest request, RenderResponse response, Model model) throws SystemException, PortalException {
        //_log.debug("### SdrCommonPortlet collectionPopup");

        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(com.liferay.portal.kernel.util.WebKeys.THEME_DISPLAY);
        long scopeGroupId = themeDisplay.getScopeGroupId();

        new SearchStaticInitalize(request);
        SearchContext searchContext = SearchStaticInitalize.getSearchContext(DataTypeManagement.class);

		PortletURL iteratorURL = response.createRenderURL();
		iteratorURL.setParameter("action", "collectionPopup");
		iteratorURL.setParameter("keyword", ParamUtil.getString(request, "keyword"));

        SearchContainer<Collection> searchContainer = new SearchContainer<Collection>(request, null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchStaticInitalize.getCur(), SearchStaticInitalize.getDelta(), iteratorURL, null, "Please create a new Collection.");
        searchContext.setStart(searchContainer.getStart());
        searchContext.setEnd(searchContainer.getEnd());

        ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
        int count;
        List<Collection> list;

        String allCollection = ParamUtil.getString(request, "allCollection");

        if ( (allCollection != null) && (allCollection.contains("true")) ) {
            // in case of retrieving collections in all communities
            count = CollectionLocalServiceUtil.getCount();
            list = CollectionLocalServiceUtil.getWritableList(searchContainer.getStart(), searchContainer.getEnd(), keyword, serviceContext);
        } else {
            // Special case) in case of retrieving collections from guest (e.g., EDISON Main Portal) community
            long guestGroupId = GroupLocalServiceUtil.getGroup(themeDisplay.getCompanyId(), GroupConstants.GUEST).getGroupId();
            if (guestGroupId == scopeGroupId) {
            	count = CollectionLocalServiceUtil.getCount();
            	list = CollectionLocalServiceUtil.getWritableList(searchContainer.getStart(), searchContainer.getEnd(), keyword, serviceContext);
            } else { // in case of retrieving collections in the scoped community
            	count = CollectionServiceUtil.getCount(scopeGroupId, serviceContext);
            	list = CollectionLocalServiceUtil.getWritableList(scopeGroupId, searchContainer.getStart(), searchContainer.getEnd(), keyword, serviceContext);
            }
        }

        searchContainer.setTotal(count);
        searchContainer.setResults(list);

        model.addAttribute("searchContainer", searchContainer);
        model.addAttribute("createPerm", CollectionModelPermission.contains(serviceContext, scopeGroupId, PermissionConstant.SDR_ACTION_COLLECTION_CREATE));


        return "sdrcommon/collectionPopup";
    }

    /**
     * Collection popup edit string.
     *
     * @param collectionId the collection id
     * @param model        the model
     * @param request      the request
     * @param response     the response
     * @return the string
     * @throws PortalException the portal exception
     * @throws SystemException the system exception
     */
    @RenderMapping(params = "action=collectionPopup_edit")
    public String collectionPopup_edit(@RequestParam(defaultValue = "0") long collectionId, Model model, RenderRequest request, RenderResponse response) throws PortalException, SystemException {
        _log.debug("### SdrCommonPortlet collectionPopup_edit");
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(com.liferay.portal.kernel.util.WebKeys.THEME_DISPLAY);

        if (collectionId > 0) {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
            Collection collection = CollectionServiceUtil.getCollection(collectionId, serviceContext);
            model.addAttribute("vo", collection);

            // Let the below code do not have Access Control. The above code already has it.
            //Contributors 조회
            List<Collection_User> collection_Users = Collection_UserLocalServiceUtil.getUsersByCollection(collection.getCollectionId());
            String uIds = "";
            String uNames = "";
            for (Collection_User c : collection_Users) {
                SdrUsers u = SdrUsersLocalServiceUtil.getSdrUsers(c.getUserId());
                if (!"".equals(uIds)) {
                    uIds += ",";
                    uNames += ",";
                }
                uIds += u.getUserId();
                uNames += u.getLastName() + u.getFirstName();
            }
            Map<String, Object> contributors = new HashMap<>();
            contributors.put("ids", uIds);
            contributors.put("names", uNames);

            //Keyword 조회
            List<AssetTag> assetTagList = AssetTagServiceUtil.getTags(Collection.class.getName(), collectionId);
            String assetTags = "";
            for (AssetTag tag : assetTagList) {
                if (!"".equals(assetTags)) assetTags += ",";
                assetTags += tag.getName();
            }

            model.addAttribute("contributors", contributors);
            model.addAttribute("assetTags", assetTags);
        }

        //Community List 조회
        ThemeDisplay attribute = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        Group group = attribute.getLayout().getGroup();
        // List<Group> communityList = GroupLocalServiceUtil.getLayoutsGroups(group.getCompanyId(), group.getParentGroupId(),true, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
        // List<Group> communityList = GroupLocalServiceUtil.getLayoutsGroups(group.getCompanyId(), group.getGroupId(),true, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
        List<Group> communityList = new ArrayList<>();
        List<Group> allList = GroupLocalServiceUtil.getCompanyGroups(group.getCompanyId(), QueryUtil.ALL_POS, QueryUtil.ALL_POS) ;
        for (Group g : allList) {
            if ( g.getType() == GroupConstants.TYPE_SITE_OPEN)
                communityList.add(g);
        }

        model.addAttribute("communityList", communityList);
        model.addAttribute("scopeGroupId", attribute.getScopeGroupId());

        long guestGroupId = GroupLocalServiceUtil.getGroup(themeDisplay.getCompanyId(), GroupConstants.GUEST).getGroupId();
        model.addAttribute("guestGroupId", guestGroupId);
		model.addAttribute("databrowser", ParamUtil.getString(request, "databrowser"));

        return "sdrcommon/collectionPopup_edit";
    }

    /**
     * Collection popup save.
     *
     * @param vo       the vo
     * @param request  the request
     * @param response the response
     * @param model    the model
     * @throws Exception the exception
     */
    @ActionMapping(value = "collectionPopup_save")
    public void collectionPopup_save(@ModelAttribute CollectionVo vo,
                                     ActionRequest request, ActionResponse response,
                                     Model model) throws Exception {
        _log.debug("### SdrCommonPortlet collectionPopup_save vo:::" + vo.toString());

        ServiceContext serviceContext = ServiceContextFactory.getInstance(Collection.class.getName(), request);

        try {

			CollectionServiceUtil.save(vo, vo.getContributorIds(), vo.getAllowedUserIds(), serviceContext);

			SessionMessages.add(request, "success");
			_log.debug("collectionPopup_save");

			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(com.liferay.portal.kernel.util.WebKeys.THEME_DISPLAY);

			if("databrowser".equals(ParamUtil.getString(request, "databrowser"))){
				PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(request), "databrowser_WAR_SDR_baseportlet", themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
				redirectURL.setParameter("action", "dataSearch");
				redirectURL.setParameter("success", "success");
				response.sendRedirect(redirectURL.toString());
			}else{
				response.setRenderParameter("action", "collectionPopup");
			}
        } catch (PrincipalException e) {
            ErrorHandler.error(request, e);
            response.setRenderParameter("action", "collectionPopup_edit");
        } catch (Exception e) {
            SessionErrors.add(request, "error");
            e.printStackTrace();
        }

    }

    /**
     * Contributors popup string.
     *
     * @param request  the request
     * @param response the response
     * @param model    the model
     * @return the string
     */
    @RenderMapping(params = "action=contributorsPopup")
    public String contributorsPopup(RenderRequest request, RenderResponse response, Model model) {
        _log.debug("### SdrCommonPortlet contributorsPopup");
        // TODO : Access Control
        return "sdrcommon/contributorsPopup";
    }

    /**
     * Contributors popup edit string.
     *
     * @param userId the user id
     * @param model  the model
     * @return the string
     * @throws PortalException the portal exception
     * @throws SystemException the system exception
     */
    @RenderMapping(params = "action=contributorsPopup_edit")
    public String contributorsPopup_edit(@RequestParam(defaultValue = "0") long userId, Model model) throws PortalException, SystemException {
        _log.debug("### SdrCommonPortlet contributorPopup_edit");
        // TODO : Access Control
        if (userId > 0) {
            SdrUsers sdrUsers = SdrUsersLocalServiceUtil.getSdrUsers(userId);
            model.addAttribute("vo", sdrUsers);
        }

        return "sdrcommon/contributorsPopup_edit";
    }

    /**
     * Contributors popup save.
     *
     * @param vo       the vo
     * @param request  the request
     * @param response the response
     * @param model    the model
     * @throws Exception the exception
     */
    @ActionMapping(value = "contributorsPopup_save")
    public void contributorsPopup_save(@ModelAttribute SdrUsersClp vo,
                                       ActionRequest request, ActionResponse response,
                                       Model model) throws Exception {
        _log.debug("### SdrCommonPortlet contributorsPopup_save vo:::" + vo.toString());

        ServiceContext serviceContext = ServiceContextFactory.getInstance(SdrUsers.class.getName(), request);

        try {
            SdrUsersServiceUtil.save(vo, serviceContext);
            SessionMessages.add(request, "success");
            response.setRenderParameter("action", "contributorsPopup");
        } catch (PrincipalException e) {
            ErrorHandler.error(request, e);
            response.setRenderParameter("action", "contributorsPopup_edit");
        } catch (Exception e) {
            SessionErrors.add(request, "error");
            e.printStackTrace();
        }

    }

    /**
     * Contributors popup delete.
     *
     * @param userId   the user id
     * @param request  the request
     * @param response the response
     * @param model    the model
     * @throws Exception the exception
     */
    @ActionMapping(value = "contributorsPopup_delete")
    public void contributorsPopup_delete(@RequestParam long userId,
                                         ActionRequest request, ActionResponse response,
                                         Model model) throws Exception {
        _log.debug("### SdrCommonPortlet contributorsPopup_delete userId:::" + userId);

        ServiceContext serviceContext = ServiceContextFactory.getInstance(SdrUsers.class.getName(), request);

        try {

            List list = Collection_UserLocalServiceUtil.getCollectionsByUser(userId);
            if(list.size()>0)
                throw new PortalException("This user is included in the collection");

            SdrUsersServiceUtil.delete(userId, serviceContext);

            SessionMessages.add(request, "success");
            response.setRenderParameter("action", "contributorsPopup");

        } catch (PortalException e) {
            SessionErrors.add(request, "error", e.getMessage());
            SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
            response.setRenderParameter("action", "contributorsPopup");
        } catch (Exception e) {
            SessionErrors.add(request, "error");
            e.printStackTrace();
        }

    }

	/**
	 * Allowed users popup string.
	 *
	 * @param request  the request
	 * @param response the response
	 * @param model    the model
	 * @return the string
	 * @throws SystemException the system exception
	 */
	@RenderMapping(params = "action=allowedUsersPopup")
	public String allowedUsersPopup(RenderRequest request, RenderResponse response, Model model) throws SystemException {
		_log.debug("### SdrCommonPortlet allowedUsersPopup");

		String keywords = ParamUtil.getString(request, "keywords");
		String allowedUserIds = ParamUtil.getString(request, "allowedUserIds");
		String allowedUserNames = ParamUtil.getString(request, "allowedUserNames");

		SearchContainer<User> searchContainer = new SearchContainer<User>(request, response.createRenderURL(), null, "no Users");

		DynamicQuery dynamicQuery = UserLocalServiceUtil.dynamicQuery();
		Criterion criterion = null;
		criterion = RestrictionsFactoryUtil.or(RestrictionsFactoryUtil.like("firstName", "%" + keywords + "%"), RestrictionsFactoryUtil.like("lastName", "%" + keywords + "%"));
		dynamicQuery.add(criterion);
		dynamicQuery.setLimit(searchContainer.getStart(), searchContainer.getEnd());

		model.addAttribute("allowedUsers", UserLocalServiceUtil.dynamicQuery(dynamicQuery));
		model.addAttribute("searchContainer", searchContainer);
		
		model.addAttribute("keywords", keywords);
		model.addAttribute("allowedUserIds", allowedUserIds);
		model.addAttribute("allowedUserNames", allowedUserNames);

		return "sdrcommon/allowedUsersPopup";
	}

	/**
	 * dataTypePopup
	 *
	 * dataType 조회 팝업
	 *
	 * @param keyword
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	@RenderMapping(params = "action=dataTypePopup")
	public String dataTypePopup(@RequestParam(value = "keyword", required = false) String keyword,
								RenderRequest request, RenderResponse response, Model model) throws SystemException, PortalException {
		_log.debug("### SdrCommonPortlet dataTypePopup : " + keyword);

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(com.liferay.portal.kernel.util.WebKeys.THEME_DISPLAY);

		new SearchStaticInitalize(request);
		SearchContext searchContext = SearchStaticInitalize.getSearchContext(DataTypeManagement.class);

		PortletURL iteratorURL = response.createRenderURL();
		iteratorURL.setParameter("action", "dataTypePopup");
		iteratorURL.setParameter("keyword", ParamUtil.getString(request, "keyword"));

		SearchContainer<DataType> searchContainer = new SearchContainer<>(request, null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchStaticInitalize.getCur(), SearchStaticInitalize.getDelta(), iteratorURL, null, "검색된 데이터가 없습니다.");

		searchContext.setStart(searchContainer.getStart());
		searchContext.setEnd(searchContainer.getEnd());

		int count;
		List<DataType> list;

		String allDataType = ParamUtil.getString(request, "allDataType");

		if( (allDataType != null) && (allDataType.contains("true")) ){
			_log.debug("ehg 2 + " + allDataType);
			count = DataTypeLocalServiceUtil.getCount();
			list = DataTypeLocalServiceUtil.getList(searchContainer.getStart(), searchContainer.getEnd(), keyword);
		} else {
			_log.debug("ehg 1");
			count = DataTypeLocalServiceUtil.getCount(keyword);
			list = DataTypeLocalServiceUtil.getList(searchContainer.getStart(), searchContainer.getEnd(), keyword);
		}

		searchContainer.setTotal(count);
		searchContainer.setResults(list);

		model.addAttribute("searchContainer", searchContainer);
		/*model.addAttribute("createPerm", DataTypeModelPermission.contains(serviceContext, PermissionConstant.SDR_ACTION_COLLECTION_CREATE));*/

		return "sdrcommon/dataTypePopup";
	}


	/**
	 * compositionPopup
	 *
	 * Curation composition Type curation 조회 팝업
	 *
	 * @param keyword
	 * @param ppId
	 * @param dataTypeName
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	@RenderMapping(params = "action=compositionPopup")
	public String compositionPopup(@RequestParam(value = "keyword", required = false) String keyword, @RequestParam(value = "ppId", required = false) String ppId,
								   @RequestParam(value = "dataTypeName", required = false) String dataTypeName,
								   @RequestParam(value = "dataTypeId", required = false) String dataTypeId,
								   @RequestParam(value = "curationIdList", required = false) String curationIdList,
								   @RequestParam(value = "popupFlag", required = false) String popupFlag,
								   RenderRequest request, RenderResponse response, Model model) throws SystemException, PortalException {
		_log.debug("### SdrCommonPortlet compositionPopup : " + keyword + " : ppId : " + ppId + " : dataTypeName : " + dataTypeName + " : dataTypeId : " + dataTypeId);

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(com.liferay.portal.kernel.util.WebKeys.THEME_DISPLAY);
		/*long scopeGroupId = themeDisplay.getScopeGroupId();*/

		new SearchStaticInitalize(request);
		SearchContext searchContext = SearchStaticInitalize.getSearchContext(CurationManager.class);

		PortletURL iteratorURL = response.createRenderURL();
		iteratorURL.setParameter("action", "compositionPopup");
		iteratorURL.setParameter("keyword", ParamUtil.getString(request, "keyword"));
		iteratorURL.setParameter("dataTypeId", ParamUtil.getString(request, "dataTypeId"));
		iteratorURL.setParameter("dataTypeName", ParamUtil.getString(request, "dataTypeName"));
		iteratorURL.setParameter("popupFlag", ParamUtil.getString(request, "popupFlag"));
		iteratorURL.setParameter("ppId", ParamUtil.getString(request, "ppId"));

		SearchContainer<PpLogic> searchContainer = new SearchContainer<PpLogic>(request, null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchStaticInitalize.getCur(), SearchStaticInitalize.getDelta(), iteratorURL, null, "검색된 데이터가 없습니다.");

		searchContext.setStart(searchContainer.getStart());
		searchContext.setEnd(searchContainer.getEnd());

		ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
		int count;
		List<PpLogic> list;

		if(dataTypeId != null && !"".equals(dataTypeId)){
			count = PpLogicServiceUtil.getCount(keyword, Long.parseLong(dataTypeId), popupFlag);
			list = PpLogicServiceUtil.getList(searchContainer.getStart(), searchContainer.getEnd(), keyword, Long.parseLong(dataTypeId), popupFlag);
		}else{
			count = PpLogicServiceUtil.getCount(keyword);
			list = PpLogicServiceUtil.getList(searchContainer.getStart(), searchContainer.getEnd(), keyword);
		}

		List<DataType> dataTypeList = DataTypeServiceUtil.getList(serviceContext);

		model.addAttribute("dataTypeList", dataTypeList);

		searchContainer.setTotal(count);
		searchContainer.setResults(list);

		model.addAttribute("keyword", keyword);
		model.addAttribute("curationIdList", curationIdList);
		model.addAttribute("ppId", ppId);
		model.addAttribute("dataTypeName", dataTypeName);
		model.addAttribute("dataTypeId", dataTypeId);
		model.addAttribute("popupFlag", popupFlag);
		model.addAttribute("searchContainer", searchContainer);
		/*model.addAttribute("createPerm", CollectionModelPermission.contains(serviceContext, scopeGroupId, PermissionConstant.SDR_ACTION_COLLECTION_CREATE));*/

		return "sdrcommon/compositionPopup";
	}









	//-----------------------------------------------------------------
	// community
	//-----------------------------------------------------------------

	/**
	 * Join community.
	 *
	 * @param request  the request
	 * @param response the response
	 * @throws IOException the io exception
	 */
	@ResourceMapping(value = "joinCommunity")
	public void joinCommunity(ResourceRequest request, ResourceResponse response) throws IOException {
		_log.debug("### joincommunity ");

		org.json.JSONObject result = new org.json.JSONObject();
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

			ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
			if ( PermissionConstant.checkGuest(serviceContext) ) {
				result.put("error", "Please login.");
			} else {
				long groupId = themeDisplay.getScopeGroupId();
				long userId = themeDisplay.getUserId();
				boolean hasUserGroup = GroupServiceUtil.hasUserGroup(userId, groupId);
				_log.debug("### userId ::: " + userId + "    ### groupId ::: " + groupId + "   ### hasUserGroup ::: " + hasUserGroup);

				if (hasUserGroup) {
					result.put("error", "Already joined community.");
				} else {
					UserLocalServiceUtil.addGroupUser(groupId, userId);
					result.put("success", "You have successfully joined the community.");
				}
			}

		} catch (Exception e) {
			result.put("error", e.getMessage());
			_log.error(e.getMessage());
		} finally {
			response.getWriter().print(result);
		}
	}

	@ResourceMapping(value = "hasJoinCommunity")
	public void hasJoinCommunity(ResourceRequest request, ResourceResponse response) throws IOException {
		_log.debug("### hasJoinCommunity ");

		org.json.JSONObject result = new org.json.JSONObject();
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

			long groupId = themeDisplay.getScopeGroupId();
			long userId = themeDisplay.getUserId();
			boolean hasUserGroup = GroupServiceUtil.hasUserGroup(userId, groupId);
			_log.debug("### userId ::: " +userId + "    ### groupId ::: " +groupId + "   ### hasUserGroup ::: " + hasUserGroup);

			result.put("data", hasUserGroup);

		} catch (Exception e) {
			result.put("error", e.getMessage());
			_log.error(e.getMessage());
		} finally {
			response.getWriter().print(result);
		}
	}











	//-----------------------------------------------------------------
	// file
	//-----------------------------------------------------------------


    /**
     * Dataset file.
     *
     * @param datasetId the dataset id
     * @param path      the path
     * @param request   the request
     * @param response  the response
     * @throws SystemException the system exception
     */
    @ResourceMapping(value = "datasetFile")
    public void datasetFile(@RequestParam("datasetId") long datasetId,
                            @RequestParam("path") String path,
                            ResourceRequest request, ResourceResponse response) throws SystemException {

        _log.debug("### path ::: " + path);

        File outputFile = getDatasetFile(datasetId, path);
        if (outputFile != null) {
            Path outputPath = outputFile.toPath();
            try {
                PortletResponseUtil.sendFile(request, response,
                        outputFile.getName(),
                        Files.readAllBytes(outputPath),
                        Files.probeContentType(outputPath));
            } catch (IOException e) {
                _log.error("datasetFile ::: " + e.getMessage());
            }
        } else {
            _log.warn("no dataset file");
        }
    }

    /**
     * Gets dataset file.
     *
     * @param datasetId the dataset id
     * @param path      the path
     * @return the dataset file
     * @throws SystemException the system exception
     */
    public File getDatasetFile(long datasetId, String path) throws SystemException {
        Dataset dataset = null;

        // Let's avoid access control for the below code
        try {
            dataset = DatasetLocalServiceUtil.getDataset(datasetId);
        } catch (PortalException e) {
            _log.warn("getDatasetFile ::: " + e.getMessage());
        }

        File outputFile = null;
        if (dataset != null && !StringUtils.isEmpty(dataset.getLocation())) {
            String location = dataset.getLocation();
            String filePath = location + path;
            outputFile = new File(filePath);
        }

        return outputFile;
    }

    /**
     * Dataset file path.
     *
     * @param path      the path
     * @param request   the request
     * @param response  the response
     * @throws SystemException the system exception
     */
    @ResourceMapping(value = "datasetFilePath")
    public void datasetFilePath(@RequestParam("path") String path, @RequestParam(value="datasetId", required=false) Long datasetId,
                            ResourceRequest request, ResourceResponse response) throws SystemException, IOException {

        //_log.debug("### path ::: " + path);
		//_log.debug("### datasetid ::: " + datasetId);

        File outputFile = new File(path);

        if (outputFile.exists() == false) {
        	try {
				Dataset ds = DatasetLocalServiceUtil.getDataset(datasetId);
				if (ds.getGrId() == 0) { _log.warn("no dataset file"); return; }
				ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
				String mf = DatasetLocalServiceUtil.findMergedFile(datasetId, path, serviceContext);
				if(mf!=null) outputFile = new File(mf);
				if(outputFile == null) { _log.warn("no dataset file"); return; }
			} catch ( Exception e ) {
				_log.warn("no dataset file"); return;
			}
		}

		Path outputPath = outputFile.toPath();
		try {
			PortletResponseUtil.sendFile(request, response,
					outputFile.getName(),
					Files.readAllBytes(outputPath),
					getContentType(outputFile)
					);
		} catch (IOException e) {
			_log.error("datasetFile ::: " + e.getMessage());
		}

    }

	/**
	 * Dataset css file background-img path.
	 *
	 * @param path      the path
	 * @param request   the request
	 * @param response  the response
	 * @throws SystemException the system exception
	 */
	@ResourceMapping(value = "datasetFileResource")
	public void datasetFileResource(@RequestParam("path") String path, @RequestParam(value="datasetId", required=false) Long datasetId,
								ResourceRequest request, ResourceResponse response) throws SystemException, IOException {

		File outputFile = new File(path);
		String tmpFilePath = "";

		if (outputFile != null) {
			if (path.indexOf(".css") > -1 || path.indexOf(".js") > -1) {
				if (path.indexOf("bootstrap") < 0 && path.indexOf("jquery") < 0) {
//					_log.debug("### catch ::: " + path);

					ResourceURL resourceURL = response.createResourceURL();
					resourceURL.setResourceID("datasetFileResource");

					int lastPathIndex = path.lastIndexOf("/");
					String cssDir = path.substring(0, lastPathIndex);

					String oldString = "url\\(";
					String oldComString = "url('";
					String oldDoubleComString = "url(\"";
					String newString = "url("+resourceURL+"&_sdrcommon_WAR_SDR_baseportlet_path="+cssDir+"/";
					String newComString = "url('"+resourceURL+"&_sdrcommon_WAR_SDR_baseportlet_path="+cssDir+"/";
					String newDoubleComString = "url(\""+resourceURL+"&_sdrcommon_WAR_SDR_baseportlet_path="+cssDir+"/";
					File fileToBeModified = outputFile;

					String oldContent = "";
					BufferedReader reader = null;
					BufferedWriter writer = null;
					try {
						reader = new BufferedReader(new FileReader(fileToBeModified));

						String line = reader.readLine();

						while (line != null) {
							oldContent = oldContent + line + System.lineSeparator();

							line = reader.readLine();
						}
						String newContent  = "";
						if(oldContent.indexOf(newString) == -1){
							if(oldContent.contains(oldComString)){
								newContent = oldContent.replaceAll("url\\('", newComString);
							}else if(oldContent.contains(oldDoubleComString)){
								newContent = oldContent.replaceAll("url\\(\\\"", newDoubleComString);
							}else{
								newContent = oldContent.replaceAll(oldString, newString);
							}
						}else{
							newContent = oldContent;
						}

//						_log.debug("### oldContent ::: " + oldContent);
//						_log.debug("### newContent ::: " + newContent);
						tmpFilePath = outputFile.getAbsolutePath() + ".tmp."+FileService.checkExtension(outputFile);
						writer = new BufferedWriter(new FileWriter(tmpFilePath));
						writer.write(newContent);
						writer.close();
						reader.close();

						outputFile = new File(tmpFilePath);

					} catch (IOException e) {
						e.printStackTrace();
					}

				}

			}
		}

		Path outputPath = outputFile.toPath();
		try {
			PortletResponseUtil.sendFile(request, response,
				outputFile.getName(),
				Files.readAllBytes(outputPath),
				getContentType(outputFile)
			);
		} catch (IOException e) {
			_log.error("datasetFileResource ::: " + e.getMessage());
		}finally {
			File tmpFile = new File(tmpFilePath);
			if(tmpFile.isFile()) tmpFile.delete();
		}

	}

    /**
     * Gets image.
     *
     * @param path     the path
     * @param request  the request
     * @param response the response
     * @throws SystemException the system exception
     */
    @ResourceMapping(value = "getImage")
    public void getImage(@RequestParam("path") String path,
                         ResourceRequest request, ResourceResponse response) throws SystemException {

        _log.debug("### getImage path ::: " + path);

        File outputFile = new File(path);
        if (outputFile != null) {
            Path outputPath = outputFile.toPath();
            try {
                PortletResponseUtil.sendFile(request, response,
                        outputFile.getName(),
                        Files.readAllBytes(outputPath),
						getContentType(outputFile));

            } catch (NoSuchFileException e) {
                //_log.debug("== No image ==");

                HttpServletRequest req = PortalUtil.getHttpServletRequest(request);
                ServletContext servletContext = req.getSession().getServletContext();

                File f = new File(servletContext.getRealPath("/images/sample_100.png"));
                Path fPath = f.toPath();

                try {
                    PortletResponseUtil.sendFile(request, response, f.getName(), Files.readAllBytes(fPath), Files.probeContentType(fPath));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            } catch (IOException e) {
                _log.error("getImage err ::: " + e.getMessage());
            }
        } else {
            _log.warn("no image file");
        }
    }


	/**
	 * Upload image.
	 *
	 * @param request  the request
	 * @param response the response
	 * @throws PortalException the portal exception
	 * @throws SystemException the system exception
	 * @throws IOException     the io exception
	 */
	@ResourceMapping(value="uploadImage")
    public void uploadImage(ResourceRequest request, ResourceResponse response) throws PortalException, SystemException, IOException {
        _log.debug("### SdrCommon uploadImage");

        org.json.JSONObject result = new org.json.JSONObject();
        try {

            ServiceContext serviceContext = ServiceContextFactory.getInstance(SdrCommon.class.getName(), request);
            UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
            String folder = ParamUtil.getString(request,"path");

            File file = uploadRequest.getFile("upload");
            String ext = FileService.checkExtension(file);

            String regEx = "(jpg|jpeg|bmp|gif|png)";
            if (!ext.matches(regEx)) {
                throw new Exception("This file is not in image format.");
            }

            String filePath = FileService.saveFile(file, folder);
            String location = filePath + File.separator + file.getName();

            result.put("uploaded", 1);
            result.put("fileName", file.getName());
            result.put("url", location);

			_log.debug("### result ::: " +result.toString());

        } catch (Exception e) {
            result.put("uploaded",0);
            result.put("error", e.getMessage());
            _log.error(e.getMessage());
        } finally {
            response.getWriter().print(result);
        }
    }


    /**
     * Multiple File Path
     *
     * @param path      the path
     * @param request   the request
     * @param response  the response
     * @throws SystemException the system exception
     * @throws IOException
     */
    @ResourceMapping(value = "multipleDatasetFilePath")
    public void multipleDatasetFilePath(@RequestParam("multiPath") String path, ResourceRequest request, ResourceResponse response) throws SystemException, IOException {

    	// Path = FileType + FilePath (e.g., http://localhost..../c:/Users/admin/..../58111/derived/*.rlt)
        //String path = request.getParameter("multiPath");
    	_log.debug("### Multiple Path ::: " + path);
    	JSONArray resultArray = JSONFactoryUtil.createJSONArray();
    	try {

	        int fileNameIndex = path.lastIndexOf("/");
	        int fileExtensionIndex = path.lastIndexOf(".");

	        String folderPath = path.substring(0, fileNameIndex);
			String fileName = path.substring(fileNameIndex+1, fileExtensionIndex);
	        //String fileName = path.substring(fileNameIndex+1);
	        //fileName = fileName.replaceAll("\\\\", "/");
			//_log.debug("file Name ==>"+ fileName);
			int asteriskFirstIndex = fileName.indexOf("*");
			int asteriskLastIndex = fileName.lastIndexOf("*");
			//asterisk 위치 파악후 받아온 파일이름에서 asterisk 제거
			fileName = fileName.replaceAll("\\*", "");
			String asteriskFirst ="";
			String asteriskLast ="";
			if(asteriskFirstIndex == 0){
				asteriskFirst = ".*";
			}
			if(asteriskLastIndex  >= fileName.length()){
				asteriskLast = ".*";
			}

	        String fileExt = path.substring(fileExtensionIndex);

	        // c:/Users/admin/root/meta/57902/20198/m0/k58/58802/derived
	        //_log.debug("folder Path ===> " + folderPath);
	        //_log.debug("file Name ===> " + fileName + " EXT ===> " + fileExt);
			//_log.debug("askeyFirst+ fileName + askeyLast ===> " + asteriskFirst+ fileName + asteriskLast);
	        File[] fileList = FileService.listAllFilesWithExtension(folderPath, fileExt);

	        for(File file : fileList){
	        	JSONObject resultObj = JSONFactoryUtil.createJSONObject();
	        	if(file.getName().matches(asteriskFirst+ fileName + asteriskLast + fileExt)){
					resultObj.put("fileName", file.getName());
					resultObj.put("filePath", file.getAbsolutePath());
					resultArray.put(resultObj);
				}
	        }

        } catch (IndexOutOfBoundsException e) {
            _log.error(e.getMessage());
        } finally {
        	_log.debug(resultArray.toString());
            response.getWriter().print(resultArray);
        }

    }

    /**
     * Dataset file check.
     *
     * @param path     the path
     * @param request  the request
     * @param response the response
     * @throws IOException the io exception
     */
    @ResourceMapping(value = "datasetFileCheck")
    public void datasetFileCheck(@RequestParam("path") String path,
                                ResourceRequest request, ResourceResponse response) throws IOException {
        _log.debug("### datasetFileCheck path ::: " + path);

        org.json.JSONObject result = new org.json.JSONObject();
        try {

            int fileCount = 0;

            File outputFile = new File(path);

            if(outputFile.isFile()){
                fileCount = 1;
            }else if(outputFile.isDirectory()){
                fileCount = FileService.getFilesCount(outputFile.getPath());
            }

            result.put("data", fileCount);

        } catch (Exception e) {
            result.put("error", e.getMessage());
            _log.error(e.getMessage());
        } finally {
            response.getWriter().print(result);
        }
    }

	/**
	 * Dataset multi file check.
	 *
	 * @param path     the path
	 * @param request  the request
	 * @param response the response
	 * @throws IOException the io exception
	 */
	@ResourceMapping(value = "datasetMultiFileCheck")
	public void datasetMultiFileCheck(@RequestParam("path") String path,
								 ResourceRequest request, ResourceResponse response) throws IOException {
		_log.debug("### datasetMultiFileCheck path ::: " + path);

		org.json.JSONObject result = new org.json.JSONObject();
		try {
			int fileCount = 0;
			int fileNameIndex = path.lastIndexOf("/");
			int fileExtensionIndex = path.lastIndexOf(".");

			String folderPath = path.substring(0, fileNameIndex);
			String fileName = path.substring(fileNameIndex+1, fileExtensionIndex);

			int asteriskFirstIndex = fileName.indexOf("*");
			int asteriskLastIndex = fileName.lastIndexOf("*");
			//asterisk 위치 파악후 받아온 파일이름에서 asterisk 제거
			fileName = fileName.replaceAll("\\*", "");
			String asteriskFirst ="";
			String asteriskLast ="";
			if(asteriskFirstIndex == 0){
				asteriskFirst = ".*";
			}
			if(asteriskLastIndex  >= fileName.length()){
				asteriskLast = ".*";
			}
			String fileExt = path.substring(fileExtensionIndex);

			File[] fileList = FileService.listAllFilesWithExtension(folderPath, fileExt);

			for(File file : fileList){
				if(file.getName().matches(asteriskFirst+ fileName + asteriskLast + fileExt)){
					fileCount++;
				}
			}
			result.put("data", fileCount);

		} catch (Exception e) {
			result.put("error", e.getMessage());
			_log.error(e.getMessage());
		} finally {
			response.getWriter().print(result);
		}
	}
    
    
    private String getContentType(File file) throws IOException {
		String contentType = "";
		String ext = FileService.checkExtension(file);
		Path outputPath = file.toPath();
		
		//web
		if("css".equals(ext)) contentType = ContentTypes.TEXT_CSS_UTF8;
		else if("js".equals(ext)) contentType = ContentTypes.TEXT_JAVASCRIPT;
		else if("xml".equals(ext)) contentType = ContentTypes.TEXT_XML_UTF8;
		else if("html".equals(ext) || "html".equals(ext)) contentType = ContentTypes.TEXT_HTML_UTF8;

		//file
		else if("csv".equals(ext)) contentType = ContentTypes.TEXT_CSV_UTF8;
		else if("zip".equals(ext)) contentType = ContentTypes.APPLICATION_ZIP;
		else if("pdf".equals(ext)) contentType = ContentTypes.APPLICATION_PDF;
		
		//image
		else if("jpg".equals(ext)) contentType = ContentTypes.IMAGE_JPEG;
		else if("png".equals(ext)) contentType = ContentTypes.IMAGE_PNG;
		else if("gif".equals(ext)) contentType = ContentTypes.IMAGE_GIF;
		else if("bmp".equals(ext)) contentType = ContentTypes.IMAGE_BMP;
		else if("svg".equals(ext)) contentType = "image/svg+xml";
		
		else contentType = Files.probeContentType(outputPath);
		
		return contentType;
	}


	
	
	


	//-----------------------------------------------------------------
	// View Designer
	//-----------------------------------------------------------------

	/**
	 * Preview string.
	 *
	 * @param request  the request
	 * @param response the response
	 * @param model    the model
	 * @return the string
	 * @throws PortalException the portal exception
	 * @throws SystemException the system exception
	 */
	@RenderMapping(params = "action=preview")
	public String preview(RenderRequest request, RenderResponse response ,Model model) throws PortalException, SystemException{

		ServiceContext serviceContext = ServiceContextFactory.getInstance(Dataset.class.getName(), request);

		long datasetId = ParamUtil.getLong(request, "datasetId");
		long dataViewId = ParamUtil.getLong(request, "dataViewId");
		String html = ParamUtil.getString(request, "html");

		model.addAttribute("datasetId", datasetId);
		model.addAttribute("html", html);

		try {
			org.json.JSONObject result = getDatasetJson(datasetId, dataViewId, serviceContext);

			//----------------------------------------------------
			//file path
			model.addAttribute("finalPath", result.get("finalPath"));
			model.addAttribute("metaPath", result.get("metaPath"));

			//----------------------------------------------------
			//descriptiveMetadata
			model.addAttribute("dm_str", result.get("dm_str"));

			//----------------------------------------------------
			//descriptiveMetadata to json
			model.addAttribute("dm", result.get("dm"));

			//----------------------------------------------------
			model.addAttribute("cv", result.get("cv"));

			//----------------------------------------------------
			// dataViewId
			if(dataViewId>0){
				DataView dataView = DataViewServiceUtil.getDataView(dataViewId, serviceContext);
				html = URLEncoder.encode(dataView.getHtml(),"utf-8");
			}

			model.addAttribute("html", html);

		} catch (Exception e) {
			model.addAttribute("finalPath", "");
			model.addAttribute("metaPath", "");
			model.addAttribute("dm_str", "{}");
			model.addAttribute("dm", "{}");
			model.addAttribute("cv", "{}");
			model.addAttribute("html", html);

			_log.debug("### error ::: " +e.getMessage());
			ErrorHandler.error(request, e);
		} finally {
			return "sdrcommon/preview";
		}

	}

	private org.json.JSONObject getDatasetJson(long datasetId, long dataViewId, ServiceContext serviceContext) throws SystemException, PortalException {
		org.json.JSONObject result = new org.json.JSONObject();
		result.put("datasetId", datasetId);
		result.put("dataViewId", dataViewId);

		if(datasetId<=0){
			result.put("finalPath", "");
			result.put("metaPath", "");
			result.put("dm_str", "{}");
			result.put("dm", "{}");
			result.put("cv", "{}");
			return result;
		}

		Dataset dataset = DatasetServiceUtil.getDataset(datasetId, serviceContext);

		// Problem : \ in url makes trouble
		String location = dataset.getLocation();
		String metaLocation = dataset.getMetalocation();

		location = location.replaceAll("\\\\", "/");
		metaLocation = metaLocation.replaceAll("\\\\", "/");

		//----------------------------------------------------
		//file path
		result.put("finalPath", location);
		result.put("metaPath", metaLocation);

		//----------------------------------------------------
		//descriptiveMetadata
		String DM = null;

		if ( dataset.getGrId() > 0 ) {
			DM = DatasetLocalServiceUtil.getMergedDescriptiveMetadata( datasetId, dataset.getGrId(), serviceContext );
			if (DM==null) DM="";
			//DM = dataset.getDescriptiveMetadata();
		} else {
			DM = dataset.getDescriptiveMetadata();
		}

		result.put("dm_str", DM);

		//----------------------------------------------------
		//descriptiveMetadata to json
		Map dmMap = new HashMap();
		if(Validator.isNull(DM)) {
			dmMap.put("No_Value", 0);
		} else {
			/* DescriptiveMetadata 소수점 6자리 정리 */
			org.json.JSONObject jsonObject = new org.json.JSONObject(DM);
			dmMap = CommonUtil.numberRoundAndMakeJson(jsonObject);
		}
		dmMap.put("datasetId", datasetId);
		result.put("dm", dmMap);

		//----------------------------------------------------
		// Descriptive Metadata Title에 wiki link 를 걸기위한 작업
		List<DataTypeSchema> cvList = DataTypeSchemaServiceUtil.getList(dataset.getDataTypeId());
		Map cvMap = new HashMap();
		for(DataTypeSchema each : cvList){
			String aTag = "https://en.wikipedia.org/wiki/"+each.getReference();
			String title = each.getTitle().substring(0, 1).toUpperCase() + each.getTitle().substring(1);
			cvMap.put(title, aTag);
		}
		result.put("cv", cvMap);

		return result;
	}


	/**
	 * Gets html.
	 *
	 * @param path     the path
	 * @param request  the request
	 * @param response the response
	 * @throws IOException the io exception
	 */
	@ResourceMapping(value = "getHtml")
	public void getHtml(@RequestParam("path") String path,
						ResourceRequest request, ResourceResponse response) throws IOException {
		_log.debug("### getHtml path ::: " + path);

		org.json.JSONObject result = new org.json.JSONObject();
		try {
			File outputFile = new File(path);

			//validate file
			if(!outputFile.isFile()){
				throw new IOException("This is not in file format.");
			}

			//validate html format
			String ext = FileService.checkExtension(outputFile);
			String regEx = "(html|HTML)";
			if (!ext.matches(regEx)) {
				result.put("error", "This file is not in HTML format.");
			}

			//html to string
			StringBuilder contentBuilder = new StringBuilder();
			try {
				BufferedReader in = new BufferedReader(new FileReader(outputFile));
				String str;
				while ((str = in.readLine()) != null) {
					contentBuilder.append(str);
				}
				in.close();
			} catch (IOException e) {
				_log.debug("### IOException error ::: " + e.getMessage());
				result.put("error", e.getMessage());
			}

			String content = contentBuilder.toString();
			result.put("data", URLEncoder.encode(content,"utf-8"));

		} catch (Exception e) {
			result.put("error", e.getMessage());
			_log.error(e.getMessage());
		} finally {
			response.getWriter().print(result);
		}
	}
	

}
