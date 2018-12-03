package com.sdr.community;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.portal.kernel.util.PortalClassInvoker;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.model.LayoutSet;
import com.liferay.portal.model.LayoutSetPrototype;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.GroupServiceUtil;
import com.liferay.portal.service.LayoutSetLocalServiceUtil;
import com.liferay.portal.service.LayoutSetPrototypeServiceUtil;
import com.liferay.portal.service.LayoutSetServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.RoleServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.service.UserGroupRoleServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.sites.util.SitesUtil;
import com.sdr.ac.PermissionConstant;
import com.sdr.common.portlet.SendEmail;
import com.sdr.common.util.SearchStaticInitalize;
import com.sdr.metadata.model.ReqMakeSite;
import com.sdr.metadata.service.ReqMakeSiteServiceUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * The type Community controller.
 */
@Controller
@RequestMapping(value = "VIEW")
public class CommunityController {

    private static Log _log = LogFactoryUtil.getLog(CommunityController.class);

    /**
     * Render string.
     *
     * @param request  the request
     * @param response the response
     * @return the string
     */
    @RenderMapping
    public String render(RenderRequest request, RenderResponse response) {
        _log.debug("### community render ###");
        return "community/list";
    }

    /**
     * List string.
     *
     * @param request  the request
     * @param response the response
     * @return the string
     */
    @RenderMapping(params = "action=list")
    public String list(RenderRequest request, RenderResponse response) {
        return "community/list";
    }

    /**
     * Request make site string.
     *
     * @param request  the request
     * @param response the response
     * @param model    the model
     * @return the string
     * @throws SystemException the system exception
     * @throws PortalException the portal exception
     */
    @RenderMapping(params = "action=requestMakeSite")
    public String requestMakeSite(RenderRequest request, RenderResponse response, Model model) throws SystemException, PortalException {
        _log.debug("### requestMakeSite ###");

        new SearchStaticInitalize(request);
        SearchContext searchContext = SearchStaticInitalize.getSearchContext(CommunityController.class);

        SearchContainer<ReqMakeSite> searchContainer = new SearchContainer<ReqMakeSite>(request, null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchStaticInitalize.getCur(), SearchStaticInitalize.getDelta(), response.createRenderURL(), null, "Data Empty");
        searchContext.setStart(searchContainer.getStart());
        searchContext.setEnd(searchContainer.getEnd());

        model.addAttribute("searchContainer", searchContainer);

        ServiceContext serviceContext = ServiceContextFactory.getInstance(ReqMakeSite.class.getName(), request);

        ThemeDisplay td = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        User user = td.getUser();

        long userId = user.getUserId();
        long scopeGroupId = td.getScopeGroupId();

        // 관리자 여부 판단
        boolean ownerBool = PermissionConstant.checkAdmin(serviceContext, scopeGroupId);

        // 관리자 인경우 전체 목록 / 아니면 본인이 신청한 목록
        List<ReqMakeSite> reqMakeSiteList = null;
        int count = 0;

        if (ownerBool) { // 관리자 전체 목록
            reqMakeSiteList = ReqMakeSiteServiceUtil.getReqMakeSites(searchContainer.getStart(), searchContainer.getEnd());
            count = reqMakeSiteList.size();
            model.addAttribute("owner", true);
        } else { // 본인이 신청한 목록
            reqMakeSiteList = ReqMakeSiteServiceUtil.getList(searchContainer.getStart(), searchContainer.getEnd(), userId);
            count = ReqMakeSiteServiceUtil.getCount(userId);
        }

        searchContainer.setResults(reqMakeSiteList);
        searchContainer.setTotal(count);

        return "community/reqView";
    }

