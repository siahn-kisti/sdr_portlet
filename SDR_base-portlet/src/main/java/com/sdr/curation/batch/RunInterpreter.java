package com.sdr.curation.batch;

import com.sdr.curation.ErrorConst;
import com.sdr.curation.batch.interpret.*;
import com.sdr.file.FileConst;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class RunInterpreter {

    public static final boolean _debug = false;

    public static final int _MAX_LINE_IN_BUFFER  = 10;

    public static void run(String _file_location, String _meta_location, String _batch_location, String script, Integer[] errCode) {
        ArrayList<String> parsedResult = new ArrayList<>();
        String split[] = script.split("\\n");

        for (String line  : split) {
            line = line.trim();
            if( line.length() == 0 ) continue ;
            if( line.startsWith("#") ) continue;

            execute(_file_location, _meta_location, line, errCode);
            if(_debug) System.out.println("ErrCode in RunInterpreter.run() : " + errCode[0]);

            if (errCode[0] != ErrorConst._OK) return;
        }
    }

    public static boolean execute(String _file_location, String _meta_location, String line, Integer[] errCode) {

        copyOutToIn(_meta_location);

        // seperate command and args
        line = line.replace("\\t", " ");
        int space = line.indexOf(" ");
        String command = line.substring(0, space);
        String args = line.substring(space+1, line.length());

        // remove "" from args
        args = args.trim();
        if (args.length() == 0 ) {
            args = null;
        } else {
            if ((args.charAt(0) == '\"') && (args.charAt(args.length() - 1) == '\"')) {
                args = args.substring(1, args.length() - 1);
            }
            if ((args.charAt(0) == '\'') && (args.charAt(args.length() - 1) == '\'')) {
                args = args.substring(1, args.length() - 1);
            }
        }

        if(_debug)System.out.println("command : " + command);
        if(_debug)System.out.println("args : " + args);

        I_Interface myInterface = I_Factory.getInstance(command);
        if (myInterface==null) {
            errCode[0] = ErrorConst._ERROR_INVALID_COMMAND_IN_SIMPLE;
            return false;
        }
        myInterface.execute(_file_location, _meta_location, args, errCode);
        return true;
    }


    public static ArrayList<String> readIN(String _meta_location, Integer[] errCode) {
        String ppFileName = FileConst.getSubPath(_meta_location, FileConst.LOC_LOG) + File.separator + FileConst._LOG_FILE_IN;
        if(_debug)System.out.println("in path : " + ppFileName);
        ArrayList<String> result = new ArrayList<>();

        File _file = new File(ppFileName);
        if ( _file.exists() == false ) {
            errCode[0] = ErrorConst._ERROR_INVALID_BUFFER_IN_SIMPLE;
            return null;
        }

        try {
            BufferedReader br = new BufferedReader( new FileReader(ppFileName) );
            String str = null;
            while ((str = br.readLine()) != null) {
                // ret += str;
                str = str.trim();
                if( str.length() == 0 ) continue ;
                if( str.startsWith("#") ) continue;
                result.add(str);
            }
            br.close();

            if(_debug) System.out.println("#### READ In : " + result);
            if (result.size() == 0) {
                errCode[0] = ErrorConst._ERROR_INVALID_BUFFER_IN_SIMPLE;
                return null;
            } else {
                return result;
            }
        } catch (IOException e) {
            errCode[0] = ErrorConst._ERROR_INVALID_BUFFER_IN_SIMPLE;
            return null;
        }


    }


    public static void writeOUT(String _meta_location, ArrayList<String> list, Integer[] errCode) {
        String result = "";
        for ( int i=0; i< list.size(); i++) {
            result += list.get(i) + System.lineSeparator();
        }

        if (result.length() == 0 ) {
            errCode[0] = ErrorConst._ERROR_INVALID_OUT_IN_SIMPLE;
            return;
        }

        RunInterpreter.writeOUT(_meta_location, result, errCode);
    }


    public static void writeOUT(String _meta_location, String result, Integer[] errCode) {
        try {
            String metadataPath = FileConst.getSubPath(_meta_location, FileConst.LOC_LOG) + File.separator + FileConst._LOG_FILE_OUT;
            if(_debug) System.out.println("#### write Out : " + result);
            FileWriter fw = new FileWriter(metadataPath);
            fw.write(result);
            fw.close();
        } catch ( IOException e) {
            errCode[0] = ErrorConst._ERROR_INVALID_OUT_IN_SIMPLE;
            if(_debug) System.out.println("Failed to write Out : " + result);
        }
        return;
    }

    public static boolean checkArgs(String args, Integer[] errCode) {
        if ((args == null) || (args.length() == 0)) {
            errCode[0] = ErrorConst._ERROR_INVALID_ARGS_IN_SIMPLE;
            return false;
        }
        return true;
    }



    private static void copyOutToIn(String _meta_location) {
        File srcDir = new File(FileConst.getSubPath(_meta_location, FileConst.LOC_LOG) + File.separator + FileConst._LOG_FILE_OUT);
        if(_debug) System.out.println("copy src dir : " + srcDir.getAbsolutePath());

        if (!srcDir.exists()) return;

        File destDir = new File(FileConst.getSubPath(_meta_location, FileConst.LOC_LOG) + File.separator + FileConst._LOG_FILE_IN);
        if(_debug) System.out.println("copy dest dir : " + destDir.getAbsolutePath());
        FileConst.cleanFile(destDir.toString());
        srcDir.renameTo(destDir);
    }


    public static String removeQuote(String value) {
        if ((value.charAt(0) == '\"') && (value.charAt(value.length() - 1) == '\"')) {
            value = value.substring(1, value.length() - 1);
        }
        if ((value.charAt(0) == '\'') && (value.charAt(value.length() - 1) == '\'')) {
            value = value.substring(1, value.length() - 1);
        }
        return value;
    }
}
