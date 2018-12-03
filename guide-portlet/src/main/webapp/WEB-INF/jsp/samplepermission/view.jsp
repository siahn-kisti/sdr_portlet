<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib uri="http://liferay.com/tld/theme" prefix="theme" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://alloy.liferay.com/tld/aui" prefix="aui" %>

<portlet:defineObjects />
<theme:defineObjects />

<h1>권한 테스트 방법</h1>
<pre>
<!-- ※ 해당 포틀릿은 임의 설정된 role에 따른 permission 설정 방법에 대한 샘플입니다. -->
I. GUEST (로그인 하지 않은 사용자 권한 설정)
	1. 관리자 계정으로 로그인 후 Admin > Control Panel > Roles 메뉴로 이동	
	2. title 목록중 Guest 클릭 Define Permission 탭에서 samplepermission 검색
	3. 해당메뉴 선택 후 우픅 Application Permissions에서 action.GUEST 체크 후 Save
     	<p style='color: red;'>※ VIEW는 선택하지 않아도기본적으로 선택된다.</p>
	4. Sing-out 후 samplepermission 포틀릿에서 [VIEW 권한 소유], [GUEST 권한 소유]텍스트가 출력되는지 확인한다.
	
II. USER (로그인 된 일반 사용자 권한 설정)	
	1. 관리자 계정으로 로그인 후 Admin > Control Panel > Roles 메뉴로 이동	
	2. title 목록중 User 클릭 Define Permission 탭에서 samplepermission 검색
	3. 해당메뉴 선택 후 우픅 Application Permissions에서 action.USER 체크 후 Save
	4. 일반사용자 생성 후 [VIEW 권한 소유], [GUEST 권한 소유], [USER 권한 소유]텍스트가 출력되는지 확인한다.
		<p style='color: red;'>※liferay에서 제공하는 기본 Roles에 경우 하위 Role에 설정된 permission은 상위에서도 적용된다.</p> 
		
III. 사용자 지정 ROLE (ROLE에 ADD한 사용자지정 ROLE에 대한 권한)	
	1. 관리자 계정으로 로그인 후 Admin > Control Panel > Roles 메뉴로 이동
	2. 상단에 Add	Regular Role 클릭 후 임의의 명칭으로 Role을 생성한다 (ex.REVIEWER)
	3. Role 목록으로 돌아와 우측의 Action > Permission 메뉴에서 해당 custom 권한에 체크한다.
	4. title 목록중 생성한 Role 클릭 Define Permission 탭에서 samplepermission 검색
	5. 해당메뉴 선택 후 우픅 Application Permissions에서 action.REVIEWER 체크 후 Save
	6. 일반사용자에 해당 Role 부여 후 [VIEW 권한 소유], [GUEST 권한 소유], [USER 권한 소유], [REVIEWER 권한 소유]텍스트가 출력되는지 확인한다.
		<p style='color: red;'>※liferay에서 제공하는 기본 Roles에 경우 하위 Role에 설정된 permission은 상위에서도 적용된다.</p>
	7. 같은 방식으로 CUSTOMROLE 이라는 Role을 생성하여  permission을 CUSTOM을 지정한 후 
		[VIEW 권한 소유], [GUEST 권한 소유], [USER 권한 소유], [CUSTOM 권한 소유]텍스트가 출력되는지 확인한다.
		REVIEWER 와 CUSTOMROLE 은 서로 같은 레벨에 같은 포틀릿에서 다른 permission을 지정하였기때문에 
		각각 [CUSTOM 권한 소유], [REVIEWER 권한 소유]만 보이게 된다.

IV. OWNER (글 작성자에 대한 권한부여)
	Guestbook-portlet tutorial 참조!!	
</pre>

<%-- <portlet:actionURL name="addPermission" var="addResouceURL"/> --%>
<h1>포틀릿 권한별 출력결과</h1>
<br/>
<c:if test='<%= permissionChecker.hasPermission(scopeGroupId,portletDisplay.getRootPortletId(),portletDisplay.getResourcePK(),"VIEW") %>'>
<h3>[VIEW 권한 소유]</h3> <p style='color: red;'>※VIEW 권한의 경우 별도 설정 없을 시 모든 권한에서 보여짐!!</p>
</c:if>
<br/>
<c:if test='<%= permissionChecker.hasPermission(scopeGroupId,portletDisplay.getRootPortletId(),portletDisplay.getResourcePK(),"GUEST") %>'>
<h3>[GUEST 권한 소유]</h3> <p style='color: red;'>※GUEST 권한의 경우 사이트에 접속한 모두에게 보여짐!!</p>
</c:if>
<br/>
<br/>
<c:if test='<%= permissionChecker.hasPermission(scopeGroupId,portletDisplay.getRootPortletId(),portletDisplay.getResourcePK(),"USER") %>'>
<h3>[USER 권한 소유]</h3> <p style='color: red;'>※USER 권한의 경우 로그인한 사용자 모두에게 보여짐!!</p>
<%-- <aui:form action="${addResouceURL}" name="<portlet:namespace />fm"> --%>
<%-- 	<aui:button-row> --%>
<%-- 	    <aui:button type="submit" value="addOwnerPerm"/> --%>
<%-- 	</aui:button-row> --%>
<%-- </aui:form> --%>
</c:if>
<br/>
<c:if test='<%= permissionChecker.hasPermission(scopeGroupId,portletDisplay.getRootPortletId(),portletDisplay.getResourcePK(),"REVIEWER") %>'>
<h3>[REVIEW 권한 소유]</h3>
</c:if>
<br/>
<c:if test='<%= permissionChecker.hasPermission(scopeGroupId,portletDisplay.getRootPortletId(),portletDisplay.getResourcePK(),"CUSTOM") %>'>
<h3>[CUSTOM 권한 소유]</h3>
</c:if>
<br/>
<%-- <c:if test='<%=permissionChecker.hasPermission(scopeGroupId, portletDisplay.getRootPortletId(), themeDisplay.getUser().getUserId(), "OWNER") %>'> --%>
<!-- aaaa -->
<%-- </c:if> --%>
<%-- <c:if test='<%= permissionChecker.hasPermission(scopeGroupId,portletDisplay.getRootPortletId(),portletDisplay.getResourcePK(),"OWNER") %>'> --%>
<%-- <%-- <%=permissionChecker.hasPermission(scopeGroupId, portletDisplay.getRootPortletId(), null, "OWNER") %> --%>
<%-- <%-- <%=permissionChecker.hasPermission(companyId, portletDisplay.getRootPortletId(), null, , "OWNER") %> --%> 
<!-- [OWNER 권한 소유] -->
<%-- </c:if> --%>