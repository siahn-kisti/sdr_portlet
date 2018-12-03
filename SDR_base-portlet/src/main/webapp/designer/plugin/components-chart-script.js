
var xrd = {
	
	path: '',
	target: '',
	
	init: function(path, target){
		xrd.path = path;
		xrd.target = target;
		
		xrd.initXrdChart();
	},
	
	changeType : function(type){
		xrd.initXrdChart(type);
	},

	initXrdChart : function(type){
		if(type==undefined) type = "xrd_CuKa.json";
		var url = xrd.path + type;

		$.ajax({
			type: "POST",
			url: url,
			dataType: "json",
			data: {},
			success: function (result) {
				xrd.createXrdChart(result);
			},
			error: function (e) {
				console.log("ERROR : ", e);
				$("#"+xrd.target).text("No xrd json data");
			}
		});
	},

	createXrdChart : function(data){
		var a = {
			"chart": {
				"renderTo": xrd.target,
				"backgroundColor": "#fff",
				"defaultSeriesType": "column",
				"height": 460,
				"plotBorderWidth": 1,
				"plotBorderColor": "rgba(0,0,0, 0.1)",
				"animation": false,
				"margin": [60, 20, 60, 80],
				"zoomType": "xy"
			},
			"navigation": {
				"buttonOptions": {
					"theme": {"stroke-width": 1, "stroke": "silver", "r": 0, "states": {"hover": {"fill": "aquamarine"}, "select": {"stroke": "#039", "fill": "aquamarine"}}}
				}
			},
			"legend": {
				"enabled": false
			},
			"subtitle": {
				"text": "",//"Click and drag to zoom",
				"style": {
					"color": "#101010"
				}
			},
			"title": {
				"text": "",//"X-Ray Diffraction",
				"style": {
					"font": "600 20px ff-dagny-web-pro, Helvetica;", "color": "#101010"
				}
			},
			"xAxis": {
				"gridLineColor": "rgba(0,0,0, 0.1)",
				"gridLineWidth": 1,
				"title": {
					"text": "2Θ", "style": {"font": "bold 1.2em Helvetica, sans-serif", "color": "#999"}
				},
				"labels": {
					"style": {"font": "1em Helvetica, sans-serif", "color": "#101010"}
				}
			},
			"yAxis": {
				"gridLineColor": "rgba(0,0,0, 0.1)",
				"labels": {
					"style": {"font": "1em Helvetica, sans-serif", "color": "#101010"}
				},
				"title": {
					"text": "Intensities (scaled)", "style": {"font": "bold 1.2em Helvetica, sans-serif", "color": "#999"}
				}
			},
			"series": [{
				"color": "rgba(75, 189, 179, 0.52)",
				"data": data
			}],
			"tooltip": {
				formatter: function() {
					var t, e, n, a, r, i;
					return n = this.point.options,
						t = n.d,
						e = n.hkl,
						a = [this.x, this.y, t].map(function(t) {
							return new Number(t).toFixed(3);
						}),
						r = a[0],
						i = a[1],
						t = a[2],
					"2Θ: " + r + "<br />Amplitude: " + i + "<br/>d: " + t + "<br />hkl: " + e.replace(/,/gi," ")
				}
			},
			"plotOptions": {
				"series": {
					"turboThreshold": 0, "pointWidth": 5, "shadow": false, "pointPadding": 0.25, "states": {"hover": {"color": "#96E3DD"}}
				}
			},
			"credits": {
				"enabled": false
			}
		};

		new Highcharts.Chart(a);
	}
	
};



var dos = {
	
	path: '',
	target: '',

	init: function(path, target){
		dos.path = path;
		dos.target = target;

		dos.initDosChart();
	},

	initDosChart : function(type){
		if(type==undefined) type = "dos.json";
		var url = dos.path + type;

		$.ajax({
			type: "POST",
			url: url,
			dataType: "json",
			data: {},
			success: function (result) {
				dos.createDosChart(result);
			},
			error: function (e) {
				console.log("ERROR : ", e);
				$("#"+dos.target).text("No Density of states json data");
			}
		});
	},

	createDosChart : function(data) {
	
		for(var i in data){
			var d = data[i];
	
			if(d.color!=undefined)
				delete d.color
		}
	
	
		var o = {
			"chart": {
				"renderTo": dos.target,
				"defaultSeriesType": "scatter",
				"zoomType": "x, y",
				"height": 485,
				"backgroundColor": "#fff",
				"events": {}
			},
			"legend": {
				"enabled": true,
				"align": "right",
				"verticalAlign": "top",
				"floating": true,
				"layout": "vertical",
				"y": 40,
				"symbolWidth": 20
			},
			"xAxis": {
				"labels": {"style": {"fontSize": "13px"}},
				"startOnTick": false,
				"endOnTick": false,
				"allowDecimals": true,
				"title": {
					"text": "Density of states", "style": {"font": "bold 1.2em Helvetica, sans-serif", "color": "#999"}
				}
			},
			"yAxis": {
				"labels": {"style": {"fontSize": "13px"}},
				"startOnTick": false,
				"endOnTick": false,
				"tickInterval": 5,
				"min": -8,
				"max": 8,
				"title": {
					"text": "Energies (eV)", "style": {"font": "bold 1.2em Helvetica, sans-serif", "color": "#999"}
				}
			},
			"series": data,
			"navigation": {
				"buttonOptions": {
					"theme": {
						"stroke-width": 1,
						"stroke": "silver",
						"r": 0,
						"states": {"hover": {"fill": "aquamarine"}, "select": {"stroke": "#039", "fill": "aquamarine"}}
					}
				}
			},
			"title": {"text": ""},
			"plotOptions": {
				"series": {"turboThreshold": 1000000, "shadow": false, "dashStyle": "solid", "lineWidth": 2, "marker": {"enabled": false}}
			},
			"tooltip": {},
			"credits": {
				"enabled": false
			},
			"exporting": {
				"sourceHeight": 485, "sourceWidth": 135
			}
		};
		new Highcharts.Chart(o);
	}
	
};
