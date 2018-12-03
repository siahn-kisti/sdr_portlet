package com.sdr.metadata.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link MlGuiParameter}.
 * </p>
 *
 * @author jaesung
 * @see MlGuiParameter
 * @generated
 */
public class MlGuiParameterWrapper implements MlGuiParameter,
    ModelWrapper<MlGuiParameter> {
    private MlGuiParameter _mlGuiParameter;

    public MlGuiParameterWrapper(MlGuiParameter mlGuiParameter) {
        _mlGuiParameter = mlGuiParameter;
    }

    @Override
    public Class<?> getModelClass() {
        return MlGuiParameter.class;
    }

    @Override
    public String getModelClassName() {
        return MlGuiParameter.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("mlGuiParameterId", getMlGuiParameterId());
        attributes.put("parentId", getParentId());
        attributes.put("kind", getKind());
        attributes.put("displayName", getDisplayName());
        attributes.put("valueType", getValueType());
        attributes.put("value", getValue());
        attributes.put("image", getImage());
        attributes.put("option", getOption());
        attributes.put("description", getDescription());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long mlGuiParameterId = (Long) attributes.get("mlGuiParameterId");

        if (mlGuiParameterId != null) {
            setMlGuiParameterId(mlGuiParameterId);
        }

        Long parentId = (Long) attributes.get("parentId");

        if (parentId != null) {
            setParentId(parentId);
        }

        String kind = (String) attributes.get("kind");

        if (kind != null) {
            setKind(kind);
        }

        String displayName = (String) attributes.get("displayName");

        if (displayName != null) {
            setDisplayName(displayName);
        }

        String valueType = (String) attributes.get("valueType");

        if (valueType != null) {
            setValueType(valueType);
        }

        String value = (String) attributes.get("value");

        if (value != null) {
            setValue(value);
        }

        String image = (String) attributes.get("image");

        if (image != null) {
            setImage(image);
        }

        String option = (String) attributes.get("option");

        if (option != null) {
            setOption(option);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }
    }

    /**
    * Returns the primary key of this ml gui parameter.
    *
    * @return the primary key of this ml gui parameter
    */
    @Override
    public long getPrimaryKey() {
        return _mlGuiParameter.getPrimaryKey();
    }

    /**
    * Sets the primary key of this ml gui parameter.
    *
    * @param primaryKey the primary key of this ml gui parameter
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _mlGuiParameter.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the ml gui parameter ID of this ml gui parameter.
    *
    * @return the ml gui parameter ID of this ml gui parameter
    */
    @Override
    public long getMlGuiParameterId() {
        return _mlGuiParameter.getMlGuiParameterId();
    }

    /**
    * Sets the ml gui parameter ID of this ml gui parameter.
    *
    * @param mlGuiParameterId the ml gui parameter ID of this ml gui parameter
    */
    @Override
    public void setMlGuiParameterId(long mlGuiParameterId) {
        _mlGuiParameter.setMlGuiParameterId(mlGuiParameterId);
    }

    /**
    * Returns the parent ID of this ml gui parameter.
    *
    * @return the parent ID of this ml gui parameter
    */
    @Override
    public long getParentId() {
        return _mlGuiParameter.getParentId();
    }

    /**
    * Sets the parent ID of this ml gui parameter.
    *
    * @param parentId the parent ID of this ml gui parameter
    */
    @Override
    public void setParentId(long parentId) {
        _mlGuiParameter.setParentId(parentId);
    }

    /**
    * Returns the kind of this ml gui parameter.
    *
    * @return the kind of this ml gui parameter
    */
    @Override
    public java.lang.String getKind() {
        return _mlGuiParameter.getKind();
    }

    /**
    * Sets the kind of this ml gui parameter.
    *
    * @param kind the kind of this ml gui parameter
    */
    @Override
    public void setKind(java.lang.String kind) {
        _mlGuiParameter.setKind(kind);
    }

    /**
    * Returns the display name of this ml gui parameter.
    *
    * @return the display name of this ml gui parameter
    */
    @Override
    public java.lang.String getDisplayName() {
        return _mlGuiParameter.getDisplayName();
    }

    /**
    * Sets the display name of this ml gui parameter.
    *
    * @param displayName the display name of this ml gui parameter
    */
    @Override
    public void setDisplayName(java.lang.String displayName) {
        _mlGuiParameter.setDisplayName(displayName);
    }

    /**
    * Returns the value type of this ml gui parameter.
    *
    * @return the value type of this ml gui parameter
    */
    @Override
    public java.lang.String getValueType() {
        return _mlGuiParameter.getValueType();
    }

    /**
    * Sets the value type of this ml gui parameter.
    *
    * @param valueType the value type of this ml gui parameter
    */
    @Override
    public void setValueType(java.lang.String valueType) {
        _mlGuiParameter.setValueType(valueType);
    }

    /**
    * Returns the value of this ml gui parameter.
    *
    * @return the value of this ml gui parameter
    */
    @Override
    public java.lang.String getValue() {
        return _mlGuiParameter.getValue();
    }

    /**
    * Sets the value of this ml gui parameter.
    *
    * @param value the value of this ml gui parameter
    */
    @Override
    public void setValue(java.lang.String value) {
        _mlGuiParameter.setValue(value);
    }

    /**
    * Returns the image of this ml gui parameter.
    *
    * @return the image of this ml gui parameter
    */
    @Override
    public java.lang.String getImage() {
        return _mlGuiParameter.getImage();
    }

    /**
    * Sets the image of this ml gui parameter.
    *
    * @param image the image of this ml gui parameter
    */
    @Override
    public void setImage(java.lang.String image) {
        _mlGuiParameter.setImage(image);
    }

    /**
    * Returns the option of this ml gui parameter.
    *
    * @return the option of this ml gui parameter
    */
    @Override
    public java.lang.String getOption() {
        return _mlGuiParameter.getOption();
    }

    /**
    * Sets the option of this ml gui parameter.
    *
    * @param option the option of this ml gui parameter
    */
    @Override
    public void setOption(java.lang.String option) {
        _mlGuiParameter.setOption(option);
    }

    /**
    * Returns the description of this ml gui parameter.
    *
    * @return the description of this ml gui parameter
    */
    @Override
    public java.lang.String getDescription() {
        return _mlGuiParameter.getDescription();
    }

    /**
    * Sets the description of this ml gui parameter.
    *
    * @param description the description of this ml gui parameter
    */
    @Override
    public void setDescription(java.lang.String description) {
        _mlGuiParameter.setDescription(description);
    }

    @Override
    public boolean isNew() {
        return _mlGuiParameter.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _mlGuiParameter.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _mlGuiParameter.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _mlGuiParameter.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _mlGuiParameter.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _mlGuiParameter.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _mlGuiParameter.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _mlGuiParameter.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _mlGuiParameter.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _mlGuiParameter.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _mlGuiParameter.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new MlGuiParameterWrapper((MlGuiParameter) _mlGuiParameter.clone());
    }

    @Override
    public int compareTo(com.sdr.metadata.model.MlGuiParameter mlGuiParameter) {
        return _mlGuiParameter.compareTo(mlGuiParameter);
    }

    @Override
    public int hashCode() {
        return _mlGuiParameter.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.sdr.metadata.model.MlGuiParameter> toCacheModel() {
        return _mlGuiParameter.toCacheModel();
    }

    @Override
    public com.sdr.metadata.model.MlGuiParameter toEscapedModel() {
        return new MlGuiParameterWrapper(_mlGuiParameter.toEscapedModel());
    }

    @Override
    public com.sdr.metadata.model.MlGuiParameter toUnescapedModel() {
        return new MlGuiParameterWrapper(_mlGuiParameter.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _mlGuiParameter.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _mlGuiParameter.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _mlGuiParameter.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof MlGuiParameterWrapper)) {
            return false;
        }

        MlGuiParameterWrapper mlGuiParameterWrapper = (MlGuiParameterWrapper) obj;

        if (Validator.equals(_mlGuiParameter,
                    mlGuiParameterWrapper._mlGuiParameter)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public MlGuiParameter getWrappedMlGuiParameter() {
        return _mlGuiParameter;
    }

    @Override
    public MlGuiParameter getWrappedModel() {
        return _mlGuiParameter;
    }

    @Override
    public void resetOriginalValues() {
        _mlGuiParameter.resetOriginalValues();
    }
}
