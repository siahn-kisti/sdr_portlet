package com.sdr.metadata.datatype;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * The type Data type schema vo.
 */
public class DataTypeSchemaVo {

    private long dataTypeSchemaId;
    private long dataTypeId;
    private String title;
    private String reference;
    private String variableType;
    private String variableUnit;
    private boolean essential;
    private Double minimum;
    private Double maximum;
    private String enums;
    private String pattern;
    private String description;
    private int status;

    public static TypeAdapter<Double> doubleTypeAdapter = new TypeAdapter<Double>() {

        @Override
        public void write(JsonWriter out, Double value)
                throws IOException {
            out.value(value);
        }

        @Override
        public Double read(JsonReader in) throws IOException {
            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                return null;
            }
            try {
                String result = in.nextString();
                if ("".equals(result)) {
                    return null;
                }
                return Double.parseDouble(result);
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(e);
            }
        }
    };


    /**
     * Gets data type schema id.
     *
     * @return the data type schema id
     */
    public long getDataTypeSchemaId() {
        return dataTypeSchemaId;
    }

    /**
     * Sets data type schema id.
     *
     * @param dataTypeSchemaId the data type schema id
     */
    public void setDataTypeSchemaId(long dataTypeSchemaId) {
        this.dataTypeSchemaId = dataTypeSchemaId;
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
     * Gets reference.
     *
     * @return the reference
     */
    public String getReference() {
        return reference;
    }

    /**
     * Sets reference.
     *
     * @param reference the reference
     */
    public void setReference(String reference) {
        this.reference = reference;
    }

    /**
     * Gets variable type.
     *
     * @return the variable type
     */
    public String getVariableType() {
        return variableType;
    }

    /**
     * Sets variable type.
     *
     * @param variableType the variable type
     */
    public void setVariableType(String variableType) {
        this.variableType = variableType;
    }

    /**
     * Gets variable unit.
     *
     * @return the variable unit
     */
    public String getVariableUnit() {
        return variableUnit;
    }

    /**
     * Sets variable unit.
     *
     * @param variableUnit the variable unit
     */
    public void setVariableUnit(String variableUnit) {
        this.variableUnit = variableUnit;
    }

    /**
     * Gets essential.
     *
     * @return the essential
     */
    public boolean getEssential() {
        return essential;
    }

    /**
     * Sets essential.
     *
     * @param essential the essential
     */
    public void setEssential(boolean essential) {
        this.essential = essential;
    }

    /**
     * Gets minimum.
     *
     * @return the minimum
     */
    public Double getMinimum() {
        return minimum;
    }

    /**
     * Sets minimum.
     *
     * @param minimum the minimum
     */
    public void setMinimum(Double minimum) {
        this.minimum = minimum;
    }

    /**
     * Gets maximum.
     *
     * @return the maximum
     */
    public Double getMaximum() {
        return maximum;
    }

    /**
     * Sets maximum.
     *
     * @param maximum the maximum
     */
    public void setMaximum(Double maximum) {
        this.maximum = maximum;
    }

    /**
     * Gets enums.
     *
     * @return the enums
     */
    public String getEnums() {
        return enums;
    }

    /**
     * Sets enums.
     *
     * @param enums the enums
     */
    public void setEnums(String enums) {
        this.enums = enums;
    }

    /**
     * Gets pattern.
     *
     * @return the pattern
     */
    public String getPattern() {
        return pattern;
    }

    /**
     * Sets pattern.
     *
     * @param pattern the pattern
     */
    public void setPattern(String pattern) {
        this.pattern = pattern;
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
     * Gets status.
     *
     * @return the
     */
    public int getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(int status) {
        this.status = status;
    }

}

