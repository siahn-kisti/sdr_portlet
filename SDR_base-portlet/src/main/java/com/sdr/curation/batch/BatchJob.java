package com.sdr.curation.batch;

public class BatchJob {
    private long datasetId;
    private long ppId;
    private int errCode;
    private String location;
    private String metaLocation;
    private int repo;
    private boolean curationRequired;

    @Override
    public String toString() {
        return "BatchJob{" +
                "datasetId=" + datasetId +
                ", errCode=" + errCode +
                ", location='" + location + '\'' +
                ", metaLocation='" + metaLocation + '\'' +
                ", ppId ='" + ppId + '\'' +
                '}';
    }

    public long getDatasetId() {
        return datasetId;
    }

    public void setDatasetId(long datasetId) {
        this.datasetId = datasetId;
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMetaLocation() { return metaLocation; }

    public void setMetaLocation(String metaLocation) {
        this.metaLocation = metaLocation;
    }

    public int getRepo() { return repo; }

    public void setRepo(int repo) { this.repo = repo; }

    public boolean isCurateionRquired() { return curationRequired; }

    public void setCurationRequired(boolean curationRequired) {
        this.curationRequired = curationRequired;
    }

    public long getPpId() { return ppId; }

    public void setPpId(long ppId) { this.ppId = ppId;  }
}
