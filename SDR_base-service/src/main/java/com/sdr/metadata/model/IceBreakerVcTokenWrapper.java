package com.sdr.metadata.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link IceBreakerVcToken}.
 * </p>
 *
 * @author jaesung
 * @see IceBreakerVcToken
 * @generated
 */
public class IceBreakerVcTokenWrapper implements IceBreakerVcToken,
    ModelWrapper<IceBreakerVcToken> {
    private IceBreakerVcToken _iceBreakerVcToken;

    public IceBreakerVcTokenWrapper(IceBreakerVcToken iceBreakerVcToken) {
        _iceBreakerVcToken = iceBreakerVcToken;
    }

    @Override
    public Class<?> getModelClass() {
        return IceBreakerVcToken.class;
    }

    @Override
    public String getModelClassName() {
        return IceBreakerVcToken.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("vcToken", getVcToken());
        attributes.put("vcTokenExpired", getVcTokenExpired());
        attributes.put("resultCode", getResultCode());
        attributes.put("tokenId", getTokenId());
        attributes.put("activate", getActivate());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String vcToken = (String) attributes.get("vcToken");

        if (vcToken != null) {
            setVcToken(vcToken);
        }

        Date vcTokenExpired = (Date) attributes.get("vcTokenExpired");

        if (vcTokenExpired != null) {
            setVcTokenExpired(vcTokenExpired);
        }

        Integer resultCode = (Integer) attributes.get("resultCode");

        if (resultCode != null) {
            setResultCode(resultCode);
        }

        Long tokenId = (Long) attributes.get("tokenId");

        if (tokenId != null) {
            setTokenId(tokenId);
        }

        Integer activate = (Integer) attributes.get("activate");

        if (activate != null) {
            setActivate(activate);
        }
    }

    /**
    * Returns the primary key of this ice breaker vc token.
    *
    * @return the primary key of this ice breaker vc token
    */
    @Override
    public long getPrimaryKey() {
        return _iceBreakerVcToken.getPrimaryKey();
    }

    /**
    * Sets the primary key of this ice breaker vc token.
    *
    * @param primaryKey the primary key of this ice breaker vc token
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _iceBreakerVcToken.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the vc token of this ice breaker vc token.
    *
    * @return the vc token of this ice breaker vc token
    */
    @Override
    public java.lang.String getVcToken() {
        return _iceBreakerVcToken.getVcToken();
    }

    /**
    * Sets the vc token of this ice breaker vc token.
    *
    * @param vcToken the vc token of this ice breaker vc token
    */
    @Override
    public void setVcToken(java.lang.String vcToken) {
        _iceBreakerVcToken.setVcToken(vcToken);
    }

    /**
    * Returns the vc token expired of this ice breaker vc token.
    *
    * @return the vc token expired of this ice breaker vc token
    */
    @Override
    public java.util.Date getVcTokenExpired() {
        return _iceBreakerVcToken.getVcTokenExpired();
    }

    /**
    * Sets the vc token expired of this ice breaker vc token.
    *
    * @param vcTokenExpired the vc token expired of this ice breaker vc token
    */
    @Override
    public void setVcTokenExpired(java.util.Date vcTokenExpired) {
        _iceBreakerVcToken.setVcTokenExpired(vcTokenExpired);
    }

    /**
    * Returns the result code of this ice breaker vc token.
    *
    * @return the result code of this ice breaker vc token
    */
    @Override
    public int getResultCode() {
        return _iceBreakerVcToken.getResultCode();
    }

    /**
    * Sets the result code of this ice breaker vc token.
    *
    * @param resultCode the result code of this ice breaker vc token
    */
    @Override
    public void setResultCode(int resultCode) {
        _iceBreakerVcToken.setResultCode(resultCode);
    }

    /**
    * Returns the token ID of this ice breaker vc token.
    *
    * @return the token ID of this ice breaker vc token
    */
    @Override
    public long getTokenId() {
        return _iceBreakerVcToken.getTokenId();
    }

    /**
    * Sets the token ID of this ice breaker vc token.
    *
    * @param tokenId the token ID of this ice breaker vc token
    */
    @Override
    public void setTokenId(long tokenId) {
        _iceBreakerVcToken.setTokenId(tokenId);
    }

    /**
    * Returns the activate of this ice breaker vc token.
    *
    * @return the activate of this ice breaker vc token
    */
    @Override
    public int getActivate() {
        return _iceBreakerVcToken.getActivate();
    }

    /**
    * Sets the activate of this ice breaker vc token.
    *
    * @param activate the activate of this ice breaker vc token
    */
    @Override
    public void setActivate(int activate) {
        _iceBreakerVcToken.setActivate(activate);
    }

    @Override
    public boolean isNew() {
        return _iceBreakerVcToken.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _iceBreakerVcToken.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _iceBreakerVcToken.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _iceBreakerVcToken.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _iceBreakerVcToken.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _iceBreakerVcToken.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _iceBreakerVcToken.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _iceBreakerVcToken.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _iceBreakerVcToken.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _iceBreakerVcToken.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _iceBreakerVcToken.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new IceBreakerVcTokenWrapper((IceBreakerVcToken) _iceBreakerVcToken.clone());
    }

    @Override
    public int compareTo(
        com.sdr.metadata.model.IceBreakerVcToken iceBreakerVcToken) {
        return _iceBreakerVcToken.compareTo(iceBreakerVcToken);
    }

    @Override
    public int hashCode() {
        return _iceBreakerVcToken.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.sdr.metadata.model.IceBreakerVcToken> toCacheModel() {
        return _iceBreakerVcToken.toCacheModel();
    }

    @Override
    public com.sdr.metadata.model.IceBreakerVcToken toEscapedModel() {
        return new IceBreakerVcTokenWrapper(_iceBreakerVcToken.toEscapedModel());
    }

    @Override
    public com.sdr.metadata.model.IceBreakerVcToken toUnescapedModel() {
        return new IceBreakerVcTokenWrapper(_iceBreakerVcToken.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _iceBreakerVcToken.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _iceBreakerVcToken.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _iceBreakerVcToken.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof IceBreakerVcTokenWrapper)) {
            return false;
        }

        IceBreakerVcTokenWrapper iceBreakerVcTokenWrapper = (IceBreakerVcTokenWrapper) obj;

        if (Validator.equals(_iceBreakerVcToken,
                    iceBreakerVcTokenWrapper._iceBreakerVcToken)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public IceBreakerVcToken getWrappedIceBreakerVcToken() {
        return _iceBreakerVcToken;
    }

    @Override
    public IceBreakerVcToken getWrappedModel() {
        return _iceBreakerVcToken;
    }

    @Override
    public void resetOriginalValues() {
        _iceBreakerVcToken.resetOriginalValues();
    }
}
