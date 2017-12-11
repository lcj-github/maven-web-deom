package com.lcj.bibao.first;

public class DemoClass4 {

private int length =0;
    
    public ILog logger(int level) {//final int level
        //final
        final int logLevel = level+1;        
        switch(level)
        {
            case 1:
                return new ILog() {
                    @Override
                    public void Write(String message) {
                        length = message.length();
                        System.out.println("DemoClass4.AnonymousClass:InfoLog " + length);
                        System.out.println(logLevel);
                    }
                };    
            default:
	            return new ILog() {
	                @Override
	                public void Write(String message) {
	                    length = message.length();
	                    System.out.println("DemoClass4.AnonymousClass:ErrorLog " + length);
	                    System.out.println(logLevel);
	                }
	            };                
        }
    }
    
    public static void main(String[] args){
        DemoClass4 demoClass4 = new DemoClass4();
        demoClass4.logger(1).Write("abcefghi");
    }
}
