package com.lcj.util.gat;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpClientHelper {
	
	 private static  HttpClientContext context = null;
	   
	   private static CloseableHttpClient httpClient=null;
		
	   /**
	    * 
	    * @param url
	    * @param isGet boolean
	    * @return
	    * @throws Exception
	    */
	   public static String getResponseText(String url,Boolean isGet) throws Exception
	   {
		   String resultString="";
		   if(isGet)
		   {
			   resultString=getResponseText(getmethod(url));
		   }
		   else
		   {
			   resultString=getResponseText(postmethod(url));
		   }
		   return resultString;
		   
	   }
	   
	   public static void cleanContext()
	   {
		   HttpClientHelper.context=null;
		   HttpClientHelper.httpClient=null;
	   } 	   
	   
	   /**
	    * 
	    * @return
	    */
	   public static List<URI> getRedrectURL()
	   {
		   return context.getRedirectLocations();
	   }
	   
	   /**
	    * 
	    * @param filePath
	    * @param url
	    * @param filedataname
	    */
	   public static String uploadFile(String filePath,String url,String fileInputFieldName)
	   {
		   String  result="";
		   try 
		   {  
			   HttpClientHelper.createClient();
			   HttpClientHelper.createContext();
			   HttpPost httppost=new HttpPost(url);
	           FileBody bin = new FileBody(new File(filePath)); 
	           MultipartEntity reqEntity = new MultipartEntity();
	           reqEntity.addPart(fileInputFieldName, bin);
	           httppost.setEntity(reqEntity);  
	           HttpResponse response = httpClient.execute(httppost);     
	           int statusCode = response.getStatusLine().getStatusCode();
	           HttpEntity resEntity = response.getEntity();  
	           result=EntityUtils.toString(resEntity);//
	           EntityUtils.consume(resEntity);
	       } 
		   catch (Exception e) 
		       {  
	               result=e.getMessage();
	           }
		   finally 
		   {  
			   try {
				httpClient.close();
				httpClient.getConnectionManager().shutdown(); 
				HttpClientHelper.cleanContext();
			} catch (Exception e) {
			}
	       } 
		   return result;
	   }
	   
	   
	   
	   
	   /**
	    * 
	    * @param url
	    * @return
	    * @throws ClientProtocolException
	    * @throws Exception
	    */
	   private static CloseableHttpResponse getmethod(String url) throws ClientProtocolException, Exception
	   {
		    HttpClientHelper.createClient();
		    HttpClientHelper.createContext();
		    HttpGet httpGet = new HttpGet(url);
		    CloseableHttpResponse response = httpClient.execute(httpGet,context);
		    return response;
	   }
	   
	   /**
	    * 
	    * @param url
	    * @return
	    * @throws ClientProtocolException
	    * @throws Exception
	    */
	   private static CloseableHttpResponse postmethod(String url) throws ClientProtocolException, Exception
	   {
		    HttpClientHelper.createClient();
		    HttpClientHelper.createContext();
		    HttpPost httpGet = new HttpPost(url);
		    CloseableHttpResponse response = httpClient.execute(httpGet,context);
		    return response;
	   }
	   
	   /**
	    * 
	    */
	   private static void  createContext()
	   {
		   if(HttpClientHelper.context==null)
		   {
			   HttpClientHelper.context=HttpClientContext.create();
		   }
	   }
	   
	   private static void createClient()
	   {
		   if(HttpClientHelper.httpClient==null)
		   {
			   HttpClientHelper.httpClient=HttpClients.createDefault();
		   }
	   }
	   
	   /**
	    * 
	    * @param response
	    * @return
	    * @throws Exception
	    */
	   private static String getResponseText(CloseableHttpResponse response) throws Exception
	   {
		    StringBuilder textView=new StringBuilder();
		    BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent())); 
		    String line = "";
		    while ((line = rd.readLine()) != null) 
		    {
		    	textView.append(line);
		    } 
	      response.close();
	      return textView.toString();
	   }

}
