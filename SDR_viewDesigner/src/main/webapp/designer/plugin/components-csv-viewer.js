var componentsGroup = Vvveb.ComponentsGroup['Library'] || [];

//adding components name
componentsGroup.push('Library/csv');
Vvveb.ComponentsGroup['Library'] = componentsGroup;

Vvveb.Components.extend("_base", "Library/csv", {
	name: "csv",
	attributes: ["data-component-csv"],
	image: "icons/custom/icon_17_csv.svg",
	dragHtml: '<img src="' + Vvveb.baseUrl + 'icons/chart.svg">',
	html: '<div data-component-csv class="csv" style="width:1000px; height:800px;" \
			data-file-type="{{finalPath}}" data-file-path="/example.csv" >\
				<img width="100%" height="100%" src="/SDR_base-portlet/images/designer/csv_viewer_sample.png" style="pointer-events:none;"/>\
			</div>',
	dragStart: function (node)
	{
		var body = Vvveb.Builder.frameBody;

		if ($(".csv-script", body).length == 0)
		{
            $(body).append("<link class='csv-script' href='/SDR_base-portlet/js/handsontable/handsontable-6.1.1.full.min.css' type='text/css' rel='stylesheet'/>");
            $(body).append("<script class='csv-script' src='/SDR_base-portlet/js/handsontable/handsontable-6.1.1.full.min.js' type='text/javascript'></script>");
            $(body).append("<script class='csv-script' src='/SDR_base-portlet/designer/plugin/components-csv-script.js' type='text/javascript'></script>");
            //$(body).append("<script class='csv-script' src='https://cdn.jsdelivr.net/npm/handsontable-pro@6.1.1/dist/handsontable.full.min.js' type='text/javascript'></script>");
            //$(body).append("<link class='csv-script' href='https://cdn.jsdelivr.net/npm/handsontable-pro@6.1.1/dist/handsontable.full.min.css' type='text/css' rel='stylesheet'/>");
			$(body).append(
				"<script class='csv-script' type='text/javascript'>\
				$(document).ready(function() {\
					$('.csv').each(function (index) {\
					    var self = $(this).attr('id','csv_'+index);\
					    if(!validate(self)) return true;\
					    self.html('');\
						var container = document.querySelector('#csv_'+index);\
						var path = this.dataset.fileType + this.dataset.filePath;\
						var dataPath = new Array();\
						var dataJson = { 'text': this.dataset.filePath, 'path': path };\
						dataPath.push(dataJson);\
						csvFunc.initCsvTable(container, dataPath, index);\
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
