package com.sdr.bbs.model.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.sdr.bbs.model.BbsComment;
import com.sdr.bbs.service.BbsCommentLocalServiceUtil;

import java.util.List;

/**
 * The extended model implementation for the BbsPost service. Represents a row in the &quot;sdr_bbs_BbsPost&quot; database table, with each column mapped to a property of this class.
 * <p>
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sdr.bbs.model.BbsPost} interface.
 * </p>
 *
 * @author goopsw
 */
public class BbsPostImpl extends BbsPostBaseImpl {

    public int getBbsCommentsCount() throws SystemException {
        return BbsCommentLocalServiceUtil.countByPostId(getPostId());
    }

    public List<BbsComment> getBbsComments() throws SystemException {
        List<BbsComment> bbsComments = null;

        int bbsCommentsCount = getBbsCommentsCount();
        if (bbsCommentsCount > 0) {
            bbsComments = BbsCommentLocalServiceUtil.findByPostId(getPostId(), 0, bbsCommentsCount);
        }
        return bbsComments;
    }

    public String getUserName() throws SystemException, PortalException {
        return UserLocalServiceUtil.getUser(getUserId()).getFullName();
    }
}
