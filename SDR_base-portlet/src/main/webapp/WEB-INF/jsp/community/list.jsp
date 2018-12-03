<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/community/init.jsp" %>

<div class="edison-sdr-portlet">
<style>
    .aui .cm-tile-container {
    }

    .aui .cm-tile-container:after {
        content: '';
        display: table;
        clear: both;
    }

    .communityTiles {
        height: 280px;
        float: left;
        width: 19%;
        /*margin: 0 0.5%;*/
        box-sizing: border-box;
        border-bottom: 2px solid #e8e9eb;
        border-top: 2px solid #e8e9eb;
        border-radius: 5px;
        transition: all 0.2s;
        margin:0 11px 8px 0;
    }

    .communityTiles:hover {
        /*border-bottom: 0 solid #fff;
        border-top: 2px solid #fff;*/
        margin:0px 7px 8px 4px;
    }

    .aui .cm-tile-container > div:last-child {
        border: 0;
    }

    .aui .cm-tile-container > div .app-view-entry-taglib.entry-display-style.display-descriptive {
        margin: 0;
        padding: 0;
        border: 1px solid #bec2c6;
        background: #fff;
        transition: all 0.2s;
    }

    .aui .cm-tile-container > div .app-view-entry-taglib.entry-display-style.display-descriptive:hover {
        border: 1px solid #5EBCDD;
        background: #F0FBFF;
    }

    .aui .cm-tile-container > div .app-view-entry .entry-thumbnail {
        display: block;
        float: none;
        max-width: 100%;
        margin: 10px 10px 0px 10px;
        padding: 0px;
        height: 183px;
        background-repeat: no-repeat;
        background-position: center;
        overflow: hidden;
    }

    .aui .cm-tile-container > div .app-view-entry .entry-thumbnail img {
        width: 100%;
        max-width: 100%;
        box-shadow: none;
        box-sizing: border-box;
    }

    .aui .cm-tile-container > div .app-view-entry .entry-metadata {
        margin: 5px 10px 20px 10px;
        min-height: 60px;
    }

    .aui .img-polaroid {
        border: 0px;
    }

    .app-view-entry .entry-title {
        font-size: 1.2em;
    }

    span.entry-description {
        font-size: 1.1em;
        overflow: hidden;
        text-overflow: ellipsis;
        display: -webkit-box !important;
        -webkit-line-clamp: 2; /* 라인수 */
        -webkit-box-orient: vertical;
        word-wrap:break-word !important;
        line-height: 1.2em;
        height: 2.6em !important;
    }

    .entry-title-text{
        overflow: hidden;
        text-overflow: ellipsis;
        display: block;
        -webkit-line-clamp: 1; /* 라인수 */
        -webkit-box-orient: vertical;
        word-break: normal;
        line-height: 1.2em;
        height: 1.2em;
    }

    .pull-right {
        float: right;
        margin-right: 0;
    }

    #btnArea {
        padding-top: 10px;
    }
</style>

