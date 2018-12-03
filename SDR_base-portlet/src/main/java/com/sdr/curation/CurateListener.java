package com.sdr.curation;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.WorkflowDefinitionLinkLocalServiceUtil;
import com.sdr.common.util.TokenProviderUtil;
import com.sdr.curation.batch.BatchCurate;
import com.sdr.curation.batch.BatchJob;
import com.sdr.curation.batch.BatchRetrieve;
import com.sdr.file.FileConst;
import com.sdr.file.FileService;
import com.sdr.file.PropConst;
import com.sdr.metadata.model.Collection;
import com.sdr.metadata.model.DataType;
import com.sdr.metadata.model.Dataset;
import com.sdr.metadata.service.CollectionLocalServiceUtil;
import com.sdr.metadata.service.DataTypeLocalServiceUtil;
import com.sdr.metadata.service.DatasetLocalServiceUtil;
import com.sdr.workflow.DatasetWorkflow;

import java.io.*;
import java.util.*;


/**
 * @package : com.sdr.curation
 * @file_name : CurateListener.java
 *
 * @author : siahn
 * @date : 2018. 7. 9.
 */

public class CurateListener implements MessageListener {

	private static Log log = LogFactoryUtil.getLog(CurateListener.class);
	//final static boolean _curate_remote = Boolean.parseBoolean(PropConst.getProp("remote.curate.allowed"));
	// final static boolean _curate_remote = true;
	final static int _MAX_LIMIT_REMOTE_RETRIEVE = 1 ;
	final static int _MAX_LIMIT_REMOTE_CURATE = 1 ;


