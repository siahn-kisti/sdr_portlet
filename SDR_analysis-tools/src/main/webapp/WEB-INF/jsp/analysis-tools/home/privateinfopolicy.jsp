<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ page import="com.liferay.portal.theme.ThemeDisplay" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>

<portlet:defineObjects/>
<liferay-theme:defineObjects/>

<%--<liferay-portlet:renderURL var="aaaa" portletName="sdrhome_WAR_SDR_baseportlet">--%>
<%--<portlet:param name="controller" value="Index"/>--%>
<%--<portlet:param name="action" value="privateinfopolicy"/>--%>
<%--</liferay-portlet:renderURL>--%>

<%--<p>--%>
<%--<a href="${aaaa}">${aaaa}</a>--%>
<%--</p>--%>

<%
    ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
%>


<div class="portlet-body">
    <style type="text/css">
        .logintitlebox {
            margin: 0 auto;
            width: 100%
        }

        .logintitle {
            font-size: 27px;
            color: #000;
            padding: 0 20px 12px 0;
            font-family: Arial, Nanum Barun Gothic, NanumGothic;
            float: left
        }

        .textarea01 {
            width: 98%;
            margin: 0;
            text-align: left;
            font-size: 14px;
            color: #777;
            line-height: 22px;
            border: solid 1px #cacaca;
            font-family: Arial, Nanum Barun Gothic, NanumGothic;
            float: left
        }

        .joinbox {
            width: 94%;
            border: solid 6px #e5e5e5;
            text-align: center;
            padding: 22px 30px;
            text-align: left
        }

        .buttonbox08 {
            margin: 0 auto;
            overflow: hidden;
            padding-top: 15px;
            padding-bottom: 10px;
            text-align: center;
        }

        .button08 {
            padding: 4px 10px 5px 10px;
            height: 38px;
            /*background: #606060;*/
            /*border-radius: 3px;*/
            -webkit-border-radius: 3px;
            border: solid 1px #6a6a6b;
            min-width: 90px;
            /*color: #ffffff;*/
            /*font-weight: 600;*/
            /*font-size: 14px;*/
            vertical-align: middle;
        }

        .table0_list {
            line-height: 1.3em;
            width: 100%;
            border-top: 2px solid #6a8ec6;
            border-collapse: collapse;
            font-size: 14px;
        }

        .table0_list thead {
            display: table-header-group;
            vertical-align: middle;
            border-color: inherit;
        }

        .table0_list tr {
            display: table-row;
            vertical-align: inherit;
            border-color: inherit;
        }

        .table0_list th {
            line-height: 2.0em;
            border-bottom: 1px solid #b4b4b4;
            padding: 8px;
            color: #383838;
            font-weight: 600;
            background-color: #f7f7f7;
            text-align: center;
            font-size: 15px;
        }

        .table0_list tbody tbody {
            display: table-row-group;
            vertical-align: middle;
            border-color: inherit;
        }

        .TC {
            text-align: center;
        }


    </style>
    <script type="text/javascript">function check() {
        history.back()
    };</script>
    <fieldset class="fieldset body_layout">
        <div class="">
            <div class="logintitlebox">
                <div class="logintitle">개인정보처리방침</div>
            </div>
            <div class="h20"></div>
            <div style="clear:left;"></div>
            <div class="joinbox">
                <c:if test='<%=themeDisplay.getLocale().toString().equals("ko_KR")%>'>

<textarea name="textarea3" cols="110" rows="20" id="textarea3" class="textarea01"
          style="padding:10px;resize: none;background-color: #f9f7f6;width: 98%;"
          spellcheck="false">▶개인정보처리방침

첨단 사이언스·교육 시뮬레이션 웹 서비스 (이하 'EDISON')는 개인정보보호법에 따라 이용자의 개인정보 보호 및 권익을 보호하고 개인정보와 관련한 이용자의 고충을 원활하게 처리할 수 있도록 다음과 같은 처리방침을 두고 있습니다.

