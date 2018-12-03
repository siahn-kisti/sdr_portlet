/*
 * NumberedTextarea - jQuery Plugin
 * Textarea with line numbering
 *
 * Copyright (c) 2015 Dariusz Arciszewski
 *
 * Requires: jQuery v2.0+
 *
 * Licensed under the GPL licenses:
 *   http://www.gnu.org/licenses/gpl.html
 */

(function ($) {
 
    $.fn.numberedtextarea = function(options) {
 
        var settings = $.extend({
            color:          null,        // Font color
            borderColor:    null,        // Border color
            class:          null,        // Add class to the 'numberedtextarea-wrapper'
            allowTabChar:   true,       // If true Tab key creates indentation
        }, options);
 
        this.each(function() {
            if(this.nodeName.toLowerCase() !== "textarea") {
                console.log('This is not a <textarea>, so no way Jose...');
                return false;
            }
            
            addWrapper(this, settings);
            addLineNumbers(this, settings);
            
            if(settings.allowTabChar) {
                $(this).allowTabChar();
            }
        });
        
        return this;
    };
    
    $.fn.allowTabChar = function() {
        if (this.jquery) {
            this.each(function() {
                if (this.nodeType == 1) {
                    var nodeName = this.nodeName.toLowerCase();
                    if (nodeName == "textarea" || (nodeName == "input" && this.type == "text")) {
                        allowTabChar(this);
                    }
                }
            })
        }
        return this;
    }
    
    function addWrapper(element, settings) {
        var wrapper = $('<div class="numberedtextarea-wrapper"></div>').insertAfter(element);
        $(element).detach().appendTo(wrapper);
    }
    
    function addLineNumbers(element, settings) {
        element = $(element);
        console.log(element.css);
        var wrapper = element.parents('.numberedtextarea-wrapper');
        
        // Get textarea styles to implement it on line numbers div
        var paddingLeft = parseFloat(element.css('padding-left'));
        var paddingTop = parseFloat(element.css('padding-top'));

        var paddingBottom = parseFloat(element.css('padding-bottom'));
        var lineNumbers = $('<div class="numberedtextarea-line-numbers"></div>').insertAfter(element);
        
        element.css({
            paddingLeft: paddingLeft + lineNumbers.width() + 'px'
        }).on('input propertychange change keyup paste', function() {
            renderLineNumbers(element, settings);
        }).on('scroll', function() {
            scrollLineNumbers(element, settings);
        }); 
        
        lineNumbers.css({
            paddingLeft: paddingLeft + 'px',
            paddingTop: paddingTop + 'px',
            lineHeight: element.css('line-height'),
            fontFamily: element.css('font-family'),
            width: lineNumbers.width() - paddingLeft + 'px',
        });
        
        element.trigger('change');
    }
    
    function renderLineNumbers(element, settings) {
        element = $(element);
        
        var linesDiv = element.parent().find('.numberedtextarea-line-numbers');
        var count = element.val().split("\n").length;
        var paddingBottom = parseFloat(element.css('padding-bottom'));

        linesDiv.find('.numberedtextarea-number').remove();
        linesDiv.find('.circle').remove();
        linesDiv.find('.tooltip').remove();

        linesDiv.find('.taglib-icon-help').remove();
        linesDiv.find('.hide-accessible tooltip-text').remove();
        /*linesDiv.find('.circle1').remove();*/
        /*alert("count : " + count);*/
        for(i = 1; i<=count; i++) {
            var line = $('<div id="textareaTooltip' + i +'" class="circle circle-' + i +'"></div>' +
                /*'<span style="float: left;" class="taglib-icon-help"><div tabindex="0" ' +
                ' onmouseover="Liferay.Portal.ToolTip.show(this);" onfocus="Liferay.Portal.ToolTip.show(this);" onblur="Liferay.Portal.ToolTip.hide();" aria-labelledby="hbfl' + i +'" alt="">&nbsp;</div>' +
                '<span class="hide-accessible tooltip-text" id="hbfl' + i +'">Help, I\'m trapped inside this icon! ' + i + ' </span></span>' +*/
                '<div class="numberedtextarea-number numberedtextarea-number-' + i + '" style="font-size: 17px;">' + i + '</div>').appendTo(linesDiv);
            if(i === count) {
            	line.css('margin-bottom', paddingBottom + 'px');
            }
        }
    }
    
    function scrollLineNumbers(element, settings) {
        element = $(element);
        var linesDiv = element.parent().find('.numberedtextarea-line-numbers');
        linesDiv.scrollTop(element.scrollTop());
    }
    
    function pasteIntoInput(el, text) {
        el.focus();
        if (typeof el.selectionStart == "number") {
            var val = el.value;
            var selStart = el.selectionStart;
            el.value = val.slice(0, selStart) + text + val.slice(el.selectionEnd);
            el.selectionEnd = el.selectionStart = selStart + text.length;
        } else if (typeof document.selection != "undefined") {
            var textRange = document.selection.createRange();
            textRange.text = text;
            textRange.collapse(false);
            textRange.select();
        }
    }

    function allowTabChar(el) {
        $(el).keydown(function(e) {
            if (e.which == 9) {
                pasteIntoInput(this, "\t");
                return false;
            }
        });

        // For Opera, which only allows suppression of keypress events, not keydown
        $(el).keypress(function(e) {
            if (e.which == 9) {
                return false;
            }
        });
    }
 
}(jQuery));