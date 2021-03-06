package com.sdr.metadata.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the IceBreakerVcToken service. Represents a row in the &quot;sdr_IceBreakerVcToken&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sdr.metadata.model.impl.IceBreakerVcTokenModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sdr.metadata.model.impl.IceBreakerVcTokenImpl}.
 * </p>
 *
 * @author jaesung
 * @see IceBreakerVcToken
 * @see com.sdr.metadata.model.impl.IceBreakerVcTokenImpl
 * @see com.sdr.metadata.model.impl.IceBreakerVcTokenModelImpl
 * @generated
 */
public interface IceBreakerVcTokenModel extends BaseModel<IceBreakerVcToken> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a ice breaker vc token model instance should use the {@link IceBreakerVcToken} interface instead.
     */

    /**
     * Returns the primary key of this ice breaker vc token.
     *
     * @return the primary key of this ice breaker vc token
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this ice breaker vc token.
     *
     * @param primaryKey the primary key of this ice breaker vc token
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the vc token of this ice breaker vc token.
     *
     * @return the vc token of this ice breaker vc token
     */
    @AutoEscape
    public String getVcToken();

    /**
     * Sets the vc token of this ice breaker vc token.
     *
     * @param vcToken the vc token of this ice breaker vc token
     */
    public void setVcToken(String vcToken);

    /**
     * Returns the vc token expired of this ice breaker vc token.
     *
     * @return the vc token expired of this ice breaker vc token
     */
    public Date getVcTokenExpired();

    /**
     * Sets the vc token expired of this ice breaker vc token.
     *
     * @param vcTokenExpired the vc token expired of this ice breaker vc token
     */
    public void setVcTokenExpired(Date vcTokenExpired);

    /**
     * Returns the result code of this ice breaker vc token.
     *
     * @return the result code of this ice breaker vc token
     */
    public int getResultCode();

    /**
     * Sets the result code of this ice breaker vc token.
     *
     * @param resultCode the result code of this ice breaker vc token
     */
    public void setResultCode(int resultCode);

    /**
     * Returns the token ID of this ice breaker vc token.
     *
     * @return the token ID of this ice breaker vc token
     */
    public long getTokenId();

    /**
     * Sets the token ID of this ice breaker vc token.
     *
     * @param tokenId the token ID of this ice breaker vc token
     */
    public void setTokenId(long tokenId);

    /**
     * Returns the activate of this ice breaker vc token.
     *
     * @return the activate of this ice breaker vc token
     */
    public int getActivate();

    /**
     * Sets the activate of this ice breaker vc token.
     *
     * @param activate the activate of this ice breaker vc token
     */
    public void setActivate(int activate);

    @Override
    public boolean isNew();

    @Override
    public void setNew(boolean n);

    @Override
    public boolean isCachedModel();

    @Override
    public void setCachedModel(boolean cachedModel);

    @Override
    public boolean isEscapedModel();

    @Override
    public Serializable getPrimaryKeyObj();

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    @Override
    public ExpandoBridge getExpandoBridge();

    @Override
    public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

    @Override
    public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    @Override
    public Object clone();

    @Override
    public int compareTo(
        com.sdr.metadata.model.IceBreakerVcToken iceBreakerVcToken);

    @Override
    public int hashCode();

    @Override
    public CacheModel<com.sdr.metadata.model.IceBreakerVcToken> toCacheModel();

    @Override
    public com.sdr.metadata.model.IceBreakerVcToken toEscapedModel();

    @Override
    public com.sdr.metadata.model.IceBreakerVcToken toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}
