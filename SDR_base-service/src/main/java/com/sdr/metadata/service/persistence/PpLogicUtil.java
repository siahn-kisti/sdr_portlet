package com.sdr.metadata.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sdr.metadata.model.PpLogic;

import java.util.List;

/**
 * The persistence utility for the pp logic service. This utility wraps {@link PpLogicPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author jaesung
 * @see PpLogicPersistence
 * @see PpLogicPersistenceImpl
 * @generated
 */
public class PpLogicUtil {
    private static PpLogicPersistence _persistence;

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
    public static void clearCache(PpLogic ppLogic) {
        getPersistence().clearCache(ppLogic);
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
    public static List<PpLogic> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<PpLogic> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<PpLogic> findWithDynamicQuery(
        DynamicQuery dynamicQuery, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static PpLogic update(PpLogic ppLogic) throws SystemException {
        return getPersistence().update(ppLogic);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static PpLogic update(PpLogic ppLogic, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(ppLogic, serviceContext);
    }

    /**
    * Caches the pp logic in the entity cache if it is enabled.
    *
    * @param ppLogic the pp logic
    */
    public static void cacheResult(com.sdr.metadata.model.PpLogic ppLogic) {
        getPersistence().cacheResult(ppLogic);
    }

    /**
    * Caches the pp logics in the entity cache if it is enabled.
    *
    * @param ppLogics the pp logics
    */
    public static void cacheResult(
        java.util.List<com.sdr.metadata.model.PpLogic> ppLogics) {
        getPersistence().cacheResult(ppLogics);
    }

    /**
    * Creates a new pp logic with the primary key. Does not add the pp logic to the database.
    *
    * @param ppId the primary key for the new pp logic
    * @return the new pp logic
    */
    public static com.sdr.metadata.model.PpLogic create(long ppId) {
        return getPersistence().create(ppId);
    }

    /**
    * Removes the pp logic with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param ppId the primary key of the pp logic
    * @return the pp logic that was removed
    * @throws com.sdr.metadata.NoSuchPpLogicException if a pp logic with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.PpLogic remove(long ppId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchPpLogicException {
        return getPersistence().remove(ppId);
    }

    public static com.sdr.metadata.model.PpLogic updateImpl(
        com.sdr.metadata.model.PpLogic ppLogic)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(ppLogic);
    }

    /**
    * Returns the pp logic with the primary key or throws a {@link com.sdr.metadata.NoSuchPpLogicException} if it could not be found.
    *
    * @param ppId the primary key of the pp logic
    * @return the pp logic
    * @throws com.sdr.metadata.NoSuchPpLogicException if a pp logic with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.PpLogic findByPrimaryKey(long ppId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.metadata.NoSuchPpLogicException {
        return getPersistence().findByPrimaryKey(ppId);
    }

    /**
    * Returns the pp logic with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param ppId the primary key of the pp logic
    * @return the pp logic, or <code>null</code> if a pp logic with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.metadata.model.PpLogic fetchByPrimaryKey(long ppId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(ppId);
    }

    /**
    * Returns all the pp logics.
    *
    * @return the pp logics
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.PpLogic> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the pp logics.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.PpLogicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of pp logics
    * @param end the upper bound of the range of pp logics (not inclusive)
    * @return the range of pp logics
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.PpLogic> findAll(
        int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the pp logics.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.metadata.model.impl.PpLogicModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of pp logics
    * @param end the upper bound of the range of pp logics (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of pp logics
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.metadata.model.PpLogic> findAll(
        int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the pp logics from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of pp logics.
    *
    * @return the number of pp logics
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static PpLogicPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (PpLogicPersistence) PortletBeanLocatorUtil.locate(com.sdr.metadata.service.ClpSerializer.getServletContextName(),
                    PpLogicPersistence.class.getName());

            ReferenceRegistry.registerReference(PpLogicUtil.class,
                "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(PpLogicPersistence persistence) {
    }
}
