package com.sdr.curation;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sdr.curation.batch.BatchCurate;
import com.sdr.curation.batch.BatchJob;
import com.sdr.curation.batch.BatchRetrieve;
import com.sdr.file.FileConst;

import java.io.*;
import java.util.List;
// import java.util.Arrays;
// import java.util.concurrent.TimeUnit;

/*
import com.sdr.file.FileService;
import java.io.File;
import com.sdr.metadata.model.DataType;
import com.sdr.metadata.model.Dataset;
import com.liferay.portal.service.ServiceContext;
*/

public class LocalPreprocess extends PreprocessInterface {
	
	private static Log log = LogFactoryUtil.getLog(LocalPreprocess.class);

	@Override
	public boolean retrieveFile(String location, List<BatchJob> batchJobList) {
		BatchRetrieve br = new BatchRetrieve(location);
		br.retrieve();
		return true;
	}

	@Override
	public boolean annotate( String location, List<BatchJob> batchJobList) {
		log.debug("START ANNO : " + location);
		BatchCurate bc = new BatchCurate(location);
		bc.annotate();
		log.debug("END ANNO : " + location);
		return true;
	}
}
