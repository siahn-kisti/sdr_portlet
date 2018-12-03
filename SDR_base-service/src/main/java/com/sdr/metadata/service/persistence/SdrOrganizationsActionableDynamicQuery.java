package com.sdr.metadata.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.sdr.metadata.model.SdrOrganizations;
import com.sdr.metadata.service.SdrOrganizationsLocalServiceUtil;

/**
 * @author jaesung
 * @generated
 */
public abstract class SdrOrganizationsActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public SdrOrganizationsActionableDynamicQuery() throws SystemException {
        setBaseLocalService(SdrOrganizationsLocalServiceUtil.getService());
        setClass(SdrOrganizations.class);

        setClassLoader(com.sdr.metadata.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("organizationId");
    }
}
