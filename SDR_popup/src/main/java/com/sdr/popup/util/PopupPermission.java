package com.sdr.popup.util;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ResourceAction;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.ResourcePermission;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.ResourceActionLocalServiceUtil;
import com.liferay.portal.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;

public class PopupPermission {

    private static Log _log = LogFactoryUtil.getLog(PopupPermission.class);

    public static boolean hasPortletPermission(ThemeDisplay themeDisplay, String portletName, String action) {

        boolean hasPermission = false;
        try {
            hasPermission = PortletPermissionUtil.contains(themeDisplay.getPermissionChecker(), themeDisplay.getPlid(), portletName, action);
        } catch (Exception e) {
            if (_log.isDebugEnabled()) {
                _log.debug(e.toString());
            }
        }
        return hasPermission;
    }

    public static boolean hasModelPermission(ThemeDisplay themeDisplay, String name, long primKey, String action) {

        boolean hasPermission = false;
        PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();
        try {
            hasPermission = permissionChecker.hasPermission(themeDisplay.getScopeGroupId(), name, primKey, action);
        } catch (Exception e) {
            if (_log.isDebugEnabled()) {
                _log.debug(e.toString());
            }
        }
        return hasPermission;
    }

}
