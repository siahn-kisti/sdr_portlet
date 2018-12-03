package com.sdr.guide.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetLinkConstants;
import com.sdr.guide.model.Guide;
import com.sdr.guide.model.GuideClp;
import com.sdr.guide.service.base.GuideLocalServiceBaseImpl;
import com.sdr.util.SdrBeanUtils;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the guide local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sdr.guide.service.GuideLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author heesangbb
 * @see com.sdr.guide.service.base.GuideLocalServiceBaseImpl
 * @see com.sdr.guide.service.GuideLocalServiceUtil
 */
public class GuideLocalServiceImpl extends GuideLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.sdr.guide.service.GuideLocalServiceUtil} to access the guide local service.
     */
	
	private static Log log = LogFactoryUtil.getLog(GuideLocalServiceImpl.class);
	
	public List<Guide> getList(int start, int end) throws SystemException, PortalException{
		return guidePersistence.findAll(start, end);
	}
	
	public int getCount() throws SystemException, PortalException{
		return guidePersistence.countAll();
	}
	
	public Guide save(GuideClp vo, Long userId, ServiceContext serviceContext) throws SystemException, PortalException {
		
		long groupId = serviceContext.getScopeGroupId();
		
		User user = userPersistence.findByPrimaryKey(userId);
		Date now = new Date();
		//TODO: validate(name, email, message);

		Guide saveVo = new GuideClp();
		
		long datasetId = vo.getDatasetId();
		if(datasetId>0){
			log.debug("### update=" + datasetId);

			saveVo = guidePersistence.findByPrimaryKey(datasetId);
			SdrBeanUtils.copyProperties(vo, saveVo);
			saveVo.setModifiedDate(now);

		}else{
			datasetId = counterLocalService.increment();
			log.debug("### insert="+ datasetId);

			saveVo = guidePersistence.create(datasetId);
//			saveVo.setUuid(serviceContext.getUuid());		//TODO: create 에서 중복됨, 그리고 값이 null
			SdrBeanUtils.copyProperties(vo, saveVo);
			saveVo.setDatasetId(datasetId);
			saveVo.setUserId(user.getUserId());
			saveVo.setUserName(user.getScreenName());
			saveVo.setCreateDate(now);
			saveVo.setModifiedDate(now);
		}

		log.debug("save:::"+saveVo.toString());
		guidePersistence.update(saveVo);


		resourceLocalService.addResources(user.getCompanyId(), groupId, userId,
				Guide.class.getName(), datasetId, false, true, true);

		AssetEntry assetEntry = assetEntryLocalService.updateEntry(userId,
				groupId, saveVo.getCreateDate(), saveVo.getModifiedDate(),
				Guide.class.getName(), datasetId, saveVo.getUuid(), 0,
				serviceContext.getAssetCategoryIds(),
				serviceContext.getAssetTagNames(), true, null, null, null,
				ContentTypes.TEXT_HTML, saveVo.getDescription(), null, null, null,
				null, 0, 0, null, false);

		assetLinkLocalService.updateLinks(userId, assetEntry.getEntryId(),
				serviceContext.getAssetLinkEntryIds(),
				AssetLinkConstants.TYPE_RELATED);

		return saveVo;
	}
	
	public Guide delete(Long datasetId, Long userId, ServiceContext serviceContext) throws SystemException, PortalException {
		Date now = new Date();
		
		Guide vo = guidePersistence.findByPrimaryKey(datasetId);
		vo.setDeleteDate(now);
		guidePersistence.update(vo);

		//TODO: 테스트용
		guidePersistence.remove(datasetId);

		resourceLocalService.deleteResource(serviceContext.getCompanyId(),
				Guide.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL,
				datasetId);

		AssetEntry assetEntry = assetEntryLocalService.fetchEntry(
				Guide.class.getName(), datasetId);

		assetLinkLocalService.deleteLinks(assetEntry.getEntryId());

		assetEntryLocalService.deleteEntry(assetEntry);

		return vo;
	}
	
}
