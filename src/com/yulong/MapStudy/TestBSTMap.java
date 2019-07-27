package com.yulong.MapStudy;

import java.util.ArrayList;

/**
 * @program: JavaInterview
 * @description: 测试链表实现的集合类
 * @author: Dragon
 * @create: 2019-07-13 11:01
 */
public class TestBSTMap {
    public static void main(String[] args) {
        System.out.println("pride-and-prejudice");
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt",words)){
            System.out.println("Total words: " + words.size());
            BSTMap<String,Integer> map = new BSTMap<>();
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
    }
}
