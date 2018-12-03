package com.sdr.common.model;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringUtil;
import com.sdr.metadata.model.CollectionClp;
import com.sdr.metadata.model.Collection_AllowedUser;
import com.sdr.metadata.model.Collection_User;
import com.sdr.metadata.service.Collection_AllowedUserLocalServiceUtil;
import com.sdr.metadata.service.Collection_UserLocalServiceUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * The type Collection vo.
 */
public class CollectionVo extends CollectionClp {

    private String submissionId;
    private String collectionName;
    private String contributorIds;
    private String allowedUserIds;



    //-----------------------------------------------------------------------

    /**
     * Get allowed users long [ ].
     *
     * @return the long [ ]
     */
    public long[] getAllowedUsers() {
        long x = 0;
        return StringUtil.split(allowedUserIds, x);
    }

    /**
     * Gets allowed user ids by db.
     *
     * @return the allowed user ids by db
     * @throws SystemException the system exception
     * @throws PortalException the portal exception
     */
    public String getAllowedUserIdsByDb() throws SystemException, PortalException {

        List<Collection_AllowedUser> list = Collection_AllowedUserLocalServiceUtil.getAllowedUsersByCollection(getCollectionId());
        String result = StringUtils.join(list, ",");

        return result;
    }

    /**
     * Get contributors long [ ].
     *
     * @return the long [ ]
     */
//-----------------------------------------------------------------------
    public long[] getContributors() {
        long x = 0;
        return StringUtil.split(contributorIds, x);
    }

    /**
     * Gets contributor ids by db.
     *
     * @return the contributor ids by db
     * @throws PortalException the portal exception
     * @throws SystemException the system exception
     */
    public String getContributorIdsByDb() throws PortalException, SystemException {

        List<Collection_User> list = Collection_UserLocalServiceUtil.getUsersByCollection(getCollectionId());
        String result = StringUtils.join(list, ",");

        return result;
    }


    //-----------------------------------------------------------------------

    /**
     * Gets allowed user ids.
     *
     * @return the allowed user ids
     */
    public String getAllowedUserIds() {
        return allowedUserIds;
    }

    /**
     * Sets allowed user ids.
     *
     * @param allowedUserIds the allowed user ids
     */
    public void setAllowedUserIds(String allowedUserIds) {
        this.allowedUserIds = allowedUserIds;
    }

    /**
     * Gets collection name.
     *
     * @return the collection name
     */
    public String getCollectionName() {
        return collectionName;
    }

    /**
     * Sets collection name.
     *
     * @param collectionName the collection name
     */
    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    /**
     * Gets contributor ids.
     *
     * @return the contributor ids
     */
    public String getContributorIds() {
        return contributorIds;
    }

    /**
     * Sets contributor ids.
     *
     * @param contributorIds the contributor ids
     */
    public void setContributorIds(String contributorIds) {
        this.contributorIds = contributorIds;
    }

    /**
     * Gets submission id.
     *
     * @return the submission id
     */
    public String getSubmissionId() {
        return submissionId;
    }

    /**
     * Sets submission id.
     *
     * @param submissionId the submission id
     */
    public void setSubmissionId(String submissionId) {
        this.submissionId = submissionId;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        super.setModelAttributes(attributes);

        String collectionName = (String) attributes.get("collectionName");

        if (collectionName != null) {
            setCollectionName(collectionName);
        }
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = super.getModelAttributes();
        attributes.put("collectionName", getCollectionName());
        return attributes;
    }
}
