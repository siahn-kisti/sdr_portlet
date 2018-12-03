<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%--
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@ page import="com.liferay.portal.model.Layout" %>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="com.sdr.metadata.model.Dataset" %>
<%@ page import="com.sdr.metadata.model.Collection" %>
<%@ page import="com.sdr.metadata.service.CollectionLocalServiceUtil" %>
<%@ page import="com.sdr.metadata.service.DatasetLocalServiceUtil" %>
<%@ page import="com.sdr.metadata.service.DataTypeLocalServiceUtil" %>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="com.liferay.portal.kernel.workflow.WorkflowConstants" %>
<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
--%>
<%@ page import="com.liferay.portal.kernel.portlet.LiferayWindowState" %>
<%@ page import="com.liferay.portal.kernel.servlet.SessionErrors" %>
<%@ page import="com.liferay.portal.security.auth.PrincipalException" %>
<%@ page import="com.liferay.portal.kernel.exception.SystemException" %>
<%@ page import="com.liferay.portal.kernel.exception.PortalException" %>

<portlet:defineObjects/>
<theme:defineObjects/>

<c:url value='/images/sample_100.png' var="defaultImage"/>

<liferay-ui:error exception="<%=PrincipalException.class%>"
                  message="<%=(String)SessionErrors.get(renderRequest, PrincipalException.class)%>"/>
<liferay-ui:error exception="<%=SystemException.class%>"
                  message="<%=(String)SessionErrors.get(renderRequest, SystemException.class)%>"/>
<liferay-ui:error exception="<%=PortalException.class%>"
                  message="<%=(String)SessionErrors.get(renderRequest, PortalException.class)%>"/>

