package com.sdr.metadata.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.sdr.metadata.model.MlGuiParameter;
import com.sdr.metadata.service.MlGuiParameterLocalServiceUtil;

/**
 * @author jaesung
 * @generated
 */
public abstract class MlGuiParameterActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public MlGuiParameterActionableDynamicQuery() throws SystemException {
        setBaseLocalService(MlGuiParameterLocalServiceUtil.getService());
        setClass(MlGuiParameter.class);

        setClassLoader(com.sdr.metadata.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("mlGuiParameterId");
    }
}
