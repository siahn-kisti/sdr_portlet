<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>

<portlet:defineObjects />

This is the <b>Sample Transt</b> portlet in View mode.


<portlet:actionURL var="test01URL" name="test01"/>
<portlet:actionURL var="test02URL" name="test02"/>
<portlet:actionURL var="test03URL" name="test03"/>


<h1>01 Liferay Transaction 처리</h1>
<ul>
	<li>- Liferay Transaction은 Spring AOP기반으로 Service(interface)단으로 넣어줘야 transaction이 가능함</li>
	<li>- Liferay의 MVCPortlet, @Controller 단에서 @Transactional은 해당이 없음</li>
	<li>- 복수의 데이터를 입력하거나 수정할 경우 transaction처리를 하려면 service단에 추가 하고 처리</li>
</ul>



<h4>//테스트용 로직: 중간(ERROR)에 중복된 pk 값으로 강제 오류 발생 시킨후 데이터 조회시 Rollbak 이 되었나 확인</h4>

<pre>
SdrOrganizations org = SdrOrganizationsLocalServiceUtil.createSdrOrganizations(10001);
SdrOrganizationsLocalServiceUtil.addSdrOrganizations(org);

org = SdrOrganizationsLocalServiceUtil.createSdrOrganizations(10002);
SdrOrganizationsLocalServiceUtil.addSdrOrganizations(org);

org = SdrOrganizationsLocalServiceUtil.createSdrOrganizations(10003);
SdrOrganizationsLocalServiceUtil.addSdrOrganizations(org);

SdrUsers users = SdrUsersLocalServiceUtil.createSdrUsers(10001);
SdrUsersLocalServiceUtil.addSdrUsers(users);

users = SdrUsersLocalServiceUtil.createSdrUsers(10002);
SdrUsersLocalServiceUtil.addSdrUsers(users);

//ERROR ==========
users = SdrUsersLocalServiceUtil.createSdrUsers(10001);
SdrUsersLocalServiceUtil.addSdrUsers(users);

org = SdrOrganizationsLocalServiceUtil.createSdrOrganizations(10004);
SdrOrganizationsLocalServiceUtil.addSdrOrganizations(org);
</pre>

<pre>
select * from sdr_SdrOrganizations;
select * from sdr_SdrUsers;

delete from sdr_SdrOrganizations where organizationId > 10000;
delete from sdr_SdrUsers where userId > 10000;
</pre>


<aui:button-row>
	<aui:button cssClass="btn btn-primary" value="test01" onClick="${test01URL}" ></aui:button>
	<aui:button cssClass="btn btn-primary" value="test02" onClick="${test02URL}" ></aui:button>
	<aui:button cssClass="btn btn-primary" value="test03" onClick="${test03URL}" ></aui:button>
</aui:button-row>
