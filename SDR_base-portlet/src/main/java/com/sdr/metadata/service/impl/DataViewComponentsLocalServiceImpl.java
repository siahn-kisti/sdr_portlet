package com.sdr.metadata.service.impl;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ServiceContext;
import com.sdr.metadata.model.DataViewComponents;
import com.sdr.metadata.service.base.DataViewComponentsLocalServiceBaseImpl;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the data view components local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sdr.metadata.service.DataViewComponentsLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author jaesung
 * @see com.sdr.metadata.service.base.DataViewComponentsLocalServiceBaseImpl
 * @see com.sdr.metadata.service.DataViewComponentsLocalServiceUtil
 */
public class DataViewComponentsLocalServiceImpl
    extends DataViewComponentsLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.sdr.metadata.service.DataViewComponentsLocalServiceUtil} to access the data view components local service.
     */

	private static Log _log = LogFactoryUtil.getLog(DataViewComponentsLocalServiceImpl.class);

	/**
	 * Gets count.
	 *
	 * @param keyword the keyword
	 * @return the count
	 * @throws SystemException the system exception
	 */
	public int getCount(String keyword, String status) throws SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(DataViewComponents.class);
		Criterion criterion = RestrictionsFactoryUtil.gt("dataViewComponentsId", new Long(-1));

		if (!StringUtils.isEmpty(keyword)) {
			Criterion tmp = PropertyFactoryUtil.forName("compGroup").like("%" + keyword + "%");
			tmp = RestrictionsFactoryUtil.or(tmp, PropertyFactoryUtil.forName("compName").like("%" + keyword + "%"));
			tmp = RestrictionsFactoryUtil.or(tmp, PropertyFactoryUtil.forName("description").like("%" + keyword + "%"));
			criterion = RestrictionsFactoryUtil.and(criterion, tmp);
		}

		if (!StringUtils.isEmpty(status)) {
			criterion = RestrictionsFactoryUtil.and(criterion, PropertyFactoryUtil.forName("status").eq(Integer.parseInt(status)));
		}

		query.add(criterion);

		return (int) dataViewComponentsPersistence.countWithDynamicQuery(query);
	}

	/**
	 * Gets list.
	 *
	 * @param start   the start
	 * @param end     the end
	 * @param keyword the keyword
	 * @return the list
	 * @throws PortalException the portal exception
	 * @throws SystemException the system exception
	 */
	public List<DataViewComponents> getList(int start, int end, String keyword, String status) throws PortalException, SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(DataViewComponents.class);
		Criterion criterion = RestrictionsFactoryUtil.gt("dataViewComponentsId", new Long(-1));
		
		if (!StringUtils.isEmpty(keyword)) {
			Criterion tmp = PropertyFactoryUtil.forName("compGroup").like("%" + keyword + "%");
			tmp = RestrictionsFactoryUtil.or(tmp, PropertyFactoryUtil.forName("compName").like("%" + keyword + "%"));
			tmp = RestrictionsFactoryUtil.or(tmp, PropertyFactoryUtil.forName("description").like("%" + keyword + "%"));
			criterion = RestrictionsFactoryUtil.and(criterion, tmp);
		}

		if (!StringUtils.isEmpty(status)) {
			criterion = RestrictionsFactoryUtil.and(criterion, PropertyFactoryUtil.forName("status").eq(Integer.parseInt(status)));
		}

		query.add(criterion);
		query.addOrder(OrderFactoryUtil.asc("compGroup"));
		query.addOrder(OrderFactoryUtil.asc("compName"));

		return dataViewComponentsPersistence.findWithDynamicQuery(query, start, end);
	}

	/**
	 * Add data data view components.
	 *
	 * @param compGroup      the comp group
	 * @param compName       the comp name
	 * @param image          the image
	 * @param html           the html
	 * @param script         the script
	 * @param properties     the properties
	 * @param description    the description
	 * @param orderNo        the order no
	 * @param status         the status
	 * @param serviceContext the service context
	 * @return the data view components
	 * @throws PortalException the portal exception
	 * @throws SystemException the system exception
	 */
	public DataViewComponents addData(String compGroup, String compName, String image, String html, String script, String properties, 
									  String description, Integer orderNo, Integer status,
									  ServiceContext serviceContext) throws PortalException, SystemException {
		long dataViewComponentsPk = counterLocalService.increment();
		DataViewComponents vo = dataViewComponentsPersistence.create(dataViewComponentsPk);

		vo.setCompGroup(compGroup);
		vo.setCompName(compName);
		vo.setImage(image);
		vo.setHtml(html);
		vo.setScript(script);
		vo.setProperties(properties);
		vo.setDescription(description);
		vo.setOrderNo(orderNo);
		vo.setDescription(description);
		vo.setOrderNo(orderNo);

		vo.setUserId(serviceContext.getUserId());
		vo.setCreateDate(new Date());
		vo.setModifiedDate(new Date());
		vo.setStatus(status);

		dataViewComponentsPersistence.update(vo);

		return vo;

	}

	/**
	 * Update data data view components.
	 *
	 * @param dataViewComponentsId the data view components id
	 * @param compGroup            the comp group
	 * @param compName             the comp name
	 * @param image                the image
	 * @param html                 the html
	 * @param script               the script
	 * @param properties           the properties
	 * @param description          the description
	 * @param orderNo              the order no
	 * @param status               the status
	 * @param serviceContext       the service context
	 * @return the data view components
	 * @throws PortalException the portal exception
	 * @throws SystemException the system exception
	 */
	public DataViewComponents updateData(long dataViewComponentsId, 
										 String compGroup, String compName, String image, String html, String script, String properties, 
										 String description, Integer orderNo, Integer status, 
										 ServiceContext serviceContext) throws PortalException, SystemException {

		DataViewComponents vo = getDataViewComponents(dataViewComponentsId);

		vo.setCompGroup(compGroup);
		vo.setCompName(compName);
		vo.setImage(image);
		vo.setHtml(html);
		vo.setScript(script);
		vo.setProperties(properties);
		vo.setDescription(description);
		vo.setOrderNo(orderNo);
		vo.setDescription(description);
		vo.setOrderNo(orderNo);

		vo.setModifiedDate(new Date());
		vo.setStatus(status);

		dataViewComponentsPersistence.update(vo);

		return vo;

	}

	/**
	 * Delete data view components.
	 *
	 * @param dataViewComponentsId the data view components id
	 * @return the data view components
	 * @throws PortalException the portal exception
	 * @throws SystemException the system exception
	 */
	public DataViewComponents deleteData(long dataViewComponentsId) throws PortalException, SystemException {
		DataViewComponents vo = getDataViewComponents(dataViewComponentsId);
		dataViewComponentsPersistence.remove(vo);
		return vo;
	}
	
	
}