EDISON은 개인정보처리방침을 개정하는 경우 웹사이트 공지사항(또는 개별공지)을 통하여 공지할 것입니다.

○ 본 방침은 2014년 9월 11일부터 시행됩니다.

1. 개인정보의 처리 목적
EDISON은 개인정보를 다음의 목적을 위해 처리합니다. 처리한 개인정보는 다음의 목적이외의 용도로는 사용되지 않으며 이용 목적이 변경될 시에는 사전 동의를 구할 예정입니다.

가. 홈페이지 회원가입 및 관리
회원 가입의사 확인, 회원제 서비스 제공에 따른 본인 식별·인증, 회원자격 유지·관리 등을 목적으로 개인정보를 처리합니다.

나. 민원처리
개인정보 열람, 개인정보 정정·삭제, 개인정보 처리 정지 요구, 개인정보 유출사고 신고 등 개인정보와 관련된 민원처리를 목적으로 개인정보를 처리합니다.

다. 서비스 제공
서비스 제공, 콘텐츠 제공 또는 회원의 서비스 이용에 대한 통계 등을 목적으로 개인정보를 처리합니다.

라. 마케팅 및 홍보에의 활용
신규 서비스 개발 및 맞춤 서비스 제공, 이벤트 및 홍보성 정보 제공 및 참여기회 제공, 서비스의 유효성 확인, 접속빈도 파악 또는 회원의 서비스 이용에 대한 설문 및 통계 등을 목적으로 개인정보를 처리합니다


2. 개인정보 파일 현황
EDISON이 개인정보 보호법 제32조에 따라 등록․공개하는 개인정보파일의 처리목적은 다음과 같습니다.

가. 개인정보 파일명 : 회원 DB
- 개인정보 항목 : 이름, ID, 비밀번호, 이메일, 대학교/기관, 전공/부서, 접속 IP 정보, 서비스 이용 기록, 접속 로그
- 수집방법 : 홈페이지
- 보유근거 : 정보주체의 동의
- 보유기간 : 회원 탈퇴시까지
※ 기타(EDISON)의 개인정보파일 등록사항 공개는 행정안전부 개인정보보호 종합지원 포털(www.privacy.go.kr) → 개인정보민원 → 개인정보열람등  요구 → 개인정보파일 목록검색 메뉴를 활용해주시기 바랍니다.


3. 개인정보의 처리 및 보유 기간
① EDISON은 법령에 따른 개인정보 보유·이용기간 또는 정보주체로부터 개인정보를 수집시에 동의 받은 개인정보 보유,이용기간 내에서 개인정보를 처리,보유합니다.

② 각각의 개인정보 처리 및 보유 기간은 다음과 같습니다.

가. 홈페이지 회원가입 및 관리
홈페이지 회원가입 및 관리와 관련한 개인정보는 수집.이용에 관한 동의일로부터 회원 탈퇴시까지 위 이용목적을 위하여 보유·이용됩니다.
-보유근거 : 정보주체의 동의

나. 민원처리
민원사무 처리와 관련한 개인정보는 수집·이용에 관한 동의일로부터 회원 탈퇴 시까지 위 이용목적을 위하여 보유·이용됩니다
-보유근거 : 정보주체의 동의

다. 서비스 제공
서비스 제공, 콘텐츠 제공, 본인인증 등을 목적으로 개인정보를 처리합니다.
-보유근거 : 정보주체의 동의

라. 마케팅 및 홍보에의 활용
접속빈도 파악 또는 회원의 서비스 이용에 대한 설문 및 통계 등을 목적으로 개인정보를 처리합니다.
-보유근거 : 정보주체의 동의


4. 개인정보의 제3자 제공에 관한 사항
① EDISON은 정보주체의 동의, 법률의 특별한 규정 등 개인정보 보호법 제17조 및 제18조에 해당하는 경우에만 개인정보를 제3자에게 제공합니다.

