<%@include file="../../../init.jsp" %>

<%
    String portletResource = ParamUtil.getString(renderRequest, "portletResource");

    PortletPreferences preferences = CommonUtil.getPreference(renderRequest, portletResource);

    String leftTabUse = preferences.getValue(VParam.SETTINGS_LEFTTAB_USE, "true");
    String titleUse = preferences.getValue(VParam.SETTINGS_TITLE_USE, "true");
    String title = preferences.getValue(VParam.SETTINGS_TITLE, "3D Visualization Chart");
    String advancedSearchUse = preferences.getValue(VParam.SETTINGS_ADVANCEDSEARCH_USE, "true");
    String dataTypeUse = preferences.getValue(VParam.SETTINGS_DATATYPE_USE, "true");
    String dataType = preferences.getValue(VParam.SETTINGS_DATATYPE, "");
    String conditionUse = preferences.getValue(VParam.SETTINGS_CONDITION_USE, "true");
    String condition = preferences.getValue(VParam.SETTINGS_CONDITION, "");
    String category = preferences.getValue(VParam.SETTINGS_CATEGORY, "");
    String zAxisUse = preferences.getValue(VParam.SETTINGS_ZAXIS_USE, "true");
    String maxLengthUse = preferences.getValue(VParam.SETTINGS_MAXLENGTH_USE, "true");
    String maxLengthDefault = preferences.getValue(VParam.SETTINGS_MAXLENGTH_DEFAULT, "1000");

    Object typeListProperty = request.getAttribute("typeList");
    Object showHideProperty = "[{\"key\":\"Show\", \"value\":\"true\"},{\"key\":\"Hide\", \"value\":\"false\"}]";
    Object trueFalseProperty = "[{\"key\":\"True\", \"value\":\"true\"},{\"key\":\"False\", \"value\":\"false\"}]";
%>

<liferay-portlet:actionURL portletConfiguration="true" var="actionURL"/>

