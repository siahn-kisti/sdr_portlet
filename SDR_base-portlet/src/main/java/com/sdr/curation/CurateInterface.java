package com.sdr.curation;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sdr.common.util.ImportRepositoryUtil;
import com.sdr.file.FileConst;
import com.sdr.metadata.model.Curate;
import com.sdr.metadata.model.DataType;
import com.sdr.metadata.model.Dataset;
import com.sdr.metadata.service.CurateLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.sdr.metadata.service.DataTypeSchemaLocalServiceUtil;
import com.sdr.metadata.util.MetadataValidator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Date;

public abstract class CurateInterface {
	private static Log log = LogFactoryUtil.getLog(CurateInterface.class);
	static final boolean _enable_curate = true;
	static final boolean _enable_checksum = false;
	private Curate _curate = null;
	private PreprocessInterface _pi = null;
	private String _descriptiveMetadata = null;

	private int _errCode = 0;
	public int getErrCode() { return _errCode; }
	public void setErrCode(int _errCode) { this._errCode = _errCode; }

	abstract public void pre_retriveFile(Dataset ds, DataType dt, ServiceContext sc);
	abstract public void do_retriveFile(Dataset ds, DataType dt, ServiceContext sc);
	abstract public void post_retriveFile(Dataset ds, DataType dt, ServiceContext sc);
	abstract public void pre_annotate(Dataset ds, DataType dt, ServiceContext sc);
	abstract public void do_annotate(Dataset ds, DataType dt, ServiceContext sc);
	abstract public void post_annotate(Dataset ds, DataType dt, ServiceContext sc);


	public void retriveFile(Dataset ds, DataType dt, ServiceContext sc) {
		pre_retriveFile(ds, dt, sc); if ( getErrCode() != ErrorConst._OK) return;
		do_retriveFile(ds, dt, sc); if (getErrCode() != ErrorConst._OK) return;
		post_retriveFile(ds, dt, sc); if (getErrCode() != ErrorConst._OK) return;
	}

	public void annotate(Dataset ds, DataType dt, ServiceContext sc) {
		pre_annotate(ds, dt, sc); if (getErrCode() != ErrorConst._OK) return;
		do_annotate(ds, dt, sc); if (getErrCode() != ErrorConst._OK) return;
		post_annotate(ds, dt, sc) ; if (getErrCode() != ErrorConst._OK) return;
	}

	public void run(Dataset ds, DataType dt, ServiceContext sc) {
		retriveFile(ds, dt, sc) ; if (getErrCode() != ErrorConst._OK) return;
		annotate(ds, dt, sc) ; if (getErrCode() != ErrorConst._OK) return;
	}

	public static CurateInterface getInstance(int repoId) {
		switch ( repoId ) {
			case FileConst.IMPORT_FROM_FTP :
				return new AsyncCurate();
			case FileConst.IMPORT_FROM_EDISON :
				return new EdisonCurate();
			case FileConst.IMPORT_FROM_TEMP_FOR_DIRECT_VIEW :
				return null;
			default:
				return null;
		}
	}

	public static Curate prepareCurate(com.liferay.portal.service.ServiceContext serviceContext, long datasetId) {
		Curate curate = null;
		try {
			curate = CurateLocalServiceUtil.create(serviceContext, datasetId);
		} catch (SystemException | PortalException e1) {
			e1.printStackTrace();
			ErrorHandler.reportError("Curate entry creation Error for " + datasetId);
		}
		return curate;
	}

	/*
	public void reportError(long datasetId, com.liferay.portal.service.ServiceContext serviceContext,
							 String msg) {
		reportError(datasetId, serviceContext, msg, msg);
	}

	public void reportError(long datasetId, com.liferay.portal.service.ServiceContext serviceContext,
							 String errorTitle, String errorBody) {
		if ( _curate != null ) {
			_curate.setEndDate(new Date());
			_curate.setLog("[" + errorTitle + "] " + errorBody);
			try {
				CurateLocalServiceUtil.updateCurate(_curate);
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
		ErrorHandler.reportError(serviceContext.getCompanyId(), serviceContext.getScopeGroupId(),
				datasetId, serviceContext.getUserId(), serviceContext, errorTitle, errorBody);
	}
	*/

	public void reportError(long datasetId, ServiceContext serviceContext){
		if ( _curate != null ) {
			_curate.setEndDate(new Date());
			_curate.setLog("[" + getErrCode() + "] ");
			try {
				CurateLocalServiceUtil.updateCurate(_curate);
			} catch (SystemException e) {
				e.printStackTrace();
			}
		}
		ErrorHandler.reportError(serviceContext.getCompanyId(), serviceContext.getScopeGroupId(),
				datasetId, serviceContext.getUserId(), serviceContext, ErrorConst.getErrorMessage(getErrCode()));
	}


	public String getDescriptiveMetadata() {
		/*
		if ( _pi == null ) return null;
		if ( _descriptiveMetadata == null ) {
			_descriptiveMetadata = _pi.getDescriptiveMetadata();
		}
		return _descriptiveMetadata;
		*/
		return null;
	}


	public static boolean checkDescriptiveMetadata(long dataTypeId, long datasetId, String dm, ServiceContext serviceContext) {
		try {
			JSONObject validateSchemaJson = DataTypeSchemaLocalServiceUtil.getDataTypeSchemaValidateRule(dataTypeId);
			// log.debug("V rule : " + validateSchemaJson);
			MetadataValidator.validate(validateSchemaJson, dm);
		} catch (Exception e) {
			log.debug("DescriptiveMetadata is incorrect compared to the schema : " + e.getMessage());
			// reportError(datasetId, serviceContext, "DescriptiveMetadata is incorrect compared to the schema : " + e.getMessage());
			return false;
		}
		return true;
	}


	public Curate getCurate(){ return _curate; }
	public void setCurate(Curate curate){ _curate = curate; }

	public PreprocessInterface get_pi() { return _pi; }
	public void set_pi(PreprocessInterface pi) { _pi = pi ;}

	// public int getErrorCode() { return _errCode[0] ; }
	// public void setErrorCode(int code) { _errCode[0] = code ;}

	public static String getDescriptiveMetadata(String path, long datasetId, Integer errCode[]) {

		File f = new File( path + File.separator + FileConst._META_FILE_MD ) ;

		if ( ! f.exists() ) {
			log.debug("descriptive metadata file does not exist for " + datasetId);
			// errCode[0] = ErrorConst._FAIL_MISSING_METADATA_FILE;
			return null ;
		}

		if ( f.length() > PreprocessInterface._MAX_FILE_LEN ) {
			log.error("metadata file is too long for " + datasetId + " (size) " + f.length());
			errCode[0] = ErrorConst._ERROR_TOO_LONG_METADATA;
			return null ;
		}

		String descriptiveMetadata = null;
		BufferedReader br = null;
		try {
			char[] c = new char[(int)f.length()];
			br = new BufferedReader(new FileReader(f));
			br.read(c);
			descriptiveMetadata = new String(c) ;
			br.close();
		} catch (Exception e) {
			log.error("error to read metadata file for " + datasetId);
			e.printStackTrace();
			errCode[0] = ErrorConst._ERROR_OPEN_METADATA;
			return null;
		}

		return descriptiveMetadata;
	}
}