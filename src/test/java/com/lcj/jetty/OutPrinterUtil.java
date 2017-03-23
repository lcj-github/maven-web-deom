package com.lcj.jetty;


import org.eclipse.jetty.server.Request;  

import java.io.IOException;  
import java.io.PrintWriter;  

import javax.servlet.http.HttpServletResponse;  
public class OutPrinterUtil {
	
	/** 
     * 响应xml格式字符串 
     *  
     * @param response 
     * @param result 
     * @throws IOException 
     */  
    public static void outputXml(HttpServletResponse response, StringBuilder result) throws IOException {  
        // response.setContentType("application/xml");  
        response.setCharacterEncoding("UTF-8");  
        response.setStatus(HttpServletResponse.SC_OK);  
        System.err.println("响应码为："+HttpServletResponse.SC_OK);  
        PrintWriter pw = response.getWriter();  
        pw.print(result.toString());  
        pw.flush();  
        pw.close();  
    }  
  
    /** 
     * 响应json格式字符串 
     *  
     * @param json 
     * @param response 
     */  
    public static void outputJson(String json, HttpServletResponse response) {  
        try {  
            response.setCharacterEncoding("UTF-8");  
            // json串必须要是json格式，否则会出错  
            response.setContentType("application/json");  
              
            //在代理服务器端防止缓冲  
            response.setDateHeader("Expires", 0);  
            PrintWriter out = response.getWriter();  
            out.print(json);  
            out.flush();  
            out.close();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
  
    /** 
     * 需要返回给用户的结果不支持session 
     *  
     * @param baseRequest 
     * @param response 
     * @param result 
     * @throws IOException 
     */  
    public static void outputNoSession(Request baseRequest, HttpServletResponse response, String result)  
            throws IOException {  
        response.setContentType("text/json;charset=utf-8");  
        response.setStatus(HttpServletResponse.SC_OK);  
        baseRequest.setHandled(true);  
        response.getWriter().println(result);  
    }  
  
    /* 
     * private OutPrinterUtil() { super(); } 
     */

}
