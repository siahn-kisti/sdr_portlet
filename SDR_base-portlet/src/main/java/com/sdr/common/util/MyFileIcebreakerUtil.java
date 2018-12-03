package com.sdr.common.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.springframework.util.FileCopyUtils;

//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.SystemProperties;
import com.liferay.util.json.JSONFactoryUtil;

//import net.sf.json.JSONArray;
//import net.sf.json.JSONObject;
//import net.sf.json.JSONSerializer;

public class MyFileIcebreakerUtil {
	
	private static final String IB_FILE_CLUSTER = "EDISON-CFD";
	private static final String FILE_MOVE_PATH = "/EDISON/LDAP/DATA/";
	
	public static List<HashMap<String,String>> apiHomeFolderList(String icebreakerUrl, String icebreakerToken) throws MalformedURLException, SystemException{
		URL url = new URL(icebreakerUrl+"/api/folder/list");
		return apiFolderList(url,icebreakerUrl, icebreakerToken);
	}
	
	public static List<HashMap<String,String>> apiFolderList(String icebreakerUrl, String icebreakerToken,String selectFolderId) throws SystemException, MalformedURLException{
		URL url = new URL(icebreakerUrl+"/api/folder/"+selectFolderId+"/list");
		return apiFolderList(url, icebreakerUrl, icebreakerToken);
	}
	
	protected static List<HashMap<String,String>> apiFolderList(URL url,String icebreakerUrl, String icebreakerToken) throws SystemException{
		
		String responseValue = "";
		HttpURLConnection conn = null;
		List<HashMap<String,String>> resultList = new ArrayList<HashMap<String,String>>();
		try{
			conn = (HttpURLConnection) url.openConnection();

			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Authorization", "Basic " + icebreakerToken);
			
			String  output = "";		
			if (conn.getResponseCode() == 200) {

				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
				while ((output = br.readLine()) != null) {
					if(!CustomUtil.strNull(output).equals("null")){
						responseValue += output;
					}
				}
				
				br.close();
				
				//JSONObject jsonObj = JSONObject.fromObject(JSONSerializer.toJSON(responseValue));
				JSONObject jsonObj = JSONFactoryUtil.createJSONObject(responseValue);
				int count = GetterUtil.getInteger(jsonObj.getInt("count"), 0);
				
				if(count!=0){
					JSONArray jsonArray = jsonObj.getJSONArray("files");
					for (int i = 0; i < jsonArray.length(); i++) {
						HashMap<String,String> folderMap = new HashMap<String,String>();
						
						JSONObject comandObj = jsonArray.getJSONObject(i);
						folderMap.put("fileName",comandObj.getString("name"));
						folderMap.put("path",comandObj.getString("path"));
						folderMap.put("fileId", comandObj.getString("id"));
						resultList.add(folderMap);
					}
				}
				
			}else{
//				System.out.println("Failed FileUtil [ apiHomeFolderList ] : ETC : etc error - HTTP error code : " + conn.getResponseCode());
				throw new SystemException("Failed FileUtil [ apiHomeFolderList ] : ETC : etc error - HTTP error code : " + conn.getResponseCode());
			}
			return resultList;
		}catch (Exception e) {
			throw new SystemException(e); 
		}finally {
			if(conn!=null){conn.disconnect();}
		}
	}
	
	public static List<HashMap<String,String>> apiHomeFileList(String icebreakerUrl, String icebreakerToken) throws MalformedURLException, SystemException{
		URL url = new URL(icebreakerUrl+"/api/file/list");
		return apiFileList(url,icebreakerUrl, icebreakerToken,null,null);
	}
	
	public static List<HashMap<String,String>> apiHomeFileList(String icebreakerUrl, String icebreakerToken,String fileExt) throws MalformedURLException, SystemException{
		URL url = new URL(icebreakerUrl+"/api/file/list");
		return apiFileList(url,icebreakerUrl, icebreakerToken,fileExt.split(","),null);
	}
	
