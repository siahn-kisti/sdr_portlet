var BatteryExplorer = Class.create({
    init: function(common) {
        this.common = common;

        this.data = $('#page-data').data('batteryExplorer');
        this.avgVoltageDefaultValue = {
            min: parseInt(this.data.avgVoltageDefaultValue.split("-")[0]),
            max: parseInt(this.data.avgVoltageDefaultValue.split("-")[1])
        };
        this.volumetricCapacityDefaultValue = {
            min: parseInt(this.data.volumetricCapacityDefaultValue.split("-")[0]),
            max: parseInt(this.data.volumetricCapacityDefaultValue.split("-")[1])
        };
        this.gravimetricCapacityDefaultValue = {
            min: parseInt(this.data.gravimetricCapacityDefaultValue.split("-")[0]),
            max: parseInt(this.data.gravimetricCapacityDefaultValue.split("-")[1])
        };
        this.nelementsDefaultValue = {
            min: parseInt(this.data.nelementsDefaultValue.split("-")[0]),
            max: parseInt(this.data.nelementsDefaultValue.split("-")[1])
        };

        this.workingIonPlaceholder = "Any";
        this.workingIonNumDisplayed = 3;
        this.workingIonOverflowText = "{n} selected";

    },
    checkForElementExistence: function(e) {
        return $(e).length ? $(e).val() : "";
    },
    parseIntExt: function(string) {
        var num = parseInt(string);
        if (num == NaN) {
            num = 0;
        }
        return num;
    },
    initPeriodic : function (that, searchValue) {
        $("button[class^=pt-color]").each(function(i, e) {
            var num = parseInt($(e).prop("class").match(/\d+/g), 10);
            if ($.inArray($(e).find("h5").text(), searchValue) >= 0) {
                $(e).toggleClass("pt-color-" + that.common.addZero(num, 2) + "-active");
            }
        });
    },
    initSlider : function () {
        var that = this;

        // Avg Voltage Slider
        var avgVoltageValue = that.checkForElementExistence("#avgVoltageValue");
        var avgVoltage;

        if (/(\d)-(\d)/g.test(avgVoltageValue)) {
            avgVoltage = {
                min : that.parseIntExt(avgVoltageValue.split("-")[0]),
                max : that.parseIntExt(avgVoltageValue.split("-")[1])
            }
        } else {
            avgVoltage = that.avgVoltageDefaultValue;
        }

        $("#avgVoltageSlider").slider({
            range : true,
            min : that.avgVoltageDefaultValue.min,
            max : that.avgVoltageDefaultValue.max,
            values : [ avgVoltage.min, avgVoltage.max ],
            slide : function(event, ui) {
                $("#avgVoltageValue").val(ui.values[0] + "-" + ui.values[1]);
            }
        });
        $("#avgVoltageValue").val($("#avgVoltageSlider").slider("values", 0) + "-" + $("#avgVoltageSlider").slider("values", 1));

        // Volumetric Capacity Slider
        var volumetricCapacityValue = $("#volumetricCapacityValue").val();
        var volumetricCapacity;

        if (/(\d)-(\d)/g.test(volumetricCapacityValue)) {
            volumetricCapacity = {
                min : that.parseIntExt(volumetricCapacityValue.split("-")[0]),
                max : that.parseIntExt(volumetricCapacityValue.split("-")[1])
            }
        } else {
            volumetricCapacity = that.volumetricCapacityDefaultValue;
        }

        $("#volumetricCapacitySlider").slider({
            range : true,
            min : that.volumetricCapacityDefaultValue.min,
            max : that.volumetricCapacityDefaultValue.max,
            values : [ volumetricCapacity.min, volumetricCapacity.max ],
            slide : function(event, ui) {
                $("#volumetricCapacityValue").val(ui.values[0] + "-" + ui.values[1]);
            }
        });
        $("#volumetricCapacityValue").val($("#volumetricCapacitySlider").slider("values", 0) + "-" + $("#volumetricCapacitySlider").slider("values", 1));

        // Gravimetric Capacity Slider
        var gravimetricCapacityValue = $("#gravimetricCapacityValue").val();
        var gravimetricCapacity;
        if (/(\d)-(\d)/g.test(gravimetricCapacityValue)) {
            gravimetricCapacity = {
                min : that.parseIntExt(gravimetricCapacityValue.split("-")[0]),
                max : that.parseIntExt(gravimetricCapacityValue.split("-")[1])
            }
        } else {
            gravimetricCapacity = that.gravimetricCapacityDefaultValue;
        }
        $("#gravimetricCapacitySlider").slider({
            range : true,
            min : that.gravimetricCapacityDefaultValue.min,
            max : that.gravimetricCapacityDefaultValue.max,
            values : [ gravimetricCapacity.min, gravimetricCapacity.max ],
            slide : function(event, ui) {
                $("#gravimetricCapacityValue").val(ui.values[0] + "-" + ui.values[1]);
            }
        });
        $("#gravimetricCapacityValue").val($("#gravimetricCapacitySlider").slider("values", 0) + "-" + $("#gravimetricCapacitySlider").slider("values", 1));

        // # of Elements Slider
        var nelementsValue = $("#nelementsValue").val();
        var nelements;
        if (/(\d)-(\d)/g.test(nelementsValue)) {
            nelements = {
                min : that.parseIntExt(nelementsValue.split("-")[0]),
                max : that.parseIntExt(nelementsValue.split("-")[1])
            }
        } else {
            nelements = that.nelementsDefaultValue;
        }
        $("#nelementsSlider").slider({
            range : true,
            min : that.nelementsDefaultValue.min,
            max : that.nelementsDefaultValue.max,
            values : [ nelements.min, nelements.max ],
            slide : function(event, ui) {
                $("#nelementsValue").val(ui.values[0] + "-" + ui.values[1]);
            }
        });
        $("#nelementsValue").val($("#nelementsSlider").slider("values", 0) + "-" + $("#nelementsSlider").slider("values", 1));
    },
    initWorkingIon : function () {
        $(".workingIonValue").fSelect({
            placeholder: this.workingIonPlaceholder,
            numDisplayed: this.workingIonNumDisplayed,
            overflowText: this.workingIonOverflowText,
            searchText: 'Search',
            showSearch: true
        })
    },
    batteryExplorerSubmit: function() {
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
        } else if (condition == "material" && (/[^A-Za-z0-9]/g.test(val) || val == "")) {
            this.common.errorMessage($("#errorMessage"), {text: "Please enter a formula."});
            return false;
        } else if (condition == "materialids" && (/[^0-9]/g.test(val) || val == "")) {
            this.common.errorMessage($("#errorMessage"), {text: "Please enter the Material ID."});
            return false;
        }
        $("#formBatteryExplorer").submit();
    },
    periodicTableClear: function () {
        var that = this;
        $("button[class^=pt-color]").each(function (i, e) {
            var num = parseInt($(e).prop("class").match(/\d+/g), 10);
            $(e).removeClass("pt-color-" + that.common.addZero(num, 2) + "-active");
        });
    },
    workingIonClear: function() {

        $(".workingIonValue option:selected").prop("selected", false);

        $(".fs-option").each(function (i, e) {
            if ($(e).hasClass("selected")) {
                $(e).removeClass("selected");
            }
        });
        var labelText = [];
        $('.fs-option.selected').each(function(i, el) {
            labelText.push($(el).find('.fs-option-label').text());
        });

        if (labelText.length < 1) {
            labelText = this.workingIonPlaceholder;
        }
        else if (labelText.length > this.workingIonNumDisplayed) {
            labelText = this.workingIonOverflowText.replace('{n}', labelText.length);
        }
        else {
            labelText = labelText.join(', ');
        }
        $(".fs-label").html(labelText);
    },
    initEvents : function () {
        var that = this;

        // List
        if ($.trim($("#datasetId").val()).length == 0) {

            var searchValue = $("#searchValue").val().split(/\s*,\s*/g);

            this.initPeriodic(that, searchValue);
            this.initSlider();
            this.initWorkingIon();

            $("#btnSearch").click(function(){
                that.batteryExplorerSubmit();
            });

            $("#searchValue").keyup(function(e) {
                var val = e.currentTarget.defaultValue;
                if (e.keyCode == 13) {
                    $("#btnSearch").trigger("click");
                } else if ($("#condition").val() == "elements") {
                    that.common.errorMessage($("#errorMessage"), {
                        text : "Please use the Periodic Table below."
                    });
                    $(this).val(val);
                }
            });

            $("#btnReset").click(function() {
                $("#condition").prop("selectedIndex", 0);

                $("#searchValue").val("");

                $("#avgVoltageSlider").slider("values", 0, that.avgVoltageDefaultValue.min);
                $("#avgVoltageSlider").slider("values", 1, that.avgVoltageDefaultValue.max);
                $("#avgVoltageValue").val(that.avgVoltageDefaultValue.min + "-" + that.avgVoltageDefaultValue.max);

                $("#nelementsSelect").prop("checked", false);

                $("#volumetricCapacitySlider").slider("values", 0, that.volumetricCapacityDefaultValue.min);
                $("#volumetricCapacitySlider").slider("values", 1, that.volumetricCapacityDefaultValue.max);
                $("#volumetricCapacityValue").val(that.volumetricCapacityDefaultValue.min + "-" + that.volumetricCapacityDefaultValue.max);

                $("#gravimetricCapacitySlider").slider("values", 0, that.gravimetricCapacityDefaultValue.min);
                $("#gravimetricCapacitySlider").slider("values", 1, that.gravimetricCapacityDefaultValue.max);
                $("#gravimetricCapacityValue").val(that.gravimetricCapacityDefaultValue.min + "-" + that.gravimetricCapacityDefaultValue.max);

                $("#nelementsSlider").slider("values", 0, that.nelementsDefaultValue.min);
                $("#nelementsSlider").slider("values", 1, that.nelementsDefaultValue.max);
                $("#nelementsValue").val(that.nelementsDefaultValue.min + "-" + that.nelementsDefaultValue.max);

                that.workingIonClear();
                that.periodicTableClear();
            });

            $("#btnPeriodicTableToggle").click(function() {
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
                    } else if (condition == "material") {
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

            $("#condition").change(function(e) {
                var val = $(this).val();
                $("#searchValue").val("");
                $("#searchValue")[0].defaultValue = "";
                if (val == "elements") {
                    $("#searchValue").attr("placeholder", "Si,O");
                } else if (val == "material") {
                    $("#searchValue").attr("placeholder", "SiO2");
                } else if (val == "materialids"){
                    $("#searchValue").attr("placeholder", "244535");
                }

                that.periodicTableClear();
            });
        // View
        } else {
            var data = $("#batteryData").val();
            that.initBattery(data);
        }
    },
    initBattery : function (data) {
        this.data = JSON.parse(JSON.stringify(eval("(" + data + ")"))),
        this.id = this.data.datasetId,
        this.workingIon = this.data.working_ion,
        this.pairs = this.data.cvpairs,
        this.formula = this.data.material,
        this.axisLabelStyle = {color: "rgba(0,0,0, .8)", font: "bold 13px Helvetica"},
        this.tickStyle = {color: "#000", fontSize: "13px"},
        this.createProfileChart();
    },
    bind : function (t, e) {
        return function () { return t.apply(e, arguments) }
    },
    cleanDecimals: function (t, e, n) {
        var i = new Number(t).toFixed(e);
        if (n) return i;
        var r = parseFloat(i);
        return isNaN(r) ? "" : r
    },
    sum: function (e) {
        return _.reduce(e, function (t, e) {
            return t + e
        })
    },
    type: function (t) {
        var V = {}, Y = V.toString;
        return null == t ? t + "" : "object" == typeof t || "function" == typeof t ? V[Y.call(t)] || "object" : typeof t
    },
    isWindow: function (t) {
        return null != t && t === t.window
    },
    n: function (t) {
        var e = t.length, n = this.type(t);
        return "function" === n || this.isWindow(t) ? !1 : 1 === t.nodeType && e ? !0 : "array" === n || 0 === e || "number" == typeof e && e > 0 && e - 1 in t
    },
    map: function (t, e, i) {
        var r, o = 0,
            s = t.length,
            a = this.n(t),
            l = [];
        if (a) {
            for (; s > o; o++) r = e(t[o], o, i), null != r && l.push(r);
        } else {
            for (o in t) r = e(t[o], o, i), null != r && l.push(r);
        }
        var M = [], U = M.concat;
        return U.apply([], l);
    },
    unitcellFormula: function (n) {
        var i, r;
        return r = this.compact(n.split(" ")), this.isEmpty(r) ? {} : r.length > 1 ? (i = this.map(r, e.parseUnitcellFormula), this.merge.apply(t, i)) : e.parseUnitcellFormula(n)
    },
    cleanDecimals: function (t, n, i) {
        return null == i && (i = !1), this.cleanDecimals2(t, n, i)
    },
    cleanDecimals2: function (t, e, n) {
        var i = new Number(t).toFixed(e);
        if (n) return i;
        var r = parseFloat(i);
        return isNaN(r) ? "" : r
    },
    createProfileChart : function () {
        var that = this;
        var buttonTheme = {
            buttonOptions: {
                theme: {
                    "stroke-width": 1,
                    stroke: "silver",
                    r: 0,
                    states: {hover: {fill: "aquamarine"},
                        select: {
                            stroke: "#039", fill: "aquamarine"
                        }
                    }
                }
            }
        }

        var option =
        {
            title: "Discharge curve",
            selectorId: "discharge-curve",
            xLabel: "x in " + this.workingIon + "x " + this.htmlFormula(this.formula),
            yLabel: "Voltage (V)",
            data: this.getVoltageProfile(),
            width: $("#discharge-curve").width(),
            height: "500",
            backgroundColor: "rgba(255, 255, 255, 1)",
        };

        this.chart = new Highcharts.Chart({
            chart: {
                renderTo: option.selectorId,
                type: "scatter",
                margin: [60, 30, 60, 80],
                backgroundColor: option.backgroundColor,
                width: option.width,
                height: option.height,
                zoomType: "xy",
                plotBorderWidth: 1,
                plotBorderColor: "rgba(0,0,0, 0.1)"},
            credits: {enabled: !1},
            navigation: buttonTheme,
            title: {text: option.title, style: {color: "#000", font: "bold 15px Helvetica"}},
            xAxis: {
                tickInterval: 1,
                title: {
                    useHTML: !0,
                    text: option.xLabel,
                    style: this.axisLabelStyle
                },
                lineWidth: 0,
                labels: {style: this.tickStyle},
                tickPositioner: function () {
                    var t, e, i;
                    for (e = [], i = Math.floor(this.min), t = 0.25; i - t <= this.max;) {
                        e.push(i);
                        i += t;
                    }
                    return e;
                },
                min: 0
            }, yAxis: {
                title: {
                    text: option.yLabel,
                    style: this.axisLabelStyle
                },
                lineWidth: 0,
                labels: {
                    style: this.tickStyle},
                min: 0
            },
            legend: {enabled: !1, symbolWidth: 60, reversed: !0},
            plotOptions: {
                scatter: {
                    marker: {
                        radius: 5, states: {
                            hover: {
                                enabled: !0, lineColor: "#393b79"
                            }
                        }
                    },
                    states: {
                        hover: {
                            marker: {
                                enabled: !1
                            }
                        }
                    },
                    lineColor: "royalblue",
                    lineWidth: 2
                }
            },
            tooltip: {
                useHTML: !0,
                formatter: function () {
                    return that.htmlFormula(this.point.name)
                }
            },
            series: option.data
        });

        $("#voltage_pair_properties_list").html(this.JsonToTable(this.data.cvpairs));
    },
    JsonToTable: function(jsonData) {
        var table = $("<table>");
        var tHeader = $("<thead>");
        var tTr = $("<tr>");
        for (var k in jsonData[0]) {
            if (k.match(/^(vol_charge|capacity|voltage)$/g)) {
                if (k == "vol_charge") {
                    k = "Volume Change";
                } else if (k == "capacity") {
                    k = "Capacity";
                } else if (k == "voltage") {
                    k = "Voltage";
                }
                tTr.append("<th>" + k + "</th>");
            }
        }
        tTr.append("<th>&nbsp;</th>");
        tHeader.append(tTr);
        $(tHeader).appendTo(table);
        var tBody = $("<tbody>");
        $.each(jsonData, function (index, value) {
            var tTr = $("<tr>");
            var reactants = "";
            var products = "";
            $.each(value, function (k, val) {
               if (k.match(/^(vol_charge|capacity|voltage)$/g)) {
                   val = val.toFixed(2);
                   if (k == "vol_charge") {
                       val = val + " %"
                   } else if (k == "capacity") {
                       val = val + " mAhg-1"
                   } else if (k == "voltage") {
                       val = val + " V"
                   }
                   tTr.append("<td>" + val + "</td>");
                } else if (k.match(/^(reactants|products)$/g)) {
                   if (k == "reactants") {
                       var cnt = 0;
                       $.each(val, function (j, v) {
                           if (cnt > 0) {
                               reactants = reactants + " <strong>+</strong> ";
                           }
                           reactants = reactants + "<span class=\"material\">"+ j + "</span>" + v.value.toFixed(2);
                           ++cnt;
                       });
                   } else if (k == "products") {
                       var cnt = 0;
                       $.each(val, function (j, v) {
                           if (cnt > 0) {
                               products = products + " <strong>+</strong> ";
                           }
                           products = products + "<span class=\"material\">"+ j + "</span>" + v.value.toFixed(2);
                           ++cnt;
                       });
                   }
               }
            });
            tTr.append("<td>" + reactants + "<i class=\"fa fa-arrow-right\" aria-hidden=\"true\"></i>" + products + "</td>");
            tBody.append(tTr);
            $(table).append(tBody);
        });
        return ($(table));
    },
    getVoltageProfile: function () {
        var t, i, n, o, s, r, a;
        for (r = [], a = n = 0; n < this.data.plot_x.length;) {
            t = this.cleanDecimals(this.data.plot_x[n], 2);
            a = this.cleanDecimals(this.data.plot_y[n], 2);
            r.push({name: this.workingIon + t + this.formula + "<br> Voltage = " + a + " V", x: t, y: a});
            n++;
        }
        for (s = this.data.voltage_min, o = this.data.voltage_max, i = [], n = 0; n < this.data.plot_y.length;) {
            t = this.cleanDecimals(this.data.plot_x[n], 2);
            a = this.cleanDecimals(this.data.plot_y[n], 2);
            a >= s && o >= a && (
                i.push({name: this.workingIon + t + this.formula + "<br />" + a + " Volts", x: t, y: a})
            );
            n++;
        }

        return [{name: "Remainder of voltage profile", data: r, marker: {symbol: "circle"}, lineWidth: 2}, {name: "Segment satisfying search criteria", data: i, marker: {symbol: "circle"}, lineWidth: 3}]
    },
    htmlFormula: function (formula) {
        var e = formula.replace("PCO7", "PO4CO3");
        var oxidNumRegex = /([A-Z][a-z]*)([\d\.]+(?=-|\+).)/g;
        var oxidRegex = /([A-Z][a-z]*)(-|\+)/g;

        if (_.isNull(e.match(oxidRegex)) && _.isNull(e.match(oxidNumRegex))) {
            e = e.replace(/([A-Z][a-z]*)([\d\.]+)/g, "$1<sub>$2</sub>");
            e = e.replace(/(\))([\d\.]+)/g, "$1<sub>$2</sub>");
        } else {
            e = e.replace(oxidNumRegex, "$1<sup>$2</sup>");
            e = e.replace(oxidRegex, "$1<sup>$2</sup>");
            e = '<span class="chemform">' + e + "</span>";
        }
        return e;
    }
});