② EDISON은 정보주체의 개인정보를 수집·이용 목적으로 명시한 범위 내에서 처리하며, 다음의 경우를 제외하고는 정보주체의 사전 동의 없이는 본래의 목적 범위를 초과하여 처리하거나 제3자에게 제공하지 않습니다.

가. 정보주체로부터 별도의 동의를 받는 경우
나. 법률에 특별한 규정이 있는 경우
다. 정보주체 또는 법정대리인이 의사표시를 할 수 없는 상태에 있거나 주소불명 등으로 사전 동의를 받을 수 없는 경우로서 명백히 정보주체 또는 제3자의 급박한 생명, 신체, 재산의 이익을 위하여 필요하다고 인정되는 경우
라. 통계작성 및 학술연구 등의 목적을 위하여 필요한 경우로서 특정 개인을 알아 볼 수 없는 형태로 개인정보를 제공하는 경우
마. 개인정보를 목적 외의 용도로 이용하거나 이를 제3자에게 제공하지 아니하면 다른 법률에서 정하는 소관 업무를 수행할 수 없는 경우로서 보호위원회의 심의·의결을 거친 경우
바. 조약, 그 밖의 국제협정의 이행을 위하여 외국정보 또는 국제기구에 제공하기 위하여 필요한 경우
사. 범죄의 수사와 공소의 제기 및 유지를 위하여 필요한 경우
아. 법원의 재판업무 수행을 위하여 필요한 경우
자. 형 및 감호, 보호처분의 집행을 위하여 필요한 경우


5. 개인정보처리 위탁
① EDISON은 위탁계약 체결시 개인정보 보호법 제25조에 따라 위탁업무 수행목적 외 개인정보 처리금지, 기술적·관리적 보호조치, 재위탁 제한, 수탁자에 대한 관리·감독, 손해배상 등 책임에 관한 사항을 계약서 등 문서에 명시하고, 수탁자가 개인정보를 안전하게 처리하는지를 감독하고 있습니다.

② 위탁업무의 내용이나 수탁자가 변경될 경우에는 지체 없이 본 개인정보 처리방침을 통하여 공개하도록 하겠습니다.


6. 정보주체의 권리, 의무 및 그 행사방법
이용자는 개인정보주체로서 다음과 같은 권리를 행사할 수 있습니다.
① 정보주체는 EDISON에 대해 언제든지 다음 각 호의 개인정보 보호 관련 권리를 행사할 수 있습니다.
가. 개인정보 열람요구
나. 오류 등이 있을 경우 정정 요구
다. 삭제요구
라. 처리정지 요구

② 제1항에 따른 권리 행사는 EDISON에 대해 개인정보 보호법 시행규칙 별지 제8호 서식에 따라 서면, 전자우편, 모사전송(FAX) 등을 통하여 하실 수 있으며 EDISON은 이에 대해 지체 없이 조치하겠습니다.

③ 정보주체가 개인정보의 오류 등에 대한 정정 또는 삭제를 요구한 경우에는 EDISON은 정정 또는 삭제를 완료할 때까지 당해 개인정보를 이용하거나 제공하지 않습니다.

④ 제1항에 따른 권리 행사는 정보주체의 법정대리인이나 위임을 받은 자 등 대리인을 통하여 하실 수 있습니다. 이 경우 개인정보 보호법 시행규칙 별지 제11호 서식에 따른 위임장을 제출하셔야 합니다.


7. 처리하는 개인정보의 항목 작성
EDISON은 다음의 개인정보 항목을 처리하고 있습니다.
- 필수항목 : 이름, ID, 비밀번호, 이메일, 대학교/기관, 전공/부서
- 자동으로 수집·저장되는 개인정보: 접속 IP 정보, 서비스 이용 기록, 접속 로그


8. 개인정보의 파기
EDISON은 원칙적으로 개인정보 처리목적이 달성된 경우에는 지체 없이 해당 개인정보를 파기합니다. 파기의 절차, 기한 및 방법은 다음과 같습니다.

