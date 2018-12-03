<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<% pageContext.setAttribute("newLineChar","\n");%>
<style>
    #resultData { white-space: pre; font-family: monospace; }

    body {background: #F0F0F0;}


    h2 {margin-left: 55px;}

    textarea {
        margin-top: 10px;
        margin-left: 50px;
        width: 500px;
        height: 500px;
        -moz-border-bottom-colors: none;
        -moz-border-left-colors: none;
        -moz-border-right-colors: none;
        -moz-border-top-colors: none;
        background: none repeat scroll 0 0 rgba(0, 0, 0, 0.07);
        border-color: -moz-use-text-color #FFFFFF #FFFFFF -moz-use-text-color;
        border-image: none;
        border-radius: 6px 6px 6px 6px;
        border-style: none solid solid none;
        border-width: medium 1px 1px medium;
        box-shadow: 0 1px 2px rgba(0, 0, 0, 0.12) inset;
        color: #555555;
        font-family: "Helvetica Neue",Helvetica,Arial,sans-serif;
        font-size: 1em;
        line-height: 1.4em;
        padding: 5px 8px;
        transition: background-color 0.2s ease 0s;
    }


    textarea:focus {
        background: none repeat scroll 0 0 #FFFFFF;
        outline-width: 0;
    }
</style>
<h3>SDR Restful API result</h3>
<textarea spellcheck="false" id="resultBasicData">${resultData}</textarea>
<textarea spellcheck="false" id="resultData"></textarea>
<script>
    var obj = ${resultData};
    document.getElementById("resultData").appendChild(document.createTextNode(JSON.stringify(obj, null, 4)));
</script>

