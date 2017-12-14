package com.lcj.jvm;

import java.lang.reflect.Field;  

import sun.misc.Unsafe;   
/** 
 * VM Args：-Xmx20M -XX:MaxDirectMemorySize=10M 
 * @author  
 * Eclipse 默认把这些受访问限制的API设成了ERROR。 
 
解决办法：将Windows->Preferences->Java-Complicer->Errors/Warnings->Deprecated and restricted API，中的Forbidden references(access rules)设置为Warning，即可以编译通过。 
 
 */  
public class DirectMemoryOOM {
	
	 private static final int _1MB = 1024 * 1024;  
	  
	    public static void main(String[] args) throws Exception {  
	          
	        Field unsafeField = Unsafe.class.getDeclaredFields()[0];  
	        unsafeField.setAccessible(true);  
	        Unsafe unsafe = (Unsafe) unsafeField.get(null);  
	        while (true) {  
	            unsafe.allocateMemory(_1MB);  
	        }  
	    }  

}
/** 
Exception in thread "main" java.lang.OutOfMemoryError 
    at sun.misc.Unsafe.allocateMemory(Native Method) 
    at baby.oom.DirectMemoryOOM.main(DirectMemoryOOM.java:20) 
*/ 

 