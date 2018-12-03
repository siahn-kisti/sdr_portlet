<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/dataSearch/init.jsp" %>

<script src="<c:url value='/js/jquery/jquery-3.2.1.min.js'/>"></script>

<script src="<c:url value='/js/tagCloud/d3.min.js'/>"></script>
<script src="<c:url value='/js/tagCloud/d3.layout.cloud.js'/>"></script>

<script>
    $(document).ready(function () {

            var skillsToDraw = ${tagsList};
            console.log(skillsToDraw);
            var width = $(document).width();
            var height = 450;
            var fill = d3.schemeCategory20;

            d3.layout.cloud()
                .size([width, height])
                .words(skillsToDraw)
                .padding(5)
                .rotate(function () {
                    return ~~(Math.random() * 1) * 90;
                })
                .font("Impact")
                .fontSize(function (d) {
                    return d.size * 20;
                })
                .on("end", drawSkillCloud)
                .start();

            function drawSkillCloud(words) {
                d3.select("body").append("svg")
                    .attr("width", width)
                    .attr("height", height)
                    .append("g")
                    .attr("transform", "translate(" + width / 2 + "," + height / 2 + ")")
                    .selectAll("text")
                    .data(words)
                    .enter().append("text")
                    .style("font-size", function (d) {
                        return d.size + "px";
                    })
                    .style("font-family", "Impact")
                    .style("cursor", "pointer")
                    .style("fill", function (d, i) {
                        return fill[i];
                    })
                    .attr("text-anchor", "middle")
                    .attr("transform", function (d) {
                        return "translate(" + [d.x, d.y] + ")rotate(" + d.rotate + ")";
                    })
                    .text(function (d) {
                        return d.text;
                    })
                    .on("click", function (d) {
                        if (<%=request.getParameter("popup")%>) {
                            tagCloudLink(d.href);
                        } else {
                            location.href = d.href;
                        }
                    });
            }
        }
    );
</script>

<liferay-ui:panel-container cssClass="taglib-asset-tags-navigation" extended="${true}" persistState="${true}">
    <%--<div style="border: 1px; width: 100%; height: 500px; text-align: center">--%>
    <div style="border: 1px;text-align: center">
        <div id="cloud" style="display: inline-block"></div>
    </div>
</liferay-ui:panel-container>

<script>
    function tagCloudLink(uri) {
        var Util = Liferay.Util;
        Util.getOpener().Liferay.fire('tagcloudsearch_collectionPopup', uri);
        Util.getWindow().hide();
    }
</script>

