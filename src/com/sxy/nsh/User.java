package com.sxy.nsh;

import java.util.Scanner;

public class User {
	private int  uID;
	public int getuID() {
		return uID;
	}

	public void setuID(int uID) {
		this.uID = uID;
	}

	private String username = "nsh";
	private String password = "123456";

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public static void main(String[] args) {
		User user = new User();
		User test = new User();
		String name, psw;
		Scanner scanner = new Scanner(System.in);
		name = scanner.nextLine();
		psw = scanner.nextLine();
		scanner.close();
		user.setUsername(name);
		user.setPassword(psw);
		if (test.login(user)) {
			System.out.println("登录成功！");
		} else {
			System.out.println("登录名或密码错误！");
		}

	}

	public boolean login(User user) {
		if ("nsh".equals(user.getUsername()) && "123456".equals(user.getPassword()))
			return true;
		return false;
	}
}
