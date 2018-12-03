package com.sdr.common.util.restfulMessage;

public class RestfulMessageVo {
	private int code = -1;
	private String codeDescription = "";
	private String data = "";

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getCodeDescription() {
		return codeDescription;
	}

	public void setCodeDescription(String codeDescription) {
		this.codeDescription = codeDescription;
	}

	public String getData() {
		return data;
	}

	public void setData(String jsonString) {
		this.data = jsonString;
	}
}
