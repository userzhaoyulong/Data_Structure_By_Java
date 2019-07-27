package com.yulong.Test;

import java.util.Stack;

/**
 * @program: JavaInterview
 * @description:
 * @author: Dragon
 * @create: 2019-06-13 20:01
 */
public class Test {
    public static void main(String[] args) {
        Integer a = -2;
        System.out.println(Integer.bitCount(-2));
        System.out.println(Integer.parseInt("+123"));
        System.out.println(Integer.toBinaryString(-2));
        push(1);
        push(2);
        push(3);
        System.out.println(pop());
    }
    static Stack<Integer> stack1 = new Stack<Integer>();
    static Stack<Integer> stack2 = new Stack<Integer>();

    public static void push(int node) {
        stack1.push(node);
    }

    public static int pop() {
        while (!stack1.isEmpty())
            stack2.push(stack1.pop());
        int s = stack2.pop();
        System.out.println(stack2.pop() + "*");

        while (!stack2.isEmpty())
            stack1.push(stack2.pop());
        return s;
    }
}
