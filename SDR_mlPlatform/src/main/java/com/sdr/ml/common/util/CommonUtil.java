package com.sdr.ml.common.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.RoleServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.sdr.metadata.model.Dataset;
import com.sdr.metadata.service.DatasetServiceUtil;
import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javax.portlet.ResourceResponse;
import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * The type Common util.
 */
public class CommonUtil {

    private static Log log = LogFactoryUtil.getLog(CommonUtil.class);

    /**
     * Instantiates a new Common util.
     */
    public CommonUtil() {
        super();
    }

    /**
     * Gets dataset search context.
     *
     * @param companyId    the company id
     * @param scopeGroupId the scope group id
     * @param entryClass   the entry class
     * @return the dataset search context
     * @Methods Name : getDatasetSearchContext
     * @작성일 : 2017. 7. 20.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : Dataset SearchContext 가져오기
     */
    public static SearchContext getDatasetSearchContext(long companyId, long scopeGroupId, Class<?> entryClass) {
        SearchContext searchContext = new SearchContext();
        searchContext.setCompanyId(companyId);

        long[] groupIds = {scopeGroupId};
        searchContext.setGroupIds(groupIds);

        String[] entryClassNames = {entryClass.getName()};
        searchContext.setEntryClassNames(entryClassNames);

        return searchContext;
    }


