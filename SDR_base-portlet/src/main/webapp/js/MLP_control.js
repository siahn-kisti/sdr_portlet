var MLP_control = {

    init: function(){
        MLP_control.setCheckboxRadio();
        MLP_control.setSlider();

        MLP_control.eventCheckboxs();
    },

    util: {
        removeSpecialChar: function (string) {
            var val = "";
            var pattern = /[^(a-zA-Z0-9)]/gi;   // 특수문자 제거

            if(pattern.test(string)){
                val = string.replace(pattern,"");
            }

            return val;
        }
    },

    eventCheckboxs: function() {
        var checkboxs = $('input[type=checkbox].mlp_checkbox');

        checkboxs.each(function () {

            if($(this)[0].checked == true){
                $(this).wrap('<div class="customCheckbox customCheckboxChecked"></div>');
            }else{
                $(this).wrap('<div class="customCheckbox"></div>');
            }
            $(this).before('<span>&#10004;</span>');
        });

        checkboxs.change(function () {
            if ($(this).is(':checked')) {
                $(this).parent().addClass('customCheckboxChecked');
            } else {
                $(this).parent().removeClass('customCheckboxChecked');
            }
        });
    },

    setCheckboxRadio: function() {

        $(".mlp_bigBody input[type=radio]").checkboxradio({
            icon: false
        });

        $("input[type=checkbox].algorithm_checkbox").checkboxradio();
    },

    setSlider: function () {

        var handle = $("#custom-handle");
        $("#slider").slider({
            create: function () {
                handle.text($(this).slider("value"));
            },
            slide: function (event, ui) {
                handle.text(ui.value);
            }
        });
    },

    setDropDown: function (context, displayName) {
        $(context.parentElement.parentElement.parentElement)
            .find(".dropdown-toggle")
            .html(displayName + '<span class="caret"></span>');
    }
};

MLP_control.init();


/*
$(function () {
    var checkboxs = $('input[type=checkbox].mlp_checkbox');

    checkboxs.each(function () {

        if($(this)[0].checked == true){
            $(this).wrap('<div class="customCheckbox customCheckboxChecked"></div>');
        }else{
            $(this).wrap('<div class="customCheckbox"></div>');
        }
        $(this).before('<span>&#10004;</span>');
    });

    checkboxs.change(function () {
        if ($(this).is(':checked')) {
            $(this).parent().addClass('customCheckboxChecked');
        } else {
            $(this).parent().removeClass('customCheckboxChecked');
        }
    });
})


$(function () {
    $(".mlp_bigBody input[type=radio]").checkboxradio({
        icon: false
    });
});

$(function () {
    $("input[type=checkbox].algorithm_checkbox").checkboxradio({});
});

$(function () {
    var handle = $("#custom-handle");
    $("#slider").slider({
        create: function () {
            handle.text($(this).slider("value"));
        },
        slide: function (event, ui) {
            handle.text(ui.value);
        }
    });
});

*/