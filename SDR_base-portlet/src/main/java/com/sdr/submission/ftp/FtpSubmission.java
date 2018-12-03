package com.sdr.submission.ftp;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.sdr.ac.CollectionModelPermission;
import com.sdr.ac.PermissionConstant;
import com.sdr.common.util.ErrorHandler;
import com.sdr.file.FileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

/**
 * The type Ftp submission.
 */
@Controller
@RequestMapping(value = "VIEW", params = "controller=ftp")
public class FtpSubmission {

	private static Log _log = LogFactoryUtil.getLog(FtpSubmission.class);

	/**
	 * Ftp submission string.
	 *
	 * @param request  the request
	 * @param response the response
	 * @param model    the model
	 * @return the string
	 */
	@RenderMapping
	public String ftpSubmission(RenderRequest request, RenderResponse response, Model model) throws SystemException, PortalException {
		_log.debug("### FtpSubmission render");

		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(FtpSubmission.class.getName(), request);
	
			boolean isGuest = PermissionConstant.checkGuest(serviceContext);
			if(isGuest){
				SessionErrors.add(request, "error");
				model.addAttribute("errorMessage", "Guest is not allowed to upload a dataset. Please login.");
				SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			}else{
				String tempPath = FileService.getTempPath(serviceContext.getUserId());
				tempPath = tempPath.replaceAll("\\\\","/");
				_log.debug("### tempPath :" +tempPath);

				model.addAttribute("tempPath", tempPath);

				model.addAttribute("createPerm", CollectionModelPermission.contains(serviceContext, 0, PermissionConstant.SDR_ACTION_COLLECTION_CREATE));
			}
			
		} catch (PrincipalException e) {
			ErrorHandler.error(request, e);
			SessionErrors.add(request, "error");
			model.addAttribute("errorMessage", "You are not allowed to upload a dataset.");
		} catch (PortalException | SystemException e) {
			SessionErrors.add(request, "error", e.getMessage());
		}finally {
			model.addAttribute("tab", "ftp");
		}
		
		return "ftpsubmission/view";
	}


}
