package com.sdr.curation;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sdr.metadata.model.DataType;
import com.sdr.metadata.model.Dataset;
import com.liferay.portal.service.ServiceContext;

import static com.sdr.curation.ErrorHandler.reportError;

public class PromptCurate extends CurateInterface {

    private static Log log = LogFactoryUtil.getLog(PromptCurate.class);

    @Override
    public void pre_retriveFile(Dataset ds, DataType dt, ServiceContext sc) {  }

    @Override
    public void do_retriveFile(Dataset ds, DataType dt, ServiceContext sc) { }

    @Override
    public void post_retriveFile(Dataset ds, DataType dt, ServiceContext sc){ }

    @Override
    public void pre_annotate(Dataset ds, DataType dt, ServiceContext sc) {
        if ( dt == null) {
            setErrCode(ErrorConst._ERROR_INVALID_DATATYPE);
        }
    }

    @Override
    public void do_annotate(Dataset ds, DataType dt, ServiceContext sc) {
        /*
        if ( dt.getCurateRequired() == false ) { return; }

        log.debug("start to preprocess the dataset : " + ds.getDatasetId());
        PreprocessInterface pi = new LocalPreprocess();
        if (pi == null) setErrCode(ErrorHandler._FAIL_CREATE_PREPROCESS);
        set_pi(pi);
        pi.setDirectView(true);

        if ( pi.preprocess(ds, dt) != ErrorHandler._OK ) {
            //pi.handleError(sc, this);
            setErrCode(pi.getErrCode());
        }
        */
    }

    @Override
    public void post_annotate(Dataset ds, DataType dt, ServiceContext sc) {
        /*
        checkDescriptiveMetadata(dt.getDataTypeId(), ds.getDatasetId(), sc) ;
        */
    }
}
