package com.sdr.curation.batch.interpret;

import com.sdr.curation.ErrorConst;
import com.sdr.curation.batch.RunInterpreter;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class I_Find extends I_Interface {
    public void execute (String _file_location, String _meta_location, String args, Integer[] errCode) {

        if ( RunInterpreter.checkArgs(args, errCode) == false ) return;

        final Path _file_path = Paths.get(_file_location);
        final ArrayList<String> matches = new ArrayList<>();
        final Integer[] count = {0};
        final String _path = args;

        try {
            Files.walkFileTree(_file_path, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    File targetFile = file.toFile();
                    String fileName = targetFile.getPath();
                    String fName = fileName.toString().replace("\\", "/");
                    String pName = ( _file_path.toString() + File.separator + _path).replace("\\", "/");
                    if(RunInterpreter._debug) System.out.println("name: " + fName);
                    if(RunInterpreter._debug) System.out.println("path: " + pName);
                    if(RunInterpreter._debug) System.out.println("fName.matches(pName) : " + Pattern.matches(fName+"$", pName));
                    if (Pattern.matches(fName+"$", pName)) {
                        if ( count[0] < RunInterpreter._MAX_LINE_IN_BUFFER) {
                            matches.add(fileName);
                            count[0]++;
                        }
                    }
                    return FileVisitResult.CONTINUE;
                }
            });

        } catch (IOException e) {
            String exceptionMessage = String.format("Resource searching failed - path:%s, exception: %s", _file_path, e);
            errCode[0] = ErrorConst._ERROR_IO_EXCEPTION;
        }

        if(RunInterpreter._debug) System.out.println("location in Find : " + _file_location);
        if(RunInterpreter._debug) System.out.println("Args in Find : " + args);
        if(RunInterpreter._debug) System.out.println("Results in Find : " + matches);

        RunInterpreter.writeOUT(_meta_location, matches, errCode);
    }
}
