var componentsGroup = Vvveb.ComponentsGroup['Library'] || [];

//adding components name
componentsGroup.push("Library/xrd");
componentsGroup.push("Library/dos");
Vvveb.ComponentsGroup['Library'] = componentsGroup;


Vvveb.Components.extend("_base", "Library/xrd", {
	name: "xrd",
	attributes: ["data-component-xrd"],
	image: "icons/custom/icon_10_xrd.chart.svg",
	dragHtml: '<img src="' + Vvveb.baseUrl + 'icons/chart.svg">',
	html: '<div data-component-xrd class="xrd" style="width:800px; height:500px; background-color: #eeeeee; text-align: center;" \
			data-file-type="{{metaPath}}" data-file-path="/derived/">\
				<div class="btn-group" data-toggle="buttons" style="pointer-events:none;">\
					<button class="btn btn-default active" onclick="xrd.changeType(\'xrd_CuKa.json\');" style="pointer-events:none;">Cu</button>\
					<button class="btn btn-default" onclick="xrd.changeType(\'xrd_AgKa.json\');" style="pointer-events:none;">Ag</button>\
					<button class="btn btn-default" onclick="xrd.changeType(\'xrd_MoKa.json\');" style="pointer-events:none;">Mo</button>\
					<button class="btn btn-default" onclick="xrd.changeType(\'xrd_FeKa.json\');" style="pointer-events:none;">Fe</button>\
				</div>\
				<div class="xrd-graph" style="pointer-events:none;">XRD Chart is visible when you preview</div>\
			</div>',

	dragStart: function (node)
	{
		var body = Vvveb.Builder.frameBody;

		if ($(".chart-script", body).length == 0)
		{
			$(body).append("<script class='chart-script' src='/SDR_base-portlet/js/highcharts/highcharts.js' type='text/javascript'></script>");
			$(body).append("<script class='chart-script' src='/SDR_base-portlet/js/highcharts/exporting.js' type='text/javascript'></script>");
			$(body).append("<script class='chart-script' src='/SDR_base-portlet/designer/plugin/components-chart-script.js' type='text/javascript'></script>");
		}
		
		if ($(".xrd-script", body).length == 0)
		{
			$(body).append(
				"<script class='xrd-script' type='text/javascript'>\
				$(document).ready(function() {\
					$('.xrd').each(function (index) {\
						$(this).find('.xrd-graph').attr('id','xrd-graph-'+index);\
						console.log($(this).find('.xrd-graph'));\
						var path = this.dataset.fileType + this.dataset.filePath;\
						console.log('path', path);\
						xrd.init(path, 'xrd-graph-'+index);\
					});\
				});\
				</script>"
			);
		}

		return node;
	}
	
});

Vvveb.Components.extend("_base", "Library/dos", {
	name: "dos",
	attributes: ["data-component-dos"],
	image: "icons/custom/icon_11_dos.chart.svg",
	dragHtml: '<img src="' + Vvveb.baseUrl + 'icons/chart.svg">',
	html: '<div data-component-dos class="dos" style="width:800px; height:500px; background-color: #eeeeee; text-align: center;" \
			data-file-type="{{metaPath}}" data-file-path="/derived/">\
				<div class="dos-graph" style="pointer-events:none;">DOS Chart is visible when you preview</div>\
			</div>',

	dragStart: function (node)
	{
		var body = Vvveb.Builder.frameBody;

		if ($(".chart-script", body).length == 0)
		{
			$(body).append("<script class='chart-script' src='/SDR_base-portlet/js/highcharts/highcharts.js' type='text/javascript'></script>");
			$(body).append("<script class='chart-script' src='/SDR_base-portlet/js/highcharts/exporting.js' type='text/javascript'></script>");
			$(body).append("<script class='chart-script' src='/SDR_base-portlet/designer/plugin/components-chart-script.js' type='text/javascript'></script>");
		}
		
		if ($(".dos-script", body).length == 0)
		{
			$(body).append(
				"<script class='dos-script' type='text/javascript'>\
				$(document).ready(function() {\
					$('.dos').each(function (index) {\
						$(this).find('.dos-graph').attr('id','dos-graph-'+index);\
						console.log($(this).find('.dos-graph'));\
						var path = this.dataset.fileType + this.dataset.filePath;\
						console.log('path', path);\
						dos.init(path, 'dos-graph-'+index);\
					});\
				});\
				</script>"
			);
		}

		return node;
	}
	
});

