package com.yulong.Test;

import java.util.TreeSet;

/**
 * @program: JavaInterview
 * @description:
 * @author: Dragon
 * @create: 2019-07-12 17:44
 */
public class TestMoShi {
    public static void main(String[] args) {
        String[] words = {"gin", "zen", "gig", "msg"};
        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        TreeSet<String> ts = new TreeSet<>();
        for(String word : words){
            StringBuilder res = new StringBuilder();
            for(int i = 0; i < word.length(); i++)
                res.append(codes[word.charAt(i) - 'a']);
            ts.add(res.toString());
        }
        System.out.println(ts);
        System.out.println(ts.size());
    }
}
