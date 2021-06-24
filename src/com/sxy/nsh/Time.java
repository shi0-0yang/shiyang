package com.sxy.nsh;

import java.util.Scanner;

public class Time {
	private int hour;
	private int minute;
	private int second;

	public Time() {

	}

	public Time(int hour, int minute, int second) {
		this.minute = minute;
		this.hour = hour;
		this.second = second;
	}

	public int getHour() {
		return this.hour;
	}

	public int getMInute() {
		return this.minute;
	}

	public int getSecond() {
		return this.second;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public void setSecond(int second) {
		this.second = second;
	}

	public void print() {
		if (this.hour <= 12) {
			System.out.println(this.getHour() + ":" + this.getMInute() + ":" + this.getSecond() + "AM");
			System.out.println(this.getHour() + ":" + this.getMInute() + ":" + this.getSecond());

		} else {
			System.out.println(this.getHour() % 12 + ":" + this.getMInute() + ":" + this.getSecond() + "PM");
			System.out.println(this.getHour() + ":" + this.getMInute() + ":" + this.getSecond());

		}
	}

	public static void main(String[] args) {
		Time time = new Time();
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[3];
		int i = 0;
		while (sc.hasNextInt()) {
			arr[i] = sc.nextInt();
			i++;
			if (i >= 3)
				break;
		}
		sc.close();
		time.setHour(arr[0]);
		time.setMinute(arr[1]);
		time.setSecond(arr[2]);
		if (arr[0] > 24 || arr[0] < 0 || arr[1] > 60 || arr[1] < 0 || arr[2] > 60 || arr[2] < 0) {
			System.out.println("输入时间错误！");
		} else {
			time.print();
		}
	}

}
