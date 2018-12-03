package com.sdr.curation;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.WorkflowDefinitionLinkLocalServiceUtil;
import com.sdr.common.portlet.SendEmail;
import com.sdr.metadata.model.Dataset;
import com.sdr.metadata.service.DatasetLocalServiceUtil;
import com.sdr.workflow.DatasetWorkflow;

/*
import com.liferay.mail.service.MailServiceUtil;
import javax.mail.internet.InternetAddress;
*/

public class ErrorHandler {
	
	private static Log log = LogFactoryUtil.getLog(ErrorHandler.class);

	public static void reportError(String message) {
		String errorTitle =  "[Curation error] " + message ;
		log.debug(errorTitle);
		//sendToAdmin(errorTitle, errorTitle);	
	}
	
	public static void reportError(String errorTitle, String errorBody) {
		//sendToAdmin(errorTitle, errorBody);	
		log.debug(errorTitle);
	}
	
	public static void reportError(long companyId, long groupId, long datasetId, long userId,
			ServiceContext sc, String msg) {
		reportError(companyId, groupId, datasetId, userId, sc, msg, msg);
	}
	public static void reportError(Dataset ds, ServiceContext sc, int errCode) {
		reportError(ds.getCompanyId(), ds.getGroupId(), ds.getDatasetId(), ds.getUserId(), sc, ErrorConst.getErrorMessage(errCode));
	}
	
	public static void reportError(long companyId, long groupId, long datasetId, long userId, 
			ServiceContext sc, String errorTitle, String errorBody) {
    	try {
    		
    		if ( WorkflowDefinitionLinkLocalServiceUtil.hasWorkflowDefinitionLink(companyId,groupId,Dataset.class.getName())) {
    			DatasetWorkflow.signalWorkflowInstance(companyId, groupId, datasetId, userId, "incomplete");
    			log.debug("--signalworkflowinstance -- incomplete ");
    		} else { 
    			DatasetLocalServiceUtil.updateStatus(userId, datasetId, WorkflowConstants.STATUS_INCOMPLETE, sc); 
    			log.debug("--updateStatus -- incomplete ");
    		}
			
    		//sendToAdmin(errorTitle, errorBody, companyId);
    		
			log.debug("reportError (" + datasetId + ") " + errorTitle);
			// log.debug(errorBody);
	    	return;			
		} catch (Exception e) {
			log.error("updateStatus Error in Curation ErrorHandler: " + datasetId);
			e.printStackTrace();
		} 
	}
	
	public static void sendToAdmin(String errorTitle, String errorBody, long companyId) {
		try {
			String email = PrefsPropsUtil.getString(companyId, PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
			log.debug("email to " + email);

			SendEmail.sendToAdmin(errorTitle, errorBody);

			// if (email != null) {
			//	InternetAddress addr = new InternetAddress(email);
			//	if ( addr != null ) {
			//		log.debug(addr.toString());
			//		MailMessage emailMessage = new MailMessage(addr, addr, errorTitle, errorBody, false);
			//		MailServiceUtil.sendEmail(emailMessage);
			//	}
			//}


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.debug("sending email failed ");
		}
	}

}