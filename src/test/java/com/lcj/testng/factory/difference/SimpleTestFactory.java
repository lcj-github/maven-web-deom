package com.lcj.testng.factory.difference;

import org.testng.annotations.Factory;

/**
 * 
Before SimpleTest class executed.
testMethod parameter value is: two
Before SimpleTest class executed.
testMethod parameter value is: one
 *
 */
public class SimpleTestFactory {
	
	@Factory
    public Object[] factoryMethod() {
        return new Object[] { 
                                new SimpleTest("one"), 
                                new SimpleTest("two") 
                            };
    }

}
