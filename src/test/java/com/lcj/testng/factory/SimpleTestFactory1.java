package com.lcj.testng.factory;

import org.testng.annotations.Factory;

public class SimpleTestFactory1 {
	@Factory
    public Object[] factoryMethod() {
        return new Object[] { new SimpleTest1(0), new SimpleTest1(1) };
    }
}
