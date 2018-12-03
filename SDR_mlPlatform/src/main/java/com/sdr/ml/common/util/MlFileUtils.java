package com.sdr.ml.common.util;

import com.liferay.portal.kernel.util.FileUtil;

import java.io.*;
import java.util.Scanner;

public class MlFileUtils {

    public static boolean isFileExist(String filePath){

        File file = new File(filePath);
        boolean result = false;
        if (file.exists()) {
            result = true;
        }

        return  result;
    }

    public static boolean fileMove(File tartgetFile, File targetDir, String saveFileName){

        boolean result = false;

        if(tartgetFile.exists()){
            FileUtil.move(tartgetFile.getAbsolutePath(), targetDir.getAbsolutePath() + "/" + saveFileName);
            result = true;
        }

        return result;
    }

    // Java IO Stream buffering Copy
    public static void fileCopy(String source, String dest) {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(source);
            fos = new FileOutputStream(dest);

            byte[] buf = new byte[1024];
            int read;
            while((read = fis.read(buf)) != -1) {
                fos.write(buf, 0, read);
            }

            fis.close();
            fos.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fis != null){
                    fis.close();
                }
                if(fos != null){
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    public static String fileRead(File tartgetFile){
        Scanner scan = null;
        StringBuilder fileText = new StringBuilder();

        try {
            scan = new Scanner(tartgetFile);

            while (scan.hasNextLine()) {
                fileText.append(scan.nextLine());
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return fileText.toString();
    }

    public static boolean fileWrite(String savePath, String saveName, String writeText){

        boolean result = false;
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(savePath + "/" + saveName);
            fileWriter.write(writeText);
            fileWriter.flush();
            fileWriter.close();

            result = true;
        } catch (IOException e) {
            e.printStackTrace();

            result = false;
        }

        return result;
    }

}
