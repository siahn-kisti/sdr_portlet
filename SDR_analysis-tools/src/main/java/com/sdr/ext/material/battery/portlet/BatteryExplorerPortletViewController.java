package com.sdr.ext.material.battery.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
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
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.Map;

@Controller
@RequestMapping("VIEW")
public class BatteryExplorerPortletViewController {

    private static Log log = LogFactoryUtil.getLog(BatteryExplorerPortletViewController.class);

    @RenderMapping
    public String render(RenderRequest renderRequest, RenderResponse renderResponse, Model model) throws Exception {
        log.debug("###### Render battery explorer portlet");
        // Initalize
        new CommonStaticInitalize(renderRequest);
        new SearchStaticInitalize(renderRequest);

        Map<String, Object> om = (Map<String, Object>) renderRequest.getAttribute("om");

            if (renderRequest.getAttribute("om") == null) {
                om = MaterialUtils.getParameterMap(renderRequest.getParameterMap());
            }

            if (om != null && om.size() > 0) {
                // 인덱싱된 dataset 검색
                om.putAll(MaterialUtils.getDatasetSearchIndexedResultsBatteryExplorer(om, renderRequest, renderResponse));
            }

            Double voltageMax = (Double) MaterialUtils.getNumericMinMax(Dataset.class, "voltage", Sort.DOUBLE_TYPE, true, "vasp_battery");
            Double voltageMin = (Double) MaterialUtils.getNumericMinMax(Dataset.class, "voltage", Sort.DOUBLE_TYPE, false, "vasp_battery");
            Double volumetricCapacityMax = (Double) MaterialUtils.getNumericMinMax(Dataset.class, "volumetric_capacity", Sort.DOUBLE_TYPE, true, "vasp_battery");
            Double volumetricCapacityMin = (Double) MaterialUtils.getNumericMinMax(Dataset.class, "volumetric_capacity", Sort.DOUBLE_TYPE, false, "vasp_battery");
            Double gravimetricCapacityMax = (Double) MaterialUtils.getNumericMinMax(Dataset.class, "gravimetric_capacity", Sort.DOUBLE_TYPE, true, "vasp_battery");
            Double gravimetricCapacityMin = (Double) MaterialUtils.getNumericMinMax(Dataset.class, "gravimetric_capacity", Sort.DOUBLE_TYPE, false, "vasp_battery");
            Integer elementsCountMax = (Integer) MaterialUtils.getNumericMinMax(Dataset.class,   "nelements", Sort.INT_TYPE, true, "vasp_battery");
            Integer elementsCountMin = (Integer) MaterialUtils.getNumericMinMax(Dataset.class,   "nelements", Sort.INT_TYPE, false, "vasp_battery");

            // Default max and min values
            om.put("avgVoltageDefaultValue", voltageMin + "-" + voltageMax);
            om.put("volumetricCapacityDefaultValue", volumetricCapacityMin + "-" + volumetricCapacityMax);
            om.put("gravimetricCapacityDefaultValue", gravimetricCapacityMin + "-" + gravimetricCapacityMax);
            om.put("nelementsDefaultValue", elementsCountMin + "-" + elementsCountMax);

            model.addAttribute("om", om);

        return "analysis-tools/battery/battery-explorer-list";
    }

    /**
     * @Methods Name : batteryExplorerListAction
     * @작성일 : 2017. 11. 09.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : Battery Explorer List Action
     */
    @ActionMapping(value = "batteryExplorerListAction")
    public void batteryExplorerListAction(ActionRequest actionRequest) throws Exception {
        Map<String, Object> om = MaterialUtils.getParameterMap(actionRequest.getParameterMap());
        actionRequest.setAttribute("om", om);
    }

    /**
     * @Methods Name : batteryExplorerViewAction
     * @작성일 : 2017. 11. 09.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : Battery Explorer View Action
     */
    @ActionMapping(value = "batteryExplorerViewAction")
    public void batteryExplorerViewAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
        Map<String, Object> om = MaterialUtils.getParameterMap(actionRequest.getParameterMap());
        actionRequest.setAttribute("om", om);
        actionResponse.setRenderParameter("action", "viewRender");
    }

    /**
     * @Methods Name : batteryExplorerViewRender
     * @작성일 : 2017. 11. 09.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : Battery Explorer View Render
     */
    @RenderMapping(params = "action=viewRender")
    public String batteryExplorerViewRender(Model model, RenderRequest renderRequest, RenderResponse renderResponse) throws SystemException, PortalException {

        Map<String, Object> om = (Map<String, Object>) renderRequest.getAttribute("om");

        if (renderRequest.getAttribute("om") == null) {
            om = MaterialUtils.getParameterMap(renderRequest.getParameterMap());
        }

        long datasetId = Long.parseLong(om.get("datasetId").toString());

        ServiceContext serviceContext = ServiceContextFactory.getInstance(renderRequest);
        om.putAll(MaterialUtils.getDatasetDescriptiveMetadata(datasetId, serviceContext));

        om.put("batteryData", om.get("stringDescriptiveMetadata").toString());
        model.addAttribute("om", om);

        return "analysis-tools/battery/battery-explorer-view";
    }
}