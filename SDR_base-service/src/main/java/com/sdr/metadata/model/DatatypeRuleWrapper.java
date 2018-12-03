package com.sdr.metadata.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link DatatypeRule}.
 * </p>
 *
 * @author jaesung
 * @see DatatypeRule
 * @generated
 */
public class DatatypeRuleWrapper implements DatatypeRule,
    ModelWrapper<DatatypeRule> {
    private DatatypeRule _datatypeRule;

    public DatatypeRuleWrapper(DatatypeRule datatypeRule) {
        _datatypeRule = datatypeRule;
    }

    @Override
    public Class<?> getModelClass() {
        return DatatypeRule.class;
    }

    @Override
    public String getModelClassName() {
        return DatatypeRule.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("drId", getDrId());
        attributes.put("grId", getGrId());
        attributes.put("dataTypeId", getDataTypeId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long drId = (Long) attributes.get("drId");

        if (drId != null) {
            setDrId(drId);
        }

        Long grId = (Long) attributes.get("grId");

        if (grId != null) {
            setGrId(grId);
        }

        Long dataTypeId = (Long) attributes.get("dataTypeId");

        if (dataTypeId != null) {
            setDataTypeId(dataTypeId);
        }
    }

    /**
    * Returns the primary key of this datatype rule.
    *
    * @return the primary key of this datatype rule
    */
    @Override
    public long getPrimaryKey() {
        return _datatypeRule.getPrimaryKey();
    }

    /**
    * Sets the primary key of this datatype rule.
    *
    * @param primaryKey the primary key of this datatype rule
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _datatypeRule.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the dr ID of this datatype rule.
    *
    * @return the dr ID of this datatype rule
    */
    @Override
    public long getDrId() {
        return _datatypeRule.getDrId();
    }

    /**
    * Sets the dr ID of this datatype rule.
    *
    * @param drId the dr ID of this datatype rule
    */
    @Override
    public void setDrId(long drId) {
        _datatypeRule.setDrId(drId);
    }

    /**
    * Returns the gr ID of this datatype rule.
    *
    * @return the gr ID of this datatype rule
    */
    @Override
    public long getGrId() {
        return _datatypeRule.getGrId();
    }

    /**
    * Sets the gr ID of this datatype rule.
    *
    * @param grId the gr ID of this datatype rule
    */
    @Override
    public void setGrId(long grId) {
        _datatypeRule.setGrId(grId);
    }

    /**
    * Returns the data type ID of this datatype rule.
    *
    * @return the data type ID of this datatype rule
    */
    @Override
    public long getDataTypeId() {
        return _datatypeRule.getDataTypeId();
    }

    /**
    * Sets the data type ID of this datatype rule.
    *
    * @param dataTypeId the data type ID of this datatype rule
    */
    @Override
    public void setDataTypeId(long dataTypeId) {
        _datatypeRule.setDataTypeId(dataTypeId);
    }

    @Override
    public boolean isNew() {
        return _datatypeRule.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _datatypeRule.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _datatypeRule.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _datatypeRule.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _datatypeRule.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _datatypeRule.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _datatypeRule.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _datatypeRule.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _datatypeRule.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _datatypeRule.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _datatypeRule.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new DatatypeRuleWrapper((DatatypeRule) _datatypeRule.clone());
    }

    @Override
    public int compareTo(com.sdr.metadata.model.DatatypeRule datatypeRule) {
        return _datatypeRule.compareTo(datatypeRule);
    }

    @Override
    public int hashCode() {
        return _datatypeRule.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.sdr.metadata.model.DatatypeRule> toCacheModel() {
        return _datatypeRule.toCacheModel();
    }

    @Override
    public com.sdr.metadata.model.DatatypeRule toEscapedModel() {
        return new DatatypeRuleWrapper(_datatypeRule.toEscapedModel());
    }

    @Override
    public com.sdr.metadata.model.DatatypeRule toUnescapedModel() {
        return new DatatypeRuleWrapper(_datatypeRule.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _datatypeRule.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _datatypeRule.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _datatypeRule.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof DatatypeRuleWrapper)) {
            return false;
        }

        DatatypeRuleWrapper datatypeRuleWrapper = (DatatypeRuleWrapper) obj;

        if (Validator.equals(_datatypeRule, datatypeRuleWrapper._datatypeRule)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public DatatypeRule getWrappedDatatypeRule() {
        return _datatypeRule;
    }

    @Override
    public DatatypeRule getWrappedModel() {
        return _datatypeRule;
    }

    @Override
    public void resetOriginalValues() {
        _datatypeRule.resetOriginalValues();
    }
}
