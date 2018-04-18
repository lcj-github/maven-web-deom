package com.lcj.fastjson.t1;

import java.util.ArrayList;
import java.util.List;

public class JSChart {
	
	private List<DataGroup> datasets = new ArrayList<DataGroup>();
	
	private List<OptionGroup> optionset = new ArrayList<OptionGroup>();

	public List<DataGroup> getDatasets() {
		return datasets;
	}

	public void setDatasets(List<DataGroup> datasets) {
		this.datasets = datasets;
	}

	public List<OptionGroup> getOptionset() {
		return optionset;
	}

	public void setOptionset(List<OptionGroup> optionset) {
		this.optionset = optionset;
	}


	

}
