package com.lcj.bibao.first;

public class DemoClass5 {
	
	private int length =0;	
	public ILog logger(final int level) throws Exception {	        
	        return new ILog() {
	            {
	                //实例初始化，不能重载 
	                if(level !=1)
	                    throw new Exception("日志等级不正确！");
	            }	            
	            @Override
	            public void Write(String message) {
	                length = message.length();
	                System.out.println("DemoClass5.AnonymousClass:" + length);
	            }
	        };
	}
}
