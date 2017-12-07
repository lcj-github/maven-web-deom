package com.lcj.annotation.exercise5;

public class Test1 extends Valid implements Invalid {  
    @Override  
    public void run(){  
        System.out.println("覆盖父类的方法");  
    }  
    @Override  
    public void print() {  
        System.out.println("实现接口的方法");  
    }  
}  
