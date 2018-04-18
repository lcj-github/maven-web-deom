package com.lcj.fastjson.t1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

public class JsonTest {

	public static void main(String[] args) {
		JSChart jc = new JSChart();
		
		DataGroup dataGroup1 = new DataGroup();
		dataGroup1.setId("blue");
		dataGroup1.setType("line"); 
		for (int i=1;i<=10;i++)
		{
			DataV dataV1 = new DataV();
			dataV1.setUnit(i+"");
			String valz = String.valueOf(33-i);
			dataV1.setValue(valz); 
			dataGroup1.getData().add(dataV1);
		}		
        
        DataGroup dataGroup2 = new DataGroup();
        dataGroup2.setId("green");
        dataGroup2.setType("line");  
        for (int i=1;i<=10;i++)
		{
			DataV dataV2 = new DataV();
			dataV2.setUnit(i+"");
			String valz = String.valueOf(i*2);
			dataV2.setValue(valz); 
			dataGroup2.getData().add(dataV2);
		}	
        
        DataGroup dataGroup3 = new DataGroup();
        dataGroup3.setId("gray");
        dataGroup3.setType("line");  
        for (int i=1;i<=10;i++)
		{
			DataV dataV3 = new DataV();
			dataV3.setUnit(i+"");
			String valz = String.valueOf(i+15);
			dataV3.setValue(valz); 
			dataGroup3.getData().add(dataV3);
		}
        
	
        DataGroup dataGroup4 = new DataGroup();
        dataGroup4.setId("black");
        dataGroup4.setType("line");  
        for (int i=1;i<=10;i++)
		{
			DataV dataV4 = new DataV();
			dataV4.setUnit(i+"");
			String valz = String.valueOf(i+5);
			dataV4.setValue(valz); 
			dataGroup4.getData().add(dataV4);
		}
        
        DataGroup dataGroup5 = new DataGroup();
        dataGroup5.setId("red");
        dataGroup5.setType("line");  
        for (int i=1;i<=10;i++)
		{
			DataV dataV5 = new DataV();
			dataV5.setUnit(i+"");
			String valz = String.valueOf(i+10);
			dataV5.setValue(valz); 
			dataGroup5.getData().add(dataV5);
		}
        
        DataGroup dataGroup6 = new DataGroup();
        dataGroup6.setId("yellow");
        dataGroup6.setType("line");  
        for (int i=1;i<=10;i++)
		{
			DataV dataV6 = new DataV();
			dataV6.setUnit(i+"");
			String valz = String.valueOf(i+20);
			dataV6.setValue(valz); 
			dataGroup6.getData().add(dataV6);
		}
        
        
        
        
		
        List<DataGroup> datasets = new ArrayList<DataGroup>();
        datasets.add(dataGroup1);
        datasets.add(dataGroup2);
        datasets.add(dataGroup3);
        datasets.add(dataGroup4);
        datasets.add(dataGroup5);
        datasets.add(dataGroup6);
        
        OptionGroup optionGroup1 = new OptionGroup();
        optionGroup1.setSet("setSize");
        optionGroup1.setValue("1200, 600");
        
        OptionGroup optionGroup2 = new OptionGroup();
        optionGroup2.setSet("setAxisValuesNumberY");
        optionGroup2.setValue("33");
        
        OptionGroup optionGroup3 = new OptionGroup();
        optionGroup3.setSet("setIntervalStartY");
        optionGroup3.setValue("1");
        
        OptionGroup optionGroup4 = new OptionGroup();
        optionGroup4.setSet("setIntervalEndY");
        optionGroup4.setValue("33");
        
        
        
        OptionGroup optionGroup5 = new OptionGroup();
        optionGroup5.setSet("setLabelX");
        optionGroup5.setValue("[1,'18013']");        
        
        OptionGroup optionGroup6 = new OptionGroup();
        optionGroup6.setSet("setLabelX");
        optionGroup6.setValue("[2,'18012']");
        
        OptionGroup optionGroup7 = new OptionGroup();
        optionGroup7.setSet("setLabelX");
        optionGroup7.setValue("[3,'18011']");
        
        OptionGroup optionGroup8 = new OptionGroup();
        optionGroup8.setSet("setLabelX");
        optionGroup8.setValue("[4,'18010']");
        
        OptionGroup optionGroup9 = new OptionGroup();
        optionGroup9.setSet("setLabelX");
        optionGroup9.setValue("[5,'18009']");
        
        OptionGroup optionGroup20 = new OptionGroup();
        optionGroup20.setSet("setLabelX");
        optionGroup20.setValue("[6,'18008']");
        
        OptionGroup optionGroup21 = new OptionGroup();
        optionGroup21.setSet("setLabelX");
        optionGroup21.setValue("[7,'18007']");
        
        OptionGroup optionGroup22 = new OptionGroup();
        optionGroup22.setSet("setLabelX");
        optionGroup22.setValue("[8,'18006']");
        
        OptionGroup optionGroup23 = new OptionGroup();
        optionGroup23.setSet("setLabelX");
        optionGroup23.setValue("[9,'18005']");
        
        OptionGroup optionGroup24 = new OptionGroup();
        optionGroup24.setSet("setLabelX");
        optionGroup24.setValue("[10,'18004']");        
        
        OptionGroup optionGroup10 = new OptionGroup();
        optionGroup10.setSet("setAxisValuesNumberX"); //设置x轴显示日期数
        optionGroup10.setValue("10");
        
        
        
        OptionGroup optionGroup11 = new OptionGroup();
        optionGroup11.setSet("setShowXValues");
        optionGroup11.setValue("false");
        
        
        OptionGroup optionGroup12 = new OptionGroup();
        optionGroup12.setSet("setTitleColor");
        optionGroup12.setValue("'#454545'");
        
        OptionGroup optionGroup13 = new OptionGroup();
        optionGroup13.setSet("setAxisValuesColor");
        optionGroup13.setValue("'#454545'");
        
        OptionGroup optionGroup14 = new OptionGroup();
        optionGroup14.setSet("setLineColor");
        optionGroup14.setValue("'#00AA00', 'green'");
        
        OptionGroup optionGroup15 = new OptionGroup();
        optionGroup15.setSet("setLineColor");
        optionGroup15.setValue("'#BBBBBB', 'gray'");
        
        OptionGroup optionGroup16 = new OptionGroup();
        optionGroup16.setSet("setLineColor");
        optionGroup16.setValue("'#0000AA', 'blue'");
        
        OptionGroup optionGroup17 = new OptionGroup();
        optionGroup17.setSet("setLineColor");
        optionGroup17.setValue("'#000000', 'black'");
        
        OptionGroup optionGroup18 = new OptionGroup();
        optionGroup18.setSet("setLineColor");
        optionGroup18.setValue("'#FF0000', 'red'");
        
        OptionGroup optionGroup19 = new OptionGroup();
        optionGroup19.setSet("setLineColor");
        optionGroup19.setValue("'#FFFF00', 'yellow'");
        
        
        
        
        /*OptionGroup optionGroup16 = new OptionGroup();
        optionGroup16.setSet("setTooltip");
        optionGroup16.setValue("[1,' ']");
        
        OptionGroup optionGroup17 = new OptionGroup();
        optionGroup17.setSet("setTooltip");
        optionGroup17.setValue("[2,' ']");
        
        OptionGroup optionGroup18 = new OptionGroup();
        optionGroup18.setSet("setTooltip");
        optionGroup18.setValue("[3,' ']");
        
        OptionGroup optionGroup19 = new OptionGroup();
        optionGroup19.setSet("setTooltip");
        optionGroup19.setValue("[4,' ']");
        
        OptionGroup optionGroup20 = new OptionGroup();
        optionGroup20.setSet("setTooltip");
        optionGroup20.setValue("[5,' ']");
        
        OptionGroup optionGroup21 = new OptionGroup();
        optionGroup21.setSet("setTooltip");
        optionGroup21.setValue("[6,' ']");
        
        OptionGroup optionGroup22 = new OptionGroup();
        optionGroup22.setSet("setTooltip");
        optionGroup22.setValue("[7,' ']");
        
        OptionGroup optionGroup23 = new OptionGroup();
        optionGroup23.setSet("setTooltip");
        optionGroup23.setValue("[8,' ']");
        
        OptionGroup optionGroup24 = new OptionGroup();
        optionGroup24.setSet("setTooltip");
        optionGroup24.setValue("[9,' ']");
        
        OptionGroup optionGroup25 = new OptionGroup();
        optionGroup25.setSet("setTooltip");
        optionGroup25.setValue("[10,' ']");*/
        
        OptionGroup optionGroup26 = new OptionGroup();
        optionGroup26.setSet("setAxisValuesDecimals");
        optionGroup26.setValue("0");
        
        
        
        OptionGroup optionGroup27 = new OptionGroup();
        optionGroup27.setSet("setFlagColor");
        optionGroup27.setValue("'#9D16FC'");
        
       /* OptionGroup optionGroup28 = new OptionGroup();
        optionGroup28.setSet("setFlagRadius");
        optionGroup28.setValue("4");*/
        
        OptionGroup optionGroup29 = new OptionGroup();
        optionGroup29.setSet("setAxisPaddingRight");
        optionGroup29.setValue("100");
        
        OptionGroup optionGroup30 = new OptionGroup();
        optionGroup30.setSet("setLegendShow");
        optionGroup30.setValue("true");
        
        OptionGroup optionGroup31 = new OptionGroup();
        optionGroup31.setSet("setLegendPosition");
        optionGroup31.setValue("1100, 50");
        
        OptionGroup optionGroup32 = new OptionGroup();
        optionGroup32.setSet("setLegendForLine");
        optionGroup32.setValue("'blue', 'Click me'");
        
        OptionGroup optionGroup33 = new OptionGroup();
        optionGroup33.setSet("setLegendForLine");
        optionGroup33.setValue("'green', 'Click me'");
        
        OptionGroup optionGroup34 = new OptionGroup();
        optionGroup34.setSet("setLegendForLine");
        optionGroup34.setValue("'gray', 'Click me'");
        
        
        OptionGroup optionGroup35 = new OptionGroup();
        optionGroup35.setSet("setLegendForLine");
        optionGroup35.setValue("'black', 'Click me'");
        
        OptionGroup optionGroup36 = new OptionGroup();
        optionGroup36.setSet("setLegendForLine");
        optionGroup36.setValue("'red', 'Click me'");
        
        OptionGroup optionGroup37 = new OptionGroup();
        optionGroup37.setSet("setLegendForLine");
        optionGroup37.setValue("'yellow', 'Click me'");
        
        
        
        
        
        List<OptionGroup> optionset = new ArrayList<OptionGroup>();
        optionset.add(optionGroup1);
        optionset.add(optionGroup2);
        optionset.add(optionGroup3);
        optionset.add(optionGroup4);
        optionset.add(optionGroup5);
        optionset.add(optionGroup6);
        optionset.add(optionGroup7);
        optionset.add(optionGroup8);
        optionset.add(optionGroup9);
        optionset.add(optionGroup10);
        optionset.add(optionGroup11);
        optionset.add(optionGroup12);
        optionset.add(optionGroup13);
        optionset.add(optionGroup14);
        optionset.add(optionGroup15);
        optionset.add(optionGroup16);
        optionset.add(optionGroup17);
        optionset.add(optionGroup18);
        optionset.add(optionGroup19);
        optionset.add(optionGroup20);
        optionset.add(optionGroup21);
        optionset.add(optionGroup22);
        optionset.add(optionGroup23);
        optionset.add(optionGroup24);
        //optionset.add(optionGroup25);
        //optionset.add(optionGroup26);
        optionset.add(optionGroup27);
        //optionset.add(optionGroup28);
        optionset.add(optionGroup29);
        optionset.add(optionGroup30);
        optionset.add(optionGroup31);
        optionset.add(optionGroup32);
        optionset.add(optionGroup33);
        optionset.add(optionGroup34);
        optionset.add(optionGroup35);
        optionset.add(optionGroup36);
        optionset.add(optionGroup37);
		
		jc.setDatasets(datasets);
		jc.setOptionset(optionset);
		
		Map<String, Object> JSChart = new HashMap<String, Object>();
		JSChart.put("JSChart", jc);
		String jsonString = JSON.toJSONString(JSChart);
        System.out.println(jsonString);

	}

}
