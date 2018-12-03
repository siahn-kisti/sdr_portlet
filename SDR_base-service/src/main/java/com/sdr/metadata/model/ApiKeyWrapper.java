package com.sdr.metadata.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ApiKey}.
 * </p>
 *
 * @author jaesung
 * @see ApiKey
 * @generated
 */
public class ApiKeyWrapper implements ApiKey, ModelWrapper<ApiKey> {
    private ApiKey _apiKey;

    public ApiKeyWrapper(ApiKey apiKey) {
        _apiKey = apiKey;
    }

    @Override
    public Class<?> getModelClass() {
        return ApiKey.class;
    }

    @Override
    public String getModelClassName() {
        return ApiKey.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("userId", getUserId());
        attributes.put("apiKey", getApiKey());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        String apiKey = (String) attributes.get("apiKey");

        if (apiKey != null) {
            setApiKey(apiKey);
        }
    }

    /**
    * Returns the primary key of this api key.
    *
    * @return the primary key of this api key
    */
    @Override
    public long getPrimaryKey() {
        return _apiKey.getPrimaryKey();
    }

    /**
    * Sets the primary key of this api key.
    *
    * @param primaryKey the primary key of this api key
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _apiKey.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the user ID of this api key.
    *
    * @return the user ID of this api key
    */
    @Override
    public long getUserId() {
        return _apiKey.getUserId();
    }

    /**
    * Sets the user ID of this api key.
    *
    * @param userId the user ID of this api key
    */
    @Override
    public void setUserId(long userId) {
        _apiKey.setUserId(userId);
    }

    /**
    * Returns the user uuid of this api key.
    *
    * @return the user uuid of this api key
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _apiKey.getUserUuid();
    }

    /**
    * Sets the user uuid of this api key.
    *
    * @param userUuid the user uuid of this api key
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _apiKey.setUserUuid(userUuid);
    }

    /**
    * Returns the api key of this api key.
    *
    * @return the api key of this api key
    */
    @Override
    public java.lang.String getApiKey() {
        return _apiKey.getApiKey();
    }

    /**
    * Sets the api key of this api key.
    *
    * @param apiKey the api key of this api key
    */
    @Override
    public void setApiKey(java.lang.String apiKey) {
        _apiKey.setApiKey(apiKey);
    }

    @Override
    public boolean isNew() {
        return _apiKey.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _apiKey.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _apiKey.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _apiKey.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _apiKey.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _apiKey.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _apiKey.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _apiKey.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _apiKey.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _apiKey.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _apiKey.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new ApiKeyWrapper((ApiKey) _apiKey.clone());
    }

    @Override
    public int compareTo(com.sdr.metadata.model.ApiKey apiKey) {
        return _apiKey.compareTo(apiKey);
    }

    @Override
    public int hashCode() {
        return _apiKey.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.sdr.metadata.model.ApiKey> toCacheModel() {
        return _apiKey.toCacheModel();
    }

    @Override
    public com.sdr.metadata.model.ApiKey toEscapedModel() {
        return new ApiKeyWrapper(_apiKey.toEscapedModel());
    }

    @Override
    public com.sdr.metadata.model.ApiKey toUnescapedModel() {
        return new ApiKeyWrapper(_apiKey.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _apiKey.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _apiKey.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _apiKey.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ApiKeyWrapper)) {
            return false;
        }

        ApiKeyWrapper apiKeyWrapper = (ApiKeyWrapper) obj;

        if (Validator.equals(_apiKey, apiKeyWrapper._apiKey)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public ApiKey getWrappedApiKey() {
        return _apiKey;
    }

    @Override
    public ApiKey getWrappedModel() {
        return _apiKey;
    }

    @Override
    public void resetOriginalValues() {
        _apiKey.resetOriginalValues();
    }
}
