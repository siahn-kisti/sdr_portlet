var Monitoring = Class.create({
	init: function(common) {
		this.common = common;
	},
	initEvents : function () {
		var that = this;

		$(function(){

		});

        $(".detailBtn").click(function(){
			console.log('detailBtn click!');
            console.log($(this).attr('data-id'));
            var simulationId = $(this).attr('data-id');
            that.callDetailPopup(simulationId);
        });

        $(".cancelBtn").click(function(){
			console.log('cancelBtn click!');
            if($(this).hasClass('disabled')) return;

            var simulationId = $(this).attr('data-id');
            var returnURL = $("input[name=cancelJobURL]").val();

            $('#actionForm [name="simulationId"]').val(simulationId);
            $('#actionForm').attr('action', returnURL);
            $('#actionForm').submit();
        });
        
        $(".deleteBtn").click(function(){
			console.log('deleteBtn click!');
            if($(this).hasClass('disabled')) return;

            var simulationId = $(this).attr('data-id');
            var returnURL = $("input[name=deleteJobURL]").val();

            $('#actionForm [name="simulationId"]').val(simulationId);
            $('#actionForm').attr('action', returnURL);
            $('#actionForm').submit();
        });

        $(".downBtn").click(function(){
			console.log('downBtn click!');
            var simulationId = $(this).attr('data-id');

            var returnURL = $("input[name=downloadFileURL]").val();
            var inputs = '<input type="hidden" name="simulationId" value="'+ simulationId +'" />';
            jQuery('<form action="'+ returnURL +'" method="post" target="fileDownloadFrame">'+inputs+'</form>')
                .appendTo('body').submit().remove();
        });

        $(".saveBtn").click(function(){
            var simulationId = $(this).attr('data-id');
            that.callStorePopup(simulationId);
        });

        $(".viewBtn").click(function(){
			console.log('viewBtn click!');
            var simulationId = $(this).attr('data-id');
            that.callDirectViewPopup(simulationId);
        });

        $("#refreshLink").click(function(){
			console.log('refreshLink click!');
            location.reload();
        });

	},
    callDetailPopup: function(simulationId){
        var that = this;
        AUI().use('aui-base','liferay-portlet-url','aui-node', function(A) {
            var namespace = $('#namespace').val();
            var popupId = Math.floor(Math.random() * (1e6 - 1 + 1) + 1);

            var returnURL = $("input[name=detailPopupURL]").val();
            	returnURL += "&"+namespace+"simulationId=" + simulationId;
            	returnURL += "&"+namespace+"popupId=" + popupId;
            Liferay.Util.selectEntity({
                dialog : {
                    modal : true,
                    width : 600,
                    height : 400
                },
                id : 'detailPopup_'+popupId,
                title : 'Monitoring Detail',
                uri : returnURL
            }, function(event) {
                that.iBRun(event.title, event.description);
            });

        });
    },
    callStorePopup: function(simulationId){
        var that = this;
        AUI().use('aui-base','liferay-portlet-url','aui-node', function(A) {
            var namespace = $('#namespace').val();
            var popupId = Math.floor(Math.random() * (1e6 - 1 + 1) + 1);

            var returnURL = $("input[name=storePopupURL]").val();
            	returnURL += "&"+namespace+"simulationId=" + simulationId;
            	returnURL += "&"+namespace+"popupId=" + popupId;
            Liferay.Util.selectEntity({
                dialog : {
                    modal : true,
                    width : 800,
                    height : 400,
                    destroyOnClose: true,
                    resizable: false,
                    constrain : true,
                    cache: false
                },
                id : 'storePopup_'+popupId,
                title : 'Store & Share',
                uri : returnURL
            }, function(event) {
                that.storeInSdr(event);
            });

        });
    },
    storeInSdr: function(event){
        $('#storeForm [name="simulationId"]').val(event.simulationId);
        $('#storeForm [name="title"]').val(event.title);
        $('#storeForm [name="collectionId"]').val(event.collectionId);
        $('#storeForm [name="dataTypeId"]').val(event.dataTypeId);

        YUI().use('aui-base','aui-form-validator', function(A) {
            submit_progress.startProgress();
        });

        var returnURL = $("input[name=storeInSdrURL]").val();
        $('#storeForm').attr('action', returnURL);
        $('#storeForm').submit();
    },
    callDirectViewPopup: function(simulationId){
        var that = this;
        AUI().use('aui-base','liferay-portlet-url','aui-node', function(A) {
            var namespace = $('#namespace').val();
            var popupId = Math.floor(Math.random() * (1e6 - 1 + 1) + 1);

            var returnURL = $("input[name=storePopupURL]").val();
            returnURL += "&"+namespace+"simulationId=" + simulationId;
            returnURL += "&"+namespace+"popupId=" + popupId;
            returnURL += "&"+namespace+"type=" + 'direct';
            Liferay.Util.selectEntity({
                dialog : {
                    modal : true,
                    width : 800,
                    height : 300
                },
                id : 'directViewPopup_'+popupId,
                title : 'View',
                uri : returnURL
            }, function(event) {
                that.directView(event);
            });

        });
    },
    directView: function(event){
        var returnURL = $('#datasetDetailURL').val();
        returnURL += "&_datasearch_WAR_SDR_baseportlet_simulationId=" + event.simulationId;
        returnURL += "&_datasearch_WAR_SDR_baseportlet_dataTypeId=" + event.dataTypeId;

        console.log(returnURL);
        var a = document.createElement("a");
        a.setAttribute("href", returnURL);
        a.setAttribute("target", "_blank");
        a.click();
    }
});