package com.lcj.datamake.csv;

import java.util.List;

import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;


public class IphoneCallServiceTest {

	public static void main(String[] args) {
		try {			 
			IphoneCallServiceTest.testphoneCall();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void testphoneCall() throws Exception {
		System.out.println("testphoneCall");
		// 建立一个WebConversation实例
		WebConversation wc = new WebConversation();
		String urlfixed = "https://ip/services.aspx?op=phoneCall&appid=888666&Para=";
		//测试环境
		List<String> keyValueparaList = new TestReadObjectExcel().readTestExcel(Common.phoneCall_INFO_XLSX_PATH);
		for (int i=0;i<keyValueparaList.size();i++)
		{
			String para = keyValueparaList.get(i);
			String sendRequest = urlfixed + para;	
			WebRequest req = new GetMethodWebRequest(sendRequest);	
			// 获取响应对象    
			WebResponse resp = wc.getResponse(req);
			// 用getText方法获取相应的全部内容
			System.out.println(resp.getText());
		}		
		
	}
	
}
