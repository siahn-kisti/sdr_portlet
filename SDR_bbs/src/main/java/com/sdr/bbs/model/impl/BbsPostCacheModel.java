package com.sdr.bbs.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sdr.bbs.model.BbsPost;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing BbsPost in entity cache.
 *
 * @author goopsw
 * @see BbsPost
 * @generated
 */
public class BbsPostCacheModel implements CacheModel<BbsPost>, Externalizable {
    public String uuid;
    public long postId;
    public long bbsId;
    public long userId;
    public long createDate;
    public long modifiedDate;
    public String writer;
    public String email;
    public String password;
    public String title;
    public String content;
    public boolean secret;
    public boolean commentEmailed;
    public int viewCount;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(29);

        sb.append("{uuid=");
        sb.append(uuid);
        sb.append(", postId=");
        sb.append(postId);
        sb.append(", bbsId=");
        sb.append(bbsId);
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
        sb.append(", title=");
        sb.append(title);
        sb.append(", content=");
        sb.append(content);
        sb.append(", secret=");
        sb.append(secret);
        sb.append(", commentEmailed=");
        sb.append(commentEmailed);
        sb.append(", viewCount=");
        sb.append(viewCount);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public BbsPost toEntityModel() {
        BbsPostImpl bbsPostImpl = new BbsPostImpl();

        if (uuid == null) {
            bbsPostImpl.setUuid(StringPool.BLANK);
        } else {
            bbsPostImpl.setUuid(uuid);
        }

        bbsPostImpl.setPostId(postId);
        bbsPostImpl.setBbsId(bbsId);
        bbsPostImpl.setUserId(userId);

        if (createDate == Long.MIN_VALUE) {
            bbsPostImpl.setCreateDate(null);
        } else {
            bbsPostImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            bbsPostImpl.setModifiedDate(null);
        } else {
            bbsPostImpl.setModifiedDate(new Date(modifiedDate));
        }

        if (writer == null) {
            bbsPostImpl.setWriter(StringPool.BLANK);
        } else {
            bbsPostImpl.setWriter(writer);
        }

        if (email == null) {
            bbsPostImpl.setEmail(StringPool.BLANK);
        } else {
            bbsPostImpl.setEmail(email);
        }

        if (password == null) {
            bbsPostImpl.setPassword(StringPool.BLANK);
        } else {
            bbsPostImpl.setPassword(password);
        }

        if (title == null) {
            bbsPostImpl.setTitle(StringPool.BLANK);
        } else {
            bbsPostImpl.setTitle(title);
        }

        if (content == null) {
            bbsPostImpl.setContent(StringPool.BLANK);
        } else {
            bbsPostImpl.setContent(content);
        }

        bbsPostImpl.setSecret(secret);
        bbsPostImpl.setCommentEmailed(commentEmailed);
        bbsPostImpl.setViewCount(viewCount);

        bbsPostImpl.resetOriginalValues();

        return bbsPostImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        uuid = objectInput.readUTF();
        postId = objectInput.readLong();
        bbsId = objectInput.readLong();
        userId = objectInput.readLong();
        createDate = objectInput.readLong();
        modifiedDate = objectInput.readLong();
        writer = objectInput.readUTF();
        email = objectInput.readUTF();
        password = objectInput.readUTF();
        title = objectInput.readUTF();
        content = objectInput.readUTF();
        secret = objectInput.readBoolean();
        commentEmailed = objectInput.readBoolean();
        viewCount = objectInput.readInt();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        if (uuid == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(uuid);
        }

        objectOutput.writeLong(postId);
        objectOutput.writeLong(bbsId);
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

        if (title == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(title);
        }

        if (content == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(content);
        }

        objectOutput.writeBoolean(secret);
        objectOutput.writeBoolean(commentEmailed);
        objectOutput.writeInt(viewCount);
    }
}
