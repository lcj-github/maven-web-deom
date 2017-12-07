package com.lcj.annotation.exercise5;

@Description(desc = "this is class")
public class Valid {
	 @Description(desc = "this is class method")  
	    public void run(){  
	        System.out.println("注解继承只能在子类中有效，不能在接口中继承");  
	    } 

}