	public static List<HashMap<String,String>> apiHomeFileList(String icebreakerUrl, String icebreakerToken, String selectFolderId,String fileExt, String fileIdFilter) throws SystemException, MalformedURLException{
	    URL url = new URL(icebreakerUrl+"/api/file/list");
	    return apiFileList(url, icebreakerUrl, icebreakerToken,fileExt.split(","),fileIdFilter.split(","));
	}
	
	public static List<HashMap<String,String>> apiFileList(String icebreakerUrl, String icebreakerToken,String selectFolderId) throws SystemException, MalformedURLException{
		URL url = new URL(icebreakerUrl+"/api/file/"+selectFolderId+"/list");
		return apiFileList(url, icebreakerUrl, icebreakerToken,null,null);
	}
	

	/**
	 * 
	 * @param icebreakerUrl
	 * @param icebreakerToken
	 * @param selectFolderId
	 * @param fileExt -> format example "aaaaa,aaaaa,aaaaa"
	 * @return
	 * @throws SystemException
	 * @throws MalformedURLException
	 */
	public static List<HashMap<String,String>> apiFileList(String icebreakerUrl, String icebreakerToken, String selectFolderId,String fileExt) throws SystemException, MalformedURLException{
		URL url = new URL(icebreakerUrl+"/api/file/"+selectFolderId+"/list");
		return apiFileList(url, icebreakerUrl, icebreakerToken,fileExt.split(","),null);
	}
	
	public static List<HashMap<String,String>> apiFileList(String icebreakerUrl, String icebreakerToken, String selectFolderId,String fileExt, String fileIdFilter) throws SystemException, MalformedURLException{
		URL url = new URL(icebreakerUrl+"/api/file/"+selectFolderId+"/list");
		return apiFileList(url, icebreakerUrl, icebreakerToken,fileExt.split(","),fileIdFilter.split(","));
	}
	
	protected static List<HashMap<String,String>> apiFileList(URL url,String icebreakerUrl, String icebreakerToken, String[] compareExt, String[] fileIdFilter) throws SystemException{
		
		String responseValue = "";
		HttpURLConnection conn = null;
		List<HashMap<String,String>> resultList = new ArrayList<HashMap<String,String>>();
		try{
			conn = (HttpURLConnection) url.openConnection();

			conn.setDoOutput(true);
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Authorization", "Basic " + icebreakerToken);
			
			String  output = "";
			if (conn.getResponseCode() == 200) {

				BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
				while ((output = br.readLine()) != null) {
					if(!CustomUtil.strNull(output).equals("null")){
						responseValue += output;
					}
				}
				
				br.close();
				
				//JSONObject jsonObj = JSONObject.fromObject(JSONSerializer.toJSON(responseValue));
				JSONObject jsonObj = JSONFactoryUtil.createJSONObject(responseValue);
				
				int count = GetterUtil.getInteger(jsonObj.getInt("count"), 0);
				
				if(count!=0){
					JSONArray jsonArray = jsonObj.getJSONArray("files");
					root1:for (int i = 0; i < jsonArray.length(); i++) {
						JSONObject comandObj = jsonArray.getJSONObject(i);
						
						if(compareExt!=null){
						    if(!compareExt[0].equals("")){
						        String fileName = comandObj.getString("name");
						        String fileExt = "";
						        
						        String[] splitFileName = fileName.split("\\.");
						        
						        if(2 < splitFileName.length){
						            // 확장자가 .xxx.xxx 인 경우
						            fileExt = fileName.substring(fileName.indexOf(splitFileName[splitFileName.length-2]), fileName.length()); 
						        } else {
						            fileExt = fileName.substring(fileName.lastIndexOf(".")+1); 
						        }
	                            if(!ArrayUtil.contains(compareExt, fileExt)){
	                                continue root1;
	                            }
						    }
						}
						
						if(fileIdFilter!=null){
						    if(!fileIdFilter[0].equals("")){
						        String fileId =  comandObj.getString("id");
	                            if(ArrayUtil.contains(fileIdFilter, fileId)){
	                                continue root1;
	                            }
						    }
						}
						
						HashMap<String,String> fileMap = new HashMap<String,String>();
						
						fileMap.put("fileName",comandObj.getString("name"));
						fileMap.put("path",comandObj.getString("path"));
						fileMap.put("fileId", comandObj.getString("id"));
						fileMap.put("parentPath",comandObj.getString("parentPath"));
						fileMap.put("lastModified", comandObj.getString("lastModified"));
						fileMap.put("fileSize", CustomUtil.fileVolumeCalc(String.valueOf(comandObj.getDouble("size"))));
						
						resultList.add(fileMap);
					}
				}
				
			}else{
				throw new SystemException("Failed FileUtil [ apiHomeFolderList ] : ETC : etc error - HTTP error code : " + conn.getResponseCode());
			}
			return resultList;
		}catch (Exception e) {
			throw new SystemException(e); 
		}finally {
			if(conn!=null){conn.disconnect();}
		}
	}
	
