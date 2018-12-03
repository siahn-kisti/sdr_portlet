package com.sdr.file;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.DigesterUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.sdr.curation.batch.BatchCurate;
import com.sdr.submission.model.BulkCsvVo;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;

import javax.portlet.ActionRequest;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Pattern;

public class FileService extends FileConst {

    private static Log _log = LogFactoryUtil.getLog(FileService.class);

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

    public static String fileRead(File tartgetFile) throws FileNotFoundException {
        Scanner scan = null;
        StringBuilder fileText = new StringBuilder();

		scan = new Scanner(tartgetFile);

		while (scan.hasNextLine()) {
			fileText.append(scan.nextLine());
		}
		scan.close();

        return fileText.toString();
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

        //_log.debug("source : " + srcPath);
        //_log.debug("dest   : " + destPath);

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

        //String _doi_header = PortletProps.get("doi.header");
        // if ((_doi_header == null) || (_doi_header.length() == 0))
        //    _doi_header = "10.5072/sdr.kisti";

        String _doi_header = PropService.getProp("doi.header");
        return _doi_header + "." + datasetId;
    }


    public static String getRootPath() {
        // String _dataset_folder = PortletProps.get("dataset.location");
        // if ((_dataset_folder == null) || (_dataset_folder.length() == 0)) {
        //     _dataset_folder = (systemType() == TYPE_WINDOWS) ? WINDOWS_DEFAULT_FOLDER : LINUX_DEFAULT_FOLDER;
        // }
        // return _dataset_folder;
        return PropService.getProp("dataset.location");
    }


    public static String getSubPath(int sub) {
        return getSubPath(getRootPath(), sub);
    }

    // getPath to getDatasetPath
    public static String getDatasetPath(long collectionId, long userId, long datasetId, int type) {
        String _folder = FileConst.getSubPath(getRootPath(), type);
        return getDatasetPath(_folder, collectionId,userId, datasetId);
    }

    // getPath to getDetailPath
    public static String getDetailPath(long collectionId, long userId, long datasetId, int type, int sub) {
        return getDetailPath(getRootPath(),collectionId, userId, datasetId, type, sub) ;
    }

    public static String getBatchPath(int step, int sign){
        return getBatchPath(getRootPath(), step, sign);
    }

    public static String getTempPath(long userId) {
        return getSubPath( LOC_TYPE_TEMP ) + File.separator + userId;
    }

    public static String getTempPromptUserPath(long userId){ return getSubPath( LOC_TYPE_TEMP_PROMPT ) + File.separator + "0" + File.separator + userId; }
    public static String getMetaPromptUserPath(long userId){ return getSubPath( LOC_TYPE_META_PROMPT ) + File.separator + "0" + File.separator + userId; }

    public static String getUploadPath(String... paths) {
        String _folder = getSubPath( LOC_TYPE_UPLOAD );
        for (String s : paths)
            _folder += File.separator + s;
        return _folder;
    }


    public static String getDataViewTempPath(ActionRequest actionRequest, String title) {
        return getSubPath( LOC_TYPE_VIEW ) + File.separator + "WEB-INF" + File.separator + "jsp" +
                File.separator + "uploadView" + File.separator + title;
    }

	public static String getCollectionPath(long collectionId) {
		return getSubPath(getRootPath(), LOC_TYPE_COLLECTION) + File.separator + collectionId;
	}

	public static String getCollectionSubPath(long collectionId, int sub) {
		String collectionPath = getCollectionPath(collectionId);
		return getSubPath(collectionPath, sub);
	}

	public static String getDataTypePath(long dataTypeId) {
		return getSubPath(getRootPath(), LOC_TYPE_DATATYPE) + File.separator + dataTypeId;
	}

