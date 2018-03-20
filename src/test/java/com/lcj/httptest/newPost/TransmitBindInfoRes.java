package com.lcj.httptest.newPost;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.alibaba.fastjson.annotation.JSONField;
 
public class TransmitBindInfoRes implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5186530789203959964L;

	/**
	 * 返回状态
	 */
	@JSONField(name="Status")
	private int status = -1;

	/**
	 * 返回的接口操作说明
	 */
	@JSONField(name="Message")
	private String message;
	
	
	@JSONField(name="Ids")
	private Set<String> ids = new HashSet<String>();


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	

	public Set<String> getIds() {
		return ids;
	}


	public void setIds(Set<String> ids) {
		this.ids = ids;
	}


	 
	
	
}
