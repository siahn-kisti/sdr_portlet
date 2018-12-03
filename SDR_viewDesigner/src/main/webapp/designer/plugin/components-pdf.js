var componentsGroup = Vvveb.ComponentsGroup['Library'] || [];

//adding components name
componentsGroup.push("Library/pdf");
Vvveb.ComponentsGroup['Library'] = componentsGroup;

Vvveb.Components.extend("_base", "Library/pdf", {
	name: "pdf",
	attributes: ["data-component-pdf"],
	image: "icons/custom/icon_07_pdf.svg",
	dragHtml: '<img src="' + Vvveb.baseUrl + 'icons/chart.svg">',
	html: '<div data-component-pdf class="pdf" style="width:800px; height:1000px; background-color: #eeeeee;" \
			data-file-type="{{finalPath}}" data-file-path="/sample.pdf">\
				PDF is visible when you preview\
			</div>',

	dragStart: function (node)
	{
		var body = Vvveb.Builder.frameBody;

		if ($(".pdf-script", body).length == 0)
		{
			$(body).append(
				"<script class='pdf-script' type='text/javascript'>\
				$(document).ready(function() {\
					$('.pdf').each(function (index) {\
						$(this).attr('id','pdf_'+index);\
						var path = this.dataset.fileType + this.dataset.filePath;\
						var iframe = $('<iframe width=\"100%\" height=\"100%\" style=\"border:0px\"></iframe>');\
						$('#pdf_'+index).html(iframe);\
						var pdf_js = '/SDR_base-portlet/js/pdfjs/web/viewer.html?file=';\
						path = path.replace(/\\\\/g,'/');\
						var pdf_path = pdf_js + encodeURIComponent(path);\
						iframe.attr('src', pdf_path);\
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
			inputtype: TextInput,
			htmlAttr: "data-file-path"
		}
	]
});
