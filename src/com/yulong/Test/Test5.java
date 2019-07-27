package com.yulong.Test;

/**
 * @program: JavaInterview
 * @description:
 * @author: Dragon
 * @create: 2019-07-26 11:14
 */
public class Test5 {
    public static void main(String[] args) {
        Super s = new Super();
        System.out.println(s.f());
        SubClass subClass = new SubClass();
        System.out.println(subClass.f());
        Super sb = new SubClass();
        System.out.println(sb.f());
    }
}

class Super{
    public int f(){
        return 1;
    }
}

class SubClass extends Super {
    public int f(){
        return 2;
    }
}