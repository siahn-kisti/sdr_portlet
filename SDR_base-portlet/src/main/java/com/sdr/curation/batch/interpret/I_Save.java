package com.sdr.curation.batch.interpret;

import com.sdr.curation.ErrorConst;
import com.sdr.curation.batch.RunInterpreter;
import com.sdr.curation.batch.ScriptCurate;
import com.sdr.file.FileConst;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class I_Save extends I_Interface {
    public int flag = 0;
    public static final int FLAG_NORMAL = 0;
    public static final int FLAG_ARRAY = 1;
    public static final int FLAG_2D_ARRAY = 2;
    public static final int FLAG_2D_ARRY_WITH_LABEL = 3;


    public int getFlag() {return flag;}
    public void setFlag(int flag) {this.flag = flag; }

    public void execute (String _file_location, String _meta_location, String args, Integer[] errCode) {

        // check variable name
        if ( RunInterpreter.checkArgs(args, errCode) == false ) return;

        // check value
        ArrayList<String> inData = RunInterpreter.readIN(_meta_location, errCode);
        if (errCode[0] != ErrorConst._OK) return;

        if(RunInterpreter._debug) System.out.println("var in Save : " + args);
        if(RunInterpreter._debug) System.out.println("value in Save : " + inData);


        JSONObject jo = new JSONObject();

        if ( flag == FLAG_NORMAL) {
            String value = inData.get(0).trim();
            putInJsonObject(args, value, jo);
        } else if ( flag == FLAG_ARRAY) {
            JSONArray ja = new JSONArray();
            for (int i=0; i<inData.size(); i++){
                String value = inData.get(i).trim();
                if (value.length() == 0) continue;
                putInJsonArray(value, ja);
            }
            jo.put(args, ja);
        } else if ( flag == FLAG_2D_ARRAY ){
            JSONArray ja = new JSONArray();
            for (int i=0; i<inData.size(); i++){
                String line = inData.get(i).trim();
                if (line.length() == 0) continue;

                String split[] = line.split("\\s+");
                JSONArray innerJa = new JSONArray();
                for( String word : split)  putInJsonArray(word, innerJa);
                ja.put(innerJa);
            }
            jo.put(args, ja);
        } else if ( flag == FLAG_2D_ARRY_WITH_LABEL ){
            JSONArray ja = new JSONArray();
            for (int i=0; i<inData.size(); i++){
                String line = inData.get(i).trim();
                if (line.length() == 0) continue;

                String split[] = line.split("\\s+");
                JSONObject innerJo = new JSONObject();
                innerJo.put("label", split[0]);

                JSONArray innerJa = new JSONArray();
                for(int j=1; j<split.length; j++)  putInJsonArray(split[j], innerJa);
                innerJo.put("value", innerJa);

                ja.put(innerJo);
            }
            jo.put(args, ja);
        }

        try {
            mergeMetadata(_meta_location, jo, errCode);

            String metadataPath = FileConst.getSubPath(_meta_location, FileConst.LOC_METADATA) + File.separator + FileConst._META_FILE_MD;
            FileWriter fw = new FileWriter(metadataPath);
            fw.write(jo.toString());
            fw.close();
        } catch ( IOException e) {
            errCode[0] = ErrorConst._ERROR_IO_EXCEPTION;
        }
    }

    private void putInJsonObject(String var, String value, JSONObject jo) {
        try {
            int intVal = Integer.parseInt(value);
            jo.put(var, intVal);
        } catch ( NumberFormatException e1 ) {
            try {
                double doubleVal = Double.parseDouble(value);
                jo.put(var, doubleVal);
            } catch ( NumberFormatException e2 ) {
                value = RunInterpreter.removeQuote(value);
                jo.put(var, value);
            }
        }
    }

    private void putInJsonArray(String value, JSONArray ja) {
        try {
            int intVal = Integer.parseInt(value);
            ja.put(intVal);
        } catch ( NumberFormatException e1 ) {
            try {
                double doubleVal = Double.parseDouble(value);
                ja.put(doubleVal);
            } catch (NumberFormatException e2) {
                value = RunInterpreter.removeQuote(value);
                ja.put(value);
            }
        }
    }

    private static void mergeMetadata(String _meta_location, JSONObject newJson, Integer[] errCode) {
        try {
            String metadataPath = FileConst.getSubPath(_meta_location, FileConst.LOC_METADATA) + File.separator + FileConst._META_FILE_MD;
            String metadata = ScriptCurate.readStringFromFile(metadataPath);
            if ((metadata != null) && (metadata.length() != 0)) {
                JSONObject jsonObject = new JSONObject(metadata);
                for (String key : jsonObject.keySet()) {
                    newJson.put(key, jsonObject.get(key));
                }
            }
        } catch (IOException e) {
            // errCode[0] = ErrorConst._ERROR_IO_EXCEPTION;
        }
    }
}
