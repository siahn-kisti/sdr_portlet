package com.sdr.guide.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sdr.guide.model.Guide;

import java.util.List;

/**
 * The persistence utility for the guide service. This utility wraps {@link GuidePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author heesangbb
 * @see GuidePersistence
 * @see GuidePersistenceImpl
 * @generated
 */
public class GuideUtil {
    private static GuidePersistence _persistence;

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
    public static void clearCache(Guide guide) {
        getPersistence().clearCache(guide);
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
    public static List<Guide> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Guide> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Guide> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Guide update(Guide guide) throws SystemException {
        return getPersistence().update(guide);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Guide update(Guide guide, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(guide, serviceContext);
    }

    /**
    * Returns all the guides where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching guides
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.guide.model.Guide> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid);
    }

    /**
    * Returns a range of all the guides where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.guide.model.impl.GuideModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of guides
    * @param end the upper bound of the range of guides (not inclusive)
    * @return the range of matching guides
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.guide.model.Guide> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end);
    }

    /**
    * Returns an ordered range of all the guides where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.guide.model.impl.GuideModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of guides
    * @param end the upper bound of the range of guides (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching guides
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.guide.model.Guide> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid(uuid, start, end, orderByComparator);
    }

    /**
    * Returns the first guide in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching guide
    * @throws com.sdr.guide.NoSuchGuideException if a matching guide could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.guide.model.Guide findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.guide.NoSuchGuideException {
        return getPersistence().findByUuid_First(uuid, orderByComparator);
    }

    /**
    * Returns the first guide in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching guide, or <code>null</code> if a matching guide could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.guide.model.Guide fetchByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUuid_First(uuid, orderByComparator);
    }

    /**
    * Returns the last guide in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching guide
    * @throws com.sdr.guide.NoSuchGuideException if a matching guide could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.guide.model.Guide findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.guide.NoSuchGuideException {
        return getPersistence().findByUuid_Last(uuid, orderByComparator);
    }

    /**
    * Returns the last guide in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching guide, or <code>null</code> if a matching guide could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.guide.model.Guide fetchByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
    }

    /**
    * Returns the guides before and after the current guide in the ordered set where uuid = &#63;.
    *
    * @param datasetId the primary key of the current guide
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next guide
    * @throws com.sdr.guide.NoSuchGuideException if a guide with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.guide.model.Guide[] findByUuid_PrevAndNext(
        long datasetId, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.guide.NoSuchGuideException {
        return getPersistence()
                   .findByUuid_PrevAndNext(datasetId, uuid, orderByComparator);
    }

    /**
    * Removes all the guides where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public static void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeByUuid(uuid);
    }

    /**
    * Returns the number of guides where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching guides
    * @throws SystemException if a system exception occurred
    */
    public static int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUuid(uuid);
    }

    /**
    * Returns the guide where uuid = &#63; and groupId = &#63; or throws a {@link com.sdr.guide.NoSuchGuideException} if it could not be found.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching guide
    * @throws com.sdr.guide.NoSuchGuideException if a matching guide could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.guide.model.Guide findByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.guide.NoSuchGuideException {
        return getPersistence().findByUUID_G(uuid, groupId);
    }

    /**
    * Returns the guide where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching guide, or <code>null</code> if a matching guide could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.guide.model.Guide fetchByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId);
    }

    /**
    * Returns the guide where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching guide, or <code>null</code> if a matching guide could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.guide.model.Guide fetchByUUID_G(
        java.lang.String uuid, long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
    }

    /**
    * Removes the guide where uuid = &#63; and groupId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the guide that was removed
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.guide.model.Guide removeByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.guide.NoSuchGuideException {
        return getPersistence().removeByUUID_G(uuid, groupId);
    }

    /**
    * Returns the number of guides where uuid = &#63; and groupId = &#63;.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the number of matching guides
    * @throws SystemException if a system exception occurred
    */
    public static int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUUID_G(uuid, groupId);
    }

