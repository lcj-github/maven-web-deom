package com.lcj.httptest;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.alibaba.fastjson.JSONObject;

//参考：https://www.jianshu.com/p/3b6d7aa2043a
public class HttpClientCTypeTest {

	//contentType:application/x-www-form-urlencoded ; post请求最常见也是默认的数据提交格式
	public static void contentTypeT1() throws ClientProtocolException, IOException{
		List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();     //定义键值对列表，用于存放向url发送post请求的数据。        
		params.add(new BasicNameValuePair("parameter1", "12345"));        
		params.add(new BasicNameValuePair("parameter2", "23456"));               //向params设置数据       
		HttpEntity reqEntity = new UrlEncodedFormEntity(params);                 //用UrlEncodedFormEntity对象包装请求体数据 
		
		HttpPost post = new HttpPost("http://example.com");                      //定义HttpPost对象并初始化它  
		post.setEntity(reqEntity);                                               //设置post请求实体        
		HttpClient client = new DefaultHttpClient();
		HttpResponse response = client.execute(post);                            //发送http请求        
		System.out.println("the request body is:"+EntityUtils.toString(reqEntity));          //打印出请求实体        
		System.out.println(response.getStatusLine().getStatusCode()); 
	}
	
	//contentType: application/json
	public static void contentTypeT2() throws ClientProtocolException, IOException{
		    
		 JSONObject js = new JSONObject();                                  //定义一个JSON数据格式对象，用其保存请求主体数据。
		 js.put("parameter1", "12345");                                 //为JSON对象的各个key值赋值
		 js.put("parameter2","23456");
		 String postRequest = js.toString();		 
		 StringEntity reqEntity = new StringEntity(postRequest);           //用StringEntity对象包装请求体数据 
		 reqEntity.setContentType("application/json"); 
		 
		 HttpPost post = new HttpPost("http://example.com");   //定义HttpPost对象并初始化它   
		 post.setEntity(reqEntity);  //设置post请求实体 
		 HttpClient client = new DefaultHttpClient();
		 HttpResponse response = client.execute(post);                       //发送http请求
		 System.out.println("the request body is:"+EntityUtils.toString(reqEntity));            //打印出请求实体
		 System.out.println(response.getStatusLine().getStatusCode());  
		 
	}
	
	//contentType: text/xml
	public static void contentTypeT3() throws ClientProtocolException, IOException{
		  
		Document doc = DocumentHelper.createDocument();                           //创建document对象
		Element book = doc.addElement("book");                                    //构建document对象各个节点
		book.addElement("title").addText("titleView");
		book.addElement("author").addText("authorView");
		String body = book.asXML();                                               //Document对象转成string类型
		StringEntity reqEntity = new StringEntity(body);                          //用StringEntity对象包装请求体数据
		reqEntity.setContentType("text/xml");                                     //设置请求头数据传输格式
		reqEntity.setContentEncoding("utf-8"); 
		
		//设置请求头数据编码格式
		HttpPost post = new HttpPost("http://example.com");                       //定义HttpPost对象并初始化它   
		post.setEntity(reqEntity);    
		HttpClient client = new DefaultHttpClient(); 
		//设置post请求实体
		HttpResponse response = client.execute(post);                             //发送http请求
		System.out.println("the request body is:"+EntityUtils.toString(reqEntity));   //打印出请求实体
		System.out.println(response.getStatusLine().getStatusCode());                 //打印http请求返回码
	}
	
	
	
	//contentType: multipart/form-data
	public static void contentTypeT4() throws ClientProtocolException, IOException{
			
		MultipartEntity mutiEntity = new MultipartEntity();           //定义MultipartEntity对象
		File file = new File("C:\\Users\\hzsuixiang\\Desktop\\image_20151117151539.png");
		mutiEntity.addPart("desc",new StringBody("网易云阅读", Charset.forName("utf-8")));     //设置multiEntity对象的主体数据
		mutiEntity.addPart("pic", new FileBody(file));
		
		HttpPost post = new HttpPost("http://example.com");           //定义HttpPost对象并初始化它
		post.setEntity(mutiEntity);             //设置post请求主体
		HttpClient client = new DefaultHttpClient();
		HttpResponse  httpResponse = client.execute(post);                                   //执行post请求
		HttpEntity httpEntity =  httpResponse.getEntity();		
	}
	
	
	public static void main(String[] args) throws ClientProtocolException, IOException {
		contentTypeT1() ;   //parameter1=12345&parameter2=23456
		contentTypeT2() ; //{"parameter2":"23456","parameter1":"12345"}
		contentTypeT3() ;   //<book><title>titleView</title><author>authorView</author></book>
	}
	
	
}
