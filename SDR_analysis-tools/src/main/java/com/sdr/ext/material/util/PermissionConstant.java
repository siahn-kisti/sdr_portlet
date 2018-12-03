package com.sdr.ext.material.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.BooleanQueryFactoryUtil;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.service.UserServiceUtil;

import java.util.Date;
import java.util.List;

public class PermissionConstant {
    private static Log _log = LogFactoryUtil.getLog(PermissionConstant.class);

    final static boolean SDR_AC_DISABLE = false;
    final static boolean SDR_EMBARGO_DISABLE = false;

    public final static int SDR_EMBARGO_AMOUNT = -365;

    final static int SDR_ROLE_GUEST = 1;
    final static int SDR_ROLE_USER = 2;
    final static int SDR_ROLE_MEMBER = 3;
    final static int SDR_ROLE_GROUP = 4;
    final static int SDR_ROLE_OWNER = 5;
    final static int SDR_ROLE_ADMIN = 6;
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

    final static int SDR_PERM_DEFAULT = 0x110;

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

    public static int getDefaultPerm() {
        return PermissionConstant.SDR_PERM_DEFAULT;
    }

    public static int convertPerm(int community, int group, int user, int guest) throws Exception {
        int perm = 0;

        switch (community) {
            case SDR_ACTION_UPDATE:
                perm |= SDR_PERM_COMMUNITY_UPDATE;
            case SDR_ACTION_CREATE:
                perm |= SDR_PERM_COMMUNITY_CREATE;
            case SDR_ACTION_READ:
                perm |= SDR_PERM_COMMUNITY_READ;
            case SDR_ACTION_NONE:
                break;
            default:
                throw new Exception("undefined value for community permission");
        }

        switch (group) {
            case SDR_ACTION_UPDATE:
                perm |= SDR_PERM_GROUP_UPDATE;
            case SDR_ACTION_CREATE:
                perm |= SDR_PERM_GROUP_CREATE;
            case SDR_ACTION_READ:
                perm |= SDR_PERM_GROUP_READ;
                break;
            case SDR_ACTION_NONE:
                break;
            default:
                throw new Exception("undefined value for group permission");
        }

        switch (user) {
            case SDR_ACTION_UPDATE:
                perm |= SDR_PERM_USER_UPDATE;
            case SDR_ACTION_CREATE:
                perm |= SDR_PERM_USER_CREATE;
            case SDR_ACTION_READ:
                perm |= SDR_PERM_USER_READ;
                break;
            case SDR_ACTION_NONE:
                break;
            default:
                throw new Exception("undefined value for user permission");
        }

        switch (guest) {
            case SDR_ACTION_READ:
                perm |= SDR_PERM_GUEST_READ;
                break;
            case SDR_ACTION_NONE:
                break;
            default:
                throw new Exception("undefined value for guest permission");
        }

        return perm;
    }

    public static String getStringforPermission(int perm) {
        char[] policy = new char[10];

        if ((perm & SDR_PERM_GROUP_READ) > 0)
            policy[0] = 'R';
        else
            policy[0] = '_';

        if ((perm & SDR_PERM_GROUP_CREATE) > 0)
            policy[1] = 'C';
        else
            policy[1] = '_';

        if ((perm & SDR_PERM_GROUP_UPDATE) > 0)
            policy[2] = 'U';
        else
            policy[2] = '_';

        if ((perm & SDR_PERM_COMMUNITY_READ) > 0)
            policy[3] = 'R';
        else
            policy[3] = '_';

        if ((perm & SDR_PERM_COMMUNITY_CREATE) > 0)
            policy[4] = 'C';
        else
            policy[4] = '_';

        if ((perm & SDR_PERM_COMMUNITY_UPDATE) > 0)
            policy[5] = 'U';
        else
            policy[5] = '_';

        if ((perm & SDR_PERM_USER_READ) > 0)
            policy[6] = 'R';
        else
            policy[6] = '_';

        if ((perm & SDR_PERM_USER_CREATE) > 0)
            policy[7] = 'C';
        else
            policy[7] = '_';

        if ((perm & SDR_PERM_USER_UPDATE) > 0)
            policy[8] = 'U';
        else
            policy[8] = '_';

        if ((perm & SDR_PERM_GUEST_READ) > 0)
            policy[9] = 'R';
        else
            policy[9] = '_';

        return new String(policy);
    }

