package com.shiyang.thread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 方法5：创建启动线程之Timer定时任务
 * 使用schedule()方法
*/
public class CreateThread5 {
    public static void main(String[] args) {
        Timer timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("定时任务延迟0(即立即执行)，每隔1000ms执行一次");
            }
        },0,1000);
    }
}