	public static File getFile(String icebreakerUrl, String vcToken, String fileId, String fileName) throws SystemException{
	    HttpURLConnection conn =  null;
	    InputStream inputStream = null;
	    try{
	        if(!CustomUtil.strNull(vcToken).equals("")){
	            URL url = new URL(icebreakerUrl+"/api/file/download?id="+CustomUtil.strNull(fileId));
	            
	            conn = (HttpURLConnection) url.openConnection();
	            conn.setDoOutput(true);
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept", "text/plain");
                conn.setRequestProperty("Content-Type", "application/xml");
             
                System.out.println(conn.getResponseCode());
	            if (conn.getResponseCode() == 200) {
	                inputStream = conn.getInputStream();
	                File file = new File(SystemProperties.get(SystemProperties.TMP_DIR) + "/" + fileName);
	                
	                if(!file.exists()){
	                    file.createNewFile();
	                  }else{
	                    file.delete();
	                    file.createNewFile();
	                  }
	                
	                FileOutputStream os = new FileOutputStream(file);
	                FileCopyUtils.copy(inputStream, os);
	                os.flush();
	                
	                return file;
	            }else{
	                if (conn.getResponseCode() == 400) {
	                    System.out.println("Failed IcebreakerService [ getResultRead ] : BAD REQUEST : wrong body content - HTTP error code : " + conn.getResponseCode());      
	                }else if (conn.getResponseCode() == 413) {
	                    System.out.println("Failed IcebreakerService [ getResultRead ] : REQUEST ENTITY TO LARGE : 10MBytes Limit - HTTP error code : " + conn.getResponseCode());      
	                }else{          
	                    System.out.println("Failed IcebreakerService [ getResultRead ] : ETC : etc error - HTTP error code : " + conn.getResponseCode());
	                }
	                return null;
	            } 
	        }else{
	            System.out.println("Failed IcebreakerService [ getResultRead ] : Token is NOT NULL - Request error code : 999");
	            return null;
	        }
	    }catch(Exception e){
	        throw new SystemException(e); 
	    }finally{
	        if(inputStream != null){
	            try{
	              inputStream.close();
	            }catch (IOException e){throw new SystemException(e);}
	          }
	        if(conn!=null){conn.disconnect();}
	    }
    }
	
    public static File createBcFile(String icebreakerUrl, String vcToken, String fileName, String fileContent) throws SystemException{
	    
	    try{
	        
	        File bcFile = new File(SystemProperties.get(SystemProperties.TMP_DIR) + "/" + fileName);
	        
	        FileWriter fw = new FileWriter(bcFile, true);
	        
	        fw.write(fileContent);
	        fw.flush();
	        fw.close();
	        
	        return bcFile;
        }catch (Exception e){
            throw new SystemException(e);
        }
	}
    
