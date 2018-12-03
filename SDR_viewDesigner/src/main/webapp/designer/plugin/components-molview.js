var componentsGroup = Vvveb.ComponentsGroup['Library'] || [];

//adding components name
componentsGroup.push('Library/molview');
Vvveb.ComponentsGroup['Library'] = componentsGroup;

Vvveb.Components.extend("_base", "Library/molview", {
	name: "molview",
	attributes: ["data-component-molview"],
	image: "icons/custom/icon_18_molview.svg",
	dragHtml: '<img src="' + Vvveb.baseUrl + 'icons/chart.svg">',
	html: '<div data-component-molview class="molview" style="width:1000px; height:800px;" \
			data-browser="Chrome|Opera|Firefox|Safari"\
			data-file-type="{{finalPath}}" data-file-path="/molView.mol" data-file-list="{{fileList}}">\
				<img width="100%" height="100%" src="/SDR_base-portlet/images/designer/molview_sample.png" style="pointer-events:none;"/>\
			</div>',
	dragStart: function (node)
	{
		var body = Vvveb.Builder.frameBody;

		if ($(".molview-script", body).length == 0)
		{
			$(body).append(
				"<script class='molview-script' type='text/javascript'>\
				$(document).ready(function() {\
					$('.molview').each(function (index) {\
					    var self = $(this).attr('id','molview_'+index);\
					    if(!validate(self)) return true;\
					    var path = this.dataset.fileType + this.dataset.filePath;\
					    $.ajax({\
					        type: 'GET',\
					        url: path,\
					        dataType: 'text',\
					        success: function(data) {\
					            var result = data.split(/\\n/).join('\\n');\
					            self.html('');\
					            var iframe = $('<iframe width=\"100%\" height=\"100%\" style=\"border:0px\"></iframe>');\
					            iframe.attr('src','/SDR_base-portlet/js/molview/viewer.html');\
					            self.html(iframe);\
                                iframe.get(0).contentWindow.addEventListener('DOMContentLoaded',function(){\
                                        this.scriptAppend(result);\
                                });\
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
