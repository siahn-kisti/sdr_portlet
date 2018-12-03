<liferay-ui:search-container-column-text name="Curate">
    <div style="text-align: center; width:75px;">
        <p  style="padding-top: 10px">
            <c:choose>
                <c:when test="${(tabs eq 'Administrator') || (tabs eq 'My Data') || (tabs eq 'dataType')}">
                    <c:if test="${(tabs ne 'dataType') }">
                        <portlet:resourceURL id="collectionWorkflow" var="resubmitURL">
                            <portlet:param name="collectionId" value="${collection.collectionId}"/>
                            <portlet:param name="flag" value="resubmit"/>
                            <portlet:param name="tabs" value="${tabs }"/>
                            <portlet:param name="tabList" value="${tabList }"/>
                            <portlet:param name="workflowId" value="${workflowId }"/>
                        </portlet:resourceURL>
                    </c:if>
                    <c:if test="${(tabs eq 'dataType') }">
                        <portlet:resourceURL id="dataTypeWorkflow" var="resubmitURL">
                            <portlet:param name="dataTypeId" value="${dataType.dataTypeId}"/>
                            <portlet:param name="flag" value="resubmit"/>
                        </portlet:resourceURL>
                    </c:if>
                    <button class="btn btn-mini selector-button btn-primary wfBtns" data-action="curate" href="${resubmitURL}">
                        Curate
                    </button>
                </c:when>
                <c:otherwise>
                    <button class="btn btn-mini selector-button btn-primary wfBtns" data-action="curate" disabled="disabled">
                        Curate
                    </button>
                </c:otherwise>
            </c:choose>
        </p>
        <c:if test="${(tabs eq 'Administrator')}">
            <p>
                <portlet:resourceURL id="collectionWorkflow" var="skipCurateURL">
                    <portlet:param name="collectionId" value="${collection.collectionId}"/>
                    <portlet:param name="flag" value="skipCurate"/>
                    <portlet:param name="tabs" value="${tabs }"/>
                    <portlet:param name="tabList" value="${tabList }"/>
                    <portlet:param name="workflowId" value="${workflowId }"/>
                </portlet:resourceURL>
                <button class="btn btn-mini selector-button wfBtns" data-action="skip-curate" href="${skipCurateURL}">
                    <c:choose>
                        <c:when test="${collection.skipCurate eq false}">
                            Skip On
                        </c:when>
                        <c:otherwise>
                            Skip Off
                        </c:otherwise>
                    </c:choose>
                </button>
            </p>
        </c:if>
    </div>
</liferay-ui:search-container-column-text>