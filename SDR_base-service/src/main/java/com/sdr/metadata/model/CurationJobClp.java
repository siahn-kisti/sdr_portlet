package com.sdr.metadata.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sdr.metadata.service.ClpSerializer;
import com.sdr.metadata.service.CurationJobLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class CurationJobClp extends BaseModelImpl<CurationJob>
    implements CurationJob {
    private long _simulationId;
    private String _simulationUuid;
    private String _jobUuid;
    private String _description;
    private String _status;
    private Date _simulationStartDt;
    private Date _simulationEndDt;
    private BaseModel<?> _curationJobRemoteModel;
    private Class<?> _clpSerializerClass = com.sdr.metadata.service.ClpSerializer.class;

    public CurationJobClp() {
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
    public long getPrimaryKey() {
        return _simulationId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setSimulationId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _simulationId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
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

    @Override
    public long getSimulationId() {
        return _simulationId;
    }

    @Override
    public void setSimulationId(long simulationId) {
        _simulationId = simulationId;

        if (_curationJobRemoteModel != null) {
            try {
                Class<?> clazz = _curationJobRemoteModel.getClass();

                Method method = clazz.getMethod("setSimulationId", long.class);

                method.invoke(_curationJobRemoteModel, simulationId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getSimulationUuid() {
        return _simulationUuid;
    }

    @Override
    public void setSimulationUuid(String simulationUuid) {
        _simulationUuid = simulationUuid;

        if (_curationJobRemoteModel != null) {
            try {
                Class<?> clazz = _curationJobRemoteModel.getClass();

                Method method = clazz.getMethod("setSimulationUuid",
                        String.class);

                method.invoke(_curationJobRemoteModel, simulationUuid);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getJobUuid() {
        return _jobUuid;
    }

    @Override
    public void setJobUuid(String jobUuid) {
        _jobUuid = jobUuid;

        if (_curationJobRemoteModel != null) {
            try {
                Class<?> clazz = _curationJobRemoteModel.getClass();

                Method method = clazz.getMethod("setJobUuid", String.class);

                method.invoke(_curationJobRemoteModel, jobUuid);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getDescription() {
        return _description;
    }

    @Override
    public void setDescription(String description) {
        _description = description;

        if (_curationJobRemoteModel != null) {
            try {
                Class<?> clazz = _curationJobRemoteModel.getClass();

                Method method = clazz.getMethod("setDescription", String.class);

                method.invoke(_curationJobRemoteModel, description);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getStatus() {
        return _status;
    }

    @Override
    public void setStatus(String status) {
        _status = status;

        if (_curationJobRemoteModel != null) {
            try {
                Class<?> clazz = _curationJobRemoteModel.getClass();

                Method method = clazz.getMethod("setStatus", String.class);

                method.invoke(_curationJobRemoteModel, status);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getSimulationStartDt() {
        return _simulationStartDt;
    }

    @Override
    public void setSimulationStartDt(Date simulationStartDt) {
        _simulationStartDt = simulationStartDt;

        if (_curationJobRemoteModel != null) {
            try {
                Class<?> clazz = _curationJobRemoteModel.getClass();

                Method method = clazz.getMethod("setSimulationStartDt",
                        Date.class);

                method.invoke(_curationJobRemoteModel, simulationStartDt);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public Date getSimulationEndDt() {
        return _simulationEndDt;
    }

    @Override
    public void setSimulationEndDt(Date simulationEndDt) {
        _simulationEndDt = simulationEndDt;

        if (_curationJobRemoteModel != null) {
            try {
                Class<?> clazz = _curationJobRemoteModel.getClass();

                Method method = clazz.getMethod("setSimulationEndDt", Date.class);

                method.invoke(_curationJobRemoteModel, simulationEndDt);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getCurationJobRemoteModel() {
        return _curationJobRemoteModel;
    }

    public void setCurationJobRemoteModel(BaseModel<?> curationJobRemoteModel) {
        _curationJobRemoteModel = curationJobRemoteModel;
    }

    public Object invokeOnRemoteModel(String methodName,
        Class<?>[] parameterTypes, Object[] parameterValues)
        throws Exception {
        Object[] remoteParameterValues = new Object[parameterValues.length];

        for (int i = 0; i < parameterValues.length; i++) {
            if (parameterValues[i] != null) {
                remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
            }
        }

        Class<?> remoteModelClass = _curationJobRemoteModel.getClass();

        ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

        Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

        for (int i = 0; i < parameterTypes.length; i++) {
            if (parameterTypes[i].isPrimitive()) {
                remoteParameterTypes[i] = parameterTypes[i];
            } else {
                String parameterTypeName = parameterTypes[i].getName();

                remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
            }
        }

        Method method = remoteModelClass.getMethod(methodName,
                remoteParameterTypes);

        Object returnValue = method.invoke(_curationJobRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            CurationJobLocalServiceUtil.addCurationJob(this);
        } else {
            CurationJobLocalServiceUtil.updateCurationJob(this);
        }
    }

    @Override
    public CurationJob toEscapedModel() {
        return (CurationJob) ProxyUtil.newProxyInstance(CurationJob.class.getClassLoader(),
            new Class[] { CurationJob.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        CurationJobClp clone = new CurationJobClp();

        clone.setSimulationId(getSimulationId());
        clone.setSimulationUuid(getSimulationUuid());
        clone.setJobUuid(getJobUuid());
        clone.setDescription(getDescription());
        clone.setStatus(getStatus());
        clone.setSimulationStartDt(getSimulationStartDt());
        clone.setSimulationEndDt(getSimulationEndDt());

        return clone;
    }

    @Override
    public int compareTo(CurationJob curationJob) {
        long primaryKey = curationJob.getPrimaryKey();

        if (getPrimaryKey() < primaryKey) {
            return -1;
        } else if (getPrimaryKey() > primaryKey) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof CurationJobClp)) {
            return false;
        }

        CurationJobClp curationJob = (CurationJobClp) obj;

        long primaryKey = curationJob.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    public Class<?> getClpSerializerClass() {
        return _clpSerializerClass;
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(15);

        sb.append("{simulationId=");
        sb.append(getSimulationId());
        sb.append(", simulationUuid=");
        sb.append(getSimulationUuid());
        sb.append(", jobUuid=");
        sb.append(getJobUuid());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", status=");
        sb.append(getStatus());
        sb.append(", simulationStartDt=");
        sb.append(getSimulationStartDt());
        sb.append(", simulationEndDt=");
        sb.append(getSimulationEndDt());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(25);

        sb.append("<model><model-name>");
        sb.append("com.sdr.metadata.model.CurationJob");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>simulationId</column-name><column-value><![CDATA[");
        sb.append(getSimulationId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>simulationUuid</column-name><column-value><![CDATA[");
        sb.append(getSimulationUuid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>jobUuid</column-name><column-value><![CDATA[");
        sb.append(getJobUuid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>status</column-name><column-value><![CDATA[");
        sb.append(getStatus());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>simulationStartDt</column-name><column-value><![CDATA[");
        sb.append(getSimulationStartDt());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>simulationEndDt</column-name><column-value><![CDATA[");
        sb.append(getSimulationEndDt());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
