var Analysis = Class.create({
    init: function () {
    },
    addZero: function (str, max) {
        str = str.toString();
        return str.length < max ? this.addZero("0" + str, max) : str;
    },
    addComma: function (str) {
        str = $.trim(str.toString());
        if (str.contains(",")) {
            return str;
        } else {
            return "," + str
        }
    },
    ajaxFileDownload: function (url, data, method) {
        // url과 data를 입력받음
        if (url && data) {
            // data 는  string 또는 array/object 를 파라미터로 받는다.
            data = typeof data == 'string' ? data : jQuery.param(data);
            // 파라미터를 form의  input으로 만든다.
            var inputs = '';
            jQuery.each(data.split('&'), function () {
                var pair = this.split('=');
                inputs += '<input type="hidden" name="' + pair[0] + '" value="' + pair[1] + '" />';
            });

            // request를 보낸다.
            jQuery('<form action="' + url + '" method="' + (method || 'post') + '" target="fileDownloadFrame">' + inputs + '</form>')
                .appendTo('body').submit().remove();
        }
        ;
    },
    jsonToTable: function (jsonData) {
        var table = $('<table>');
        var tblHeader = "<tr>";
        for (var k in jsonData[0]) tblHeader += "<th>" + k + "</th>";
        tblHeader += "</tr>";
        $(tblHeader).appendTo(table);
        $.each(jsonData, function (index, value) {
            var TableRow = "<tr>";
            $.each(value, function (key, val) {
                TableRow += "<td>" + val + "</td>";
            });
            TableRow += "</tr>";
            $(table).append(TableRow);
        });
        return ($(table));
    },
    jsonToDiv: function (jsonData, title) {
        console.log('jsonData', jsonData);

        var base_dl = '<dl class="dl-title"><dt></dt><dd>' + title + '<br/>Properties</dd></dl>';
        var area = base_dl;
        $.each(jsonData, function (key, val) {
            var dl = "<dl>";
            dl += "<dt>" + key.replace(/_/gi, " ");
            +"</dt>";

            //TODO: toFixed error or isNumber 처리로 변경필요
            if (key == "Space_Group_Symbol" || key == "Range") {
                dl += "<dd>" + val + "</dd>";
            } else {
                dl += "<dd>" + val.toFixed(3) + "</dd>";
            }

            dl += "</dl>";
            area += dl;
        });
        return ($(area));
    },
    errorMessage: function (elements, options) {
        options = $.extend({
            text: "Done",
            time: 3000,
            how: "before",
            class_name: ""
        }, options);

        var message = $("<span />", {
            "class": "errorMessage " + options.class_name,
            text: options.text
        }).hide().fadeIn("fast");

        elements.html(message);

        message.delay(options.time).fadeOut("normal", function () {
            message.remove();
        });
    },
    isEmailAddress: function (str) {
        var pattern = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
        return pattern.test(str);  // returns a boolean
    },
    isNotEmpty: function (str) {
        var pattern = /\S+/;
        return pattern.test(str);  // returns a boolean
    },
    isNumber: function (str) {
        var pattern = /^\d+$/;
        return pattern.test(str);  // returns a boolean
    },
    isSame: function (str1, str2) {
        return str1 === str2;
    },
    isBlank: function (obj) {
        if ($.trim(obj).length == 0 || obj == null || obj == undefined) {
            return true;
        } else {
            return false;
        }
    },
    getRandomHslColor: function (colorNum, colors) {
        if (colors < 1) colors = 1; // defaults to one color - avoid divide by zero
        return "hsl(" + (colorNum * (360 / colors) % 360) + ", 100%, 70%)";
    },
    getRandomRgbColor: function () {
        var r = Math.floor(Math.random() * 256);          // Random between 0-255
        var g = Math.floor(Math.random() * 256);          // Random between 0-255
        var b = Math.floor(Math.random() * 256);          // Random between 0-255

        return 'rgb(' + r + ',' + g + ',' + b + ')'; // Collect all to a string
    },
    getRainbowRgbColorfunction: function (numOfSteps, step) {
        var r, g, b;
        var h = step / numOfSteps;
        var i = ~~(h * 6);
        var f = h * 6 - i;
        var q = 1 - f;

        switch(i % 6){
            case 0: r = 1; g = f; b = 0; break;
            case 1: r = q; g = 1; b = 0; break;
            case 2: r = 0; g = 1; b = f; break;
            case 3: r = 0; g = q; b = 1; break;
            case 4: r = f; g = 0; b = 1; break;
            case 5: r = 1; g = 0; b = q; break;
        }
        console.log('rgb(' + r * 255 + ',' + g * 255 + ',' + b * 255 + ')')
        return 'rgb(' + r * 255 + ',' + g * 255 + ',' + b * 255 + ')'; // Collect all to a string
    },
    initEvents: function () {

        $.ajaxSetup({'global': true});

        $(document).ajaxStart(function () {
            $("#icon-loding").show();
        });

        $(document).ajaxComplete(function () {
            $("#icon-loding").hide();
        });

        var ranges = [
            {divider: 1e18, suffix: 'P'},
            {divider: 1e15, suffix: 'E'},
            {divider: 1e12, suffix: 'T'},
            {divider: 1e9, suffix: 'G'},
            {divider: 1e6, suffix: 'M'},
            {divider: 1e3, suffix: 'k'}
        ];

        function formatNumber(n) {
            for (var i = 0; i < ranges.length; i++) {
                if (n >= ranges[i].divider) {
                    return Math.floor(n / ranges[i].divider).toString() + ranges[i].suffix;
                }
            }
            return n.toString();
        }

        // $('.animatedNumberCount').each(function (i, e) {
        //     $(this).prop('Counter', 0).animate({
        //         Counter: $(e).text()
        //     }, {
        //         duration: 2000,
        //         easing: 'linear',
        //         step: function (now) {
        //             if (now >= 1000) {
        //                 $(this).text(formatNumber(now));
        //             } else {
        //                 $(this).text(String(Math.ceil(now)).replace(/\B(?=(\d{3})+(?!\d))/g, ','));
        //             }
        //         }
        //     });
        // });
    }
});