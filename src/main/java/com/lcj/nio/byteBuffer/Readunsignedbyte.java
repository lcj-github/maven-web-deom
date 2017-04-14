package com.lcj.nio.byteBuffer;

import java.io.UnsupportedEncodingException;

public class Readunsignedbyte {

	//将字节型转为 ascii码
	public static void Parry(byte p[]) {
		for (int i = 0; i < p.length; i++) {
			int result = p[i] & 0xff;
			System.out.print(result);
			System.out.print(" ");
		}
		
	}	
	
	
	public static void main(String[] args) throws UnsupportedEncodingException
    {
		String username = "qqid";  //113 113 105 100
		byte[] usernameBy = username.getBytes();
		Parry(usernameBy);
    }
	
	
	
}
