var componentsGroup = Vvveb.ComponentsGroup['Library'] || [];

//adding components name
componentsGroup.push("Library/epub");
Vvveb.ComponentsGroup['Library'] = componentsGroup;

Vvveb.Components.extend("_base", "Library/epub", {
	name: "epub",
	attributes: ["data-component-epub"],
	image: "icons/custom/icon_08_epub.svg",
	dragHtml: '<img src="' + Vvveb.baseUrl + 'icons/chart.svg">',
	html: '<div data-component-epub class="epub" style="width:800px; height:1000px; background-color: #eeeeee;" \
			data-file-type="{{finalPath}}" data-file-path="/sample.epub">\
				EPUB is visible when you preview\
			</div>',

	dragStart: function (node)
	{
		var body = Vvveb.Builder.frameBody;

		if ($(".epub-script", body).length == 0)
		{
			$(body).append(
				"<script class='epub-script' type='text/javascript'>\
				$(document).ready(function() {\
					$('.epub').each(function (index) {\
						var path = encodeURIComponent(this.dataset.fileType + this.dataset.filePath);\
						var html = '<iframe src=\"/SDR_base-portlet/designer/plugin/components-epub.jsp?path='+path+'\" style=\"border:none; width:100%; height:100%\"></iframe>';\
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
