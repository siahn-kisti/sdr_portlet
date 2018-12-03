<div class="search-facet">
    <ul class="nav nav-pills nav-stacked scopes">
        <li class="facet-value default"><a data-value="0" class="collection">Collection<span
                class="default-badge">reset</span></a></li>
        <c:forEach items="${collectionFacet}" var="collection" varStatus="status" end="14">
            <c:choose>
                <c:when test="${status.count > 5}">
                    <li class="facet-value tab-move collection" value="${collection.collectionId }"
                        style="display: none">
                        <a class="collection">${collection.collectionName}</a><span
                            class="badge badge-search frequency">${collection.collectionCnt }</span>
                    </li>
                    <c:if test="${status.last}">
                        <div class="more">
                            <a onclick="moreFacet('collection');"><i class="icon-arrow-down"></i>more</a>
                        </div>
                    </c:if>
                </c:when>
                <c:otherwise>
                    <li class="facet-value tab-move collection" value="${collection.collectionId }">
                        <a class="collection">${collection.collectionName}</a><span
                            class="badge badge-search frequency">${collection.collectionCnt }</span>
                    </li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <c:if test="${collectionFacet == null || collectionFacet.size() == 0}">
            <li><a>(none)</a></li>
        </c:if>
    </ul>
</div>