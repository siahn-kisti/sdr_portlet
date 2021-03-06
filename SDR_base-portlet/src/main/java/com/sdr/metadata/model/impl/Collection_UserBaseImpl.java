package com.sdr.metadata.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import com.sdr.metadata.model.Collection_User;
import com.sdr.metadata.service.Collection_UserLocalServiceUtil;

/**
 * The extended model base implementation for the Collection_User service. Represents a row in the &quot;sdr_Collection_User&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link Collection_UserImpl}.
 * </p>
 *
 * @author jaesung
 * @see Collection_UserImpl
 * @see com.sdr.metadata.model.Collection_User
 * @generated
 */
public abstract class Collection_UserBaseImpl extends Collection_UserModelImpl
    implements Collection_User {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a collection_ user model instance should use the {@link Collection_User} interface instead.
     */
    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            Collection_UserLocalServiceUtil.addCollection_User(this);
        } else {
            Collection_UserLocalServiceUtil.updateCollection_User(this);
        }
    }
}
