package com.sdr.ac;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.*;
import com.liferay.portal.theme.ThemeDisplay;
import com.sdr.file.PropConst;
import com.sdr.metadata.model.Collection;
import com.sdr.metadata.model.Collection_AllowedUser;
import com.sdr.metadata.model.Collection_User;
import com.sdr.metadata.model.Dataset;
import com.sdr.metadata.service.CollectionLocalServiceUtil;
import com.sdr.metadata.service.Collection_AllowedUserLocalServiceUtil;
import com.sdr.metadata.service.Collection_UserLocalServiceUtil;
import com.sdr.metadata.service.DatasetLocalServiceUtil;
import com.sdr.ac.PermissionConstant;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * The type Collection model permission.
 */
public class CollectionModelPermission {
    // public static final string RESOURCE_NAME = "com.sdr.collection.model";

    private static Log _log = LogFactoryUtil.getLog(CollectionModelPermission.class);

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

        _log.debug("permission check : (targetId) " + targetId + " (actionId) " + PermissionConstant.getStringforAction(actionId));
        if (!contains(serviceContext, targetId, actionId)) {
            throw new PrincipalException();
        }
    }

    /**
     * Check.
     *
     * @param serviceContext the service context
     * @param target         the target
     * @param actionId       the action id
     * @throws PortalException    the portal exception
     * @throws SystemException    the system exception
     * @throws PrincipalException the principal exception
     */
    public static void check(ServiceContext serviceContext, Collection target, int actionId)
            throws PortalException, SystemException, PrincipalException {
        if (PermissionConstant.SDR_AC_DISABLE) return;

        if (!contains(serviceContext, target, actionId)) {
            throw new PrincipalException();
        }
    }

    /**
     * Check.
     *
     * @param serviceContext the service context
     * @param target         the target
     * @param actionId       the action id
     * @throws PortalException    the portal exception
     * @throws SystemException    the system exception
     * @throws PrincipalException the principal exception
     */
    public static void check(ServiceContext serviceContext, Dataset target, int actionId)
            throws PortalException, SystemException, PrincipalException {
        if (PermissionConstant.SDR_AC_DISABLE) return;

                if (!contains(serviceContext, target, actionId)) {
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
     * @throws PortalException the portal exception
     * @throws SystemException the system exception
     */
    public static boolean contains(ServiceContext serviceContext, long targetId, int actionId)
            throws PortalException, SystemException {
        _log.debug("action : " + targetId + " : " + PermissionConstant.getStringforAction(actionId));
        _log.debug("user : " + serviceContext.getUserId() );
        switch ( actionId ) {
            case PermissionConstant.SDR_ACTION_COLLECTION_SEARCH :
            case PermissionConstant.SDR_ACTION_DATASET_SEARCH :
                _log.debug("permission check : allows search ");
                return true;
            case PermissionConstant.SDR_ACTION_COLLECTION_CREATE  :
                // TODO : allow for only who has certain role
                if ( PermissionConstant.checkAdmin( serviceContext , targetId ) ) return true;

                /*
                List<Role> roles = RoleLocalServiceUtil.getUserRoles( serviceContext.getUserId() );
                Role role = RoleLocalServiceUtil.getRole( serviceContext.getCompanyId(), PropConst.getProp("collection.create.role")) ;
                for (Role tmpRole : roles) {
                    _log.debug("try role : " + tmpRole.getRoleId() + " " + tmpRole.getName());
                    if ( tmpRole.getRoleId() == role.getRoleId() ) {
                        return true;
                    }
                }
                */

                return RoleServiceUtil.hasUserRole( serviceContext.getUserId(), serviceContext.getCompanyId(), PropConst.getProp("collection.create.role"), true) ;

            case PermissionConstant.SDR_ACTION_COLLECTION_READ :
            case PermissionConstant.SDR_ACTION_COLLECTION_UPDATE :
            case PermissionConstant.SDR_ACTION_COLLECTION_DELETE :
            case PermissionConstant.SDR_ACTION_DATASET_CREATE :
                Collection targetColl = CollectionLocalServiceUtil.getCollection(targetId);
                return contains(serviceContext, targetColl, actionId);
            case PermissionConstant.SDR_ACTION_DATASET_READ :
            case PermissionConstant.SDR_ACTION_DATASET_UPDATE   :
            case PermissionConstant.SDR_ACTION_DATASET_DELETE  :
                Dataset targetData = DatasetLocalServiceUtil.getDataset(targetId);
                return contains(serviceContext, targetData, actionId);
            default:
                _log.debug("Invalid action : " + targetId + " : " + actionId);
                return false;
        }
    }

    /**
     * Contains
     *
     * @param serviceContext
     * @param target
     * @param actionId
     * @return boolean
     */
    private static boolean contains(ServiceContext serviceContext, Collection target, int actionId) {
        switch ( actionId ) {
            case PermissionConstant.SDR_ACTION_COLLECTION_READ :
            case PermissionConstant.SDR_ACTION_COLLECTION_UPDATE  :
            case PermissionConstant.SDR_ACTION_COLLECTION_DELETE  :
            case PermissionConstant.SDR_ACTION_DATASET_CREATE :
            case PermissionConstant.SDR_ACTION_DATASET_READ :
                break;
            default :
                _log.debug("Invalid action : " + target.getCollectionId() + " : " + target.getTitle());
                return false;
        }

        int role = checkRoleforCollection(serviceContext, target);
        _log.debug(" (role) " + PermissionConstant.getStringforRole(role) );

        if ( ! PermissionConstant.SDR_EMBARGO_DISABLE ) {
            //_log.debug("check Embargo");
            if ((role >= PermissionConstant.SDR_ROLE_USER) &&
                    ((actionId & 0xF) == PermissionConstant.SDR_ACTION_READ)) {
                if (checkEmbargo(target)) {
                    //_log.debug("Embargo has been expired ");
                    return true;
                }
                //_log.debug("still in Embargo");
            }
        }

        int accessPermission = target.getAccessPolicy();
        _log.debug(" (policy) " + PermissionConstant.getStringforPermission(accessPermission) );

        boolean ret = allowAccessforCollection(role, accessPermission, actionId);
        _log.debug(" (result) " + ret);
        return ret;
    }

    private static boolean checkEmbargo(Collection target) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.DAY_OF_WEEK, PermissionConstant.SDR_EMBARGO_AMOUNT);

        if ( target.getCreateDate().before(calendar.getTime()) )
            return true;
        return false;
    }

    /**
     * Contains
     *
     * @param serviceContext
     * @param targetData
     * @param actionId
     * @return boolean
     * @throws SystemException
     * @throws PortalException
     */
    private static boolean contains(ServiceContext serviceContext, Dataset targetData, int actionId)
            throws SystemException, PortalException {

        _log.debug("Permission Check for dataset : " + targetData.getDatasetId() );

        // in case of admin, everything is allowed
        if ( PermissionConstant.checkAdmin(serviceContext, targetData.getGroupId())) return true;

        switch (actionId) {
            case PermissionConstant.SDR_ACTION_DATASET_DELETE :
            case PermissionConstant.SDR_ACTION_DATASET_UPDATE :
                if (serviceContext.getUserId() == targetData.getUserId() ) return true;
                    //if ( targetData.getStatus() != WorkflowConstants.STATUS_APPROVED )

                return false;
            case PermissionConstant.SDR_ACTION_DATASET_READ :
                if (serviceContext.getUserId() == targetData.getUserId() )
                    return true;
                Collection coll = CollectionLocalServiceUtil.getCollection(targetData.getCollectionId());
                return contains(serviceContext, coll, actionId);
            default:
                return false;
        }
    }

    /**
     * Allow access for collection
     *
     * @param role
     * @param accessPermission
     * @param actionId
     * @return boolean
     */
    private static boolean allowAccessforCollection(int role, int accessPermission, int actionId) {
        // in case of owner and admin, allow all
        if ( role >= PermissionConstant.SDR_ROLE_OWNER )
            return true;

        // only owner and admin can delete collection
        if (actionId == PermissionConstant.SDR_ACTION_COLLECTION_DELETE )
            return false;

        int policy = 0;

        if ( role == PermissionConstant.SDR_ROLE_GROUP ) {
            policy = PermissionConstant.SDR_PERM_GROUP_READ + PermissionConstant.SDR_PERM_USER_READ + PermissionConstant.SDR_PERM_GUEST_READ;
        } else if ( role == PermissionConstant.SDR_ROLE_MEMBER ) {
            policy = PermissionConstant.SDR_PERM_COMMUNITY_READ + PermissionConstant.SDR_PERM_USER_READ + PermissionConstant.SDR_PERM_GUEST_READ;
        } else if ( role == PermissionConstant.SDR_ROLE_USER ) {
            policy = PermissionConstant.SDR_PERM_USER_READ + PermissionConstant.SDR_PERM_GUEST_READ;
        } else {
            policy = PermissionConstant.SDR_PERM_GUEST_READ;
        }

        switch (actionId) {
            case PermissionConstant.SDR_ACTION_COLLECTION_UPDATE :
                policy = policy << 2;
                break;
            case PermissionConstant.SDR_ACTION_DATASET_CREATE :
                policy = policy << 1;
                break;
        }

        if ((policy & accessPermission) > 0 ) {
            return true;
        } else {
            return false;
        }
    }


    /**
     * Check role for collection
     *
     * @param serviceContext
     * @param target
     * @return int
     */
    private static int checkRoleforCollection(ServiceContext serviceContext, Collection target) {

        _log.debug("--User : " + serviceContext.getUserId());
        _log.debug("--Site : " + serviceContext.getScopeGroupId());

        if ( PermissionConstant.checkGuest(serviceContext) )
            return PermissionConstant.SDR_ROLE_GUEST;

        if ( PermissionConstant.checkAdmin(serviceContext, target.getGroupId()) )
            return PermissionConstant.SDR_ROLE_ADMIN;

        if (serviceContext.getUserId() == target.getUserId() )
            return PermissionConstant.SDR_ROLE_OWNER;

        try {
            List<Collection_AllowedUser> allowedUsers = Collection_AllowedUserLocalServiceUtil.getAllowedUsersByCollection(target.getCollectionId());
            for ( Collection_AllowedUser user : allowedUsers )
                if (serviceContext.getUserId() == user.getUserId() )
                    return PermissionConstant.SDR_ROLE_GROUP;
        } catch (Exception e) {
            e.printStackTrace();
        }

        if ( PermissionConstant.checkMember(serviceContext, target.getGroupId()) )
            return PermissionConstant.SDR_ROLE_MEMBER;

        return PermissionConstant.SDR_ROLE_USER;
    }
}
