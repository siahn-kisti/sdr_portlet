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
import com.sdr.ac.PermissionConstant;
import com.sdr.metadata.model.DataType;
import com.sdr.metadata.service.DataTypeLocalServiceUtil;

/**
 * The type Data type model permission.
 */
public class DataTypeModelPermission {

    private static Log _log = LogFactoryUtil.getLog(DataTypeModelPermission.class);

    /**
     * Check.
     *
     * @param serviceContext the service context
     * @param actionId       the action id
     * @throws PortalException    the portal exception
     * @throws SystemException    the system exception
     * @throws PrincipalException the principal exception
     */
    public static void check(ServiceContext serviceContext, long targetId, int actionId)
            throws PortalException, SystemException, PrincipalException {
        if (PermissionConstant.SDR_AC_DISABLE) return;

        _log.debug("data type permission check : " + PermissionConstant.getStringforAction(actionId));
        if (!contains(serviceContext, targetId, actionId)) {
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
    public static boolean contains(ServiceContext serviceContext, long targetId, int actionId)
            throws PortalException, SystemException {

        int role = PermissionConstant.checkRole(serviceContext, serviceContext.getScopeGroupId());
        if ( role == PermissionConstant.SDR_ROLE_ADMIN) return true;

        DataType dt = null;
        switch (actionId) {
            case PermissionConstant.SDR_ACTION_DATATYPE_SEARCH :
            case PermissionConstant.SDR_ACTION_DATATYPE_READ:
                return true;
            case PermissionConstant.SDR_ACTION_DATATYPE_UPDATE :
                dt = DataTypeLocalServiceUtil.getDataType(targetId);
                if ( (serviceContext.getUserId() == dt.getUserId()) || (serviceContext.getUserId() == dt.getAllowedUserId()) ) return true;
                return false;
            case PermissionConstant.SDR_ACTION_DATATYPE_DELETE :
                dt = DataTypeLocalServiceUtil.getDataType(targetId);
                if ( serviceContext.getUserId() == dt.getUserId()) return true;
                return false;
            case PermissionConstant.SDR_ACTION_DATATYPE_CREATE :
                // if ( role >= PermissionConstant.SDR_ROLE_USER) return true;
                return RoleServiceUtil.hasUserRole( serviceContext.getUserId(), serviceContext.getCompanyId(), PropConst.getProp("collection.create.role"), true) ;
        }
        return false;
    }


}
