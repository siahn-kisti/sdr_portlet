package com.sdr.curation.batch;

import com.sdr.curation.ErrorConst;
import com.sdr.file.FileConst;
import com.sdr.file.PropConst;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RunContainer {

    public final static int CONTAINER_DOCKER = 1;
    public final static int CONTAINER_SINGULARITY = 2;
    private final static int _MAX_TRY = 1 ;


    public static void run(String srcLocation, String destLocation, String batchLocation,
                           String image, Integer[] errCode) {
        String container = null;
        if ( BatchCurate.isRemote() ) {
           container = PropConst.getProp("remote.curate");
        } else {
           container = PropConst.getProp("local.curate");
        }

        if ( container == null ) {
            if (BatchCurate._debug) System.out.println("remote.curate or local.curate is not defined");
            return;
        } else if ( container.contains("docker")) {
            if ( BatchCurate._debug ) System.out.println("use docker in curation");
            run(srcLocation, destLocation, batchLocation, image, errCode, CONTAINER_DOCKER);
        } else {
            if ( BatchCurate._debug ) System.out.println("use singularity in curation");
            run(srcLocation, destLocation, batchLocation, image, errCode, CONTAINER_SINGULARITY);
        }
    }


    public static void run(String srcLocation, String destLocation, String batchLocation,
                           String image, Integer[] errCode, int type) {
        String ret = null;
        String _successlog = null;
        String _errorlog = null;

        if ( srcLocation != null ) {
            srcLocation = srcLocation.replace("c:", "/c").replace("C:", "/c").replace("e:", "/e").replace("E:", "/e").replace("d:", "/d").replace("D:", "/d").replace("\\", "/");
        }

        if (destLocation != null ) {
            FileConst.cleanFile( FileConst.getSubPath( destLocation, FileConst.LOC_SUCCESS_LOG) );
            FileConst.cleanFile( FileConst.getSubPath( destLocation, FileConst.LOC_ERROR_LOG) );

            destLocation = destLocation.replace("c:", "/c").replace("C:", "/c").replace("e:", "/e").replace("E:", "/e").replace("d:", "/d").replace("D:", "/d").replace("\\", "/");
        }


        String command = null;
        switch ( type ) {
            case CONTAINER_DOCKER :
                command = RunDocker.getCommand(srcLocation, destLocation, image);
                break;
            case CONTAINER_SINGULARITY :
                command = RunSingularity.getCommand(srcLocation, destLocation, image);
                break;
            default:
                return ;
        }
        if (BatchCurate._debug) System.out.println("command : " + command);
        BatchCurate.writeLogFile(batchLocation, " Run : " + command);

        for (int i = 0 ; i < _MAX_TRY ; i++ ) {
            Process p = null;
            InputStream error = null;

            try {
                p = Runtime.getRuntime().exec( command );
                // p.waitFor(2, TimeUnit.MINUTES);
                p.waitFor();

                int pret = p.exitValue();
                error = p.getErrorStream();

                if ( (pret != 0) && (error != null ) && (error.available() > 0) ) {

                    if (i + 1 == _MAX_TRY) {
                        BufferedReader br = new BufferedReader( new InputStreamReader(p.getErrorStream()));
                        String str = null;
                        while ((str = br.readLine()) != null) { ret += str; }
                        br.close();
                        error.close();
                        errCode[0] = ErrorConst._ERROR_DOCKER_EXEC;
                        break;
                    } else {
                        error.close();
                        continue;
                    }
                }
                error.close();
            } catch (Exception e ) {
                if ( i + 1 == _MAX_TRY) {
                    errCode[0] = ErrorConst._ERROR_DOCKER_EXEC;
                } else {
                    continue;
                }
            } finally {
                p.destroy();
            }
        }

        if (errCode[0] == ErrorConst._OK) {
            BatchCurate.writeLogFile(batchLocation, " End of Run ");
        } else {
            BatchCurate.writeLogFile(batchLocation, " Error at the Run : " + ErrorConst.getErrorMessage( errCode[0] ));
        }
    }
}