- 파기절차
이용자가 입력한 정보는 목적 달성 후 별도의 DB에 옮겨져 내부 방침 및 기타 관련 법령에 따라 일정기간 저장된 후 혹은 즉시 파기됩니다. 이 때, DB로 옮겨진 개인정보는 법률에 의한 경우가 아니고서는 다른 목적으로 이용되지 않습니다.

- 파기기한
이용자의 개인정보는 개인정보의 보유기간이 경과된 경우에는 보유기간의 종료일로부터 7일 이내에, 개인정보의 처리 목적 달성, 해당 서비스의 폐지, 사업의 종료 등 그 개인정보가 불필요하게 되었을 때에는 개인정보의 처리가 불필요한 것으로 인정되는 날로부터 7일 이내에 그 개인정보를 파기합니다.

-파기방법
전자적 파일 형태의 정보는 기록을 재생할 수 없는 기술적 방법을 사용합니다.


9. 개인정보 보호책임자 작성
① EDISON은 개인정보 처리에 관한 업무를 총괄해서 책임지고, 개인정보 처리와 관련한 정보주체의 불만처리 및 피해구제 등을 위하여 아래와 같이 개인정보 보호책임자를 지정하고 있습니다.

▶ 개인정보 보호 책임자
성명 : 조금원
소속 : 한국과학기술정보연구원 슈퍼컴퓨팅융합연구센터
직책 : 센터장
연락처 : 042-869-0550, ckw@kisti.re.kr, (FAX)042-869-0799

▶ 개인정보 보호 담당자
성명 : 서정현
소속 : 한국과학기술정보연구원 슈퍼컴퓨팅융합연구센터
직책 : 담당
연락처 : 042-869-1040, jerry@kisti.re.kr, (FAX)042-869-0799

② 정보주체께서는 EDISON의 서비스를 이용하시면서 발생한 모든 개인정보 보호 관련 문의, 불만처리, 피해구제 등에 관한 사항을 개인정보 보호책임자 및 담당부서로 문의하실 수 있습니다. EDISON은 정보주체의 문의에 대해 지체 없이 답변 및 처리해드릴 것입니다.


10. 개인정보 열람청구
① 정보주체는 개인정보 보호법 제35조에 따른 개인정보의 열람 청구를 아래의 부서에 할 수 있습니다. EDISON은 정보주체의 개인정보 열람청구가 신속하게 처리되도록 노력하겠습니다.

▶ 개인정보 열람청구 접수·처리 담당자
성명 : 서정현
소속 : 한국과학기술정보연구원 슈퍼컴퓨팅융합연구센터
직책 : 담당
연락처 : 042-869-1040, jerry@kisti.re.kr, (FAX)042-869-0799

