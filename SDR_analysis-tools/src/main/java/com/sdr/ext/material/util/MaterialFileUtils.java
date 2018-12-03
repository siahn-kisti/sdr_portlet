package com.sdr.ext.material.util;

import java.io.*;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.portlet.ResourceResponse;

import org.apache.commons.io.FileUtils;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upload.UploadRequest;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.util.PortalUtil;

/**
 * @FileName : FileUtil.java
 * @Project : SDR_analysis-tools
 * @Date : 2017. 7. 18.
 * @작성자 : devsky
 * @변경이력 :
 * @프로그램 설명 : 파일 관련 클래스
 */
public class MaterialFileUtils {

	private static Log log = LogFactoryUtil.getLog(MaterialFileUtils.class);

	private static String fileRealPath = null;

	/**
	 * @Methods Name : multiFileCopy
	 * @작성일 : 2017. 7. 11.
	 * @작성자 : devsky
	 * @변경이력 :
	 * @Method 설명 : 폴더 단위로 복사시키기
	 */
	public static boolean multiFileCopy(String beforePath, String afterPath) {

		// 이전 temp 파일 삭제
		multiFileDelete(afterPath);

		boolean success = true;

		// 해당 디렉토리의 존재여부를 확인
		mkdirs(afterPath);

		// 이동전의 폴더에 있는 파일들을 읽는다.
		List<File> dirList = getDirFileList(beforePath);

		// 폴더의 사이즈만큼 돌면서 파일을 이동시킨다.
		for (int i = 0; i < dirList.size(); i++) {
			// i번째 저장되어 있는 파일을 불러온다.
			String fileName = dirList.get(i).getName();

			// 파일 복사을 원한다면
			try {
				fileCopy(beforePath + File.separator + fileName, afterPath + File.separator + fileName);
			} catch (IOException e) {
				System.err.println("### FileUtil : 파일 복사 에러 : " + e.getMessage());
				success = false;
			}
		}

		return success;
	}

	/**
	 * @Methods Name : multiFileMove
	 * @작성일 : 2017. 7. 11.
	 * @작성자 : devsky
	 * @변경이력 :
	 * @Method 설명 : 폴더 단위로 이동시키기
	 */
	public static boolean multiFileMove(String beforePath, String afterPath) {

		// 이전 temp 파일 삭제
		multiFileDelete(afterPath);

		boolean success = true;

		// 해당 디렉토리의 존재여부를 확인
		mkdirs(afterPath);

		// 이동전의 폴더에 있는 파일들을 읽는다.
		List<File> dirList = getDirFileList(beforePath);

		// 폴더의 사이즈만큼 돌면서 파일을 이동시킨다.
		for (int i = 0; i < dirList.size(); i++) {
			// i번째 저장되어 있는 파일을 불러온다.
			String fileName = dirList.get(i).getName();

			// 파일 이동을 원한다면
			try {
				fileMove(beforePath + File.separator + fileName, afterPath + File.separator + fileName);
			} catch (IOException e) {
				System.err.println("### FileUtil : 파일 이동 에러 : " + e.getMessage());
				success = false;
			}

		}

		return success;
	}

	/**
	 * @Methods Name : multiFileDelete
	 * @작성일 : 2017. 7. 11.
	 * @작성자 : devsky
	 * @변경이력 :
	 * @Method 설명 : 폴더 단위로 삭제하기
	 */
	public static boolean multiFileDelete(String deletePath) {
		boolean success = true;

		// 해당 디렉토리의 존재여부를 확인
		File dir = new File(deletePath);
		if (dir.exists()) {

			// 폴더에 있는 파일들을 읽는다.
			List<File> dirList = getDirFileList(deletePath);

			// 폴더의 사이즈만큼 돌면서 파일을 삭제시킨다.
			for (int i = 0; i < dirList.size(); i++) {
				// i번째 저장되어 있는 파일을 불러온다.
				String fileName = dirList.get(i).getName();

				fileDelete(deletePath + File.separator + fileName);
			}
		}

		return success;
	}

	// 파일을 존재여부를 확인하는 메소드
	public static Boolean fileIsLive(String isLivefile) {
		File f1 = new File(isLivefile);

		if (f1.exists()) {
			return true;
		} else {
			return false;
		}
	}

