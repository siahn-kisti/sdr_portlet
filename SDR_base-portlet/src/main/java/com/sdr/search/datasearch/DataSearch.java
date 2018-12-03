package com.sdr.search.datasearch;

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
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
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
public class DataSearch {

    private static Log _log = LogFactoryUtil.getLog(DataSearch.class);

    /**
     * Data search main string.
     *
     * @param renderRequest  the render request
     * @param renderResponse the render response
     * @param model          the model
     * @return the string
     * @throws PortalException the portal exception
     * @throws SystemException the system exception
     */
    @RenderMapping
    public String dataSearchMain(RenderRequest renderRequest, RenderResponse renderResponse, Model model) {

        _log.debug("### DataSearch Main Renderer");

        try {

            // TEST CODE for category
        	/*
        	List<Long> categories = new ArrayList<Long>();
        	categories.add(54918L);
        	categories.add(54904L);
        	renderRequest.setAttribute("categories", categories);
        	*/

            dataSearch(renderRequest, renderResponse, model);
            dataSearchCore(renderRequest, renderResponse, model);

            String tagCloudKeyword = ParamUtil.getString(renderRequest, "tagCloudKeyword", "");

            if (!tagCloudKeyword.isEmpty()) {
                model.addAttribute("tagCloudKeyword", tagCloudKeyword);
            }
        } catch (PrincipalException pe) {
            ErrorHandler.error(renderRequest, pe);
        } catch (SystemException | PortalException e) {
            SessionErrors.add(renderRequest, e.getClass(), e.getMessage());
            SessionMessages.add(renderRequest, PortalUtil.getPortletId(renderRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
        }

        return "dataSearch/view";
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
        _log.debug("### DataSearch Tab Renderer");


        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        long scopeGroupId = themeDisplay.getScopeGroupId();
		long scopeCompanyId = themeDisplay.getCompanyId();

		String tabName = ParamUtil.getString(renderRequest, "tabs", "Collection");
        String keywords = ParamUtil.getString(renderRequest, "keywords");
        String searchSelect = ParamUtil.getString(renderRequest, "searchSelect");
        String facetKeywords = ParamUtil.getString(renderRequest, "facetKeywords");

        _log.debug("keyword ::: " + keywords + " searchFlag ::: " + searchSelect);

		Map<String, Object> assetMap = AssetEntries_AssetTagsLocalServiceUtil.getAssetMap(scopeGroupId, scopeCompanyId, tabName, keywords, searchSelect, facetKeywords);

		model.addAttribute("tabs", tabName);
		model.addAllAttributes(assetMap);
		renderResponse.setContentType("text/html");

		return "dataSearch/facet";
    }

    /**
     * Data search ajax string.
     *
     * @param renderRequest  the render request
     * @param renderResponse the render response
     * @param model          the model
     * @return the string
     * @throws PortalException the portal exception
     * @throws SystemException the system exception
     */
    @RenderMapping(params = "action=dataSearchAjax")
    public String dataSearchAjax(RenderRequest renderRequest, RenderResponse renderResponse, Model model) throws PortalException, SystemException {

        _log.debug("### DataSearch Ajax Renderer");

        String tabName = ParamUtil.getString(renderRequest, "tabs", "Collection");
        String returnView;

        dataSearchCore(renderRequest, renderResponse, model);

        renderResponse.setContentType("text/html");

        if (tabName.equals("Collection")) {
            returnView = "dataSearch/collection/list_collection";
        } else {
            returnView = "dataSearch/dataset/list_dataset";
        }

        return returnView;
    }


    /**
     * Data search core
     *
     * @param renderRequest
     * @param renderResponse
     * @param model
     * @return model
     * @throws SearchException
     * @throws ParseException
     * @throws SystemException
     * @throws PortalException
     * @throws PrincipalException
     */
    private Model dataSearchCore(RenderRequest renderRequest, RenderResponse renderResponse, Model model)
            throws SearchException, ParseException, SystemException, PortalException, PrincipalException {

        String tabName = ParamUtil.getString(renderRequest, "tabs", "Collection");

        Map<String, String> paramMap = new HashMap<String, String>();

        if (tabName.equals("Collection")) {

            _log.debug("### Collection list");

            paramMap.put("tabs", "Collection");

            model.addAllAttributes(CollectionServiceUtil.search(renderRequest, renderResponse));

        } else if (tabName.equals("Dataset")) {

            _log.debug("### Dataset list");

            paramMap.put("tabs", "Dataset");

            model.addAllAttributes(DatasetServiceUtil.search(renderRequest, renderResponse));

        }

        PortletURL iteratorURL = renderResponse.createRenderURL();

        Iterator<Map.Entry<String, String>> entries = paramMap.entrySet().iterator();

        while (entries.hasNext()) {
            Map.Entry<String, String> entry = entries.next();
            iteratorURL.setParameter(entry.getKey(), entry.getValue());
        }
        model.addAttribute("iteratorURL", iteratorURL);
        model.addAttribute("tabs", tabName);

        return model;
    }

}
