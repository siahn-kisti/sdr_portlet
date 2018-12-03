package com.sdr.curation.batch.interpret;

import com.sdr.curation.ErrorConst;
import com.sdr.curation.batch.RunInterpreter;

import java.util.ArrayList;

public class I_Head extends I_Interface {

    public void execute (String _file_location, String _meta_location, String args, Integer[] errCode) {
        // check args
        if ( RunInterpreter.checkArgs(args, errCode) == false ) return;

        int index = Integer.parseInt(args);
        if ( index == 0) {
            errCode[0] = ErrorConst._ERROR_INVALID_ARGS_IN_SIMPLE;
            return;
        }


        // check file
        ArrayList<String> inData = RunInterpreter.readIN(_meta_location, errCode);
        if (errCode[0] != ErrorConst._OK) return;

        ArrayList<String> outData = new ArrayList<>();
        for (int i=0; i< inData.size(); i++)
            if ( i < index) outData.add(inData.get(i));

        // select
        RunInterpreter.writeOUT(_meta_location, outData, errCode);
    }
}
