package com.sdr.bbs.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.liferay.portal.theme.ThemeDisplay;

public class BbsPermission {

    private static Log _log = LogFactoryUtil.getLog(BbsPermission.class);

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