    /**
     * JSONObject -> Map
     *
     * @param object the object
     * @return map
     * @throws JSONException the json exception
     */
    public static Map<String, Object> toMap(JSONObject object) throws JSONException {
        Map<String, Object> map = new HashMap<String, Object>();

        Iterator<String> keysItr = object.keys();
        while (keysItr.hasNext()) {
            String key = keysItr.next();
            Object value = object.get(key);

            if (value instanceof JSONArray) {
                value = toList((JSONArray) value);
            } else if (value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            map.put(key, value);
        }
        return map;
    }

    /**
     * JSONObject -> List
     *
     * @param array the array
     * @return list
     * @throws JSONException the json exception
     */
    public static List<Object> toList(JSONArray array) throws JSONException {
        List<Object> list = new ArrayList<Object>();
        for (int i = 0; i < array.length(); i++) {
            Object value = array.get(i);
            if (value instanceof JSONArray) {
                value = toList((JSONArray) value);
            } else if (value instanceof JSONObject) {
                value = toMap((JSONObject) value);
            }
            list.add(value);
        }
        return list;
    }


    /**
     * Jsmol file output stream.
     *
     * @param datasetId        the dataset id
     * @param targetFilePath   the target file path
     * @param outputFileName   the output file name
     * @param resourceResponse the resource response
     * @param serviceContext   the service context
     * @Methods Name : jsmolFileOutputStream
     * @작성일 : 2017. 7. 20.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : jsmol 파일 렌더링
     */
    public static void jsmolFileOutputStream(long datasetId, String targetFilePath, String outputFileName, ResourceResponse resourceResponse, ServiceContext serviceContext) {

        Dataset dataset = null;
        String filePath = "";

        try {
            dataset = DatasetServiceUtil.getDataset(datasetId, serviceContext);
        } catch (PortalException e) {
            log.error(e.getMessage());
        } catch (SystemException e) {
            log.error(e.getMessage());
        }

        if (StringUtils.isEmpty(targetFilePath))
            filePath = dataset.getLocation() + File.separator + outputFileName;
        else
            filePath = targetFilePath + File.separator + outputFileName;

        try {
            outputStream(outputFileName, filePath, resourceResponse);
        } catch (FileNotFoundException e) {
            // File Not Found
            log.error(e.getMessage());
        } catch (IOException e) {
            // IO Exception
            log.error(e.getMessage());
        }
    }

    /**
     * Gets analysis output temp real path.
     *
     * @param condition the condition
     * @return the analysis output temp real path
     * @Methods Name : getAnalysisOutputTempRealPath
     * @작성일 : 2017. 7. 20.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : Analysis 임시 출력 파일 변환 위치 Get
     */
//    public static String getAnalysisOutputTempRealPath(String condition) {
//        String dirPath = getAnalysisTempRealPath() + File.separator + condition + File.separator + "output";
//        mkdirs(dirPath);
//        return dirPath;
//    }

    /**
     * Gets analysis temp real path.
     *
     * @return the analysis temp real path
     * @Methods Name : getAnalysisTempRealPath
     * @작성일 : 2017. 7. 20.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : Analysis 임시 파일 변환 위치 Get
     */
//    public static String getAnalysisTempRealPath() {
//        String dirPath = CommonStaticInitalize.getWebappsRealPath() + File.separator + "temp" + File.separator + CommonStaticInitalize.getUserId();
//        mkdirs(dirPath);
//        return dirPath;
//    }

    /**
     * Mkdirs.
     *
     * @param dirPath the dir path
     * @Methods Name : mkdirs
     * @작성일 : 2017. 7. 11.
     * @작성자 : devsky
     * @변경이력 :
     * @Method 설명 : 디렉토리 확인 후 없으면 생성
     */
    public static void mkdirs(String dirPath) {
        // 해당 디렉토리의 존재여부를 확인
        File dir = new File(dirPath);
        if (!dir.exists()) {
            // 없다면 생성
            dir.mkdirs();
        }
    }


    public static boolean deleteDirectory(File path) {
        if (!path.exists()) {
            return false;
        }

        File[] files = path.listFiles();
        for (File file : files) {
            if (file.isDirectory())
                deleteDirectory(file);
            else
                file.delete();
        }
        return path.delete();
    }

    /**
     * Output stream.
     *
     * @param fileName         the file name
     * @param filePath         the file path
     * @param resourceResponse the resource response
     * @throws IOException           the io exception
     * @throws FileNotFoundException the file not found exception
     */
// 파일 다운로드 메소드
    public static void outputStream(String fileName, String filePath, ResourceResponse resourceResponse) throws IOException, FileNotFoundException {
        File downloadFile = new File(filePath);
        byte[] downloadFileByte = new byte[(int) downloadFile.length()];
        FileInputStream fileInputStream = new FileInputStream(downloadFile);
        fileInputStream.read(downloadFileByte);
        // Writing file to output
        resourceResponse.setContentType("application/xml");
        resourceResponse.addProperty("Content-disposition", "atachment; filename=" + fileName);
        OutputStream out = resourceResponse.getPortletOutputStream();
        out.write(downloadFileByte);
        out.flush();
        out.close();
    }


    /**
     * Number round and make json map.
     *
     * @param jsonObject the json object
     * @return the map
     */
    public static Map numberRoundAndMakeJson(JSONObject jsonObject) {
        Map map = new HashMap<>();
        DecimalFormat df = new DecimalFormat("#.######");

        Iterator<String> keys = jsonObject.keySet().iterator();
        while (keys.hasNext()) {

            String key = keys.next();

            Object value = jsonObject.get(key);

            if (value instanceof JSONArray) {
                List<Object> arr = CommonUtil.toList((JSONArray) value);

                List list = new ArrayList();
                for (Object each : arr) {
                    if (each instanceof Number) {
                        if (each instanceof Long) {
                            list.add(df.format((Long) each));
                        } else if (each instanceof Double) {
                            list.add(df.format((Double) each));
                        }
                    } else {
                        list.add(each);
                    }
                }
                map.put(key, list);
            } else if (value instanceof JSONObject) {
                Map<String, Object> stringObjectMap = CommonUtil.toMap((JSONObject) value);
            } else if (value instanceof Number) {
                if (value instanceof Long) {
                    map.put(key, df.format((Long) value));
                } else if (value instanceof Double) {
                    map.put(key, df.format((Double) value));
                } else {
                    map.put(key, df.format((Integer) value));
                }
            } else {
                map.put(key, value);
            }
        }

        return map;
    }

    /**
     * Gets admin.
     *
     * @return the admin
     */
    public static User getAdmin() {
        final long companyId = PortalUtil.getDefaultCompanyId();
        Role role = null;
        try {
            role = getRoleById(companyId, RoleConstants.ADMINISTRATOR);
            for (final User admin : UserLocalServiceUtil.getRoleUsers(role.getRoleId())) {
                return admin;
            }
        } catch (final Exception e) {
            log.error("Utils::getAdmin Exception", e);
        }
        return null;
    }

    /**
     * Gets role by id.
     *
     * @param companyId the company id
     * @param roleStrId the role str id
     * @return the role by id
     */
    public static Role getRoleById(final long companyId, final String roleStrId) {
        try {
            return RoleServiceUtil.getRole(companyId, roleStrId);
        } catch (final Exception e) {
            log.error("Utils::getRoleById Exception", e);
        }
        return null;
    }

    public static String getDateTime(){
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        String today = (new SimpleDateFormat("yyyyMMddHHmmss").format(date));
        return today;
    }
}
