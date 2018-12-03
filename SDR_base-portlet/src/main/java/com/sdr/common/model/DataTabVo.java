package com.sdr.common.model;

import java.util.List;

public class DataTabVo {
	
	private String label;
	private String value;

	//----------------------------------------------------
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	//new ----------------------------------------------------
	public DataTabVo(String label){
		setLabel(label);
		setValue(label);
	}

	public DataTabVo(String label, String value){
		setLabel(label);
		setValue(value);
	}

	public DataTabVo(String label, long value){
		setLabel(label);
		setValue(String.valueOf(value));
	}

	//getLabelString
	public static String getLabelString(List<DataTabVo> list) {
		StringBuilder sb = new StringBuilder();
		if(list!=null && list.size()>0){
			for(DataTabVo vo : list){
				if(sb.length()>0) sb.append(",");
				sb.append(vo.getLabel());
			}
		}
		return sb.toString();
	}

	//getValueString
	public static String getValueString(List<DataTabVo> list) {
		StringBuilder sb = new StringBuilder();
		if(list!=null && list.size()>0){
			
			for(DataTabVo vo : list){
				if(sb.length()>0) sb.append(",");
				sb.append(vo.getValue());
			}
		}
		return sb.toString();
	}
	
}
