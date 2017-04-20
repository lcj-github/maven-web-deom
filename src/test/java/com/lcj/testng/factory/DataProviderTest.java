package com.lcj.testng.factory;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

/**
DataProvider: 
A test method that uses DataProvider will be executed a multiple number of times based on the data provided by the DataProvider.
The test method will be executed using the same instance of the test class to which the test method belongs.
 *
 */
public class DataProviderTest {
	
	private int param;
	 
    @Factory(dataProvider = "dataMethod")
    public DataProviderTest(int param) {
        this.param = param;
    }
 
    @DataProvider
    public static Object[][] dataMethod() {
        return new Object[][] { { 0 }, { 1 } };
    }
 
    @Test
    public void testMethodOne() {
        int opValue = param + 1;
        System.out.println("Test method one output: " + opValue);
    }
 
    @Test
    public void testMethodTwo() {
        int opValue = param + 2;
        System.out.println("Test method two output: " + opValue);
    }

}
