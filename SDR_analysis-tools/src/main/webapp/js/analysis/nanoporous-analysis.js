var NanoporousAnalysis = Class.create({
    init: function (common) {
        this.common = common;
    },
    nanoporousAnalysisSubmit: function () {
        var condition = $("#condition").val();
        var val = $("#searchValue").val();

        if (condition == "materialId" && !(/^[0-9]*$/g.test(val) || val == "")) {
            this.common.errorMessage($("#errorMessage"), {text: "Please enter only numbers."});
            return false;
        } else if (condition == "extract" && $.trim($("#extractFile").val()).length == 0) {
            this.common.errorMessage($("#errorMessage"), {text: "Please enter the file."});
            return false;
        }

        $('g.node').removeAttr('marker-end');

        $('g.node[data-datasets*=' + val + ']').each(function (i, e) {
            var $e = $(e);
            var data = $e.attr("data-datasets").split(',');
            if ($.inArray(val, data) > 0) {
                $e.attr({'marker-end': 'url(#marker-arrow)'})
            }
        });

    },
    initEvents: function () {
        var that = this;

        if ($("#condition").val() == "extract") {
            $("#searchValue").val("");
            $("#searchValue").hide();
            $("#extractFile").show();
        }

        $("#btnSearch").click(function () {
            that.nanoporousAnalysisSubmit();
        });

        $("#searchValue").keydown(function (e) {
            if (e.keyCode == 13) {
                $("#btnSearch").trigger("click");
                e.preventDefault();
                return false;
            }
        });

        $("#btnReset").click(function () {
            $("#condition").prop("selectedIndex", 0);

            $("#searchValue").val("");
            $("#searchValue").show();
            $("#searchValue").attr("placeholder", "Ca,C,O");
            $("#extractFile").hide();

        });

        $("#btnPeriodicTableToggle").click(function () {
            $("#periodic-btn").slideToggle("slow");
        });

        $("#nelementsSlider").click(function () {
            $("#nelementsSelect").prop("checked", true);
        });

        $("#condition").change(function (e) {
            $("#extractFile").val("");
            $("#searchValue").val("");
            $("#searchValue")[0].defaultValue = "";
            $("#searchValue").hide();
            $("#extractFile").hide();
            var val = $(this).val();
            if (val == "materialId") {
                $("#searchValue").show();
                $("#searchValue").attr("placeholder", "ex) 24567");
            } else if (val == "extract") {
                $("#extractFile").show();
            }
        });

////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////
////      kepler-mapper event
////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////

// Height and width settings
        var sizeData = panesSizeSet();
        var width = sizeData.canvasOuterWidth
        var height = sizeData.canvasOuterHeight

        var w = width;
        var h = height;

        var focus_node = null, highlight_node = null;
        var text_center = false;
        var outline = false;

// Size for zooming
        var size = d3.scale.pow().exponent(1)
            .domain([1, 100])
            .range([8, 24]);

        var palette = [
            '#0500ff', '#0300ff', '#0100ff', '#0002ff', '#0022ff', '#0044ff',
            '#0064ff', '#0084ff', '#00a4ff', '#00a4ff', '#00c4ff', '#00e4ff',
            '#00ffd0', '#00ff83', '#00ff36', '#17ff00', '#65ff00', '#b0ff00',
            '#fdff00', '#FFf000', '#FFdc00', '#FFc800', '#FFb400', '#FFa000',
            '#FF8c00', '#FF7800', '#FF6400', '#FF5000', '#FF3c00', '#FF2800',
            '#FF1400', '#FF0000'
        ];

// Variety of variable inits
        var highlight_color = "blue";
        var highlight_trans = 0.1;
        var default_node_color = "#ccc";
        var default_node_color = "rgba(160,160,160, 0.5)";
        var default_link_color = "rgba(160,160,160, 0.5)";
        var nominal_base_node_size = 8;
        var nominal_text_size = 15;
        var max_text_size = 24;
        var nominal_stroke = 1.0;
        var max_stroke = 4.5;
        var max_base_node_size = 36;
        var min_zoom = 0.1;
        var max_zoom = 7;
        var zoom = d3.behavior.zoom().scaleExtent([min_zoom, max_zoom]);


        var tocolor = "fill";
        var towhite = "stroke";
        if (outline) {
            tocolor = "stroke";
            towhite = "fill";
        }


// We draw the graph in SVG
        var svg = d3.select("#canvas").append("svg")
            .attr("id", "svg-graph")
            .attr("width", width)
            .attr("height", height);

        svg.style("cursor", "move");
        var group = svg.append("g");
        group.attr("class", "group");

////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////
////      Side panes
////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////

// Show/Hide Functionality
        $('.evt-tools').click(function () {
            var h = $('#canvas').height();
            var w = 300;

            var tip = $('#' + $(this).attr('id').split('_')[0]);
            var tip_content = tip.children().eq(0);

            if ($(this).hasClass('tip-open')) {
                tip_content.hide();
                $(this).find('.fa').removeClass('fa-minus-square');
                $(this).find('.fa').addClass('fa-plus-square');
                tip.width(0);
                tip.height(0);
            } else {
                tip_content.show();
                $(this).find('.fa').removeClass('fa-plus-square');
                $(this).find('.fa').addClass('fa-minus-square');
                tip.width(w);
                tip.height(h);
            }

            $(this).toggleClass('tip-open');

            panesSizeSet();
        });

// Color settings: Ordinal Scale of ["0"-"30"] hot-to-cold
        var color = d3.scale.ordinal()
            .domain(["0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
                "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
                "21", "22", "23", "24", "25", "26", "27", "28", "29", "30"])
            .range(palette);

// var color = d3.scale.category10();

////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////
////      Graph Setup
////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
        var graph = $("#json-graph").data("graph");

// Force settings
        var force = d3.layout.force()
            .linkDistance(5)
            .gravity(0.2)
            .charge(-1200)
            .size([w, h]);

        force
            .nodes(graph.nodes)
            .links(graph.links)
            .start();

        // Create line group
        var lineGroup = group.append("g");
        lineGroup.attr("class", "line-group");

        // line drowing
        var link = lineGroup.selectAll(".link")
            .data(graph.links)
            .enter().append("line")
            .attr("class", "link")
            .style("stroke-width", function (d) {
                return d.w * nominal_stroke;
            })
            .style("stroke-width", function (d) {
                return d.w * nominal_stroke;
            })
        //.style("stroke", function(d) {
        //  if (isNumber(d.score) && d.score>=0) return color(d.score);
        //  else return default_link_color; })

        // Create node group
        var nodeGroup = group.append("g");
        nodeGroup.attr("class", "node-group");

        // nodes(path) position set
        var node = nodeGroup.selectAll(".node")
            .data(graph.nodes)
            .enter().append("g")
            .attr("class", "node")
            .call(force.drag)
            .attr('data-members', function (d) {
                return d.members;
            })
            .attr('data-datasets', function (d) {
                return d.datasets;
            });

        console.log(graph.members);

// Double clicking on a node will center on it.
        node.on("dblclick.zoom", function (d) {
            d3.event.stopPropagation();
            var dcx = (window.innerWidth / 2 - d.x * zoom.scale());
            var dcy = (window.innerHeight / 2 - d.y * zoom.scale());
            zoom.translate([dcx, dcy]);
            group.attr("transform", "translate(" + dcx + "," + dcy + ")scale(" + zoom.scale() + ")");
        });


// Drop-shadow Filter
        var svg = d3.select("svg");
        var defs = svg.append("defs");
        var dropShadowFilter = defs.append('svg:filter')
            .attr('id', 'drop-shadow')
            .attr('filterUnits', "userSpaceOnUse")
            .attr('width', '250%')
            .attr('height', '250%');
        dropShadowFilter.append('svg:feGaussianBlur')
            .attr('in', 'SourceGraphic')
            .attr('stdDeviation', 12)
            .attr('result', 'blur-out');
        dropShadowFilter.append('svg:feColorMatrix')
            .attr('in', 'blur-out')
            .attr('type', 'hueRotate')
            .attr('values', 0)
            .attr('result', 'color-out');
        dropShadowFilter.append('svg:feOffset')
            .attr('in', 'color-out')
            .attr('dx', 0)
            .attr('dy', 0)
            .attr('result', 'the-shadow');
        dropShadowFilter.append('svg:feComponentTransfer')
            .attr('type', 'linear')
            .attr('slope', 0.2)
            .attr('result', 'shadow-opacity');
        dropShadowFilter.append('svg:feBlend')
            .attr('in', 'SourceGraphic')
            .attr('in2', 'the-shadow')
            .attr('mode', 'normal');

// Marker
        var marker = defs.append('svg:marker')
            .attr('id', 'marker-arrow')
            .attr('orient', 'auto')
            .attr('viewBox', '0 0 10 10')
            .attr('markerWidth', 8)
            .attr('markerHeight', 10)
            .attr('markerUnits', 'strokeWidth')
            .attr('refX', 0)
            .attr('refY', 2)
        marker.append('svg:polyline')
            .attr('points', '-6,-7 0,-4 6,-7 0,0')
            .attr('fill', 'red')

// Draw nodes (데이터의 size와 type으로 노드의 모양을 그리고, 색상 스타일 설정)
        var circle = node.append("path")
            .attr("d", d3.svg.symbol()
                .size(function (d) {
                    return d.size * 50;
                })
                .type(function (d) {
                    return d.type;
                }))
            .attr("class", "circle")
            .style(tocolor, function (d) {
                return color(d.color);
            });

//.style("filter", "url(#drop-shadow)");

        // text no used
// Format all text
        /*var text = group.selectAll(".text")
            .data(graph.nodes)
            .enter().append("text")
            .attr("dy", ".35em")
            .style("font-family", "Roboto")
            .style("font-weight", "400")
            .style("color", "#2C3E50")
            .style("font-size", nominal_text_size + "px");


        if (text_center) {
            text.text(function (d) {
                return d.id;
            })
                .style("text-anchor", "middle");
        } else {
            text.attr("dx", function (d) {
                return (size(d.size) || nominal_base_node_size);
            })
                .text(function (d) {
                    return '\u2002' + d.id;
                });
        }*/


////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////
////      Mouse Interactivity
////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////

// Mouse events
        node.on("mouseover", function (d) {
            // Change node details
            set_highlight(d);

            var path = $('#page-data').data('nanoporousAnalysis').pageContextPath;

            var tt = replaceAll(d.tooltip, "/path/", path + "/temp/nanoporous-png/");

            d3.select("#tooltip_content").html(tt + "<br/>");
        }).on("mousedown", function (d) {
            // TODO: This seems to only stop the one particular node from moving?

            d3.event.stopPropagation();
            focus_node = d;
            if (highlight_node === null) {
                set_highlight(d)
            }
        }).on("mouseout", function (d) {
            exit_highlight();
        });

        d3.select(window).on("mouseup", function () {
            if (focus_node !== null) {
                focus_node = null;
            }
            if (highlight_node === null) {
                exit_highlight();
            }
        });

// Node highlighting logic
        function exit_highlight() {
            highlight_node = null;
            if (focus_node === null) {
                svg.style("cursor", "move");
            }
        }

        function set_highlight(d) {
            svg.style("cursor", "pointer");
            if (focus_node !== null) d = focus_node;
        }


// Zoom logic
        zoom.on("zoom", function () {
            var stroke = nominal_stroke;
            var base_radius = nominal_base_node_size;
            if (nominal_base_node_size * zoom.scale() > max_base_node_size) {
                base_radius = max_base_node_size / zoom.scale();
            }

            // zoom에 따른 마커 크기 변환
            var pl = $('#marker-arrow').children().eq(0);
            //var ps = pl.attr("points");
            ps = '-6,-7 0,-4 6,-7 0,0';
            var pa = ps.split(" ");
            var pr = "";
            $.each(pa, function (i, v) {
                var cd = v.split(',');
                if (base_radius <= nominal_base_node_size) base_radius = nominal_base_node_size;
                var scal = (base_radius / nominal_base_node_size) / zoom.scale();
                if (i < 3) {
                    cd[0] = cd[0] * scal;
                    cd[1] = cd[1] * scal;
                    pr += Math.round(cd[0]) + "," + Math.round(cd[1]) + " ";
                } else {
                    pr += "0,0"
                }
            });
            pl.attr({"points": pr});

            var size = 0;
            circle.attr("d", d3.svg.symbol()
                .size(function (d) {
                    size = d;
                    return d.size * 50;
                })
                .type(function (d) {
                    return d.type;
                }))

            // text no used
            /*if (!text_center) text.attr("dx", function (d) {
                return (size(d.size) * base_radius / nominal_base_node_size || base_radius);
            });*/

            var text_size = nominal_text_size;
            if (nominal_text_size * zoom.scale() > max_text_size) {
                text_size = max_text_size / zoom.scale();
            }
            // text no used
            /*text.style("font-size", text_size + "px");*/

            group.attr("transform", "translate(" + d3.event.translate + ")scale(" + d3.event.scale + ")");
        });

        svg.call(zoom);
        resize();
        d3.select(window).on("resize", resize);

// Animation per tick
        force.on("tick", function () {
            node.attr("transform", function (d) {
                return "translate(" + d.x + "," + d.y + ")";
            });
            // text no used
            /*text.attr("transform", function (d) {
                return "translate(" + d.x + "," + d.y + ")";
            });*/

            link.attr("x1", function (d) {
                return d.source.x;
            })
                .attr("y1", function (d) {
                    return d.source.y;
                })
                .attr("x2", function (d) {
                    return d.target.x;
                })
                .attr("y2", function (d) {
                    return d.target.y;
                });
            node.attr("cx", function (d) {
                return d.x;
            })
                .attr("cy", function (d) {
                    return d.y;
                });
        });


// Resizing window and redraws
        function resize() {
            var width = window.innerWidth, height = window.innerHeight;
            var width = document.getElementById("canvas").offsetWidth;
            var height = document.getElementById("canvas").offsetHeight;
            svg.attr("width", width).attr("height", height);

            force.size([force.size()[0] + (width - w) / zoom.scale(),
                force.size()[1] + (height - h) / zoom.scale()]).resume();
            w = width;
            h = height;
        }


        function isNumber(n) {
            return !isNaN(parseFloat(n)) && isFinite(n);
        }

// Key press events
        window.addEventListener("keydown", function (event) {
            if (event.defaultPrevented) {
                return; // Do nothing if the event was already processed
            }

            switch (event.key) {
                case "f":
                    console.log("Freeze graph")
                    break;
                case "s":
                    // Do something for "s" key press.
                    node.style("filter", "url(#drop-shadow)");
                    break;
                case "c":
                    // Do something for "s" key press.
                    node.style("filter", null);
                    break;
                case "p":
                    // Turn to print mode, white backgrounds
                    d3.select("#kepler-mapper").attr('class', null).attr('class', "print")
                    break;
                case "d":
                    // Do something for "d" key press.
                    d3.select("#kepler-mapper").attr('class', null).attr('class', "display")
                    break;
                case "z":
                    force.gravity(0.0)
                        .charge(0.0);
                    resize();
                    break
                case "m":
                    force.gravity(0.07)
                        .charge(-1);
                    resize();
                    break
                case "e":
                    force.gravity(0.4)
                        .charge(-600);

                    resize();
                    break
                default:
                    return; // Quit when this doesn't handle the key event.
            }
// Cancel the default action to avoid it being handled twice
            event.preventDefault();
        }, true);

        function replaceAll(str, searchStr, replaceStr) {
            return str.split(searchStr).join(replaceStr);
        }

        function panesSizeSet() {
            var sd = {};
            sd.toolbarHeight = $("#toolbar").outerHeight();
            sd.headerHeight = $("#header").outerHeight();

            if (document.fullscreenElement || document.webkitFullscreenElement || document.mozFullScreenElement || document.msFullscreenElement) {
                sd.canvasHeight = $(window).innerHeight() - sd.toolbarHeight - sd.headerHeight;
            } else {
                sd.canvasHeight = $("#kepler-mapper").innerHeight() - sd.toolbarHeight - sd.headerHeight;
            }

            sd.canvasOuterWidth = $('#canvas').outerWidth();
            sd.canvasOuterHeight = $('#canvas').outerHeight();

            $('.pane_content').each(function(){
                var pdT = $(this).css('padding-top').split('px')[0];
                var pdB = $(this).css('padding-bottom').split('px')[0];
                $(this).height(sd.canvasHeight - pdT - pdB);
            });

            $('#canvas').height(sd.canvasHeight);
            $('#svg-graph').height(sd.canvasHeight);
            return sd
        }

        $('#fullscreen_control').on('click', function () {
            // if already full screen; exit
            // else go fullscreen
            if (
                document.fullscreenElement ||
                document.webkitFullscreenElement ||
                document.mozFullScreenElement ||
                document.msFullscreenElement
            ) {
                if (document.exitFullscreen) {
                    document.exitFullscreen();
                } else if (document.mozCancelFullScreen) {
                    document.mozCancelFullScreen();
                } else if (document.webkitExitFullscreen) {
                    document.webkitExitFullscreen();
                } else if (document.msExitFullscreen) {
                    document.msExitFullscreen();
                }
                $(this).find('.fa').removeClass('fa-compress');
                $(this).find('.fa').addClass('fa-expand');
            } else {
                element = $('#kepler-mapper').get(0);
                if (element.requestFullscreen) {
                    element.requestFullscreen();
                } else if (element.mozRequestFullScreen) {
                    element.mozRequestFullScreen();
                } else if (element.webkitRequestFullscreen) {
                    element.webkitRequestFullscreen(Element.ALLOW_KEYBOARD_INPUT);
                } else if (element.msRequestFullscreen) {
                    element.msRequestFullscreen();
                }
                $(this).find('.fa').removeClass('fa-expand');
                $(this).find('.fa').addClass('fa-compress');
            }

            setTimeout(function () {
                panesSizeSet();
            }, 500);
        });

    }
});