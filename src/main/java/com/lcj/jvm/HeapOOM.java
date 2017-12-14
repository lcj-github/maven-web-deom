package com.lcj.jvm;

import java.util.ArrayList;
import java.util.List;


/** 
 * java 堆溢出 :堆溢出原因莫过于对象太多导致
 * VM Args：-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError 
 * @author  
 */  
public class HeapOOM {
	
	static class OOMObject {  
    }  
  
    public static void main(String[] args) {  
        List<OOMObject> list = new ArrayList<OOMObject>();  
          
        while (true) {  
            list.add(new OOMObject());  
            /*System.out.println("total(k):"+Runtime.getRuntime().totalMemory()/1024+ 
                    "  freeMemory(k):"+Runtime.getRuntime().freeMemory()/1024+ 
                    "  maxMemory(k):"+Runtime.getRuntime().maxMemory()/1024+ 
                    "  availableProcessors:"+Runtime.getRuntime().availableProcessors());*/  
        }  
    }  
}
/** 
 * java.lang.OutOfMemoryError: Java heap space 
Dumping heap to java_pid1820.hprof ... 
Heap dump file created [24787111 bytes in 0.346 secs] 
Exception in thread "main" java.lang.OutOfMemoryError: Java heap space 
    at java.util.Arrays.copyOf(Arrays.java:2760) 
    at java.util.Arrays.copyOf(Arrays.java:2734) 
    at java.util.ArrayList.ensureCapacity(ArrayList.java:167) 
    at java.util.ArrayList.add(ArrayList.java:351) 
    at baby.oom.HeapOOM.main(HeapOOM.java:19) 
 *  
 * 
*/ 