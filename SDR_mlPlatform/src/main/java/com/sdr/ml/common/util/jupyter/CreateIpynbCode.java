package com.sdr.ml.common.util.jupyter;

import com.sdr.ml.common.util.MlFileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;

public class CreateIpynbCode {
    final public static String _IPYNB_CELL_TYPE_CODE = "code";
    final public static String _IPYNB_CELL_TYPE_MARKDOWN = "markdown";
    final public static String _IPYNB_LANGUAGE_PYTHON = "python";
    final public static String _IPYNB_LANGUAGE_R = "r";
    final public static String _IPYNB_METADATA_ML_INFO_DATA_ID = "ml_data_id";
    final public static String _IPYNB_METADATA_ML_INFO_NOTEBOOK_ID = "ml_notebook_id";
    final public static String _IPYNB_METADATA_ML_INFO_CREATE_DATE = "create_date";
    final public static String _IPYNB_METADATA_ML_INFO_GUI_PARAMETERS = "gui_parameters";

    JSONObject _IpynbParentJObject = null;
    JSONObject _IpynbMetadataJObject = null;
    JSONObject _MlInfoMetadataJObject = null;
    JSONArray _IpynbCellsJArray = null;
    String _Language = "";

	/**
	 * CreateIpynbCode 생성자
	 *
	 * @param language  생성할 코드가 사용하는 프로그래밍 언어 선택
	 */
    public CreateIpynbCode(String language){

        _IpynbParentJObject = new JSONObject();
        _IpynbMetadataJObject = new JSONObject();
        _IpynbCellsJArray = new JSONArray();
        _MlInfoMetadataJObject = new JSONObject();
        _Language = language.toLowerCase();

        setParentJson();
    }

	/**
	 * CreateIpynbCode 생성자
	 *
	 * @param ipynbFile  기존에 만들어진 Notebook 파싱
	 */
    public CreateIpynbCode(File ipynbFile){

        String ipynbText = MlFileUtils.fileRead(ipynbFile);
        JSONObject jobjectIpynb = new JSONObject(ipynbText);


        _IpynbParentJObject = new JSONObject();
        _IpynbMetadataJObject = jobjectIpynb.getJSONObject("metadata");
        _IpynbCellsJArray = jobjectIpynb.getJSONArray("cells");  //new JSONArray();
        _MlInfoMetadataJObject = _IpynbMetadataJObject.getJSONObject("ml_info");
        _Language = _IpynbMetadataJObject.getJSONObject("kernelspec").getString("language").toLowerCase();

        setParentJson();
    }


	/**
	 * Notebook의 코드열을 추가
	 *
	 * @param sources  String of code sources
	 */
    public CreateIpynbCode appendCode(String sources){
        append(_IPYNB_CELL_TYPE_CODE, sources);

        return this;
    }

	/**
	 * Notebook의 마크다운 추가
	 *
	 * @param sources  String of mark down
	 */
    public CreateIpynbCode appendMarkdown(String sources){
        append(_IPYNB_CELL_TYPE_MARKDOWN, sources);

        return this;
    }

	/**
	 * ml notebook에 Metadata를 추가
	 *
	 * @param key  String
	 * @param value  String
	 */
    public void appendMlInfoMetadata(String key, String value){

        _MlInfoMetadataJObject.put(key, value);
    }


	/**
	 * Notebook에 생성일 추가
	 *
	 * @param date  String
	 */
    public CreateIpynbCode setCreateDate(String date){
        appendMlInfoMetadata(_IPYNB_METADATA_ML_INFO_CREATE_DATE, date);

        return this;
    }

	/**
	 * Notebook에 생성일 반환
	 *
	 * @return date String
	 */
    public String getCreateDate(){

        return _MlInfoMetadataJObject.getString(_IPYNB_METADATA_ML_INFO_CREATE_DATE);
    }

	/**
	 * Notebook에 mlDatasetId 추가
	 *
	 * @param mlDatasetId String
	 */
    public CreateIpynbCode setMlDatasetId(String mlDatasetId){
        appendMlInfoMetadata(_IPYNB_METADATA_ML_INFO_DATA_ID, mlDatasetId);

        return this;
    }

	/**
	 * Notebook의 mlDatasetId 반환
	 *
	 * @return mlDatasetId String
	 */
    public String getMlDatasetId(){

        return _MlInfoMetadataJObject.getString(_IPYNB_METADATA_ML_INFO_DATA_ID);
    }

	/**
	 * Notebook에 guiParameters 추가
	 *
	 * @param guiParameters String
	 */
    public CreateIpynbCode setGuiParameters(String guiParameters){
        appendMlInfoMetadata(_IPYNB_METADATA_ML_INFO_GUI_PARAMETERS, guiParameters);

        return this;
    }

	/**
	 * Notebook의 guiParameters 반환
	 *
	 * @return guiParameters String
	 */
    public String getGuiParameters(){

        return _MlInfoMetadataJObject.getString(_IPYNB_METADATA_ML_INFO_GUI_PARAMETERS);
    }


