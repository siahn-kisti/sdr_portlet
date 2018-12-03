package com.sdr.ml.common.util;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.DigesterUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.util.portlet.PortletProps;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;

import javax.portlet.ActionRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.regex.Pattern;

public class FileService {

    private static Log _log = LogFactoryUtil.getLog(FileService.class);


    public static final int LOC_DERIVED = 20;
    public static final int LOC_METADATA = 30;
    public static final int LOC_LOG = 40;
    public static final int LOC_UNDEF = 0;

    public static final int LOC_SUCCESS_LOG = 41;
    public static final int LOC_ERROR_LOG = 42;

    public static final int LOC_TYPE_FINAL = 1;
    public static final int LOC_TYPE_TEMP = 2;
    public static final int LOC_TYPE_META = 3;
    public static final int LOC_TYPE_TEMP_PROMPT = 4;
    public static final int LOC_TYPE_META_PROMPT = 5;
    public static final int LOC_TYPE_UNDEF = 0;

    public static final int TYPE_WINDOWS = 1;
    public static final int TYPE_LINUX = 2;
    public static final int TYPE_OTHERS = 99;

    public static final String WINDOWS_DEFAULT_FOLDER_FINAL = "C:/UTIL/kisti/root/final";
    public static final String WINDOWS_DEFAULT_FOLDER_TEMP = "C:/UTIL/kisti/root/temp";
    public static final String WINDOWS_DEFAULT_FOLDER_META = "C:/UTIL/kisti/root/meta";
    public static final String WINDOWS_DEFAULT_FOLDER_TEMP_PROMPT = "C:/UTIL/kisti/root/prompt/temp";
    public static final String WINDOWS_DEFAULT_FOLDER_META_PROMPT = "C:/UTIL/kisti/root/prompt/meta";
    public static final String WINDOWS_DEFAULT_UPLOAD_FOLDER = "C:/UTIL/kisti/root/uploadfile";

    public static final String LINUX_DEFAULT_FOLDER_FINAL = "/root/final";
    public static final String LINUX_DEFAULT_FOLDER_TEMP = "/root/tmp";
    public static final String LINUX_DEFAULT_FOLDER_META = "/root/meta";
    public static final String LINUX_DEFAULT_FOLDER_TEMP_PROMPT = "/root/prompt/tmp";
    public static final String LINUX_DEFAULT_FOLDER_META_PROMPT = "/root/prompt/meta";
    public static final String LINUX_DEFAULT_UPLOAD_FOLDER = "/root/uploadfile";

    //----------------------------------------------------------------------------------------------------
    // File Upload
    //----------------------------------------------------------------------------------------------------

    /**
     * 파일을 입력받아 해당경로에 생성
     *
     * @param file
     * @param filePath
     * @return
     * @throws SystemException
     */
    public static String saveFile(File file, String filePath) throws SystemException {
        if (file == null || StringUtils.isEmpty(filePath)) return "";
        File destFolder;
        File destFile = null;
        try {
            String fileName = file.getName();
            destFolder = new File(filePath);
            if (!destFolder.exists()) destFolder.mkdirs();

            destFile = new File(destFolder + File.separator + fileName);
            FileUtil.copyFile(file, destFile);

            _log.debug("### fileSave:::" + destFolder + File.separator + fileName);

        } catch (Exception e) {
            _log.error(e.getMessage());
            if (destFile != null)
                FileUtil.delete(destFile);
            throw new SystemException(e.getMessage());
        } finally {
            FileUtil.delete(file);
            file = null;
            destFile = null;
        }
        return filePath;
    }

    public static boolean removeFile(String path) {
        File f = new File(path);
        return FileSystemUtils.deleteRecursively(f);
    }

    /**
     * 파일을 파일을 입력받아 해당경로에 압축해제
     * 업로드된 원본 파일은 저장하지 않음
     *
     * @param file
     * @param filePath
     * @return
     * @throws SystemException
     */

    public static int saveFileAndDecompress(File file, String filePath) throws SystemException {
        if (file == null) return 0;
        _log.debug("### uploaded file:::" + file.getName());
        int fileCount = 0;

        try {
            FileService.unzip(file, filePath);

            fileCount = getFilesCount(filePath);
            _log.debug("### Decompress file:::" + filePath + "   length:" + fileCount);
        } catch (ZipException e) {
            _log.error(e.getMessage());
            FileUtil.deltree(filePath);
            throw new SystemException(e.getMessage());
        } finally {
            FileUtil.delete(file);
            file = null;
            // TODO : ROLLBACK
        }
        return fileCount;
    }

