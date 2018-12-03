
var plotMarginWidth;
var plotMarginHeight;
var readFileList = {};
var mainContainer;
var d3 = Plotly.d3;
var gd;

var plotDataArray = [];
var plotDataCount = 0;


createChart = function (container, dataPath) {
  
  readFileList = dataPath;

  // Create Div
  $(container).append($('<div />', 
                        { 'class' : 'nav-tabs-custom', 'style' : 'margin-bottom : 0px'})
              .append($('<ul />', { 'class' : 'nav nav-tabs', 'role' : 'tablist' }))
              .append($('<div />', { 'class' : 'tab-content'}))
  );


  for (var i = 0; i < dataPath.length; i++) { // data.length = 6
    var tab_num = i;
    var tabString = '#nav_tap_' + tab_num;
    var tabContentID = 'tap_' + tab_num;

    readFileList[i].tabID = tabString; // #nav_tap_1 ~ 6
    readFileList[i].tabContentID = tabContentID; // tap_1 ~ 6

    if(i==0) {
      $('.nav-tabs').append($('<li />',{ 'class' : 'nav-item active'})
                    .append($('<a />',{ 'id': 'nav_tap_' + tab_num, 'class' : 'nav-link active show', 'href' : '#tap_' + tab_num, 'data-toggle' : 'tab' })
                    .html(dataPath[i].text)));

      $('.tab-content').append($('<div />',
                                  { 'role' : 'tabpanel', 'class' : 'tab-pane nav-item active', 'id' : tabContentID }));
    } else {
      $('.nav-tabs').append($('<li />', { 'class' : 'nav-item' })
                    .append($('<a />',{ 'id': 'nav_tap_' + tab_num, 'class' : 'nav-link', 'href' : '#tap_' + tab_num, 'data-toggle' : 'tab' })
                    .html(dataPath[i].text)));

      $('.tab-content').append($('<div />',{ 'role' : 'tabpanel', 'class' : 'tab-pane nav-item', 'id' : tabContentID }));
    }
  }
  
  $('.nav-tabs').append($('<li />', { 'class' : 'dropdown ml-auto show'})
          			.append($('<a />', { 'class' : 'dropdown-toggle', 'data-toggle' : 'dropdown', 'href': '#', 'aria-expanded' : 'true'})
          				.append($('<i />', { 'class' : 'fa fa-gear'}))
          			)
          			.append($('<ul />', { 'class' : 'dropdown-menu show', 'style' : 'z-index : 1040; right : 0; left : auto;'})
          				.append($('<div />', { 'class' : 'content', 'style' : 'min-height : 0'}))
          			)
              	 );

  mainContainer = container;
  
  plotMarginWidth = parseInt($(mainContainer).css("padding-right"))
   + parseInt($(mainContainer).css("padding-left"))
   + parseInt($('.tab-content').css("padding-right"))
   + parseInt($('.tab-content').css("padding-left"));


  plotMarginHeight = parseInt($(mainContainer).css("padding-top"))
    + parseInt($(mainContainer).css("padding-bottom"))
    + parseInt($('.tab-content').css("padding-top"))
    + parseInt($('.tab-content').css("padding-bottom"));

  $(container).on("change", "select", function() {
    var selectOption =  $(this).find(":selected").text();
    var getAxis = $(this).get(0).id.split('_')[1];
    var getTabIDNum = $(this).get(0).id.split('_')[2];

    for (var i = 0; i < plotDataArray.length; i++) {
      if (plotDataArray[i].tabIDNum == getTabIDNum ) {
        if (plotDataArray[i].plotType == '2D') {
          if (getAxis == 'x') {
            plotDataArray[i].plotData[0].x = plotDataArray[i][selectOption];
            plotDataArray[i].plotLayout.xaxis.title = selectOption;
            plotDataArray[i].plotLayout.title = selectOption + " vs " + plotDataArray[i].plotLayout.yaxis.title;
            Plotly.update(plotDataArray[i].divClass, plotDataArray[i].plotData, plotDataArray[i].plotLayout );

          } else if (getAxis == 'y') {
              plotDataArray[i].plotData[0].y = plotDataArray[i][selectOption];
              plotDataArray[i].plotLayout.yaxis.title = selectOption;
              plotDataArray[i].plotLayout.title = plotDataArray[i].plotLayout.xaxis.title + " vs " + selectOption;
              Plotly.update(plotDataArray[i].divClass, plotDataArray[i].plotData, plotDataArray[i].plotLayout );
          }


        } else if (plotDataArray[i].plotType == '3D') {
          if (getAxis == 'x') {
            plotDataArray[i].plotData[1].x = plotDataArray[i][selectOption];
            Plotly.update(plotDataArray[i].divClass, plotDataArray[i].plotData, plotDataArray[i].plotLayout );

          } else if (getAxis == 'y') {
              plotDataArray[i].plotData[1].y = plotDataArray[i][selectOption];
              Plotly.update(plotDataArray[i].divClass, plotDataArray[i].plotData, plotDataArray[i].plotLayout );
          } else if (getAxis == 'z') {
              plotDataArray[i].plotData[0].z = plotDataArray[i][selectOption];
              Plotly.update(plotDataArray[i].divClass, plotDataArray[i].plotData, plotDataArray[i].plotLayout );
          }
        }
      }
    }
  });
  
  for (var i = 1; i < readFileList.length; i++) {
	    $(readFileList[i].tabID).one( "click", function() {
	      var clickTagNum = this.id.slice(-1);
	      getCFDData(readFileList[clickTagNum].path ,readFileList[clickTagNum].tabContentID );

	    });
	  }
  for (var i = 0; i < readFileList.length; i++) {
    $(readFileList[i].tabID).click( function() {
      var clickTagNum = this.id.slice(-1);
      subTapControll(clickTagNum);
      resizeLayout(clickTagNum);
    });

  }
	  
//  for(var i = 0; i < readFileList.length;  i++){
//      getCFDData(readFileList[i].path , readFileList[i].tabContentID );
//  }
  getCFDData(readFileList[0].path , readFileList[0].tabContentID );
};


