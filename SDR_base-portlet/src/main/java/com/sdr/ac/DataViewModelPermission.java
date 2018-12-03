package com.sdr.ac;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.RoleServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.theme.ThemeDisplay;
import com.sdr.file.PropConst;
import com.sdr.metadata.model.Collection;
import com.sdr.metadata.model.DataView;
import com.sdr.metadata.service.DataViewLocalServiceUtil;

/**
 * The type Data view model permission.
 */
public class DataViewModelPermission {
    private static Log _log = LogFactoryUtil.getLog(DataViewModelPermission.class);

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

        _log.debug("data view permission check : " + PermissionConstant.getStringforAction(actionId));
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
    public static boolean contains(ServiceContext serviceContext, long targetId, int actionId)
            throws PortalException, SystemException {

        int role = PermissionConstant.checkRole(serviceContext, serviceContext.getScopeGroupId());
        if ( role == PermissionConstant.SDR_ROLE_ADMIN) return true;

        DataView dv = null;
        switch (actionId) {
            case PermissionConstant.SDR_ACTION_DATAVIEW_READ:
            case PermissionConstant.SDR_ACTION_DATAVIEW_SEARCH:
                return true;
            case PermissionConstant.SDR_ACTION_DATAVIEW_UPDATE :
            case PermissionConstant.SDR_ACTION_DATAVIEW_DELETE :
                dv = DataViewLocalServiceUtil.getDataView(targetId);
                if (serviceContext.getUserId() == dv.getUserId()) return true;
                return false;
            case PermissionConstant.SDR_ACTION_DATAVIEW_CREATE :
                return RoleServiceUtil.hasUserRole( serviceContext.getUserId(), serviceContext.getCompanyId(), PropConst.getProp("collection.create.role"), true) ;
                // if ( role >= PermissionConstant.SDR_ROLE_USER) return true;
                // return false;
        }
        return false;
     }
}
