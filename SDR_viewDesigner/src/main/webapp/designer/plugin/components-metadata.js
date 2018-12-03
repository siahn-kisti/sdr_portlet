
Vvveb.Metadata = {

	_namespace: '',				//portlet namespace
	_getDatasetURL: '',			//getDatasetURL url <%=getDatasetURL%>
	_datasetId: 0,				//required
	
	init: function(opt){
		this._namespace = opt['namespace'];
		this._getDatasetURL = opt['getDatasetURL'];
		this._datasetId = opt['datasetId'];
		this.getMetadata();
	},

	getMetadata: function(){
		if(!this._datasetId) return;
		
		var self = this;
		var namespace = Vvveb.Metadata._namespace;
		var getDatasetURL = Vvveb.Metadata._getDatasetURL;
		var datasetId = Vvveb.Metadata._datasetId;
		
		var data = {};
		data[namespace+"datasetId"] = datasetId;
		
		$.ajax({
			type: "POST",
			url: getDatasetURL,
			dataType: "json",
			data: data,
			success: function (e) {
				//console.log("SUCCESS : ", e);
				if (!e.error) {
                    self.setMetadata(e);
                }else{
				    alert(e.error);
                }
			},
			error: function (e) {
				console.log("ERROR : ", e);
                alert(e.error);
			}
		});
	},
	
	
	setMetadata: function(e){
		//console.log('setMetadata', e);
		if(e.dm) this.addDMComponents(e.dm);
		if(e.cv) this.addCVComponents(e.cv);

		Vvveb.Builder.loadControlGroups();
		Vvveb.Builder._initDragdrop();
	},
	
	
	addDMComponents: function(dm){
		//console.log('addDMComponents', dm);

		var metadataGroup = [];

		$.each(dm, function(key, data){
			//console.log('data', key, data);
			
			var group = 'metadata/'+key;
			metadataGroup.push(group);
			
			Vvveb.Components.add(group, {
				name: key,
				//image: "icons/custom/icon_03_01_12grid.svg",
				html: '<label>{{dm.'+key+'}}</label>'
			});
			
		});

		Vvveb.ComponentsGroup['Metadata'] = metadataGroup;
	},
	
	addCVComponents: function(cv){
		//console.log('addCVComponents', cv);

		var cvGroup = [];

		$.each(cv, function(key, data){
			//console.log('data', key, data);

			var group = 'reference/'+key;
			cvGroup.push(group);

			Vvveb.Components.add(group, {
				name: key,
				//image: "icons/custom/icon_03_01_12grid.svg",
				html: '<label>'+key +
						'<a class="la la-question" title="{{cv.'+key+'}}" href="{{cv.'+key+'}}" target="_blank" style="pointer-events:none;"></a>' +
                    '</label>'
			});

		});

		Vvveb.ComponentsGroup['Reference'] = cvGroup;
	}
	
};

