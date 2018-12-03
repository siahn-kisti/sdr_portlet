package com.sdr.guide.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sdr.guide.model.Guide;

/**
 * The persistence interface for the guide service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author heesangbb
 * @see GuidePersistenceImpl
 * @see GuideUtil
 * @generated
 */
public interface GuidePersistence extends BasePersistence<Guide> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link GuideUtil} to access the guide persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the guides where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching guides
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.guide.model.Guide> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.sdr.guide.model.Guide> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.sdr.guide.model.Guide> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first guide in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching guide
    * @throws com.sdr.guide.NoSuchGuideException if a matching guide could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.guide.model.Guide findByUuid_First(java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.guide.NoSuchGuideException;

    /**
    * Returns the first guide in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching guide, or <code>null</code> if a matching guide could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.guide.model.Guide fetchByUuid_First(java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last guide in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching guide
    * @throws com.sdr.guide.NoSuchGuideException if a matching guide could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.guide.model.Guide findByUuid_Last(java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.guide.NoSuchGuideException;

    /**
    * Returns the last guide in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching guide, or <code>null</code> if a matching guide could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.guide.model.Guide fetchByUuid_Last(java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.sdr.guide.model.Guide[] findByUuid_PrevAndNext(long datasetId,
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.guide.NoSuchGuideException;

    /**
    * Removes all the guides where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of guides where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching guides
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the guide where uuid = &#63; and groupId = &#63; or throws a {@link com.sdr.guide.NoSuchGuideException} if it could not be found.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching guide
    * @throws com.sdr.guide.NoSuchGuideException if a matching guide could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.guide.model.Guide findByUUID_G(java.lang.String uuid,
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.guide.NoSuchGuideException;

    /**
    * Returns the guide where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching guide, or <code>null</code> if a matching guide could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.guide.model.Guide fetchByUUID_G(java.lang.String uuid,
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the guide where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching guide, or <code>null</code> if a matching guide could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.guide.model.Guide fetchByUUID_G(java.lang.String uuid,
        long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the guide where uuid = &#63; and groupId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the guide that was removed
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.guide.model.Guide removeByUUID_G(java.lang.String uuid,
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.guide.NoSuchGuideException;

    /**
    * Returns the number of guides where uuid = &#63; and groupId = &#63;.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the number of matching guides
    * @throws SystemException if a system exception occurred
    */
    public int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the guides where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the matching guides
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.guide.model.Guide> findByUuid_C(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.sdr.guide.model.Guide> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.sdr.guide.model.Guide> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.sdr.guide.model.Guide findByUuid_C_First(java.lang.String uuid,
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.guide.NoSuchGuideException;

    /**
    * Returns the first guide in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching guide, or <code>null</code> if a matching guide could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.guide.model.Guide fetchByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.sdr.guide.model.Guide findByUuid_C_Last(java.lang.String uuid,
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.guide.NoSuchGuideException;

    /**
    * Returns the last guide in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching guide, or <code>null</code> if a matching guide could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.guide.model.Guide fetchByUuid_C_Last(java.lang.String uuid,
        long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.sdr.guide.model.Guide[] findByUuid_C_PrevAndNext(
        long datasetId, java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.guide.NoSuchGuideException;

    /**
    * Removes all the guides where uuid = &#63; and companyId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of guides where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the number of matching guides
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the guide in the entity cache if it is enabled.
    *
    * @param guide the guide
    */
    public void cacheResult(com.sdr.guide.model.Guide guide);

    /**
    * Caches the guides in the entity cache if it is enabled.
    *
    * @param guides the guides
    */
    public void cacheResult(java.util.List<com.sdr.guide.model.Guide> guides);

    /**
    * Creates a new guide with the primary key. Does not add the guide to the database.
    *
    * @param datasetId the primary key for the new guide
    * @return the new guide
    */
    public com.sdr.guide.model.Guide create(long datasetId);

    /**
    * Removes the guide with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param datasetId the primary key of the guide
    * @return the guide that was removed
    * @throws com.sdr.guide.NoSuchGuideException if a guide with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.guide.model.Guide remove(long datasetId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.guide.NoSuchGuideException;

    public com.sdr.guide.model.Guide updateImpl(com.sdr.guide.model.Guide guide)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the guide with the primary key or throws a {@link com.sdr.guide.NoSuchGuideException} if it could not be found.
    *
    * @param datasetId the primary key of the guide
    * @return the guide
    * @throws com.sdr.guide.NoSuchGuideException if a guide with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.guide.model.Guide findByPrimaryKey(long datasetId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.guide.NoSuchGuideException;

    /**
    * Returns the guide with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param datasetId the primary key of the guide
    * @return the guide, or <code>null</code> if a guide with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.guide.model.Guide fetchByPrimaryKey(long datasetId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the guides.
    *
    * @return the guides
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.guide.model.Guide> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.sdr.guide.model.Guide> findAll(int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.sdr.guide.model.Guide> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the guides from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of guides.
    *
    * @return the number of guides
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
