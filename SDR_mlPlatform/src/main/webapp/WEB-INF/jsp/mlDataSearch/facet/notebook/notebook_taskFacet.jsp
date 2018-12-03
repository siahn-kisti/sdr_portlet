<div class="search-facet">
    <ul class="nav nav-pills nav-stacked scopes">
        <li class="facet-value default"><a data-value="0" class="performance">Task<span
                class="default-badge">reset</span></a></li>

        <c:forEach var="facetItem" items="${taskFacetList}">
            <li class="facet-value tab-move task" value="${facetItem.value}">
                <a class="task">${facetItem.name}</a>
            </li>
        </c:forEach>

    </ul>
</div>
