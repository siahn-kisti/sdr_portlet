var NanoporousExplorer = Class.create({
    init: function (common) {
        this.common = common;
    },
    initPeriodic: function (that, searchValue) {
        $("button[class^=pt-color]").each(function (i, e) {
            var num = parseInt($(e).prop("class").match(/\d+/g), 10);
            if ($.inArray($(e).find("h5").text(), searchValue) >= 0) {
                $(e).toggleClass("pt-color-" + that.common.addZero(num, 2) + "-active");
            }
        });
    },
    nanoporousExplorerSubmit: function () {
        var condition = $("#condition").val();
        var val = $("#searchValue").val();

        if (condition == "elements") {
            if ($.trim(val).length > 0) {
                var valArr = val.split(/\s*,\s*/g);
                if (valArr.length < 1) {
                    this.common.errorMessage($("#errorMessage"), {text: "Please use the Periodic Table below."});
                    return false;
                }
            } else {
                this.common.errorMessage($("#errorMessage"), {text: "Please use the Periodic Table below."});
                return false;
            }
        } else if (condition == "reducedformula" && (/[^A-Za-z0-9]/g.test(val) || val == "")) {
            this.common.errorMessage($("#errorMessage"), {text: "Please enter a formula."});
            return false;
        } else if (condition == "extract" && $.trim($("#extractFile").val()).length == 0) {
            this.common.errorMessage($("#errorMessage"), {text: "Please enter the file."});
            return false;
        }

        $("#formNanoporousExplorer").submit();
    },
    initEvents: function () {
        console.log(1);
        var that = this;
        var searchValue = $("#searchValue").val().split(/\s*,\s*/g);
        this.initPeriodic(that, searchValue);

        if ($("#condition").val() == "extract") {
            $("#searchValue").val("");
            $("#searchValue").hide();
            $("#extractFile").show();
        }

        $("#btnSearch").click(function () {
            that.nanoporousExplorerSubmit();
        });

        $("#searchValue").keyup(function (e) {
            var val = e.currentTarget.defaultValue;
            if (e.keyCode == 13) {
                $("#btnSearch").trigger("click");
            } else if ($("#condition").val() == "elements") {
                that.common.errorMessage($("#errorMessage"), {
                    text: "Please use the Periodic Table below."
                });
                $(this).val(val);
            }
        });

        $("#btnReset").click(function () {
            $("#condition").prop("selectedIndex", 0);

            $("#searchValue").val("");
            $("#searchValue").show();
            $("#searchValue").attr("placeholder", "Ca,C,O");
            $("#extractFile").hide();

            that.periodicTableClear();
        });

        $("#btnPeriodicTableToggle").click(function () {
            $("#periodic-btn").slideToggle("slow");
        });

        $("#nelementsSlider").click(function () {
            $("#nelementsSelect").prop("checked", true);
        });

        $("button[class^=pt-color]").click(function () {
            if(!$(this).hasClass('disabled')) {
                var num = parseInt($(this).prop("class").match(/\d+/g), 10);
                $(this).toggleClass("pt-color-" + that.common.addZero(num, 2) + "-active");

                var condition = $("#condition").val();
                var searchValue;
                if (condition == "elements") {
                    searchValue = new Array();
                    $("button[class^=pt-color]").each(function (i, e) {
                        if (/active$/.test(e.className)) {
                            searchValue.push($(e).find("h5").text());
                        }
                    });
                } else if (condition == "reducedformula") {
                    searchValue = "";
                    $("button[class^=pt-color]").each(function (i, e) {
                        if (/active$/.test(e.className)) {
                            searchValue = searchValue + $(e).find("h5").text();
                        }
                    });
                }
                $("#searchValue").val(searchValue);
            }
        });

        $("#condition").change(function (e) {
            $("#extractFile").val("");
            $("#searchValue").val("");
            $("#searchValue")[0].defaultValue = "";
            $("#searchValue").hide();
            $("#extractFile").hide();
            var val = $(this).val();
            if (val == "elements") {
                $("#searchValue").show();
                $("#searchValue").attr("placeholder", "Ca,C,O");
            } else if (val == "reducedformula") {
                $("#searchValue").show();
                $("#searchValue").attr("placeholder", "Ca4C8O16");
            } else if (val == "extract") {
                $("#extractFile").show();
            }
            that.periodicTableClear();
        });
    }
});