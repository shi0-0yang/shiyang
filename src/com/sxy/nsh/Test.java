package com.sxy.nsh;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Test{

    public static void main(String[] args) {
    	System.out.println(17^5);
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入N个字符：");
        String str=sc.next();
        String[] arr=str.split(",");
//        System.out.println(Arrays.toString(arr));

        List<String> list=new ArrayList<String>();
        for(int i=0;i<arr.length;i++){
            list.add(arr[i]);
        }
        System.out.println("原序输出：  "+list);

        Collections.sort(list);
        System.out.println("升序输出： "+list);

        Collections.sort(list,new Comparator<String>(){
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }});
        System.out.println("降序输出：   "+list);

        Collections.reverse(list);
        System.out.println("反转指定列表中元素的顺序     "+list);

//        Set set = new ArraySet(list);
//        HashSet<String> set=new HashSet<String>(list);
//        System.out.println("无序输出：  "+set);
//        升序  Collections.sort(list)    降序  Collections.reserve(list)   随机  Collections.shuffle(list)
sc.close();
    }
}