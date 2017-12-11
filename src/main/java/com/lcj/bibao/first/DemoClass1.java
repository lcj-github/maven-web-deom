package com.lcj.bibao.first;

public class DemoClass1 {
	
	private int length =0;
    //private|public
    private class InnerClass implements ILog
    {
        @Override
        public void Write(String message) {
        	//如何通过this显式引用外围类的变量？通过此格式进行引用：{外围类名}.this.{变量名称}
            //DemoClass1.this.length = message.length();
            length = message.length();
            System.out.println("DemoClass1.InnerClass:" + length);
        }
    }    
    public ILog logger() {
        return new InnerClass();
    } 
    public static void main(String[] args){
        DemoClass1 demoClass1 = new DemoClass1();
        demoClass1.logger().Write("abc");        
        //.new   如何创建这个InnerClass的实例? 可以通过外围类的实例进行创建
        DemoClass1 dc1 = new DemoClass1();
        InnerClass ic = dc1.new InnerClass();
        ic.Write("abcde");
    }
}
