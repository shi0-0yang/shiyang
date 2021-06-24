package com.sxy;

import java.util.Scanner;

import com.shiyang.arithmetic.MySort;

public class SortTest {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int arr[] = new int[5];
		int i = 0;
		while (i<5&&scanner.hasNextInt()) {
			arr[i] = scanner.nextInt();
			i++;
		}
		MySort.selectSort(arr);
		publish(arr);
		scanner.close();
	}
	
	private static void publish(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
			array.toString();
		}

	}
}
//  1 5 2 7 4