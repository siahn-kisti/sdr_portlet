package com.sdr.curation;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sdr.common.util.TokenProviderUtil;
import com.sdr.curation.batch.BatchCurate;
import com.sdr.curation.batch.BatchJob;
import com.sdr.curation.batch.EDISONUtil;
import com.sdr.file.PropConst;
import com.sdr.file.PropService;
import com.sdr.metadata.model.CurationJob;
import com.sdr.metadata.service.CurationJobLocalServiceUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;


public class IBPreprocess extends PreprocessInterface {

    private static Log log = LogFactoryUtil.getLog(IBPreprocess.class);

    @Override
    public boolean retrieveFile( String location, List<BatchJob> batchJobList) {
        Integer[] errCode = { 0 } ;
        submitJob(location, BatchCurate.STEP_IN_RETRIEVAL, errCode ) ;
        if ( errCode[0] != ErrorConst._OK ) {
            for (int i=0; i< batchJobList.size(); i++)
                batchJobList.get(i).setErrCode( errCode[0] );
            return false;
        }
        return true;
    }


    @Override
    public boolean annotate( String location, List<BatchJob> batchJobList) {
        Integer[] errCode = { 0 } ;
        log.debug("do you come here ? : " );
        submitJob(location, BatchCurate.STEP_IN_CURATION, errCode ) ;
        if ( errCode[0] != ErrorConst._OK ) {
            for (int i=0; i< batchJobList.size(); i++)
                batchJobList.get(i).setErrCode( errCode[0] );
            return false;
        }
        return true;
    }


    public void submitJob( String location, int step, Integer[] errCode ) {
        String token = null;

        log.debug("submitJob : " );
        try {
            Map<String, Object> icebreakerVcToken = TokenProviderUtil.getAdminVcToken();
            if (icebreakerVcToken == null) { errCode[0] = ErrorConst._ERROR_TOKEN; return; }

            token = (String) icebreakerVcToken.get("vcToken");
            if (token == null) { errCode[0] = ErrorConst._ERROR_TOKEN; return; }
        } catch ( Exception  e ) {
            errCode[0] = ErrorConst._ERROR_TOKEN;  return;
        }

        log.debug("token : " + token );

        if ( EDISONUtil.EDISON_URL == null ) EDISONUtil.EDISON_URL = PropService.getProp("icebreakerUrl");
        log.debug("edison url : " + EDISONUtil.EDISON_URL );

        String simulation = EDISONUtil.createIBSimulation(token, 12345, "curation", location, errCode);
        log.debug("errCoide : " + errCode[0]);
        if (simulation == null ) return;
        log.debug("Simulation ID : " + simulation);


        String urlString = EDISONUtil.getCurationURL(simulation, step, location, errCode);
        if ( errCode[0] != ErrorConst._OK ) return;
        log.debug("edison url : " + urlString);



        String _root = PropConst.getProp("dataset.location");
        String _remote_root = PropConst.getProp("dataset.remote.location");
        if ( ( _root != null) && ( _root.length() > 0)
                && ( _remote_root != null) && ( _remote_root.length() > 0) ) {
            location = location.replaceFirst(_root, _remote_root);
        }
        log.debug("location : " + location );


        String job = EDISONUtil.createIBCurationJob(token, urlString, step, location, errCode) ;
        if (job == null ) return;
        log.debug("Job ID : " + job);


        // save Status
        try {
            long simulationId = CounterLocalServiceUtil.increment(IBPreprocess.class.getName());
            CurationJob curationJob = CurationJobLocalServiceUtil.createCurationJob(simulationId);
            curationJob.setSimulationUuid(simulation);
            curationJob.setJobUuid(job);
            curationJob.setSimulationStartDt(new Date());
            CurationJobLocalServiceUtil.updateCurationJob(curationJob);
        } catch (SystemException e) {
            e.printStackTrace();
            // TODO : Error Handling : should not happen
            return;
        }
    }

}
