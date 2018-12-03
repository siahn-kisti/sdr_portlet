<div class="search-facet">
    <ul class="nav nav-pills nav-stacked scopes">
        <li class="facet-value default"><a data-value="0" class="language">Language<span
                class="default-badge">reset</span></a></li>

        <c:forEach var="facetItem" items="${languageFacetList}">
            <li class="facet-value tab-move language" value="${facetItem.value}">
                <a class="language">${facetItem.name}</a>
            </li>
        </c:forEach>

    </ul>
</div>
