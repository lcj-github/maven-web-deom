package com.lcj.testng.factory;

import org.testng.annotations.Test;

public class SimpleTest1 {
	private int param;

	public SimpleTest1(int param) {
		this.param = param;
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