    /**
     * ZIP 파일 생성 후 IB File UPLOAD
     * @param icebreakerUrl
     * @param vcToken
     * @param zipFileName
     * @param fileList
     * @param isFileDelete - 압축 수행 후 기존 파일 삭제 여부(true:삭제/false:미삭제)
     * @throws SystemException 
     */
    public static String createZipFileWithIbUpload(String icebreakerUrl, String vcToken, String zipFileName, File[] fileList, boolean isFileDelete,String userScreenName) throws SystemException{
    	try{
            File zipFile = new File(SystemProperties.get(SystemProperties.TMP_DIR) + FileSystems.getDefault().getSeparator() + zipFileName);
            
            FileOutputStream fos = new FileOutputStream(zipFile);
            ZipOutputStream zos = new ZipOutputStream(fos);
            
            byte[] buffer = new byte[1024];
            for(File file : fileList){
                
                FileInputStream fis = new FileInputStream(file);
                zos.putNextEntry(new ZipEntry(file.getName()));
                
                int length;
                while((length = fis.read(buffer)) > 0){
                    zos.write(buffer, 0, length);
                }
                
                zos.closeEntry();
                fis.close();
                
                if(isFileDelete){
                	FileUtil.delete(file);
                }
            }
            zos.close();
            
            zipFile.setReadable(true);
            zipFile.setExecutable(true);
            zipFile.setWritable(true);
			
            return ibFileUpload(icebreakerUrl, vcToken, zipFile,"eTURB_Meshes",userScreenName);
        }catch (Exception e){
            throw new SystemException(e);
        }
    }
    
    
    private static String ibFileUpload(String icebreakerUrl, String vcToken, File file, String parentFilePath, String userScreenName) throws SystemException{
	    
    	HttpURLConnection conn = null;
    	String fileId = "";
	    try{
	        URL url = new URL(icebreakerUrl+"/api/file/upload?cluster="+IB_FILE_CLUSTER);
	        
            HttpFileUtil httpFileUtil = new HttpFileUtil(url);
            httpFileUtil.Token = vcToken;
            httpFileUtil.addFile("file", file);
            
            String resultJson = httpFileUtil.sendMultipartPost();
            
            if(!"".equals(CustomUtil.strNull(resultJson))){
            	//JSONObject json = JSONObject.fromObject(JSONSerializer.toJSON(resultJson));
            	JSONObject json = JSONFactoryUtil.createJSONObject(resultJson);
            	
                fileId = json.getString("id");
                String fileName = json.getString("name");
            	
            	int responseStatus = 0;
            	System.out.println("FILE__ID-->"+fileId);
            	System.out.println("FILENAME-->"+fileName);
            	System.out.println("ICEBREAKERURL-->"+icebreakerUrl);
            	System.out.println("PARENTFILEPATH-->"+parentFilePath);
            	
            	if(CustomUtil.strNull(parentFilePath).equals("")){
            		URL fileMoveUrl = new URL(icebreakerUrl+"/api/file/move/"+fileId+"/HOME");
                	conn = (HttpURLConnection) fileMoveUrl.openConnection();
                    
                    conn.setDoOutput(true);
                    conn.setRequestMethod("PUT");
                    conn.setRequestProperty("Accept", "application/json");
                    conn.setRequestProperty("Authorization", "Basic " + vcToken);
                    
                    responseStatus =  conn.getResponseCode();
                    
                    conn.disconnect();
                }else{
                	 //eTURB Meshes 폴더에 File 등록
                    Map<String, Object> requestParamMap = new HashMap<String, Object>();
                    requestParamMap.put("newFolderNm", parentFilePath);
                    createFolder(icebreakerUrl, vcToken, requestParamMap);
                    
                    requestParamMap.clear();
                    requestParamMap.put("sourceId", fileId);
                    requestParamMap.put("destPath", parentFilePath+file.separator + fileName);
                    fileId = moveFileReturnJsonObject(icebreakerUrl, vcToken, requestParamMap, userScreenName).getString("id");
                }
            }
            
            FileUtil.delete(file);
	    }catch (Exception e){
	        e.printStackTrace();
	        throw new SystemException(e);
	    }finally {
			if(conn!=null){conn.disconnect();}
			return fileId;
		}
        
	}
    
