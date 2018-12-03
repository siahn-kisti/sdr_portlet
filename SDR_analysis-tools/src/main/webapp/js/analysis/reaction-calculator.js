var ReactionCalculator = Class.create({
	init: function(common) {		
		this.common = common;
	},
    reactionCalculatorExcute: function(jsonData) {
        var that = this;

        var reaction = jsonData.reaction;
        var value1 = jsonData.value1;
        var value2 = jsonData.value2;
        var formationenergy = jsonData.formationenergy;

        // $(".expression").html($("#reactants").val() + "=" + $("#products").val());
        var reactions = reaction.replace(' ','').split('->');
        var expression = reactions[0] + "=" + reactions[1];

        $(".expression").html(expression.replace(/ /g, ''));
        $("#reactants").val(reactions[0].replace(/ /g, ''));
        $("#products").val(reactions[1].replace(/ /g, ''));

        $(".value1").html("(" + jsonData.value1.value.toFixed(2) + " " + jsonData.value1.unit + ")");
        $(".value2").html(jsonData.value2.value.toFixed(2) + " " + jsonData.value2.unit);

        var tBody = $("<tbody>");
        $.each(jsonData.formationenergy, function (key, value) {
            var tTr = $("<tr>");
            tTr.append("<td>" + key + "</td>");
            tTr.append("<td>" + value.toFixed(2) + "</td>");
            tBody.append(tTr);
        });

        $("#reactionCalculatorFormationEnergies").html(tBody.children("tr"));

        $("#blockReactionCalculatorResult").show();
    },
    reactionCalculatorRequest: function() {
        var that = this;
        var jsonData = "";

        $.ajax({
            url: $("#calculateDataJsonURL").val(),
            type : "GET",
            data : $("#reactionCalculatorForm").serialize(),
            success : function(data){
                jsonData = $.parseJSON(data)[0];
                if (jsonData.error != undefined) {
                    if ($.trim(jsonData.error) == "???") {
                        that.common.errorMessage($("#errorMessage"), { text: "No results were found for your search." });
                        return false;
                    } else {
                        that.common.errorMessage($("#errorMessage"), { text: jsonData.error });
                    }
                    $("#blockReactionCalculatorResult").fadeOut();
                } else {
                    that.reactionCalculatorExcute(jsonData);
                    $("#blockReactionCalculatorResult").fadeIn();
                }
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){
                alert(errorThrown);
                alert(textStatus);
            }
        });
    },
    reactionCalculatorValidation: function(reactants, products) {
        if (/[^A-Za-z0-9+]/.test(reactants)) {
            $("#reactants").focus();
            $("#blockReactionCalculatorResult").hide();
            this.common.errorMessage($("#errorMessage"), { text: "Reactants allow only the elements." });
            return false;
        }

        if (/[^A-Za-z0-9]/.test(products)) {
            $("#products").focus();
            $("#blockReactionCalculatorResult").hide();
            this.common.errorMessage($("#errorMessage"), { text: "Products allow only the elements." });
            return false;
        }

        this.reactionCalculatorRequest();
    },
	initEvents : function () {

		var that = this;

        $("#btnSubmit").click(function(){
            $("#blockReactionCalculatorResult").hide();
            var reactants = $("#reactants").val();
            reactants = reactants.replace(/\s/g, '');
            $("#reactants").val(reactants);
            
            var products = $("#products").val(); 
            products = products.replace(/\s/g, '');
            $("#products").val(products);
            that.reactionCalculatorValidation($("#reactants").val(), $("#products").val());
        });
	}
});