package com.sdr.popup.popup;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryServiceUtil;
import com.sdr.popup.model.Popup;
import com.sdr.popup.service.PopupLocalServiceUtil;
import com.sdr.popup.util.PopupUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.File;
import java.util.List;

@Controller
@RequestMapping("VIEW")
public class PopupController {

    private static Log _log = LogFactoryUtil.getLog(PopupController.class);

    @RenderMapping
    public String render(RenderRequest request, RenderResponse response, Model model) {

        _log.debug("### SDR Popup render ");

        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

        List<Popup> popups = null;
        int popupTotal = 0;
        try {
            long companyId = themeDisplay.getCompanyId();
            long groupId = themeDisplay.getScopeGroupId();

            popups = PopupLocalServiceUtil.getAvailablePopups(companyId, groupId);

            if (Validator.isNotNull(popups)) {
                popupTotal = popups.size();
            }
        } catch (Exception e) {
            if (_log.isDebugEnabled()) {
                _log.debug(e.toString());
            }
        }

        request.setAttribute("popups", popups);
        request.setAttribute("popupTotal", Integer.valueOf(popupTotal));

        return "popup/popup/view";
    }

}
