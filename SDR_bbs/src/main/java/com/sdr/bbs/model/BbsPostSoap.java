package com.sdr.bbs.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author goopsw
 * @generated
 */
public class BbsPostSoap implements Serializable {
    private String _uuid;
    private long _postId;
    private long _bbsId;
    private long _userId;
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

    public BbsPostSoap() {
    }

    public static BbsPostSoap toSoapModel(BbsPost model) {
        BbsPostSoap soapModel = new BbsPostSoap();

        soapModel.setUuid(model.getUuid());
        soapModel.setPostId(model.getPostId());
        soapModel.setBbsId(model.getBbsId());
        soapModel.setUserId(model.getUserId());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setWriter(model.getWriter());
        soapModel.setEmail(model.getEmail());
        soapModel.setPassword(model.getPassword());
        soapModel.setTitle(model.getTitle());
        soapModel.setContent(model.getContent());
        soapModel.setSecret(model.getSecret());
        soapModel.setCommentEmailed(model.getCommentEmailed());
        soapModel.setViewCount(model.getViewCount());

        return soapModel;
    }

    public static BbsPostSoap[] toSoapModels(BbsPost[] models) {
        BbsPostSoap[] soapModels = new BbsPostSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static BbsPostSoap[][] toSoapModels(BbsPost[][] models) {
        BbsPostSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new BbsPostSoap[models.length][models[0].length];
        } else {
            soapModels = new BbsPostSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static BbsPostSoap[] toSoapModels(List<BbsPost> models) {
        List<BbsPostSoap> soapModels = new ArrayList<BbsPostSoap>(models.size());

        for (BbsPost model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new BbsPostSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _postId;
    }

    public void setPrimaryKey(long pk) {
        setPostId(pk);
    }

    public String getUuid() {
        return _uuid;
    }

    public void setUuid(String uuid) {
        _uuid = uuid;
    }

    public long getPostId() {
        return _postId;
    }

    public void setPostId(long postId) {
        _postId = postId;
    }

    public long getBbsId() {
        return _bbsId;
    }

    public void setBbsId(long bbsId) {
        _bbsId = bbsId;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    public Date getModifiedDate() {
        return _modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    public String getWriter() {
        return _writer;
    }

    public void setWriter(String writer) {
        _writer = writer;
    }

    public String getEmail() {
        return _email;
    }

    public void setEmail(String email) {
        _email = email;
    }

    public String getPassword() {
        return _password;
    }

    public void setPassword(String password) {
        _password = password;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        _title = title;
    }

    public String getContent() {
        return _content;
    }

    public void setContent(String content) {
        _content = content;
    }

    public boolean getSecret() {
        return _secret;
    }

    public boolean isSecret() {
        return _secret;
    }

    public void setSecret(boolean secret) {
        _secret = secret;
    }

    public boolean getCommentEmailed() {
        return _commentEmailed;
    }

    public boolean isCommentEmailed() {
        return _commentEmailed;
    }

    public void setCommentEmailed(boolean commentEmailed) {
        _commentEmailed = commentEmailed;
    }

    public int getViewCount() {
        return _viewCount;
    }

    public void setViewCount(int viewCount) {
        _viewCount = viewCount;
    }
}
