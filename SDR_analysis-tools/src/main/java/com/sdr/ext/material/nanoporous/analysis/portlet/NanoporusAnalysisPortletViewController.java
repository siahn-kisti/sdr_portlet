package com.sdr.ext.material.nanoporous.analysis.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.util.portlet.PortletProps;
import com.sdr.ext.material.util.CommonStaticInitalize;
import com.sdr.ext.material.util.MaterialUtils;
import com.sdr.ext.material.util.SearchStaticInitalize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

@Controller
@RequestMapping("VIEW")
public class NanoporusAnalysisPortletViewController {

    private static Log log = LogFactoryUtil.getLog(NanoporusAnalysisPortletViewController.class);

    @RenderMapping
    public String render() {
        log.debug("###### Render nanoporous analysis portlet");

        return "analysis-tools/nanoporous/nanoporous-analysis-list";
    }

    /**
     * @Methods Name : chartDataJson
     * @작성일 : 2018. 7. 5.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : 차트 데이터 생성
     */
    @ResourceMapping(value = "chartDataJson")
    public void chartDataJson(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
        // Initalize
        new CommonStaticInitalize(resourceRequest);
        new SearchStaticInitalize(resourceRequest);
        MaterialUtils.getSearchDataJsonNanoporousAnalysis(resourceRequest, resourceResponse);
    }
}