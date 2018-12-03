package com.sdr.curation;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sdr.curation.batch.BatchJob;
import com.sdr.metadata.model.DataType;
import com.sdr.metadata.model.Dataset;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

import com.liferay.portal.service.ServiceContext;

public abstract class PreprocessInterface {

    // private static Log log = LogFactoryUtil.getLog(PreprocessInterface.class);
    static final int _MAX_FILE_LEN = 500000 ;

    boolean _prompt = false;
    public boolean is_prompt() {  return _prompt; }
    public void set_prompt(boolean _prompt) { this._prompt = _prompt; }
    public boolean isDirectView() { return _prompt; }
    public void setDirectView(boolean directView) { _prompt = directView; }

    private int _errCode = 0;
    public int getErrCode() { return _errCode; }
    public void setErrCode(int errCode) { this._errCode = errCode; }

    // abstract public int preprocess(Dataset dataset, DataType dataType) ;
    // abstract public String getDescriptiveMetadata() ;
    // abstract public void handleError(ServiceContext serviceContext, CurateInterface ci);

    abstract public boolean retrieveFile(String location, List<BatchJob> batchJobList);
    abstract public boolean annotate( String location, List<BatchJob> batchJobList );
}
