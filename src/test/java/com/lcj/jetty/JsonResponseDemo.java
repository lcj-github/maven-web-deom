package com.lcj.jetty;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JsonResponseDemo extends HttpServlet {
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override  
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {  
	         	         
	          
	        String resultJson = "[{\"id\":\"0375\",\"city\":\"平顶山\"},{\"id\":\"0377\",\"city\":\"南阳\"}]";
	        //响应json格式字符串  
	        OutPrinterUtil.outputJson(resultJson, resp);  
	    }  
	  
	    @Override  
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {  
	        doPost(req, resp);  
	    }  

}
