
Vvveb.ComponentsManager = {

	_namespace: '',				//portlet namespace
	_getComponentsURL: '',		//getComponentsURL url <%=getComponentsURL%>
	_getImageURL: '',		    //getImageURL url <%=getImageURL%>
	
	init: function(opt){
		this._namespace = opt['namespace'];
		this._getComponentsURL = opt['getComponentsURL'];
		this._getImageURL = opt['getImageURL'];
		this.getComponents();
	},

	getComponents: function(){
		var self = this;
		var namespace = Vvveb.ComponentsManager._namespace;
		var getComponentsURL = Vvveb.ComponentsManager._getComponentsURL;

		var data = {};

		$.ajax({
			type: "POST",
			url: getComponentsURL,
			dataType: "json",
			data: data,
			success: function (e) {
				//console.log("SUCCESS : ", e);
				if (!e.error)
					self.setComponents(e);
			},
			error: function (e) {
				console.log("ERROR : ", e);
			}
		});
	},

	setComponents: function(e){
		if(e['list']==undefined) return;
		
		for(var i in e.list){
			var item = e.list[i];
			var itemType = item.compGroup+'/'+item.compName;

            //Home 일경우 뷰디자이너 설명 페이지로 추가
			if(itemType=='Home/Home'){
				Vvveb.guide.add({
					type: itemType,
					guide: this.replaceImageURL(item.description)
				});
				continue;
			}
			
			 // console.log('item', item.compGroup, item.compName, itemType);//, item.description);
			// console.log('Vvveb.ComponentsGroup', Vvveb.ComponentsGroup);

			var components = Vvveb.ComponentsGroup[ item.compGroup ];
			for (var j in components){
				var componentType = components[j];
				var component = Vvveb.Components.get(componentType);
				
				if(componentType == itemType){
					//console.log('componentType == itemType', j, componentType, itemType, component);
					component['guide'] = this.replaceImageURL(item.description);
					break;
				}
			}
		}
		
		Vvveb.Builder.loadControlGroups();
		Vvveb.Builder._initDragdrop();
	},
    
    replaceImageURL: function(str){
        var re = new RegExp('::getImage::', 'gi');
	    return str.replace(re, this._getImageURL);
    }

};