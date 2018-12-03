<div class="search-facet">
    <ul class="nav nav-pills nav-stacked scopes">
        <li class="facet-value default"><a data-value="0" class="contributor">Contributor<span class="default-badge">reset</span></a>
        </li>
        <c:forEach items="${contributorFacet}" var="contributor" varStatus="status" end="14">
            <c:choose>
                <%--<c:when test="${status.count > 5 && !status.last}">--%>
                <c:when test="${status.count > 5}">
                    <li class="facet-value tab-move contributor" value="${contributor.contributorId }"
                        style="display: none;">
                        <a class="contributor">${contributor.contributorName}</a><span
                            class="badge badge-search frequency">${contributor.contributorCnt }</span>
                    </li>
                    <c:if test="${status.last}">
                        <div class="more">
                            <a onclick="moreFacet('contributor');"><i class="icon-arrow-down"></i>more</a>
                        </div>
                    </c:if>
                </c:when>
                <c:otherwise>
                    <li class="facet-value tab-move contributor" value="${contributor.contributorId }">
                        <a class="contributor">${contributor.contributorName}</a>
                        <span class="badge badge-search frequency">${contributor.contributorCnt }</span>
                    </li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <c:if test="${contributorFacet == null || contributorFacet.size() == 0}">
            <li><a>(none)</a></li>
        </c:if>
    </ul>
</div>


