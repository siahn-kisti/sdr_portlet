package com.sdr.bbs.bbs;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.util.Encryptor;
import com.sdr.bbs.common.model.BbsPostVo;
import com.sdr.bbs.common.util.BbsDisplayTypeConstants;
import com.sdr.bbs.common.util.FileManagerUtil;
import com.sdr.bbs.common.util.SearchStaticInitalize;
import com.sdr.bbs.common.util.SendEmail;
import com.sdr.bbs.model.Bbs;
import com.sdr.bbs.model.BbsComment;
import com.sdr.bbs.model.BbsPost;
import com.sdr.bbs.service.BbsCommentLocalServiceUtil;
import com.sdr.bbs.service.BbsLocalServiceUtil;
import com.sdr.bbs.service.BbsPostLocalServiceUtil;
import com.sdr.bbs.util.BbsPermission;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletModeException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.WindowStateException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The type Bbs controller.
 */
@Controller
@RequestMapping("VIEW")
public class BbsController {

    private static Log _log = LogFactoryUtil.getLog(BbsController.class);

    /**
     * Render string.
     *
     * @param request  the request
     * @param response the response
     * @param model    the model
     * @return the string
     * @throws SystemException      the system exception
     * @throws PortalException      the portal exception
     * @throws WindowStateException the window state exception
     * @throws PortletModeException the portlet mode exception
     */
    @RenderMapping
    public String render(RenderRequest request, RenderResponse response, Model model) throws SystemException, PortalException, WindowStateException, PortletModeException {
        _log.debug("#### bbs render ####");

        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        boolean hasPermission = BbsPermission.hasPortletPermission(themeDisplay, themeDisplay.getPortletDisplay().getId(), StringUtil.upperCase("view"));
        model.addAttribute("hasPermission", hasPermission);

        PortletPreferences portletPreferences = request.getPreferences();
        long prefBbsId = GetterUtil.getLong(portletPreferences.getValue("prefBbsId", "0"));

        Bbs bbs = BbsLocalServiceUtil.getBbs(prefBbsId);
        request.setAttribute("bbs", bbs);

        new SearchStaticInitalize(request);
        SearchContext searchContext = SearchStaticInitalize.getSearchContext(BbsController.class);

        SearchContainer<BbsPostVo> searchContainer = new SearchContainer<BbsPostVo>(request, null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchStaticInitalize.getCur(), SearchStaticInitalize.getDelta(), response.createRenderURL(), null, "Data Empty");
        searchContext.setStart(searchContainer.getStart());
        searchContext.setEnd(searchContainer.getEnd());

        model.addAttribute("searchContainer", searchContainer);

        List<BbsPostVo> voList = new ArrayList<>();
        int postCnt = 0;

        if (Validator.isNotNull(bbs)) {
            String keyword = ParamUtil.getString(request, "keyword");
            List<BbsPost> list = BbsPostLocalServiceUtil.getList(searchContainer.getStart(), searchContainer.getEnd(), keyword, bbs.getBbsId());
            postCnt = BbsPostLocalServiceUtil.getCount(keyword, bbs.getBbsId());

            BbsPostVo vo = null;
            if (bbs.getDisplayType() == BbsDisplayTypeConstants.IMAGE) {
                if (Validator.isNotNull(list) && list.size() > 0) {
                    for (BbsPost each : list) {
                        vo = new BbsPostVo();
                        BeanUtils.copyProperties(each, vo);
                        vo.setImgType(BbsDisplayTypeConstants.IMG_TYPE_EMPTY);

                        long fileEntryId = 0L;
                        List<DLFileEntry> fileEntries = FileManagerUtil.getFileEntries(themeDisplay, each.getPostId());
                        if (Validator.isNotNull(fileEntries) && fileEntries.size() > 0) {
                            for (DLFileEntry fileEntry : fileEntries) {
                                if (fileEntry.getMimeType().startsWith("image/")) {
                                    fileEntryId = fileEntry.getFileEntryId();
                                    vo.setFirstFileId(fileEntryId);
                                    vo.setImgType(BbsDisplayTypeConstants.IMG_TYPE_ID);
                                    break;
                                }
                            }
                        }

                        String imgSrc = "";
                        if (fileEntryId == 0L) {
                            imgSrc = com.sdr.bbs.common.util.HtmlUtil.getFirstAttributeValueByTagName(each.getContent(), "img", "src");
                            if (Validator.isNotNull(imgSrc)) {
                                vo.setImgSrc(imgSrc);
                                vo.setImgType(BbsDisplayTypeConstants.IMG_TYPE_URL);
                            }
                        }

                        voList.add(vo);
                    }

                }

            } else {
                copyProperties(list, voList);
            }
        }

        searchContainer.setResults(voList);
        searchContainer.setTotal(postCnt);

        return "bbs/bbs/view";
    }

