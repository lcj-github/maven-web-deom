package com.lcj.threadBase;

//http://blog.csdn.net/coslay/article/details/38293689
/**
ThreadLocal 不是用来解决共享对象的多线程访问问题的，一般情况下，通过ThreadLocal.set() 到线程中的对象是该线程自己使用的对象，其他线程是不需要访问的，也访问不到的。
 ◎ 定义了两个ThreadLocal变量，最终的目的就是要看最后两个值是否能对应上，这样才有机会证明ThreadLocal所保存的数据可能是线程私有的。
◎ 使用两个内部类只是为了使测试简单，方便大家直观理解，大家也可以将这个例子的代码拆分到多个类中，得到的结果是相同的。
◎ 测试代码更像是为了方便传递参数，因为它确实传递参数很方便，但这仅仅是为了测试。
◎ 在finally里面有remove()操作，是为了清空数据而使用的。为何要清空数据，在后文中会继续介绍细节
 */
public class ThreadLocalTest1 {
	static class ResourceClass {
		public final static ThreadLocal<String> RESOURCE_1 = new ThreadLocal<String>();
		public final static ThreadLocal<String> RESOURCE_2 = new ThreadLocal<String>();
	}
	static class A {
		public void setOne(String value) {
			ResourceClass.RESOURCE_1.set(value);
		}
		public void setTwo(String value) {
			ResourceClass.RESOURCE_2.set(value);
		}
	}
	static class B {
		public void display(String threadName) {
			System.out.println("threadName :"+threadName+ResourceClass.RESOURCE_1.get() + ":"+ ResourceClass.RESOURCE_2.get());					
		}
	}
	public static void main(String[] args) {
		final A a = new A();
		final B b = new B();
		for (int i = 0; i < 3; i++) {
			final String resouce1 = " ; 线程-" + i;
			final String resouce2 = " value = (" + i + ")";
			new Thread() {
				public void run() {
					try {
						String threadName = Thread.currentThread().getName();						
						a.setOne(resouce1);
						a.setTwo(resouce2);
						b.display(threadName);
					} finally {
						ResourceClass.RESOURCE_1.remove();
						ResourceClass.RESOURCE_2.remove();
					}
				}
			}.start();
		}
	}
}
