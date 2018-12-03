var componentsGroup = Vvveb.ComponentsGroup['Library'] || [];

//adding components name
componentsGroup.push('Library/html');
Vvveb.ComponentsGroup['Library'] = componentsGroup;

Vvveb.Components.extend("_base", "Library/html", {
    name: "html",
    attributes: ["data-component-html"],
    image: "icons/custom/icon_13_html.svg",
    dragHtml: '<img src="' + Vvveb.baseUrl + 'icons/chart.svg">',
    html: '<div data-component-html class="html" data-file-type="{{finalPath}}" data-file-path="/html/index.html"> \
				<div style="width:100%; height:270px; background-color: #eeeeee; pointer-events:none;">\
				HTML component is visible when you preview\
				</div>\
			</div>',

    dragStart: function (node)
    {
        var body = Vvveb.Builder.frameBody;

        if ($(".html-script", body).length == 0)
        {
            $(body).append(
                "<script class='html-script' type='text/javascript'>\
				$(document).ready(function() {\
					$('.html').each(function (index) {\
						var self = $(this).attr('id','html_'+index);\
						if(!validate(self)) return true;\
						var url = Scope().getHtmlURL;\
						var namespace = '_sdrcommon_WAR_SDR_baseportlet_';\
						var param = {};\
						param[namespace+'path'] = getRealPath(self) + $(this).data('filePath');\
						$.ajax({\
                           type : 'POST',\
                           dataType:'json',\
                           url : url,\
                           data : param,\
                           success : function(e) {\
                               if (e.data == undefined) {\
                                   $('#html_' + index).html(e.error);\
                               }else{\
                                   var iframe = $('<iframe width=\"100%\" height=\"100%\" style=\"border:0px\"></iframe>');\
                                   $('#html_' + index).html(iframe);\
                                   var iframeBody = iframe.contents().find('body');\
                                   var html = parseHTML(self, e.data);\
                                   iframeBody.html(html).trigger('create');\
                                   setTimeout(function(){\
                                       var previewIframe = iframe.get(0).contentWindow;\
                                       var h = previewIframe.document.body.offsetHeight;\
                                       iframe.height(h+60);\
                                   }, 1000)\
                               }\
                           },\
                           error: function(e){\
                               $('#coordinate_'+index).html('There was an error in the metadata and no coordinate table was created.');\
                               console.log('error', e);\
                           }\
                        });\
					});\
				});\
				</script>"
            );
        }

        return node;
    },

    init: function (node)
    {
        this.node = node;
        return node;
    },


    beforeInit: function (node)
    {
        return node;
    },

    properties: [
        {
            sort: 1,
            name: "File Type",
            key: "fileType",
            htmlAttr: "data-file-type",
            inputtype: SelectInput,
            data:{
                options: [{
                    text: "Final Path",
                    value: "{{finalPath}}"
                }, {
                    text: "Meta Path",
                    value: "{{metaPath}}"
                }, {
                    text: "Another",
                    value: ""
                }]
            }
        },
        {
            sort: 2,
            name: "File Path",
            key: "filePath",
            htmlAttr: "data-file-path",
            inputtype: TextInput
        }
    ]

});
