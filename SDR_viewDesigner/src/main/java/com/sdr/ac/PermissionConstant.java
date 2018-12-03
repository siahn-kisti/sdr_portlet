package com.sdr.ac;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.service.UserServiceUtil;

public class PermissionConstant {
    private static Log _log = LogFactoryUtil.getLog(PermissionConstant.class);

    final static boolean SDR_AC_DISABLE = false;
    final static boolean SDR_EMBARGO_DISABLE = false;

    public final static int SDR_EMBARGO_AMOUNT = -365;

    public final static int SDR_ROLE_GUEST = 1;
    public final static int SDR_ROLE_USER = 2;
    public final static int SDR_ROLE_MEMBER = 3;
    public final static int SDR_ROLE_GROUP = 4;
    public final static int SDR_ROLE_OWNER = 5;
    public final static int SDR_ROLE_ADMIN = 6;
    final static String _ADMIN_ROLE = "administrator";

    /* Permissions */
    public final static int SDR_PERM_GROUP_READ = 0x01;
    public final static int SDR_PERM_GROUP_CREATE = 0x02;
    public final static int SDR_PERM_GROUP_UPDATE = 0x04;

    public final static int SDR_PERM_COMMUNITY_READ = 0x10;
    public final static int SDR_PERM_COMMUNITY_CREATE = 0x20;
    public final static int SDR_PERM_COMMUNITY_UPDATE = 0x40;

    public final static int SDR_PERM_USER_READ = 0x100;
    public final static int SDR_PERM_USER_CREATE = 0x200;
    public final static int SDR_PERM_USER_UPDATE = 0x400;

    public final static int SDR_PERM_GUEST_READ = 0x1000;

    final static int SDR_PERM_DEFAULT = 0x117;

    /* Actions */
    public final static int SDR_ACTION_READ = 1;
    public final static int SDR_ACTION_UPDATE = 2;
    public final static int SDR_ACTION_CREATE = 3;
    public final static int SDR_ACTION_DELETE = 4;
    public final static int SDR_ACTION_SEARCH = 5;
    public final static int SDR_ACTION_REQUEST = 6;
    public final static int SDR_ACTION_NONE = 7;

    final static int SDR_ACTION_COLLECTION = 0;
    public final static int SDR_ACTION_COLLECTION_READ = SDR_ACTION_COLLECTION + SDR_ACTION_READ;
    public final static int SDR_ACTION_COLLECTION_CREATE = SDR_ACTION_COLLECTION + SDR_ACTION_CREATE;
    public final static int SDR_ACTION_COLLECTION_UPDATE = SDR_ACTION_COLLECTION + SDR_ACTION_UPDATE;
    public final static int SDR_ACTION_COLLECTION_DELETE = SDR_ACTION_COLLECTION + SDR_ACTION_DELETE;
    public final static int SDR_ACTION_COLLECTION_SEARCH = SDR_ACTION_COLLECTION + SDR_ACTION_SEARCH;

    final static int SDR_ACTION_DATASET = 0x10;
    public final static int SDR_ACTION_DATASET_READ = SDR_ACTION_DATASET + SDR_ACTION_READ;
    public final static int SDR_ACTION_DATASET_CREATE = SDR_ACTION_DATASET + SDR_ACTION_CREATE;
    public final static int SDR_ACTION_DATASET_UPDATE = SDR_ACTION_DATASET + SDR_ACTION_UPDATE;
    public final static int SDR_ACTION_DATASET_DELETE = SDR_ACTION_DATASET + SDR_ACTION_DELETE;
    public final static int SDR_ACTION_DATASET_SEARCH = SDR_ACTION_DATASET + SDR_ACTION_SEARCH;

    final static int SDR_ACTION_DATATYPE = 0x20;
    public final static int SDR_ACTION_DATATYPE_READ = SDR_ACTION_DATATYPE + SDR_ACTION_READ;
    public final static int SDR_ACTION_DATATYPE_CREATE = SDR_ACTION_DATATYPE + SDR_ACTION_CREATE;
    public final static int SDR_ACTION_DATATYPE_UPDATE = SDR_ACTION_DATATYPE + SDR_ACTION_UPDATE;
    public final static int SDR_ACTION_DATATYPE_DELETE = SDR_ACTION_DATATYPE + SDR_ACTION_DELETE;
    public final static int SDR_ACTION_DATATYPE_SEARCH = SDR_ACTION_DATATYPE + SDR_ACTION_SEARCH;

