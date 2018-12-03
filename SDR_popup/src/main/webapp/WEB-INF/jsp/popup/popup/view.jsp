<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@include file="/WEB-INF/jsp/popup/popup/init.jsp" %>

<%@ page import="com.sdr.popup.model.Popup" %>
<%@ page import="java.util.List" %>
<%@ page import="com.liferay.portal.kernel.repository.model.FileEntry" %>
<%@ page import="java.io.File" %>
<%@ page import="com.liferay.portal.theme.ThemeDisplay" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil" %>

<%
    ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
    List<Popup> popups = (List) request.getAttribute("popups");
    int popupTotal = (Integer) request.getAttribute("popupTotal");
%>

<script>

    $(function () {

        var windowWidth = window.innerWidth;
        var windowHeight = window.innerHeight;

        var left = 10;
        var top = 150;
        var nextLine = 0;

        <%
        for (int i = 0; i < popupTotal; i++) {
        Popup popup = popups.get(i);
        %>
        var width = '<%= popup.getWidth()%>';
        var height = '<%= popup.getHeight() + 100%>';

        if (windowWidth < width * 1 + left) {

            if (windowWidth <= width) {
                height = height * ((windowHeight * 1 - 10) / width);
                width = windowWidth - 10;
            }

            left = 5;
            top = nextLine * 1 + 150;

        }

        if (windowHeight < height * 1 + top) {
            top = (windowHeight / 2);
        }

        var doNotOpen1Day = jQuery.cookie("<portlet:namespace/>modal_<%=themeDisplay.getScopeGroupId()%>-<%= i %>");

        console.log(doNotOpen1Day);
        if (!doNotOpen1Day || doNotOpen1Day != "Y") {
            $('#<portlet:namespace/>modal_<%=themeDisplay.getScopeGroupId()%>-<%= i %>').dialog({
                resizable: false,
                buttons: {
                    "하루동안 열지 않기": function () {
                        jQuery.cookie("<portlet:namespace/>modal_<%=themeDisplay.getScopeGroupId()%>-<%= i %>", "Y", {expires: 1});
                        $('#<portlet:namespace/>modal_<%=themeDisplay.getScopeGroupId()%>-<%= i %>').dialog("close");
                    }
                },
                width: width,
                height: height,
                position: {my: "left+" + left + " top+" + top, at: "left top", of: window}
            });
        } else {
            $('#<portlet:namespace/>modal_<%=themeDisplay.getScopeGroupId()%>-<%= i %>').hide();
        }

        left += width * 1 + 10 + 1;

        if (nextLine < height) {
            nextLine = height;
        }

        <%
        }
        %>
    });

</script>

<c:if test='${!empty popupTotal}'>
    <div class="yui3-skin-sam">
        <%
            for (int i = 0; i < popupTotal; i++) {
                Popup popup = popups.get(i);
                long imgPathId = popup.getImgPath();
                String imagePath = "";
                try {
                    FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(imgPathId);
                    imagePath = themeDisplay.getPortalURL() + "/documents/" + fileEntry.getGroupId() + File.separator + fileEntry.getFolderId() + File.separator + fileEntry.getTitle() + File.separator + fileEntry.getUuid();
                } catch (Exception e) {
                    imagePath = "/";
                }
        %>
        <div id="<portlet:namespace/>modal_<%=themeDisplay.getScopeGroupId()%>-<%= i %>" style="display: none"
             title="<%= popup.getTitle()%>">
            <img src="<c:url value='<%= imagePath%>'/>"/>
        </div>
        <%
            }
        %>
    </div>
</c:if>