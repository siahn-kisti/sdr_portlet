package com.sdr.ml.common.util.jupyter;

import com.sdr.ml.common.util.MlStringUtils;

public class JupyterConst {

//	jupyterhub.uri=http://localhost:58000/
//	jupyterhub.sub.uri.login=hub/login
//	jupyterhub.sub.uri.logout=logout

    //TODO: tempFilePath 임시로 사용
	public static String JUPYTER_ID = "cm";
	public static String JUPYTER_PASSWORD = "1234";
    public static String JUPYTER_HUB_URI = MlStringUtils.JUPYTERHUB_URL;
	public static String JUPYTER_HUB_SUB_URL_LOGIN = MlStringUtils.JUPYTERHUB_SUB_URL_LOGIN;
	public static String JUPYTER_HUB_SUB_URL_LOGOUT = MlStringUtils.JUPYTERHUB_SUB_URL_LOGOUT;


	private static String JUPYTER_HUB_NOTEBOOK_TEMP_URI = JUPYTER_HUB_URI + "/user/%s/notebooks%s";
	private static String JUPYTER_HUB_USER_REPOGITORY_PATH = "C:/Users/kyu/EDISON/jupyterhub/%s";
	private static String JUPYTER_HUB_NOTEBOOK_PATH = "/%s/run.ipynb";
	private static String JUPYTER_HUB_NOTEBOOK_FILE_NAME = "%s.ipynb";

	public static String getJupyterHubNotebookUri(String jupyterId, String notebookPath){

		return String.format(JUPYTER_HUB_NOTEBOOK_TEMP_URI, jupyterId, notebookPath);
	}

	public static String getJupyterHubUserRepogitoryPath(String jupyterId){

		return String.format(JUPYTER_HUB_USER_REPOGITORY_PATH, jupyterId);
	}

	public static String getJupyterHubNotebookPath(String nameToSave){

		return String.format(JUPYTER_HUB_NOTEBOOK_PATH, nameToSave);
	}

	public static String getJupyterHubFileName(String fileName){

		return String.format(JUPYTER_HUB_NOTEBOOK_FILE_NAME, fileName);
	}

}