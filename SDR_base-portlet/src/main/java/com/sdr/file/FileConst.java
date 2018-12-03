package com.sdr.file;

import com.sdr.curation.batch.BatchCurate;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

import java.io.File;

public class FileConst {

    /* locations under root */
    public static final int LOC_TYPE_FINAL = 11;
    private static final String _FINAL_SUBFOLDER = "final";

    public static final int LOC_TYPE_TEMP = 12;
    private static final String _TEMP_SUBFOLDER = "temp";

    public static final int LOC_TYPE_META = 13;
    private static final String _META_SUBFOLDER = "meta";

    public static final int LOC_TYPE_TEMP_PROMPT = 14;
    private static final String _PROMPT_TEMP_SUBFOLDER = "prompt" + File.separator + "temp";

    public static final int LOC_TYPE_META_PROMPT = 15;
    private static final String _PROMPT_META_SUBFOLDER = "prompt" + File.separator + "meta";

    public static final int LOC_TYPE_UPLOAD = 16;
    private static final String _UPLOAD_SUBFOLDER = "uploadfile";

    public static final int LOC_TYPE_BATCH = 17;
    private static final String _BATCH_SUBFOLDER = "batch";

    public static final int LOC_TYPE_VIEW = 18;
    private static final String _VIEW_SUBFOLDER = "view";

    public static final int LOC_TYPE_PP = 19;
    private static final String _PP_SUBFOLDER = "preprocess";
    
	public static final int LOC_TYPE_COLLECTION = 61;
	private static final String _COLLECTION_SUBFOLDER = "collection";
	
	public static final int LOC_TYPE_DATATYPE = 62;
	private static final String _DATATYPE_SUBFOLDER = "datatype";
	
	public static final int LOC_TYPE_VIEWCOMPONENT = 63;
	private static final String _VIEWCOMPONENT_SUBFOLDER = "viewcomponent";


    /* locations under each dataset */
    public static final int LOC_DERIVED = 21;
    private static final String _DERIVED_LOCATION = "derived";

    public static final int LOC_METADATA = 22;
    private static final String _METADATA_LOCATION = "metadata";

    public static final int LOC_LOG = 23;
    private static final String _LOG_LOCATION = "log";

	public static final int LOC_IMAGE = 24;
	private static final String _IMAGE_LOCATION = "image";
	
	public static final int LOC_HTML = 25;
	private static final String _HTML_LOCATION = "html";
	
	public static final int LOC_PAPER = 26;
	private static final String _PAPER_LOCATION = "paper";


    public static final int LOC_SUCCESS_LOG = 41;
    public static final String _LOG_FILE_SUCCESS = "success.log";

    public static final int LOC_ERROR_LOG = 42;
    public static final String _LOG_FILE_ERROR = "error.log";

    public static final int LOC_HISTORY_LOG = 43;
    private static final String _LOG_FILE_HISTORY = "history.log";

    public static final int LOC_IN_LOG = 44;
    public static final String _LOG_FILE_IN = "in.dat";

    public static final int LOC_OUT_LOG = 45;
    public static final String _LOG_FILE_OUT = "out.dat";

    public static final int LOC_IMAGE_THUMB = 46;
	private static final String _IMAGE_FILE_THUMB = "thumb.png";

    public static final int LOC_INDEX_HTML = 47;
	private static final String _HTML_FILE_INDEX = "index.html";

    public static final int LOC_PAPER_PDF = 48;
	private static final String _PDF_FILE_PAPER = "paper.pdf";




    public static final int LOC_MD_META = 51;
    public static final String _META_FILE_MD = "dm.json";

    public static final int LOC_MD_OLD_META = 52;
    public static final String _META_FILE_MD_OLD = "dm.old";




    public static final int LOC_DATASET_LIST = 31;
    private static final String _DATASET_LIST_FILE_NAME = "dataset.list";

    public static final int LOC_FEEDBACK_LIST = 32;
    private static final String _FEEDBACK_FILE_NAME = "feedback.list";

    public static final int LOC_BATCH_INFO = 33;
    private static final String _BATCH_INFO_FILE_NAME = "batch.info";

    /* System Type */
    public static final int TYPE_WINDOWS = 1;
    public static final int TYPE_LINUX = 2;
    public static final int TYPE_OTHERS = 99;


    /* Repository */
    public final static int IMPORT_FROM_FTP = 0;
    public final static int IMPORT_FROM_EDISON = 1;
    public final static int IMPORT_FROM_TEMP_FOR_DIRECT_VIEW = 2;


    /* Proprocessing */
    public final static long PP_NO = 2;
    public final static long PP_DEFAULT = 0;
    public final static long PP_PREVIOUS = 1;

    public final static int PP_TYPE_COMPOSITION = 1;
    public final static int PP_TYPE_SIMPLE = 2;
    public final static int PP_TYPE_CONTAINER = 3;
    public final static int PP_TYPE_UNKNOWN = 4;


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


    public static String getDetailPath(String location, long collectionId, long userId, long datasetId, int type, int sub) {
        String filePath = getSubPath(location, type);
        filePath = getDatasetPath(filePath, collectionId, userId, datasetId);
        return getSubPath(filePath, sub);
    }


