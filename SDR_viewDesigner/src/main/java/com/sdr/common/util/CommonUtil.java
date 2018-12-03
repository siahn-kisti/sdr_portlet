package com.sdr.common.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CommonUtil {

	private static Log log = LogFactoryUtil.getLog(CommonUtil.class);
	
	public CommonUtil() {
		super();
	}

	/**
	 * @Methods Name : getDatasetSearchContext
	 * @작성일 : 2017. 7. 20.
	 * @작성자 : devsky
	 * @변경이력 :
	 * @Method 설명 : Dataset SearchContext 가져오기
	 */
	public static SearchContext getDatasetSearchContext(long companyId, long scopeGroupId, Class<?> entryClass) {
		SearchContext searchContext = new SearchContext();
		searchContext.setCompanyId(companyId);

		long[] groupIds = { scopeGroupId };
		searchContext.setGroupIds(groupIds);

		String[] entryClassNames = { entryClass.getName() };
		searchContext.setEntryClassNames(entryClassNames);

		return searchContext;
	}
	
	
	/**
	 * JSONObject -> Map
	 * @param object
	 * @return
	 * @throws JSONException
	 */
	public static Map<String, Object> toMap(org.json.JSONObject object) throws JSONException {
	    Map<String, Object> map = new HashMap<String, Object>();

	    Iterator<String> keysItr = object.keys();
	    while(keysItr.hasNext()) {
	        String key = keysItr.next();
	        Object value = object.get(key);

	        if(value instanceof JSONArray) {
	            value = toList((JSONArray) value);
	        }

	        else if(value instanceof org.json.JSONObject) {
	            value = toMap((org.json.JSONObject) value);
	        }
	        map.put(key, value);
	    }
	    return map;
	}
	
	/**
	 * JSONObject -> List
	 * @param array
	 * @return
	 * @throws JSONException
	 */
	public static List<Object> toList(JSONArray array) throws JSONException {
	    List<Object> list = new ArrayList<Object>();
	    for(int i = 0; i < array.length(); i++) {
	        Object value = array.get(i);
	        if(value instanceof JSONArray) {
	            value = toList((JSONArray) value);
	        }

	        else if(value instanceof org.json.JSONObject) {
	            value = toMap((org.json.JSONObject) value);
	        }
	        list.add(value);
	    }
	    return list;
	}


	public static Map numberRoundAndMakeJson(JSONObject jsonObject){
		Map map = new HashMap<>();
		DecimalFormat df = new DecimalFormat("#.######");

		Iterator<String> keys = jsonObject.keySet().iterator();
		while( keys.hasNext() ) {

			String key = keys.next();

			Object value = jsonObject.get(key);

			if(value instanceof JSONArray) {
				List<Object> arr = CommonUtil.toList((JSONArray) value);

				List list = new ArrayList();
				for(Object each : arr){
					if(each instanceof Number) {
						if ( each instanceof Long )
						{
							list.add(df.format((Long)each));
						}
						else if ( each instanceof Double )
						{
							list.add(df.format((Double)each));
						}
						else if ( each instanceof Integer )
						{
							list.add(df.format((Integer)each));
						}
					}else {
						list.add(each);
					}
				}
				map.put(key, list);
			}

			else if(value instanceof JSONObject) {
				Map<String, Object> stringObjectMap = CommonUtil.toMap((org.json.JSONObject) value);
			}
			else if(value instanceof Number) {
				if ( value instanceof Long )				{
					map.put(key, df.format((Long)value));
				}
				else if ( value instanceof Double ){
					map.put(key, df.format((Double)value));
				}else{
					map.put(key, df.format((Integer)value));
				}
			}else {
				map.put(key, value);
			}
		}

		return map;
	}


}
