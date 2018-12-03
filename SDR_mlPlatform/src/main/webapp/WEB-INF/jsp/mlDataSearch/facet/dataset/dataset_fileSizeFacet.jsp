<div class="search-facet">
    <ul class="nav nav-pills nav-stacked scopes">
        <li class="facet-value default"><a data-value="0" class="fileSize">File Size<span
                class="default-badge">reset</span></a></li>

        <c:forEach var="facetItem" items="${fileSizeFacetList}">
            <li class="facet-value tab-move fileSize" value="${facetItem.value}">
                <a class="fileSize">${facetItem.name}</a>
            </li>
        </c:forEach>

    </ul>
</div>
