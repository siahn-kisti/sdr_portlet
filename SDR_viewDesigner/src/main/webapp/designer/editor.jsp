<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

	<title>View Designer</title>
	
	<link href="css/editor.css" rel="stylesheet">
</head>

<body>

<div id="vvveb-builder" class="">

	<div id="top-panel">

		<div class="btn-group float-left" role="group">
			<button class="btn btn-light active" title="Left Panel Toggle" id="left-panel-toggle-btn" data-vvveb-action="leftPanelToggle">
				<i class="la la-bars"></i>
			</button>
		</div>

		<!-- --------------------------->
		<div class="btn-group mr-3" role="group">
			<button class="btn btn-light" title="Preview" id="preview-btn" type="button" data-toggle="button" aria-pressed="false" data-vvveb-custom-action="preview">
				<i class="la la-eye"></i>
			</button>
		</div>
		
		<div class="btn-group mr-3" role="group">
			<button class="btn btn-light" title="Undo (Ctrl/Cmd + Z)" id="undo-btn" data-vvveb-action="undo" data-vvveb-shortcut="ctrl+z">
				<i class="la la-undo"></i>
			</button>
			<button class="btn btn-light"  title="Redo (Ctrl/Cmd + Shift + Z)" id="redo-btn" data-vvveb-action="redo" data-vvveb-shortcut="ctrl+shift+z">
				<i class="la la-undo la-flip-horizontal"></i>
			</button>
			<button class="btn btn-light" title="Fullscreen (F11)" id="fullscreen-btn" data-toggle="button" aria-pressed="false" data-vvveb-action="fullscreen">
				<i class="la la-arrows"></i>
			</button>
			<button class="btn btn-light" title="Export (Ctrl + E)" data-vvveb-action="save" data-vvveb-shortcut="ctrl+e">
				<i class="la la-download"></i>
			</button>
			<button class="btn btn-light" title="Guide" id="guide-btn" data-vvveb-action="guide">
				<i class="la la-question"></i>
			</button>
		</div>

		<div class="btn-group mr-3" role="group">
			<button class="btn btn-light" title="Save" data-vvveb-custom-action="save">
				<i class="la la-save"></i>
			</button>
		</div>
		<!-- --------------------------->

		<div class="btn-group float-right" role="group">
			<button class="btn btn-light ml-3 active" title="Left Panel Toggle" id="right-panel-toggle-btn" data-vvveb-action="rightPanelToggle">
				<i class="la la-gear"></i>
			</button>
		</div>

		<%--<div class="btn-group float-right" role="group">--%>
			<%--<button id="mobile-view" data-view="mobile" class="btn btn-light"  title="Mobile view" data-vvveb-action="viewport">--%>
				<%--<i class="ion-iphone"></i>--%>
			<%--</button>--%>

			<%--<button id="tablet-view"  data-view="tablet" class="btn btn-light"  title="Tablet view" data-vvveb-action="viewport">--%>
				<%--<i class="ion-ipad"></i>--%>
			<%--</button>--%>

			<%--<button id="desktop-view"  data-view="" class="btn btn-light"  title="Desktop view" data-vvveb-action="viewport">--%>
				<%--<i class="ion-monitor"></i>--%>
			<%--</button>--%>
		<%--</div>--%>
		

	</div>

	<div id="left-panel">

		<div id="filemanager" class="hide">
			<label class="header">Pages <div class="header-arrow"></div>
			</label>
			<%--<div class="header"><a href="#">Pages</a>--%>
			<%--</div>--%>
			<div class="tree hide">
				<ol>
				</ol>
			</div>
		</div>

		<div id="components">

			<div class="header">

				<input class="form-control form-control-sm" placeholder="" type="text" id="component-search"  data-vvveb-action="componentSearch" data-vvveb-on="keyup">
				<button id="clear-backspace"  data-vvveb-action="clearComponentSearch">
					<i class="ion-backspace"></i>
				</button>

			</div>

			<div id="components-sidepane" class="sidepane">
				<div>

					<ul id="components-list" class="clearfix">
					</ul>

				</div>
			</div>
		</div>


	</div>

	<div id="canvas">
		<div id="iframe-wrapper">
			<div id="iframe-layer">

				<div id="highlight-box">
					<div id="highlight-name"></div>

				</div>

				<div id="select-box">

					<div id="wysiwyg-editor">
						<a id="bold-btn" href="" title="Bold"><i><strong>B</strong></i></a>
						<a id="italic-btn" href="" title="Italic"><i>I</i></a>
						<a id="underline-btn" href="" title="Underline"><u>u</u></a>
						<a id="strike-btn" href="" title="Strikeout"><strike>S</strike></a>
						<a id="link-btn" href="" title="Create link"><strong>a</strong></a>
					</div>

					<div id="select-actions">
						<a id="drag-box" href="" title="Drag element"><i class="ion-arrow-move"></i></a>
						<a id="parent-box" href="" title="Select parent"><i class="ion-reply"></i></a>
						<a id="up-box" href="" title="Move element up"><i class="ion-arrow-up-a"></i></a>
						<a id="down-box" href="" title="Move element down"><i class="ion-arrow-down-a"></i></a>
						<a id="clone-box" href="" title="Clone element"><i class="ion-ios-copy"></i></a>
						<a id="delete-box" href="" title="Remove element"><i class="ion-trash-a"></i></a>
					</div>
				</div>

			</div>
			<iframe src="about:none" allowfullscreen id="iframe1" style="z-index: -99"></iframe>
		</div>
		<div id="preview-wrapper">
			<iframe id="previewIframe" allowfullscreen name="previewIframe" style="z-index: -100"></iframe>
		</div>
	</div>


	<div id="right-panel">
		<div id="component-properties">
		</div>
	</div>

	<div id="bottom-panel">

		<div class="btn-group" role="group">

			<button id="code-editor-btn" data-view="mobile" class="btn btn-light btn-sm"  title="Code editor" data-vvveb-action="toggleEditor">
				<i class="ion-code"></i> Code editor
			</button>

		</div>

		<div id="vvveb-code-editor">
			<textarea class="form-control"></textarea>
			<div>

			</div>
		</div>
	</div>


	<!-- templates -->

	<script id="vvveb-input-textinput" type="text/html">

		<div>
			<input name="{%=key%}" type="text" class="form-control"/>
		</div>

	</script>

	<script id="vvveb-input-checkboxinput" type="text/html">

		<div class="custom-control custom-checkbox">
			<input name="{%=key%}" class="custom-control-input" type="checkbox" id="{%=key%}_check">
			<label class="custom-control-label" for="{%=key%}_check">{% if (typeof text !== 'undefined') { %} {%=text%} {% } %}</label>
		</div>

	</script>

	<script id="vvveb-input-radioinput" type="text/html">

		<div>

			{% for ( var i = 0; i < options.length; i++ ) { %}

			<label class="custom-control custom-radio  {% if (typeof inline !== 'undefined' && inline == true) { %}custom-control-inline{% } %}"  title="{%=options[i].title%}">
				<input name="{%=key%}" class="custom-control-input" type="radio" value="{%=options[i].value%}" id="{%=key%}{%=i%}" {%if (options[i].checked) { %}checked="{%=options[i].checked%}"{% } %}>
				<label class="custom-control-label" for="{%=key%}{%=i%}">{%=options[i].text%}</label>
			</label>

			{% } %}

		</div>

	</script>

	<script id="vvveb-input-radiobuttoninput" type="text/html">

		<div class="btn-group btn-group-toggle  {%if (extraclass) { %}{%=extraclass%}{% } %} clearfix" data-toggle="buttons">

			{% for ( var i = 0; i < options.length; i++ ) { %}

			<label class="btn btn-light  {%if (options[i].checked) { %}active{% } %}" for="{%=key%}{%=i%} " title="{%=options[i].title%}">
				<input name="{%=key%}" class="custom-control-input" type="radio" value="{%=options[i].value%}" id="{%=key%}{%=i%}" {%if (options[i].checked) { %}checked="{%=options[i].checked%}"{% } %}>
				{%if (options[i].icon) { %}<i class="{%=options[i].icon%}"></i>{% } %}
				{%=options[i].text%}
			</label>

			{% } %}

		</div>

	</script>


	<script id="vvveb-input-toggle" type="text/html">

		<div class="toggle">
			<input type="checkbox" name="{%=key%}" value="{%=on%}" data-value-off="{%=off%}" data-value-on="{%=on%}" class="toggle-checkbox" id="{%=key%}">
			<label class="toggle-label" for="{%=key%}">
				<span class="toggle-inner"></span>
				<span class="toggle-switch"></span>
			</label>
		</div>

	</script>

	<script id="vvveb-input-header" type="text/html">

		<h6 class="header">{%=header%}</h6>

	</script>


	<script id="vvveb-input-select" type="text/html">

		<div>

			<select class="form-control custom-select">
				{% for ( var i = 0; i < options.length; i++ ) { %}
				<option value="{%=options[i].value%}">{%=options[i].text%}</option>
				{% } %}
			</select>

		</div>

	</script>


	<script id="vvveb-input-listinput" type="text/html">

		<div class="row">

			{% for ( var i = 0; i < options.length; i++ ) { %}
			<div class="col-6">
				<div class="input-group">
					<input name="{%=key%}_{%=i%}" type="text" class="form-control" value="{%=options[i].text%}"/>
					<div class="input-group-append">
						<button class="input-group-text btn btn-sm btn-danger">
							<i class="ion-trash-a"></i>
						</button>
					</div>
				</div>
				<br/>
			</div>
			{% } %}


			{% if (typeof hide_remove === 'undefined') { %}
			<div class="col-12">

				<button class="btn btn-sm btn-outline-primary">
					<i class="ion-trash-a"></i> Add new
				</button>

			</div>
			{% } %}

		</div>

	</script>

	<script id="vvveb-input-grid" type="text/html">

		<div class="row">
			<div class="mb-1 col-12">

				<label>Flexbox</label>
				<select class="form-control custom-select" name="col">

					<%--<option value="">None</option>--%>
					{% for ( var i = 1; i <= 12; i++ ) { %}
					<option value="{%=i%}" {% if ((typeof col !== 'undefined') && col == i) { %} selected {% } %}>{%=i%}</option>
					{% } %}

				</select>
				<br/>
			</div>

			<%--<div class="col-6">--%>
				<%--<label>Extra small</label>--%>
				<%--<select class="form-control custom-select" name="col-xs">--%>

					<%--<option value="">None</option>--%>
					<%--{% for ( var i = 1; i <= 12; i++ ) { %}--%>
					<%--<option value="{%=i%}" {% if ((typeof col_xs !== 'undefined') && col_xs == i) { %} selected {% } %}>{%=i%}</option>--%>
					<%--{% } %}--%>

				<%--</select>--%>
				<%--<br/>--%>
			<%--</div>--%>

			<%--<div class="col-6">--%>
				<%--<label>Small</label>--%>
				<%--<select class="form-control custom-select" name="col-sm">--%>

					<%--<option value="">None</option>--%>
					<%--{% for ( var i = 1; i <= 12; i++ ) { %}--%>
					<%--<option value="{%=i%}" {% if ((typeof col_sm !== 'undefined') && col_sm == i) { %} selected {% } %}>{%=i%}</option>--%>
					<%--{% } %}--%>

				<%--</select>--%>
				<%--<br/>--%>
			<%--</div>--%>

			<%--<div class="col-6">--%>
				<%--<label>Medium</label>--%>
				<%--<select class="form-control custom-select" name="col-md">--%>

					<%--<option value="">None</option>--%>
					<%--{% for ( var i = 1; i <= 12; i++ ) { %}--%>
					<%--<option value="{%=i%}" {% if ((typeof col_md !== 'undefined') && col_md == i) { %} selected {% } %}>{%=i%}</option>--%>
					<%--{% } %}--%>

				<%--</select>--%>
				<%--<br/>--%>
			<%--</div>--%>

			<%--<div class="col-6 mb-1">--%>
				<%--<label>Large</label>--%>
				<%--<select class="form-control custom-select" name="col-lg">--%>

					<%--<option value="">None</option>--%>
					<%--{% for ( var i = 1; i <= 12; i++ ) { %}--%>
					<%--<option value="{%=i%}" {% if ((typeof col_lg !== 'undefined') && col_lg == i) { %} selected {% } %}>{%=i%}</option>--%>
					<%--{% } %}--%>

				<%--</select>--%>
				<%--<br/>--%>
			<%--</div>--%>

			{% if (typeof hide_remove === 'undefined') { %}
			<div class="col-12">

				<button class="btn btn-sm btn-outline-light text-danger">
					<i class="ion-trash-a"></i> Remove
				</button>

			</div>
			{% } %}

		</div>

	</script>

	<script id="vvveb-input-textvalue" type="text/html">

		<div class="row">
			<div class="col-6 mb-1">
				<label>Value</label>
				<input name="value" type="text" value="{%=value%}" class="form-control"/>
			</div>

			<div class="col-6 mb-1">
				<label>Text</label>
				<input name="text" type="text" value="{%=text%}" class="form-control"/>
			</div>

			{% if (typeof hide_remove === 'undefined') { %}
			<div class="col-12">

				<button class="btn btn-sm btn-outline-light text-danger">
					<i class="ion-trash-a"></i> Remove
				</button>

			</div>
			{% } %}

		</div>

	</script>

	<script id="vvveb-input-rangeinput" type="text/html">

		<div>
			<input name="{%=key%}" type="range" min="{%=min%}" max="{%=max%}" step="{%=step%}" class="form-control"/>
		</div>

	</script>

	<script id="vvveb-input-colorinput" type="text/html">

		<div>
			<input name="{%=key%}" type="color" value="{%=value%}" pattern="#[a-f0-9]{6}" class="form-control"/>
		</div>

	</script>

	<script id="vvveb-input-numberinput" type="text/html">
		<div>
			<input name="{%=key%}" type="number" value="{%=value%}"
				   {% if (typeof min !== 'undefined' && min != false) { %}min="{%=min%}"{% } %}
			{% if (typeof max !== 'undefined' && max != false) { %}max="{%=max%}"{% } %}
			{% if (typeof step !== 'undefined' && step != false) { %}step="{%=step%}"{% } %}
			class="form-control"/>
		</div>
	</script>

	<script id="vvveb-input-button" type="text/html">
		<div>
			<button class="btn btn-sm btn-primary">
				<i class="ion-trash-a"></i> {%=text%}
			</button>
		</div>
	</script>

	<script id="vvveb-input-cssunitinput" type="text/html">
		<div class="input-group" id="cssunit-{%=key%}">
			<input name="number" type="number" value="{%=value%}"
				   {% if (typeof min !== 'undefined' && min != false) { %}min="{%=min%}"{% } %}
			{% if (typeof max !== 'undefined' && max != false) { %}max="{%=max%}"{% } %}
			{% if (typeof step !== 'undefined' && step != false) { %}step="{%=step%}"{% } %}
			class="form-control"/>
			<div class="input-group-append">
				<select class="form-control custom-select small-arrow" name="unit">
					<option>em&ensp;</option>
					<option>px</option>
					<option>%</option>
					<option>rem</option>
					<option>auto</option>
				</select>
			</div>
		</div>

	</script>


	<script id="vvveb-filemanager-page" type="text/html">
		<li data-url="{%=url%}" data-page="{%=name%}">
			<label for="{%=name%}"><span>{%=title%}</span></label> <input type="checkbox" checked id="{%=name%}" />
			<ol></ol>
		</li>
	</script>

	<script id="vvveb-filemanager-component" type="text/html">product
		<li data-url="{%=url%}" data-component="{%=name%}" class="file">
			<a href="{%=url%}"><span>{%=title%}</span></a>
		</li>
	</script>

	<script id="vvveb-input-sectioninput" type="text/html">

		<label class="header" data-header="{%=key%}" for="header_{%=key%}"><span>&ensp;{%=header%}</span> <div class="header-arrow"></div></label>
		<input class="header_check" type="checkbox" {% if (typeof expanded !== 'undefined' && expanded == false) { %} {% } else { %}checked="true"{% } %} id="header_{%=key%}">
		<div class="section" data-section="{%=key%}"></div>

	</script>


	<script id="vvveb-property" type="text/html">

		<div class="form-group {% if (typeof col !== 'undefined' && col != false) { %} col-sm-{%=col%} d-inline-block {% } else { %}row{% } %}" data-key="{%=key%}" {% if (typeof group !== 'undefined' && group != null) { %}data-group="{%=group%}" {% } %}>

		{% if (typeof name !== 'undefined' && name != false) { %}<label class="{% if (typeof inline === 'undefined' ) { %}col-sm-4{% } %} control-label" for="input-model">{%=name%}</label>{% } %}

		<div class="{% if (typeof inline === 'undefined') { %}col-sm-{% if (typeof name !== 'undefined' && name != false) { %}8{% } else { %}12{% } } %} input"></div>

		</div>

	</script>

	<!--// end templates -->


	<!-- export html modal-->
	<div class="modal fade" id="textarea-modal" tabindex="-1" role="dialog" aria-labelledby="textarea-modal" aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Export html</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">

					<textarea rows="25" cols="150" class="form-control"></textarea>

				</div>
				<div class="modal-footer">
					<button class="btn btn-primary" title="Download" data-vvveb-action="download" download="index.html">
						<i class="la la-download"></i> Download
					</button>
					<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	
	<!-- save html modal-->
	<div class="modal fade" id="save-modal" tabindex="-1" role="dialog" aria-labelledby="save-modal" aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">Save</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>

				<form class="form-horizontal" role="form" id="saveForm" method="post" target="_top">
					<input type="hidden" class="form-control" id="save-dataViewId"/>
					<input type="hidden" class="form-control" id="save-dataTypeId"/>
					<div class="modal-body">
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Title *</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="save-title" required/>
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Description</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="save-description"/>
							</div>
						</div>
						<div class="form-group row">
							<label class="col-sm-2 col-form-label">Html *</label>
							<div class="col-sm-10">
								<textarea rows="22" class="form-control" id="save-html" required></textarea>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-primary" title="Save">
							<i class="la la-save"></i> Save
						</button>
						<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
					</div>
				</form>
				
			</div>
		</div>
	</div>
	

	<!-- guide html modal-->
	<style>
		#guide-modal .modal-body{
			padding: 0;
		}
		#guide-modal #guide-list{
			padding: 20px 0;
			background-color: #fafafa;
		}
		#guide-modal #guide-list li {
			cursor: pointer;
			color: #212121;
			padding: 10px 30px;
		}
		#guide-modal #guide-list li a.active{
			color: #F44336;
		}
		
		#guide-modal #guide-html{
			padding: 20px 20px;
		}
		#guide-modal #guide-html img { 
			max-width:100% !important 
		}
		
	</style>
	<div class="modal fade" id="guide-modal" tabindex="-1" role="dialog" aria-labelledby="guide-modal" aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document" style="min-width:1200px;">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title">View Designer Guide</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">

					<div class="container-fluid">
						<div class="row">
							<div class="col-3" id="guide-list">
								<ul class="nav navbar-nav">
								</ul>
							</div>
							<div class="col-9" id="guide-html">
							</div>
						</div>
					</div>
					
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	
</div>


