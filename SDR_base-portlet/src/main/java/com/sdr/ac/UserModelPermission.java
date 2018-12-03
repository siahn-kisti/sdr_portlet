package com.sdr.ac;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceContext;


/**
 * The type User model permission.
 */
public class UserModelPermission {

    private static Log _log = LogFactoryUtil.getLog(UserModelPermission.class);

    /**
     * Check.
     *
     * @param serviceContext the service context
     * @param targetId       the target id
     * @param actionId       the action id
     * @throws PortalException    the portal exception
     * @throws SystemException    the system exception
     * @throws PrincipalException the principal exception
     */
    public static void check(ServiceContext serviceContext, long targetId, int actionId)
            throws PortalException, SystemException, PrincipalException {
        if (PermissionConstant.SDR_AC_DISABLE) return;

        _log.debug("user permission check : " + actionId);
        _log.debug("user permission check : " + PermissionConstant.getStringforAction(actionId));
        if (!contains(serviceContext, targetId, actionId)) {
            throw new PrincipalException();
        }
    }

    /**
     * Contains boolean.
     *
     * @param serviceContext the service context
     * @param targetId       the target id
     * @param actionId       the action id
     * @return the boolean
     */
    public static boolean contains(ServiceContext serviceContext, long targetId, int actionId) {
        int role = 0;
        try {
            role = PermissionConstant.checkRole(serviceContext, serviceContext.getScopeGroupId());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        switch (actionId) {
            case PermissionConstant.SDR_ACTION_USER_READ:
            case PermissionConstant.SDR_ACTION_USER_SEARCH :
                return true;
            case PermissionConstant.SDR_ACTION_USER_CREATE :
                if ( role >= PermissionConstant.SDR_ROLE_USER) {
                    return true;
                } else {
                    return false;
                }
            case PermissionConstant.SDR_ACTION_USER_UPDATE :
                if ( role == PermissionConstant.SDR_ROLE_OWNER)
                    return true;
            case PermissionConstant.SDR_ACTION_USER_DELETE :
                if ( role == PermissionConstant.SDR_ROLE_ADMIN) {
                    return true;
                } else {
                    return false;
                }
            default :
                return false;
        }
    }

}