    public static String getStringforRole(int role) {
        switch (role) {
            case PermissionConstant.SDR_ROLE_GUEST:
                return "GUEST";
            case PermissionConstant.SDR_ROLE_ADMIN:
                return "ADMIN";
            case PermissionConstant.SDR_ROLE_OWNER:
                return "OWNER";
            case PermissionConstant.SDR_ROLE_GROUP:
                return "ALLOWED_USER";
            case PermissionConstant.SDR_ROLE_MEMBER:
                return "COMMUNITY_MEMBER";
            case PermissionConstant.SDR_ROLE_USER:
                return "USER";
            default:
                return "INVALID";
        }
    }

    public static String getStringforAction(int action) {
        String target;
        switch (action & 0xF0) {
            case SDR_ACTION_COLLECTION:
                target = "COLLECTION";
                break;
            case SDR_ACTION_DATASET:
                target = "DATASET";
                break;
            case SDR_ACTION_DATATYPE:
                target = "DATATYPE";
                break;
            case SDR_ACTION_DATAVIEW:
                target = "DATAVIEW";
                break;
            case SDR_ACTION_USER:
                target = "USER";
                break;
            default:
                target = "INVALID";
        }

        String request;
        switch (action & 0xF) {
            case SDR_ACTION_READ:
                request = "read";
                break;
            case SDR_ACTION_CREATE:
                request = "create";
                break;
            case SDR_ACTION_UPDATE:
                request = "Update";
                break;
            case SDR_ACTION_DELETE:
                request = "Delete";
                break;
            case SDR_ACTION_SEARCH:
                request = "Search";
                break;
            case SDR_ACTION_REQUEST:
                request = "request";
                break;
            default:
                request = "Invalid";
        }

        return target + "_" + request;

    }

    public static Hits checkAndQuery(ServiceContext serviceContext, SearchContext searchContext, BooleanQuery mainQuery)
            throws SearchException, PortalException {
        if (PermissionConstant.SDR_AC_DISABLE) {
            _log.debug("Access Control is disabled");
            return SearchEngineUtil.search(searchContext, mainQuery);
        }

        _log.debug("querySearchEngine : " + mainQuery);

        if (PermissionConstant.checkAdmin(serviceContext, serviceContext.getScopeGroupId())) {
            _log.debug("allow all collections for admin");
            return SearchEngineUtil.search(searchContext, mainQuery);
        } else {
            List<Long> collections = null;
            try {
                collections = SearchPermission.get(serviceContext);
            } catch (Exception e) {
                throw new SearchException();
            }

            if (collections.isEmpty()) {
                _log.debug("No collection found");
                return SearchPermission.getHits();
            }

            BooleanQuery extraQuery = BooleanQueryFactoryUtil.create(searchContext);
            for (Long coll : collections) {
                BooleanQuery subQuery = BooleanQueryFactoryUtil.create(searchContext);
                subQuery.addExactTerm("collectionId", coll);
                extraQuery.add(subQuery, BooleanClauseOccur.SHOULD);
            }
            mainQuery.add(extraQuery, BooleanClauseOccur.MUST);

            _log.debug("with permission string : " + mainQuery);
            return SearchEngineUtil.search(searchContext, mainQuery);
        }
    }