    /**
     * Req site.
     *
     * @param actionRequest  the action request
     * @param actionResponse the action response
     * @param model          the model
     * @throws PortalException the portal exception
     * @throws SystemException the system exception
     */
    @ActionMapping(value = "reqSite")
    public void reqSite(ActionRequest actionRequest, ActionResponse actionResponse, Model model) throws PortalException, SystemException {

        ThemeDisplay td = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        User user = td.getUser();
        long userId = user.getUserId();

//		boolean signedIn = td.isSignedIn(); // 로그인 여부
//		_log.debug("signedIn == "+signedIn);

        String name = actionRequest.getParameter("name");
        String memberType = actionRequest.getParameter("memberType");
        String description = actionRequest.getParameter("description");
        String message = actionRequest.getParameter("message");

        ReqMakeSite vo = ReqMakeSiteServiceUtil.addReqMakeSite(name, memberType, description, message, userId);
        model.addAttribute("vo", vo);
        model.addAttribute("result", "request");

        // Send Email to Admin
        SendEmail.send_reqCommunity(vo);

        SessionMessages.add(actionRequest, "success");
        actionResponse.setRenderParameter("action", "success");

    }

    /**
     * Cancel request.
     *
     * @param actionRequest  the action request
     * @param actionResponse the action response
     * @param model          the model
     * @throws PortalException the portal exception
     * @throws SystemException the system exception
     */
    @ActionMapping(value = "cancelRequest")
    public void cancelRequest(ActionRequest actionRequest, ActionResponse actionResponse, Model model) throws PortalException, SystemException {
        String requestId = actionRequest.getParameter("cancelId");
        ReqMakeSite updatedVo = ReqMakeSiteServiceUtil.updateStatus(requestId, CommunityConstants.STATUS_CANCEL, "Canceled by user");

        model.addAttribute("vo", updatedVo);
        model.addAttribute("result", "cancel");
        SessionMessages.add(actionRequest, "success");
        actionResponse.setRenderParameter("action", "success");
    }

    /**
     * Confirm.
     *
     * @param actionRequest  the action request
     * @param actionResponse the action response
     * @param model          the model
     * @throws PortalException the portal exception
     * @throws SystemException the system exception
     */
    @ActionMapping(value = "confirm")
    public void confirm(ActionRequest actionRequest, ActionResponse actionResponse, Model model) throws PortalException, SystemException {
        String requestId = actionRequest.getParameter("requestId");
        long resultType = Long.parseLong(actionRequest.getParameter("resultType"));
        String answer = actionRequest.getParameter("answer");

        ReqMakeSite updatedVo = ReqMakeSiteServiceUtil.updateStatus(requestId, resultType, answer);
        _log.debug("updatedVo : " + updatedVo);

        if (resultType == CommunityConstants.STATUS_APPROVE) makeSite(actionRequest, updatedVo);

        model.addAttribute("vo", updatedVo);
        model.addAttribute("result", resultType == CommunityConstants.STATUS_APPROVE ? "approve" : "reject");

        // Send Email
        SendEmail.send_confirmCommunity(updatedVo);

        SessionMessages.add(actionRequest, "success");
        actionResponse.setRenderParameter("action", "success");
    }

