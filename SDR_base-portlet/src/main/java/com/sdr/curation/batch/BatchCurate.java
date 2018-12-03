package com.sdr.curation.batch;

import com.sdr.curation.ErrorConst;
import com.sdr.file.FileConst;
import com.sdr.file.PropConst;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


public class BatchCurate {

    String fileLocation;
    List<BatchJob> batchLists;
    static boolean remote = false;
    public static boolean _debug = true;


    public static final int STEP_IN_RETRIEVAL= 1;
    public static final int STEP_IN_CURATION = 2;

    public BatchCurate(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public void setFileLocation(String _loc) { fileLocation = _loc ; }

    public static void setRemote(boolean _remote) { remote = _remote; }
    public static boolean isRemote() { return remote; }

    public static List<BatchJob> readDatasetListFile(String _location, int fileType) {
        if ( _location == null ) return null;
        String datasetListFileName = FileConst.getSubPath(_location, fileType);
        File datasetListFile = new File(datasetListFileName);

        if(! datasetListFile.exists()) {
            // makeErrLog("Not existing datasetListFile : " + datasetListFileName );
            System.err.println("Not existing datasetListFile : " + datasetListFileName );
            return null;
        }

        List<BatchJob> bjList = new ArrayList<>();
        try {
            BufferedReader in = new BufferedReader(new FileReader(datasetListFileName));
            String s;

            while ((s = in.readLine()) != null) {
                String words[] = s.split(",");
                if (words.length != 7) {
                    if (BatchCurate._debug) System.out.println("???? : " + words );
                    continue;
                }
                BatchJob bj = new BatchJob();
                bj.setDatasetId(Long.parseLong(words[0].trim()));
                bj.setPpId(Long.parseLong(words[1].trim()));
                bj.setErrCode(Integer.parseInt(words[2].trim()));

                // replace location from local to remote
                String fileLocation = words[3].trim();
                String metaLocation = words[4].trim();
                String _root = PropConst.getProp("dataset.location");
                String _remote_root = PropConst.getProp("dataset.remote.location");
                if ( ( _root != null) && ( _root.length() > 0) && ( _remote_root != null) && ( _remote_root.length() > 0) ) {
                    if ( BatchCurate.isRemote() ) {
                        fileLocation = fileLocation.replaceFirst(_root, _remote_root);
                        metaLocation = metaLocation.replaceFirst(_root, _remote_root);
                    } else {
                        fileLocation = fileLocation.replaceFirst(_remote_root, _root);
                        metaLocation = metaLocation.replaceFirst(_remote_root, _root);
                    }
                }

                bj.setLocation(fileLocation);
                bj.setMetaLocation(metaLocation);
                bj.setRepo(Integer.parseInt(words[5].trim()));
                bj.setCurationRequired(Boolean.parseBoolean(words[6].trim()));
                bjList.add(bj);
                // System.out.println("parsed batchJob :: " + bj );
            }

            in.close();
        } catch ( IOException e ) {
            // makeErrLog("IO Exception : " + fileLocation );
            System.out.println("IO Exception : " + _location );
            return null;
        }
        return bjList;
    }


    public static boolean writeDatasetListFile(String _location, List<BatchJob> bjList, int fileType) {
        String feedbackFile = FileConst.getSubPath(_location, fileType );

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(feedbackFile));
            for (int i=0; i< bjList.size(); i++) {
                writer.write("" + bjList.get(i).getDatasetId() + ","
                        + bjList.get(i).getPpId() + ","
                        + bjList.get(i).getErrCode() + ","
                        + bjList.get(i).getLocation() + ","
                        + bjList.get(i).getMetaLocation() + ","
                        + bjList.get(i).getRepo() + ","
                        + bjList.get(i).isCurateionRquired()
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

    public static boolean writeLogFile(String _location, String errMessage) {
        if (_location == null || _location.length() == 0 ) return false;
        String file = FileConst.getSubPath(_location, FileConst.LOC_HISTORY_LOG );

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            writer.write("" + new Date() + ":"
                        + errMessage
                        + System.lineSeparator() );
            writer.close();
        } catch ( IOException e ) {
            e.printStackTrace();
            System.err.println("IO Exception in Feedback");
            return false;
        }
        return true;
    }



    public static void checkError(BatchJob bj, String batchLocation) {

        String location = bj.getMetaLocation();

        File tmpFolder = new File(FileConst.getSubPath(location, FileConst.LOC_SUCCESS_LOG));
        if (! tmpFolder.exists()) {
            bj.setErrCode(ErrorConst._ERROR_PREPROCESSING);
            //System.err.println("Success file does not exist in "  + tmpFolder.getPath());
            writeLogFile(batchLocation, "Success file does not exist in "  + tmpFolder.getPath());
            return;
        }

        tmpFolder = new File(FileConst.getSubPath(location, FileConst.LOC_ERROR_LOG));
        if (tmpFolder.exists()) {
            bj.setErrCode(ErrorConst._ERROR_PREPROCESSING);
            writeLogFile(batchLocation, "Error file does exist in "  + tmpFolder.getPath());
            //System.err.println("Error file does exist in "  + tmpFolder.getPath());
        }
        writeLogFile(batchLocation, "No Error found : " + location);
    }


    public static String makeTmpLocation(String _location, long id) {
        String batchLocation = _location + File.separator + id;
        makeTmpLocation(batchLocation);
        return batchLocation;
    }

    public static void makeTmpLocation(String _location) {
        File tmpFolder = new File(_location);
        if (!tmpFolder.exists()) tmpFolder.mkdirs();
        //chmod775(batchLocation);

        String tmpLocation = FileConst.getSubPath(_location, FileConst.LOC_METADATA);
        tmpFolder = new File(tmpLocation);
        if (!tmpFolder.exists()) tmpFolder.mkdirs();
        //chmod775(tmpLocation);

        tmpLocation = FileConst.getSubPath(_location, FileConst.LOC_LOG);
        tmpFolder = new File(tmpLocation);
        if (!tmpFolder.exists()) tmpFolder.mkdirs();
        //chmod775(tmpLocation);

        tmpLocation = FileConst.getSubPath(_location, FileConst.LOC_DERIVED);
        tmpFolder = new File(tmpLocation);
        if (!tmpFolder.exists()) tmpFolder.mkdirs();
        //chmod775(tmpLocation);
    }


    public void batch() {
        writeLogFile( fileLocation, "Start batch Curation");

        for (int i=0; i< batchLists.size(); i++) {
            if ( batchLists.get(i).getErrCode() != ErrorConst._OK ) continue;

            Integer[] errCode = { 0 };
            String metaTmpLocation = makeTmpLocation( fileLocation, batchLists.get(i).getDatasetId());
            writeLogFile( fileLocation, "making Temparary Location for metadata : " + metaTmpLocation);
            batchLists.get(i).setMetaLocation(metaTmpLocation);

            // writeLogFile( fileLocation, "Target File Location : " + batchLists.get(i).getLocation());
            // writeLogFile( fileLocation, "meta_location : " + _metaLocation);
            // RunContainer.run(batchLists.get(i).getLocation(), batchLists.get(i).getMetaLocation(), fileLocation, batchLists.get(i).getImage(), errCode  );
            ScriptCurate.run(batchLists.get(i).getLocation(), batchLists.get(i).getMetaLocation(), fileLocation, batchLists.get(i).getPpId(), errCode  );

            System.out.println("ErrCode in BatchCurate.run() : " + errCode[0]);

            if (errCode[0] != ErrorConst._OK) {
                batchLists.get(i).setErrCode( errCode[0] );
            } else {
                checkError(batchLists.get(i), fileLocation);
            }
        }
    }

    public void makeErrLog(String err){

        String errLogFile = fileLocation + File.separator + "err.log";

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(errLogFile));
            writer.write("ERROR : " + err + System.lineSeparator() );
            writer.close();
        } catch ( IOException e ) {
            e.printStackTrace();
            System.err.println("IO Exception in ErrLog");
            return;
        }

        // System.err.println("ErrLog : " + err);
    }

