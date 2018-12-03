var MaterialsExplorer = Class.create({
    init: function (common) {
        this.common = common;

        this.data = $('#page-data').data('materialsExplorer');
        this.densityDefaultValue = {
            min: parseInt(this.data.densityDefaultValue.split("-")[0]),
            max: parseInt(this.data.densityDefaultValue.split("-")[1])
        };
        this.nelementsDefaultValue = {
            min: parseInt(this.data.nelementsDefaultValue.split("-")[0]),
            max: parseInt(this.data.nelementsDefaultValue.split("-")[1])
        };
        this.bandgapDefaultValue = {
            min: parseInt(this.data.bandgapDefaultValue.split("-")[0]),
            max: parseInt(this.data.bandgapDefaultValue.split("-")[1])
        };
        this.volumeDefaultValue = {
            min: parseInt(this.data.volumeDefaultValue.split("-")[0]),
            max: parseInt(this.data.volumeDefaultValue.split("-")[1])
        };
    },
    initPeriodic: function (that, searchValue) {
        $("button[class^=pt-color]").each(function (i, e) {
            var num = parseInt($(e).prop("class").match(/\d+/g), 10);
            if ($.inArray($(e).find("h5").text(), searchValue) >= 0) {
                $(e).toggleClass("pt-color-" + that.common.addZero(num, 2) + "-active");
            }
        });
    },
    initSlider: function () {

        var that = this;

        // density 슬라이더
        var densityValue = $("#densityValue").val();
        var density;

        console.log("densityValue", densityValue);

        if (/(\d*\.?\d+)-(\d*\.?\d+)/g.test(densityValue)) {
            density = {
                min: densityValue.split("-")[0],
                max: densityValue.split("-")[1]
            }

            console.log("density 1", density);
        } else {
            density = that.densityDefaultValue;

            console.log("density 2", density);
        }

        $("#densitySlider").slider({
            range: true,
            min: that.densityDefaultValue.min,
            max: that.densityDefaultValue.max,
            values: [density.min, density.max],
            slide: function (event, ui) {
                $("#densityValue").val(ui.values[0] + "-" + ui.values[1]);
            }
        });
        $("#densityValue").val($("#densitySlider").slider("values", 0) + "-" + $("#densitySlider").slider("values", 1));

        // nelements 슬라이더
        var nelementsValue = $("#nelementsValue").val();
        var nelements;
        if (/(\d)-(\d)/g.test(nelementsValue)) {
            nelements = {
                min: nelementsValue.split("-")[0],
                max: nelementsValue.split("-")[1]
            }
        } else {
            nelements = that.nelementsDefaultValue;
        }
        $("#nelementsSlider").slider({
            range: true,
            min: that.nelementsDefaultValue.min,
            max: that.nelementsDefaultValue.max,
            values: [nelements.min, nelements.max],
            slide: function (event, ui) {
                $("#nelementsValue").val(ui.values[0] + "-" + ui.values[1]);
            }
        });
        $("#nelementsValue").val($("#nelementsSlider").slider("values", 0) + "-" + $("#nelementsSlider").slider("values", 1));

        // bandgap 슬라이더
        var bandgapValue = $("#bandgapValue").val();
        var bandgap;
        if (/(\d)-(\d)/g.test(bandgapValue)) {
            bandgap = {
                min: bandgapValue.split("-")[0],
                max: bandgapValue.split("-")[1]
            }
        } else {
            bandgap = that.bandgapDefaultValue;
        }
        $("#bandgapSlider").slider({
            range: true,
            min: that.bandgapDefaultValue.min,
            max: that.bandgapDefaultValue.max,
            values: [bandgap.min, bandgap.max],
            slide: function (event, ui) {
                $("#bandgapValue").val(ui.values[0] + "-" + ui.values[1]);
            }
        });
        $("#bandgapValue").val($("#bandgapSlider").slider("values", 0) + "-" + $("#bandgapSlider").slider("values", 1));

        // volume 슬라이더
        var volumeValue = $("#volumeValue").val();
        var volume;
        if (/(\d)-(\d)/g.test(volumeValue)) {
            volume = {
                min: volumeValue.split("-")[0],
                max: volumeValue.split("-")[1]
            }
        } else {
            volume = that.volumeDefaultValue;
        }

        $("#volumeSlider").slider({
            range: true,
            min: that.volumeDefaultValue.min,
            max: that.volumeDefaultValue.max,
            values: [volume.min, volume.max],
            slide: function (event, ui) {
                $("#volumeValue").val(ui.values[0] + "-" + ui.values[1]);
            }
        });
        $("#volumeValue").val($("#volumeSlider").slider("values", 0) + "-" + $("#volumeSlider").slider("values", 1));
    },
    materialsExplorerSubmit: function () {
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

        $("#formMaterialsExplorer").submit();
    },
    periodicTableClear: function () {
        var that = this;
        $("button[class^=pt-color]").each(function (i, e) {
            var num = parseInt($(e).prop("class").match(/\d+/g), 10);
            $(e).removeClass("pt-color-" + that.common.addZero(num, 2) + "-active");
        });
    },
    initEvents: function () {
        var that = this;
        var searchValue = $("#searchValue").val().split(/\s*,\s*/g);
        this.initPeriodic(that, searchValue);
        this.initSlider();

        if ($("#condition").val() == "extract") {
            $("#searchValue").val("");
            $("#searchValue").hide();
            $("#extractFile").show();
        }

        $("#btnSearch").click(function () {
            that.materialsExplorerSubmit();
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

            $("#densitySlider").slider("values", 0, that.densityDefaultValue.min);
            $("#densitySlider").slider("values", 1, that.densityDefaultValue.max);
            $("#densityValue").val(that.densityDefaultValue.min + "-" + that.densityDefaultValue.max);

            $("#nelementsSelect").prop("checked", false);

            $("#nelementsSlider").slider("values", 0, that.nelementsDefaultValue.min);
            $("#nelementsSlider").slider("values", 1, that.nelementsDefaultValue.max);
            $("#nelementsValue").val(that.nelementsDefaultValue.min + "-" + that.nelementsDefaultValue.max);

            $("#bandgapSlider").slider("values", 0, that.bandgapDefaultValue.min);
            $("#bandgapSlider").slider("values", 1, that.bandgapDefaultValue.max);
            $("#bandgapValue").val(that.bandgapDefaultValue.min + "-" + that.bandgapDefaultValue.max);

            $("#volumeSlider").slider("values", 0, that.volumeDefaultValue.min);
            $("#volumeSlider").slider("values", 1, that.volumeDefaultValue.max);
            $("#volumeValue").val(that.volumeDefaultValue.min + "-" + that.volumeDefaultValue.max);

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