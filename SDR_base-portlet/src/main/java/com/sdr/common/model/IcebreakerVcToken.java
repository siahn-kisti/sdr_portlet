package com.sdr.common.model;

public class IcebreakerVcToken {
	
	public IcebreakerVcToken(){}
	
	private String vcToken;
	private String vcTokenExpired;
	private int resultCode;
	
	public String getVcToken() {
		return vcToken;
	}
	public void setVcToken(String vcToken) {
		this.vcToken = vcToken;
	}
	public String getVcTokenExpired() {
		return vcTokenExpired;
	}
	public void setVcTokenExpired(String vcTokenExpired) {
		this.vcTokenExpired = vcTokenExpired;
	}
	public int getResultCode() {
		return resultCode;
	}
	public void setResultCode(int resultCode) {
		this.resultCode = resultCode;
	}
}
