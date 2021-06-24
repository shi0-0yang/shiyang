package com.shiyang;

public class BitOperation {
    public static void main(String[] args) {

        byte a = 0B00110010;    //十进制50
        byte b = 0B01011110;    //十进制94

        int num=0;
        int count=0;

        int[] arr=new int[]{1,2,3,4,5,4,3,2,1};
        int temp=0; //临时变量



//        //判断一个数是奇数还是偶数
//        if((a&1)==1)  //a为偶数，则结果为0；为奇数则运算结果为1。a&1取末尾值
//        {
//            System.out.println(a+"为奇数");
//        }else {
//            System.out.println(a+"为偶数");
//        }

//        //求num在二进制下1的个数（运算次数只与1的个数有关）
//        while(num>0){
//            count++;
//            num=num&(num-1);
//        }
//        System.out.println(num+"在二进制下含有1的个数为:"+count);

//        //求数组中只出现一次的数（运算次数为N）
//        for(int i=0;i<arr.length;i++){
//            temp^=arr[i];
//        }
//        System.out.println("数组中只出现一次的数"+temp);




//        System.out.println("a | b = " + (a | b));     // 0B01111110
//        System.out.println("a & b = " + (a & b));     // 0B00010010
//        System.out.println("a ^ b = " + (a ^ b));     // 0B01101100
//        System.out.println("~b = " + (~b));         // 0B10100001
//        System.out.println("a >> 2 = " + (a >> 2));     // 0B00001100
//        System.out.println("a >> 1 = " + (a >> 1));     // 0B00011001
//        System.out.println("a >>> 2 = " + (a >>> 2));   // 0B00001100
//        System.out.println("a << 2 = " + (a << 2));     // 0B11001000
//        System.out.println("a << 1 = " + (a << 1));     // 0B01100100
//        int c = -12;
//        System.out.println("c >>> 2 = " + (c >>> 2));
//        System.out.println("c >> 2 = " + (c >> 2));
    }

    /**
     * 只出现一次的数字②；
     * 有限状态自动机+位运算
     * 三个状态00->01->10->00;这两位设为two,one; 题目信息：出现一次或出现三次，即不存在10,只需输出ones位即可
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for(int num : nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }
}
