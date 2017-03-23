package com.lcj.jetty;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class XmlResponseDemo  extends HttpServlet{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override  
	    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {  
	            StringBuilder builder = new StringBuilder(1024);  
	            bindBuilder(builder);	            
	            //响应xml格式字符串  
	            OutPrinterUtil.outputXml(response, builder);  
	    }
	 
	 @Override  
	    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {  
	        //同doPost方法  
	        doPost(request, response);  
	    }  
	 
	 private void bindBuilder(StringBuilder builder) {  
	        builder.append("<?xml version=\"1.0\" encoding=\"utf-8\"?><notifyRsp>");  
	        builder.append("<transId>" + "cs112233" + "</transId>");  
	        builder.append("<processTime>" + "230ms" + "</processTime>");  
	        builder.append("<cpId>710302</cpId>");  
	        builder.append("<bulletinType>1</bulletinType>");  
	        builder.append("<bulletinID>1</bulletinID>");  
	        builder.append("<bulletinID>1</bulletinID>");  
	        builder.append("<returnCode>0000</returnCode>");  
	        builder.append("<bulletinTitle>停电公告</bulletinTitle>");  
	        builder.append("<bulletinCont>十月31号停电</bulletinCont>");  
	        builder.append("<publishTime>20151021101212</publishTime>");  
	        builder.append("<publishType>0</publishType>");  
	        builder.append("<bulletinLevel>0</bulletinLevel>");  
	        builder.append("<contactType>1</contactType>");  
	        builder.append("<needReply>1</needReply>");  
	        builder.append("<adminName> 管理员 </adminName >");  
	        builder.append("<bulletinAttachs>");  
	        builder.append("<bulletinAttach>");  
	        builder.append("<attachName> 附件1 </attachName >");  
	        builder.append("<attachType> 1 </attachType >");  
	        builder.append("<attachURL> ftp://192.168.1.1/test.doc</attachURL>");  
	        builder.append("</bulletinAttach>");  
	        builder.append("<bulletinAttach>");  
	        builder.append("<attachName> 附件2 </attachName >");  
	        builder.append("<attachType> 2 </attachType >");  
	        builder.append("<attachURL > ftp://192.168.1.1/test2.doc</attachURL>");  
	        builder.append("</bulletinAttach >");  
	        builder.append("</bulletinAttachs >");  
	        builder.append("<replys >");  
	        builder.append("<reply >");  
	        builder.append("<replyTime > 20151011121212 </replyTime >");  
	        builder.append("<replyType > 1 </replyType >");  
	        builder.append("<replyCont > CP回复测试1 </replyCont >");  
	        builder.append("<replyAttchs >");  
	        builder.append("<replyAttch >");  
	        builder.append("<attachName > 附件1 </attachName >");  
	        builder.append("<attachURL > ftp://192.168.1.1/test.doc</attachURL>");  
	        builder.append("</replyAttch >");  
	        builder.append("</replyAttchs >");  
	        builder.append("</reply >");  
	        builder.append("<reply >");  
	        builder.append("<replyTime > 20151011121212 </replyTime >");  
	        builder.append("<replyType > 2 </replyType >");  
	        builder.append("<replyCont > 管理员回复测试1 </replyCont >");  
	        builder.append("<replyAttchs >");  
	        builder.append("<replyAttch >");  
	        builder.append("<attachName > 附件1 </attachName >");  
	        builder.append("<attachURL > ftp://192.168.1.1/test.doc</attachURL>");  
	        builder.append("</replyAttch >");  
	        builder.append("</replyAttchs >");  
	        builder.append("</reply >");  
	        builder.append("</replys >");  
	        builder.append("</notifyRsp>");  
	    }  

}
