package com.lcj.util;

import java.io.UnsupportedEncodingException;

public class Readunsignedbyte {
	//将字节型转为 ascii码
	public static void Parry(byte p[]) {
		for (int i = 0; i < p.length; i++) {
			int result = p[i] & 0xff; //byte类型的数字要&0xff再赋值给int类型，其本质原因就是想保持二进制补码的一致性			
			System.out.print(result);
			System.out.print(" ");
		}		
	}
	public static void main(String[] args) throws UnsupportedEncodingException
    {
		String username = "qqid";  //113 113 105 100
		byte[] usernameBy = username.getBytes();
		Parry(usernameBy);
		test001();
    }	
	//https://www.cnblogs.com/think-in-java/p/5527389.html
	public static void test001()
	{
		byte[] a = new byte[10];
        a[0]= -127;
        System.out.println(a[0]);  //-127
        int c = a[0]&0xff;
        System.out.println(c); //129
	}
}
