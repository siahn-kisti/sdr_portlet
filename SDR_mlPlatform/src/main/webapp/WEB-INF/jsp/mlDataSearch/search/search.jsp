
<aui:form method="post" name="fm">


    <div class="search-form">

        <div class="control-group search-inputbox">

            <aui:select label="" name="searchSelect">
                <aui:option selected="selected" value="title">Title</aui:option>
                <aui:option selected="" value="id">ID</aui:option>
                <aui:option selected="" value="description">Description</aui:option>
                <aui:option selected="" value="titleDescription">Title+Description</aui:option>
                <%--<aui:option selected="" value="all">All</aui:option>--%>
            </aui:select>
            <div class="input-append">
                <aui:input inlineField="${ true }" label="" name="keywords" title="search-entries"
                           type="text"
                           placeholder="Please enter your search term"/>
            </div>
            <input type="text" style="display: none;"/>
            <aui:button cssClass="btn-success" type="button" value="search" id="searchBtn"/>
        </div>

    </div>

    <aui:input name="facetKeywords" type="hidden"></aui:input>
</aui:form>

<script>
    AUI().ready('aui-io-request', function (A) {

        $('#searchBtn').click(function () {

            fn<portlet:namespace/>.dataSearchAjax(A, null);
            // dataSearchAjax(null);
        });
    });
</script>