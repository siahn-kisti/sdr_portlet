package com.sdr.curation.batch.interpret;

import com.sdr.curation.ErrorConst;
import com.sdr.curation.batch.RunInterpreter;

import java.util.ArrayList;

public class I_Select extends I_Interface {

    public void execute (String _file_location, String _meta_location, String args, Integer[] errCode) {

        // check grep pattern
        if ( RunInterpreter.checkArgs(args, errCode) == false ) return;


        int index = 0;
        try {
            index = Integer.parseInt(args);
        } catch (NumberFormatException e) {
            errCode[0] = ErrorConst._ERROR_INVALID_ARGS_IN_SIMPLE;
            return;
        }

        // check file
        ArrayList<String> inData = RunInterpreter.readIN(_meta_location, errCode);
        if (errCode[0] != ErrorConst._OK) return;

        if ( (inData.size() < index) || (index == 0)) {
            errCode[0] = ErrorConst._ERROR_INVALID_ARGS_IN_SIMPLE;
            return;
        }


        // select
        RunInterpreter.writeOUT(_meta_location, inData.get(index-1), errCode);
    }
}
