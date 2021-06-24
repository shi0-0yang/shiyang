package com.shiyang.dataStructure;

import java.util.*;

public class MyString {
    public static void main(String[] args) {

        String str="abc   123  def";
        String str1="hello";
        String str2="hello";
        Map<Integer,Integer> hashtable=new HashMap<>();
        Stack<Integer> stack=new Stack<>();

//        StringBuilder sb=new StringBuilder((CharSequence) System.in);
//
//        //根据给定的正则表达式的匹配拆分字符串。
//        //正则表达式：\s匹配任意空白符，+重复一次或多次
//        String[] str22=str.split("\\s+");
//        for (String s:str22
//             ) {
//            System.out.println(s);
//        }
//        System.out.println(str22.length);
//
//        str.concat("str");
//        str.compareTo(str1);
//        str.compareToIgnoreCase(str2);
//        str.compareTo(str1);
    }

    /**
     * 反转每对括号间的子串
     * 栈+动态规划
     * 思路:使用栈结构实现子串反转,优先Deque双端队列；从左到右遍历该字符串，使用str记录当前层所遍历到的小写字母，
     * 对于当前遍历的字符：
     * 如果是左括号，将str插入到栈中，并将str置空，进入下一层
     * 如果是右括号，这说明遍历完了当前层，需将str反转，返回给上一层。具体的，将栈顶字符串弹出，然后将反转后的str拼接到栈顶字符串末尾，将结果赋值给str.
     * 如果是小写字母，将其加到str末尾。
     * @param s
     * @return
     * a(bcdefghijkl(mno)p)q
     * str=a,stack=a,str=0;
     * str=bcdefghijkl,stack=abcdefghijkl,str=0;
     * str=mno,str=onm,str=lkjihgfedcbaonm
     * str=lkjihgfedcbaonm,str=pmnolkjihgfedcba;
     * str=qpmnolkjihgfedcba
     */
    public String reverseParentheses(String s) {
        Deque<String> stack=new LinkedList<String>();
        StringBuilder sb=new StringBuilder();
        for (int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                stack.push(sb.toString());
                sb.setLength(0);
            }else if(ch==')'){
                sb.reverse();
                sb.insert(0,stack.pop());
            }else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    /**
     * 匹配子串在字符串中出现的位置
     * KMP算法：
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {

        return haystack.indexOf(needle);
    }
}
