package com.sxy;

import java.util.Scanner;

public class acm {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] target = new int[1000];

		while (scan.hasNextInt()) {
			for (int i = 0; i < 1000; i++) {
				target[i] = 0;
			}

			int num = scan.nextInt();
			for (int i = 0; i < num; i++) {
				int next = scan.nextInt();
				target[next] = next;

			}
			int i = 0;
			while (i < 1000) {
				if (target[i] == 0) {
					i++;
				} else {
					System.out.print(target[i]);
					i++;
					break;
				}
			}
			for (; i < 1000; i++) {
				if (target[i] != 0) {
					System.out.print(" " + target[i]);
				}
			}
			System.out.println();
		}
		scan.close();
	}

}
