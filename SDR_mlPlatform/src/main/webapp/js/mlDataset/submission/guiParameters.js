var GuiParameters = function () {};

GuiParameters.prototype = function() {

    var _originValue = null;
    var _value = null;

    var init = function (guiParametersValue) {

        if(_originValue == null){

            if(guiParametersValue == null || guiParametersValue == ""){
                guiParametersValue = "{}";
            }

            _originValue = JSON.parse(JSON.stringify(guiParametersValue));
            _value = JSON.parse(JSON.stringify(guiParametersValue));
        }

        return this;
    };

    var originValue = function (key){

        if(key == null){
            return _originValue;
        }else{
            return _originValue[key];
        }
    };

    var value = function(key){

        if(key == null){
            return _value;
        }else{
            return _value[key];
        }
    };

    var toString = function(){
        return JSON.stringify(_value);
    };

    var labelRefresh = function(){
        _value = originValue();
    };

    var labelVerify = function(successCallback, failCallback){
        var result = true;
        var messageString = "";

        if(_value["output_columns_index_and_name"] == null
            || JSON.stringify(_value["output_columns_index_and_name"]) == "{}"){
            messageString = "Please select a target label.";

            result = false;
        } else if (_value["input_columns_index_and_name"] == null
            || JSON.stringify(_value["input_columns_index_and_name"]) == "{}"){
            messageString = "Please select feature lists.";

            result = false;
        }

        if(result == false){
            if(failCallback != null){
                failCallback(messageString);
            }
        }else{
            if(successCallback != null){
                successCallback();
            }
        }
    };

    var algorithmRefresh = function(){

        _value["kernel"] = "";
        _value["task"] = "";
        _value["algorithm"] = "";
        _value["analysis"] = [];
        _value["perf_eval"] = [];
        _value["hparams"] = {};
    };

    var algorithmVerify = function(successCallback, failCallback){
        var result = true;
        var messageString = "";

        if(_value["kernel"] == null
            || _value["kernel"] == ""){
            messageString = "Please select a kernel.";

            result = false;
        }else if (_value["task"] == null
            || _value["task"] == ""){
            messageString = "Please select a task.";

            result = false;
        }else if (_value["algorithm"] == null
            || _value["algorithm"] == ""){
            messageString = "Please select a algorithm.";

            result = false;
        }

        if(result == false){
            if(failCallback != null){
                failCallback(messageString);
            }
        }else{
            if(successCallback != null){
                successCallback();
            }
        }
    };


    var setInputColumns = function(value){
        _value["input_columns_index_and_name"] = value;
    };

    var setOutputColumns = function(value){
        _value["output_columns_index_and_name"] = value;
    };

    var setTestingRate = function(value){
        _value["testing_frame_rate"] = value;
    };

    var setTestingMethod = function(value){
        _value["testing_frame_extract_method"] = value;
    };

    var setKernel = function(value){
        algorithmRefresh();
        _value["kernel"] = value;
    };

    var setTask = function(value, controller){
        var kernel = _value["kernel"];

        algorithmRefresh();
        _value["kernel"] = kernel;
        _value["task"] = value;
    };

    var setAlgorithm = function(value){
        var kernel = _value["kernel"];
        var task = _value["task"];

        algorithmRefresh();
        _value["kernel"] = kernel;
        _value["task"] = task;
        _value["algorithm"] = value;
    };

    var setMapParams = function(paramName, key, value){

        _value[paramName][key] = value;
    };

    var setListParams = function(paramName, value){

        _value[paramName] = value;
    };

    return {
        "init": init,
        "originValue" : originValue,
        "value" : value,
        "toString" : toString,
        "labelRefresh" : labelRefresh,
        "labelVerify" : labelVerify,
        "algorithmRefresh" : algorithmRefresh,
        "algorithmVerify" : algorithmVerify,
        "setInputColumns" : setInputColumns,
        "setOutputColumns" : setOutputColumns,
        "setTestingRate" : setTestingRate,
        "setTestingMethod" : setTestingMethod,
        "setKernel" : setKernel,
        "setTask" : setTask,
        "setAlgorithm" : setAlgorithm,
        "setMapParams": setMapParams,
        "setListParams": setListParams
    }
}();