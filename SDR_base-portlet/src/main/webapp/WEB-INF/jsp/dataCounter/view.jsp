<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@include file="/WEB-INF/jsp/dataCounter/init.jsp" %>
<link href="<c:url value='/css/dataCounter/dataCounter.css'/>" rel="stylesheet">
<link href="<c:url value='/css/fontawesome/css/font-awesome.min.css'/>" rel="stylesheet">

<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>--%>

<script>
    $(function () {

        var ranges = [
            {divider: 1e18, suffix: 'P'},
            {divider: 1e15, suffix: 'E'},
            {divider: 1e12, suffix: 'T'},
            {divider: 1e9, suffix: 'G'},
            {divider: 1e6, suffix: 'M'},
            {divider: 1e3, suffix: 'k'}
        ];

        function formatNumber(n) {
            for (var i = 0; i < ranges.length; i++) {
                if (n >= ranges[i].divider) {
                    return Math.floor(n / ranges[i].divider).toString() + ranges[i].suffix;
                }
            }
            return n.toString();
        }

        $('.animatedNumberCount').each(function (i, e) {
            $(this).prop('Counter', 0).animate({
                Counter: $(e).text()
            }, {
                duration: 2000,
                easing: 'linear',
                step: function (now) {
                    if (now >= 1000) {
                        $(this).text(formatNumber(now));
                    } else {
                        $(this).text(String(Math.ceil(now)).replace(/\B(?=(\d{3})+(?!\d))/g, ','));
                    }
                }
            });
        });
    });
</script>

<c:if test='<%= prefStyle == 0L %>'>
    <div class="alert alert-warning">
        <liferay-ui:message key="dataCounter.needed-to-choose-style"/>
    </div>
</c:if>
<c:if test='<%= prefStyle == 1 %>'>
    <%@include file="/WEB-INF/jsp/dataCounter/viewType1.jsp" %>
</c:if>
<c:if test='<%= prefStyle == 2 %>'>
    <%@include file="/WEB-INF/jsp/dataCounter/viewType2.jsp" %>
</c:if>
<c:if test='<%= prefStyle == 3 %>'>
    <%@include file="/WEB-INF/jsp/dataCounter/viewType3.jsp" %>
</c:if>
<c:if test='<%= prefStyle == 4 %>'>
    <%@include file="/WEB-INF/jsp/dataCounter/viewType4.jsp" %>
</c:if>
<c:if test='<%= prefStyle == 5 %>'>
    <%@include file="/WEB-INF/jsp/dataCounter/viewType5.jsp" %>
</c:if>