	// 파일을 생성하는 메소드
	public static void fileMake(String makeFileName) {
		File f1 = new File(makeFileName);
		try {
			f1.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 파일을 삭제하는 메소드
	public static void fileDelete(String deleteFileName) {
		File I = new File(deleteFileName);
		I.delete();
	}

	// 특정 시간이 지난 Temp 파일 삭제
	public static boolean deleteFilesOlderThan24Hours(File path, int hour) {
		if (!path.exists()) {
			return false;
		}
		File[] files = path.listFiles();
		for (File file : files) {

			Date modifiedDate = new Date(file.lastModified());
			Date currentDate = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(currentDate);
			cal.add(Calendar.HOUR, hour);
			Date deleteDate = cal.getTime();

			// 특정 시간이 지난 Temp 파일 삭제
			if (modifiedDate.before(deleteDate)) {
				if (file.isDirectory()) {
					deleteFilesOlderThan24Hours(file, hour);
				} else {
					file.delete();
				}
			}
		}
		return path.delete();
	}

	// FileChannel을 이용한 파일을 복사하는 메소드
	public static void fileCopy(String inFileName, String outFileName) throws IOException {
		FileInputStream fis = new FileInputStream(inFileName);
		FileOutputStream fos = new FileOutputStream(outFileName);

		FileChannel fcin = fis.getChannel();
		FileChannel fcout = fos.getChannel();

		long size = fcin.size();
		fcin.transferTo(0, size, fcout);

		fcout.close();
		fcin.close();

		fos.close();
		fis.close();
	}

	// FileChannel을 이용한 파일을 이동하는 메소드
	public static void fileMove(String inFileName, String outFileName) throws IOException {
		FileInputStream fis = new FileInputStream(inFileName);
		FileOutputStream fos = new FileOutputStream(outFileName);

		FileChannel fcin = fis.getChannel();
		FileChannel fcout = fos.getChannel();

		long size = fcin.size();
		fcin.transferTo(0, size, fcout);

		fcout.close();
		fcin.close();

		fos.close();
		fis.close();

		// 복사한뒤 원본파일을 삭제함
		fileDelete(inFileName);
	}

	// 디렉토리의 파일 리스트를 읽는 메소드
	public static List<File> getDirFileList(String dirPath) {
		// 디렉토리 파일 리스트
		List<File> dirFileList = null;

		// 파일 목록을 요청한 디렉토리를 가지고 파일 객체를 생성함
		File dir = new File(dirPath);

		// 디렉토리가 존재한다면
		if (dir.exists()) {
			// 파일 목록을 구함
			File[] files = dir.listFiles();

			// 파일 배열을 파일 리스트로 변화함
			dirFileList = Arrays.asList(files);
		}

		return dirFileList;
	}

	// 파일 다운로드 메소드
	public static void outputStream(String fileName, String filePath, ResourceResponse resourceResponse) throws IOException, FileNotFoundException {
		File downloadFile = new File(filePath);
		byte[] downloadFileByte = new byte[(int) downloadFile.length()];
		FileInputStream fileInputStream = new FileInputStream(downloadFile);
		fileInputStream.read(downloadFileByte);
		// Writing file to output
		resourceResponse.setContentType("application/xml");
		resourceResponse.addProperty("Content-disposition", "attachment; filename=" + fileName);
		OutputStream out = resourceResponse.getPortletOutputStream();
		out.write(downloadFileByte);
		out.flush();
		out.close();
	}

	// 파일 유효성 검사 메소드
	public static boolean validateFileParamNotEmpty(UploadRequest request, String paramName) throws Exception {
		boolean validate = true;

		// 1kB 미만의 바이너리 컨텐츠를로드 할 필요가 없습니다 (이들은 기본적으로 디스크에 기록되지 않고 메모리에만 기록되므로), 검증 목적으로 메모리에 저장할 수 있습니다
		boolean forceWriteUploadedFileToDisc = false;

		File file = request.getFile(paramName, forceWriteUploadedFileToDisc);

		Long fileSize = request.getSize(paramName);

		if (file == null || fileSize == null || fileSize <= 0) {
			long companyId = PortalUtil.getCompanyId(request);

			// TODO 라이프레이 파일 업로드 첨부파일 제한 추가 예정
			String maxUploadFileSize = FileUtils.byteCountToDisplaySize(PrefsPropsUtil.getLong(companyId, PropsKeys.UPLOAD_SERVLET_REQUEST_IMPL_MAX_SIZE));

			validate = false;
		}

		return validate;
	}

	/**
	 * @Methods Name : dirFileSearch
	 * @작성일 : 2017. 7. 20.
	 * @작성자 : devsky
	 * @변경이력 :
	 * @Method 설명 : 서브 디렉토리 파일 탐색
	 */
	public static String dirFileSearch(String directory, String fileName) {

		fileRealPath = null;

		File dir = new File(directory);
		File[] fileList = dir.listFiles();
		try {
			for (int i = 0; i < fileList.length; i++) {
				File file = fileList[i];
				if (file.isFile()) {
					if (file.getName().equals(fileName)) {
						fileRealPath = file.getAbsolutePath();
						break;
					}
				} else if (file.isDirectory()) {
					// 서브디렉토리가 존재하면 재귀적 방법으로 다시 탐색
					dirFileSearch(file.getCanonicalPath().toString(), fileName);
				}
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}

		return fileRealPath;
	}

	/**
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

	/**
	 * @Methods Name : writeFile
	 * @작성일 : 2017. 8. 21.
	 * @작성자 : devsky
	 * @변경이력 :
	 * @Method 설명 : 문자열을 지정하여 파일 생성
	 */
	public static void writeFile(String string, String fileFullPath) {
		try {
			File file = new File(fileFullPath);
			FileWriter fw;
			fw = new FileWriter(file, false);
			fw.write(string);
			fw.close();
		} catch (Exception e) {
			log.error("Problem writing file.");
		}
	}

	/**
	 * @Methods Name : jsonToArrayFile
	 * @작성일 : 2017. 8. 21.
	 * @작성자 : devsky
	 * @변경이력 :
	 * @Method 설명 : 파이썬에서 생성한 Dictionaly 타입 문자열을 json array 타입으로 변환하기 위한 대괄호 추가
	 */
	public static void jsonToArrayFile(String fileFullPath) {
		try {
			// input the file content to the StringBuffer "input"
			BufferedReader file = new BufferedReader(new FileReader(fileFullPath));
			String line;
			StringBuffer inputBuffer = new StringBuffer();

			while ((line = file.readLine()) != null) {
				inputBuffer.append(line);
				inputBuffer.append('\n');
			}
			String inputStr = inputBuffer.toString();
			log.debug("######BEFORE inputStr :::::::::" + inputStr);
			file.close();

			if (!inputStr.replace("\n", "").equals("[]")) {
				inputStr = "[" + inputStr + "]";
			}

			// write the new String with the replaced line OVER the same file
			FileOutputStream fileOut = new FileOutputStream(fileFullPath);
			fileOut.write(inputStr.getBytes());
			fileOut.close();
			log.debug("######AFTER inputStr :::::::::" + inputStr);

		} catch (Exception e) {
			log.error("Problem reading file.");
		}
	}

	/**
	 * @Methods Name : replaceFileText
	 * @작성일 : 2017. 8. 21.
	 * @작성자 : devsky
	 * @변경이력 :
	 * @Method 설명 : 파일 내용 수정
	 */
	public static void replaceFileText(String targetText, String replaceText, String fileFullPath) {
		try {
			// input the file content to the StringBuffer "input"
			BufferedReader file = new BufferedReader(new FileReader(fileFullPath));
			String line;
			StringBuffer inputBuffer = new StringBuffer();

			while ((line = file.readLine()) != null) {
				inputBuffer.append(line);
				inputBuffer.append('\n');
			}
			String inputStr = inputBuffer.toString();

			file.close();

			inputStr = inputStr.replace(replaceText, replaceText);

			// write the new String with the replaced line OVER the same file
			FileOutputStream fileOut = new FileOutputStream(fileFullPath);
			fileOut.write(inputStr.getBytes());
			fileOut.close();

		} catch (Exception e) {
			log.error("Problem reading file.");
		}
	}
}
