package com.lcj.httptest.newGet;

import java.io.Serializable;

import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.annotation.JSONType;
 

 
@JSONType(orders ={ "BizData", "Status", "Message"}) 
public class MobileBindResDto implements Serializable {

	private static final long serialVersionUID = 8385984327420092870L;

	/**
	 * 数据实体
	 */
	@JSONField(name="BizData")
	private String bizData = null;

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

	
	public String getBizData() {
		return bizData;
	}


	public void setBizData(String bizData) {
		this.bizData = bizData;
	}


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
}
