<div class="search-facet">
    <ul class="nav nav-pills nav-stacked scopes">
        <li class="facet-value default"><a data-value="0" class="keyword">Keyword <span
            class="default-badge">reset</span></a>
        </li>
        <c:forEach items="${keywordFacet}" var="keyword" varStatus="status" end="14">
            <c:choose>
                <c:when test="${status.count > 5}">
                    <li class="facet-value tab-move keyword" value="${keyword.keywordId }"
                        style="display: none">
                        <a class="keyword">${keyword.keywordName}</a><span
                        class="badge badge-search frequency">${keyword.keywordCnt }</span>
                    </li>
                    <c:if test="${status.last}">
                        <div class="more">
                            <a onclick="moreFacet('keyword');"><i class="icon-arrow-down"></i>more</a>
                        </div>
                    </c:if>
                </c:when>
                <c:otherwise>
                    <li class="facet-value tab-move keyword" value="${keyword.keywordId }">
                        <a class="keyword">${keyword.keywordName}</a>
                        <span class="badge badge-search frequency">${keyword.keywordCnt }</span>
                    </li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <c:if test="${keywordFacet == null || keywordFacet.size() == 0}">
            <li><a>(none)</a></li>
        </c:if>
    </ul>
</div>
