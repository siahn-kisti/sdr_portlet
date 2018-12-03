package com.sdr.ac;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.RoleServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.sdr.ac.PermissionConstant;
import com.sdr.file.PropConst;
import com.sdr.metadata.model.PpLogic;
import com.sdr.metadata.service.PpLogicLocalServiceUtil;

public class DataProcessModelPermission {

    private static Log _log = LogFactoryUtil.getLog(CVModelPermission.class);

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

        _log.debug("data preprocess module permission check : " + PermissionConstant.getStringforAction(actionId));
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

        PpLogic ppl = null;
        actionId = actionId & 0x0F;
        switch (actionId) {
            case PermissionConstant.SDR_ACTION_SEARCH :
            case PermissionConstant.SDR_ACTION_READ:
                return true;
            case PermissionConstant.SDR_ACTION_UPDATE :
            case PermissionConstant.SDR_ACTION_DELETE :
                ppl = PpLogicLocalServiceUtil.getPpLogic(targetId);
                if (serviceContext.getUserId() == ppl.getUserId()) return true;
                return false;
            case PermissionConstant.SDR_ACTION_CREATE :
                return false;
            //return RoleServiceUtil.hasUserRole( serviceContext.getUserId(), serviceContext.getCompanyId(), PropConst.getProp("collection.create.role"), true) ;
            //if ( role >= PermissionConstant.SDR_ROLE_USER) return true;
            //return false;
        }
        return false;
    }
}
