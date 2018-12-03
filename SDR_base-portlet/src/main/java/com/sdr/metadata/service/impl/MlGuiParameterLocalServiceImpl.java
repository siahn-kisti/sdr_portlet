package com.sdr.metadata.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.sdr.metadata.model.MlGuiParameter;
import com.sdr.metadata.service.base.MlGuiParameterLocalServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the ml gui parameter local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sdr.metadata.service.MlGuiParameterLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author jaesung
 * @see com.sdr.metadata.service.base.MlGuiParameterLocalServiceBaseImpl
 * @see com.sdr.metadata.service.MlGuiParameterLocalServiceUtil
 */
public class MlGuiParameterLocalServiceImpl
    extends MlGuiParameterLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.sdr.metadata.service.MlGuiParameterLocalServiceUtil} to access the ml gui parameter local service.
     */



    /**
     * get child rows
     *
     * @param parentId long
     * @param kind String
     * @return List<DataTypeSchema>
     * @throws PortalException
     * @throws SystemException
     */
    public List<MlGuiParameter> getChildList(long parentId, String kind) throws SystemException {
        return mlGuiParameterPersistence.findBychildList(parentId, kind);
    }


    /**
     * get child rows
     *
     * @param kind String
     * @return List<DataTypeSchema>
     * @throws PortalException
     * @throws SystemException
     */
    public List<MlGuiParameter> getList(String kind) throws PortalException, SystemException {
        return mlGuiParameterPersistence.findBylist(kind);
    }
}
