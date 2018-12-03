package com.sdr.popup.admin;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.sdr.popup.model.Popup;
import com.sdr.popup.service.PopupLocalServiceUtil;
import com.sdr.popup.util.PopupPermission;
import com.sdr.popup.util.PopupUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import javax.imageio.ImageIO;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("VIEW")
public class PopupAdminController {

    private static Log _log = LogFactoryUtil.getLog(PopupAdminController.class);

    @RenderMapping
    public String render(RenderRequest request, Model model) {

        _log.debug("### SDR Popup Admin render ");

        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        String portletName = (String) request.getAttribute("PORTLET_ID");

        String action = ParamUtil.getString(request, "action", "view");

        boolean hasPermission = false;

        if (action.equals("view")) {
            hasPermission = PopupPermission.hasPortletPermission(themeDisplay, portletName, StringUtil.upperCase("view"));
        } else if ((action.equals("edit"))) {
            hasPermission = PopupPermission.hasPortletPermission(themeDisplay, portletName, StringUtil.upperCase("edit"));
        } else {
            hasPermission = false;
        }
        if (hasPermission) {
            if (action.equals("view")) {

                List<Popup> popups = null;
                int popupTotal = 0;
                try {
                    long companyId = themeDisplay.getCompanyId();
                    long groupId = themeDisplay.getScopeGroupId();

                    popups = PopupLocalServiceUtil.getAllPopups(companyId, groupId);

                    if (Validator.isNotNull(popups)) {
                        popupTotal = popups.size();
                    }
                } catch (Exception e) {
                    if (_log.isDebugEnabled()) {
                        _log.debug(e.toString());
                    }
                }

                model.addAttribute("popups", popups);
                model.addAttribute("popupTotal", popupTotal);

            } else if (action.equals("edit")) {
                Popup popup = null;
                try {
                    long popupId = ParamUtil.getLong(request, "popupId");
                    if (popupId > 0L) {
                        popup = PopupLocalServiceUtil.getPopup(popupId);
                        if ((popup.getCompanyId() != themeDisplay.getCompanyId()) ||
                                (popup.getGroupId() != themeDisplay.getScopeGroupId())) {
                            popup = null;
                        }
                    }
                } catch (Exception e) {
                    if (_log.isDebugEnabled()) {
                        _log.debug(e.toString());
                    }
                }
                model.addAttribute("popup", popup);
            } else {
                action = "access_denied";
            }
        }

        model.addAttribute("curAction", action);
        model.addAttribute("hasPermission", hasPermission);

        return "popup/admin/view";
    }

