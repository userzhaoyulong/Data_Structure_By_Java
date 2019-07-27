package com.yulong.MapStudy;

import java.util.ArrayList;

/**
 * @program: JavaInterview
 * @description: 测试链表集合和二叉树集合的时间复杂度
 * @author: Dragon
 * @create: 2019-07-13 14:08
 */
public class TestMap {

    private static double testMap(Map<String,Integer> map, String filename){
        long startTime = System.nanoTime();
        System.out.println("pride-and-prejudice");
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename,words)){
            System.out.println("Total words: " + words.size());
            for (String word : words){
                if (map.contains(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word,1);
            }
            System.out.println("Total different words: " + map.getSize());
            System.out.println("pride happen times: " + map.get("pride"));
            System.out.println("prejudice happen times: " + map.get("prejudice"));
            System.out.println("is happen times: " + map.get("is"));
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        LinkedListMap<String,Integer> linkedListMap = new LinkedListMap<>();
        BSTMap<String, Integer> bstMap = new BSTMap<>();

        double bstTime = testMap(bstMap, "pride-and-prejudice.txt");
        System.out.println("bstTime: " + bstTime);
        System.out.println("*******************************");
        double linkedTime = testMap(linkedListMap, "pride-and-prejudice.txt");
        System.out.println("linkedTime: " + linkedTime);
    }
}
