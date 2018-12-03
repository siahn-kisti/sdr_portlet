package com.sdr.common.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.util.portlet.PortletProps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * VC 계정생성
 * @author mhkang
 *
 */
public class VCRegisterUtil{
	
	/**
	 * VC계정 생성
	 * @throws ParseException 
	 * @throws SystemException 
	 * @throws PortalException 
	 * @userId : 회원아이디
	 * @password : 비밀번호
	 */
	public static int isVcInfo(String userScreenName) throws MalformedURLException, IOException, ParseException, PortalException, SystemException {		

		int resultCode = 0;
		
		if(!userScreenName.equals("")){
			//Group thisGroup = GroupLocalServiceUtil.getGroup(groupId);
			//String icebreakerUrl = CustomUtil.strNull(thisGroup.getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL));
			String icebreakerUrl = SimulationConstants.ICEBREAKER_URL;
			
			URL url = new URL(icebreakerUrl+"/api/user/"+userScreenName+"/info");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
			
			//GET Admin Token		
			conn.setRequestProperty("Authorization", "Basic " + TokenProviderUtil.getAdminVcToken().get("vcToken"));
			
			resultCode = conn.getResponseCode();
			
			if (conn.getResponseCode() == 200) {
				System.out.println("SUCCESS VCInfo [ VCInfo ] : USER ID - "+userScreenName);
			}else if (conn.getResponseCode() == 401) {
				System.out.println("Failed VCInfo [ VCInfo ] : UNAUTHORIZED : not an admin - HTTP error code : " + conn.getResponseCode());
			}else if (conn.getResponseCode() == 404) {
				System.out.println("Failed VCInfo [ VCInfo ] : NOT FOUND : no existing - HTTP error code : " + conn.getResponseCode());
			}else{			
				System.out.println("Failed VCInfo [ VCInfo ] : ETC : etc error - HTTP error code : " + conn.getResponseCode());
			}
			
			resultCode = conn.getResponseCode();
			
			conn.disconnect();		
		}else{
			System.out.println("Failed VCInfo [ VCInfo ] : userId,password is NOT NULL - Request error code : 999");
			resultCode = 999;
		}
		return resultCode;
	}
	
	/**
	 * VC계정 조회
	 */
	public static Map getVcInfo(String userScreenName) throws MalformedURLException, IOException, ParseException, PortalException, SystemException {		

		Map resultMap = new HashMap();
		
		//Group thisGroup = GroupLocalServiceUtil.getGroup(groupId);
		//String icebreakerUrl = CustomUtil.strNull(thisGroup.getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL));
		String icebreakerUrl = SimulationConstants.ICEBREAKER_URL;
		
		if(!CustomUtil.strNull(userScreenName).equals("")){
		
			URL url = new URL(icebreakerUrl+"/api/user/"+userScreenName+"/info");
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
			
			//GET Admin Token
			conn.setRequestProperty("Authorization", "Basic "+ TokenProviderUtil.getAdminVcToken().get("vcToken"));

			String  output = "";		
			StringBuffer responseBuffer = new StringBuffer();			
			
			if (conn.getResponseCode() == 200) {

				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

				while ((output = br.readLine()) != null) {
					if(!CustomUtil.strNull(output).equals("null")){

						responseBuffer.append(CustomUtil.strNull(output));
						
						JSONObject json = JSONFactoryUtil.createJSONObject(responseBuffer.toString());

						resultMap.put("storageSource", CustomUtil.strNull(json.getString("storageSource")));
						resultMap.put("registeredDate", CustomUtil.strNull(json.getString("registeredDate")));						
					}
				}
			}else if (conn.getResponseCode() == 401) {
				System.out.println("Failed  [ VCInfoSearch ] : UNAUTHORIZED : not an admin - HTTP error code : " + conn.getResponseCode());
			}else if (conn.getResponseCode() == 404) {
				System.out.println("Failed  [ VCInfoSearch ] : NOT FOUND : no existing - HTTP error code : " + conn.getResponseCode());
			}else{			
				System.out.println("Failed  [ VCInfoSearch ] : ETC : etc error - HTTP error code : " + conn.getResponseCode());
			}	
			
			conn.disconnect();		
		}else{
			System.out.println("Failed  [ VCInfoSearch ] : userId,password is NOT NULL - Request error code : 999");
		}
		
		return resultMap;
	}	
	/**
	 * VC계정 조회
	 * @throws ParseException 
	 * @throws SystemException 
	 * @throws PortalException 
	 * @userId : 회원아이디
	 * @password : 비밀번호
	 */
	public static JSONObject VCInfoJsonSearch(String userScreenName) throws MalformedURLException, IOException, ParseException, PortalException, SystemException {
		
		JSONObject json = null;

		//Group thisGroup = GroupLocalServiceUtil.getGroup(groupId);
		//String icebreakerUrl = CustomUtil.strNull(thisGroup.getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL));
		String icebreakerUrl = SimulationConstants.ICEBREAKER_URL;
		
		if(!CustomUtil.strNull(userScreenName).equals("")){
		
			URL url = new URL(icebreakerUrl+"/api/user/"+userScreenName+"/info");
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
			
			//GET Admin Token
			conn.setRequestProperty("Authorization", "Basic "+ TokenProviderUtil.getAdminVcToken().get("vcToken"));

			String  output = "";		
			StringBuffer responseBuffer = new StringBuffer();
			
			if (conn.getResponseCode() == 200) {

				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

				while ((output = br.readLine()) != null) {
					if(!CustomUtil.strNull(output).equals("null")){

						responseBuffer.append(CustomUtil.strNull(output));
						
						json = JSONFactoryUtil.createJSONObject(responseBuffer.toString());
					}
				}
			}else if (conn.getResponseCode() == 401) {
				System.out.println("Failed  [ VCInfoSearch ] : UNAUTHORIZED : not an admin - HTTP error code : " + conn.getResponseCode());
			}else if (conn.getResponseCode() == 404) {
				System.out.println("Failed  [ VCInfoSearch ] : NOT FOUND : no existing - HTTP error code : " + conn.getResponseCode());
			}else{			
				System.out.println("Failed  [ VCInfoSearch ] : ETC : etc error - HTTP error code : " + conn.getResponseCode());
			}	
			
			conn.disconnect();		
		}else{
			System.out.println("Failed  [ VCInfoSearch ] : userId,password is NOT NULL - Request error code : 999");
		}
		
		return json;
	}
	
	
	