② 정보주체께서는 제1항의 열람청구 접수·처리부서 이외에, 행정안전부의 ‘개인정보보호 종합지원 포털’ 웹사이트(http://www.privacy.go.kr)를 통하여서도 개인정보 열람청구를 하실 수 있습니다.

▶ 행정안전부 개인정보보호 종합지원 포털 → 개인정보 민원 → 개인정보 열람등 요구 (본인확인을 위하여 아이핀(I-PIN)이 있어야 함)


11. 권익침해 구제 방법
EDISON의 자체적인 개인정보 불만처리, 피해구제 결과에 만족하지 못하시거나 보다 자세한 도움이 필요하시면 문의하여 주시기 바랍니다.

▶ 개인정보 침해신고센터 (한국인터넷진흥원 운영)
- 소관업무 : 개인정보 침해사실 신고, 상담 신청
- 홈페이지 : http://privacy.kisa.or.kr
- 전화 : (국번없이) 118
- 주소 : (05717) 서울시 송파구 중대로 135 한국인터넷진흥원 개인정보침해신고센터

▶ 개인정보 분쟁조정위원회 (한국인터넷진흥원 운영)
- 소관업무 : 개인정보 분쟁조정신청, 집단분쟁조정 (민사적 해결)
- 홈페이지 : http://www.kopico.go.kr
- 전화 : (국번없이) 1833-6972
- 주소 : (03171) 서울특별시 종로구 세종대로 209 정부서울청사 4층

▶ 대검찰청 사이버범죄수사단 : 02-3480-3573 (http://www.spo.go.kr)

▶ 경찰청 사이버범죄수사단 : 1566-0112 (http://www.netan.go.kr)


12. 개인정보 처리방침 변경
① 이 개인정보처리방침은 시행일로부터 적용되며, 법령 및 방침에 따른 변경내용의 추가, 삭제 및 정정이 있는 경우에는 변경사항의 시행 7일 전부터 공지사항을 통하여 고지할 것입니다.

- 공고일자 : 2014년 9월 4일
- 시행일자 : 2014년 8월 11일
		</textarea>
                </c:if>
                <c:if test='<%=themeDisplay.getLocale().toString().equals("en_US")%>'>
    <pre style="text-align: left;font-size: 14px;color: #777;line-height: 22px; font-family: Arial,Nanum Barun Gothic,NanumGothic;word-break: normal; height: 421px; overflow-x: auto; word-wrap: break-word;
    white-space: pre-wrap;">All personal information that Education-research Integration through Simulation on the Net (EDISON) handles are collected, retained, and processed under relevant Acts and subordinate statutes or with consent of each person whose information becomes subject to this Policy. The Personal Information Protection Act provides general norms concerning the management of personal information, and EDISON will lawfully and properly manage the information collected, retained, and processed under the provisions of such statutes so as to properly perform public services and appropriately protect citizens’ rights and interests.

Furthermore, we at EDISON respect your rights, including the right to request us to permit you to inspect your personal information retained by us and the right to request us to correct such information, and you have a right to file a petition for an administrative trial to seek remedies for a violation of any of such rights under the Administrative Appeals Act.


<b>1. Purposes of Handling Personal Information</b>

Your personal information processed by us are not used for any purpose other than the purposes specified in the following, and we will take necessary measures when any change occurs in the purposes of use, such as obtaining additional consent in accordance with Article 18 of the Personal Information Protection Act.


<b>1.1 Personal Information Automatically Collected and Stored</b>

When you access the website of EDISON, the information listed in the following is automatically collected and stored. The information automatically collected and stored, as explained above, is used for the statistical analysis for the improvement and supplementation of web pages and the web-site so as to provide better services to users. However, you are kindly requested to note and understand that relevant statutes require us to present such information to a relevant authority in certain cases.

	<table width="100%" border="0" cellspacing="0" cellpadding="0" class="table0_list">
		<colgroup>
			<col width="25%">
			<col width="25%">
			<col width="25%">
			<col width="25%">
		</colgroup>
		<thead>
			<tr>
				<th scope="col">Authority for Use</th>
				<th scope="col">Purpose of Handling</th>
				<th scope="col">Major Items</th>
				<th scope="col">Period of Retaining</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td class="TC">Consent of a user whose information becomes subject to this Policy</td>
				<td class="TC">Membership management</td>
				<td class="TC">Name, password,e-mail address, affiliation, IP address, access log</td>
				<td class="TC">Until the user deletes his/her account</td>
			</tr>
		</tbody>
	</table>


<b>2. Period of Handling and Retaining of Personal Information</b>

	(a)	EDISON handles and retains personal information only during the period specified by relevant statutes for retaining and using personal information or the period to which each user consents when collecting the user’s personal information.
	(b)	The period of handling and retaining a user’s personal information is as follows:
	  -	A user registered with us as a member: Until deleting his/her account.


<b>3. Provision of Personal Information to Third Parties</b>

EDISON does not provide personal information collected and retained by it to a third party without each user’s consent, except in the following cases:


	(a)	Where a user specifically consents to the provision of his/her personal information;
	(b)	Where EDISON is required or obliged to provide a user’s personal information to a third party under any Act or subordinate statute;
	(c)	Where a user or his/her legal representative is in a state of being incapable of communicating his/her intention or it is impossible to obtain consent from a user or his/her legal representative because his/her whereabouts are unknown but it is considered obviously necessary to urgently provide his/her personal information to a third party for the life, body, or property interests of the user or a third party;
	(d)	Where personal information is provided in a format that makes it impossible to identify a specific person, as necessary for the production of statistics or scientific research;
	(e)	When we provide your personal information to a third party, we will inform you of the following facts to obtain consent from you:
	  -	The name of the recipient of personal information (or the name of the corporation or organization, if the recipient is a corporation or organization) and the contact information of the recipient;
	  -	The recipient’s purposes of use of personal information and the items of personal information to be provided;
	  -	The duration of retaining and using personal information by the recipient;
	  -	The fact that the user has a right to refuse to consent and disadvantages in detail, if the user’s refusal to consent may result in the user’s disadvantages.


<b>4. Entrustment of Processing of Personal Information</b>

EDISON does not entrust any other person with the processing of a user’s personal information without the user’s consent. We EDISON ensure that we will comply with Article 26 of the Personal Information Protection Act when we entrust a third party with the processing of personal information and will post a statement concerning the following information, including the scope of entrusted business affairs and the entrusted person, our web-site:

	(a)	Prohibition of processing personal information for any purpose other than the performance of entrusted business affairs;
	(b)	Technical and administrative measures for the protection of personal information;
	(c)	The following matters specified by Presidential Decree for the safe management of personal information:
	  -	Purposes and the scope of entrusted business affairs;
	  -	Restriction on re-entrustment;
	  -	Measures for securing safety, restrictions on access to personal information;
	  -	Matters concerning supervision, including the inspection of current conditions of management of personal information retained in connection with entrusted business affairs;
	  -	Matters concerning liability, including the compensation for injuries caused by breach of duties that the entrusted person shall fulfill under Article 26 (2) of the Act.


<b>5. Rights and Obligations of Users, Exercise of Rights, and Performance of Obligations</b>

A user, as a person whose information becomes subject to this Policy, may exercise the following rights:

	(a)	The right to request the permission for inspecting personal information: A user may request EDISON to permit him/her to inspect files containing his/her personal information held by it under Article 35 of the Personal Information Protection Act: Provided, That restrictions may be placed under Article 35 (5) of the Personal Information Protection Act on a request for the permission for inspecting personal information in the following cases:
	(b)	Where any Act prohibits or restricts such inspection;
	(c)	Where such inspection is likely to harm another person’s life or body or is likely to unreasonably encroach on another person’s property or interest;
	(d)	Where such inspection creates a serious problem in performing any of the following business affairs:
	  -	Testing of academic achievements or skills for employment or examination of qualification;
	  -	Evaluation or judgment in process for the calculation of damages or grants;
	  -	Audit or investigation in process under any other Act.

(1)	The right to request the correction or deletion of personal information: A user may request EDISON to correct or delete files containing his/her personal information held by it under Article 36 of the Personal Information Protection Act: Provided, That no user may request the deletion of his/her personal information, if his/her personal information is clearly specified as information subject to collection under any other statute.
(2)	The right to request the suspension of handling of personal information: A user may request EDISON to suspend the handling of his/her personal information held by it under Article 37 of the Personal Information Protection Act. Moreover, the legal representative of a minor under the age of 14 may request EDISON to permit him/her to inspect the minor’s personal information, to correct or delete such information, or to suspend the handling of such information: Provided, That a request for suspending the handling of personal information may be declined under Article 37 (2) of the Personal Information Protection Act:

	(a)	Where any Act expressly prohibits such suspension or it is unavoidable to handle personal information in order to fulfill obligations under relevant statutes;
	(b)	Where such suspension is likely to harm another person’s life or body or is likely to unreasonably encroach on another person’s property or other interest;
	(c)	Where EDISON as a public agency is unable to carry out administrative affairs assigned to it by any Act without handling personal information;
	(d)	Where EDISON will be unable to provide services that it has agreed with a user to provide to the user whose personal information becomes subject to this policy or will have difficulties in performing the relevant contract made with the user, unless it is permitted to handle his/her personal information, and the user has not clearly expressed his/her intention to terminate the agreement.

(3)	Upon receipt of a request for the inspection, correction, or deletion of personal information or a request for the suspension of handling personal information, EDISON will give notice of the measures taken by it for the relevant matters within seven days. If you contact our officer in charge of management of personal information to request us to permit the inspection of your personal information, to correct or delete your personal information, or to suspend the handling of your personal information by telephone or e-mail, we will take necessary measures promptly.


<b>6. Destruction of Personal Information</b>

In principle, EDISON destroys a user’s personal information after the period of retaining the personal information ends or the purposes of handling the personal information have been attained, except where it is required to preserve the personal information under any other Act. The procedure, time limits, and methods for the destruction are as follows:

	(a)	Procedure for destruction: The information that a user has entered is destroyed in accordance with internal policies and relevant statutes after the period of retaining the information ends or the purposes of handling the information have been attained;
	(b)	Methods for destruction: Personal information recorded and stored in electronic files will be destroyed by means of Low Level Format or other similar methods so as to prevent reproduction of records, while personal information recorded and preserved in paper documents will be shredded by a shredder for destruction.

<b>7. Managers and Officers in Charge of Management of Personal Information</b>

In order to ensure the legality of personal information and the properness of procedures to protect citizens’ rights and interests and properly perform public services, EDISON appoints one of its personnel as the officer in charge of protection of personal information as follows: For any question or inquiry about the files of personal information retained by EDISON and the policy on the protection of personal information, please do not hesitate to contact us by any of the following means:

Name: Kum Won, Cho
Department: R&amp;D on Supercomputing Convergence
Position: Head
Contact: +82-42-869-0550, ckw@kisti.re.kr, (FAX) +82-42-869-0799

Name: Jerry H. Seo
Department: R&amp;D on Supercomputing Convergence
Position: Manager
Contact: +82-42-869-1040, jerry@kisti.re.kr, (FAX) +82-42-869-0799


<b>8. Remedies for Violation of Rights and Interests</b>

A user whose personal information becomes subject to this Policy may file a petition for settlement of, or advice on, a dispute with the Personal Information Dispute Mediation Committee, EDISON, or a privacy invasion reporting center to seek remedies for the invasion of privacy. In addition, you may contact any of the following agencies for reporting or counselling on the invasion of privacy:

	(a)	The Personal Information Dispute Mediation Committee: 118 (with no exchange number)
	(b)	The Cyber Crime Investigation Team of the Supreme Prosecutors’ Office: 02-3480-3571 (http://www.spo.go.kr)
	(c)	The Cyber Terrorism Response Center of the National Police Agency: 1566-0112 (http://www.netan.go.kr)

Any person who has any of his/her rights or interests violated by a disposition or inaction of the head of a public agency with regard to a request made under the provisions of Article 35, 36, or 37 of the Personal Information Dispute Mediation Committee may file a petition for an administrative trial in accordance with the provisions of the Administrative Appeals Act.

※ For more information about administrative appeals, please refer to the web-pages of the Ministry of Government Legislation (http://www.moleg.go.kr ).


<b>9. Amendment of Privacy Policy</b>

This Privacy Policy currently in force was wholly amended on August 11, 2014, and entered into force on September 4, 2014. If the policy is amended for any reason, the changes will be notified 7 days before it is enforced.

	  -	Date of amendment of the Privacy Policy: August 11, 2014
	  -	Date of enforcement of the Privacy Policy: September 4, 2014
	  		</pre>
                </c:if>
                <div style="clear:left;"></div>
                <div class="borderline" style="display: block;"></div>
                <div class="buttonbox08"><input type="button" name="fullsize" id="fullsize" value="확인"
                                                onclick="check();" class="button08">
                </div>
            </div>
        </div>
    </fieldset>
</div>




