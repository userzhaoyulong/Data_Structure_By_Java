package com.yulong.linklist;

import com.yulong.stack.ArrayStack;

import java.util.Random;

public class TestArrayLinkedStack {

    private static double testArrayStack(int count){
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        Random random = new Random();
        long startTime = System.nanoTime();
        for (int i = 0; i < count; i++){
            arrayStack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < count; i++){
            arrayStack.pop();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    private static double testLinkedListStack(int count){
        LinkedListStack<Integer> linkedStack = new LinkedListStack<>();
        Random random = new Random();
        long startTime = System.nanoTime();
        for (int i = 0; i < count; i++){
            linkedStack.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < count; i++){
            linkedStack.pop();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {

        int count = 100000000;

        System.out.print("ArrayStack time is ");
        System.out.println(testArrayStack(count));

        System.out.print("LinkedListStack time is ");
        System.out.println(testLinkedListStack(count));
    }
}
