package com.sdr.metadata.service.impl;

import com.liferay.portal.kernel.dao.orm.*;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ServiceContext;
import com.sdr.file.FileConst;
import com.sdr.file.FileService;
import com.sdr.metadata.NoSuchPpLogicException;
import com.sdr.metadata.model.PpLogic;
import com.sdr.metadata.service.base.PpLogicLocalServiceBaseImpl;
import org.springframework.util.StringUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The implementation of the pp logic local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sdr.metadata.service.PpLogicLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author jaesung
 * @see com.sdr.metadata.service.base.PpLogicLocalServiceBaseImpl
 * @see com.sdr.metadata.service.PpLogicLocalServiceUtil
 */
public class PpLogicLocalServiceImpl extends PpLogicLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.sdr.metadata.service.PpLogicLocalServiceUtil} to access the pp logic local service.
     */

    private static Log _log = LogFactoryUtil.getLog(PpLogicLocalServiceImpl.class);

	/**
	 * PpLogic Add
	 *
	 * PpLogic 저장
	 *
	 * @param ppLogic the pp logic
	 * @return
	 * @throws SystemException
	 */
    @Override
    public PpLogic addPpLogic(PpLogic ppLogic) throws SystemException {
        _log.debug("### PpLogicLocalServiceImpl vo " + ppLogic.getTitle());

        long ppidPk = counterLocalService.increment();
        PpLogic saveVo = ppLogicPersistence.create(ppidPk);
        _log.debug("### PpLogicLocalServiceImpl =============> : " + ppLogic.getPpId());

        if(ppLogic.getPpId() <= 0){
            _log.debug("#### INSERT ###");
            saveVo.setTitle(ppLogic.getTitle());
            saveVo.setDescription(ppLogic.getDescription());
            saveVo.setType(ppLogic.getType());
            saveVo.setCommand(ppLogic.getCommand());
            saveVo.setDataTypeId(ppLogic.getDataTypeId());
            ppLogicPersistence.update(saveVo);
        }else{
            _log.debug("#### UPDATE ###");
            ppLogicPersistence.update(ppLogic);
        }
        return ppLogic;
    }

    /**
     * Get PpLogics
     *
	 * PpLogic List 조회
	 *
     * @param start
     * @param end
     * @param keyword
     * @return
     * @throws PortalException
     * @throws SystemException
     */
    public List<PpLogic> getList(int start, int end, String keyword) throws PortalException, SystemException{
		_log.debug("#### PpLogic getList ###");
        DynamicQuery query = DynamicQueryFactoryUtil.forClass(PpLogic.class);

        Criterion criterion = null;

        if(!StringUtils.isEmpty(keyword)){
            criterion = null;
            if (!StringUtils.isEmpty(keyword)) {
                criterion = PropertyFactoryUtil.forName("title").like("%" + keyword + "%");
                query.add(criterion);
            } else {
                criterion = PropertyFactoryUtil.forName("title").like("%" + keyword + "%");
                query.add(criterion);
            }
        }
        query.addOrder(OrderFactoryUtil.desc("ppId"));
        return ppLogicPersistence.findWithDynamicQuery(query, start, end);
    }

    /**
     * Get Cuartions
	 *
	 * Curation composition Type CurationList
     *
     * @param start
     * @param end
     * @param keyword
     * @return
     * @throws PortalException
     * @throws SystemException
     */
    public List<PpLogic> getCompositionList(int start, int end, String keyword) throws PortalException, SystemException{
		_log.debug("#### CompositionList ###");
        DynamicQuery query = DynamicQueryFactoryUtil.forClass(PpLogic.class);

        Criterion criterion = null;

        if(!StringUtils.isEmpty(keyword)){
            criterion = null;
            if(!StringUtils.isEmpty(keyword)){
                criterion = PropertyFactoryUtil.forName("dataTypeId").eq(Long.parseLong(keyword));
                criterion = RestrictionsFactoryUtil.or(criterion, PropertyFactoryUtil.forName("dataTypeId").eq(0L));
                query.add(criterion);
            }else{
                criterion = PropertyFactoryUtil.forName("title").like("%" + keyword + "%");
                query.add(criterion);
            }
        }
        query.addOrder(OrderFactoryUtil.desc("ppId"));
        return ppLogicPersistence.findWithDynamicQuery(query);
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
    public PpLogic addPpLogic(String title, String description,Integer type, String command, Long dataTypeId,
                              ServiceContext serviceContext) throws PortalException, SystemException{
		_log.debug("#### PpLogic addPpLogic ###");
        long ppLogicPk = counterLocalService.increment();
        PpLogic ppLogic = ppLogicPersistence.create(ppLogicPk);

        ppLogic.setTitle(title);
        ppLogic.setDescription(description);
        ppLogic.setType(type);
        ppLogic.setCommand(command);
        ppLogic.setDataTypeId(dataTypeId);

        ppLogic.setUserId(serviceContext.getUserId());

        ppLogicPersistence.update(ppLogic);

        // 파일 생성
        String fileType = fileType(ppLogic.getType());

        File filedir = new File(FileConst.getSubPath(FileService.getRootPath(), FileConst.LOC_TYPE_PP) + File.separator);
        File file = new File(filedir + File.separator + ppLogic.getPpId() + ".logic");
        _log.debug("fileder : " + filedir.getPath());
        _log.debug("filePath : " + file.getPath());

        if(!filedir.exists()){
            filedir.mkdir();
            _log.debug("mkdir : ");
        }

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            _log.debug("Command : " + ppLogic.getCommand());
            bufferedWriter.write(fileType);
			if(ppLogic.getType() == 3){
				List<String> commandList = compositionLine(ppLogic.getCommand());
				for(String commandStr : commandList){
					bufferedWriter.newLine();
					bufferedWriter.write(commandStr);
				}
			}else{
				bufferedWriter.newLine();
				bufferedWriter.write(ppLogic.getCommand());
			}
            bufferedWriter.close();
        } catch (IOException e){
            e.printStackTrace();
        }

        return ppLogic;
    }
    //TODO : TEST 임시
    private List<String> compositionLine(String command){
		List<String> commandList = Arrays.asList(command.split(","));
		return commandList;
	}

    private String fileType(int type){
		String fileType = "#";
		if(type == 1){
			fileType = "#SIMPLE";
		}else if(type == 2){
			fileType = "#CONTAINER";
		}else if(type == 3){
			fileType = "#COMPOSITION";
		};
    	return fileType;
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
        PpLogic ppLogic = getPpLogic(ppLogicId);
		_log.debug("#### PpLogic updatePpLogic ###" + ppLogic.getType());

        ppLogic.setTitle(title);
        ppLogic.setDescription(description);
        ppLogic.setType(type);
        ppLogic.setCommand(command);
        ppLogic.setDataTypeId(dataTypeId);

        ppLogicPersistence.update(ppLogic);

        // 파일 생성
		String fileType = fileType(ppLogic.getType());

        File filedir = new File(FileConst.getSubPath(FileService.getRootPath(), FileConst.LOC_TYPE_PP) + File.separator);
        File file = new File(filedir + File.separator + ppLogic.getPpId() + ".logic");
        _log.debug("fileDirPath : " + filedir.getPath());
        _log.debug("filePath : " + file.getPath());
        if(!filedir.exists()){
            filedir.mkdir();
            _log.debug("mkdir : ");
        }

        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(fileType);
			if(ppLogic.getType() == 3){
				String commandValue = ppLogic.getCommand().replace(",", "\r\n");
				bufferedWriter.newLine();
				bufferedWriter.write(commandValue);
			}else{
				bufferedWriter.newLine();
				bufferedWriter.write(ppLogic.getCommand());
			}
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ppLogic;
    }

    /**
     * Get PpLogic Count
	 *
	 * PpLogic Count
     *
     * @return
     * @throws SystemException
     */
    public int getPpLogicsCount() throws SystemException {
        return ppLogicPersistence.countAll();
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
    public PpLogic deletePplogic(long ppLogicId, ServiceContext serviceContext) throws SystemException, NoSuchPpLogicException{
		_log.debug("#### Delete PpLogic ###" + ppLogicId);

        // 파일 삭제
		File filedir = new File(FileConst.getSubPath(FileService.getRootPath(), FileConst.LOC_TYPE_PP) + File.separator);
		File file = new File(filedir + File.separator + ppLogicId + ".logic");

        if(file.exists()){
            if(file.delete()){
                _log.debug("File Delete Success");
            }else{
                _log.debug("File Delete Failed");
            }
        }else{
            _log.debug("No File ");
        }
        return ppLogicPersistence.remove(ppLogicId);
    }

	/**
	 * CurationListPopup
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
		_log.debug("#### CuraationListPopup ###" + dataTypeId);

		DynamicQuery query = curationListQuery(keyword, dataTypeId);

		query.addOrder(OrderFactoryUtil.desc("ppId"));
		return ppLogicPersistence.findWithDynamicQuery(query, start, end);
	}

	/**
	 * curationListQuery
	 *
	 * 데이터 타입 등록 수정 화면에서 curation 선택 팝업에서 사용
	 *
	 * @param keyword
	 * @param dataTypeId
	 * @return
	 */
	private DynamicQuery curationListQuery(String keyword, long dataTypeId){
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(PpLogic.class);
		Criterion criterion = null;
		if(!StringUtils.isEmpty(keyword) || dataTypeId != 0){
			criterion = null;
			if(!StringUtils.isEmpty(keyword) && dataTypeId == 0){ // keyword
				criterion = PropertyFactoryUtil.forName("title").like("%" + keyword + "%");
				query.add(criterion);
			}else if(StringUtils.isEmpty(keyword) && dataTypeId != 0){ // dataTypeId
				criterion = PropertyFactoryUtil.forName("dataTypeId").eq(dataTypeId);
				criterion = RestrictionsFactoryUtil.or(criterion, PropertyFactoryUtil.forName("dataTypeId").eq(0L));
				query.add(criterion);
			}else if(!StringUtils.isEmpty(keyword) && dataTypeId != 0){ // keyword, dataTypeId
				criterion = PropertyFactoryUtil.forName("dataTypeId").eq(dataTypeId);
				criterion = RestrictionsFactoryUtil.or(criterion, PropertyFactoryUtil.forName("dataTypeId").eq(0L));
				criterion = RestrictionsFactoryUtil.and(criterion, PropertyFactoryUtil.forName("title").like("%" + keyword + "%"));
				query.add(criterion);
			}else{
				criterion = PropertyFactoryUtil.forName("title").like("%" + keyword + "%");
				query.add(criterion);
			}
		}
		return query;
	}

	/**
	 * CourationListPopup Count
	 *
	 * 데이터 타입 등록 수정 화면에서 curation 선택 팝업에서 사용
	 *
	 * @param keyword
	 * @param dataTypeId
	 * @return
	 * @throws SystemException
	 */
	public int getCount(String keyword, long dataTypeId) throws SystemException{
		_log.debug("#### CourationListPopup Count ### dataTypeId : " + dataTypeId + " : keyword : " + keyword);

		DynamicQuery query = curationListQuery(keyword, dataTypeId);

		return (int) ppLogicPersistence.countWithDynamicQuery(query);
	}

	/**
	 * CurationListPopup
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
		_log.debug("#### CuraationListPopup ###" + dataTypeId);

		DynamicQuery query = curationListQuery(keyword, dataTypeId, popupFlag);

        query.addOrder(OrderFactoryUtil.desc("ppId"));
        return ppLogicPersistence.findWithDynamicQuery(query, start, end);
    }

	/**
	 * curationListQuery
	 *
	 * popupFlag에 따라 curation 등록수정 화면, workflow curate 시 팝업 조회 조건 변경
	 *
	 * @param keyword
	 * @param dataTypeId
	 * @return
	 */
    private DynamicQuery curationListQuery(String keyword, long dataTypeId, String popupFlag){
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(PpLogic.class);
		Criterion criterion = null;

		//TODO curation, workflow 조회 조건에 따라 나누기
		if(popupFlag != null && !"".equals(popupFlag) && "collection".equals(popupFlag)){

			if(!StringUtils.isEmpty(keyword) && dataTypeId == 0){ // keyword
				_log.debug("==================> 1");
				criterion = PropertyFactoryUtil.forName("title").like("%" + keyword + "%");
				query.add(criterion);
			}else if(StringUtils.isEmpty(keyword) && dataTypeId != 0){ // dataTypeId
				_log.debug("==================> 2");
				criterion = PropertyFactoryUtil.forName("dataTypeId").eq(dataTypeId);
				query.add(criterion);
			}else if(!StringUtils.isEmpty(keyword) && dataTypeId != 0){ // keyword, dataTypeId
				_log.debug("==================> 3");
				criterion = PropertyFactoryUtil.forName("dataTypeId").eq(dataTypeId);
				criterion = RestrictionsFactoryUtil.and(criterion, PropertyFactoryUtil.forName("title").like("%" + keyword + "%"));
				query.add(criterion);
			}else{
				_log.debug("==================> 4");
				criterion = PropertyFactoryUtil.forName("title").like("%" + keyword + "%");
				query.add(criterion);
			}

		}else{
			if(!StringUtils.isEmpty(keyword) && dataTypeId == 0){ // keyword
				_log.debug("################################### 1");
				criterion = PropertyFactoryUtil.forName("title").like("%" + keyword + "%");
				query.add(criterion);
			}else if(StringUtils.isEmpty(keyword) && dataTypeId != 0){ // dataTypeId
				_log.debug("################################### 2");
				criterion = PropertyFactoryUtil.forName("dataTypeId").eq(dataTypeId);
				criterion = RestrictionsFactoryUtil.or(criterion, PropertyFactoryUtil.forName("dataTypeId").eq(0L));
				query.add(criterion);
			}else if(!StringUtils.isEmpty(keyword) && dataTypeId != 0){ // keyword, dataTypeId
				_log.debug("################################### 3");
				criterion = PropertyFactoryUtil.forName("dataTypeId").eq(dataTypeId);
				criterion = RestrictionsFactoryUtil.or(criterion, PropertyFactoryUtil.forName("dataTypeId").eq(0L));
				criterion = RestrictionsFactoryUtil.and(criterion, PropertyFactoryUtil.forName("title").like("%" + keyword + "%"));
				query.add(criterion);
			}else{
				_log.debug("################################### 4");
				criterion = PropertyFactoryUtil.forName("title").like("%" + keyword + "%");
				query.add(criterion);
			}
		}
		return query;
	}

	/**
	 * CourationListPopup Count
	 *
	 * popupFlag에 따라 curation 등록수정 화면, workflow curate 시 팝업 조회 조건 변경
	 *
	 * @param keyword
	 * @param dataTypeId
	 * @param popupFlag
	 * @return
	 * @throws SystemException
	 */
    public int getCount(String keyword, long dataTypeId, String popupFlag) throws SystemException{
		_log.debug("#### CourationListPopup Count ### dataTypeId : " + dataTypeId + " : keyword : " + keyword);

        DynamicQuery query = curationListQuery(keyword, dataTypeId, popupFlag);

        return (int) ppLogicPersistence.countWithDynamicQuery(query);
    }

	public int getCount(String keyword) throws SystemException{
		_log.debug("#### CourationListPopup Count ### keyword : " + keyword);

		DynamicQuery query = DynamicQueryFactoryUtil.forClass(PpLogic.class);
		Criterion criterion = null;
		if (!StringUtils.isEmpty(keyword)) {
			criterion = PropertyFactoryUtil.forName("title").like("%" + keyword + "%");
			query.add(criterion);
		}
		query.addOrder(OrderFactoryUtil.asc("title"));

		return (int) ppLogicPersistence.countWithDynamicQuery(query);
	}

}
