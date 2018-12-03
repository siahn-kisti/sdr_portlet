package com.sdr.bbs.service.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.sdr.bbs.model.Bbs;
import com.sdr.bbs.service.base.BbsLocalServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the bbs local service.
 * <p>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sdr.bbs.service.BbsLocalService} interface.
 * <p>
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author goopsw
 * @see com.sdr.bbs.service.base.BbsLocalServiceBaseImpl
 * @see com.sdr.bbs.service.BbsLocalServiceUtil
 */
public class BbsLocalServiceImpl extends BbsLocalServiceBaseImpl {

    /**
     * Get bbs
     *
     * @param bbsId the primary key of the bbs
     * @return Bbs
     * @throws SystemException
     */
    public Bbs getBbs(long bbsId) throws SystemException {
        return bbsPersistence.fetchByPrimaryKey(bbsId);
    }

    /**
     * Count by company id and group id
     *
     * @param companyId
     * @param groupId
     * @return int
     * @throws SystemException
     */
    public int countByC_G(long companyId, long groupId) throws SystemException {
        return bbsPersistence.countByC_G(companyId, groupId);
    }

    /**
     * Find by company id and group id
     *
     * @param companyId
     * @param groupId
     * @param start
     * @param end
     * @return List
     * @throws SystemException
     */
    public List<Bbs> findByC_G(long companyId, long groupId, int start, int end) throws SystemException {
        return bbsPersistence.findByC_G(companyId, groupId, start, end);
    }
}
