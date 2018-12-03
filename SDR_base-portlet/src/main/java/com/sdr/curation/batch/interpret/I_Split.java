package com.sdr.curation.batch.interpret;

import com.sdr.curation.ErrorConst;
import com.sdr.curation.batch.RunInterpreter;

import java.util.ArrayList;

public class I_Split extends I_Interface {

    public void execute (String _file_location, String _meta_location, String args, Integer[] errCode) {

        // check split
        if ( RunInterpreter.checkArgs(args, errCode) == false ) return;

        // check file
        ArrayList<String> inData = RunInterpreter.readIN(_meta_location, errCode);
        if (errCode[0] != ErrorConst._OK) return;


        // split
        ArrayList<String> outData = new ArrayList<>();
        for(int i=0; i<inData.size(); i++){
            String value = inData.get(i);
            value = value.trim();
            if (value.length() == 0 ) continue;
            String[] split = value.split(args);
            for (String sub : split) outData.add(sub.trim());
        }

        if(RunInterpreter._debug) System.out.println("Args in Split : " + args);
        if(RunInterpreter._debug) System.out.println("Results in Split : " + outData);

        RunInterpreter.writeOUT(_meta_location, outData, errCode);
    }
}
