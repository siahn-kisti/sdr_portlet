<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html class="no-js">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
	<title></title>
	<meta name="description" content="">
	<meta name="viewport" content="width=device-width, user-scalable=no">
	<meta name="apple-mobile-web-app-capable" content="yes">

	<link rel="stylesheet" href="<%=request.getContextPath()%>/js/epubJs/reader/css/normalize.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/js/epubJs/reader/css/main.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/js/epubJs/reader/css/popup.css">

	<script src="<%=request.getContextPath()%>/js/epubJs/reader/js/libs/jquery.min.js"></script>

	<script src="<%=request.getContextPath()%>/js/epubJs/reader/js/libs/zip.min.js"></script>

	<script>
		"use strict";

		var ebookPath = decodeURIComponent("${param.path}");

		document.onreadystatechange = function () {
			if (document.readyState == "complete") {
				EPUBJS.filePath = "js/libs/";
				EPUBJS.cssPath = window.location.href.replace(window.location.hash, '').replace('index.html', '') + "css/";
				// fileStorage.filePath = EPUBJS.filePath;

				window.reader = ePubReader(ebookPath, {
					contained : true,
					version: 1, // Changing will cause stored Book information to be reloaded
					restore: false, // Skips parsing epub contents, loading from localstorage instead
					storage: false, // true (auto) or false (none) | override: 'ram', 'websqldatabase', 'indexeddb', 'filesystem'
					spreads: true, // Displays two columns
					fixedLayout : false, //-- Will turn off pagination
					styles : {}, // Styles to be applied to epub
					width : false,
					height: false
				});
			}
		};

	</script>

	<!-- File Storage -->
	<!-- <script src="js/libs/localforage.min.js"></script> -->

	<!-- Full Screen -->
	<script src="<%=request.getContextPath()%>/js/epubJs/reader/js/libs/screenfull.min.js"></script>

	<!-- Render -->
	<script src="<%=request.getContextPath()%>/js/epubJs/reader/js/epub.min.js"></script>

	<!-- Hooks -->
	<script src="<%=request.getContextPath()%>/js/epubJs/reader/js/hooks.min.js"></script>

	<!-- Reader -->
	<script src="<%=request.getContextPath()%>/js/epubJs/reader/js/reader.min.js"></script>

	<!-- Plugins -->
	<!-- <script src="<%=request.getContextPath()%>/js/epubJs/reader/js/plugins/search.js"></script> -->

</head>
<body>
<div id="sidebar">
	<div id="panels">
		<input id="searchBox" placeholder="search" type="search">

		<a id="show-Search" class="show_view icon-search" data-view="Search">Search</a>
		<a id="show-Toc" class="show_view icon-list-1 active" data-view="Toc">TOC</a>
		<a id="show-Bookmarks" class="show_view icon-bookmark" data-view="Bookmarks">Bookmarks</a>
		<a id="show-Notes" class="show_view icon-edit" data-view="Notes">Notes</a>

	</div>
	<div id="tocView" class="view">
	</div>
	<div id="searchView" class="view">
		<ul id="searchResults"></ul>
	</div>
	<div id="bookmarksView" class="view">
		<ul id="bookmarks"></ul>
	</div>
	<div id="notesView" class="view">
		<div id="new-note">
			<textarea id="note-text"></textarea>
			<button id="note-anchor">Anchor</button>
		</div>
		<ol id="notes"></ol>
	</div>
</div>
<div id="main">

	<div id="titlebar">
		<div id="opener">
			<a id="slider" class="icon-menu">Menu</a>
		</div>
		<div id="metainfo">
			<span id="book-title"></span>
			<span id="title-seperator">&nbsp;&nbsp;–&nbsp;&nbsp;</span>
			<span id="chapter-title"></span>
		</div>
		<div id="title-controls">
			<a id="bookmark" class="icon-bookmark-empty">Bookmark</a>
			<a id="setting" class="icon-cog">Settings</a>
			<a id="fullscreen" class="icon-resize-full">Fullscreen</a>
		</div>
	</div>

	<div id="divider"></div>
	<div id="prev" class="arrow">‹</div>
	<div id="viewer"></div>
	<div id="next" class="arrow">›</div>

	<div id="loader"><img src="<%=request.getContextPath()%>/js/epubJs/reader/img/loader.gif"></div>
</div>
<div class="modal md-effect-1" id="settings-modal">
	<div class="md-content">
		<h3>Settings</h3>
		<div>
			<p>
				<input type="checkbox" id="sidebarReflow" name="sidebarReflow">Reflow text when sidebars are open.
			</p>
		</div>
		<div class="closer icon-cancel-circled"></div>
	</div>
</div>
<div class="overlay"></div>
</body>
</html>
