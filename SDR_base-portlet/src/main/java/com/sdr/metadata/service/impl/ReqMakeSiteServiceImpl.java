package com.sdr.metadata.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.sdr.metadata.NoSuchReqMakeSiteException;
import com.sdr.metadata.model.ReqMakeSite;
import com.sdr.metadata.service.ReqMakeSiteLocalServiceUtil;
import com.sdr.metadata.service.base.ReqMakeSiteServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the req make site remote service.
 * <p>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sdr.metadata.service.ReqMakeSiteService} interface.
 * <p>
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author jaesung
 * @see com.sdr.metadata.service.base.ReqMakeSiteServiceBaseImpl
 * @see com.sdr.metadata.service.ReqMakeSiteServiceUtil
 */
public class ReqMakeSiteServiceImpl extends ReqMakeSiteServiceBaseImpl {

    /**
     * Get list
     *
     * @param start
     * @param end
     * @param userId
     * @return List<ReqMakeSite>
     * @throws SystemException
     */
    public List<ReqMakeSite> getList(int start, int end, long userId) throws SystemException {
        return ReqMakeSiteLocalServiceUtil.getList(start, end, userId);
    }

    /**
     * Get count
     *
     * @param userId
     * @return int
     * @throws SystemException
     */
    public int getCount(long userId) throws SystemException {
        return ReqMakeSiteLocalServiceUtil.getCount(userId);
    }

    /**
     * Add request make site
     *
     * @param name
     * @param memberType
     * @param description
     * @param message
     * @param userId
     * @return
     * @throws SystemException
     */
    public ReqMakeSite addReqMakeSite(String name, String memberType, String description, String message, long userId) throws SystemException {
        return ReqMakeSiteLocalServiceUtil.addReqMakeSite(name, memberType, description, message, userId);
    }

    /**
     * Update status
     *
     * @param requestId
     * @param type
     * @param answer
     * @return ReqMakeSite
     * @throws NoSuchReqMakeSiteException
     * @throws SystemException
     */
    public ReqMakeSite updateStatus(String requestId, long type, String answer) throws NoSuchReqMakeSiteException, SystemException {
        return ReqMakeSiteLocalServiceUtil.updateStatus(requestId, type, answer);
    }

    /**
     * Get request make site
     *
     * @param requestId
     * @return ReqMakeSite
     * @throws SystemException
     * @throws PortalException
     */
    public ReqMakeSite getReqMakeSite(long requestId) throws SystemException, PortalException {
        return ReqMakeSiteLocalServiceUtil.getReqMakeSite(requestId);
    }

    /**
     * Get request make sites
     *
     * @param start
     * @param end
     * @return List<ReqMakeSite>
     * @throws SystemException
     */
    public List<ReqMakeSite> getReqMakeSites(int start, int end) throws SystemException {
        return ReqMakeSiteLocalServiceUtil.getReqMakeSites(start, end);
    }

}