    /**
     * Make site.
     *
     * @param actionRequest the action request
     * @param reqVo         the req vo
     */
    public void makeSite(ActionRequest actionRequest, ReqMakeSite reqVo) {
        _log.debug("### makeSite Renderer ###");

        HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
        ServletContext servletContext = request.getSession().getServletContext();

        String siteName = reqVo.getName();
        String siteDesc = reqVo.getDescription();
        long userId = reqVo.getUserId();
        int siteType = (int) reqVo.getSiteType();

        int publicLayoutSetPrototypeId = 0;
        int privateLayoutSetPrototypeId = 0;

        try {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(Group.class.getName(), actionRequest);
            Group grp = null;
            try {
                grp = GroupServiceUtil.getGroup(serviceContext.getThemeDisplay().getCompanyId(), siteName);
            } catch (Exception e) {

            }

            // create site
            if (grp == null) {
                // TODO : under guest ? or global ?
                grp = GroupServiceUtil.addGroup(GroupConstants.DEFAULT_PARENT_GROUP_ID, GroupConstants.DEFAULT_LIVE_GROUP_ID, siteName, siteDesc,
//                        GroupConstants.TYPE_SITE_RESTRICTED,
                        siteType,
                        true, GroupConstants.DEFAULT_MEMBERSHIP_RESTRICTION,
                        "/" + siteName, true, true, serviceContext);
            }

            // default community template 선택
            // 미리 만들어 놓은 'default Community' 라는 이름의 template가 있어야함
            List<LayoutSetPrototype> layoutSetPrototypes = LayoutSetPrototypeServiceUtil.search(serviceContext.getThemeDisplay().getCompanyId(), Boolean.TRUE, null);
            for (LayoutSetPrototype layoutSetPrototype : layoutSetPrototypes) {
                if (layoutSetPrototype.getName("").toLowerCase().equals("default community template")) {
                    publicLayoutSetPrototypeId = (int) layoutSetPrototype.getLayoutSetPrototypeId();
                    _log.debug("public pages template id :" + publicLayoutSetPrototypeId);
                }
            }

            // 생성한 site template 적용
            MethodKey methodKey = new MethodKey(SitesUtil.class, "updateLayoutSetPrototypesLinks", Group.class, long.class, long.class, boolean.class, boolean.class);
            PortalClassInvoker.invoke(true, methodKey, grp, publicLayoutSetPrototypeId, privateLayoutSetPrototypeId, true, false);
            LayoutSet layoutSet = LayoutSetLocalServiceUtil.getLayoutSet(grp.getGroupId(), false);
            MethodKey _mergeLayoutSetPrototypeLayoutsMethodKey = new MethodKey(SitesUtil.class, "mergeLayoutSetPrototypeLayouts", Group.class, LayoutSet.class);
            PortalClassInvoker.invoke(true, _mergeLayoutSetPrototypeLayoutsMethodKey, grp, layoutSet);

            // 생성 요청자를 site의 관리자로 권한 변경
            UserLocalServiceUtil.addGroupUser(grp.getGroupId(), userId);
            Role role = RoleServiceUtil.getRole(grp.getCompanyId(), RoleConstants.SITE_ADMINISTRATOR);
            long[] roles = new long[]{role.getRoleId()};
            UserGroupRoleServiceUtil.addUserGroupRoles(userId, grp.getGroupId(), roles);

            // site의 기본 대문이미지 적용
            java.io.File file = new java.io.File(servletContext.getRealPath("/images/community/img_sdr_logo_cm.jpg"));
            LayoutSetServiceUtil.updateLogo(grp.getGroupId(), false, true, file);

            _log.debug("success");

        } catch (PortalException e) {
            e.printStackTrace();
        } catch (SystemException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Req confirm popup string.
     *
     * @param request  the request
     * @param response the response
     * @param model    the model
     * @return the string
     * @throws SystemException the system exception
     * @throws PortalException the portal exception
     */
    @RenderMapping(params = "action=reqConfirmPopup")
    public String reqConfirmPopup(RenderRequest request, RenderResponse response, Model model) throws SystemException, PortalException {
        _log.debug("### reqConfirmPopup ###");

        String requestId = request.getParameter("requestId");
        String popupId = request.getParameter("popupId");
        ReqMakeSite vo = ReqMakeSiteServiceUtil.getReqMakeSite(Long.parseLong(requestId));

        model.addAttribute("vo", vo);
        model.addAttribute("popupId", popupId);
        return "community/confirmPopup";
    }

    /**
     * Detail popup string.
     *
     * @param request  the request
     * @param response the response
     * @param model    the model
     * @return the string
     * @throws SystemException the system exception
     * @throws PortalException the portal exception
     */
    @RenderMapping(params = "action=detailPopup")
    public String detailPopup(RenderRequest request, RenderResponse response, Model model) throws SystemException, PortalException {
        _log.debug("### detailPopup ###");

        String requestId = request.getParameter("requestId");
        String popupId = request.getParameter("popupId");
        ReqMakeSite vo = ReqMakeSiteServiceUtil.getReqMakeSite(Long.parseLong(requestId));

        model.addAttribute("vo", vo);
        model.addAttribute("popupId", popupId);
        return "community/detailPopup";
    }

    /**
     * Success string.
     *
     * @param request  the request
     * @param response the response
     * @param model    the model
     * @return the string
     */
    @RenderMapping(params = "action=success")
    public String success(RenderRequest request, RenderResponse response, Model model) {
        SessionMessages.add(request, "success");
        return "community/success";
    }


}
