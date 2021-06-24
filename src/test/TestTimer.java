package test;

import java.util.Timer;
import com.shiyang.thread.MyTimerTask;
/*
 (1）schedule(task,time) 在时间等于或超过time的时候执行且只执行一次task，这个time表示的是例如2019年11月11日上午11点11分11秒。指的是时刻。
（2）schedule(task,time,period)
在时间等于或超过time的时候首次执行task，之后每隔period毫秒重复执行一次task 。这个time和上一个一样。
（3）schedule(task, delay)
在delay时间之后，执行且只执行一次task。这个delay表示的是延迟时间，比如说三秒后执行
（4）schedule(task,delay,period)
在delay时间之后，开始首次执行task，之后每隔period毫秒重复执行一次task ，这个delay和上面的一样。
 */

public class TestTimer {
public static void main(String[] args) {
	Timer timer=new Timer();
	MyTimerTask myTimerTask=new MyTimerTask("TimerTask 1");
	//在两秒后执行第一次，之后每隔一秒执行一次
	timer.schedule(myTimerTask, 2000L,1000L);
	//timer.cancel();
	
}
}
