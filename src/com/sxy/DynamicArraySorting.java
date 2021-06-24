package com.sxy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class DynamicArraySorting {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Integer> list=new ArrayList<Integer>();
		list.add(4);
		list.add(5);
		list.add(2);
		list.add(9);
		list.add(1);
		
		Collections.sort(list);
		
		System.out.println(list.toString());
		scanner.close();
	}

}
