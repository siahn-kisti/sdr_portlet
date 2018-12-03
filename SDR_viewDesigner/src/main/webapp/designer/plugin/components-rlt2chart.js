var componentsGroup = Vvveb.ComponentsGroup['Library'] || [];

//adding components name
componentsGroup.push("Library/rlt2chart");
Vvveb.ComponentsGroup['Library'] = componentsGroup;

Vvveb.Components.extend("_base", "Library/rlt2chart", {
	name: "rlt2chart",
	attributes: ["data-component-rlt2chart"],
	image: "icons/custom/icon_10_xrd.chart.svg",
	dragHtml: '<img src="' + Vvveb.baseUrl + 'icons/chart.svg">',
	html: '<div data-component-rlt2chart class="rlt2chart" style="width:800px; height:500px; background-color: #eeeeee;" \
			data-file-type="{{finalPath}}" data-file-path="/error.rlt" data-file-list="{{fileList}}">RLT File To 2D Chart</div>',

	dragStart: function (node)
	{
		var body = Vvveb.Builder.frameBody;

		if ($(".rlt2chart-script", body).length == 0)
		{
			/*$(body).append("<link class='rlt2chart-script' href='/SDR_base-portlet/js/font-awesome/font-awesome.min.css' rel='stylesheet'>");
			$(body).append("<script class='rlt2chart-script' src='/SDR_base-portlet/js/rlt2chart/popper.min.js' type='text/javascript'></script>");
			$(body).append("<script class='rlt2chart-script' src='/SDR_base-portlet/js/rlt2chart/plotly-latest.min.js' type='text/javascript'></script>");
			$(body).append("<script class='rlt2chart-script' src='/SDR_base-portlet/js/rlt2chart/rlt2chart.js?3' type='text/javascript'></script>");*/
			$(body).append(
				"<script class='rlt2chart-script' type='text/javascript'>\
				$(document).ready(function() {\
					$('.rlt2chart').each(function (index) {\
					    var self = $(this).attr('id','rlt2chart_'+index);\
					    if(!validate(self)) return true;\
						var path = this.dataset.fileType + this.dataset.filePath;\
						var multiPath = $(this).attr('data-file-list');\
						$(this).attr('id','rlt2chart_'+index);\
						$(this).html('');\
						$(this).css('backgroundColor', 'white');\
						var uriPath = encodeURIComponent(path);\
                        var uriText = encodeURIComponent(this.dataset.filePath);\
                        var uriMultiPath = encodeURIComponent(multiPath);\
                        var html = '<iframe src=\"/SDR_base-portlet/designer/plugin/components-rlt2chart.jsp?path='+uriPath+'&text='+uriText+'&multiPath='+uriMultiPath+'\" style=\"border:none; width:100%; height:100%\"></iframe>';\
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
