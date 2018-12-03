package com.sdr.ml.common.util;

import java.io.*;
import java.nio.file.CopyOption;
import java.nio.file.Files;

public class FileUtils {


    public static void MakeDir(File dirFile) {
        if (!dirFile.exists())
            dirFile.mkdirs();
    }

    public static String getExtension(File file) {
        String ext = "";

        String fileName = file.getName();

        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            ext = fileName.substring(fileName.lastIndexOf(".") + 1);
        } else {
            ext = "";
        }

        return ext;
    }

    public static void moveFile(File oriFile, File targetDirectory, String saveName) throws IOException {

        FileInputStream fis = null;
        FileOutputStream fos = null;
        File fileToMove = new File(targetDirectory.getAbsolutePath() + File.separator + saveName);

        if (!fileToMove.exists()) {
            fis = new FileInputStream(oriFile);
            fos = new FileOutputStream(fileToMove);

            int data = 0;
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }
            fis.close();
            fos.close();
        }
    }

    public static void copyFile(File theFile, File targetDirectory, String saveName, boolean overwrite) throws IOException {
        File fileToMove = new File(targetDirectory.getAbsolutePath() + File.separator + saveName);

        System.out.println(fileToMove.getAbsolutePath() + "||" + fileToMove.getName());
        System.out.println(theFile.getAbsolutePath() + "||" + theFile.getName());

        if(overwrite && fileToMove.exists()){
            fileToMove.delete();
        }

        Files.copy(theFile.toPath(), fileToMove.toPath());
    }

}
