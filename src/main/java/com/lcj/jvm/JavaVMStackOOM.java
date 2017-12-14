package com.lcj.jvm;

/** 
 * VM Args：-Xss2M （这时候不妨设大些） 
 * @author  
 */  
public class JavaVMStackOOM {
	
    int i=0;  
    private void dontStop() {  
           while (true) {  
           }  
    }  

    public void stackLeakByThread() {  
          
           while (true) {  
                  Thread thread = new Thread(new Runnable() {  
                         @Override  
                         public void run() {  
                                dontStop();  
                         }  
                  });  
                  i++;  
                  System.out.println("i="+i);  
                  thread.start();  
           }  
    }  

    public static void main(String[] args) throws Throwable {  
           JavaVMStackOOM oom = new JavaVMStackOOM();  
            
           try {  
               oom.stackLeakByThread();  
         } catch (Throwable e) {  
             System.out.println("thread num:" + oom.i);  
             throw e;  
         }  
    }  

}

//i=391  
//thread num:391  
//Exception in thread "main" java.lang.OutOfMemoryError: unable to create new native thread 
