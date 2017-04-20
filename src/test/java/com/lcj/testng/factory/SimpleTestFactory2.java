package com.lcj.testng.factory;

import org.testng.annotations.Factory;

/*
 * Factory: 
 * A factory will execute all the test methods present inside a test class 
using a separate instance of the respective class.
 */

public class SimpleTestFactory2 {
	@Factory
    public Object[] factoryMethod() 
    {
        return new Object[] { new DependencyTest2(1), new DependencyTest2(2) };
    }

}
