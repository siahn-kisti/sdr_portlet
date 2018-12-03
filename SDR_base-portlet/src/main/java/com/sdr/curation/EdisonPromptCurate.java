package com.sdr.curation;

import com.liferay.portal.service.ServiceContext;
import com.sdr.metadata.model.DataType;
import com.sdr.metadata.model.Dataset;

public class EdisonPromptCurate extends EdisonCurate {

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

        PreprocessInterface pi = new LocalPreprocess();
        if (pi == null) setErrCode(ErrorHandler._FAIL_CREATE_PREPROCESS);
        set_pi(pi);
        pi.setDirectView(true);

        if ( pi.preprocess(ds, dt) != ErrorHandler._OK ) {
            setErrCode(pi.getErrCode());
        }
        */
    }
}
