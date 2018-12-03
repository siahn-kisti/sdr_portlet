package com.sdr.ml.mlDataSearch;


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
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.sdr.metadata.service.AssetEntries_AssetTagsLocalServiceUtil;
import com.sdr.metadata.service.DatasetServiceUtil;
import com.sdr.ml.common.util.MlStringUtils;
import com.sdr.ml.common.util.MlDataIdUtils;
import org.json.JSONArray;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * The type Data search.
 */
@Controller
@RequestMapping("VIEW")
public class MlDataSearch {

    private static Log _log = LogFactoryUtil.getLog(MlDataSearch.class);
    private static String _CONTENT_TYPE_DATASET = "Dataset";
    private static String _CONTENT_TYPE_NOTEBOOK = "Notebook";


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
        _log.debug("###ML DataSearch Main Renderer");

        try {

			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long scopeGroupId = themeDisplay.getScopeGroupId();
			long scopeCompanyId = themeDisplay.getCompanyId();

			String tabName = ParamUtil.getString(renderRequest, "tabs", _CONTENT_TYPE_DATASET);
			String keywords = ParamUtil.getString(renderRequest, "keywords");
			String searchSelect = ParamUtil.getString(renderRequest, "searchSelect");
			String facetKeywords = ParamUtil.getString(renderRequest, "facetKeywords");

			_log.debug("keyword ::: " + keywords + " searchFlag ::: " + searchSelect);

			Map<String, Object> assetMap = AssetEntries_AssetTagsLocalServiceUtil.getAssetMap(scopeGroupId, scopeCompanyId, tabName, keywords, searchSelect, facetKeywords);
			model.addAllAttributes(assetMap);

            if (tabName.equals(_CONTENT_TYPE_DATASET)) {

                searchDataset(renderRequest, renderResponse, model);

                JSONArray jArrayFileSizeFacet = new JSONArray(MlStringUtils._FACET_ML_DATASET_FILE_SIZE_LIST);

                model.addAttribute("fileSizeFacetList", jArrayFileSizeFacet.toList());

            } else if (tabName.equals(_CONTENT_TYPE_NOTEBOOK)) {

                JSONArray jArrayLanguageFaccet = new JSONArray(MlStringUtils._FACET_ML_NOTEBOOK_LANGUAGE_LIST);
				JSONArray jArrayTaskFaccet = new JSONArray(MlStringUtils._FACET_ML_NOTEBOOK_TASK_LIST);
                JSONArray jArrayAlgorithmFaccet = new JSONArray(MlStringUtils._FACET_ML_NOTEBOOK_ALGORITHM_LIST);

                model.addAttribute("languageFacetList", jArrayLanguageFaccet.toList());
                model.addAttribute("taskFacetList", jArrayTaskFaccet.toList());
                model.addAttribute("algorithmFacetList", jArrayAlgorithmFaccet.toList());

                searchNotebook(renderRequest, renderResponse, model);
            }

        } catch (PrincipalException pe) {
//            ErrorHandler.error(renderRequest, pe);
        } catch (Exception e) {
            SessionErrors.add(renderRequest, e.getClass(), e.getMessage());
            SessionMessages.add(renderRequest, PortalUtil.getPortletId(renderRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
        }

        return "mlDataSearch/view";
    }

    /**
     * Data search ajax string.
     *
     * @param renderRequest  the render request
     * @param renderResponse the render response
     * @param model          the model
     * @return the string
     */
    @RenderMapping(params = "action=dataSearchAjax")
    public String dataSearchAjax(RenderRequest renderRequest, RenderResponse renderResponse, Model model) {
        _log.debug("### Ml DataSearch Ajax Renderer");

        String result = "";
        String tabName = ParamUtil.getString(renderRequest, "tabs", _CONTENT_TYPE_DATASET);
		String keywords = ParamUtil.getString(renderRequest, "keywords");
		String searchSelect = ParamUtil.getString(renderRequest, "searchSelect");
		String facetKeywords = ParamUtil.getString(renderRequest, "facetKeywords");

        renderResponse.setContentType("text/html");

        try {
            if (tabName.equals(_CONTENT_TYPE_DATASET)) {
                result = searchDataset(renderRequest, renderResponse, model);
            }
            else if (tabName.equals(_CONTENT_TYPE_NOTEBOOK)) {
                result = searchNotebook(renderRequest, renderResponse, model);
            }
        } catch (SystemException e) {
            e.printStackTrace();
        } catch (PortalException e) {
            e.printStackTrace();
        }

        return result;
    }


    /*
     *
     * Resource API
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     */











    /*
     *
     * Util Fucntions
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     *
     */

    /**
     * Dataset search core
     *
     * @param renderRequest
     * @param renderResponse
     * @param model
     * @return String
     * @throws SearchException
     * @throws ParseException
     * @throws SystemException
     * @throws PortalException
     * @throws PrincipalException
     */
    private String searchDataset(RenderRequest renderRequest, RenderResponse renderResponse, Model model)
            throws SearchException, ParseException, SystemException, PortalException, PrincipalException {
        _log.debug("### Ml Dataset list");

        PortletURL iteratorURL = renderResponse.createRenderURL();
		iteratorURL.setParameter("tabs", _CONTENT_TYPE_DATASET);

        Map<String, String> paramMap = new HashMap<String, String>();

        paramMap.put("tabs", _CONTENT_TYPE_DATASET);

        Iterator<Map.Entry<String, String>> entries = paramMap.entrySet().iterator();

        while (entries.hasNext()) {
            Map.Entry<String, String> entry = entries.next();
            iteratorURL.setParameter(entry.getKey(), entry.getValue());
        }

        /*
         * Data Type의 Id값 전달
         */
        MlDataIdUtils mlDataIdUtils = MlDataIdUtils.getInstance();
        renderRequest.setAttribute("ml-notebook-datasetId", mlDataIdUtils.getIdMlNotebookDataType());
        renderRequest.setAttribute("ml-data-datasetId",mlDataIdUtils.getIdMlDatasetDataType());
		renderRequest.setAttribute("ml-data-publicCollectionId",mlDataIdUtils.getIdPublicMlCollection());

        model.addAllAttributes(DatasetServiceUtil.search(renderRequest, renderResponse));
        model.addAttribute("iteratorURL", iteratorURL);
        model.addAttribute("tabs", _CONTENT_TYPE_DATASET);


        return "mlDataSearch/contentList/list_dataset";
    }



    /**
     * Dataset search core
     *
     * @param renderRequest
     * @param renderResponse
     * @param model
     * @return String
     * @throws SearchException
     * @throws ParseException
     * @throws SystemException
     * @throws PortalException
     * @throws PrincipalException
     */
    private String searchNotebook(RenderRequest renderRequest, RenderResponse renderResponse, Model model)
            throws SearchException, ParseException, SystemException, PortalException, PrincipalException {
        _log.debug("### Ml Notebook list");

        PortletURL iteratorURL = renderResponse.createRenderURL();
		iteratorURL.setParameter("tabs", _CONTENT_TYPE_NOTEBOOK);
        Map<String, String> paramMap = new HashMap<String, String>();

        paramMap.put("tabs", _CONTENT_TYPE_NOTEBOOK);

        Iterator<Map.Entry<String, String>> entries = paramMap.entrySet().iterator();

        while (entries.hasNext()) {
            Map.Entry<String, String> entry = entries.next();
            iteratorURL.setParameter(entry.getKey(), entry.getValue());
        }

        /*
         * Data Type의 Id값 전달
         */
        MlDataIdUtils mlDataIdUtils = MlDataIdUtils.getInstance();
        renderRequest.setAttribute("ml-notebook-datasetId", mlDataIdUtils.getIdMlNotebookDataType());
        renderRequest.setAttribute("ml-data-datasetId",mlDataIdUtils.getIdMlDatasetDataType());

        model.addAllAttributes(DatasetServiceUtil.search(renderRequest, renderResponse));
        model.addAttribute("iteratorURL", iteratorURL);
        model.addAttribute("tabs", _CONTENT_TYPE_NOTEBOOK);

        return "mlDataSearch/contentList/list_notebook";
    }

}
