package com.shiyang.dataStructure;

import java.util.Stack;

/**
 * 利用两个栈来实现队列:先进先出
 */
public class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    private int pop() {
        while (this.stack1.size() > 0) {
            Integer x = this.stack1.pop();
            this.stack2.push(x);
        }

        return this.stack2.pop();
    }
    private void push(Integer x) {
        this.stack1.push(x);
    }

    public static void main(String[] args) {
        MyQueue myQueue=new MyQueue();
        for (int i = 1; i <=5 ; i++) {
            myQueue.push(i);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(myQueue.pop());
        }
    }
}
