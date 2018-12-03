<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<div id="data-counter-type1">
    <ul>
        <li onclick="location.href='${collectionURL}'">
            <img src="<c:url value='/images/dataCounter/icon_msc_sub_01.png'/>">
            <h5>Collection</h5>
            <p class="animatedNumberCount">${collectionCnt}</p>
        </li>
        <%--<li onclick="location.href='${datasetURL}'">--%>
        <li onclick="location.href='${collectionURL}'">
            <img src="<c:url value='/images/dataCounter/icon_msc_sub_02.png'/>">
            <h5>Dataset</h5>
            <p class="animatedNumberCount">${datasetCnt}</p>

        </li>
        <li onclick="location.href='${toolsURL}'">
            <img src="<c:url value='/images/dataCounter/icon_msc_sub_04.png'/>" href="${toolsURL}">
            <h5>Analysis Tool</h5>
            <p class="animatedNumberCount">7</p>

        </li>
        <li>
            <img src="<c:url value='/images/dataCounter/icon_msc_sub_03.png'/>">
            <h5>Users</h5>
            <p class="animatedNumberCount">${userCnt}</p>

        </li>
    </ul>
</div>