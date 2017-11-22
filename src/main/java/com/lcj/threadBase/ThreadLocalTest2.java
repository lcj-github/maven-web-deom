package com.lcj.threadBase;

public class ThreadLocalTest2 {
	ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
	ThreadLocal<String> stringLocal = new ThreadLocal<String>();
	public void set() {
		longLocal.set(Thread.currentThread().getId());
		stringLocal.set(Thread.currentThread().getName());
	}
	public long getLong() {
		return longLocal.get();
	}
	public String getString() {
		return stringLocal.get();
	}
	//在main线程中和thread1线程中，longLocal保存的副本值和stringLocal保存的副本值都不一样。
	//最后一次在main线程再次打印副本值是为了证明在main线程中和thread1线程中的副本值确实是不同的。
	public static void main(String[] args) throws InterruptedException {
		final ThreadLocalTest2 test = new ThreadLocalTest2();
		test.set();
		System.out.println(test.getLong());       //1
		System.out.println(test.getString());     //main
		Thread thread1 = new Thread() {
			public void run() {
				test.set();
				System.out.println(test.getLong());  //9
				System.out.println(test.getString());//Thread-0
			};
		};
		thread1.start();
		thread1.join();
		System.out.println(test.getLong()); //1
		System.out.println(test.getString()); //main
	}
}
