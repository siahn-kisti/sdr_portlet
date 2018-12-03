package com.sdr.metadata.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CurationJob}.
 * </p>
 *
 * @author jaesung
 * @see CurationJob
 * @generated
 */
public class CurationJobWrapper implements CurationJob,
    ModelWrapper<CurationJob> {
    private CurationJob _curationJob;

    public CurationJobWrapper(CurationJob curationJob) {
        _curationJob = curationJob;
    }

    @Override
    public Class<?> getModelClass() {
        return CurationJob.class;
    }

    @Override
    public String getModelClassName() {
        return CurationJob.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("simulationId", getSimulationId());
        attributes.put("simulationUuid", getSimulationUuid());
        attributes.put("jobUuid", getJobUuid());
        attributes.put("description", getDescription());
        attributes.put("status", getStatus());
        attributes.put("simulationStartDt", getSimulationStartDt());
        attributes.put("simulationEndDt", getSimulationEndDt());

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
    }

    /**
    * Returns the primary key of this curation job.
    *
    * @return the primary key of this curation job
    */
    @Override
    public long getPrimaryKey() {
        return _curationJob.getPrimaryKey();
    }

    /**
    * Sets the primary key of this curation job.
    *
    * @param primaryKey the primary key of this curation job
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _curationJob.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the simulation ID of this curation job.
    *
    * @return the simulation ID of this curation job
    */
    @Override
    public long getSimulationId() {
        return _curationJob.getSimulationId();
    }

    /**
    * Sets the simulation ID of this curation job.
    *
    * @param simulationId the simulation ID of this curation job
    */
    @Override
    public void setSimulationId(long simulationId) {
        _curationJob.setSimulationId(simulationId);
    }

    /**
    * Returns the simulation uuid of this curation job.
    *
    * @return the simulation uuid of this curation job
    */
    @Override
    public java.lang.String getSimulationUuid() {
        return _curationJob.getSimulationUuid();
    }

    /**
    * Sets the simulation uuid of this curation job.
    *
    * @param simulationUuid the simulation uuid of this curation job
    */
    @Override
    public void setSimulationUuid(java.lang.String simulationUuid) {
        _curationJob.setSimulationUuid(simulationUuid);
    }

    /**
    * Returns the job uuid of this curation job.
    *
    * @return the job uuid of this curation job
    */
    @Override
    public java.lang.String getJobUuid() {
        return _curationJob.getJobUuid();
    }

    /**
    * Sets the job uuid of this curation job.
    *
    * @param jobUuid the job uuid of this curation job
    */
    @Override
    public void setJobUuid(java.lang.String jobUuid) {
        _curationJob.setJobUuid(jobUuid);
    }

    /**
    * Returns the description of this curation job.
    *
    * @return the description of this curation job
    */
    @Override
    public java.lang.String getDescription() {
        return _curationJob.getDescription();
    }

    /**
    * Sets the description of this curation job.
    *
    * @param description the description of this curation job
    */
    @Override
    public void setDescription(java.lang.String description) {
        _curationJob.setDescription(description);
    }

    /**
    * Returns the status of this curation job.
    *
    * @return the status of this curation job
    */
    @Override
    public java.lang.String getStatus() {
        return _curationJob.getStatus();
    }

    /**
    * Sets the status of this curation job.
    *
    * @param status the status of this curation job
    */
    @Override
    public void setStatus(java.lang.String status) {
        _curationJob.setStatus(status);
    }

    /**
    * Returns the simulation start dt of this curation job.
    *
    * @return the simulation start dt of this curation job
    */
    @Override
    public java.util.Date getSimulationStartDt() {
        return _curationJob.getSimulationStartDt();
    }

    /**
    * Sets the simulation start dt of this curation job.
    *
    * @param simulationStartDt the simulation start dt of this curation job
    */
    @Override
    public void setSimulationStartDt(java.util.Date simulationStartDt) {
        _curationJob.setSimulationStartDt(simulationStartDt);
    }

    /**
    * Returns the simulation end dt of this curation job.
    *
    * @return the simulation end dt of this curation job
    */
    @Override
    public java.util.Date getSimulationEndDt() {
        return _curationJob.getSimulationEndDt();
    }

    /**
    * Sets the simulation end dt of this curation job.
    *
    * @param simulationEndDt the simulation end dt of this curation job
    */
    @Override
    public void setSimulationEndDt(java.util.Date simulationEndDt) {
        _curationJob.setSimulationEndDt(simulationEndDt);
    }

    @Override
    public boolean isNew() {
        return _curationJob.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _curationJob.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _curationJob.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _curationJob.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _curationJob.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _curationJob.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _curationJob.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _curationJob.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _curationJob.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _curationJob.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _curationJob.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new CurationJobWrapper((CurationJob) _curationJob.clone());
    }

    @Override
    public int compareTo(com.sdr.metadata.model.CurationJob curationJob) {
        return _curationJob.compareTo(curationJob);
    }

    @Override
    public int hashCode() {
        return _curationJob.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<com.sdr.metadata.model.CurationJob> toCacheModel() {
        return _curationJob.toCacheModel();
    }

    @Override
    public com.sdr.metadata.model.CurationJob toEscapedModel() {
        return new CurationJobWrapper(_curationJob.toEscapedModel());
    }

    @Override
    public com.sdr.metadata.model.CurationJob toUnescapedModel() {
        return new CurationJobWrapper(_curationJob.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _curationJob.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _curationJob.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _curationJob.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof CurationJobWrapper)) {
            return false;
        }

        CurationJobWrapper curationJobWrapper = (CurationJobWrapper) obj;

        if (Validator.equals(_curationJob, curationJobWrapper._curationJob)) {
            return true;
        }

        return false;
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public CurationJob getWrappedCurationJob() {
        return _curationJob;
    }

    @Override
    public CurationJob getWrappedModel() {
        return _curationJob;
    }

    @Override
    public void resetOriginalValues() {
        _curationJob.resetOriginalValues();
    }
}
