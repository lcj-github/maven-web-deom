package com.lcj.jvm;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;

/** shell 脚本内容
#!/bin/bash  
echo "begin"  
sleep 10  
echo "end" 
 */
public class TestSleep {
	
	public static void main(String[] args) {  
        System.out.println("being sleep"+new Date().toLocaleString());  
        try  
        {  
        Runtime rt = Runtime.getRuntime();  
        Process proc = rt.exec("/home/boco/script/sleep.sh");  
        InputStream stdin = proc.getInputStream();  
        InputStreamReader isr = new InputStreamReader(stdin);  
        BufferedReader br = new BufferedReader(isr);  
        String line = null;  
        System.out.println("output");  
        while ( (line = br.readLine()) != null)  
        System.out.println(line);  
        System.out.println("");  
        int exitVal = proc.waitFor();  
        System.out.println("Process exitValue: " + exitVal);  
        } catch (Throwable t)  
        {  
        t.printStackTrace();  
        }  

        System.out.println("end sleep"+new Date().toLocaleString());  
}  

}
