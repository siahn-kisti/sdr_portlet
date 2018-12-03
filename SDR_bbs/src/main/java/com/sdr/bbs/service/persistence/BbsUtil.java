package com.sdr.bbs.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sdr.bbs.model.Bbs;

import java.util.List;

/**
 * The persistence utility for the bbs service. This utility wraps {@link BbsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author goopsw
 * @see BbsPersistence
 * @see BbsPersistenceImpl
 * @generated
 */
public class BbsUtil {
    private static BbsPersistence _persistence;

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
     */
    public static void clearCache() {
        getPersistence().clearCache();
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
     */
    public static void clearCache(Bbs bbs) {
        getPersistence().clearCache(bbs);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
     */
    public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().countWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
     */
    public static List<Bbs> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Bbs> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Bbs> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Bbs update(Bbs bbs) throws SystemException {
        return getPersistence().update(bbs);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Bbs update(Bbs bbs, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(bbs, serviceContext);
    }

    /**
    * Returns all the bbses where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching bbses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.bbs.model.Bbs> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid);
    }

    /**
    * Returns a range of all the bbses where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of bbses
    * @param end the upper bound of the range of bbses (not inclusive)
    * @return the range of matching bbses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.bbs.model.Bbs> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end);
    }

    /**
    * Returns an ordered range of all the bbses where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of bbses
    * @param end the upper bound of the range of bbses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching bbses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.bbs.model.Bbs> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end, orderByComparator);
    }

    /**
    * Returns the first bbs in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching bbs
    * @throws com.sdr.bbs.NoSuchBbsException if a matching bbs could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.bbs.model.Bbs findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.bbs.NoSuchBbsException {
        return getPersistence().findByUuid_First(uuid, orderByComparator);
    }

    /**
    * Returns the first bbs in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching bbs, or <code>null</code> if a matching bbs could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.bbs.model.Bbs fetchByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUuid_First(uuid, orderByComparator);
    }

    /**
    * Returns the last bbs in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching bbs
    * @throws com.sdr.bbs.NoSuchBbsException if a matching bbs could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.bbs.model.Bbs findByUuid_Last(java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.bbs.NoSuchBbsException {
        return getPersistence().findByUuid_Last(uuid, orderByComparator);
    }

    /**
    * Returns the last bbs in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching bbs, or <code>null</code> if a matching bbs could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.bbs.model.Bbs fetchByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
    }

    /**
    * Returns the bbses before and after the current bbs in the ordered set where uuid = &#63;.
    *
    * @param bbsId the primary key of the current bbs
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next bbs
    * @throws com.sdr.bbs.NoSuchBbsException if a bbs with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.bbs.model.Bbs[] findByUuid_PrevAndNext(long bbsId,
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.bbs.NoSuchBbsException {
        return getPersistence()
                   .findByUuid_PrevAndNext(bbsId, uuid, orderByComparator);
    }

    /**
    * Removes all the bbses where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUuid(uuid);
    }

    /**
    * Returns the number of bbses where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching bbses
    * @throws SystemException if a system exception occurred
    */
    public static int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUuid(uuid);
    }

    /**
    * Returns the bbs where uuid = &#63; and groupId = &#63; or throws a {@link com.sdr.bbs.NoSuchBbsException} if it could not be found.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching bbs
    * @throws com.sdr.bbs.NoSuchBbsException if a matching bbs could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.bbs.model.Bbs findByUUID_G(java.lang.String uuid,
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.bbs.NoSuchBbsException {
        return getPersistence().findByUUID_G(uuid, groupId);
    }

    /**
    * Returns the bbs where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching bbs, or <code>null</code> if a matching bbs could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.bbs.model.Bbs fetchByUUID_G(java.lang.String uuid,
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId);
    }

    /**
    * Returns the bbs where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching bbs, or <code>null</code> if a matching bbs could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.bbs.model.Bbs fetchByUUID_G(java.lang.String uuid,
        long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
    }

    /**
    * Removes the bbs where uuid = &#63; and groupId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the bbs that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.bbs.model.Bbs removeByUUID_G(java.lang.String uuid,
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.bbs.NoSuchBbsException {
        return getPersistence().removeByUUID_G(uuid, groupId);
    }

    /**
    * Returns the number of bbses where uuid = &#63; and groupId = &#63;.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the number of matching bbses
    * @throws SystemException if a system exception occurred
    */
    public static int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUUID_G(uuid, groupId);
    }

    /**
    * Returns all the bbses where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the matching bbses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.bbs.model.Bbs> findByUuid_C(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_C(uuid, companyId);
    }

    /**
    * Returns a range of all the bbses where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of bbses
    * @param end the upper bound of the range of bbses (not inclusive)
    * @return the range of matching bbses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.bbs.model.Bbs> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_C(uuid, companyId, start, end);
    }

    /**
    * Returns an ordered range of all the bbses where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of bbses
    * @param end the upper bound of the range of bbses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching bbses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.bbs.model.Bbs> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
    }

    /**
    * Returns the first bbs in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching bbs
    * @throws com.sdr.bbs.NoSuchBbsException if a matching bbs could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.bbs.model.Bbs findByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.bbs.NoSuchBbsException {
        return getPersistence()
                   .findByUuid_C_First(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the first bbs in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching bbs, or <code>null</code> if a matching bbs could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.bbs.model.Bbs fetchByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the last bbs in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching bbs
    * @throws com.sdr.bbs.NoSuchBbsException if a matching bbs could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.bbs.model.Bbs findByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.bbs.NoSuchBbsException {
        return getPersistence()
                   .findByUuid_C_Last(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the last bbs in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching bbs, or <code>null</code> if a matching bbs could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.bbs.model.Bbs fetchByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the bbses before and after the current bbs in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param bbsId the primary key of the current bbs
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next bbs
    * @throws com.sdr.bbs.NoSuchBbsException if a bbs with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.bbs.model.Bbs[] findByUuid_C_PrevAndNext(long bbsId,
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.bbs.NoSuchBbsException {
        return getPersistence()
                   .findByUuid_C_PrevAndNext(bbsId, uuid, companyId,
            orderByComparator);
    }

    /**
    * Removes all the bbses where uuid = &#63; and companyId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUuid_C(uuid, companyId);
    }

    /**
    * Returns the number of bbses where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the number of matching bbses
    * @throws SystemException if a system exception occurred
    */
    public static int countByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUuid_C(uuid, companyId);
    }

