package com.shiyang.arithmetic;

public class MySearch {

    //字符串模式匹配
    public static  int index(String str1,String match){
        int length1=str1.length(),length2=match.length();
        //i,j,k分别表示的是主串下标，匹配串下标，记录下次循环主串开始的位置
        int i=0,j=0,k=0;
        char[] char1=str1.toCharArray();
        char[] char2=match.toCharArray();
        while(i<length1&&j<length2){
            if(char1[i]==char2[j]) {
                i++;
                j++;
            }else {
                k++;
                j=0;
                i=k;
            }
        }
        if(j==length2) return  k+1;
        else return -1;
    }
	//顺序查找
	int SequenceSearch(int[] a, int value, int n)
	{
	    int i;
	    for(i=0; i<n; i++)
	        if(a[i]==value)
	            return i;
	    return -1;
	}
	/*
	 * 二分查找法
	 * params:	array:待查数组；left左边界；right右边界；key关键字
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
	 //插值查找
	 int InsertionSearch(int a[], int value, int low, int high)
	 {
	     int mid = low+(value-a[low])/(a[high]-a[low])*(high-low);
	     if(a[mid]==value)
	         return mid;
	     if(a[mid]>value)
	         return InsertionSearch(a, value, low, mid-1);
	     if(a[mid]<value)
	         return InsertionSearch(a, value, mid+1, high);
	     return 0;
	 }

    public static void main(String[] args) {
        String str1="abccdefggggcdefgh",str2="cdefgh";
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(index(str1,str2));
    }

}
