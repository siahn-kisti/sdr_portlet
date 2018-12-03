package com.sdr.bbs.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sdr.bbs.service.BbsPostLocalServiceUtil;
import com.sdr.bbs.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class BbsPostClp extends BaseModelImpl<BbsPost> implements BbsPost {
    private String _uuid;
    private long _postId;
    private long _bbsId;
    private long _userId;
    private String _userUuid;
    private Date _createDate;
    private Date _modifiedDate;
    private String _writer;
    private String _email;
    private String _password;
    private String _title;
    private String _content;
    private boolean _secret;
    private boolean _commentEmailed;
    private int _viewCount;
    private BaseModel<?> _bbsPostRemoteModel;
    private Class<?> _clpSerializerClass = com.sdr.bbs.service.ClpSerializer.class;

    public BbsPostClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return BbsPost.class;
    }

    @Override
    public String getModelClassName() {
        return BbsPost.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _postId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setPostId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _postId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("uuid", getUuid());
        attributes.put("postId", getPostId());
        attributes.put("bbsId", getBbsId());
        attributes.put("userId", getUserId());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("writer", getWriter());
        attributes.put("email", getEmail());
        attributes.put("password", getPassword());
        attributes.put("title", getTitle());
        attributes.put("content", getContent());
        attributes.put("secret", getSecret());
        attributes.put("commentEmailed", getCommentEmailed());
        attributes.put("viewCount", getViewCount());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String uuid = (String) attributes.get("uuid");

        if (uuid != null) {
            setUuid(uuid);
        }

        Long postId = (Long) attributes.get("postId");

        if (postId != null) {
            setPostId(postId);
        }

        Long bbsId = (Long) attributes.get("bbsId");

        if (bbsId != null) {
            setBbsId(bbsId);
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

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        String content = (String) attributes.get("content");

        if (content != null) {
            setContent(content);
        }

        Boolean secret = (Boolean) attributes.get("secret");

        if (secret != null) {
            setSecret(secret);
        }

        Boolean commentEmailed = (Boolean) attributes.get("commentEmailed");

        if (commentEmailed != null) {
            setCommentEmailed(commentEmailed);
        }

        Integer viewCount = (Integer) attributes.get("viewCount");

        if (viewCount != null) {
            setViewCount(viewCount);
        }
    }

    @Override
    public String getUuid() {
        return _uuid;
    }

    @Override
    public void setUuid(String uuid) {
        _uuid = uuid;

        if (_bbsPostRemoteModel != null) {
            try {
                Class<?> clazz = _bbsPostRemoteModel.getClass();

                Method method = clazz.getMethod("setUuid", String.class);

                method.invoke(_bbsPostRemoteModel, uuid);
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

        if (_bbsPostRemoteModel != null) {
            try {
                Class<?> clazz = _bbsPostRemoteModel.getClass();

                Method method = clazz.getMethod("setPostId", long.class);

                method.invoke(_bbsPostRemoteModel, postId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getBbsId() {
        return _bbsId;
    }

    @Override
    public void setBbsId(long bbsId) {
        _bbsId = bbsId;

        if (_bbsPostRemoteModel != null) {
            try {
                Class<?> clazz = _bbsPostRemoteModel.getClass();

                Method method = clazz.getMethod("setBbsId", long.class);

                method.invoke(_bbsPostRemoteModel, bbsId);
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

        if (_bbsPostRemoteModel != null) {
            try {
                Class<?> clazz = _bbsPostRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_bbsPostRemoteModel, userId);
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

        if (_bbsPostRemoteModel != null) {
            try {
                Class<?> clazz = _bbsPostRemoteModel.getClass();

                Method method = clazz.getMethod("setCreateDate", Date.class);

                method.invoke(_bbsPostRemoteModel, createDate);
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

        if (_bbsPostRemoteModel != null) {
            try {
                Class<?> clazz = _bbsPostRemoteModel.getClass();

                Method method = clazz.getMethod("setModifiedDate", Date.class);

                method.invoke(_bbsPostRemoteModel, modifiedDate);
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

        if (_bbsPostRemoteModel != null) {
            try {
                Class<?> clazz = _bbsPostRemoteModel.getClass();

                Method method = clazz.getMethod("setWriter", String.class);

                method.invoke(_bbsPostRemoteModel, writer);
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

        if (_bbsPostRemoteModel != null) {
            try {
                Class<?> clazz = _bbsPostRemoteModel.getClass();

                Method method = clazz.getMethod("setEmail", String.class);

                method.invoke(_bbsPostRemoteModel, email);
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

        if (_bbsPostRemoteModel != null) {
            try {
                Class<?> clazz = _bbsPostRemoteModel.getClass();

                Method method = clazz.getMethod("setPassword", String.class);

                method.invoke(_bbsPostRemoteModel, password);
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

        if (_bbsPostRemoteModel != null) {
            try {
                Class<?> clazz = _bbsPostRemoteModel.getClass();

                Method method = clazz.getMethod("setTitle", String.class);

                method.invoke(_bbsPostRemoteModel, title);
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

        if (_bbsPostRemoteModel != null) {
            try {
                Class<?> clazz = _bbsPostRemoteModel.getClass();

                Method method = clazz.getMethod("setContent", String.class);

                method.invoke(_bbsPostRemoteModel, content);
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

        if (_bbsPostRemoteModel != null) {
            try {
                Class<?> clazz = _bbsPostRemoteModel.getClass();

                Method method = clazz.getMethod("setSecret", boolean.class);

                method.invoke(_bbsPostRemoteModel, secret);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public boolean getCommentEmailed() {
        return _commentEmailed;
    }

    @Override
    public boolean isCommentEmailed() {
        return _commentEmailed;
    }

    @Override
    public void setCommentEmailed(boolean commentEmailed) {
        _commentEmailed = commentEmailed;

        if (_bbsPostRemoteModel != null) {
            try {
                Class<?> clazz = _bbsPostRemoteModel.getClass();

                Method method = clazz.getMethod("setCommentEmailed",
                        boolean.class);

                method.invoke(_bbsPostRemoteModel, commentEmailed);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public int getViewCount() {
        return _viewCount;
    }

    @Override
    public void setViewCount(int viewCount) {
        _viewCount = viewCount;

        if (_bbsPostRemoteModel != null) {
            try {
                Class<?> clazz = _bbsPostRemoteModel.getClass();

                Method method = clazz.getMethod("setViewCount", int.class);

                method.invoke(_bbsPostRemoteModel, viewCount);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public java.util.List<com.sdr.bbs.model.BbsComment> getBbsComments() {
        try {
            String methodName = "getBbsComments";

            Class<?>[] parameterTypes = new Class<?>[] {  };

            Object[] parameterValues = new Object[] {  };

            java.util.List<com.sdr.bbs.model.BbsComment> returnObj = (java.util.List<com.sdr.bbs.model.BbsComment>) invokeOnRemoteModel(methodName,
                    parameterTypes, parameterValues);

            return returnObj;
        } catch (Exception e) {
            throw new UnsupportedOperationException(e);
        }
    }

    @Override
    public java.lang.String getUserName() {
        try {
            String methodName = "getUserName";

            Class<?>[] parameterTypes = new Class<?>[] {  };

            Object[] parameterValues = new Object[] {  };

            java.lang.String returnObj = (java.lang.String) invokeOnRemoteModel(methodName,
                    parameterTypes, parameterValues);

            return returnObj;
        } catch (Exception e) {
            throw new UnsupportedOperationException(e);
        }
    }

    @Override
    public int getBbsCommentsCount() {
        try {
            String methodName = "getBbsCommentsCount";

            Class<?>[] parameterTypes = new Class<?>[] {  };

            Object[] parameterValues = new Object[] {  };

            Integer returnObj = (Integer) invokeOnRemoteModel(methodName,
                    parameterTypes, parameterValues);

            return returnObj;
        } catch (Exception e) {
            throw new UnsupportedOperationException(e);
        }
    }

    public BaseModel<?> getBbsPostRemoteModel() {
        return _bbsPostRemoteModel;
    }

    public void setBbsPostRemoteModel(BaseModel<?> bbsPostRemoteModel) {
        _bbsPostRemoteModel = bbsPostRemoteModel;
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

        Class<?> remoteModelClass = _bbsPostRemoteModel.getClass();

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

        Object returnValue = method.invoke(_bbsPostRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            BbsPostLocalServiceUtil.addBbsPost(this);
        } else {
            BbsPostLocalServiceUtil.updateBbsPost(this);
        }
    }

    @Override
    public BbsPost toEscapedModel() {
        return (BbsPost) ProxyUtil.newProxyInstance(BbsPost.class.getClassLoader(),
            new Class[] { BbsPost.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        BbsPostClp clone = new BbsPostClp();

        clone.setUuid(getUuid());
        clone.setPostId(getPostId());
        clone.setBbsId(getBbsId());
        clone.setUserId(getUserId());
        clone.setCreateDate(getCreateDate());
        clone.setModifiedDate(getModifiedDate());
        clone.setWriter(getWriter());
        clone.setEmail(getEmail());
        clone.setPassword(getPassword());
        clone.setTitle(getTitle());
        clone.setContent(getContent());
        clone.setSecret(getSecret());
        clone.setCommentEmailed(getCommentEmailed());
        clone.setViewCount(getViewCount());

        return clone;
    }

    @Override
    public int compareTo(BbsPost bbsPost) {
        int value = 0;

        if (getPostId() < bbsPost.getPostId()) {
            value = -1;
        } else if (getPostId() > bbsPost.getPostId()) {
            value = 1;
        } else {
            value = 0;
        }

        value = value * -1;

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

        if (!(obj instanceof BbsPostClp)) {
            return false;
        }

        BbsPostClp bbsPost = (BbsPostClp) obj;

        long primaryKey = bbsPost.getPrimaryKey();

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
        StringBundler sb = new StringBundler(29);

        sb.append("{uuid=");
        sb.append(getUuid());
        sb.append(", postId=");
        sb.append(getPostId());
        sb.append(", bbsId=");
        sb.append(getBbsId());
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
        sb.append(", title=");
        sb.append(getTitle());
        sb.append(", content=");
        sb.append(getContent());
        sb.append(", secret=");
        sb.append(getSecret());
        sb.append(", commentEmailed=");
        sb.append(getCommentEmailed());
        sb.append(", viewCount=");
        sb.append(getViewCount());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(46);

        sb.append("<model><model-name>");
        sb.append("com.sdr.bbs.model.BbsPost");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>uuid</column-name><column-value><![CDATA[");
        sb.append(getUuid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>postId</column-name><column-value><![CDATA[");
        sb.append(getPostId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>bbsId</column-name><column-value><![CDATA[");
        sb.append(getBbsId());
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
            "<column><column-name>title</column-name><column-value><![CDATA[");
        sb.append(getTitle());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>content</column-name><column-value><![CDATA[");
        sb.append(getContent());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>secret</column-name><column-value><![CDATA[");
        sb.append(getSecret());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>commentEmailed</column-name><column-value><![CDATA[");
        sb.append(getCommentEmailed());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>viewCount</column-name><column-value><![CDATA[");
        sb.append(getViewCount());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
