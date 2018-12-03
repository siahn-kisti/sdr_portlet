package com.sdr.curation.batch.interpret;

import com.sdr.curation.ErrorConst;
import com.sdr.curation.batch.RunInterpreter;
import com.sdr.file.FileConst;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class I_Copy extends I_Interface {

    public void execute (String _file_location, String _meta_location, String args, Integer[] errCode) {

        if(RunInterpreter._debug) System.out.println("Args in Copy : " + args);
        if ( RunInterpreter.checkArgs(args, errCode) == false ) return;

        // check file
        ArrayList<String> inData = RunInterpreter.readIN(_meta_location, errCode);
        if (errCode[0] != ErrorConst._OK) return;

        File src = new File(inData.get(0));
        if ( src.exists() == false ) {
            errCode[0] = ErrorConst._ERROR_INVALID_BUFFER_IN_SIMPLE;
            return ;
        }

        File dest = new File(FileConst.getSubPath(_meta_location, FileConst.LOC_DERIVED) + File.separator + args.trim());
        try {
            FileCopyUtils.copy(src, dest);
        } catch (IOException e) {
            errCode[0] = ErrorConst._ERROR_IO_EXCEPTION;
        }
    }
}
