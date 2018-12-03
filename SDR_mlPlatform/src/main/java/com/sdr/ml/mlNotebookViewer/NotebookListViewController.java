/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.sdr.ml.mlNotebookViewer;

import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ReleaseInfo;

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
@RequestMapping("VIEW")
public class NotebookListViewController {

	/**
	 * show My notebook list
	 *
	 * @param model    the model
	 * @param request  the request
	 * @param response the response
	 * @return String  the string
	 */
	@RenderMapping
	public String question(Model model, RenderRequest request , RenderResponse response) {
		model.addAttribute("releaseInfo", ReleaseInfo.getReleaseInfo());

        Map userInfo = (Map) request.getAttribute(request.USER_INFO);

		if(userInfo != null){
			SignJupyterhub signJupyterhub = new SignJupyterhub();

			if(userInfo != null){
				signJupyterhub.signin(JupyterConst.JUPYTER_HUB_URI + JupyterConst.JUPYTER_HUB_SUB_URL_LOGIN
					, JupyterConst.JUPYTER_ID
					, JupyterConst.JUPYTER_PASSWORD
					, response);
			}else{
				signJupyterhub.signout(JupyterConst.JUPYTER_HUB_URI + JupyterConst.JUPYTER_HUB_SUB_URL_LOGOUT, response);
			}

			model.addAttribute("jupyterhubUri", JupyterConst.JUPYTER_HUB_URI);
		}else{
			SessionErrors.add(request, "error");
			model.addAttribute("errorMessage", "Guest is not allowed to upload a dataset. Please login.");
		}

        return "mlNotebookViewer/mlNotebookListPage";
	}

}