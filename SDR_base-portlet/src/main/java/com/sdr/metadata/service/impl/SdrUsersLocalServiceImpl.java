package com.sdr.metadata.service.impl;

import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.sdr.metadata.model.SdrUsers;
import com.sdr.metadata.model.SdrUsersClp;
import com.sdr.metadata.service.SdrUsersLocalServiceUtil;
import com.sdr.metadata.service.base.SdrUsersLocalServiceBaseImpl;
import com.sdr.metadata.util.SdrBeanUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * The implementation of the sdr users local service.
 *
// * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sdr.metadata.service.SdrUsersLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author jaesung
 * @see com.sdr.metadata.service.base.SdrUsersLocalServiceBaseImpl
 * @see com.sdr.metadata.service.SdrUsersLocalServiceUtil
 */
public class SdrUsersLocalServiceImpl extends SdrUsersLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.sdr.metadata.service.SdrUsersLocalServiceUtil} to access the sdr users local service.
     */
	
	private static Log _log = LogFactoryUtil.getLog(SdrUsersLocalServiceImpl.class);

	/**
	 * Get count
	 * @return int
	 * @throws SystemException
	 * @throws PortalException
	 */
	public int getCount() throws SystemException, PortalException{
		return sdrUsersPersistence.countAll();
	}

	/**
	 * Get list
	 *
	 * @param start
	 * @param end
	 * @return List<SdrUsers>
	 * @throws SystemException
	 */
	public List<SdrUsers> getList(int start, int end) throws SystemException{
		return sdrUsersPersistence.findAll(start, end);
	}

	/**
	 * Get list
	 *
	 * @param start
	 * @param end
	 * @param keyword
	 * @return List<SdrUsers>
	 * @throws SystemException
	 */
	public List<SdrUsers> getList(int start, int end, String keyword) throws SystemException{
		
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(SdrUsers.class);
		Criterion criterion = null;
		if(!StringUtils.isEmpty(keyword)){
			criterion = PropertyFactoryUtil.forName("email").like("%"+keyword+"%");
			criterion = RestrictionsFactoryUtil.or(criterion, PropertyFactoryUtil.forName("lastName").like("%"+keyword+"%"));
			criterion = RestrictionsFactoryUtil.or(criterion, PropertyFactoryUtil.forName("firstName").like("%"+keyword+"%"));
			query.add(criterion);
		}
		query.addOrder(OrderFactoryUtil.asc("lastName"));
		query.addOrder(OrderFactoryUtil.asc("firstName"));
		
		return sdrUsersPersistence.findWithDynamicQuery(query, start, end);
	}

	/**
	 * Save
	 *
	 * @param vo
	 * @param serviceContext
	 * @return SdrUsers
	 * @throws SystemException
	 * @throws PortalException
	 */
	public SdrUsers save(SdrUsersClp vo, ServiceContext serviceContext) throws SystemException, PortalException {
		User user = userPersistence.findByPrimaryKey(serviceContext.getUserId());

		SdrUsers saveVo = new SdrUsersClp();
		
		long userId = vo.getUserId();
		if(userId<=0){
			userId = counterLocalService.increment();
			_log.debug("### insert="+ userId);
			saveVo = sdrUsersPersistence.create(userId);
			SdrBeanUtils.copyProperties(vo, saveVo);
			
			saveVo.setCreateUser(user.getUserId());
			
		}else{
			_log.debug("### update=" + userId);
			saveVo = getSdrUsers(userId);
			SdrBeanUtils.copyProperties(vo, saveVo);
		}
		sdrUsersPersistence.update(saveVo);
		
		return saveVo;
	}

	/**
	 * Delete
	 *
	 * @param userId
	 * @param serviceContext
	 * @throws SystemException
	 * @throws PortalException
	 */
	public void delete(long userId, ServiceContext serviceContext) throws SystemException, PortalException {
		sdrUsersPersistence.remove(userId);
	}

	public void test() throws PortalException, SystemException {

		SdrUsers users = SdrUsersLocalServiceUtil.createSdrUsers(10001);
		SdrUsersLocalServiceUtil.addSdrUsers(users);

		users = SdrUsersLocalServiceUtil.createSdrUsers(10002);
		SdrUsersLocalServiceUtil.addSdrUsers(users);

		//ERROR ==========
		users = SdrUsersLocalServiceUtil.createSdrUsers(10001);
		SdrUsersLocalServiceUtil.addSdrUsers(users);

	}
	
}
