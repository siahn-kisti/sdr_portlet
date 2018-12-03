package com.sdr.bbs.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.sdr.bbs.model.BbsPost;
import com.sdr.bbs.service.BbsPostLocalServiceUtil;

/**
 * @author goopsw
 * @generated
 */
public abstract class BbsPostActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public BbsPostActionableDynamicQuery() throws SystemException {
        setBaseLocalService(BbsPostLocalServiceUtil.getService());
        setClass(BbsPost.class);

        setClassLoader(com.sdr.bbs.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("postId");
    }
}
