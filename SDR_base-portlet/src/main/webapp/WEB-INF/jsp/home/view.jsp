<%@ include file="/WEB-INF/jsp/home/init.jsp" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">

    <%--<link href="<c:url value='/js/bootstrap/dist/css/bootstrap.min.css'/>" rel="stylesheet">--%>
    <link href="<c:url value='/css/fontawesome/css/font-awesome.min.css'/>" rel="stylesheet">
    <link href="<c:url value='/css/lightSlider/lightslider.css'/>" rel="stylesheet">

</head>
<style>
    .collapse {
        display: block;
    }

    .portlet-column-content.empty {
        padding: 0
    }

    .commuTitle {
        overflow: hidden;
        height: 20px;
        font-size: 12px;
        font-family: Arial, Nanum Barun Gothic, NanumGothic;
    }
</style>
<body>

<div id="main-bar">
    <div id="bar-width">
        <h3>
            Everything for Computational Science & Engineering ::: <span class="text-yellow">Bridge to Computational Science for Higher Education and Advanced Research</span>
        </h3>
        <div class="dropdown">
            <button class="btn btn-sm btn-default dropdown-toggle" type="button" id="dropdownMenu2"
                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                관련 사이트 링크
                <span class="caret"></span>
            </button>
            <ul class="dropdown-menu dropdown-menu-right" aria-labelledby="dropdownMenu2">
                <li><a href="https://www.edison.re.kr/" target="_blank">EDISON</a></li>
                <%--<li class="dropdown-header">시뮬레이션 관련 사이트</li>--%>
                <%--<li><a href="#">e-Spin Simulation System</a></li>--%>
                <%--<li class="dropdown-header">외부 관련 사이트</li>--%>
                <%--<li><a href="#">미래창조과학부</a></li>--%>
                <%--<li><a href="#">한국연구재단</a></li>--%>
                <%--<li><a href="#">한국과학기술정보연구원</a></li>--%>
            </ul>
        </div>
    </div>
</div>

<%


    List<Group> childGroups = null;
    int total = 0;

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
%>

<div id="main-btn">
    <div id="main-row">
        <ul id="ul-btn">

            <%
                List<Group> groups = ListUtil.subList(visibleGroups, 0, 1000);

                for (Group childGroup : groups) {
                    if (mainGroupId == childGroup.getGroupId()) continue;
                    LayoutSet layoutSet = null;
                    if (childGroup.hasPublicLayouts()) {
                        layoutSet = childGroup.getPublicLayoutSet();
                    } else {
                        layoutSet = childGroup.getPrivateLayoutSet();
                    }
            %>
            <li>
                <a href="#"
                   onclick="fn_openBlank('<%= childGroup.getGroupId()%>', '<%= scopeGroupId%>', '<%= PortalUtil.getGroupFriendlyURL(childGroup, !childGroup.hasPublicLayouts(), themeDisplay)%>');">
                    <img src="<%= themeDisplay.getPathImage() + "/layout_set_logo?img_id=" + layoutSet.getLogoId() + "&t=" + WebServerServletTokenUtil.getToken(layoutSet.getLogoId()) %>"><br/>
                    <%--<%= HtmlUtil.escape(childGroup.getDescriptiveName(locale)) %>--%>
                    <label class="commuTitle"
                           style="font-size: 12px;"><%= HtmlUtil.escape(childGroup.getDescriptiveName(locale)) %>
                    </label>
                </a>
            </li>
            <%
                }
            %>


        </ul>
    </div>
</div>

<%--<script src="<c:url value='/js/jquery/jquery-3.2.1.min.js'/>"></script>--%>
<%--<script src="<c:url value='/js/bootstrap/dist/js/bootstrap.min.js'/>"></script>--%>
</body>
</html>


<script type="text/javascript">

    $('#main-bar #bar-width .dropdown').on('click', function () {
        var dropList = $('#main-bar #bar-width .dropdown >ul.dropdown-menu');

        if (dropList.css('display') == 'none') {
            $('#main-bar #bar-width .dropdown >ul.dropdown-menu').css('display', 'block');
        } else {
            $('#main-bar #bar-width .dropdown >ul.dropdown-menu').css('display', 'none');
        }

    });

    function fn_openBlank(groupId, scopeGroupId, url) {
        if (groupId != scopeGroupId) {
            window.open(url, '_blank');
        }
    }

    $(function () {
        $('#ul-btn').lightSlider({
            item: 6,
            loop: false,
            slideMove: 1,
            slideMargin: 10,
            slideEndAnimation: true,
            pager: false,
            speed: 700
        });
    });
</script>