	/**
	 * VC계정 생성
	 * @throws ParseException 
	 * @throws SystemException 
	 * @throws PortalException 
	 * @userId : 회원아이디
	 * @password : 비밀번호
	 */
	public static int VCRegist(String userScreenName, String password, String email, String userName,String universityField, String virtualLabId, String classId, String majorField) throws MalformedURLException, IOException, ParseException, PortalException, SystemException {		
		
		int resultCode = 0;
		
		//Group thisGroup = GroupLocalServiceUtil.getGroup(groupId);
		//String icebreakerUrl = CustomUtil.strNull(thisGroup.getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL));
		String icebreakerUrl = SimulationConstants.ICEBREAKER_URL;
		
		if(!CustomUtil.strNull(userScreenName).equals("") && !CustomUtil.strNull(password).equals("")){
			
			URL url = new URL(icebreakerUrl+"/api/user/register");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
			
			//GET Admin Token
			conn.setRequestProperty("Authorization", "Basic "+ TokenProviderUtil.getAdminVcToken().get("vcToken"));
			
			StringBuffer bodyStr = new StringBuffer();
			
			bodyStr.append("{");
			bodyStr.append("	\"userId\" : \""+userScreenName+"\", ");
			bodyStr.append("	\"password\" : \""+password+"\", ");					
			bodyStr.append("	\"userName\" : \""+userName+"\", ");
			if(universityField != null && !universityField.equals("")) {
				bodyStr.append("	\"affiliation\" : \""+universityField+"\", ");			
			}
			if(virtualLabId != null && !virtualLabId.equals("")) {
				bodyStr.append("	\"cyberLabId\" : \""+virtualLabId+"\", ");
			}
			if(classId != null && !classId.equals("")) {
				bodyStr.append("	\"classId\" : \""+classId+"\", ");
			}
			if(majorField != null && !majorField.equals("")) {
				bodyStr.append("	\"major\" : \""+majorField+"\", ");
			}
//			bodyStr.append("	\"className\" : \"className\", ");
			bodyStr.append("	\"email\" : \""+email+"\" ");
			
			bodyStr.append("}");
			
			System.out.println(bodyStr.toString());			
			
			OutputStream os = conn.getOutputStream();
			os.write(bodyStr.toString().getBytes());
			os.flush();
			
			if (conn.getResponseCode() == 201) {
				System.out.println("SUCCESS VCRegister [ VCRegist ] : CREATED ID - "+userScreenName);
			}else if (conn.getResponseCode() == 401) {
				System.out.println("Failed VCRegister [ VCRegist ] : UNAUTHORIZED : not an admin - HTTP error code : " + conn.getResponseCode());
			}else if (conn.getResponseCode() == 409) {
				System.out.println("Failed VCRegister [ VCRegist ] : CONFLICT : already exist - HTTP error code : " + conn.getResponseCode());
			}else{			
				System.out.println("Failed VCRegister [ VCRegist ] : ETC : etc error - HTTP error code : " + conn.getResponseCode());
			}
			
			resultCode = conn.getResponseCode();
			
			conn.disconnect();		
		}else{
			System.out.println("Failed VCRegister [ VCRegist ] : userId,password is NOT NULL - Request error code : 999");
			resultCode = 999;
		}
		return resultCode;
	}
	
