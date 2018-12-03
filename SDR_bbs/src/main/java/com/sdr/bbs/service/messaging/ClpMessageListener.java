package com.sdr.bbs.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import com.sdr.bbs.service.BbsCommentLocalServiceUtil;
import com.sdr.bbs.service.BbsLocalServiceUtil;
import com.sdr.bbs.service.BbsPostLocalServiceUtil;
import com.sdr.bbs.service.ClpSerializer;


public class ClpMessageListener extends BaseMessageListener {
    public static String getServletContextName() {
        return ClpSerializer.getServletContextName();
    }

    @Override
    protected void doReceive(Message message) throws Exception {
        String command = message.getString("command");
        String servletContextName = message.getString("servletContextName");

        if (command.equals("undeploy") &&
                servletContextName.equals(getServletContextName())) {
            BbsLocalServiceUtil.clearService();

            BbsCommentLocalServiceUtil.clearService();

            BbsPostLocalServiceUtil.clearService();
        }
    }
}
