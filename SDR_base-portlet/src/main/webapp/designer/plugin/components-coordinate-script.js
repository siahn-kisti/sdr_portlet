

var coord = {
    coordinateValue : '',

    init : function(metadata, title, column, index){
        $('#coordinate_'+index).html(coord.createTable(metadata,title,column));
    },

    createTable: function(metadata,title, column){
        var returnStr = "";
        var jsonData = metadata;
        var labelName = String(title);
        var locationName = String(column);
        //var metadata = "coordinate";
        /*if(data == ""){
            returnStr = "No metadata was created because it does not exist.";
            return returnStr;
        }else{
            jsonData = JSON.parse(JSON.stringify(metadata));
        }*/
        var jsonList = [];
        for (var i=0; i<jsonData.metadata.length; i++){
            jsonList.push(jsonData.metadata[i]);
        }
        /* ================ label을 key로 하는 map 형태로 전환 ================ */
        var map = new Map();
        jsonList.forEach(function(roof){
            var label = roof.label;
            if(map.has(label)){
                var list = map.get(label);
                list.push(roof.value);
                map.delete(label);
                map.set(label, list);
            }else{
                var emptyList = [];
                emptyList.push(roof.value);
                map.set(label, emptyList);
            }
        });

        /* ================ div 만들기 ================ */
        var labelNameFlag = (labelName == "")? true:
            (labelName == 'undefined')? true:
            (labelName == null)? true:false;
        var labelArr = [];
        var labelLength = 0;
        if(!labelNameFlag) {
            labelArr = (labelName.indexOf(",") >= 0) ? labelName.split(",") : new Array(labelName);
            labelLength = labelArr.length;
        }

        var locationNameFlag = (locationName == "")? true:
            (locationName == 'undefined')? true:
            (locationName == null)? true:false;
        var locationArr = [];
        var locationLength = 0;
        if(!locationNameFlag){
            locationArr = (locationName.indexOf(",") >= 0) ? locationName.split(",") : new Array(locationName);
            locationLength = locationArr.length;
        }

        var count = 0;
        for(var [key , value] of map){
            var locationList = map.get(key);
            returnStr += "<div class=\"element_wrapper\">\n";
            var label = "";
            if(!labelNameFlag){
                if(count >= labelLength) label = key;
                else label = labelArr[count];
            }else{
                label = key;
            }
            returnStr += "<h1 class=\"element_name\">"+ label +"</h1>\n"
                + "<table class=\"coordinate\">\n"
                + "	<thead>\n"
                + "		<tr>\n";
            var locationCount = locationList[0].length; // 행 수
            var defaultLocation = new Array("a","b","c","d","e","f","g","h");
            for(var i=0; i<locationCount; i++){
                var pos = "";
                var className = "";
                if(!locationNameFlag){
                    if(i >= locationLength) pos = defaultLocation[i];
                    else pos = locationArr[i];
                }else{
                    pos = defaultLocation[i];
                }
                if(i == (locationCount-1)) className = "class=\"table_last-child\"";
                returnStr += "			<th "+className+">"+ pos +"</th>\n";
            }
            returnStr += "		</tr>\n";
            returnStr += "	</thead>\n";
            returnStr += "	<tbody>\n";

            var listSize = locationList.length;
            for(var i=0; i<listSize; i++){
                returnStr += "		<tr>\n";
                var deps3List = locationList[i];
                var deps3Size = deps3List.length;
                for(var j=0; j<deps3Size; j++){
                    var className = "";
                    if(j == (deps3Size-1)) className = "class=\"table_last-child\"";

                    var locationValue = deps3List[j].toFixed(3);
                    returnStr += "			<td "+className+">"+ locationValue +"</td>\n";
                }
                returnStr += "		</tr>\n";
            }
            returnStr += "	</tbody>\n";
            returnStr += "</table>\n";
            returnStr += "</div>\n";

            count++;
        }
        return returnStr;
    }
};