<div class="nav-menu sites-directory-taglib cm-tile-container">
    <c:choose>
        <c:when test="<%= hidden %>">
            <div class="alert alert-info">
                <liferay-ui:message key="no-sites-were-found"/>
            </div>
        </c:when>
        <c:otherwise>
            <c:choose>
                <c:when test="<%= Validator.isNull(portletDisplay.getId()) %>">
                    <div class="alert alert-info">
                        <liferay-ui:message arguments="<%= displayStyle %>"
                                            key="the-display-style-x-cannot-be-used-in-this-context"/>
                    </div>
                </c:when>
                <c:otherwise>

                    <%
                        PortletURL portletURL = PortletURLFactoryUtil.create(request, portletDisplay.getId(), plid, PortletRequest.RENDER_PHASE);
                    %>

                    <liferay-ui:search-container emptyResultsMessage="no-sites-were-found"
                                                 iteratorURL="<%= portletURL %>">

                        <%
                            List<Group> childGroups = null;

                            if (rootGroup != null) {
                                childGroups = rootGroup.getChildrenWithLayouts(true, QueryUtil.ALL_POS, QueryUtil.ALL_POS, new GroupNameComparator(true));
                            } else {
                                childGroups = GroupLocalServiceUtil.getLayoutsGroups(group.getCompanyId(), group.getParentGroupId(), true, QueryUtil.ALL_POS, QueryUtil.ALL_POS, new GroupIdComparator(true));
                            }

                            List<Group> visibleGroups = new UniqueList<Group>();

                            for (Group childGroup : childGroups) {
                                if (childGroup.hasPublicLayouts()) {
                                    visibleGroups.add(childGroup);
                                } else if (GroupLocalServiceUtil.hasUserGroup(user.getUserId(), childGroup.getGroupId())) {
                                    visibleGroups.add(childGroup);
                                }
                            }

                            total = visibleGroups.size();

                            searchContainer.setTotal(total);

                        %>

                        <liferay-ui:search-container-results
                                results="<%= ListUtil.subList(visibleGroups, searchContainer.getStart(), searchContainer.getEnd()) %>"
                        />

                        <liferay-ui:search-container-row
                                className="com.liferay.portal.model.Group"
                                modelVar="childGroup"
                        >

                            <%
                                LayoutSet layoutSet = null;

                                if (childGroup.hasPublicLayouts()) {
                                    layoutSet = childGroup.getPublicLayoutSet();
                                } else {
                                    layoutSet = childGroup.getPrivateLayoutSet();
                                }
                            %>
                            <%
                                long companyId = themeDisplay.getCompanyId();
                                Group defaultGroup = GroupLocalServiceUtil.getGroup(companyId, GroupConstants.GUEST);

                                if (defaultGroup.getGroupId() != childGroup.getGroupId()) {%>
                            <div id="panel<%= childGroup.getGroupId() %>"
                                 onclick="fn_openBlank('<%= childGroup.getGroupId()%>', '<%= scopeGroupId%>', '<%= PortalUtil.getGroupFriendlyURL(childGroup, !childGroup.hasPublicLayouts(), themeDisplay)%>');"
                                 css="cm-tile" class="communityTiles"
                                 style="
                                 <c:if test='<%= (childGroup.getGroupId() != scopeGroupId) %>'>cursor: pointer; color: #009ae5;</c:if>
                                         ">

                                <liferay-ui:app-view-entry
                                        assetCategoryClassName="<%= Group.class.getName() %>"
                                        assetCategoryClassPK="<%= childGroup.getGroupId() %>"
                                        assetTagClassName="<%= Group.class.getName() %>"
                                        assetTagClassPK="<%= childGroup.getGroupId() %>"
                                        description="<%= HtmlUtil.escape(childGroup.getDescription()) %>"
                                        displayStyle="<%= displayStyle %>"
                                        showCheckbox="<%= false %>"
                                        thumbnailSrc='<%= themeDisplay.getPathImage() + "/layout_set_logo?img_id=" + layoutSet.getLogoId() + "&t=" + WebServerServletTokenUtil.getToken(layoutSet.getLogoId()) %>'
                                        title="<%= HtmlUtil.escape(childGroup.getDescriptiveName(locale)) %>"
                                        cssClass=""
                                />

                            </div>
                            <%}%>
                        </liferay-ui:search-container-row>

                        <liferay-ui:search-paginator searchContainer="<%= searchContainer %>"/>
                    </liferay-ui:search-container>
                </c:otherwise>
            </c:choose>
        </c:otherwise>
    </c:choose>

</div>

<portlet:renderURL var="reqURL">
    <portlet:param name="action" value="requestMakeSite"></portlet:param>
</portlet:renderURL>

<div id="btnArea">
    <aui:button cssClass="search-button btn-success pull-right" value="request" href="${reqURL}"/>
</div>

<script type="text/javascript">
    function fn_openBlank(groupId, scopeGroupId, url) {
        if (groupId != scopeGroupId) {
            window.open(url, '_blank');
        }
    }
</script>
</div>