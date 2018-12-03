<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/components/init.jsp" %>

<div class="edison-sdr-portlet">

<c:if test="<%=SessionErrors.isEmpty(renderRequest)%>">

	<portlet:renderURL var="viewURL"></portlet:renderURL>

	<portlet:renderURL var="editURL">
		<portlet:param name="action" value="edit"></portlet:param>
		<portlet:param name="dataViewComponentsId" value="0"/>
	</portlet:renderURL>

    <liferay-portlet:resourceURL id="getImage" var="getImageURL" portletName="sdrcommon_WAR_SDR_baseportlet"></liferay-portlet:resourceURL>
    <c:set var="getImageURL_path" value="${getImageURL}&_sdrcommon_WAR_SDR_baseportlet_path="/>
    
	
	<script type="text/javascript" src="<c:url value='/js/jquery/jquery.min.js'/>"></script>

	<style>
		#_SDR_viewComponents_WAR_SDR_viewDesignerportlet_dataViewComponentsesSearchContainer{
			display: none;
		}
		#board_body .boardTile .lfr-search-container {
			border: 0px;
			background: transparent;
		}

        .aui #board_body .search-inputbox .input-append input[type="text"] {
            width: 610px;
            height: 22px;
            border: 0;
            box-shadow: none;
        }
        .aui .input-append, .aui .input-prepend{
            display: inline-block;
        }
        .aui #board_body .search-inputbox{
            font-size: 24px;
        }
	</style>
	
	<h3><liferay-ui:message key="View Components"/></h3>
	<div id="board_body">

		<aui:form method="post" name="fm" action="${viewURL}">

			<!-- 상단 검색바-논 셀렉트 영역 -->
			<div class="search-form">
				<div class="control-group search-inputbox">
					<div class="input-append">
						<aui:input type="text" inlineField="true" label="" name="keyword" size="30"
								   placeholder="Please enter your Keyword" id="searchInput"/>
					</div>
					<aui:button cssClass="btn-success search-button" type="button" value="search" id="searchBtn" />
				</div>
			</div>
			<!--// 상단 검색바-논 셀렉트 영역 -->


			<!-- tile형 게시물 리스트 영역 -->
			<div class="boardTile">
				<liferay-ui:search-container searchContainer="${searchContainer}">
					<ul class="boardTileList" style="list-style: none;">
						<liferay-ui:search-container-results results="${searchContainer.results}"
															 total="${searchContainer.total}"/>
						<liferay-ui:search-container-row className="com.sdr.metadata.model.DataViewComponents" modelVar="vo">
							<portlet:renderURL var="detailURL">
								<portlet:param name="action" value="detail"/>
								<portlet:param name="dataViewComponentsId" value="${vo.dataViewComponentsId}"/>
							</portlet:renderURL>

							<li>
								<a href="#LINK" onclick="location.href='${detailURL}'">
									<div class="imgArea" style="text-align: center;">
										<c:if test="${not empty vo.image}">
											<img src="${getImageURL_path}${vo.image}" style="max-width:207px;max-height:159px;">
										</c:if>
										<c:if test="${empty vo.image}">
											<img src="<c:url value='/images/sample_100.png'/>" style="max-width:207px;max-height:159px;">
										</c:if>
									</div>
									<h4>${vo.compGroup} / ${vo.compName} </h4>
									<label class="textTitleString">
										<%--<c:out value="${vo.description}" escapeXml="flase"/>--%>
										<%--<c:out value="${fn:substring(vo.description,0,13)}" escapeXml="false"/>--%>
										<c:out value='${fn:substring(vo.description.replaceAll("\\\<.*?\\\>",""),0, 90)}' />
									</label>
								</a>

								<div style="position: absolute; margin:-35px 4px 10px -12px;">
									<aui:workflow-status showIcon="false" showLabel="false" status="${vo.status}"/>
								</div>
							</li>
						</liferay-ui:search-container-row>
					</ul>
                    <liferay-ui:search-paginator searchContainer="${searchContainer }"/>
					<%-- <liferay-ui:search-iterator /> --%>
				</liferay-ui:search-container>
				<!--// tile형 게시물 리스트 영역 -->

				<aui:button id="editBtn" cssClass="btn btn-success btn-right" value="Create" onClick="${editURL}"/>
			</div>

			<%--<div class="listBoardArea">--%>

				<%--<liferay-ui:search-container searchContainer="${searchContainer}">--%>
					<%--<liferay-ui:search-container-results results="${searchContainer.results}"--%>
														 <%--total="${searchContainer.total}"/>--%>
					<%--<liferay-ui:search-container-row className="com.sdr.metadata.model.DataViewComponents"--%>
													 <%--modelVar="vo">--%>

						<%--<portlet:renderURL var="detailURL">--%>
							<%--<portlet:param name="action" value="detail"/>--%>
							<%--<portlet:param name="dataViewComponentsId" value="${vo.dataViewComponentsId}"/>--%>
						<%--</portlet:renderURL>--%>

						<%--<liferay-ui:search-container-column-text name="Image" align="center">--%>
							<%--<div style="text-align: center;">--%>
								<%--<c:if test="${not empty vo.image}">--%>
									<%--<img src="${vo.image}" style="max-width:120px;max-height:120px;">--%>
								<%--</c:if>--%>
								<%--<c:if test="${empty vo.image}">--%>
									<%--<img src="<c:url value='/images/no-image.gif'/>" style="max-width:120px;max-height:120px;">--%>
								<%--</c:if>--%>
							<%--</div>--%>
						<%--</liferay-ui:search-container-column-text>--%>
						<%----%>
						<%--<liferay-ui:search-container-column-text property="compGroup" name="Group" />--%>
						<%--<liferay-ui:search-container-column-text property="compName" name="Name" href="${detailURL}" />--%>
						<%----%>
						<%--<liferay-ui:search-container-column-date property="modifiedDate" name="modifiedDate"/>--%>

						<%--<liferay-ui:search-container-column-status property="status"/>--%>

					<%--</liferay-ui:search-container-row>--%>
					<%--<liferay-ui:search-iterator paginate="true" searchContainer="${searchContainer}"/>--%>
				<%--</liferay-ui:search-container>--%>

				<%--<div class="cvBtn">--%>
					<%--<aui:button id="editBtn" cssClass="btn btn-success btn-right" value="Create" onClick="${editURL}"/>--%>
				<%--</div>--%>

			<%--</div>--%>
			
		</aui:form>
		
	</div>

	<script>
		$("#<portlet:namespace/>searchInput").keydown(function (e) {
			if (e.keyCode == 13) {
				e.preventDefault();
				$("#searchBtn").trigger("click");
			}
		});

		AUI().use('aui-base', 'liferay-portlet-url', 'aui-node', 'liferay-util-window', function (A) {
			A.one('#<portlet:namespace/>fm').delegate('click', function (event) {
				var f = document.<portlet:namespace/>fm;
				f.submit();
			}, '.search-button');
		});
	</script>

</c:if>
    
</div>