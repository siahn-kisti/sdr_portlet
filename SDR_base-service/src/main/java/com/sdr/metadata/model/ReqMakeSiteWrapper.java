package com.sdr.metadata.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ReqMakeSite}.
 * </p>
 *
 * @author jaesung
 * @see ReqMakeSite
 * @generated
 */
public class ReqMakeSiteWrapper implements ReqMakeSite,
    ModelWrapper<ReqMakeSite> {
    private ReqMakeSite _reqMakeSite;

    public ReqMakeSiteWrapper(ReqMakeSite reqMakeSite) {
        _reqMakeSite = reqMakeSite;
    }

    @Override
    public Class<?> getModelClass() {
        return ReqMakeSite.class;
    }

    @Override
    public String getModelClassName() {
        return ReqMakeSite.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("requestId", getRequestId());
        attributes.put("name", getName());
        attributes.put("description", getDescription());
        attributes.put("siteType", getSiteType());
        attributes.put("userId", getUserId());
        attributes.put("requestDate", getRequestDate());
        attributes.put("confirmDate", getConfirmDate());
        attributes.put("message", getMessage());
        attributes.put("status", getStatus());
        attributes.put("answer", getAnswer());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long requestId = (Long) attributes.get("requestId");

        if (requestId != null) {
            setRequestId(requestId);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        Long siteType = (Long) attributes.get("siteType");

        if (siteType != null) {
            setSiteType(siteType);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        Date requestDate = (Date) attributes.get("requestDate");

        if (requestDate != null) {
            setRequestDate(requestDate);
        }

        Date confirmDate = (Date) attributes.get("confirmDate");

        if (confirmDate != null) {
            setConfirmDate(confirmDate);
        }

        String message = (String) attributes.get("message");

        if (message != null) {
            setMessage(message);
        }

        Long status = (Long) attributes.get("status");

        if (status != null) {
            setStatus(status);
        }

        String answer = (String) attributes.get("answer");

        if (answer != null) {
            setAnswer(answer);
        }
    }

    /**
    * Returns the primary key of this req make site.
    *
    * @return the primary key of this req make site
    */
    @Override
    public long getPrimaryKey() {
        return _reqMakeSite.getPrimaryKey();
    }

    /**
    * Sets the primary key of this req make site.
    *
    * @param primaryKey the primary key of this req make site
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _reqMakeSite.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the request ID of this req make site.
    *
    * @return the request ID of this req make site
    */
    @Override
    public long getRequestId() {
        return _reqMakeSite.getRequestId();
    }

    /**
    * Sets the request ID of this req make site.
    *
    * @param requestId the request ID of this req make site
    */
    @Override
    public void setRequestId(long requestId) {
        _reqMakeSite.setRequestId(requestId);
    }

    /**
    * Returns the name of this req make site.
    *
    * @return the name of this req make site
    */
    @Override
    public java.lang.String getName() {
        return _reqMakeSite.getName();
    }

    /**
    * Sets the name of this req make site.
    *
    * @param name the name of this req make site
    */
    @Override
    public void setName(java.lang.String name) {
        _reqMakeSite.setName(name);
    }

    /**
    * Returns the description of this req make site.
    *
    * @return the description of this req make site
    */
    @Override
    public java.lang.String getDescription() {
        return _reqMakeSite.getDescription();
    }

    /**
    * Sets the description of this req make site.
    *
    * @param description the description of this req make site
    */
    @Override
    public void setDescription(java.lang.String description) {
        _reqMakeSite.setDescription(description);
    }

    /**
    * Returns the site type of this req make site.
    *
    * @return the site type of this req make site
    */
    @Override
    public long getSiteType() {
        return _reqMakeSite.getSiteType();
    }

    /**
    * Sets the site type of this req make site.
    *
    * @param siteType the site type of this req make site
    */
    @Override
    public void setSiteType(long siteType) {
        _reqMakeSite.setSiteType(siteType);
    }

    /**
    * Returns the user ID of this req make site.
    *
    * @return the user ID of this req make site
    */
    @Override
    public long getUserId() {
        return _reqMakeSite.getUserId();
    }

    /**
    * Sets the user ID of this req make site.
    *
    * @param userId the user ID of this req make site
    */
    @Override
    public void setUserId(long userId) {
        _reqMakeSite.setUserId(userId);
    }

    /**
    * Returns the user uuid of this req make site.
    *
    * @return the user uuid of this req make site
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _reqMakeSite.getUserUuid();
    }

    /**
    * Sets the user uuid of this req make site.
    *
    * @param userUuid the user uuid of this req make site
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _reqMakeSite.setUserUuid(userUuid);
    }

    /**
    * Returns the request date of this req make site.
    *
    * @return the request date of this req make site
    */
    @Override
    public java.util.Date getRequestDate() {
        return _reqMakeSite.getRequestDate();
    }

    /**
    * Sets the request date of this req make site.
    *
    * @param requestDate the request date of this req make site
    */
    @Override
    public void setRequestDate(java.util.Date requestDate) {
        _reqMakeSite.setRequestDate(requestDate);
    }

    /**
    * Returns the confirm date of this req make site.
    *
    * @return the confirm date of this req make site
    */
    @Override
    public java.util.Date getConfirmDate() {
        return _reqMakeSite.getConfirmDate();
    }

    /**
    * Sets the confirm date of this req make site.
    *
    * @param confirmDate the confirm date of this req make site
    */
    @Override
    public void setConfirmDate(java.util.Date confirmDate) {
        _reqMakeSite.setConfirmDate(confirmDate);
    }

    /**
    * Returns the message of this req make site.
    *
    * @return the message of this req make site
    */
    @Override
    public java.lang.String getMessage() {
        return _reqMakeSite.getMessage();
    }

    /**
    * Sets the message of this req make site.
    *
    * @param message the message of this req make site
    */
    @Override
    public void setMessage(java.lang.String message) {
        _reqMakeSite.setMessage(message);
    }

    /**
    * Returns the status of this req make site.
    *
    * @return the status of this req make site
    */
    @Override
    public long getStatus() {
        return _reqMakeSite.getStatus();
    }

    /**
    * Sets the status of this req make site.
    *
    * @param status the status of this req make site
    */
    @Override
    public void setStatus(long status) {
        _reqMakeSite.setStatus(status);
    }

    /**
    * Returns the answer of this req make site.
    *
    * @return the answer of this req make site
    */
    @Override
    public java.lang.String getAnswer() {
        return _reqMakeSite.getAnswer();
    }

    /**
    * Sets the answer of this req make site.
    *
    * @param answer the answer of this req make site
    */
    @Override
    public void setAnswer(java.lang.String answer) {
        _reqMakeSite.setAnswer(answer);
    }

    @Override
    public boolean isNew() {
        return _reqMakeSite.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _reqMakeSite.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _reqMakeSite.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _reqMakeSite.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _reqMakeSite.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _reqMakeSite.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _reqMakeSite.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _reqMakeSite.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _reqMakeSite.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _reqMakeSite.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _reqMakeSite.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new ReqMakeSiteWrapper((ReqMakeSite) _reqMakeSite.clone());
    }

    @Override
    public int compareTo(com.sdr.metadata.model.ReqMakeSite reqMakeSite) {
        return _reqMakeSite.compareTo(reqMakeSite);
    }

    @Override
    public int hashCode() {
        return _reqMakeSite.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.sdr.metadata.model.ReqMakeSite> toCacheModel() {
        return _reqMakeSite.toCacheModel();
    }

    @Override
    public com.sdr.metadata.model.ReqMakeSite toEscapedModel() {
        return new ReqMakeSiteWrapper(_reqMakeSite.toEscapedModel());
    }

    @Override
    public com.sdr.metadata.model.ReqMakeSite toUnescapedModel() {
        return new ReqMakeSiteWrapper(_reqMakeSite.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _reqMakeSite.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _reqMakeSite.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _reqMakeSite.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ReqMakeSiteWrapper)) {
            return false;
        }

        ReqMakeSiteWrapper reqMakeSiteWrapper = (ReqMakeSiteWrapper) obj;

        if (Validator.equals(_reqMakeSite, reqMakeSiteWrapper._reqMakeSite)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public ReqMakeSite getWrappedReqMakeSite() {
        return _reqMakeSite;
    }

    @Override
    public ReqMakeSite getWrappedModel() {
        return _reqMakeSite;
    }

    @Override
    public void resetOriginalValues() {
        _reqMakeSite.resetOriginalValues();
    }
}