    public static String revertPerm(int permission) {

        String permString = "7777";

        int guestAction = SDR_ACTION_NONE;
        int userAction = SDR_ACTION_NONE;
        int communityAction = SDR_ACTION_NONE;
        int groupAction = SDR_ACTION_NONE;

        if (permission - PermissionConstant.SDR_PERM_GUEST_READ > -1) {
            permission = permission - PermissionConstant.SDR_PERM_GUEST_READ;
            guestAction = SDR_ACTION_READ;
        }

        if (permission - (PermissionConstant.SDR_PERM_USER_UPDATE + PermissionConstant.SDR_PERM_USER_CREATE + PermissionConstant.SDR_PERM_USER_READ) > -1) {
            permission = permission - (PermissionConstant.SDR_PERM_USER_UPDATE + PermissionConstant.SDR_PERM_USER_CREATE + PermissionConstant.SDR_PERM_USER_READ);
            userAction = SDR_ACTION_UPDATE;
        } else if (permission - (PermissionConstant.SDR_PERM_USER_CREATE + PermissionConstant.SDR_PERM_USER_READ) > -1) {
            permission = permission - (PermissionConstant.SDR_PERM_USER_CREATE + PermissionConstant.SDR_PERM_USER_READ);
            userAction = SDR_ACTION_CREATE;
        } else if (permission - PermissionConstant.SDR_PERM_USER_READ > -1) {
            permission = permission - PermissionConstant.SDR_PERM_USER_READ;
            userAction = SDR_ACTION_READ;
        }

        if (permission - (PermissionConstant.SDR_PERM_COMMUNITY_UPDATE + PermissionConstant.SDR_PERM_COMMUNITY_CREATE + PermissionConstant.SDR_PERM_COMMUNITY_READ) > -1) {
            permission = permission - (PermissionConstant.SDR_PERM_COMMUNITY_UPDATE + PermissionConstant.SDR_PERM_COMMUNITY_CREATE + PermissionConstant.SDR_PERM_COMMUNITY_READ);
            communityAction = SDR_ACTION_UPDATE;
        } else if (permission - (PermissionConstant.SDR_PERM_COMMUNITY_CREATE + PermissionConstant.SDR_PERM_COMMUNITY_READ) > -1) {
            permission = permission - (PermissionConstant.SDR_PERM_COMMUNITY_CREATE + PermissionConstant.SDR_PERM_COMMUNITY_READ);
            communityAction = SDR_ACTION_CREATE;
        } else if (permission - PermissionConstant.SDR_PERM_COMMUNITY_READ > -1) {
            permission = permission - PermissionConstant.SDR_PERM_COMMUNITY_READ;
            communityAction = SDR_ACTION_READ;
        }

        if (permission - (PermissionConstant.SDR_PERM_GROUP_UPDATE + PermissionConstant.SDR_PERM_GROUP_CREATE + PermissionConstant.SDR_PERM_GROUP_READ) > -1) {
            permission = permission - (PermissionConstant.SDR_PERM_GROUP_UPDATE + PermissionConstant.SDR_PERM_GROUP_CREATE + PermissionConstant.SDR_PERM_GROUP_READ);
            groupAction = SDR_ACTION_UPDATE;
        } else if (permission - (PermissionConstant.SDR_PERM_GROUP_CREATE + PermissionConstant.SDR_PERM_GROUP_READ) > -1) {
            permission = permission - (PermissionConstant.SDR_PERM_GROUP_CREATE + PermissionConstant.SDR_PERM_GROUP_READ);
            groupAction = SDR_ACTION_CREATE;
        } else if (permission - PermissionConstant.SDR_PERM_GROUP_READ > -1) {
            permission = permission - PermissionConstant.SDR_PERM_GROUP_READ;
            groupAction = SDR_ACTION_READ;
        }

        System.out.println("au: " + groupAction + " cu: " + communityAction + " u: " + userAction + " gu: " + guestAction);

        permString = Integer.toString(groupAction) + Integer.toString(communityAction) + Integer.toString(userAction) + Integer.toString(guestAction);
        return permString;
    }

    public static int checkEmbago(int userPerm, Date createDate) {
        int available = 0;

        long today = new Date().getTime() / (1000 * 60 * 60 * 24);
        long crtDate = createDate.getTime() / (1000 * 60 * 60 * 24);

        long embagoDate = (today - crtDate) + SDR_EMBARGO_AMOUNT;

        available = (int) Math.abs(embagoDate);

        if (SDR_EMBARGO_DISABLE == true) {
            available = 0;
        } else if (userPerm > 0 && userPerm < 5) {
            available = 0;
        } else if (embagoDate > -1) {
            available = 0;
        }

        return available;
    }
}
