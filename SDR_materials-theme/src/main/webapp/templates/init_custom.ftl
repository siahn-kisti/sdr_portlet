<#--
This file allows you to override and define new FreeMarker variables.
-->

<#if theme.getSetting("content-title") != "">
    <#assign the_title = theme.getSetting("content-title") />
</#if>

<#--<#assign privateInfoURL = company_url+"/privateinfopolicy/-/materialsprivateinfopolicy/view"/>-->
<#--<#assign termOfUseURL = company_url+"/termsofuse/-/materialstermsofuse/view"/>-->
<#assign privateInfoURL = company_url+"/privateinfopolicy/-/privateinfopolicy/view"/>
<#assign termOfUseURL = company_url+"/termsofuse/-/termsofuse/view"/>