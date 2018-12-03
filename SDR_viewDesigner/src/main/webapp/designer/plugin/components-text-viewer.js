var componentsGroup = Vvveb.ComponentsGroup['Library'] || [];

//adding components name
componentsGroup.push('Library/textviewer');
Vvveb.ComponentsGroup['Library'] = componentsGroup;

Vvveb.Components.extend("_base", "Library/textviewer", {
	name: "text",
	attributes: ["data-component-textviewer"],
	image: "icons/custom/icon_18_text.svg",
	dragHtml: '<img src="' + Vvveb.baseUrl + 'icons/text_area.svg">',
	html: '<div data-component-textviewer class="textviewer" style="width:400px; height:400px; background-color: #eeeeee; overflow: auto;" \
				data-file-type="{{finalPath}}" data-file-path="/text_name">\
				Text is visible when you preview\
			</div>',
	
	dragStart: function (node)
	{
		var body = Vvveb.Builder.frameBody;
		
		if ($(".textviewer-script", body).length == 0)
		{
			$(body).append(
				"<script class='textviewer-script' type='text/javascript'>\
				$(document).ready(function() {\
					$('.textviewer').each(function (index) {\
						var self = $(this).attr('id','textviewer_'+index);\
						if(!validate(self)) return true;\
					    var path = this.dataset.fileType + this.dataset.filePath;\
					    var container = document.querySelector('#textviewer_'+index);\
					    $.ajax({\
							type: 'GET',\
							url: path,\
							dataType: 'text',\
							success: function(data) {\
								container.innerHTML = data;\
							},\
							error:function(d, e){\
								console.log('Error');\
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
