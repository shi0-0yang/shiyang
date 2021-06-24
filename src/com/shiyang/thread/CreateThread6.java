package com.shiyang.thread;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池的实现
 * 降低了创建线程和销毁线程的时间开销和资源浪费
 */
public class CreateThread6 {
    public static void main(String[] args) {

        //创建带有5个线程的线程池
        //返回的实际上是ExecutorService,而ExecutorService是Executor的子接口
        ExecutorService threadPool= Executors.newFixedThreadPool(5);
        for (int i=0;i<5;i++){
            threadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+" is running");
                }
            });
        }
        //ExecutorService接口销毁线程
        threadPool.shutdown();
    }
}
