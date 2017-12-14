package com.lcj.jvm;

/** 
 * 栈异常 
 * 如果线程请求的栈深度大于虚拟机所允许的最大深度，将抛出StackOverflowError 
 * 如果虚拟机在扩展栈时无法申请到足够的内存空间，将抛出OutOfMemoryError 
 * VM Args：-Xss128k 
 * @author  
 */ 
public class JavaVMStackSOF {
	
	 private int stackLength = 1;  
	  
	    public void stackLeak() {  
	        stackLength++;  
	        stackLeak();  
	    }  
	  
	    public static void main(String[] args) throws Throwable {  
	        JavaVMStackSOF oom = new JavaVMStackSOF();  
	        try {  
	            oom.stackLeak();  
	        } catch (Throwable e) {  
	            System.out.println("stack length:" + oom.stackLength);  
	            throw e;  
	        }  
	    }  

}
/** 
 *  
 * stack length:2403 
Exception in thread "main" java.lang.StackOverflowError 
    at baby.oom.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:11) 
    at baby.oom.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:12) 
    at baby.oom.JavaVMStackSOF.stackLeak(JavaVMStackSOF.java:12) 
     
    默认情况下，即不加Xss限制，输出的length为8956，加了Xss128k length位2403 
 */  