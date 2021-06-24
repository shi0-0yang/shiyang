package com.sxy.nsh;

public class QuanXianDemo {
	public static final int READ_PHONE = 0b0001;
	public static final int WRITE_PHONE = 0b0010;
	public static final int READ_MSN = 0b0100;
	public static final int WRITE_MSN = 0b1000;

	public static final int ALL = 0b1111;
	public static final int NO = 0;

	public static void main(String[] args) {
		// 假设已经从数据库查询到支付宝的权限集为3
		int perssions = 3;
		int result = READ_PHONE & perssions;
		if (result == 1) {
			System.out.println("读取联系人的权限为：开启");
		} else {
			System.out.println("读取联系人的权限为：关闭");
		}
		// System.out.println("读取联系人的权限为："+);

//		int result2 = READ_MSN | perssions;

		// int result3=openPer(READ_MSN, perssions);
		int result3 = READ_MSN ^ perssions;
		query(result3);

//		int result4 = WRITE_MSN ^ perssions;

	}

	public static void query(int perssions) {

	}

	public static int closePer(int perssion, int perssions) {
		return perssion ^ perssions;
	}

	public static int openAll(int perssion) {
		return perssion | ALL;
	}

	public static int clossAll(int perssion) {
		return perssion & NO;
	}
}
