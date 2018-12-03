package com.sdr.metadata.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the DataType service. Represents a row in the &quot;sdr_DataType&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sdr.metadata.model.impl.DataTypeModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sdr.metadata.model.impl.DataTypeImpl}.
 * </p>
 *
 * @author jaesung
 * @see DataType
 * @see com.sdr.metadata.model.impl.DataTypeImpl
 * @see com.sdr.metadata.model.impl.DataTypeModelImpl
 * @generated
 */
public interface DataTypeModel extends BaseModel<DataType> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a data type model instance should use the {@link DataType} interface instead.
     */

    /**
     * Returns the primary key of this data type.
     *
     * @return the primary key of this data type
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this data type.
     *
     * @param primaryKey the primary key of this data type
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the data type ID of this data type.
     *
     * @return the data type ID of this data type
     */
    public long getDataTypeId();

    /**
     * Sets the data type ID of this data type.
     *
     * @param dataTypeId the data type ID of this data type
     */
    public void setDataTypeId(long dataTypeId);

    /**
     * Returns the title of this data type.
     *
     * @return the title of this data type
     */
    @AutoEscape
    public String getTitle();

    /**
     * Sets the title of this data type.
     *
     * @param title the title of this data type
     */
    public void setTitle(String title);

    /**
     * Returns the description of this data type.
     *
     * @return the description of this data type
     */
    @AutoEscape
    public String getDescription();

    /**
     * Sets the description of this data type.
     *
     * @param description the description of this data type
     */
    public void setDescription(String description);

    /**
     * Returns the file validation rule of this data type.
     *
     * @return the file validation rule of this data type
     */
    @AutoEscape
    public String getFileValidationRule();

    /**
     * Sets the file validation rule of this data type.
     *
     * @param fileValidationRule the file validation rule of this data type
     */
    public void setFileValidationRule(String fileValidationRule);

    /**
     * Returns the user ID of this data type.
     *
     * @return the user ID of this data type
     */
    public long getUserId();

    /**
     * Sets the user ID of this data type.
     *
     * @param userId the user ID of this data type
     */
    public void setUserId(long userId);

    /**
     * Returns the user uuid of this data type.
     *
     * @return the user uuid of this data type
     * @throws SystemException if a system exception occurred
     */
    public String getUserUuid() throws SystemException;

    /**
     * Sets the user uuid of this data type.
     *
     * @param userUuid the user uuid of this data type
     */
    public void setUserUuid(String userUuid);

    /**
     * Returns the allowed user ID of this data type.
     *
     * @return the allowed user ID of this data type
     */
    public long getAllowedUserId();

    /**
     * Sets the allowed user ID of this data type.
     *
     * @param allowedUserId the allowed user ID of this data type
     */
    public void setAllowedUserId(long allowedUserId);

    /**
     * Returns the allowed user uuid of this data type.
     *
     * @return the allowed user uuid of this data type
     * @throws SystemException if a system exception occurred
     */
    public String getAllowedUserUuid() throws SystemException;

    /**
     * Sets the allowed user uuid of this data type.
     *
     * @param allowedUserUuid the allowed user uuid of this data type
     */
    public void setAllowedUserUuid(String allowedUserUuid);

    /**
     * Returns the group ID of this data type.
     *
     * @return the group ID of this data type
     */
    public long getGroupId();

    /**
     * Sets the group ID of this data type.
     *
     * @param groupId the group ID of this data type
     */
    public void setGroupId(long groupId);

    /**
     * Returns the company ID of this data type.
     *
     * @return the company ID of this data type
     */
    public long getCompanyId();

    /**
     * Sets the company ID of this data type.
     *
     * @param companyId the company ID of this data type
     */
    public void setCompanyId(long companyId);

    /**
     * Returns the curate required of this data type.
     *
     * @return the curate required of this data type
     */
    public boolean getCurateRequired();

    /**
     * Returns <code>true</code> if this data type is curate required.
     *
     * @return <code>true</code> if this data type is curate required; <code>false</code> otherwise
     */
    public boolean isCurateRequired();

    /**
     * Sets whether this data type is curate required.
     *
     * @param curateRequired the curate required of this data type
     */
    public void setCurateRequired(boolean curateRequired);

    /**
     * Returns the location of this data type.
     *
     * @return the location of this data type
     */
    @AutoEscape
    public String getLocation();

    /**
     * Sets the location of this data type.
     *
     * @param location the location of this data type
     */
    public void setLocation(String location);

    /**
     * Returns the docker image of this data type.
     *
     * @return the docker image of this data type
     */
    @AutoEscape
    public String getDockerImage();

    /**
     * Sets the docker image of this data type.
     *
     * @param dockerImage the docker image of this data type
     */
    public void setDockerImage(String dockerImage);

    /**
     * Returns the default pp logic ID of this data type.
     *
     * @return the default pp logic ID of this data type
     */
    public long getDefaultPpLogicId();

    /**
     * Sets the default pp logic ID of this data type.
     *
     * @param defaultPpLogicId the default pp logic ID of this data type
     */
    public void setDefaultPpLogicId(long defaultPpLogicId);

    /**
     * Returns the status of this data type.
     *
     * @return the status of this data type
     */
    public int getStatus();

    /**
     * Sets the status of this data type.
     *
     * @param status the status of this data type
     */
    public void setStatus(int status);

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
    public int compareTo(com.sdr.metadata.model.DataType dataType);

    @Override
    public int hashCode();

    @Override
    public CacheModel<com.sdr.metadata.model.DataType> toCacheModel();

    @Override
    public com.sdr.metadata.model.DataType toEscapedModel();

    @Override
    public com.sdr.metadata.model.DataType toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}