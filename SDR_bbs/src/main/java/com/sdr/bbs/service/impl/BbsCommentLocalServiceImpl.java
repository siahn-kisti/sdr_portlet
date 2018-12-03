package com.sdr.bbs.service.impl;

import com.liferay.portal.kernel.exception.SystemException;
import com.sdr.bbs.model.BbsComment;
import com.sdr.bbs.service.base.BbsCommentLocalServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the bbs comment local service.
 * <p>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sdr.bbs.service.BbsCommentLocalService} interface.
 * <p>
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author goopsw
 * @see com.sdr.bbs.service.base.BbsCommentLocalServiceBaseImpl
 * @see com.sdr.bbs.service.BbsCommentLocalServiceUtil
 */
public class BbsCommentLocalServiceImpl extends BbsCommentLocalServiceBaseImpl {

    /**
     * Get bbs comment
     *
     * @param commentId the primary key of the bbs comment
     * @return BbsComment
     * @throws SystemException
     */
    public BbsComment getBbsComment(long commentId) throws SystemException {
        return this.bbsCommentPersistence.fetchByPrimaryKey(commentId);
    }

    /**
     * Count by post id
     *
     * @param postId
     * @return
     * @throws SystemException
     */
    public int countByPostId(long postId) throws SystemException {
        return this.bbsCommentPersistence.countByPostId(postId);
    }

    /**
     * Find by post id
     *
     * @param postId
     * @param start
     * @param end
     * @return List
     * @throws SystemException
     */
    public List<BbsComment> findByPostId(long postId, int start, int end) throws SystemException {
        return this.bbsCommentPersistence.findByPostId(postId, start, end);
    }
}
