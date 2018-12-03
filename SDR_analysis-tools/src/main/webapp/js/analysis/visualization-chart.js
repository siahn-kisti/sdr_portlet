var VisualizationChart = Class.create({
    init: function (common) {
        var that = this;
        this.common = common;
        this.pageData = $('#page-data').data('visualizationChart');
        this.pn = this.pageData.portletNamespace;
        this.chart = null
        this.chartIndex = 1;
        this.option = {
            credits: {
                enabled: false
            },
            chart: {
                renderTo: 'highchartsContainer',
                type: '',
                options3d: ''
            },
            boost: {
                useGPUTranslations: true,
                usePreAllocated: true
            },
            title: {
                text: '',
                style: {
                    display: 'none'
                }
            },
            xAxis: {
                title: {
                    enabled: true,
                    text: ''
                },
                gridLineWidth: 1,
                startOnTick: true,
                endOnTick: true,
                showLastLabel: true
            },
            yAxis: {
                title: {
                    text: ''
                }
            },
            zAxis: {
                title: {
                    text: ''
                }
            },
            tooltip: {
                headerFormat: '',
                pointFormatter: function () {
                    return that.tooltipFormatter(this);
                }
            },
            plotOptions: {},
            series: []
        };
    },
    modifyFinalOption: function (x, y, z, data) {
        // this.option.title.text = x + ' vs ' + y;
        this.option.xAxis.title.text = x;
        this.option.yAxis.title.text = y;
        this.option.zAxis.title.text = z;

        this.seperateSeries(data);
    },
    seperateSeries: function (data) {
        var that = this;
        var $cate = $('#' + this.pageData.portletNamespace + 'pref-categorys');

        console.log($cate);

        that.option.series = [];

        // 카테고리가 없는 경우
        if (that.common.isBlank($cate.val()) || $cate.val() == '[]') {
            var seriesData = [];
            seriesData.showInLegend = false,
            seriesData.name = "Null";
            seriesData.data = data[0];
            seriesData.color = {
                radialGradient: { cx: 0.4, cy: 0.3, r: 0.5 },
                stops: [
                    [0, $.randomColor()],
                    [1, Highcharts.Color($.randomColor()).brighten(-0.2).get('rgb')]
                ]
            };
            seriesData.keys = ['x', 'y', 'z', 'title', 'datasetId'];
            that.option.series.push(seriesData);
        } else {
            var cateValue = JSON.parse($cate.val());
            var colorArray = $.randomColor({luminosity: 'light', count: cateValue.length});

            $.each(cateValue, function (i, e) {
                var seriesData = [];
                seriesData.name = e.label + '<br />' + data[i].length;

                seriesData.color = {
                    radialGradient: { cx: 0.4, cy: 0.3, r: 0.5 },
                    stops: [
                        [0, colorArray[i]],
                        [1, Highcharts.Color(colorArray[i]).brighten(-0.2).get('rgb')]
                    ]
                };

                seriesData.data = data[i];
                seriesData.keys = ['x', 'y', 'z', 'title', 'datasetId'];

                that.option.series.push(seriesData);
            });
        }
    },
    tooltipFormatter: function (that) {
        return '<strong>' + that.title + '</strong> (' + that.datasetId + ') <br />' +
            this.option.xAxis.title.text + ': ' + that.x + '<br />' +
            this.option.yAxis.title.text + ': ' + that.y + '<br />' +
            this.option.zAxis.title.text + ': ' + that.z;
    },
    schemaSelect: function () {
        var that = this;
        $.ajax({
            type: 'post',
            url: $('#keyListURL').val(),
            dataType: 'json',
            data: $('#formVisualizationChart').serialize(), // data-types
            success: function (data) {

                $('.evt-parameters option').remove();

                $('.evt-parameters').append('<option value="">- Select -</option>');

                for (var i = 0; i < data.searchKeyList.length; i++) {
                    $('.evt-parameters').append('<option value="' + data.searchKeyList[i].title + '">' + data.searchKeyList[i].title + '</option>');
                }

                for (var i = 0; i < data.searchAllKeyList.length; i++) {
                    $('#evt-parameters-all').append('<option value="' + data.searchAllKeyList[i].title + '">' + data.searchAllKeyList[i].title + '</option>');
                }

                that.common.errorMessage($('#evt-error-message'), {text: 'Parameter loading is complete!'});
            },
            error: function (request, status, error) {
                console.log('code:' + request.status + '\n' + 'message:' + request.responseText + '\n' + 'error:' + error);
            }
        });
    },
    chartDrawing: function (type, message) {
        var that = this;

        var x = $('#' + that.pn + 'evt-x-axis option:selected').val();
        var y = $('#' + that.pn + 'evt-y-axis option:selected').val();
        var z = $('#' + that.pn + 'evt-z-axis option:selected').val();

        var zChecked = $('#radius').is(':checked');

        if (type != 'search') {
            $('#keywords').val('');
        }

        if (x == '' || y == '' || (z == '' && !zChecked)) {
            alert(message);
        } else {
            $.ajax({
                url: $('#makechartURL').val(),
                method: 'POST',
                data: $('#formVisualizationChart').serialize(),	// x-axis, y-axis, z-axis, data-types, keywords
                dataType: 'json',
                async: false,
                success: function (data) {
                    that.option.chart.type = 'scatter';
                    if ($('#radius').is(':checked')) {
                        that.option.chart.options3d = {
                            enabled: true,
                            drag: {
                                enabled: true,
                                flipAxes: true,
                                snap: 15,
                                animateSnap: true
                            },
                            alpha: 10,
                            beta: 30,
                            depth: 250,
                            viewDistance: 5,
                            fitToPlot: false,
                            frame: {
                                bottom: {size: 1, color: 'rgba(0,0,0,0.02)'},
                                back: {size: 1, color: 'rgba(0,0,0,0.04)'},
                                side: {size: 1, color: 'rgba(0,0,0,0.06)'}
                            }
                        }
                    } else {
                        that.option.chart.options3d = {
                            enabled: false
                        }
                    }
                    that.modifyFinalOption(x, y, z, data);

                    that.prependThreeChart();

                    that.chart = new Highcharts.Chart(that.option);

                    that.chartIndex = that.chart.index;
                },
                error: function (request, status, error) {
                    console.log('code:' + request.status + '\n' + 'message:' + request.responseText + '\n' + 'error:' + error);
                }
            });
        }
    },
    prependThreeChart: function() {
        var chartLength = $('#highchartsContainer').children('.highcharts-item-content').length;

        if (chartLength >= 3) {
            $('#highchartsContainer .highcharts-item-content:last-child').remove();
            $('#highchartsContainer .highcharts-item-title:last-child').remove();
        }

        var div = $('<div>')
            .addClass('highcharts-item-content')
            .attr('id', 'chart-' + chartLength);

        if (this.chart != null) {
            this.chartIndex = this.chartIndex + 2;
        }

        var title = $('<div>')
            .addClass('highcharts-item-title')
            .text("Chart No. " + this.chartIndex + " : " + this.option.xAxis.title.text + " vs " + this.option.yAxis.title.text);

        $('#highchartsContainer').prepend(div);
        $('#highchartsContainer').prepend(title);
        this.option.chart.renderTo = 'chart-' + chartLength;
    },
    initEvents: function () {
        var that = this;

        $('[data-toggle="tooltip"]').tooltip();

        var $edt = $('#' + that.pn + 'evt-data-types');

        if ($edt.length > 0) {
            $('#' + that.pn + 'evt-data-types').change(function () {
                if ($edt.val().length > 0) {
                    that.schemaSelect();
                }
            });
            // Data Type 하나 일 경우, select box 삭제 후 input hidden 으로 변환
            if ($edt.find('option').length == 2) {
                var form = $('#formVisualizationChart');
                var $input = $('<input>');
                $input.attr('type', 'hidden');
                $input.attr('name', that.pn + 'data-types');
                $input.val($edt.find('option:eq(1)').val());
                form.append($input);
                $edt.parents(".vc-input").remove();
                that.schemaSelect();
            }
        } else {
            that.schemaSelect();
        }

        $('#evt-parameters-all').change(function () {
            var that = $(this);
            var added_value = $('#keywords').val() + ' ' + that.val() + ': ';
            $('#keywords').val(added_value);
        });

        $('#' + that.pn + 'evt-z-axis').change(function () {
            if ($('.evt-parameters').val() == '' || $('.evt-parameters').val() == undefined) {
                $('#radius').attr('checked', false);
            } else {
                $('#radius').attr('checked', true);
            }
        });

        $('#chart').on('click', function (event) {
            that.chartDrawing('chart', 'Some values are not assigned');
        });

        $('#btnSearch').on('click', function (event) {
            that.chartDrawing('search', 'Choose values First!');
        });

        $('#btnReset').on('click', function (event) {
            that.chartDrawing('reset', 'Choose values First!');
        });

        $('#radius').on('click', function (event) {
            that.chartDrawing('search', 'Choose values First!');
        });

        $('#keywords').keydown(function (e) {
            if (e.keyCode == 13) {
                e.preventDefault();
                $('#btnSearch').trigger('click');
            }
        });
    }
});