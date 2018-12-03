package com.sdr.curation.batch;


// import com.google.gson.stream.JsonReader;
import com.sdr.common.util.CustomUtil;
import com.sdr.curation.ErrorConst;
import com.sdr.file.FileConst;
import com.sdr.file.PropConst;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import sun.misc.BASE64Encoder;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class EDISONUtil {

    public static String EDISON_URL = null;

    // location is the main repository directory
    public static void getEdisonFiles(String token, String tempPath, String destPath, String jobId,
                                      Integer[] errCode) {
        // for result.zip, input.json
        if ( EDISON_URL == null ) EDISON_URL = PropConst.getProp("icebreakerUrl");
        if ( EDISON_URL == null ) { errCode[0] = ErrorConst._ERROR_BAD_HTTP_REQEUST; return; }

        File tmpFolder = new File(tempPath);
        if (!tmpFolder.exists()) tmpFolder.mkdirs();

        // place where downloaded files are located
        File destFolder = new File(destPath);
        if (!destFolder.exists()) destFolder.mkdirs();

        if ( getEdisonOutputAndUnzip(token, jobId, tempPath, destPath, errCode) )
            getEdisonInput(token, jobId, tempPath, destPath, errCode);

        FileConst.deleteDirectory(new File(tempPath));
    }


    public static boolean getEdisonInputMetadata(String token, String dataLocation, String metaFile, Integer[] errCode) {
        String result = null;

        // Open InputStream
        HttpURLConnection conn = connectForDownload(token, dataLocation, _INPUT_METADATA_DOWNLOAD, errCode);
        if (conn == null) return false;

        try {
            InputStream returnIs = conn.getInputStream();

            // Open OutputStream
            //String fileName = java.net.URLEncoder.encode(inputFile, "UTF-8");
            File targetFile = new File(metaFile);
            OutputStream out = new FileOutputStream(targetFile);

            // Write to OutputStream
            moveIsToOs(returnIs, out);

            // finalize
            returnIs.close();
            out.close();
            conn.disconnect();
        } catch (IOException e) {
            errCode[0] = ErrorConst._ERROR_SIM_META;
            return false;
        }

        // _log.debug("metadata File has been downloaded successfully for jobID " + dataLocation);
        // _log.debug("location " + metaFile);
        return true;
    }


    private static void moveIsToOs(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[8 * 1024];
        int bytesRead;
        while ((bytesRead = in.read(buffer)) > 0) {
            out.write(buffer, 0, bytesRead);
        }
        out.flush();
    }



    private final static int _OUTPUT_DOWNLOAD = 1;
    private final static int _INPUT_METADATA_DOWNLOAD = 2;
    private final static int _INPUT_FILE_DOWNLOAD = 3;


    private static HttpURLConnection connectForDownload(String token, String job_uuid, int type, Integer[] errCode)  {
        HttpURLConnection conn = null;
        URL url = null;

        if( (token == null) || (token.length() == 0)) {
            errCode[0] = ErrorConst._ERROR_TOKEN;
            return null;
        }

        if( (job_uuid == null) || (job_uuid.length() == 0)) {
            errCode[0] = ErrorConst._ERROR_INVALID_DATA_LOCATION;
            return null;
        }


        try {
            switch (type) {
                case _INPUT_METADATA_DOWNLOAD:
                    url = new URL(EDISON_URL + "/api/job/" + job_uuid + "/input");
                    break;
                case _INPUT_FILE_DOWNLOAD:
                    url = new URL(EDISON_URL + "/api/file/download?id=" + job_uuid);
                    break;
                case _OUTPUT_DOWNLOAD:
                    url = new URL(EDISON_URL + "/api/job/" + job_uuid + "/download/zip");
                    break;
                default:
                    return null;
            }
            //_log.debug("url : " + url);

            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Authorization", "Basic " + token);

            if (type == _INPUT_METADATA_DOWNLOAD) {
                conn.setRequestProperty("Accept", "application/json");
                conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
            }

            if ( ( conn.getResponseCode() / 100 ) == 2 ) {
                return conn;
            } else {
                handleResponseCode(conn.getResponseCode(), errCode);
            }

        } catch (Exception e) {
            errCode[0] = ErrorConst._ERROR_CONNECTION;
            return null;
        }

        return null;
    }


    public static boolean getEdisonInputFiles(String token, String inputPath, String metaFile, Integer[] errCode) {

        String metadataFullPath = metaFile ;
        File f = new File(metadataFullPath);
        if ( ! f.exists() ) {
            errCode[0] = ErrorConst._ERROR_SIM_META;
            return false;
        }

        if ( f.length() > 100000 ) {
            errCode[0] = ErrorConst._ERROR_SIM_META;
            return false;
        }

        String metadata = null;
        BufferedReader br = null;
        try {
            char[] c = new char[(int)f.length()];
            br = new BufferedReader(new FileReader(f));
            br.read(c);
            metadata = new String(c);
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
            errCode[0] = ErrorConst._ERROR_SIM_META;
            return false;
        }

        JSONObject jsonObject = null;
        JSONArray arrObj = null;
        try {
            jsonObject = new JSONObject(metadata);
            arrObj = jsonObject.getJSONArray("files");
        } catch (JSONException e) {
            e.printStackTrace();
            errCode[0] = ErrorConst._ERROR_SIM_META;
            return false;
        }

        String result = null;

        for (int i = 0; i < arrObj.length(); ++i) {
        	JSONObject inputJson = null;
        	try {
        		inputJson = arrObj.getJSONObject(i);
        	} catch (JSONException e) {
        		break;
        	}
            if (inputJson == null) break;
            String fileName = inputJson.getString("name");
            String filePath = inputJson.getString("parentPath");
            String subPath = filePath.substring(filePath.indexOf("repository")+10).trim().replace("/", File.separator );
            String fileId = inputJson.getString("id");
            //_log.debug("inputJson name : " + fileName);
            //_log.debug("inputJson path : " + filePath );
            //_log.debug("inputJson subpath : " + subPath );
            //_log.debug("inputJson id   : " + fileId);

            String placeHolder = null;
            if ( subPath.length() > 0 ) {
                placeHolder = inputPath + File.separator + subPath;
                File tmpFolder = new File(placeHolder);
                if (!tmpFolder.exists()) tmpFolder.mkdirs();
            } else {
                placeHolder = inputPath;
            }

            // Open InputStream
            HttpURLConnection conn = connectForDownload(token, fileId, _INPUT_FILE_DOWNLOAD, errCode);
            if (conn == null) return false;

            try {
                InputStream returnIs = conn.getInputStream();

                // Open OutputStream
                String tempName = java.net.URLEncoder.encode(fileName, "UTF-8");
                File targetFile = new File(placeHolder + File.separator + tempName);
                OutputStream out = new FileOutputStream(targetFile);

                // Write to OutputStream
                moveIsToOs(returnIs, out);

                // finalize
                returnIs.close();
                out.close();
                conn.disconnect();
            } catch (IOException e) {
                // _log.error(e.getMessage());
                errCode[0] = ErrorConst._ERROR_SIM_INPUT;
                return false;
            }

            //_log.debug("input File has been downloaded successfully ::: " + fileName);
            //_log.debug("location :: " + placeHolder);
        }

        //_log.debug("All input Files has been downloaded at " + inputPath);
        return true;
    }

    public static boolean getEdisonInput(String token, String dataLocation, String tempPath, String filePath, Integer[] errCode) {

        String inputPath = filePath + File.separator + "input";
        File tmpFolder = new File(inputPath);
        if (!tmpFolder.exists()) tmpFolder.mkdirs();
        // _log.debug("### filePath ::: " + inputPath);

        String metaFile = tempPath  + File.separator +  "input.json";
        if ( getEdisonInputMetadata(token, dataLocation, metaFile, errCode) != true ) return false;
        if ( getEdisonInputFiles(token, inputPath, metaFile, errCode) != true ) return false;

        return true;
    }


    public static boolean getEdisonOutputAndUnzip(String token, String dataLocation, String tempPath, String filePath, Integer[] errCode) {

        File tempFile = getEdisonOutput(token, dataLocation, tempPath, errCode);
        if (tempFile == null) return false;

        try {
            FileConst.unzip(tempFile, filePath);
        } catch (Exception e) {
            // _log.error(e.getMessage());
            errCode[0] = ErrorConst._ERROR_SIM_OUTPUT;
            return false;
        }

        //_log.debug("output File has been downloaded successfully for jobID " + dataLocation);
        //_log.debug("location " + filePath);
        return true;
    }


    public static File getEdisonOutput(String vcToken, String job_uuid, String path, Integer[] errCode) {
        HttpURLConnection conn = connectForDownload(vcToken, job_uuid, _OUTPUT_DOWNLOAD, errCode);
        if (conn == null) return null;

        File targetFile = null;
        try {
            InputStream returnIs = conn.getInputStream();

            // Open OutputStream
            String fileName = java.net.URLEncoder.encode("result.zip", "UTF-8");
            targetFile = new File(path + File.separator + fileName);
            OutputStream out = new FileOutputStream(targetFile);

            // Write to OutputStream
            moveIsToOs(returnIs, out);

            // finalize
            returnIs.close();
            out.close();
            conn.disconnect();
        } catch (Exception e) {
            // _log.debug(e.getMessage());
            errCode[0] = ErrorConst._ERROR_SIM_OUTPUT;
            return null;
        }

        return targetFile;
    }


    public static String createIBSimulation(String token, long scienceAppId, String title, String description, Integer[] errCode) {
        if ( EDISON_URL == null ) EDISON_URL = PropConst.getProp("icebreakerUrl");
        if ( EDISON_URL == null ) { errCode[0] = ErrorConst._ERROR_BAD_HTTP_REQEUST; return null; }
        String result = null;

        URL url = null;
        HttpURLConnection conn = null;
        try {
            url = new URL(EDISON_URL+"/api/simulation/create");
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");


            // create header
            conn.setDoOutput(true);
            conn.setRequestProperty("Accept", "application/json");
            conn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
            conn.setRequestProperty("Authorization", "Basic "+ token);

            // create body
            StringBuffer bodyStr = new StringBuffer();
            bodyStr.append("{");
            bodyStr.append("	\"solverId\" : \""+scienceAppId+"\", ");
            bodyStr.append("	\"title\" : \""+title+"\", ");
            bodyStr.append("	\"description\" : \""+description+"\"");
            bodyStr.append("}");


            OutputStream os = conn.getOutputStream();
            os.write(bodyStr.toString().getBytes());
            os.flush();

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

            String  output = "";
            StringBuffer responseBuffer = new StringBuffer();

            if ( ( conn.getResponseCode() / 100 ) == 2 ) {
                while ((output = br.readLine()) != null) {
                    if(!CustomUtil.strNull(output).equals("null")){
                        responseBuffer.append(CustomUtil.strNull(output));
                        JSONObject json = new JSONObject(responseBuffer.toString());
                        result = CustomUtil.strNull(json.getString("uuid"));
                    }
                }
            } else {
                handleResponseCode(conn.getResponseCode(), errCode);
            }

        } catch (IOException e) {
            e.printStackTrace();
            errCode[0] = ErrorConst._ERROR_CONNECTION;
            return null;
        }

        conn.disconnect();

        return result;
    }


    public static String getCurationURL(String simulation, int step, String location, Integer[] errCode) {
        if ( EDISON_URL == null ) EDISON_URL = PropConst.getProp("icebreakerUrl");
        if ( EDISON_URL == null ) { errCode[0] = ErrorConst._ERROR_BAD_HTTP_REQEUST; return null; }


        String urlString = EDISON_URL + "/api/simulation/" + simulation.trim() + "/job/submit";
        String syncCallBackURL = PropConst.getAccessPoint();
        if (syncCallBackURL == null) {
            errCode[0] = ErrorConst._ERROR_INVALIDE_CALLBACK;
            return null;
        }

        BASE64Encoder encoder = new BASE64Encoder();
        String encodedString = encoder.encode(location.getBytes());
        encodedString = encodedString.replaceAll("(\r\n|\r|\n|\n\r| )", "");
        syncCallBackURL += "?step=" + step + "%26location=" + encodedString;
        urlString += "?url=" + syncCallBackURL;

        return urlString;
    }


    public static String createIBCurationJob(String token, String urlString, int step, String location, Integer[] errCode) {
        if ( EDISON_URL == null ) EDISON_URL = PropConst.getProp("icebreakerUrl");
        if ( EDISON_URL == null ) { errCode[0] = ErrorConst._ERROR_BAD_HTTP_REQEUST; return null; }
        String result = null;
        HttpURLConnection conn = null;

        try {
            URL url = new URL(urlString);
            conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(300000);
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Accept", "application/xml");
            conn.setRequestProperty("Content-Type", "application/xml");
            conn.setRequestProperty("Authorization", "Basic " + token);


            StringBuffer bodyStr = new StringBuffer();
            String parameter = " -jar " + CustomUtil.strNull(PropConst.getProp("dataset.remote.location")) + "/" +
                    CustomUtil.strNull(PropConst.getProp("singularity.Image.path")) + "/BatchCurate.jar";
            if ( step == BatchCurate.STEP_IN_CURATION ) {
                parameter += " CURATE " + location;
            } else {
                parameter += " RETRIEVE " + location;
            }
            String title = location;


            bodyStr.append("<job>");
            bodyStr.append("	<type>SEQUENTIAL</type>");
            bodyStr.append("	<solverName>BatchCurate</solverName>");
            bodyStr.append("	<executable>/EDISON/SOLVERS/Curate_test/1.0.0/bin/Curate_test</executable>");
            bodyStr.append("	<execution>" + parameter + "</execution>");
            bodyStr.append("	<cyberLabId>curation01</cyberLabId>");
            bodyStr.append("	<classId>curation01</classId>");
            bodyStr.append("	<cluster>EDISON-NANO</cluster>");
            bodyStr.append("	<title>" + title + "</title>");
            bodyStr.append("	<solverId>12345</solverId>");
            bodyStr.append("	<dependencies></dependencies>");
            bodyStr.append("</job>");

            System.out.println("##### SUBMIT #################################");
            System.out.println(bodyStr.toString());
            System.out.println("##### SUBMIT #################################");

            OutputStream os = conn.getOutputStream();
            os.write(bodyStr.toString().getBytes());
            os.flush();

            String output = "";
            if ((conn.getResponseCode() / 100) == 2) {
                BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
                while ((output = br.readLine()) != null) {
                    if (!CustomUtil.strNull(output).equals("null")) {
                        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                        DocumentBuilder builder = factory.newDocumentBuilder();
                        Document document = builder.parse(new InputSource(new StringReader(CustomUtil.strNull(output))));
                        result = document.getElementsByTagName("uuid").item(0).getChildNodes().item(0).getNodeValue();
                    }
                }
            } else {
                handleResponseCode(conn.getResponseCode(), errCode);
            }
        } catch ( Exception e ) {
            errCode[0] = ErrorConst._ERROR_CONNECTION;
        }

        conn.disconnect();
        return result;
    }



    public static String getVcToken(String icebreakUserId, String icebreakerUserPwd) throws IOException, ParseException {
        URL url = new URL(EDISON_URL+"/api/user/login");
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

            responseValue = responseValue.replace("\"", "");
            String[] arr = responseValue.split("\\\\n");

            for(int i=0;i<arr.length;i++){
                if(i == 0){
                    tokenStr = arr[i].toString();
                    tokenStr = tokenStr.replace("Token: ", "");
                    break;
                }else if(i == 1){
                    expiredStr = arr[i].toString();
                    expiredStr = expiredStr.replace("Expired: ", "");

                    DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd", Locale.KOREA);
                    date = dateFormat.parse(expiredStr);
                    expiredStr = sdf.format(date);
                }
            }
        }else{
            System.out.println("Failed AdminTokenProvider [ getTokenApi ] : HTTP error code : " + conn.getResponseCode());
        }

        conn.disconnect();
        return tokenStr;
    }


    private static void handleResponseCode(int code, Integer[] errCode) {
        if ( code == 400) {
            errCode[0] = ErrorConst._ERROR_BAD_HTTP_REQEUST;
        } else if (code == 401) {
            errCode[0] = ErrorConst._ERROR_AUTH;
        } else if (code == 404) {
            errCode[0] = ErrorConst._ERROR_INVALIDE_JOB;
        } else {
            errCode[0] = ErrorConst._ERROR_UNKNOWN_HTTP;
        }
    }
}
