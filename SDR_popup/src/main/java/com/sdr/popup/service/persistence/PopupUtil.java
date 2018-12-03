package com.sdr.popup.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sdr.popup.model.Popup;

import java.util.List;

/**
 * The persistence utility for the popup service. This utility wraps {@link PopupPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author goopsw
 * @see PopupPersistence
 * @see PopupPersistenceImpl
 * @generated
 */
public class PopupUtil {
    private static PopupPersistence _persistence;

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
    public static void clearCache(Popup popup) {
        getPersistence().clearCache(popup);
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
    public static List<Popup> findWithDynamicQuery(DynamicQuery dynamicQuery)
        throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
     */
    public static List<Popup> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end) throws SystemException {
        return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
     */
    public static List<Popup> findWithDynamicQuery(DynamicQuery dynamicQuery,
        int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        return getPersistence()
                   .findWithDynamicQuery(dynamicQuery, start, end,
            orderByComparator);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
     */
    public static Popup update(Popup popup) throws SystemException {
        return getPersistence().update(popup);
    }

    /**
     * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
     */
    public static Popup update(Popup popup, ServiceContext serviceContext)
        throws SystemException {
        return getPersistence().update(popup, serviceContext);
    }

    /**
    * Returns all the popups where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @return the matching popups
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.popup.model.Popup> findByC_G(
        long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByC_G(companyId, groupId);
    }

    /**
    * Returns a range of all the popups where companyId = &#63; and groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.popup.model.impl.PopupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param start the lower bound of the range of popups
    * @param end the upper bound of the range of popups (not inclusive)
    * @return the range of matching popups
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.popup.model.Popup> findByC_G(
        long companyId, long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findByC_G(companyId, groupId, start, end);
    }

    /**
    * Returns an ordered range of all the popups where companyId = &#63; and groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.popup.model.impl.PopupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param start the lower bound of the range of popups
    * @param end the upper bound of the range of popups (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching popups
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.popup.model.Popup> findByC_G(
        long companyId, long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByC_G(companyId, groupId, start, end, orderByComparator);
    }

    /**
    * Returns the first popup in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching popup
    * @throws com.sdr.popup.NoSuchPopupException if a matching popup could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.popup.model.Popup findByC_G_First(long companyId,
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.popup.NoSuchPopupException {
        return getPersistence()
                   .findByC_G_First(companyId, groupId, orderByComparator);
    }

    /**
    * Returns the first popup in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching popup, or <code>null</code> if a matching popup could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.popup.model.Popup fetchByC_G_First(long companyId,
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByC_G_First(companyId, groupId, orderByComparator);
    }

    /**
    * Returns the last popup in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching popup
    * @throws com.sdr.popup.NoSuchPopupException if a matching popup could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.popup.model.Popup findByC_G_Last(long companyId,
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.popup.NoSuchPopupException {
        return getPersistence()
                   .findByC_G_Last(companyId, groupId, orderByComparator);
    }

    /**
    * Returns the last popup in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching popup, or <code>null</code> if a matching popup could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.popup.model.Popup fetchByC_G_Last(long companyId,
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByC_G_Last(companyId, groupId, orderByComparator);
    }

    /**
    * Returns the popups before and after the current popup in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param popupId the primary key of the current popup
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next popup
    * @throws com.sdr.popup.NoSuchPopupException if a popup with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.popup.model.Popup[] findByC_G_PrevAndNext(
        long popupId, long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.popup.NoSuchPopupException {
        return getPersistence()
                   .findByC_G_PrevAndNext(popupId, companyId, groupId,
            orderByComparator);
    }

    /**
    * Removes all the popups where companyId = &#63; and groupId = &#63; from the database.
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
    * Returns the number of popups where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @return the number of matching popups
    * @throws SystemException if a system exception occurred
    */
    public static int countByC_G(long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countByC_G(companyId, groupId);
    }

    /**
    * Returns all the popups where companyId = &#63; and groupId = &#63; and startDate &le; &#63; and finishDate &ge; &#63; and enable = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param startDate the start date
    * @param finishDate the finish date
    * @param enable the enable
    * @return the matching popups
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.popup.model.Popup> findByC_G_S_F_E(
        long companyId, long groupId, java.util.Date startDate,
        java.util.Date finishDate, boolean enable)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByC_G_S_F_E(companyId, groupId, startDate, finishDate,
            enable);
    }

    /**
    * Returns a range of all the popups where companyId = &#63; and groupId = &#63; and startDate &le; &#63; and finishDate &ge; &#63; and enable = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.popup.model.impl.PopupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param startDate the start date
    * @param finishDate the finish date
    * @param enable the enable
    * @param start the lower bound of the range of popups
    * @param end the upper bound of the range of popups (not inclusive)
    * @return the range of matching popups
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.popup.model.Popup> findByC_G_S_F_E(
        long companyId, long groupId, java.util.Date startDate,
        java.util.Date finishDate, boolean enable, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByC_G_S_F_E(companyId, groupId, startDate, finishDate,
            enable, start, end);
    }

    /**
    * Returns an ordered range of all the popups where companyId = &#63; and groupId = &#63; and startDate &le; &#63; and finishDate &ge; &#63; and enable = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.popup.model.impl.PopupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param startDate the start date
    * @param finishDate the finish date
    * @param enable the enable
    * @param start the lower bound of the range of popups
    * @param end the upper bound of the range of popups (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching popups
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.popup.model.Popup> findByC_G_S_F_E(
        long companyId, long groupId, java.util.Date startDate,
        java.util.Date finishDate, boolean enable, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .findByC_G_S_F_E(companyId, groupId, startDate, finishDate,
            enable, start, end, orderByComparator);
    }

    /**
    * Returns the first popup in the ordered set where companyId = &#63; and groupId = &#63; and startDate &le; &#63; and finishDate &ge; &#63; and enable = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param startDate the start date
    * @param finishDate the finish date
    * @param enable the enable
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching popup
    * @throws com.sdr.popup.NoSuchPopupException if a matching popup could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.popup.model.Popup findByC_G_S_F_E_First(
        long companyId, long groupId, java.util.Date startDate,
        java.util.Date finishDate, boolean enable,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.popup.NoSuchPopupException {
        return getPersistence()
                   .findByC_G_S_F_E_First(companyId, groupId, startDate,
            finishDate, enable, orderByComparator);
    }

    /**
    * Returns the first popup in the ordered set where companyId = &#63; and groupId = &#63; and startDate &le; &#63; and finishDate &ge; &#63; and enable = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param startDate the start date
    * @param finishDate the finish date
    * @param enable the enable
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching popup, or <code>null</code> if a matching popup could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.popup.model.Popup fetchByC_G_S_F_E_First(
        long companyId, long groupId, java.util.Date startDate,
        java.util.Date finishDate, boolean enable,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByC_G_S_F_E_First(companyId, groupId, startDate,
            finishDate, enable, orderByComparator);
    }

    /**
    * Returns the last popup in the ordered set where companyId = &#63; and groupId = &#63; and startDate &le; &#63; and finishDate &ge; &#63; and enable = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param startDate the start date
    * @param finishDate the finish date
    * @param enable the enable
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching popup
    * @throws com.sdr.popup.NoSuchPopupException if a matching popup could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.popup.model.Popup findByC_G_S_F_E_Last(
        long companyId, long groupId, java.util.Date startDate,
        java.util.Date finishDate, boolean enable,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.popup.NoSuchPopupException {
        return getPersistence()
                   .findByC_G_S_F_E_Last(companyId, groupId, startDate,
            finishDate, enable, orderByComparator);
    }

    /**
    * Returns the last popup in the ordered set where companyId = &#63; and groupId = &#63; and startDate &le; &#63; and finishDate &ge; &#63; and enable = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param startDate the start date
    * @param finishDate the finish date
    * @param enable the enable
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching popup, or <code>null</code> if a matching popup could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.popup.model.Popup fetchByC_G_S_F_E_Last(
        long companyId, long groupId, java.util.Date startDate,
        java.util.Date finishDate, boolean enable,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .fetchByC_G_S_F_E_Last(companyId, groupId, startDate,
            finishDate, enable, orderByComparator);
    }

    /**
    * Returns the popups before and after the current popup in the ordered set where companyId = &#63; and groupId = &#63; and startDate &le; &#63; and finishDate &ge; &#63; and enable = &#63;.
    *
    * @param popupId the primary key of the current popup
    * @param companyId the company ID
    * @param groupId the group ID
    * @param startDate the start date
    * @param finishDate the finish date
    * @param enable the enable
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next popup
    * @throws com.sdr.popup.NoSuchPopupException if a popup with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.popup.model.Popup[] findByC_G_S_F_E_PrevAndNext(
        long popupId, long companyId, long groupId, java.util.Date startDate,
        java.util.Date finishDate, boolean enable,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.popup.NoSuchPopupException {
        return getPersistence()
                   .findByC_G_S_F_E_PrevAndNext(popupId, companyId, groupId,
            startDate, finishDate, enable, orderByComparator);
    }

    /**
    * Removes all the popups where companyId = &#63; and groupId = &#63; and startDate &le; &#63; and finishDate &ge; &#63; and enable = &#63; from the database.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param startDate the start date
    * @param finishDate the finish date
    * @param enable the enable
    * @throws SystemException if a system exception occurred
    */
    public static void removeByC_G_S_F_E(long companyId, long groupId,
        java.util.Date startDate, java.util.Date finishDate, boolean enable)
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence()
            .removeByC_G_S_F_E(companyId, groupId, startDate, finishDate, enable);
    }

    /**
    * Returns the number of popups where companyId = &#63; and groupId = &#63; and startDate &le; &#63; and finishDate &ge; &#63; and enable = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param startDate the start date
    * @param finishDate the finish date
    * @param enable the enable
    * @return the number of matching popups
    * @throws SystemException if a system exception occurred
    */
    public static int countByC_G_S_F_E(long companyId, long groupId,
        java.util.Date startDate, java.util.Date finishDate, boolean enable)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence()
                   .countByC_G_S_F_E(companyId, groupId, startDate, finishDate,
            enable);
    }

