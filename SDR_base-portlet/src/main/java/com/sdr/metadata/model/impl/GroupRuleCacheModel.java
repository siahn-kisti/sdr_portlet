package com.sdr.metadata.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sdr.metadata.model.GroupRule;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing GroupRule in entity cache.
 *
 * @author jaesung
 * @see GroupRule
 * @generated
 */
public class GroupRuleCacheModel implements CacheModel<GroupRule>,
    Externalizable {
    public long grId;
    public String title;
    public String description;
    public String rule;
    public String viewAttr;
    public String mergeAttr;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(13);

        sb.append("{grId=");
        sb.append(grId);
        sb.append(", title=");
        sb.append(title);
        sb.append(", description=");
        sb.append(description);
        sb.append(", rule=");
        sb.append(rule);
        sb.append(", viewAttr=");
        sb.append(viewAttr);
        sb.append(", mergeAttr=");
        sb.append(mergeAttr);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public GroupRule toEntityModel() {
        GroupRuleImpl groupRuleImpl = new GroupRuleImpl();

        groupRuleImpl.setGrId(grId);

        if (title == null) {
            groupRuleImpl.setTitle(StringPool.BLANK);
        } else {
            groupRuleImpl.setTitle(title);
        }

        if (description == null) {
            groupRuleImpl.setDescription(StringPool.BLANK);
        } else {
            groupRuleImpl.setDescription(description);
        }

        if (rule == null) {
            groupRuleImpl.setRule(StringPool.BLANK);
        } else {
            groupRuleImpl.setRule(rule);
        }

        if (viewAttr == null) {
            groupRuleImpl.setViewAttr(StringPool.BLANK);
        } else {
            groupRuleImpl.setViewAttr(viewAttr);
        }

        if (mergeAttr == null) {
            groupRuleImpl.setMergeAttr(StringPool.BLANK);
        } else {
            groupRuleImpl.setMergeAttr(mergeAttr);
        }

        groupRuleImpl.resetOriginalValues();

        return groupRuleImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        grId = objectInput.readLong();
        title = objectInput.readUTF();
        description = objectInput.readUTF();
        rule = objectInput.readUTF();
        viewAttr = objectInput.readUTF();
        mergeAttr = objectInput.readUTF();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        objectOutput.writeLong(grId);

        if (title == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(title);
        }

        if (description == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(description);
        }

        if (rule == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(rule);
        }

        if (viewAttr == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(viewAttr);
        }

        if (mergeAttr == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(mergeAttr);
        }
    }
}
