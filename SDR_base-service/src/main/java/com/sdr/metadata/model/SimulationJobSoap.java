package com.sdr.metadata.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.sdr.metadata.service.http.SimulationJobServiceSoap}.
 *
 * @author jaesung
 * @see com.sdr.metadata.service.http.SimulationJobServiceSoap
 * @generated
 */
public class SimulationJobSoap implements Serializable {
    private long _simulationId;
    private String _simulationUuid;
    private String _jobUuid;
    private String _inputId;
    private String _title;
    private String _description;
    private String _status;
    private Date _simulationStartDt;
    private Date _simulationEndDt;
    private long _userId;
    private long _groupId;
    private long _companyId;

    public SimulationJobSoap() {
    }

    public static SimulationJobSoap toSoapModel(SimulationJob model) {
        SimulationJobSoap soapModel = new SimulationJobSoap();

        soapModel.setSimulationId(model.getSimulationId());
        soapModel.setSimulationUuid(model.getSimulationUuid());
        soapModel.setJobUuid(model.getJobUuid());
        soapModel.setInputId(model.getInputId());
        soapModel.setTitle(model.getTitle());
        soapModel.setDescription(model.getDescription());
        soapModel.setStatus(model.getStatus());
        soapModel.setSimulationStartDt(model.getSimulationStartDt());
        soapModel.setSimulationEndDt(model.getSimulationEndDt());
        soapModel.setUserId(model.getUserId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());

        return soapModel;
    }

    public static SimulationJobSoap[] toSoapModels(SimulationJob[] models) {
        SimulationJobSoap[] soapModels = new SimulationJobSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static SimulationJobSoap[][] toSoapModels(SimulationJob[][] models) {
        SimulationJobSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new SimulationJobSoap[models.length][models[0].length];
        } else {
            soapModels = new SimulationJobSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static SimulationJobSoap[] toSoapModels(List<SimulationJob> models) {
        List<SimulationJobSoap> soapModels = new ArrayList<SimulationJobSoap>(models.size());

        for (SimulationJob model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new SimulationJobSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _simulationId;
    }

    public void setPrimaryKey(long pk) {
        setSimulationId(pk);
    }

    public long getSimulationId() {
        return _simulationId;
    }

    public void setSimulationId(long simulationId) {
        _simulationId = simulationId;
    }

    public String getSimulationUuid() {
        return _simulationUuid;
    }

    public void setSimulationUuid(String simulationUuid) {
        _simulationUuid = simulationUuid;
    }

    public String getJobUuid() {
        return _jobUuid;
    }

    public void setJobUuid(String jobUuid) {
        _jobUuid = jobUuid;
    }

    public String getInputId() {
        return _inputId;
    }

    public void setInputId(String inputId) {
        _inputId = inputId;
    }

    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        _title = title;
    }

    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    public String getStatus() {
        return _status;
    }

    public void setStatus(String status) {
        _status = status;
    }

    public Date getSimulationStartDt() {
        return _simulationStartDt;
    }

    public void setSimulationStartDt(Date simulationStartDt) {
        _simulationStartDt = simulationStartDt;
    }

    public Date getSimulationEndDt() {
        return _simulationEndDt;
    }

    public void setSimulationEndDt(Date simulationEndDt) {
        _simulationEndDt = simulationEndDt;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }
}