    /**
    * Returns all the guides where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the matching guides
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.guide.model.Guide> findByUuid_C(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_C(uuid, companyId);
    }

    /**
    * Returns a range of all the guides where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.guide.model.impl.GuideModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of guides
    * @param end the upper bound of the range of guides (not inclusive)
    * @return the range of matching guides
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.guide.model.Guide> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByUuid_C(uuid, companyId, start, end);
    }

    /**
    * Returns an ordered range of all the guides where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.guide.model.impl.GuideModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of guides
    * @param end the upper bound of the range of guides (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching guides
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.guide.model.Guide> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
    }

    /**
    * Returns the first guide in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching guide
    * @throws com.sdr.guide.NoSuchGuideException if a matching guide could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.guide.model.Guide findByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.guide.NoSuchGuideException {
        return getPersistence()
                   .findByUuid_C_First(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the first guide in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching guide, or <code>null</code> if a matching guide could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.guide.model.Guide fetchByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the last guide in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching guide
    * @throws com.sdr.guide.NoSuchGuideException if a matching guide could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.guide.model.Guide findByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.guide.NoSuchGuideException {
        return getPersistence()
                   .findByUuid_C_Last(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the last guide in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching guide, or <code>null</code> if a matching guide could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.guide.model.Guide fetchByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
    }

    /**
    * Returns the guides before and after the current guide in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param datasetId the primary key of the current guide
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next guide
    * @throws com.sdr.guide.NoSuchGuideException if a guide with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.guide.model.Guide[] findByUuid_C_PrevAndNext(
        long datasetId, java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.guide.NoSuchGuideException {
        return getPersistence()
                   .findByUuid_C_PrevAndNext(datasetId, uuid, companyId,
            orderByComparator);
    }

    /**
    * Removes all the guides where uuid = &#63; and companyId = &#63; from the database.
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
    * Returns the number of guides where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the number of matching guides
    * @throws SystemException if a system exception occurred
    */
    public static int countByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByUuid_C(uuid, companyId);
    }

    /**
    * Caches the guide in the entity cache if it is enabled.
    *
    * @param guide the guide
    */
    public static void cacheResult(com.sdr.guide.model.Guide guide) {
        getPersistence().cacheResult(guide);
    }

    /**
    * Caches the guides in the entity cache if it is enabled.
    *
    * @param guides the guides
    */
    public static void cacheResult(
        java.util.List<com.sdr.guide.model.Guide> guides) {
        getPersistence().cacheResult(guides);
    }

    /**
    * Creates a new guide with the primary key. Does not add the guide to the database.
    *
    * @param datasetId the primary key for the new guide
    * @return the new guide
    */
    public static com.sdr.guide.model.Guide create(long datasetId) {
        return getPersistence().create(datasetId);
    }

    /**
    * Removes the guide with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param datasetId the primary key of the guide
    * @return the guide that was removed
    * @throws com.sdr.guide.NoSuchGuideException if a guide with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.guide.model.Guide remove(long datasetId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.guide.NoSuchGuideException {
        return getPersistence().remove(datasetId);
    }

    public static com.sdr.guide.model.Guide updateImpl(
        com.sdr.guide.model.Guide guide)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(guide);
    }

    /**
    * Returns the guide with the primary key or throws a {@link com.sdr.guide.NoSuchGuideException} if it could not be found.
    *
    * @param datasetId the primary key of the guide
    * @return the guide
    * @throws com.sdr.guide.NoSuchGuideException if a guide with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.guide.model.Guide findByPrimaryKey(long datasetId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.guide.NoSuchGuideException {
        return getPersistence().findByPrimaryKey(datasetId);
    }

    /**
    * Returns the guide with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param datasetId the primary key of the guide
    * @return the guide, or <code>null</code> if a guide with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.guide.model.Guide fetchByPrimaryKey(long datasetId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(datasetId);
    }

    /**
    * Returns all the guides.
    *
    * @return the guides
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.guide.model.Guide> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the guides.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.guide.model.impl.GuideModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of guides
    * @param end the upper bound of the range of guides (not inclusive)
    * @return the range of guides
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.guide.model.Guide> findAll(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the guides.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.guide.model.impl.GuideModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of guides
    * @param end the upper bound of the range of guides (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of guides
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.guide.model.Guide> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the guides from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of guides.
    *
    * @return the number of guides
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static GuidePersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (GuidePersistence) PortletBeanLocatorUtil.locate(com.sdr.guide.service.ClpSerializer.getServletContextName(),
                    GuidePersistence.class.getName());

            ReferenceRegistry.registerReference(GuideUtil.class, "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(GuidePersistence persistence) {
    }
}
