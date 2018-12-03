package com.sdr.common.model;

import com.sdr.metadata.model.DatasetClp;

/**
 * The type Dataset vo.
 */
public class DatasetVo extends DatasetClp {
	
	private long collectionId;
	private String collectionName;
	private String dataTypeName;
	private String keyword;

	/**
	 * Gets collection Id
	 * @return the collection Id
	 */
	public long getCollectionId() {
		return collectionId;
	}

	/**
	 * Sets collection Id
	 *
	 * @param collectionId
	 */
	public void setCollectionId(long collectionId) {
		this.collectionId = collectionId;
	}

	/**
	 * Gets collection name.
	 *
	 * @return the collection name
	 */
	public String getCollectionName() {
		return collectionName;
	}

	/**
	 * Sets collection name.
	 *
	 * @param collectionName the collection name
	 */
	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}

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

	/**
	 * Gets keyword.
	 *
	 * @return the keyword
	 */
	public String getKeyword() {
		return keyword;
	}

	/**
	 * Sets keyword.
	 *
	 * @param keyword the keyword
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
