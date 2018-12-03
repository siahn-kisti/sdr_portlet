var d3 = Plotly.d3;
var gd;

var container;

window.onresize = function() {
    var h = window.innerHeight - 45;
    var w = window.innerWidth;

    var update = {
        width: w,
        height: h
    };

    Plotly.relayout(gd, update);
};


textToOneDObj = function(data){
    var objData = {};
    var layout = {};
    var xaxis = {};
    var yaxis = {};
    var field = [];
    var lines = data.split('\n');

    for(var i = 0; i < lines.length; i++){
        if (lines[i][0] == '#'){
            var tempHeaderKey = lines[i].split(':')[0].split('#')[1].trim();

            if (tempHeaderKey =='NumField') {
                objData.numField = lines[i].split(':')[1].trim();

            } else if (tempHeaderKey == 'LabelX') {
                xaxis.title = lines[i].split(",")[0].split(":")[1].trim();
                yaxis.title = lines[i].split(",")[1].split(":")[1].trim();

            } else if (new RegExp(/^Field/).test(tempHeaderKey) ) {
                var tempField = {};

                tempField.name = lines[i].split(",")[0].split(":")[1].trim();      //field별 이름 및 라인값 저장
                tempField.length = lines[i].split(",")[1].split(":")[1].trim();
                tempField.x = [];
                tempField.y = [];
                tempField.type = 'scatter';

                // read x, y data
                var k = 1;
                // 다음 필드가 나올때 까지 x,y  데이터 읽기
                while ( !(lines[i+k][0] == '#')  ) {
                    // x,y 데이터가 들어 있지 않는 라인을 제외하고  x,y 데이터 읽기
                    if(lines[i+k].trim() != '' ) {
                        //공백이 여려줄인 경우 replace(정규 표현식)을 이용 하나의 공백으로 치환
                        tempField.x.push(parseFloat(lines[i+k].trim().replace(/ +/g, " ").split(' ')[0]));
                        tempField.y.push(parseFloat(lines[i+k].trim().replace(/ +/g, " ").split(' ')[1]));
                    }
                    // 다음 라인을 읽기 위한 k 값 증가
                    k++;
                    // 파일끝인 경우  while 문 중단
                    if( i+k >= lines.length){
                        break;
                    }
                }
                // x,y 데이터 이후 라인을 읽을 수 있도록 i 값 재설정
                i = i+k-1;

                // 파싱한 x,y 데이터를 oneD 객체에 저장
                field.push(tempField);
            }    // else if (new RegExp(/^Field/).test(tempHeaderKey) )  종료
        }    //if (lines[i][0] == '#') 종료
    }  // for(var i = 0; i < lines.length; i++) 종료

    layout.width =  window.innerWidth;
    layout.height =  window.innerHeight - 45;
    layout.margin = {t:40 };

    xaxis.exponentformat = "e";
    xaxis.mirror = true;
    xaxis.linewidth = 1;
    xaxis.zeroline = false;

    yaxis.exponentformat = "e";
    yaxis.mirror = true;
    yaxis.linewidth = 1;
    yaxis.zeroline = false;

    layout.xaxis = xaxis;
    layout.yaxis = yaxis;

    objData.data = field;
    objData.layout = layout;

    return objData;

}  //textToOneDObj : function(data) 함수 종료


readOned = function (data){
    var oneDFile = textToOneDObj(data);

    var gd3 = d3.select('#plotDiv');

    gd = gd3.node();
    oneDFile.divClass = gd;

    Plotly.newPlot(gd, oneDFile);

   var update = {
        width: $(container).width(),
        height: $(container).height()-$("#selectForm").height()
    };

    Plotly.relayout(gd, update);
}

getOneD = function (url_path){
    var request = new XMLHttpRequest();
    request.open('GET', url_path, true);

    request.onload = function() {
        if (request.status >= 200 && request.status < 400) {
            // Success!
            readOned(request.responseText);
        } else {
            // We reached our target server, but it returned an error
        }
    };
    request.onerror = function() {
        // There was a connection error of some sort
    };
    request.send();
}

/**
 * OSP Analyzer function
 */
function drawOneDViewer(serveResourceUrl){
//	console.log("[oneDPlotly] laod data 1 ", inputData);
//	console.log("[oneDPlotly] laod data 1 ", serveResourceUrl);
    getOneD(serveResourceUrl);
}

function drawOneDExample(){
//	console.log("[oneDPlotly] drawOneD example 1 ");
    getOneD('./CB1.oneD');
}

//drawOneDViewer('./CB1.oneD');


/**
 * Create OneD Viewer function
 */
function createOneDViewer(containerParam, dataPath){
    container = containerParam;
    if(dataPath.length > 1){
        $(container).append($('<div/>', {'id':'selectForm'})
            .append($('<label />',{ 'text' : 'Select plotly  :', 'for' : 'plotSelect'}))
            .append($('<select />',{ 'id' : 'plotSelect', 'class' : 'form-control', 'style':'display:inline;width:400px;margin-left:50px;'}))
        );

        for(var count = 0; count < dataPath.length; count++){
            var option = $("<option value='"+dataPath[count].path+"'>"+dataPath[count].text+"</option>");
            $('#plotSelect').append(option);
        }
    }
    // Create Div
    $(container).append($('<div />',{ 'id' : 'plotDiv'}));
    drawOneDViewer(dataPath[0].path);
}
$(document).on('change', '#plotSelect', function() {
    drawOneDViewer($( "#plotSelect option:selected" ).val());
});