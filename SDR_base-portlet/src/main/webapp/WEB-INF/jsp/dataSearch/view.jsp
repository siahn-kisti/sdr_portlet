<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@include file="/WEB-INF/jsp/dataSearch/init.jsp" %>

<link rel="stylesheet" type="text/css" href="<c:url value='/js/jquery/jquery.tagsinput.css'/>">
<script src="<c:url value='/js/jquery/jquery-3.2.1.min.js'/>"></script>
<script src="<c:url value='/js/jquery-ui/jquery-ui.js'/>"></script>
<script src="<c:url value='/js/jquery/jquery.tagsinput.min.js'/>"></script>

<div class="edison-sdr-portlet">

<c:if test="<%=SessionErrors.isEmpty(renderRequest)%>">
    <style>
        /* main.css */

        #facetTag_addTag {
            display: none;
        }

        #facetTag {
            visibility: hidden;
            display: none;
            padding: 0;
            border: 0;
            height: 0;
            font-size: 0;
        }

        .aui #search_body .filterArea div.tagsinput {
            margin-bottom: 0;
        }
    </style>

    <h3><liferay-ui:message key="datasearch.datasearch"/></h3>

    <portlet:renderURL var="dataSearchTabURL">
        <portlet:param name="tabs" value="${tabs}"/>
    </portlet:renderURL>

    <portlet:renderURL var="dataSearchAjaxURL" windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
        <portlet:param name="action" value="dataSearchAjax"/>
        <portlet:param name="tabs" value="${tabs}"/>
        <portlet:param name="delta" value="${delta}"/>
    </portlet:renderURL>

    <portlet:renderURL var="dataSearchURL" windowState="<%=LiferayWindowState.EXCLUSIVE.toString()%>">
        <portlet:param name="action" value="dataSearch"/>
        <portlet:param name="tabs" value="${tabs}"/>
    </portlet:renderURL>


    <div id="search_body" style="clear: both; padding: 37px 0 50px 0; overflow: hidden; min-height: 630px;">

        <aui:form method="post" name="fm">

            <!-- 상단 검색바 영역 -->
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
            <!--// 상단 검색바 영역 -->
            <aui:input name="facetKeywords" type="hidden"></aui:input>
        </aui:form>

        <aui:row>

            <!-- 좌측 탭 메뉴 -->
            <aui:col id="facetNavigation" cssClass="searchTabs">
                <%@include file="/WEB-INF/jsp/dataSearch/facet.jsp" %>
            </aui:col>

            <!-- //좌측 탭 메뉴 -->

            <!-- 우측 컨텐츠 영역 -->
            <aui:col cssClass="searchContentsList">
                <liferay-ui:success key="success" message="Data saved successfully!"/>
                <liferay-ui:error key="error" message="Sorry, an error prevented saving your data."/>
                <liferay-ui:success key="delete" message="Data deleted successfully!"/>



                <!--liferay-ui:tabs names="Collection,Dataset" param="tabs" refresh="${true }" url="${dataSearchTabURL}"-->


                <liferay-ui:tabs names="Collection" param="tabs" refresh="${true }"
                                 url="${dataSearchTabURL}">
                    <div class="searchTabContents">

                        <aui:select label="" name="sort" cssClass="searchAlign">
                            <aui:option value="lastest">Lastest Date</aui:option>
                            <aui:option value="oldest">Oldest Date</aui:option>
                            <aui:option value="asc">Title Asc</aui:option>
                            <aui:option value="desc">Title Desc</aui:option>
                        </aui:select>

                        <div class="searchValue"></div>
                        <!-- 필터 선택 -->
                        <div class="filterArea">
                            <label>filter</label>
                            <input id="facetTag"/>
                        </div>
                        <!--// 필터 선택 -->

                        <div class="searchList">
                            <liferay-ui:section>
                                <c:if test="${tabs eq 'Collection'}">
                                    <%@include file="/WEB-INF/jsp/dataSearch/collection/list_collection.jsp" %>
                                </c:if>
                            </liferay-ui:section>
                            <liferay-ui:section>
                                <c:if test="${tabs eq 'Dataset'}">
                                    <%@include file="/WEB-INF/jsp/dataSearch/dataset/list_dataset.jsp" %>
                                </c:if>
                            </liferay-ui:section>
                        </div>
                    </div>
                </liferay-ui:tabs>
            </aui:col>
            <!-- //우측 컨텐츠 영역 -->
        </aui:row>

    </div>

    <script type="text/javascript">
        AUI().ready('aui-io-request', function (A) {

            var facetKeywords = new Array();

            var changeFlag = false;

            if (${! empty tagCloudKeyword}) {

                $('.facet-value.keyword').each(function () {
                    $('.facet-value.keyword').addClass('active');
                });

                facetKeywords.push('keyword_' + $('.facet-value.keyword.active').val());
                $('#<portlet:namespace/>facetKeywords').attr('value', facetKeywords);
                $('#facetTag').addTag($('.facet-value.keyword.active a').text());

            }

            //--------------------------------------------------
            // tag
            //--------------------------------------------------
            var tags = $('#facetTag').tagsInput({
                width: 'auto',
                height: 'auto',
                defaultText: 'add a rule',
                'onRemoveTag': function (tag) {

                    $('#<portlet:namespace/>facetNavigation').find("li.facet-value.active > a:contains('" + tag + "')").parent().parent().children('li').eq(0).addClass('active');
                    $('#<portlet:namespace/>facetNavigation').find("li.facet-value.active > a:contains('" + tag + "')").parent().removeClass('active');

                    if (changeFlag == false) {

                        var fg = $('#<portlet:namespace/>facetNavigation').find("li.facet-value > a:contains('" + tag + "')").attr('class');

                        for (var i in facetKeywords) {
                            if (facetKeywords[i].indexOf(fg + '_') > -1) {
                                facetKeywords.splice(facetKeywords.indexOf(facetKeywords[i]), 1);
                            }
                        }

                        $("#<portlet:namespace/>facetKeywords").attr("value", facetKeywords);

                        dataSearch();
                        dataSearchAjax(null);
                    }
                }
            });

            var container = A.one('#<portlet:namespace/>facetNavigation');

            if (container) {
                container.delegate('click',
                    function (event) {

                        changeFlag = true;

                        var term = event.currentTarget;
                        var facetGroup = term.attr('class');
                        var facetValue = term.ancestor('.facet-value');
                        if (facetValue) {
                            var currentTerm = facetValue.hasClass('active');

                            if (!currentTerm) {
                                var currentFacet = "";
                                var removeKey = $('.facet-value.' + facetGroup + '.active').val();
                                if (typeof removeKey != 'undefined') {
                                    for (var i in facetKeywords) {
                                        if (facetKeywords[i].indexOf(facetGroup + '_') > -1) {
                                            currentFacet = facetKeywords[i];
                                            facetKeywords.splice(facetKeywords.indexOf(facetKeywords[i]), 1);
                                        }
                                    }
                                }
                                $('#facetTag').removeTag($('.facet-value.' + facetGroup + '.active a').text());

                                facetValue.radioClass('active');
                                var pushKey = $('.facet-value.' + facetGroup + '.active').val();

                                $('#facetTag').addTag($('.facet-value.' + facetGroup + '.active a').text());

                                if (typeof pushKey != 'undefined') {
                                    facetKeywords.push(facetGroup + '_' + $('.facet-value.' + facetGroup + '.active').val());
                                }
                                $('#<portlet:namespace/>facetKeywords').attr('value', facetKeywords);
                            }
                            event.preventDefault();
                        }
                        dataSearch();
                        dataSearchAjax(null);
                        changeFlag = false;
                    },
                    '.facet-value a'
                );
            }

            $('#searchBtn').click(function () {
                dataSearch();
                dataSearchAjax(null);
            });

            function dataSearch() {

                A.io.request('${dataSearchURL.toString()}', {
                    method: 'post',
                    form: {
                        id: '<portlet:namespace/>fm'
                    },
                    on: {
                        success: function () {

                            $("#<portlet:namespace/>facetNavigation").html(this.get('responseData'));
                            if (facetKeywords != null) {
                                for (var i in facetKeywords) {
                                    var key = facetKeywords[i].split('_');
                                    $('#<portlet:namespace/>facetNavigation').find('li.facet-value.default.active > a.' + key[0]).parent().removeClass('active');
                                    $('#<portlet:namespace/>facetNavigation').find('li.facet-value[value=' + key[key.length - 1] + ']').addClass('active');
                                }
                            }

                        },
                        failure: function (data) {
                            console.log(data);
                        }
                    }
                });
            };

            function dataSearchAjax(uri) {
                if (uri == null) {
                    uri = '${dataSearchAjaxURL.toString()}';
                }

                A.io.request(uri, {
                    method: 'post',
                    data: {
                        <portlet:namespace/>sort: $("#<portlet:namespace/>sort :selected").val()
                    },
                    form: {
                        id: '<portlet:namespace/>fm'
                    },
                    on: {
                        success: function () {
                            $(".searchList").html(this.get('responseData'));
                        },
                        failure: function (data) {
                            console.log(data);
                        }
                    }
                });
            };

            A.one('.searchList').delegate('click', function (event) {
                event.preventDefault();
                var uri = event.currentTarget.get('href');
                if (uri != 'javascript:;') {
                    uri = uri.replace(/p_p_state=normal/i, 'p_p_state=exclusive');
                    uri = uri.replace('p_p_mode=view', 'p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1&_datasearch_WAR_SDR_baseportlet_action=dataSearchAjax');

                    dataSearchAjax(uri);
                }

            }, '.taglib-page-iterator a');

            A.one('.searchList').delegate('mousedown', function (event) {
                if (A.one('.overlay-hidden')) {
                    A.one('.overlay').removeClass('overlay-hidden');
                }
                event.preventDefault();
            }, '.lfr-pagination-config a');

            A.one('body').delegate('mousedown', function (event) {
                var uri = event.currentTarget.get('href');
                if (uri != 'javascript:;') {
                    uri = uri.replace(/p_p_state=normal/i, 'p_p_state=exclusive');
                    uri = uri.replace('p_p_mode=view', 'p_p_mode=view&p_p_col_id=column-1&p_p_col_count=1&_datasearch_WAR_SDR_baseportlet_action=dataSearchAjax');

                    dataSearchAjax(uri);
                }

                A.one('.overlay').addClass('overlay-hidden');
                event.preventDefault();
            }, '.dropdown-menu.lfr-menu-list.direction-down a');

            $("#<portlet:namespace/>sort").change(function () {
                dataSearchAjax(null);
            });

            $(document).keyup(function (event) {
                if ($("#<portlet:namespace/>keywords").is(":focus") && (event.keyCode == 13)) {
                    event.preventDefault();
                    dataSearch();
                    dataSearchAjax(null);
                }
            });

            $('#<portlet:namespace/>keywords').on('textchange', function (event) {
                console.log(event);
            });

            function onlynum() {
                if ((event.keyCode < 48) || (event.keyCode > 57)) {
                    event.returnValue = false;
                }
            }

        });

    </script>
</c:if>
    
</div>