package com.sdr.property;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.portlet.PortletProps;
import com.sdr.ac.PermissionConstant;
import com.sdr.file.PropConst;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;


import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.Map;
import java.util.TreeMap;

@Controller
@RequestMapping("VIEW")
public class PropertySetting  {

    private static Log _log = LogFactoryUtil.getLog(PropertySetting.class);

    @RenderMapping
    public String getProperty(RenderRequest request, RenderResponse response, Model model)
            throws PortalException, SystemException{
        _log.debug("### getProperty render");

        ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
        boolean isAdmin = PermissionConstant.checkAdmin(serviceContext, serviceContext.getScopeGroupId());
        model.addAttribute("isAdmin", isAdmin);
        if ( isAdmin ) {
            Map<String, String> propMap = PropConst.getPropMap();
            Map<String, String> treeMap = new TreeMap<>(propMap);
            _log.debug("map : " + treeMap);
            model.addAttribute("propMap", treeMap);
        }
        return "property/view";
    }


    @ActionMapping(value = "save")
    public void save(ActionRequest request, ActionResponse response, Model model)
            throws PortalException, SystemException{

        ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
        boolean isAdmin = PermissionConstant.checkAdmin(serviceContext, serviceContext.getScopeGroupId());
        model.addAttribute("isAdmin", isAdmin);
        if ( ! isAdmin ) return;

        Map<String, String[]> map = request.getParameterMap();
        Map<String, String> propMap = PropConst.getPropMap();

        for (String key : propMap.keySet() ) {
            if ( map.containsKey( key ) ) {
                if ( ! propMap.get(key).equals( map.get(key)[0])) {
                    _log.debug("value[" + key + "] has been changed from [" + propMap.get(key) + "] to [" + map.get(key)[0] + "]");
                    propMap.put(key, map.get(key)[0]);

                    if (PortletProps.contains(key)) {
                        PortletProps.set(key, map.get(key)[0]);
                    }
                }
            }
        }

    }
}
