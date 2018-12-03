package com.sdr.metadata.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import com.sdr.metadata.model.CurationJob;
import com.sdr.metadata.service.CurationJobLocalServiceUtil;

/**
 * The extended model base implementation for the CurationJob service. Represents a row in the &quot;sdr_CurationJob&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CurationJobImpl}.
 * </p>
 *
 * @author jaesung
 * @see CurationJobImpl
 * @see com.sdr.metadata.model.CurationJob
 * @generated
 */
public abstract class CurationJobBaseImpl extends CurationJobModelImpl
    implements CurationJob {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a curation job model instance should use the {@link CurationJob} interface instead.
     */
    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            CurationJobLocalServiceUtil.addCurationJob(this);
        } else {
            CurationJobLocalServiceUtil.updateCurationJob(this);
        }
    }
}