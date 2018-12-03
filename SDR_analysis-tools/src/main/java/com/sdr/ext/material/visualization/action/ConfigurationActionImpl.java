package com.sdr.ext.material.visualization.action;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.sdr.metadata.model.DataType;
import com.sdr.metadata.service.DataTypeServiceUtil;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.portlet.*;
import java.util.Enumeration;
import java.util.List;

/**
 * The type Configuration action.
 */
public class ConfigurationActionImpl implements ConfigurationAction {

    private Log _log = LogFactoryUtil.getLog(ConfigurationActionImpl.class);


    public String render(PortletConfig portletConfig, RenderRequest renderRequest, RenderResponse renderResponse) throws Exception {
        // Get DataType
        ServiceContext serviceContext = ServiceContextFactory.getInstance(renderRequest);
        List<DataType> typeList = DataTypeServiceUtil.getDataTypes(QueryUtil.ALL_POS, QueryUtil.ALL_POS, serviceContext);

        JSONArray jsonArray = new JSONArray();

        if (typeList != null) {
            int len = typeList.size();
            for (int i = 0; i < len; i++) {
                JSONObject json = new JSONObject();
                json.put("key", typeList.get(i).getTitle());
                json.put("value", typeList.get(i).getDataTypeId());
                jsonArray.add(json);
            }
        }

        renderRequest.setAttribute("typeList", jsonArray);

        return "/WEB-INF/jsp/analysis-tools/visualization/config/configuration.jsp";
    }

    public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

        String cmd = actionRequest.getParameter(VConstants.CMD);

        if (Validator.isNull(cmd)) {
            throw new Exception("exception-occurred");
        }
        try {
            if (cmd.equals(VConstants.UPDATE_CHART_CONFIG)) {
                savePreferences(actionRequest, actionResponse);
                actionResponse.setRenderParameter("tab", "charts");
            } else if (cmd.equals(VConstants.UPDATE_LOOK_AND_FEEL)) {
                String tab = ParamUtil.getString(actionRequest, "tab");
                if (tab != null) {
                    actionResponse.setRenderParameter("tab", tab);
                }
            }
            SessionMessages.add(actionRequest, "request-successfully");
        } catch (Exception e) {
            _log.error(e.getMessage());
            SessionErrors.add(actionRequest, e.getMessage());
        }
    }

    private void savePreferences(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

        String portletResource = ParamUtil.getString(actionRequest, "portletResource");

        PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);

        Enumeration<String> parameterNames = actionRequest.getParameterNames();

        while (parameterNames.hasMoreElements()) {

            String param = parameterNames.nextElement();

            if (param.startsWith("settings")) {
                String value = ParamUtil.get(actionRequest, param, "");
                //log.info("save param=" + param + ", value=" + value);
                preferences.setValue(param, value);
            }
        }

        preferences.store();
    }
}