    public static boolean finalizeFiles(String srcPath, String destPath) {
        File srcDir = new File(srcPath);
        if (!srcDir.exists()) return false;

        File destDir = new File(destPath);

        _log.debug("source : " + srcPath);
        _log.debug("dest   : " + destPath);

        /* To make parent directories, make directory first and then delete it */
        destDir.mkdirs();
        destDir.delete();

        boolean success = srcDir.renameTo(destDir);
		/* TODO : ROLLBACK in case of failure
		if (!success) {  }
		*/
        // TODO : in case of different volume, COPY
        return success;
    }


    public static String mintDOI(long datasetId) {

        String _doi_header = PortletProps.get("doi.header");

        if ((_doi_header == null) || (_doi_header.length() == 0))
            _doi_header = "10.5072/sdr.kisti";

        return _doi_header + "." + datasetId;
    }


    public static int systemType() {
        String OS = System.getProperty("os.name").toLowerCase();

        if (OS.indexOf("win") >= 0) {
            return TYPE_WINDOWS;
        } else if (OS.indexOf("mac") >= 0) {
            return TYPE_LINUX;
        } else if (OS.indexOf("nix") >= 0) {
            return TYPE_LINUX;
        } else if (OS.indexOf("sunos") >= 0) {
            return TYPE_LINUX;
        } else {
            return TYPE_OTHERS;
        }
    }

    public static String getSubPath(String path, int sub) {

        switch (sub) {
            case LOC_DERIVED:
                return path + File.separator + "derived";
            case LOC_METADATA:
                return path + File.separator + "metadata";
            case LOC_LOG:
                return path + File.separator + "log";
            case LOC_SUCCESS_LOG:
                return path + File.separator + "log" + File.separator + "success.log";
            case LOC_ERROR_LOG:
                return path + File.separator + "log" + File.separator + "error.log";
        }
        return null;
    }

    public static String getSubPath(long collectionId, long userId, long datasetId, int type, int sub) {
        String path = getPath(collectionId, userId, datasetId, type);
        if (path == null) return null;
        return getSubPath(path, sub);
    }

    public static String getPath(long collectionId, long userId, long datasetId, int type) {

        String _dataset_folder = null;

        if (type == LOC_TYPE_FINAL) {
            _dataset_folder = PortletProps.get("dataset.final");
        } else if (type == LOC_TYPE_TEMP) {
            _dataset_folder = PortletProps.get("dataset.temp");
        } else if (type == LOC_TYPE_META) {
            _dataset_folder = PortletProps.get("dataset.meta");
        } else if (type == LOC_TYPE_TEMP_PROMPT) {
            _dataset_folder = PortletProps.get("dataset.temp.prompt");
        } else if (type == LOC_TYPE_META_PROMPT) {
            _dataset_folder = PortletProps.get("dataset.meta.prompt");
        } else {
            return null;
        }

        if ((_dataset_folder == null) || (_dataset_folder.length() == 0)) {
            if (systemType() == TYPE_WINDOWS) {
                switch (type) {
                    case LOC_TYPE_FINAL:
                        _dataset_folder = WINDOWS_DEFAULT_FOLDER_FINAL;
                        break;
                    case LOC_TYPE_TEMP:
                        _dataset_folder = WINDOWS_DEFAULT_FOLDER_TEMP;
                        break;
                    case LOC_TYPE_META:
                        _dataset_folder = WINDOWS_DEFAULT_FOLDER_META;
                        break;
                    case LOC_TYPE_TEMP_PROMPT:
                        _dataset_folder = WINDOWS_DEFAULT_FOLDER_TEMP_PROMPT;
                        break;
                    case LOC_TYPE_META_PROMPT:
                        _dataset_folder = WINDOWS_DEFAULT_FOLDER_META_PROMPT;
                        break;
                }
            } else {
                switch (type) {
                    case LOC_TYPE_FINAL:
                        _dataset_folder = LINUX_DEFAULT_FOLDER_FINAL;
                        break;
                    case LOC_TYPE_TEMP:
                        _dataset_folder = LINUX_DEFAULT_FOLDER_TEMP;
                        break;
                    case LOC_TYPE_META:
                        _dataset_folder = LINUX_DEFAULT_FOLDER_META;
                        break;
                    case LOC_TYPE_TEMP_PROMPT:
                        _dataset_folder = LINUX_DEFAULT_FOLDER_TEMP_PROMPT;
                        break;
                    case LOC_TYPE_META_PROMPT:
                        _dataset_folder = LINUX_DEFAULT_FOLDER_META_PROMPT;
                        break;
                }
            }
        }

        String filePath = _dataset_folder +
                File.separator + collectionId +
                File.separator + userId +
                File.separator + "m" + (datasetId / 1000000) +
                File.separator + "k" + (datasetId / 1000) +
                File.separator + datasetId;
        return filePath;
    }

