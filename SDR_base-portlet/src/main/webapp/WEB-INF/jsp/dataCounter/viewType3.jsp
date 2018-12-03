<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>


<div id="main-count">
    <div id="count-board">
        <h3 class="board_title">System Resource Statistics</h3>
        <table class="table table-striped">
            <colgroup>
                <col style="width:33%;">
                <col style="width:33%;">
                <col style="width:33%;">
            </colgroup>
            <thead>
            <tr>
                <th>Site</th>
                <th>Category</th>
                <th>Count</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td rowspan="4">CSE Portal</td>
                <td>Collection</td>
                <td>${collectionCnt}</td>
            </tr>
            <tr>
                <td>Dataset</td>
                <td>${datasetCnt}</td>
            </tr>
            <tr>
                <td>User</td>
                <td>${userCnt}</td>
            </tr>
            <tr>
                <td>Community</td>
                <td>${userCnt}</td>
            </tr>
            </tbody>
        </table>
    </div>
</div>