package com.sdr.metadata.service.impl;

import com.sdr.metadata.model.DataType_dataTypeSchema_essential;
import com.sdr.metadata.service.base.DataType_dataTypeSchema_essentialLocalServiceBaseImpl;
import com.sdr.metadata.service.persistence.DataType_dataTypeSchema_essentialPK;

/**
 * The implementation of the data type_data type schema_essential local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sdr.metadata.service.DataType_dataTypeSchema_essentialLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author jaesung
 * @see com.sdr.metadata.service.base.DataType_dataTypeSchema_essentialLocalServiceBaseImpl
 * @see com.sdr.metadata.service.DataType_dataTypeSchema_essentialLocalServiceUtil
 */
public class DataType_dataTypeSchema_essentialLocalServiceImpl
        extends DataType_dataTypeSchema_essentialLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.sdr.metadata.service.DataType_dataTypeSchema_essentialLocalServiceUtil} to access the data type_data type schema_essential local service.
     */

    public Boolean getEssential(long dataTypeId, long dataTypeSchemaId) {

        DataType_dataTypeSchema_essentialPK dataType_dataTypeSchema_essentialPK = new DataType_dataTypeSchema_essentialPK();
        dataType_dataTypeSchema_essentialPK.setDataTypeId(dataTypeId);
        dataType_dataTypeSchema_essentialPK.setDataTypeSchemaId(dataTypeSchemaId);

        DataType_dataTypeSchema_essential dtdtse = null;
        try {
            dtdtse = dataType_dataTypeSchema_essentialPersistence.findByPrimaryKey(dataType_dataTypeSchema_essentialPK);
            return dtdtse.getEssential();
        } catch (Exception e) {
//            e.printStackTrace();
            return false;
        }
    }
}
