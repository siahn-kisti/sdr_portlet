package com.sdr.curation.batch;

import com.sdr.curation.ErrorConst;
import com.sdr.file.FileConst;
import com.sdr.file.PropConst;

import java.io.*;
import java.util.*;

public class BatchRetrieve {
    String fileLocation;
    List<BatchJob> batchLists;
    String token = null;
    int signature= 0;

    public BatchRetrieve(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public static Map<String,String> readBatchInfoFile(String _location) {
        if ( _location == null ) return null;

        String batchInfoFileName = FileConst.getSubPath(_location, FileConst.LOC_BATCH_INFO);
        File batchInfoFile = new File(batchInfoFileName);
        if(! batchInfoFile.exists()) {
            System.err.println("batch.info file does not exists : " + batchInfoFileName );
            return null;
        }

        Map<String,String> bInfo = new HashMap<String,String>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(batchInfoFileName));
            String s;

            while ((s = in.readLine()) != null) {
                String words[] = s.split(":");
                if (words.length != 2) {
                    System.err.println("???? : " + words );
                    continue;
                }

                bInfo.put(words[0].trim(), words[1].trim());
            }
            if (BatchCurate._debug) System.out.println("parsed batchInfo :: " + bInfo );
            in.close();
        } catch ( IOException e ) {
            // makeErrLog("IO Exception : " + fileLocation );
            System.out.println("IO Exception : " + _location );
            return null;
        }
        return bInfo;
    }


    public static boolean writeBatchInfoFile (String _location, Map<String,String> bInfo) {
        if ( _location == null ) return false;
        String batchInfoFileName = FileConst.getSubPath(_location, FileConst.LOC_BATCH_INFO);

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(batchInfoFileName));
            Iterator<String> iterator = bInfo.keySet().iterator();
            while (iterator.hasNext()) {
                String key = (String) iterator.next();
                writer.write("" +key+ ":"
                        + bInfo.get(key)
                        + System.lineSeparator() );
            }
            writer.close();
        } catch ( IOException e ) {
            e.printStackTrace();
            System.err.println("IO Exception in Feedback");
            return false;
        }
        return true;
    }

    public void retrieve(){
        Map<String,String> bInfo = readBatchInfoFile(fileLocation) ;
        PropConst.setPropFromBInfo(bInfo);

        if ( bInfo.containsKey("token")) {
            token = bInfo.get("token");
        } else {
            token = null;
        }

        if ( bInfo.containsKey("signature")) {
            signature = Integer.parseInt(bInfo.get("signature"));
        }

        batchLists = BatchCurate.readDatasetListFile(fileLocation, FileConst.LOC_DATASET_LIST);
        if(batchLists == null) {
            System.out.println("File read Error : " + fileLocation );
            return;
        }

        batch();
        BatchCurate.writeDatasetListFile(fileLocation, batchLists, FileConst.LOC_FEEDBACK_LIST);
    }


    public void batch() {
        for (int i=0; i< batchLists.size(); i++) {
            if ( batchLists.get(i).getErrCode() != ErrorConst._OK ) continue;

            if ( batchLists.get(i).getRepo() == FileConst.IMPORT_FROM_FTP ) continue;

            if ( (token==null) || (token.length() == 0) ) {
                batchLists.get(i).setErrCode( ErrorConst._ERROR_TOKEN );
            }

            String tmpPath = fileLocation + File.separator + "tmp";
            String rootPath = ( BatchCurate.isRemote() ) ? PropConst.getProp("dataset.remote.location") : PropConst.getProp("dataset.location");
            String destPath = FileConst.getTempDatasetPath(rootPath, batchLists.get(i).getDatasetId(), signature);

            String jobId = batchLists.get(i).getLocation();
            batchLists.get(i).setLocation(destPath);

            // TODO : Generalize
            if ( BatchCurate.isRemote() ) {
                String _root = PropConst.getProp("dataset.location");
                String _remote_root = PropConst.getProp("dataset.remote.location");
                if ( ( _root != null) && ( _root.length() > 0)
                        && ( _remote_root != null) && ( _remote_root.length() > 0) ) {
                    tmpPath = tmpPath.replaceFirst(_root, _remote_root);
                    destPath = destPath.replaceFirst(_root, _remote_root);
                }
            }

            Integer[] errCode = { 0 };
            EDISONUtil.getEdisonFiles(token, tmpPath, destPath, jobId, errCode);

            if (errCode[0] != ErrorConst._OK) {
                batchLists.get(i).setErrCode( errCode[0] );
                if (BatchCurate._debug) System.out.println("Error in Retrieval :: " + errCode[0] );
            }
        }
    }

    public static void main(String args[]) {
        if (args.length < 1) {
            System.out.println("Usage : java BatchRetrieve <path>");
            return;
        }

        BatchRetrieve br = new BatchRetrieve(args[0]);
        BatchCurate.setRemote(true);
        br.retrieve();
    }
}
