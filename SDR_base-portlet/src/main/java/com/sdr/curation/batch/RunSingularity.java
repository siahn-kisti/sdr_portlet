package com.sdr.curation.batch;

import com.sdr.file.PropConst;

public class RunSingularity {

    static final int _MAX_TRY = 1 ;

    public static void run(String srcLocation, String destLocation, String batchLocation, String image, Integer[] errCode)  {
        RunContainer.run(srcLocation, destLocation, batchLocation, image, errCode, RunContainer.CONTAINER_DOCKER);
    }

    public static String getCommand(String srcLocation, String destLocation, String image) {
        String command = PropConst.getProp("singularity.command") ;
        String imagePath = PropConst.getProp("singularity.Image.path") ;
        String root = null;
        if ( BatchCurate.isRemote() ) {
            root = PropConst.getProp("dataset.remote.location") ;
        } else {
            root = PropConst.getProp("dataset.location") ;
        }


        String run = command + " -d exec " ;
        run += " -H " + System.getenv("HOME") + ":/home/" +   System.getenv("USER");
        if ( srcLocation != null )
            run += " -B " + srcLocation + ":/curate/input";

        if ( destLocation != null)
            run += "," + destLocation + ":/curate/output";


        int index = image.indexOf(" ");
        String sinImage = image.substring(0, index);
        String args = image.substring(index+1).trim();


        run += " " + root + "/" + imagePath + "/" + sinImage + " /curate/curate.sh " + args;
        return run;
    }
}
