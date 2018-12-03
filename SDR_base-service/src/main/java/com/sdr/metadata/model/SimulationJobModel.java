package com.sdr.metadata.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the SimulationJob service. Represents a row in the &quot;sdr_SimulationJob&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sdr.metadata.model.impl.SimulationJobModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sdr.metadata.model.impl.SimulationJobImpl}.
 * </p>
 *
 * @author jaesung
 * @see SimulationJob
 * @see com.sdr.metadata.model.impl.SimulationJobImpl
 * @see com.sdr.metadata.model.impl.SimulationJobModelImpl
 * @generated
 */
public interface SimulationJobModel extends BaseModel<SimulationJob> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. All methods that expect a simulation job model instance should use the {@link SimulationJob} interface instead.
     */

    /**
     * Returns the primary key of this simulation job.
     *
     * @return the primary key of this simulation job
     */
    public long getPrimaryKey();

    /**
     * Sets the primary key of this simulation job.
     *
     * @param primaryKey the primary key of this simulation job
     */
    public void setPrimaryKey(long primaryKey);

    /**
     * Returns the simulation ID of this simulation job.
     *
     * @return the simulation ID of this simulation job
     */
    public long getSimulationId();

    /**
     * Sets the simulation ID of this simulation job.
     *
     * @param simulationId the simulation ID of this simulation job
     */
    public void setSimulationId(long simulationId);

    /**
     * Returns the simulation uuid of this simulation job.
     *
     * @return the simulation uuid of this simulation job
     */
    @AutoEscape
    public String getSimulationUuid();

    /**
     * Sets the simulation uuid of this simulation job.
     *
     * @param simulationUuid the simulation uuid of this simulation job
     */
    public void setSimulationUuid(String simulationUuid);

    /**
     * Returns the job uuid of this simulation job.
     *
     * @return the job uuid of this simulation job
     */
    @AutoEscape
    public String getJobUuid();

    /**
     * Sets the job uuid of this simulation job.
     *
     * @param jobUuid the job uuid of this simulation job
     */
    public void setJobUuid(String jobUuid);

    /**
     * Returns the input ID of this simulation job.
     *
     * @return the input ID of this simulation job
     */
    @AutoEscape
    public String getInputId();

    /**
     * Sets the input ID of this simulation job.
     *
     * @param inputId the input ID of this simulation job
     */
    public void setInputId(String inputId);

    /**
     * Returns the title of this simulation job.
     *
     * @return the title of this simulation job
     */
    @AutoEscape
    public String getTitle();

    /**
     * Sets the title of this simulation job.
     *
     * @param title the title of this simulation job
     */
    public void setTitle(String title);

    /**
     * Returns the description of this simulation job.
     *
     * @return the description of this simulation job
     */
    @AutoEscape
    public String getDescription();

    /**
     * Sets the description of this simulation job.
     *
     * @param description the description of this simulation job
     */
    public void setDescription(String description);

    /**
     * Returns the status of this simulation job.
     *
     * @return the status of this simulation job
     */
    @AutoEscape
    public String getStatus();

    /**
     * Sets the status of this simulation job.
     *
     * @param status the status of this simulation job
     */
    public void setStatus(String status);

    /**
     * Returns the simulation start dt of this simulation job.
     *
     * @return the simulation start dt of this simulation job
     */
    public Date getSimulationStartDt();

    /**
     * Sets the simulation start dt of this simulation job.
     *
     * @param simulationStartDt the simulation start dt of this simulation job
     */
    public void setSimulationStartDt(Date simulationStartDt);

    /**
     * Returns the simulation end dt of this simulation job.
     *
     * @return the simulation end dt of this simulation job
     */
    public Date getSimulationEndDt();

    /**
     * Sets the simulation end dt of this simulation job.
     *
     * @param simulationEndDt the simulation end dt of this simulation job
     */
    public void setSimulationEndDt(Date simulationEndDt);

    /**
     * Returns the user ID of this simulation job.
     *
     * @return the user ID of this simulation job
     */
    public long getUserId();

    /**
     * Sets the user ID of this simulation job.
     *
     * @param userId the user ID of this simulation job
     */
    public void setUserId(long userId);

    /**
     * Returns the user uuid of this simulation job.
     *
     * @return the user uuid of this simulation job
     * @throws SystemException if a system exception occurred
     */
    public String getUserUuid() throws SystemException;

    /**
     * Sets the user uuid of this simulation job.
     *
     * @param userUuid the user uuid of this simulation job
     */
    public void setUserUuid(String userUuid);

    /**
     * Returns the group ID of this simulation job.
     *
     * @return the group ID of this simulation job
     */
    public long getGroupId();

    /**
     * Sets the group ID of this simulation job.
     *
     * @param groupId the group ID of this simulation job
     */
    public void setGroupId(long groupId);

    /**
     * Returns the company ID of this simulation job.
     *
     * @return the company ID of this simulation job
     */
    public long getCompanyId();

    /**
     * Sets the company ID of this simulation job.
     *
     * @param companyId the company ID of this simulation job
     */
    public void setCompanyId(long companyId);

    @Override
    public boolean isNew();

    @Override
    public void setNew(boolean n);

    @Override
    public boolean isCachedModel();

    @Override
    public void setCachedModel(boolean cachedModel);

    @Override
    public boolean isEscapedModel();

    @Override
    public Serializable getPrimaryKeyObj();

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj);

    @Override
    public ExpandoBridge getExpandoBridge();

    @Override
    public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

    @Override
    public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext);

    @Override
    public Object clone();

    @Override
    public int compareTo(com.sdr.metadata.model.SimulationJob simulationJob);

    @Override
    public int hashCode();

    @Override
    public CacheModel<com.sdr.metadata.model.SimulationJob> toCacheModel();

    @Override
    public com.sdr.metadata.model.SimulationJob toEscapedModel();

    @Override
    public com.sdr.metadata.model.SimulationJob toUnescapedModel();

    @Override
    public String toString();

    @Override
    public String toXmlString();
}
