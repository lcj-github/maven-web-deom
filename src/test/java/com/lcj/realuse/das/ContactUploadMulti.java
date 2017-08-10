package com.lcj.realuse.das;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.xml.sax.SAXException;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableMap;
import com.meterware.httpunit.PostMethodWebRequest;
import com.meterware.httpunit.WebConversation;
import com.meterware.httpunit.WebResponse;



public class ContactUploadMulti {
	
	public  static byte[] wrapUploadInfo(String username,String  qudaohao,Map<String,String> contactz_mobile_name) 
			throws IOException, SAXException  {
		
		int u = username.getBytes().length;
		int q = qudaohao.getBytes().length;
		
		int mobileLen = 0;
		int mobileNameLen = 0;
		
		for (Map.Entry<String, String> entry : contactz_mobile_name.entrySet()) { 
			String mobile = entry.getKey(); 
			mobileLen += mobile.getBytes().length;
			mobileLen += 1;
			String mobileName = entry.getValue(); 
			mobileNameLen += mobileName.getBytes().length;
			mobileNameLen += 1;
		}
		int contactMoibleLen = mobileLen+mobileNameLen;		
		int len = 1 + u + 1 + q +contactMoibleLen;	
		
		ByteBuffer orionBf = ByteBuffer.allocate(len);
		
		orionBf.order(ByteOrder.LITTLE_ENDIAN);
		int offset = 0;
		
		orionBf.put((byte) u);
		offset++;
		orionBf.position(offset);
		
		orionBf.put(username.getBytes());
		offset += u;
		orionBf.position(offset);
		
		orionBf.put((byte) q);
		offset++;
		orionBf.position(offset);
		
		orionBf.put(qudaohao.getBytes());
		offset += q;
		orionBf.position(offset);
		
		
		for (Map.Entry<String, String> entry : contactz_mobile_name.entrySet()) { 
			String mobile = entry.getKey();
			String mobileName = entry.getValue(); 
			
			byte[] mobileByte = mobile.getBytes();
			byte[] mobileNameByte = mobileName.getBytes();
			int mobileByteLen = mobileByte.length;
			int mobileNameByteLen = mobileNameByte.length;
			
			// 通讯录手机及名称
			orionBf.put((byte) mobileByteLen);
			offset++;
			orionBf.position(offset);
			
			orionBf.put(mobileByte);
			offset += mobileByteLen;
			orionBf.position(offset);
			
			orionBf.put((byte) mobileNameByteLen);
			offset++;
			orionBf.position(offset);
			
			orionBf.put(mobileNameByte);
			offset += mobileNameByteLen;
			orionBf.position(offset);			
			
		}		
		
		
		System.out.println("====发送的初始原内容 start ====");
		Readunsignedbyte.Parry(orionBf.array());
		System.out.println("发送的初始原内容长度为:"+orionBf.array().length);		
		System.out.println("====发送的初始原内容 end ====");		
	
		//对原始内容 orionBf 进行 GZIP压缩
		byte[] gzipClearText = GZipUtils.compress(orionBf.array());	
		int gzipClearTextLen = gzipClearText.length;
		byte[] gzipClearTextBwei = getBuweiAft(gzipClearText);
		
		//通讯录AES密文
		String key = getRandomKey("key");
		String iv = getRandomIV("iv");
		byte[] ivBytes = iv.getBytes();
		int ivLen = ivBytes.length;
		// 通讯录aes加密		
		byte aes[]=AesEncrypt.endecrypt(gzipClearTextBwei, key, iv,true);
		int aesLen=aes.length;	
		
		System.out.println("====通讯录AES密文 start ====");
		Readunsignedbyte.Parry(aes);
		System.out.println("通讯录AES长度为:"+aesLen);		
		System.out.println("====通讯录AES密文 end ====");		
		
		System.out.println("====AES明文IV（16个字节） start ====");
		Readunsignedbyte.Parry(ivBytes);
		System.out.println("通讯录AES长度为:"+ivLen);		
		System.out.println("====AES明文IV（16个字节）  end ====");		
		
		System.out.println("====通讯录明文长度（4个字节） start ====");
		System.out.println("补位前--gzip压缩通讯录明文长度:"+gzipClearTextLen);
		Readunsignedbyte.Parry(gzipClearText);
		System.out.println("补位后--gzip压缩通讯录明文长度:"+gzipClearTextBwei.length);
		Readunsignedbyte.Parry(gzipClearTextBwei);		
		System.out.println("====通讯录明文长度（4个字节） end ====");		
		
		String pubkey = getContactPubkey();
		// 针对key进行rsa加密
		RsaEncrypt RsaEncrypt = new RsaEncrypt();
		byte keyRsa[] = RsaEncrypt.RsaEncrypt(pubkey, key.getBytes());
		int keyRsaLen = keyRsa.length;
		System.out.println("====AES密码的RSA格式密文 start ====");
		Readunsignedbyte.Parry(keyRsa);
		System.out.println("RSA密文长度（4个字节）:"+keyRsaLen);		
		System.out.println("====AES密码的RSA格式密文 end ====");		
		
		
		// 组装后的数据		
		int lencry = 4+keyRsaLen+4+ivLen+aesLen;
		ByteBuffer aa = ByteBuffer.allocate(lencry);		
		aa.order(ByteOrder.LITTLE_ENDIAN);
		int offsetWrap = 0;		
		aa.putInt(keyRsaLen);
		offsetWrap += 4;
		aa.position(offsetWrap);
		
		aa.put(keyRsa);
		offsetWrap += keyRsaLen;
		aa.position(offsetWrap);
		
			
		aa.putInt(gzipClearTextLen);
		offsetWrap += 4;
		aa.position(offsetWrap);
		
		aa.put(ivBytes);
		offsetWrap +=ivLen;
		aa.position(offsetWrap);
		
		aa.put(aes);
		offsetWrap += aesLen;
		aa.position(offsetWrap);	
		
		byte[] reqByte =  aa.array(); 
		
		System.out.println("====最终请求串 start ====");

		Readunsignedbyte.Parry(reqByte);
		System.out.println("最终请求串长度为:"+reqByte.length);
		
		System.out.println("====最终请求串 end ====");
		
		
		
		return reqByte;

	}
	
	
	
	
	public static byte[] getBuweiAft(byte[] source) {
		int newlen = (source.length + 15) / 16 * 16;		
		byte[] arrBTmp = source;
		byte[] arrB = new byte[newlen]; // 创建一个空的16位字节数组（默认值为0）

		for (int i = 0; i < arrBTmp.length && i < arrB.length; i++) {
			arrB[i] = arrBTmp[i];
		}
		return arrB;
	}
	
	
	
