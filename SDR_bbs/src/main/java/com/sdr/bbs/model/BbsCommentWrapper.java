package com.sdr.bbs.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link BbsComment}.
 * </p>
 *
 * @author goopsw
 * @see BbsComment
 * @generated
 */
public class BbsCommentWrapper implements BbsComment, ModelWrapper<BbsComment> {
    private BbsComment _bbsComment;

    public BbsCommentWrapper(BbsComment bbsComment) {
        _bbsComment = bbsComment;
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

    /**
    * Returns the primary key of this bbs comment.
    *
    * @return the primary key of this bbs comment
    */
    @Override
    public long getPrimaryKey() {
        return _bbsComment.getPrimaryKey();
    }

    /**
    * Sets the primary key of this bbs comment.
    *
    * @param primaryKey the primary key of this bbs comment
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _bbsComment.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the uuid of this bbs comment.
    *
    * @return the uuid of this bbs comment
    */
    @Override
    public java.lang.String getUuid() {
        return _bbsComment.getUuid();
    }

    /**
    * Sets the uuid of this bbs comment.
    *
    * @param uuid the uuid of this bbs comment
    */
    @Override
    public void setUuid(java.lang.String uuid) {
        _bbsComment.setUuid(uuid);
    }

    /**
    * Returns the comment ID of this bbs comment.
    *
    * @return the comment ID of this bbs comment
    */
    @Override
    public long getCommentId() {
        return _bbsComment.getCommentId();
    }

    /**
    * Sets the comment ID of this bbs comment.
    *
    * @param commentId the comment ID of this bbs comment
    */
    @Override
    public void setCommentId(long commentId) {
        _bbsComment.setCommentId(commentId);
    }

    /**
    * Returns the post ID of this bbs comment.
    *
    * @return the post ID of this bbs comment
    */
    @Override
    public long getPostId() {
        return _bbsComment.getPostId();
    }

    /**
    * Sets the post ID of this bbs comment.
    *
    * @param postId the post ID of this bbs comment
    */
    @Override
    public void setPostId(long postId) {
        _bbsComment.setPostId(postId);
    }

    /**
    * Returns the user ID of this bbs comment.
    *
    * @return the user ID of this bbs comment
    */
    @Override
    public long getUserId() {
        return _bbsComment.getUserId();
    }

    /**
    * Sets the user ID of this bbs comment.
    *
    * @param userId the user ID of this bbs comment
    */
    @Override
    public void setUserId(long userId) {
        _bbsComment.setUserId(userId);
    }

    /**
    * Returns the user uuid of this bbs comment.
    *
    * @return the user uuid of this bbs comment
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _bbsComment.getUserUuid();
    }

    /**
    * Sets the user uuid of this bbs comment.
    *
    * @param userUuid the user uuid of this bbs comment
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _bbsComment.setUserUuid(userUuid);
    }

    /**
    * Returns the create date of this bbs comment.
    *
    * @return the create date of this bbs comment
    */
    @Override
    public java.util.Date getCreateDate() {
        return _bbsComment.getCreateDate();
    }

    /**
    * Sets the create date of this bbs comment.
    *
    * @param createDate the create date of this bbs comment
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _bbsComment.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this bbs comment.
    *
    * @return the modified date of this bbs comment
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _bbsComment.getModifiedDate();
    }

    /**
    * Sets the modified date of this bbs comment.
    *
    * @param modifiedDate the modified date of this bbs comment
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _bbsComment.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the writer of this bbs comment.
    *
    * @return the writer of this bbs comment
    */
    @Override
    public java.lang.String getWriter() {
        return _bbsComment.getWriter();
    }

    /**
    * Sets the writer of this bbs comment.
    *
    * @param writer the writer of this bbs comment
    */
    @Override
    public void setWriter(java.lang.String writer) {
        _bbsComment.setWriter(writer);
    }

    /**
    * Returns the email of this bbs comment.
    *
    * @return the email of this bbs comment
    */
    @Override
    public java.lang.String getEmail() {
        return _bbsComment.getEmail();
    }

    /**
    * Sets the email of this bbs comment.
    *
    * @param email the email of this bbs comment
    */
    @Override
    public void setEmail(java.lang.String email) {
        _bbsComment.setEmail(email);
    }

    /**
    * Returns the password of this bbs comment.
    *
    * @return the password of this bbs comment
    */
    @Override
    public java.lang.String getPassword() {
        return _bbsComment.getPassword();
    }

    /**
    * Sets the password of this bbs comment.
    *
    * @param password the password of this bbs comment
    */
    @Override
    public void setPassword(java.lang.String password) {
        _bbsComment.setPassword(password);
    }

    /**
    * Returns the content of this bbs comment.
    *
    * @return the content of this bbs comment
    */
    @Override
    public java.lang.String getContent() {
        return _bbsComment.getContent();
    }

    /**
    * Sets the content of this bbs comment.
    *
    * @param content the content of this bbs comment
    */
    @Override
    public void setContent(java.lang.String content) {
        _bbsComment.setContent(content);
    }

    /**
    * Returns the secret of this bbs comment.
    *
    * @return the secret of this bbs comment
    */
    @Override
    public boolean getSecret() {
        return _bbsComment.getSecret();
    }

    /**
    * Returns <code>true</code> if this bbs comment is secret.
    *
    * @return <code>true</code> if this bbs comment is secret; <code>false</code> otherwise
    */
    @Override
    public boolean isSecret() {
        return _bbsComment.isSecret();
    }

    /**
    * Sets whether this bbs comment is secret.
    *
    * @param secret the secret of this bbs comment
    */
    @Override
    public void setSecret(boolean secret) {
        _bbsComment.setSecret(secret);
    }

    @Override
    public boolean isNew() {
        return _bbsComment.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _bbsComment.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _bbsComment.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _bbsComment.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _bbsComment.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _bbsComment.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _bbsComment.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _bbsComment.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _bbsComment.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _bbsComment.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _bbsComment.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new BbsCommentWrapper((BbsComment) _bbsComment.clone());
    }

    @Override
    public int compareTo(com.sdr.bbs.model.BbsComment bbsComment) {
        return _bbsComment.compareTo(bbsComment);
    }

    @Override
    public int hashCode() {
        return _bbsComment.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.sdr.bbs.model.BbsComment> toCacheModel() {
        return _bbsComment.toCacheModel();
    }

    @Override
    public com.sdr.bbs.model.BbsComment toEscapedModel() {
        return new BbsCommentWrapper(_bbsComment.toEscapedModel());
    }

    @Override
    public com.sdr.bbs.model.BbsComment toUnescapedModel() {
        return new BbsCommentWrapper(_bbsComment.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _bbsComment.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _bbsComment.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _bbsComment.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof BbsCommentWrapper)) {
            return false;
        }

        BbsCommentWrapper bbsCommentWrapper = (BbsCommentWrapper) obj;

        if (Validator.equals(_bbsComment, bbsCommentWrapper._bbsComment)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public BbsComment getWrappedBbsComment() {
        return _bbsComment;
    }

    @Override
    public BbsComment getWrappedModel() {
        return _bbsComment;
    }

    @Override
    public void resetOriginalValues() {
        _bbsComment.resetOriginalValues();
    }
}
