<liferay-ui:search-container-column-text name="workflow">
    <div style="text-align: center; width:75px;">
        <p style="padding-top: 10px">
            <c:choose>
                <c:when test="${collection.pending eq 0 || dataType.pending eq 0}">
                    <button class="btn btn-primary btn-mini selector-button wfBtns" data-action="accept" disabled="disabled">
                        Accept
                    </button>
                </c:when>
                <c:otherwise>
                    <c:if test="${collection.pending ne 0 && !empty collection.pending }">
                        <portlet:resourceURL id="collectionWorkflow" var="publishURL">
                            <portlet:param name="collectionId" value="${collection.collectionId}"/>
                            <portlet:param name="flag" value="accept"/>
                            <portlet:param name="tabs" value="${tabs }"/>
                            <portlet:param name="tabList" value="${tabList }"/>
                            <portlet:param name="workflowId" value="${workflowId }"/>
                        </portlet:resourceURL>
                    </c:if>
                    <c:if test="${dataType.pending ne 0 && !empty dataType.pending }">
                        <portlet:resourceURL id="dataTypeWorkflow" var="publishURL">
                            <portlet:param name="action" value="dataTypeWorkflow"/>
                            <portlet:param name="dataTypeId" value="${dataType.dataTypeId}"/>
                            <portlet:param name="flag" value="approved"/>
                        </portlet:resourceURL>
                    </c:if>
                    <button class="btn btn-mini selector-button btn-primary wfBtns" data-action="accept" href="${publishURL}">
                        Accept
                    </button>
                </c:otherwise>
            </c:choose>
        </p>
        <p>
            <c:choose>
                <c:when test="${collection.pending eq 0 || dataType.pending eq 0}">
                    <button class="btn btn-mini selector-button wfBtns" data-action="reject" disabled="disabled">
                        Reject
                    </button>
                </c:when>
                <c:otherwise>
                    <c:if test="${collection.pending ne 0 && !empty collection.pending }">
                        <portlet:resourceURL id="collectionWorkflow" var="rejectURL">
                            <portlet:param name="collectionId" value="${collection.collectionId}"/>
                            <portlet:param name="flag" value="reject"/>
                            <portlet:param name="tabs" value="${tabs }"/>
                            <portlet:param name="tabList" value="${tabList }"/>
                            <portlet:param name="workflowId" value="${workflowId }"/>
                        </portlet:resourceURL>
                    </c:if>
                    <c:if test="${dataType.pending ne 0 && !empty dataType.pending }">
                        <portlet:resourceURL id="dataTypeWorkflow" var="rejectURL">
                            <portlet:param name="dataTypeId" value="${dataType.dataTypeId}"/>
                            <portlet:param name="flag" value="reject"/>
                        </portlet:resourceURL>
                    </c:if>
                    <button class="btn btn-mini selector-button wfBtns" data-action="reject" href="${rejectURL}">
                        Reject
                    </button>
                </c:otherwise>
            </c:choose>
        </p>
    </div>
</liferay-ui:search-container-column-text>