	public static String getRandomKey(String prefix)
	{
		SimpleDateFormat df = new SimpleDateFormat("ddHHmmss");
		Date date = new Date();
		return prefix
				+ ((int) (Math.random() * (99999 - 10000 + 1)) + 10000)
				+ df.format(date);
		
	}
	
	public static String getRandomIV(String prefix)
	{
		SimpleDateFormat df = new SimpleDateFormat("ddHHmmss");
		Date date = new Date();
		return  prefix
				+ ((int) (Math.random() * (999999 - 100000 + 1)) + 100000)
				+ df.format(date);
	}
	
	
	//获取公钥
	public static String getContactPubkey() throws IOException, SAXException
	{
		String serverIP = "http://*.*.*.*";
		String request = JSON.toJSONString(ImmutableMap.of());
		WebConversation webpost = new WebConversation();
		String posturlString = serverIP + "/Contacts/pubkey";
		PostMethodWebRequest post = new PostMethodWebRequest(posturlString,
				new ByteArrayInputStream(request.getBytes()), "UTF-8");
		WebResponse postresponse = webpost.getResponse(post);		
		return  FastJsonUtils.getValueFromJsonResponse(
				postresponse.getText(), "pubkey");
	}
	
	
	public static String uploadContactz(String username,String  qudaohao,Map<String,String> contactz_mobile_name) 
			throws IOException, SAXException
	{
		String serverIP = "http://*.*.*.*";
		byte[] reqByte = wrapUploadInfo(username, qudaohao,contactz_mobile_name);
		WebConversation webpost = new WebConversation();
		String posturlString = serverIP + "/Contacts/upload";
		PostMethodWebRequest post = new PostMethodWebRequest(posturlString,
				new ByteArrayInputStream(reqByte), "UTF-8");
		WebResponse postresponse = webpost.getResponse(post);
		return postresponse.getText();
		
	}
	
	
	//修改username、mobile 及 dataMake中的 uname、cnt  及 num 两边也要一致
	public static void main(String args[]) throws Exception {		
		
		String username = "test8";
		String qudaohao = "qdh008";
		Map<String,String> contactz_mobile_name = wrapContactInput();
		String uploadRsp = ContactUploadMulti.uploadContactz(username,qudaohao,contactz_mobile_name);
		System.out.println("uploadRsp===="+uploadRsp);
		
	}
	
	private static Map<String,String> wrapContactInput()
	{
		Map<String,String> txlMap  = new HashMap<String,String>();
		for (int num = 0;num<10;num++)
		{
			Long mobile = 12008000010L+num;
			String mapKey = String.valueOf(mobile);			
			String mapVal = "contact" + mobile;
			txlMap.put(mapKey,mapVal);			 			
		}
		return txlMap;
	}

}
