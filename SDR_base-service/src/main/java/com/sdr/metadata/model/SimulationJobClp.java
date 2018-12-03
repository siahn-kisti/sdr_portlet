package com.sdr.metadata.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sdr.metadata.service.ClpSerializer;
import com.sdr.metadata.service.SimulationJobLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class SimulationJobClp extends BaseModelImpl<SimulationJob>
    implements SimulationJob {
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
    private String _userUuid;
    private long _groupId;
    private long _companyId;
    private BaseModel<?> _simulationJobRemoteModel;
    private Class<?> _clpSerializerClass = com.sdr.metadata.service.ClpSerializer.class;

    public SimulationJobClp() {
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

    @Override
    public long getSimulationId() {
        return _simulationId;
    }

    @Override
    public void setSimulationId(long simulationId) {
        _simulationId = simulationId;

        if (_simulationJobRemoteModel != null) {
            try {
                Class<?> clazz = _simulationJobRemoteModel.getClass();

                Method method = clazz.getMethod("setSimulationId", long.class);

                method.invoke(_simulationJobRemoteModel, simulationId);
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

        if (_simulationJobRemoteModel != null) {
            try {
                Class<?> clazz = _simulationJobRemoteModel.getClass();

                Method method = clazz.getMethod("setSimulationUuid",
                        String.class);

                method.invoke(_simulationJobRemoteModel, simulationUuid);
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

        if (_simulationJobRemoteModel != null) {
            try {
                Class<?> clazz = _simulationJobRemoteModel.getClass();

                Method method = clazz.getMethod("setJobUuid", String.class);

                method.invoke(_simulationJobRemoteModel, jobUuid);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getInputId() {
        return _inputId;
    }

    @Override
    public void setInputId(String inputId) {
        _inputId = inputId;

        if (_simulationJobRemoteModel != null) {
            try {
                Class<?> clazz = _simulationJobRemoteModel.getClass();

                Method method = clazz.getMethod("setInputId", String.class);

                method.invoke(_simulationJobRemoteModel, inputId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getTitle() {
        return _title;
    }

    @Override
    public void setTitle(String title) {
        _title = title;

        if (_simulationJobRemoteModel != null) {
            try {
                Class<?> clazz = _simulationJobRemoteModel.getClass();

                Method method = clazz.getMethod("setTitle", String.class);

                method.invoke(_simulationJobRemoteModel, title);
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

        if (_simulationJobRemoteModel != null) {
            try {
                Class<?> clazz = _simulationJobRemoteModel.getClass();

                Method method = clazz.getMethod("setDescription", String.class);

                method.invoke(_simulationJobRemoteModel, description);
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

        if (_simulationJobRemoteModel != null) {
            try {
                Class<?> clazz = _simulationJobRemoteModel.getClass();

                Method method = clazz.getMethod("setStatus", String.class);

                method.invoke(_simulationJobRemoteModel, status);
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

        if (_simulationJobRemoteModel != null) {
            try {
                Class<?> clazz = _simulationJobRemoteModel.getClass();

                Method method = clazz.getMethod("setSimulationStartDt",
                        Date.class);

                method.invoke(_simulationJobRemoteModel, simulationStartDt);
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

        if (_simulationJobRemoteModel != null) {
            try {
                Class<?> clazz = _simulationJobRemoteModel.getClass();

                Method method = clazz.getMethod("setSimulationEndDt", Date.class);

                method.invoke(_simulationJobRemoteModel, simulationEndDt);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(long userId) {
        _userId = userId;

        if (_simulationJobRemoteModel != null) {
            try {
                Class<?> clazz = _simulationJobRemoteModel.getClass();

                Method method = clazz.getMethod("setUserId", long.class);

                method.invoke(_simulationJobRemoteModel, userId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    @Override
    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    @Override
    public long getGroupId() {
        return _groupId;
    }

    @Override
    public void setGroupId(long groupId) {
        _groupId = groupId;

        if (_simulationJobRemoteModel != null) {
            try {
                Class<?> clazz = _simulationJobRemoteModel.getClass();

                Method method = clazz.getMethod("setGroupId", long.class);

                method.invoke(_simulationJobRemoteModel, groupId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public long getCompanyId() {
        return _companyId;
    }

    @Override
    public void setCompanyId(long companyId) {
        _companyId = companyId;

        if (_simulationJobRemoteModel != null) {
            try {
                Class<?> clazz = _simulationJobRemoteModel.getClass();

                Method method = clazz.getMethod("setCompanyId", long.class);

                method.invoke(_simulationJobRemoteModel, companyId);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getSimulationJobRemoteModel() {
        return _simulationJobRemoteModel;
    }

    public void setSimulationJobRemoteModel(
        BaseModel<?> simulationJobRemoteModel) {
        _simulationJobRemoteModel = simulationJobRemoteModel;
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

        Class<?> remoteModelClass = _simulationJobRemoteModel.getClass();

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

        Object returnValue = method.invoke(_simulationJobRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            SimulationJobLocalServiceUtil.addSimulationJob(this);
        } else {
            SimulationJobLocalServiceUtil.updateSimulationJob(this);
        }
    }

    @Override
    public SimulationJob toEscapedModel() {
        return (SimulationJob) ProxyUtil.newProxyInstance(SimulationJob.class.getClassLoader(),
            new Class[] { SimulationJob.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        SimulationJobClp clone = new SimulationJobClp();

        clone.setSimulationId(getSimulationId());
        clone.setSimulationUuid(getSimulationUuid());
        clone.setJobUuid(getJobUuid());
        clone.setInputId(getInputId());
        clone.setTitle(getTitle());
        clone.setDescription(getDescription());
        clone.setStatus(getStatus());
        clone.setSimulationStartDt(getSimulationStartDt());
        clone.setSimulationEndDt(getSimulationEndDt());
        clone.setUserId(getUserId());
        clone.setGroupId(getGroupId());
        clone.setCompanyId(getCompanyId());

        return clone;
    }

    @Override
    public int compareTo(SimulationJob simulationJob) {
        long primaryKey = simulationJob.getPrimaryKey();

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

        if (!(obj instanceof SimulationJobClp)) {
            return false;
        }

        SimulationJobClp simulationJob = (SimulationJobClp) obj;

        long primaryKey = simulationJob.getPrimaryKey();

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
        StringBundler sb = new StringBundler(25);

        sb.append("{simulationId=");
        sb.append(getSimulationId());
        sb.append(", simulationUuid=");
        sb.append(getSimulationUuid());
        sb.append(", jobUuid=");
        sb.append(getJobUuid());
        sb.append(", inputId=");
        sb.append(getInputId());
        sb.append(", title=");
        sb.append(getTitle());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", status=");
        sb.append(getStatus());
        sb.append(", simulationStartDt=");
        sb.append(getSimulationStartDt());
        sb.append(", simulationEndDt=");
        sb.append(getSimulationEndDt());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(40);

        sb.append("<model><model-name>");
        sb.append("com.sdr.metadata.model.SimulationJob");
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
            "<column><column-name>inputId</column-name><column-value><![CDATA[");
        sb.append(getInputId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>title</column-name><column-value><![CDATA[");
        sb.append(getTitle());
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
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>groupId</column-name><column-value><![CDATA[");
        sb.append(getGroupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyId</column-name><column-value><![CDATA[");
        sb.append(getCompanyId());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
