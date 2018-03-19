package com.lcj.httptest.new1;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;

public class DataDto {

	
	private String UserName = "na";
	
	
	private String MarketCode = "3745";
	

	private String Mobile;
	
	
	private String Remark;
	
	private String OSN = "invitecode-79";
	

	private String Channel = "Web";
	
	@JSONField(name="SourceNo")
	private String SourceNo = "79";
	
	@JSONField(name="extraRtn")
	private String ExtraRtn = "InviteCode"; 
	
	@JSONField(serialize = false)
	private String province;
	
	@JSONField(serialize = false)
	private String provinceCode;
	
	@JSONField(serialize = false)
	private String city;
	
	@JSONField(serialize = false)
	private String schoolName;
	
	@JSONField(serialize = false)
	private String schoolCode;
	
	@JSONField(serialize = false)
	private String department;
	
	@JSONField(serialize = false)
	private String studentNo;
	
	@JSONField(serialize = false)
	private String studentName;
	
	@JSONField(serialize = false)
	private String email="";
	
	@JSONField(serialize = false)
	private String leader="";
	
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLeader() {
		return leader;
	}

	public void setLeader(String leader) {
		this.leader = leader;
	}

	@JSONField(name="UserName")
	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	
	@JSONField(name="Mobile")
	public String getMobile() {
		return Mobile;
	}

	public void setMobile(String mobile) {
		Mobile = mobile;
	}

	@JSONField(name="Remark")
	public String getRemark() {
		JSONObject obj = new JSONObject();
		obj.put("province", this.province);
		obj.put("provinceCode", this.provinceCode);
		obj.put("city", this.city);
		obj.put("department", this.department);
		obj.put("schoolName", this.schoolName);
		obj.put("schoolCode", this.schoolCode);
		obj.put("studentNo", this.studentNo);
		obj.put("studentName", this.studentName);
		obj.put("email", this.email);
		obj.put("leader", this.leader);
		return JSON.toJSONString(obj);
	}

	
	public void setRemark(String remark) {
		Remark = remark;
	}

	@JSONField(name="Channel")
	public String getChannel() {
		return Channel;
	}

	public void setChannel(String channel) {
		Channel = channel;
	}

	public String getSourceNo() {
		return SourceNo;
	}

	public void setSourceNo(String sourceNo) {
		SourceNo = sourceNo;
	}

	public String getExtraRtn() {
		return ExtraRtn;
	}

	public void setExtraRtn(String extraRtn) {
		ExtraRtn = extraRtn;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@JSONField(name="MarketCode")
	public String getMarketCode() {
		return MarketCode;
	}

	public void setMarketCode(String marketCode) {
		MarketCode = marketCode;
	}

	public String getOSN() {
		return OSN;
	}

	public void setOSN(String oSN) {
		OSN = oSN;
	}

	public String getProvinceCode() {
		return provinceCode;
	}

	public void setProvinceCode(String provinceCode) {
		this.provinceCode = provinceCode;
	}

	public String getSchoolCode() {
		return schoolCode;
	}

	public void setSchoolCode(String schoolCode) {
		this.schoolCode = schoolCode;
	}
	
	
	
	
	
}
