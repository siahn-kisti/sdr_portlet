package com.sdr.popup.service.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sdr.popup.model.Popup;
import com.sdr.popup.service.base.PopupLocalServiceBaseImpl;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the popup local service.
 * <p>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sdr.popup.service.PopupLocalService} interface.
 * <p>
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author goopsw
 * @see PopupLocalServiceBaseImpl
 * @see com.sdr.popup.service.PopupLocalServiceUtil
 */
public class PopupLocalServiceImpl extends PopupLocalServiceBaseImpl {

    private static Log _log = LogFactoryUtil.getLog(PopupLocalServiceImpl.class);

    public List<Popup> getAllPopups(long companyId, long groupId) throws SystemException {
        return popupPersistence.findByC_G(companyId, groupId);
    }

    public List<Popup> getAvailablePopups(long companyId, long groupId)
            throws SystemException {
        Date today = new Date();
        boolean bannerEnable = true;

        return this.popupPersistence.findByC_G_S_F_E(companyId, groupId, today, today, bannerEnable);
    }
}