    public static File createZipFile(String icebreakerUrl, String vcToken, String zipFileName, List<File> fileList) throws SystemException{
        
        try{
            File zipFile = new File(SystemProperties.get(SystemProperties.TMP_DIR) + FileSystems.getDefault().getSeparator() + zipFileName);
            
            FileOutputStream fos = new FileOutputStream(zipFile);
            ZipOutputStream zos = new ZipOutputStream(fos);
            
            byte[] buffer = new byte[1024];
            for(File file : fileList){
                
                FileInputStream fis = new FileInputStream(file);
                zos.putNextEntry(new ZipEntry(file.getName()));
                
                int length;
                while((length = fis.read(buffer)) > 0){
                    zos.write(buffer, 0, length);
                }
                
                zos.closeEntry();
                fis.close();
                
                FileUtil.delete(file);
            }
            zos.close();
            
            return zipFile;
            
        }catch (Exception e){
            throw new SystemException(e);
        }
    }
	
	public static void ibFileUpload(String icebreakerUrl, String vcToken, List<File> fileList, UploadPortletRequest upload, String userScreenName, boolean bcUse) throws SystemException{
	    
	    String ICEBREAKER_TEMP_PATH = PropsUtil.get(PropsKeys.LIFERAY_HOME)+"/ICEBREAKER_TEMP";
	    
	    try{
	        URL url = new URL(icebreakerUrl+"/api/file/upload?cluster=EDISON-CFD");
	        
	        InputStream[] uploadInputStream = upload.getFilesAsStream("addFile",false);
	        int responseStatus = 0;
	        
	        for(int i=0; i<fileList.size(); i++){
	            
	            File tempFile = fileList.get(i);
	            
	            HttpFileUtil httpFileUtil = new HttpFileUtil(url);
	            httpFileUtil.Token = vcToken;
	            
	            /*temp 파일 생성 exception 처리 추가*/
	            FileOutputStream output = new FileOutputStream(ICEBREAKER_TEMP_PATH + File.separator + tempFile.getName());
	            FileInputStream inputStream = new FileInputStream(tempFile);
	            byte[] buffer = new byte[1024 * 8];
	            int readcount = 0;
	            while((readcount=inputStream.read(buffer)) != -1) {
	                output.write(buffer, 0, readcount);
	            }
	            output.flush();
	            inputStream.close();
	            output.close();
	            
	            if(tempFile.exists()){
	                FileUtil.delete(tempFile);
	            }
	            
	            File uploadfile = new File(ICEBREAKER_TEMP_PATH + File.separator + tempFile.getName());
	            
	            httpFileUtil.addFile("file", uploadfile);
	            
	            // IOException
	            String resultJson = httpFileUtil.sendMultipartPost();
	            System.out.println("IBFileUtil > resultJson : " + resultJson);
	            String bcUseFileLocation = "";
	            if(bcUse){
	                
	            	// This code is not used??
	            	//JsonParser parser = new JsonParser();
	                //Object obj = parser.parse(resultJson);
	            	
//	                moveFileReturnJsonObject(icebreakerUrl, vcToken, requestParamMap, userScreenName);
//	                return;
	            }
	            
	            if(!"".equals(CustomUtil.strNull(resultJson))){
	                
	                //JSONObject json = JSONObject.fromObject(JSONSerializer.toJSON(resultJson));
	            	JSONObject json = JSONFactoryUtil.createJSONObject(resultJson);
	                String fileId = json.getString("id");
	                String fileName = json.getString("name");
	                
	                	URL fileMoveUrl = new URL(icebreakerUrl+"/api/file/move/"+fileId+ "/HOME");
		                System.out.println("fileMoveUrl : " + fileMoveUrl.toString());
		                
		                HttpURLConnection conn = (HttpURLConnection) fileMoveUrl.openConnection();
		                
		                conn.setDoOutput(true);
		                conn.setRequestMethod("PUT");
		                conn.setRequestProperty("Accept", "application/json");
		                conn.setRequestProperty("Authorization", "Basic " + vcToken);
		                
		                responseStatus =  conn.getResponseCode();
	                    
	                    conn.disconnect();
                    /* Export 시 HOME 하위에 폴더 생성
	                */
                    
	                
	            }else{
	            }
	            
	            FileUtil.delete(uploadfile);
	            
	        }// for end
	    }catch (Exception e){
	        e.printStackTrace();
	        throw new SystemException(e);
	    }
        
	}
	
