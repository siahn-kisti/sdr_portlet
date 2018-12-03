var PhaseDiagram = Class.create({
	init: function(common) {		
		this.common = common;

		this.colors = { stable: "#2B3E50"};
		this.unstableTabId = "unstable";
		this.stableTabId = "stable";
		this.activeTabId = this.stableTabId;		
	},
	compoundsJsonToTable: function(jsonData) {
	    var table = $("<table>");
	    var tHeader = $("<thead>");
    	var tTr = $("<tr>");
	    for (var k in jsonData[0]) {
	    	if (k.match(/^(name|formation_energy_per_atom|materialid)$/g)) {
		    	if (k == "name") {
			    	k = "Formula";
			    } else if (k == "formation_energy_per_atom") {
		    		k = "Formation(Energy/Atom)";
		    	} else if (k == "materialid") {
		    		k = "Id";
		    	}
	    	} else {
	    		break;
	    	}
	    	tTr.append("<th>" + k + "</th>");
	    }
	    tHeader.append(tTr);
	    $(tHeader).appendTo(table);
	    var tBody = $("<tbody>");
	    $.each(jsonData, function (index, value) {
	        var tTr = $("<tr>");
	        $.each(value, function (k, val) {
	        	if (k.match(/^(name|formation_energy_per_atom|materialid)$/g)) {
	        		if (k == "materialid") {
	        			tTr.append("<td><a href='" + $("#datasetDetailURL").val() + "&" + "_datasearch_WAR_SDR_baseportlet_datasetId=" + val + "' target='_blank'> " + val + "</a></td>");
	        		} else if (k == "formation_energy_per_atom") {
	        			tTr.append("<td>" + val.toFixed(5) + "</td>");
	        		} else {
	        			tTr.append("<td>" + val + "</td>");
	        		}
	        	}
	        });
	        tBody.append(tTr);
	        $(table).append(tBody);
	    });
	    return ($(table));
	},
	isMaterialId: function(t){
		// return t = String(t), t.match(/\mp-\d+$/)||t.match(/\mvc-\d+$/);
		return t = String(t), t.match(/^[\d]+$/);
	},
	htmlFormula: function(t) {
        var e = t.replace("PCO7", "PO4CO3");
        return oxidNumRegex = /([A-Z][a-z]*)([\d\.]+(?=-|\+).)/g, oxidRegex = /([A-Z][a-z]*)(-|\+)/g, _.isNull(e.match(oxidRegex)) && _.isNull(e.match(oxidNumRegex)) ? (e = e.replace(/([A-Z][a-z]*)([\d\.]+)/g, "$1<sub>$2</sub>"), e = e.replace(/(\))([\d\.]+)/g, "$1<sub>$2</sub>")) : (e = e.replace(oxidNumRegex, "$1<sup>$2</sup>"), e = e.replace(oxidRegex, "$1<sup>$2</sup>")), e
    },
	getAxisOptions: function(dimension, targetEl) {
		var options;
		if (dimension === 2) {
			options = {
				x: {
					title: {
						text: "Mol. fraction of " + targetEl,
						style: {
							color: "black"
						}
					},
					lineWidth: 2,
					gridLineWidth: 1,
					max: 1.1,
					min: -0.1,
					labels: {
						style: {
							color: "black"
						}
					}
				},
				y: {
					title: {
						text: "Energy relative to end members (eV)",
							style: {
							color: "black"
						}
					},
					lineWidth: 1,
					gridLineWidth: 1,
					labels: {
						style: {
							color: "black"
						}
					}
				}
			};
		} else {
			options = {
				x: {
					title: {
						text: ""
					},
					lineWidth: 0,
					gridLineWidth: 0,
					tickWidth: 0,
					max: 1.05,
					min: -0.05,
					labels: {
						enabled: false
					}
				},
				y: {
					title: {
						text: ""
					},
					lineWidth: 0,
					gridLineWidth: 0,
					tickWidth: 0,
					labels: {
						enabled: false
					}
				}
			};
		}

		return options;
	},
	coordsEqual: function(x1, y1, x2, y2) {
		return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)) < 0.001;
	},

	getOverlappingPoints: function(labels, point) {
		var overlapped;
		overlapped = labels.filter((function(_this) {
			return function(d) {
				return _this.coordsEqual(d.x, d.y, point.x, point.y);
			};
		})(this));

		return overlapped.sort(function(a, b) {
			return a.formation_energy_per_atom - b.formation_energy_per_atom;
		});
	},

	createTooltipTitle: function(name) {
		return "<h5>" + name + " Polymorphs</h5>";
	},

	generateLink: function(href, text) {
		return "<a target='_blank' href='" + href + "'>" + text + "</a>";
	},

	getDetailLink: function(id) {
		if (this.isMaterialId(id)) {
			return this.generateLink($("#datasetDetailURL").val() + "&" + "_datasearch_WAR_SDR_baseportlet_datasetId=" + id, id);
		} else {
			return "--";
		}
	},

	generateTooltipAtPoint: function(labelsAtPoint, name) {
		var e_above_hull, formE, key, label, labeltxt, link, section, tooltip;
		tooltip = [];
		if (!_.isEmpty(labelsAtPoint)) {
			tooltip.push(this.createTooltipTitle(name));

			for (key in labelsAtPoint) {
				label = labelsAtPoint[key];
				if (!(!_.isFunction(label))) {
					continue;
				}
				if (label.name == null) {
					label.name = "";
				}
				if (label.e_above_hull != null) {
					e_above_hull = label.e_above_hull.toFixed(3);
				}
				link = this.getDetailLink(label.materialid);
				labeltxt = label.name;

				if (label.formation_energy_per_atom != null) {
					formE = label.formation_energy_per_atom.toFixed(3);
				}
				if ((e_above_hull != null) && (formE != null)) {
					if (name.toLowerCase() === "stable") {
						section = "<b>" + labeltxt + "</b><div>Form. energy : " + formE + " eV<br>Id : " + link + "</div>";
					} else {
						section = "<div>" + link + " : " + formE + " eV (" + e_above_hull + " eV)</div>";
					}
					tooltip.push(section);
				}
			}
		}
		return tooltip.join("");
	},

	getUniqueUnstable: function(unstableLabels) {
		var label, pickedUnstable, uniqueUnstable;
		uniqueUnstable = _.uniq(_.map(unstableLabels, function(l) {
			return JSON.stringify(_.pick(l, "x", "y", "name"));
		}));
		pickedUnstable = (function() {
			var j, len, results;
			results = [];
			for (j = 0, len = uniqueUnstable.length; j < len; j++) {
				label = uniqueUnstable[j];
				results.push(JSON.parse(label));
			}
			return results;
		})();

		return _.map(pickedUnstable, function(label) {
			return _.find(unstableLabels, function(l) {
			return l.x === label.x && l.y === label.y && l.name === label.name;
			});
		});
	},

	generateLines: function(lines) {
		return {
			name: "none",
			color: this.colors.stable,
			dashStyle: "solid",
			lineWidth: 2,
			lineColor: this.colors.stable,
			marker: {
				enabled: false
			},
			data: this.getLineData(lines)
		};
	},

	getLineData: function(lines) {
		var coords;
		coords = [];
		lines.forEach((function(_this) {
			return function(line) {
				coords.push(line[0].slice(0));
				coords.push(line[1].slice(0));
				return coords.push(null);
			};
		})(this));

		return coords;
	},

	formatPlotData: function(arg) {

		var color, data, labels, name, primaryLabels, series, unstableLabels, zIndex;
		labels = arg.labels;
		unstableLabels = arg.unstableLabels;
		color = arg.color;
		name = arg.name;
		zIndex = arg.zIndex;

		if (name.toLowerCase() === "stable") {
			primaryLabels = labels;
		} else {
			primaryLabels = this.getUniqueUnstable(unstableLabels);
		}

		data = primaryLabels.map((function(_this) {
			return function(label) {
				var id, point, stableHTML, stableHere, tooltip, unstableHTML, unstableHere, x, y;
				x = label.x
				y = label.y;
				id = label.materialid;
				unstableHere = _this.getOverlappingPoints(unstableLabels, label);
				stableHere = _this.getOverlappingPoints(labels, label);
				stableHTML = _this.generateTooltipAtPoint(stableHere, "Stable");
				unstableHTML = _this.generateTooltipAtPoint(unstableHere, "Unstable");
				tooltip = stableHTML + unstableHTML;
				point = {
					id: id,
					x: x,
					y: y,
					name: label.name,
					tooltip: tooltip
				};
				return point;
			};
		})(this));

		series = {
			data: data,
			name: name,
			zIndex: zIndex,
			color: color
		};

		return series;
	},

   getLabelItems: function(elementsref, dim) {
	      elementsref = _.filter(elementsref, function(d) {
	        return _.isArray(d);
	      });
	      return _.map(elementsref, function(d) {
	        var labelItems, x1, y1;
	        if (dim === 3) {
	          x1 = d[0] * 430 - 10 * d[2].length / 2.0 + 20;
	          y1 = -d[1] * 480 + 450;
	        } else {
	          x1 = d[0] * 350 + 20;
	          y1 = 25;
	        }
	        return labelItems = {
	          html: d[2],
	          style: {
	            left: x1 + "px",
	            top: y1 + "px",
	            fontSize: "1.5em",
	            color: "#E25F05"
	          }
	        };
	      });
	    },

	toggleSeries: function(arg) {
		var hide, j, len, ref1, results, series, show;
		hide = arg.hide;
		show = arg.show;
		if (this.chart != null) {
			ref1 = this.chart.series;
			for (j = 0, len = ref1.length; j < len; j++) {
				series = ref1[j];

				series.show()

				if (hide != null) {
					if (series.name === hide) {
						series.hide();
					}
				} else {
					if (!series.visible) {
						series.show();
					}
				}
			}
		}
	},

	phaseDiagramExcute: function(jsonData) {
		var that = this;

		this.elements = jsonData.elements;
		
		console.log(this.elements);

		var dim = jsonData.dimension;

		// UI
		var phaseExpresssion = "";
		$.each(this.elements, function(i, v){
			phaseExpresssion += v;
			if (i < dim - 1) {
				phaseExpresssion += " + ";
			}
		});
		$(".phase_expresssion").html(phaseExpresssion);

		var chartWidth, elementsref, labelItems, labels, lines, pdPlotOptions, stablePoints, targetEl, unstableLabels, unstablePoints;
		lines = jsonData.lines
		labels = jsonData.stable_labels
		unstableLabels = jsonData.unstable_labels;

		$("#stable").html(this.compoundsJsonToTable(labels));
		$("#unstable").html(this.compoundsJsonToTable(unstableLabels));

		// is_element가 true 인 값만
		this.elementLabels = labels.filter(function(l) {
			return l.is_element;
		});

		elementsref = this.elementLabels.map(function(arg1) {
			var name, x, y;
			x = arg1.x, y = arg1.y, name = arg1.name;
			return [x, y, name];
		});

		stablePoints = this.formatPlotData({
			labels: labels,
			zIndex: 1,
			unstableLabels: unstableLabels,
			name: "stable",
			color: this.colors.stable
		});

		unstablePoints = this.formatPlotData({
			labels: labels,
			zIndex: 0,
			unstableLabels: unstableLabels,
			name: "unstable",
			color: "royalblue"
		});

		this.chartSeries = [this.generateLines(lines)];
		this.chartSeries.push(stablePoints);
		this.chartSeries.push(unstablePoints);

		// UI
		$("#btnStable").html("stable (" + labels.length + ")");
		$("#btnUnstable").html("Unstable (" + unstableLabels.length + ")");

		// TODO markComposition 구현
		/*
		 * if (!_.isEmpty(this.userLabels)) { this.addUserLabels(); }
		 */

		labelItems = this.getLabelItems(elementsref, dim);

		// X 좌표가 1인 원소 받기
		targetEl = _.last(_.find(elementsref, function(ref, i) {
			if (ref[0] === 1) {
				return ref[2];
			}
		}));

		pdPlotOptions =
		{
				scatter: {
					dataLabels: {
						allowOverlap: true
					},
					marker: {
						radius: 5,
						symbol: "diamond",
						states: {
							hover: {
								enabled: true,
								lineColor: "rgb(100,100,100)"
							}
						}
					},
					states: {
						hover: {
							marker: {
								enabled: false
							}
						}
					},
					animation: false
				}
		};

		pdPlotOptions["series"] =
		{
				dataLabels: {
					enabled: true,
					useHTML: true,
					formatter: function() {
						if (this.point.options.name) {
							return that.htmlFormula(this.point.options.name);
						} else {
							return "";
						}
					},
					style: {
						font: "bold 1.2em Helvetica, sans-serif"
					}
				},
            	stickyTracking: false,
				cursor: 'pointer',
				events: {
					click: function(evt) {
						this.chart.myTooltip.options.enabled = true;
						this.chart.myTooltip.refresh(evt.point, evt);
						this.chart.myTooltip.options.enabled = false;
					}
				}
		};

		chartWidth = 450;

		this.chart = Highcharts.chart({
			chart: {
				renderTo: "highchartsContainer",
				type: "scatter",
				height: chartWidth * 1.08,
				width: chartWidth,
				zoomType: "xy",
				animation: false,
				events: {
					load: function(){
						this.myTooltip = new Highcharts.Tooltip(this, this.options.tooltip);
					},
					click: function() {
						this.myTooltip.hide('fast');
					}
				}
			},
			loading: {
				style: {
					fontSize: "20px",
					opacity: ".8",
					color: "royalblue"
				}
			},
			navigation: {
				buttonOptions: {
					theme: {
						"stroke-width": 1,
						stroke: "silver",
						r: 0,
						states: {
							hover: {
								fill: "aquamarine"
							},
							select: {
								stroke: "#039",
								fill: "aquamarine"
							}
						}
					}
				}
			},
			credits: {
				enabled: false
			},
			title: {
				text: ""
			},
			subtitle: {
				text: "Mouse over dots for details"
			},
			xAxis: this.getAxisOptions(dim, targetEl).x,
			yAxis: this.getAxisOptions(dim, targetEl).y,
			legend: {
				enabled: false
			},
			plotOptions: pdPlotOptions,
			tooltip: {
				useHTML: true,
				style: {
					pointerEvents: 'auto',
				},
				formatter: function() {
					return this.point.options.tooltip;
				},
				snap:1,
                hideDelay: 500,
				enabled: false,
				backgroundColor: 'rgba(255,255,255,1)',
				positioner: function (labelWidth, labelHeight, point) {
					var tooltipX, tooltipY;
					if (point.plotX + labelWidth > this.chart.plotWidth) {
						tooltipX = point.plotX + this.chart.plotLeft - labelWidth - 20;
					} else {
						tooltipX = point.plotX + this.chart.plotLeft + 20;
					}
					tooltipY = point.plotY + this.chart.plotTop - 20;
					return { x: tooltipX, y: tooltipY };
				}
			},
			series: this.chartSeries
		});

		this.toggleSeries({ hide: "unstable" });
	},

	phaseDiagramRequest: function() {
		var that = this;
		var jsonData = "";

        $.ajax({
        	url: $("#chartDataJsonURL").val(),
        	type : "GET",
        	data : $("#formPhaseDiagramr").serialize(),
            success : function(data){
                jsonData = $.parseJSON(data)[0];

            	if ($.trim(data) == "[]" || jsonData == undefined) {
                    that.common.errorMessage($("#errorMessage"), {text: "No results were found for your search."});
                    $("#phase-diagram-phase-compounds").fadeOut();
            	} else if (jsonData.elements.length > 1) {
                    that.phaseDiagramExcute(jsonData);
                    $("#phase-diagram-phase-compounds").fadeIn();
                } else {
                    that.common.errorMessage($("#errorMessage"), { text: jsonData.error });
                    $("#phase-diagram-phase-compounds").fadeOut();
            	}
            },
            error : function(XMLHttpRequest, textStatus, errorThrown){
               alert(errorThrown);
               alert(textStatus);
            }
        });
	},

	periodicValidation: function(val) {
		if ($.trim(val).length > 0) {
			var valArr = val.split(/\s*,\s*/g);
			if (valArr.length <= 1) {
				this.common.errorMessage($("#errorMessage"), { text: "Enter between 2 and 4 different elements/formulas." });
				return false;
			} else if (valArr.length > 4) {
				this.common.errorMessage($("#errorMessage"), { text: "Enter between 2 and 4 different elements/formulas." });
				return false;
			} else {
				$("#phase-diagram-phase-compounds").hide();
				this.phaseDiagramRequest();
			}
		} else {
			this.common.errorMessage($("#errorMessage"), { text: "Please use the Periodic Table below." });
			return false;
		}
	},
    periodicTableClear: function () {
        var that = this;
        $("button[class^=pt-color]").each(function (i, e) {
            var num = parseInt($(e).prop("class").match(/\d+/g), 10);
            $(e).removeClass("pt-color-" + that.common.addZero(num, 2) + "-active");
        });
    },
	initEvents : function () {

		var that = this;

		var searchValue = $("#searchValue").val().split(/\s*,\s*/g);

		$("#btnSearch").click(function(){
			that.periodicValidation($("#searchValue").val());
		});

		$("#btnReset").click(function(){
			$("#searchValue").val("");
            that.periodicTableClear();
		});

		// $("#searchValue").keyup(function(e){
        $("#searchValue").keyup(function(e){
			var val = e.currentTarget.defaultValue;
		    if (e.keyCode == 13) {
                e.preventDefault();
		    	$("#btnSearch").trigger("click");
		    } else {
				that.common.errorMessage($("#errorMessage"), { text: "Please use the Periodic Table below." });
                $(this).val("");
		    }
		});

		$("button[class^=pt-color]").each(function(i, e){
			var num = parseInt( $(e).prop("class").match(/\d+/g), 10 );
			if ($.inArray($(e).find("h5").text(), searchValue) >= 0) {
				$(e).toggleClass("pt-color-" + that.common.addZero(num, 2) + "-active");
			}
		});

		$("#btnPeriodicTableToggle").click(function(){
			$("#periodic-btn").slideToggle("slow");
		});

		$("button[class^=pt-color]").click(function(){
            if(!$(this).hasClass('disabled')) {
                var val = $("searchValue").val();
                if ($.trim(val).length > 0) {
                    var valArr = val.split(/\s*,\s*/g);
                    if (valArr.length > 4) {
                        this.common.errorMessage($("#errorMessage"), {text: "Enter between 2 and 4 different elements/formulas."});
                        return false;
                    }
                }

                var num = parseInt($(this).prop("class").match(/\d+/g), 10);
                $(this).toggleClass("pt-color-" + that.common.addZero(num, 2) + "-active");
                var searchValue = new Array();
                $("button[class^=pt-color]").each(function (i, e) {
                    if (/active$/.test(e.className)) {
                        searchValue.push($(e).find("h5").text());
                    }
                });

                $("#searchValue").val(searchValue);
            }
		});
		
		// Compounds 탭 활성화
		var $tabs = $("#compoundsTabs").tabs();

		$tabs.on("tabsactivate", function(event, ui){
			if (ui.newTab.children("a:first").attr("href") == "#stable") {
				that.toggleSeries({ hide: "unstable" });
			} else {
				that.toggleSeries({ show: "unstable" });
			}
		});
	}
});