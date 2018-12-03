package com.sdr.ext.material.home.portlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@Controller
@RequestMapping(value = "VIEW", params = "controller=materialsprivateinfopolicy")
public class MaterialsPrivateinfopolicyController {

    private static Log _log = LogFactoryUtil.getLog(MaterialsPrivateinfopolicyController.class);


    @RenderMapping(params = "action=privateinfopolicy")
    public String privateinfopolicy(RenderRequest request, RenderResponse response, Model model) {
        _log.debug("### privateinfopolicy render ###");

        return "analysis-tools/home/privateinfopolicy";
    }

}
