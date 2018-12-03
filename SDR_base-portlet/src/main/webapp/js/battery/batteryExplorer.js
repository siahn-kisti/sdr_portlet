var data, id, workingIon, pairs, formula, axisLabelStyle, tickStyle;

function initBattery (metadata) {
    data = JSON.parse(JSON.stringify(eval("(" + metadata + ")")));
    id = this.data.datasetId;
    workingIon = this.data.working_ion;
    pairs = this.data.cvpairs;
    formula = this.data.material;
    axisLabelStyle = {color: "rgba(0,0,0, .8)", font: "bold 13px Helvetica"};
    tickStyle = {color: "#000", fontSize: "13px"};

    createProfileChart();
}

function createProfileChart() {
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
            xLabel: "x in " + this.workingIon + "x " + htmlFormula(this.formula),
            yLabel: "Voltage (V)",
            data: this.getVoltageProfile(),
            // width: $("#discharge-curve").width(),
            width: "1050",
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
                return htmlFormula(this.point.name);
            }
        },
        series: option.data
    });

    $("#voltage_pair_properties_list").html(this.JsonToTable(this.data.cvpairs));
}

function htmlFormula(formula) {
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

function getVoltageProfile() {
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
}

function cleanDecimals(t, n, i) {
    return null == i && (i = !1), this.cleanDecimals2(t, n, i)
}

function cleanDecimals2(t, e, n) {
    var i = new Number(t).toFixed(e);
    if (n) return i;
    var r = parseFloat(i);
    return isNaN(r) ? "" : r
}

function JsonToTable(jsonData) {
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
}