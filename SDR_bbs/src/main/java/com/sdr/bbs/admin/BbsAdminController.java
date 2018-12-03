package com.sdr.bbs.admin;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.sdr.bbs.model.Bbs;
import com.sdr.bbs.service.BbsLocalServiceUtil;
import com.sdr.bbs.service.BbsPostLocalServiceUtil;
import com.sdr.bbs.util.BbsPermission;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.Date;
import java.util.List;

/**
 * The type Bbs admin controller.
 */
@Controller
@RequestMapping("VIEW")
public class BbsAdminController {

    private static Log _log = LogFactoryUtil.getLog(BbsAdminController.class);

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

        _log.debug("### SDR BBS Admin render ");

        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        String portletName = (String) request.getAttribute("PORTLET_ID");

        String action = ParamUtil.getString(request, "action", "view");

        boolean hasPermission = false;
        if ((action.equals("view")) || (action.equals("edit"))) {
            try {
                hasPermission = BbsPermission.hasPortletPermission(themeDisplay, portletName, StringUtil.upperCase("view"));
            } catch (Exception e) {
                if (_log.isDebugEnabled()) {
                    _log.debug(e.toString());
                }
            }
        } else {
            hasPermission = false;
        }
        if (hasPermission) {

            SearchContainer<Bbs> searchContainer = new SearchContainer<Bbs>(request, response.createRenderURL(), null, "there are no dataset");

            long companyId = themeDisplay.getCompanyId();
            long groupId = themeDisplay.getScopeGroupId();
            if (action.equals("view")) {
                List<Bbs> bbsList = null;
                int bbsTotal = 0;
                try {
                    bbsTotal = BbsLocalServiceUtil.countByC_G(companyId, groupId);
                    if (bbsTotal > 0) {
                        bbsList = BbsLocalServiceUtil.findByC_G(companyId, groupId, searchContainer.getStart(), searchContainer.getEnd());
                    }
                } catch (Exception e) {
                    if (_log.isDebugEnabled()) {
                        _log.debug(e.toString());
                    }
                }

                model.addAttribute("bbsList", bbsList);
                model.addAttribute("bbsTotal", Integer.valueOf(bbsTotal));

            } else if (action.equals("edit")) {
                Bbs bbs = null;
                try {
                    long bbsId = ParamUtil.getLong(request, "bbsId");
                    if (bbsId > 0L) {
                        bbs = BbsLocalServiceUtil.getBbs(bbsId);

                        if ((bbs.getCompanyId() != companyId) || (bbs.getGroupId() != groupId)) {
                            bbs = null;
                        }
                    }
                } catch (Exception e) {
                    if (_log.isDebugEnabled()) {
                        _log.debug(e.toString());
                    }
                }
                model.addAttribute("bbs", bbs);
            }
        } else {
            action = "access_denied";
        }
        model.addAttribute("hasPermission", hasPermission);
        model.addAttribute("curAction", action);

        return "bbs/admin/view";
    }

    /**
     * Edit.
     *
     * @param request  the request
     * @param response the response
     */
    @ActionMapping(value = "edit")
    public void edit(ActionRequest request, ActionResponse response) {

        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

        long bbsId = ParamUtil.getLong(request, "bbsId");

        Bbs bbs = null;
        try {
            long companyId = themeDisplay.getCompanyId();
            long groupId = themeDisplay.getScopeGroupId();

            boolean isValidated = true;

            long userId = themeDisplay.getUserId();
            Date createDate = new Date();
            Date modifiedDate = new Date();
            String title = StringUtil.trim(ParamUtil.getString(request, "title"));
            int displayType = ParamUtil.getInteger(request, "displayType");

            _log.debug("### title : " + title + " displayType : " + displayType);

            if (Validator.isNull(title)) {
                isValidated = false;
            }
            if (isValidated) {
                if (bbsId > 0L) {
                    bbs = BbsLocalServiceUtil.getBbs(bbsId);
                    if ((bbs.getCompanyId() == companyId) &&
                            (bbs.getGroupId() == groupId)) {
                        bbs.setUserId(userId);
                        bbs.setModifiedDate(modifiedDate);
                        bbs.setTitle(title);
                        bbs.setDisplayType(displayType);

                        BbsLocalServiceUtil.updateBbs(bbs);

                        SessionMessages.add(request, "sdr_bbs_admin.bbs-save-successfully");
                    } else {
                        bbs = null;
                        SessionErrors.add(request, "sdr_bbs_admin.bbs-save-fail");
                    }
                } else {
                    bbsId = CounterLocalServiceUtil.increment(Bbs.class.getName());
                    bbs = BbsLocalServiceUtil.createBbs(bbsId);

                    bbs.setCompanyId(companyId);
                    bbs.setGroupId(groupId);
                    bbs.setUserId(userId);
                    bbs.setCreateDate(createDate);
                    bbs.setModifiedDate(modifiedDate);
                    bbs.setTitle(title);
                    bbs.setDisplayType(displayType);

                    BbsLocalServiceUtil.addBbs(bbs);

                    SessionMessages.add(request, "sdr_bbs_admin.bbs-save-successfully");
                }
            } else {
                SessionErrors.add(request, "sdr_bbs_admin.bbs-save-fail-to-required-input");
            }
        } catch (Exception e) {
            if (_log.isDebugEnabled()) {
                _log.debug(e.toString());
            }
            SessionErrors.add(request, "sdr_bbs_admin.bbs-save-fail");
        }
    }

    /**
     * Delete.
     *
     * @param request  the request
     * @param response the response
     */
    @ActionMapping(value = "delete")
    public void delete(ActionRequest request, ActionResponse response) {
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

        long bbsId = ParamUtil.getLong(request, "bbsId");
        if (bbsId > 0L) {
            Bbs bbs = null;
            try {
                long companyId = themeDisplay.getCompanyId();
                long groupId = themeDisplay.getScopeGroupId();

                bbs = BbsLocalServiceUtil.getBbs(bbsId);
                if ((bbs.getCompanyId() == companyId) && (bbs.getGroupId() == groupId)) {
                    if (BbsPostLocalServiceUtil.countByBbsId(bbsId) > 0) {
                        bbs = null;
                        SessionErrors.add(request, "sdr_bbs_admin.bbs-delete-fail-to-has-post");
                    } else {
                        BbsLocalServiceUtil.deleteBbs(bbsId);

                        SessionMessages.add(request, "sdr_bbs_admin.bbs-delete-successfully");
                    }
                } else {
                    bbs = null;
                    SessionErrors.add(request, "sdr_bbs_admin.bbs-delete-fail");
                }
            } catch (Exception e) {
                if (_log.isDebugEnabled()) {
                    _log.debug(e.toString());
                }
                SessionErrors.add(request, "sdr_bbs_admin.bbs-delete-fail");
            }
        }
    }

}