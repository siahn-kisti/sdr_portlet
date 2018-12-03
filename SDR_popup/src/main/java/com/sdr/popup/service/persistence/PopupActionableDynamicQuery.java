package com.sdr.popup.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.sdr.popup.model.Popup;
import com.sdr.popup.service.PopupLocalServiceUtil;

/**
 * @author goopsw
 * @generated
 */
public abstract class PopupActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public PopupActionableDynamicQuery() throws SystemException {
        setBaseLocalService(PopupLocalServiceUtil.getService());
        setClass(Popup.class);

        setClassLoader(com.sdr.popup.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("popupId");
    }
}