    public static String getDatasetPath(String location, long collectionId, long userId, long datasetId) {
        String filePath = location +
                File.separator + collectionId +
                File.separator + userId +
                File.separator + "m" + (datasetId / 1000000) +
                File.separator + "k" + (datasetId / 1000) +
                File.separator + datasetId;
        return filePath;
    }


    public static String getBatchPath(String location, int step, int sign){

        String _dataset_folder = getSubPath(location, LOC_TYPE_BATCH );
        String header = "" + sign + File.separator;
        header += (step == BatchCurate.STEP_IN_CURATION) ? "curate" : "retrieve";

        /*
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String today = sdf.format(new Date());
        String randomId = UUID.randomUUID().toString().replace("-", "");
        String hashcode = header + (randomId.hashCode() % 1000)   ;
        _dataset_folder += File.separator + today + File.separator + hashcode + File.separator + randomId ;
        */

        _dataset_folder += File.separator + header;
        return _dataset_folder;
    }

    public static String getTempDatasetPath(String location, long datasetId, int sign){
        String _dataset_folder = getSubPath(location, LOC_TYPE_TEMP );

        if (datasetId == 0) {
            _dataset_folder += File.separator + sign;
        } else {
            _dataset_folder += File.separator + sign + File.separator + datasetId;
        }

        return _dataset_folder;
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
            // _log.error("File Unzip Failed: " + e.getMessage());
            deleteDirectory(new File(destPath));
            throw new ZipException("File Unzip Failed: " + e.getMessage());
        }
    }

    public static boolean deleteDirectory(String dir) {
        File file = new File(dir);
        return deleteDirectory(file);
    }

    public static boolean deleteDirectory(File path) {
        if (!path.exists()) return false;

        File[] files = path.listFiles();
        for (File file : files) {
            if (file.isDirectory()) deleteDirectory(file);
            else  file.delete();
        }
        return path.delete();
    }


    public static boolean cleanFile(String path) {
        File f = new File(path);
        return f.delete();
    }



    public static String getSubPath(String path, int sub) {
        switch (sub) {
            /* super folder */
            case LOC_TYPE_FINAL:
                return path + File.separator + _FINAL_SUBFOLDER;
            case LOC_TYPE_TEMP:
                return path + File.separator + _TEMP_SUBFOLDER;
            case LOC_TYPE_META:
                return path + File.separator + _META_SUBFOLDER;
            case LOC_TYPE_TEMP_PROMPT :
                return path + File.separator + _PROMPT_TEMP_SUBFOLDER;
            case LOC_TYPE_META_PROMPT :
                return path + File.separator + _PROMPT_META_SUBFOLDER;
            case LOC_TYPE_UPLOAD :
                return path + File.separator + _UPLOAD_SUBFOLDER;
            case LOC_TYPE_BATCH :
                return path + File.separator + _BATCH_SUBFOLDER;
            case LOC_TYPE_VIEW :
                return path + File.separator + _VIEW_SUBFOLDER;
            case LOC_TYPE_PP :
                return path + File.separator + _PP_SUBFOLDER;
            case LOC_TYPE_COLLECTION :
                return path + File.separator + _COLLECTION_SUBFOLDER;
            case LOC_TYPE_DATATYPE :
                return path + File.separator + _DATATYPE_SUBFOLDER;
            case LOC_TYPE_VIEWCOMPONENT :
                return path + File.separator + _VIEWCOMPONENT_SUBFOLDER;

            /* dataset folder */
            case LOC_DERIVED:
                return path + File.separator + _DERIVED_LOCATION;
            case LOC_METADATA:
                return path + File.separator + _METADATA_LOCATION;
            case LOC_LOG:
                return path + File.separator + _LOG_LOCATION;

			/* sub folder */
            case LOC_IMAGE:
                return path + File.separator + _IMAGE_LOCATION;
            case LOC_HTML:
                return path + File.separator + _HTML_LOCATION;
            case LOC_PAPER:
                return path + File.separator + _PAPER_LOCATION;
                
            case LOC_SUCCESS_LOG:
                return path + File.separator + _LOG_LOCATION + File.separator + _LOG_FILE_SUCCESS;
            case LOC_ERROR_LOG:
                return path + File.separator + _LOG_LOCATION + File.separator + _LOG_FILE_ERROR;
            case LOC_HISTORY_LOG:
                return path + File.separator + _LOG_FILE_HISTORY;

			case LOC_IMAGE_THUMB:
				return path + File.separator + _IMAGE_LOCATION + File.separator + _IMAGE_FILE_THUMB;
			case LOC_INDEX_HTML:
				return path + File.separator + _HTML_LOCATION + File.separator + _HTML_FILE_INDEX;
			case LOC_PAPER_PDF:
				return path + File.separator + _PAPER_LOCATION + File.separator + _PDF_FILE_PAPER;
				
            /* batch job folder */
            case LOC_DATASET_LIST:
                return path + File.separator + _DATASET_LIST_FILE_NAME;
            case LOC_FEEDBACK_LIST:
                return path + File.separator + _FEEDBACK_FILE_NAME;
            case LOC_BATCH_INFO :
                return path + File.separator + _BATCH_INFO_FILE_NAME;
                
        }
        return null;
    }
}
