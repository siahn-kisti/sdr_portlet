package com.sdr.carousel.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sdr.carousel.util.SliderParamUtil;
import com.sdr.carousel.util.SliderUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

@Controller(value = "carouselPortletViewController")
@RequestMapping("VIEW")
public class CarouselPortletViewController {

    private static Log log = LogFactoryUtil.getLog(CarouselPortletViewController.class);

    @RenderMapping
    public String render(Model model, RenderRequest renderRequest, RenderResponse renderResponse) throws PortalException, SystemException {

        String slidesBuilder = SliderUtil.buildSlides(renderRequest, renderResponse);
        String buildSettings = SliderUtil.buildSettings(renderRequest, renderResponse);
        boolean displaySlide = (slidesBuilder != null && !slidesBuilder.trim().equals(""));

        //Slides Themes
        PortletPreferences preferences = SliderUtil.getPreference(renderRequest, null);

        String themeValue = preferences.getValue(SliderParamUtil.SETTINGS_THEME, "default");
        String addCssClassValue = preferences.getValue(SliderParamUtil.SETTINGS_ADDITIONAL_CSS_CLASS, "");
        String widthValue = preferences.getValue(SliderParamUtil.SETTINGS_SLIDE_WIDTH, "750px");
        String heightValue = preferences.getValue(SliderParamUtil.SETTINGS_SLIDE_HEIGHT, "350px");

        themeValue = themeValue.toLowerCase();

        if (themeValue.equals("default")) {
            widthValue = "100%";
            heightValue = "500px";
        } else if (themeValue.equals("materials")) {
            widthValue = "750px";
            heightValue = "350px";
        } else if (themeValue.equals("defcommu")) {
            widthValue = "100%";
            heightValue = "500px";
        }

        model.addAttribute("widthValue", widthValue);
        model.addAttribute("heightValue", heightValue);
        model.addAttribute("displaySlide", displaySlide);
        model.addAttribute("themeValue", themeValue);
        model.addAttribute("addCssClassValue", addCssClassValue);
        model.addAttribute("slidesBuilder", slidesBuilder);
        model.addAttribute("buildSettings", buildSettings);

        return "SDR_carousel/carousel-view";
    }
}