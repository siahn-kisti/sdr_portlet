package com.sdr.ml.common.util;

import com.sdr.ml.common.util.MlFileUtils;

import java.io.File;

public class WatingForFileUtils {

	/**
	 * 파일들이 생성되는 시점을 기다리는 함수
	 *
	 * @param timeoutSecond  integer
	 * @param location String
	 * @param fileNames String[]
	 */
	public String doWait(int timeoutSecond, String location, String[] fileNames){
		String result = "";

		try {
			for(int i=0; i<timeoutSecond; i++) {

				Thread.sleep(1000);

				for(String fileName : fileNames){
					String successLogFilePath = location + File.separator + fileName;

					if (MlFileUtils.isFileExist(successLogFilePath)) {
						result = fileName;

						return result;
					}
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**
	 * 파일이 생성되는 시점을 기다리는 함수
	 *
	 * @param timeoutSecond  integer
	 * @param location String
	 * @param fileName String
	 */
	public String doWait(int timeoutSecond, String location, String fileName){
		return doWait(timeoutSecond, location, new String[]{fileName});
	}
}