	/**
	 * VC계정 수정
	 * @throws ParseException 
	 * @throws SystemException 
	 * @throws PortalException 
	 * @userId : 회원아이디
	 * @password : 비밀번호
	 */
	public static int VCUpdate(String userScreenName, String password, String email) throws MalformedURLException, IOException, ParseException, PortalException, SystemException {		
		
		int resultCode = 0;
		
		if(!CustomUtil.strNull(userScreenName).equals("") && !CustomUtil.strNull(password).equals("")){
			
			//사용자 정보 수정하기 전 기존의 사용자 정보를 조회
			JSONObject json = VCInfoJsonSearch(userScreenName);
			
			json.put("password", CustomUtil.strNull(password));

			//Group thisGroup = GroupLocalServiceUtil.getGroup(groupId);
			//String icebreakerUrl = CustomUtil.strNull(thisGroup.getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL));
			String icebreakerUrl = SimulationConstants.ICEBREAKER_URL;
			
			URL url = new URL(icebreakerUrl+"/api/user/"+userScreenName);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setDoOutput(true);
			conn.setRequestMethod("PUT");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
			
			//GET Admin Token
			conn.setRequestProperty("Authorization", "Basic "+TokenProviderUtil.getAdminVcToken().get("vcToken"));
						
			json.put("userName", "userName");	
			json.put("affiliation", "affiliation");	
			json.put("major", "major");	
			json.put("className", "className");	
			json.put("cyberLabId", "cyberLabId");	
			json.put("cyberLabId", "cyberLabId");	
			json.put("classId", "classId");

			json.put("email", email);
			json.put("password", password);
			json.put("userId", userScreenName);
						
			OutputStream os = conn.getOutputStream();
			os.write(json.toString().getBytes());
			os.flush();
			
			if (conn.getResponseCode() == 200) {
				System.out.println("SUCCESS VCUpdater [ VCUpdate ] : UPDATE ID - "+userScreenName);
			}else if (conn.getResponseCode() == 401) {
				System.out.println("Failed VCUpdater [ VCUpdate ] : UNAUTHORIZED : not an admin - HTTP error code : " + conn.getResponseCode());
			}else if (conn.getResponseCode() == 404) {
				System.out.println("Failed VCUpdater [ VCUpdate ] : NOT FOUND : no existing user - HTTP error code : " + conn.getResponseCode());
			}else{			
				System.out.println("Failed VCUpdater [ VCUpdate ] : ETC : etc error - HTTP error code : " + conn.getResponseCode());
			}
			
			resultCode = conn.getResponseCode();
			
			conn.disconnect();		
		}else{
			System.out.println("Failed VCRegister [ VCUpdate ] : userId,password is NOT NULL - Request error code : 999");
			resultCode = 999;
		}
		return resultCode;
	}
	
	
	/**
	 * VC 계정 DEACTIVATE
	 * @throws IOException 
	 * @throws ParseException 
	 * @throws SystemException 
	 * @throws PortalException 
	 */
	public static int VCDeactivate(Object params) throws IOException, ParseException, PortalException, SystemException{
		int resultCode = 0;
		StringBuffer bodyStr = new StringBuffer();
		
		if(params instanceof HashMap){
			Map userMap = (Map) params;
			if(CustomUtil.strNull(userMap.get("userScreenName")).equals("")){
				System.out.println("Failed VCDeativate [ VCDeativate Map] : userId is NOT NULL - Request error code : 999");
				return resultCode = 999;
			}else{
				System.out.println("VCDeativate [ VCDeativate Map] : userId"+CustomUtil.strNull(userMap.get("userScreenName")));
				bodyStr.append("<users>");
				bodyStr.append("<user><userId>"+CustomUtil.strNull(userMap.get("userScreenName"))+"</userId></user>");
				bodyStr.append("</users>");
			}
		}else if(params instanceof List){
			Map userMap = null;
			List userList = (List) params;
			bodyStr.append("<users>");
			
			root1:for(int i=0;i<userList.size();i++){
				userMap = new HashMap();
				userMap = (Map) userList.get(i);
				
				if(CustomUtil.strNull(userMap.get("userScreenName")).equals("")){
					System.out.println("Failed VCDeativate [ VCDeativate List] : userId is NOT NULL - Request error code : 999");
					return resultCode = 999;
				}else{
					System.out.println("VCDeativate [ VCDeativate List] : userId"+CustomUtil.strNull(userMap.get("userScreenName")));
					bodyStr.append("<user><userId>"+CustomUtil.strNull(userMap.get("userScreenName"))+"</userId></user>");
				}
			}
			bodyStr.append("</users>");
		}else{
			System.out.println("Failed VCDeativate [ VCDeativate ] : unKnow instance Type - Request error code : 999");
			return resultCode = 999;
		}
		
		//Group thisGroup = GroupLocalServiceUtil.getGroup(groupId);
		//String icebreakerUrl = CustomUtil.strNull(thisGroup.getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL));
		String icebreakerUrl = SimulationConstants.ICEBREAKER_URL;
		
		URL url = new URL(icebreakerUrl+"/api/user/deactivate");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		conn.setDoOutput(true);
		conn.setRequestMethod("PUT");
		conn.setRequestProperty("Accept", "application/xml");
		conn.setRequestProperty("Content-Type", "application/xml");
		
		//GET Admin Token
		conn.setRequestProperty("Authorization", "Basic "+TokenProviderUtil.getAdminVcToken().get("vcToken"));
		
		OutputStream os = conn.getOutputStream();
		os.write(bodyStr.toString().getBytes());
		os.flush();
		
		if (conn.getResponseCode() == 200) {
			System.out.println("SUCCESS VCDeativate [ VCDeativate ] : DEATIVATE");
		}else if (conn.getResponseCode() == 401) {
			System.out.println("Failed VCDeativate [ VCDeativate ] : UNAUTHORIZED : not an admin - HTTP error code : " + conn.getResponseCode());
		}else if (conn.getResponseCode() == 404) {
			System.out.println("Failed VCDeativate [ VCDeativate ] : NOT FOUND : no existing user - HTTP error code : " + conn.getResponseCode());
		}else{
			System.out.println("Failed VCDeativate [ VCDeativate ] : ETC : etc error - HTTP error code : " + conn.getResponseCode());
		}
		
		resultCode = conn.getResponseCode();
		
		conn.disconnect();		
		return resultCode;
	}
	
