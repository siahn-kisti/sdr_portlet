package com.sdr.metadata.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import com.sdr.metadata.model.GroupRule;
import com.sdr.metadata.service.GroupRuleLocalServiceUtil;

/**
 * The extended model base implementation for the GroupRule service. Represents a row in the &quot;sdr_GroupRule&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link GroupRuleImpl}.
 * </p>
 *
 * @author jaesung
 * @see GroupRuleImpl
 * @see com.sdr.metadata.model.GroupRule
 * @generated
 */
public abstract class GroupRuleBaseImpl extends GroupRuleModelImpl
    implements GroupRule {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a group rule model instance should use the {@link GroupRule} interface instead.
     */
    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            GroupRuleLocalServiceUtil.addGroupRule(this);
        } else {
            GroupRuleLocalServiceUtil.updateGroupRule(this);
        }
    }
}
