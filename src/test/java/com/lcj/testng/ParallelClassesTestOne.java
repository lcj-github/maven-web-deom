package com.lcj.testng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
Before test-class. Thread id is: 11
Before test-class. Thread id is: 10
Sample test-method One. Thread id is: 11
Sample test-method Two. Thread id is: 11
After test-class. Thread id is: 11
Sample test-method One. Thread id is: 10
Sample test-method Two. Thread id is: 10
After test-class. Thread id is: 10
 */
public class ParallelClassesTestOne {
	
	@BeforeClass
    public void beforeClass() {
        long id = Thread.currentThread().getId();
        System.out.println("Before test-class. Thread id is: " + id);
    }
    @Test
    public void testMethodOne() {
        long id = Thread.currentThread().getId();
        System.out.println("Sample test-method One. Thread id is: " + id);
    }
    @Test
    public void testMethodTwo() {
        long id = Thread.currentThread().getId();
        System.out.println("Sample test-method Two. Thread id is: " + id);
    }
    @AfterClass
    public void afterClass() {
        long id = Thread.currentThread().getId();
        System.out.println("After test-class. Thread id is: " + id);
    }

}
