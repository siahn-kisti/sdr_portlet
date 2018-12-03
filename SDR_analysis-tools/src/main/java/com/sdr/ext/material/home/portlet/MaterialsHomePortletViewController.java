package com.sdr.ext.material.home.portlet;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.sdr.metadata.service.CollectionLocalServiceUtil;
import com.sdr.metadata.service.DatasetLocalServiceUtil;
import com.sdr.metadata.service.persistence.DatasetPersistence;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;


@Controller
@RequestMapping("VIEW")
public class MaterialsHomePortletViewController {

    private static Log _log = LogFactoryUtil.getLog(MaterialsHomePortletViewController.class);

    @RenderMapping
    public String render(RenderRequest request, RenderResponse response, Model model) throws SystemException, PortalException {
        _log.debug("### MaterialsHomePortletViewController render");

        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

        long scopeGroupId = themeDisplay.getScopeGroupId();

        model.addAttribute("collectionCnt", CollectionLocalServiceUtil.getCount(scopeGroupId));
        //승인된 수량만 나오게
        model.addAttribute("datasetCnt", DatasetLocalServiceUtil.getCount(scopeGroupId, 0, 0, WorkflowConstants.STATUS_APPROVED));
        //해당 커뮤니티에 속한 전체 수량
//		model.addAttribute("datasetCnt", DatasetLocalServiceUtil.getCountByGroupId(scopeGroupId));
        model.addAttribute("userCnt", UserLocalServiceUtil.getGroupUsersCount(scopeGroupId));


        return "analysis-tools/home/materials-home-view";
    }
}
