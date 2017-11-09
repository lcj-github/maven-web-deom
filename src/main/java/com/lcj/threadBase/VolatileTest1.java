package com.lcj.threadBase;

/**
 * http://www.cnblogs.com/dolphin0520/p/3920373.html
 * 可见性只能保证每次读取的是最新的值，但是volatile没办法保证对变量的操作的原子性；volatile能在一定程度上保证有序性。
 * 自增操作是不具备原子性的，它包括读取变量的原始值、进行加1操作、写入工作内存。而且volatile也无法保证对变量的任何操作都是原子性的。
 * 为保证原子性，可参考类实现：SynchronizeTest1，LockTest1，AtomicIntegerTest1
 *
 *	内存屏障会提供3个功能：

　　1）它确保指令重排序时不会把其后面的指令排到内存屏障之前的位置，也不会把前面的指令排到内存屏障的后面；即在执行到内存屏障这句指令时，在它前面的操作已经全部完成；

　　2）它会强制将对缓存的修改操作立即写入主存；

　　3）如果是写操作，它会导致其他CPU中对应的缓存行无效。
 *
 */
public class VolatileTest1 {
	
	public volatile int inc = 0;
    
    public void increase() {
        inc++;
    }
     
    public static void main(String[] args) {
        final VolatileTest1 test = new VolatileTest1();
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