    public static String getTempPath(long userId) {
        String _folder = PortletProps.get("dataset.temp");
        ;

        if (StringUtils.isEmpty(_folder)) {
            _folder = (systemType() == LOC_TYPE_TEMP) ? WINDOWS_DEFAULT_FOLDER_TEMP : LINUX_DEFAULT_FOLDER_TEMP;
        }

        _folder += File.separator + userId;

        return _folder;
    }

    public static String getUploadPath(String... paths) {
        String _folder = getUploadPath();
        for (String s : paths)
            _folder += File.separator + s;
        return _folder;
    }

    public static String getUploadPath() {
        String _folder = PortletProps.get("uploadfile");
        ;

        if (StringUtils.isEmpty(_folder)) {
            _folder = (systemType() == TYPE_WINDOWS) ? WINDOWS_DEFAULT_UPLOAD_FOLDER : LINUX_DEFAULT_UPLOAD_FOLDER;
        }

        return _folder;
    }

    public static String getDataViewTempPath(ActionRequest actionRequest, String title) {
        String _dataView_folder_temp = PortletProps.get("dataview.temp");

        /* TODO
         * What if dataview.temp is not set
         *
         */

        String filePath = _dataView_folder_temp +
                File.separator + "WEB-INF" +
                File.separator + "jsp" +
                File.separator + "uploadView" +
                File.separator + title;

        return filePath;
    }

    public static void deleteDataViewPath(String filepath) {

        File folder = new File(filepath);
        if (!folder.exists()) {
            folder.mkdir();
        } else {
            String[] file_entries = folder.list();
            for (String s : file_entries) {
                File currentFile = new File(folder.getPath(), s);
                currentFile.delete();
            }
            folder.delete();
        }
        _log.debug("### fileDelete:::" + folder);
    }

    public static int getFilesCount(String path) {
        File dir = new File(path);
        int totalFiles = 0;

        File[] listFiles = dir.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file : listFiles) {
                if (file.isFile()) {
                    totalFiles++;
                } else {
                    totalFiles += getFilesCount(file.getPath());
                }
            }
        }

        return totalFiles;
    }


    //----------------------------------------------------------------------------------------------------
    // csv
    //----------------------------------------------------------------------------------------------------
