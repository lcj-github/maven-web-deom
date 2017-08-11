package com.lcj.realuse.sfdata;

import java.io.IOException;
import java.nio.charset.Charset;

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

import com.alibaba.fastjson.JSONObject;

public class OpenAcctCairenhui {
	
	private HttpPost method;
	private HttpClient httpClient;
	private String apiURL = "http://19.*.*.*:****/***/post***Step";
	
	@Before
	public void setUp() {
		method = new HttpPost(apiURL);
		httpClient   = new DefaultHttpClient();
		method.addHeader("Content-type","application/json; charset=utf-8");
		method.setHeader("Accept", "application/json");	
	}	
	 
	@Test
	public void testByC() throws Exception{
		String clientId = "";		 
		String mobile = "18133330003";	//手机号
		String osnStr = UUIDGenerator.getUUID();
		String secretKey = "c12";
		String signMsg = MD5SignUtil.getSignMsg(clientId, osnStr, secretKey);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("clientId",clientId);
		jsonObject.put("mobile", mobile);
		String reqJson = jsonObject.toString();
		System.out.println("reqJson==="+reqJson);
		String respBody = postJson(reqJson);
		System.out.println("respBody==="+respBody);
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
