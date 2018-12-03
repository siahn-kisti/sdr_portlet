package com.sdr.metadata.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link GroupRule}.
 * </p>
 *
 * @author jaesung
 * @see GroupRule
 * @generated
 */
public class GroupRuleWrapper implements GroupRule, ModelWrapper<GroupRule> {
    private GroupRule _groupRule;

    public GroupRuleWrapper(GroupRule groupRule) {
        _groupRule = groupRule;
    }

    @Override
    public Class<?> getModelClass() {
        return GroupRule.class;
    }

    @Override
    public String getModelClassName() {
        return GroupRule.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("grId", getGrId());
        attributes.put("title", getTitle());
        attributes.put("description", getDescription());
        attributes.put("rule", getRule());
        attributes.put("viewAttr", getViewAttr());
        attributes.put("mergeAttr", getMergeAttr());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long grId = (Long) attributes.get("grId");

        if (grId != null) {
            setGrId(grId);
        }

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        String rule = (String) attributes.get("rule");

        if (rule != null) {
            setRule(rule);
        }

        String viewAttr = (String) attributes.get("viewAttr");

        if (viewAttr != null) {
            setViewAttr(viewAttr);
        }

        String mergeAttr = (String) attributes.get("mergeAttr");

        if (mergeAttr != null) {
            setMergeAttr(mergeAttr);
        }
    }

    /**
    * Returns the primary key of this group rule.
    *
    * @return the primary key of this group rule
    */
    @Override
    public long getPrimaryKey() {
        return _groupRule.getPrimaryKey();
    }

    /**
    * Sets the primary key of this group rule.
    *
    * @param primaryKey the primary key of this group rule
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _groupRule.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the gr ID of this group rule.
    *
    * @return the gr ID of this group rule
    */
    @Override
    public long getGrId() {
        return _groupRule.getGrId();
    }

    /**
    * Sets the gr ID of this group rule.
    *
    * @param grId the gr ID of this group rule
    */
    @Override
    public void setGrId(long grId) {
        _groupRule.setGrId(grId);
    }

    /**
    * Returns the title of this group rule.
    *
    * @return the title of this group rule
    */
    @Override
    public java.lang.String getTitle() {
        return _groupRule.getTitle();
    }

    /**
    * Sets the title of this group rule.
    *
    * @param title the title of this group rule
    */
    @Override
    public void setTitle(java.lang.String title) {
        _groupRule.setTitle(title);
    }

    /**
    * Returns the description of this group rule.
    *
    * @return the description of this group rule
    */
    @Override
    public java.lang.String getDescription() {
        return _groupRule.getDescription();
    }

    /**
    * Sets the description of this group rule.
    *
    * @param description the description of this group rule
    */
    @Override
    public void setDescription(java.lang.String description) {
        _groupRule.setDescription(description);
    }

    /**
    * Returns the rule of this group rule.
    *
    * @return the rule of this group rule
    */
    @Override
    public java.lang.String getRule() {
        return _groupRule.getRule();
    }

    /**
    * Sets the rule of this group rule.
    *
    * @param rule the rule of this group rule
    */
    @Override
    public void setRule(java.lang.String rule) {
        _groupRule.setRule(rule);
    }

    /**
    * Returns the view attr of this group rule.
    *
    * @return the view attr of this group rule
    */
    @Override
    public java.lang.String getViewAttr() {
        return _groupRule.getViewAttr();
    }

    /**
    * Sets the view attr of this group rule.
    *
    * @param viewAttr the view attr of this group rule
    */
    @Override
    public void setViewAttr(java.lang.String viewAttr) {
        _groupRule.setViewAttr(viewAttr);
    }

    /**
    * Returns the merge attr of this group rule.
    *
    * @return the merge attr of this group rule
    */
    @Override
    public java.lang.String getMergeAttr() {
        return _groupRule.getMergeAttr();
    }

    /**
    * Sets the merge attr of this group rule.
    *
    * @param mergeAttr the merge attr of this group rule
    */
    @Override
    public void setMergeAttr(java.lang.String mergeAttr) {
        _groupRule.setMergeAttr(mergeAttr);
    }

    @Override
    public boolean isNew() {
        return _groupRule.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _groupRule.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _groupRule.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _groupRule.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _groupRule.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _groupRule.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _groupRule.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _groupRule.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _groupRule.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _groupRule.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _groupRule.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new GroupRuleWrapper((GroupRule) _groupRule.clone());
    }

    @Override
    public int compareTo(com.sdr.metadata.model.GroupRule groupRule) {
        return _groupRule.compareTo(groupRule);
    }

    @Override
    public int hashCode() {
        return _groupRule.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.sdr.metadata.model.GroupRule> toCacheModel() {
        return _groupRule.toCacheModel();
    }

    @Override
    public com.sdr.metadata.model.GroupRule toEscapedModel() {
        return new GroupRuleWrapper(_groupRule.toEscapedModel());
    }

    @Override
    public com.sdr.metadata.model.GroupRule toUnescapedModel() {
        return new GroupRuleWrapper(_groupRule.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _groupRule.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _groupRule.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _groupRule.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof GroupRuleWrapper)) {
            return false;
        }

        GroupRuleWrapper groupRuleWrapper = (GroupRuleWrapper) obj;

        if (Validator.equals(_groupRule, groupRuleWrapper._groupRule)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public GroupRule getWrappedGroupRule() {
        return _groupRule;
    }

    @Override
    public GroupRule getWrappedModel() {
        return _groupRule;
    }

    @Override
    public void resetOriginalValues() {
        _groupRule.resetOriginalValues();
    }
}
