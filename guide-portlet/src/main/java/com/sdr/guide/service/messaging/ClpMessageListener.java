package com.sdr.guide.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import com.sdr.guide.service.ClpSerializer;
import com.sdr.guide.service.GuideLocalServiceUtil;
import com.sdr.guide.service.GuideServiceUtil;


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
            GuideLocalServiceUtil.clearService();

            GuideServiceUtil.clearService();
        }
    }
}
