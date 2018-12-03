package com.sdr.pp;


import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.sdr.ac.PermissionConstant;
import com.sdr.metadata.model.PpLogic;
import com.sdr.metadata.model.PpLogicClp;
import com.sdr.metadata.service.PpLogicLocalServiceUtil;
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

@Controller
@RequestMapping("VIEW")
public class ppController {

    private static Log _log = LogFactoryUtil.getLog(ppController.class);

    @RenderMapping
    public String getPP(RenderRequest request, RenderResponse response, Model model)
            throws PortalException, SystemException {
        _log.debug("### getPP render");

        ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
        boolean isAdmin = PermissionConstant.checkAdmin(serviceContext, serviceContext.getScopeGroupId());
        model.addAttribute("isAdmin", isAdmin);

        Map<String, String[]> map = request.getParameterMap();
        String[] ppIdList = map.get("ppId");
        if ((ppIdList==null) || (ppIdList.length==0) || (ppIdList[0].length()==0) ) {
            // do nothing
            PpLogicClp ppl = new PpLogicClp();
            ppl.setPpId(0);
            ppl.setCommand("");
            _log.debug("ppl : " + ppl);
            model.addAttribute("vo", ppl);
        } else {
            long ppId = Long.parseLong(ppIdList[0]);
            PpLogic ppl = PpLogicLocalServiceUtil.getPpLogic(ppId);
            _log.debug("ppl : " + ppl);
            model.addAttribute("vo", ppl);
        }



        return "pp/view";
    }


    @ActionMapping(value = "save")
    public void save(ActionRequest request, ActionResponse response, Model model,
                     @ModelAttribute PpLogicClp vo) throws PortalException, SystemException{

        ServiceContext serviceContext = ServiceContextFactory.getInstance(request);
        boolean isAdmin = PermissionConstant.checkAdmin(serviceContext, serviceContext.getScopeGroupId());
        model.addAttribute("isAdmin", isAdmin);
        if ( ! isAdmin ) return;

        Map<String, String[]> map = request.getParameterMap();



        if ( vo.getPpId() == 0 ) {
            long ppId = CounterLocalServiceUtil.increment();
            _log.debug("### insert=" + ppId);
            vo.setPpId(ppId);
            _log.debug("vo : " + vo);
            PpLogicLocalServiceUtil.addPpLogic(vo);

        }

        /*
        for (String key : map.keySet()) {
            _log.debug("(key)" + key + "(value)" + map.get(key));
        }
        */
    }

}
