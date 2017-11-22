package com.lcj.threadBase;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * thread1和thread2在同时进行读操作。
 * ReentrantReadWriteLock里面提供了很多丰富的方法，不过最主要的有两个方法：readLock()和writeLock()用来获取读锁和写锁
 * 如果有一个线程已经占用了读锁，则此时其他线程如果要申请写锁，则申请写锁的线程会一直等待释放读锁。
 * 如果有一个线程已经占用了写锁，则此时其他线程如果申请写锁或者读锁，则申请的线程会一直等待释放写锁。
 */

public class ReentrantReadWriteLockTest1 {
	
	private ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();    
    public static void main(String[] args)  {
        final ReentrantReadWriteLockTest1 test = new ReentrantReadWriteLockTest1();         
        new Thread(){
            public void run() {
                test.get(Thread.currentThread());
            };
        }.start();         
        new Thread(){
            public void run() {
                test.get(Thread.currentThread());
            };
        }.start();         
    }     
    public void get(Thread thread) {
        rwl.readLock().lock();
        try {
            long start = System.currentTimeMillis();
             
            while(System.currentTimeMillis() - start <= 1) {
                System.out.println(thread.getName()+"正在进行读操作");
            }
            System.out.println(thread.getName()+"读操作完毕");
        } finally {
            rwl.readLock().unlock();
        }
    }
}
