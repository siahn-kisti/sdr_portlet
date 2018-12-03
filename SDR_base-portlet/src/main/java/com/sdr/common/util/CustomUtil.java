package com.sdr.common.util;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Group;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.UUID;


public final class CustomUtil {
	

	/**
	 * 대상 문자 변수가 null인 경우 ""로 반환
	 */
    public static String strNull(Object o) {
        if (o == null) {
            return "";
        }
        return deleteScriptTag(o.toString());
    }
    public static String strNull(Object o, String str) {
        if (o == null || o.toString().equals("")) {
            return str;
        }
        return deleteScriptTag(o.toString());
    }
    
	public static String deleteScriptTag(String str) 
	{
		String returnStr = null;
		try {
			returnStr = replace(str,"<%","&lt;%");             
			returnStr = replace(returnStr,"%>","%&gt;");             
			returnStr = replace(returnStr,"<script","&lt;script");   
			returnStr = replace(returnStr,"</script","&lt;/script"); 
			returnStr = replace(returnStr,"javascript",""); 
			returnStr = replace(returnStr,"alert",""); 
			//returnStr = replace(returnStr,"<img","&lt;img"); 
		} catch (Exception e) {}
		return returnStr;
	}
	
	public static String replace(String str, String oldStr, String newStr)
	{
		StringBuffer result = new StringBuffer(str.length());
		int index1 = 0, index2 = 0;

		while((index2=str.indexOf(oldStr, index1)) >= 0)
		{
			result.append(str.substring(index1, index2));
			result.append(newStr);
			index1 = index2+oldStr.length();
		}
		result.append(str.substring(index1));           

		return result.toString(); 
	}	

	/**
	 * 
	 * @param dt 
	 * @param format yyyy.MM.dd
	 * @return str yyyy.MM.dd");
	 * @throws ParseException 
	 */
	public static String dateToStringFormat(Date dt, String format)
	{
		SimpleDateFormat fmt = new SimpleDateFormat(format);
		String dtStr = "";
		if(dt!=null){
			dtStr = fmt.format(dt).toString();
		}
		return dtStr; 
	}	

	/**
	 * 
	 * @param str    yyyy-mm-dd
	 * @return date
	 * @throws ParseException 
	 */
	public static Date StringToDateFormat(String str, String format) throws ParseException
	{
		Date dt = new Date();
		if(str != null && !str.equals("")){
			SimpleDateFormat transFormat = new SimpleDateFormat(format);
			dt = transFormat.parse(str);
		}
		
		return dt; 
	}	
	

	public static Locale stringToLocale(String locale)
	{
		Locale returnLocale;
		
		if(locale == null || locale.equals("")){
			returnLocale = Locale.getDefault();
		}else if(locale.equals(Locale.KOREA.toString())){
			returnLocale = Locale.KOREA;
		}else if(locale.equals(Locale.TAIWAN.toString())){
			returnLocale = Locale.TAIWAN;
		}else{
			returnLocale = Locale.US;
		}
		
		return returnLocale; 
	}	

	
	public static String getRandomString(int length){
	   String randomStr = UUID.randomUUID().toString();
	   while(randomStr.length() < length) {
	       randomStr += UUID.randomUUID().toString();
	   }
	   return randomStr.substring(0, length);
	}
	
	
    /**
     * 대상 파라미터가 문자열인지 배열 형인지 판단하여 무조건 배열형으로 변환하여 보내줌.
     * @param o
     * @return
     */
    public static String[] paramToArray(Object o) {
    	String[] arr = null;
    	if(o instanceof String){
    		arr = new String[]{strNull(o)};
    	}else{
    		arr = (String[])o;
    	}
        return arr;
    }
    
    /**
     * 다국어 map Create
     * 다국어 정보를 모두 입력 하지 않았을 경우에는 입력된 쪽의 다국어 값을 입력되지 않은 필드에 SET
     * @param param - RequestUtil을 통하여 request에서 변환된 Map
     * @param parameter - 다국어가 적용된 Parameter
     * @return
     */
    public static Map<Locale,String> getLocalizationMap(Map param,String parameter){
    	Locale[] locales = LanguageUtil.getAvailableLocales();
    	
    	Map<Locale, String> map = new HashMap<Locale, String>();
    	List<Locale> nullLoacleList = new ArrayList<Locale>();
    	String nullDataReplace = "";
    	
    	for (Locale locale : locales) {
			String languageId = LocaleUtil.toLanguageId(locale);

			String localeParameter = parameter.concat(StringPool.UNDERLINE).concat(languageId);
			
			if(strNull(param.get(localeParameter)).equals("")){
				nullLoacleList.add(locale);
			}else{
				map.put(locale, strNull(param.get(localeParameter)));
				nullDataReplace = strNull(param.get(localeParameter));
			}
		}
    	
    	if(nullLoacleList.size()>0){
    		for (Locale locale : nullLoacleList) {
    			map.put(locale, nullDataReplace);
    		}
    	}
		return map;
    }
    
