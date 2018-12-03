package com.sdr.bbs.common.model;

import com.sdr.bbs.model.BbsPostClp;

/**
 * The type Bbs post vo.
 */
public class BbsPostVo extends BbsPostClp {

    private String commentEmailTitle;
    private String secretPassword;
    private String imgSrc;
    private long firstFileId;
    private long imgType;

    /**
     * Gets comment email title.
     *
     * @return the comment email title
     */
    public String getCommentEmailTitle() {
        return commentEmailTitle;
    }

    /**
     * Sets comment email title.
     *
     * @param commentEmailTitle the comment email title
     */
    public void setCommentEmailTitle(String commentEmailTitle) {
        this.commentEmailTitle = commentEmailTitle;
    }

    /**
     * Gets secret password.
     *
     * @return the secret password
     */
    public String getSecretPassword() {
        return secretPassword;
    }

    /**
     * Sets secret password.
     *
     * @param secretPassword the secret password
     */
    public void setSecretPassword(String secretPassword) {
        this.secretPassword = secretPassword;
    }

    /**
     * Gets img src.
     *
     * @return the img src
     */
    public String getImgSrc() {
        return imgSrc;
    }

    /**
     * Sets img src.
     *
     * @param imgSrc the img src
     */
    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    /**
     * Gets first file id.
     *
     * @return the first file id
     */
    public long getFirstFileId() {
        return firstFileId;
    }

    /**
     * Sets first file id.
     *
     * @param firstFileId the first file id
     */
    public void setFirstFileId(long firstFileId) {
        this.firstFileId = firstFileId;
    }

    /**
     * Gets img type.
     *
     * @return the img type
     */
    public long getImgType() {
        return imgType;
    }

    /**
     * Sets img type.
     *
     * @param imgType the img type
     */
    public void setImgType(long imgType) {
        this.imgType = imgType;
    }
}
