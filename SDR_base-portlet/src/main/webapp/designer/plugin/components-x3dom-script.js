var onExitFrame = function(){
    var currentFPS = this.fps.toFixed(2);
    document.getElementById("fps_"+x3domFunc.index).innerHTML     = "FPS "  + currentFPS;
}

var x3domFunc =  {
    count : 0,
    readFileList : {},
    index : 0,
    createX3dom : function (container, dataPath, index) {
        x3domFunc.readFileList = dataPath;
        var h = $( container ).height();
        var w = $( container ).width();
        var namespace="";
        for(var i=0; i<x3domFunc.readFileList.length; i++){
            var inputHTML =
                '<img src="" class="dropdownImg"/>'+
                '<div style="display:none;text-align:center;width:120px;margin: 5px;background-color:rgba(0, 0, 0, 0.68);position:absolute;z-index: 1000;">' +
                '<p style="color:white;margin:0px;padding:1px;font-size: 1.5em;" id="fps_'+index+'"></p>' +
                '<button id="rvButton_'+index+'" class="ui-button" title="reset camera to initial position">Reset View</button></div>'+
                '<x3d id="x3dElement_'+index+'" width="'+w+'" height="'+h+'">\n' +
                '<scene>\n' +
                '<Viewpoint id="right" position="-2.43383 1.07351 -1.28700" orientation="-0.00318 -0.99950 -0.03159 2.06609" description="camera"></Viewpoint>'+
                '<Viewpoint id="left" position="2.70190 1.05153 -0.57128" orientation="-0.08205 0.99612 -0.03175 1.73722" description="camera"></Viewpoint>\n'+
                '<Viewpoint id="front" position="-0.07427 0.95329 -2.79608" orientation="-0.01451 0.99989 0.00319 3.15833" description="camera"></Viewpoint>\n'+
                '<Viewpoint id="top" position="0.05087 3.78235 -1.75890" orientation="-0.00307 0.87466 0.48473 3.12040" description="camera"></Viewpoint>'+
                '<Transform><Inline nameSpaceName="'+namespace+'" mapDEFToID="true" url="'+x3domFunc.readFileList[i].path+'" onclick="x3domFunc.objectClick(event);"/></Transform>\n' +
                '</scene>\n' +
                '</x3d>';
            $(container).append(inputHTML);
            x3dom.reload();
        }
        x3domFunc.index = index;

    },
    objectClick : function (event) {
        if (x3domFunc.count == 0) document.getElementById('left').setAttribute('set_bind', 'true');
        if (x3domFunc.count == 1) document.getElementById('right').setAttribute('set_bind', 'true');
        if (x3domFunc.count == 2) document.getElementById('front').setAttribute('set_bind', 'true');
        if (x3domFunc.count == 3) document.getElementById('top').setAttribute('set_bind', 'true');
        x3domFunc.count++;
        if (x3domFunc.count == 4) x3domFunc.count = 0;
    }

};

document.onload = function()
{
    var x3dElement = document.getElementById('x3dElement_'+x3domFunc.index);
    if(x3dElement) x3dElement.runtime.exitFrame = onExitFrame;
    $( ".ui-button" ).click(function( event ) {
            event.preventDefault();
            console.log($(this).attr("id").replace('rvButton_',''));
            var tempIndex = $(this).attr("id").replace('rvButton_','');
            document.getElementById('x3dElement_'+tempIndex).runtime.resetView();
     });
};


