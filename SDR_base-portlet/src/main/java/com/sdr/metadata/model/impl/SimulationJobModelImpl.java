package com.sdr.metadata.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.sdr.metadata.model.SimulationJob;
import com.sdr.metadata.model.SimulationJobModel;
import com.sdr.metadata.model.SimulationJobSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the SimulationJob service. Represents a row in the &quot;sdr_SimulationJob&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.sdr.metadata.model.SimulationJobModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SimulationJobImpl}.
 * </p>
 *
 * @author jaesung
 * @see SimulationJobImpl
 * @see com.sdr.metadata.model.SimulationJob
 * @see com.sdr.metadata.model.SimulationJobModel
 * @generated
 */
@JSON(strict = true)
public class SimulationJobModelImpl extends BaseModelImpl<SimulationJob>
    implements SimulationJobModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a simulation job model instance should use the {@link com.sdr.metadata.model.SimulationJob} interface instead.
     */
    public static final String TABLE_NAME = "sdr_SimulationJob";
    public static final Object[][] TABLE_COLUMNS = {
            { "simulationId", Types.BIGINT },
            { "simulationUuid", Types.VARCHAR },
            { "jobUuid", Types.VARCHAR },
            { "inputId", Types.VARCHAR },
            { "title", Types.VARCHAR },
            { "description", Types.VARCHAR },
            { "status", Types.VARCHAR },
            { "simulationStartDt", Types.TIMESTAMP },
            { "simulationEndDt", Types.TIMESTAMP },
            { "userId", Types.BIGINT },
            { "groupId", Types.BIGINT },
            { "companyId", Types.BIGINT }
        };
    public static final String TABLE_SQL_CREATE = "create table sdr_SimulationJob (simulationId LONG not null primary key,simulationUuid VARCHAR(2000) null,jobUuid VARCHAR(2000) null,inputId VARCHAR(2000) null,title VARCHAR(75) null,description VARCHAR(2000) null,status VARCHAR(75) null,simulationStartDt DATE null,simulationEndDt DATE null,userId LONG,groupId LONG,companyId LONG)";
    public static final String TABLE_SQL_DROP = "drop table sdr_SimulationJob";
    public static final String ORDER_BY_JPQL = " ORDER BY simulationJob.simulationId ASC";
    public static final String ORDER_BY_SQL = " ORDER BY sdr_SimulationJob.simulationId ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.sdr.metadata.model.SimulationJob"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.sdr.metadata.model.SimulationJob"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.sdr.metadata.model.SimulationJob"),
            true);
    public static long JOBUUID_COLUMN_BITMASK = 1L;
    public static long SIMULATIONUUID_COLUMN_BITMASK = 2L;
    public static long USERID_COLUMN_BITMASK = 4L;
    public static long SIMULATIONID_COLUMN_BITMASK = 8L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.sdr.metadata.model.SimulationJob"));
    private static ClassLoader _classLoader = SimulationJob.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            SimulationJob.class
        };
    private long _simulationId;
    private String _simulationUuid;
    private String _originalSimulationUuid;
    private String _jobUuid;
    private String _originalJobUuid;
    private String _inputId;
    private String _title;
    private String _description;
    private String _status;
    private Date _simulationStartDt;
    private Date _simulationEndDt;
    private long _userId;
    private String _userUuid;
    private long _originalUserId;
    private boolean _setOriginalUserId;
    private long _groupId;
    private long _companyId;
    private long _columnBitmask;
    private SimulationJob _escapedModel;

    public SimulationJobModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static SimulationJob toModel(SimulationJobSoap soapModel) {
        if (soapModel == null) {
            return null;
        }

        SimulationJob model = new SimulationJobImpl();

        model.setSimulationId(soapModel.getSimulationId());
        model.setSimulationUuid(soapModel.getSimulationUuid());
        model.setJobUuid(soapModel.getJobUuid());
        model.setInputId(soapModel.getInputId());
        model.setTitle(soapModel.getTitle());
        model.setDescription(soapModel.getDescription());
        model.setStatus(soapModel.getStatus());
        model.setSimulationStartDt(soapModel.getSimulationStartDt());
        model.setSimulationEndDt(soapModel.getSimulationEndDt());
        model.setUserId(soapModel.getUserId());
        model.setGroupId(soapModel.getGroupId());
        model.setCompanyId(soapModel.getCompanyId());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<SimulationJob> toModels(SimulationJobSoap[] soapModels) {
        if (soapModels == null) {
            return null;
        }

        List<SimulationJob> models = new ArrayList<SimulationJob>(soapModels.length);

        for (SimulationJobSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
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

    @JSON
    @Override
    public long getSimulationId() {
        return _simulationId;
    }

    @Override
    public void setSimulationId(long simulationId) {
        _simulationId = simulationId;
    }

    @JSON
    @Override
    public String getSimulationUuid() {
        if (_simulationUuid == null) {
            return StringPool.BLANK;
        } else {
            return _simulationUuid;
        }
    }

    @Override
    public void setSimulationUuid(String simulationUuid) {
        _columnBitmask |= SIMULATIONUUID_COLUMN_BITMASK;

        if (_originalSimulationUuid == null) {
            _originalSimulationUuid = _simulationUuid;
        }

        _simulationUuid = simulationUuid;
    }

    public String getOriginalSimulationUuid() {
        return GetterUtil.getString(_originalSimulationUuid);
    }

    @JSON
    @Override
    public String getJobUuid() {
        if (_jobUuid == null) {
            return StringPool.BLANK;
        } else {
            return _jobUuid;
        }
    }

    @Override
    public void setJobUuid(String jobUuid) {
        _columnBitmask |= JOBUUID_COLUMN_BITMASK;

        if (_originalJobUuid == null) {
            _originalJobUuid = _jobUuid;
        }

        _jobUuid = jobUuid;
    }

    public String getOriginalJobUuid() {
        return GetterUtil.getString(_originalJobUuid);
    }

    @JSON
    @Override
    public String getInputId() {
        if (_inputId == null) {
            return StringPool.BLANK;
        } else {
            return _inputId;
        }
    }

    @Override
    public void setInputId(String inputId) {
        _inputId = inputId;
    }

    @JSON
    @Override
    public String getTitle() {
        if (_title == null) {
            return StringPool.BLANK;
        } else {
            return _title;
        }
    }

    @Override
    public void setTitle(String title) {
        _title = title;
    }

    @JSON
    @Override
    public String getDescription() {
        if (_description == null) {
            return StringPool.BLANK;
        } else {
            return _description;
        }
    }

    @Override
    public void setDescription(String description) {
        _description = description;
    }

    @JSON
    @Override
    public String getStatus() {
        if (_status == null) {
            return StringPool.BLANK;
        } else {
            return _status;
        }
    }

    @Override
    public void setStatus(String status) {
        _status = status;
    }

    @JSON
    @Override
    public Date getSimulationStartDt() {
        return _simulationStartDt;
    }

    @Override
    public void setSimulationStartDt(Date simulationStartDt) {
        _simulationStartDt = simulationStartDt;
    }

    @JSON
    @Override
    public Date getSimulationEndDt() {
        return _simulationEndDt;
    }

    @Override
    public void setSimulationEndDt(Date simulationEndDt) {
        _simulationEndDt = simulationEndDt;
    }

    @JSON
    @Override
    public long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(long userId) {
        _columnBitmask |= USERID_COLUMN_BITMASK;

        if (!_setOriginalUserId) {
            _setOriginalUserId = true;

            _originalUserId = _userId;
        }

        _userId = userId;
    }

    @Override
    public String getUserUuid() throws SystemException {
        return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
    }

    @Override
    public void setUserUuid(String userUuid) {
        _userUuid = userUuid;
    }

    public long getOriginalUserId() {
        return _originalUserId;
    }

    @JSON
    @Override
    public long getGroupId() {
        return _groupId;
    }

    @Override
    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    @JSON
    @Override
    public long getCompanyId() {
        return _companyId;
    }

    @Override
    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
            SimulationJob.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public SimulationJob toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (SimulationJob) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        SimulationJobImpl simulationJobImpl = new SimulationJobImpl();

        simulationJobImpl.setSimulationId(getSimulationId());
        simulationJobImpl.setSimulationUuid(getSimulationUuid());
        simulationJobImpl.setJobUuid(getJobUuid());
        simulationJobImpl.setInputId(getInputId());
        simulationJobImpl.setTitle(getTitle());
        simulationJobImpl.setDescription(getDescription());
        simulationJobImpl.setStatus(getStatus());
        simulationJobImpl.setSimulationStartDt(getSimulationStartDt());
        simulationJobImpl.setSimulationEndDt(getSimulationEndDt());
        simulationJobImpl.setUserId(getUserId());
        simulationJobImpl.setGroupId(getGroupId());
        simulationJobImpl.setCompanyId(getCompanyId());

        simulationJobImpl.resetOriginalValues();

        return simulationJobImpl;
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

        if (!(obj instanceof SimulationJob)) {
            return false;
        }

        SimulationJob simulationJob = (SimulationJob) obj;

        long primaryKey = simulationJob.getPrimaryKey();

        if (getPrimaryKey() == primaryKey) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return (int) getPrimaryKey();
    }

    @Override
    public void resetOriginalValues() {
        SimulationJobModelImpl simulationJobModelImpl = this;

        simulationJobModelImpl._originalSimulationUuid = simulationJobModelImpl._simulationUuid;

        simulationJobModelImpl._originalJobUuid = simulationJobModelImpl._jobUuid;

        simulationJobModelImpl._originalUserId = simulationJobModelImpl._userId;

        simulationJobModelImpl._setOriginalUserId = false;

        simulationJobModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<SimulationJob> toCacheModel() {
        SimulationJobCacheModel simulationJobCacheModel = new SimulationJobCacheModel();

        simulationJobCacheModel.simulationId = getSimulationId();

        simulationJobCacheModel.simulationUuid = getSimulationUuid();

        String simulationUuid = simulationJobCacheModel.simulationUuid;

        if ((simulationUuid != null) && (simulationUuid.length() == 0)) {
            simulationJobCacheModel.simulationUuid = null;
        }

        simulationJobCacheModel.jobUuid = getJobUuid();

        String jobUuid = simulationJobCacheModel.jobUuid;

        if ((jobUuid != null) && (jobUuid.length() == 0)) {
            simulationJobCacheModel.jobUuid = null;
        }

        simulationJobCacheModel.inputId = getInputId();

        String inputId = simulationJobCacheModel.inputId;

        if ((inputId != null) && (inputId.length() == 0)) {
            simulationJobCacheModel.inputId = null;
        }

        simulationJobCacheModel.title = getTitle();

        String title = simulationJobCacheModel.title;

        if ((title != null) && (title.length() == 0)) {
            simulationJobCacheModel.title = null;
        }

        simulationJobCacheModel.description = getDescription();

        String description = simulationJobCacheModel.description;

        if ((description != null) && (description.length() == 0)) {
            simulationJobCacheModel.description = null;
        }

        simulationJobCacheModel.status = getStatus();

        String status = simulationJobCacheModel.status;

        if ((status != null) && (status.length() == 0)) {
            simulationJobCacheModel.status = null;
        }

        Date simulationStartDt = getSimulationStartDt();

        if (simulationStartDt != null) {
            simulationJobCacheModel.simulationStartDt = simulationStartDt.getTime();
        } else {
            simulationJobCacheModel.simulationStartDt = Long.MIN_VALUE;
        }

        Date simulationEndDt = getSimulationEndDt();

        if (simulationEndDt != null) {
            simulationJobCacheModel.simulationEndDt = simulationEndDt.getTime();
        } else {
            simulationJobCacheModel.simulationEndDt = Long.MIN_VALUE;
        }

        simulationJobCacheModel.userId = getUserId();

        simulationJobCacheModel.groupId = getGroupId();

        simulationJobCacheModel.companyId = getCompanyId();

        return simulationJobCacheModel;
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
