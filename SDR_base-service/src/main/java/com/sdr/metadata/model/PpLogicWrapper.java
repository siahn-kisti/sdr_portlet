package com.sdr.metadata.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PpLogic}.
 * </p>
 *
 * @author jaesung
 * @see PpLogic
 * @generated
 */
public class PpLogicWrapper implements PpLogic, ModelWrapper<PpLogic> {
    private PpLogic _ppLogic;

    public PpLogicWrapper(PpLogic ppLogic) {
        _ppLogic = ppLogic;
    }

    @Override
    public Class<?> getModelClass() {
        return PpLogic.class;
    }

    @Override
    public String getModelClassName() {
        return PpLogic.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("ppId", getPpId());
        attributes.put("userId", getUserId());
        attributes.put("title", getTitle());
        attributes.put("description", getDescription());
        attributes.put("type", getType());
        attributes.put("command", getCommand());
        attributes.put("dataTypeId", getDataTypeId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long ppId = (Long) attributes.get("ppId");

        if (ppId != null) {
            setPpId(ppId);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        Integer type = (Integer) attributes.get("type");

        if (type != null) {
            setType(type);
        }

        String command = (String) attributes.get("command");

        if (command != null) {
            setCommand(command);
        }

        Long dataTypeId = (Long) attributes.get("dataTypeId");

        if (dataTypeId != null) {
            setDataTypeId(dataTypeId);
        }
    }

    /**
    * Returns the primary key of this pp logic.
    *
    * @return the primary key of this pp logic
    */
    @Override
    public long getPrimaryKey() {
        return _ppLogic.getPrimaryKey();
    }

    /**
    * Sets the primary key of this pp logic.
    *
    * @param primaryKey the primary key of this pp logic
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _ppLogic.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the pp ID of this pp logic.
    *
    * @return the pp ID of this pp logic
    */
    @Override
    public long getPpId() {
        return _ppLogic.getPpId();
    }

    /**
    * Sets the pp ID of this pp logic.
    *
    * @param ppId the pp ID of this pp logic
    */
    @Override
    public void setPpId(long ppId) {
        _ppLogic.setPpId(ppId);
    }

    /**
    * Returns the user ID of this pp logic.
    *
    * @return the user ID of this pp logic
    */
    @Override
    public long getUserId() {
        return _ppLogic.getUserId();
    }

    /**
    * Sets the user ID of this pp logic.
    *
    * @param userId the user ID of this pp logic
    */
    @Override
    public void setUserId(long userId) {
        _ppLogic.setUserId(userId);
    }

    /**
    * Returns the user uuid of this pp logic.
    *
    * @return the user uuid of this pp logic
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _ppLogic.getUserUuid();
    }

    /**
    * Sets the user uuid of this pp logic.
    *
    * @param userUuid the user uuid of this pp logic
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _ppLogic.setUserUuid(userUuid);
    }

    /**
    * Returns the title of this pp logic.
    *
    * @return the title of this pp logic
    */
    @Override
    public java.lang.String getTitle() {
        return _ppLogic.getTitle();
    }

    /**
    * Sets the title of this pp logic.
    *
    * @param title the title of this pp logic
    */
    @Override
    public void setTitle(java.lang.String title) {
        _ppLogic.setTitle(title);
    }

    /**
    * Returns the description of this pp logic.
    *
    * @return the description of this pp logic
    */
    @Override
    public java.lang.String getDescription() {
        return _ppLogic.getDescription();
    }

    /**
    * Sets the description of this pp logic.
    *
    * @param description the description of this pp logic
    */
    @Override
    public void setDescription(java.lang.String description) {
        _ppLogic.setDescription(description);
    }

    /**
    * Returns the type of this pp logic.
    *
    * @return the type of this pp logic
    */
    @Override
    public int getType() {
        return _ppLogic.getType();
    }

    /**
    * Sets the type of this pp logic.
    *
    * @param type the type of this pp logic
    */
    @Override
    public void setType(int type) {
        _ppLogic.setType(type);
    }

    /**
    * Returns the command of this pp logic.
    *
    * @return the command of this pp logic
    */
    @Override
    public java.lang.String getCommand() {
        return _ppLogic.getCommand();
    }

    /**
    * Sets the command of this pp logic.
    *
    * @param command the command of this pp logic
    */
    @Override
    public void setCommand(java.lang.String command) {
        _ppLogic.setCommand(command);
    }

    /**
    * Returns the data type ID of this pp logic.
    *
    * @return the data type ID of this pp logic
    */
    @Override
    public long getDataTypeId() {
        return _ppLogic.getDataTypeId();
    }

    /**
    * Sets the data type ID of this pp logic.
    *
    * @param dataTypeId the data type ID of this pp logic
    */
    @Override
    public void setDataTypeId(long dataTypeId) {
        _ppLogic.setDataTypeId(dataTypeId);
    }

    @Override
    public boolean isNew() {
        return _ppLogic.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _ppLogic.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _ppLogic.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _ppLogic.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _ppLogic.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _ppLogic.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _ppLogic.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _ppLogic.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _ppLogic.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _ppLogic.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _ppLogic.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new PpLogicWrapper((PpLogic) _ppLogic.clone());
    }

    @Override
    public int compareTo(com.sdr.metadata.model.PpLogic ppLogic) {
        return _ppLogic.compareTo(ppLogic);
    }

    @Override
    public int hashCode() {
        return _ppLogic.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.sdr.metadata.model.PpLogic> toCacheModel() {
        return _ppLogic.toCacheModel();
    }

    @Override
    public com.sdr.metadata.model.PpLogic toEscapedModel() {
        return new PpLogicWrapper(_ppLogic.toEscapedModel());
    }

    @Override
    public com.sdr.metadata.model.PpLogic toUnescapedModel() {
        return new PpLogicWrapper(_ppLogic.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _ppLogic.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _ppLogic.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _ppLogic.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof PpLogicWrapper)) {
            return false;
        }

        PpLogicWrapper ppLogicWrapper = (PpLogicWrapper) obj;

        if (Validator.equals(_ppLogic, ppLogicWrapper._ppLogic)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public PpLogic getWrappedPpLogic() {
        return _ppLogic;
    }

    @Override
    public PpLogic getWrappedModel() {
        return _ppLogic;
    }

    @Override
    public void resetOriginalValues() {
        _ppLogic.resetOriginalValues();
    }
}
