var csvFunc =  {
    count : 0,
    readFileList : {},
    initCsvTable : function(container, dataPath, index){
        csvFunc.readFileList = dataPath;
        for(var i=0; i<csvFunc.readFileList.length; i++){
            $.ajax({
                type: "GET",
                url: csvFunc.readFileList[i].path,
                dataType: "text",
                success: function(data) {processData(data);}
            });

            function processData(data) {
                var allTextLines = data.replace(/\"/g,"").split(/\r\n|\n/);
                var headers = allTextLines[0].split(',');
                var result = [];
                //json array
                for(var i=1;i<allTextLines.length;i++){
                    var obj = {};
                    var currentline=allTextLines[i].split(",");

                    for(var j=0;j<headers.length;j++){
                        obj[headers[j]] = currentline[j];
                    }
                    result.push(obj);
                }
                csvFunc.createCsvTable(headers,result, container, dataPath, index);
            }
        }

    },
    createCsvTable : function (headers,resultData,container, dataPath, index) {
        csvFunc.readFileList = dataPath;
        var h = $( container ).height();
        var w = $( container ).width();
        var namespace="";
        var array = resultData;
        for(var i=0; i<csvFunc.readFileList.length; i++){
            var searchForms =
                '<div id="searchForms"><span><b>Search : </b></span><input id="search_field_'+index+'" type="search" placeholder="Search" class="form-control" style="display: inline;width:'+(w*0.3)+'px;">\n' +
                '<p style="display:inline-block"><span id="resultCount_'+index+'"><b>0</span> rows</b></p></div>\n';
            $(container).append(searchForms);
            var csvBody = '<div id="hot_'+index+'" width="'+w+'" height="'+(h-$("#searchForms").height())+'">\n</div>';
            $(container).append(csvBody);
        }

        //var searchResultCount = 0;
        //Search match column color change
        function searchResultCounter(instance, row, col, value, result) {
            const DEFAULT_CALLBACK = function(instance, row, col, data, testResult) {
                instance.getCellMeta(row, col).isSearchResult = testResult;
            };

            DEFAULT_CALLBACK.apply(this, arguments);
            /*if (result) {
                searchResultCount++;
            }*/
        }
        var editHeaders = [];
        for(var m=0; m < headers.length; m++){
            editHeaders.push({
                data: headers[m],
                editor: false
            })
        }
        var hotElement = document.querySelector('#hot_'+index);
        //var hotElementContainer = hotElement.parentNode;
        var hotSettings = {
            data: array,
            colHeaders: headers,
            columns: editHeaders,
            fillHandle: false,
            stretchH: 'all',
            width: w,
            autoWrapRow: true,
            height: h-50,
            maxRows: resultData.length,
            rowHeaders: true,
            columnSorting: {
                indicator: true
            },
            autoColumnSize: {
                samplingRatio: 23
            },
            manualRowResize: true,
            manualColumnResize: true,
            manualRowMove: true,
            manualColumnMove: true,
            //afterScrollVertically: compute_window, //laze load
            search: {
                callback: searchResultCounter
            }
        };
        var searchFiled4 = document.getElementById('search_field_'+index);
        var resultCount = document.getElementById('resultCount_'+index);
        resultCount.innerHTML = '<b>' + resultData.length.toString() + '</b>';
        var hot = new Handsontable(hotElement, hotSettings);
        //Search matching one data row filter
        var limitCnt = 100;
        var searhResultArr = [];

        function filter(search) {
            var row, r_len;
            var data = resultData;
            array = [];
            searhResultArr = [];
            for(row=0, r_len = data.length; row < r_len; row++){
                $.each(data[row], function(key, value){
                    if(('' + value).toLowerCase().indexOf(search) > -1) {
                        searhResultArr.push(data[row]);
                        return false;
                    }
                });
            }
            resultCount.innerHTML = '<b>' + searhResultArr.length.toString() + '</b>';
            var serarchCnt = searhResultArr.length;
            /*
            //laze load
            for(var k = 0; k<serarchCnt; k++){
               if(k  > limitCnt){
                    break;
                }
                var temp = searhResultArr.shift();
                array.push(temp);
            }
            */
            array = searhResultArr;
            hot.loadData(array);
        }
        //key event
        Handsontable.dom.addEvent(searchFiled4, 'keyup', function(event) {
            //searchResultCount = 0;
            filter(('' + this.value).toLowerCase());

            var search = hot.getPlugin('search');
            var queryResult = search.query(this.value);
            //resultCount.innerText = searchResultCount.toString();
            hot.render();
        });
        //laze load
        function compute_window(e) {
            var rowCount = hot.countRows();
            var rowOffset = hot.rowOffset();
            var visibleRows = hot.countVisibleRows();
            var lastRow = rowOffset + (visibleRows * 1);
            var lastVisibleRow = rowOffset + visibleRows + (visibleRows/2);
            var threshold = 15;

            if(lastVisibleRow > (rowCount - threshold)) {
                loadMoreData(rowCount);
            }
        };
        //laze load
        function loadMoreData(rowCount){
            for(var j = 0; j<searhResultArr.length; j++){
                if(j  > limitCnt){
                    break;
                }
                var temp = searhResultArr.shift();
                array.push(temp);
            }
            hot.render();
        }

    }
}
