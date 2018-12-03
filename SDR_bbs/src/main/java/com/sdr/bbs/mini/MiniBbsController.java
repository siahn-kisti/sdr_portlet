package com.sdr.bbs.mini;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.*;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.LayoutServiceUtil;
import com.liferay.portal.service.persistence.LayoutUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.sdr.bbs.model.Bbs;
import com.sdr.bbs.model.BbsPost;
import com.sdr.bbs.service.BbsLocalServiceUtil;
import com.sdr.bbs.service.BbsPostLocalServiceUtil;
import com.sdr.bbs.util.BbsPermission;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import javax.portlet.*;
import java.io.IOException;
import java.util.List;

/**
 * The type Mini bbs controller.
 */
@Controller
@RequestMapping("VIEW")
public class MiniBbsController {

    private static Log _log = LogFactoryUtil.getLog(MiniBbsController.class);

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
        _log.debug("#### mini bbs render ####");

        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        boolean hasPermission = BbsPermission.hasPortletPermission(themeDisplay, themeDisplay.getPortletDisplay().getId(), StringUtil.upperCase("view"));
        model.addAttribute("hasPermission", hasPermission);

        PortletPreferences portletPreferences = request.getPreferences();
        long prefBbsId = GetterUtil.getLong(portletPreferences.getValue("prefBbsId", "0"));
        int prefMessageNo = GetterUtil.getInteger(portletPreferences.getValue("prefMessageNo", "4"));

        Bbs bbs = BbsLocalServiceUtil.getBbs(prefBbsId);
        request.setAttribute("bbs", bbs);

//        List<BbsPostVo> voList = new ArrayList<>();
//        int postCnt = 0;

        if(Validator.isNotNull(bbs)) {
            List<BbsPost> list = BbsPostLocalServiceUtil.getList(0, prefMessageNo, null, bbs.getBbsId());
            int postCnt = BbsPostLocalServiceUtil.getCount(null, bbs.getBbsId());

            model.addAttribute("list", list);
            model.addAttribute("count", postCnt);

            // 메인bbs에도 이미지게시판 스타일이 들어갈 경우 아래 적용해야..
            // BbsPostVo vo = null;
            /*if (bbs.getDisplayType() == BbsDisplayTypeConstants.IMAGE) {
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
            }*/
        }


        return "bbs/mini/view";
    }

    /**
     * Go bbs.
     *
     * @param request  the request
     * @param response the response
     * @param model    the model
     * @throws SystemException the system exception
     * @throws PortalException the portal exception
     * @throws IOException     the io exception
     */
    @ActionMapping(value = "goBbs")
    public void goBbs(ActionRequest request, ActionResponse response, Model model) throws SystemException, PortalException, IOException {

        PortletPreferences portletPreferences = request.getPreferences();
        long prefPlid = GetterUtil.getLong(portletPreferences.getValue("prefPlid", "0"));
        long prefBbsId = GetterUtil.getLong(portletPreferences.getValue("prefBbsId", "0"));

        if (prefPlid > 0L) {

            PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(request), "sdr_bbsportlet_WAR_SDR_bbsportlet", prefPlid, PortletRequest.RENDER_PHASE);
            redirectURL.setParameter("action", "list");
            redirectURL.setParameter("prefPlid", Long.toString(prefPlid));
            redirectURL.setParameter("prefBbsId", Long.toString(prefBbsId));
            response.sendRedirect(redirectURL.toString());
        }
    }

    /**
     * Go bbs detail.
     *
     * @param request  the request
     * @param response the response
     * @param model    the model
     * @throws SystemException the system exception
     * @throws PortalException the portal exception
     * @throws IOException     the io exception
     */
    @ActionMapping(value = "goBbsDetail")
    public void goBbsDetail(ActionRequest request, ActionResponse response, Model model) throws SystemException, PortalException, IOException {

        PortletPreferences portletPreferences = request.getPreferences();
        long prefPlid = GetterUtil.getLong(portletPreferences.getValue("prefPlid", "0"));
        long prefBbsId = GetterUtil.getLong(portletPreferences.getValue("prefBbsId", "0"));

        if (prefPlid > 0L && prefBbsId > 0L) {

            long postId = ParamUtil.getLong(request, "postId", 0L);

            PortletURL redirectURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(request), "sdr_bbsportlet_WAR_SDR_bbsportlet", prefPlid, PortletRequest.RENDER_PHASE);
            redirectURL.setParameter("action", "detail");
            redirectURL.setParameter("prefPlid", Long.toString(prefPlid));
            redirectURL.setParameter("bbsId", Long.toString(prefBbsId));
            redirectURL.setParameter("postId", Long.toString(postId));
            response.sendRedirect(redirectURL.toString());
        }
    }
}