package com.sdr.bbs.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the BbsPost service. Represents a row in the &quot;sdr_bbs_BbsPost&quot; database table, with each column mapped to a property of this class.
 *
 * @author goopsw
 * @see BbsPostModel
 * @see com.sdr.bbs.model.impl.BbsPostImpl
 * @see com.sdr.bbs.model.impl.BbsPostModelImpl
 * @generated
 */
public interface BbsPost extends BbsPostModel, PersistedModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify this interface directly. Add methods to {@link com.sdr.bbs.model.impl.BbsPostImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
     */
    public int getBbsCommentsCount()
        throws com.liferay.portal.kernel.exception.SystemException;

    public java.util.List<com.sdr.bbs.model.BbsComment> getBbsComments()
        throws com.liferay.portal.kernel.exception.SystemException;

    public java.lang.String getUserName()
        throws com.liferay.portal.kernel.exception.PortalException,
            com.liferay.portal.kernel.exception.SystemException;
}
