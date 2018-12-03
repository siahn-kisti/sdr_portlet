package com.sdr.bbs.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sdr.bbs.service.BbsCommentLocalServiceUtil;
import com.sdr.bbs.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class BbsCommentClp extends BaseModelImpl<BbsComment>
    implements BbsComment {
    private String _uuid;
    private long _commentId;
    private long _postId;
    private long _userId;
    private String _userUuid;
    private Date _createDate;
    private Date _modifiedDate;
    private String _writer;
    private String _email;
    private String _password;
    private String _content;
    private boolean _secret;
    private BaseModel<?> _bbsCommentRemoteModel;
    private Class<?> _clpSerializerClass = com.sdr.bbs.service.ClpSerializer.class;

    public BbsCommentClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return BbsComment.class;
    }

    @Override
    public String getModelClassName() {
        return BbsComment.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _commentId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setCommentId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _commentId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("uuid", getUuid());
        attributes.put("commentId", getCommentId());
        attributes.put("postId", getPostId());
        attributes.put("userId", getUserId());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("writer", getWriter());
        attributes.put("email", getEmail());
        attributes.put("password", getPassword());
        attributes.put("content", getContent());
        attributes.put("secret", getSecret());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String uuid = (String) attributes.get("uuid");

        if (uuid != null) {
            setUuid(uuid);
        }

        Long commentId = (Long) attributes.get("commentId");

        if (commentId != null) {
            setCommentId(commentId);
        }

        Long postId = (Long) attributes.get("postId");

        if (postId != null) {
            setPostId(postId);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Date modifiedDate = (Date) attributes.get("modifiedDate");

        if (modifiedDate != null) {
            setModifiedDate(modifiedDate);
        }

        String writer = (String) attributes.get("writer");

        if (writer != null) {
            setWriter(writer);
        }

        String email = (String) attributes.get("email");

        if (email != null) {
            setEmail(email);
        }

        String password = (String) attributes.get("password");

        if (password != null) {
            setPassword(password);
        }

        String content = (String) attributes.get("content");

        if (content != null) {
            setContent(content);
        }

        Boolean secret = (Boolean) attributes.get("secret");

        if (secret != null) {
            setSecret(secret);
        }
    }

    @Override
    public String getUuid() {
        return _uuid;
    }

    @Override
    public void setUuid(String uuid) {
        _uuid = uuid;

        if (_bbsCommentRemoteModel != null) {
            try {
                Class<?> clazz = _bbsCommentRemoteModel.getClass();

                Method method = clazz.getMethod("setUuid", String.class);

                method.invoke(_bbsCommentRemoteModel, uuid);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getCommentId() {
        return _commentId;
    }

    @Override
    public void setCommentId(long commentId) {
        _commentId = commentId;

        if (_bbsCommentRemoteModel != null) {
            try {
                Class<?> clazz = _bbsCommentRemoteModel.getClass();

                Method method = clazz.getMethod("setCommentId", long.class);

                method.invoke(_bbsCommentRemoteModel, commentId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getPostId() {
        return _postId;
    }

    @Override
    public void setPostId(long postId) {
        _postId = postId;

        if (_bbsCommentRemoteModel != null) {
            try {
                Class<?> clazz = _bbsCommentRemoteModel.getClass();

                Method method = clazz.getMethod("setPostId", long.class);

                method.invoke(_bbsCommentRemoteModel, postId);
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

        if (_bbsCommentRemoteModel != null) {
            try {
                Class<?> clazz = _bbsCommentRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_bbsCommentRemoteModel, userId);
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
    public Date getCreateDate() {
        return _createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        _createDate = createDate;

        if (_bbsCommentRemoteModel != null) {
            try {
                Class<?> clazz = _bbsCommentRemoteModel.getClass();

                Method method = clazz.getMethod("setCreateDate", Date.class);

                method.invoke(_bbsCommentRemoteModel, createDate);
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

        if (_bbsCommentRemoteModel != null) {
            try {
                Class<?> clazz = _bbsCommentRemoteModel.getClass();

                Method method = clazz.getMethod("setModifiedDate", Date.class);

                method.invoke(_bbsCommentRemoteModel, modifiedDate);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getWriter() {
        return _writer;
    }

    @Override
    public void setWriter(String writer) {
        _writer = writer;

        if (_bbsCommentRemoteModel != null) {
            try {
                Class<?> clazz = _bbsCommentRemoteModel.getClass();

                Method method = clazz.getMethod("setWriter", String.class);

                method.invoke(_bbsCommentRemoteModel, writer);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getEmail() {
        return _email;
    }

    @Override
    public void setEmail(String email) {
        _email = email;

        if (_bbsCommentRemoteModel != null) {
            try {
                Class<?> clazz = _bbsCommentRemoteModel.getClass();

                Method method = clazz.getMethod("setEmail", String.class);

                method.invoke(_bbsCommentRemoteModel, email);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getPassword() {
        return _password;
    }

    @Override
    public void setPassword(String password) {
        _password = password;

        if (_bbsCommentRemoteModel != null) {
            try {
                Class<?> clazz = _bbsCommentRemoteModel.getClass();

                Method method = clazz.getMethod("setPassword", String.class);

                method.invoke(_bbsCommentRemoteModel, password);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getContent() {
        return _content;
    }

    @Override
    public void setContent(String content) {
        _content = content;

        if (_bbsCommentRemoteModel != null) {
            try {
                Class<?> clazz = _bbsCommentRemoteModel.getClass();

                Method method = clazz.getMethod("setContent", String.class);

                method.invoke(_bbsCommentRemoteModel, content);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getSecret() {
        return _secret;
    }

    @Override
    public boolean isSecret() {
        return _secret;
    }

    @Override
    public void setSecret(boolean secret) {
        _secret = secret;

        if (_bbsCommentRemoteModel != null) {
            try {
                Class<?> clazz = _bbsCommentRemoteModel.getClass();

                Method method = clazz.getMethod("setSecret", boolean.class);

                method.invoke(_bbsCommentRemoteModel, secret);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getBbsCommentRemoteModel() {
        return _bbsCommentRemoteModel;
    }

    public void setBbsCommentRemoteModel(BaseModel<?> bbsCommentRemoteModel) {
        _bbsCommentRemoteModel = bbsCommentRemoteModel;
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

        Class<?> remoteModelClass = _bbsCommentRemoteModel.getClass();

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

        Object returnValue = method.invoke(_bbsCommentRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            BbsCommentLocalServiceUtil.addBbsComment(this);
        } else {
            BbsCommentLocalServiceUtil.updateBbsComment(this);
        }
    }

    @Override
    public BbsComment toEscapedModel() {
        return (BbsComment) ProxyUtil.newProxyInstance(BbsComment.class.getClassLoader(),
            new Class[] { BbsComment.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        BbsCommentClp clone = new BbsCommentClp();

        clone.setUuid(getUuid());
        clone.setCommentId(getCommentId());
        clone.setPostId(getPostId());
        clone.setUserId(getUserId());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setWriter(getWriter());
        clone.setEmail(getEmail());
        clone.setPassword(getPassword());
        clone.setContent(getContent());
        clone.setSecret(getSecret());

        return clone;
    }

    @Override
    public int compareTo(BbsComment bbsComment) {
        int value = 0;

        if (getCommentId() < bbsComment.getCommentId()) {
            value = -1;
        } else if (getCommentId() > bbsComment.getCommentId()) {
            value = 1;
        } else {
            value = 0;
        }

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof BbsCommentClp)) {
            return false;
        }

        BbsCommentClp bbsComment = (BbsCommentClp) obj;

        long primaryKey = bbsComment.getPrimaryKey();

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
        StringBundler sb = new StringBundler(23);

        sb.append("{uuid=");
        sb.append(getUuid());
        sb.append(", commentId=");
        sb.append(getCommentId());
        sb.append(", postId=");
        sb.append(getPostId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", modifiedDate=");
        sb.append(getModifiedDate());
        sb.append(", writer=");
        sb.append(getWriter());
        sb.append(", email=");
        sb.append(getEmail());
        sb.append(", password=");
        sb.append(getPassword());
        sb.append(", content=");
        sb.append(getContent());
        sb.append(", secret=");
        sb.append(getSecret());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(37);

        sb.append("<model><model-name>");
        sb.append("com.sdr.bbs.model.BbsComment");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>uuid</column-name><column-value><![CDATA[");
        sb.append(getUuid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>commentId</column-name><column-value><![CDATA[");
        sb.append(getCommentId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>postId</column-name><column-value><![CDATA[");
        sb.append(getPostId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
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
            "<column><column-name>writer</column-name><column-value><![CDATA[");
        sb.append(getWriter());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>email</column-name><column-value><![CDATA[");
        sb.append(getEmail());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>password</column-name><column-value><![CDATA[");
        sb.append(getPassword());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>content</column-name><column-value><![CDATA[");
        sb.append(getContent());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>secret</column-name><column-value><![CDATA[");
        sb.append(getSecret());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
