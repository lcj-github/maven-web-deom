package com.lcj.threadBase;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest1 {
	
	public  AtomicInteger inc = new AtomicInteger();
    
    public  void increase() {
        inc.getAndIncrement();
    }
    
    public static void main(String[] args) {
        final AtomicIntegerTest1 test = new AtomicIntegerTest1();
        for(int i=0;i<10;i++){
            new Thread(){
                public void run() {
                    for(int j=0;j<1000;j++)
                        test.increase();
                };
            }.start();
        }
        
        while(Thread.activeCount()>1)  //保证前面的线程都执行完
            Thread.yield();
        System.out.println(test.inc);
    }

}