	/* Create Folder */
	public static int createFolder(String icebreakerUrl, String vcToken, Map<String, Object> requestParamMap) throws SystemException{
	    
	    int responseStatus = 0;
	    
	    try{
            
	        String parentFolderId = CustomUtil.strNull(requestParamMap.get("parentId[]"));
	        
            String parentpath = CustomUtil.strNull(requestParamMap.get("parentpath"));
            String newFolderName = CustomUtil.strNull(requestParamMap.get("newFolderNm"));
            
	        if(!"".equals(icebreakerUrl)){
                String urlStr = icebreakerUrl;
                if(parentFolderId.equals("HOME") || parentpath.equals("")){//최상위
                    urlStr += "/api/folder/create?name="+newFolderName+"&cluster=EDISON-CFD";
                }else if(!parentFolderId.equals("HOME") && !parentpath.equals("")){
                    urlStr += "/api/folder/create?name="+parentpath+"/"+newFolderName+"&cluster=EDISON-CFD";
                }
                System.out.println("urlStr : " + urlStr);
                URL url = new URL(urlStr);
                
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                
                conn.setDoOutput(true);
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Accept", "application/json");
                conn.setRequestProperty("Authorization", "Basic " + vcToken);
                
                StringBuffer bodyStr = new StringBuffer();
                bodyStr.append("<folder id='"+parentFolderId+"'>");
                bodyStr.append("<name>"+newFolderName+"</name>");
                bodyStr.append("<size>80</size>");
                bodyStr.append("<type>text/plain</type>");
                bodyStr.append("</folder>");
                
                OutputStream os = conn.getOutputStream();
                os.write(bodyStr.toString().getBytes());
                os.flush();
                
                responseStatus =  conn.getResponseCode();
                conn.disconnect();
            }
	        
	        return responseStatus;
        }catch (Exception e){
            e.printStackTrace();
            return responseStatus; 
        }
	}
	
	public static int renameFolder(String icebreakerUrl, String vcToken, Map<String, Object> requestParamMap) throws SystemException{
	    int responseStatus = 0;
	    
	    try{
	        String selectFolderId = CustomUtil.strNull(requestParamMap.get("selectFolderId"));
	        String newFolderName = CustomUtil.strNull(requestParamMap.get("newFolderNm"));
	        
	        if(!"".equals(icebreakerUrl)){
	            URL url = new URL(icebreakerUrl + "/api/folder/"+selectFolderId+"/"+newFolderName);
	            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	            
	            conn.setDoOutput(true);
	            conn.setRequestMethod("PUT");
	            conn.setRequestProperty("Accept", "application/json");
	            conn.setRequestProperty("Authorization", "Basic " + vcToken);
	            
	            responseStatus =  conn.getResponseCode();
	            conn.disconnect();
	        }
	        
	        return responseStatus;
        }catch (Exception e){
            e.printStackTrace();
            return responseStatus;
        }
	    
	}
	
