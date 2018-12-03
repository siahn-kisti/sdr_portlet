<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/dataSearch/init.jsp" %>

<div class="edison-sdr-portlet">

<c:if test="<%=SessionErrors.isEmpty(renderRequest)%>">

    <link rel="stylesheet" href="<c:url value='/js/jquery-ui/jquery-ui.css'/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value='/js/jquery/jquery.tagsinput.css'/>">
    <script src="<c:url value='/js/jquery/jquery-3.2.1.min.js'/>"></script>
    <script src="<c:url value='/js/jquery-ui/jquery-ui.js'/>"></script>
    <script src="<c:url value='/js/jquery/jquery.tagsinput.min.js'/>"></script>


    <h3>Advanced Search</h3>

    <portlet:resourceURL var="keyListURL" id="keyList"></portlet:resourceURL>
    <portlet:renderURL var="advancedSearchAjaxURL" windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
        <portlet:param name="action" value="advancedSearchAjax"/>
    </portlet:renderURL>

    <div id="advanced_search">

        <aui:form name="advancedSearchForm" method="post">

            <div class="advancedSearch-main">

                <div class="advancedSearch-left">

                    <!-- Left-Data Type -->
                    <div class="row-as">
                        <div class="border-row">
                            <label class="as-label">Data Type</label>
                            <aui:select label="" name="dataTypeSelect">
                                <aui:option>::: 선택 :::</aui:option>
                                <c:forEach var="result" items="${dataTypeList}" varStatus="status">
                                    <aui:option value="${result.dataTypeId}">${result.title}</aui:option>
                                </c:forEach>
                            </aui:select>
                            <div class="taggleUI">
                                <input id="dataTypeTag"/>
                            </div>

                            <aui:input name="dataTypes" type="hidden"/>
                        </div>
                    </div>

                    <!--// Left-Data Type -->

                    <!-- Left-Query -->
                    <div class="row-as">
                        <div class="border-row">
                            <label class="as-label">Query</label>
                            <aui:select label="" name="searchKeySelect" disabled="true">
                                <option>Select DataType</option>
                                <c:if test="${!empty searchKeyList}">
                                    <c:forEach var="result" items="${searchKeyList}" varStatus="status">
                                        <c:if test="${!empty result}">
                                            <aui:option value="${result}">${result}</aui:option>
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </aui:select>
                            <aui:input label="" name="query" cssClass="advancedTextarea" type="textarea" value=""
                                       resizable="false"/>
                        </div>
                    </div>
                    <!--// Left-Query -->

                    <!-- Left-Result of -->
                    <div class="row-as">
                        <div class="border-row">
                            <label class="as-label">Result of</label>
                            <aui:input name="resultOf" type="hidden"></aui:input>
                            <aui:select label="" name="resultKeySelect" disabled="true">
                                <option>Select DataType</option>
                                <c:if test="${!empty resultKeyList}">
                                    <c:forEach var="result" items="${resultKeyList}" varStatus="status">
                                        <aui:option value="${result}">${result}</aui:option>
                                    </c:forEach>
                                </c:if>
                            </aui:select>
                            <div class="taggleUI">
                                <input id="resultOfTag"/>
                            </div>
                        </div>
                    </div>
                    <!--// Left-Result of -->

                    <aui:button cssClass="btn-success btn-right" type="button" value="search" id="searchBtn"
                                disabled="true"/>
                </div>

                <div class="advancedSearch-right">
                    <div class="row-as">
                        <label class="as-label">Example</label>
                        <pre>
1. Equal search
  1-1. elements: Li
  → To search for datasets that contain elements 'Li'
  1-2. nsites : 3
  → To search for datasets that contain nsites '3'
2. AND operator
  2-1. elements: Li AND elements: O
  → To search for datasets that must contain elements 'Li' and 'O'
  2-2. elements: Li AND nsites : 1
  → To search for datasets that must contain elements 'Li'
    and nsites '1'
3. OR operator
  3-1. elements: Li OR elements: O
  → To search for datasets that contain elements 'Li' or 'O'
  3-2. elements: Li OR nsites: 2
  → To search for datasets that contain elements 'Li'
    or nsites '2'
