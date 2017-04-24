package com.lcj.annotation.exercise2;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)  
@Target(ElementType.METHOD)  
@Documented  
public @interface Author {
	  String name(); // 因为没有定义public，所以默认的访问权限为包权限，在定义时没有指定默认值，则使用时必须指定默认值  
	  String group();  
}
