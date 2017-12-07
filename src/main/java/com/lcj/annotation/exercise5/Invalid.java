package com.lcj.annotation.exercise5;

@Description(desc = "this is Interface")    //因为注解Description中的author和age成员有默认值，所以可以省略 
public interface Invalid {
	@Description(desc = "this is Interface method")  
    public void print();
}
