package com.sdr.metadata.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.sdr.metadata.service.http.CurationJobServiceSoap}.
 *
 * @author jaesung
 * @see com.sdr.metadata.service.http.CurationJobServiceSoap
 * @generated
 */
public class CurationJobSoap implements Serializable {
    private long _simulationId;
    private String _simulationUuid;
    private String _jobUuid;
    private String _description;
    private String _status;
    private Date _simulationStartDt;
    private Date _simulationEndDt;

    public CurationJobSoap() {
    }

    public static CurationJobSoap toSoapModel(CurationJob model) {
        CurationJobSoap soapModel = new CurationJobSoap();

        soapModel.setSimulationId(model.getSimulationId());
        soapModel.setSimulationUuid(model.getSimulationUuid());
        soapModel.setJobUuid(model.getJobUuid());
        soapModel.setDescription(model.getDescription());
        soapModel.setStatus(model.getStatus());
        soapModel.setSimulationStartDt(model.getSimulationStartDt());
        soapModel.setSimulationEndDt(model.getSimulationEndDt());

        return soapModel;
    }

    public static CurationJobSoap[] toSoapModels(CurationJob[] models) {
        CurationJobSoap[] soapModels = new CurationJobSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static CurationJobSoap[][] toSoapModels(CurationJob[][] models) {
        CurationJobSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new CurationJobSoap[models.length][models[0].length];
        } else {
            soapModels = new CurationJobSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static CurationJobSoap[] toSoapModels(List<CurationJob> models) {
        List<CurationJobSoap> soapModels = new ArrayList<CurationJobSoap>(models.size());

        for (CurationJob model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new CurationJobSoap[soapModels.size()]);
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
}
