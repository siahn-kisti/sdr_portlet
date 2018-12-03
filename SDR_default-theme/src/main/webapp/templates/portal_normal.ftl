<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
    <title>${the_title} - ${company_name}</title>

    <meta content="initial-scale=1.0, width=device-width" name="viewport"/>
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

<div id="nav-bg">
    <div id="main-nav">
        <nav id="nav-header">
            <#include "${full_templates_path}/nav_header.ftl" />
        </nav>
        <nav id="nav-menu">
            <#include "${full_templates_path}/nav_menu.ftl" />
        </nav>
    </div>
</div>

<div id="breadcrumb-nav"><@liferay.breadcrumbs /></div>

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
            COPYRIGHT(C) 2017 NISN, KISTI ALL RIGHTS RESERVED.<a href="${privateInfoURL}">개인정보처리방침</a><span>E-mail. edison@kisti.re.kr</span>
        </div>
    </div>
</footer>

${theme.include(body_bottom_include)}

${theme.include(bottom_include)}

</body>

</html>