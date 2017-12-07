package com.lcj.annotation.exercise5;

import java.lang.reflect.Method;

public class ParseAnno {
	public static void main(String[] args) {  
        try {  
            /* 
             * 1.使用类加载器加载类 
             * Class.forName("类名字符串") （注意：类名字符串必须是全称，包名+类名） 
             */  
            Class c = Class.forName("com.lcj.annotation.exercise5.Test1");  
              
            //2.判断类上是否存在注解，并获取类上面注解的实例  
            if(c.isAnnotationPresent(Description.class)){
            	System.out.println("类的解析");
                Description Description = (Description) c.getAnnotation(Description.class);  
                System.out.println(Description.desc());  
                System.out.println(Description.author());  
                System.out.println(Description.age());  
            }  
              
            //3.判断方法上是否存在注解，并获取方法上面注解的实例  
            Method[] ms = c.getMethods();  
            for (Method method : ms) {  
                if(method.isAnnotationPresent(Description.class)){ 
                	System.out.println("方法的解析");
                    Description Description = (Description)method.getAnnotation(Description.class);  
                    System.out.println(Description.desc());  
                    System.out.println(Description.author());  
                    System.out.println(Description.age());  
                }  
            }  
        
              
        } catch (ClassNotFoundException e) {  
            e.printStackTrace();  
        }  
    }  
}