    /**
     * Detail string.
     *
     * @param request  the request
     * @param response the response
     * @param model    the model
     * @return the string
     * @throws SystemException the system exception
     * @throws PortalException the portal exception
     */
    @RenderMapping(params = "action=detail")
    public String detail(RenderRequest request, RenderResponse response, Model model) throws SystemException, PortalException {
        _log.debug("### SDR BBS detail render ###");

        PortletPreferences portletPreferences = request.getPreferences();
        long prefBbsId = GetterUtil.getLong(portletPreferences.getValue("prefBbsId", "0"));
        Bbs bbs = BbsLocalServiceUtil.getBbs(prefBbsId);
        request.setAttribute("bbs", bbs);

        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        String action = ParamUtil.getString(request, "action", "detail");
        Long bbsId = ParamUtil.getLong(request, "bbsId");

        boolean hasPermission = false;

        if ((action.equals("detail")) || (Validator.isNull(action))) {
            hasPermission = BbsPermission.hasPortletPermission(themeDisplay, themeDisplay.getPortletDisplay().getId(), StringUtil.upperCase("view"));
        } else {
            hasPermission = false;
        }
        if (hasPermission) {
            if (bbsId > 0L) {
                long companyId = themeDisplay.getCompanyId();
                long groupId = themeDisplay.getScopeGroupId();
                try {
                    if ((bbs.getCompanyId() != companyId) || (bbs.getGroupId() != groupId)) {
                        bbs = null;
                    }

                    boolean hasModelPermission = false;
                    if (action.equals("detail")) {
                        long postId = ParamUtil.getLong(request, "postId", 0L);

                        BbsPost post = null;
                        List<BbsComment> postComments = null;
                        BbsComment postComment = null;

                        if (postId > 0L) {
                            try {
                                post = BbsPostLocalServiceUtil.getBbsPost(postId);
                                if (post.getBbsId() == bbs.getBbsId()) {
                                    hasModelPermission = BbsPermission.hasModelPermission(themeDisplay, Bbs.class.getName(), bbs.getBbsId(), StringUtil.upperCase("detail"));
                                    if (hasModelPermission && post.isSecret()) {
                                        hasModelPermission = false;
                                        if (BbsPermission.hasModelPermission(themeDisplay, Bbs.class.getName(), bbs.getBbsId(), StringUtil.upperCase("configuration"))) {
                                            hasModelPermission = true;
                                        } else if (post.getUserId() == themeDisplay.getUserId()) {
                                            if (themeDisplay.isSignedIn()) {
                                                hasModelPermission = true;
                                            }
                                        }
                                    }

                                    if (hasModelPermission) {
                                        post.setViewCount(post.getViewCount() + 1);
                                        post = BbsPostLocalServiceUtil.updateBbsPost(post);

                                        if (Validator.isNotNull(post)) {
                                            long commentId = ParamUtil.getLong(request, "commentId", 0L);
                                            if (commentId > 0L) {
                                                postComment = BbsCommentLocalServiceUtil.getBbsComment(commentId);
                                                if (postComment.getPostId() == post.getPostId()) {
                                                    hasModelPermission = BbsPermission.hasModelPermission(themeDisplay,
                                                            Bbs.class.getName(), bbs.getBbsId(), StringUtil.upperCase("comment"));
                                                    if (hasModelPermission) {
                                                        hasModelPermission = false;
                                                        if (BbsPermission.hasModelPermission(themeDisplay, Bbs.class.getName(), bbs.getBbsId(), StringUtil.upperCase("configuration"))) {
                                                            hasModelPermission = true;
                                                        } else if (postComment.getUserId() == themeDisplay.getUserId()) {
                                                            if (themeDisplay.isSignedIn()) {
                                                                hasModelPermission = true;
                                                            } else {
                                                                String password = (String) request.getPortletSession().getAttribute(
                                                                        BbsController.class.getName() + "_cpwd_" + commentId);
                                                                if ((Validator.isNotNull(password)) && (postComment.getPassword().equals(password))) {
                                                                    hasModelPermission = true;
                                                                }
                                                            }
                                                        }
                                                        if (!hasModelPermission) {
                                                            postComment = null;
                                                        }
                                                    } else {
                                                        postComment = null;
                                                    }
                                                } else {
                                                    postComment = null;
                                                }
                                            }
                                            postComments = post.getBbsComments();

                                            long authCommentId = ParamUtil.getLong(request, "authCommentId", 0L);
                                            if (authCommentId > 0L) {
                                                model.addAttribute("authCommentId", authCommentId);
                                            }


                                            List<DLFileEntry> fileEntries = FileManagerUtil.getFileEntries(themeDisplay, post.getPostId());

                                            long fileEntryId = 0L;
                                            if (Validator.isNotNull(fileEntries) && fileEntries.size() > 0) {
                                                for (DLFileEntry fileEntry : fileEntries) {
                                                    if (fileEntry.getMimeType().startsWith("image/")) {
                                                        fileEntryId = fileEntry.getFileEntryId();
                                                        model.addAttribute("detailMainImageId", fileEntryId);
                                                        break;
                                                    }
                                                }
                                            }

                                            model.addAttribute("fileEntries", fileEntries);

                                        }
                                    } else {
                                        bbs = null;
                                        post = null;
                                    }
                                } else {
                                    bbs = null;
                                    post = null;
                                }
                            } catch (Exception e) {
                                _log.debug(e.toString());
                            }
//                            _log.debug(e.toString());
                        } else {
                            bbs = null;
                        }

                        model.addAttribute("post", post);
                        model.addAttribute("postComment", postComment);
                        model.addAttribute("postComments", postComments);
                    }
                    model.addAttribute("bbs", bbs);
                    model.addAttribute("defaultUserId", UserLocalServiceUtil.getDefaultUserId(bbs.getCompanyId()));
                    model.addAttribute("hasPermComment", BbsPermission.hasModelPermission(themeDisplay, Bbs.class.getName(), bbs.getBbsId(), StringUtil.upperCase("configuration")));
                } catch (Exception e) {
                    _log.debug(e.toString());
                }
            }
        }

        boolean signedIn = themeDisplay.isSignedIn();

        if (signedIn == true)

        {
            model.addAttribute("user", themeDisplay.getUser());
        }

        model.addAttribute("isSignedIn", signedIn);
        model.addAttribute("hasPermission", hasPermission);

        return "bbs/bbs/detail/view";
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
    @RenderMapping(params = "action=edit")
    public String requestMakeSite(RenderRequest request, RenderResponse response, Model model) throws SystemException, PortalException {
        _log.debug("### edit render ###");

        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        PortletPreferences portletPreferences = request.getPreferences();

        String action = ParamUtil.getString(request, "action", "edit");
        long prefBbsId = GetterUtil.getLong(portletPreferences.getValue("prefBbsId", "0"));

        if (prefBbsId > 0L) {
            long companyId = themeDisplay.getCompanyId();
            long groupId = themeDisplay.getScopeGroupId();

            try {
                Bbs bbs = BbsLocalServiceUtil.getBbs(prefBbsId);
                request.setAttribute("bbs", bbs);

                boolean hasPermission = false;
                //////////////////////////////////////////////////////////////////////////////////////////////////////////////
                if ((action.equals("edit")) || (Validator.isNull(action))) {
                    hasPermission = BbsPermission.hasPortletPermission(themeDisplay, themeDisplay.getPortletDisplay().getId(), StringUtil.upperCase("edit"));
                } else {
                    hasPermission = false;
                }

//                if (!hasPermission) {
//                    action = "access_denied";
//                }
                //////////////////////////////////////////////////////////////////////////////////////////////////////////////
                boolean hasModelPermission = false;

                hasModelPermission = BbsPermission.hasModelPermission(themeDisplay, Bbs.class.getName(),
                        bbs.getBbsId(), com.liferay.portal.kernel.util.StringUtil.upperCase("edit"));

                if (hasModelPermission) {
                    long postId = ParamUtil.getLong(request, "postId");

                    BbsPost post = null;

                    if (postId > 0L) {
                        try {
                            post = BbsPostLocalServiceUtil.getBbsPost(postId);

                            if (post.getBbsId() == bbs.getBbsId()) {
                                hasModelPermission = false;

                                if (BbsPermission.hasModelPermission(themeDisplay, Bbs.class.getName(), bbs.getBbsId(),
                                        com.liferay.portal.kernel.util.StringUtil.upperCase("configuration"))) {
                                    hasModelPermission = true;
                                } else if (post.getUserId() == themeDisplay.getUserId()) {
                                    if (themeDisplay.isSignedIn()) {
                                        hasModelPermission = true;
                                    } else {
                                        hasModelPermission = false;
                                    }

                                }

                                if (!hasModelPermission) {
                                    bbs = null;
                                    post = null;
                                } else {
                                    request.setAttribute("post", post);

                                    List<DLFileEntry> fileEntries = FileManagerUtil.getFileEntries(themeDisplay, post.getPostId());
                                    model.addAttribute("fileEntries", fileEntries);

                                }
                            } else {
                                bbs = null;
                                post = null;
                            }
                        } catch (Exception e) {
                            if (_log.isDebugEnabled()) _log.debug(e.toString());

                        }

                    }

                } else {
                    bbs = null;
                }

                boolean signedIn = themeDisplay.isSignedIn();

                if (signedIn == true) {
                    model.addAttribute("user", themeDisplay.getUser());
                }

                model.addAttribute("isSignedIn", signedIn);
                model.addAttribute("hasPermission", hasPermission && hasModelPermission);

            } catch (Exception e) {
                if (_log.isDebugEnabled()) _log.debug(e.toString());
            }
        }
        return "bbs/bbs/edit/view";
    }


    /**
     * Save.
     *
     * @param actionRequest  the action request
     * @param actionResponse the action response
     * @param vo             the vo
     * @param model          the model
     * @throws PortalException the portal exception
     * @throws SystemException the system exception
     */
    @ActionMapping(value = "save")
    public void save(ActionRequest actionRequest, ActionResponse actionResponse,
                     @ModelAttribute BbsPostVo vo, Model model) throws PortalException, SystemException {

        _log.debug("### save render ###");

        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute("LIFERAY_SHARED_THEME_DISPLAY");
        UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
        PortletPreferences portletPreferences = actionRequest.getPreferences();
        String action = ParamUtil.getString(actionRequest, "action", "edit");

        long prefBbsId = GetterUtil.getLong(portletPreferences.getValue("prefBbsId", "0"));
        vo.setBbsId(prefBbsId);

        Bbs bbs = BbsLocalServiceUtil.getBbs(prefBbsId);
        BbsPost post = null;

        boolean hasModelPermission = BbsPermission.hasModelPermission(themeDisplay, Bbs.class.getName(), bbs.getBbsId(), com.liferay.portal.kernel.util.StringUtil.upperCase("edit"));
        long userId = themeDisplay.getUserId();

        if (hasModelPermission) {
            try {
                Date newDate = new Date();
                long postId = vo.getPostId();

                if (postId > 0L) {
                    post = BbsPostLocalServiceUtil.getBbsPost(postId);

                    hasModelPermission = false;

                    if (BbsPermission.hasModelPermission(themeDisplay, Bbs.class.getName(), bbs.getBbsId(),
                            com.liferay.portal.kernel.util.StringUtil.upperCase("configuration"))) {
                        hasModelPermission = true;

                    } else if (post.getUserId() == themeDisplay.getUserId()) {
                        if (themeDisplay.isSignedIn()) hasModelPermission = true;
                        else hasModelPermission = false;
                    }

                    if (hasModelPermission) {
                        if (post.getBbsId() == bbs.getBbsId()) {
                            post.setTitle(vo.getTitle());
                            post.setContent(vo.getContent());
                            post.setSecret(vo.getSecret());
                            post.setCommentEmailed(vo.getCommentEmailed());
                            post.setModifiedDate(newDate);

                            BbsPostLocalServiceUtil.updateBbsPost(post);
                        }
                    }
                } else {
                    postId = CounterLocalServiceUtil.increment(BbsPost.class.getName());
                    post = BbsPostLocalServiceUtil.createBbsPost(postId);

                    BeanUtils.copyProperties(vo, post);

                    post.setPostId(postId);
                    post.setUserId(userId);
                    post.setCreateDate(newDate);

                    BbsPostLocalServiceUtil.addBbsPost(post);
                }

            } catch (Exception e) {
                if (_log.isDebugEnabled()) _log.debug(e.toString());
            }

            // file upload
            FileManagerUtil.fileUpload(actionRequest, themeDisplay, post.getPostId());

            // file delete
            String delFileIds = com.liferay.portal.kernel.util.StringUtil.trim(ParamUtil.getString(uploadPortletRequest, "delFileIds"));
            if (Validator.isNotNull(delFileIds)) {
                List delFileIdList = com.sdr.bbs.common.util.StringUtil.getStringListFromString(delFileIds, ",");
                if ((Validator.isNotNull(delFileIdList)) && (delFileIdList.size() > 0)) {
                    for (int i = 0; i < delFileIdList.size(); i++) {
                        FileManagerUtil.deleteFileEntry(themeDisplay, post.getPostId(), Long.parseLong((String) delFileIdList.get(i)));
                    }
                }

            }
        }

        if (!hasModelPermission) SessionMessages.add(actionRequest, "denied");
        else SessionMessages.add(actionRequest, "success");

        PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest), "sdr_bbsportlet_WAR_SDR_bbsportlet", themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
        try {
            actionResponse.sendRedirect(redirectURL.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Delete.
     *
     * @param actionRequest  the action request
     * @param actionResponse the action response
     * @param model          the model
     * @throws PortalException the portal exception
     * @throws SystemException the system exception
     */
    @ActionMapping(value = "delete")
    public void delete(ActionRequest actionRequest, ActionResponse actionResponse, Model model) throws PortalException, SystemException {

        _log.debug("### delete render ###");

        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute("LIFERAY_SHARED_THEME_DISPLAY");
        UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
        PortletPreferences portletPreferences = actionRequest.getPreferences();

        long prefBbsId = GetterUtil.getLong(portletPreferences.getValue("prefBbsId", "0"));
        Bbs bbs = BbsLocalServiceUtil.getBbs(prefBbsId);
        long postId = ParamUtil.getLong(actionRequest, "postId");

        boolean hasModelPermission = BbsPermission.hasModelPermission(themeDisplay, Bbs.class.getName(), bbs.getBbsId(), com.liferay.portal.kernel.util.StringUtil.upperCase("edit"));
        if (hasModelPermission) {
            BbsPost bbsPost = BbsPostLocalServiceUtil.deleteBbsPost(postId);
            FileManagerUtil.deleteFileEntriesInFolder(themeDisplay, postId);

            SessionMessages.add(actionRequest, "delete");

            PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest), "sdr_bbsportlet_WAR_SDR_bbsportlet", themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
            try {
                actionResponse.sendRedirect(redirectURL.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    /**
     * File down.
     *
     * @param resourceRequest  the resource request
     * @param resourceResponse the resource response
     */
    @ResourceMapping(value = "fileDown")
    public void fileDown(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {

        ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute("LIFERAY_SHARED_THEME_DISPLAY");
        String portletName = (String) resourceRequest.getAttribute("PORTLET_ID");
        PortletPreferences portletPreferences = resourceRequest.getPreferences();

        long thumbnailBool = ParamUtil.getLong(resourceRequest, "thumbnailBool");

        boolean hasPermission = false;
        hasPermission = BbsPermission.hasPortletPermission(themeDisplay, portletName, com.liferay.portal.kernel.util.StringUtil.upperCase("view"));

        if (hasPermission || thumbnailBool == 1) {
            try {
                long messageId = ParamUtil.getLong(resourceRequest, "postId");
                long prefBbsId = GetterUtil.getLong(portletPreferences.getValue("prefBbsId", "0"));

                long companyId = themeDisplay.getCompanyId();
                long groupId = themeDisplay.getScopeGroupId();

                Bbs bbs = BbsLocalServiceUtil.getBbs(prefBbsId);

                if ((bbs.getCompanyId() == companyId) && (bbs.getGroupId() == groupId)) {
                    if (messageId > 0L) {
                        BbsPost message = BbsPostLocalServiceUtil.getBbsPost(messageId);

                        if (message.getBbsId() == bbs.getBbsId()) {
                            boolean hasModelPermission = false;
                            long fileId = ParamUtil.getLong(resourceRequest, "fileId");

                            if (fileId > 0L) {
                                hasModelPermission = BbsPermission.hasModelPermission(themeDisplay, Bbs.class.getName(), bbs.getBbsId(),
                                        com.liferay.portal.kernel.util.StringUtil.upperCase("detail"));

                                if (hasModelPermission || thumbnailBool == 1) {
                                    HttpServletResponse response = PortalUtil.getHttpServletResponse(resourceResponse);
                                    HttpServletRequest request = PortalUtil.getHttpServletRequest(resourceRequest);

                                    FileManagerUtil.downloadFile(response, request, themeDisplay, fileId);
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                if (_log.isDebugEnabled()) _log.debug(e.toString());
            }

        }

    }
/*

    @RenderMapping(params = "action=success")
    public String success(RenderRequest request, RenderResponse response, Model model) {
        SessionMessages.add(request, "success");
        return "bbs/bbs/success";
    }
*/


    /**
     * Copy properties list.
     *
     * @param list       the list
     * @param targetList the target list
     * @return the list
     */
    public List<BbsPostVo> copyProperties(List<BbsPost> list, List<BbsPostVo> targetList) {
        BbsPostVo vo = null;
        for (BbsPost each : list) {
            vo = new BbsPostVo();
            BeanUtils.copyProperties(each, vo);
            targetList.add(vo);
        }
        return targetList;
    }

    /**
     * Comment edit.
     *
     * @param request  the request
     * @param response the response
     * @throws IOException the io exception
     */
    @ActionMapping(value = "commentEdit")
    public void commentEdit(ActionRequest request, ActionResponse response) throws IOException {

        _log.debug("### SDR BBS Comment Save ###");

        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

        long bbsId = ParamUtil.getLong(request, "bbsId");
        long postId = ParamUtil.getLong(request, "postId");
        long commentId = ParamUtil.getLong(request, "commentId");

        boolean isValidated = true;

        Date createDate = new Date();
        Date modifiedDate = new Date();
        String writer = StringUtil.trim(ParamUtil.getString(request, "writer"));
        String email = StringUtil.trim(ParamUtil.getString(request, "email"));
        String password = StringUtil.trim(ParamUtil.getString(request, "password"));
        String content = StringUtil.trim(ParamUtil.getString(request, "content"));
        boolean secret = ParamUtil.getBoolean(request, "secret");

        if (themeDisplay.isSignedIn()) {
            User user = themeDisplay.getUser();
            writer = user.getFullName();
            email = user.getEmailAddress();
        } else {
            try {
                password = Encryptor.encrypt(themeDisplay.getCompany().getKeyObj(), password);
            } catch (Exception e) {
                if (_log.isDebugEnabled()) {
                    _log.debug(e.toString());
                }
                password = "";
            }
        }
        if ((commentId == 0L) && (Validator.isNull(writer))) {
            isValidated = false;
        } else if ((commentId == 0L) && (Validator.isNull(email)) && (!themeDisplay.isSignedIn())) {
            isValidated = false;
        } else if ((commentId == 0L) && (Validator.isNull(password)) && (!themeDisplay.isSignedIn())) {
            isValidated = false;
        }
        if (isValidated) {
            long companyId = themeDisplay.getCompanyId();
            long groupId = themeDisplay.getScopeGroupId();
            try {
                Bbs bbs = BbsLocalServiceUtil.getBbs(bbsId);


                boolean hasModelPermission = BbsPermission.hasModelPermission(themeDisplay, Bbs.class.getName(), bbs.getBbsId(), StringUtil.upperCase("comment"));

                BbsPost bbsPost = BbsPostLocalServiceUtil.getBbsPost(postId);

                BbsComment comment = null;
                if (commentId > 0L) {
                    comment = BbsCommentLocalServiceUtil.getBbsComment(commentId);

                    hasModelPermission = false;
                    if (BbsPermission.hasModelPermission(themeDisplay, Bbs.class.getName(), bbs.getBbsId(), StringUtil.upperCase("configuration"))) {
                        hasModelPermission = true;
                    } else if (comment.getUserId() == themeDisplay.getUserId()) {
                        if (themeDisplay.isSignedIn()) {
                            hasModelPermission = true;
                        } else {
                            password = (String) request.getPortletSession().getAttribute(
                                    BbsController.class.getName() + "_cpwd_" + commentId);
                            if ((Validator.isNotNull(password)) && (comment.getPassword().equals(password))) {
                                hasModelPermission = true;
                            }
                        }
                    }
                    if (hasModelPermission) {
                        if (comment.getPostId() == bbsPost.getPostId()) {
                            comment.setModifiedDate(modifiedDate);
                            comment.setContent(content);
                            comment.setSecret(secret);

                            BbsCommentLocalServiceUtil.updateBbsComment(comment);

                        } else {
                            comment = null;
                        }
                    } else {
                        comment = null;
                    }
                } else {
                    commentId = CounterLocalServiceUtil.increment(BbsComment.class.getName());

                    comment = BbsCommentLocalServiceUtil.createBbsComment(commentId);

                    comment.setPostId(postId);
                    comment.setUserId(themeDisplay.getUserId());
                    comment.setCreateDate(createDate);
                    comment.setModifiedDate(modifiedDate);
                    comment.setWriter(writer);
                    comment.setEmail(email);

                    if (!themeDisplay.isSignedIn()) {
                        comment.setPassword(password);
                    } else {
                        comment.setPassword(null);
                    }
                    comment.setContent(content);
                    comment.setSecret(secret);

                    BbsCommentLocalServiceUtil.addBbsComment(comment);

                    if (!themeDisplay.isSignedIn()) {
                        request.getPortletSession().setAttribute(BbsController.class.getName() + "_cpwd_" + commentId, password);
                    }

                    if (bbsPost.isCommentEmailed()) {
                        _log.debug("###  : comment send email !!");

                        // send email
                        User user = UserLocalServiceUtil.getUser(bbsPost.getUserId());
                        String subject = "Your post has been commented.";
                        String body = "Post Infomation\n";
                        body += "--------------------" + "\n";
                        body += "Board Name : " + bbs.getTitle() + "\n";
                        ;
                        body += "Title : " + bbsPost.getTitle() + "\n\n\n";
                        ;

                        User commentUser = UserLocalServiceUtil.getUser(comment.getUserId());
                        body += "Comment Infomation" + "\n";
                        body += "--------------------" + "\n";
                        body += "User : " + commentUser.getFullName() + "\n";
                        body += "Email : " + commentUser.getEmailAddress() + "\n";
                        body += "Contents : " + comment.getContent() + "\n";
                        body += "Commented Date : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(comment.getModifiedDate()) + "\n";

                        SendEmail.sendFromAdmin(subject, body, user);
                    }
                }

                SessionMessages.add(request, "sdr_bbs.bbscomment-save-successfully");
            } catch (Exception e) {
                if (_log.isDebugEnabled()) {
                    _log.debug(e.toString());
                }
                SessionErrors.add(request, "sdr_bbs.bbscomment-save-fail");
            }
        } else {
            SessionErrors.add(request, "sdr_bbs.bbscomment-save-fail-to-required-input");
        }

        PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(request), "sdr_bbsportlet_WAR_SDR_bbsportlet", themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
        redirectURL.setParameter("action", "detail");
        redirectURL.setParameter("bbsId", Long.toString(bbsId));
        redirectURL.setParameter("postId", Long.toString(postId));
        response.sendRedirect(redirectURL.toString());
    }

    /**
     * Comment delete.
     *
     * @param request  the request
     * @param response the response
     * @throws IOException the io exception
     */
    @ActionMapping(value = "commentDelete")
    public void commentDelete(ActionRequest request, ActionResponse response) throws IOException {

        _log.debug("### SDR BBS Comment Delete ###");

        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

        long bbsId = ParamUtil.getLong(request, "bbsId");
        long postId = ParamUtil.getLong(request, "postId");
        long commentId = ParamUtil.getLong(request, "commentId");

        if ((bbsId > 0L) && (postId > 0L) && (commentId > 0L)) {
            long companyId = themeDisplay.getCompanyId();
            long groupId = themeDisplay.getScopeGroupId();
            try {
                Bbs bbs = BbsLocalServiceUtil.getBbs(bbsId);
                if ((bbs.getCompanyId() == companyId) && (bbs.getGroupId() == groupId)) {
                    boolean hasModelPermission = BbsPermission.hasModelPermission(themeDisplay, Bbs.class.getName(), bbs.getBbsId(), StringUtil.upperCase("detail"));
                    if (hasModelPermission) {
                        BbsPost bbsPost = BbsPostLocalServiceUtil.getBbsPost(postId);
                        if (bbsPost.getBbsId() == bbs.getBbsId()) {
                            BbsComment comment = BbsCommentLocalServiceUtil.getBbsComment(commentId);
                            if (bbsPost.getPostId() == comment.getPostId()) {
                                hasModelPermission = false;
                                if (BbsPermission.hasModelPermission(themeDisplay, Bbs.class.getName(), bbs.getBbsId(), StringUtil.upperCase("configuration"))) {
                                    hasModelPermission = true;
                                } else if (comment.getUserId() == themeDisplay.getUserId()) {
                                    if (themeDisplay.isSignedIn()) {
                                        hasModelPermission = true;
                                    } else {
                                        String password = (String) request.getPortletSession().getAttribute(
                                                BbsController.class.getName() + "_cpwd_" + commentId);
                                        if ((Validator.isNotNull(password)) && (comment.getPassword().equals(password))) {
                                            hasModelPermission = true;
                                        }
                                    }
                                }
                                if (hasModelPermission) {

                                    BbsCommentLocalServiceUtil.deleteBbsComment(comment);

                                    SessionMessages.add(request, "sdr_bbs.bbscomment-delete-successfully");
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                if (_log.isDebugEnabled()) {
                    _log.debug(e.toString());
                }
                SessionErrors.add(request, "sdr_bbs.bbscomment-delete-fail");
            }
        }

        PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(request), "sdr_bbsportlet_WAR_SDR_bbsportlet", themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
        redirectURL.setParameter("action", "detail");
        redirectURL.setParameter("bbsId", Long.toString(bbsId));
        redirectURL.setParameter("postId", Long.toString(postId));
        response.sendRedirect(redirectURL.toString());
    }

    /**
     * Comment pwd check.
     *
     * @param request  the request
     * @param response the response
     * @throws SystemException the system exception
     * @throws PortalException the portal exception
     * @throws IOException     the io exception
     */
    @ResourceMapping
    public void commentPwdCheck(ResourceRequest request, ResourceResponse response) throws SystemException, PortalException, IOException {

        _log.debug("### SDR BBS Comment Password Check ###");

        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

        long bbsId = ParamUtil.getLong(request, "bbsId");
        long postId = ParamUtil.getLong(request, "postId");
        long commentId = ParamUtil.getLong(request, "commentId");

        String returnVal = "0";
        if (commentId > 0L) {
            String password = ParamUtil.getString(request, "password");
            if (Validator.isNotNull(password)) {
                Bbs bbs = BbsLocalServiceUtil.getBbs(bbsId);
                BbsComment bbsComment = BbsCommentLocalServiceUtil.getBbsComment(commentId);
                if (bbsComment.getUserId() == UserLocalServiceUtil.getDefaultUserId(bbs.getCompanyId())) {
                    try {
                        password = Encryptor.encrypt(themeDisplay.getCompany().getKeyObj(), password);
                    } catch (Exception e) {
                        if (_log.isDebugEnabled()) {
                            _log.debug(e.toString());
                        }
                        password = "";
                    }
                    if ((Validator.isNotNull(password)) && (bbsComment.getPassword().equals(password))) {
                        returnVal = "1";
                    }
                }
            }
        }
        response.getWriter().write(returnVal);
    }

    /**
     * Comment auth.
     *
     * @param request  the request
     * @param response the response
     * @throws IOException the io exception
     */
    @ActionMapping(value = "commentAuth")
    public void commentAuth(ActionRequest request, ActionResponse response) throws IOException {

        _log.debug("### SDR BBS Comment authentication ###");

        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

        long bbsId = ParamUtil.getLong(request, "bbsId");
        long postId = ParamUtil.getLong(request, "postId");
        long commentId = ParamUtil.getLong(request, "commentId");

        boolean isCommentOwner = false;

        if ((bbsId > 0L) && (!themeDisplay.isSignedIn())) {
            long companyId = themeDisplay.getCompanyId();
            long groupId = themeDisplay.getScopeGroupId();
            try {
                Bbs bbs = BbsLocalServiceUtil.getBbs(bbsId);
                if ((bbs.getCompanyId() == companyId) && (bbs.getGroupId() == groupId) && (postId > 0L)) {
                    boolean hasModelPermission = BbsPermission.hasModelPermission(themeDisplay, Bbs.class.getName(), bbs.getBbsId(), StringUtil.upperCase("detail"));
                    if (hasModelPermission) {
                        BbsPost bbsPost = BbsPostLocalServiceUtil.getBbsPost(postId);
                        if ((Validator.isNotNull(bbsPost)) && (bbsPost.getBbsId() == bbs.getBbsId())) {
                            BbsComment comment = null;
                            if (commentId > 0L) {
                                comment = BbsCommentLocalServiceUtil.getBbsComment(commentId);
                                if (comment.getPostId() == bbsPost.getPostId()) {
                                    hasModelPermission = false;
                                    if (comment.getUserId() == themeDisplay.getUserId()) {
                                        if (!themeDisplay.isSignedIn()) {
                                            String password = ParamUtil.getString(request, "password");
                                            try {
                                                password = Encryptor.encrypt(themeDisplay.getCompany().getKeyObj(), password);
                                            } catch (Exception e) {
                                                if (_log.isDebugEnabled()) {
                                                    _log.debug(e.toString());
                                                }
                                                password = "";
                                            }
                                            if ((Validator.isNotNull(password)) && (comment.getPassword().equals(password))) {
                                                hasModelPermission = true;
                                                request.getPortletSession().setAttribute(
                                                        BbsController.class.getName() + "_cpwd_" + commentId, password);

                                                boolean isGuestComment = (comment.getUserId() == UserLocalServiceUtil.getDefaultUserId(bbs.getCompanyId()));
                                                if (themeDisplay.getUserId() == comment.getUserId()) {
                                                    if (isGuestComment) {
                                                        String pwdMessage = (String) request.getPortletSession().getAttribute(BbsController.class.getName() + "_cpwd_" + comment.getCommentId());

                                                        if (Validator.isNotNull(pwdMessage) && pwdMessage.equals(comment.getPassword()))
                                                            isCommentOwner = true;
                                                    } else {
                                                        isCommentOwner = true;
                                                    }
                                                }
                                                SessionMessages.add(request, "sdr_bbs.bbscomment-pwd-auth-successfully");
                                            } else {
                                                SessionErrors.add(request, "sdr_bbs.bbscomment-pwd-auth-fail");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            } catch (Exception e) {
                if (_log.isDebugEnabled()) {
                    _log.debug(e.toString());
                }
                SessionErrors.add(request, "sdr_bbs.bbscomment-pwd-auth-fail");
            }
        }

        PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(request), "sdr_bbsportlet_WAR_SDR_bbsportlet", themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
        redirectURL.setParameter("action", "detail");
        redirectURL.setParameter("bbsId", Long.toString(bbsId));
        redirectURL.setParameter("postId", Long.toString(postId));
        if (isCommentOwner) {
            redirectURL.setParameter("authCommentId", Long.toString(commentId));
        }
        response.sendRedirect(redirectURL.toString());
    }

}