package com.lcj.fastjson.t1;

import java.util.ArrayList;
import java.util.List;

public class DataGroup {

	private String id;
    private String type;
    private List<DataV> data = new ArrayList<DataV>();
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<DataV> getData() {
		return data;
	}
	public void setData(List<DataV> data) {
		this.data = data;
	}

    
    
}
