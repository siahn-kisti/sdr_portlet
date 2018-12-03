var mlCommonUtil = function() {

    var sendPostAjax = function(console, url, formData, successCallback, failCallback){
        $.ajax({
            url: url,
            processData: false,
            contentType: false,
            data: formData,
            type: 'POST',
            success: function(result){
                var resultData = JSON.parse(result);
                if (resultData["code"] == 200){
                    console.log("SUCCESS"+resultData["code"]+": " + resultData["message"]);
                    if(successCallback != null){
                        successCallback(resultData);
                    }
                }else{
                    console.log("ERROR"+resultData["code"]+": " + resultData["message"])
                    if(failCallback != null){
                        failCallback(resultData["message"]);
                    }
                }
            },
            error:function(request,status,error){
                console.log(error);
                if(failCallback != null){
                    failCallback();
                }
            }
        });
    };

    var valueTypeConverter = function(value, valueType){
        var resultValue;

        if(valueType == null || valueType == "" || valueType == "String" || valueType == "string"){
            resultValue = value.toString();
        }else if(valueType == "Numeric" || valueType == "numeric"){
            resultValue = Number(value);
        }
        return resultValue;
    };

    return {
        sendPostAjax: sendPostAjax,
        valueTypeConverter: valueTypeConverter
    }

}();