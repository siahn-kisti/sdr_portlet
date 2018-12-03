var componentsGroup = Vvveb.ComponentsGroup['Library'] || [];

//adding components name
componentsGroup.push('Library/jsmol');
Vvveb.ComponentsGroup['Library'] = componentsGroup;

Vvveb.Components.extend("_base", "Library/jsmol", {
	name: "jsmol",
	attributes: ["data-component-jsmol"],
	image: "icons/custom/icon_05_jsmol.svg",
	dragHtml: '<img src="' + Vvveb.baseUrl + 'icons/chart.svg">',
	html: '<div data-component-jsmol class="jsmol" style="width:400px; height:400px;" \
			data-config=\'{\
				"width" : "100%",\
				"height" : "100%",\
				"color" : "#FFF",\
				"addSelectionOptions" : false,\
				"use" : "HTML5",\
				"j2sPath" : "/SDR_base-portlet/js/jsmol/j2s",\
				"script" : "set antialiasDisplay; load ",\
				"disableJ2SLoadMonitor" : true,\
				"disableInitialConsole" : true,\
				"allowJavaScript" : true\
			}\' data-file-type="{{finalPath}}" data-file-path="/POSCAR">\
				<img width="100%" height="100%" src="/SDR_base-portlet/images/designer/jsmol_preSample.jpg" style="pointer-events:none;"/>\
			</div>',
	
	dragStart: function (node)
	{
		var body = Vvveb.Builder.frameBody;
		
		if ($(".jsmol-script", body).length == 0)
		{
            $(body).append("<script class='jsmol-script' src='/SDR_base-portlet/js/jsmol/JSmol.min.nojq.js' type='text/javascript'></script>");
			$(body).append(
				"<script class='jsmol-script' type='text/javascript'>\
				$(document).ready(function() {\
					$('.jsmol').each(function (index) {\
						var self = $(this).attr('id','jsmol_'+index);\
						if(!validate(self)) return true;\
						var config = JSON.parse(this.dataset.config);\
						config['script'] = config['script'] + this.dataset.fileType + this.dataset.filePath;\
						$(this).html(Jmol.getAppletHtml('jsmol_'+index, config));\
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