    @ActionMapping(value = "edit")
    public void edit(ActionRequest request, ActionResponse response) {

        _log.debug("### SDR Popup Admin edit render ");

        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

        long popupId = ParamUtil.getLong(request, "popupId");

        Popup popup = null;

        try {
            long companyId = themeDisplay.getCompanyId();
            long groupId = themeDisplay.getScopeGroupId();

            boolean isValidated = true;
            String title = ParamUtil.getString(request, "title");
            title = StringUtil.trim(title);


            Calendar calendar = CalendarFactoryUtil.getCalendar(themeDisplay.getTimeZone());

            int startDateMonth = ParamUtil.getInteger(request, "startDateMonth");
            int startDateDay = ParamUtil.getInteger(request, "startDateDay");
            int startDateYear = ParamUtil.getInteger(request, "startDateYear");
            int startDateHour = ParamUtil.getInteger(request, "startDateHour");
            int startDateMinute = ParamUtil.getInteger(request, "startDateMinute");
            int startDateAmPm = ParamUtil.getInteger(request, "startDateAmPm");
            if (startDateAmPm == 1) {
                startDateHour += 12;
            }

            calendar.set(startDateYear, startDateMonth, startDateDay, startDateHour, startDateMinute);
            Date startDate = calendar.getTime();

            int finishDateMonth = ParamUtil.getInteger(request, "finishDateMonth");
            int finishDateDay = ParamUtil.getInteger(request, "finishDateDay");
            int finishDateYear = ParamUtil.getInteger(request, "finishDateYear");
            int finishDateHour = ParamUtil.getInteger(request, "finishDateHour");
            int finishDateMinute = ParamUtil.getInteger(request, "finishDateMinute");
            int finishDateAmPm = ParamUtil.getInteger(request, "finishDateAmPm");
            if (finishDateAmPm == 1) {
                finishDateHour += 12;
            }

            calendar.set(finishDateYear, finishDateMonth, finishDateDay, finishDateHour, finishDateMinute);
            Date finishDate = calendar.getTime();

            int width = ParamUtil.getInteger(request, "width");
            int height = ParamUtil.getInteger(request, "height");
            boolean enable = ParamUtil.getBoolean(request, "enable");

            UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(request);
            File imageFile = uploadPortletRequest.getFile("imageFile");
            int imageWidth = width;
            int imageHeight = height;

            if (imageFile.exists()) {
                BufferedImage image = ImageIO.read(imageFile);
                if (width <= 0) {
                    imageWidth = image.getWidth();
                }
                if (height <= 0) {
                    imageHeight = image.getHeight();
                }
            }

            if (Validator.isNull(title)) {
                isValidated = false;
            }
            if (isValidated) {
                if (popupId > 0L) {
                    popup = PopupLocalServiceUtil.getPopup(popupId);

                    if ((popup.getCompanyId() == companyId) &&
                            (popup.getGroupId() == groupId)) {
                        popup.setTitle(title);
                        popup.setStartDate(startDate);
                        popup.setFinishDate(finishDate);
                        popup.setEnable(enable);
                        popup.setWidth(imageWidth);
                        popup.setHeight(imageHeight);
                        if (!imageFile.getName().isEmpty()) {
                            PopupUpload.fileDelete(popup.getImgPath());
                            popup.setImgPath(PopupUpload.uploadDocument(request, response));
                        }

                        PopupUpload.uploadDocument(request, response);

                        PopupLocalServiceUtil.updatePopup(popup);
                    } else {
                        popup = null;
                        SessionErrors.add(request, "error-save-message");
                    }
                } else {
                    popupId = CounterLocalServiceUtil.increment(Popup.class.getName());
                    popup = PopupLocalServiceUtil.createPopup(popupId);

                    popup.setCompanyId(companyId);
                    popup.setGroupId(groupId);
                    popup.setTitle(title);
                    popup.setStartDate(startDate);
                    popup.setFinishDate(finishDate);
                    popup.setWidth(imageWidth);
                    popup.setHeight(imageHeight);
                    popup.setEnable(enable);
                    popup.setImgPath(PopupUpload.uploadDocument(request, response));

                    PopupLocalServiceUtil.addPopup(popup);
                }
                SessionMessages.add(request, "sdr_popup_admin.popup-save-successfully");
            } else {
                SessionErrors.add(request, "sdr_popup_admin.popup-save-fail-to-required-input");
            }
        } catch (Exception e) {
            if (_log.isDebugEnabled()) {
                _log.debug(e.toString());
            }
            SessionErrors.add(request, "sdr_popup_admin.popup-save-fail");
        }
    }

    @ActionMapping(value = "delete")
    public void delete(ActionRequest request) {

        _log.debug("### SDR Popup Admin delete render ");

        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

        long popupId = ParamUtil.getLong(request, "popupId");
        if (popupId > 0L) {
            try {
                Popup popup = PopupLocalServiceUtil.getPopup(popupId);

                long companyId = themeDisplay.getCompanyId();
                long groupId = themeDisplay.getScopeGroupId();
                if ((popup.getCompanyId() == companyId) && (popup.getGroupId() == groupId)) {

                    PopupUpload.fileDelete(popup.getImgPath());

                    PopupLocalServiceUtil.deletePopup(popupId);
                    SessionMessages.add(request, "sdr_popup_admin.popup-delete-successfully");
                }
            } catch (Exception e) {
                if (_log.isDebugEnabled()) {
                    _log.debug(e.toString());
                }
                SessionErrors.add(request, "sdr_popup_admin.popup-delete-fail");
            }

        }
    }
}

