package com.sdr.curation.batch.interpret;

import com.sdr.curation.ErrorConst;
import com.sdr.curation.batch.RunInterpreter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;


public class I_Grep extends I_Interface {

    public void execute (String _file_location, String _meta_location, String args, Integer[] errCode) {

        if(RunInterpreter._debug) System.out.println("location in Grep : " + _file_location);
        if(RunInterpreter._debug) System.out.println("Args in Grep : " + args);

        if ( RunInterpreter.checkArgs(args, errCode) == false ) return;

        // check file
        ArrayList<String> inData = RunInterpreter.readIN(_meta_location, errCode);
        if (errCode[0] != ErrorConst._OK) return;

        File _file = new File(inData.get(0));
        if ( _file.exists() == false ) {
            errCode[0] = ErrorConst._ERROR_INVALID_BUFFER_IN_SIMPLE;
            return ;
        }


        final ArrayList<String> matches = new ArrayList<>();
        String findStr = ".*" + args.trim() + ".*";

        // get matching entries
        int count = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(inData.get(0))) ;
            String str = null;
            while ((str = br.readLine()) != null) {
                if(RunInterpreter._debug) System.out.println("##str : " + str);
                if (Pattern.matches(findStr, str)) {
                    if(RunInterpreter._debug) System.out.println("##matches : " + str);
                    matches.add(str);
                    count++;
                    if (count >= RunInterpreter._MAX_LINE_IN_BUFFER) break;
                }
            }
            br.close();

            if (matches.size() == 0) {
                errCode[0] = ErrorConst._ERROR_INVALID_ARGS_IN_SIMPLE;
                return;
            }
        } catch (IOException e) {
            errCode[0] = ErrorConst._ERROR_IO_EXCEPTION;
            return;
        }


        if(RunInterpreter._debug) System.out.println("Results in Grep : " + matches);

        RunInterpreter.writeOUT(_meta_location, matches, errCode);
    }
}
