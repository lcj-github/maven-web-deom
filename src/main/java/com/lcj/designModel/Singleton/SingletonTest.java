package com.lcj.designModel.Singleton;

/**
 * 可用： 懒汉式单例
 * 因为我们只需要在创建类的时候进行同步，所以只要将创建和getInstance()分开，单独为创建加synchronized关键字
 * 考虑性能的话，整个程序只需创建一次实例，所以性能也不会有什么影响
 */
public class SingletonTest {
	
	/* 持有私有静态实例，防止被引用，此处赋值为null，目的是实现延迟加载 */
	private static SingletonTest instance = null;  
	  
	/* 私有构造方法，防止被实例化 */ 
    private SingletonTest() {  
    }  
  
    private static synchronized void syncInit() {  
        if (instance == null) {  
            instance = new SingletonTest();  
        }  
    }  
  
    public static SingletonTest getInstance() {  
        if (instance == null) {  
            syncInit();  
        }  
        return instance;  
    } 
    
    /**
     * instance = new Singleton();语句是分两步执行的。
     * 但是JVM并不保证这两个操作的先后顺序，也就是说有可能JVM会为新的Singleton实例分配空间，然后直接赋值给instance成员，然后再去初始化这个Singleton实例。
          
    public static SingletonTest getInstance2() {  
        if (instance == null) {  
            synchronized (instance) {  
	            if (instance == null) {  
	                instance = new SingletonTest();  
	            }  
            }  
        }  
        return instance;  
    }
   
    *我们以A、B两个线程为例：

		a>A、B线程同时进入了第一个if判断

		b>A首先进入synchronized块，由于instance为null，所以它执行instance = new Singleton();

		c>由于JVM内部的优化机制，JVM先画出了一些分配给Singleton实例的空白内存，并赋值给instance成员 （ 注意此时JVM没有开始初始化这个实例 ），然后A离开了synchronized块。

		d>B进入synchronized块，由于instance此时不是null，因此它马上离开了synchronized块并将结果返回给调用该方法的程序。

		e>此时B线程打算使用Singleton实例，却发现它没有被初始化，于是错误发生了。
    **/
}
