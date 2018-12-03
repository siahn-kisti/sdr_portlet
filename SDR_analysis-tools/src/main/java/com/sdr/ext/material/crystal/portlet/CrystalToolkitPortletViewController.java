package com.sdr.ext.material.crystal.portlet;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.sdr.ext.material.util.CommonStaticInitalize;
import com.sdr.ext.material.util.MaterialFileUtils;
import com.sdr.ext.material.util.MaterialUtils;

@Controller(value = "crystalToolkitPortletViewController")
@RequestMapping("VIEW")
public class CrystalToolkitPortletViewController {

	private static Log log = LogFactoryUtil.getLog(CrystalToolkitPortletViewController.class);

	/**
	 * @Methods Name : render
	 * @작성일 : 2017. 7. 11.
	 * @작성자 : devsky
	 * @변경이력 :
	 * @Method 설명 : CrystalToolkit portlet 기본 렌더 메소드
	 */
	@RenderMapping
	public String render(RenderRequest renderRequest) {

		new CommonStaticInitalize(renderRequest);

		return "analysis-tools/crystal/crystal-toolkit-view";
	}

	/**
	 * @Methods Name : pythonAction
	 * @작성일 : 2017. 7. 11.
	 * @작성자 : devsky
	 * @변경이력 :
	 * @Method 설명 : Python 프로세스 호출
	 */
	@ActionMapping(value="crystalToolkitAction")
	public void crystalToolkitAction(ActionRequest actionRequest, Model model) throws Exception, FileNotFoundException, IOException, InterruptedException {
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);

		String condition = uploadPortletRequest.getParameter("condition");

		Map<String, Object> outputModel = null;

		// Material ID 검색, dataset 첨부 파일 구조 추출
		if (condition.equals("material")) {
			outputModel = MaterialUtils.getCrystalToolkitMaterialOutputModel(uploadPortletRequest);
		}
		// 파일 extract 검색, 업로드 파일 구조 추출, 파일 유효성검사
		else if (condition.equals("extract")) {
			if (MaterialFileUtils.validateFileParamNotEmpty(uploadPortletRequest, "extractFile")) {
				outputModel = MaterialUtils.getCrystalToolkitExtractOutputModel(uploadPortletRequest, "extractFile");
			}
		}
		// Supercell 또는 Substitute
		else {
			outputModel = MaterialUtils.getCrystalToolkitSubstituteOutputModel(uploadPortletRequest);
		}

		outputModel.put("condition", condition);
		model.addAttribute("dm", outputModel);
	}

	/**
	 * @Methods Name : pythonDownload
	 * @작성일 : 2017. 7. 11.
	 * @작성자 : devsky
	 * @변경이력 :
	 * @Method 설명 : crystaltoolkit 파일 다운로드
	 */
	@ResourceMapping(value = "pythonFileDownload")
	public void pythonFileDownload(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws FileNotFoundException, IOException, InterruptedException {
		MaterialUtils.pythonFileDownload(resourceRequest, resourceResponse);
	}

	/**
	 * @Methods Name : jsmolFileRender
	 * @작성일 : 2017. 7. 11.
	 * @작성자 : devsky
	 * @변경이력 :
	 * @Method 설명 : datasetId로 첨부 POSCAR 파일 조회, 에러 시 메시지만 뿌림
	 */
	@ResourceMapping(value = "jsmolFileRender")
	public void jsmolFileRender(
			@RequestParam String condition,
			@RequestParam(required=false, defaultValue="0") long datasetId,
			@RequestParam String outputFileName,
			ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {

		MaterialUtils.jsmolFileOutputStream(condition, datasetId, outputFileName, resourceRequest, resourceResponse);
	}

	/**
	 * @Methods Name : elementsJson
	 * @작성일 : 2017. 7. 11.
	 * @작성자 : devsky
	 * @변경이력 :
	 * @Method 설명 : Substitute 셀렉트박스 원소 목록 호출, 코드 관리 개발 시 DB화 고려
	 */
	@ResourceMapping(value = "elementsJson")
	public void elementsJson(ResourceResponse resourceResponse) {
		MaterialUtils.getWriteRealFileRootPath(resourceResponse, CommonStaticInitalize.getWebappsRealPath() + "/WEB-INF/jsp/analysis-tools/elements-list.json", null);
	}
}