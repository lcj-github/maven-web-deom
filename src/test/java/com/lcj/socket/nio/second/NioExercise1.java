package com.lcj.socket.nio.second;

import java.nio.ByteBuffer;

public class NioExercise1 {

	public static void main(String[] args) throws Exception  {
		//sendData1();
		//sendData2();
		sendData3();
	}
	
	public static void sendData1() throws Exception {
		ByteBuffer bBuf = ByteBuffer.allocate(10); 
		
		int postion = bBuf.position();
		int limit = bBuf.limit();
		int capacity = bBuf.capacity();		
		//orion:postion=0limit=10capacity=10
		System.out.println("orion:postion="+postion+"limit="+limit+"capacity="+capacity);
		
		// 存入4次数据  
		bBuf.put((byte) 'A');  
		bBuf.put((byte) 'B');  
		bBuf.put((byte) 'C');  
		bBuf.put((byte) 'D');  
		// 翻转缓冲区  
		bBuf.flip();  
		System.out.println("flip:postion="+postion+"limit="+limit+"capacity="+capacity);
		// 读取2次数据  
		System.out.println((char)bBuf.get());  
		System.out.println((char)bBuf.get());
		  
		 
	}
	
	//批量移动缓冲区的数据
	public static void sendData2() throws Exception {
		byte[] bytes = "hello world!".getBytes();  
		// 创建一个容量等bytes容量的byte数据缓冲区  
		ByteBuffer buff = ByteBuffer.allocate(bytes.length);  
		//将byte数据写入缓冲区，下面代码和buff.put(bytes)效果一致  
		buff.put(bytes, 0, bytes.length);  
		//翻转缓冲区  
		buff.flip();  
		//轮询判断是否有数据，有则将缓冲区的数据批量读到array中  
		byte[] array =  new byte[bytes.length];  
		while(buff.hasRemaining()){  
		    buff.get(array, 0, buff.remaining());  
		}  
		//输出冲缓冲区读出来的数据  
		System.out.println(new String(array)); 
	}
	
	public static void sendData3() throws Exception {
		
		ByteBuffer buff = ByteBuffer.allocate(100);  
		buff.putShort((short)100);  
		buff.putInt(200);  
		buff.putLong(300L);  
		buff.putFloat(400.5f);  
		buff.putDouble(500.56);  
		buff.putChar('A');  
		buff.flip();  
		System.out.println(buff.getShort());//return 100  
		System.out.println(buff.getInt());//return 200  
		System.out.println(buff.getLong());//return 300  
		System.out.println(buff.getFloat());//return 400.5  
		System.out.println(buff.getDouble());//return 500.56  
		System.out.println(buff.getChar());//return 'A'		
	}
	

}
