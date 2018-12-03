package com.sdr.common.model;

import com.sdr.metadata.model.DataViewClp;

/**
 * The type Data view vo.
 */
public class DataViewVo extends DataViewClp {
	
	private String dataTypeName;

	/**
	 * Gets data type name.
	 *
	 * @return the data type name
	 */
	public String getDataTypeName() {
		return dataTypeName;
	}

	/**
	 * Sets data type name.
	 *
	 * @param dataTypeName the data type name
	 */
	public void setDataTypeName(String dataTypeName) {
		this.dataTypeName = dataTypeName;
	}

}
