package com.sdr.metadata.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.sdr.metadata.model.Collection;
import com.sdr.metadata.service.CollectionLocalServiceUtil;

/**
 * @author jaesung
 * @generated
 */
public abstract class CollectionActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public CollectionActionableDynamicQuery() throws SystemException {
        setBaseLocalService(CollectionLocalServiceUtil.getService());
        setClass(Collection.class);

        setClassLoader(com.sdr.metadata.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("collectionId");
    }
}
