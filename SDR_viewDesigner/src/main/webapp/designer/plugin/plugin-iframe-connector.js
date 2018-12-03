//var Vvveb = Vvveb || {};

Vvveb.IframeConnector = {
	
	_namespace: '',				//portlet namespace
	_previewURL: '',			//preview url <%=previewURL%>
	_saveDataURL: '',			//saveData url <%=saveDataURL%>
	
	_data: {
		type: 'new',
		dataViewId: 0,
		dataTypeId: 0,
		title: '',
		description: ''
	},
	
	_datasetId: 0,				//preview datasetId
	
	init: function (opt) {
		//Vvveb.IframeConnector.option = $.extend({}, Vvveb.IframeConnector.option, opt);
		this._namespace = opt['namespace'];
		this._previewURL = opt['previewURL'];
		this._saveDataURL = opt['saveDataURL'];

		$("[data-vvveb-custom-action]").each(function () {
			var on = "click";
			$(this).on(on, Vvveb.IframeConnector[this.dataset.vvvebCustomAction]);
		});
	},

	
	setDataTypeId: function(dataTypeId){
		this._data.dataTypeId = dataTypeId;
	},
	
	setDatasetId: function(datasetId){
		this._datasetId = datasetId;
	},
	

	preview: function(){
		Vvveb.Gui.preview();
		
		var iframeWrapper = $("#iframe-wrapper");
		var previewWrapper = $("#preview-wrapper");
		var bottomPanel = $("#bottom-panel");
		
		var isPreview = $("#vvveb-builder").hasClass("preview");
		if(!isPreview){
			iframeWrapper.show();
			previewWrapper.hide();
			bottomPanel.show();
			return;
		}

		//previewSubmit
		Vvveb.IframeConnector.previewSubmit();

		//preview slide 효과를 보여주기위해 지연
		setTimeout(function(){
			iframeWrapper.hide();
			previewWrapper.show();
			bottomPanel.hide();
		}, 600);
	},
	
	previewSubmit: function(){
		var isPreview = $("#vvveb-builder").hasClass("preview");
		if(!isPreview) return;
		
		var previewIframe = $("#preview-wrapper > iframe");
		var namespace = '_sdrcommon_WAR_SDR_baseportlet_';
		var previewURL = Vvveb.IframeConnector._previewURL;
		var datasetId = Vvveb.IframeConnector._datasetId;
		
		var editorIframe = $("#iframe-wrapper > iframe");
		//var html = editorIframe.contents().find("body").html();
		var html = Vvveb.Builder.getHtml();
		html = encodeURIComponent(html);

		var $form = $("<form/>").attr({
			name: 'previewForm',
			method: 'POST',
			action: previewURL,
			target: previewIframe.attr("name")
		});
		
		$(document.body).append($form);
		$("<input/>").attr({type:"hidden", name:namespace+"datasetId", value:datasetId}).appendTo($form);
		$("<input/>").attr({type:"hidden", name:namespace+"html", value:html}).appendTo($form);
		$form.submit();
		$form.remove();
	},
	
	save: function(){
		var namespace = Vvveb.IframeConnector._namespace;
		var saveDataURL = Vvveb.IframeConnector._saveDataURL;
		
		var data = Vvveb.IframeConnector._data;
		if(data.dataTypeId==undefined || data.dataTypeId <= 0){
			alert("Please select a dataset to set the datatype before saving.");
			return;
		}

		var f = $('#save-modal #saveForm');
		f.attr('action', saveDataURL);
		f.attr('name',namespace+'saveForm');
		
		if(data.type == 'edit'){
			f.find('#save-dataViewId').attr('name',namespace+'dataViewId');
			f.find('#save-dataViewId').val(data.dataViewId);
			f.find('#save-title').val(data.title);
			f.find('#save-description').val(data.description);
		}
		
		f.find('#save-dataTypeId').attr('name',namespace+'dataTypeId');
		f.find('#save-dataTypeId').val(data.dataTypeId);

		f.find('#save-title').attr('name',namespace+'title');
		f.find('#save-description').attr('name',namespace+'description');
		
		f.find('#save-html').attr('name',namespace+'html');
		f.find('#save-html').val(Vvveb.Builder.getHtml());
		
		$('#save-modal').modal();
	},
	
	setData: function (data) {
		this._data = {
			type: data['type'],
			dataViewId : data['dataViewId'],
			dataTypeId : data['dataTypeId'],
			title : data['title'],
			description : data['description']
		};

		var editorIframe = $("#iframe-wrapper > iframe");
		var body = editorIframe.contents().find("body");
		var html = decodeURIComponent((data.html + '').replace(/\+/g, '%20'));
		//body.html(html);
		Vvveb.Builder.setHtml(html);
	}
	
};
