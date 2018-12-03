<div class="search-facet">
    <ul class="nav nav-pills nav-stacked scopes">
        <li class="facet-value default"><a data-value="0" class="dataType">DataType<span
                class="default-badge">reset</span></a>
        </li>
        <c:forEach items="${dataTypeFacet}" var="dataType" varStatus="status" end="14">
            <c:choose>
                <c:when test="${status.count > 5}">
                    <li class="facet-value tab-move dataType" value="${dataType.dataTypeId }" style="display: none">
                        <a class="dataType">${dataType.dataTypeName}</a><span
                            class="badge badge-search frequency">${dataType.dataTypeCnt }</span>
                    </li>
                    <c:if test="${status.last}">
                        <div class="more">
                            <a onclick="moreFacet('dataType');"><i class="icon-arrow-down"></i>more</a>
                        </div>
                    </c:if>
                </c:when>
                <c:otherwise>
                    <li class="facet-value tab-move dataType" value="${dataType.dataTypeId }">
                        <a class="dataType">${dataType.dataTypeName}</a><span
                            class="badge badge-search frequency">${dataType.dataTypeCnt }</span>
                    </li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <c:if test="${dataTypeFacet == null || dataTypeFacet.size() == 0}">
            <li><a>(none)</a></li>
        </c:if>
    </ul>
</div>