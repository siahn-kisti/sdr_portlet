package com.sdr.curation.manage;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.sdr.common.model.PplogicVo;
import com.sdr.common.util.ErrorHandler;
import com.sdr.common.util.SearchStaticInitalize;
import com.sdr.metadata.model.DataType;
import com.sdr.metadata.model.PpLogic;
import com.sdr.metadata.service.DataTypeLocalServiceUtil;
import com.sdr.metadata.service.DataTypeServiceUtil;
import com.sdr.metadata.service.PpLogicLocalServiceUtil;
import com.sdr.metadata.service.PpLogicServiceUtil;
import com.sdr.metadata.util.WebKeys;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/* Let;s avoid Access Control for the Workflow */


/**
 * The type Datatype workflow.
 */

@Controller
@RequestMapping("VIEW")
public class CurationManager {
    private static Log _log = LogFactoryUtil.getLog(CurationManager.class);

	/**
	 * CurationManageMain
	 *
	 * Curation List 조회 화면
	 *
	 * @param keyword
	 * @param renderRequest
	 * @param renderResponse
	 * @param model
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
    @RenderMapping
    public String CurationManageMain(@RequestParam(value = "keyword", required = false) String keyword,
                                     RenderRequest renderRequest, RenderResponse renderResponse, Model model) throws PortalException, SystemException {
        _log.debug("CurationManageMain :::::::::::::::::");

        new SearchStaticInitalize(renderRequest);
        SearchContext searchContext = SearchStaticInitalize.getSearchContext(CurationManager.class);

		PortletURL iteratorURL = renderResponse.createRenderURL();
		iteratorURL.setParameter("keyword", ParamUtil.getString(renderRequest, "keyword"));

        SearchContainer<PpLogic> searchContainer = new SearchContainer<PpLogic>(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchStaticInitalize.getCur(), SearchStaticInitalize.getDelta(), iteratorURL, null, "검색된 데이터가 없습니다.");
        searchContext.setStart(searchContainer.getStart());
        searchContext.setStart(searchContainer.getEnd());

        int count = PpLogicLocalServiceUtil.getPpLogicsCount();
        List<PpLogic> list = PpLogicServiceUtil.getList(searchContainer.getStart(), searchContainer.getEnd(), keyword);
        ServiceContext serviceContext = ServiceContextFactory.getInstance(renderRequest);
        List<DataType> dataTypeList = DataTypeServiceUtil.getList(serviceContext);
        _log.debug("dataTypeList : " + dataTypeList.toString());

        searchContainer.setTotal(count);
        searchContainer.setResults(list);

        model.addAttribute("keyword", keyword);
        model.addAttribute("dataTypeList", dataTypeList);
        model.addAttribute("searchContainer", searchContainer);

        return "curation/manage/list";
    }

	/**
	 * Curation View
	 *
	 * Curation View 화면
	 *
	 * @param pplogicId
	 * @param renderRequest
	 * @param renderResponse
	 * @param model
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
	@RenderMapping(params = "action=view")
	public String view(@RequestParam long pplogicId, RenderRequest renderRequest, RenderResponse renderResponse, Model model) throws PortalException, SystemException {
		_log.debug("CurationManageMain detail Pplogic :::::::::::::::::");

		List<PpLogic> ppLogicList = new ArrayList<PpLogic>();
		if (pplogicId > 0) {
			PpLogic ppLogic = PpLogicServiceUtil.getPpLogic(pplogicId);
			model.addAttribute("vo", ppLogic);
			_log.debug("View ========================>" + ppLogic.toString());
			if(ppLogic.getDataTypeId() > 0){
				DataType dataType = DataTypeLocalServiceUtil.getDataType(ppLogic.getDataTypeId());
				model.addAttribute("dataTypeVo", dataType);
			}

			/*  CurationType composition curation 정보 조회 */
			if(ppLogic.getType() == 3 && ppLogic.getCommand() != null && !StringUtils.isEmpty(ppLogic.getCommand())){
				String[] ppIdTitleList = ppLogic.getCommand().split(",");

				for (int i = 0; i < ppIdTitleList.length; i++){

					PpLogic ppLogic11 = PpLogicServiceUtil.getPpLogic(Long.parseLong(ppIdTitleList[i]));
					if(ppLogic11 != null){
						ppLogicList.add(ppLogic11);
					}

				}
				model.addAttribute("ppLogicList", ppLogicList);
			}
		}
		return "curation/manage/view";
	}

	/**
	 * Curation detail
	 *
	 * Curation 상세 수정 화면
	 *
	 * @param pplogicId
	 * @param renderRequest
	 * @param renderResponse
	 * @param model
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
    @RenderMapping(params = "action=detail")
    public String detail(@RequestParam long pplogicId, RenderRequest renderRequest, RenderResponse renderResponse, Model model) throws PortalException, SystemException {
        _log.debug("CurationManageMain detail Pplogic :::::::::::::::::");

        List<PpLogic> ppLogicList = new ArrayList<PpLogic>();
        if (pplogicId > 0) {
            PpLogic ppLogic = PpLogicServiceUtil.getPpLogic(pplogicId);
            model.addAttribute("vo", ppLogic);
            _log.debug("Detail ========================>" + ppLogic.toString());
            if(ppLogic.getDataTypeId() > 0){
                DataType dataType = DataTypeLocalServiceUtil.getDataType(ppLogic.getDataTypeId());
                model.addAttribute("dataTypeVo", dataType);
            }

			/*  CurationType composition curation 정보 조회 */
			if(ppLogic.getType() == 3 && ppLogic.getCommand() != null && !StringUtils.isEmpty(ppLogic.getCommand())){
                String[] ppIdTitleList = ppLogic.getCommand().split(",");

                for (int i = 0; i < ppIdTitleList.length; i++){

                    PpLogic ppLogic11 = PpLogicServiceUtil.getPpLogic(Long.parseLong(ppIdTitleList[i]));
                    if(ppLogic11 != null){
                        ppLogicList.add(ppLogic11);
                    }

                }
                model.addAttribute("ppLogicList", ppLogicList);
            }
        }
        return "curation/manage/detail";
    }

	/**
	 * Curation Edit
	 *
	 * Curation 등록 화면
	 *
	 * @param pplogicId
	 * @param renderRequest
	 * @param renderResponse
	 * @param model
	 * @return
	 * @throws PortalException
	 * @throws SystemException
	 */
    @RenderMapping(params = "action=edit")
    public String edit(@RequestParam long pplogicId, RenderRequest renderRequest, RenderResponse renderResponse, Model model) throws PortalException, SystemException {
        _log.debug("CurationManager edit :::::::::::::::::" + pplogicId);

        if (pplogicId > 0) {
            PpLogicServiceUtil.getPpLogic(pplogicId);
            model.addAttribute("vo", PpLogicServiceUtil.getPpLogic(pplogicId));
        }
        return "curation/manage/edit";
    }

	/**
	 * Curation DeleteData
	 *
	 * Curation 삭제
	 *
	 * @param request
	 * @param response
	 */
	@ActionMapping(value = "deleteData")
    public void deleteData(ActionRequest request, ActionResponse response) {
        long ppLogicId = ParamUtil.getLong(request, "ppLogicId");
        _log.debug("CurationManager Delete ::::::::::::::::: " + ppLogicId);

        try {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
            PpLogicServiceUtil.deletePpLogic(ppLogicId, serviceContext);
        } catch (PrincipalException e) {
            _log.error("Permission error: " + e.getMessage());
            ErrorHandler.error(request, e);
        } catch (PortalException | SystemException e) {
            _log.error("DataTypeManagement error: " + e.getMessage());
            SessionErrors.add(request, e.getClass(), e.getMessage());
            SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
        }
    }

	/**
	 * PpLogic Save
	 *
	 * PpLogic(Curation) 저장
	 *
	 * @param request
	 * @param response
	 * @param vo
	 */
    @ActionMapping(value = "save")
    public void save(ActionRequest request, ActionResponse response, @ModelAttribute PplogicVo vo) throws IOException, SystemException, PortalException {
        long ppid = vo.getPpId();
		_log.debug("=======> : " + ppid);
        _log.debug("### PpLogic save  vo::: " + vo.toString() + " :::::::::::::::: " + vo.getPpId());

        try {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(PplogicVo.class.getName(), request);

            long ppLogicId = vo.getPpId();
            if (ppLogicId <= 0) {
                PpLogic pplogic = PpLogicServiceUtil.addPpLogic(vo.getTitle(), vo.getDescription(), vo.getType(), vo.getCommand(), vo.getDataTypeId(), serviceContext);
				ppid = pplogic.getPpId();
            } else {
                PpLogicServiceUtil.updatePpLogic(vo.getPpId(), vo.getTitle(), vo.getDescription(), vo.getType(), vo.getCommand(), vo.getDataTypeId(), serviceContext);
            }

        } catch (PrincipalException e) {
            _log.error("Permission error: " + e.getMessage());
            ErrorHandler.error(request, e);
        } catch (PortalException | SystemException e) {
            _log.error("CurationManagement error: " + e.getMessage());
            SessionErrors.add(request, e.getClass(), e.getMessage());
            SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
        }

        // 저장 후 detail 화면으로 이동
		String portletId = "curationmanager_WAR_SDR_baseportlet";
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long plid = PortalUtil.getPlidFromPortletId(themeDisplay.getScopeGroupId(), portletId);
		PortletURL portletURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(request), portletId, plid, PortletRequest.RENDER_PHASE);
		/*portletURL.setParameter("controller", "Collection");*/
		portletURL.setParameter("action", "detail");
		portletURL.setParameter("pplogicId", Long.toString(ppid));
		/*_log.debug("portletURL : " + portletURL.toString());*/
		response.sendRedirect(portletURL.toString());
    }

	/**
	 * validateData
	 *
	 * Curation simpleType validate 체크
	 *
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@ResourceMapping(value = "validateData")
	public void validateData(ResourceRequest request, ResourceResponse response) throws IOException {
		long ppId = ParamUtil.getLong(request, "ppId");
		_log.debug("### validateData ###" + ppId);

		//TODO: 테스트 위한 임시 data
		String validateValue = "{\"result\":4, \"metadata\":[3.59904,3.59904,3.59904]}";
		JSONObject result = new JSONObject();
		result.put("validateValue", validateValue);

		response.getWriter().print(result);
	}

	/**
	 * simpleTest
	 *
	 * Curation simpleType Test
	 *
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@ResourceMapping(value = "simpleTest")
	public void simpleTest(ResourceRequest request, ResourceResponse response) throws IOException {
		long ppId = ParamUtil.getLong(request, "ppId");
		long datasetId = ParamUtil.getLong(request, "datasetId");
		_log.debug("### simpleTest ###" + ppId + " : datasetId : " + datasetId);

		//TODO: 테스트 위한 임시 data
		String simpleTestValue = "{\"result\":0, \"metadata\":[3.59904,3.59904,3.59904]}";
		JSONObject result = new JSONObject();
		result.put("simpleTestValue", simpleTestValue);

		response.getWriter().print(result);
	}

	/**
	 * viewMetadataPopup
	 *
	 * Curation simple Test 후 오류없을 시 viewMetadataPopup 화면
	 *
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RenderMapping(params = "action=viewMetadataPopup")
	public String viewMetadataPopup(RenderRequest request, RenderResponse response, Model model) {
		_log.debug("### viewMetadataPopup ###");
		String descriptionJson = ParamUtil.getString(request, "descriptionJson");

		model.addAttribute("descriptionJson", descriptionJson);

		// File
		String datasetId = ParamUtil.getString(request, "datasetId");
		String datasetLocation = ParamUtil.getString(request, "datasetLocation");
		String metaLocation = ParamUtil.getString(request, "metaLocation");

		model.addAttribute("datasetId", datasetId);
		model.addAttribute("datasetLocation", datasetLocation);
		model.addAttribute("metaLocation", metaLocation);

		return "curation/manage/viewMetadataPopup";
	}

	/**
	 * testDatasetPopup
	 *
	 * Curation simple Test 시 Dataset 선택 Popup
	 *
	 * @param dataTypeId
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 * @throws SystemException
	 */
	@RenderMapping(params = "action=testDatasetPopup")
	public String testDatasetPopup(@RequestParam long dataTypeId, RenderRequest request, RenderResponse response, Model model) throws SystemException, PortalException {
		_log.debug("### testDatasetPopup ###");
		ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
		_log.debug("serviceContext.getUserId() : " + serviceContext.getUserId());
		if(dataTypeId > 0){
			List<DataType> dataTypeList = DataTypeServiceUtil.getList(serviceContext);
			model.addAttribute("dataTypeList", dataTypeList);
		}
		request.setAttribute("dataTypeId", dataTypeId);
		return "curation/manage/testDatasetPopup";
	}

}