    /**
    * Returns all the bbses where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @return the matching bbses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.bbs.model.Bbs> findByC_G(
        long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByC_G(companyId, groupId);
    }

    /**
    * Returns a range of all the bbses where companyId = &#63; and groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param start the lower bound of the range of bbses
    * @param end the upper bound of the range of bbses (not inclusive)
    * @return the range of matching bbses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.bbs.model.Bbs> findByC_G(
        long companyId, long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByC_G(companyId, groupId, start, end);
    }

    /**
    * Returns an ordered range of all the bbses where companyId = &#63; and groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param start the lower bound of the range of bbses
    * @param end the upper bound of the range of bbses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching bbses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.bbs.model.Bbs> findByC_G(
        long companyId, long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByC_G(companyId, groupId, start, end, orderByComparator);
    }

    /**
    * Returns the first bbs in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching bbs
    * @throws com.sdr.bbs.NoSuchBbsException if a matching bbs could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.bbs.model.Bbs findByC_G_First(long companyId,
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.bbs.NoSuchBbsException {
        return getPersistence()
                   .findByC_G_First(companyId, groupId, orderByComparator);
    }

    /**
    * Returns the first bbs in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching bbs, or <code>null</code> if a matching bbs could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.bbs.model.Bbs fetchByC_G_First(long companyId,
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByC_G_First(companyId, groupId, orderByComparator);
    }

    /**
    * Returns the last bbs in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching bbs
    * @throws com.sdr.bbs.NoSuchBbsException if a matching bbs could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.bbs.model.Bbs findByC_G_Last(long companyId,
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.bbs.NoSuchBbsException {
        return getPersistence()
                   .findByC_G_Last(companyId, groupId, orderByComparator);
    }

    /**
    * Returns the last bbs in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching bbs, or <code>null</code> if a matching bbs could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.bbs.model.Bbs fetchByC_G_Last(long companyId,
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByC_G_Last(companyId, groupId, orderByComparator);
    }

    /**
    * Returns the bbses before and after the current bbs in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param bbsId the primary key of the current bbs
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next bbs
    * @throws com.sdr.bbs.NoSuchBbsException if a bbs with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.bbs.model.Bbs[] findByC_G_PrevAndNext(long bbsId,
        long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.bbs.NoSuchBbsException {
        return getPersistence()
                   .findByC_G_PrevAndNext(bbsId, companyId, groupId,
            orderByComparator);
    }

    /**
    * Returns all the bbses that the user has permission to view where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @return the matching bbses that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.bbs.model.Bbs> filterFindByC_G(
        long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().filterFindByC_G(companyId, groupId);
    }

    /**
    * Returns a range of all the bbses that the user has permission to view where companyId = &#63; and groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param start the lower bound of the range of bbses
    * @param end the upper bound of the range of bbses (not inclusive)
    * @return the range of matching bbses that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.bbs.model.Bbs> filterFindByC_G(
        long companyId, long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().filterFindByC_G(companyId, groupId, start, end);
    }

    /**
    * Returns an ordered range of all the bbses that the user has permissions to view where companyId = &#63; and groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param start the lower bound of the range of bbses
    * @param end the upper bound of the range of bbses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching bbses that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.bbs.model.Bbs> filterFindByC_G(
        long companyId, long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .filterFindByC_G(companyId, groupId, start, end,
            orderByComparator);
    }

    /**
    * Returns the bbses before and after the current bbs in the ordered set of bbses that the user has permission to view where companyId = &#63; and groupId = &#63;.
    *
    * @param bbsId the primary key of the current bbs
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next bbs
    * @throws com.sdr.bbs.NoSuchBbsException if a bbs with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.bbs.model.Bbs[] filterFindByC_G_PrevAndNext(
        long bbsId, long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.bbs.NoSuchBbsException {
        return getPersistence()
                   .filterFindByC_G_PrevAndNext(bbsId, companyId, groupId,
            orderByComparator);
    }

    /**
    * Removes all the bbses where companyId = &#63; and groupId = &#63; from the database.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public static void removeByC_G(long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByC_G(companyId, groupId);
    }

    /**
    * Returns the number of bbses where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @return the number of matching bbses
    * @throws SystemException if a system exception occurred
    */
    public static int countByC_G(long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByC_G(companyId, groupId);
    }

