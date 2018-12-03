package com.sdr.file;

import com.liferay.util.portlet.PortletProps;

import java.util.Iterator;
import java.util.Map;

public class PropService extends PropConst {
    // private static Map<String, String> propSeriviceMap = null;

    public synchronized static void initPropMapFromPortletProperties(Map<String, String> map) {
        Iterator<String> keys = map.keySet().iterator();
        for ( String _key : map.keySet() ) {
            String _value = PortletProps.get(_key);
            if ((_value == null) || (_value.length() == 0)) continue;
            map.put(_key, _value);
        }
    }

    /*
    public synchronized  static Map<String, String> getPropServiceMap() {
        Map<String, String> map = new HashMap<>();
        PropConst.initPropMap(map);

        // read from portlet.properties
        Iterator<String> keys = map.keySet().iterator();
        for ( String _key : map.keySet() ) {
            String _value = PortletProps.get(_key);
            if ((_value == null) || (_value.length() == 0)) continue;
            map.put(_key, _value);
        }
        return map;
    }
        */

    public static String getProp(String str){
        return PropConst.getProp(str);
    }
}
