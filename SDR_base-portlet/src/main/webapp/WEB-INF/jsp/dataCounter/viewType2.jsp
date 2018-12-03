<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<div id="data-counter-type2">
    <ul>
        <li style="background-image: url('<c:url value='/images/defaultCommunity/icon-test01.jpg'/>');">
            <img src="<c:url value='/images/defaultCommunity/test01.png'/>"><br/>
            <p class="animatedNumberCount">${collectionCnt}</p>
            <h3>COLLECTION</h3>
        </li>
        <li style="background-image: url('<c:url value='/images/defaultCommunity/icon-test02.jpg'/>');">
            <img src="<c:url value='/images/defaultCommunity/test02.png'/>"><br/>
            <p class="animatedNumberCount">${datasetCnt}</p>
            <h3>DATASET</h3>
        </li>
        <li style="background-image: url('<c:url value='/images/defaultCommunity/icon-test03.jpg'/>');">
            <img src="<c:url value='/images/defaultCommunity/test03.png'/>"><br/>
            <p class="animatedNumberCount">${userCnt}</p>
            <h3>USERS</h3>
        </li>
    </ul>
</div>