	public static String getViewComponentPath(long dataViewComponentsId) {
		return getSubPath(getRootPath(), LOC_TYPE_VIEWCOMPONENT) + File.separator + dataViewComponentsId;
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



    public static void deleteDirectoryFromSignature(int R_signature, int C_signature){
        // delete temp-curate-sign & info
        //String batch_location = getBatchPath(BatchCurate.STEP_IN_RETRIEVAL, signature);
        //cleanFile(batch_location);
        if (C_signature > 0) {
            String batch_location = getBatchPath(BatchCurate.STEP_IN_CURATION, C_signature);
            if (cleanFile(batch_location)) {
                batch_location = getSubPath(getRootPath(), LOC_TYPE_BATCH) + File.separator + C_signature;
                cleanFile(batch_location);
            }
        }

        // delete temp-retrieval-sign
        if (R_signature > 0) {
            String temp_location = getTempDatasetPath(getRootPath(), 0, R_signature);
            cleanFile(temp_location);
        }
    }




    //----------------------------------------------------------------------------------------------------
    // csv
    //----------------------------------------------------------------------------------------------------
    public static List<BulkCsvVo> getBulkCsvVoList(File file) throws SystemException {
        List<BulkCsvVo> data = null;

        try {
            CSVReader reader = new CSVReader(new FileReader(file));
            ColumnPositionMappingStrategy<BulkCsvVo> start = new ColumnPositionMappingStrategy<BulkCsvVo>();
            start.setType(BulkCsvVo.class);
            String[] columns = new String[]{"dataLocation", "dataType", "title"};
            start.setColumnMapping(columns);
            CsvToBean<BulkCsvVo> csv = new CsvToBean<BulkCsvVo>();
            data = csv.parse(start, reader);
            if (data != null && data.size() > 0)
                data.remove(0);
        } catch (IOException e) {
            _log.error(e.getMessage());
            throw new SystemException("Please upload a CSV file or check the format. Please refer [CSV file template] at the top");
        }

        return data;
    }

	/**
	 * @Methods Name : listAllFiles
	 * @작성일 : 2018. 8. 16.
	 * @작성자 : jaesung
	 * @변경이력 :
	 * @Method 설명 : 디렉토리 파일 탐색 (recursive)
	 */
	public static void listAllFiles(String directory, List<File> files) {

		File dir = new File(directory);
		File[] fileList = dir.listFiles();
		if(fileList != null) {
			for (int i = 0; i < fileList.length; i++) {
				File file = fileList[i];
				if (file.isFile()) {
					files.add(file);
				} else if (file.isDirectory()) {
					listAllFiles(file.getAbsolutePath(), files);
				}
			}
		}
	}

	/**
	 * @Methods Name : listAllFilesWithExtension
	 * @작성일 : 2018. 9. 17.
	 * @작성자 : jaesung
	 * @변경이력 :
	 * @Method 설명 : 특정 디렉토리 및 확장자 갖는 파일 탐색
	 */
	public static File[] listAllFilesWithExtension(String dirName, String extension){
        File dir = new File(dirName);
        final String ext = extension;
        return dir.listFiles(new FilenameFilter() {
                 public boolean accept(File dir, String filename)
                      { return filename.endsWith(ext); }
        } );

    }


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
                //_log.debug("### datasetFileValidateRule key: " + key + "  match: " + patternMap.get(key));
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
                        if (Pattern.matches(fName+"$", pName)) {
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
		if(file==null) return 0;
		_log.debug("### Flatten file :::" + filePath);

		int fileCount = 0;
		File resultPath = new File(filePath + File.separator + "result");

		/* When the user zipped the file in directory */
		if(resultPath.exists()) {
			File[] fileList = resultPath.listFiles();
			fileCount = fileList.length;
			for(int i = 0; i < fileCount; i++) {
				File sourceFile = fileList[i];
				File destFile = new File(filePath + File.separator + sourceFile.getName());
				boolean success = sourceFile.renameTo(destFile);
				if(success == false) {
					throw new IOException("No such file!");
				}
			}

			/* After flattening is done, delete the 'result' folder */
			resultPath.delete();
		}
		else {
			fileCount = getFilesCount(filePath);
			_log.debug("### Already flattened :::" + filePath);
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

        SequenceInputStream sequenceInputStream = new SequenceInputStream(fileStreams.elements()) ;
        return DigesterUtil.digest("MD5", sequenceInputStream);
    }


    private static void collectFiles(File directory, List<FileInputStream> fileInputStreams) throws IOException {
        File[] files = directory.listFiles();

        if (files != null) {
            Arrays.sort(files);

            for (File file : files) {
                if (file.isDirectory()) {
                    collectFiles(file, fileInputStreams);
                } else 	{
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


	/**
	 * Get thumb image string.
	 *
	 * @param _loc_image_file the loc image file
	 * @return the string
	 */
	public static String getFilePath(String _loc_image_file){
		String filePath = "";
		File file = new File(_loc_image_file);
		if (file.exists()){
			return file.getAbsolutePath();
		}
		return filePath;
	}

	/**
	 * Gets html file.
	 *
	 * @param _loc_html_file the loc html file
	 * @return the html file
	 * @throws IOException the io exception
	 */
	public static String getHtmlFile(String _loc_html_file) throws IOException {
		StringBuffer html = new StringBuffer();
		File htmlFile = new File(_loc_html_file);
		if (htmlFile.exists()){
			BufferedReader in = new BufferedReader(new FileReader(htmlFile));
			String line;
			while ((line = in.readLine()) != null) {
				html.append(line);
			}
		}
		return html.toString();
	}


	public static boolean renameFile(String filename, String newFilename) {
		File file = new File( filename );
		File fileNew = new File( newFilename );
		if( file.exists() ) return file.renameTo( fileNew );
		else return false;
	}
	
}
