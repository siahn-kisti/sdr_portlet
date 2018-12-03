<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@ page import="com.liferay.portal.kernel.util.StringPool" %>
<%@page import="com.sdr.metadata.model.Collection" %>
<%@ page import="com.sdr.metadata.model.Dataset"%>
<%@ page import="com.sdr.metadata.service.CollectionLocalServiceUtil"%>
<%@ page import="com.sdr.metadata.service.DatasetLocalServiceUtil"%>
<%@ page import="com.sdr.metadata.service.DataTypeLocalServiceUtil"%>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<portlet:defineObjects />
<theme:defineObjects />

<%--<link rel="stylesheet" type="text/css" href="<c:url value='/js/bootstrap/dist/css/bootstrap.css'/>">--%>
<script src="<c:url value='/js/jquery/jquery-3.2.1.min.js'/>"></script>
<%--<script src="<c:url value='/js/bootstrap/dist/js/bootstrap.min.js'/>"></script>--%>
