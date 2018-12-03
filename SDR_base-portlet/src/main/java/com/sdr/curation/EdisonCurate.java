package com.sdr.curation;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ServiceContext;
import com.sdr.common.util.ImportRepositoryUtil;
import com.sdr.file.FileConst;
import com.sdr.file.FileService;
import com.sdr.metadata.model.Curate;
import com.sdr.metadata.model.DataType;
import com.sdr.metadata.model.Dataset;
import com.sdr.metadata.service.DataTypeLocalServiceUtil;
import com.sdr.metadata.service.DatasetLocalServiceUtil;
import com.sdr.metadata.service.SimulationJobLocalServiceUtil;
import com.sdr.submission.model.BulkCsvVo;

public class EdisonCurate extends CurateInterface {
    private static Log log = LogFactoryUtil.getLog(EdisonCurate.class);

    @Override
    public void pre_retriveFile(Dataset ds, DataType dt, ServiceContext sc) {
        /*
        Integer code[] = { 0 };
        if (SimulationJobLocalServiceUtil.validateEdisonJob( ds.getLocation(), code) == false ) {
            log.debug("do you really mean false ??????  : " + code[0] );
            setErrCode( code[0] );
        }
        */
    }

    @Override
    public void do_retriveFile(Dataset ds, DataType dt, ServiceContext sc) {
        /*
        Integer code[] = { 0 };
        if (SimulationJobLocalServiceUtil.getEdisonFiles( ds.getLocation(), ds.getCollectionId(), ds.getDatasetId(), code, sc) == false ) {
            log.debug("errCode : " + code[0] );
            setErrCode( code[0] );
            return;
        }

        try {
            ds.setLocation(FileService.getDatasetPath(ds.getCollectionId(), sc.getUserId(), ds.getDatasetId(), FileService.LOC_TYPE_TEMP));
            ds.setRepository( FileConst.IMPORT_FROM_FTP );
            DatasetLocalServiceUtil.updateDataset(ds, false);
        } catch ( SystemException | PortalException e ) {
            log.error("Error in setting data location : " + e);
        }
        */
    }

    @Override
    public void post_retriveFile(Dataset ds, DataType dt, ServiceContext sc){
        /*
        int ret = BulkCsvVo.validateFile(ds, dt);
        if (ret != 0) {
            setErrCode( ErrorConst._ERROR_VALIDATE_FILE);
        }
        */
    }

    @Override
    public void pre_annotate(Dataset ds, DataType dt, ServiceContext sc) {
        /*
        Curate curate = CurateInterface.prepareCurate(sc, ds.getDatasetId()) ;
        if ( curate == null) {
            setErrCode(ErrorConst._ERROR_CREATE_CURATION );
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
            //pi.handleError(sc, this);
            setErrCode(pi.getErrCode());
        }
        */
    }

    @Override
    public void post_annotate(Dataset ds, DataType dt, ServiceContext sc) {
        // checkDescriptiveMetadata(dt.getDataTypeId(), ds.getDatasetId(), sc) ;
    }
}
