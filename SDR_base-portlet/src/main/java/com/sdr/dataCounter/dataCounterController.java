package com.sdr.dataCounter;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.UniqueList;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.comparator.GroupIdComparator;
import com.liferay.portal.util.comparator.GroupNameComparator;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.sdr.metadata.service.CollectionLocalServiceUtil;
import com.sdr.metadata.service.CollectionServiceUtil;
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
 * The type Data counter controller.
 */
@Controller
@RequestMapping("VIEW")
public class dataCounterController {

    private static Log _log = LogFactoryUtil.getLog(dataCounterController.class);

    /**
     * Render string.
     *
     * @param request  the request
     * @param response the response
     * @param model    the model
     * @return the string
     * @throws SystemException the system exception
     * @throws PortalException the portal exception
     */
    @RenderMapping
    public String render(RenderRequest request, RenderResponse response, Model model)
            throws SystemException, PortalException, PrincipalException {
        _log.debug("### dataCounter render ###");

        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        long scopeGroupId = themeDisplay.getScopeGroupId();

        ServiceContext serviceContext = ServiceContextFactory.getInstance(request);

        String portletId = "datasearch_WAR_SDR_baseportlet";

        long plid = PortalUtil.getPlidFromPortletId(scopeGroupId, portletId);

        int collectionCnt = 0;
        int datasetCnt = 0;
        int userCnt = 0;
        if (scopeGroupId != GroupLocalServiceUtil.getGroup(themeDisplay.getCompanyId(), GroupConstants.GUEST).getGroupId()) {
            collectionCnt = CollectionServiceUtil.getCount(scopeGroupId, serviceContext);
            datasetCnt = DatasetLocalServiceUtil.getCount(scopeGroupId, 0, 0, WorkflowConstants.STATUS_APPROVED);
            userCnt = UserLocalServiceUtil.getGroupUsersCount(scopeGroupId);
        } else {
            collectionCnt = CollectionLocalServiceUtil.getCount();
            datasetCnt = DatasetLocalServiceUtil.getCount(0, 0, 0, WorkflowConstants.STATUS_APPROVED);
            userCnt = UserLocalServiceUtil.getUsersCount();
        }
        model.addAttribute("collectionURL", PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(request), portletId, plid, PortletRequest.RENDER_PHASE));
        model.addAttribute("collectionCnt", collectionCnt);

        PortletURL portletURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(request), portletId, plid, PortletRequest.RENDER_PHASE);
        portletURL.setParameter("tabs", "Dataset");

        model.addAttribute("datasetURL", portletURL);
        model.addAttribute("datasetCnt", datasetCnt);
        model.addAttribute("userCnt", userCnt);

        /* Get community count */
        List<Group> childGroups = null;
        Group rootGroup = null;

        Group group = GroupLocalServiceUtil.getGroup(scopeGroupId);
        if (rootGroup != null) {
            childGroups = rootGroup.getChildrenWithLayouts(true, QueryUtil.ALL_POS, QueryUtil.ALL_POS, new GroupNameComparator(true));
        } else {
            childGroups = GroupLocalServiceUtil.getLayoutsGroups(group.getCompanyId(), group.getParentGroupId(), true, QueryUtil.ALL_POS, QueryUtil.ALL_POS, new GroupIdComparator(true));
        }
        List<Group> visibleGroups = new UniqueList<>();
        User user = themeDisplay.getUser();
        for (Group childGroup : childGroups) {
            if (childGroup.hasPublicLayouts()) {
                visibleGroups.add(childGroup);
            } else if (GroupLocalServiceUtil.hasUserGroup(user.getUserId(), childGroup.getGroupId())) {
                visibleGroups.add(childGroup);
            }
        }
        List<Group> groups = ListUtil.subList(visibleGroups, 0, 1000000);


        portletId = "materialsexplorer_WAR_SDR_analysistoolsportlet";
        plid = PortalUtil.getPlidFromPortletId(scopeGroupId, portletId);
        model.addAttribute("toolsURL", PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(request), portletId, plid, PortletRequest.RENDER_PHASE));

        portletId = "sdrcommunity_WAR_SDR_baseportlet";
        plid = PortalUtil.getPlidFromPortletId(scopeGroupId, portletId);
        model.addAttribute("commListURL", PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(request), portletId, plid, PortletRequest.RENDER_PHASE));
        // default Community count -1
        model.addAttribute("commuCnt", groups.size() - 1);

        return "dataCounter/view";
    }

}
