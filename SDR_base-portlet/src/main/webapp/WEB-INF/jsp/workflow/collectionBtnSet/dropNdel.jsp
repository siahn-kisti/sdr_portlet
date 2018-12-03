<liferay-ui:search-container-column-text name="Drop">
    <%-- 기존의 drop 기능은 해당 collection 의 dataset 을 삭제하는 기능이였음. --%>
    <%--
    <div style="text-align: center; width:75px;">
        <p style="padding-top: 10px">
            <c:choose>
                <c:when test="${(tabs eq 'Administrator') || (tabs eq 'My Data') || (tabs eq 'dataType')}">
                    <c:if test="${(tabs ne 'dataType') }">
                        <portlet:resourceURL id="collectionWorkflow" var="dropURL">
                            <portlet:param name="collectionId" value="${collection.collectionId}"/>
                            <portlet:param name="flag" value="drop"/>
                            <portlet:param name="tabs" value="${tabs }"/>
                            <portlet:param name="tabList" value="${tabList }"/>
                            <portlet:param name="workflowId" value="${workflowId }"/>
                        </portlet:resourceURL>
                    </c:if>
                    <c:if test="${(tabs eq 'dataType') }">
                        <portlet:resourceURL id="dataTypeWorkflow" var="dropURL">
                            <portlet:param name="action" value="dataTypeWorkflow"/>
                            <portlet:param name="dataTypeId" value="${dataType.dataTypeId}"/>
                            <portlet:param name="flag" value="drop"/>
                        </portlet:resourceURL>
                    </c:if>
                    <button class="btn btn-primary btn-mini selector-button wfBtns" data-action="drop" href="${dropURL}">
                        Drop
                    </button>
                </c:when>
                <c:otherwise>
                    <button class="btn btn-primary btn-mini selector-button wfBtns" data-action="drop" disabled="disabled">
                        Drop
                    </button>
                </c:otherwise>
            </c:choose>
        </p>
    </div>
    --%>
    <%--dropCollection 추가 (해당 collection에 dataset이 하나도 없을경우 collection 삭제할수 있음) --%>
    <div style="text-align: center; width:75px;">
        <c:choose>
            <c:when test="${collection.datasetCnt<=0}">
                <c:if test="${(tabs eq 'Administrator') || (tabs eq 'My Data')}">
                    <portlet:resourceURL id="collectionWorkflow" var="dropDelURL">
                        <portlet:param name="collectionId" value="${collection.collectionId}"/>
                        <portlet:param name="flag" value="dropCollection"/>
                        <portlet:param name="tabs" value="${tabs }"/>
                        <portlet:param name="tabList" value="${tabList }"/>
                        <portlet:param name="workflowId" value="${workflowId }"/>
                    </portlet:resourceURL>
                </c:if>
                <c:if test="${(tabs eq 'dataType') }">
                    <portlet:resourceURL id="dataTypeWorkflow" var="dropDelURL">
                        <portlet:param name="dataTypeId" value="${dataType.dataTypeId}"/>
                        <portlet:param name="flag" value="dropCollection"/>
                    </portlet:resourceURL>
                </c:if>
                <button class="btn btn-primary btn-mini selector-button wfBtns" data-action="dropCollection" href="${dropDelURL}">
                    Delete
                </button>
            </c:when>
            <c:otherwise>
                <button class="btn btn-primary btn-mini selector-button wfBtns" data-action="dropCollection" disabled="disabled"
                        title="Dataset count: ${collection.datasetCnt}">
                    Delete
                </button>
            </c:otherwise>
        </c:choose>
    </div>
</liferay-ui:search-container-column-text>
