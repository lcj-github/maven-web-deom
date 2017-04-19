package com.lcj.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * 
Before test test-method One. Thread id is: 10
Before test test-method Two. Thread id is: 11
Before test-class test-method One. Thread id is: 10
Before test-class test-method Two. Thread id is: 11
Sample test-method test-method One. Thread id is: 10
After test-method  test-method One. Thread id is: 10
After test  test-method One. Thread id is: 10
Sample test-method test-method Two. Thread id is: 11
After test-method  test-method Two. Thread id is: 11
After test  test-method Two. Thread id is: 11
 */
public class ParallelSuiteTest {
	
	String testName = "";
    @BeforeTest
    @Parameters({ "test-name" })
    public void beforeTest(String testName) {
        this.testName = testName;
        long id = Thread.currentThread().getId();
        System.out.println("Before test " + testName + ". Thread id is: " + id);
    }
    @BeforeClass
    public void beforeClass() {
        long id = Thread.currentThread().getId();
        System.out.println("Before test-class " + testName + ". Thread id is: "
                + id);
    }
    @Test
    public void testMethodOne() {
        long id = Thread.currentThread().getId();
        System.out.println("Sample test-method " + testName
                + ". Thread id is: " + id);
    }
    @AfterClass
    public void afterClass() {
        long id = Thread.currentThread().getId();
        System.out.println("After test-method  " + testName
                + ". Thread id is: " + id);
    }
    @AfterTest
    public void afterTest() {
        long id = Thread.currentThread().getId();
        System.out.println("After test  " + testName + ". Thread id is: " + id);
    }

}
