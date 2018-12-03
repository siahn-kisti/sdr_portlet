package com.sdr.metadata.datatype;

import java.util.List;
import java.util.Map;

/**
 * The type Data type vo.
 */
public class DataTypeVo {

    private long dataTypeId;
    private String title;
    private String description;
    private String fileValidationRule;
    private boolean curateRequired;
    private String location;
    private long defaultPpLogicId;

    private Map<String, List<String>> schemaList;
    private Map<String, List<String>> viewList;
    private List<String> viewOrderList;
    private List<Map<String, String>> essentialList;

    /**
     * Gets default PpLogic Id
     *
     * @return
     */
    public long getDefaultPpLogicId() {
        return defaultPpLogicId;
    }

    /**
     * Sets default PpLogic Id
     *
     * @param defaultPpLogicId
     */
    public void setDefaultPpLogicId(long defaultPpLogicId) {
        this.defaultPpLogicId = defaultPpLogicId;
    }

    /**
     * Gets data type id.
     *
     * @return the data type id
     */
    public long getDataTypeId() {
        return dataTypeId;
    }

    /**
     * Sets data type id.
     *
     * @param dataTypeId the data type id
     */
    public void setDataTypeId(long dataTypeId) {
        this.dataTypeId = dataTypeId;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets file validation rule.
     *
     * @return the file validation rule
     */
    public String getFileValidationRule() {
        return fileValidationRule;
    }

    /**
     * Sets file validation rule.
     *
     * @param fileValidationRule the file validation rule
     */
    public void setFileValidationRule(String fileValidationRule) {
        this.fileValidationRule = fileValidationRule;
    }

    /**
     * Is curate required boolean.
     *
     * @return the boolean
     */
    public boolean isCurateRequired() {
        return curateRequired;
    }

    /**
     * Sets curate required.
     *
     * @param curateRequired the curate required
     */
    public void setCurateRequired(boolean curateRequired) {
        this.curateRequired = curateRequired;
    }

    /**
     * Gets location.
     *
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets location.
     *
     * @param location the location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Gets view list.
     *
     * @return the view list
     */
    public Map<String, List<String>> getViewList() {
        return viewList;
    }

    /**
     * Sets view list.
     *
     * @param viewList the view list
     */
    public void setViewList(Map<String, List<String>> viewList) {
        this.viewList = viewList;
    }

    /**
     * Gets view order list.
     *
     * @return the view order list
     */
    public List<String> getViewOrderList() {
        return viewOrderList;
    }

    /**
     * Sets view order list.
     *
     * @param viewOrderList the view order list
     */
    public void setViewOrderList(List<String> viewOrderList) {
        this.viewOrderList = viewOrderList;
    }

    public Map<String, List<String>> getSchemaList() {
        return schemaList;
    }

    public void setSchemaList(Map<String, List<String>> schemaList) {
        this.schemaList = schemaList;
    }

    public List<Map<String, String>> getEssentialList() {
        return essentialList;
    }

    public void setEssentialList(List<Map<String, String>> essentialList) {
        this.essentialList = essentialList;
    }
}
