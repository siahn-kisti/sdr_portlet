package com.sdr.metadata.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import com.sdr.metadata.model.SimulationJob;
import com.sdr.metadata.service.SimulationJobLocalServiceUtil;

/**
 * The extended model base implementation for the SimulationJob service. Represents a row in the &quot;sdr_SimulationJob&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SimulationJobImpl}.
 * </p>
 *
 * @author jaesung
 * @see SimulationJobImpl
 * @see com.sdr.metadata.model.SimulationJob
 * @generated
 */
public abstract class SimulationJobBaseImpl extends SimulationJobModelImpl
    implements SimulationJob {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a simulation job model instance should use the {@link SimulationJob} interface instead.
     */
    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            SimulationJobLocalServiceUtil.addSimulationJob(this);
        } else {
            SimulationJobLocalServiceUtil.updateSimulationJob(this);
        }
    }
}