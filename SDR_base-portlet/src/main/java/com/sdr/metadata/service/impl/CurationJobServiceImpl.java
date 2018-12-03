package com.sdr.metadata.service.impl;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.security.ac.AccessControlled;
import com.sdr.curation.CurateListener;
import com.sdr.curation.batch.BatchCurate;
import com.sdr.metadata.service.base.CurationJobServiceBaseImpl;
import sun.misc.BASE64Decoder;

import java.io.IOException;

/**
 * The implementation of the curation job remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sdr.metadata.service.CurationJobService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author jaesung
 * @see com.sdr.metadata.service.base.CurationJobServiceBaseImpl
 * @see com.sdr.metadata.service.CurationJobServiceUtil
 */
public class CurationJobServiceImpl extends CurationJobServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.sdr.metadata.service.CurationJobServiceUtil} to access the curation job remote service.
     */

    private static Log log = LogFactoryUtil.getLog(CurationJobServiceImpl.class);

    @AccessControlled(guestAccessEnabled=true)
    public boolean getCurationCallBack(int step, String location, String jobUuid, String jobStatus, String jobStartDt, String jobEndDt ) {

        if (location == null || location.length() == 0) return false;

        BASE64Decoder decoder = new BASE64Decoder();
        String decodedString = null;
        try {
            decodedString = new String(decoder.decodeBuffer(location));
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        /*
        String _root = PropConst.getProp("dataset.location");
        String _remote_root = PropConst.getProp("dataset.remote.location");
        if ( ( _root != null) && ( _root.length() > 0)
                && ( _remote_root != null) && ( _remote_root.length() > 0) ) {
            decodedString = decodedString.replaceFirst(_remote_root, _root);
        }
        */


        log.debug("step : " + step);
        log.debug("location : " + decodedString);
        log.debug("jobStatus : " + jobStatus);

        if (!jobStatus.contains("SUCCESS")) return false;


        switch ( step ) {
            case BatchCurate.STEP_IN_RETRIEVAL:
				try {
					CurateListener.callBackAfterFileRetrieval(decodedString);
				} catch (IOException e) {
					e.printStackTrace();
				}
				break;
            case BatchCurate.STEP_IN_CURATION:
                CurateListener.callBackAfterAnnotation(decodedString);
                break;
            default:
                return false;
        }

        return true;
    }

    // updateSimulationJob(long gid, String simulationUuid, String jobUuid, String jobStatus, String jobStartDt, String jobEndDt) {
}
