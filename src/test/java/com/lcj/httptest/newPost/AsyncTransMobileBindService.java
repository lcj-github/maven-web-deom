package com.lcj.httptest.newPost;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;


public class AsyncTransMobileBindService {

	
	
	private TransmitBindInfoRes doPost(String key) throws Exception {
		HttpPost httpPost = new HttpPost(HttpURLHelper.getUrl(HttpURLHelper.TRANSMIT_DATA_URL));
		CloseableHttpClient httpClient = null;
		 
		TransmitBindInfoRes res = null;
		
		try {			
			List<NameValuePair> paras = buildParameters(key);
			
			httpPost.setEntity(new UrlEncodedFormEntity(paras,Consts.UTF_8));

			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(25000).setConnectTimeout(25000).build();//设置请求和传输超时时间
			httpPost.setConfig(requestConfig);
			httpClient = HttpClientBuilder.create().build();
			
			res = httpClient.execute(httpPost,new ResponseHandler<TransmitBindInfoRes>(){
				public TransmitBindInfoRes handleResponse(HttpResponse response)
						throws ClientProtocolException, IOException {
					StatusLine statusLine = response.getStatusLine();
					final HttpEntity entity = response.getEntity();
					String body = null;
					if(200==statusLine.getStatusCode()){
						HttpEntity dealEntity = response.getEntity();
						String charset = EntityUtils.getContentCharSet(dealEntity);
						charset = StringUtils.isEmpty(charset)?"utf-8":charset;
						body = EntityUtils.toString(dealEntity,charset);
						
						EntityUtils.consume(dealEntity);
					}else if (statusLine.getStatusCode() >= 300) {
			            EntityUtils.consume(entity);
			            throw new HttpResponseException(statusLine.getStatusCode(),
			                    statusLine.getReasonPhrase());
			        }
					TransmitBindInfoRes result = convertToRes(body);
					return result;
				}
			}); 
			
		} catch (HttpResponseException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if (httpClient != null) {
					httpClient.close();
				}
			} catch (Exception e) {
				 
			}
		}
		
		return res;
	}


	protected List<NameValuePair> buildParameters(String key) throws Exception {
		List<NameValuePair> paras = new ArrayList<NameValuePair>();
		addWhenNotEmpty(paras, "key",key);
		return paras;
	}
	
	private void addWhenNotEmpty(List<NameValuePair> paras, String key, String value){
		if(StringUtils.isNotEmpty(value)){
			paras.add(new BasicNameValuePair(key, value));
		}
	}
	
	private TransmitBindInfoRes convertToRes(String body) {
		 
		return JSON.parseObject( StringUtils.trim(body), TransmitBindInfoRes.class);
	}
	
}
