package com.sdr.ext.material.phase.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sdr.ext.material.util.CommonStaticInitalize;
import com.sdr.ext.material.util.MaterialUtils;
import com.sdr.ext.material.util.SearchStaticInitalize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.IOException;

@Controller
@RequestMapping("VIEW")
public class PhaseDiagramPortletViewController {

    private static Log log = LogFactoryUtil.getLog(PhaseDiagramPortletViewController.class);

    @RenderMapping
    public String render() throws Exception {
        log.debug("##### Render phase diagram portlet");
        return "analysis-tools/phase/phase-diagram-view";
    }

    /**
     * @Methods Name : chartDataJson
     * @작성일 : 2017. 8. 21.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : 차트 데이터 생성
     */
    @ResourceMapping(value = "chartDataJson")
    public void chartDataJson(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
            throws PortalException, SystemException, IOException {
        // Initalize
        new CommonStaticInitalize(resourceRequest);
        new SearchStaticInitalize(resourceRequest);
        MaterialUtils.getSearchDataJsonPhaseDiagram(resourceRequest, resourceResponse);
    }
}