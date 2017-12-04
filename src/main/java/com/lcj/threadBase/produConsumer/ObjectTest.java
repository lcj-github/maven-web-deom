package com.lcj.threadBase.produConsumer;

import java.util.PriorityQueue;

public class ObjectTest {
	
	private int queueSize = 10;
    private PriorityQueue<Integer> queue = new PriorityQueue<Integer>(queueSize);
      
    public static void main(String[] args)  {
    	ObjectTest test = new ObjectTest();
        Producer producer = test.new Producer();
        Consumer consumer = test.new Consumer();
          
        producer.start();
        consumer.start();
    }
      
    class Consumer extends Thread{
          
        @Override
        public void run() {
            consume();
        }
          
        private void consume() {
        	 
            while(true){
            	System.out.println("consume() while 里"); 
                synchronized (queue) {
                	System.out.println("consume() synchronized 里");
                    while(queue.size() == 0){
                        try {
                            System.out.println("队列空，等待数据");
                            queue.wait();
                            System.out.println("consume() queue.wait后"); //在 produce()中 queue.wait()后执行
                        } catch (InterruptedException e) {                        	 
                            e.printStackTrace();
                            queue.notify();
                            System.out.println("consume() queue.notify Interruption");
                        }
                    }
                    queue.poll();          //每次移走队首元素
                    System.out.println("consume() queue.poll");
                    queue.notify();
                    System.out.println("consume() queue.notify");
                    System.out.println("从队列取走一个元素，队列剩余"+queue.size()+"个元素");
                }
            }
        }
    }
      
    class Producer extends Thread{
          
        @Override
        public void run() {
            produce();
        }
          
        private void produce() {
        	 
            while(true){
            	System.out.println("produce() while 里");
                synchronized (queue) {
                	System.out.println("produce() synchronized 里");
                    while(queue.size() == queueSize){
                        try {
                            System.out.println("队列满，等待有空余空间");
                            queue.wait();
                            System.out.println("produce() queue.wait后"); //在 consume()中 queue.wait()后执行
                        } catch (InterruptedException e) {                        	 
                            e.printStackTrace();
                            queue.notify();
                            System.out.println("produce() queue.notify Interruption");
                        }
                    }
                    queue.offer(1);        //每次插入一个元素
                    System.out.println("produce() queue.offer");
                    queue.notify();
                    System.out.println("produce() queue.notify");
                    System.out.println("向队列取中插入一个元素，队列剩余空间："+(queueSize-queue.size()));
                }
            }
        }
    }

}
