package com.sdr.ml.common.file;

import java.io.File;

public class FileConst {


	/* locations under each dataset */
	public static final int LOC_DERIVED = 21;
	private static final String _DERIVED_LOCATION = "derived";


	public static String getSubPath(String path, int sub) {
		switch (sub) {
			/* super folder */

			/* dataset folder */
			case LOC_DERIVED:
				return path + File.separator + _DERIVED_LOCATION;
		}
		return null;
	}
}
