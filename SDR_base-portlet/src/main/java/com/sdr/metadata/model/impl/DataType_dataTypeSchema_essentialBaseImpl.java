package com.sdr.metadata.model.impl;

import com.liferay.portal.kernel.exception.SystemException;

import com.sdr.metadata.model.DataType_dataTypeSchema_essential;
import com.sdr.metadata.service.DataType_dataTypeSchema_essentialLocalServiceUtil;

/**
 * The extended model base implementation for the DataType_dataTypeSchema_essential service. Represents a row in the &quot;sdr_DataType_dataTypeSchema_essential&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link DataType_dataTypeSchema_essentialImpl}.
 * </p>
 *
 * @author jaesung
 * @see DataType_dataTypeSchema_essentialImpl
 * @see com.sdr.metadata.model.DataType_dataTypeSchema_essential
 * @generated
 */
public abstract class DataType_dataTypeSchema_essentialBaseImpl
    extends DataType_dataTypeSchema_essentialModelImpl
    implements DataType_dataTypeSchema_essential {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this class directly. All methods that expect a data type_data type schema_essential model instance should use the {@link DataType_dataTypeSchema_essential} interface instead.
     */
    @Override
    public void persist() throws SystemException {
        if (this.isNew()) {
            DataType_dataTypeSchema_essentialLocalServiceUtil.addDataType_dataTypeSchema_essential(this);
        } else {
            DataType_dataTypeSchema_essentialLocalServiceUtil.updateDataType_dataTypeSchema_essential(this);
        }
    }
}
