<div class="search-facet">
    <ul class="nav nav-pills nav-stacked scopes">
        <li class="facet-value default"><a data-value="0" class="community">Community<span
            class="default-badge">reset</span></a></li>
        <c:forEach items="${communityFacet}" var="community" varStatus="status" end="14">
            <c:choose>
                <c:when test="${status.count > 5}">
                    <li class="facet-value tab-move community" value="${community.communityId}" style="display: none">
                        <a class="community">${community.communityName}</a><span
                        class="badge badge-search frequency">${community.communityCnt }</span>
                    </li>
                    <c:if test="${status.last}">
                        <div class="more">
                            <a onclick="moreFacet('community');"><i class="icon-arrow-down"></i>more</a>
                        </div>
                    </c:if>
                </c:when>
                <c:otherwise>
                    <li class="facet-value tab-move community" value="${community.communityId}">
                        <a class="community">${community.communityName}</a>
                        <%--<span class="badge badge-search frequency">${community.communityCnt }</span>--%>
                    </li>
                </c:otherwise>
            </c:choose>
        </c:forEach>
        <c:if test="${communityFacet == null || communityFacet.size() == 0}">
            <li><a>(none)</a></li>
        </c:if>
    </ul>
</div>
