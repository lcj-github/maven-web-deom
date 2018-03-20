package com.lcj.testng;

import java.io.IOException;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

// 前端数据到 T_SECURITY_OPERATOR_STEP_RECEIVE ,status   为1 ，则转到 T_SECURITY_OPERATOR_STEP ，初始时，mobileAes是有值的，如果成功推送到安全入库，则为空
// 这两张表根据 osn 进行确认一条记录，T_SECURITY_OPERATOR_STEP 字段 id ，给安全入库 外网 T_MOBILE_BIND_INFO 表中 osn 字段
import com.alibaba.fastjson.JSONObject;
import com.lcj.fastjson.FastJsonUtils;
import com.lcj.realuse.sfdata.MD5SignUtil;
import com.lcj.util.AES;
import com.lcj.util.UUIDGenerator;

public class OpenAcctSd {
	
	private HttpPost method;
	private HttpClient httpClient;
	private String apiURL = "http://*.*.*.*:8080/dxd/cctStep";
	
	@SuppressWarnings("deprecation")
	@Before
	public void setUp() {
		method = new HttpPost(apiURL);
		httpClient   = new DefaultHttpClient();
		method.addHeader("Content-type","application/json; charset=utf-8");
		method.setHeader("Accept", "application/json");	
	}	
	
	@Test
	public void testNormal() throws Exception{
		String traderNo = "23300";      //券商号
		String mobile = "18511600025";	//手机号
		String clientId = "611111";      
		String secretKey = "s67";  
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");//设置日期格式
		String dateString = df.format(new Date());
		String osnStr = UUIDGenerator.getUUID();
		String signMsg = MD5SignUtil.getSignMsg(clientId, osnStr, secretKey);
		
		JSONObject jsonObject = new JSONObject();		
		jsonObject.put("version", "1.0");
		jsonObject.put("inputCharset","1");
		jsonObject.put("signType","1");
		jsonObject.put("userName","");
		jsonObject.put("custName","");			
		jsonObject.put("mobile", mobile);
		jsonObject.put("currentStep","login");
		jsonObject.put("currentStepDesc","登录");
		jsonObject.put("operatorTime",dateString);
		jsonObject.put("clientId",clientId);
		jsonObject.put("osn",osnStr);
		jsonObject.put("sourceNo", "27");            
		jsonObject.put("traderNo", traderNo);
		jsonObject.put("firmAcct", "000000000000");
		jsonObject.put("openAcctChannel", "1");
		jsonObject.put("childOpenAcctChannel", "16");
		String extResult = AES.encrypt("key", "iv", "{\"chilannel\":\"17\", \"node\":\"110\", \"type\":\"1\", \"data\":{\"fwdUserName\":\"khjz02706\",\"aaa\":111}}");
		jsonObject.put("ext", extResult);
		jsonObject.put("customerCode", "aaaaaaaab");
		String remarkResult = AES.encrypt("key", "iv", "{\"sd_sex\":\"性别\",\"sd_risklevel\":\"风险等级\"}");
		jsonObject.put("remark", remarkResult);
		jsonObject.put("signMsg", signMsg);
		
		String reqJson = jsonObject.toString();
		System.out.println("reqJson==="+reqJson);
		
		String respBody = postJson(reqJson);
		System.out.println("respBody==="+respBody);
		
		Object obj = FastJsonUtils.textToJson(respBody);
		System.out.println(obj);
		
	}
	
	private String postJson(String parameters){		 
		String respBody = null;		
		method.setEntity(new StringEntity(parameters, Charset.forName("UTF-8")));
		try {
			HttpResponse response = httpClient.execute(method);
			respBody =  EntityUtils.toString(response.getEntity());
		} catch (ParseException | IOException e) {
			e.printStackTrace();
		}
		return respBody;
	}
	
	@After
	public void tearDown()   {
		method = null;
		httpClient   = null;
	}
	
  

}
