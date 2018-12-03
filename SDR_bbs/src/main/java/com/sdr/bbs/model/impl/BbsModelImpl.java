package com.sdr.bbs.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
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

import com.sdr.bbs.model.Bbs;
import com.sdr.bbs.model.BbsModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Bbs service. Represents a row in the &quot;sdr_bbs_Bbs&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.sdr.bbs.model.BbsModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link BbsImpl}.
 * </p>
 *
 * @author goopsw
 * @see BbsImpl
 * @see com.sdr.bbs.model.Bbs
 * @see com.sdr.bbs.model.BbsModel
 * @generated
 */
public class BbsModelImpl extends BaseModelImpl<Bbs> implements BbsModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a bbs model instance should use the {@link com.sdr.bbs.model.Bbs} interface instead.
     */
    public static final String TABLE_NAME = "sdr_bbs_Bbs";
    public static final Object[][] TABLE_COLUMNS = {
            { "uuid_", Types.VARCHAR },
            { "bbsId", Types.BIGINT },
            { "companyId", Types.BIGINT },
            { "groupId", Types.BIGINT },
            { "userId", Types.BIGINT },
            { "createDate", Types.TIMESTAMP },
            { "modifiedDate", Types.TIMESTAMP },
            { "title", Types.VARCHAR },
            { "displayType", Types.INTEGER }
        };
    public static final String TABLE_SQL_CREATE = "create table sdr_bbs_Bbs (uuid_ VARCHAR(75) null,bbsId LONG not null primary key,companyId LONG,groupId LONG,userId LONG,createDate DATE null,modifiedDate DATE null,title VARCHAR(75) null,displayType INTEGER)";
    public static final String TABLE_SQL_DROP = "drop table sdr_bbs_Bbs";
    public static final String ORDER_BY_JPQL = " ORDER BY bbs.bbsId DESC";
    public static final String ORDER_BY_SQL = " ORDER BY sdr_bbs_Bbs.bbsId DESC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.sdr.bbs.model.Bbs"), true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.sdr.bbs.model.Bbs"), true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.sdr.bbs.model.Bbs"),
            true);
    public static long COMPANYID_COLUMN_BITMASK = 1L;
    public static long GROUPID_COLUMN_BITMASK = 2L;
    public static long UUID_COLUMN_BITMASK = 4L;
    public static long BBSID_COLUMN_BITMASK = 8L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.sdr.bbs.model.Bbs"));
    private static ClassLoader _classLoader = Bbs.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] { Bbs.class };
    private String _uuid;
    private String _originalUuid;
    private long _bbsId;
    private long _companyId;
    private long _originalCompanyId;
    private boolean _setOriginalCompanyId;
    private long _groupId;
    private long _originalGroupId;
    private boolean _setOriginalGroupId;
    private long _userId;
    private String _userUuid;
    private Date _createDate;
    private Date _modifiedDate;
    private String _title;
    private int _displayType;
    private long _columnBitmask;
    private Bbs _escapedModel;

    public BbsModelImpl() {
    }

    @Override
    public long getPrimaryKey() {
        return _bbsId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setBbsId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _bbsId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Class<?> getModelClass() {
        return Bbs.class;
    }

    @Override
    public String getModelClassName() {
        return Bbs.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("uuid", getUuid());
        attributes.put("bbsId", getBbsId());
        attributes.put("companyId", getCompanyId());
        attributes.put("groupId", getGroupId());
        attributes.put("userId", getUserId());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("title", getTitle());
        attributes.put("displayType", getDisplayType());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String uuid = (String) attributes.get("uuid");

        if (uuid != null) {
            setUuid(uuid);
        }

        Long bbsId = (Long) attributes.get("bbsId");

        if (bbsId != null) {
            setBbsId(bbsId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Date modifiedDate = (Date) attributes.get("modifiedDate");

        if (modifiedDate != null) {
            setModifiedDate(modifiedDate);
        }

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        Integer displayType = (Integer) attributes.get("displayType");

        if (displayType != null) {
            setDisplayType(displayType);
        }
    }

    @Override
    public String getUuid() {
        if (_uuid == null) {
            return StringPool.BLANK;
        } else {
            return _uuid;
        }
    }

    @Override
    public void setUuid(String uuid) {
        if (_originalUuid == null) {
            _originalUuid = _uuid;
        }

        _uuid = uuid;
    }

    public String getOriginalUuid() {
        return GetterUtil.getString(_originalUuid);
    }

    @Override
    public long getBbsId() {
        return _bbsId;
    }

    @Override
    public void setBbsId(long bbsId) {
        _columnBitmask = -1L;

        _bbsId = bbsId;
    }

    @Override
    public long getCompanyId() {
        return _companyId;
    }

    @Override
    public void setCompanyId(long companyId) {
        _columnBitmask |= COMPANYID_COLUMN_BITMASK;

        if (!_setOriginalCompanyId) {
            _setOriginalCompanyId = true;

            _originalCompanyId = _companyId;
        }

        _companyId = companyId;
    }

    public long getOriginalCompanyId() {
        return _originalCompanyId;
    }

    @Override
    public long getGroupId() {
        return _groupId;
    }

    @Override
    public void setGroupId(long groupId) {
        _columnBitmask |= GROUPID_COLUMN_BITMASK;

        if (!_setOriginalGroupId) {
            _setOriginalGroupId = true;

            _originalGroupId = _groupId;
        }

        _groupId = groupId;
    }

    public long getOriginalGroupId() {
        return _originalGroupId;
    }

    @Override
    public long getUserId() {
        return _userId;
    }

    @Override
    public void setUserId(long userId) {
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

    @Override
    public Date getCreateDate() {
        return _createDate;
    }

    @Override
    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    @Override
    public Date getModifiedDate() {
        return _modifiedDate;
    }

    @Override
    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

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

    @Override
    public int getDisplayType() {
        return _displayType;
    }

    @Override
    public void setDisplayType(int displayType) {
        _displayType = displayType;
    }

    @Override
    public StagedModelType getStagedModelType() {
        return new StagedModelType(PortalUtil.getClassNameId(
                Bbs.class.getName()));
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
            Bbs.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public Bbs toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (Bbs) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        BbsImpl bbsImpl = new BbsImpl();

        bbsImpl.setUuid(getUuid());
        bbsImpl.setBbsId(getBbsId());
        bbsImpl.setCompanyId(getCompanyId());
        bbsImpl.setGroupId(getGroupId());
        bbsImpl.setUserId(getUserId());
        bbsImpl.setCreateDate(getCreateDate());
        bbsImpl.setModifiedDate(getModifiedDate());
        bbsImpl.setTitle(getTitle());
        bbsImpl.setDisplayType(getDisplayType());

        bbsImpl.resetOriginalValues();

        return bbsImpl;
    }

    @Override
    public int compareTo(Bbs bbs) {
        int value = 0;

        if (getBbsId() < bbs.getBbsId()) {
            value = -1;
        } else if (getBbsId() > bbs.getBbsId()) {
            value = 1;
        } else {
            value = 0;
        }

        value = value * -1;

        if (value != 0) {
            return value;
        }

        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Bbs)) {
            return false;
        }

        Bbs bbs = (Bbs) obj;

        long primaryKey = bbs.getPrimaryKey();

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
        BbsModelImpl bbsModelImpl = this;

        bbsModelImpl._originalUuid = bbsModelImpl._uuid;

        bbsModelImpl._originalCompanyId = bbsModelImpl._companyId;

        bbsModelImpl._setOriginalCompanyId = false;

        bbsModelImpl._originalGroupId = bbsModelImpl._groupId;

        bbsModelImpl._setOriginalGroupId = false;

        bbsModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<Bbs> toCacheModel() {
        BbsCacheModel bbsCacheModel = new BbsCacheModel();

        bbsCacheModel.uuid = getUuid();

        String uuid = bbsCacheModel.uuid;

        if ((uuid != null) && (uuid.length() == 0)) {
            bbsCacheModel.uuid = null;
        }

        bbsCacheModel.bbsId = getBbsId();

        bbsCacheModel.companyId = getCompanyId();

        bbsCacheModel.groupId = getGroupId();

        bbsCacheModel.userId = getUserId();

        Date createDate = getCreateDate();

        if (createDate != null) {
            bbsCacheModel.createDate = createDate.getTime();
        } else {
            bbsCacheModel.createDate = Long.MIN_VALUE;
        }

        Date modifiedDate = getModifiedDate();

        if (modifiedDate != null) {
            bbsCacheModel.modifiedDate = modifiedDate.getTime();
        } else {
            bbsCacheModel.modifiedDate = Long.MIN_VALUE;
        }

        bbsCacheModel.title = getTitle();

        String title = bbsCacheModel.title;

        if ((title != null) && (title.length() == 0)) {
            bbsCacheModel.title = null;
        }

        bbsCacheModel.displayType = getDisplayType();

        return bbsCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(19);

        sb.append("{uuid=");
        sb.append(getUuid());
        sb.append(", bbsId=");
        sb.append(getBbsId());
        sb.append(", companyId=");
        sb.append(getCompanyId());
        sb.append(", groupId=");
        sb.append(getGroupId());
        sb.append(", userId=");
        sb.append(getUserId());
        sb.append(", createDate=");
        sb.append(getCreateDate());
        sb.append(", modifiedDate=");
        sb.append(getModifiedDate());
        sb.append(", title=");
        sb.append(getTitle());
        sb.append(", displayType=");
        sb.append(getDisplayType());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(31);

        sb.append("<model><model-name>");
        sb.append("com.sdr.bbs.model.Bbs");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>uuid</column-name><column-value><![CDATA[");
        sb.append(getUuid());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>bbsId</column-name><column-value><![CDATA[");
        sb.append(getBbsId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>companyId</column-name><column-value><![CDATA[");
        sb.append(getCompanyId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>groupId</column-name><column-value><![CDATA[");
        sb.append(getGroupId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>userId</column-name><column-value><![CDATA[");
        sb.append(getUserId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>createDate</column-name><column-value><![CDATA[");
        sb.append(getCreateDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
        sb.append(getModifiedDate());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>title</column-name><column-value><![CDATA[");
        sb.append(getTitle());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>displayType</column-name><column-value><![CDATA[");
        sb.append(getDisplayType());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
