package com.sdr.curation.batch.interpret;

import com.sdr.curation.ErrorConst;
import com.sdr.curation.batch.RunInterpreter;

import java.util.ArrayList;

public class I_RemoveFirst extends I_Interface {

    public void execute (String _file_location, String _meta_location, String args, Integer[] errCode) {

        if(RunInterpreter._debug) System.out.println("Args in Remove First : " + args);

        if ( RunInterpreter.checkArgs(args, errCode) == false ) return;

        ArrayList<String> inData = RunInterpreter.readIN(_meta_location, errCode);
        if (errCode[0] != ErrorConst._OK) return;

        ArrayList<String> outData = new ArrayList<>();
        for(int i=0; i<inData.size(); i++) {
            String value = inData.get(i);

            int index = value.indexOf(args.charAt(0));
            if (index == -1) {
                outData.add(value);
            } else {
                outData.add(value.substring(index + 1));
            }
        }

        if(RunInterpreter._debug) System.out.println("Results in remove first : " + outData);

        RunInterpreter.writeOUT(_meta_location, outData, errCode);
    }


}
