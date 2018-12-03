package com.sdr.metadata.model;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import com.sdr.metadata.service.persistence.Collection_UserPK;

import java.io.Serializable;

/**
 * The base model interface for the Collection_User service. Represents a row in the &quot;sdr_Collection_User&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sdr.metadata.model.impl.Collection_UserModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sdr.metadata.model.impl.Collection_UserImpl}.
 * </p>
 *
 * @author jaesung
 * @see Collection_User
 * @see com.sdr.metadata.model.impl.Collection_UserImpl
 * @see com.sdr.metadata.model.impl.Collection_UserModelImpl
 * @generated
 */
public interface Collection_UserModel extends BaseModel<Collection_User> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a collection_ user model instance should use the {@link Collection_User} interface instead.
     */

    /**
     * Returns the primary key of this collection_ user.
     *
     * @return the primary key of this collection_ user
     */
    public Collection_UserPK getPrimaryKey();

    /**
     * Sets the primary key of this collection_ user.
     *
     * @param primaryKey the primary key of this collection_ user
     */
    public void setPrimaryKey(Collection_UserPK primaryKey);

    /**
     * Returns the collection ID of this collection_ user.
     *
     * @return the collection ID of this collection_ user
     */
    public long getCollectionId();

    /**
     * Sets the collection ID of this collection_ user.
     *
     * @param collectionId the collection ID of this collection_ user
     */
    public void setCollectionId(long collectionId);

    /**
     * Returns the user ID of this collection_ user.
     *
     * @return the user ID of this collection_ user
     */
    public long getUserId();

    /**
     * Sets the user ID of this collection_ user.
     *
     * @param userId the user ID of this collection_ user
     */
    public void setUserId(long userId);

    /**
     * Returns the user uuid of this collection_ user.
     *
     * @return the user uuid of this collection_ user
     * @throws SystemException if a system exception occurred
     */
    public String getUserUuid() throws SystemException;

    /**
     * Sets the user uuid of this collection_ user.
     *
     * @param userUuid the user uuid of this collection_ user
     */
    public void setUserUuid(String userUuid);

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
    public int compareTo(com.sdr.metadata.model.Collection_User collection_User);

    @Override
    public int hashCode();

    @Override
    public CacheModel<com.sdr.metadata.model.Collection_User> toCacheModel();

    @Override
    public com.sdr.metadata.model.Collection_User toEscapedModel();

    @Override
    public com.sdr.metadata.model.Collection_User toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}
