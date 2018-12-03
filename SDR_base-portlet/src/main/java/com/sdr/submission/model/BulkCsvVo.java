package com.sdr.submission.model;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sdr.curation.ErrorConst;
import com.sdr.common.util.ImportRepositoryUtil;
import com.sdr.file.FileConst;
import com.sdr.file.FileService;
import com.sdr.metadata.model.DataType;
import com.sdr.metadata.model.Dataset;
import com.sdr.metadata.service.DataTypeLocalServiceUtil;
import com.sdr.metadata.service.SimulationJobLocalService;
import com.sdr.metadata.service.SimulationJobLocalServiceUtil;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;

/**
 * The type Bulk csv vo.
 */
public class BulkCsvVo {

	private String dataLocation; // require
	private String dataType; // require
	private String title;

	/*
	private int errCnt = 0;
	private String dataLocationErr;
	private String dataTypeErr;
	private String fileValidateRuleErr;
	*/
	private int errCode = 0;
	private String errMessage = null;

	private static Log _log = LogFactoryUtil.getLog(BulkCsvVo.class);

	/**
	 * Validate int.
	 *
	 * @return the int
	 * @throws SystemException the system exception
	 */
// --------------------------------------------------

	// check whether the specified directory exists
	private int validateLocalLocation() {
		File file = new File( getDataLocation() );
		if (!file.exists()) {
			errCode = ErrorConst._ERROR_INVALID_DATA_LOCATION;
		} else if (file.listFiles().length <= 0) {
			errCode = ErrorConst._ERROR_INVALID_DATA_LOCATION;
		}
		return errCode;
	}


	// Check Where the specified data type exists
	private int validateDataType() {

		DataType dataType = null;
		try {
			dataType = DataTypeLocalServiceUtil.getDataTypeByTitle(getDataType());
		} catch (SystemException e) {
			e.printStackTrace();
			errCode = ErrorConst._ERROR_INVALID_DATATYPE;
		}
		if (dataType == null){
			errCode = ErrorConst._ERROR_INVALID_DATATYPE;
		}

		return errCode;
	}

	// Check Whether files exists which the file policy specifies
	private int validateFile() {
		try {
			DataType dataType = DataTypeLocalServiceUtil.getDataTypeByTitle(getDataType());
			FileService.datasetFileValidateRule(getDataLocation(), dataType.getFileValidationRule());
		} catch (SystemException | IOException e) {
			errCode = ErrorConst._ERROR_VALIDATE_FILE;
		}
		return errCode;
	}

	public static int validateFile(Dataset ds, DataType dt){
		int ret = 0;
		try {
			FileService.datasetFileValidateRule(ds.getLocation(), dt.getFileValidationRule());
		} catch (IOException e) {
			ret = ErrorConst._ERROR_VALIDATE_FILE;
		}
		return ret;
	}

	public int validate() {
		return validate(FileConst.IMPORT_FROM_FTP);
	}

	public int validate(int repo) {

		if(StringUtils.isEmpty(dataLocation)){
			errCode = ErrorConst._ERROR_INVALID_DATA_LOCATION;
			return errCode;
		}

		if(StringUtils.isEmpty(dataType)) {
			errCode = ErrorConst._ERROR_INVALID_DATATYPE;
			return errCode;
		}

		switch (repo) {
			case FileConst.IMPORT_FROM_FTP :
				if ( validateLocalLocation() > 0 ) return errCode;
				if ( validateDataType() > 0 ) return errCode;
				if ( validateFile() > 0 ) return errCode;
				break;


			case FileConst.IMPORT_FROM_EDISON :

				Integer code[] = { 0 };
				if (SimulationJobLocalServiceUtil.validateEdisonJob(dataLocation, code) == false ) {
					_log.debug("do you really mean false ??????  : " + code[0] );
					errCode = code[0];
					return errCode;
				}

				if ( validateDataType() > 0 ) return errCode;
				break;

			default:
				errCode = ErrorConst._ERROR_INVALID_DATA_SOURCE;
		}
		return errCode;
	}

	/**
	 * Gets data type by title.
	 *
	 * @return the data type by title
	 * @throws SystemException the system exception
	 */
	public DataType getDataTypeByTitle() throws SystemException {
		return DataTypeLocalServiceUtil.getDataTypeByTitle(getDataType());
	}

	/**
	 * Gets file count.
	 *
	 * @return the file count
	 */
	public int getFileCount() {
		int count = 0;
		if (StringUtils.isEmpty(getDataLocation()))
			return count;

		File file = new File(getDataLocation());
		if (file != null && file.isDirectory()) {
			count = file.listFiles().length;
		}

		return count;
	}

	// --------------------------------------------------
	/**
	 * Gets data location.
	 *
	 * @return the data location
	 */
	public String getDataLocation() {  return dataLocation; 	}

	/**
	 * Sets data location.
	 *
	 * @param dataLocation the data location
	 */
	public void setDataLocation(String dataLocation) { this.dataLocation = dataLocation; }

	/**
	 * Gets data type.
	 *
	 * @return the data type
	 */
	public String getDataType() {
		return dataType;
	}

	/**
	 * Sets data type.
	 *
	 * @param dataType the data type
	 */
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	/**
	 * Gets title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets title.
	 *
	 * @param title the title
	 */
	public void setTitle(String title) {
		this.title = title;
	}


	/**
	 * Gets err cnt.
	 *
	 * @return the err cnt
	 */
	public int getErrCode() {
		return errCode;
	}

	/**
	 * Sets err cnt.
	 *
	 * @param errCnt the err cnt
	 */
	public void setErrCode(int errCnt) {
		this.errCode = errCode;
	}

	public void setErrMessage(String msg) { this.errMessage = msg; }
	public String getErrMessage() { return errMessage; }

	@Override
	public String toString() {
		return "BulkCsvVo{" +
				"dataLocation='" + dataLocation + '\'' +
				", dataType='" + dataType + '\'' +
				", title='" + title + '\'' +
				", errCode=" + errCode +
				'}';
	}
}
