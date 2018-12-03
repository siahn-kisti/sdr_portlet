package com.sdr.workflow;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.service.ServiceContext;
import com.sdr.metadata.model.Dataset;
import com.sdr.metadata.service.DatasetLocalServiceUtil;
import com.sdr.metadata.service.DatasetServiceUtil;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

/**
 * The type Dataset workflow handler.
 */
public class DatasetWorkflowHandler extends BaseWorkflowHandler {

    /**
     * The constant CLASS_NAME.
     */
    public static final String CLASS_NAME = Dataset.class.getName();

    @Override
    public String getClassName() {
        return CLASS_NAME;
    }

    @Override
    public String getType(Locale locale) {
        return LanguageUtil.get(locale, "model.resource" + CLASS_NAME);
    }

    @Override
    public Object updateStatus(int status,
                               Map<String, Serializable> workflowContext) throws PortalException,
            SystemException {

        long userId = GetterUtil.getLong(
                (String) workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));

        long datasetId = GetterUtil.getLong(
                (String) workflowContext.get(
                        WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));

        ServiceContext serviceContext = (ServiceContext) workflowContext.get("serviceContext");

        return DatasetLocalServiceUtil.updateStatus(userId, datasetId, status, serviceContext);

    }
}
