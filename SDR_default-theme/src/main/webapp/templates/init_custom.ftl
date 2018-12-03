<#--
This file allows you to override and define new FreeMarker variables.
-->

<#assign privateInfoURL = company_url+"/privateinfopolicy/-/privateinfopolicy/view"/>
<#assign termOfUseURL = company_url+"/termsofuse/-/termsofuse/view"/>

<#assign portletId = "sdrcommon_WAR_SDR_baseportlet" />
<#assign joinCommunityURL =  portletURLFactory.create(request, portletId, themeDisplay.getPlid(), "RESOURCE_PHASE") + "&p_p_resource_id=joinCommunity" />
<#assign hasJoinCommunityURL =  portletURLFactory.create(request, portletId, themeDisplay.getPlid(), "RESOURCE_PHASE") + "&p_p_resource_id=hasJoinCommunity" />
