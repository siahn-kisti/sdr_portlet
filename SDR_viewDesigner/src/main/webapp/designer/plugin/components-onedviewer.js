var componentsGroup = Vvveb.ComponentsGroup['Library'] || [];

//adding components name
componentsGroup.push("Library/onedviewer");
Vvveb.ComponentsGroup['Library'] = componentsGroup;

Vvveb.Components.extend("_base", "Library/onedviewer", {
    name: "onedviewer",
    attributes: ["data-component-onedviewer"],
    image: "icons/custom/icon_10_xrd.chart.svg",
    dragHtml: '<img src="' + Vvveb.baseUrl + 'icons/chart.svg">',
    html: '<div data-component-onedviewer class="onedviewer" style="width:800px; height:500px; background-color: #eeeeee;" \
			data-file-type="{{finalPath}}" data-file-path="/CB1.oneD" data-file-list="{{fileList}}">OneD Viewer</div>',

    dragStart: function (node)
    {
        var body = Vvveb.Builder.frameBody;

        if ($(".onedviewer-script", body).length == 0)
        {
            //$(body).append("<script class='onedviewer-script' src='/SDR_base-portlet/js/onedviewer/plotly-latest.js' type='text/javascript'></script>");
            //$(body).append("<script class='onedviewer-script' src='/SDR_base-portlet/js/onedviewer/onedviewer.js' type='text/javascript'></script>");
            $(body).append(
                "<script class='onedviewer-script' type='text/javascript'>\
				$(document).ready(function() {\
					$('.onedviewer').each(function (index) {\
						var self = $(this).attr('id','onedviewer_'+index);\
						if(!validate(self)) return true;\
						var path = this.dataset.fileType + this.dataset.filePath;\
						var multiPath = $(this).attr('data-file-list');\
						$(this).attr('id','onedviewer_'+index);\
						$(this).html('');\
						$(this).css('backgroundColor', 'white');\
						var uriPath = encodeURIComponent(path);\
						var uriText = encodeURIComponent(this.dataset.filePath);\
						var uriMultiPath = encodeURIComponent(multiPath);\
						var html = '<iframe src=\"/SDR_base-portlet/designer/plugin/components-onedviewer.jsp?path='+uriPath+'&text='+uriText+'&multiPath='+uriMultiPath+'\" style=\"border:none; width:100%; height:100%\"></iframe>';\
						$(this).html(html);\
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
