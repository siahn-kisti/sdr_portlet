package com.sdr.search.listForMain.dataset;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.sdr.metadata.model.Collection;
import com.sdr.metadata.model.Dataset;
import com.sdr.metadata.model.impl.DatasetModelImpl;
import com.sdr.metadata.service.DatasetLocalServiceUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.List;


/**
 * The type Dataset lfm controller.
 */
@Controller
@RequestMapping("VIEW")
public class DatasetLFMController {

    private static Log _log = LogFactoryUtil.getLog(DatasetLFMController.class);

    /**
     * Data search main string.
     *
     * @param request  the request
     * @param response the response
     * @param model    the model
     * @return the string
     * @throws PortalException the portal exception
     * @throws SystemException the system exception
     */
    @RenderMapping
    public String dataSearchMain(RenderRequest request, RenderResponse response, Model model) {

        _log.debug("### DatasetLFM Main Renderer");

        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

        long groupId = themeDisplay.getScopeGroupId();

        String portletId = "datasearch_WAR_SDR_baseportlet";

        try {
            long plid = PortalUtil.getPlidFromPortletId(groupId, portletId);

            PortletURL portletURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(request), portletId, plid, PortletRequest.RENDER_PHASE);
            portletURL.setParameter("tabs", "Dataset");

            OrderByComparator orderByComparator = OrderByComparatorFactoryUtil.create(DatasetModelImpl.TABLE_NAME, "createDate", false);
            List<Dataset> datasetList = DatasetLocalServiceUtil.getListOrderBy(WorkflowConstants.STATUS_APPROVED, 0, 10, orderByComparator);

            model.addAttribute("datasetList", datasetList);
            model.addAttribute("dataSearchURL", portletURL);

        } catch (PortalException e) {
            e.printStackTrace();
        } catch (SystemException e) {
            e.printStackTrace();
        }

        return "dataSearch/dataset/listForMain/view";
    }
}
