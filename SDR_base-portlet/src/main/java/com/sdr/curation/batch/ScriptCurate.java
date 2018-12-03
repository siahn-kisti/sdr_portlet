package com.sdr.curation.batch;

import com.sdr.curation.ErrorConst;
import com.sdr.file.FileConst;
import com.sdr.file.PropConst;
import org.json.JSONObject;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class ScriptCurate {

    public static void run(String _file_location, String _meta_location, String _batch_location, long ppLogicId, Integer[] errCode) {
        ArrayList<Long> ppList = new ArrayList<>();
        getPPList(ppLogicId, ppList);
        System.out.println("PPList : " + ppList );

        for (int i=0; i<ppList.size(); i++) {
            int type = getPPType(ppList.get(i)) ;
            System.out.println("pp Type : " + type );

            copyMetadata(_meta_location, errCode);
            switch ( type ) {
                case FileConst.PP_TYPE_SIMPLE:
                    String script = readContentFromSimple(ppList.get(i));
                    if (script !=null) RunInterpreter.run(_file_location, _meta_location, _batch_location, script, errCode);
                    break;
                case FileConst.PP_TYPE_CONTAINER:
                    String image = readImageNameFromContainer(ppList.get(i));
                    if (image !=null) RunContainer.run(_file_location, _meta_location, _batch_location, image, errCode);
                    break;
                case FileConst.PP_TYPE_COMPOSITION:
                default:
                    break;
            }

            System.out.println("ErrCode in ScriptCurate.run() : " + errCode[0]);

            if (errCode[0] != ErrorConst._OK) break;
            mergeMetadata(_meta_location, errCode);
        }

        if (errCode[0] == ErrorConst._OK) {
            try {
                String successFile = FileConst.getSubPath(_meta_location, FileConst.LOC_LOG) + File.separator + FileConst._LOG_FILE_SUCCESS;
                System.out.println("out path : " + successFile);
                FileWriter fw = new FileWriter(successFile);
                fw.write("success");
                fw.close();
            } catch (IOException e ) {
                errCode[0] = ErrorConst._ERROR_IO_EXCEPTION;
            }
        }
    }

    private static void copyMetadata(String _meta_location, Integer[] errCode) {
        File srcDir = new File(FileConst.getSubPath(_meta_location, FileConst.LOC_METADATA) + File.separator + FileConst._META_FILE_MD);
        if (!srcDir.exists()) return;

        File destDir = new File(FileConst.getSubPath(_meta_location, FileConst.LOC_METADATA) + File.separator + FileConst._META_FILE_MD_OLD);
        FileConst.cleanFile(destDir.toString());
        srcDir.renameTo(destDir);
    }


    private static void mergeMetadata(String _meta_location, Integer[] errCode) {
        JSONObject newJson = new JSONObject();

        try {
            String metadataPath = FileConst.getSubPath(_meta_location, FileConst.LOC_METADATA) + File.separator + FileConst._META_FILE_MD_OLD;
            String metadata = readStringFromFile(metadataPath);
            if ((metadata != null) && (metadata.length() != 0)) {
                JSONObject jsonObject = new JSONObject(metadata);
                for (String key : jsonObject.keySet()) {
                    newJson.put(key, jsonObject.get(key));
                }
            }
        } catch ( IOException e) {
            // errCode[0] = ErrorConst._ERROR_IO_EXCEPTION;
        }


        try {
            String metadataPath = FileConst.getSubPath(_meta_location, FileConst.LOC_METADATA) + File.separator + FileConst._META_FILE_MD;
            String metadata = readStringFromFile(metadataPath);
            if ((metadata != null) && (metadata.length() != 0)) {
                JSONObject jsonObject = new JSONObject(metadata);
                for (String key : jsonObject.keySet()) {
                    newJson.put(key, jsonObject.get(key));
                }
            }
        } catch ( IOException e) {
            // errCode[0] = ErrorConst._ERROR_IO_EXCEPTION;
        }

        try {
            String metadataPath = FileConst.getSubPath(_meta_location, FileConst.LOC_METADATA) + File.separator + FileConst._META_FILE_MD;
            if ( newJson.length() > 0) {
                FileWriter fw = new FileWriter(metadataPath);
                fw.write(newJson.toString());
                fw.close();
            }
        } catch ( IOException e) {
        	e.printStackTrace();
            errCode[0] = ErrorConst._ERROR_IO_EXCEPTION;
        }
    }







    public static String getRootPath() {
        String path = ( BatchCurate.isRemote() ) ? PropConst.getProp("dataset.remote.location") : PropConst.getProp("dataset.location");
        return path;
    }


    private static void getPPList(long ppId, ArrayList<Long> list) {
        int type = getPPType(ppId);
        switch ( type ) {
            case FileConst.PP_TYPE_SIMPLE:
            case FileConst.PP_TYPE_CONTAINER:
                for(int i=0; i<list.size(); i++)
                    if (list.get(i) == ppId) return;
                list.add(ppId);
                break;
            case FileConst.PP_TYPE_COMPOSITION:
                ArrayList<Long> _tmp_list = readListFromComposition(ppId);
                if (_tmp_list != null) {
                    for (int i = 0; i < _tmp_list.size(); i++) {
                        getPPList(_tmp_list.get(i), list);
                    }
                }
                break;
            default:
                break;
        }
    }

    private static ArrayList<Long> readListFromComposition(long ppId) {
        String ppFileName = FileConst.getSubPath(getRootPath(), FileConst.LOC_TYPE_PP) + File.separator + ppId + ".logic";
        ArrayList<Long> list = new ArrayList<>();

        try {
            FileReader _file = new FileReader(ppFileName);
            BufferedReader reader = new BufferedReader(_file);

            String firstLine = reader.readLine();
            String _line = null;
            while ( (_line = reader.readLine()) != null ) {
                long subPPid = Long.parseLong(_line);
                if (subPPid != 0) list.add(subPPid);
            }
            return list;
        } catch (IOException e) {
            return null;
        }
    }

    private static int getPPType(long ppId) {
        String ppFileName = FileConst.getSubPath(getRootPath(), FileConst.LOC_TYPE_PP) + File.separator + ppId + ".logic";
        BufferedReader reader = null;
        try {
            FileReader _file = new FileReader(ppFileName);
            reader = new BufferedReader(_file);
            String firstLine = reader.readLine();
            if (reader !=null) reader.close();;

            if (firstLine.contains("#SIMP")) {
                return FileConst.PP_TYPE_SIMPLE;
            } else if (firstLine.contains("#CONT")) {
                return FileConst.PP_TYPE_CONTAINER;
            } else if (firstLine.contains("#COMP")) {
                return FileConst.PP_TYPE_COMPOSITION;
            } else {
                return FileConst.PP_TYPE_UNKNOWN;
            }
        } catch (IOException e) {
            return FileConst.PP_TYPE_UNKNOWN;
        }
    }

    public static String readImageNameFromContainer(long ppId) {
        String ppFileName = FileConst.getSubPath(getRootPath(), FileConst.LOC_TYPE_PP) + File.separator + ppId + ".logic";
        BufferedReader reader = null;

        try {
            FileReader _file = new FileReader(ppFileName);
            reader = new BufferedReader(_file);
            String firstLine = reader.readLine();
            String secondLine = reader.readLine();
            secondLine = secondLine.trim();
            if (reader !=null) reader.close();;
            return secondLine;
        } catch (IOException e) {
            return null;
        }
    }

    public static String readContentFromSimple(long ppId) {
        String ppFileName = FileConst.getSubPath(getRootPath(), FileConst.LOC_TYPE_PP) + File.separator + ppId + ".logic";

        try {
            String result = readStringFromFile(ppFileName);
            if (result.length() == 0) {
                return null;
            } else {
                return result;
            }
        } catch (IOException e) {
            return null;
        }
    }


    public static String readStringFromFile(String filePath) throws IOException {
        String fileContent = new String(Files.readAllBytes(Paths.get(filePath)));
        return fileContent;
    }

}
