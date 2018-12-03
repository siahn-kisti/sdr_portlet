package com.sdr.common.util;

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

import com.sdr.common.model.EdisonExpando;
import com.sdr.common.model.EdisonRoleConstants;
import com.sdr.common.model.IcebreakerVcToken;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Group;
import com.liferay.portal.service.GroupLocalServiceUtil;

/**
 * Admin Token 관리를 위한 Singleton Method
 * @author mhkang
 *
 */
public class TokenProviderUtilforEdison{
	
//	private static Log logger = LogFactoryUtil.getLog(RequestUtil.class);
	
	private static String adminVcToken = "";
	private static String adminVcTokenExpired = "";
			
	public static IcebreakerVcToken getVcToken(long groupId, String icebreakUserId, String icebreakerUserPwd) throws MalformedURLException, IOException, ParseException, PortalException, SystemException  {

		Group thisGroup = GroupLocalServiceUtil.getGroup(groupId);
		String icebreakerUrl = CustomUtil.strNull(thisGroup.getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL));
		
//		String icebreakerUrl = "http://10.10.0.245:8080/eCloud20150430";
		
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
					Date date = null;

					date = dateFormat.parse(expiredStr);

					expiredStr = sdf.format(date); 				     
				}
			}
		}else{			
			System.out.println("Failed AdminTokenProvider [ getTokenApi ] : HTTP error code : " + conn.getResponseCode());
		}
		
		IcebreakerVcToken icebreakerVcToken = new IcebreakerVcToken();
		
		icebreakerVcToken.setVcToken(tokenStr);
		icebreakerVcToken.setVcTokenExpired(expiredStr);
		icebreakerVcToken.setResultCode(conn.getResponseCode());
	    
		conn.disconnect();

		return icebreakerVcToken;
	}


	public static IcebreakerVcToken getAdminVcToken(long groupId) throws MalformedURLException, IOException, ParseException, PortalException, SystemException  {

		IcebreakerVcToken icebreakerVcToken;
		
		if(adminVcToken.equals("") || Integer.parseInt(adminVcTokenExpired) < Integer.parseInt(CustomUtil.dateToStringFormat(new Date(), "yyyyMMdd"))){
			Group thisGroup = GroupLocalServiceUtil.getGroup(groupId);		

			String icebreakerUrl = CustomUtil.strNull(thisGroup.getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL));
			String icebreakerAdminId = CustomUtil.strNull(thisGroup.getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_ADMIN_ID));
			String icebreakerAdminPwd = CustomUtil.strNull(thisGroup.getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_ADMIN_PWD));

			return getVcToken(groupId, icebreakerAdminId, icebreakerAdminPwd);
		}else{ 
			icebreakerVcToken = new IcebreakerVcToken();			

			icebreakerVcToken.setVcToken(adminVcToken);
			icebreakerVcToken.setVcTokenExpired(adminVcTokenExpired);
			icebreakerVcToken.setResultCode(200);
			
			return icebreakerVcToken;
		}
	}
	
	
	public static void main(String[] args)  throws MalformedURLException, IOException, ParseException, PortalException, SystemException  {
		
		IcebreakerVcToken aaa = getVcToken(140780, "admin", "edison2013!!");
		
		System.out.println("getVcToken : "+aaa.getVcToken());
		System.out.println("getResultCode : "+aaa.getResultCode());
		System.out.println("getVcTokenExpired : "+aaa.getVcTokenExpired());
		
		
		
	}	
		
	
	
}