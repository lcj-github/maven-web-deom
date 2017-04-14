package com.lcj.nio.byteBuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ByteBufferApi {

	public static void main(String[] args) {
		
		showContent();
		//showMethod();
	}
	
	
	public static void showContent()
	{
		String username ="acct";
		String qudaohao = "acct001";		
		String mobile1 = "18662010003";		
		String mobilename1 = "name18662010003";
		int u = username.getBytes().length;
		int q = qudaohao.getBytes().length;
		int m = mobile1.getBytes().length;
		int n = mobilename1.getBytes().length;
		
		int mob_name =(1 + m + 1 + n);
		int len = 1 + u + 1 + q +mob_name;		
		
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

		// 通讯录手机及名称
		orionBf.put((byte) m);
		offset++;
		orionBf.position(offset);
		
		orionBf.put(mobile1.getBytes());
		offset += m;
		orionBf.position(offset);
		
		orionBf.put((byte) n);
		offset++;
		orionBf.position(offset);
		
		orionBf.put(mobilename1.getBytes());
		offset += n;
		orionBf.position(offset);	
		
		System.out.println("====发送的初始原内容 start ====");
		//4 97 99 99 116 7 97 99 99 116 48 48 49 11 49 56 54 54 50 48 49 48 48 48 51 15 110 97 109 101 49 56 54 54 50 48 49 48 48 48 51
		Readunsignedbyte.Parry(orionBf.array());
		System.out.println("发送的初始原内容长度为:"+orionBf.array().length);		
		System.out.println("====发送的初始原内容 end ====");	
	}
	
	
	//mark、position、limit、flip、reset 方法后，post、limit讲解
	public static void showMethod()
	{
		String str = "helloWorld";  
        ByteBuffer buff  = ByteBuffer.wrap(str.getBytes());  
        System.out.println("position:"+buff.position()+"\t limit:"+buff.limit());  //mark:-1 position:0	 limit:10
        //读取两个字节  
        buff.get();  
        buff.get();  
        System.out.println("position:"+ buff.position()+"\t limit:"+buff.limit()); //mark:-1 position:2	 limit:10
        
        buff.mark();  
        System.out.println("position:"+buff.position()+"\t limit:"+buff.limit()); //mark:2 position:2	 limit:10
        
        buff.flip();  
        System.out.println("position:"+buff.position()+"\t limit:"+buff.limit()); //mark:-1 position:0	 limit:2
        
        System.out.println((char)buff.get()+""+(char)buff.get()); //he
        
        
	}

}
