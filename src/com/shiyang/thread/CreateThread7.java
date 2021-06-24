package com.shiyang.thread;

import java.util.Arrays;
import java.util.List;

/**
 * Lambda表达式并行计算
 */
public class CreateThread7 {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1,2,3,4,5,6);
        CreateThread7 d=new CreateThread7();
        int result=d.add(list);
        System.out.println("计算后的结果为："+result);
    }
    public int add(List<Integer> list){
        //若Lambda是串行执行,则应顺序打印
        list.parallelStream().forEach(System.out::println);
        //Lambda有stream和parallelSteam(并行)
        return  list.parallelStream().mapToInt(i->i).sum();
    }
}
