package com.sdr.metadata.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import com.sdr.metadata.model.GroupRule;
import com.sdr.metadata.service.GroupRuleLocalServiceUtil;

/**
 * @author jaesung
 * @generated
 */
public abstract class GroupRuleActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public GroupRuleActionableDynamicQuery() throws SystemException {
        setBaseLocalService(GroupRuleLocalServiceUtil.getService());
        setClass(GroupRule.class);

        setClassLoader(com.sdr.metadata.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("grId");
    }
}
