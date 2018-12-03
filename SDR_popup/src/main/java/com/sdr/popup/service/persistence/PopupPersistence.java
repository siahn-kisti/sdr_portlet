package com.sdr.popup.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sdr.popup.model.Popup;

/**
 * The persistence interface for the popup service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author goopsw
 * @see PopupPersistenceImpl
 * @see PopupUtil
 * @generated
 */
public interface PopupPersistence extends BasePersistence<Popup> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link PopupUtil} to access the popup persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the popups where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @return the matching popups
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.popup.model.Popup> findByC_G(long companyId,
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.sdr.popup.model.Popup> findByC_G(long companyId,
        long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.sdr.popup.model.Popup> findByC_G(long companyId,
        long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.sdr.popup.model.Popup findByC_G_First(long companyId,
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.popup.NoSuchPopupException;

    /**
    * Returns the first popup in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching popup, or <code>null</code> if a matching popup could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.popup.model.Popup fetchByC_G_First(long companyId,
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.sdr.popup.model.Popup findByC_G_Last(long companyId,
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.popup.NoSuchPopupException;

    /**
    * Returns the last popup in the ordered set where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching popup, or <code>null</code> if a matching popup could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.popup.model.Popup fetchByC_G_Last(long companyId,
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.sdr.popup.model.Popup[] findByC_G_PrevAndNext(long popupId,
        long companyId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.popup.NoSuchPopupException;

    /**
    * Removes all the popups where companyId = &#63; and groupId = &#63; from the database.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByC_G(long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of popups where companyId = &#63; and groupId = &#63;.
    *
    * @param companyId the company ID
    * @param groupId the group ID
    * @return the number of matching popups
    * @throws SystemException if a system exception occurred
    */
    public int countByC_G(long companyId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.sdr.popup.model.Popup> findByC_G_S_F_E(
        long companyId, long groupId, java.util.Date startDate,
        java.util.Date finishDate, boolean enable)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.sdr.popup.model.Popup> findByC_G_S_F_E(
        long companyId, long groupId, java.util.Date startDate,
        java.util.Date finishDate, boolean enable, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.sdr.popup.model.Popup> findByC_G_S_F_E(
        long companyId, long groupId, java.util.Date startDate,
        java.util.Date finishDate, boolean enable, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.sdr.popup.model.Popup findByC_G_S_F_E_First(long companyId,
        long groupId, java.util.Date startDate, java.util.Date finishDate,
        boolean enable,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.popup.NoSuchPopupException;

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
    public com.sdr.popup.model.Popup fetchByC_G_S_F_E_First(long companyId,
        long groupId, java.util.Date startDate, java.util.Date finishDate,
        boolean enable,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.sdr.popup.model.Popup findByC_G_S_F_E_Last(long companyId,
        long groupId, java.util.Date startDate, java.util.Date finishDate,
        boolean enable,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.popup.NoSuchPopupException;

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
    public com.sdr.popup.model.Popup fetchByC_G_S_F_E_Last(long companyId,
        long groupId, java.util.Date startDate, java.util.Date finishDate,
        boolean enable,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public com.sdr.popup.model.Popup[] findByC_G_S_F_E_PrevAndNext(
        long popupId, long companyId, long groupId, java.util.Date startDate,
        java.util.Date finishDate, boolean enable,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.popup.NoSuchPopupException;

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
    public void removeByC_G_S_F_E(long companyId, long groupId,
        java.util.Date startDate, java.util.Date finishDate, boolean enable)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public int countByC_G_S_F_E(long companyId, long groupId,
        java.util.Date startDate, java.util.Date finishDate, boolean enable)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the popup in the entity cache if it is enabled.
    *
    * @param popup the popup
    */
    public void cacheResult(com.sdr.popup.model.Popup popup);

    /**
    * Caches the popups in the entity cache if it is enabled.
    *
    * @param popups the popups
    */
    public void cacheResult(java.util.List<com.sdr.popup.model.Popup> popups);

    /**
    * Creates a new popup with the primary key. Does not add the popup to the database.
    *
    * @param popupId the primary key for the new popup
    * @return the new popup
    */
    public com.sdr.popup.model.Popup create(long popupId);

    /**
    * Removes the popup with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param popupId the primary key of the popup
    * @return the popup that was removed
    * @throws com.sdr.popup.NoSuchPopupException if a popup with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.popup.model.Popup remove(long popupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.popup.NoSuchPopupException;

    public com.sdr.popup.model.Popup updateImpl(com.sdr.popup.model.Popup popup)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the popup with the primary key or throws a {@link com.sdr.popup.NoSuchPopupException} if it could not be found.
    *
    * @param popupId the primary key of the popup
    * @return the popup
    * @throws com.sdr.popup.NoSuchPopupException if a popup with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.popup.model.Popup findByPrimaryKey(long popupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            com.sdr.popup.NoSuchPopupException;

    /**
    * Returns the popup with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param popupId the primary key of the popup
    * @return the popup, or <code>null</code> if a popup with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public com.sdr.popup.model.Popup fetchByPrimaryKey(long popupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the popups.
    *
    * @return the popups
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<com.sdr.popup.model.Popup> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.sdr.popup.model.Popup> findAll(int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

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
    public java.util.List<com.sdr.popup.model.Popup> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the popups from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of popups.
    *
    * @return the number of popups
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