    /**
    * Caches the popup in the entity cache if it is enabled.
    *
    * @param popup the popup
    */
    public static void cacheResult(com.sdr.popup.model.Popup popup) {
        getPersistence().cacheResult(popup);
    }

    /**
    * Caches the popups in the entity cache if it is enabled.
    *
    * @param popups the popups
    */
    public static void cacheResult(
        java.util.List<com.sdr.popup.model.Popup> popups) {
        getPersistence().cacheResult(popups);
    }

    /**
    * Creates a new popup with the primary key. Does not add the popup to the database.
    *
    * @param popupId the primary key for the new popup
    * @return the new popup
    */
    public static com.sdr.popup.model.Popup create(long popupId) {
        return getPersistence().create(popupId);
    }

    /**
    * Removes the popup with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param popupId the primary key of the popup
    * @return the popup that was removed
    * @throws com.sdr.popup.NoSuchPopupException if a popup with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.popup.model.Popup remove(long popupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.popup.NoSuchPopupException {
        return getPersistence().remove(popupId);
    }

    public static com.sdr.popup.model.Popup updateImpl(
        com.sdr.popup.model.Popup popup)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().updateImpl(popup);
    }

    /**
    * Returns the popup with the primary key or throws a {@link com.sdr.popup.NoSuchPopupException} if it could not be found.
    *
    * @param popupId the primary key of the popup
    * @return the popup
    * @throws com.sdr.popup.NoSuchPopupException if a popup with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.popup.model.Popup findByPrimaryKey(long popupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.popup.NoSuchPopupException {
        return getPersistence().findByPrimaryKey(popupId);
    }

    /**
    * Returns the popup with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param popupId the primary key of the popup
    * @return the popup, or <code>null</code> if a popup with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public static com.sdr.popup.model.Popup fetchByPrimaryKey(long popupId)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().fetchByPrimaryKey(popupId);
    }

    /**
    * Returns all the popups.
    *
    * @return the popups
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.popup.model.Popup> findAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll();
    }

    /**
    * Returns a range of all the popups.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.popup.model.impl.PopupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of popups
    * @param end the upper bound of the range of popups (not inclusive)
    * @return the range of popups
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.popup.model.Popup> findAll(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end);
    }

    /**
    * Returns an ordered range of all the popups.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sdr.popup.model.impl.PopupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of popups
    * @param end the upper bound of the range of popups (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of popups
    * @throws SystemException if a system exception occurred
    */
    public static java.util.List<com.sdr.popup.model.Popup> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().findAll(start, end, orderByComparator);
    }

    /**
    * Removes all the popups from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public static void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        getPersistence().removeAll();
    }

    /**
    * Returns the number of popups.
    *
    * @return the number of popups
    * @throws SystemException if a system exception occurred
    */
    public static int countAll()
        throws com.liferay.portal.kernel.exception.SystemException {
        return getPersistence().countAll();
    }

    public static PopupPersistence getPersistence() {
        if (_persistence == null) {
            _persistence = (PopupPersistence) PortletBeanLocatorUtil.locate(com.sdr.popup.service.ClpSerializer.getServletContextName(),
                    PopupPersistence.class.getName());

            ReferenceRegistry.registerReference(PopupUtil.class, "_persistence");
        }

        return _persistence;
    }

    /**
     * @deprecated As of 6.2.0
     */
    public void setPersistence(PopupPersistence persistence) {
    }
}