resizeLayout = function (clickTagNum){
  var plotDataFlag = false;

  for (var i = 0; i < plotDataArray.length; i++) {
    //plotDataArray[i]
    if (plotDataArray[i].tabIDNum == clickTagNum) {
      plotDataFlag = true;
    }
  }
  if (!plotDataFlag){ return -1; }

  var gd3 = d3.select('#tap_'+clickTagNum + '> div');
  gd = gd3.node();
  if (!gd) { return -1; }

  var h = $( mainContainer ).height();
  var w = $( mainContainer ).width();

  var update = {
    width: w - plotMarginWidth,
    height: h - plotMarginHeight - $('.nav-tabs').height()
  };
  Plotly.relayout(gd, update);
}

subTapControll = function (clickTap){
  for (var i = 0; i < readFileList.length; i++) {
    $('#sub_tap_'+i).css("display", 'none' );
    if (clickTap == i) {
      $('#sub_tap_'+i).css("display", '' );
    }
  }
};

/*$(function() {
  for (var i = 1; i < readFileList.length; i++) {
    $(readFileList[i].tabID).one( "click", function() {
      var clickTagNum =this.id.slice(-1);
      getCFDData(readFileList[clickTagNum].path ,readFileList[clickTagNum].tabContentID );

    });
  }
  for (var i = 0; i < readFileList.length; i++) {
    $(readFileList[i].tabID).click( function() {
      var clickTagNum =this.id.slice(-1);
      subTapControll(clickTagNum);
      resizeLayout(clickTagNum);
    });


  }

});*/

select_option = function  (tab_index, div_class, selectOption ) {
  $("#sub_tap_" + tab_index +" > ." + div_class + " > select option:eq(" +selectOption+ ")")
    .attr("selected", "selected");
}

createSubTab = function (tab_num, plotType){
  $('.dropdown-menu > div').append($('<form />', { 'role' : 'form', 'id' : 'sub_tap_' + tab_num}));
  

  $('#sub_tap_'+tab_num ).append($('<div />', {'class' : 'form-group x_axis', })
                        .append($('<label />').html('Select x axis')));

  $('#sub_tap_'+tab_num ).append($('<div />', {'class' : 'form-group y_axis'})
                      .append($('<label />').html('Select y axis')));

  $('#sub_tap_'+tab_num +'> .x_axis')
        .append($('<select />', { 'class' : 'form-control', 'id':'select_x_' + tab_num}));

  $('#sub_tap_'+tab_num +'> .y_axis')
        .append($('<select />', {'class' : 'form-control', 'id':'select_y_' + tab_num}));

  if (plotType == '3D') {
    $('#sub_tap_'+tab_num ).append($('<div />', {'class' : 'form-group z_axis'})
                        .append($('<label />').html('Select z data')));
    $('#sub_tap_'+tab_num +'> .z_axis')
          .append($('<select />', {'class' : 'form-control', 'id':'select_z_' + tab_num}));
  }
//  $('#sub_tap_'+tab_num +'> .x_axis')
//        .append($('<select />', {'class' : 'form-control', 'id' : 'select_x_' + tab_num}));


}

