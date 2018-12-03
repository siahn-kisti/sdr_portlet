<%--
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

This is the <b>SDR_codeViewer</b> portlet.<br />

<c:out escapeXml="true" value="${releaseInfo}" />.
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/mlMyPage/init.jsp" %>

<liferay-ui:success key="success" message="Data saved successfully!"/>
<liferay-ui:error key="error" message="${errorMessage}" />
<c:if test="${empty errorMessage}">

    <div class="edison-sdr-portlet">
        <iframe name="codeViewerIframe" id="codeViewerIframe" src="${jupyterhubUri}" width="100%" height="600px" border="0"  bordercolor="#000000" frameborder="0">
        </iframe>
    </div>

</c:if>