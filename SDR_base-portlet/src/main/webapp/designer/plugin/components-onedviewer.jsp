<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <link class='onedviewer-script' href='<%=request.getContextPath()%>/js/bootstrap/4.0.0/bootstrap.min.css' rel='stylesheet'>
    <link class='onedviewer-script' href='<%=request.getContextPath()%>/designer/css/editor.css' rel='stylesheet'>
    <link class='onedviewer-script' href='<%=request.getContextPath()%>/js/font-awesome/font-awesome.min.css' rel='stylesheet'>

    <script src="<%=request.getContextPath()%>/js/jquery/jquery-3.2.1.min.js"></script>
    <%--<script class='rlt2chart-script' src='<%=request.getContextPath()%>/js/bootstrap/4.0.0/popper.min.js' type='text/javascript'></script>--%>
    <script class='onedviewer-script' src='<%=request.getContextPath()%>/js/rlt2chart/popper.min.js' type='text/javascript'></script>
    <script class='onedviewer-script' src='<%=request.getContextPath()%>/js/rlt2chart/plotly-latest.min.js' type='text/javascript'></script>
    <script class='onedviewer-script' src='<%=request.getContextPath()%>/js/onedviewer/onedviewer.js' type='text/javascript'></script>
    <script class='onedviewer-script' src='<%=request.getContextPath()%>/js/bootstrap/4.0.0/bootstrap.min.js' type='text/javascript'></script>

</head>
<body style="background-color: white">
    <div id="onedviewer"></div>
    <script>
        var dataPath = new Array();
        var path = decodeURIComponent("${param.path}");
        var text = decodeURIComponent("${param.text}");
        var multiPath = decodeURIComponent("${param.multiPath}");
        if(text.indexOf('*') > -1) {
            var index = path.indexOf('SDR_baseportlet_path');
            var oldPath = path.substring(0, index+21);
            var newPath = path.substring(index+21);
            var multiDatasetPath = multiPath + newPath;
            $.ajax({
                url: multiDatasetPath,
                type: 'GET',
                dataType: 'json',
                success: function(data){
                    for(var i in data){
                        var fileName = data[i].fileName;
                        var filePath = oldPath + data[i].filePath;
                        dataJson = { 'text': fileName, 'path': filePath };
                        dataPath.push(dataJson);
                    }
                    createOneDViewer(document.querySelector("#onedviewer"), dataPath);
                },
                error: function() { alert('File Path Error!!!');}
            });
        }else{
            var dataJson = { 'text': text, 'path': path };
            dataPath.push(dataJson);
            createOneDViewer(document.querySelector("#onedviewer"), dataPath);
        }

    </script>
</body>
</html>

