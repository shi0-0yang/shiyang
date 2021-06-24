package com.sxy;

public class search {
	/*
	 * 二分查找
	 */
	 int BinarySearch(int[] array, int left, int right, int key) {
		int mid = -1;
		 mid = (left + right) / 2;
		if (key == array[mid]) {
			return mid;
		} else if (key < array[mid]) {
			return BinarySearch(array, left, mid - 1, key);
		} else if (key > array[mid]) {
			return BinarySearch(array, mid + 1, right, key);
		}
		return -1;
	}
	 /*
	  *	二分法扩展
	  * 请实现有重复数字的有序数组的二分查找。
      *输出在数组中第一个大于等于查找值的位置，如果数组中不存在这样的数，则输出数组长度加一。
      * @param n int整型 数组长度
     * @param v int整型 查找值
     * @param a int整型一维数组 有序数组
     * @return int整型
	  */
     public static int   upper_bound_(int n, int v, int[] a) {
    	 if(a==null||n==0||a[n-1]<v)  return n+1;
    	 if(a[0]>=v) return 1;
    	 int left=0,right=n-1;
    	 int mid=0;
    	 while (left<=right) {
			mid=(left+right)/2;
			if(a[mid]>=v) {
				if(mid==0||a[mid-1]<v)  return mid+1;
				right=mid-1;
			}else {
				left=mid+1;
			}
		}
	return n+1;
}
}