    final static int SDR_ACTION_DATAVIEW = 0x30;
    public final static int SDR_ACTION_DATAVIEW_READ = SDR_ACTION_DATAVIEW + SDR_ACTION_READ;
    public final static int SDR_ACTION_DATAVIEW_CREATE = SDR_ACTION_DATAVIEW + SDR_ACTION_CREATE;
    public final static int SDR_ACTION_DATAVIEW_UPDATE = SDR_ACTION_DATAVIEW + SDR_ACTION_UPDATE;
    public final static int SDR_ACTION_DATAVIEW_DELETE = SDR_ACTION_DATAVIEW + SDR_ACTION_DELETE;
    public final static int SDR_ACTION_DATAVIEW_SEARCH = SDR_ACTION_DATAVIEW + SDR_ACTION_SEARCH;

    final static int SDR_ACTION_COMM = 0x40;
    public final static int SDR_ACTION_COMM_READ = SDR_ACTION_COMM + SDR_ACTION_READ;
    public final static int SDR_ACTION_COMM_CREATE = SDR_ACTION_COMM + SDR_ACTION_CREATE;
    //final static int SDR_ACTION_COMM_UPDATE = SDR_ACTION_COMM + SDR_ACTION_UPDATE;
    public final static int SDR_ACTION_COMM_DELETE = SDR_ACTION_COMM + SDR_ACTION_DELETE;
    public final static int SDR_ACTION_COMM_SEARCH = SDR_ACTION_COMM + SDR_ACTION_SEARCH;
    public final static int SDR_ACTION_COMM_REQUEST = SDR_ACTION_COMM + SDR_ACTION_REQUEST;

    final static int SDR_ACTION_USER = 0x50;
    public final static int SDR_ACTION_USER_READ = SDR_ACTION_USER + SDR_ACTION_READ;
    public final static int SDR_ACTION_USER_CREATE = SDR_ACTION_USER + SDR_ACTION_CREATE;
    public final static int SDR_ACTION_USER_UPDATE = SDR_ACTION_USER + SDR_ACTION_UPDATE;
    public final static int SDR_ACTION_USER_DELETE = SDR_ACTION_USER + SDR_ACTION_DELETE;
    public final static int SDR_ACTION_USER_SEARCH = SDR_ACTION_USER + SDR_ACTION_SEARCH;

    public final static String SDR_ACCESS_DENIED_MESSAGE = "Access denied";

	public static boolean checkGuest(ServiceContext serviceContext) {
        /*
        ThemeDisplay themeDisplay = (ThemeDisplay) serviceContext.getRequest().getAttribute(WebKeys.THEME_DISPLAY);
        if (! themeDisplay.isSignedIn() )
            return true;
        return false;

        _log.debug("serviceContext : " + serviceContext.getAttributes());

        Enumeration<String> aaa = serviceContext.getRequest().getAttributeNames();
        while(aaa.hasMoreElements()) {
            String ttt = aaa.nextElement();
            _log.debug("getReqest() " + ttt + " : " + serviceContext.getRequest().getAttribute(ttt) );
        }
        */

		User user = null;
		try {
			user = UserServiceUtil.getUserById(serviceContext.getUserId());
		} catch (Exception e) {
			_log.debug("failed to get user info : " + serviceContext.getUserId());
		}

		if (user == null) {
			try {
				user = (User) serviceContext.getRequest().getAttribute(WebKeys.USER);
			} catch (Exception e) {
				_log.debug("UnIndentified User");
				return true;
			}
		}

		if (user == null) {
			_log.debug("UnIndentified User ");
			return true;
		}

		if (user.isDefaultUser())
			return true;

		return false;
	}

	public static boolean checkAdmin(ServiceContext serviceContext, long scopeGroupId) {
		try {
			if (RoleServiceUtil.hasUserRole(serviceContext.getUserId(), serviceContext.getCompanyId(), RoleConstants.ADMINISTRATOR, true))
				return true;
			if (UserGroupRoleLocalServiceUtil.hasUserGroupRole(serviceContext.getUserId(), scopeGroupId, RoleConstants.SITE_OWNER, true))
				return true;
			if (UserGroupRoleLocalServiceUtil.hasUserGroupRole(serviceContext.getUserId(), scopeGroupId, RoleConstants.ADMINISTRATOR, true))
				return true;

		} catch (PortalException | SystemException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static boolean checkMember(ServiceContext serviceContext, long scopeGroupId) {
		try {
			if (UserServiceUtil.hasGroupUser(scopeGroupId, serviceContext.getUserId()))
				return true;

		} catch (PortalException | SystemException e) {
			e.printStackTrace();
		}
		return false;
	}

	public static int checkRole(ServiceContext serviceContext, long scopeGroupId) {
		if (checkGuest(serviceContext))
			return PermissionConstant.SDR_ROLE_GUEST;

		if (checkAdmin(serviceContext, scopeGroupId))
			return PermissionConstant.SDR_ROLE_ADMIN;

		if (checkMember(serviceContext, scopeGroupId))
			return PermissionConstant.SDR_ROLE_MEMBER;

		return PermissionConstant.SDR_ROLE_USER;
	}

}
