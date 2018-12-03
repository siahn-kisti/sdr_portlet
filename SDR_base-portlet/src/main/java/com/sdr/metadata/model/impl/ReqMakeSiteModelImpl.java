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

import com.sdr.metadata.model.ReqMakeSite;
import com.sdr.metadata.model.ReqMakeSiteModel;
import com.sdr.metadata.model.ReqMakeSiteSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the ReqMakeSite service. Represents a row in the &quot;sdr_ReqMakeSite&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.sdr.metadata.model.ReqMakeSiteModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ReqMakeSiteImpl}.
 * </p>
 *
 * @author jaesung
 * @see ReqMakeSiteImpl
 * @see com.sdr.metadata.model.ReqMakeSite
 * @see com.sdr.metadata.model.ReqMakeSiteModel
 * @generated
 */
@JSON(strict = true)
public class ReqMakeSiteModelImpl extends BaseModelImpl<ReqMakeSite>
    implements ReqMakeSiteModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a req make site model instance should use the {@link com.sdr.metadata.model.ReqMakeSite} interface instead.
     */
    public static final String TABLE_NAME = "sdr_ReqMakeSite";
    public static final Object[][] TABLE_COLUMNS = {
            { "requestId", Types.BIGINT },
            { "name", Types.VARCHAR },
            { "description", Types.VARCHAR },
            { "siteType", Types.BIGINT },
            { "userId", Types.BIGINT },
            { "requestDate", Types.TIMESTAMP },
            { "confirmDate", Types.TIMESTAMP },
            { "message", Types.VARCHAR },
            { "status", Types.BIGINT },
            { "answer", Types.VARCHAR }
        };
    public static final String TABLE_SQL_CREATE = "create table sdr_ReqMakeSite (requestId LONG not null primary key,name VARCHAR(75) null,description VARCHAR(2000) null,siteType LONG,userId LONG,requestDate DATE null,confirmDate DATE null,message VARCHAR(2000) null,status LONG,answer VARCHAR(2000) null)";
    public static final String TABLE_SQL_DROP = "drop table sdr_ReqMakeSite";
    public static final String ORDER_BY_JPQL = " ORDER BY reqMakeSite.requestId ASC";
    public static final String ORDER_BY_SQL = " ORDER BY sdr_ReqMakeSite.requestId ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.sdr.metadata.model.ReqMakeSite"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.sdr.metadata.model.ReqMakeSite"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.sdr.metadata.model.ReqMakeSite"),
            true);
    public static long USERID_COLUMN_BITMASK = 1L;
    public static long REQUESTID_COLUMN_BITMASK = 2L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.sdr.metadata.model.ReqMakeSite"));
    private static ClassLoader _classLoader = ReqMakeSite.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            ReqMakeSite.class
        };
    private long _requestId;
    private String _name;
    private String _description;
    private long _siteType;
    private long _userId;
    private String _userUuid;
    private long _originalUserId;
    private boolean _setOriginalUserId;
    private Date _requestDate;
    private Date _confirmDate;
    private String _message;
    private long _status;
    private String _answer;
    private long _columnBitmask;
    private ReqMakeSite _escapedModel;

    public ReqMakeSiteModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static ReqMakeSite toModel(ReqMakeSiteSoap soapModel) {
        if (soapModel == null) {
            return null;
        }

        ReqMakeSite model = new ReqMakeSiteImpl();

        model.setRequestId(soapModel.getRequestId());
        model.setName(soapModel.getName());
        model.setDescription(soapModel.getDescription());
        model.setSiteType(soapModel.getSiteType());
        model.setUserId(soapModel.getUserId());
        model.setRequestDate(soapModel.getRequestDate());
        model.setConfirmDate(soapModel.getConfirmDate());
        model.setMessage(soapModel.getMessage());
        model.setStatus(soapModel.getStatus());
        model.setAnswer(soapModel.getAnswer());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<ReqMakeSite> toModels(ReqMakeSiteSoap[] soapModels) {
        if (soapModels == null) {
            return null;
        }

        List<ReqMakeSite> models = new ArrayList<ReqMakeSite>(soapModels.length);

        for (ReqMakeSiteSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    @Override
    public long getPrimaryKey() {
        return _requestId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setRequestId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _requestId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Class<?> getModelClass() {
        return ReqMakeSite.class;
    }

    @Override
    public String getModelClassName() {
        return ReqMakeSite.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("requestId", getRequestId());
        attributes.put("name", getName());
        attributes.put("description", getDescription());
        attributes.put("siteType", getSiteType());
        attributes.put("userId", getUserId());
        attributes.put("requestDate", getRequestDate());
        attributes.put("confirmDate", getConfirmDate());
        attributes.put("message", getMessage());
        attributes.put("status", getStatus());
        attributes.put("answer", getAnswer());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long requestId = (Long) attributes.get("requestId");

        if (requestId != null) {
            setRequestId(requestId);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        Long siteType = (Long) attributes.get("siteType");

        if (siteType != null) {
            setSiteType(siteType);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        Date requestDate = (Date) attributes.get("requestDate");

        if (requestDate != null) {
            setRequestDate(requestDate);
        }

        Date confirmDate = (Date) attributes.get("confirmDate");

        if (confirmDate != null) {
            setConfirmDate(confirmDate);
        }

        String message = (String) attributes.get("message");

        if (message != null) {
            setMessage(message);
        }

        Long status = (Long) attributes.get("status");

        if (status != null) {
            setStatus(status);
        }

        String answer = (String) attributes.get("answer");

        if (answer != null) {
            setAnswer(answer);
        }
    }

    @JSON
    @Override
    public long getRequestId() {
        return _requestId;
    }

    @Override
    public void setRequestId(long requestId) {
        _requestId = requestId;
    }

    @JSON
    @Override
    public String getName() {
        if (_name == null) {
            return StringPool.BLANK;
        } else {
            return _name;
        }
    }

    @Override
    public void setName(String name) {
        _name = name;
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
    public long getSiteType() {
        return _siteType;
    }

    @Override
    public void setSiteType(long siteType) {
        _siteType = siteType;
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
    public Date getRequestDate() {
        return _requestDate;
    }

    @Override
    public void setRequestDate(Date requestDate) {
        _requestDate = requestDate;
    }

    @JSON
    @Override
    public Date getConfirmDate() {
        return _confirmDate;
    }

    @Override
    public void setConfirmDate(Date confirmDate) {
        _confirmDate = confirmDate;
    }

    @JSON
    @Override
    public String getMessage() {
        if (_message == null) {
            return StringPool.BLANK;
        } else {
            return _message;
        }
    }

    @Override
    public void setMessage(String message) {
        _message = message;
    }

    @JSON
    @Override
    public long getStatus() {
        return _status;
    }

    @Override
    public void setStatus(long status) {
        _status = status;
    }

    @JSON
    @Override
    public String getAnswer() {
        if (_answer == null) {
            return StringPool.BLANK;
        } else {
            return _answer;
        }
    }

    @Override
    public void setAnswer(String answer) {
        _answer = answer;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
            ReqMakeSite.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public ReqMakeSite toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (ReqMakeSite) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        ReqMakeSiteImpl reqMakeSiteImpl = new ReqMakeSiteImpl();

        reqMakeSiteImpl.setRequestId(getRequestId());
        reqMakeSiteImpl.setName(getName());
        reqMakeSiteImpl.setDescription(getDescription());
        reqMakeSiteImpl.setSiteType(getSiteType());
        reqMakeSiteImpl.setUserId(getUserId());
        reqMakeSiteImpl.setRequestDate(getRequestDate());
        reqMakeSiteImpl.setConfirmDate(getConfirmDate());
        reqMakeSiteImpl.setMessage(getMessage());
        reqMakeSiteImpl.setStatus(getStatus());
        reqMakeSiteImpl.setAnswer(getAnswer());

        reqMakeSiteImpl.resetOriginalValues();

        return reqMakeSiteImpl;
    }

    @Override
    public int compareTo(ReqMakeSite reqMakeSite) {
        long primaryKey = reqMakeSite.getPrimaryKey();

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

        if (!(obj instanceof ReqMakeSite)) {
            return false;
        }

        ReqMakeSite reqMakeSite = (ReqMakeSite) obj;

        long primaryKey = reqMakeSite.getPrimaryKey();

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
        ReqMakeSiteModelImpl reqMakeSiteModelImpl = this;

        reqMakeSiteModelImpl._originalUserId = reqMakeSiteModelImpl._userId;

        reqMakeSiteModelImpl._setOriginalUserId = false;

        reqMakeSiteModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<ReqMakeSite> toCacheModel() {
        ReqMakeSiteCacheModel reqMakeSiteCacheModel = new ReqMakeSiteCacheModel();

        reqMakeSiteCacheModel.requestId = getRequestId();

        reqMakeSiteCacheModel.name = getName();

        String name = reqMakeSiteCacheModel.name;

        if ((name != null) && (name.length() == 0)) {
            reqMakeSiteCacheModel.name = null;
        }

        reqMakeSiteCacheModel.description = getDescription();

        String description = reqMakeSiteCacheModel.description;

        if ((description != null) && (description.length() == 0)) {
            reqMakeSiteCacheModel.description = null;
        }

        reqMakeSiteCacheModel.siteType = getSiteType();

        reqMakeSiteCacheModel.userId = getUserId();

        Date requestDate = getRequestDate();

        if (requestDate != null) {
            reqMakeSiteCacheModel.requestDate = requestDate.getTime();
        } else {
            reqMakeSiteCacheModel.requestDate = Long.MIN_VALUE;
        }

        Date confirmDate = getConfirmDate();

        if (confirmDate != null) {
            reqMakeSiteCacheModel.confirmDate = confirmDate.getTime();
        } else {
            reqMakeSiteCacheModel.confirmDate = Long.MIN_VALUE;
        }

        reqMakeSiteCacheModel.message = getMessage();

        String message = reqMakeSiteCacheModel.message;

        if ((message != null) && (message.length() == 0)) {
            reqMakeSiteCacheModel.message = null;
        }

        reqMakeSiteCacheModel.status = getStatus();

        reqMakeSiteCacheModel.answer = getAnswer();

        String answer = reqMakeSiteCacheModel.answer;

        if ((answer != null) && (answer.length() == 0)) {
            reqMakeSiteCacheModel.answer = null;
        }

        return reqMakeSiteCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(21);

        sb.append("{requestId=");
        sb.append(getRequestId());
        sb.append(", name=");
        sb.append(getName());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", siteType=");
        sb.append(getSiteType());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", requestDate=");
        sb.append(getRequestDate());
        sb.append(", confirmDate=");
        sb.append(getConfirmDate());
        sb.append(", message=");
        sb.append(getMessage());
        sb.append(", status=");
        sb.append(getStatus());
        sb.append(", answer=");
        sb.append(getAnswer());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(34);

        sb.append("<model><model-name>");
        sb.append("com.sdr.metadata.model.ReqMakeSite");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>requestId</column-name><column-value><![CDATA[");
        sb.append(getRequestId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>name</column-name><column-value><![CDATA[");
        sb.append(getName());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>description</column-name><column-value><![CDATA[");
        sb.append(getDescription());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>siteType</column-name><column-value><![CDATA[");
        sb.append(getSiteType());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>requestDate</column-name><column-value><![CDATA[");
        sb.append(getRequestDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>confirmDate</column-name><column-value><![CDATA[");
        sb.append(getConfirmDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>message</column-name><column-value><![CDATA[");
        sb.append(getMessage());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>status</column-name><column-value><![CDATA[");
        sb.append(getStatus());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>answer</column-name><column-value><![CDATA[");
        sb.append(getAnswer());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
