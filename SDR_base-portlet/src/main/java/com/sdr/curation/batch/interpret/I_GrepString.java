package com.sdr.curation.batch.interpret;

import com.sdr.curation.ErrorConst;
import com.sdr.curation.batch.RunInterpreter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class I_GrepString extends I_Interface {

    public void execute (String _file_location, String _meta_location, String args, Integer[] errCode) {

        if(RunInterpreter._debug) System.out.println("location in Grep : " + _file_location);
        if(RunInterpreter._debug) System.out.println("Args in Grep : " + args);

        if ( RunInterpreter.checkArgs(args, errCode) == false ) return;


        ArrayList<String> inData = RunInterpreter.readIN(_meta_location, errCode);
        if (errCode[0] != ErrorConst._OK) return;


        final ArrayList<String> matches = new ArrayList<>();
        String findStr = ".*" + args.trim() + ".*";

        // get matching entries
        for(int i=0; i<inData.size(); i++) {
            // System.out.println("##str : " + str);
            if (Pattern.matches(findStr, inData.get(i))) {
                // System.out.println("##matches : " + str);
                matches.add(inData.get(i));
            }
        }

        if (matches.size() == 0) {
            errCode[0] = ErrorConst._ERROR_INVALID_ARGS_IN_SIMPLE;
            return;
        }

        if(RunInterpreter._debug) System.out.println("Results in Grep String : " + matches);

        RunInterpreter.writeOUT(_meta_location, matches, errCode);
    }



}
