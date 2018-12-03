var componentsGroup = Vvveb.ComponentsGroup['Library'] || [];

//adding components name
componentsGroup.push('Library/p3d');
Vvveb.ComponentsGroup['Library'] = componentsGroup;

Vvveb.Components.extend("_base", "Library/p3d", {
	name: "p3d",
	attributes: ["data-component-p3d"],
	image: "icons/custom/icon_15_p3d.svg",
	dragHtml: '<img src="' + Vvveb.baseUrl + 'icons/chart.svg">',
	html: '<div data-component-p3d class="p3d" style="width:1000px; height:800px;"\
			data-file-type="{{finalPath}}" data-file-path="/cfd.p3d" >\
				<img width="100%" height="100%" src="/SDR_base-portlet/images/designer/p3d_sample.png" style="pointer-events:none;"/>\
			</div>',
	dragStart: function (node)
	{
		var body = Vvveb.Builder.frameBody;

		if ($(".p3d-script", body).length == 0)
		{
			$(body).append(
				"<script class='p3d-script' type='text/javascript'>\
				$(document).ready(function() {\
					$('.p3d').each(function (index) {\
					    var self = $(this).attr('id','p3d_'+index);\
					    if(!validate(self)) return true;\
					    self.html('');\
						var iframe = $('<iframe width=\"100%\" height=\"100%\" style=\"border:0px\"></iframe>');\
						var path = this.dataset.fileType + this.dataset.filePath;\
						iframe.attr('src','/SDR_base-portlet/js/p3dView/html/viewer.html');\
                        self.html(iframe);\
                        iframe.on('load',function(){\
                            iframe.get(0).contentWindow.filePath = path;\
                            iframe.get(0).contentWindow.scriptAppend();\
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
