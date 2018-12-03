package com.sdr.metadata.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.sdr.metadata.model.CurationJob;
import com.sdr.metadata.model.CurationJobModel;
import com.sdr.metadata.model.CurationJobSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the CurationJob service. Represents a row in the &quot;sdr_CurationJob&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.sdr.metadata.model.CurationJobModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CurationJobImpl}.
 * </p>
 *
 * @author jaesung
 * @see CurationJobImpl
 * @see com.sdr.metadata.model.CurationJob
 * @see com.sdr.metadata.model.CurationJobModel
 * @generated
 */
@JSON(strict = true)
public class CurationJobModelImpl extends BaseModelImpl<CurationJob>
    implements CurationJobModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a curation job model instance should use the {@link com.sdr.metadata.model.CurationJob} interface instead.
     */
    public static final String TABLE_NAME = "sdr_CurationJob";
    public static final Object[][] TABLE_COLUMNS = {
            { "simulationId", Types.BIGINT },
            { "simulationUuid", Types.VARCHAR },
            { "jobUuid", Types.VARCHAR },
            { "description", Types.VARCHAR },
            { "status", Types.VARCHAR },
            { "simulationStartDt", Types.TIMESTAMP },
            { "simulationEndDt", Types.TIMESTAMP }
        };
    public static final String TABLE_SQL_CREATE = "create table sdr_CurationJob (simulationId LONG not null primary key,simulationUuid VARCHAR(75) null,jobUuid VARCHAR(75) null,description VARCHAR(75) null,status VARCHAR(75) null,simulationStartDt DATE null,simulationEndDt DATE null)";
    public static final String TABLE_SQL_DROP = "drop table sdr_CurationJob";
    public static final String ORDER_BY_JPQL = " ORDER BY curationJob.simulationId ASC";
    public static final String ORDER_BY_SQL = " ORDER BY sdr_CurationJob.simulationId ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.sdr.metadata.model.CurationJob"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.sdr.metadata.model.CurationJob"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = false;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.sdr.metadata.model.CurationJob"));
    private static ClassLoader _classLoader = CurationJob.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            CurationJob.class
        };
    private long _simulationId;
    private String _simulationUuid;
    private String _jobUuid;
    private String _description;
    private String _status;
    private Date _simulationStartDt;
    private Date _simulationEndDt;
    private CurationJob _escapedModel;

    public CurationJobModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static CurationJob toModel(CurationJobSoap soapModel) {
        if (soapModel == null) {
            return null;
        }

        CurationJob model = new CurationJobImpl();

        model.setSimulationId(soapModel.getSimulationId());
        model.setSimulationUuid(soapModel.getSimulationUuid());
        model.setJobUuid(soapModel.getJobUuid());
        model.setDescription(soapModel.getDescription());
        model.setStatus(soapModel.getStatus());
        model.setSimulationStartDt(soapModel.getSimulationStartDt());
        model.setSimulationEndDt(soapModel.getSimulationEndDt());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<CurationJob> toModels(CurationJobSoap[] soapModels) {
        if (soapModels == null) {
            return null;
        }

        List<CurationJob> models = new ArrayList<CurationJob>(soapModels.length);

        for (CurationJobSoap soapModel : soapModels) {
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
        _simulationUuid = simulationUuid;
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
        _jobUuid = jobUuid;
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

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
            CurationJob.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public CurationJob toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (CurationJob) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        CurationJobImpl curationJobImpl = new CurationJobImpl();

        curationJobImpl.setSimulationId(getSimulationId());
        curationJobImpl.setSimulationUuid(getSimulationUuid());
        curationJobImpl.setJobUuid(getJobUuid());
        curationJobImpl.setDescription(getDescription());
        curationJobImpl.setStatus(getStatus());
        curationJobImpl.setSimulationStartDt(getSimulationStartDt());
        curationJobImpl.setSimulationEndDt(getSimulationEndDt());

        curationJobImpl.resetOriginalValues();

        return curationJobImpl;
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

        if (!(obj instanceof CurationJob)) {
            return false;
        }

        CurationJob curationJob = (CurationJob) obj;

        long primaryKey = curationJob.getPrimaryKey();

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
    }

    @Override
    public CacheModel<CurationJob> toCacheModel() {
        CurationJobCacheModel curationJobCacheModel = new CurationJobCacheModel();

        curationJobCacheModel.simulationId = getSimulationId();

        curationJobCacheModel.simulationUuid = getSimulationUuid();

        String simulationUuid = curationJobCacheModel.simulationUuid;

        if ((simulationUuid != null) && (simulationUuid.length() == 0)) {
            curationJobCacheModel.simulationUuid = null;
        }

        curationJobCacheModel.jobUuid = getJobUuid();

        String jobUuid = curationJobCacheModel.jobUuid;

        if ((jobUuid != null) && (jobUuid.length() == 0)) {
            curationJobCacheModel.jobUuid = null;
        }

        curationJobCacheModel.description = getDescription();

        String description = curationJobCacheModel.description;

        if ((description != null) && (description.length() == 0)) {
            curationJobCacheModel.description = null;
        }

        curationJobCacheModel.status = getStatus();

        String status = curationJobCacheModel.status;

        if ((status != null) && (status.length() == 0)) {
            curationJobCacheModel.status = null;
        }

        Date simulationStartDt = getSimulationStartDt();

        if (simulationStartDt != null) {
            curationJobCacheModel.simulationStartDt = simulationStartDt.getTime();
        } else {
            curationJobCacheModel.simulationStartDt = Long.MIN_VALUE;
        }

        Date simulationEndDt = getSimulationEndDt();

        if (simulationEndDt != null) {
            curationJobCacheModel.simulationEndDt = simulationEndDt.getTime();
        } else {
            curationJobCacheModel.simulationEndDt = Long.MIN_VALUE;
        }

        return curationJobCacheModel;
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