<aui:form action="<%=actionURL%>" method="post" name="fm">
    <aui:input name="<%=VConstants.CMD%>" type="hidden" value="<%=VConstants.UPDATE_CHART_CONFIG%>"/>
    <aui:input name="tab" type="hidden" value="<%=VConstants.TAB_CHARTS%>"/>
    <aui:input name="<%=VParam.SETTINGS_CATEGORY%>" type="hidden" value="<%=category%>"/>

    <aui:fieldset label="lefttab-setting">
        <%
            request.setAttribute("chart-name", VParam.SETTINGS_LEFTTAB_USE);
            request.setAttribute("chart-value", leftTabUse);
            request.setAttribute("chart-property", showHideProperty);
        %>
        <jsp:include page="settings_field.jsp"></jsp:include>
    </aui:fieldset>

    <aui:fieldset label="title-setting">
        <%
            request.setAttribute("chart-name", VParam.SETTINGS_TITLE_USE);
            request.setAttribute("chart-value", titleUse);
            request.setAttribute("chart-property", showHideProperty);
        %>
        <jsp:include page="settings_field.jsp"></jsp:include>
        <%
            request.setAttribute("chart-name", VParam.SETTINGS_TITLE);
            request.setAttribute("chart-value", title);
        %>
        <jsp:include page="settings_field.jsp"></jsp:include>

    </aui:fieldset>

    <aui:fieldset label="advancedsearch-setting">
        <%
            request.setAttribute("chart-name", VParam.SETTINGS_ADVANCEDSEARCH_USE);
            request.setAttribute("chart-value", advancedSearchUse);
            request.setAttribute("chart-property", showHideProperty);
        %>
        <jsp:include page="settings_field.jsp"></jsp:include>
    </aui:fieldset>

    <aui:fieldset label="datatype-setting">

        <%
            request.setAttribute("chart-name", VParam.SETTINGS_DATATYPE_USE);
            request.setAttribute("chart-value", dataTypeUse);
            request.setAttribute("chart-property", showHideProperty);
        %>
        <jsp:include page="settings_field.jsp"></jsp:include>

        <aui:layout cssClass="chart-field-wrapper">

            <aui:column columnWidth="15" first="true">
                <liferay-ui:message key="<%=VParam.SETTINGS_DATATYPE%>"></liferay-ui:message>
            </aui:column>

            <aui:column columnWidth="50">
                <div class="row">
                    <div class="col-xs-5">
                        <select name="from[]" id="<portlet:namespace />undo_redo" class="form-control" size="10" multiple="multiple">
                            <c:forEach items="<%=typeListProperty%>" var="item" varStatus="status">
                                <c:if test="${item ne null}">
                                    <option value="${item.value}">${item.key}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="col-xs-2 button-area">
                        <button type="button" id="<portlet:namespace />undo_redo_undo" class="btn btn-primary btn-block">undo
                        </button>
                        <button type="button" id="<portlet:namespace />undo_redo_rightAll" class="btn btn-default btn-block"><i class="fa  fa-angle-double-right"></i></button>
                        <button type="button" id="<portlet:namespace />undo_redo_rightSelected" class="btn btn-default btn-block"><i class="fa fa-angle-right"></i></button>
                        <button type="button" id="<portlet:namespace />undo_redo_leftSelected" class="btn btn-default btn-block"><i class="fa fa-angle-left"></i></button>
                        <button type="button" id="<portlet:namespace />undo_redo_leftAll" class="btn btn-default btn-block"><i class="fa  fa-angle-double-left"></i></button>
                        <button type="button" id="<portlet:namespace />undo_redo_redo" class="btn btn-warning btn-block">redo
                        </button>
                    </div>

                    <div class="col-xs-5">
                        <aui:select name="to[]" id="undo_redo_to" label="" size="10" multiple="multiple">
                            <c:forEach items="<%=dataType%>" var="item" varStatus="status">
                                <aui:option value="${fn:split(item,'|')[1]}" label="${fn:split(item,'|')[0]}"/>
                            </c:forEach>
                        </aui:select>
                        <aui:input type="hidden" name="<%=VParam.SETTINGS_DATATYPE%>" value="<%=dataType%>"></aui:input>
                    </div>
                </div>
            </aui:column>
            <aui:column columnWidth="35" last="true">
                <liferay-ui:message key='desc-setting-datatype'></liferay-ui:message>
            </aui:column>

        </aui:layout>

    </aui:fieldset>


    <aui:fieldset label="condition-setting">
        <%
            request.setAttribute("chart-name", VParam.SETTINGS_CONDITION_USE);
            request.setAttribute("chart-value", conditionUse);
            request.setAttribute("chart-property", trueFalseProperty);
        %>
        <jsp:include page="settings_field.jsp"></jsp:include>
        <%
            request.setAttribute("chart-name", VParam.SETTINGS_CONDITION);
            request.setAttribute("chart-value", condition);
        %>
        <jsp:include page="settings_field.jsp"></jsp:include>

    </aui:fieldset>

    <aui:fieldset label="category-setting">

        <aui:column columnWidth="15" first="true">
            <liferay-ui:message key="<%=VParam.SETTINGS_CATEGORY%>"></liferay-ui:message>
        </aui:column>

        <aui:column columnWidth="50">
            <div id="jsGrid"></div>
        </aui:column>

        <aui:column columnWidth="35" last="true">
            <liferay-ui:message key="desc-settings-category"></liferay-ui:message>
        </aui:column>

    </aui:fieldset>

    <aui:fieldset label="zaxis-setting">
        <%
            request.setAttribute("chart-name", VParam.SETTINGS_ZAXIS_USE);
            request.setAttribute("chart-value", zAxisUse);
            request.setAttribute("chart-property", showHideProperty);
        %>
        <jsp:include page="settings_field.jsp"></jsp:include>
    </aui:fieldset>

    <aui:fieldset label="maxlength-setting">
        <%
            request.setAttribute("chart-name", VParam.SETTINGS_MAXLENGTH_USE);
            request.setAttribute("chart-value", maxLengthUse);
            request.setAttribute("chart-property", showHideProperty);
        %>
        <jsp:include page="settings_field.jsp"></jsp:include>
        <%
            request.setAttribute("chart-name", VParam.SETTINGS_MAXLENGTH_DEFAULT);
            request.setAttribute("chart-value", maxLengthDefault);
        %>
        <jsp:include page="settings_field.jsp"></jsp:include>

    </aui:fieldset>

    <aui:button-row>
        <aui:button name="saveButton" cssClass="btn-primary" type="button" value="save"/>
    </aui:button-row>

