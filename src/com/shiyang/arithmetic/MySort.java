package com.shiyang.arithmetic;

import java.util.ArrayList;
import java.util.Arrays;

public class MySort {
    public static void main(String[] args) {

    }
	/*
	 * 直接插入排序 ：从小到大 params:array[]待排序整型数组,length待排序数组长度
	 * 思路：1将原数组分为未排序和已排序两部分；2从第一个元素开始，该元素可以认为已经被排序；3取出下一个元素，在已经排好序的元素序列中从后向前扫描，
	 * 直到待排序元素小于该元素，插入其后
	 * 
	 */
	public static void insertSort(int[] array, int length) {
		for (int i = 1; i < length; i++) { // 将第i个元素依次与前i-1个元素进行比较，找到合适的位置
			int temp = array[i];
			int j = i;
			for (; j > 0 && array[j - 1] > temp; j--)
				array[j] = array[j - 1]; // 后移一位
			array[j] = temp;

		}

	}

	/*
	 * 直接选择排序 :从小到大 
	 * 优点：选择排序与其他排序相比减少了数组元素的交换次数，从而使得选择排序的平均效率一般比其他交换排序高
	 * 思路：每一步都从待排序的记录中选出排序码最小的记录，顺序存放在已排序的记录序列后面
	 */
	public static void selectSort(int[] array) {
		int flag; // min存每轮最小的，flag存每轮最小的记录的下标
		for (int i = 0; i < array.length - 1; i++) {
			flag = i;
			for (int j = i+1; j < array.length; j++) { // 从待排序的记录中找到最小的
				if (array[j] < array[flag]) {
					flag = j;
				}
			}
			if(flag!=i) {
				swap(array, flag, i);
			}
		}
	}
	/*
	 * 选择排序优化：二元选择排序
	 * 改进思路：每次排序找出最大和最小的元素，减少循环次数，从而提高查找的效率
	 */
	public static void doubbleSelectSort(int[]array,int length) {
		int min,max;
		for (int i = 0; i < length/2; i++) {
			min=max=i;
			for (int j = i+1; j < length-i; j++) {
				if(array[j]>array[max]) {
					max=j;
					continue;        //array[j]>array[max]，就一定不会小于array[min]
				}
				if (array[j]<array[min]) {
					min=j;
				}
			}
			if(min!=i) {
				swap(array, min, i);
			}
			if(max==i) {   //如果擂主位置为最大值，则上一步已将最大值换到了最小值打擂成功处
				max=min;
			}
			if(max!=length-i-1) {  //如果擂主不是无序数列最后一位则将其与最后一位交换，纳入有序数列
				swap(array, max, length-i-1);
			}
		}
	}

    /**
     * 冒泡排序： 思路：通过相邻元素之间的比较和交换，将排序码较小的元素逐渐从底部移向顶部
     * 比较次数=n*(n-1)/2;移动次数=3n*(n-1)/2;  O(n^2)
     * @param array 表
     * @param n 表长
     */
	public static void bubbleSort(int[] array,int n) {
		for (int i = 0; i < n - 1; i++) {
		    boolean flag=false; //表示本次冒泡是否发生交换的标志
			for (int j = n - 1; j >i; j--) { // 从后往前比较
				if (array[j-1] < array[j]) { // 若为逆序，交换位置
					swap(array, j, j - 1);
					flag=true;
				}
			}
//			if(flag==false) {
//			    return;     //本趟遍历后没有发生交换，说明表已有序
//            }
		}
	}

	/*
	 * 冒泡排序优化 冒泡缺点：1、当数组已经有序时，不能及时退出，而是继续判断是否交换；2、当无序数列尾部存在部分有序时仍然对有序部分进行判断
	 * 优化：当数组已经有序结束排序，无序部分尾部有序时改变无序数列的边界值
	 */
	public static void bubbleSort1(int[] array, int length) {
		boolean IsSorted;
		int LastPosition = 0;
		int SortBorder = length - 1;
		for (int i = 0; i < length - 1; i++) {
			IsSorted = true;
			for (int j = SortBorder; j > i; j--) {
				if (array[j-1] < array[j]) {
					swap(array, j, j - 1);
					IsSorted = false;
					LastPosition = j;
				}
			}
			SortBorder = LastPosition;
			if (IsSorted) {
				break;
			}
		}
	}

