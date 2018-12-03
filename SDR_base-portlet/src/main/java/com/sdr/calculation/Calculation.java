package com.sdr.calculation;

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
import com.liferay.portal.util.PortalUtil;
import com.sdr.common.model.GroupRuleVo;
import com.sdr.common.util.ErrorHandler;
import com.sdr.common.util.SearchStaticInitalize;
import com.sdr.metadata.datatype.DataTypeVo;
import com.sdr.metadata.model.DataType;
import com.sdr.metadata.model.DatatypeRule;
import com.sdr.metadata.model.GroupRule;
import com.sdr.metadata.service.DataTypeServiceUtil;
import com.sdr.metadata.service.DatatypeRuleServiceUtil;
import com.sdr.metadata.service.GroupRuleServiceUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.List;


/* Let;s avoid Access Control for the Workflow */


/**
 * The type Datatype workflow.
 */

@Controller
@RequestMapping("VIEW")
public class Calculation {
    private static Log _log = LogFactoryUtil.getLog(Calculation.class);

	/**
	 * GroupRule List
	 *
	 * GroupRule List 조회
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
    public String CalculationMain(@RequestParam(value = "keyword", required = false) String keyword,
                                     RenderRequest renderRequest, RenderResponse renderResponse, Model model) throws PortalException, SystemException {
        _log.debug("Calculation Main ::::::::::::::::: keyword : " + keyword);

		new SearchStaticInitalize(renderRequest);
		SearchContext searchContext = SearchStaticInitalize.getSearchContext(Calculation.class);

		PortletURL iteratorURL = renderResponse.createRenderURL();
		iteratorURL.setParameter("keyword", ParamUtil.getString(renderRequest, "keyword"));

		SearchContainer<GroupRule> searchContainer = new SearchContainer<GroupRule>(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, SearchStaticInitalize.getCur(), SearchStaticInitalize.getDelta(), iteratorURL, null, "검색된 데이터가 없습니다.");
		searchContext.setStart(searchContainer.getStart());
		searchContext.setStart(searchContainer.getEnd());

		List<GroupRule> list = GroupRuleServiceUtil.getList(searchContainer.getStart(), searchContainer.getEnd(), keyword);
		int count = GroupRuleServiceUtil.getCount(keyword);

		searchContainer.setTotal(count);
		searchContainer.setResults(list);

		model.addAttribute("searchContainer", searchContainer);


        return "calculation/list";
    }

	/**
	 * GroupRule View
	 *
	 * GroupRule 상세 정보 조회
	 *
	 * @param grId
	 * @param renderRequest
	 * @param renderResponse
	 * @param model
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	@RenderMapping(params = "action=view")
	public String view(@RequestParam(value = "grId")long grId, RenderRequest renderRequest, RenderResponse renderResponse, Model model) throws SystemException, PortalException {
		_log.debug("Calculation View ::::::::::::::::: grId : " + grId);

		ServiceContext serviceContext = ServiceContextFactory.getInstance(DataTypeVo.class.getName(), renderRequest);

		GroupRule groupRule = GroupRuleServiceUtil.getGroupRule(grId);
		_log.debug("Calculation View ::::::::::::::::: groupRule : " + groupRule.toString());
		model.addAttribute("groupRule", groupRule);

		// dataTypeRule 정보 조회
		DatatypeRule datatypeRule = DatatypeRuleServiceUtil.getGrIdDatatypeRule(grId);
		if(datatypeRule != null){
			model.addAttribute("datatypeRule", datatypeRule);

			// dataType 정보 조회
			if(datatypeRule.getDataTypeId() > 0){
				DataType dataType = DataTypeServiceUtil.getDataType(datatypeRule.getDataTypeId(), serviceContext);
				model.addAttribute("dataType", dataType);
			}
		}

		return "calculation/view";
	}

	/**
	 * GroupRule Edit
	 *
	 * GroupRule 등록 및 수정
	 *
	 * @param grId
	 * @param renderRequest
	 * @param renderResponse
	 * @param model
	 * @return
	 * @throws SystemException
	 * @throws PortalException
	 */
	@RenderMapping(params = "action=edit")
	public String edit(@RequestParam(value = "grId")long grId, RenderRequest renderRequest, RenderResponse renderResponse, Model model) throws SystemException, PortalException {
		_log.debug("Calculation Edit ::::::::::::::::: grId : " + grId + " : dataTypeId : " + renderRequest.getParameter("dataTypeId"));

		ServiceContext serviceContext = ServiceContextFactory.getInstance(DataTypeVo.class.getName(), renderRequest);

		if (grId > 0) {
			GroupRule groupRule = GroupRuleServiceUtil.getGroupRule(grId);
			model.addAttribute("groupRule", groupRule);

			// dataTypeRule 정보 조회
			DatatypeRule datatypeRule = DatatypeRuleServiceUtil.getGrIdDatatypeRule(grId);
			if(datatypeRule != null){
				model.addAttribute("datatypeRule", datatypeRule);
				// dataType 정보 조회
				if(datatypeRule.getDataTypeId() > 0){
					DataType dataType = DataTypeServiceUtil.getDataType(datatypeRule.getDataTypeId(), serviceContext);
					model.addAttribute("dataType", dataType);
				}
			}
		}

    	return "calculation/edit";
	}

