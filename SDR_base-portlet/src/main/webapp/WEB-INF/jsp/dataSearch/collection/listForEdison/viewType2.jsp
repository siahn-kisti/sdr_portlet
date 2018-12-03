<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@include file="/WEB-INF/jsp/dataSearch/init.jsp" %>

<liferay-portlet:resourceURL id="getImage" var="getImageURL" portletName="sdrcommon_WAR_SDR_baseportlet"></liferay-portlet:resourceURL>
<c:set var="getImageURL_path" value="${getImageURL}&_sdrcommon_WAR_SDR_baseportlet_path=" />

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/slick/slick.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/slick/slick-theme.css">

<style>

._collectionlistforedison_WAR_SDR_baseportlet_resultwrap{padding-top:40px; padding-bottom:20px; position:relative; clear:both; text-align:right;}
._collectionlistforedison_WAR_SDR_baseportlet_resultlist{ position:relative; font-family:'nanumgothic', sans-serif; padding-left:5px; padding-right:5px;}
._collectionlistforedison_WAR_SDR_baseportlet_resultlist ul{ padding:0; background-color:#fff; margin:0; border:solid 1px #ddd; border-radius:0 0 7px 7px; height: 270px}
._collectionlistforedison_WAR_SDR_baseportlet_resultlist ul li{ list-style:none; font-family:'nanumgothic', sans-serif; font-size:13px; color:#777; padding:3px 15px; text-align:left;}
._collectionlistforedison_WAR_SDR_baseportlet_resultlist ul li.tit{ font-size:16px; color:#345e9e !important; font-weight:600; padding-top:20px; text-align:left;}
._collectionlistforedison_WAR_SDR_baseportlet_resultlist ul li:first-child{ padding:0;}
._collectionlistforedison_WAR_SDR_baseportlet_resultlist ul li:first-child img{ width:100%; max-height:147px;}
._collectionlistforedison_WAR_SDR_baseportlet_resultlist ul li a{color:#345e9e!important;}
._collectionlistforedison_WAR_SDR_baseportlet_resultlist ul li a:hover{text-decoration:underline!important;}
._collectionlistforedison_WAR_SDR_baseportlet_resultlist ul li:last-child{padding-bottom:15px; text-align:left;}

._collectionlistforedison_WAR_SDR_baseportlet_row{width: 100%; }
._collectionlistforedison_WAR_SDR_baseportlet_communityImage{width: 289px; height: 147px; height: -webkit-fill-available;}
._collectionlistforedison_WAR_SDR_baseportlet_btn_line02{
	border-radius:20px !important;
	cursor:pointer !important;
	color:#162f40; 
	border:solid 1px #5bc0de; 
	background-color:#fff;
	font-size: 12px !important;
	vertical-align: middle !important;
	line-height: 13px !important;
	display: inline-block !important;
	padding:1px 11px !important;
	font-weight:700; text-align:center;
}
	
._collectionlistforedison_WAR_SDR_baseportlet_btn_line02 a{color:#162f40 !important;}
._collectionlistforedison_WAR_SDR_baseportlet_btn_line02 a:hover{color:#162f40; text-decoration:none !important;}
._collectionlistforedison_WAR_SDR_baseportlet_btn_line02:hover{ background-color:#5bc0de; color:#fff !important;  text-decoration:none !important; transition-duration:0.4s; transition-timing-function:ease;}


/* Arrows */
.slick-prev,
.slick-next
{
    font-size: 0;
    line-height: 0;

    position: absolute;
    top: 50%;

    display: block;

    width: 20px;
    height: 20px;
    padding: 0;
    -webkit-transform: translate(0, -50%);
    -ms-transform: translate(0, -50%);
    transform: translate(0, -50%);

    cursor: pointer;

    color: transparent;
    border: none;
    outline: none;
    background: transparent;
}
.slick-prev:hover,
.slick-prev:focus,
.slick-next:hover,
.slick-next:focus
{
    color: transparent;
    outline: none;
    background: transparent;
}
.slick-prev:hover:before,
.slick-prev:focus:before,
.slick-next:hover:before,
.slick-next:focus:before
{
    opacity: 1;
}
.slick-prev.slick-disabled:before,
.slick-next.slick-disabled:before
{
    opacity: .25;
}

.slick-prev:before,
.slick-next:before
{
    font-family: 'slick';
    font-size: 20px;
    line-height: 1;

    opacity: .75;
    color: black;

    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
}

.slick-prev
{
    left: -25px;
}
[dir='rtl'] .slick-prev
{
    right: -25px;
    left: auto;
}
.slick-prev:before
{
    content: '←';
    margin-left: 9px;
}
[dir='rtl'] .slick-prev:before
{
    content: '→';
}

.slick-next
{
    right: -25px;
}
[dir='rtl'] .slick-next
{
    right: auto;
    left: -25px;
}
.slick-next:before
{
    content: '→';
}
[dir='rtl'] .slick-next:before
{
    content: '←';
}
.aui .nav {
    margin-bottom: 0px !important;
}
</style>

<script src="<%=request.getContextPath()%>/js/slick/slick.min.js"></script>
<h2 class="h2title" style="font-family: 'Nanum Gothic', sans-serif; padding-top: 12px;">SIMULATION DATA</h2>
<aui:form method="post" name="listForm">

	<div class="<portlet:namespace />resultwrap">
		<div class="container">
			<span class="<portlet:namespace />btn_line02" onclick="location.href='${dataSearchURL}'">more</span>
			<div id="<portlet:namespace />collection-row" class="row" style="margin:0;">
       			<c:if test="${!empty collectionList}">    
        		<c:forEach items="${collectionList}" var="collection" end="7">
			
					<div class="<portlet:namespace />resultlist">
					<ul>
					
						<liferay-portlet:renderURL portletName="datasearch_WAR_SDR_baseportlet"
                             var="collectionDetailURL"
                             windowState="<%=LiferayWindowState.MAXIMIZED.toString()%>">
                    		<portlet:param name="controller" value="Collection"/>
                    		<portlet:param name="action" value="collectionDetail"/>
                    		<portlet:param name="collectionId" value="${collection.vo.collectionId}"/>
                		</liferay-portlet:renderURL>
					
						<li onclick="location.href='${collectionDetailURL}'">
                            <c:if test="${not empty collection.collectionImage}">
                                <c:set var="collectionImage" value="${getImageURL_path}${collection.collectionImage}"/>
							    <img src="${(empty collection.collectionImage) ? defaultImage : collectionImage}" class="<portlet:namespace />communityImage" style="max-width: 288px; max-height: 147px;">
                            </c:if>
                            <c:if test="${empty collection.collectionImage}">
							    <img src="${defaultImage}" class="<portlet:namespace />communityImage" style="max-width: 288px; max-height: 147px;">
                            </c:if>
						</li>

                		<li class="tit" /><a href="${collectionDetailURL}" target="_blank" data-toggle="tooltip" title="${collection.vo.title}">
	                		<c:set var = "title_len" value = "${fn:length(collection.vo.title)}"/>
	                		<c:choose>
	                			<c:when test="${title_len eq 0}">
	                				No Title
	                			</c:when>
	 	               			<c:when test="${title_len gt 30}">
	                				${fn:substring(collection.vo.title, 0, 23).concat(' ...')}
	                			</c:when>
	                			<c:when test="${title_len le 30}">
	                				${collection.vo.title}
	                			</c:when>
	                		</c:choose>
                		</a>
                		<li /><fmt:formatDate value="${collection.vo.createDate }" pattern="yyyy-MM-dd"/> -
	                		<c:set var = "description" value = "${fn:length(collection.vo.description)}"/>
	                		<c:choose>
	                			<c:when test="${description eq 0}">
	                				No Description
	                			</c:when>
	 	               			<c:when test="${description gt 60}">
	                				${fn:substring(collection.vo.description, 0, 60).concat(' ...')}
	                			</c:when>
	                			<c:when test="${description le 60}">
	                				${collection.vo.description}
	                			</c:when>
	                		</c:choose>
					</ul>
					</div>					
				</c:forEach>	        
    			</c:if>
    		</div>
		</div>
	</div> 
</aui:form>

<script>
	$(document).ready(function() {
		$('#<portlet:namespace />collection-row').slick({
			infinite : true,
			slidesToShow : 4,
			slidesToScroll : 1
		});
		
		$('#<portlet:namespace />collection-row button').html("");
	});
	
/* 	$('[data-toggle="tooltip"]').tooltip(); */
</script>

