package com.sxy;
//找出B中不属于A的数
//找出数组B中不属于A的数，数组A有序而数组B无序。假设数组A有n个数，数组B有m个数，写出算法并分析时间复杂度。
public class B_out_of_A {
    //1.遍历B，将B中每个数与A比较，不存在则打印 O(m*n)
    private void func1(int[] A,int[] B){
        for (int b:B
             ) {
            for (int a:A
                 ) {
                if(a==b)
                    System.out.println();
            }
        }
    }
    //2.折半查找。遍历B,将B中每个数与A 折半比较，不存在则打印。O(mlogn)
    //3.排序+外排。将B排序，新建两指针a.b指向A.B首地址，比较a,b。若a<b,a指向下一位；若a==b，b指向下一位；
    // 若a>b说明A中不存在该元素，打印该元素并跳过该元素的查找，向后移动b,a或b到达数组末尾。 O(mlogm)+O(m+n)

}
