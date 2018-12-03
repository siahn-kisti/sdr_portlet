package com.sdr.search.tagCloudSearch;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionList;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.GroupConstants;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.asset.model.AssetTag;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetTagLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetTagServiceUtil;
import com.sdr.metadata.model.Collection;
import com.sdr.metadata.service.AssetEntries_AssetTagsLocalServiceUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.portlet.bind.annotation.RenderMapping;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The type Tag cloud search.
 */
@Controller
@RequestMapping("VIEW")
public class TagCloudSearch {

    private static Log _log = LogFactoryUtil.getLog(TagCloudSearch.class);

    /**
     * Tag cloud search string.
     *
     * @param request  the request
     * @param response the response
     * @param model    the model
     * @return the string
     * @throws PortalException the portal exception
     * @throws SystemException the system exception
     */
    @RenderMapping
    public String tagCloudSearch(RenderRequest request, RenderResponse response, Model model) throws PortalException, SystemException {

        _log.debug("### Tag Cloud Search Main Renderer");

        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        long scopeGroupId = themeDisplay.getScopeGroupId();

        String portletId = "datasearch_WAR_SDR_baseportlet";

        long plid = PortalUtil.getPlidFromPortletId(scopeGroupId, portletId);

        PortletURL portletURL = PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(request), portletId, plid, PortletRequest.RENDER_PHASE);

        List<AssetTag> tags = null;

        long classNameId = PortalUtil.getClassNameId(Collection.class.getName());

        StringBundler sb = new StringBundler();

        List tagsList = new ArrayList();

        if (scopeGroupId != GroupLocalServiceUtil.getGroup(themeDisplay.getCompanyId(), GroupConstants.GUEST).getGroupId()) {
            tags = AssetTagServiceUtil.getTags(scopeGroupId, classNameId, null);
        } else {

            DynamicQuery dynamicQuery = AssetEntries_AssetTagsLocalServiceUtil.dynamicQuery();

            ProjectionList projectionList = ProjectionFactoryUtil.projectionList();
            projectionList.add(ProjectionFactoryUtil.groupProperty("primaryKey.tagId"));
            dynamicQuery.setProjection(projectionList);

            DynamicQuery dynamicQuery1 = AssetEntryLocalServiceUtil.dynamicQuery();
            projectionList = ProjectionFactoryUtil.projectionList();
            projectionList.add(ProjectionFactoryUtil.groupProperty("entryId"));
            dynamicQuery1.setProjection(projectionList);
            dynamicQuery1.add(RestrictionsFactoryUtil.eq("classNameId", classNameId));

            dynamicQuery.add(RestrictionsFactoryUtil.in("primaryKey.entryId", AssetEntryLocalServiceUtil.dynamicQuery(dynamicQuery1)));

            DynamicQuery dynamicQuery2 = AssetTagLocalServiceUtil.dynamicQuery();
            dynamicQuery2.add(RestrictionsFactoryUtil.in("tagId", AssetEntries_AssetTagsLocalServiceUtil.dynamicQuery(dynamicQuery)));

            tags = AssetTagLocalServiceUtil.dynamicQuery(dynamicQuery2);
        }

        if (tags.isEmpty()) {
            return null;
        }

        tags = ListUtil.sort(tags);

        sb.append("<ul class=\"tag-items ");

        sb.append("tag-cloud");

        sb.append("\">");

        int maxCount = 1;
        int minCount = 1;

        for (AssetTag tag : tags) {
            String tagName = tag.getName();

            int count = 0;
            if (scopeGroupId != GroupLocalServiceUtil.getGroup(themeDisplay.getCompanyId(), GroupConstants.GUEST).getGroupId()) {
                count = tag.getAssetCount();
            } else {
                count = tag.getAssetCount();
            }

            maxCount = Math.max(maxCount, count);
            minCount = Math.min(minCount, count);

        }

        double multiplier = 1;

        if (maxCount != minCount) {
            multiplier = (double) 5 / (maxCount - minCount);
        }

        for (AssetTag tag : tags) {
            String tagName = tag.getName();
            String tagId = Long.toString(tag.getTagId());

            int count = 0;

            if (scopeGroupId != GroupLocalServiceUtil.getGroup(themeDisplay.getCompanyId(), GroupConstants.GUEST).getGroupId()) {
                count = tag.getAssetCount();
            } else {
                count = tag.getAssetCount();
            }

            int popularity = (int) (1 + ((maxCount - (maxCount - (count - minCount))) * multiplier));

            sb.append("<li class=\"tag-popularity-");
            sb.append(popularity);
            sb.append("\"><span>");

            portletURL.setParameter("searchSelect", "tag");
            portletURL.setParameter("tabs", "Collection");
            portletURL.setParameter("facetKeywords", "keyword_" + tagId);
            portletURL.setParameter("tagCloudKeyword", tagId);

            // redirect URL
            sb.append("<a href=\"");
            sb.append(HtmlUtil.escape(portletURL.toString()));
            // font size
            sb.append("\" rel=\"");
            sb.append(popularity);
            // style add
            sb.append("\" style=\"");
            sb.append("\">");
            sb.append(tagName);

            // assetCount 보이기
            sb.append("<span class=\"tag-asset-count\">");
            sb.append(StringPool.SPACE);
            sb.append(StringPool.OPEN_PARENTHESIS);
            sb.append(count);
            sb.append(StringPool.CLOSE_PARENTHESIS);
            sb.append("</span>");

            sb.append("</a></span></li>");

            //d3-cloud 타입 적용시
            Map<String, String> map = new HashMap<String, String>();
            map.put("text", "'" + tagName + "'");
            map.put("size", Integer.toString(popularity));
            map.put("href", "'" + portletURL.toString() + "'");
            tagsList.add(map);

            _log.debug("Tag : " +map.get("text")+" : "+ map.get("size")+" : "+ map.get("href"));
    }

        sb.append("</ul><br style=\"clear: both;\" />");

        model.addAttribute("tagsNavigation", sb.toString());

        //d3-cloud 타입 적용시
        _log.debug("TagtoString : "+tagsList.toString().replace("text=", "text:").replace("size=", "size:").replace("href=", "href:"));
        model.addAttribute("tagsList", tagsList.toString().replace("text=", "text:").replace("size=", "size:").replace("href=", "href:"));

        return "tagCloudSearch/view";
    }

}
