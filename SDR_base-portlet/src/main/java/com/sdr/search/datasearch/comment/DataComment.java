package com.sdr.search.datasearch.comment;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.struts.PortletActionInvoker;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.ActionMapping;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 * The type Data comment.
 */
@Controller
@RequestMapping(value = "VIEW", params = "controller=DataComment")
public class DataComment {
    private static Log _log = LogFactoryUtil.getLog(DataComment.class);

    /**
     * Add discussion.
     *
     * @param actionRequest  the action request
     * @param actionResponse the action response
     */
    @ActionMapping(value = "addDiscussion")
    public void addDiscussion(ActionRequest actionRequest, ActionResponse actionResponse) {

        _log.debug("###data comments");

        try {
            PortletActionInvoker.processAction("com.liferay.portlet.messageboards.action.EditDiscussionAction", null,
                    actionRequest, actionResponse);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}