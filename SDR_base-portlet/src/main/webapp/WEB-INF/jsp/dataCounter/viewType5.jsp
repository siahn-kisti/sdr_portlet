<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<div id="data-counter-type5">
    <table class="table table-striped">
        <colgroup>
            <col style="width:50%;">
            <col style="width:50%;">
        </colgroup>
        <tbody>
        <tr>
            <td onclick="location.href='${collectionURL}'">
                <img src="<c:url value='/images/defaultCommunity/test01.png'/>">
                <p class="animatedNumberCount">${collectionCnt}</p>
                <div style="margin-left: 110px;">
                    <h3>COLLECTION</h3>
                </div>
            </td>
        </tr>
        <tr>
            <td onclick="location.href='${datasetURL}'">
                <img src="<c:url value='/images/defaultCommunity/test02.png'/>">
                <p class="animatedNumberCount">${datasetCnt}</p>
                <div style="margin-left: 110px;">
                    <h3>DATASET</h3>
                </div>
            </td>
        </tr>

        </tbody>
    </table>
</div>