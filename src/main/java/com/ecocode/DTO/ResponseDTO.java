package com.ecocode.DTO;

public class ResponseDTO {
	
	private String key ;
	private Object other;
	
	public ResponseDTO() {
	}
	
	public ResponseDTO(String key, Object other) {
		super();
		this.key = key;
		this.other = other;
	}
	
	public String getKey() {
		return key;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public Object getOther() {
		return other;
	}
	
	public void setOther(Object other) {
		this.other = other;
	}
	

}