	public static int deleteFolder(String icebreakerUrl, String vcToken, Map<String, Object> requestParamMap) throws SystemException{
        int responseStatus = 0;
        try{
            String selectFolderId = CustomUtil.strNull(requestParamMap.get("selectFolderId"));
            
            if(!"".equals(icebreakerUrl)){
                
                URL url = new URL(icebreakerUrl + "/api/folder/delete/"+selectFolderId);
                
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                
                conn.setDoOutput(true);
                conn.setRequestMethod("DELETE");
                conn.setRequestProperty("Accept", "application/json");
                conn.setRequestProperty("Authorization", "Basic " + vcToken);
                
                responseStatus =  conn.getResponseCode();
                conn.disconnect();
            }
            return responseStatus;
        }catch (Exception e){
            e.printStackTrace();
            return responseStatus;
        }
        
    }
	
	/* Move Folder or File */
	public static JSONObject moveFileReturnJsonObject(String icebreakerUrl, String vcToken, Map<String, Object> requestParamMap, String userScreenName){
		JSONObject element = null;
		HttpURLConnection conn = null;
		try{
			String sourceId = CustomUtil.strNull(requestParamMap.get("sourceId"));
			String destPath = CustomUtil.strNull(requestParamMap.get("destPath"));
			
			if(!"".equals(icebreakerUrl)){
				icebreakerUrl = icebreakerUrl + "/api/file/move";
				
				URL url = new URL(icebreakerUrl);
	            
	            conn = (HttpURLConnection) url.openConnection();
	            
	            conn.setDoOutput(true);
	            conn.setRequestProperty("Authorization", "Basic " + vcToken);
	            conn.setRequestProperty("Accept", "application/json");
	            conn.setRequestProperty("Content-Type", "application/json");
	            
	            
	            StringBuffer bodyStr = new StringBuffer();
                destPath = FILE_MOVE_PATH + userScreenName + "/repository/"+destPath;
                
                conn.setRequestMethod("POST");
                System.out.println("destPath--->"+destPath);
                bodyStr.append("{");
                bodyStr.append("   \"fileId\" : \"" + sourceId + "\", ");
                bodyStr.append("   \"destPath\" : \""+destPath+"\" ");
                bodyStr.append("}");
                
                System.out.println("bodyStr : " + bodyStr.toString());
                
                OutputStream os = conn.getOutputStream();
                os.write(bodyStr.toString().getBytes());
                os.flush();
                
                if (conn.getResponseCode() == 200) {
	            	BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
	            	String line;
	                StringBuilder sb = new StringBuilder();
	                while ((line = br.readLine()) != null) sb.append(line);
	                //element = new JsonParser().parse(sb.toString()).getAsJsonObject();
	                element = JSONFactoryUtil.createJSONObject(sb.toString());
	            }
			}
		}catch (Exception e) {
            e.printStackTrace();
        }finally {
        	if(conn!=null){conn.disconnect();}
			return element;
		}
	}
	
