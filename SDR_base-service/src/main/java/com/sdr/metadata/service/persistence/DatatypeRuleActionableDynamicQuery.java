package com.sdr.metadata.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.sdr.metadata.model.DatatypeRule;
import com.sdr.metadata.service.DatatypeRuleLocalServiceUtil;

/**
 * @author jaesung
 * @generated
 */
public abstract class DatatypeRuleActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public DatatypeRuleActionableDynamicQuery() throws SystemException {
        setBaseLocalService(DatatypeRuleLocalServiceUtil.getService());
        setClass(DatatypeRule.class);

        setClassLoader(com.sdr.metadata.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("drId");
    }
}
