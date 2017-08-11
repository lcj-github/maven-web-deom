package com.lcj.realuse.sfdata;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 
 * @author gaowei
 * 
 */
public final class MD5SignUtil {

	public static String getSignMsg(String clientId, String osn, String secretKey)
	  {
	    String md5Str = clientId + "," + osn + "," + secretKey;
	    String signatureMsg = DigestUtils.md5Hex(md5Str);

	    return signatureMsg;
	  }
	
	
	public static String getGTJASignMsg(String clientId, String tradeNo,String procDate,String secretKey)
	  {
	    String md5Str = clientId + "," + tradeNo + "," + procDate+ "," + "FIRSTFUNDIN"+ "," + secretKey;
	    String signatureMsg = DigestUtils.md5Hex(md5Str);

	    return signatureMsg;
	  }
	

	  public static void main(String[] args)
	  {
		  String s = getGTJASignMsg("100001", "10300", "20160804", "1qaz2wsx3edc");
		  System.out.println(s);
	    
	  }
}