	/**
	 * VC계정 삭제
	 * @throws ParseException 
	 * @throws SystemException 
	 * @throws PortalException 
	 * @userId : 회원아이디
	 */
	public static int VCDelete(String userScreenName) throws MalformedURLException, IOException, ParseException, PortalException, SystemException {		

		int resultCode = 0;

		//Group thisGroup = GroupLocalServiceUtil.getGroup(groupId);
		//String icebreakerUrl = CustomUtil.strNull(thisGroup.getExpandoBridge().getAttribute(EdisonExpando.SITE_ICEBREAKER_URL));
		String icebreakerUrl = SimulationConstants.ICEBREAKER_URL;
		
		if(!CustomUtil.strNull(userScreenName).equals("")){
		
			URL url = new URL(icebreakerUrl+"/api/user/"+userScreenName);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setDoOutput(true);
			conn.setRequestMethod("DELETE");
			conn.setRequestProperty("Accept", "application/json");
			
			//GET Admin Token
			conn.setRequestProperty("Authorization", "Basic "+TokenProviderUtil.getAdminVcToken().get("vcToken"));

			resultCode = conn.getResponseCode();
			
			if (resultCode == 200) {
				System.out.println("SUCCESS VCRegister [ VCDelete ] : DELETE ID - "+userScreenName);
			}else if (resultCode == 401) {
				System.out.println("Failed VCRegister [ VCDelete ] : UNAUTHORIZED : not an admin - HTTP error code : " + conn.getResponseCode());
			}else if (resultCode == 404) {
				System.out.println("Failed VCRegister [ VCDelete ] : NOT FOUND : not existing user - HTTP error code : " + conn.getResponseCode());
			}else if (resultCode == 403) {
				System.out.println("Failed VCRegister [ VCDelete ] : FORBIDDEN : not allowed to delete \"admin\" - HTTP error code : " + conn.getResponseCode());				
			}else{			
				System.out.println("Failed VCRegister [ VCDelete ] : ETC : etc error - HTTP error code : " + conn.getResponseCode());
			}			
			
			conn.disconnect();		
		}else{
			System.out.println("Failed VCRegister [ VCDelete ] : userId is NOT NULL - Request error code : 999");
			resultCode = 999;
		}
		return resultCode;
	}	
	
}