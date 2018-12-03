<liferay-ui:search-container-column-text name="Reindex">
    <div style="text-align: center; width:75px;">
        <c:if test="${(tabs ne 'dataType') }">
            <portlet:resourceURL id="collectionWorkflow" var="reindexURL">
                <portlet:param name="collectionId" value="${collection.collectionId}"/>
                <portlet:param name="flag" value="reindex"/>
                <portlet:param name="tabs" value="${tabs }"/>
                <portlet:param name="tabList" value="${tabList }"/>
                <portlet:param name="workflowId" value="${workflowId }"/>
            </portlet:resourceURL>
        </c:if>
        <button class="btn btn-mini selector-button btn-primary wfBtns" data-action="reindex" href="${reindexURL}">
            Reindex
        </button>
    </div>
</liferay-ui:search-container-column-text>