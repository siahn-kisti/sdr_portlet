package com.sdr.metadata.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SimulationJob}.
 * </p>
 *
 * @author jaesung
 * @see SimulationJob
 * @generated
 */
public class SimulationJobWrapper implements SimulationJob,
    ModelWrapper<SimulationJob> {
    private SimulationJob _simulationJob;

    public SimulationJobWrapper(SimulationJob simulationJob) {
        _simulationJob = simulationJob;
    }

    @Override
    public Class<?> getModelClass() {
        return SimulationJob.class;
    }

    @Override
    public String getModelClassName() {
        return SimulationJob.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("simulationId", getSimulationId());
        attributes.put("simulationUuid", getSimulationUuid());
        attributes.put("jobUuid", getJobUuid());
        attributes.put("inputId", getInputId());
        attributes.put("title", getTitle());
        attributes.put("description", getDescription());
        attributes.put("status", getStatus());
        attributes.put("simulationStartDt", getSimulationStartDt());
        attributes.put("simulationEndDt", getSimulationEndDt());
        attributes.put("userId", getUserId());
        attributes.put("groupId", getGroupId());
        attributes.put("companyId", getCompanyId());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long simulationId = (Long) attributes.get("simulationId");

        if (simulationId != null) {
            setSimulationId(simulationId);
        }

        String simulationUuid = (String) attributes.get("simulationUuid");

        if (simulationUuid != null) {
            setSimulationUuid(simulationUuid);
        }

        String jobUuid = (String) attributes.get("jobUuid");

        if (jobUuid != null) {
            setJobUuid(jobUuid);
        }

        String inputId = (String) attributes.get("inputId");

        if (inputId != null) {
            setInputId(inputId);
        }

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        String status = (String) attributes.get("status");

        if (status != null) {
            setStatus(status);
        }

        Date simulationStartDt = (Date) attributes.get("simulationStartDt");

        if (simulationStartDt != null) {
            setSimulationStartDt(simulationStartDt);
        }

        Date simulationEndDt = (Date) attributes.get("simulationEndDt");

        if (simulationEndDt != null) {
            setSimulationEndDt(simulationEndDt);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }
    }

    /**
    * Returns the primary key of this simulation job.
    *
    * @return the primary key of this simulation job
    */
    @Override
    public long getPrimaryKey() {
        return _simulationJob.getPrimaryKey();
    }

    /**
    * Sets the primary key of this simulation job.
    *
    * @param primaryKey the primary key of this simulation job
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _simulationJob.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the simulation ID of this simulation job.
    *
    * @return the simulation ID of this simulation job
    */
    @Override
    public long getSimulationId() {
        return _simulationJob.getSimulationId();
    }

    /**
    * Sets the simulation ID of this simulation job.
    *
    * @param simulationId the simulation ID of this simulation job
    */
    @Override
    public void setSimulationId(long simulationId) {
        _simulationJob.setSimulationId(simulationId);
    }

    /**
    * Returns the simulation uuid of this simulation job.
    *
    * @return the simulation uuid of this simulation job
    */
    @Override
    public java.lang.String getSimulationUuid() {
        return _simulationJob.getSimulationUuid();
    }

    /**
    * Sets the simulation uuid of this simulation job.
    *
    * @param simulationUuid the simulation uuid of this simulation job
    */
    @Override
    public void setSimulationUuid(java.lang.String simulationUuid) {
        _simulationJob.setSimulationUuid(simulationUuid);
    }

    /**
    * Returns the job uuid of this simulation job.
    *
    * @return the job uuid of this simulation job
    */
    @Override
    public java.lang.String getJobUuid() {
        return _simulationJob.getJobUuid();
    }

    /**
    * Sets the job uuid of this simulation job.
    *
    * @param jobUuid the job uuid of this simulation job
    */
    @Override
    public void setJobUuid(java.lang.String jobUuid) {
        _simulationJob.setJobUuid(jobUuid);
    }

    /**
    * Returns the input ID of this simulation job.
    *
    * @return the input ID of this simulation job
    */
    @Override
    public java.lang.String getInputId() {
        return _simulationJob.getInputId();
    }

    /**
    * Sets the input ID of this simulation job.
    *
    * @param inputId the input ID of this simulation job
    */
    @Override
    public void setInputId(java.lang.String inputId) {
        _simulationJob.setInputId(inputId);
    }

    /**
    * Returns the title of this simulation job.
    *
    * @return the title of this simulation job
    */
    @Override
    public java.lang.String getTitle() {
        return _simulationJob.getTitle();
    }

    /**
    * Sets the title of this simulation job.
    *
    * @param title the title of this simulation job
    */
    @Override
    public void setTitle(java.lang.String title) {
        _simulationJob.setTitle(title);
    }

    /**
    * Returns the description of this simulation job.
    *
    * @return the description of this simulation job
    */
    @Override
    public java.lang.String getDescription() {
        return _simulationJob.getDescription();
    }

    /**
    * Sets the description of this simulation job.
    *
    * @param description the description of this simulation job
    */
    @Override
    public void setDescription(java.lang.String description) {
        _simulationJob.setDescription(description);
    }

    /**
    * Returns the status of this simulation job.
    *
    * @return the status of this simulation job
    */
    @Override
    public java.lang.String getStatus() {
        return _simulationJob.getStatus();
    }

    /**
    * Sets the status of this simulation job.
    *
    * @param status the status of this simulation job
    */
    @Override
    public void setStatus(java.lang.String status) {
        _simulationJob.setStatus(status);
    }

    /**
    * Returns the simulation start dt of this simulation job.
    *
    * @return the simulation start dt of this simulation job
    */
    @Override
    public java.util.Date getSimulationStartDt() {
        return _simulationJob.getSimulationStartDt();
    }

    /**
    * Sets the simulation start dt of this simulation job.
    *
    * @param simulationStartDt the simulation start dt of this simulation job
    */
    @Override
    public void setSimulationStartDt(java.util.Date simulationStartDt) {
        _simulationJob.setSimulationStartDt(simulationStartDt);
    }

    /**
    * Returns the simulation end dt of this simulation job.
    *
    * @return the simulation end dt of this simulation job
    */
    @Override
    public java.util.Date getSimulationEndDt() {
        return _simulationJob.getSimulationEndDt();
    }

    /**
    * Sets the simulation end dt of this simulation job.
    *
    * @param simulationEndDt the simulation end dt of this simulation job
    */
    @Override
    public void setSimulationEndDt(java.util.Date simulationEndDt) {
        _simulationJob.setSimulationEndDt(simulationEndDt);
    }

    /**
    * Returns the user ID of this simulation job.
    *
    * @return the user ID of this simulation job
    */
    @Override
    public long getUserId() {
        return _simulationJob.getUserId();
    }

    /**
    * Sets the user ID of this simulation job.
    *
    * @param userId the user ID of this simulation job
    */
    @Override
    public void setUserId(long userId) {
        _simulationJob.setUserId(userId);
    }

    /**
    * Returns the user uuid of this simulation job.
    *
    * @return the user uuid of this simulation job
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _simulationJob.getUserUuid();
    }

    /**
    * Sets the user uuid of this simulation job.
    *
    * @param userUuid the user uuid of this simulation job
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _simulationJob.setUserUuid(userUuid);
    }

    /**
    * Returns the group ID of this simulation job.
    *
    * @return the group ID of this simulation job
    */
    @Override
    public long getGroupId() {
        return _simulationJob.getGroupId();
    }

    /**
    * Sets the group ID of this simulation job.
    *
    * @param groupId the group ID of this simulation job
    */
    @Override
    public void setGroupId(long groupId) {
        _simulationJob.setGroupId(groupId);
    }

    /**
    * Returns the company ID of this simulation job.
    *
    * @return the company ID of this simulation job
    */
    @Override
    public long getCompanyId() {
        return _simulationJob.getCompanyId();
    }

    /**
    * Sets the company ID of this simulation job.
    *
    * @param companyId the company ID of this simulation job
    */
    @Override
    public void setCompanyId(long companyId) {
        _simulationJob.setCompanyId(companyId);
    }

    @Override
    public boolean isNew() {
        return _simulationJob.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _simulationJob.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _simulationJob.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _simulationJob.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _simulationJob.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _simulationJob.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _simulationJob.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _simulationJob.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _simulationJob.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _simulationJob.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _simulationJob.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new SimulationJobWrapper((SimulationJob) _simulationJob.clone());
    }

    @Override
    public int compareTo(com.sdr.metadata.model.SimulationJob simulationJob) {
        return _simulationJob.compareTo(simulationJob);
    }

    @Override
    public int hashCode() {
        return _simulationJob.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.sdr.metadata.model.SimulationJob> toCacheModel() {
        return _simulationJob.toCacheModel();
    }

    @Override
    public com.sdr.metadata.model.SimulationJob toEscapedModel() {
        return new SimulationJobWrapper(_simulationJob.toEscapedModel());
    }

    @Override
    public com.sdr.metadata.model.SimulationJob toUnescapedModel() {
        return new SimulationJobWrapper(_simulationJob.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _simulationJob.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _simulationJob.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _simulationJob.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof SimulationJobWrapper)) {
            return false;
        }

        SimulationJobWrapper simulationJobWrapper = (SimulationJobWrapper) obj;

        if (Validator.equals(_simulationJob, simulationJobWrapper._simulationJob)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public SimulationJob getWrappedSimulationJob() {
        return _simulationJob;
    }

    @Override
    public SimulationJob getWrappedModel() {
        return _simulationJob;
    }

    @Override
    public void resetOriginalValues() {
        _simulationJob.resetOriginalValues();
    }
}
