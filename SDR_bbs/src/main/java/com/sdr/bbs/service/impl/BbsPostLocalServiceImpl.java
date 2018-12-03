package com.sdr.bbs.service.impl;

import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.exception.SystemException;
import com.sdr.bbs.common.model.BbsPostVo;
import com.sdr.bbs.model.BbsPost;
import com.sdr.bbs.service.base.BbsPostLocalServiceBaseImpl;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * The implementation of the bbs post local service.
 * <p>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sdr.bbs.service.BbsPostLocalService} interface.
 * <p>
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author goopsw
 * @see com.sdr.bbs.service.base.BbsPostLocalServiceBaseImpl
 * @see com.sdr.bbs.service.BbsPostLocalServiceUtil
 */
public class BbsPostLocalServiceImpl extends BbsPostLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.sdr.bbs.service.BbsPostLocalServiceUtil} to access the bbs post local service.
     */

    /**
     * Get list
     *
     * @param start
     * @param end
     * @return List
     * @throws SystemException
     */
    public List<BbsPost> getList(int start, int end) throws SystemException {
        DynamicQuery query = DynamicQueryFactoryUtil.forClass(BbsPost.class);
        query.addOrder(OrderFactoryUtil.asc("postId"));

        return bbsPostPersistence.findWithDynamicQuery(query, start, end);
    }

    /**
     * Get count
     *
     * @return int
     * @throws SystemException
     */
    public int getCount() throws SystemException {
        DynamicQuery query = DynamicQueryFactoryUtil.forClass(BbsPost.class);
        query.addOrder(OrderFactoryUtil.asc("postId"));

        return (int) bbsPostPersistence.countWithDynamicQuery(query);
    }

    /**
     * Find by bbs id
     *
     * @param bbsId
     * @param start
     * @param end
     * @return List
     * @throws SystemException
     */
    public List<BbsPost> findByBbsId(long bbsId, int start, int end) throws SystemException {
        return this.bbsPostPersistence.findByBbsId(bbsId, start, end);
    }

    /**
     * Count by bbs id
     *
     * @param bbsId
     * @return int
     * @throws SystemException
     */
    public int countByBbsId(long bbsId) throws SystemException {
        return this.bbsPostPersistence.countByBbsId(bbsId);
    }


    /**
     * Get list
     *
     * @param start
     * @param end
     * @param keyword
     * @param bbsId
     * @return List
     * @throws SystemException
     */
    public List<BbsPost> getList(int start, int end, String keyword, long bbsId) throws SystemException {
        DynamicQuery query = DynamicQueryFactoryUtil.forClass(BbsPost.class);
        Criterion criterion = null;
        criterion = PropertyFactoryUtil.forName("bbsId").eq(bbsId);
        if(!StringUtils.isEmpty(keyword)){
            criterion = RestrictionsFactoryUtil.and(criterion, PropertyFactoryUtil.forName("title").like("%"+keyword+"%"));
        }
        query.add(criterion);
        query.addOrder(OrderFactoryUtil.desc("postId"));

        return (List<BbsPost>) bbsPostPersistence.findWithDynamicQuery(query, start, end);
    }

    /**
     * Get count
     *
     * @param keyword
     * @param bbsId
     * @return int
     * @throws SystemException
     */
    public int getCount(String keyword, long bbsId) throws SystemException {
        DynamicQuery query = DynamicQueryFactoryUtil.forClass(BbsPost.class);
        Criterion criterion = null;
        criterion = PropertyFactoryUtil.forName("bbsId").eq(bbsId);
        if(!StringUtils.isEmpty(keyword)){
            criterion = PropertyFactoryUtil.forName("title").like("%"+keyword+"%");
        }
        query.add(criterion);

        return (int) bbsPostPersistence.countWithDynamicQuery(query);
    }


}
