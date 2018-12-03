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

import com.sdr.metadata.model.IceBreakerVcToken;
import com.sdr.metadata.model.IceBreakerVcTokenModel;
import com.sdr.metadata.model.IceBreakerVcTokenSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the IceBreakerVcToken service. Represents a row in the &quot;sdr_IceBreakerVcToken&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.sdr.metadata.model.IceBreakerVcTokenModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link IceBreakerVcTokenImpl}.
 * </p>
 *
 * @author jaesung
 * @see IceBreakerVcTokenImpl
 * @see com.sdr.metadata.model.IceBreakerVcToken
 * @see com.sdr.metadata.model.IceBreakerVcTokenModel
 * @generated
 */
@JSON(strict = true)
public class IceBreakerVcTokenModelImpl extends BaseModelImpl<IceBreakerVcToken>
    implements IceBreakerVcTokenModel {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a ice breaker vc token model instance should use the {@link com.sdr.metadata.model.IceBreakerVcToken} interface instead.
     */
    public static final String TABLE_NAME = "sdr_IceBreakerVcToken";
    public static final Object[][] TABLE_COLUMNS = {
            { "vcToken", Types.VARCHAR },
            { "vcTokenExpired", Types.TIMESTAMP },
            { "resultCode", Types.INTEGER },
            { "tokenId", Types.BIGINT },
            { "activate", Types.INTEGER }
        };
    public static final String TABLE_SQL_CREATE = "create table sdr_IceBreakerVcToken (vcToken VARCHAR(1000) null,vcTokenExpired DATE null,resultCode INTEGER,tokenId LONG not null primary key,activate INTEGER)";
    public static final String TABLE_SQL_DROP = "drop table sdr_IceBreakerVcToken";
    public static final String ORDER_BY_JPQL = " ORDER BY iceBreakerVcToken.tokenId ASC";
    public static final String ORDER_BY_SQL = " ORDER BY sdr_IceBreakerVcToken.tokenId ASC";
    public static final String DATA_SOURCE = "liferayDataSource";
    public static final String SESSION_FACTORY = "liferaySessionFactory";
    public static final String TX_MANAGER = "liferayTransactionManager";
    public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.entity.cache.enabled.com.sdr.metadata.model.IceBreakerVcToken"),
            true);
    public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.finder.cache.enabled.com.sdr.metadata.model.IceBreakerVcToken"),
            true);
    public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
                "value.object.column.bitmask.enabled.com.sdr.metadata.model.IceBreakerVcToken"),
            true);
    public static long ACTIVATE_COLUMN_BITMASK = 1L;
    public static long TOKENID_COLUMN_BITMASK = 2L;
    public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
                "lock.expiration.time.com.sdr.metadata.model.IceBreakerVcToken"));
    private static ClassLoader _classLoader = IceBreakerVcToken.class.getClassLoader();
    private static Class<?>[] _escapedModelInterfaces = new Class[] {
            IceBreakerVcToken.class
        };
    private String _vcToken;
    private Date _vcTokenExpired;
    private int _resultCode;
    private long _tokenId;
    private int _activate;
    private int _originalActivate;
    private boolean _setOriginalActivate;
    private long _columnBitmask;
    private IceBreakerVcToken _escapedModel;

    public IceBreakerVcTokenModelImpl() {
    }

    /**
     * Converts the soap model instance into a normal model instance.
     *
     * @param soapModel the soap model instance to convert
     * @return the normal model instance
     */
    public static IceBreakerVcToken toModel(IceBreakerVcTokenSoap soapModel) {
        if (soapModel == null) {
            return null;
        }

        IceBreakerVcToken model = new IceBreakerVcTokenImpl();

        model.setVcToken(soapModel.getVcToken());
        model.setVcTokenExpired(soapModel.getVcTokenExpired());
        model.setResultCode(soapModel.getResultCode());
        model.setTokenId(soapModel.getTokenId());
        model.setActivate(soapModel.getActivate());

        return model;
    }

    /**
     * Converts the soap model instances into normal model instances.
     *
     * @param soapModels the soap model instances to convert
     * @return the normal model instances
     */
    public static List<IceBreakerVcToken> toModels(
        IceBreakerVcTokenSoap[] soapModels) {
        if (soapModels == null) {
            return null;
        }

        List<IceBreakerVcToken> models = new ArrayList<IceBreakerVcToken>(soapModels.length);

        for (IceBreakerVcTokenSoap soapModel : soapModels) {
            models.add(toModel(soapModel));
        }

        return models;
    }

    @Override
    public long getPrimaryKey() {
        return _tokenId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setTokenId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _tokenId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Class<?> getModelClass() {
        return IceBreakerVcToken.class;
    }

    @Override
    public String getModelClassName() {
        return IceBreakerVcToken.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("vcToken", getVcToken());
        attributes.put("vcTokenExpired", getVcTokenExpired());
        attributes.put("resultCode", getResultCode());
        attributes.put("tokenId", getTokenId());
        attributes.put("activate", getActivate());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String vcToken = (String) attributes.get("vcToken");

        if (vcToken != null) {
            setVcToken(vcToken);
        }

        Date vcTokenExpired = (Date) attributes.get("vcTokenExpired");

        if (vcTokenExpired != null) {
            setVcTokenExpired(vcTokenExpired);
        }

        Integer resultCode = (Integer) attributes.get("resultCode");

        if (resultCode != null) {
            setResultCode(resultCode);
        }

        Long tokenId = (Long) attributes.get("tokenId");

        if (tokenId != null) {
            setTokenId(tokenId);
        }

        Integer activate = (Integer) attributes.get("activate");

        if (activate != null) {
            setActivate(activate);
        }
    }

    @JSON
    @Override
    public String getVcToken() {
        if (_vcToken == null) {
            return StringPool.BLANK;
        } else {
            return _vcToken;
        }
    }

    @Override
    public void setVcToken(String vcToken) {
        _vcToken = vcToken;
    }

    @JSON
    @Override
    public Date getVcTokenExpired() {
        return _vcTokenExpired;
    }

    @Override
    public void setVcTokenExpired(Date vcTokenExpired) {
        _vcTokenExpired = vcTokenExpired;
    }

    @JSON
    @Override
    public int getResultCode() {
        return _resultCode;
    }

    @Override
    public void setResultCode(int resultCode) {
        _resultCode = resultCode;
    }

    @JSON
    @Override
    public long getTokenId() {
        return _tokenId;
    }

    @Override
    public void setTokenId(long tokenId) {
        _tokenId = tokenId;
    }

    @JSON
    @Override
    public int getActivate() {
        return _activate;
    }

    @Override
    public void setActivate(int activate) {
        _columnBitmask |= ACTIVATE_COLUMN_BITMASK;

        if (!_setOriginalActivate) {
            _setOriginalActivate = true;

            _originalActivate = _activate;
        }

        _activate = activate;
    }

    public int getOriginalActivate() {
        return _originalActivate;
    }

    public long getColumnBitmask() {
        return _columnBitmask;
    }

    @Override
    public ExpandoBridge getExpandoBridge() {
        return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
            IceBreakerVcToken.class.getName(), getPrimaryKey());
    }

    @Override
    public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
        ExpandoBridge expandoBridge = getExpandoBridge();

        expandoBridge.setAttributes(serviceContext);
    }

    @Override
    public IceBreakerVcToken toEscapedModel() {
        if (_escapedModel == null) {
            _escapedModel = (IceBreakerVcToken) ProxyUtil.newProxyInstance(_classLoader,
                    _escapedModelInterfaces, new AutoEscapeBeanHandler(this));
        }

        return _escapedModel;
    }

    @Override
    public Object clone() {
        IceBreakerVcTokenImpl iceBreakerVcTokenImpl = new IceBreakerVcTokenImpl();

        iceBreakerVcTokenImpl.setVcToken(getVcToken());
        iceBreakerVcTokenImpl.setVcTokenExpired(getVcTokenExpired());
        iceBreakerVcTokenImpl.setResultCode(getResultCode());
        iceBreakerVcTokenImpl.setTokenId(getTokenId());
        iceBreakerVcTokenImpl.setActivate(getActivate());

        iceBreakerVcTokenImpl.resetOriginalValues();

        return iceBreakerVcTokenImpl;
    }

    @Override
    public int compareTo(IceBreakerVcToken iceBreakerVcToken) {
        long primaryKey = iceBreakerVcToken.getPrimaryKey();

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

        if (!(obj instanceof IceBreakerVcToken)) {
            return false;
        }

        IceBreakerVcToken iceBreakerVcToken = (IceBreakerVcToken) obj;

        long primaryKey = iceBreakerVcToken.getPrimaryKey();

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
        IceBreakerVcTokenModelImpl iceBreakerVcTokenModelImpl = this;

        iceBreakerVcTokenModelImpl._originalActivate = iceBreakerVcTokenModelImpl._activate;

        iceBreakerVcTokenModelImpl._setOriginalActivate = false;

        iceBreakerVcTokenModelImpl._columnBitmask = 0;
    }

    @Override
    public CacheModel<IceBreakerVcToken> toCacheModel() {
        IceBreakerVcTokenCacheModel iceBreakerVcTokenCacheModel = new IceBreakerVcTokenCacheModel();

        iceBreakerVcTokenCacheModel.vcToken = getVcToken();

        String vcToken = iceBreakerVcTokenCacheModel.vcToken;

        if ((vcToken != null) && (vcToken.length() == 0)) {
            iceBreakerVcTokenCacheModel.vcToken = null;
        }

        Date vcTokenExpired = getVcTokenExpired();

        if (vcTokenExpired != null) {
            iceBreakerVcTokenCacheModel.vcTokenExpired = vcTokenExpired.getTime();
        } else {
            iceBreakerVcTokenCacheModel.vcTokenExpired = Long.MIN_VALUE;
        }

        iceBreakerVcTokenCacheModel.resultCode = getResultCode();

        iceBreakerVcTokenCacheModel.tokenId = getTokenId();

        iceBreakerVcTokenCacheModel.activate = getActivate();

        return iceBreakerVcTokenCacheModel;
    }

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(11);

        sb.append("{vcToken=");
        sb.append(getVcToken());
        sb.append(", vcTokenExpired=");
        sb.append(getVcTokenExpired());
        sb.append(", resultCode=");
        sb.append(getResultCode());
        sb.append(", tokenId=");
        sb.append(getTokenId());
        sb.append(", activate=");
        sb.append(getActivate());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(19);

        sb.append("<model><model-name>");
        sb.append("com.sdr.metadata.model.IceBreakerVcToken");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>vcToken</column-name><column-value><![CDATA[");
        sb.append(getVcToken());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>vcTokenExpired</column-name><column-value><![CDATA[");
        sb.append(getVcTokenExpired());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>resultCode</column-name><column-value><![CDATA[");
        sb.append(getResultCode());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>tokenId</column-name><column-value><![CDATA[");
        sb.append(getTokenId());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>activate</column-name><column-value><![CDATA[");
        sb.append(getActivate());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}