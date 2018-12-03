var componentsGroup = Vvveb.ComponentsGroup['Library'] || [];

//adding components name
componentsGroup.push('Library/ngl');
Vvveb.ComponentsGroup['Library'] = componentsGroup;

Vvveb.Components.extend("_base", "Library/ngl", {
	name: "ngl",
	attributes: ["data-component-ngl"],
	image: "icons/custom/icon_16_ngl.svg",
	dragHtml: '<img src="' + Vvveb.baseUrl + 'icons/chart.svg">',
	html: '<div data-component-ngl class="ngl" style="width:1000px; height:800px;" \
			data-file-type="{{finalPath}}" data-file-path="/1blu.pdb" data-file-list="{{fileList}}">\
				<img width="100%" height="100%" src="/SDR_base-portlet/images/designer/ngl_sample.png" style="pointer-events:none;"/>\
			</div>',
	dragStart: function (node)
	{
		var body = Vvveb.Builder.frameBody;

		if ($(".ngl-script", body).length == 0)
		{
			$(body).append(
				"<script class='ngl-script' type='text/javascript'>\
				$(document).ready(function() {\
					$('.ngl').each(function (index) {\
					   var self = $(this).attr('id','p3d_'+index);\
					   if(!validate(self)) return true;\
					   self.html('');\
					   var iframe = $('<iframe width=\"100%\" height=\"100%\" style=\"border:0px\"></iframe>');\
					   var path = this.dataset.fileType + this.dataset.filePath;\
					   var fileDir = this.dataset.fileType;\
					   var fileName = this.dataset.filePath;\
					   var mutiFileArr = [];\
					   iframe.attr('src','/SDR_base-portlet/js/ngl/html/viewer-ngl.html');\
					   iframe.on('load',function(){\
                            iframe.get(0).contentWindow.filePath = path;\
                            iframe.get(0).contentWindow.fileDir = fileDir;\
                            iframe.get(0).contentWindow.fileName = fileName;\
                            iframe.get(0).contentWindow.mutiFileArr = mutiFileArr;\
                            iframe.get(0).contentWindow.scriptAppend();\
                       });\
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
                                success: function(data){\
                                    for(var i in data){\
                                        var fileName = data[i].fileName;\
                                        var filePath = oldPath + data[i].filePath;\
                                        mutiFileArr.push('/'+fileName);\
                                    }\
                                    self.html(iframe);\
                                },\
                                error: function() { alert('File Path Error!!!');}\
                           });\
					   }else{\
					      self.html(iframe);\
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
