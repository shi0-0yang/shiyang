package com.shiyang.thread;

import java.util.TimerTask;

public class MyTimerTask extends TimerTask{
private String taskName;

public MyTimerTask(String taskName) {
	super();
	this.taskName = taskName;
}

public String getTaskName() {
	return taskName;
}

public void setTaskName(String taskName) {
	this.taskName = taskName;
}
@Override
public void run() {
	System.out.println("当前的任务是："+taskName);
}
}