4. NOT operator
  4-1. elements: Li NOT elements: O
  → To search for datasets that contain elements 'Li'
    but not 'O'
5. Range search
  5-1. nsites: [1 TO 5]
  → To search for datasets that nsites are between 1 to 5
    (For Integer)
  5-2. density: [1.0 TO 5.0]
  → To search for datasets that density are between 1.0 to 5.0
    (For Float)
6. Advanced
  6-1. elements: Li AND nsites: [1 TO 5]
  → To search for datasets that must contain elements 'Li' and
    nsites 1 to 5 (For Integer)
  6-2. elements: Li AND density: [1.0 TO 5.0]
  → To search for datasets that must contain elements 'Li' and
    density 1.0 to 5.0 (For Float)
  6-3. (elements: Li OR elements: O) AND elements: Si
  → To search for datasets that must contain elements 'Si' and
    either 'Li' or 'O'
					</pre>
                    </div>
                </div>
            </div>
            <aui:input type="hidden" name="delta" value="${delta}"/>
        </aui:form>
    </div>
    <div class="advancedSearchValue"></div>

    <script type="text/javascript">

        var autoCompSource = [''];

        $(document).ready(function () {

            var dataTypes = new Array();
            var resultKeys = new Array();

//--------------------------------------------------
// dataTypeTag
//--------------------------------------------------
            var tags = $('#dataTypeTag').tagsInput({
                width: 'auto',
                height: 'auto',
                defaultText: 'Please enter the Data Type',
                'onAddTag': function (tag) {
                    dataTypes.push($("#<portlet:namespace/>dataTypeSelect option:contains('" + tag + "')").val());
                    $("#<portlet:namespace/>dataTypes").attr("value", dataTypes);
                    tagSelect();
                },
                'onRemoveTag': function (tag) {
                    dataTypes.splice(dataTypes.indexOf($("#<portlet:namespace/>dataTypeSelect option:contains('" + tag + "')").val()), 1);
                    $("#<portlet:namespace/>dataTypes").attr("value", dataTypes);
                    if (dataTypes == "") {
                        $("#searchBtn").attr("disabled", "true");
                        $('#<portlet:namespace/>searchKeySelect').attr("disabled", "true");
                        $('#<portlet:namespace/>resultKeySelect').attr("disabled", "true");
                    }
                }
            });

//--------------------------------------------------
// resultOfTag
//--------------------------------------------------

            var tags = $('#resultOfTag').tagsInput({
                width: 'auto',
                height: 'auto',
                defaultText: 'Please Select Return',
                'onAddTag': function (tag) {
                    resultKeys.push(tag.trim());
                    $("#<portlet:namespace/>resultOf").attr("value", resultKeys);
                },
                'onRemoveTag': function (tag) {
                    resultKeys.splice(resultKeys.indexOf(tag), 1);
                    $("#<portlet:namespace/>resultOf").attr("value", resultKeys);
                }
            });

            function tagSelect() {
                $.ajax({
                    type: "post",
                    url: "${keyListURL}",
                    dataType: "json",
                    data: {
                        "<portlet:namespace/>dataTypes": dataTypes
                    },
                    success: function (data) {
                        $("select").attr("disabled", false);
                        $("#searchBtn").attr("disabled", "false").removeClass('disabled');
                        $("#<portlet:namespace/>searchKeySelect option").remove();
                        $("#<portlet:namespace/>resultKeySelect option").remove();
                        $("#<portlet:namespace/>searchKeySelect").append("<option>::: 선택 :::</option>");
                        $("#<portlet:namespace/>resultKeySelect").append("<option>::: 선택 :::</option>");

                        autoCompSource = data.searchKeyList;
                        for (var i = 0; i < data.searchKeyList.length; i++) {
                            $("#<portlet:namespace/>searchKeySelect").append("<option value='" + data.searchKeyList[i] + "'>" + data.searchKeyList[i] + "</option>");
                        }

                        for (var i = 0; i < data.resultKeyList.length; i++) {
                            $("#<portlet:namespace/>resultKeySelect").append("<option value='" + data.resultKeyList[i] + "'>" + data.resultKeyList[i] + "</option>");
                        }

                        $("button").attr("disabled", false);
                    },
                    error: function (request, status, error) {
                        console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
                    }
                });
            };

            $("#<portlet:namespace/>dataTypeSelect").change(function (event) {
                var tag = $("#<portlet:namespace/>dataTypeSelect option:selected").text();

                if (!$('#dataTypeTag').tagExist(tag) && tag.indexOf('선택') == -1) {
                    $("#dataTypeTag").addTag(tag);
                }

                $("#<portlet:namespace/>dataTypeSelect").find('option:first').attr('selected', 'true');
            });

            $("#<portlet:namespace/>searchKeySelect").change(function () {
                var tag = $("#<portlet:namespace/>query").val() + " " + $("#<portlet:namespace/>searchKeySelect option:selected").val() + ": ";
                if ( tag.indexOf('선택') == -1) {
                    $("#<portlet:namespace/>query").val(tag);
                }

                $("#<portlet:namespace/>searchKeySelect").find('option:first').attr('selected', 'true');
            });

            $("#<portlet:namespace/>resultKeySelect").change(function () {
                var tag = $("#<portlet:namespace/>resultKeySelect option:selected").text();

                if (!$('#resultOfTag').tagExist(tag) && tag.indexOf('선택') == -1) {
                    $("#resultOfTag").addTag(tag);
                }

                $("#<portlet:namespace/>resultKeySelect").find('option:first').attr('selected', 'true');
            });

            $('#searchBtn').click(function () {
                advancedSearchAjax(null);
            });

            $('.advancedSearchValue').on('click', '.taglib-page-iterator a', function (event) {
                event.preventDefault();
                var uri = event.currentTarget.href;
                if (uri != 'javascript:;') {
                    uri = uri.replace(/p_p_state=normal/i, 'p_p_state=exclusive');
                    uri = uri.replace('p_p_mode=view', 'p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1&_advancedsearch_WAR_SDR_baseportlet_action=advancedSearchAjax');

                    advancedSearchAjax(uri);
                }
            });

            $('.advancedSearchValue').on('mousedown', '.lfr-pagination-config a', function (event) {
                event.preventDefault();
                if ($('.overlay-hidden')) {
                    $('.overlay').removeClass('overlay-hidden');
                }
            });
            $('body').on('mousedown', '.dropdown-menu.lfr-menu-list.direction-down a', function (event) {
                var uri = event.currentTarget.href;
                if (uri != 'javascript:;') {
                    uri = uri.replace(/p_p_state=normal/i, 'p_p_state=exclusive');
                    uri = uri.replace('p_p_mode=view', 'p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1&_advancedsearch_WAR_SDR_baseportlet_action=advancedSearchAjax');

                    advancedSearchAjax(uri);
                }
                $('.overlay').addClass('overlay-hidden');
                event.preventDefault();
            });

            function advancedSearchAjax(uri) {
                if (uri == null) {
                    uri = '${advancedSearchAjaxURL.toString()}';
                }

                var form = $('#<portlet:namespace/>advancedSearchForm').serialize();

                $.ajax({
                    type: "POST",
                    url: uri,
                    chach: false,
                    data: form,
                    dataType: "html",
                    success: function (data) {
                        $(".advancedSearchValue").html(data);
                    },
                    error: function (e) {
                        console.log(e);
                    }
                });
            };

            function split(val) {
                return val.split(" ");
            }

            function extractLast(term) {
                var pop = split(term).pop();
                var arr = split(term);

                if (pop.length < 2) {
                    pop = split(term)[arr.length - 2];
                }

                return pop;
            }

            <%--$("#<portlet:namespace/>query").autocomplete({--%>
            <%--autoFocus: true,--%>
            <%--minLength: 2,--%>
            <%--position: {my: "left bottom", at: "left center", collision: "flip"},--%>
            <%--source:--%>
            <%--function (request, response) {--%>
            <%--response($.ui.autocomplete.filter(--%>
            <%--autoCompSource, extractLast(request.term)));--%>
            <%--},--%>
            <%--select: function (event, ui) {--%>
            <%--var terms = split(this.value);--%>
            <%--terms.pop();--%>
            <%--terms.push(ui.item.value + ": ");--%>
            <%--this.value = terms.join(" ");--%>
            <%--return false;--%>
            <%--}--%>
            <%--})--%>

        });
    </script>

</c:if>
    
</div>