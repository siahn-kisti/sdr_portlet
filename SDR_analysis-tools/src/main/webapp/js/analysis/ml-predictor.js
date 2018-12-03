var MLPredictor = Class.create({
	init : function(common) {
		this.common = common;
	},
	jsmolIsReady: function(applet) {
		var $appletDiv = $(Jmol._getElement(applet, "appletdiv"));
		var $appletInfoTableDiv = $appletDiv.parent();
        $appletInfoTableDiv.css("margin", "0 auto");
	},
	schemaSelect : function() {
		var that = this;
		var jsmolApplet0;
		var use = "HTML5";

		$.ajax({
			type : "post",
			url : $("#predictionDataJsonURL").val(),
			dataType : "json",
			data : $("#formPredictor").serialize(),
            beforeSend : function() {
                $("#poscar").val($("#poscar").val().trim());

                var s = document.location.search;
                Jmol.debugCode = (s.indexOf("debugcode") >= 0);
			},
			success : function(data) {
				var jsmolInfo = {
                    width : 535,
                    height : 497,
                    debug : false,
                    color : "#FFF",
                    addSelectionOptions : false,
                    use : "HTML5",
                    j2sPath : $("#contextPath").val() + "/jsmol/j2s",
                    readyFunction: that.jsmolIsReady,
                    script : "set antialiasDisplay;load " + data[1].jsmolURL,
                    disableJ2SLoadMonitor : true,
                    disableInitialConsole : true,
                    allowJavaScript : true
                };

				$("#mlPredictionDefault").hide();
				$(".ml-repeat-container").show();

				var jsmol1 = Jmol.getAppletHtml("jsmolApplet0", jsmolInfo);
                $("#mlPredictionJSMolOutput").html(jsmol1);

                //base properties
				if(data[0][0]!=undefined){
					var div = common.jsonToDiv(data[0][0], 'Base');
					$("#mlPredictionBaseOutput").html(div);
				}

				//battery properties
				if(data[0][1]!=undefined){
					div = common.jsonToDiv(data[0][1], 'Battery');
					$("#mlPredictionBatteryOutput").html(div);
                    $("#mlPredictionBatteryOutput").show();
				} else {
                    $("#mlPredictionBatteryOutput").hide();
				}
			},
			error : function(request, status, error) {
				console.log("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
			}
		});
	},	
	initEvents : function() {
		var that = this;
		
		$("#runPrediction").click(function(){
			that.schemaSelect();
		});
	}
});