package com.lcj.annotation.exercise2;

import java.lang.reflect.Method;

public class AnalysisAnnotation {
	
	   public static void main(String[] args) {  
	        try {  
	              
	            // 通过运行时反射API获得annotation信息  
	            Class<?> rtClass = Class.forName("com.lcj.annotation.exercise2.Utility");  
	            Method[] methods = rtClass.getMethods();  
	              
	            boolean descriptionExist = rtClass.isAnnotationPresent(Description.class);  
	            if (descriptionExist) {  
	                Description description = (Description)rtClass.getAnnotation(Description.class);  
	                System.out.println("Utility's Description --- > " + description.value());  
	                  
	                for (Method method : methods) {  
	                    if (method.isAnnotationPresent(Author.class)) {  
	                        Author author = (Author)method.getAnnotation(Author.class);  
	                        System.out.println("Utility's Author ---> " + author.name() + " from " + author.group());  
	                    }  
	                }  
	            }  
	              
	        } catch (ClassNotFoundException e) {  
	            e.printStackTrace();  
	        }  
	    }

}
