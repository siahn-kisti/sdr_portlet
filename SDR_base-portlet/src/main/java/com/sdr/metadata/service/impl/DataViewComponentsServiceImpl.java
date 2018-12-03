package com.sdr.metadata.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;
import com.sdr.metadata.model.DataViewComponents;
import com.sdr.metadata.service.DataViewComponentsLocalServiceUtil;
import com.sdr.metadata.service.base.DataViewComponentsServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the data view components remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sdr.metadata.service.DataViewComponentsService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author jaesung
 * @see com.sdr.metadata.service.base.DataViewComponentsServiceBaseImpl
 * @see com.sdr.metadata.service.DataViewComponentsServiceUtil
 */
public class DataViewComponentsServiceImpl
    extends DataViewComponentsServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.sdr.metadata.service.DataViewComponentsServiceUtil} to access the data view components remote service.
     */

	public int getCount(String keyword, String status) throws SystemException {
		//TODO: PermissionCheck
		return DataViewComponentsLocalServiceUtil.getCount(keyword, status);
	}

	public List<DataViewComponents> getList(int start, int end, String keyword, String status) throws PortalException, SystemException {
		//TODO: PermissionCheck
		return DataViewComponentsLocalServiceUtil.getList(start, end, keyword, status);
	}

	public DataViewComponents getData(long dataViewComponentsId) throws SystemException, PortalException {
		//TODO: PermissionCheck
		return DataViewComponentsLocalServiceUtil.getDataViewComponents(dataViewComponentsId);
	}

	public DataViewComponents addData(String compGroup, String compName, String image, String html, String script, String properties,
									  String description, Integer orderNo, Integer status,
									  ServiceContext serviceContext) throws PortalException, SystemException {
		//TODO: PermissionCheck
		return DataViewComponentsLocalServiceUtil.addData(compGroup, compName, image, html, script, properties,
				description, orderNo, status,
				serviceContext);
	}

	public DataViewComponents updateData(long dataViewComponentsId,
										 String compGroup, String compName, String image, String html, String script, String properties,
										 String description, Integer orderNo, Integer status,
										 ServiceContext serviceContext) throws PortalException, SystemException {
		//TODO: PermissionCheck
		return DataViewComponentsLocalServiceUtil.updateData(dataViewComponentsId,
															compGroup, compName, image, html, script, properties,
															description, orderNo, status,
															serviceContext);
	}

	public DataViewComponents deleteData(long dataViewComponentsId) throws PortalException, SystemException {
		//TODO: PermissionCheck
		return DataViewComponentsLocalServiceUtil.deleteData(dataViewComponentsId);
	}
	
}