	/* (non-Javadoc)
     * @see com.liferay.portal.kernel.messaging.MessageListener#receive(com.liferay.portal.kernel.messaging.Message)
     */
	public void receive(Message message) {

		// get payload
		List<BatchJob> bjList = getPayload(message);
		if ( bjList.size() == 0 ) return;


		// get first dataset
		Dataset firstDs = getDataset( bjList.get(0).getDatasetId() );
		if (firstDs == null) {
			for(int i=0;i<bjList.size();i++) bjList.get(i).setErrCode( ErrorConst._ERROR_INVALID_DATASET);
			// handleErrCode(dsIdList, errCodes);
			return ;
		}

		// get collection info
		Collection collection = getCollection( firstDs.getCollectionId() );
		if ( collection == null ) {
			for(int i=0;i<bjList.size();i++) bjList.get(i).setErrCode( ErrorConst._ERROR_INVALID_COLLECTION);
			// is this really happen ?? handleErrCode(dsIdList, errCodes);
			return ;
		}

		// if skipCurate is set then skip
		if ( collection.getSkipCurate() ) return;

		int signature = new Date().hashCode();

		// retrieve Files
		String batch_location = makeBatchDir(BatchCurate.STEP_IN_RETRIEVAL, signature);
		Boolean[] skipMakingList = { true };
		Boolean[] remote = { false };
		try {
			if( ! prepareAndRetrieve( bjList, batch_location, signature, skipMakingList, remote ) ) {
				handleError(bjList);
				return ;
			}
		} catch ( SystemException | PortalException e ) {
			e.printStackTrace();
			return;
		}

		// curate
		if ( remote[0] == false )  {
			// In case that there is no need to retrieve files
			if ( skipMakingList[0] == false )
				bjList =  BatchCurate.readDatasetListFile(batch_location, FileService.LOC_FEEDBACK_LIST) ;
			if (bjList == null ) return ;

			validateFile(bjList);
			try {
				startCurate( bjList, signature);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	private List<BatchJob> getPayload(Message message) {

		// retrieve list of datasetId from the message bus
		JSONArray jsonArray = null;
		List<BatchJob> bjList = new ArrayList<>();
		String payload = (String) message.getPayload();

		try {
			jsonArray = JSONFactoryUtil.createJSONArray(payload);
		} catch (JSONException e) {
			e.printStackTrace();
			ErrorHandler.reportError("[Curation error] Failed to create json array");
			return null;
		}

		for ( int i = 0 ; i < jsonArray.length(); i++ ) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			Long datasetId = (Long) jsonObject.getLong("id");
			if ( datasetId == null || datasetId == 0 ) {
				continue;
			}

			BatchJob bj = new BatchJob();
			bj.setDatasetId(datasetId);


			long ppId = 0;
			try {
				ppId = jsonObject.getLong("pp");
			} catch (org.json.JSONException e) {
				ppId = FileConst.PP_PREVIOUS;
			}

 			bj.setPpId(ppId);
			bj.setErrCode(0);
			bjList.add(bj);
			log.debug("message Bus (receive) : " + datasetId + "(" + ppId + ")");
		}

		return bjList;
	}


	private boolean prepareAndRetrieve(List<BatchJob> bjList, String batch_location, int signature, Boolean[] skipMakingList, Boolean[] remote )
			throws SystemException, PortalException {
		int count_from_remote = 0;
		boolean retrieve_remote = false;
		Date now = new Date();
		String token = null;

		log.debug("Prepare and retrieve for " + batch_location);

		for (int i = 0; i < bjList.size(); i++) {
			Dataset ds = getDataset(bjList.get(i).getDatasetId());
			if ( ds == null ) {
				bjList.get(i).setErrCode( ErrorConst._ERROR_INVALID_DATASET );
				continue;
			}

			DataType dt = getDataType( ds.getDataTypeId());
			if ( dt == null ) {
				bjList.get(i).setErrCode( ErrorConst._ERROR_INVALID_DATATYPE);
				continue;
			}

			long ppId = DatasetLocalServiceUtil.transPPId(ds, dt, bjList.get(i).getPpId());
			bjList.get(i).setPpId(ppId);


			bjList.get(i).setLocation( ds.getLocation() );
			bjList.get(i).setRepo( ds.getRepository() );
			if (ds.getRepository() != FileConst.IMPORT_FROM_FTP) {
				count_from_remote++;
				if (count_from_remote >= _MAX_LIMIT_REMOTE_RETRIEVE) {
					retrieve_remote = true;
				}
				if ( token == null ) {
					// get Token
					Map<String, Object> icebreakerVcToken = null;
					try {
						icebreakerVcToken = TokenProviderUtil.getAdminVcToken();
					} catch ( Exception e ) {
						e.printStackTrace();
					}
					token = (String) icebreakerVcToken.get("vcToken");
				}
			}

			//if ( dt.getDefaultPpLogicId() != FileConst.PP_NO ) bjList.get(i).setCurationRequired( true );
			if ( bjList.get(i).getPpId() == FileConst.PP_NO ) {
				bjList.get(i).setCurationRequired(false);
			} else {
				bjList.get(i).setCurationRequired(true);
			}

			ds.setCreateDate(now);
			ds.setCurateLogCode( CurationLogConst.LOG_START_RETRIEVE_FILE);
			if (ds.getRepository() != FileConst.IMPORT_FROM_FTP) {
				ds.setRetrieveSignature(signature);
			}
			
			bjList.get(i).setMetaLocation("");
			ds.setMetalocation("");

			DatasetLocalServiceUtil.updateDataset(ds, false);
		}

		if (count_from_remote == 0) {
			remote[0] = false;
			return true;
		}

		skipMakingList[0] = false;
		if ( Boolean.parseBoolean(PropConst.getProp("remote.curate.allowed")) == false ) retrieve_remote = false;


		PreprocessInterface pi = null;
		if ( ! makeBatchFiles( bjList, batch_location, retrieve_remote, signature, token ) )  {
			throw new PortalException("make Batch File failure") ;
		}

		log.debug("retrieve_remote : " + retrieve_remote);
		log.debug("batch_location : " + batch_location);

		pi = ( retrieve_remote ) ? new IBPreprocess() : new  LocalPreprocess() ;
		boolean success = pi.retrieveFile( batch_location, bjList );
		if (success) {
			remote[0] = retrieve_remote;
			return true;
		} else {
			remote[0] = false;
			return false;
		}
	}


	public static String makeBatchDir(int step, int signature) {
		//String header = "" + signature + File.separator;
		//header += (step == BatchCurate.STEP_IN_CURATION) ? "curate" : "retrieve";
		String batch_location = FileService.getBatchPath(step, signature);

		File destFolder = new File(batch_location);
		if (!destFolder.exists()) destFolder.mkdirs();
		BatchCurate.chmod775(batch_location);
		return batch_location;
	}


	public static void deleteBatchFiles(String location, int step){
		FileService.cleanFile(FileConst.getSubPath(location, FileConst.LOC_DATASET_LIST ));
		FileService.cleanFile(FileConst.getSubPath(location, FileConst.LOC_FEEDBACK_LIST ));
		FileService.cleanFile(FileConst.getSubPath(location, FileConst.LOC_HISTORY_LOG ));
		FileService.cleanFile(FileConst.getSubPath(location, FileConst.LOC_BATCH_INFO ));

		if (step==BatchCurate.STEP_IN_RETRIEVAL) FileService.cleanFile(location);
	}


	/*
	 * annotate : true in curation step. false in retrieval step
	 * remote : true when executed in remote computing farm. if it is true, it uses call back
	 * signature : ID of batch job
	 */
	private static boolean makeBatchFiles(List<BatchJob> bjList,
								  String batch_location,
								  boolean remote,
								  int signature, String token) {

		if ( ! BatchCurate.writeDatasetListFile(batch_location, bjList, FileService.LOC_DATASET_LIST))
			return false;


		// portlet.property info for batch.info file
		Map<String,String> bInfo = PropConst.getPropMap();

		// other info for batch.info file
		bInfo.put("signature", "" + signature);
		if (token !=null )  bInfo.put("token", token);

		if ( ! BatchRetrieve.writeBatchInfoFile(batch_location, bInfo) )
			return false;

		return true;
	}


	private static void validateFile(List<BatchJob> bjList){
		for (int i=0; i< bjList.size(); i++ ) {
			if (bjList.get(i).getErrCode() != ErrorConst._OK) continue;

			Dataset ds = getDataset(bjList.get(i).getDatasetId());
			if ( ds == null ) continue;

			DataType dt = getDataType( ds.getDataTypeId());
			if ( dt == null ) continue;

			try {
				FileService.datasetFileValidateRule(bjList.get(i).getLocation(), dt.getFileValidationRule());
			} catch (IOException e) {
				bjList.get(i).setErrCode( ErrorConst._ERROR_VALIDATE_FILE);
			}
		}
	}

	public static void startCurate(List<BatchJob> bjList, int signature ) throws IOException {
		// delete Temporary Batch Files
		deleteBatchFiles(FileService.getBatchPath(BatchCurate.STEP_IN_RETRIEVAL, signature), BatchCurate.STEP_IN_RETRIEVAL);


		String batch_location = makeBatchDir(BatchCurate.STEP_IN_CURATION, signature);
		Boolean[] skipMakingList = { true };
		Boolean[] remote = { false };

		if ( ! curate( bjList, batch_location, signature, skipMakingList, remote) ) {
			log.debug("Curation Error !! ");
			handleError(bjList);
			return ;
		}


		if ( remote[0] == false ) {
			if ( skipMakingList[0] == false )
				bjList = BatchCurate.readDatasetListFile(batch_location, FileService.LOC_FEEDBACK_LIST) ;

			if (bjList == null ) {
				log.debug("Curation Error !! : SHould not happen ");
				return;
			}

			finalizeCurate( bjList, batch_location, signature );
		}
	}


	private static boolean curate( List<BatchJob> bjList, String batch_location, int signature, Boolean[] skipMakingList, Boolean[] remote ) throws IOException {
		boolean remote_annotate = false;
		int count_need_curation = 0;
		PreprocessInterface pi = null;
		Date now = new Date();

		log.debug("Curate for " + batch_location + " : " + bjList.get(0));


		for ( int i = 0 ; i < bjList.size() ; i++ ) {
			if (bjList.get(i).getErrCode() != ErrorConst._OK) continue;

			Dataset ds = getDataset(bjList.get(i).getDatasetId());
			if ( ds == null ) {
				bjList.get(i).setErrCode( ErrorConst._ERROR_INVALID_DATASET );
				continue;
			}

			// Someone else tried to retrieve same files, so I give up
			// delete all temp files in my retrieval signature
			if ( (ds.getRetrieveSignature() != 0) && (ds.getRetrieveSignature() != signature) ) {
				String myLoc = FileService.getTempDatasetPath( FileService.getSubPath(FileService.LOC_TYPE_TEMP), ds.getDatasetId(), signature );
				FileConst.deleteDirectory(myLoc);
			}

			log.debug("Do you come here ? :" + signature);
			ds.setCurateSignature(signature);
			ds.setLocation( bjList.get(i).getLocation() );
			ds.setRepository( FileConst.IMPORT_FROM_FTP );

			ds.setCreateDate(now);
			ds.setCurateLogCode( CurationLogConst.LOG_START_CURATE );

			try {
				DatasetLocalServiceUtil.updateDataset(ds, false);
			} catch ( PortalException | SystemException e) {
				continue;
			}
			
			// Test needed
			// Jaesung added. Save provenance metadata in [ds.getLocation()/prov/pm.json]
			if ( !"".equals(ds.getProvenanceMetadata())) {
				String pmPath = ds.getLocation() + File.separator + "prov";
				String pmFileName = "pm.json";
				String provenanceMetadata = ds.getProvenanceMetadata();
				File pmFolder = new File(pmPath);
	            if (!pmFolder.exists()) pmFolder.mkdirs();
	            FileWriter pmFile = null;
	            try {
					pmFile = new FileWriter(pmFolder + File.separator + pmFileName);
					pmFile.write(provenanceMetadata);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					pmFile.close();
				}
	            
			}

			// TODO : need to replace DataType to Curation
 			if ( bjList.get(i).isCurateionRquired() == true ) count_need_curation++ ;
			if ( count_need_curation >= _MAX_LIMIT_REMOTE_CURATE ) {
				remote_annotate = true;
			}

			log.debug("File Location for " + ds.getDatasetId() + " : " + ds.getLocation());
		}

		if (count_need_curation == 0)
			return true;

		skipMakingList[0] = false;

		// TODO : cleanse old files

		if ( ! makeBatchFiles( bjList, batch_location, remote_annotate, signature, null) ) return false;

		log.debug("curation allowed in remote : " + PropConst.getProp("remote.curate.allowed"));
		if ( Boolean.parseBoolean(PropConst.getProp("remote.curate.allowed")) == false ) remote_annotate = false ;

		log.debug("remote_annotate ? : " + remote_annotate);
		log.debug("batch_location ::: " + batch_location);

		pi = ( remote_annotate ) ?  new IBPreprocess() : new  LocalPreprocess() ;
		boolean success = pi.annotate( batch_location, bjList );
		if (success) {
			remote[0] = remote_annotate ;
			return true;
		} else {
			remote[0] = false;
			return false;
		}
	}



	public static void finalizeCurate( List<BatchJob> bjList, String batchLocation, int signature ) {
		Date now = new Date();
		log.debug("Finalize for " + batchLocation);
		// cleasing files used for retrieval


		for ( int i = 0 ; i < bjList.size() ; i++ ) {
			Dataset ds = getDataset(bjList.get(i).getDatasetId());
			if (ds==null) continue;

			if ( ds.getCurateSignature() != signature ) {
				log.debug("Someone else curated already for " + ds.getDatasetId());
				// TODO : delete some files
				String metaLocation = ds.getMetalocation();
				if (metaLocation!=null && metaLocation.length()!=0) {
					FileService.removeFile(metaLocation);
				}
				continue;
			}

			
			ds.setMetalocation(bjList.get(i).getMetaLocation());

			if (bjList.get(i).getErrCode() != ErrorConst._OK) {
				ds.setCurateErrorCode(bjList.get(i).getErrCode());
			} else {
				/* TODO : Checksum
				if (CurateInterface._enable_checksum) {
					String checksum = null;
					try {
						checksum = FileService.getCheckSum(ds.getLocation());
					} catch (IOException e) {
						// TODO :
						continue;
					}
					if ( checksum != null ) ds.setChecksum(checksum);
				}
				*/

				Integer dmErrCode[] = { 0 };
				String dm = CurateInterface.getDescriptiveMetadata(
						FileConst.getSubPath(bjList.get(i).getMetaLocation(), FileConst.LOC_METADATA),
						ds.getDatasetId(), dmErrCode ) ;
				if ( dm == null) {
					if ( dmErrCode[0] != ErrorConst._OK ) {
						bjList.get(i).setErrCode(dmErrCode[0]);
						ds.setCurateErrorCode(dmErrCode[0]);
					}
				} else if ( dm.length() > 0 ){
					ServiceContext sc = buildServiceContext( ds );
					if ( CurateInterface.checkDescriptiveMetadata(ds.getDataTypeId(), ds.getDatasetId(), dm, sc) ) {
						ds.setDescriptiveMetadata(dm);
					} else {
						bjList.get(i).setErrCode( ErrorConst._ERROR_VALIDATE_METADATA);
						ds.setCurateErrorCode( ErrorConst._ERROR_VALIDATE_METADATA );
					}
				}
			}

			try {
				ds.setCurateLogDate(now);
				ds.setCurateLogCode( CurationLogConst.LOG_END_CURATE );
				DatasetLocalServiceUtil.updateDataset(ds, false);
			} catch ( PortalException | SystemException e ) {
				e.printStackTrace();
				log.error(" Portal or System Exception in finalizeCurate ");
				continue;
			}

			log.debug("ErrCode " + bjList.get(i).getErrCode());
			log.debug("Metadata for " + ds.getDatasetId() + " : " + ds.getDescriptiveMetadata());

			// startReview
			if (bjList.get(i).getErrCode() == ErrorConst._OK) {
				try {
					startReview(ds);
				} catch (Exception e) {
					// TODO :
				}
			} else {
				ServiceContext sc = buildServiceContext( ds );
				ErrorHandler.reportError(ds, sc, bjList.get(i).getErrCode());
			}

		}

		// deleteBatchFiles(batchLocation, BatchCurate.STEP_IN_CURATION);
	}


    private static void startReview( Dataset ds ) throws InterruptedException, SystemException, PortalException {
		ServiceContext serviceContext = buildServiceContext( ds );

		int max_try = 5;
		for (int i=0 ; i < max_try ; i++ ) {
			try {
				if (WorkflowDefinitionLinkLocalServiceUtil.hasWorkflowDefinitionLink(serviceContext.getCompanyId(), serviceContext.getScopeGroupId(), Dataset.class.getName())) {
					DatasetWorkflow.signalWorkflowInstance(serviceContext.getCompanyId(), serviceContext.getScopeGroupId(), ds.getDatasetId(), serviceContext.getUserId(), "review");
					log.debug("--signalworkflowinstance -- review ");
				} else {
					DatasetLocalServiceUtil.updateStatus(serviceContext.getUserId(), ds.getDatasetId(), WorkflowConstants.STATUS_APPROVED, serviceContext);
					log.debug("--updatestatus -- approved ");
				}
				return;
			} catch (PortalException | SystemException e) {
				if ( i + 1 == max_try ) {
					throw e;
				} else {
					log.debug("You come too fast : " + i);
					Thread.sleep(1000);
				}
			}
		}
    }

	private static void goToIncomplete( Dataset ds ) throws PortalException, SystemException {
		ServiceContext serviceContext = buildServiceContext( ds );

		if ( WorkflowDefinitionLinkLocalServiceUtil.hasWorkflowDefinitionLink(serviceContext.getCompanyId(), serviceContext.getScopeGroupId(), Dataset.class.getName()) ) {
			// ???? Thread.sleep(1000);
			DatasetWorkflow.signalWorkflowInstance(serviceContext.getCompanyId(), serviceContext.getScopeGroupId(), ds.getDatasetId(), serviceContext.getUserId(), "incomplete");
			log.debug("--signalworkflowinstance -- incomplete ");
		} else {
			DatasetLocalServiceUtil.updateStatus(serviceContext.getUserId(), ds.getDatasetId(), WorkflowConstants.STATUS_INCOMPLETE, serviceContext);
			log.debug("--updatestatus -- incomplete ");
		}
	}


	/* util Functions */

	private static ServiceContext buildServiceContext(Dataset ds) {
		ServiceContext serviceContext = new ServiceContext();
		serviceContext.setAddGroupPermissions(true);
		serviceContext.setUserId(ds.getUserId());
		serviceContext.setScopeGroupId(ds.getGroupId());
		serviceContext.setCompanyId(ds.getCompanyId());
		return serviceContext;
	}


	private static Dataset getDataset( Long datasetId ) {
		Dataset ds = null;
		if (datasetId == null || datasetId.longValue() == 0) {
			return null;
		} else {
			try {
				ds = DatasetLocalServiceUtil.getDataset(datasetId);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		return ds;
	}

	private static Collection getCollection( Long collectionId ) {
		Collection coll = null;
		if (collectionId == null || collectionId.longValue() == 0) {
			return null;
		} else {
			try {
				coll = CollectionLocalServiceUtil.getCollection( collectionId );
			} catch (Exception e) {
				return null;
			}
		}
		return coll;
	}

	private static DataType getDataType( Long datatypeId ) {
		DataType dt = null;
		if (datatypeId == null || datatypeId.longValue() == 0) {
			return null;
		} else {
			try {
				dt = DataTypeLocalServiceUtil.getDataType(datatypeId);
			} catch (Exception e) {
				return null;
			}
		}
		return dt;
	}

	public static void callBackAfterFileRetrieval( String location ) throws IOException {
		List<BatchJob> bjList = BatchCurate.readDatasetListFile( location, FileService.LOC_FEEDBACK_LIST) ;
		if ( bjList == null || bjList.size() == 0 ) return;

		Map<String,String> bInfo = BatchRetrieve.readBatchInfoFile(location) ;
		if ( bjList == null ) return;

		int signature;
		if ( bInfo.containsKey("signature")) {
			signature = Integer.parseInt( bInfo.get("signature") );
		} else {
			// TODO : Error
			return;
		}

		validateFile(bjList);
		startCurate(bjList, signature) ;
	}

	public static void callBackAfterAnnotation( String location ) {
		List<BatchJob> bjList = BatchCurate.readDatasetListFile( location, FileService.LOC_FEEDBACK_LIST) ;
		if ( bjList == null || bjList.size() == 0 ) return;

		Map<String,String> bInfo = BatchRetrieve.readBatchInfoFile(location) ;
		if ( bjList == null ) return;

		int signature;
		if ( bInfo.containsKey("signature")) {
			signature = Integer.parseInt( bInfo.get("signature") );
		} else {
			// TODO : Error
			return;
		}

		finalizeCurate( bjList, location, signature );
	}



	private static void handleError(List<BatchJob> bjList) {
		for (int i=0; i< bjList.size(); i++){
			try {
				Dataset ds = DatasetLocalServiceUtil.getDataset(bjList.get(i).getDatasetId());
				if (ds != null) {
					ds.setCurateErrorCode(bjList.get(i).getErrCode());
					DatasetLocalServiceUtil.updateDataset(ds, false);
					goToIncomplete(ds);
				}
			} catch ( PortalException | SystemException e ) {
				e.printStackTrace();
				log.error("PortalException");
			}
		}
	}

	/*
	class ErrCode {
    	int value;
    	public ErrCode(){ value = 0;}
    	public void set(int val) { value = val;}
    	public int get() { return value; }
	}
	*/
}

