<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link href="<c:url value='/js/bootstrap/dist/css/bootstrap.min.css'/>" rel="stylesheet">
</head>

<body>
<h3>FAQ</h3>

<div class="faq-container">
    <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">

        <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="faq01">
                <span class="faq-panel_headPoint">Q</span>
                <h4 class="panel-title">
                    <a role="button" data-toggle="collapse" data-parent="#accordion" href="#faqcollapse01"
                       aria-expanded="true" aria-controls="collapseOne">
                        에디슨 나노물리에서 가시화 도구에 WebGL Viewer가 있었는데 지금은 보이지 않습니다. 어떻게 추가할 수 있나요?
                    </a>
                    <label>Data</label><label>Advanced Search</label>
                    <span class="faq-panel_date">2017-09-07</span>
                </h4>
            </div>
            <div id="faqcollapse01" class="panel-collapse collapse" role="tabpanel" aria-labelledby="faq01">
                <div class="panel-body">
                    신규 웹포털에서는 webGL viewer로 실행결과를 보기 위해서는<br/>
                    <br/>
                    사이언스앱스토어-SW관리-Category에 있는 후처리기 항목의 WebGLViewer 가  체크 되어 있어야 합니다.<br/>
                    <br/>
                    <br/>
                    <br/>
                    따라서 솔버 소유자 또는 관리자 권한을 갖고 있는 개발자께서는  해당 내용을 체크한 후 저장하여 주시기 바랍니다.
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="faq02">
                <span class="faq-panel_headPoint">Q</span>
                <h4 class="panel-title">
                    <a role="button" data-toggle="collapse" data-parent="#accordion" href="#faqcollapse02"
                       aria-expanded="true" aria-controls="collapseOne">
                        후처리기 그래픽 기능이 정상 작동하지 않습니다. 어떻게 해야 하나요?
                    </a>
                    <label>Data</label><label>Advanced Search</label>
                    <span class="faq-panel_date">2017-09-07</span>
                </h4>
            </div>
            <div id="faqcollapse02" class="panel-collapse collapse" role="tabpanel" aria-labelledby="faq02">
                <div class="panel-body">
                    자바 버전을 최신 버전으로 업데이트하시고 다시 실행하여 보시기 바랍니다.
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="faq03">
                <span class="faq-panel_headPoint">Q</span>
                <h4 class="panel-title">
                    <a role="button" data-toggle="collapse" data-parent="#accordion" href="#faqcollapse03"
                       aria-expanded="true" aria-controls="collapseOne">
                        개발된 SW를 급하게 수업에서 사용해야 합니다. 어떻게 해야 하나요?
                    </a>
                    <label>Data</label><label>Collection search</label>
                    <span class="faq-panel_date">2017-09-07</span>
                </h4>
            </div>
            <div id="faqcollapse03" class="panel-collapse collapse" role="tabpanel" aria-labelledby="faq03">
                <div class="panel-body">
                    SW등록은 요청 시점에서 최소 2주 정도의 테스트 및 검토 기간이 소요됩니다. 왜냐하면 SW 등록 요청 순서대로 처리되기 때문입니다. 다만 시급하게 활용을 요하는 경우는 관리자에게 별도 메일로 문의하여 주시기 바랍니다.
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="faq04">
                <span class="faq-panel_headPoint">Q</span>
                <h4 class="panel-title">
                    <a role="button" data-toggle="collapse" data-parent="#accordion" href="#faqcollapse04"
                       aria-expanded="true" aria-controls="collapseOne">
                        콘텐츠 등록은 어떻게 하나요?
                    </a>
                    <label>Data</label><label>Collection search</label>
                    <span class="faq-panel_date">2017-09-07</span>
                </h4>
            </div>
            <div id="faqcollapse04" class="panel-collapse collapse" role="tabpanel" aria-labelledby="faq04">
                <div class="panel-body">
                    개발자 또는 튜터 권한이 있는 경우 콘텐츠-콘텐츠 조회에서 콘텐츠 리스트 오른쪽 위에 있는 콘텐츠 등록 메뉴을 이용하여 콘텐츠를 등록할 수 있습니다.
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading" role="tab" id="faq05">
                <span class="faq-panel_headPoint">Q</span>
                <h4 class="panel-title">
                    <a role="button" data-toggle="collapse" data-parent="#accordion" href="#faqcollapse05"
                       aria-expanded="true" aria-controls="collapseOne">
                        병렬프로그램(MPI/OpenMP)을 사용하려면 어떻게 하나요?
                    </a>
                    <label>Data</label><label>Collection search</label>
                    <span class="faq-panel_date">2017-09-07</span>
                </h4>
            </div>
            <div id="faqcollapse05" class="panel-collapse collapse" role="tabpanel" aria-labelledby="faq05">
                <div class="panel-body">
                    개발머신의 텍스트 환경에서 $>module av 명령을 치면 사용할 수 있는 모듈을 확인 할 수 있습니다. 예를 들면, $>module add mpi/intel/mpich-1.2.7p1 명령으로 인텔 MPI 사용이 가능하며 $module li 명령으로 현재 로드된 모듈을 확인하실 수 있습니다.
                </div>
            </div>
        </div>

    </div>
</div>

</body>

<script src="<c:url value='/js/jquery/jquery-3.2.1.min.js'/>"></script>
<script src="<c:url value='/js/bootstrap/dist/js/bootstrap.min.js'/>"></script>

</html>