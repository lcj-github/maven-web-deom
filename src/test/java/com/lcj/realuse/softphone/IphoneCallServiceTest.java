package com.lcj.realuse.softphone;

import java.util.List;

import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;

/**
 * 电话服务
 * @author Administrator
 *
 */
public class IphoneCallServiceTest {

	public static void main(String[] args) {
		try {
			//  
			IphoneCallServiceTest.testphoneCall();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	public static void testphoneCall() throws Exception {
		System.out.println("testphoneCall");		
		// 建立一个WebConversation实例
		WebConversation wc = new WebConversation();		
		//测试环境  https
		String urlfixed = "https://ts**.**.com.cn/crmapispex.aspx?op=phoneCall&appid=**&Para=";				
		List<String> keyValueparaList = new TestReadObjectExcel().readTestExcel(Common.phoneCall_INFO_XLSX_PATH);
		for (int i=0;i<keyValueparaList.size();i++)
		{
			String para = keyValueparaList.get(i);
			System.out.println("para=="+para);
			String paraR = replacePara(para);			
			String sendRequest = urlfixed + paraR;		// 向指定的URL发出请求
			System.out.println("sendRequest=="+sendRequest);		
	
			WebRequest req = new GetMethodWebRequest(sendRequest);	
			// 获取响应对象    
			WebResponse resp = wc.getResponse(req);
			// 用getText方法获取相应的全部内容
			System.out.println(showResult(resp.getText()));
		}	
		
	}	
	
	public static String replacePara(String para) throws Exception 
	{
		String key = "crmsoftphone";
		String iv = "crmsoftphone";
		
		String repPara = para;
		if (para.contains("'callType':'2'"))
		{
			repPara = repPara.replace("'callType':'2'", "'callType':2");
		}
		if (para.contains("'callType':'1'"))
		{
			repPara = repPara.replace("'callType':'1'", "'callType':1");
		}
		if (para.contains("'callType':'3'"))
		{
			repPara = repPara.replace("'callType':'3'", "'callType':3");
		}
		if (para.contains("'callType':'4'"))
		{
			repPara = repPara.replace("'callType':'4'", "'callType':4");
		}
		if (para.contains("'callType':'11'"))
		{
			repPara = repPara.replace("'callType':'11'", "'callType':11");
		}	
		
		repPara = AES.encrypt(key, iv, repPara);
		repPara = repPara.replaceAll("\r|\n", "");
		return repPara;
	}
	

	

	public static String showResult(String resp) throws Exception {
 
		return AES.decrypt("crmsoftphone", "crmsoftphone", resp);
	}

}
