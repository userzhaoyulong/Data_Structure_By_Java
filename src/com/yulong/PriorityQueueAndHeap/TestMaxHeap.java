package com.yulong.PriorityQueueAndHeap;

import java.util.Random;

/**
 * @program: JavaInterview
 * @description: 测试最大堆
 * @author: Dragon
 * @create: 2019-07-13 18:45
 */
public class TestMaxHeap {
    public static double testHeap(Integer[] testData, boolean isHeapify){
        long startTime = System.nanoTime();

        MaxHeap<Integer> maxHeap;
        if (isHeapify){
            maxHeap = new MaxHeap<>(testData);
        }else {
            maxHeap = new MaxHeap<>();
            for (int num : testData)
                maxHeap.add(num);
        }
        int[] arr = new int[testData.length];
        for (int i = 0; i < testData.length; i++)
            arr[i] = maxHeap.extractMax();   //数组中的数据是降序排列

        for(int i = 1; i < testData.length; i++)
            if (arr[i - 1] < arr[i])
                throw new IllegalArgumentException("堆异常。");
        System.out.println("Test MaxHeap completed.");
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }
    public static void main(String[] args) {
        int n = 5000000;
        Random random = new Random();
        Integer[] testDates = new Integer[n];
        for (int i = 0; i < n; i++)
            testDates[i] = random.nextInt(Integer.MAX_VALUE);

        double noHeapifyTime = testHeap(testDates, false);
        System.out.println("Without heapify: " + noHeapifyTime + "s");

        double heapifyTime = testHeap(testDates, true);
        System.out.println("With heapify: " + heapifyTime + "s");
        /*int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = maxHeap.extractMax();   //数组中的数据是降序排列

        for(int i = 1; i < 100; i++)
            if (arr[i - 1] < arr[i])
                throw new IllegalArgumentException("堆异常。");
        System.out.println("Test MaxHeap completed.");*/
    }
}
