package com.sdr.ac;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.theme.ThemeDisplay;
import com.sdr.metadata.model.DataView;

/**
 * The type Comm model permission.
 */
public class CommModelPermission {

    private static Log _log = LogFactoryUtil.getLog(CommModelPermission.class);

    /**
     * Check.
     *
     * @param serviceContext the service context
     * @param actionId       the action id
     * @throws PortalException    the portal exception
     * @throws SystemException    the system exception
     * @throws PrincipalException the principal exception
     */
    public static void check(ServiceContext serviceContext, int actionId)
            throws PortalException, SystemException, PrincipalException {
        if (PermissionConstant.SDR_AC_DISABLE) return;

        _log.debug("community permission check : " + PermissionConstant.getStringforAction(actionId));
        if (!contains(serviceContext, actionId)) {
            throw new PrincipalException();
        }
    }

    /**
     * Contains boolean.
     *
     * @param serviceContext the service context
     * @param actionId       the action id
     * @return the boolean
     */
    public static boolean contains(ServiceContext serviceContext, int actionId) {
        int role = PermissionConstant.checkRole(serviceContext, serviceContext.getScopeGroupId());

        switch (actionId) {
            case PermissionConstant.SDR_ACTION_COMM_READ:
            case PermissionConstant.SDR_ACTION_COMM_SEARCH :
                return true;
            case PermissionConstant.SDR_ACTION_COMM_REQUEST :
                if ( role >= PermissionConstant.SDR_ROLE_USER) {
                    return true;
                } else {
                    return false;
                }
            case PermissionConstant.SDR_ACTION_COMM_DELETE :
            case PermissionConstant.SDR_ACTION_COMM_CREATE :
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