    /**
     * 다국어 map Create
     * 다국어 정보를 모두 입력 하지 않았을 경우에는 입력된 쪽의 다국어 값을 입력되지 않은 필드에 SET 하지않음
     * @param param - RequestUtil을 통하여 request에서 변환된 Map
     * @param parameter - 다국어가 적용된 Parameter
     * @return
     */
    public static Map<Locale,String> getLocalizationNotSetLocaleMap(Map param,String parameter){
    	Locale[] locales = LanguageUtil.getAvailableLocales();
    	
    	Map<Locale, String> map = new HashMap<Locale, String>();
    	
    	for (Locale locale : locales) {
    		String languageId = LocaleUtil.toLanguageId(locale);
    		
    		String localeParameter = parameter.concat(StringPool.UNDERLINE).concat(languageId);

			map.put(locale, strNull(param.get(localeParameter)));
    	}
    	return map;
    }

	
	public static String getStatusConvertIceToPortal(String icebreakerStatus){
		String returnStatus = "codeConvertError";
		
		if(icebreakerStatus != null && !icebreakerStatus.equals("")){

		   	     if(icebreakerStatus.equals("UNKNOWN"))				returnStatus = "1701001";
			else if(icebreakerStatus.equals("INITIALIZE_FAILED"))	returnStatus = "1701002";
			else if(icebreakerStatus.equals("INITIALIZED"))			returnStatus = "1701003";
			else if(icebreakerStatus.equals("SUBMISSION_FAILED"))	returnStatus = "1701004";
			else if(icebreakerStatus.equals("QUEUED"))				returnStatus = "1701005";
			else if(icebreakerStatus.equals("RUNNING"))				returnStatus = "1701006";
			else if(icebreakerStatus.equals("SUSPEND_REQUESTED"))	returnStatus = "1701007";
			else if(icebreakerStatus.equals("SUSPENDED"))			returnStatus = "1701008";
			else if(icebreakerStatus.equals("CANCEL_REQUESTED"))	returnStatus = "1701009";
		   	     
			else if(icebreakerStatus.equals("CANCEL"))				returnStatus = "1701010";
			else if(icebreakerStatus.equals("CANCELED"))			returnStatus = "1701010";
			else if(icebreakerStatus.equals("SUCCESS"))				returnStatus = "1701011";
			else if(icebreakerStatus.equals("FAILED"))				returnStatus = "1701012";
		}
		
		return returnStatus;
	}   	
	
    /**
     * StringTokenizer를 이용해서 문자열을 분리해서
     * 쿼리용(IN ())으로 문자열 조정
     * @param str String : 대상문자열 
     * @param delim String : 분리자
     */
    public static String getForInQuery(String str, String delim){
    	StringTokenizer stz = new StringTokenizer(str, delim);
    	String inStr = "";
    	int i = 0;
    	while(stz.hasMoreTokens()){
    		inStr = inStr+ (i==0?"":",") + "\""+stz.nextToken().trim()+"\"";
    		i++;
    	}
    	return inStr;
    }
    
    /*
     * 파일 사이즈 Return
     */
    public static String fileVolumeCalc(String fileSizeStr){
		if(fileSizeStr == null || fileSizeStr.equals("") || fileSizeStr.equals("0")){
			return "0 KByte";
		}
		DecimalFormat t = new DecimalFormat("################.0");
		
		double Byte = Double.parseDouble(fileSizeStr);
		double KB = Byte / 1024.0;
		double MB = KB / 1024.0;
		double GB = MB / 1024.0;
		
		if (GB >= 1) {
			return t.format(GB) + " GB";
		} else if (MB >= 1) {
			return t.format(MB) + " MB";
		} else if (KB >= 1) {
			return t.format(KB) + " KB";
		}else {
			return t.format(Byte) + " Byte";
		}

	}
    
    
	
	/**
	 * <br>
	 * @Sorting Algorithm : bubble Sort 삽입정렬 
	 * @arr : 정렬하고자하는 ArrayList <br>
	 */
    public static  List<Group> getGroupIdASC(List<Group> arr){
		int  i,j;
		long keyGroupId = 0;
		Group key = null;
		Group minGroup = null;
		List<Group> resultList = new ArrayList();
		
		List groupList = new ArrayList();
		for ( i = 0; i < arr.size() ; i++ ){	
			groupList.add((Long)arr.get(i).getGroupId());
		}
		long tmp = 0;
		//bubble
		for ( i=0; i < groupList.size()-1 ; i++){
			for ( j=0; j < groupList.size()-1-i; j++){
				if((Long)groupList.get(j) > (Long)groupList.get(j+1)){
					tmp = (Long) groupList.get(j);
					groupList.set(j, (Long) groupList.get(j+1));
					groupList.set(j+1, tmp);
				}
			}
		}
		for(int k=0;k<groupList.size();k++){			
			for (int t = 0; t < arr.size() ; t++ ){	
				if(((Long)groupList.get(k)).equals((Long)arr.get(t).getGroupId())){
					resultList.add((Group)arr.get(t));
					break;
				}
			}
		}
		return resultList;
	}
    
    
    /**
	 * 필요없는 URL 파라미터 값 제거 
	 */
    public static String removeParameterUrl(String url){
    	String removePplifecycleUrl = HttpUtil.removeParameter(url, "p_p_lifecycle");
		String removePpStateUrl = HttpUtil.removeParameter(removePplifecycleUrl, "p_p_state");
		String removePpModeUrl = HttpUtil.removeParameter(removePpStateUrl, "p_p_mode");
		String removePpColIdUrl = HttpUtil.removeParameter(removePpModeUrl, "p_p_col_id");
		String resultUrl = HttpUtil.removeParameter(removePpColIdUrl, "p_p_col_count");
    	return resultUrl;
    }
    
}