	public static int moveNode(String icebreakerUrl, String vcToken, Map<String, Object> requestParamMap, String userScreenName) throws SystemException{
	    
	    int responseStatus = 0;
	    
	    try{
	        
	        String sourceId = CustomUtil.strNull(requestParamMap.get("sourceId"));
	        String targetId = CustomUtil.strNull(requestParamMap.get("targetId"));
	        String nodeType = CustomUtil.strNull(requestParamMap.get("nodeType"));     // file or default
	        String destPath = CustomUtil.strNull(requestParamMap.get("destPath"));
	        
	        if(!"".equals(icebreakerUrl)){
	            
	            if(nodeType.equals("file")){
	                // file
	                icebreakerUrl = icebreakerUrl + "/api/file/move";
	            } else {
	                // folder
	                icebreakerUrl = icebreakerUrl + "/api/folder/move/"+sourceId;
	                
	                if(!targetId.equals("HOME") && (!"".equals(targetId))){
	                    icebreakerUrl += "/"+targetId;
	                }
	            }
	            
	            System.out.println("PRE_FILEID--->"+sourceId);
	            System.out.println("MOVE_NODE_URL--->"+icebreakerUrl);
	            URL url = new URL(icebreakerUrl);
	            
	            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	            
	            conn.setDoOutput(true);
	            conn.setRequestProperty("Authorization", "Basic " + vcToken);
	            conn.setRequestProperty("Accept", "application/json");
	            conn.setRequestProperty("Content-Type", "application/json");
	            
	            if(nodeType.equals("file")){
	                
	                StringBuffer bodyStr = new StringBuffer();
	                destPath = FILE_MOVE_PATH + userScreenName + "/repository/"+destPath;
	                
	                conn.setRequestMethod("POST");
	                System.out.println("destPath--->"+destPath);
	                bodyStr.append("{");
	                bodyStr.append("   \"fileId\" : \"" + sourceId + "\", ");
	                bodyStr.append("   \"destPath\" : \""+destPath+"\" ");
	                bodyStr.append("}");
	                
	                OutputStream os = conn.getOutputStream();
	                os.write(bodyStr.toString().getBytes());
	                os.flush();
	                
	            } else {
	                conn.setRequestMethod("PUT");
	            }
	            responseStatus =  conn.getResponseCode();
	            conn.disconnect();
	        }
	        
	        return responseStatus;
	        
	    } catch (Exception e) {
            e.printStackTrace();
            return responseStatus;
        }
	}
	
	/* Copy or Update File */
	public static int copyFile(String icebreakerUrl, String vcToken, Map<String, Object> requestParamMap, String userScreenName) throws SystemException{
	    
	    int responseStatus = 0;
	    
	    try{
	        
	        int selectNodeLength =  Integer.parseInt(CustomUtil.strNull(requestParamMap.get("copyFilesArrayLength")));
	        String[] selectNodes = null;
	        if(1 < selectNodeLength){
	            selectNodes = (String[]) requestParamMap.get("copyFilesArray[]");
	        } else {
	            selectNodes = new String[1];
	            selectNodes[0] = CustomUtil.strNull(requestParamMap.get("copyFilesArray[]"));
	        }
	        
            
            if(!"".equals(icebreakerUrl)){
                
                String apiUrl = "/api/file/copy";
                String sourceId = "";
                String sourceFileName = "";
                
                icebreakerUrl = icebreakerUrl + apiUrl;
                
                URL url = new URL(icebreakerUrl);
                
                for(int i=0; i<selectNodes.length; i++){
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    
                    conn.setDoOutput(true);
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("Accept", "application/json");
                    conn.setRequestProperty("Content-Type", "application/json");
                    conn.setRequestProperty("Authorization", "Basic " + vcToken);
                    
                    String destPath = CustomUtil.strNull(requestParamMap.get("destPath"));
                    
                    //JsonParser parser = new JsonParser();
                    //JsonObject selectNodeJson =  (JsonObject) parser.parse((String) selectNodes[i]);
                    JSONObject selectNodeJson = JSONFactoryUtil.createJSONObject((String) selectNodes[i]);
                    sourceId = selectNodeJson.getString("sourceId");
                    sourceFileName = selectNodeJson.getString("sourceFileName");
                    
                    StringBuffer bodyStr = new StringBuffer();
                    
                    bodyStr.append("{");
                    bodyStr.append("   \"fileId\" : \"" + sourceId + "\", ");
                    
                    destPath = FILE_MOVE_PATH + userScreenName + "/repository/"+destPath + sourceFileName.toString();
                    bodyStr.append("   \"destPath\" : \""+destPath +"\" ");
                    bodyStr.append("}");
                    
                    OutputStream os = conn.getOutputStream();
                    os.write(bodyStr.toString().getBytes());
                    
                    responseStatus =  conn.getResponseCode();
                    os.flush();
                    os.close();
                    conn.disconnect();
                }
                
            }
            
            return responseStatus;
        }catch (Exception e){
            e.printStackTrace();
            return responseStatus;
        }
	}
}
