package com.sdr.file;

import com.sdr.curation.batch.BatchCurate;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class PropConst {
    private static Map<String, String> propMap = null;
    public static String accessPoint = null;


    public synchronized static void setAccessPoint(boolean isSecure, String serverName, boolean force) {
        if ( (accessPoint != null) && (force == false)) return;
        if (serverName == null) return;

        String callback = getProp("callbackUrl" );
        if (callback == null || callback.length() == 0) {
            accessPoint = (isSecure) ? "https://" : "http://";
            accessPoint += serverName + "/api/jsonws/SDR_base-portlet.curationjob/get-curation-call-back";
        } else {
            accessPoint = callback + "/api/jsonws/SDR_base-portlet.curationjob/get-curation-call-back";
        }
    }


    public static String getAccessPoint() {
        return accessPoint;
    }


    public static void initPropMap(Map<String, String> map) {
        // set default value;
        map.put("doi.header",               "10.5072/sdr.kisti");
        map.put("pythonCommand",            "python");
        map.put("docker.command",           "docker");
        map.put("singularity.command",     "singularity");
        map.put("singularity.Image.path",  "singularity-images");
        map.put("local.curate",             "docker");
        map.put("remote.curate",            "singularity");
        map.put("remote.curate.allowed",   "false");
        map.put("collection.create.role",  "User");

        if (FileConst.systemType() == FileConst.TYPE_WINDOWS) {
            map.put("dataset.location", "c:/Users/admin/root");
        } else {
            map.put("dataset.location", "/root");
        }
        map.put("dataset.remote.location", "");

        // set default for IB job
        map.put("icebreakerUrl",            "http://150.183.247.103:8080/ldap");
        map.put("callbackUrl",              "");
        map.put("cluster",                  "EDISON-NANO");
        /*
        map.put("icebreakerAdminId", "edisonadm");
        map.put("icebreakerAdminPwd", "");
        */
    }

    /*
    private static Map<String, String> getPropMap(Map<String,String> bInfo) {
        Map<String, String> map = new HashMap<>();
        PropConst.initPropMap(map);
        if ( bInfo != null ) {
            Iterator<String> keys = map.keySet().iterator();
            for (String _key : map.keySet())
                if (bInfo.containsKey(_key))
                    map.put(_key, bInfo.get(_key));
        }
        return map;
    }
    */


    public synchronized static void initProp() {
        if (propMap != null) return;

        propMap = new HashMap<>();
        initPropMap(propMap);
        try {
            if ( BatchCurate.isRemote() == false ) PropService.initPropMapFromPortletProperties(propMap);
        } catch ( Exception e ) {
            // DO Nothing
        }
    }


    public static Map<String, String> getPropMap() {
        if ( propMap == null ) initProp();
        return propMap;
    }

    public static String getProp(String str){
        if ( propMap == null ) initProp();
        if ( propMap.containsKey(str) ) {
            return propMap.get(str).trim();
        }
        return null;
    }


    public synchronized static void setPropFromBInfo(Map<String,String> bInfo) {
        if ( propMap == null ) initProp();

        if ( bInfo != null ) {
            for (String _key : propMap.keySet())
                if ( bInfo.containsKey(_key))
                    propMap.put(_key, bInfo.get(_key));
        }
    }
}