//    public static List<BulkCsvVo> getBulkCsvVoList(File file) throws SystemException {
//        List<BulkCsvVo> data = null;
//
//        try {
//            CSVReader reader = new CSVReader(new FileReader(file));
//            ColumnPositionMappingStrategy<BulkCsvVo> start = new ColumnPositionMappingStrategy<BulkCsvVo>();
//            start.setType(BulkCsvVo.class);
//            String[] columns = new String[]{"dataLocation", "dataType", "title"};
//            start.setColumnMapping(columns);
//            CsvToBean<BulkCsvVo> csv = new CsvToBean<BulkCsvVo>();
//            data = csv.parse(start, reader);
//            if (data != null && data.size() > 0)
//                data.remove(0);
//        } catch (IOException e) {
//            _log.error(e.getMessage());
//            throw new SystemException("Please upload a CSV file or check the format. Please refer [CSV file template] at the top");
//        }
//
//        return data;
//    }


    //----------------------------------------------------------------------------------------------------
    // Compress
    //----------------------------------------------------------------------------------------------------
    public static String zip(String zipFolder, String zipFile) {
        try {
            ZipFile zipfile = new ZipFile(zipFile);
            zipfile.setFileNameCharset("euc-kr");
            ZipParameters parameters = new ZipParameters();
            parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
            parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
            zipfile.addFolder(zipFolder, parameters);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return zipFile;
    }

    //----------------------------------------------------------------------------------------------------
    // Decompress
    //----------------------------------------------------------------------------------------------------
    public static void unzip(File file, String destPath) throws ZipException {
        ZipFile zipFile = null;
        try {
            zipFile = new ZipFile(file);
            zipFile.setFileNameCharset("euc-kr");
            zipFile.extractAll(destPath);
        } catch (ZipException e) {
            _log.error("File Unzip Failed: " + e.getMessage());
            FileUtil.deltree(destPath);
            throw new ZipException("File Unzip Failed: " + e.getMessage());
        }
    }


    //----------------------------------------------------------------------------------------------------
    // file validation
    //----------------------------------------------------------------------------------------------------
    public static void datasetFileValidateRule(String folder, String rule) throws IOException {
        if (!StringUtils.isEmpty(rule)) {
            String[] rules = rule.split(":");
            Map<String, Integer> patternMap = fileValidateRule(folder, rules);
            for (String key : patternMap.keySet()) {
                _log.debug("### datasetFileValidateRule key: " + key + "  match: " + patternMap.get(key));
                if (patternMap.get(key) <= 0)
                    throw new IOException("file validation error : file pattern not found! [ " + key + " ] ");
            }
        }
    }

    public static Map fileValidateRule(String folder, String[] patterns) throws IOException {
        final Path path = Paths.get(folder);
        if (!Files.exists(path) || !Files.isDirectory(path)) {
            throw new IOException("No such directory!");
        }
        if (patterns == null || patterns.length < 1) {
            throw new IOException("Please provide at least the glob pattern.");
        }

        final Map<String, Integer> patternMap = new HashMap();
        for (String s : patterns) patternMap.put(s, 0);

        try {
            Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    File targetFile = file.toFile();
                    for (String key : patternMap.keySet()) {
                        String fileName = targetFile.getPath();
                        String fName = fileName.toString().replace("\\", "/");
                        String pName = (path.toString() + File.separator + key).replace("\\", "/");
//                        System.out.println("name: " + fName);
//                        System.out.println("path: " + pName);
//                        System.out.println("fName.matches(pName) : " + Pattern.matches(fName+"$", pName));
                        if (Pattern.matches(fName + "$", pName)) {
                            Integer i = patternMap.get(key);
                            patternMap.put(key, i + 1);
                        }
                    }
                    return FileVisitResult.CONTINUE;
                }

            });
        } catch (IOException e) {
            String exceptionMessage = String.format("Resource searching failed - path:%s, exception: %s", path, e);
            throw new IOException(exceptionMessage, e);
        }
        return patternMap;
    }

    public static int flattenFile(File file, String filePath) throws IOException {
        if (file == null) return 0;
        _log.debug("### Flatten file :::" + file.getName());

        int fileCount = 0;
        File resultPath = new File(filePath + "/result");

        /* When the user zipped the file in directory */
        if (resultPath.exists()) {
            File[] fileList = resultPath.listFiles();
            fileCount = fileList.length;
            for (int i = 0; i < fileCount; i++) {
                File sourceFile = fileList[i];
                File destFile = new File(filePath + "/" + sourceFile.getName());
                boolean success = sourceFile.renameTo(destFile);
                if (success == false) {
                    throw new IOException("No such file!");
                }
            }

            /* After flattening is done, delete the 'result' folder */
            resultPath.delete();
        } else {
            fileCount = getFilesCount(filePath);
            _log.debug("### Already flattened :::" + file.getName());
        }

        return fileCount;
    }


    public static final int CHECKSUM_VALID = 0;
    public static final int CHECKSUM_INVALID = 1;
    public static final int CHECKSUM_NONE = 2;

    public static String getCheckSum(String path) throws IOException {
        File directory = new File(path);

        if (!directory.isDirectory()) {
            throw new IllegalArgumentException("Not a directory");
        }

        Vector<FileInputStream> fileStreams = new Vector<>();
        collectFiles(directory, fileStreams);

        SequenceInputStream sequenceInputStream = new SequenceInputStream(fileStreams.elements());
        return DigesterUtil.digest("MD5", sequenceInputStream);
    }


    private static void collectFiles(File directory, List<FileInputStream> fileInputStreams) throws IOException {
        File[] files = directory.listFiles();

        if (files != null) {
            Arrays.sort(files);

            for (File file : files) {
                if (file.isDirectory()) {
                    collectFiles(file, fileInputStreams);
                } else {
                    fileInputStreams.add(new FileInputStream(file));
                }
            }
        }
    }

    public static String checkExtension(File file) {
        String ext = "";

        String fileName = file.getName();

        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            ext = fileName.substring(fileName.lastIndexOf(".") + 1);
        } else {
            ext = "";
        }

        return ext;
    }

}
