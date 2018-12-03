package com.sdr.metadata.service.impl;

import com.liferay.portal.kernel.dao.orm.*;
import com.sdr.community.CommunityConstants;
import com.sdr.metadata.NoSuchReqMakeSiteException;
import com.sdr.metadata.model.ReqMakeSite;
import com.sdr.metadata.service.base.ReqMakeSiteLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the req make site local service.
 * <p>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sdr.metadata.service.ReqMakeSiteLocalService} interface.
 * <p>
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author jaesung
 * @see com.sdr.metadata.service.base.ReqMakeSiteLocalServiceBaseImpl
 * @see com.sdr.metadata.service.ReqMakeSiteLocalServiceUtil
 */
public class ReqMakeSiteLocalServiceImpl extends ReqMakeSiteLocalServiceBaseImpl {

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
        DynamicQuery query = DynamicQueryFactoryUtil.forClass(ReqMakeSite.class);

        Criterion criterion = null;
        criterion = PropertyFactoryUtil.forName("userId").eq(userId);
        query.add(criterion);

        query.addOrder(OrderFactoryUtil.asc("requestId"));

        return reqMakeSitePersistence.findWithDynamicQuery(query, start, end);
    }

    /**
     * Get count
     *
     * @param userId
     * @return int
     * @throws SystemException
     */
    public int getCount(long userId) throws SystemException {
        DynamicQuery query = DynamicQueryFactoryUtil.forClass(ReqMakeSite.class);

        Criterion criterion = null;
        criterion = PropertyFactoryUtil.forName("userId").eq(userId);
        query.add(criterion);

        query.addOrder(OrderFactoryUtil.asc("requestId"));

        return (int) reqMakeSitePersistence.countWithDynamicQuery(query);
    }

    /**
     * Add request make site
     *
     * @param name
     * @param memberType
     * @param description
     * @param message
     * @param userId
     * @return ReqMakeSite
     * @throws SystemException
     */
    public ReqMakeSite addReqMakeSite(String name, String memberType, String description, String message, long userId) throws SystemException {

        long requestId = counterLocalService.increment();
        ReqMakeSite vo = reqMakeSitePersistence.create(requestId);

        vo.setName(name);
        vo.setDescription(description);
        vo.setSiteType(Long.parseLong(memberType));
        vo.setUserId(userId);
        vo.setRequestDate(new Date());
        vo.setMessage(message);
        vo.setStatus(CommunityConstants.STATUS_PENDING);

        ReqMakeSite returnVo = reqMakeSitePersistence.update(vo);
        return returnVo;
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
        ReqMakeSite vo = reqMakeSitePersistence.findByPrimaryKey(Long.parseLong(requestId));
        vo.setStatus(type);
        vo.setAnswer(answer);
        vo.setConfirmDate(new Date());

        ReqMakeSite returnVo = reqMakeSitePersistence.update(vo);
        return returnVo;
    }

}
