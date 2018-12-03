package com.sdr.rest.servlet;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

import java.io.File;
import java.io.IOException;

public class FileService {
	
	private static Log _log = LogFactoryUtil.getLog(FileService.class);

	//TODO: com.sdr.submission.service.FileService copy...
	//SDR_base-service 로 통합 검토..


	//----------------------------------------------------------------------------------------------------
	// Compress
	//----------------------------------------------------------------------------------------------------
	public static String zip(String zipFolder, String zipFile) {
		try {
			ZipFile zipfile = new ZipFile(zipFile);
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
	public static void unzip(File file, String destPath) {
		try {
			ZipFile zipFile = new ZipFile(file);
			zipFile.extractAll(destPath);
		} catch (ZipException e) {
			e.printStackTrace();
		}
	}


	//----------------------------------------------------------------------------------------------------
	// test
	//----------------------------------------------------------------------------------------------------
	public static void main(String[] args) throws IOException {
//		zip();
		unzip();
//		csv();
	}

	public static void zip() throws IOException{
		String zipFolder = "/Users/heesangbb/Desktop/uploadtest/study1111";
		String zipFile = "/Users/heesangbb/Desktop/uploadtest/test.zip";

		String zipFileName = FileService.zip(zipFolder, zipFile);

		System.out.println("zipFileName = "+zipFileName);
	}

	public static void unzip() throws IOException{
		String filePath = "/Users/heesangbb/Desktop/uploadtest/error/Li2O.zip";
		String destDir = "/Users/heesangbb/Desktop/uploadtest/error/unzip/";

		FileService.unzip(new File(filePath), destDir);

		System.out.println("destDir = "+destDir);
	}

}
