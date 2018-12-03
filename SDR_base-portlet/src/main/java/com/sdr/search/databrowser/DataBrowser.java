package com.sdr.search.databrowser;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.ParseException;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.sdr.ac.CollectionModelPermission;
import com.sdr.ac.PermissionConstant;
import com.sdr.common.util.ErrorHandler;
import com.sdr.metadata.service.AssetEntries_AssetTagsLocalServiceUtil;
import com.sdr.metadata.service.CollectionServiceUtil;
import com.sdr.metadata.service.DatasetServiceUtil;
import com.sdr.search.datasearch.facet.FacetSearch;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/**
 * The type Data search.
 */
@Controller
@RequestMapping("VIEW")
public class DataBrowser {

	private static Log _log = LogFactoryUtil.getLog(DataBrowser.class);

	/**
	 *  Data search main string.
	 *
	 * @param renderRequest the render request
	 * @param renderResponse the render response
	 * @param model the model
	 * @return the string
	 * @throws PortalException the portal exception
	 * @throws SystemException the system exception
	 * @throws PrincipalException the principal exception
	 *
	 */
	@RenderMapping
	public String dataSearchMain(RenderRequest renderRequest, RenderResponse renderResponse, Model model) {

		_log.debug("### DataBrowser Main Renderer");

		try {

			dataSearch(renderRequest, renderResponse, model);

		} catch (PrincipalException pe) {
			ErrorHandler.error(renderRequest, pe);
		} catch (SystemException | PortalException e) {
			SessionErrors.add(renderRequest, e.getClass(), e.getMessage());
			SessionMessages.add(renderRequest, PortalUtil.getPortletId(renderRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		}

		return "dataBrowser/view";
	}

	/**
	 * Data search string.
	 *
	 * @param renderRequest  the render request
	 * @param renderResponse the render response
	 * @param model          the model
	 * @return the string
	 * @throws PortalException the portal exception
	 * @throws SystemException the system exception
	 */
	@RenderMapping(params = "action=dataSearch")
	public String dataSearch(RenderRequest renderRequest, RenderResponse renderResponse, Model model) throws PortalException, SystemException {
		_log.debug("### DataBrowser function Renderer");


		Map<String, String> paramMap = new HashMap<String, String>();
		ServiceContext serviceContext = ServiceContextFactory.getInstance(renderRequest);
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(com.liferay.portal.kernel.util.WebKeys.THEME_DISPLAY);
		long scopeGroupId = themeDisplay.getScopeGroupId();
		String keywords = ParamUtil.getString(renderRequest, "keywords");
		renderRequest.setAttribute("databrowser", "databrowser");

		//_log.debug("keyword ::: " + keywords );

		model.addAllAttributes(CollectionServiceUtil.search(renderRequest, renderResponse));

		PortletURL iteratorURL = renderResponse.createRenderURL();

		Iterator<Map.Entry<String, String>> entries = paramMap.entrySet().iterator();

		while (entries.hasNext()) {
			Map.Entry<String, String> entry = entries.next();
			iteratorURL.setParameter(entry.getKey(), entry.getValue());
		}
		model.addAttribute("iteratorURL", iteratorURL);
		model.addAttribute("createPerm", CollectionModelPermission.contains(serviceContext, scopeGroupId, PermissionConstant.SDR_ACTION_COLLECTION_CREATE));

		String tagCloudKeyword = ParamUtil.getString(renderRequest, "tagCloudKeyword", "");

		if (!tagCloudKeyword.isEmpty()) {
			model.addAttribute("tagCloudKeyword", tagCloudKeyword);
		}

		return "dataBrowser/view";
	}



}
