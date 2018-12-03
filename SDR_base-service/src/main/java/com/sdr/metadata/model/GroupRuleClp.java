package com.sdr.metadata.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.sdr.metadata.service.ClpSerializer;
import com.sdr.metadata.service.GroupRuleLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;


public class GroupRuleClp extends BaseModelImpl<GroupRule> implements GroupRule {
    private long _grId;
    private String _title;
    private String _description;
    private String _rule;
    private String _viewAttr;
    private String _mergeAttr;
    private BaseModel<?> _groupRuleRemoteModel;
    private Class<?> _clpSerializerClass = com.sdr.metadata.service.ClpSerializer.class;

    public GroupRuleClp() {
    }

    @Override
    public Class<?> getModelClass() {
        return GroupRule.class;
    }

    @Override
    public String getModelClassName() {
        return GroupRule.class.getName();
    }

    @Override
    public long getPrimaryKey() {
        return _grId;
    }

    @Override
    public void setPrimaryKey(long primaryKey) {
        setGrId(primaryKey);
    }

    @Override
    public Serializable getPrimaryKeyObj() {
        return _grId;
    }

    @Override
    public void setPrimaryKeyObj(Serializable primaryKeyObj) {
        setPrimaryKey(((Long) primaryKeyObj).longValue());
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("grId", getGrId());
        attributes.put("title", getTitle());
        attributes.put("description", getDescription());
        attributes.put("rule", getRule());
        attributes.put("viewAttr", getViewAttr());
        attributes.put("mergeAttr", getMergeAttr());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        Long grId = (Long) attributes.get("grId");

        if (grId != null) {
            setGrId(grId);
        }

        String title = (String) attributes.get("title");

        if (title != null) {
            setTitle(title);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        String rule = (String) attributes.get("rule");

        if (rule != null) {
            setRule(rule);
        }

        String viewAttr = (String) attributes.get("viewAttr");

        if (viewAttr != null) {
            setViewAttr(viewAttr);
        }

        String mergeAttr = (String) attributes.get("mergeAttr");

        if (mergeAttr != null) {
            setMergeAttr(mergeAttr);
        }
    }

    @Override
    public long getGrId() {
        return _grId;
    }

    @Override
    public void setGrId(long grId) {
        _grId = grId;

        if (_groupRuleRemoteModel != null) {
            try {
                Class<?> clazz = _groupRuleRemoteModel.getClass();

                Method method = clazz.getMethod("setGrId", long.class);

                method.invoke(_groupRuleRemoteModel, grId);
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

        if (_groupRuleRemoteModel != null) {
            try {
                Class<?> clazz = _groupRuleRemoteModel.getClass();

                Method method = clazz.getMethod("setTitle", String.class);

                method.invoke(_groupRuleRemoteModel, title);
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

        if (_groupRuleRemoteModel != null) {
            try {
                Class<?> clazz = _groupRuleRemoteModel.getClass();

                Method method = clazz.getMethod("setDescription", String.class);

                method.invoke(_groupRuleRemoteModel, description);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getRule() {
        return _rule;
    }

    @Override
    public void setRule(String rule) {
        _rule = rule;

        if (_groupRuleRemoteModel != null) {
            try {
                Class<?> clazz = _groupRuleRemoteModel.getClass();

                Method method = clazz.getMethod("setRule", String.class);

                method.invoke(_groupRuleRemoteModel, rule);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getViewAttr() {
        return _viewAttr;
    }

    @Override
    public void setViewAttr(String viewAttr) {
        _viewAttr = viewAttr;

        if (_groupRuleRemoteModel != null) {
            try {
                Class<?> clazz = _groupRuleRemoteModel.getClass();

                Method method = clazz.getMethod("setViewAttr", String.class);

                method.invoke(_groupRuleRemoteModel, viewAttr);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    @Override
    public String getMergeAttr() {
        return _mergeAttr;
    }

    @Override
    public void setMergeAttr(String mergeAttr) {
        _mergeAttr = mergeAttr;

        if (_groupRuleRemoteModel != null) {
            try {
                Class<?> clazz = _groupRuleRemoteModel.getClass();

                Method method = clazz.getMethod("setMergeAttr", String.class);

                method.invoke(_groupRuleRemoteModel, mergeAttr);
            } catch (Exception e) {
                throw new UnsupportedOperationException(e);
            }
        }
    }

    public BaseModel<?> getGroupRuleRemoteModel() {
        return _groupRuleRemoteModel;
    }

    public void setGroupRuleRemoteModel(BaseModel<?> groupRuleRemoteModel) {
        _groupRuleRemoteModel = groupRuleRemoteModel;
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

        Class<?> remoteModelClass = _groupRuleRemoteModel.getClass();

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

        Object returnValue = method.invoke(_groupRuleRemoteModel,
                remoteParameterValues);

        if (returnValue != null) {
            returnValue = ClpSerializer.translateOutput(returnValue);
        }

        return returnValue;
    }

    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            GroupRuleLocalServiceUtil.addGroupRule(this);
        } else {
            GroupRuleLocalServiceUtil.updateGroupRule(this);
        }
    }

    @Override
    public GroupRule toEscapedModel() {
        return (GroupRule) ProxyUtil.newProxyInstance(GroupRule.class.getClassLoader(),
            new Class[] { GroupRule.class }, new AutoEscapeBeanHandler(this));
    }

    @Override
    public Object clone() {
        GroupRuleClp clone = new GroupRuleClp();

        clone.setGrId(getGrId());
        clone.setTitle(getTitle());
        clone.setDescription(getDescription());
        clone.setRule(getRule());
        clone.setViewAttr(getViewAttr());
        clone.setMergeAttr(getMergeAttr());

        return clone;
    }

    @Override
    public int compareTo(GroupRule groupRule) {
        long primaryKey = groupRule.getPrimaryKey();

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

        if (!(obj instanceof GroupRuleClp)) {
            return false;
        }

        GroupRuleClp groupRule = (GroupRuleClp) obj;

        long primaryKey = groupRule.getPrimaryKey();

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
        StringBundler sb = new StringBundler(13);

        sb.append("{grId=");
        sb.append(getGrId());
        sb.append(", title=");
        sb.append(getTitle());
        sb.append(", description=");
        sb.append(getDescription());
        sb.append(", rule=");
        sb.append(getRule());
        sb.append(", viewAttr=");
        sb.append(getViewAttr());
        sb.append(", mergeAttr=");
        sb.append(getMergeAttr());
        sb.append("}");

        return sb.toString();
    }

    @Override
    public String toXmlString() {
        StringBundler sb = new StringBundler(22);

        sb.append("<model><model-name>");
        sb.append("com.sdr.metadata.model.GroupRule");
        sb.append("</model-name>");

        sb.append(
            "<column><column-name>grId</column-name><column-value><![CDATA[");
        sb.append(getGrId());
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
            "<column><column-name>rule</column-name><column-value><![CDATA[");
        sb.append(getRule());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>viewAttr</column-name><column-value><![CDATA[");
        sb.append(getViewAttr());
        sb.append("]]></column-value></column>");
        sb.append(
            "<column><column-name>mergeAttr</column-name><column-value><![CDATA[");
        sb.append(getMergeAttr());
        sb.append("]]></column-value></column>");

        sb.append("</model>");

        return sb.toString();
    }
}
