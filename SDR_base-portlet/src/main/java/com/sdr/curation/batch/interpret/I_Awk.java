package com.sdr.curation.batch.interpret;

import com.sdr.curation.ErrorConst;
import com.sdr.curation.batch.RunInterpreter;
import java.util.ArrayList;

public class I_Awk extends I_Interface {

    public void execute (String _file_location, String _meta_location, String args, Integer[] errCode) {

        if(RunInterpreter._debug) System.out.println("location in Awk : " + _file_location);
        if(RunInterpreter._debug) System.out.println("Args in Awk : " + args);

        if ( RunInterpreter.checkArgs(args, errCode) == false ) return;

        // check file
        ArrayList<String> inData = RunInterpreter.readIN(_meta_location, errCode);
        if (errCode[0] != ErrorConst._OK) return;


        // split
        ArrayList<String> outData = new ArrayList<>();
        for(int i=0; i<inData.size(); i++){
            String value = inData.get(i);
            value = value.replace("\t", " ");
            value = value.trim();
            if (value.length() == 0 ) continue;

            String[] split = value.split("\\s+");
            System.out.println("splited data : " + split);
            String replaced = args;
            for(int j=split.length; j>0; j--) {
                String target = "$" + j;
                replaced = replaced.replace(target, split[j-1].trim());
            }
            outData.add(replaced.trim());
        }

        if(RunInterpreter._debug) System.out.println("Results in Awk : " + outData);

        RunInterpreter.writeOUT(_meta_location, outData, errCode);
    }
}