	/**
	 * GroupRule Save
	 *
	 * GroupRule 저장
	 *
	 * @param request
	 * @param response
	 * @param vo
	 * @param dataTypeId
	 * @throws SystemException
	 * @throws PortalException
	 */
	@ActionMapping(value = "save")
	public void save(ActionRequest request, ActionResponse response, @ModelAttribute GroupRuleVo vo, @RequestParam(value = "dataTypeId")long dataTypeId) throws SystemException, PortalException {
		_log.debug("Calculation save ::::::::::::::::: vo : " + vo.toString() + " : " + request.getParameter("grId") + " : dataTypeId : " + dataTypeId);

		if(vo.getGrId() <= 0){
			if(dataTypeId <= 0){
				GroupRuleServiceUtil.addGroupRule(vo.getGrId(), vo.getTitle(), vo.getDescription(), vo.getRule(), vo.getViewAttr(), vo.getMergeAttr());
			}else{
				GroupRuleServiceUtil.addGroupRule(vo.getGrId(), vo.getTitle(), vo.getDescription(), vo.getRule(), vo.getViewAttr(), vo.getMergeAttr(), dataTypeId);
			}
		}else{
			if(dataTypeId <= 0){
				GroupRuleServiceUtil.updateGroupRule(vo.getGrId(), vo.getTitle(), vo.getDescription(), vo.getRule(), vo.getViewAttr(), vo.getMergeAttr());
			}else{
				GroupRuleServiceUtil.updateGroupRule(vo.getGrId(), vo.getTitle(), vo.getDescription(), vo.getRule(), vo.getViewAttr(), vo.getMergeAttr(), dataTypeId);
			}
		}

	}

	/**
	 * Delete GroupRule
	 *
	 * GroupRule 삭제
	 *
	 * @param request
	 * @param response
	 */
	@ActionMapping(value = "deleteData")
	public void deleteGroupRule(ActionRequest request, ActionResponse response){
		long grId = ParamUtil.getLong(request, "grId");
		long drId = ParamUtil.getLong(request, "drId");
		_log.debug("Calculation deleteGroupRule ::::::::::::::::: grId : " + grId + " : drId : " + drId);

		try {
			GroupRuleServiceUtil.deleteGroupRule(grId, drId);
		} catch (PrincipalException e) {
			_log.error("Permission error: " + e.getMessage());
			ErrorHandler.error(request, e);
		} catch (PortalException | SystemException e) {
			_log.error("Calculation error: " + e.getMessage());
			SessionErrors.add(request, e.getClass(), e.getMessage());
			SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		}
	}

}
