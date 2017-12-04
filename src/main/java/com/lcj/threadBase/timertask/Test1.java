package com.lcj.threadBase.timertask;

import java.util.Date;
import java.util.Timer;
   
public class Test1 {
       
    public static void main(String[] args) {
        Timer timer = new Timer(); 
  
        timer.schedule(new OneTask(1), 5000);// 5秒后启动任务
          
        OneTask secondTask= new OneTask(2);
     // 1秒后启动任务,以后每隔3秒执行一次线程 (让secondTask在1秒钟后，每3秒钟执行一次，但是因为java不是实时的，所以 并不能够严格执行，例如有时可能资源调度紧张4秒以后才执行下一次，有时候又3.5秒执行。）
        timer.schedule(secondTask, 1000, 3000);
     // 1秒钟后，secondTask执行一次，因为系统繁忙，之后的3.5秒后secondTask才得以执行第二次，然后Timer记下了这个延迟，并尝试在下一个任务的时候弥补这个延迟，那么2.5秒后，secondTask 将执行的三次。   
        timer.scheduleAtFixedRate(secondTask, 1000, 3000);
        
          
        Date date = new Date();
        timer.schedule(new OneTask(3),new Date(date.getTime()+1000));//以date为参数，指定某个时间点执行线程
          
//      timer.cancel();
//      secondTask.cancel();
        System.out.println("end in main thread...");
    }
}