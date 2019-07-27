package com.yulong.MySet;

import java.util.ArrayList;

/**
 * @program: JavaInterview
 * @description:测试二叉树和链表实现的集合的时间复杂度
 * @author: Dragon
 * @create: 2019-07-12 16:36
 */
public class TimeTestByBSTAndLinked {
    private static double testSet(Set<String> set, String filename){
        long startTime = System.nanoTime();
        System.out.println(filename);
        ArrayList<String> words = new ArrayList<>();
        FileOperation.readFile(filename,words);
        System.out.println("Total words " + words.size());
        for (String word : words)
            set.add(word);
        System.out.println("Total different words " + set.getSize());
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    private static double testLinked(Set<String> set, String filename){
        long startTime = System.nanoTime();
        System.out.println(filename);
        ArrayList<String> words = new ArrayList<>();
        FileOperation.readFile(filename,words);
        System.out.println("Total words " + words.size());
        for (String word : words)
            set.add(word);
        System.out.println("Total different words " + set.getSize());
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        double time1 = testSet(new BSTSet<>(), "Pride-and-Prejudice.txt");
        System.out.println(time1);
        System.out.println(testLinked(new LinkedListSet<>(),"Pride-and-Prejudice.txt"));

        System.out.println("*************************");
        //System.out.println(testLinked(new LinkedListSet<>(),"a-tale-of-two-cities.txt"));
    }
}
