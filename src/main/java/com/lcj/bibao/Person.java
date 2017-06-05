package com.lcj.bibao;

//闭包能够将一个方法作为一个变量去存储，这个方法有能力去访问所在类的自由变量。
public class Person {

	public static void main(String[] args) {  
        //买一箱牛奶  
        Milk m = new Milk();  
          
        Active haveMeals = m.HaveMeals();  
          
        //没事喝一瓶  
        haveMeals.drink();  
        //有事喝一瓶  
        haveMeals.drink();  
          
        //看看还剩多少？  
        m.currentNum();  
    }  
}
