var componentsGroup = Vvveb.ComponentsGroup['Library'] || [];

//adding components name
componentsGroup.push('Library/x3dom');
Vvveb.ComponentsGroup['Library'] = componentsGroup;

Vvveb.Components.extend("_base", "Library/x3dom", {
	name: "x3dom",
	attributes: ["data-component-x3dom"],
	image: "icons/custom/icon_14_x3dom.svg",
	dragHtml: '<img src="' + Vvveb.baseUrl + 'icons/chart.svg">',
	html: '<div data-component-x3dom class="x3dom" style="width:1000px; height:800px;" \
			data-file-type="{{finalPath}}" data-file-path="/Deer.x3d" >\
				<img width="100%" height="100%" src="/SDR_base-portlet/images/designer/x3dom_sample.png" style="pointer-events:none;"/>\
			</div>',
	dragStart: function (node)
	{
		var body = Vvveb.Builder.frameBody;

		if ($(".x3dom-script", body).length == 0)
		{
            //$(body).append("<lin k rel='stylesheet' type='text/css' href='https://www.x3dom.org/download/x3dom.css'/>");
            //$(body).append("<script type='text/javascript' src='https://www.x3dom.org/download/x3dom.init.js'> </script>");
            //$(body).append("<link class='x3dom-script' href='/SDR_base-portlet/js/x3dom/x3dom.css' type='text/css' rel='stylesheet'/>");
            //$(body).append("<script class='x3dom-script' src='/SDR_base-portlet/designer/plugin/components-x3dom-script.js' type='text/javascript'></script>");
            //$(body).append("<script class='x3dom-script' src='/SDR_base-portlet/js/x3dom/x3dom.js' type='text/javascript'></script>");
			$(body).append(
				"<script class='x3dom-script' type='text/javascript'>\
				$(document).ready(function() {\
					$('.x3dom').each(function (index) {\
					    var self = $(this).attr('id','x3dom_'+index);\
					    if(!validate(self)) return true;\
					    self.html('');\
					    var container = document.querySelector('#x3dom_'+index);\
						var path = this.dataset.fileType + this.dataset.filePath;\
                        var iframe = $('<iframe width=\"100%\" height=\"100%\" style=\"border:0px\"></iframe>');\
                        iframe.attr('src','/SDR_base-portlet/js/x3dom/x3dom.html');\
                        self.html(iframe);\
                        iframe.get(0).contentWindow.addEventListener('DOMContentLoaded',function(){\
                            iframe.get(0).contentWindow.filePath = path;\
                            iframe.get(0).contentWindow.scriptAppend(path, container);\
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
		},
        {
            sort: 3,
            name: "orientation",
            key: "orientation",
            htmlAttr: "data-file-ori",
            inputtype: TextInput
        },
        {
            sort: 4,
            name: "position",
            key: "position",
            htmlAttr: "data-file-pos",
            inputtype: TextInput
        },
        {
            sort: 5,
            name: "zNear",
            key: "zNear",
            htmlAttr: "data-file-zNear",
            inputtype: TextInput
        },
        {
            sort: 6,
            name: "zFar",
            key: "zFar",
            htmlAttr: "data-file-zFar",
            inputtype: TextInput
        }
	]
});
