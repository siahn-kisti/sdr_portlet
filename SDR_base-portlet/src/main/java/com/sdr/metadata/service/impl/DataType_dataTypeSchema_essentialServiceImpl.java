package com.sdr.metadata.service.impl;

import com.sdr.metadata.service.DataType_dataTypeSchema_essentialLocalServiceUtil;
import com.sdr.metadata.service.base.DataType_dataTypeSchema_essentialServiceBaseImpl;

/**
 * The implementation of the data type_data type schema_essential remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sdr.metadata.service.DataType_dataTypeSchema_essentialService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author jaesung
 * @see com.sdr.metadata.service.base.DataType_dataTypeSchema_essentialServiceBaseImpl
 * @see com.sdr.metadata.service.DataType_dataTypeSchema_essentialServiceUtil
 */
public class DataType_dataTypeSchema_essentialServiceImpl
        extends DataType_dataTypeSchema_essentialServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.sdr.metadata.service.DataType_dataTypeSchema_essentialServiceUtil} to access the data type_data type schema_essential remote service.
     */

    public Boolean getEssential(long dataTypeId, long dataTypeSchemaId) {
        return DataType_dataTypeSchema_essentialLocalServiceUtil.getEssential(dataTypeId, dataTypeSchemaId);
    }
}
