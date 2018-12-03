package com.sdr.metadata.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.sdr.metadata.service.http.GroupRuleServiceSoap}.
 *
 * @author jaesung
 * @see com.sdr.metadata.service.http.GroupRuleServiceSoap
 * @generated
 */
public class GroupRuleSoap implements Serializable {
    private long _grId;
    private String _title;
    private String _description;
    private String _rule;
    private String _viewAttr;
    private String _mergeAttr;

    public GroupRuleSoap() {
    }

    public static GroupRuleSoap toSoapModel(GroupRule model) {
        GroupRuleSoap soapModel = new GroupRuleSoap();

        soapModel.setGrId(model.getGrId());
        soapModel.setTitle(model.getTitle());
        soapModel.setDescription(model.getDescription());
        soapModel.setRule(model.getRule());
        soapModel.setViewAttr(model.getViewAttr());
        soapModel.setMergeAttr(model.getMergeAttr());

        return soapModel;
    }

    public static GroupRuleSoap[] toSoapModels(GroupRule[] models) {
        GroupRuleSoap[] soapModels = new GroupRuleSoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static GroupRuleSoap[][] toSoapModels(GroupRule[][] models) {
        GroupRuleSoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new GroupRuleSoap[models.length][models[0].length];
        } else {
            soapModels = new GroupRuleSoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static GroupRuleSoap[] toSoapModels(List<GroupRule> models) {
        List<GroupRuleSoap> soapModels = new ArrayList<GroupRuleSoap>(models.size());

        for (GroupRule model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new GroupRuleSoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _grId;
    }

    public void setPrimaryKey(long pk) {
        setGrId(pk);
    }

    public long getGrId() {
        return _grId;
    }

    public void setGrId(long grId) {
        _grId = grId;
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

    public String getRule() {
        return _rule;
    }

    public void setRule(String rule) {
        _rule = rule;
    }

    public String getViewAttr() {
        return _viewAttr;
    }

    public void setViewAttr(String viewAttr) {
        _viewAttr = viewAttr;
    }

    public String getMergeAttr() {
        return _mergeAttr;
    }

    public void setMergeAttr(String mergeAttr) {
        _mergeAttr = mergeAttr;
    }
}
