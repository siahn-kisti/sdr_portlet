package com.sdr.guide.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sdr.guide.service.ClpSerializer;
import com.sdr.guide.service.GuideLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class GuideClp extends BaseModelImpl<Guide> implements Guide {
    private String _uuid;
    private long _datasetId;
    private String _title;
    private String _dataType;
    private String _contributors;
    private String _collectionName;
    private String _keyword;
    private String _description;
    private Long _dataFileId;
    private String _dataFileName;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userUuid;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private Date _deleteDate;
    private BaseModel<?> _guideRemoteModel;
    private Class<?> _clpSerializerClass = com.sdr.guide.service.ClpSerializer.class;

    public GuideClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return Guide.class;
    }

    @Override
    public String getModelClassName() {
        return Guide.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _datasetId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setDatasetId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _datasetId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("uuid", getUuid());
        attributes.put("datasetId", getDatasetId());
        attributes.put("title", getTitle());
        attributes.put("dataType", getDataType());
        attributes.put("contributors", getContributors());
        attributes.put("collectionName", getCollectionName());
        attributes.put("keyword", getKeyword());
        attributes.put("description", getDescription());
        attributes.put("dataFileId", getDataFileId());
        attributes.put("dataFileName", getDataFileName());
        attributes.put("groupId", getGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("deleteDate", getDeleteDate());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String uuid = (String) attributes.get("uuid");

        if (uuid != null) {
            setUuid(uuid);
        }

        Long datasetId = (Long) attributes.get("datasetId");

        if (datasetId != null) {
            setDatasetId(datasetId);
        }

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        String dataType = (String) attributes.get("dataType");

        if (dataType != null) {
            setDataType(dataType);
        }

        String contributors = (String) attributes.get("contributors");

        if (contributors != null) {
            setContributors(contributors);
        }

        String collectionName = (String) attributes.get("collectionName");

        if (collectionName != null) {
            setCollectionName(collectionName);
        }

        String keyword = (String) attributes.get("keyword");

        if (keyword != null) {
            setKeyword(keyword);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        Long dataFileId = (Long) attributes.get("dataFileId");

        if (dataFileId != null) {
            setDataFileId(dataFileId);
        }

        String dataFileName = (String) attributes.get("dataFileName");

        if (dataFileName != null) {
            setDataFileName(dataFileName);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        String userName = (String) attributes.get("userName");

        if (userName != null) {
            setUserName(userName);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Date modifiedDate = (Date) attributes.get("modifiedDate");

        if (modifiedDate != null) {
            setModifiedDate(modifiedDate);
        }

        Date deleteDate = (Date) attributes.get("deleteDate");

        if (deleteDate != null) {
            setDeleteDate(deleteDate);
        }
    }

    @Override
    public String getUuid() {
        return _uuid;
    }

    @Override
    public void setUuid(String uuid) {
        _uuid = uuid;

        if (_guideRemoteModel != null) {
            try {
                Class<?> clazz = _guideRemoteModel.getClass();

                Method method = clazz.getMethod("setUuid", String.class);

                method.invoke(_guideRemoteModel, uuid);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getDatasetId() {
        return _datasetId;
    }

    @Override
    public void setDatasetId(long datasetId) {
        _datasetId = datasetId;

        if (_guideRemoteModel != null) {
            try {
                Class<?> clazz = _guideRemoteModel.getClass();

                Method method = clazz.getMethod("setDatasetId", long.class);

                method.invoke(_guideRemoteModel, datasetId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getTitle() {
        return _title;
    }

    @Override
    public void setTitle(String title) {
        _title = title;

        if (_guideRemoteModel != null) {
            try {
                Class<?> clazz = _guideRemoteModel.getClass();

                Method method = clazz.getMethod("setTitle", String.class);

                method.invoke(_guideRemoteModel, title);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDataType() {
        return _dataType;
    }

    @Override
    public void setDataType(String dataType) {
        _dataType = dataType;

        if (_guideRemoteModel != null) {
            try {
                Class<?> clazz = _guideRemoteModel.getClass();

                Method method = clazz.getMethod("setDataType", String.class);

                method.invoke(_guideRemoteModel, dataType);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getContributors() {
        return _contributors;
    }

    @Override
    public void setContributors(String contributors) {
        _contributors = contributors;

        if (_guideRemoteModel != null) {
            try {
                Class<?> clazz = _guideRemoteModel.getClass();

                Method method = clazz.getMethod("setContributors", String.class);

                method.invoke(_guideRemoteModel, contributors);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getCollectionName() {
        return _collectionName;
    }

    @Override
    public void setCollectionName(String collectionName) {
        _collectionName = collectionName;

        if (_guideRemoteModel != null) {
            try {
                Class<?> clazz = _guideRemoteModel.getClass();

                Method method = clazz.getMethod("setCollectionName",
                        String.class);

                method.invoke(_guideRemoteModel, collectionName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getKeyword() {
        return _keyword;
    }

    @Override
    public void setKeyword(String keyword) {
        _keyword = keyword;

        if (_guideRemoteModel != null) {
            try {
                Class<?> clazz = _guideRemoteModel.getClass();

                Method method = clazz.getMethod("setKeyword", String.class);

                method.invoke(_guideRemoteModel, keyword);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDescription() {
        return _description;
    }

    @Override
    public void setDescription(String description) {
        _description = description;

        if (_guideRemoteModel != null) {
            try {
                Class<?> clazz = _guideRemoteModel.getClass();

                Method method = clazz.getMethod("setDescription", String.class);

                method.invoke(_guideRemoteModel, description);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Long getDataFileId() {
        return _dataFileId;
    }

    @Override
    public void setDataFileId(Long dataFileId) {
        _dataFileId = dataFileId;

        if (_guideRemoteModel != null) {
            try {
                Class<?> clazz = _guideRemoteModel.getClass();

                Method method = clazz.getMethod("setDataFileId", Long.class);

                method.invoke(_guideRemoteModel, dataFileId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDataFileName() {
        return _dataFileName;
    }

    @Override
    public void setDataFileName(String dataFileName) {
        _dataFileName = dataFileName;

        if (_guideRemoteModel != null) {
            try {
                Class<?> clazz = _guideRemoteModel.getClass();

                Method method = clazz.getMethod("setDataFileName", String.class);

                method.invoke(_guideRemoteModel, dataFileName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getGroupId() {
        return _groupId;
    }

    @Override
    public void setGroupId(long groupId) {
        _groupId = groupId;

        if (_guideRemoteModel != null) {
            try {
                Class<?> clazz = _guideRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_guideRemoteModel, groupId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getCompanyId() {
        return _companyId;
    }

    @Override
    public void setCompanyId(long companyId) {
        _companyId = companyId;

        if (_guideRemoteModel != null) {
            try {
                Class<?> clazz = _guideRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_guideRemoteModel, companyId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(long userId) {
        _userId = userId;

        if (_guideRemoteModel != null) {
            try {
                Class<?> clazz = _guideRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_guideRemoteModel, userId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    @Override
    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    @Override
    public String getUserName() {
        return _userName;
    }

    @Override
    public void setUserName(String userName) {
        _userName = userName;

        if (_guideRemoteModel != null) {
            try {
                Class<?> clazz = _guideRemoteModel.getClass();

                Method method = clazz.getMethod("setUserName", String.class);

                method.invoke(_guideRemoteModel, userName);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getCreateDate() {
        return _createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        _createDate = createDate;

        if (_guideRemoteModel != null) {
            try {
                Class<?> clazz = _guideRemoteModel.getClass();

                Method method = clazz.getMethod("setCreateDate", Date.class);

                method.invoke(_guideRemoteModel, createDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getModifiedDate() {
        return _modifiedDate;
    }

    @Override
    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;

        if (_guideRemoteModel != null) {
            try {
                Class<?> clazz = _guideRemoteModel.getClass();

                Method method = clazz.getMethod("setModifiedDate", Date.class);

                method.invoke(_guideRemoteModel, modifiedDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getDeleteDate() {
        return _deleteDate;
    }

    @Override
    public void setDeleteDate(Date deleteDate) {
        _deleteDate = deleteDate;

        if (_guideRemoteModel != null) {
            try {
                Class<?> clazz = _guideRemoteModel.getClass();

                Method method = clazz.getMethod("setDeleteDate", Date.class);

                method.invoke(_guideRemoteModel, deleteDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public StagedModelType getStagedModelType() {
        return new StagedModelType(PortalUtil.getClassNameId(
                Guide.class.getName()));
    }

    public BaseModel<?> getGuideRemoteModel() {
        return _guideRemoteModel;
    }

    public void setGuideRemoteModel(BaseModel<?> guideRemoteModel) {
        _guideRemoteModel = guideRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _guideRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_guideRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            GuideLocalServiceUtil.addGuide(this);
        } else {
            GuideLocalServiceUtil.updateGuide(this);
        }
    }

    @Override
    public Guide toEscapedModel() {
        return (Guide) ProxyUtil.newProxyInstance(Guide.class.getClassLoader(),
            new Class[] { Guide.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        GuideClp clone = new GuideClp();

        clone.setUuid(getUuid());
        clone.setDatasetId(getDatasetId());
        clone.setTitle(getTitle());
        clone.setDataType(getDataType());
        clone.setContributors(getContributors());
        clone.setCollectionName(getCollectionName());
        clone.setKeyword(getKeyword());
        clone.setDescription(getDescription());
        clone.setDataFileId(getDataFileId());
        clone.setDataFileName(getDataFileName());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());
        clone.setUserId(getUserId());
        clone.setUserName(getUserName());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setDeleteDate(getDeleteDate());

        return clone;
    }

    @Override
    public int compareTo(Guide guide) {
        long primaryKey = guide.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof GuideClp)) {
            return false;
        }

        GuideClp guide = (GuideClp) obj;

        long primaryKey = guide.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    public Class<?> getClpSerializerClass() {
        return _clpSerializerClass;
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(35);

        sb.append("{uuid=");
        sb.append(getUuid());
        sb.append(", datasetId=");
        sb.append(getDatasetId());
        sb.append(", title=");
        sb.append(getTitle());
        sb.append(", dataType=");
        sb.append(getDataType());
        sb.append(", contributors=");
        sb.append(getContributors());
        sb.append(", collectionName=");
        sb.append(getCollectionName());
        sb.append(", keyword=");
        sb.append(getKeyword());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", dataFileId=");
        sb.append(getDataFileId());
        sb.append(", dataFileName=");
        sb.append(getDataFileName());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", userName=");
        sb.append(getUserName());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", modifiedDate=");
        sb.append(getModifiedDate());
        sb.append(", deleteDate=");
        sb.append(getDeleteDate());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(55);

        sb.append("<model><model-name>");
        sb.append("com.sdr.guide.model.Guide");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>uuid</column-name><column-value><![CDATA[");
        sb.append(getUuid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>datasetId</column-name><column-value><![CDATA[");
        sb.append(getDatasetId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>title</column-name><column-value><![CDATA[");
        sb.append(getTitle());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>dataType</column-name><column-value><![CDATA[");
        sb.append(getDataType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>contributors</column-name><column-value><![CDATA[");
        sb.append(getContributors());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>collectionName</column-name><column-value><![CDATA[");
        sb.append(getCollectionName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>keyword</column-name><column-value><![CDATA[");
        sb.append(getKeyword());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>dataFileId</column-name><column-value><![CDATA[");
        sb.append(getDataFileId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>dataFileName</column-name><column-value><![CDATA[");
        sb.append(getDataFileName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>groupId</column-name><column-value><![CDATA[");
        sb.append(getGroupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyId</column-name><column-value><![CDATA[");
        sb.append(getCompanyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userName</column-name><column-value><![CDATA[");
        sb.append(getUserName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
        sb.append(getModifiedDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>deleteDate</column-name><column-value><![CDATA[");
        sb.append(getDeleteDate());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
