package com.lcj.threadBase;

import java.io.IOException;

/**
 * 当调用thread1.join()方法后，main线程会进入等待，然后等待thread1执行完之后再继续执行。
 * 实际上调用join方法是调用了Object的wait方法.由于wait方法会让线程释放对象锁，所以join方法同样会让线程释放对一个对象持有的锁。 
 *
 */
public class JoinTest1 {

	public static void main(String[] args) throws IOException  {
        System.out.println("进入线程"+Thread.currentThread().getName());
        JoinTest1 test = new JoinTest1();
        MyThread thread1 = test.new MyThread();
        thread1.start();
        try {
            System.out.println("线程"+Thread.currentThread().getName()+"等待");
            thread1.join();
            System.out.println("线程"+Thread.currentThread().getName()+"继续执行");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    } 
     
    class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("进入线程"+Thread.currentThread().getName());
            try {
                Thread.currentThread().sleep(5000);
            } catch (InterruptedException e) {
                // TODO: handle exception
            }
            System.out.println("线程"+Thread.currentThread().getName()+"执行完毕");
        }
    }
}
