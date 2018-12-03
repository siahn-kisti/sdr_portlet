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
public class BbsCommentSoap implements Serializable {
    private String _uuid;
    private long _commentId;
    private long _postId;
    private long _userId;
    private Date _createDate;
    private Date _modifiedDate;
    private String _writer;
    private String _email;
    private String _password;
    private String _content;
    private boolean _secret;

    public BbsCommentSoap() {
    }

    public static BbsCommentSoap toSoapModel(BbsComment model) {
        BbsCommentSoap soapModel = new BbsCommentSoap();

        soapModel.setUuid(model.getUuid());
        soapModel.setCommentId(model.getCommentId());
        soapModel.setPostId(model.getPostId());
        soapModel.setUserId(model.getUserId());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setWriter(model.getWriter());
        soapModel.setEmail(model.getEmail());
        soapModel.setPassword(model.getPassword());
        soapModel.setContent(model.getContent());
        soapModel.setSecret(model.getSecret());

        return soapModel;
    }

    public static BbsCommentSoap[] toSoapModels(BbsComment[] models) {
        BbsCommentSoap[] soapModels = new BbsCommentSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static BbsCommentSoap[][] toSoapModels(BbsComment[][] models) {
        BbsCommentSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new BbsCommentSoap[models.length][models[0].length];
        } else {
            soapModels = new BbsCommentSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static BbsCommentSoap[] toSoapModels(List<BbsComment> models) {
        List<BbsCommentSoap> soapModels = new ArrayList<BbsCommentSoap>(models.size());

        for (BbsComment model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new BbsCommentSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _commentId;
    }

    public void setPrimaryKey(long pk) {
        setCommentId(pk);
    }

    public String getUuid() {
        return _uuid;
    }

    public void setUuid(String uuid) {
        _uuid = uuid;
    }

    public long getCommentId() {
        return _commentId;
    }

    public void setCommentId(long commentId) {
        _commentId = commentId;
    }

    public long getPostId() {
        return _postId;
    }

    public void setPostId(long postId) {
        _postId = postId;
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
}
