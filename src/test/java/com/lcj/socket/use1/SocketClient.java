package com.lcj.socket.use1;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Socket客户端,向服务端发送消息 
 */

public class SocketClient {
	
	 
	private static final int MAX_TIMEOUT = 500;
 
	public SocketClient() {
		
	}
	

	 /**
	  * 向SocketServer发送通信指令并获取回复数据
	  *
	  * @param host 主机名称或IP
	  * @param port 端口
	  * @param timeout 超时时间(秒)
	  * @param content 指令内容
	  * @return
	  */
	public static String sendAndGetReply(String host, int port, int timeout, String content) {
		
		String encode = "gbk";
		Socket s = null;
		DataInputStream input = null;
		DataOutputStream out = null;
		String respData = null;   
		
		try {
			long start = System.currentTimeMillis();
			s = new Socket();
			s.setSoTimeout((timeout > MAX_TIMEOUT ? MAX_TIMEOUT : timeout) * 1000);
			s.connect(new InetSocketAddress(host, port), timeout);
			out = new DataOutputStream(s.getOutputStream());  
			out.write(content.getBytes(encode));
			out.flush();
	         //读取服务器端数据    
            input = new DataInputStream(s.getInputStream());
            byte[] b = new byte[2480]; 
            input.read(b);  
            respData = new String(b,"gbk");
            long end = System.currentTimeMillis();
            System.out.println("获取GUID，耗时:" + (end - start));
		} catch (Exception e) {
			System.out.println("连接异常!" );
		} finally {
			
			if (s != null) {
				try {
					s.close();
				} catch (IOException e) {
					System.out.println("关闭socket连接异常!" );
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					System.out.println("关闭OutputStream异常!" );
				}
			}
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					System.out.println("关闭InputStream异常!" );
				}
			}
			s = null;
			out = null;
			input = null;
		}
		
		return respData;
	}
	
	public static void main(String[] args) throws Exception {
		// 过河bin
		String strParameter = "GET /phonenumber="+"13662017845"+ "&Source=" + "110" +"&AccountName="+"custName"+"&channel="+127+" HTTP/1.1\r\nConnection: Keep-Alive";
		String result = sendAndGetReply("ip", 8080, 30, strParameter);
		
	}
	
	
}