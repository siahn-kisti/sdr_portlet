package com.sdr.metadata.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.sdr.file.FileService;
import com.sdr.metadata.model.Curate;
import com.sdr.metadata.model.CurateClp;
import com.sdr.metadata.model.Dataset;
import com.sdr.metadata.model.DatasetClp;
import com.sdr.metadata.service.CurateLocalServiceUtil;
import com.sdr.metadata.service.DatasetLocalServiceUtil;
import com.sdr.metadata.service.base.CurateLocalServiceBaseImpl;
import com.sdr.metadata.util.SdrBeanUtils;

/**
 * The implementation of the curate local service.
 * <p>
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sdr.metadata.service.CurateLocalService} interface.
 * <p>
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author siahn
 * @see com.sdr.metadata.service.base.CurateLocalServiceBaseImpl
 * @see com.sdr.metadata.service.CurateLocalServiceUtil
 */
public class CurateLocalServiceImpl extends CurateLocalServiceBaseImpl {
	
	private static Log _log = LogFactoryUtil.getLog(CurateLocalServiceImpl.class);


	/**
	 * Create
	 *
	 * @param sc
	 * @param datasetId
	 * @return Curate
	 * @throws PortalException
	 * @throws SystemException
	 */
	public Curate create(ServiceContext sc, long datasetId) throws PortalException, SystemException{
		User user = userPersistence.findByPrimaryKey(sc.getUserId());
		Date now = new Date();
		
	    long curateId = counterLocalService.increment();
	    _log.debug("### insert=" + curateId);
	    
	    Curate saveVo = curatePersistence.create(curateId);	    
	    saveVo.setCurateId(curateId);
	    saveVo.setGroupId(sc.getScopeGroupId());
	    saveVo.setCompanyId(sc.getCompanyId());
		saveVo.setUserId(user.getUserId());
		saveVo.setUserName(user.getScreenName());
		saveVo.setCreateDate(now);    
		saveVo.setDatasetId(datasetId);
		saveVo.setTitle("dataset : " + datasetId);
		updateCurate(saveVo);
		//curatePersistence.update(saveVo);
		
		Dataset dataset = DatasetLocalServiceUtil.getDataset(datasetId);
		dataset.setCurateId(curateId); 
		DatasetLocalServiceUtil.updateDataset(dataset, false);
		
		return saveVo;
	}


	/**
	 * Finalize curate
	 *
	 * @param datasetId
	 * @param descriptiveMetadata
	 * @param curate
	 * @return boolean
	 * @throws PortalException
	 * @throws SystemException
	 */
	public boolean finalizeCurate(long datasetId, String descriptiveMetadata, String checksum, Curate curate)
			throws PortalException, SystemException {	
		
		Dataset ds = DatasetLocalServiceUtil.getDataset(datasetId);
		Long priv_curateId = ds.getCurateId();
		boolean success ;
		
		if ( priv_curateId == curate.getCurateId()) {
			if ( descriptiveMetadata !=null ) ds.setDescriptiveMetadata(descriptiveMetadata);
			ds.setMetalocation( FileService.getDatasetPath( ds.getCollectionId(), ds.getUserId(), ds.getDatasetId(), FileService.LOC_TYPE_META) );
			if (checksum != null) ds.setChecksum(checksum);
			DatasetLocalServiceUtil.updateDataset(ds, false);
			curate.setEndDate(new Date());
			curate.setLog("SUCCESS");
			success = true;
		} else {
			curate.setEndDate(new Date());
			curate.setLog("There is a new Curation Job for " + datasetId);
		    _log.debug("There is a new Curation Job for " + datasetId);
		    success = false;
		}
		updateCurate(curate);
		return success;
	}

	/**
	 * Delete by dataset
	 *
	 * @param datasetId
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void deleteBydataset(long datasetId) throws SystemException, PortalException{
		List<Curate> list = getList(datasetId);
		for (Curate item : list) {
			deleteCurate(item);
		}
	}


	/**
	 * Get list
	 *
	 * @return List<Curate>
	 * @throws SystemException
	 * @throws PortalException
	 */
	public List<Curate> getList() throws SystemException, PortalException{
		return curatePersistence.findAll(); 
	}

	/**
	 * Get list
	 *
	 * @param datasetId
	 * @return List<Curate>
	 * @throws SystemException
	 * @throws PortalException
	 */
	public List<Curate> getList(long datasetId) throws SystemException, PortalException{
		return curatePersistence.findByDataset(datasetId);
	}

}
