package test;

import java.util.Arrays;

import com.shiyang.arithmetic.MySort;

public class TestSort {
public static void main(String[] args) {
	int[] array= {1,7,3,6,9,5};
	int i=0;
	Print(array);
	//MySort.bubbleSort(array);
	//MySort.bubbleSort1(array, array.length);
	//MySort.insertSort(array, array.length);
	//MySort.doubbleSelectSort(array, array.length);
	System.out.println(i++);
	System.out.println(i);
	Print(array);
	System.out.println(Arrays.toString(array));
}
public static void Print(int[] array) {
	for (int i : array) {
		System.out.print(i+"\t");
	}
	System.out.println();
}
}
