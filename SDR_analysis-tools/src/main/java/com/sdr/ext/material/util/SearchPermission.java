package com.sdr.ext.material.util;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.HitsImpl;
import com.liferay.portal.kernel.search.StringQueryImpl;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;
import com.sdr.metadata.model.Collection;
import com.sdr.metadata.service.CollectionLocalServiceUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * The type Search permission.
 */
public class SearchPermission {

    private static Log _log = LogFactoryUtil.getLog(SearchPermission.class);
    /**
     * The constant groupName.
     */
    final static String groupName = GroupConstants.GUEST;
    /**
     * The constant companyId.
     */
    final static long companyId = PortalUtil.getDefaultCompanyId();


    /**
     * Get list.
     *
     * @param serviceContext the service context
     * @return the list
     * @throws PortalException the portal exception
     * @throws SystemException the system exception
    */

    public static List<Long> get(ServiceContext serviceContext)
        throws PortalException, SystemException {
        int permissionCut = PermissionConstant.SDR_PERM_GUEST_READ;
        List<Long> collections = new ArrayList<Long>();

        long guestGroupId = GroupLocalServiceUtil.getGroup(companyId, groupName).getGroupId();

        long targetGroupId = serviceContext.getScopeGroupId();
        _log.debug("guestGroupId : " + guestGroupId);
        _log.debug("targetGroupId : " + targetGroupId);

        DynamicQuery query = DynamicQueryFactoryUtil.forClass(Collection.class);

        Criterion criterion = PropertyFactoryUtil.forName("userId").eq(serviceContext.getUserId());

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        // calendar.add(Calendar.YEAR, -1);
        calendar.add(Calendar.DAY_OF_WEEK, PermissionConstant.SDR_EMBARGO_AMOUNT);

        if ( (guestGroupId != targetGroupId) && (targetGroupId != 0)) {
          if (PermissionConstant.checkMember(serviceContext, serviceContext.getScopeGroupId())) {
                _log.debug("search permissionCut set for Member");
                permissionCut = PermissionConstant.SDR_PERM_COMMUNITY_READ;
                if ( ! PermissionConstant.SDR_EMBARGO_DISABLE )
                    criterion = RestrictionsFactoryUtil.or(criterion, PropertyFactoryUtil.forName("createDate").lt(calendar.getTime()));
            } else if (PermissionConstant.checkGuest(serviceContext)) {
                _log.debug("search permissionCut set for Guest");
                permissionCut = PermissionConstant.SDR_PERM_GUEST_READ;
            } else {
                _log.debug("search permissionCut set for User");
                permissionCut = PermissionConstant.SDR_PERM_USER_READ;
              if ( ! PermissionConstant.SDR_EMBARGO_DISABLE )
                  criterion = RestrictionsFactoryUtil.or(criterion, PropertyFactoryUtil.forName("createDate").lt(calendar.getTime()));
            }

            criterion = RestrictionsFactoryUtil.or(criterion, PropertyFactoryUtil.forName("accessPolicy").ge(permissionCut));
            criterion = RestrictionsFactoryUtil.and(criterion, PropertyFactoryUtil.forName("groupId").eq(serviceContext.getScopeGroupId()));
            query.add(criterion);
        } else {
            if (PermissionConstant.checkGuest(serviceContext)) {
                _log.debug("search permissionCut set for Guest");
                permissionCut = PermissionConstant.SDR_PERM_GUEST_READ;
            } else {
                _log.debug("search permissionCut set for User");
                permissionCut = PermissionConstant.SDR_PERM_USER_READ;
                if ( ! PermissionConstant.SDR_EMBARGO_DISABLE )
                    criterion = RestrictionsFactoryUtil.or(criterion, PropertyFactoryUtil.forName("createDate").lt(calendar.getTime()));
            }

            criterion = RestrictionsFactoryUtil.or(criterion, PropertyFactoryUtil.forName("accessPolicy").ge(permissionCut));
            query.add(criterion);
        }

        _log.debug("search string : " + query);

        try {
            List<Collection> lc = CollectionLocalServiceUtil.dynamicQuery(query);
            for (Collection c : lc) {
                collections.add(c.getCollectionId());
            }
        } catch (SystemException e) {
            e.printStackTrace();
        }

        _log.debug("search perm check result : " + collections);

        return collections;
    }

    /**
     * Gets hits.
     *
     * @return the hits
     */
    public static Hits getHits() {
        Hits hits = new HitsImpl();
        hits.setCollatedSpellCheckResult("");
        hits.setDocs(new Document[0]);
        hits.setLength(0);
        hits.setQuery(new StringQueryImpl(""));
        hits.setQuerySuggestions(new String[0]);
        hits.setQueryTerms(new String[0]);
        hits.setLength(0);
        hits.setScores(new float[0]);
        hits.setSearchTime(0.0F);
        hits.setSnippets(new String[0]);
        hits.setStart(0L);
        return hits;
    }

}
