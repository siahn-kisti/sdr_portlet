package com.sdr.metadata.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.ServiceContext;
import com.sdr.metadata.NoSuchPpLogicException;
import com.sdr.metadata.model.PpLogic;
import com.sdr.metadata.service.PpLogicLocalServiceUtil;
import com.sdr.metadata.service.base.PpLogicServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the pp logic remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sdr.metadata.service.PpLogicService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author jaesung
 * @see com.sdr.metadata.service.base.PpLogicServiceBaseImpl
 * @see com.sdr.metadata.service.PpLogicServiceUtil
 */
public class PpLogicServiceImpl extends PpLogicServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.sdr.metadata.service.PpLogicServiceUtil} to access the pp logic remote service.
     */

    /**
     * Get PpLogics
	 *
	 * PpLogics List 조회
     *
     * @param start
     * @param end
     * @param keyword
     * @return
     * @throws PortalException
     * @throws SystemException
     */
     public List<PpLogic> getList(int start, int end, String keyword) throws PortalException, SystemException{
        //TODO: PermissionCheck
        return PpLogicLocalServiceUtil.getList(start, end, keyword);
    }

    /**
     * Get Cuaration List
     *
	 * Curation composition Type Curation ListPopup
	 *
     * @param start
     * @param end
     * @param keyword
     * @return
     * @throws PortalException
     * @throws SystemException
     */
    public List<PpLogic> getCompositionList(int start, int end, String keyword) throws PortalException, SystemException{
        //TODO: PermissionCheck
        return PpLogicLocalServiceUtil.getCompositionList(start, end, keyword);
    }

    /**
     * Get PpLogic
	 *
	 * PpLogic 단건 조회
     *
     * @param ppLogicId
     * @return
     * @throws PortalException
     * @throws SystemException
     */
    public PpLogic getPpLogic(long ppLogicId) throws PortalException, SystemException{
        //TODO: PermissionCheck
         return PpLogicLocalServiceUtil.getPpLogic(ppLogicId);
    }

    /**
     * Add PpLogic
	 *
	 * PpLogic 저장
     *
     * @param title
     * @param description
     * @param type
     * @param command
     * @param dataTypeId
     * @param serviceContext
     * @return
     * @throws PortalException
     * @throws SystemException
     */
    public PpLogic addPpLogic(String title, String description, Integer type, String command, Long dataTypeId,
                              ServiceContext serviceContext) throws PortalException, SystemException {
        //TODO: PermissionCheck
        return PpLogicLocalServiceUtil.addPpLogic(title, description, type, command, dataTypeId, serviceContext);
    }

    /**
     * update PpLogic
	 *
	 * PpLogic 수정
     *
     * @param ppLogicId
     * @param title
     * @param description
     * @param type
     * @param command
     * @param dataTypeId
     * @param serviceContext
     * @return
     * @throws PortalException
     * @throws SystemException
     */
    public PpLogic updatePpLogic(Long ppLogicId, String title, String description,Integer type, String command, Long dataTypeId,
                              ServiceContext serviceContext) throws PortalException, SystemException{
        //TODO: PermissionCheck
        return PpLogicLocalServiceUtil.updatePpLogic(ppLogicId, title, description, type, command, dataTypeId, serviceContext);
    }

    /**
     * delete PpLogic
	 *
	 * PpLogic 삭제
     *
     * @param ppLogicId
     * @param serviceContext
     * @return
     * @throws SystemException
     * @throws NoSuchPpLogicException
     */
    public PpLogic deletePpLogic(long ppLogicId, ServiceContext serviceContext) throws SystemException, NoSuchPpLogicException{
        //TODO: PermissionCheck
        return PpLogicLocalServiceUtil.deletePplogic(ppLogicId, serviceContext);
    }

    /**
     * Get PpLogic Count
	 *
	 * PpLogic Count
     *
     * @return
     * @throws SystemException
     */
    public int getPpLogicsCount() throws SystemException{
         return PpLogicLocalServiceUtil.getPpLogicsCount();
    }

	/**
	 * Get List
	 *
	 * 데이터 타입 등록 수정 화면에서 curation 선택 팝업에서 사용
	 *
	 * @param start
	 * @param end
	 * @param keyword
	 * @param dataTypeId
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	public List<PpLogic> getList(int start, int end, String keyword, long dataTypeId) throws PortalException, SystemException{
		//TODO: PermissionCheck
		return PpLogicLocalServiceUtil.getList(start, end, keyword, dataTypeId);
	}

	/**
	 * Get Count
	 *
	 * 데이터 타입 등록 수정 화면에서 curation 선택 팝업에서 사용
	 *
	 * @param keyword
	 * @param dataType
	 * @return
	 * @throws SystemException
	 */
	public int getCount(String keyword, long dataType) throws SystemException{
		return PpLogicLocalServiceUtil.getCount(keyword, dataType);
	}

	/**
	 * getList
	 *
	 * popupFlag에 따라 curation 등록수정 화면, workflow curate 시 팝업 조회 조건 변경
	 *
 	 * @param start
	 * @param end
	 * @param keyword
	 * @param dataTypeId
	 * @param popupFlag
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
    public List<PpLogic> getList(int start, int end, String keyword, long dataTypeId, String popupFlag) throws PortalException, SystemException{
        //TODO: PermissionCheck
        return PpLogicLocalServiceUtil.getList(start, end, keyword, dataTypeId, popupFlag);
    }

	/**
	 * Get Count
	 *
	 * popupFlag에 따라 curation 등록수정 화면, workflow curate 시 팝업 조회 조건 변경
	 *
	 * @param keyword
	 * @param dataType
	 * @param popupFlag
	 * @return
	 * @throws SystemException
	 */
    public int getCount(String keyword, long dataType, String popupFlag) throws SystemException{
        return PpLogicLocalServiceUtil.getCount(keyword, dataType, popupFlag);
    }

	/**
	 * Get Count
	 *
	 * @param keyword
	 * @return
	 * @throws SystemException
	 */
	public int getCount(String keyword) throws SystemException{
		return PpLogicLocalServiceUtil.getCount(keyword);
	}

}