	/**
	 * Notebook에 mlNotebookId 추가
	 *
	 * @param mlNotebookId String
	 */
    public CreateIpynbCode setMlNotebookId(String mlNotebookId){
        appendMlInfoMetadata(_IPYNB_METADATA_ML_INFO_NOTEBOOK_ID, mlNotebookId);

        return this;
    }

	/**
	 * Notebook의 mlNotebookId 반환
	 *
	 * @return mlNotebookId String
	 */
    public String getMlNotebookId(){

        String result = "";

        try{
            result =  _MlInfoMetadataJObject.getString(_IPYNB_METADATA_ML_INFO_NOTEBOOK_ID);
        }catch (org.json.JSONException e){
            result =  "";
        }

        return result;
    }


	/**
	 * Notebook에 cell 추가
	 *
	 * @param cellType String
	 * @param sources String
	 */
    public CreateIpynbCode append(String cellType, String sources){
        JSONObject cell = new JSONObject();
        JSONObject metadata = new JSONObject();

        cell.put("metadata", metadata);

        cell.put("cell_type", cellType);

        String[] sourceList = sources.split("(\r\n|\r|\n)");

        if(sourceList.length > 1){
            JSONArray sourceJArray = new JSONArray();

            for(String source : sourceList){
                sourceJArray.put(source + '\n');
            }

            cell.put("source", sourceJArray);

        }else{
            cell.put("source", sources);
        }

        cell.put("execution_count", 0);
        cell.put("outputs", new JSONArray());

        _IpynbCellsJArray.put(cell);

        return this;
    }


	/**
	 * Notebook의 기본적인 Json Data를 생성
	 *
	 * @return void
	 */
    private void setParentJson(){

        if(_Language.equals(_IPYNB_LANGUAGE_R)){
            _IpynbMetadataJObject = setParentRMetadataJson();
        }
        else if(_Language.equals(_IPYNB_LANGUAGE_PYTHON)){
            _IpynbMetadataJObject = setParentPythonMetadataJson();
        }

        _IpynbMetadataJObject.put("ml_info", _MlInfoMetadataJObject);

        _IpynbParentJObject.put("metadata", _IpynbMetadataJObject);

        _IpynbParentJObject.put("cells", _IpynbCellsJArray);
        _IpynbParentJObject.put("nbformat", 4);
        _IpynbParentJObject.put("nbformat_minor", 2);
    }


	/**
	 * Notebook의 프로그래밍 언어가 R일때 기본적인 Json Data를 생성
	 *
	 * @return JSONObject
	 */
    private JSONObject setParentRMetadataJson(){

        JSONObject metadata = new JSONObject();
        JSONObject metadata_kernelspec = new JSONObject();
        JSONObject metadata_languageInfo = new JSONObject();

        metadata_kernelspec.put("display_name", "R");
        metadata_kernelspec.put("language", "R");
        metadata_kernelspec.put("name", "ir");

        metadata_languageInfo.put("codemirror_mode", "r");
        metadata_languageInfo.put("file_extension", ".r");
        metadata_languageInfo.put("mimetype", "text/x-r-source");
        metadata_languageInfo.put("name", "R");
        metadata_languageInfo.put("pygments_lexer", "r");
        metadata_languageInfo.put("version", "3.4.1");


        metadata.put("kernelspec", metadata_kernelspec);
        metadata.put("language_info", metadata_languageInfo);

        return metadata;
    }

	/**
	 * Notebook의 프로그래밍 언어가 Python일때 기본적인 Json Data를 생성
	 *
	 * @return JSONObject
	 */
    private JSONObject setParentPythonMetadataJson(){

        JSONObject metadata = new JSONObject();
        JSONObject metadata_kernelspec = new JSONObject();
        JSONObject metadata_languageInfo = new JSONObject();
        JSONObject metadata_languageInfo_codemirror_mode = new JSONObject();

        metadata_kernelspec.put("display_name", "Python 3");
        metadata_kernelspec.put("language", "python");
        metadata_kernelspec.put("name", "python3");

        metadata_languageInfo_codemirror_mode.put("name","ipython");
        metadata_languageInfo_codemirror_mode.put("version","version");

        metadata_languageInfo.put("file_extension", ".py");
        metadata_languageInfo.put("mimetype", "text/x-python");
        metadata_languageInfo.put("name", "python");
        metadata_languageInfo.put("pygments_lexer", "ipython3");
        metadata_languageInfo.put("version", "3.6.5");
        metadata_languageInfo.put("codemirror_mode", metadata_languageInfo_codemirror_mode);


        metadata.put("kernelspec", metadata_kernelspec);
        metadata.put("language_info", metadata_languageInfo);

        return metadata;
    }

	/**
	 * 생성된 Notebook 코드를 문저열로 반환
	 *
	 * @return String
	 */
    @Override
    public String toString() {
        return _IpynbParentJObject.toString();
    }
}
