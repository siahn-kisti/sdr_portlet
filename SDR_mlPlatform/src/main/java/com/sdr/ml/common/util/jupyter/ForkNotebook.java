package com.sdr.ml.common.util.jupyter;

import com.sdr.metadata.model.Dataset;
import com.sdr.ml.common.util.FileUtils;
import com.sdr.ml.common.util.MlStringUtils;

import java.io.File;
import java.io.IOException;

public class ForkNotebook {

    private File _SaveDirectory;
    private Dataset _Dataset;
    private String _UserId;

	/**
	 * CreateIpynbCode 생성자
	 *
	 * @param userId String
	 * @param dataset  the Dataset
	 * @param saveDirectory  File
	 */
    public ForkNotebook(String userId, Dataset dataset, File saveDirectory) {
        _UserId = userId;
        _Dataset = dataset;
        _SaveDirectory = saveDirectory;
    }

	/**
	 * ipynb notebook에서 사용할 데이터 파일 개인 저장소로 복사
	 *
	 * @return boolean
	 *
	 */
    public boolean forkDataset(){
        boolean result = false;
        File targetDatasetFile = new File(_Dataset.getMetalocation() + File.separator + MlStringUtils._NAME_ML_SUBMISSION_INPUT_CSV);

        FileUtils.MakeDir(_SaveDirectory);

        try {
            FileUtils.copyFile(targetDatasetFile, _SaveDirectory, MlStringUtils._NAME_ML_SUBMISSION_INPUT_CSV, true);
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

	/**
	 * 생성된 ipynb notebook 파일 개인 저장소로 복사
	 *
	 * @return boolean
	 *
	 */
    public boolean forkNotebook(){
        boolean result = false;
        File targetNotebookFile = new File(_Dataset.getMetalocation() + File.separator + MlStringUtils.getNotebookCodeFileName(_UserId));

        FileUtils.MakeDir(_SaveDirectory);

        try {
            FileUtils.copyFile(targetNotebookFile, _SaveDirectory, MlStringUtils._NAME_NOTEBOOK_IPYNB_FILE, true );
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

	/**
	 * 다른 사용자가 생성한 ipynb notebook 파일 개인 저장소로 복사
	 * @param notebookFileName  String
	 *
	 * @return boolean
	 *
	 */
	public boolean forkNotebook(String notebookFileName){
		// 생성된 ipynb notebook 파일 개인 저장소로 복사
		boolean result = false;
		File targetNotebookFile = new File(_Dataset.getMetalocation() + File.separator + notebookFileName);

		FileUtils.MakeDir(_SaveDirectory);

		try {
			FileUtils.copyFile(targetNotebookFile, _SaveDirectory, MlStringUtils._NAME_NOTEBOOK_IPYNB_FILE, true );
			result = true;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return result;
	}
}
