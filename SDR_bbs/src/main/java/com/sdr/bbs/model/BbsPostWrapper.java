package com.sdr.bbs.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link BbsPost}.
 * </p>
 *
 * @author goopsw
 * @see BbsPost
 * @generated
 */
public class BbsPostWrapper implements BbsPost, ModelWrapper<BbsPost> {
    private BbsPost _bbsPost;

    public BbsPostWrapper(BbsPost bbsPost) {
        _bbsPost = bbsPost;
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

    /**
    * Returns the primary key of this bbs post.
    *
    * @return the primary key of this bbs post
    */
    @Override
    public long getPrimaryKey() {
        return _bbsPost.getPrimaryKey();
    }

    /**
    * Sets the primary key of this bbs post.
    *
    * @param primaryKey the primary key of this bbs post
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _bbsPost.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the uuid of this bbs post.
    *
    * @return the uuid of this bbs post
    */
    @Override
    public java.lang.String getUuid() {
        return _bbsPost.getUuid();
    }

    /**
    * Sets the uuid of this bbs post.
    *
    * @param uuid the uuid of this bbs post
    */
    @Override
    public void setUuid(java.lang.String uuid) {
        _bbsPost.setUuid(uuid);
    }

    /**
    * Returns the post ID of this bbs post.
    *
    * @return the post ID of this bbs post
    */
    @Override
    public long getPostId() {
        return _bbsPost.getPostId();
    }

    /**
    * Sets the post ID of this bbs post.
    *
    * @param postId the post ID of this bbs post
    */
    @Override
    public void setPostId(long postId) {
        _bbsPost.setPostId(postId);
    }

    /**
    * Returns the bbs ID of this bbs post.
    *
    * @return the bbs ID of this bbs post
    */
    @Override
    public long getBbsId() {
        return _bbsPost.getBbsId();
    }

    /**
    * Sets the bbs ID of this bbs post.
    *
    * @param bbsId the bbs ID of this bbs post
    */
    @Override
    public void setBbsId(long bbsId) {
        _bbsPost.setBbsId(bbsId);
    }

    /**
    * Returns the user ID of this bbs post.
    *
    * @return the user ID of this bbs post
    */
    @Override
    public long getUserId() {
        return _bbsPost.getUserId();
    }

    /**
    * Sets the user ID of this bbs post.
    *
    * @param userId the user ID of this bbs post
    */
    @Override
    public void setUserId(long userId) {
        _bbsPost.setUserId(userId);
    }

    /**
    * Returns the user uuid of this bbs post.
    *
    * @return the user uuid of this bbs post
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _bbsPost.getUserUuid();
    }

    /**
    * Sets the user uuid of this bbs post.
    *
    * @param userUuid the user uuid of this bbs post
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _bbsPost.setUserUuid(userUuid);
    }

    /**
    * Returns the create date of this bbs post.
    *
    * @return the create date of this bbs post
    */
    @Override
    public java.util.Date getCreateDate() {
        return _bbsPost.getCreateDate();
    }

    /**
    * Sets the create date of this bbs post.
    *
    * @param createDate the create date of this bbs post
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _bbsPost.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this bbs post.
    *
    * @return the modified date of this bbs post
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _bbsPost.getModifiedDate();
    }

    /**
    * Sets the modified date of this bbs post.
    *
    * @param modifiedDate the modified date of this bbs post
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _bbsPost.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the writer of this bbs post.
    *
    * @return the writer of this bbs post
    */
    @Override
    public java.lang.String getWriter() {
        return _bbsPost.getWriter();
    }

    /**
    * Sets the writer of this bbs post.
    *
    * @param writer the writer of this bbs post
    */
    @Override
    public void setWriter(java.lang.String writer) {
        _bbsPost.setWriter(writer);
    }

    /**
    * Returns the email of this bbs post.
    *
    * @return the email of this bbs post
    */
    @Override
    public java.lang.String getEmail() {
        return _bbsPost.getEmail();
    }

    /**
    * Sets the email of this bbs post.
    *
    * @param email the email of this bbs post
    */
    @Override
    public void setEmail(java.lang.String email) {
        _bbsPost.setEmail(email);
    }

    /**
    * Returns the password of this bbs post.
    *
    * @return the password of this bbs post
    */
    @Override
    public java.lang.String getPassword() {
        return _bbsPost.getPassword();
    }

    /**
    * Sets the password of this bbs post.
    *
    * @param password the password of this bbs post
    */
    @Override
    public void setPassword(java.lang.String password) {
        _bbsPost.setPassword(password);
    }

    /**
    * Returns the title of this bbs post.
    *
    * @return the title of this bbs post
    */
    @Override
    public java.lang.String getTitle() {
        return _bbsPost.getTitle();
    }

    /**
    * Sets the title of this bbs post.
    *
    * @param title the title of this bbs post
    */
    @Override
    public void setTitle(java.lang.String title) {
        _bbsPost.setTitle(title);
    }

    /**
    * Returns the content of this bbs post.
    *
    * @return the content of this bbs post
    */
    @Override
    public java.lang.String getContent() {
        return _bbsPost.getContent();
    }

    /**
    * Sets the content of this bbs post.
    *
    * @param content the content of this bbs post
    */
    @Override
    public void setContent(java.lang.String content) {
        _bbsPost.setContent(content);
    }

    /**
    * Returns the secret of this bbs post.
    *
    * @return the secret of this bbs post
    */
    @Override
    public boolean getSecret() {
        return _bbsPost.getSecret();
    }

    /**
    * Returns <code>true</code> if this bbs post is secret.
    *
    * @return <code>true</code> if this bbs post is secret; <code>false</code> otherwise
    */
    @Override
    public boolean isSecret() {
        return _bbsPost.isSecret();
    }

    /**
    * Sets whether this bbs post is secret.
    *
    * @param secret the secret of this bbs post
    */
    @Override
    public void setSecret(boolean secret) {
        _bbsPost.setSecret(secret);
    }

    /**
    * Returns the comment emailed of this bbs post.
    *
    * @return the comment emailed of this bbs post
    */
    @Override
    public boolean getCommentEmailed() {
        return _bbsPost.getCommentEmailed();
    }

    /**
    * Returns <code>true</code> if this bbs post is comment emailed.
    *
    * @return <code>true</code> if this bbs post is comment emailed; <code>false</code> otherwise
    */
    @Override
    public boolean isCommentEmailed() {
        return _bbsPost.isCommentEmailed();
    }

    /**
    * Sets whether this bbs post is comment emailed.
    *
    * @param commentEmailed the comment emailed of this bbs post
    */
    @Override
    public void setCommentEmailed(boolean commentEmailed) {
        _bbsPost.setCommentEmailed(commentEmailed);
    }

    /**
    * Returns the view count of this bbs post.
    *
    * @return the view count of this bbs post
    */
    @Override
    public int getViewCount() {
        return _bbsPost.getViewCount();
    }

    /**
    * Sets the view count of this bbs post.
    *
    * @param viewCount the view count of this bbs post
    */
    @Override
    public void setViewCount(int viewCount) {
        _bbsPost.setViewCount(viewCount);
    }

    @Override
    public boolean isNew() {
        return _bbsPost.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _bbsPost.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _bbsPost.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _bbsPost.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _bbsPost.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _bbsPost.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _bbsPost.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _bbsPost.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _bbsPost.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _bbsPost.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _bbsPost.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new BbsPostWrapper((BbsPost) _bbsPost.clone());
    }

    @Override
    public int compareTo(com.sdr.bbs.model.BbsPost bbsPost) {
        return _bbsPost.compareTo(bbsPost);
    }

    @Override
    public int hashCode() {
        return _bbsPost.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.sdr.bbs.model.BbsPost> toCacheModel() {
        return _bbsPost.toCacheModel();
    }

    @Override
    public com.sdr.bbs.model.BbsPost toEscapedModel() {
        return new BbsPostWrapper(_bbsPost.toEscapedModel());
    }

    @Override
    public com.sdr.bbs.model.BbsPost toUnescapedModel() {
        return new BbsPostWrapper(_bbsPost.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _bbsPost.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _bbsPost.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _bbsPost.persist();
    }

    @Override
    public int getBbsCommentsCount()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _bbsPost.getBbsCommentsCount();
    }

    @Override
    public java.util.List<com.sdr.bbs.model.BbsComment> getBbsComments()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _bbsPost.getBbsComments();
    }

    @Override
    public java.lang.String getUserName()
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException {
        return _bbsPost.getUserName();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof BbsPostWrapper)) {
            return false;
        }

        BbsPostWrapper bbsPostWrapper = (BbsPostWrapper) obj;

        if (Validator.equals(_bbsPost, bbsPostWrapper._bbsPost)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public BbsPost getWrappedBbsPost() {
        return _bbsPost;
    }

    @Override
    public BbsPost getWrappedModel() {
        return _bbsPost;
    }

    @Override
    public void resetOriginalValues() {
        _bbsPost.resetOriginalValues();
    }
}
