package com.sdr.curation;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.theme.ThemeDisplay;
import com.sdr.file.PropConst;

import java.util.ArrayList;
import java.util.List;

public class CurateSender {
	
	private static Log log = LogFactoryUtil.getLog(CurateSender.class);


	public static void send(Long datasetId, Long ppId, ServiceContext serviceContext) {
		List<Long> dsIdList = new ArrayList<>();
		dsIdList.add( datasetId );
		List<Long> ppIdList = null;
		if (ppId!=null) {
			ppIdList = new ArrayList<>();
			ppIdList.add(ppId);
		}
		CurateSender.send( dsIdList, ppIdList, serviceContext );
	}


	public static void send(List<Long> dsIdList, List<Long> ppId, ServiceContext serviceContext) {

		// TODO :
		if ( PropConst.getAccessPoint() == null ) {
			ThemeDisplay themeDisplay = serviceContext.getThemeDisplay();
			String serverName = themeDisplay.getServerName();
			String virtualHostName = themeDisplay.getCompany().getVirtualHostname();

			if(!serverName.equals(virtualHostName)){
				serverName += ":"+themeDisplay.getServerPort();
			}
			PropConst.setAccessPoint(themeDisplay.isSecure(), serverName, true);
		}


		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		for ( int i = 0 ; i < dsIdList.size(); i++ ) {
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("id", dsIdList.get(i));
			if ( (ppId != null) && (ppId.size()>i) )
				jsonObject.put("pp", ppId.get(i));
			jsonArray.put(jsonObject);
		}

		MessageBusUtil.sendMessage("dataset/curate", jsonArray.toString());
		log.debug("message Bus (Bulk send) : " + dsIdList);
	}

}