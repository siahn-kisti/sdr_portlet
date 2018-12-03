var componentsGroup = Vvveb.ComponentsGroup['Library'] || [];

//adding components name
componentsGroup.push('Library/paraview');
Vvveb.ComponentsGroup['Library'] = componentsGroup;

Vvveb.Components.extend("_base", "Library/paraview", {
	name: "paraview",
	attributes: ["data-component-paraview"],
	image: "icons/custom/icon_06_paraview.svg",
	dragHtml: '<img src="' + Vvveb.baseUrl + 'icons/chart.svg">',
	html: '<div data-component-paraview class="paraview" style="width:1000px; height:800px;" \
			data-browser="Chrome|Opera|Firefox|Safari"\
			data-file-type="{{finalPath}}" data-file-path="/output.vtp" data-file-list="{{fileList}}">\
				<img width="100%" height="100%" src="/SDR_base-portlet/images/designer/paraviewSample.jpg" style="pointer-events:none;"/>\
			</div>',

	dragStart: function (node)
	{
		var body = Vvveb.Builder.frameBody;

		if ($(".paraview-script", body).length == 0)
		{
			$(body).append("<script class='paraview-script' src='/SDR_base-portlet/js/glance/glance.js?20180403' type='text/javascript'></script>");
			$(body).append("<script class='paraview-script' src='/SDR_base-portlet/js/glance/glance-external-ITKReader.js?20180403' type='text/javascript'></script>");
			$(body).append("<script class='paraview-script' src='/SDR_base-portlet/js/glance/glance-external-Workbox.js' type='text/javascript'></script>");
			$(body).append(
				"<script class='paraview-script' type='text/javascript'>\
				$(document).ready(function() {\
					$('.paraview').each(function (index) {\
						var self = $(this).attr('id','paraview_'+index);\
						if(!validate(self)) return true;\
						var container = document.querySelector('#paraview_'+index);\
						var viewer = Glance.createViewer(container);\
						var path = this.dataset.fileType + this.dataset.filePath;\
						var fileName = this.dataset.filePath;\
						$(container).children().children().eq(1).children().css('height',$( container ).height()-$(container).children().children().eq(0).height());\
						if(fileName.indexOf('*') > -1) {\
							var index = path.indexOf('SDR_baseportlet_path');\
							var oldPath = path.substring(0, index+21);\
							var newPath = path.substring(index+21);\
							var multiPath = $(this).attr('data-file-list');\
							var multiDatasetPath = multiPath + newPath;\
							$.ajax({\
								url: multiDatasetPath,\
								type: 'GET',\
								dataType: 'json',\
								success: function(data){ \
									for(var i in data){\
										var fileName = data[i].fileName;\
										var filePath = oldPath + data[i].filePath;\
										console.log(fileName);\
										console.log(filePath);\
										viewer.loadURL(fileName, filePath);\
									}\
								},\
								error: function() { alert('File Path Error!!!');}\
							});}\
						else{\
							viewer.loadURL(this.dataset.filePath, path);\
						}\
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
