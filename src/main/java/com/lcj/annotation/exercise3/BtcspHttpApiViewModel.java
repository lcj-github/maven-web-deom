package com.lcj.annotation.exercise3;

import java.io.Serializable;
import java.util.Date;




@TableRecordMarker
public class BtcspHttpApiViewModel implements Serializable
{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@TableColumnMarker(index = 1, name = "app应用名")
	private String app;
	
	@TableColumnMarker(index = 2, name = "请求路径")
	private String command;
	
	private String precommand;

	@TableColumnMarker(index = 4, name = "请求参数")
	private String prams;
	
	private String postcommand;
	
	private String outputtype;
	
	
	private String expectoutput;
	
	@TableColumnMarker(index = 3, name = "备注")
	private String comment;
	
	private String author;
	
	private String tester;
	
	private String zephryID;
	
	private String jiraID;
	
	
	private Date designdate;
	
	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getPrecommand() {
		return precommand;
	}

	public void setPrecommand(String precommand) {
		this.precommand = precommand;
	}

	public String getPrams() {
		return prams;
	}

	public void setPrams(String prams) {
		this.prams = prams;
	}

	public String getPostcommand() {
		return postcommand;
	}

	public void setPostcommand(String postcommand) {
		this.postcommand = postcommand;
	}

	public String getOutputtype() {
		return outputtype;
	}

	public void setOutputtype(String outputtype) {
		this.outputtype = outputtype;
	}

	public String getExpectoutput() {
		return expectoutput;
	}

	public void setExpectoutput(String expectoutput) {
		this.expectoutput = expectoutput;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTester() {
		return tester;
	}

	public void setTester(String tester) {
		this.tester = tester;
	}

	public String getZephryID() {
		return zephryID;
	}

	public void setZephryID(String zephryID) {
		this.zephryID = zephryID;
	}

	public String getJiraID() {
		return jiraID;
	}

	public void setJiraID(String jiraID) {
		this.jiraID = jiraID;
	}

	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDesigndate() {
		return designdate;
	}

	public void setDesigndate(Date designdate) {
		this.designdate = designdate;
	}

}
