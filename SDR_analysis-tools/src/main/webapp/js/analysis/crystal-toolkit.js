var CrystalToolkit = Class.create({
	init: function(common) {
		this.common = common;
	},
	additionalWorkBeforeSubmission: function() {
		$("select[name=substitute]").each(function(i, e){
			$("option:not(:selected)", e).remove();
		});
		$(document).off("click", ".evtRemoveSubstitute");		
	},
    callIBPopup: function(){
        var that = this;
        AUI().use('aui-base','liferay-portlet-url','aui-node', function(A) {
            var returnURL = $("input[name=iBPopupURL]").val();
            Liferay.Util.selectEntity({
                dialog : {
                    modal : true,
                    width : 600,
					height : 400
                },
                id : 'iBPopup',
                title : 'Run Quantum Espresso Simulation',
                uri : returnURL
            }, function(event) {
				that.iBRun(event.title, event.description);
            });

        });
	},
    callIConfCreateBPopup: function(data1, data2){
        var that = this;
        AUI().use('aui-base','liferay-portlet-url','aui-node', function(A) {

            var outputFileName = $("input[name=outputFileName]").val();
            var beforeCondition = $("input[name=beforeCondition]").val();

            var portletNameiBPopup = $("input[name=portletNameiBPopup]").val();

            var portletURL = Liferay.PortletURL.createRenderURL();
            portletURL.setPortletMode("view");
            portletURL.setWindowState($("input[name=windowState]").val());
            portletURL.setPortletId($("input[name=themeDisplayId]").val());
            portletURL.setParameter("controller", "simulationPortletController");
            portletURL.setParameter("action", "iBConfCreatePopup");
            portletURL.setParameter("outputFileName", outputFileName);
            portletURL.setParameter("beforeCondition", beforeCondition);
            portletURL.setParameter("title", data1);
            portletURL.setParameter("desc", data2);

            Liferay.Util.selectEntity({
                dialog : {
                    modal : true,
                    width : 600,
                    height : 600
                },
                id : portletNameiBPopup,
                title : 'Simulate this material',
                uri : portletURL
            }, function(event) {
                that.iBRun(event.title, event.description);
            });

        });
    },
    iBRun: function(data1, data2) {
        var url = $("input[name=iBRunActionURL]").val();
        var outputFileName = $("input[name=outputFileName]").val();
        var beforeCondition = $("input[name=beforeCondition]").val();

        $('#iBForm [name="title"]').val(data1);
        $('#iBForm [name="description"]').val(data2);
        $('#iBForm [name="outputFileName"]').val(outputFileName);
        $('#iBForm [name="beforeCondition"]').val(beforeCondition);

        $('#iBForm').attr('action', url);
        $('#iBForm').submit();

		// var inputs = '<input type="hidden" name="title" value="'+ data1 +'" />';
		// 	inputs +='<input type="hidden" name="description" value="'+ data2 +'" />';
		// 	inputs +='<input type="hidden" name="outputFileName" value="'+ outputFileName +'" />';
		// 	inputs +='<input type="hidden" name="beforeCondition" value="'+ beforeCondition +'" />';
        //
		// jQuery('<form action="'+ url +'" method="post" target="ibRunFrame">'+inputs+'</form>').appendTo('body').submit().remove();
    },
	initEvents : function () {
		var that = this;

        $('#selectOperation').change(function() {
            var selected = $(this).val();

            if(selected == 0) {
                $(this).removeClass('upload');
                $('#edit-search-container').show();
                $('#edit-file-container').hide();
            }
            else if(selected == 1) {
                $(this).addClass('upload');
                $('#edit-search-container').hide();
                $('#edit-file-container').show();
            }
        });

        $(".btnSearchSubmit").click(function(){
        	
        	
        	if (!$('#selectOperation').hasClass("upload")) {
        		var datasetId = $("input[name=datasetId]").val();
        		datasetId = datasetId.replace(/\s/g, '');
        		$("input[name=datasetId]").val(datasetId);
        		if (!that.common.isNumber($("input[name=datasetId]").val())) {
        			that.common.errorMessage($("#errorMessage"), {text: "Please enter Dataset ID."});
        			return false;
        		}
        	}
        	
        	if ($('#selectOperation').hasClass("upload")) {
        		$("input[name=datasetId]").val("");
        		$("#condition").val("extract");
        	} else {
        		$("#condition").val("material");
        	}
        	$("#crystal-toolkit-form").submit();
        });
        
        $("input[name=datasetId]").keyup(function(e){
			if (e.keyCode == 13) {
				$(".btnSearchSubmit").trigger("click");
			} 
        });

        if ($.trim($("#condition").val()).length > 0 && $.trim($("#errorMessage").html()).length == 0) {
	        $.post($("input[name=elementsJsonURL]").val(), function(json){
                var data = json[0];
                var option = "";
                $.each(data, function(key, val){
                    option += '<option value="' + key + '">' + val +'</option>';
                });
				$(".evtSsubstituteSelect").append(option);
				var nowElement = "";
				$(".evtSsubstituteSelect").each(function(i, e){
					nowElement = $(e).attr("title");
					$(e).val(nowElement);
				});
			}, "json");
        }

		var changeEelement = new Array();

        var beforeChangeValue = "";
		$(".evtSsubstituteSelect").focus(function(){
			$("#condition").val("substitution");
			$("input[name=substituteFlag]").val("change");
            beforeChangeValue = $(this).val();
			changeEelement.push(beforeChangeValue);
		}).change(function(){
            var changedValue = $(this).val();
            var substituteValidation = false;
            $("select[name=substitute]").each(function(i, e){
				var selectedValue = $(e).attr("title");
				if (selectedValue === changedValue) {
                    substituteValidation = true;
				}
            });

            if (substituteValidation) {
            	$(this).val(beforeChangeValue);
                that.common.errorMessage($("#errorMessage"), {text: changedValue + " is already selected."});
                return false;
			}

			changeEelement.push($(this).val());
			$("input[name=changeEelement]").val(changeEelement);
			$("#crystal-toolkit-form").submit();
			that.additionalWorkBeforeSubmission();
		});

        $('#btnSupercellSubmit').click(function(){
			$("#condition").val("supercell");
			var supercell = new Array();
			var subcell = new Array();
			var check = true;
			$("input[name=supercell]").each(function(i, e){
				var val = $(e).val();

				if (!/\d/.test(val)) {
                    that.common.errorMessage($("#errorMessage"), {text: "Each cell must be greater than or equal to 0 and must be an integer."});
					check = false;
					return false;
				}

				if (i%4 == 0 && val < 1) {
                    that.common.errorMessage($("#errorMessage"), {text: "This value must be greater than one."});
                    $(e).focus();
                    check = false;
                    return false;
				}

				subcell.push(val);
				if (i % 3 == 2) {
					supercell.push(subcell);
					subcell = new Array();
				}
			});

			if (check) {
				var scale = JSON.stringify(supercell).split("\"").join("");
	            $("input[name=supercellData]").val(scale);
	            $("#crystal-toolkit-form").submit();					
			}
          });

        // Substitute 엘리먼트 추가
        $("#btnAddSubstitute").click(function(){
        	var $div = $('div[id^="substitute_"]:last');
        	var num = parseInt( $div.prop("id").match(/\d+/g), 10 ) + 1;
        	var $clone = $div.clone().prop("id", "substitute_"+num);
        	$clone.find('select[id^="selectSubstitute_"]').prop("id", "selectSubstitute_"+num).prepend("<option value='' selected='selected'>=선택=</option>");
        	$clone.find('button[id^="removeSubstitute_"]').prop("id", "removeSubstitute_"+num);
        	$div.after($clone);
        	$(this).attr("disabled", "disabled");
        });

		$(document).on("click", ".evtRemoveSubstitute", function(){
			if ($("select[name=substitute]").size() > 1) {
				$("#condition").val("substitution");
				$("input[name=substituteFlag]").val("remove");
				var id = $(this).attr("id").split("_")[1];
				var value = $("#selectSubstitute_" + id).val();
				$("input[name=removeEelement]").val(value);
				$("#substitute_" + id).remove();
				$("#crystal-toolkit-form").submit();
				$(document).off("click", ".evtRemoveSubstitute");
				that.additionalWorkBeforeSubmission();
			} else {
				alert("마지막 원소입니다.");
			}
		});

		$(document).on("click", ".IBRunBtn", function(){
			console.log('IBRunBtn click!!!!');
			var signedIn = $("input[name=isSignedIn]").val();
			console.log('signedIn ===>' + signedIn);
            that.callIConfCreateBPopup($("input[name=reducedformula]").val(), "");
			/*if(signedIn == "true") {
				//that.callIBPopup();
                if(confirm('Are you sure to submit a job ?'))
					that.iBRun($("input[name=reducedformula]").val(), "");
			} else {
				alert("Please Sign In First.");
			}*/
            
		});



		$("#evtDownloadSelect").change(function(){
			if ($(this).val().length > 0) {
				that.common.ajaxFileDownload(
							$("input[name=pythonFileDownloadURL]").val(),
							"condition=download&chooseFileFormat=" + $(this).val() + "&outputFileName=" + $("input[name=outputFileName]").val() + "&beforeCondition=" + $("input[name=beforeCondition]").val(),
							"post"
						);
			}
		});
	}
});

