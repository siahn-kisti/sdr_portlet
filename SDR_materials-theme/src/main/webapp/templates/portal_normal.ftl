<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${the_title} - ${company_name}</title>

	<meta content="initial-scale=1.0, width=device-width" name="viewport" />
    <meta name="format-detection" content="telephone=no">

	${theme.include(top_head_include)}
</head>

<#if theme.getSetting("dockbar-vertical") == "true">
	<#assign css_class = css_class + " dockbar-vertical" />
</#if>

<body class="${css_class}">

<a href="#main-content" id="skip-to-content"><@liferay.language key="skip-to-content" /></a>

${theme.include(body_top_include)}

<@liferay.dockbar />

<nav id="nav-area">
	<div id="nav-top">
        <a id="edison-logo" href="http://edison.re.kr">
            <div class="edison-logo-img"></div>
        </a>
		<a id="msc-logo" href="${site_default_url}" title="<@liferay.language_format arguments='${site_name}' key='go-to-x' />" >
            Materials Science <strong title="${logo_description}">Community</strong>
		</a>
		<div id="nav-header">
			<#include "${full_templates_path}/navigation.ftl" />
		</div>			
	</div>
</nav>
  
<div id="breadcrumb-nav"><!--@liferay.breadcrumbs /-->
	<br>
    <br>
    <br>
</div>

<div id="sub-area">
	<#if selectable>
		${theme.include(content_include)}
	<#else>
		${portletDisplay.recycle()}

		${portletDisplay.setTitle(the_title)}

		${theme.wrapPortlet("portlet.ftl", content_include)}
	</#if>
</div>

<footer>
   <div id="footer-width">
       <div class="footer-text">
            COPYRIGHT(C) 2017 NISN, KISTI ALL RIGHTS RESERVED.<a class="privacy" href="${privateInfoURL}">개인정보처리방침</a><span>E-mail. sunilahn@gmail.com</span>
           <a href="http://www.kisti.re.kr" class="banner" target="_blank"><img src="${images_folder}/custom/footer/footer_kisti.gif" alt="한구과학기술정보연구원" /></a>
           <a href="http://www.nrf.re.kr" class="banner" target="_blank"><img src="${images_folder}/custom/footer/footer_nrf.gif" alt="한국연구재단" /></a>
           <a href="http://www.msip.go.kr" class="banner" target="_blank"><img src="${images_folder}/custom/footer/footer_msip.gif" alt="과학기술정보통신부" /></a>
        </div>
    </div>
</footer>

${theme.include(body_bottom_include)}

${theme.include(bottom_include)}

</body>

</html>