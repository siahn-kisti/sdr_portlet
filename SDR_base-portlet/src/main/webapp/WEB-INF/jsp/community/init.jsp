<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page import="com.liferay.portal.model.Group" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.liferay.portal.service.GroupLocalServiceUtil" %>
<%@ page import="com.liferay.taglib.ui.SitesDirectoryTag" %>
<%@ page import="javax.portlet.PortletURL" %>
<%@ page import="com.liferay.portlet.PortletURLFactoryUtil" %>
<%@ page import="javax.portlet.PortletRequest" %>
<%@ page import="com.liferay.portal.kernel.dao.orm.QueryUtil" %>
<%@ page import="com.liferay.portal.util.comparator.GroupNameComparator" %>
<%@ page import="com.liferay.portal.model.GroupConstants" %>
<%@ page import="com.liferay.portal.util.comparator.GroupIdComparator" %>
<%@ page import="com.liferay.portal.model.LayoutSet" %>
<%@ page import="com.liferay.portal.util.PortalUtil" %>
<%@ page import="com.liferay.portal.webserver.WebServerServletTokenUtil" %>
<%@ page import="com.liferay.portal.kernel.util.*" %>
<%@ page import="javax.portlet.PortletResponse" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>

<portlet:defineObjects />
<theme:defineObjects />

<script src="<c:url value='/js/jquery/jquery-3.2.1.min.js'/>"></script>

<%
    PortletRequest portletRequest = (PortletRequest)request.getAttribute(JavaConstants.JAVAX_PORTLET_REQUEST);

    PortletResponse portletResponse = (PortletResponse)request.getAttribute(JavaConstants.JAVAX_PORTLET_RESPONSE);

    String namespace = StringPool.BLANK;

    boolean auiFormUseNamespace = GetterUtil.getBoolean((String)request.getAttribute("aui:form:useNamespace"), true);

    if ((portletResponse != null) && auiFormUseNamespace) {
        namespace = GetterUtil.getString(request.getAttribute("aui:form:portletNamespace"), portletResponse.getNamespace());
    }

    String currentURL = PortalUtil.getCurrentURL(request);

//    String displayStyle = (String)request.getAttribute("liferay-ui:sites-directory:displayStyle");
//    String sites = (String)request.getAttribute("liferay-ui:sites-directory:sites");
    String displayStyle = "descriptive";
    String sites = "top-level";

    Group group = GroupLocalServiceUtil.getGroup(scopeGroupId);

    Group rootGroup = null;
    boolean hidden = false;

    List<Group> branchGroups = new ArrayList<Group>();

    branchGroups.add(group);
    branchGroups.addAll(group.getAncestors());

    if (sites.equals(SitesDirectoryTag.SITES_TOP_LEVEL)) {
    }
    else if (sites.equals(SitesDirectoryTag.SITES_CHILDREN) && (branchGroups.size() > 0)) {
        rootGroup = branchGroups.get(0);
    }
    else if (sites.equals(SitesDirectoryTag.SITES_SIBLINGS) && (branchGroups.size() > 1)) {
        rootGroup = branchGroups.get(1);
    }
    else if (sites.equals(SitesDirectoryTag.SITES_SIBLINGS) && group.isRoot()) {
    }
    else if (sites.equals(SitesDirectoryTag.SITES_PARENT_LEVEL) && (branchGroups.size() > 2)) {
        rootGroup = branchGroups.get(2);
    }
    else if (sites.equals(SitesDirectoryTag.SITES_PARENT_LEVEL) && (branchGroups.size() == 2)) {
    }
    else {
        hidden = true;
    }

    int idx = 0;
%>