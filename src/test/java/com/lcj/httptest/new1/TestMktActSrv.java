package com.lcj.httptest.new1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;

public class TestMktActSrv {

	private static final int readTimeOut = 30000;
	private static final int connectTimeOut = 30000;
	private final static String serviceUrl = "http://localhost:8080/services/alapi";
 
	
	public  static MobileBindResDto doGet(DataDto dto) {
		
		MobileBindResDto res = null;
		
		try {
			List<NameValuePair> paras = new ArrayList<NameValuePair>();
			System.out.println("JSON串："+JSON.toJSONString(dto));
			paras = buildReq(JSON.toJSONString(dto), "binndMobi");
			res = HttpHelper.httpGetExecute(serviceUrl, paras, new ResponseHandler<MobileBindResDto>() {
				@Override
				public MobileBindResDto handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
					StatusLine statusLine = response.getStatusLine();	
					HttpEntity dealEntity = response.getEntity();
					String body = null;
					MobileBindResDto res = null;
					if(200==statusLine.getStatusCode()){											
						body = EntityUtils.toString(dealEntity);						 
						res = JSON.parseObject(StringUtils.trim(body), MobileBindResDto.class);					
						EntityUtils.consume(dealEntity);
					}else if (statusLine.getStatusCode() >= 300) {						
			            EntityUtils.consume(dealEntity);
			            throw new HttpResponseException(statusLine.getStatusCode(),
			                    statusLine.getReasonPhrase());				        
					}
					return res;
				}			
			}, readTimeOut, connectTimeOut);
			
		}catch(Exception ex){
			throw new RuntimeException(ex);
		}	
		return res;
	}
	
	 private static List<NameValuePair> buildReq(String paramString, String type)
			throws Exception {
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("op", type));
		params.add(new BasicNameValuePair("key", paramString));
		return params;
	}
	
	 
	public static void main(String[] args) {
		DataDto dto = new DataDto();
		dto.setChannel("web");
		 
		dto.setRemark("{\"custName\":\"\",\"operateTime\":\"2016-08-22\",\"currentStep\":\"11\",\"currentStepDesc\":\"success\",\"childOpenacctChannel\":\"16\",\"node\":\"1638\"}");
		dto.setOSN("0002");
//		System.out.println(JSONObject.toJSONString(dto));
		System.out.println(doGet(dto));
	}
	
}
