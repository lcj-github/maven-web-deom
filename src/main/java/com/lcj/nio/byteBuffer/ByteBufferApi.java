package com.lcj.nio.byteBuffer;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class ByteBufferApi {

	private final static SecretKeySpec key = new SecretKeySpec(new byte[] {
			(byte) 0x63, (byte) 0xfa, (byte) 0xc0, (byte) 0xd0, (byte) 0x34,
			(byte) 0xd9, (byte) 0xf7, (byte) 0x93, (byte) 0x19, (byte) 0x9e,
			(byte) 0x9d, (byte) 0x6d, (byte) 0xf3, (byte) 0x9a, (byte) 0xa8,
			(byte) 0x16, }, "AES");
	private final static IvParameterSpec iv = new IvParameterSpec(new byte[] {
			(byte) 0x37, (byte) 0x36, (byte) 0x35, (byte) 0x34, (byte) 0x33,
			(byte) 0x32, (byte) 0x31, (byte) 0x20, (byte) 0x4e, (byte) 0x6f,
			(byte) 0x77, (byte) 0x20, (byte) 0x69, (byte) 0x73, (byte) 0x20,
			(byte) 0x74, });

	public static void main(String[] args) throws UnsupportedEncodingException {

		// showContent();
		// showMethod();
		   showLength();
	}

	public static void showContent() {
		String username = "acct";
		String qudaohao = "acct001";
		String mobile1 = "18662010003";
		String mobilename1 = "name18662010003";
		int u = username.getBytes().length;
		int q = qudaohao.getBytes().length;
		int m = mobile1.getBytes().length;
		int n = mobilename1.getBytes().length;

		int mob_name = (1 + m + 1 + n);
		int len = 1 + u + 1 + q + mob_name;

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
		// 4 97 99 99 116 7 97 99 99 116 48 48 49 11 49 56 54 54 50 48 49 48 48
		// 48 51 15 110 97 109 101 49 56 54 54 50 48 49 48 48 48 51
		Readunsignedbyte.Parry(orionBf.array());
		System.out.println("发送的初始原内容长度为:" + orionBf.array().length);
		System.out.println("====发送的初始原内容 end ====");
	}

	// mark、position、limit、flip、reset 方法后，post、limit讲解
	public static void showMethod() {
		String str = "helloWorld";
		ByteBuffer buff = ByteBuffer.wrap(str.getBytes());
		System.out.println("position:" + buff.position() + "\t limit:"
				+ buff.limit()); // mark:-1 position:0 limit:10
		// 读取两个字节
		buff.get();
		buff.get();
		System.out.println("position:" + buff.position() + "\t limit:"
				+ buff.limit()); // mark:-1 position:2 limit:10

		buff.mark();
		System.out.println("position:" + buff.position() + "\t limit:"
				+ buff.limit()); // mark:2 position:2 limit:10

		buff.flip();
		System.out.println("position:" + buff.position() + "\t limit:"
				+ buff.limit()); // mark:-1 position:0 limit:2

		System.out.println((char) buff.get() + "" + (char) buff.get()); // he

	}

	
	public static void showLength() throws UnsupportedEncodingException {
		ByteBuffer wb = ByteBuffer.allocate(22);

		//[未加body]186 10 2 0 8 48 0 0 0 0 0 0 0 0 1  
		wb.order(ByteOrder.LITTLE_ENDIAN);
		wb.putShort((short) 0x0ABA);
		wb.putShort((short) 2);
		wb.putShort((short) 0x3008);
		wb.putInt(0);
		wb.putInt(0);
		wb.put((byte) 1);

		//[加body]186 10 2 0 8 48 7 0 0 0 0 0 0 0 1 99 111 110 116 101 110 116
		String body = "content";
		byte[] bodyBuffer = body.getBytes("utf-8");
		wb.putInt(6, bodyBuffer.length);
		wb.put(crypt(bodyBuffer, 0, bodyBuffer.length, Cipher.ENCRYPT_MODE));
		
		Parry(wb.array());

	}

	private static byte[] crypt(byte[] buffer, int start, int len, int mode) {

		try {
			ByteBuffer temp = ByteBuffer.allocate(len);
			Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
			int blockSize = cipher.getBlockSize();
			cipher.init(mode, key, iv);
			int size = len / blockSize * blockSize;
			byte[] encrypted = cipher.doFinal(buffer, start, size);
			temp.put(encrypted);
			int remain = len - size;
			if (remain != 0) {
				temp.put(buffer, start + len - remain, remain);
			}
			return temp.array();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void Parry(byte p[]) {
		for (int i = 0; i < 22; i++) {
			int result = p[i] & 0xff;  //byte第一位是符合位
			System.out.print(result);
			System.out.print(" ");
		}
		System.out.println();
	}
	
	

}
