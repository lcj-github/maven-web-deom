package com.lcj.httptest.new1;

import java.net.URI;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.lcj.util.HttpClientConfig;




public class HttpHelper {
	
	public static <T> T httpGetExecute(String serverUrl, List<NameValuePair> paras, ResponseHandler<T> handler, int readTimeout, int connectTimeout ) throws Exception{
		
		HttpGet httpget = new HttpGet(serverUrl);
		String queryStr = EntityUtils.toString(new UrlEncodedFormEntity(paras, "UTF-8"));
		String uriStr = httpget.getURI().toString();
		if(StringUtils.contains(httpget.getURI().toString(), "?")){
			uriStr+="&"+queryStr;
		}else{
			uriStr+="?"+queryStr;
		}
		httpget.setURI(new URI(uriStr)); 
		
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		RequestConfig requestConfig = RequestConfig.custom().
					setSocketTimeout(readTimeout==0?HttpClientConfig.readTimeout:readTimeout)
					.setConnectTimeout(connectTimeout==0?HttpClientConfig.connectTimeout:connectTimeout).build();//设置请求和传输超时时间
		httpget.setConfig(requestConfig);
		CloseableHttpResponse response = httpClient.execute(httpget);
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			try {
				return handler.handleResponse(response);
			} finally {
				try{
				response.close();
				httpClient.close();
				}catch(Exception e){
					// do nothing
				}
			}
		}
		return null;
	}
	
	public static <T> T httpPostExecute(String serverUrl, List<NameValuePair> paras, ResponseHandler<T> handler, int readTimeout, int connectTimeout ) throws Exception{
		HttpPost httpPost = new HttpPost(serverUrl);
		httpPost.setEntity(new UrlEncodedFormEntity(paras,"UTF-8"));
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		RequestConfig requestConfig = RequestConfig.custom().
					setSocketTimeout(readTimeout==0?HttpClientConfig.readTimeout:readTimeout)
					.setConnectTimeout(connectTimeout==0?HttpClientConfig.connectTimeout:connectTimeout).build();//设置请求和传输超时时间
		httpPost.setConfig(requestConfig);
		CloseableHttpResponse response = httpClient.execute(httpPost);
		HttpEntity entity = response.getEntity();
		if (entity != null) {
			try {
				return handler.handleResponse(response);
			} finally {
				try{
				response.close();				
				httpPost.releaseConnection();
				httpClient.close();
				}catch(Exception e){
					// do nothing
				}
			}
		}
		return null;
	}
	

}
