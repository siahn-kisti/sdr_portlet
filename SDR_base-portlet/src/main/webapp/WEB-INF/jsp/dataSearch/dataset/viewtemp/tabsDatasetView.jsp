<%@ page import="com.liferay.portal.security.permission.ActionKeys" %>
<%@ page import="com.sdr.ac.CollectionModelPermission" %>
<%@ page import="com.sdr.ac.PermissionConstant" %>
<%@ page import="com.liferay.portal.theme.ThemeDisplay" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%-- <%@ page import="com.sdr.SampleDataSearch.service.permission.DatasetPermission" %> --%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/dataSearch/init.jsp" %>

<%
ThemeDisplay themeDisplay2 = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
boolean signedIn = themeDisplay2.isSignedIn();
%>

<liferay-ui:tabs names="${dataViewTitles }" param="tabs" refresh="${true }" url="${datasetViewTabURL }" tabsValues="${tabValue }"></liferay-ui:tabs>
<c:if test="${null ne dataset.provenanceMetadata && '' ne dataset.provenanceMetadata && not empty dataset.provenanceMetadata}">
    <script type="text/javascript">
        $( function() {
            var li = $('<li>');
            li.addClass('tab');
            li.attr('class', 're-run-tab')

            var a = $('<a>');
            a.attr('id', 're-run-simulation');

            a.text('Rerun simulation');

            li.append(a);

            $('#submissionTab').find('.nav-tabs').append(li)

            $(document).on("click", '#re-run-simulation', function(){
                var signedIn = <%=signedIn %>;
                console.log('signedIn ===>' + signedIn);
                if(signedIn === true) {
                    if(confirm('Are you sure to rerun this simulation ?'))
                        location.href = '${rerunURL}';
                } else {
                    alert("Please Sign In First.");
                }
            });
        });
    </script>
</c:if>



<style>
    #submissionTab .re-run-tab a {
        background-color: #337ab7;
        color: #ffffff !important;
        text-decoration: none;
        font-weight: bold;
        cursor: pointer;
    }
</style>