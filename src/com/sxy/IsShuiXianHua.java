package com.sxy;

import java.util.Scanner;

public class IsShuiXianHua {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		int i, j, k;
		scanner.close();
		i = x / 100;
		k = x % 10;
		j = (x % 100 - k) / 10;
		if (i * i * i + j * j * j + k * k * k == x) {
			System.out.println("Y");
		} else
			System.out.println("N");
	}
}
