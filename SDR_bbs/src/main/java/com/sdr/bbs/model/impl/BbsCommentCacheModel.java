package com.sdr.bbs.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sdr.bbs.model.BbsComment;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BbsComment in entity cache.
 *
 * @author goopsw
 * @see BbsComment
 * @generated
 */
public class BbsCommentCacheModel implements CacheModel<BbsComment>,
    Externalizable {
    public String uuid;
    public long commentId;
    public long postId;
    public long userId;
    public long createDate;
    public long modifiedDate;
    public String writer;
    public String email;
    public String password;
    public String content;
    public boolean secret;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(23);

        sb.append("{uuid=");
        sb.append(uuid);
        sb.append(", commentId=");
        sb.append(commentId);
        sb.append(", postId=");
        sb.append(postId);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append(", modifiedDate=");
        sb.append(modifiedDate);
        sb.append(", writer=");
        sb.append(writer);
        sb.append(", email=");
        sb.append(email);
        sb.append(", password=");
        sb.append(password);
        sb.append(", content=");
        sb.append(content);
        sb.append(", secret=");
        sb.append(secret);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public BbsComment toEntityModel() {
        BbsCommentImpl bbsCommentImpl = new BbsCommentImpl();

        if (uuid == null) {
            bbsCommentImpl.setUuid(StringPool.BLANK);
        } else {
            bbsCommentImpl.setUuid(uuid);
        }

        bbsCommentImpl.setCommentId(commentId);
        bbsCommentImpl.setPostId(postId);
        bbsCommentImpl.setUserId(userId);

        if (createDate == Long.MIN_VALUE) {
            bbsCommentImpl.setCreateDate(null);
        } else {
            bbsCommentImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            bbsCommentImpl.setModifiedDate(null);
        } else {
            bbsCommentImpl.setModifiedDate(new Date(modifiedDate));
        }

        if (writer == null) {
            bbsCommentImpl.setWriter(StringPool.BLANK);
        } else {
            bbsCommentImpl.setWriter(writer);
        }

        if (email == null) {
            bbsCommentImpl.setEmail(StringPool.BLANK);
        } else {
            bbsCommentImpl.setEmail(email);
        }

        if (password == null) {
            bbsCommentImpl.setPassword(StringPool.BLANK);
        } else {
            bbsCommentImpl.setPassword(password);
        }

        if (content == null) {
            bbsCommentImpl.setContent(StringPool.BLANK);
        } else {
            bbsCommentImpl.setContent(content);
        }

        bbsCommentImpl.setSecret(secret);

        bbsCommentImpl.resetOriginalValues();

        return bbsCommentImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        uuid = objectInput.readUTF();
        commentId = objectInput.readLong();
        postId = objectInput.readLong();
        userId = objectInput.readLong();
        createDate = objectInput.readLong();
        modifiedDate = objectInput.readLong();
        writer = objectInput.readUTF();
        email = objectInput.readUTF();
        password = objectInput.readUTF();
        content = objectInput.readUTF();
        secret = objectInput.readBoolean();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        if (uuid == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(uuid);
        }

        objectOutput.writeLong(commentId);
        objectOutput.writeLong(postId);
        objectOutput.writeLong(userId);
        objectOutput.writeLong(createDate);
        objectOutput.writeLong(modifiedDate);

        if (writer == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(writer);
        }

        if (email == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(email);
        }

        if (password == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(password);
        }

        if (content == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(content);
        }

        objectOutput.writeBoolean(secret);
    }
}
