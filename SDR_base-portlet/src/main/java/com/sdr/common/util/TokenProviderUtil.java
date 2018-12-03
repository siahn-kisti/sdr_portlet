package com.sdr.common.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.util.portlet.PortletProps;
import com.sdr.metadata.model.IceBreakerVcToken;
import com.sdr.metadata.model.IceBreakerVcTokenClp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;


/**
 * Admin Token 관리를 위한 Singleton Method
 * @author mhkang
 *
 */
public class TokenProviderUtil{
	
	private static Log logger = LogFactoryUtil.getLog(TokenProviderUtil.class);
	
	private static String adminVcToken = "";
	private static Date adminVcTokenExpired = null;

	public static Map<String, Object> getVcToken(String icebreakUserId, String icebreakerUserPwd) throws MalformedURLException, IOException, ParseException, PortalException, SystemException {

		//Group thisGroup = GroupLocalServiceUtil.getGroup(groupId);
		//String icebreakerUrl = CustomUtil.strNull(thisGroup.getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL));
		String icebreakerUrl = SimulationConstants.ICEBREAKER_URL;

		URL url = new URL(icebreakerUrl+"/api/user/login");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Accept", "application/json");
		conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");

		StringBuffer bodyStr = new StringBuffer();

		Map returnMap = new HashMap();

		String responseValue = "";
		String tokenStr = "";
		String expiredStr = "";
		Date date = null;
		
		bodyStr.append("{");
		bodyStr.append("	\"userId\" : \""+icebreakUserId+"\", ");
		bodyStr.append("	\"password\" : \""+icebreakerUserPwd+"\" ");
		bodyStr.append("}");

		OutputStream os = conn.getOutputStream();
		os.write(bodyStr.toString().getBytes());
		os.flush();

		if (conn.getResponseCode() == 200) {
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String output = "";
			while ((output = br.readLine()) != null) {
				responseValue += output;
			}

			responseValue = CustomUtil.replace(responseValue, "\"", "");

			String[] arr = responseValue.split("\\\\n");

			for(int i=0;i<arr.length;i++){
				if(i == 0){
					tokenStr = arr[i].toString();
					tokenStr = CustomUtil.replace(tokenStr, "Token: ", "");
				}else if(i == 1){
					expiredStr = arr[i].toString();
					expiredStr = CustomUtil.replace(expiredStr, "Expired: ", "");

					DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);
					

					date = dateFormat.parse(expiredStr);

					expiredStr = sdf.format(date);
				}
			}
		}else{
			System.out.println("Failed AdminTokenProvider [ getTokenApi ] : HTTP error code : " + conn.getResponseCode());
		}

		Map<String, Object> icebreakerVcToken = new HashMap<String, Object>();
		icebreakerVcToken.put("vcToken", tokenStr);
		icebreakerVcToken.put("vcTokenExpired", date);
		icebreakerVcToken.put("resultCode", conn.getResponseCode());

//		icebreakerVcToken = new IceBreakerVcTokenClp();
//
//		icebreakerVcToken.setVcToken(tokenStr);
//		icebreakerVcToken.setVcTokenExpired(date);
//		icebreakerVcToken.setResultCode(conn.getResponseCode());
		conn.disconnect();

		return icebreakerVcToken;
	}


	public static Map<String, Object> getAdminVcToken() throws MalformedURLException, IOException, ParseException, PortalException, SystemException  {

		if(adminVcToken.equals("") || Integer.parseInt(CustomUtil.dateToStringFormat(adminVcTokenExpired, "yyyyMMdd")) < Integer.parseInt(CustomUtil.dateToStringFormat(new Date(), "yyyyMMdd"))){
			//Group thisGroup = GroupLocalServiceUtil.getGroup(groupId);

			//String icebreakerUrl = CustomUtil.strNull(thisGroup.getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL));
			String icebreakerAdminId = SimulationConstants.ICEBREAKER_ADMIN_ID;
			String icebreakerAdminPwd = SimulationConstants.ICEBREAKER_ADMIN_PWD;

			return getVcToken(icebreakerAdminId, icebreakerAdminPwd);
		}else{
//			icebreakerVcToken = new IceBreakerVcTokenClp();
//
//			icebreakerVcToken.setVcToken(adminVcToken);
//			icebreakerVcToken.setVcTokenExpired(adminVcTokenExpired);
//			icebreakerVcToken.setResultCode(200);
			
			Map<String, Object> icebreakerVcToken = new HashMap<String, Object>();	
			icebreakerVcToken.put("vcToken", adminVcToken);
			icebreakerVcToken.put("vcTokenExpired", adminVcTokenExpired);
			icebreakerVcToken.put("resultCode", 200);

			return icebreakerVcToken;
		}
	}

}