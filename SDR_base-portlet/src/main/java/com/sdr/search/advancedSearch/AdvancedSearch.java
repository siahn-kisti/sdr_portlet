package com.sdr.search.advancedSearch;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.util.PortalUtil;
import com.sdr.ac.PermissionConstant;
import com.sdr.common.util.ErrorHandler;
import com.sdr.metadata.model.DataType;
import com.sdr.metadata.model.DataTypeSchema;
import com.sdr.metadata.service.DataTypeSchemaServiceUtil;
import com.sdr.metadata.service.DataTypeServiceUtil;
import com.sdr.metadata.service.DatasetServiceUtil;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * Portlet implementation class AdvancedSearch
 */
@Controller
@RequestMapping("VIEW")
public class AdvancedSearch {

    private static Log _log = LogFactoryUtil.getLog(AdvancedSearch.class);

    /**
     * Advanced search main string.
     *
     * @param renderRequest  the render request
     * @param renderResponse the render response
     * @param model          the model
     * @return the string
     * @throws PortalException the portal exception
     * @throws SystemException the system exception
     */
    @RenderMapping
    public String advancedSearchMain(RenderRequest renderRequest, RenderResponse renderResponse, Model model) {

        _log.debug("### AdvancedSearch Main Renderer");

        try {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(renderRequest);
            List<DataType> dataTypeList = DataTypeServiceUtil.getList(serviceContext);
            model.addAttribute("dataTypeList", dataTypeList);

            String dataTypeRqst = ParamUtil.getString(renderRequest, "dataTypes");

            if (dataTypeRqst != null && dataTypeRqst != "") {
                String[] dataTypes = dataTypeRqst.split(",");

                List<String> keyList = mkKeyList(dataTypes);

                model.addAttribute("searchKeyList", keyList);
                model.addAttribute("resultKeyList", keyList);
            }
        } catch (PrincipalException e) {
            ErrorHandler.error(renderRequest, e);
        } catch (SystemException | PortalException e) {
            SessionErrors.add(renderRequest, e.getClass(), e.getMessage());
            SessionMessages.add(renderRequest, PortalUtil.getPortletId(renderRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
        }

        return "advancedSearch/view";
    }

    /**
     * Advanced search ajax string.
     *
     * @param renderRequest  the render request
     * @param renderResponse the render response
     * @param model          the model
     * @return the string
     * @throws SearchException the search exception
     */
    @RenderMapping(params = "action=advancedSearchAjax")
    public String advancedSearchAjax(RenderRequest renderRequest, RenderResponse renderResponse, Model model) {

        _log.debug("### Advanced Search Ajax Renderer");

        try {

            Map<String, Object> map = DatasetServiceUtil.querySearch(renderRequest, renderResponse);
            model.addAllAttributes(map);
            renderResponse.setContentType("text/html");

        } catch (PrincipalException e) {
            model.addAttribute("error", ErrorHandler.ajaxError(e));
        } catch (PortalException | SystemException e) {
            model.addAttribute("error", e.getMessage());
        }


        return "advancedSearch/list_advanced_dataset";
    }

    /**
     * Gets key list.
     *
     * @param resourceRequest  the resource request
     * @param resourceResponse the resource response
     * @param model            the model
     * @throws PortalException the portal exception
     * @throws IOException     the io exception
     * @throws SystemException the system exception
     */
    @ResourceMapping(value = "keyList")
    public void getKeyList(ResourceRequest resourceRequest, ResourceResponse resourceResponse, Model model)
            throws PortalException, IOException, SystemException {

        String[] dataTypes = resourceRequest.getParameterValues("dataTypes[]");

        List keyList = mkKeyList(dataTypes);

        JSONObject jsonObject = new org.json.JSONObject();
        jsonObject.put("searchKeyList", keyList);
        jsonObject.put("resultKeyList", keyList);

        resourceResponse.setContentType("text/html;charset=utf-8");
        PrintWriter out = resourceResponse.getWriter();
        out.print(jsonObject.toString());

    }

    /**
     * Make descriptive metadata key List
     *
     * @param dataTypes
     * @return List
     * @throws SystemException
     * @throws PortalException
     */
    private List mkKeyList(String[] dataTypes) throws SystemException, PortalException {

        List keyList = new ArrayList();

        for (String dataTypeId : dataTypes) {
            List<DataTypeSchema> schemaList = DataTypeSchemaServiceUtil.getList(Long.parseLong(dataTypeId));
            for (int i = 0; i < schemaList.size(); i++) {
                keyList.add(schemaList.get(i).getTitle());
            }
        }

        keyList = new ArrayList(new HashSet(keyList));
        Collections.sort(keyList);

        return keyList;
    }


}