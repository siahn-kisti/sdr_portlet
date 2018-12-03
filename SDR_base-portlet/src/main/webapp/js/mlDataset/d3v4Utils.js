var d3v4Utils = function () {
    var createData = function(chartType, chartData){
        var result;
        var data = chartData[chartType]["data"];

        switch (chartType) {
            case "bar":
                result = [];

                for(var key in data){
                    var value = data[key];
                    var map = {};

                    map["letter"] = value['k'];
                    map["frequency"] = value['v'];

                    result.push(map);
                }

                break;
            case "unique":
            case "rank":
            case "pie":
                result = [];

                for(var key in data){
                    var value = data[key];
                    var map = {};

                    map["age"] = value['k'];
                    map["population"] = value['v'];

                    result.push(map);
                }

                break;
        }

        return result;
    };

    var remove = function(csvChartTargetId){
        var csvChartTarget = document.getElementById(csvChartTargetId);
        d3.select(csvChartTarget).selectAll("*").remove();
    };

    var tooltip = {
        element: d3.select("body").append("div").attr("class", "toolTip"),

        active: function ( message){  // utility function to be called on mouseover.

            d3v4Utils.tooltip.element
                .style("left", d3.event.pageX - 50 + "px")
                .style("top", d3.event.pageY - 70 + "px")
                .style("display", "inline-block")
                .html(message);
        },

        inactive: function (){    // utility function to be called on mouseout.

            d3v4Utils.tooltip.element.style("display", "none");
        }
    };

    var chart = {
        unique: function(svgId, data){
            var svgElement = document.getElementById(svgId);
            if(svgElement == null) return;

            var svg = d3.select(svgElement),
                margin = {top: 10, right: 5, bottom: 25, left: 5},
                width = +svg.attr("width") - margin.left - margin.right,
                height = +svg.attr("height") - margin.top - margin.bottom,
                fontSize = "30" + "px";

            var x = d3.scaleBand().rangeRound([0, width]),
                y = d3.scaleLinear().rangeRound([height, 0]);

            var g = svg.append("g")
                .attr("transform", "translate(" + margin.left + "," + margin.top + ")");

            svg.append("text")
                .attr("transform",
                    "translate( " + (width/3)*1 + " ," +
                    ((height/3)*2) + ")")
                .style("fill", "gray")
                .style("font-size", fontSize)
                .style("text-anchor", "start")
                .text('unique');
        },

        rank: function(svgId, data){
            var nameSubString = function(stringValue){
                var value = stringValue.toString();
                if(value.length > 10){
                    value = value.substring(0,8) + "...";
                }

                return value;
            };

            var svgText = function(svgText, message, fontSize, y_coordinate, align_right){

                if(align_right == null || align_right == false){
                    // Left
                    svgText
                        .attr("transform",
                            "translate( " + margin.left + " ," +
                            y_coordinate + ")")
                        .style("fill", "black")
                        .style("font-size", fontSize)
                        .style("text-anchor", "start")
                        .on("mouseover",function(d){
                            d3v4Utils.tooltip.active(message);
                        })
                        .on("mouseout",function(d){
                            d3v4Utils.tooltip.inactive();
                        })
                        .text(nameSubString(message));
                }else{
                    //Right
                    svg.append("text")
                        .attr("transform",
                            "translate(" + (width) + " ," +
                            y_coordinate + ")")
                        .style("fill", "gray")
                        .style("font-size", fontSize)
                        .style("text-anchor", "end")
                        .text(message);
                }
            };

            var svgElement = document.getElementById(svgId);
            if(svgElement == null) return;

            var svg = d3.select(svgElement),
                margin = {top: 10, right: 5, bottom: 25, left: 5},
                width = +svg.attr("width") - margin.left - margin.right,
                height = +svg.attr("height") - margin.top - margin.bottom
                fontSize = "16" + "px";

            var x = d3.scaleBand().rangeRound([0, width]),
                y = d3.scaleLinear().rangeRound([height, 0]);

            var g = svg.append("g")
                .attr("transform", "translate(" + margin.left + "," + margin.top + ")");

            // the most
            if(data[0] != null){
                svgText(svg.append("text"), (data[0]["age"]), fontSize, (height/3));
                svgText(svg.append("text"), (data[0]["population"]), fontSize, (height/3), true);
            }
            // The second most
            if(data[1] != null){
                svgText(svg.append("text"), (data[1]["age"]), fontSize, ((height/3)*2));
                svgText(svg.append("text"), (data[1]["population"]), fontSize, ((height/3)*2), true);
            }
            // Remaining quantity
            if(data[2] != null){
                svgText(svg.append("text"), (data[2]["age"]), fontSize, ((height/3)*3));
                svgText(svg.append("text"), (data[2]["population"]), fontSize, ((height/3)*3), true);
            }
        },

        pie: function(svgId, data){
            var svgElement = document.getElementById(svgId);
            if(svgElement == null) return;

            var svg = d3.select(svgElement),
                width = +svg.attr("width"),
                height = +svg.attr("height"),
                radius = Math.min(width, height) / 2,
                g = svg.append("g").attr("transform", "translate(" + width / 2 + "," + height / 2 + ")");

            var color = d3.scaleOrdinal(["#52E252", "#7878e1", "#b4b4b4"]);

            var pie = d3.pie()
                .sort(null)
                .value(function(d) { return d.population; });

            var path = d3.arc()
                .outerRadius(radius - 10)
                .innerRadius(0);

            var label = d3.arc()
                .outerRadius(radius - 30)
                .innerRadius(radius - 20);


            // graph drawing
            var arc = g.selectAll(".arc")
                .data(pie(data))
                .enter().append("g")
                .attr("class", "arc")
                .on("mouseover",function(d){

                    var message =  (d.data["age"]) + "<br> Count: " + (d.data["population"]);
                    d3v4Utils.tooltip.active(message);
                })
                .on("mouseout",function(d){

                    d3v4Utils.tooltip.inactive();
                });

            arc.append("path")
                .attr("d", path)
                .style("fill", function(d) { return color(d.data.age); });

            arc.append("text")
                .attr("transform", function(d) { return "translate(" + label.centroid(d) + ")"; })
                .attr("dy", "0.35em")
                .text(function(d) { return d.data.age; });
        },


        bar: function (svgId, data) {

            var svgElement = document.getElementById(svgId);
            if(svgElement == null) return;

            var svg = d3.select(svgElement),
                margin = {top: 10, right: 5, bottom: 25, left: 30},
                width = +svg.attr("width") - margin.left - margin.right,
                height = +svg.attr("height") - margin.top - margin.bottom;

            var x = d3.scaleBand().rangeRound([0, width]),
                y = d3.scaleLinear().rangeRound([height, 0]);

            var g = svg.append("g")
                .attr("transform", "translate(" + margin.left + "," + margin.top + ")");

            // graph drawing
            var map = [];
            for(var idx=0; idx < data.length; idx++){
                if(idx == 0){
                    map.push(data[idx].letter);
                }else if ((idx == data.length - 1)){
                    map.push(data[idx].letter);
                }else{
                    map.push("-");
                }
            }

            x.domain
            (data.map(
                function(d) {
                    return d.letter;
                }
            ));


            y.domain([0, d3.max(data, function(d) { return d.frequency; })]);

            g.append("g")
                .attr("class", "axis axis--x")
                .attr("transform", "translate(0," + height + ")")
                .call(d3.axisBottom(x));

            g.append("g")
                .attr("class", "axis axis--y")
                .call(d3.axisLeft(y).ticks(10, "%"))
                .append("text")
                .attr("transform", "rotate(-90)")
                .attr("y", 6)
                .attr("dy", "0.71em")
                .attr("text-anchor", "end")
                .text("Frequency");

            g.selectAll(".bar")
                .data(data)
                .enter().append("rect")
                .attr("class", "bar")
                .attr("x", function(d) { return x(d.letter); })
                .attr("y", function(d) { return y(d.frequency); })
                .style("width", x.bandwidth())
                .style("height", function(d) { return height - y(d.frequency); })
                .style("fill", "0064FF")
                .on("mouseover",function(d){
                    var message =  (d["letter"]) + "<br> Count: " + (d["frequency"]);
                    d3v4Utils.tooltip.active(message);
                })
                .on("mouseout",function(d){
                    d3v4Utils.tooltip.inactive();
                });
        },

        axisHiddenBar: function (svgId, data, min, max) {

            var svgElement = document.getElementById(svgId);
            if(svgElement == null) return;

            var svg = d3.select(svgElement),
                margin = {top: 10, right: 5, bottom: 25, left: 5},
                width = +svg.attr("width") - margin.left - margin.right,
                height = +svg.attr("height") - margin.top - margin.bottom;

            var color = d3.scaleOrdinal(["79D3DC", "#017598", "#AEDF1D"]);

            var x = d3.scaleBand().rangeRound([0, width]),
                y = d3.scaleLinear().rangeRound([height, 0]);

            var g = svg.append("g")
                .attr("fill","blue")
                .attr("transform", "translate(" + margin.left + "," + margin.top + ")");

            // graph drawing
            var map = [];
            for(var idx=0; idx < data.length; idx++){
                if(idx == 0){
                    map.push(data[idx].letter);
                }else if ((idx == data.length - 1)){
                    map.push(data[idx].letter);
                }else{
                    map.push("-");
                }
            }

            x.domain
            (data.map(
                function(d) {
                    return d.letter;
                }
            ));


            y.domain([0, d3.max(data, function(d) { return d.frequency; })]);

            svg.append("text")
                .attr("transform",
                    "translate( " + margin.left + " ," +
                    (height + margin.top + 20) + ")")
                .attr("fill", "gray")
                .style("text-anchor", "start")
                .text(min);

            svg.append("text")
                .attr("transform",
                    "translate(" + (width) + " ," +
                    (height + margin.top + 20) + ")")
                .attr("fill", "gray")
                .style("text-anchor", "end")
                .text(max);

            g.selectAll(".bar")
                .data(data)
                .enter().append("rect")
                .attr("class", "bar")
                .attr("x", function(d) {
                    return x(d.letter);
                })
                .attr("y", function(d) {
                    return y(d.frequency);
                })
                .style("width", x.bandwidth())
                .style("height", function(d) {
                    return height - y(d.frequency);
                })
                .style("fill",  function(d) { return color(d.letter); })
                .on("mouseover",function(d){
                    var message =  (d["letter"]) + "<br> Count: " + (d["frequency"]);
                    d3v4Utils.tooltip.active(message);
                })
                .on("mouseout",function(d){
                    d3v4Utils.tooltip.inactive();
                });
        }
    };

    var DATA_TYPE_NUMERIC = "numeric";
    var DATA_TYPE_STRING = "string";

    var CHART_TYPE_HISTOGRAM = "bar";
    var CHART_TYPE_RANKING = "rank";
    var CHART_TYPE_UNIQUE = "unique";


    return {
        DATA_TYPE_NUMERIC: DATA_TYPE_NUMERIC,
        DATA_TYPE_STRING: DATA_TYPE_STRING,
        CHART_TYPE_HISTOGRAM: CHART_TYPE_HISTOGRAM,
        CHART_TYPE_RANKING: CHART_TYPE_RANKING,
        CHART_TYPE_UNIQUE: CHART_TYPE_UNIQUE,
        createData: createData,
        remove: remove,
        tooltip: tooltip,
        chart:chart
    }
}();