package com.lcj.jetty;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class FileUtil {

	/** 
     * 读取.json文件方法 
     * @param filePath 
     * @return 
     */  
    public static String ReadFile(String filePath) {  
        BufferedReader reader=null;  
        StringBuilder result=null;  
        try {  
            FileInputStream inStream=new FileInputStream(filePath);  
            InputStreamReader inReader=new InputStreamReader(inStream,"UTF-8");  
            reader=new BufferedReader(inReader);  
            result=new StringBuilder();  
            String tempStr;  
            while((tempStr=reader.readLine())!=null){  
                result.append(tempStr);  
            }  
            reader.close();  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (UnsupportedEncodingException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }finally {  
            if(reader!=null) {  
                try {  
                    reader.close();  
                } catch (IOException e) {  
                    e.printStackTrace();  
                }  
            }  
        }  
        return result.toString();  
    }  
}
