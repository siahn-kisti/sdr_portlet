package com.sdr.metadata.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the ApiKey service. Represents a row in the &quot;sdr_ApiKey&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sdr.metadata.model.impl.ApiKeyModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sdr.metadata.model.impl.ApiKeyImpl}.
 * </p>
 *
 * @author jaesung
 * @see ApiKey
 * @see com.sdr.metadata.model.impl.ApiKeyImpl
 * @see com.sdr.metadata.model.impl.ApiKeyModelImpl
 * @generated
 */
public interface ApiKeyModel extends BaseModel<ApiKey> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a api key model instance should use the {@link ApiKey} interface instead.
     */

    /**
     * Returns the primary key of this api key.
     *
     * @return the primary key of this api key
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this api key.
     *
     * @param primaryKey the primary key of this api key
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the user ID of this api key.
     *
     * @return the user ID of this api key
     */
    public long getUserId();

    /**
     * Sets the user ID of this api key.
     *
     * @param userId the user ID of this api key
     */
    public void setUserId(long userId);

    /**
     * Returns the user uuid of this api key.
     *
     * @return the user uuid of this api key
     * @throws SystemException if a system exception occurred
     */
    public String getUserUuid() throws SystemException;

    /**
     * Sets the user uuid of this api key.
     *
     * @param userUuid the user uuid of this api key
     */
    public void setUserUuid(String userUuid);

    /**
     * Returns the api key of this api key.
     *
     * @return the api key of this api key
     */
    @AutoEscape
    public String getApiKey();

    /**
     * Sets the api key of this api key.
     *
     * @param apiKey the api key of this api key
     */
    public void setApiKey(String apiKey);

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
    public int compareTo(com.sdr.metadata.model.ApiKey apiKey);

    @Override
    public int hashCode();

    @Override
    public CacheModel<com.sdr.metadata.model.ApiKey> toCacheModel();

    @Override
    public com.sdr.metadata.model.ApiKey toEscapedModel();

    @Override
    public com.sdr.metadata.model.ApiKey toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}
