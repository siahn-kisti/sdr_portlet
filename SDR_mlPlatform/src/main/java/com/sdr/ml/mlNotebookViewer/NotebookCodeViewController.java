package com.sdr.ml.mlNotebookViewer;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sdr.ml.common.util.jupyter.JupyterConst;
import com.sdr.ml.common.util.jupyter.SignJupyterhub;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.Map;

@Controller
@RequestMapping(value = "VIEW", params = "controller=notebookCodeView")
public class NotebookCodeViewController {

	/**
	 * show Notebook Code Viewer
	 *
	 * @param model    the model
	 * @param request  the request
	 * @param response the response
	 * @return String  the string
	 */
	@RenderMapping
	public String question(Model model, RenderRequest request, RenderResponse response) {

		Map userInfo = (Map) request.getAttribute(request.USER_INFO);

		if(userInfo != null){
			String notebookPath = ParamUtil.getString(request, "nbPath");

			String notebookUri = JupyterConst.getJupyterHubNotebookUri(JupyterConst.JUPYTER_ID, notebookPath);
			SignJupyterhub signJupyterhub = new SignJupyterhub();

			signJupyterhub.signin(JupyterConst.JUPYTER_HUB_URI, JupyterConst.JUPYTER_ID, JupyterConst.JUPYTER_PASSWORD, response);

			model.addAttribute("nbTitle", notebookPath.split("/")[1]);
			model.addAttribute("nbUri", notebookUri);

			return "mlNotebookViewer/mlNotebookCodePage";
		}else{
			SessionErrors.add(request, "error");
			model.addAttribute("errorMessage", "Guest is not allowed to upload a dataset. Please login.");
		}

		return null;
	}
}
