package com.sdr.metadata.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import com.sdr.metadata.model.SdrOrganizations;
import com.sdr.metadata.service.SdrOrganizationsLocalServiceUtil;

/**
 * The extended model base implementation for the SdrOrganizations service. Represents a row in the &quot;sdr_SdrOrganizations&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SdrOrganizationsImpl}.
 * </p>
 *
 * @author jaesung
 * @see SdrOrganizationsImpl
 * @see com.sdr.metadata.model.SdrOrganizations
 * @generated
 */
public abstract class SdrOrganizationsBaseImpl extends SdrOrganizationsModelImpl
    implements SdrOrganizations {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a sdr organizations model instance should use the {@link SdrOrganizations} interface instead.
     */
    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            SdrOrganizationsLocalServiceUtil.addSdrOrganizations(this);
        } else {
            SdrOrganizationsLocalServiceUtil.updateSdrOrganizations(this);
        }
    }
}
