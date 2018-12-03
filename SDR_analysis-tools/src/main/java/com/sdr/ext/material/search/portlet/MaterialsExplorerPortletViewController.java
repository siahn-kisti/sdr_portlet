package com.sdr.ext.material.search.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.util.PortalUtil;
import com.sdr.ext.material.util.CommonStaticInitalize;
import com.sdr.ext.material.util.MaterialUtils;
import com.sdr.ext.material.util.SearchStaticInitalize;
import com.sdr.metadata.model.Dataset;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.Map;

@Controller
@RequestMapping("VIEW")
public class MaterialsExplorerPortletViewController {

    private static Log log = LogFactoryUtil.getLog(MaterialsExplorerPortletViewController.class);

    @RenderMapping
    public String render(RenderRequest renderRequest, RenderResponse renderResponse, Model model) {
        log.debug("###### Render materials explorer portlet");
        // Initalize
        new CommonStaticInitalize(renderRequest);
        new SearchStaticInitalize(renderRequest);

        Map<String, Object> om = (Map<String, Object>) renderRequest.getAttribute("om");

        try {
            if (renderRequest.getAttribute("om") == null) {
                om = MaterialUtils.getParameterMap(renderRequest.getParameterMap());
            }

            if (om != null && om.size() > 0) {
                // 인덱싱된 dataset 검색
                om.putAll(MaterialUtils.getDatasetSearchIndexedResultsMaterialsExplorer(om, renderRequest, renderResponse));

                if (om.get("condition").equals("extract")) {
                    // extract 3. 검색된 dataset들의 첨부파일 정보 추출
                    om.putAll(MaterialUtils.getSameResultsUploadedFilesMaterialExplorer(om, renderRequest, renderResponse));
                }
            }

            Double densityMax = (Double) MaterialUtils.getNumericMinMax(Dataset.class,   "density", Sort.DOUBLE_TYPE, true, "materials");
            Double densityMin = (Double) MaterialUtils.getNumericMinMax(Dataset.class,  "density", Sort.DOUBLE_TYPE, false, "materials");
            Integer elementsCountMax = (Integer) MaterialUtils.getNumericMinMax(Dataset.class,   "nelements", Sort.INT_TYPE, true, "materials");
            Integer elementsCountMin = (Integer) MaterialUtils.getNumericMinMax(Dataset.class,   "nelements", Sort.INT_TYPE, false, "materials");
            Double bandgapMax = (Double) MaterialUtils.getNumericMinMax(Dataset.class,   "bandgap", Sort.DOUBLE_TYPE, true, "materials");
            Double bandgapMin = (Double) MaterialUtils.getNumericMinMax(Dataset.class,   "bandgap", Sort.DOUBLE_TYPE, false, "materials");
            Double volumeMax = (Double) MaterialUtils.getNumericMinMax(Dataset.class,   "volume", Sort.DOUBLE_TYPE, true, "materials");
            Double volumeMin = (Double) MaterialUtils.getNumericMinMax(Dataset.class,   "volume", Sort.DOUBLE_TYPE, false, "materials");

            // Default max and min values
            om.put("densityDefaultValue", densityMin + "-" + densityMax);
            om.put("nelementsDefaultValue", elementsCountMin + "-" + elementsCountMax);
            om.put("bandgapDefaultValue", bandgapMin + "-" + bandgapMax);
            om.put("volumeDefaultValue", volumeMin + "-" + volumeMax);

            model.addAttribute("om", om);

        } catch (SearchException se) {
            SessionErrors.add(renderRequest, se.getClass(), "Access Denied");
            SessionMessages.add(renderRequest, PortalUtil.getPortletId(renderRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
        } catch (Exception e) {
            SessionErrors.add(renderRequest, e.getClass(), e.getMessage());
            SessionMessages.add(renderRequest, PortalUtil.getPortletId(renderRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
        }

        return "analysis-tools/search/materials-explorer-view";
    }

    /**
     * @Methods Name : materialsExplorerAction
     * @작성일 : 2017. 7. 11.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : Materials Explorer Action
     */
    @ActionMapping(value = "materialsExplorerAction")
    public void materialsExplorerAction(ActionRequest actionRequest) throws Exception {
        UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
        Map<String, Object> om = MaterialUtils.getParameterMap(uploadPortletRequest.getParameterMap());

        if (om.get("condition").equals("extract")) {
            // 전처리를 통해 reducedformula 와 nsites 값을 추출 (Crystal toolkit 파일 extract 활용)
            om.putAll(MaterialUtils.getCrystalToolkitExtractOutputModel(PortalUtil.getUploadPortletRequest(actionRequest), "extractFile"));
        }
        actionRequest.setAttribute("om", om);
    }
}