package com.lcj.realuse.sfdata;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.lcj.util.AES;
import com.meterware.httpunit.GetMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;


/** 
 * @author Administrator
 *
 */
public class HlcTest {

	public static void main(String[] args) {
		try {	
			
			HlcTest.testAddRecord();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testAddRecord() throws Exception {
		System.out.println("testAddRecord");
		// 建立一个WebConversation实例
		WebConversation wc = new WebConversation();
		String urlfixed = "http://10.*.*.*/ci/ci.aspx?op=mobi&key=";		
		
		String remark = obtainAddRecordRemark("慧23","598bf8f026876");
		String keyAddRecord = obtainkeyAddRecord("Hlc8623",remark );
			 
		String sendRequest = urlfixed + keyAddRecord; 
		System.out.println("sendRequest="+sendRequest); 
		
		 // 向指定的URL发出请求
		WebRequest req = new GetMethodWebRequest(sendRequest);		
		// 获取响应对象
		WebResponse resp = wc.getResponse(req);		
		System.out.println(showResult(resp.getText())); 

   }

	public static String obtainAddRecordRemark(String truename,String bankcardno)
	{
		Map<String,String> remarkMap  = new HashMap<String,String>();
		if (truename.length()!=0)
		{
			remarkMap.put("truename", truename);
		}		
		if (bankcardno.length()!=0)
		{
			remarkMap.put("bankcardno", bankcardno);
		}
		int mapSize = remarkMap.size();		
		String remarkStr  = "{";
		Iterator<String> keys = remarkMap.keySet().iterator(); 
		while(keys.hasNext()) {	
		   mapSize--;	
		   String keyMap = (String) keys.next(); 
		   String value=remarkMap.get(keyMap);
		   remarkStr = remarkStr+"\"";
		   remarkStr = remarkStr.concat(keyMap);	
		   remarkStr = remarkStr+"\"";
		  remarkStr = remarkStr.concat(":");
		   remarkStr = remarkStr+"\"";
		   remarkStr = remarkStr.concat(value);
		   remarkStr = remarkStr+"\"";
		   if (mapSize != 0)
		   {
			   remarkStr =  remarkStr.concat(","); 
		   } 
		}
		remarkStr = remarkStr.concat("}");
		remarkStr = remarkStr .replaceAll("\"", "\'");
		return remarkStr;
	}
		
	public static String obtainkeyAddRecord(String userName,String remark) throws Exception
	{
		String key = "*.cn";
		String iv = "*.cn";		
		Map<String,String> strMap  = new HashMap<String,String>();
		strMap.put("UserName", userName);		
		strMap.put("Remark", remark);
		int mapSize = strMap.size();		
		String conStr  = "{";
		Iterator<String> keys = strMap.keySet().iterator(); 
		while(keys.hasNext()) {	
		   mapSize--;	
		   String keyMap = (String) keys.next(); 
		   String value=strMap.get(keyMap);
		   conStr = conStr+"\"";
		   conStr = conStr.concat(keyMap);	
		  conStr = conStr+"\"";
		   conStr = conStr.concat(":");
		   conStr = conStr+"\"";
		   conStr = conStr.concat(value);
		  conStr = conStr+"\"";
		   if (mapSize != 0)
		   {
			   conStr =  conStr.concat(","); 
		   } 
		}
		conStr = conStr.concat("}");		
		conStr = AES.encrypt(key, iv, conStr);
		conStr = conStr.replaceAll("\r|\n", "");
		return conStr;
	}		
	
	public static String showResult(String resp) throws Exception {	
		
		String jsonContent =   AES.decrypt("*.cn", "*.cn", resp);
		return jsonContent;		
		/*JSONObject jsonObject = new JSONObject(jsonContent);
		JSONObject jsonobject2=jsonObject.getJSONObject("BizData");
		JSONArray arry = jsonobject2.getJSONArray("result");
		JSONObject jsonObject3 = arry.getJSONObject(0);
		String mobile = jsonObject3.getString("mobile");	
		return mobile;*/
		
	}
	
	
	

	

}
