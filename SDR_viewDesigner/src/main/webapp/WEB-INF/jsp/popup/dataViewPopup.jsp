
<liferay-ui:search-container total="${total }" delta="5" emptyResultsMessage="no-entries-were-found">
	<liferay-ui:search-container-results results="${dataViewList }" />
	<liferay-ui:search-container-row className="com.sdr.metadata.model.DataView" modelVar="dataView" 
	keyProperty="dataViewId" escapedModel="${true }">
		
    <portlet:actionURL var="dataViewDeleteURL">
    	<portlet:param name="action" value="dataViewDelete"/>
        <portlet:param name="dataViewId" value="${dataView.dataViewId }"/>
    </portlet:actionURL>
		
		<div class="dataViewSearchList">
			<div class="textArea">
				<span class="textLine"></span>${dataView.dataViewId}
				<span class="textLine"></span>${dataView.title}
				<span class="textLine"></span>${dataView.dataTypeId }
			</div>
			<aui:button onClick="${ dataViewDeleteURL }" value="Delete"></aui:button>
		</div>
		
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>