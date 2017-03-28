package com.lcj.designModel.Singleton;

/**
 * 饿汉式单例
 * @author Administrator
 *
 */
public class SingletonTest2 {
	
	private static SingletonTest2 singleton = new SingletonTest2();  
	
    private SingletonTest2(){}  
    
    public static SingletonTest2 getInstance(){  
        return singleton;  
    } 

}
