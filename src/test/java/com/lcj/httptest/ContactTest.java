package com.lcj.httptest;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

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
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lcj.util.ConfigUtil;
import com.lcj.util.JTestF;


@RunWith(Parameterized.class)
public class ContactTest {
	
	//envirenment
		private static String ip = ConfigUtil.getConfig("ip");
		private static String port=ConfigUtil.getConfig("port");
		private static String protocol="http://"; //http or https,default http
		private static String mysqlurl=ConfigUtil.getConfig("mysqlurl");
		private static String mysqluser=ConfigUtil.getConfig("mysqluser");
		private static String mysqlpwd=ConfigUtil.getConfig("mysqlpwd");
		private static String mysqlquery=ConfigUtil.getConfig("mysqlquery");
		
		private String apiURLPrx =protocol+ip+":"+port;
		private HttpPost method;
		private HttpClient httpClient;
		
		//需要传入testcase的参数
		private String path;
		private String params;
		private String expect;
		
		
		
		//set environment,run only once 
		static{
			//System.out.println("11111111");
			
		}
		
		
		public  ContactTest(String path,String params,String expect) {
			// TODO Auto-generated constructor stub
			this.path=apiURLPrx+path;
			this.params=params;
			this.expect=expect;
		}

		public static Object[][]  getDataFromMysql() throws ClassNotFoundException, SQLException{
			JTestF jtest=new JTestF(ip, port, protocol);
			JSONArray ts=jtest.getTestcases(mysqlurl, mysqluser, mysqlpwd, mysqlquery);
			
			int i=0;
			List  testdatArrayList = new ArrayList();
			for(;i < ts.size(); i++){
				JSONObject jObject=ts.getJSONObject(i);
				Object[] testcase = {jObject.getString("command"), jObject.getString("prams"),jObject.getString("expectoutput")};
				testdatArrayList.add(testcase);
			}
			
			String[][] retStrings=new String[testdatArrayList.size()][];
			for(int index=0; index<testdatArrayList.size(); index++)
			{
			      Object[] s = (Object[])testdatArrayList.get(index);
			      retStrings[index] = new String[s.length];
			      for(int j=0;j<s.length;j++){
			    	  retStrings[index][j] = (String) s[j];
			      }
			}
			return retStrings;
		}
		
		//准备测试参数。参数集合（二维数组）中的所有行将被执行,
		//且每一行的参数必须与构造函数的参数一一对应
		@SuppressWarnings("rawtypes")
		@Parameters
		public static Collection prepareData() throws ClassNotFoundException, SQLException{
			Object[][] collectionObjects=getDataFromMysql();
			return Arrays.asList(collectionObjects);
		}
		
		/**
		 * @throws java.lang.Exception
		 */
		@Before
		public void setUp() throws Exception {
			method = new HttpPost(path);
			httpClient   = new DefaultHttpClient();
			method.addHeader("Content-type","application/json; charset=utf-8");
			method.setHeader("Accept", "application/json");	
			
		}

		/**
		 * @throws java.lang.Exception
		 */
		@After
		public void tearDown() throws Exception {
			method = null;
			httpClient   = null;
		}
		
		@Test
		public void testByAccountNormal() throws ParseException, IOException
		{			
			method.setEntity(new StringEntity(params, Charset.forName("UTF-8")));
			HttpResponse response = httpClient.execute(method);
			String respBody  =  EntityUtils.toString(response.getEntity());				
	        assertTrue("实际结果应该与预期相符合！", respBody.indexOf(expect) >= 0);	        
		}
		
		
}
