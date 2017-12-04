package com.lcj.threadBase.notify;

public class NotifyTest {
	
	 	public static Object object = new Object();
	 	
	    public static void main(String[] args) {
	        Thread1 thread1 = new Thread1();
	        Thread2 thread2 = new Thread2();
	         
	        thread1.start();
	         
	        try {
	            Thread.sleep(200);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	         
	        thread2.start();
	    }
	     
	    static class Thread1 extends Thread{
	        @Override
	        public void run() {
	            synchronized (object) {
	                try {
	                    object.wait();
	                } catch (InterruptedException e) {
	                }
	                System.out.println("线程"+Thread.currentThread().getName()+"获取到了锁");
	            }
	        }
	    }
	     
	    static class Thread2 extends Thread{
	        @Override
	        public void run() {
	        	// 一个线程被唤醒不代表立即获取了对象的monitor，只有等调用完notify()或者notifyAll()并退出synchronized块，释放对象锁后，其余线程才可获得锁执行。
	            synchronized (object) {
	                object.notify();
	                System.out.println("线程"+Thread.currentThread().getName()+"调用了object.notify()");//必先执行
	            }
	            System.out.println("线程"+Thread.currentThread().getName()+"释放了锁");
	        }
	    }

}
