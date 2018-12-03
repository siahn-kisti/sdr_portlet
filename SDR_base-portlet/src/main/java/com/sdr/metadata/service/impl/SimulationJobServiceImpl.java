package com.sdr.metadata.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.ServiceContext;
import com.sdr.common.util.CustomUtil;
import com.sdr.metadata.model.SimulationJob;
import com.sdr.metadata.service.SimulationJobLocalServiceUtil;
import com.sdr.metadata.service.base.SimulationJobServiceBaseImpl;
import com.sdr.submission.model.BulkCsvVo;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * The implementation of the simulation job remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sdr.metadata.service.SimulationJobService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author jaesung
 * @see com.sdr.metadata.service.base.SimulationJobServiceBaseImpl
 * @see com.sdr.metadata.service.SimulationJobServiceUtil
 */
public class SimulationJobServiceImpl extends SimulationJobServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.sdr.metadata.service.SimulationJobServiceUtil} to access the simulation job remote service.
     */
    private static Log log = LogFactoryUtil.getLog(SimulationJobServiceImpl.class);

    @AccessControlled(guestAccessEnabled=true)
    public boolean updateSimulationJob(long gid, String simulationUuid, String jobUuid, String jobStatus, String jobStartDt, String jobEndDt) {

        //if(gid == 0L) gid = 0;
        if(simulationUuid == null) simulationUuid = "";
        if(jobUuid == null) jobUuid = "";
        if(jobStartDt == null) jobStartDt = "";
        if(jobEndDt == null) jobEndDt = "";

        simulationUuid = simulationUuid.trim();
        jobUuid = jobUuid.trim();
        jobStartDt = jobStartDt.trim();
        jobEndDt = jobEndDt.trim();

        SimulationJob simulationJob = null;

        boolean result = false;

        log.debug("==================================================================================================================");
        log.debug("Icebreaker to Portal Sync Start, Info[(simulationUuid)/(jobUuid)/(jobStatus)]");
        log.debug("Info : ("+simulationUuid+") / ("+jobUuid+") / ("+jobStatus+")");
        log.debug("Sync Time : "+new Date());
        log.debug("==================================================================================================================");
        //log.debug("jobSeqNo : " + jobSeqNo);
        //log.debug("gid : " + gid);
        if(!simulationUuid.equals("") && !jobUuid.equals("")){
            try{
                simulationJob = SimulationJobLocalServiceUtil.getOnebySimUuid(simulationUuid);

                String jobStatusPortal = CustomUtil.getStatusConvertIceToPortal(jobStatus);

                if(jobStatusPortal.equals("codeConvertError")){
                    log.error("Error Sync Icebreaker to Portal [ CODE CONVERT ] in updateSimulationJob");
                    result = false;
                }else{
                    simulationJob.setStatus(jobStatus);

                    if(!jobStartDt.equals("")){
                        if(jobStartDt.length()==19){
                            simulationJob.setSimulationStartDt(CustomUtil.StringToDateFormat(jobStartDt, "yyyy-MM-dd HH:mm:ss"));
                        }else{
                            log.error("Error Sync Icebreaker to Portal [ jobStartDt Format Error != size(19)] in updateSimulationJob");
                        }
                    }
                    if(!jobEndDt.equals("")){
                        if(jobEndDt.length()==19){
                            simulationJob.setSimulationEndDt(CustomUtil.StringToDateFormat(jobEndDt, "yyyy-MM-dd HH:mm:ss"));
                        }else if(jobEndDt.toLowerCase().equals("none")){

                        }else{
                            log.error("Error Sync Icebreaker to Portal [ jobEndDt Format Error != size(19)] in updateSimulationJob==>"+jobEndDt);
                        }
                    }

                    simulationJob = SimulationJobLocalServiceUtil.updateSimulationJob(simulationJob);
                }

                result = true;

            } catch (SystemException e) {
                log.error("Error Sync Icebreaker to Portal [ SystemException ] in updateSimulationJob");
                log.error("SystemException : " + e.toString());

                result = false;
            } catch (ParseException e) {
                log.error("Error Sync Icebreaker to Portal [ ParseException ] in updateSimulationJob");
                log.error("ParseException : " + e.toString());
                result = false;
            }
        }else{
            log.error("Error Sync Icebreaker to Portal [ REQUEST ARGUMENT ] in updateSimulationJob");
            result = false;
        }


        return result;
    }

    public List<SimulationJob> getList(long userId, int start, int end, OrderByComparator orderByComparator)
        throws SystemException {
        /*
        List<SimulationJob> list = null;
        try {
            list = SimulationJobLocalServiceUtil.getList(userId, start, end, orderByComparator);
        } catch (SystemException e) {
            e.printStackTrace();
        }
        return list;
        */
        // TODO : Access Control
        return SimulationJobLocalServiceUtil.getList(userId, start, end, orderByComparator);
    }

    public SimulationJob getInfo(long simulationId) throws PortalException, SystemException {
        /*
        SimulationJob simulationJob = null;
        try {
            simulationJob = SimulationJobLocalServiceUtil.getSimulationJob(simulationId);
        } catch (PortalException e) {
            e.printStackTrace();
        } catch (SystemException e) {
            e.printStackTrace();
        }
        return simulationJob;
        */
        // TODO : Access Control
        return SimulationJobLocalServiceUtil.getSimulationJob(simulationId);
    }

}