readCFDData = function (data, class_path){
  var datas = data.trim().split(/[\s,="']+/);
  //console.log(datas);
  var mode = 0;

//    console.log(datas);
  var colum_val =[];
  var zone = {};
  var zone_val = [];
  var zone_keys = [];
  var trace = {};
  var x_langth, y_langth;
  var r = 0;
  var plotType = '2D';

  if (!datas[0].toLowerCase().match(/^variables/)) {

    var lines = data.split('\n');

    for (var qq = 0; qq < lines.length; qq++) {
      var getId = '#tap_' + class_path.slice(-1);
      $(getId).append($('<p />').html(lines[qq]));
    }
//        return 0;
  } else { // plot3D type
    for(var i = 0; i < datas.length; i++) {
      if (datas[i].toLowerCase().match(/^variables/)) {
        var j = 0;
        while(!datas[i+1].toLowerCase().match(/^zone/)){
          i = i + 1;
          //console.log(datas[i])
          var replaced = datas[i].replace(/\W*/g,'').toLowerCase();
          //console.log(replaced)
          if ( replaced ) {
            colum_val[j++] = replaced;
          }
        }
      } else if (datas[i].toLowerCase().match('zone')){
        i=i+1;
        var j = 0;
        var key = "";
        var value = "";
        var i_flag = false, j_flag = false;

        //console.log(datas[i]);
         //숫자가 나올 때까지
        try {
            while ( datas[i].replace(/\W+/g,'').match(/^[a-zA-Z]/) ) {
                var key = datas[i].replace(/\W+/g,'').toLowerCase();
                var value = "";
                while ( ! value ) {
                    value = datas[++i].replace(/\W+/g,'').toLowerCase();
                }
                if( key.match(/[i]/)){
                    zone[key] = parseInt(value);
                    i_flag = true;
                } else if( key.match(/[j]/)){
                    zone[key] = parseInt(value);
                    j_flag = true;

                } else if ( key.match(/[tf]/)) {
                    zone[key] = value;
                }

                i++;
            }
        }catch(err) {
            console.log(err.message);
            alert("rlt2chart : There are no numbers.");
        }
        i--;

        if (i_flag && j_flag ) {
          plotType = '3D';
        } else {
          plotType = '2D';

          for (var p = 0; p < colum_val.length; p++) {
            trace[colum_val[p]] = new Array();
          }
        }
      } else {     //read data
        if (plotType == '2D'){
          for (var p = 0; p < colum_val.length; p++) {
            trace[colum_val[p]][r] = parseFloat(datas[i++]);
          }
          i--;
          r++;
        } else {
          return -1;
        }
      }
    }

    trace.zone = zone;
    trace.varlist = colum_val;
    trace.plotType = plotType;

    if (trace.plotType.match('2D')) {
      var x_flag = true, y_flag = true;
      var tab_index = class_path.slice(-1);

      createSubTab(tab_index, trace.plotType);

      for (var kk = 0; kk < colum_val.length; kk++) {
        $('#sub_tap_'+ tab_index + ' select')
          .append($('<option />',{'value' : kk}).html(colum_val[kk]));
      };

      //init select_option x,y
      select_option(tab_index, 'x_axis', 0);
      select_option(tab_index, 'y_axis', 1);

      var trace1  = {
        type: 'scatter',
        x: trace[colum_val[0]],
        y: trace[colum_val[1]]
      };
      var data2 = [trace1];

      //var h = $( window ).height();
      //var w = $( window ).width();
      var h = $( mainContainer ).height();
      var w = $( mainContainer ).width();

      var layout = {
        width: w - plotMarginWidth,
        height: h - plotMarginHeight - $('.nav-tabs').height(),
        //width: w,
        //height: h,
        margin: {
          t: 20
        },
        title: colum_val[0] + ' vs ' + colum_val[1],
        xaxis: {
          title: colum_val[0]
        },
        yaxis: {
          title: colum_val[1]
        }
      };

      var gd3 = d3.select('#'+class_path).append('div');

      gd = gd3.node();


    } else {
      return -1;
    }

    trace.clickCount = plotDataCount;
    trace.divClass = gd;
    trace.tapID = class_path;
    trace.tabIDNum = class_path.slice(-1);
    trace.plotData = data2;
    trace.plotLayout = layout;

    Plotly.plot(trace.divClass, trace.plotData, trace.plotLayout);
    plotDataArray[plotDataCount++] = trace;

  }
}

getCFDData = function (url_path, class_path){
  $.ajax({
    url: url_path,
    success: function (data){
      readCFDData(data, class_path);
    }
  });
}

