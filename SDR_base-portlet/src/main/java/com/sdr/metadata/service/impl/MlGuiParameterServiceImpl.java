package com.sdr.metadata.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.sdr.metadata.model.MlGuiParameter;
import com.sdr.metadata.service.MlGuiParameterLocalServiceUtil;
import com.sdr.metadata.service.base.MlGuiParameterServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the ml gui parameter remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sdr.metadata.service.MlGuiParameterService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author jaesung
 * @see com.sdr.metadata.service.base.MlGuiParameterServiceBaseImpl
 * @see com.sdr.metadata.service.MlGuiParameterServiceUtil
 */
public class MlGuiParameterServiceImpl extends MlGuiParameterServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.sdr.metadata.service.MlGuiParameterServiceUtil} to access the ml gui parameter remote service.
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
    public List<MlGuiParameter> getChildList(long parentId, String kind) throws PortalException, SystemException {
        //TODO: PermissionCheck
        return MlGuiParameterLocalServiceUtil.getChildList(parentId, kind);
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
        //TODO: PermissionCheck
        return MlGuiParameterLocalServiceUtil.getList(kind);
    }
}