<!-- jquery-->
<script src="js/jquery.min.js"></script>
<script src="js/jquery.hotkeys.js"></script>

<!-- bootstrap-->
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>

<!-- builder code-->
<script src="libs/builder/builder.js"></script>
<!-- undo manager-->
<script src="libs/builder/undo.js"></script>
<!-- inputs-->
<script src="libs/builder/inputs.js"></script>
<!-- components-->
<%--<script src="libs/builder/components-bootstrap4.js"></script>--%>
<%--<script src="libs/builder/components-widgets.js"></script>--%>

<!-- plugins -->

<!-- code mirror - code editor syntax highlight -->
<link href="libs/codemirror/lib/codemirror.css" rel="stylesheet"/>
<link href="libs/codemirror/theme/material.css" rel="stylesheet"/>
<script src="libs/codemirror/lib/codemirror.js"></script>
<script src="libs/codemirror/lib/xml.js"></script>
<script src="libs/codemirror/lib/formatting.js"></script>
<script src="libs/builder/plugin-codemirror.js"></script>

<!-- custom plugin -->
<script src="plugin/plugin-iframe-connector.js"></script>
<script src="plugin/plugin-manager.js"></script>
<script src="plugin/components-layout.js"></script>
<script src="plugin/components-metadata.js"></script>
<script src="plugin/components-jsmol.js"></script>
<script src="plugin/components-paraview.js"></script>
<script src="plugin/components-pdf.js"></script>
<script src="plugin/components-epub.js"></script>
<script src="plugin/components-chart.js"></script>
<script src="plugin/components-rlt2chart.js"></script>
<script src="plugin/components-html.js"></script>
<script src="plugin/components-x3dom.js"></script>
<script src="plugin/components-p3d.js"></script>
<script src="plugin/components-ngl.js"></script>
<script src="plugin/components-csv-viewer.js"></script>
<script src="plugin/components-text-viewer.js"></script>
<script src="plugin/components-onedviewer.js"></script>
<%--<script src="plugin/components-molview.js"></script>--%>
<!-- user plugin -->


<script>
    Vvveb.Builder.init('demo/blank/index.html', function() {
        //run code after page/iframe is loaded
    });

    Vvveb.Gui.init();
    Vvveb.FileManager.init();
    Vvveb.FileManager.addPages(
        [
            {name:"blank", title:"Blank",  url: "demo/blank/index.html"},
            {name:"material", title:"Material",  url: "demo/material/index.html"},
            {name:"2dincompp", title:"2D_Incomp_P",  url: "demo/cfd/2d_incomp_p.html"},
            {name:"narrow-jumbotron", title:"Jumbotron",  url: "demo/narrow-jumbotron/index.html"},
            {name:"album", title:"Album",  url: "demo/album/index.html"},
            {name:"blog", title:"Blog",  url: "demo/blog/index.html"},
            {name:"carousel", title:"Carousel",  url: "demo/carousel/index.html"},
            {name:"offcanvas", title:"Offcanvas",  url: "demo/offcanvas/index.html"},
            {name:"pricing", title:"Pricing",  url: "demo/pricing/index.html"},
            {name:"product", title:"Product",  url: "demo/product/index.html"},
        ]);
	$(document).ready(function()
	{


	});
</script>
</body>
</html>
