package com.sdr.bbs.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.sdr.bbs.model.BbsComment;
import com.sdr.bbs.service.BbsCommentLocalServiceUtil;

/**
 * @author goopsw
 * @generated
 */
public abstract class BbsCommentActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public BbsCommentActionableDynamicQuery() throws SystemException {
        setBaseLocalService(BbsCommentLocalServiceUtil.getService());
        setClass(BbsComment.class);

        setClassLoader(com.sdr.bbs.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("commentId");
    }
}
