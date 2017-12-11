package com.lcj.bibao.first;

public class DemoClass2 {
	
	private int length =0;
    public ILog logger() {
        //在方法体的作用域中定义此局部内部类
        class InnerClass implements ILog
        {
            @Override
            public void Write(String message) {
                length = message.length();
                System.out.println("DemoClass2.InnerClass:" + length);
            }
        }
        return new InnerClass();
    }
}
