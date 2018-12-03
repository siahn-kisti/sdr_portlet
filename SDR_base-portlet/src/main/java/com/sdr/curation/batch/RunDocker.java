package com.sdr.curation.batch;

import com.sdr.file.FileConst;
import com.sdr.file.PropConst;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RunDocker {

    public static void run(String srcLocation, String destLocation, String batchLocation, String dockerImage, Integer[] errCode)  {
        RunContainer.run(srcLocation, destLocation, batchLocation, dockerImage, errCode, RunContainer.CONTAINER_DOCKER);
    }

    public static String getCommand(String srcLocation, String destLocation, String dockerImage) {
        String dockerCommand = PropConst.getProp("docker.command") ;

        String user = " ";
		if ( FileConst.systemType() != FileConst.TYPE_WINDOWS ) {
			try {
				String cmd = "id -u ";
				Process child = Runtime.getRuntime().exec(cmd);
				BufferedReader in = new BufferedReader(new InputStreamReader(child.getInputStream()));
				String line = in.readLine();
				line = line.trim();
				if ( line.length() > 0 ) user = " -u " + line;
				System.out.println(user);
			} catch (Exception e) {
				System.out.println("Failed to get userId ");
			}
		}

        String dockerRun = dockerCommand + " run --rm " + user ;
        if ( srcLocation != null )
            dockerRun += " -v " + srcLocation + ":/curate/input";

        if ( destLocation != null)
            dockerRun += " -v " + destLocation + ":/curate/output";

        int index = dockerImage.indexOf(",");
        String image = dockerImage.substring(0, index);
        String args = dockerImage.substring(index+1).trim();

        /*
        if ( batchMode ) {
            String OS = System.getProperty("os.name").toLowerCase();
            if ( OS.indexOf("win") >= 0) {   //  FileService.TYPE_WINDOWS
                dockerRun += " -v /usr/local/bin/docker:/usr/bin/docker";
            } else {
                dockerRun += " -v /usr/bin/docker:/usr/bin/docker";
            }
            dockerRun += " -v /var/run/docker.sock:/var/run/docker.sock";
        }
        */

        dockerRun += " " + image + " /curate/curate.sh " + args;
        return dockerRun;
    }
}
