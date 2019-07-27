package com.yulong.queue;

import java.util.Random;

public class TestLoopAndArray {

    public static double testTime(Queue<Integer> queue, int count){
        Random random = new Random();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < count; i++)
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        for (int i = 0; i < count; i++)
            queue.dequeue();
        long endTime = System.currentTimeMillis();
        return (endTime - startTime) / 1000.0;
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        int count = 1000000;
        System.out.println(testTime(loopQueue, count));
        System.out.println(testTime(arrayQueue, count));

    }
}
