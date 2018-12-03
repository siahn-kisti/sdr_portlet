package com.sdr.ml.common.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.sdr.metadata.model.Collection;
import com.sdr.metadata.model.DataType;
import com.sdr.metadata.service.CollectionLocalServiceUtil;
import com.sdr.metadata.service.DataTypeLocalServiceUtil;

public class MlDataIdUtils {

    private static MlDataIdUtils _MlDataIdUtils = null;
    private static long _ID_PUBLIC_ML_COLLECTION = -1;
    private static long _ID_PRIVATE_ML_COLLECTION = -1;
    private static long _ID_ML_DATASET_DATA_TYPE = -1;
    private static long _ID_ML_NOTEBOOK_DATA_TYPE = -1;

    private MlDataIdUtils(){}


	/**
	 * MlDataIdUtils의 인스턴스를 반환
	 *
	 * @return MlDataIdUtils
	 */
    public static MlDataIdUtils getInstance(){

        if(_MlDataIdUtils == null){
			_MlDataIdUtils = new MlDataIdUtils();
			_MlDataIdUtils.update();
        }

        return _MlDataIdUtils;
    }


	/**
	 * MlDataIdUtils의 Id값을 갱신
	 *
	 * @return void
	 */
    public void update(){

		try {
			updateCollectionId();
			updateDataTypeId();
		} catch (PortalException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		}
	}


	private void updateCollectionId() throws SystemException, PortalException {
		Collection privateCollection = CollectionLocalServiceUtil.getCollection(MlStringUtils._TITLE_PRIVATE_ML_COLLECTION);
		Collection publicCollection = CollectionLocalServiceUtil.getCollection(MlStringUtils._TITLE_PUBLIC_ML_COLLECTION);

		_ID_PRIVATE_ML_COLLECTION = privateCollection.getCollectionId();
		_ID_PUBLIC_ML_COLLECTION = publicCollection.getCollectionId();
	}


	private void updateDataTypeId() throws SystemException {
		DataType mlDatasetDataType = DataTypeLocalServiceUtil.getDataTypeByTitle(MlStringUtils._TITLE_ML_DATASET_DATA_TYPE);
		DataType mlNotebookDataType = DataTypeLocalServiceUtil.getDataTypeByTitle(MlStringUtils._TITLE_ML_NOTEBOOK_DATA_TYPE);

		_ID_ML_DATASET_DATA_TYPE = mlDatasetDataType.getDataTypeId();
		_ID_ML_NOTEBOOK_DATA_TYPE = mlNotebookDataType.getDataTypeId();
	}


	/**
	 * DataType ml-data의 Id를 반환
	 *
	 * @return long
	 */
    public long getIdMlDatasetDataType() {
        return _ID_ML_DATASET_DATA_TYPE;
    }
	/**
	 * DataType ml-notebook의 Id를 반환
	 *
	 * @return long
	 */
    public long getIdMlNotebookDataType() {
        return _ID_ML_NOTEBOOK_DATA_TYPE;
    }
	/**
	 * Collection ml-public의 Id를 반환
	 *
	 * @return long
	 */
    public long getIdPublicMlCollection() {
        return _ID_PUBLIC_ML_COLLECTION;
    }
	/**
	 * Collection ml-private의 Id를 반환
	 *
	 * @return long
	 */
    public long getIdPrivateMlCollection() {
        return _ID_PRIVATE_ML_COLLECTION;
    }
}
