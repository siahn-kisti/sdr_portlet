package com.sdr.common.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.permission.PortletPermissionUtil;
import com.liferay.portal.theme.ThemeDisplay;

/**
 * The type Permission util.
 */
public class PermissionUtil {

    private static Log _log = LogFactoryUtil.getLog(PermissionUtil.class);

    /**
     * Has portlet permission boolean.
     *
     * @param themeDisplay the theme display
     * @param portletName  the portlet name
     * @param action       the action
     * @return the boolean
     */
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

    /**
     * Has model permission boolean.
     *
     * @param themeDisplay the theme display
     * @param name         the name
     * @param primKey      the prim key
     * @param action       the action
     * @return the boolean
     */
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
