package com.lcj.socket.multhread;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MyClient {

	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("localhost", 10000);
		//接受服务端记录
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		//发送给服务端记录
		PrintWriter out = new PrintWriter(socket.getOutputStream());
		//读取控制台中输入的记录
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			//发送给服务端记录
			String msg = reader.readLine();
			out.println(msg);
			out.flush();
			if (msg.equals("bye")) {
				break;
			}
			//从服务端接受到的数据
			System.out.println("from server"+in.readLine());
		}
		socket.close();
	}

}
