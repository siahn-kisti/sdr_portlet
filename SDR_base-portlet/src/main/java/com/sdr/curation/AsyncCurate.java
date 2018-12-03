package com.sdr.curation;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ServiceContext;
import com.sdr.metadata.model.Curate;
import com.sdr.metadata.model.DataType;
import com.sdr.metadata.model.Dataset;

public class AsyncCurate extends CurateInterface {
    private static Log log = LogFactoryUtil.getLog(AsyncCurate.class);

    @Override
    public void pre_retriveFile(Dataset ds, DataType dt, ServiceContext sc) {   }

    @Override
    public void do_retriveFile(Dataset ds, DataType dt, ServiceContext sc) { }

    @Override
    public void post_retriveFile(Dataset ds, DataType dt, ServiceContext sc) {  }

    @Override
    public void pre_annotate(Dataset ds, DataType dt, ServiceContext sc) {
        /*
        Curate curate = CurateInterface.prepareCurate(sc, ds.getDatasetId()) ;
        if ( curate == null) {
            setErrCode(ErrorConst._FAIL_CREATE_CURATION);
            return;
        }
        setCurate(curate);
        */
    }

    @Override
    public void do_annotate(Dataset ds, DataType dt, ServiceContext sc) {
        /*
        PreprocessInterface pi = new LocalPreprocess();
        if (pi == null) setErrCode(ErrorHandler._FAIL_CREATE_PREPROCESS);
        set_pi(pi);

        if ( pi.preprocess(ds, dt) != ErrorHandler._OK ) {
            // pi.handleError(sc, this);
            setErrCode(pi.getErrCode());
        }
        */
    }

    @Override
    public void post_annotate(Dataset ds, DataType dt, ServiceContext sc) {
        // checkDescriptiveMetadata(dt.getDataTypeId(), ds.getDatasetId(), sc) ;
    }

}
