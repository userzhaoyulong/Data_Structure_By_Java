package com.yulong.MySet;

import java.util.ArrayList;

/**
 * @program: JavaInterview
 * @description:
 * @author: Dragon
 * @create: 2019-06-11 20:19
 */
public class TestBSTSet {
    public static void main(String[] args) {
        /*BSTSet<Integer> bstSet = new BSTSet<>();
        int[] nums = {5,3,6,8,4,2,7};
        for (int num : nums)
            bstSet.add(num);
        System.out.println();
        System.out.println(bstSet.getSize());*/

        System.out.println("Pride and Prejudice");
        ArrayList<String> word1 = new ArrayList<>();
        FileOperation.readFile("pride-and-prejudice.txt",word1);
        System.out.println("Total words: " + word1.size());

        BSTSet<String> set1 = new BSTSet<>();
        for (String word : word1)
            set1.add(word);
        System.out.println("Total different words: " + set1.getSize());

        System.out.println("****************************************");

        System.out.println("a-tale-of-two-cities");
        ArrayList<String> word2 = new ArrayList<>();
        FileOperation.readFile("a-tale-of-two-cities.txt",word2);
        System.out.println("Total words: " + word2.size());

        BSTSet<String> set2 = new BSTSet<>();
        for (String word : word2)
            set2.add(word);
        System.out.println("Total different words: " + set2.getSize());
    }
}