    public void annotate(){
        writeLogFile( fileLocation, "start to Annotate : " + fileLocation);
        Map<String,String> bInfo = BatchRetrieve.readBatchInfoFile(fileLocation) ;
        //writeLogFile( fileLocation, "end of read batch info ");

        PropConst.setPropFromBInfo(bInfo);

        batchLists = BatchCurate.readDatasetListFile(fileLocation, FileConst.LOC_DATASET_LIST);
        if(batchLists == null) {
            System.out.println("File read Error : " + fileLocation );
            writeLogFile( fileLocation, "File read Error : " + fileLocation);
            return;
        }

        batch();
        BatchCurate.writeDatasetListFile(fileLocation, batchLists, FileConst.LOC_FEEDBACK_LIST);
    }


    public static void chmod775(String location) {
        if ( FileConst.systemType() == FileConst.TYPE_WINDOWS ) return;
        try {
            String chmod = "chmod 775 " + location;
            Runtime.getRuntime().exec(chmod);
        } catch (Exception e) {
            System.out.println("Failed to change permission for " + location);
        }
    }


    public static void main(String args[]) {
        if (args.length < 2) {
            System.out.println("Usage : java -jar BatchCurate [ CURATE | RETRIEVE ]  <path>");
            return;
        }
        BatchCurate.setRemote(true);


        // chmod775(args[1]);
        if ( args[0].endsWith("CURATE") ) {
            BatchCurate bc = new BatchCurate(args[1]);
            bc.annotate();
        } else if ( args[0].endsWith("RETRIEVE") ) {
            BatchRetrieve br = new BatchRetrieve(args[1]);
            br.retrieve();
        } else {
            System.out.println("Usage : java -jar BatchCurate [ CURATE | RETRIEVE ]  <path>");
        }
    }
}
