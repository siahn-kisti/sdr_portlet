package com.sdr.popup.service.persistence;

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.sdr.popup.NoSuchPopupException;
import com.sdr.popup.model.Popup;
import com.sdr.popup.model.impl.PopupImpl;
import com.sdr.popup.model.impl.PopupModelImpl;
import com.sdr.popup.service.persistence.PopupPersistence;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the popup service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author goopsw
 * @see PopupPersistence
 * @see PopupUtil
 * @generated
 */
public class PopupPersistenceImpl extends BasePersistenceImpl<Popup>
    implements PopupPersistence {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. Always use {@link PopupUtil} to access the popup persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
     */
    public static final String FINDER_CLASS_NAME_ENTITY = PopupImpl.class.getName();
    public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List1";
    public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
        ".List2";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(PopupModelImpl.ENTITY_CACHE_ENABLED,
            PopupModelImpl.FINDER_CACHE_ENABLED, PopupImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(PopupModelImpl.ENTITY_CACHE_ENABLED,
            PopupModelImpl.FINDER_CACHE_ENABLED, PopupImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
    public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(PopupModelImpl.ENTITY_CACHE_ENABLED,
            PopupModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G = new FinderPath(PopupModelImpl.ENTITY_CACHE_ENABLED,
            PopupModelImpl.FINDER_CACHE_ENABLED, PopupImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_G",
            new String[] {
                Long.class.getName(), Long.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G = new FinderPath(PopupModelImpl.ENTITY_CACHE_ENABLED,
            PopupModelImpl.FINDER_CACHE_ENABLED, PopupImpl.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByC_G",
            new String[] { Long.class.getName(), Long.class.getName() },
            PopupModelImpl.COMPANYID_COLUMN_BITMASK |
            PopupModelImpl.GROUPID_COLUMN_BITMASK |
            PopupModelImpl.STARTDATE_COLUMN_BITMASK |
            PopupModelImpl.FINISHDATE_COLUMN_BITMASK);
    public static final FinderPath FINDER_PATH_COUNT_BY_C_G = new FinderPath(PopupModelImpl.ENTITY_CACHE_ENABLED,
            PopupModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByC_G",
            new String[] { Long.class.getName(), Long.class.getName() });
    private static final String _FINDER_COLUMN_C_G_COMPANYID_2 = "popup.companyId = ? AND ";
    private static final String _FINDER_COLUMN_C_G_GROUPID_2 = "popup.groupId = ?";
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G_S_F_E =
        new FinderPath(PopupModelImpl.ENTITY_CACHE_ENABLED,
            PopupModelImpl.FINDER_CACHE_ENABLED, PopupImpl.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_G_S_F_E",
            new String[] {
                Long.class.getName(), Long.class.getName(), Date.class.getName(),
                Date.class.getName(), Boolean.class.getName(),
                
            Integer.class.getName(), Integer.class.getName(),
                OrderByComparator.class.getName()
            });
    public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_G_S_F_E =
        new FinderPath(PopupModelImpl.ENTITY_CACHE_ENABLED,
            PopupModelImpl.FINDER_CACHE_ENABLED, Long.class,
            FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByC_G_S_F_E",
            new String[] {
                Long.class.getName(), Long.class.getName(), Date.class.getName(),
                Date.class.getName(), Boolean.class.getName()
            });
    private static final String _FINDER_COLUMN_C_G_S_F_E_COMPANYID_2 = "popup.companyId = ? AND ";
    private static final String _FINDER_COLUMN_C_G_S_F_E_GROUPID_2 = "popup.groupId = ? AND ";
    private static final String _FINDER_COLUMN_C_G_S_F_E_STARTDATE_1 = "popup.startDate <= NULL AND ";
    private static final String _FINDER_COLUMN_C_G_S_F_E_STARTDATE_2 = "popup.startDate <= ? AND ";
    private static final String _FINDER_COLUMN_C_G_S_F_E_FINISHDATE_1 = "popup.finishDate >= NULL AND ";
    private static final String _FINDER_COLUMN_C_G_S_F_E_FINISHDATE_2 = "popup.finishDate >= ? AND ";
    private static final String _FINDER_COLUMN_C_G_S_F_E_ENABLE_2 = "popup.enable = ?";
    private static final String _SQL_SELECT_POPUP = "SELECT popup FROM Popup popup";
    private static final String _SQL_SELECT_POPUP_WHERE = "SELECT popup FROM Popup popup WHERE ";
    private static final String _SQL_COUNT_POPUP = "SELECT COUNT(popup) FROM Popup popup";
    private static final String _SQL_COUNT_POPUP_WHERE = "SELECT COUNT(popup) FROM Popup popup WHERE ";
    private static final String _ORDER_BY_ENTITY_ALIAS = "popup.";
    private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Popup exists with the primary key ";
    private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Popup exists with the key {";
    private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
                PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
    private static Log _log = LogFactoryUtil.getLog(PopupPersistenceImpl.class);
    private static Popup _nullPopup = new PopupImpl() {
            @Override
            public Object clone() {
                return this;
            }

            @Override
            public CacheModel<Popup> toCacheModel() {
                return _nullPopupCacheModel;
            }
        };

    private static CacheModel<Popup> _nullPopupCacheModel = new CacheModel<Popup>() {
            @Override
            public Popup toEntityModel() {
                return _nullPopup;
            }
        };

    public PopupPersistenceImpl() {
        setModelClass(Popup.class);
    }

    /**
     * Returns all the popups where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @return the matching popups
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Popup> findByC_G(long companyId, long groupId)
        throws SystemException {
        return findByC_G(companyId, groupId, QueryUtil.ALL_POS,
            QueryUtil.ALL_POS, null);
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
    @Override
    public List<Popup> findByC_G(long companyId, long groupId, int start,
        int end) throws SystemException {
        return findByC_G(companyId, groupId, start, end, null);
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
    @Override
    public List<Popup> findByC_G(long companyId, long groupId, int start,
        int end, OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G;
            finderArgs = new Object[] { companyId, groupId };
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G;
            finderArgs = new Object[] {
                    companyId, groupId,
                    
                    start, end, orderByComparator
                };
        }

        List<Popup> list = (List<Popup>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Popup popup : list) {
                if ((companyId != popup.getCompanyId()) ||
                        (groupId != popup.getGroupId())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(4 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(4);
            }

            query.append(_SQL_SELECT_POPUP_WHERE);

            query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

            query.append(_FINDER_COLUMN_C_G_GROUPID_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(PopupModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                qPos.add(groupId);

                if (!pagination) {
                    list = (List<Popup>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Popup>(list);
                } else {
                    list = (List<Popup>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Popup findByC_G_First(long companyId, long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchPopupException, SystemException {
        Popup popup = fetchByC_G_First(companyId, groupId, orderByComparator);

        if (popup != null) {
            return popup;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchPopupException(msg.toString());
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
    @Override
    public Popup fetchByC_G_First(long companyId, long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        List<Popup> list = findByC_G(companyId, groupId, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Popup findByC_G_Last(long companyId, long groupId,
        OrderByComparator orderByComparator)
        throws NoSuchPopupException, SystemException {
        Popup popup = fetchByC_G_Last(companyId, groupId, orderByComparator);

        if (popup != null) {
            return popup;
        }

        StringBundler msg = new StringBundler(6);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", groupId=");
        msg.append(groupId);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchPopupException(msg.toString());
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
    @Override
    public Popup fetchByC_G_Last(long companyId, long groupId,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByC_G(companyId, groupId);

        if (count == 0) {
            return null;
        }

        List<Popup> list = findByC_G(companyId, groupId, count - 1, count,
                orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Popup[] findByC_G_PrevAndNext(long popupId, long companyId,
        long groupId, OrderByComparator orderByComparator)
        throws NoSuchPopupException, SystemException {
        Popup popup = findByPrimaryKey(popupId);

        Session session = null;

        try {
            session = openSession();

            Popup[] array = new PopupImpl[3];

            array[0] = getByC_G_PrevAndNext(session, popup, companyId, groupId,
                    orderByComparator, true);

            array[1] = popup;

            array[2] = getByC_G_PrevAndNext(session, popup, companyId, groupId,
                    orderByComparator, false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Popup getByC_G_PrevAndNext(Session session, Popup popup,
        long companyId, long groupId, OrderByComparator orderByComparator,
        boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_POPUP_WHERE);

        query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

        query.append(_FINDER_COLUMN_C_G_GROUPID_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(PopupModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        qPos.add(groupId);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(popup);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Popup> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
    }

    /**
     * Removes all the popups where companyId = &#63; and groupId = &#63; from the database.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeByC_G(long companyId, long groupId)
        throws SystemException {
        for (Popup popup : findByC_G(companyId, groupId, QueryUtil.ALL_POS,
                QueryUtil.ALL_POS, null)) {
            remove(popup);
        }
    }

    /**
     * Returns the number of popups where companyId = &#63; and groupId = &#63;.
     *
     * @param companyId the company ID
     * @param groupId the group ID
     * @return the number of matching popups
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countByC_G(long companyId, long groupId)
        throws SystemException {
        FinderPath finderPath = FINDER_PATH_COUNT_BY_C_G;

        Object[] finderArgs = new Object[] { companyId, groupId };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(3);

            query.append(_SQL_COUNT_POPUP_WHERE);

            query.append(_FINDER_COLUMN_C_G_COMPANYID_2);

            query.append(_FINDER_COLUMN_C_G_GROUPID_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                qPos.add(groupId);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
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
    @Override
    public List<Popup> findByC_G_S_F_E(long companyId, long groupId,
        Date startDate, Date finishDate, boolean enable)
        throws SystemException {
        return findByC_G_S_F_E(companyId, groupId, startDate, finishDate,
            enable, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<Popup> findByC_G_S_F_E(long companyId, long groupId,
        Date startDate, Date finishDate, boolean enable, int start, int end)
        throws SystemException {
        return findByC_G_S_F_E(companyId, groupId, startDate, finishDate,
            enable, start, end, null);
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
    @Override
    public List<Popup> findByC_G_S_F_E(long companyId, long groupId,
        Date startDate, Date finishDate, boolean enable, int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_C_G_S_F_E;
        finderArgs = new Object[] {
                companyId, groupId, startDate, finishDate, enable,
                
                start, end, orderByComparator
            };

        List<Popup> list = (List<Popup>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if ((list != null) && !list.isEmpty()) {
            for (Popup popup : list) {
                if ((companyId != popup.getCompanyId()) ||
                        (groupId != popup.getGroupId()) ||
                        (startDate.getTime() < popup.getStartDate().getTime()) ||
                        (finishDate.getTime() > popup.getFinishDate().getTime()) ||
                        (enable != popup.getEnable())) {
                    list = null;

                    break;
                }
            }
        }

        if (list == null) {
            StringBundler query = null;

            if (orderByComparator != null) {
                query = new StringBundler(7 +
                        (orderByComparator.getOrderByFields().length * 3));
            } else {
                query = new StringBundler(7);
            }

            query.append(_SQL_SELECT_POPUP_WHERE);

            query.append(_FINDER_COLUMN_C_G_S_F_E_COMPANYID_2);

            query.append(_FINDER_COLUMN_C_G_S_F_E_GROUPID_2);

            boolean bindStartDate = false;

            if (startDate == null) {
                query.append(_FINDER_COLUMN_C_G_S_F_E_STARTDATE_1);
            } else {
                bindStartDate = true;

                query.append(_FINDER_COLUMN_C_G_S_F_E_STARTDATE_2);
            }

            boolean bindFinishDate = false;

            if (finishDate == null) {
                query.append(_FINDER_COLUMN_C_G_S_F_E_FINISHDATE_1);
            } else {
                bindFinishDate = true;

                query.append(_FINDER_COLUMN_C_G_S_F_E_FINISHDATE_2);
            }

            query.append(_FINDER_COLUMN_C_G_S_F_E_ENABLE_2);

            if (orderByComparator != null) {
                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);
            } else
             if (pagination) {
                query.append(PopupModelImpl.ORDER_BY_JPQL);
            }

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                qPos.add(groupId);

                if (bindStartDate) {
                    qPos.add(CalendarUtil.getTimestamp(startDate));
                }

                if (bindFinishDate) {
                    qPos.add(CalendarUtil.getTimestamp(finishDate));
                }

                qPos.add(enable);

                if (!pagination) {
                    list = (List<Popup>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Popup>(list);
                } else {
                    list = (List<Popup>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
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
    @Override
    public Popup findByC_G_S_F_E_First(long companyId, long groupId,
        Date startDate, Date finishDate, boolean enable,
        OrderByComparator orderByComparator)
        throws NoSuchPopupException, SystemException {
        Popup popup = fetchByC_G_S_F_E_First(companyId, groupId, startDate,
                finishDate, enable, orderByComparator);

        if (popup != null) {
            return popup;
        }

        StringBundler msg = new StringBundler(12);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", groupId=");
        msg.append(groupId);

        msg.append(", startDate=");
        msg.append(startDate);

        msg.append(", finishDate=");
        msg.append(finishDate);

        msg.append(", enable=");
        msg.append(enable);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchPopupException(msg.toString());
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
    @Override
    public Popup fetchByC_G_S_F_E_First(long companyId, long groupId,
        Date startDate, Date finishDate, boolean enable,
        OrderByComparator orderByComparator) throws SystemException {
        List<Popup> list = findByC_G_S_F_E(companyId, groupId, startDate,
                finishDate, enable, 0, 1, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Popup findByC_G_S_F_E_Last(long companyId, long groupId,
        Date startDate, Date finishDate, boolean enable,
        OrderByComparator orderByComparator)
        throws NoSuchPopupException, SystemException {
        Popup popup = fetchByC_G_S_F_E_Last(companyId, groupId, startDate,
                finishDate, enable, orderByComparator);

        if (popup != null) {
            return popup;
        }

        StringBundler msg = new StringBundler(12);

        msg.append(_NO_SUCH_ENTITY_WITH_KEY);

        msg.append("companyId=");
        msg.append(companyId);

        msg.append(", groupId=");
        msg.append(groupId);

        msg.append(", startDate=");
        msg.append(startDate);

        msg.append(", finishDate=");
        msg.append(finishDate);

        msg.append(", enable=");
        msg.append(enable);

        msg.append(StringPool.CLOSE_CURLY_BRACE);

        throw new NoSuchPopupException(msg.toString());
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
    @Override
    public Popup fetchByC_G_S_F_E_Last(long companyId, long groupId,
        Date startDate, Date finishDate, boolean enable,
        OrderByComparator orderByComparator) throws SystemException {
        int count = countByC_G_S_F_E(companyId, groupId, startDate, finishDate,
                enable);

        if (count == 0) {
            return null;
        }

        List<Popup> list = findByC_G_S_F_E(companyId, groupId, startDate,
                finishDate, enable, count - 1, count, orderByComparator);

        if (!list.isEmpty()) {
            return list.get(0);
        }

        return null;
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
    @Override
    public Popup[] findByC_G_S_F_E_PrevAndNext(long popupId, long companyId,
        long groupId, Date startDate, Date finishDate, boolean enable,
        OrderByComparator orderByComparator)
        throws NoSuchPopupException, SystemException {
        Popup popup = findByPrimaryKey(popupId);

        Session session = null;

        try {
            session = openSession();

            Popup[] array = new PopupImpl[3];

            array[0] = getByC_G_S_F_E_PrevAndNext(session, popup, companyId,
                    groupId, startDate, finishDate, enable, orderByComparator,
                    true);

            array[1] = popup;

            array[2] = getByC_G_S_F_E_PrevAndNext(session, popup, companyId,
                    groupId, startDate, finishDate, enable, orderByComparator,
                    false);

            return array;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    protected Popup getByC_G_S_F_E_PrevAndNext(Session session, Popup popup,
        long companyId, long groupId, Date startDate, Date finishDate,
        boolean enable, OrderByComparator orderByComparator, boolean previous) {
        StringBundler query = null;

        if (orderByComparator != null) {
            query = new StringBundler(6 +
                    (orderByComparator.getOrderByFields().length * 6));
        } else {
            query = new StringBundler(3);
        }

        query.append(_SQL_SELECT_POPUP_WHERE);

        query.append(_FINDER_COLUMN_C_G_S_F_E_COMPANYID_2);

        query.append(_FINDER_COLUMN_C_G_S_F_E_GROUPID_2);

        boolean bindStartDate = false;

        if (startDate == null) {
            query.append(_FINDER_COLUMN_C_G_S_F_E_STARTDATE_1);
        } else {
            bindStartDate = true;

            query.append(_FINDER_COLUMN_C_G_S_F_E_STARTDATE_2);
        }

        boolean bindFinishDate = false;

        if (finishDate == null) {
            query.append(_FINDER_COLUMN_C_G_S_F_E_FINISHDATE_1);
        } else {
            bindFinishDate = true;

            query.append(_FINDER_COLUMN_C_G_S_F_E_FINISHDATE_2);
        }

        query.append(_FINDER_COLUMN_C_G_S_F_E_ENABLE_2);

        if (orderByComparator != null) {
            String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

            if (orderByConditionFields.length > 0) {
                query.append(WHERE_AND);
            }

            for (int i = 0; i < orderByConditionFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByConditionFields[i]);

                if ((i + 1) < orderByConditionFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN_HAS_NEXT);
                    } else {
                        query.append(WHERE_LESSER_THAN_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(WHERE_GREATER_THAN);
                    } else {
                        query.append(WHERE_LESSER_THAN);
                    }
                }
            }

            query.append(ORDER_BY_CLAUSE);

            String[] orderByFields = orderByComparator.getOrderByFields();

            for (int i = 0; i < orderByFields.length; i++) {
                query.append(_ORDER_BY_ENTITY_ALIAS);
                query.append(orderByFields[i]);

                if ((i + 1) < orderByFields.length) {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC_HAS_NEXT);
                    } else {
                        query.append(ORDER_BY_DESC_HAS_NEXT);
                    }
                } else {
                    if (orderByComparator.isAscending() ^ previous) {
                        query.append(ORDER_BY_ASC);
                    } else {
                        query.append(ORDER_BY_DESC);
                    }
                }
            }
        } else {
            query.append(PopupModelImpl.ORDER_BY_JPQL);
        }

        String sql = query.toString();

        Query q = session.createQuery(sql);

        q.setFirstResult(0);
        q.setMaxResults(2);

        QueryPos qPos = QueryPos.getInstance(q);

        qPos.add(companyId);

        qPos.add(groupId);

        if (bindStartDate) {
            qPos.add(CalendarUtil.getTimestamp(startDate));
        }

        if (bindFinishDate) {
            qPos.add(CalendarUtil.getTimestamp(finishDate));
        }

        qPos.add(enable);

        if (orderByComparator != null) {
            Object[] values = orderByComparator.getOrderByConditionValues(popup);

            for (Object value : values) {
                qPos.add(value);
            }
        }

        List<Popup> list = q.list();

        if (list.size() == 2) {
            return list.get(1);
        } else {
            return null;
        }
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
    @Override
    public void removeByC_G_S_F_E(long companyId, long groupId, Date startDate,
        Date finishDate, boolean enable) throws SystemException {
        for (Popup popup : findByC_G_S_F_E(companyId, groupId, startDate,
                finishDate, enable, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
            remove(popup);
        }
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
    @Override
    public int countByC_G_S_F_E(long companyId, long groupId, Date startDate,
        Date finishDate, boolean enable) throws SystemException {
        FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_C_G_S_F_E;

        Object[] finderArgs = new Object[] {
                companyId, groupId, startDate, finishDate, enable
            };

        Long count = (Long) FinderCacheUtil.getResult(finderPath, finderArgs,
                this);

        if (count == null) {
            StringBundler query = new StringBundler(6);

            query.append(_SQL_COUNT_POPUP_WHERE);

            query.append(_FINDER_COLUMN_C_G_S_F_E_COMPANYID_2);

            query.append(_FINDER_COLUMN_C_G_S_F_E_GROUPID_2);

            boolean bindStartDate = false;

            if (startDate == null) {
                query.append(_FINDER_COLUMN_C_G_S_F_E_STARTDATE_1);
            } else {
                bindStartDate = true;

                query.append(_FINDER_COLUMN_C_G_S_F_E_STARTDATE_2);
            }

            boolean bindFinishDate = false;

            if (finishDate == null) {
                query.append(_FINDER_COLUMN_C_G_S_F_E_FINISHDATE_1);
            } else {
                bindFinishDate = true;

                query.append(_FINDER_COLUMN_C_G_S_F_E_FINISHDATE_2);
            }

            query.append(_FINDER_COLUMN_C_G_S_F_E_ENABLE_2);

            String sql = query.toString();

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                QueryPos qPos = QueryPos.getInstance(q);

                qPos.add(companyId);

                qPos.add(groupId);

                if (bindStartDate) {
                    qPos.add(CalendarUtil.getTimestamp(startDate));
                }

                if (bindFinishDate) {
                    qPos.add(CalendarUtil.getTimestamp(finishDate));
                }

                qPos.add(enable);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(finderPath, finderArgs, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Caches the popup in the entity cache if it is enabled.
     *
     * @param popup the popup
     */
    @Override
    public void cacheResult(Popup popup) {
        EntityCacheUtil.putResult(PopupModelImpl.ENTITY_CACHE_ENABLED,
            PopupImpl.class, popup.getPrimaryKey(), popup);

        popup.resetOriginalValues();
    }

    /**
     * Caches the popups in the entity cache if it is enabled.
     *
     * @param popups the popups
     */
    @Override
    public void cacheResult(List<Popup> popups) {
        for (Popup popup : popups) {
            if (EntityCacheUtil.getResult(PopupModelImpl.ENTITY_CACHE_ENABLED,
                        PopupImpl.class, popup.getPrimaryKey()) == null) {
                cacheResult(popup);
            } else {
                popup.resetOriginalValues();
            }
        }
    }

    /**
     * Clears the cache for all popups.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache() {
        if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
            CacheRegistryUtil.clear(PopupImpl.class.getName());
        }

        EntityCacheUtil.clearCache(PopupImpl.class.getName());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    /**
     * Clears the cache for the popup.
     *
     * <p>
     * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
     * </p>
     */
    @Override
    public void clearCache(Popup popup) {
        EntityCacheUtil.removeResult(PopupModelImpl.ENTITY_CACHE_ENABLED,
            PopupImpl.class, popup.getPrimaryKey());

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }

    @Override
    public void clearCache(List<Popup> popups) {
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

        for (Popup popup : popups) {
            EntityCacheUtil.removeResult(PopupModelImpl.ENTITY_CACHE_ENABLED,
                PopupImpl.class, popup.getPrimaryKey());
        }
    }

    /**
     * Creates a new popup with the primary key. Does not add the popup to the database.
     *
     * @param popupId the primary key for the new popup
     * @return the new popup
     */
    @Override
    public Popup create(long popupId) {
        Popup popup = new PopupImpl();

        popup.setNew(true);
        popup.setPrimaryKey(popupId);

        return popup;
    }

    /**
     * Removes the popup with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param popupId the primary key of the popup
     * @return the popup that was removed
     * @throws com.sdr.popup.NoSuchPopupException if a popup with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Popup remove(long popupId)
        throws NoSuchPopupException, SystemException {
        return remove((Serializable) popupId);
    }

    /**
     * Removes the popup with the primary key from the database. Also notifies the appropriate model listeners.
     *
     * @param primaryKey the primary key of the popup
     * @return the popup that was removed
     * @throws com.sdr.popup.NoSuchPopupException if a popup with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Popup remove(Serializable primaryKey)
        throws NoSuchPopupException, SystemException {
        Session session = null;

        try {
            session = openSession();

            Popup popup = (Popup) session.get(PopupImpl.class, primaryKey);

            if (popup == null) {
                if (_log.isWarnEnabled()) {
                    _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
                }

                throw new NoSuchPopupException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                    primaryKey);
            }

            return remove(popup);
        } catch (NoSuchPopupException nsee) {
            throw nsee;
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }
    }

    @Override
    protected Popup removeImpl(Popup popup) throws SystemException {
        popup = toUnwrappedModel(popup);

        Session session = null;

        try {
            session = openSession();

            if (!session.contains(popup)) {
                popup = (Popup) session.get(PopupImpl.class,
                        popup.getPrimaryKeyObj());
            }

            if (popup != null) {
                session.delete(popup);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        if (popup != null) {
            clearCache(popup);
        }

        return popup;
    }

    @Override
    public Popup updateImpl(com.sdr.popup.model.Popup popup)
        throws SystemException {
        popup = toUnwrappedModel(popup);

        boolean isNew = popup.isNew();

        PopupModelImpl popupModelImpl = (PopupModelImpl) popup;

        Session session = null;

        try {
            session = openSession();

            if (popup.isNew()) {
                session.save(popup);

                popup.setNew(false);
            } else {
                session.merge(popup);
            }
        } catch (Exception e) {
            throw processException(e);
        } finally {
            closeSession(session);
        }

        FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

        if (isNew || !PopupModelImpl.COLUMN_BITMASK_ENABLED) {
            FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
        }
        else {
            if ((popupModelImpl.getColumnBitmask() &
                    FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G.getColumnBitmask()) != 0) {
                Object[] args = new Object[] {
                        popupModelImpl.getOriginalCompanyId(),
                        popupModelImpl.getOriginalGroupId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
                    args);

                args = new Object[] {
                        popupModelImpl.getCompanyId(),
                        popupModelImpl.getGroupId()
                    };

                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_C_G, args);
                FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_C_G,
                    args);
            }
        }

        EntityCacheUtil.putResult(PopupModelImpl.ENTITY_CACHE_ENABLED,
            PopupImpl.class, popup.getPrimaryKey(), popup);

        return popup;
    }

    protected Popup toUnwrappedModel(Popup popup) {
        if (popup instanceof PopupImpl) {
            return popup;
        }

        PopupImpl popupImpl = new PopupImpl();

        popupImpl.setNew(popup.isNew());
        popupImpl.setPrimaryKey(popup.getPrimaryKey());

        popupImpl.setPopupId(popup.getPopupId());
        popupImpl.setCompanyId(popup.getCompanyId());
        popupImpl.setGroupId(popup.getGroupId());
        popupImpl.setTitle(popup.getTitle());
        popupImpl.setStartDate(popup.getStartDate());
        popupImpl.setFinishDate(popup.getFinishDate());
        popupImpl.setWidth(popup.getWidth());
        popupImpl.setHeight(popup.getHeight());
        popupImpl.setEnable(popup.isEnable());
        popupImpl.setImgPath(popup.getImgPath());

        return popupImpl;
    }

    /**
     * Returns the popup with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
     *
     * @param primaryKey the primary key of the popup
     * @return the popup
     * @throws com.sdr.popup.NoSuchPopupException if a popup with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Popup findByPrimaryKey(Serializable primaryKey)
        throws NoSuchPopupException, SystemException {
        Popup popup = fetchByPrimaryKey(primaryKey);

        if (popup == null) {
            if (_log.isWarnEnabled()) {
                _log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
            }

            throw new NoSuchPopupException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
                primaryKey);
        }

        return popup;
    }

    /**
     * Returns the popup with the primary key or throws a {@link com.sdr.popup.NoSuchPopupException} if it could not be found.
     *
     * @param popupId the primary key of the popup
     * @return the popup
     * @throws com.sdr.popup.NoSuchPopupException if a popup with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Popup findByPrimaryKey(long popupId)
        throws NoSuchPopupException, SystemException {
        return findByPrimaryKey((Serializable) popupId);
    }

    /**
     * Returns the popup with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param primaryKey the primary key of the popup
     * @return the popup, or <code>null</code> if a popup with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Popup fetchByPrimaryKey(Serializable primaryKey)
        throws SystemException {
        Popup popup = (Popup) EntityCacheUtil.getResult(PopupModelImpl.ENTITY_CACHE_ENABLED,
                PopupImpl.class, primaryKey);

        if (popup == _nullPopup) {
            return null;
        }

        if (popup == null) {
            Session session = null;

            try {
                session = openSession();

                popup = (Popup) session.get(PopupImpl.class, primaryKey);

                if (popup != null) {
                    cacheResult(popup);
                } else {
                    EntityCacheUtil.putResult(PopupModelImpl.ENTITY_CACHE_ENABLED,
                        PopupImpl.class, primaryKey, _nullPopup);
                }
            } catch (Exception e) {
                EntityCacheUtil.removeResult(PopupModelImpl.ENTITY_CACHE_ENABLED,
                    PopupImpl.class, primaryKey);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return popup;
    }

    /**
     * Returns the popup with the primary key or returns <code>null</code> if it could not be found.
     *
     * @param popupId the primary key of the popup
     * @return the popup, or <code>null</code> if a popup with the primary key could not be found
     * @throws SystemException if a system exception occurred
     */
    @Override
    public Popup fetchByPrimaryKey(long popupId) throws SystemException {
        return fetchByPrimaryKey((Serializable) popupId);
    }

    /**
     * Returns all the popups.
     *
     * @return the popups
     * @throws SystemException if a system exception occurred
     */
    @Override
    public List<Popup> findAll() throws SystemException {
        return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
    @Override
    public List<Popup> findAll(int start, int end) throws SystemException {
        return findAll(start, end, null);
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
    @Override
    public List<Popup> findAll(int start, int end,
        OrderByComparator orderByComparator) throws SystemException {
        boolean pagination = true;
        FinderPath finderPath = null;
        Object[] finderArgs = null;

        if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
                (orderByComparator == null)) {
            pagination = false;
            finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
            finderArgs = FINDER_ARGS_EMPTY;
        } else {
            finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
            finderArgs = new Object[] { start, end, orderByComparator };
        }

        List<Popup> list = (List<Popup>) FinderCacheUtil.getResult(finderPath,
                finderArgs, this);

        if (list == null) {
            StringBundler query = null;
            String sql = null;

            if (orderByComparator != null) {
                query = new StringBundler(2 +
                        (orderByComparator.getOrderByFields().length * 3));

                query.append(_SQL_SELECT_POPUP);

                appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
                    orderByComparator);

                sql = query.toString();
            } else {
                sql = _SQL_SELECT_POPUP;

                if (pagination) {
                    sql = sql.concat(PopupModelImpl.ORDER_BY_JPQL);
                }
            }

            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(sql);

                if (!pagination) {
                    list = (List<Popup>) QueryUtil.list(q, getDialect(), start,
                            end, false);

                    Collections.sort(list);

                    list = new UnmodifiableList<Popup>(list);
                } else {
                    list = (List<Popup>) QueryUtil.list(q, getDialect(), start,
                            end);
                }

                cacheResult(list);

                FinderCacheUtil.putResult(finderPath, finderArgs, list);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(finderPath, finderArgs);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return list;
    }

    /**
     * Removes all the popups from the database.
     *
     * @throws SystemException if a system exception occurred
     */
    @Override
    public void removeAll() throws SystemException {
        for (Popup popup : findAll()) {
            remove(popup);
        }
    }

    /**
     * Returns the number of popups.
     *
     * @return the number of popups
     * @throws SystemException if a system exception occurred
     */
    @Override
    public int countAll() throws SystemException {
        Long count = (Long) FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
                FINDER_ARGS_EMPTY, this);

        if (count == null) {
            Session session = null;

            try {
                session = openSession();

                Query q = session.createQuery(_SQL_COUNT_POPUP);

                count = (Long) q.uniqueResult();

                FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY, count);
            } catch (Exception e) {
                FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
                    FINDER_ARGS_EMPTY);

                throw processException(e);
            } finally {
                closeSession(session);
            }
        }

        return count.intValue();
    }

    /**
     * Initializes the popup persistence.
     */
    public void afterPropertiesSet() {
        String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
                    com.liferay.util.service.ServiceProps.get(
                        "value.object.listener.com.sdr.popup.model.Popup")));

        if (listenerClassNames.length > 0) {
            try {
                List<ModelListener<Popup>> listenersList = new ArrayList<ModelListener<Popup>>();

                for (String listenerClassName : listenerClassNames) {
                    listenersList.add((ModelListener<Popup>) InstanceFactory.newInstance(
                            getClassLoader(), listenerClassName));
                }

                listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }

    public void destroy() {
        EntityCacheUtil.removeCache(PopupImpl.class.getName());
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
        FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
    }
}
