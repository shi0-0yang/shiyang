package com.sxy;

import java.sql.Struct;
import java.util.Stack;

public class Main {


    public static class Teacher{
        String name;
        boolean sex;
        int age;
    }

    public static  int function3(int n)
    {
        if(n/10==0){
            return n;
        }
        return n%10+function3(n/10);
    }
    public static   boolean function2(int[] arr){
        int Sn=arr[0];      //存储前i-1项和
        for (int i = 1; i < arr.length; i++) {  //0<i<n,循环从1开始
            if(arr[i]==Sn){
                return true;
            }else {
                Sn+=arr[i];
            }
        }
        return  false;
    }
    /*
     * a[i]=i/((i+1)*(i+2)!)
     */
    public static float function1(int n){
        int temp=1;     //temp存储初试阶乘1！
        float fn=0;     //存储函数和
        for (int i = 0; i <= n ; i++) {
            temp=temp*(i+2); //(i+2)的阶乘
            fn+=(float) i/((i+1)*temp);
            System.out.println(fn);
        }
        return  fn;
    }
    public static void main(String[] args) {


        Teacher teacher=new Teacher(){};

//        System.out.println(function3(10351));
//        //静态初始化数组，方法一
//        int arr[]=new int[]{1,2,3,4,5};
////        int arr[]={1,2,3,4,5};
//        System.out.println(function2(arr));
//        System.out.println(function1(3));
//		Stack<Integer> stack=new Stack<>();
//    	Solution solution=new Solution();
//
//		System.out.printf(String.valueOf(24>>1));
	}

}