    /*
     * 快速排序O(nlogn)：分治法，将原问题分解成若干规模更小但结构与原问题相似的子问题。 通过递归地解决这些子问题，然后再将这些子问题的解组合成 原问题的解
     * 一；在待排序的n个记录中任选一个记录，以该记录的排序码为准，将所有记录都分成两组，第一组都小于该数，第二组都大于该数
     * 二：采用相同的方法对左右两组进行排序，知道所有的记录都排到相应得位置为止
     */
    private static void fastSort(int[] array, int left, int right) {
        if (left<right ) {
            //Partition划分操作，将表分成满足条件的两个子表
            int flag=Partition(array,left,right);   //划分
            fastSort(array,left,flag-1);    //依次对两个子表递归排序
            fastSort(array,flag+1,right);
            }
    }
    private static int Partition(int[] array,int left,int right) {
        int flag = array[left]; // 索引的基准,对表进行划分
        while (left != right) {      //一趟排序过程
            // 先从右边探测，直至找到小于等于基准数的记录
            while (array[right] >= flag && left < right) {
                right--;
            }
            array[left] = array[right]; //将比基准小的元素移到左端
            // 从左探测，
            while (array[left] <= flag && left < right) {
                left++;
            }
            array[right] = array[left]; //将比基准大的元素移到右端
        }
        array[left]=flag;   //基准元素存放到最终位置
        return left;    //返回存放基准的最终位置
    }
	/*
	 * 堆排序demo： 思路：将待排序序列构造成一个大顶堆，此时，整个序列的最大值就是堆顶的根结点。
	 * 将其与末尾元素交换，此时末尾就是最大值。然后将剩余n-1个元素重新构造成一个大顶堆， 这样可得到n个元素的次大值。如此反复执行，便能得到一个有序序列
	 */
	public static void HeapSort(int[] array) {
		// 构造大顶堆
		for (int i = array.length / 2 - 1; i >= 0; i--) {
			// 从最后一个非叶结点开始，从左至右调整堆结构
			adjustHeap(array, i, array.length);
		}
		// 2,调整堆结构+交换堆顶元素与末尾元素
		for (int i = array.length - 1; i > 0; i--) {
			swap(array, 0, i);
			adjustHeap(array, 0, i);
		}
	}

	// 调整大顶堆
	private static void adjustHeap(int[] arr, int i, int length) {
		int temp = arr[i]; // 取出当前元素
		for (int j = i * 2 + 1; j < length; j = j * 2 + 1) { // 从i结点的左子结点开始
			if (j + 1 < length && arr[j] < arr[j + 1]) { // 如果左子结点小于右子结点，j指向右子结点
				j++;
			}
			if (arr[j] > temp) {
				arr[i] = arr[j];
				i = j;
			} else {
				break;
			}
		}
		arr[i] = temp; // 将temp值放到当前位置

	}

	private static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

    /**
     * 归并排序
     * 思路：1把长度为n的数列分成两个长度为n/2的子序列；2对这两个子序列采用归并排序；3将两个已排序好的子序列合并成一个最终的序列
     * 将递归中创建的临时数组提出来，减少时间开销
     * @param array 待排序数组
     * @param left 左下标(从0下标开始)
     * @param right 右下标
     */
	public static void mergeSort(int[]array,int left,int right,int[] temp) {
		if(left<right){
		    int mid=(left+right)/2;
		    mergeSort(array,left,mid,temp);  //左边归并排序，使得左子序列有序
		    mergeSort(array,mid+1,right,temp);  //右边归并排序，使得右子序列有序
		    merge(array,left,mid,right,temp);   //将两个有序子序列组合并操作
        }
	}

	public static void merge(int[] array,int left,int mid,int right,int[] temp){
	    int i=left; //左子序列指针
        int j=mid+1; //右子序列指针
        int t=0;  //临时数组指针
        for (;t<right-left+1;t++){
            if(i>mid){  //将右边剩余元素填充到temp
                temp[t]=array[j++];
            }else if(j>right){  //将左边剩余元素填充到temp
                temp[t]=array[i++];
            }else if(array[i]<=array[j]){   //若左边较小，将较小者填充到temp
                temp[t]=array[i++];
            }else{
                temp[t]=array[j++];
            }
        }
        //将temp中的元素全部拷贝到原数组
        for(i=left,t=0;i<=right;i++,t++){
            array[i]=temp[t];
        }

    }

}