</aui:form>

<script type="text/javascript">
    $(function () {
        var $grid = $('#jsGrid');
        var $category = $('#<portlet:namespace/><%=VParam.SETTINGS_CATEGORY%>');
        var gridData = eval($category.val());

        $grid.jsGrid({
            width: '100%',
            height: '300px',

            inserting: true,
            editing: true,
            sorting: false,
            paging: true,
            autoload: true,

            controller: {
                loadData: function () {
                    var d = $.Deferred();
                    return d.resolve($.map(gridData, function (item, itemIndex) {
                        return $.extend(item, {"Index": itemIndex + 1});
                    }));
                }
            },

            fields: [
                {name: "index", type: "number", title: "Index", width: 30, align: "center"},
                {name: 'label', type: 'text', title: "Label", width: 100, validate: 'required'},
                {name: 'condition', type: 'text', title: "Condition", width: 100, validate: 'required'},
                {name: 'used', type: 'checkbox', title: 'Used', width: 30},
                {type: 'control'}
            ],
            onRefreshed: function () {
                var $gridData = $grid.find('.jsgrid-grid-body tbody');
                $gridData.sortable({
                    helper: function(e, tr)
                    {
                        var $originals = tr.children();
                        var $helper = tr.clone();
                        $helper.children().each(function(index)
                        {
                            // Set helper cell sizes to match the original sizes
                            $(this).width($originals.eq(index).width());
                        });
                        return $helper;
                    },
                    update: function (e, ui) {
                        var datas = getGridData($grid);
                        $.each(datas, function (i, data) {
                            data.Index = i + 1;
                        });
                        $category.val(JSON.stringify(datas));

                        var $tr = $gridData.children();

                        $.map($tr, function (e, i) {
                            var idx = i + 1;
                            $(e).children().eq(0).text(idx);
                        });
                    }
                }).disableSelection();
                ;
            }
        });

        $('#<portlet:namespace />undo_redo').multiselect();

        $('#<portlet:namespace />saveButton').click(function () {
            var selectType = $('#<portlet:namespace />undo_redo_to');
            var optionsType = $('#<portlet:namespace />undo_redo_to option');
            var settingsType = $('#<portlet:namespace /><%=VParam.SETTINGS_DATATYPE%>');
            var size = optionsType.length;
            if (size == 0) {
                selectType.append($('<option>'));
                settingsType.val('');
            }
            var result = '';
            optionsType.each(function (i, e) {
                if (result != '') {
                    result = result + ','
                }
                result = result + $(e).text() + '|' + $(e).val();
            });
            settingsType.val(result);

            var items = getGridData($grid);

            $category.val(JSON.stringify(items));

            $('#<portlet:namespace />fm').submit();
        });

        function getGridData($grid) {
            var $tr = $grid.find('.jsgrid-grid-body tbody tr');
            var items = $.map($tr, function (row) {
                return $(row).data("JSGridItem");
            });
            return items;
        }
    });
</script>

<style>
    .button-area {
        padding: 0px !important;
        margin-bottom: 10px;
    }

    .button-area .btn {
        margin: 0 auto;
        width: 90% !important;
        padding: 3px !important;
    }

    .jsgrid-header-cell {
        padding: .5em !important;
        text-align: center !important;
    }

    .jsgrid-cell {
        padding: .5em !important;
    }

</style>