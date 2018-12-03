package com.sdr.ml.common.util;

import com.liferay.util.portlet.PortletProps;

public class MlStringUtils {

    // ID
    public static final String _TITLE_PUBLIC_ML_COLLECTION = PortletProps.get("publicMlCollectionTitle");
    public static final String _TITLE_PRIVATE_ML_COLLECTION = PortletProps.get("privateMlCollectionTitle");
    public static final String _TITLE_ML_DATASET_DATA_TYPE = PortletProps.get("mlDatasetDataTypeTitle");
    public static final String _TITLE_ML_NOTEBOOK_DATA_TYPE = PortletProps.get("mlNotebookDataTypeTitle");


    // Facet Keyword List
    public static final String _FACET_ML_DATASET_LICENSE_LIST = PortletProps.get("facet.mlDatasetLicenseList");
    public static final String _FACET_ML_DATASET_FILE_SIZE_LIST = PortletProps.get("facet.mlDatasetFileSizeList");

    public static final String _FACET_ML_NOTEBOOK_LANGUAGE_LIST = PortletProps.get("facet.mlNotebookLanguageList");
	public static final String _FACET_ML_NOTEBOOK_TASK_LIST = PortletProps.get("facet.mlNotebookTaskList");
    public static final String _FACET_ML_NOTEBOOK_ALGORITHM_LIST = PortletProps.get("facet.mlNotebookAlgorithmList");


    // Code values
    public static final int _CODE_CURATION_SUCCESS = 200;
    public static final int _CODE_UNAUTHORIZED = 401;
    public static final int _CODE_NO_REQUIRED_PARAMETERS = 405;
    public static final int _CODE_CURATION_FAIL = 500;
    public static final int _CODE_CURATION_TIMEOUT = 599;
    public static final int _CODE_FILE_EXISTS = 599;


    // Messages
    public static final String _MSG_CURATION_SUCCESS = "Preprocessing success.";
    public static final String _MSG_UNAUTHORIZED = "unauthorized.";
    public static final String _MSG_CURATION_FAIL = "Preprocessing failure.";
    public static final String _MSG_NO_REQUIRED_PARAMETERS = "No required parameters";
    public static final String _MSG_CURATION_TIMEOUT = "Curation Time Out.";
    public static final String _MSG_FILE_EXISTS = "The file already exists.";


    // Session Key
    public static final String _SESSION_KEY_GUI_PARAMETERS = "sssnGuiParameters";
    public static final String _SESSION_KEY_DATASET_ID = "datasetId";
    

    // File Names
    public static final String _NAME_ML_SUBMISSION_INPUT_CSV = "input.csv";
	public static final String _NAME_ML_SUBMISSION_TOP_IMAGE = "top";
	public static final String _NAME_ML_SUBMISSION_INDEX_HTML = "index.html";
	public static final String _NAME_ML_SUBMISSION_THUMBNAIL = "thumbnail";
    public static final String _NAME_ML_GUI_TO_CODE_CONVERSION = "WEB-INF/python/gui_to_programming_code_conversion.py";
    public static final String _NAME_NOTEBOOK_IPYNB_FILE = "run.ipynb";

    // Key Names of DescriptiveMetadata
	public static final String _KEY_NAME_DM_INPUT_SCHEMA = "inputSchema";


    // %s = {userId}
    private static final String _NAME_NOTEBOOK_CODE_FILE = "%s_nbcode";
    private static final String _NAME_NOTEBOOK_HTML_FILE = "%s_nbcod.html";
    private static final String _NAME_GUI_PARAMETERS_JSON_FILE = "%s_gui_parameters.json";


    // ML GUI Parameter Kind Values
    public static final String _KIND_ML_GUI_PARAMETER_LANGUAGE = "language";
    public static final String _KIND_ML_GUI_PARAMETER_TASK = "task";
    public static final String _KIND_ML_GUI_PARAMETER_ALGORITHM = "algorithm";
    public static final String _KIND_ML_GUI_PARAMETER_OPTION = "parameter";
    public static final String _KIND_ML_GUI_PARAMETER_VISUALIZATION = "visualization";
    public static final String _KIND_ML_GUI_PARAMETER_PERFORMANCE_EVALUATION = "performanceEvaluation";


    // Jupyterhub
    public static final String JUPYTERHUB_URL = PortletProps.get("jupyterhub.uri");
    public static final String JUPYTERHUB_SUB_URL_LOGIN = PortletProps.get("jupyterhub.sub.uri.login");
    public static final String JUPYTERHUB_SUB_URL_LOGOUT = PortletProps.get("jupyterhub.sub.uri.logout");


    // Python
    public static final String _PYTHON_EXEC_COMMAND = PortletProps.get("pythonCommand");

    // Docker
    public static final String _DOCKER_EXEC_COMMAND = PortletProps.get("dockerCommand");



    public static String getNotebookCodeFileName(String userId){

        return String.format(_NAME_NOTEBOOK_CODE_FILE, userId);
    }

    public static String getNotebookHtmlFileName(String userId){

        return String.format(_NAME_NOTEBOOK_HTML_FILE, userId);
    }

    public static String getGuiParametersJsonFileName(String userId){

        return String.format(_NAME_GUI_PARAMETERS_JSON_FILE, userId);
    }

    /**
     * Windows형태의 파일 경로를 Linux형태의 경로로 변경
     * <p>
     * Windows형태의 파일 경로를 Docker나 Linux에서
     * 사용할 수 있도록 경로의 형태를 변경
     * </p>
     *
     * @param  windowsStylePath Windows Style Path
     * @return Linux Style Path
     */
    public static String windowsPathToLinuxPath(String windowsStylePath){
        String linuxStylePath = windowsStylePath
                .replace("C:", "c").replace("c:", "c")
                .replace("D:", "d").replace("d:", "d")
                .replace("E:", "e").replace("e:", "e")
                .replaceAll("\\\\","/");

        if(!((char)linuxStylePath.getBytes()[0] == '/')) {
            linuxStylePath = "/" + linuxStylePath;
        }

        return linuxStylePath;
    }
}

