<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ page import="com.liferay.portal.kernel.util.Constants" %>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@ page import="com.liferay.portal.kernel.util.Validator" %>
<%@ page import="com.sdr.bbs.model.Bbs" %>
<%@ page import="com.sdr.bbs.service.BbsLocalServiceUtil" %>
<%@ page import="java.util.List" %>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<portlet:defineObjects/>
<liferay-theme:defineObjects/>

<%
    long prefPlid = GetterUtil.getLong(portletPreferences.getValue("prefPlid", "0"));
    long prefBbsId = GetterUtil.getLong(portletPreferences.getValue("prefBbsId", "0"));
    int prefType = GetterUtil.getInteger(portletPreferences.getValue("prefType", "0"));
    int prefMessageNo = GetterUtil.getInteger(portletPreferences.getValue("prefMessageNo", "4"));
    boolean prefShowDate = GetterUtil.getBoolean(portletPreferences.getValue("prefShowDate", "true"));

    Bbs bbs = null;
    if (prefBbsId > 0) {
        bbs = (Bbs) request.getAttribute("bbs");

        if (Validator.isNotNull(bbs)) {
            if (bbs.getBbsId() != prefBbsId) {
                bbs = null;
            }
        }
    }
    String keyword = ParamUtil.getString(request, "keyword");
    int idx = 0;
%>