    /**
    * Returns the number of bbses that the user has permission to view where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @return the number of matching bbses that the user has permission to view
    * @throws SystemException if a system exception occurred
    */
    public static int filterCountByC_G(long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().filterCountByC_G(companyId, groupId);
    }

    /**
    * Caches the bbs in the entity cache if it is enabled.
    *
    * @param bbs the bbs
    */
    public static void cacheResult(com.sdr.bbs.model.Bbs bbs) {
        getPersistence().cacheResult(bbs);
    }

    /**
    * Caches the bbses in the entity cache if it is enabled.
    *
    * @param bbses the bbses
    */
    public static void cacheResult(java.util.List<com.sdr.bbs.model.Bbs> bbses) {
        getPersistence().cacheResult(bbses);
    }

    /**
    * Creates a new bbs with the primary key. Does not add the bbs to the database.
    *
    * @param bbsId the primary key for the new bbs
    * @return the new bbs
    */
    public static com.sdr.bbs.model.Bbs create(long bbsId) {
        return getPersistence().create(bbsId);
    }

    /**
    * Removes the bbs with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param bbsId the primary key of the bbs
    * @return the bbs that was removed
    * @throws com.sdr.bbs.NoSuchBbsException if a bbs with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.bbs.model.Bbs remove(long bbsId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.bbs.NoSuchBbsException {
        return getPersistence().remove(bbsId);
    }

    public static com.sdr.bbs.model.Bbs updateImpl(com.sdr.bbs.model.Bbs bbs)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(bbs);
    }

    /**
    * Returns the bbs with the primary key or throws a {@link com.sdr.bbs.NoSuchBbsException} if it could not be found.
    *
    * @param bbsId the primary key of the bbs
    * @return the bbs
    * @throws com.sdr.bbs.NoSuchBbsException if a bbs with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.bbs.model.Bbs findByPrimaryKey(long bbsId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.bbs.NoSuchBbsException {
        return getPersistence().findByPrimaryKey(bbsId);
    }

    /**
    * Returns the bbs with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param bbsId the primary key of the bbs
    * @return the bbs, or <code>null</code> if a bbs with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.bbs.model.Bbs fetchByPrimaryKey(long bbsId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(bbsId);
    }

    /**
    * Returns all the bbses.
    *
    * @return the bbses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.bbs.model.Bbs> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the bbses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of bbses
    * @param end the upper bound of the range of bbses (not inclusive)
    * @return the range of bbses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.bbs.model.Bbs> findAll(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the bbses.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.bbs.model.impl.BbsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of bbses
    * @param end the upper bound of the range of bbses (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of bbses
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.bbs.model.Bbs> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the bbses from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of bbses.
    *
    * @return the number of bbses
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static BbsPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (BbsPersistence) PortletBeanLocatorUtil.locate(com.sdr.bbs.service.ClpSerializer.getServletContextName(),
                    BbsPersistence.class.getName());

            ReferenceRegistry.registerReference(BbsUtil.class, "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(BbsPersistence persistence) {
    }
}
