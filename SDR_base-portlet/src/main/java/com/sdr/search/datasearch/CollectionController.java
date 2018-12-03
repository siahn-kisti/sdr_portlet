package com.sdr.search.datasearch;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.GroupLocalServiceUtil;
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
import com.sdr.common.util.ErrorHandler;
import com.sdr.file.FileService;
import com.sdr.metadata.model.Collection;
import com.sdr.metadata.model.Collection_AllowedUser;
import com.sdr.metadata.model.Collection_User;
import com.sdr.metadata.model.SdrUsers;
import com.sdr.metadata.service.CollectionServiceUtil;
import com.sdr.metadata.service.Collection_AllowedUserLocalServiceUtil;
import com.sdr.metadata.service.Collection_UserLocalServiceUtil;
import com.sdr.metadata.service.DatasetLocalServiceUtil;
import com.sdr.metadata.service.SdrUsersLocalServiceUtil;
import com.sdr.metadata.util.WebKeys;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * The type Collection controller.
 */
@Controller
@RequestMapping(value = "VIEW", params = "controller=Collection")
public class CollectionController {

    private static Log log = LogFactoryUtil.getLog(CollectionController.class);

    /**
     * Collection detail string.
     *
     * @param renderRequest  the render request
     * @param renderResponse the render response
     * @param collectionId   the collection id
     * @param model          the model
     * @return the string
     * @throws PortalException the portal exception
     * @throws SystemException the system exception
     */
    @RenderMapping(params = "action=collectionDetail")
    public String collectionDetail(RenderRequest renderRequest, RenderResponse renderResponse, @RequestParam long collectionId, Model model) {
        log.debug("### collectionDetail :::" + collectionId);
        String tabName = null;
        try {
            tabName = ParamUtil.getString(renderRequest, "tabs");

            ServiceContext serviceContext = ServiceContextFactory.getInstance(Collection.class.getName(), renderRequest);
            Collection collection = CollectionServiceUtil.getCollection(collectionId, serviceContext);
            String communityName = GroupLocalServiceUtil.getGroup(collection.getGroupId()).getName().isEmpty() ? "-" : GroupLocalServiceUtil.getGroup(collection.getGroupId()).getName();
            String owner = UserLocalServiceUtil.getUser(collection.getUserId()).getFullName().isEmpty() ? "-" : UserLocalServiceUtil.getUser(collection.getUserId()).getFullName();

            List<SdrUsers> contributors = new ArrayList<>();

            // Let's avoid the Access Control. The above code already has it.
            for (Collection_User contributor : Collection_UserLocalServiceUtil.getUsersByCollection(collection.getCollectionId())) {
                contributors.add(SdrUsersLocalServiceUtil.getSdrUsers(contributor.getUserId()));
            }
            List<User> allowedUsers = new ArrayList<>();
            for (Collection_AllowedUser allowedUser : Collection_AllowedUserLocalServiceUtil.getAllowedUsersByCollection(collectionId)) {
                allowedUsers.add(UserLocalServiceUtil.getUser(allowedUser.getUserId()));
            }

            // allowedPolicy
            Map allowedPolicy = new LinkedHashMap();
            String revertPerm = PermissionConstant.revertPerm(collection.getAccessPolicy());

            allowedPolicy.put("Allowed User", Character.getNumericValue(revertPerm.charAt(0)));
            allowedPolicy.put("Community Member", Character.getNumericValue(revertPerm.charAt(1)));
            allowedPolicy.put("Non-Community Member", Character.getNumericValue(revertPerm.charAt(2)));
            allowedPolicy.put("Guest", Character.getNumericValue(revertPerm.charAt(3)));

            //embago
            int embago = PermissionConstant.checkEmbago(Character.getNumericValue(revertPerm.charAt(2)), collection.getCreateDate());

            model.addAttribute("embago", embago);

            model.addAttribute("allowedPolicy", allowedPolicy);

            model.addAttribute("collection", collection);
            model.addAttribute("communityName", communityName);
            model.addAttribute("owner", owner);
            model.addAttribute("contributors", contributors);
            model.addAttribute("allowedUsers", allowedUsers);
            model.addAttribute("dsCnt", DatasetLocalServiceUtil.getCount(collectionId, WorkflowConstants.STATUS_APPROVED));
            model.addAttribute("editPerm", CollectionModelPermission.contains(serviceContext, collectionId, PermissionConstant.SDR_ACTION_COLLECTION_UPDATE));
            model.addAttribute("deletePerm", CollectionModelPermission.contains(serviceContext, collectionId, PermissionConstant.SDR_ACTION_COLLECTION_DELETE));

			//model.addAttribute("dataViewTitles", "Info,Detail,Dataset,Paper,Comment");
			//model.addAttribute("tabValue", "Info,Detail,Dataset,Paper,Comment");
			model.addAttribute("dataViewTitles", "Info,Dataset,Paper,Detail,Comment");
            model.addAttribute("tabValue", "Info,Dataset,Paper,Detail,Comment");


			//image
			model.addAttribute("image", FileService.getFilePath(getThumbPath(collectionId)));
			
            //info
			model.addAttribute("description", FileService.getHtmlFile(getHtmlPath(collectionId)));
			
			//paper
			model.addAttribute("paper", FileService.getFilePath(getPaperPath(collectionId)));
			

        } catch (PrincipalException e) {
            ErrorHandler.error(renderRequest, e);
		} catch (IOException e) {
			ErrorHandler.error(renderRequest, e);
		} catch (SystemException | PortalException e) {
			SessionErrors.add(renderRequest, e.getClass(), e.getMessage());
			SessionMessages.add(renderRequest, PortalUtil.getPortletId(renderRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			e.printStackTrace();
		}

		if (StringUtils.isEmpty(tabName) ) {
            return "dataSearch/collection/wiki_collection";
        } else {
            if (StringUtils.equals(tabName, "Detail")) {
                return "dataSearch/collection/detail_collection";
            } else if (StringUtils.equals(tabName, "Dataset")) {
                return "dataSearch/collection/dataset_in_collection";
            } else if (StringUtils.equals(tabName, "Comment")) {
                return "dataSearch/collection/comment_collection";
            } else if (StringUtils.equals(tabName, "Paper")) {
                return "dataSearch/collection/paper_collection";
            } else {
                return "dataSearch/collection/wiki_collection";
            }
        }
    }

    /**
     * Collection edit string.
     *
     * @param collectionId  the collection id
     * @param renderRequest the render request
     * @param model         the model
     * @return the string
     * @throws PortalException the portal exception
     * @throws SystemException the system exception
     */
    @RenderMapping(params = "action=collectionSaveForm")
    public String collectionEdit(@RequestParam long collectionId, RenderRequest renderRequest, Model model) throws PortalException, SystemException, PrincipalException {

        log.debug("### collectionEditForm ::: " + collectionId);

        Group group = null;
        if (collectionId > 0) {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(Collection.class.getName(), renderRequest);
            Collection collection = CollectionServiceUtil.getCollection(collectionId, serviceContext);
            model.addAttribute("collection", collection);

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
            model.addAttribute("contributors", contributors);

            //Keyword 조회
            List<AssetTag> assetTagList = AssetTagServiceUtil.getTags(Collection.class.getName(), collectionId);
            String assetTags = "";
            for (AssetTag tag : assetTagList) {
                if (!"".equals(assetTags)) assetTags += ",";
                assetTags += tag.getName();
            }
            model.addAttribute("assetTags", assetTags);

            //Allowed Users 조회
            List<Collection_AllowedUser> collection_allowedUsers = Collection_AllowedUserLocalServiceUtil.getAllowedUsersByCollection(collectionId);
            uIds = "";
            uNames = "";
            for (Collection_AllowedUser a : collection_allowedUsers) {
                User u = UserLocalServiceUtil.getUser(a.getUserId());
                if (!"".equals(uIds)) {
                    uIds += ",";
                    uNames += ",";
                }
                uIds += u.getUserId();
                uNames += u.getLastName() + " " + u.getFirstName();
            }
            Map<String, Object> allowedUsers = new HashMap<>();
            allowedUsers.put("ids", uIds);
            allowedUsers.put("names", uNames);
            model.addAttribute("allowedUsers", allowedUsers);

            model.addAttribute("skipCurate", collection.getSkipCurate());
            //revertPermission
            model.addAttribute("allowedPolicy", PermissionConstant.revertPerm(collection.getAccessPolicy()));

            group = GroupLocalServiceUtil.getGroup(collection.getGroupId());

			//image
			model.addAttribute("image", FileService.getFilePath(getThumbPath(collectionId)));
        }

        //Community List 조회
        ThemeDisplay attribute = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

        //Group group = attribute.getLayout().getGroup();
        List<Group> communityList = GroupLocalServiceUtil.getLayoutsGroups(group.getCompanyId(), group.getParentGroupId(), true, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
        model.addAttribute("communityList", communityList);

        return "dataSearch/collection/save_collection";
    }

    /**
     * Collection save.
     *
     * @param collection     the collection
     * @param actionRequest  the action request
     * @param actionResponse the action response
     * @param model          the model
     * @throws Exception the exception
     */
    @ActionMapping(value = "collectionSave")
    public void collectionSave(@ModelAttribute CollectionVo collection, ActionRequest actionRequest, ActionResponse actionResponse, Model model) throws Exception {

        log.debug("### collectionSave :::" + collection.toString());

        ServiceContext serviceContext = ServiceContextFactory.getInstance(CollectionController.class.getName(), actionRequest);

        int groupPermission = Integer.parseInt(actionRequest.getParameter("aUserRadio"));
        int communityPermission = Integer.parseInt(actionRequest.getParameter("groupRadio"));
        int userPermission = Integer.parseInt(actionRequest.getParameter("userRadio"));
        int guestPermission = Integer.parseInt(actionRequest.getParameter("guestRadio"));

        int permission = PermissionConstant.convertPerm(communityPermission, groupPermission, userPermission, guestPermission);
        collection.setAccessPolicy(permission);

        //boolean skipCurate = Boolean.parseBoolean(actionRequest.getParameter("skipCurate"));
        //collection.setSkipCurate(skipCurate);

        try {
            // TODO : Transaction : What if there is a failure

            Collection saveCollection = CollectionServiceUtil.save(collection, collection.getContributorIds(), collection.getAllowedUserIds(), serviceContext);
			long collectionId = saveCollection.getCollectionId();
            
			//image
			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
			File file = uploadRequest.getFile("uploadedFile");
			if(file.exists()){
				String folder = FileService.getCollectionSubPath(collectionId, FileService.LOC_IMAGE);
				String filePath = FileService.saveFile(file, folder) + File.separator + file.getName();
				FileService.renameFile(filePath, getThumbPath(collectionId));
			}

            SessionMessages.add(actionRequest, "success");
        } catch (PrincipalException e) {
            ErrorHandler.error(actionRequest, e);
        } catch (SystemException | PortalException e) {
            SessionErrors.add(actionRequest, e.getClass(), e.getMessage());
            SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
        }

        if (collection.getCollectionId() > 0) {
            String portletId = "datasearch_WAR_SDR_baseportlet";

            ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
            long plid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), portletId);
            PortletURL portletURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest), portletId, plid, PortletRequest.RENDER_PHASE);
            portletURL.setParameter("controller", "Collection");
            portletURL.setParameter("action", "collectionDetail");
            portletURL.setParameter("collectionId", Long.toString(collection.getCollectionId()));
            portletURL.setParameter("tabs", "Detail");

            actionResponse.sendRedirect(portletURL.toString());
        }

    }

    /**
     * Collection delete.
     *
     * @param actionRequest
     * @param actionResponse
     * @throws PortalException
     * @throws SystemException
     */
    @ActionMapping(value = "collectionDelete")
    private void collectionDelete(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException {

        try {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(CollectionController.class.getName(), actionRequest);

            long collectionId = GetterUtil.getLong(serviceContext.getAttribute("collectionId"));

            log.debug("### collectionDelete :::" + serviceContext.getAttribute("collectionId") + ":::" + GetterUtil.getLong(serviceContext.getAttribute("collectionId")));


            // TODO : Transaction : What if there is a failure
            CollectionServiceUtil.delete(collectionId, serviceContext);

            SessionMessages.add(actionRequest, "delete");

			String portletId = "datasearch_WAR_SDR_baseportlet";

			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long plid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), portletId);
			PortletURL portletURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest), portletId, plid, PortletRequest.RENDER_PHASE);

			actionResponse.sendRedirect(portletURL.toString());
        } catch (PrincipalException e) {
            ErrorHandler.error(actionRequest, e);
        } catch (SystemException | PortalException e) {
            System.out.println(e.getMessage());
            SessionErrors.add(actionRequest, e.getClass(), e.getMessage());
            SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
        }

    }


	@RenderMapping(params = "action=collectionInfoEdit")
	public String collectionInfoEdit(@RequestParam long collectionId, RenderRequest request, Model model) throws PortalException, SystemException {
		log.debug("### collectionInfoEdit ::: " + collectionId);

		if (collectionId > 0) {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(Collection.class.getName(), request);
			Collection collection = CollectionServiceUtil.getCollection(collectionId, serviceContext);
			model.addAttribute("vo", collection);

			String description = "";
			
			try {

				//html
				description = FileService.getHtmlFile(getHtmlPath(collectionId));
				
			} catch ( IOException e ) {
				log.error("collectionInfoEdit error: " + e.getMessage());
				ErrorHandler.error(request, e);
			}
			
			//html
			model.addAttribute("description", description);

			model.addAttribute("uploadImagePath", getHtmlFolder(collectionId));
		}

		return "dataSearch/collection/wiki_collection_edit";
	}

	@ActionMapping(value = "collectionInfoSave")
	public void saveData(ActionRequest request, ActionResponse response) throws SystemException, PortalException, IOException {
		log.debug("### collectionInfoSave ::: " );
		
		long collectionId = ParamUtil.getLong(request, "collectionId");
		String description = ParamUtil.getString(request, "description");
		log.debug("### collectionId ::: " +collectionId);

		try {

			//html
			File destFolder = new File(getHtmlFolder(collectionId));
			if (!destFolder.exists()) destFolder.mkdirs();
			BufferedWriter writer = new BufferedWriter(new FileWriter(getHtmlPath(collectionId)));
			writer.write(description);
			writer.close();
			
		} catch (IOException e) {
			log.error("collectionInfoSave error: " + e.getMessage());
			ErrorHandler.error(request, e);
		}
		
		//redirect detail
		if (collectionId > 0) {
			String portletId = "datasearch_WAR_SDR_baseportlet";

			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			long plid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), portletId);
			PortletURL portletURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(request), portletId, plid, PortletRequest.RENDER_PHASE);
			portletURL.setParameter("controller", "Collection");
			portletURL.setParameter("action", "collectionDetail");
			portletURL.setParameter("collectionId", Long.toString(collectionId));
			portletURL.setParameter("tabs", "Info");

			response.sendRedirect(portletURL.toString());
		}
	}

	@ResourceMapping(value = "uploadPaper")
	public void uploadPaper(ResourceRequest request, ResourceResponse response) throws IOException {
		log.debug("### CollectionController uploadPaper");

		JSONObject result = new JSONObject();
		try {

			UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);

			Long collectionId = ParamUtil.getLong(request, "collectionId");
			File file = uploadRequest.getFile("uploadPaper");
			if(file.exists()){
				String folder = FileService.getCollectionSubPath(collectionId, FileService.LOC_PAPER);
				String filePath = FileService.saveFile(file, folder) + File.separator + file.getName();
				FileService.renameFile(filePath, getPaperPath(collectionId));

				log.debug("### uploadPaper ::: " + getPaperPath(collectionId));
			}
			result.put("success", true);

		} catch (SystemException e) {
			result.put("error", e.getMessage());
			log.error(e.getMessage());
		}

		response.getWriter().print(result);
	}
	
	//----------------------------------------------------------------------------------------
	private String getHtmlFolder(long collectionId){
		return FileService.getCollectionSubPath(collectionId, FileService.LOC_HTML);
	}
	
	private String getHtmlPath(long collectionId){
		return FileService.getCollectionSubPath(collectionId, FileService.LOC_INDEX_HTML);
	}

	private String getThumbPath(long collectionId){
		return FileService.getCollectionSubPath(collectionId, FileService.LOC_IMAGE_THUMB);
	}

	private String getPaperPath(long collectionId){
		return FileService.getCollectionSubPath(collectionId, FileService.LOC_PAPER_PDF);
	}
	
	
}
