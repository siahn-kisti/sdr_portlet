<div class="search-facet">
    <ul class="nav nav-pills nav-stacked scopes">
        <li class="facet-value default"><a data-value="0" class="analysis">Algorithm<span
                class="default-badge">reset</span></a></li>

        <c:forEach var="facetItem" items="${algorithmFacetList}">
            <li class="facet-value tab-move algorithm" value="${facetItem.value}">
                <a class="algorithm">${facetItem.name}</a>
            </li>
        </c:forEach>

    </ul>
</div>
