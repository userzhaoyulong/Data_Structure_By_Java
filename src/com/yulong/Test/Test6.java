package com.yulong.Test;

class Test7 {
    public Test7() {
        System.out.println("Base");
    }
}

class Sub extends Test7 {
    public Sub() {
        super();
        System.out.println("Sun");
    }
}

public class Test6{
    public static void main(String[] args) {
        Test7 test6 = new Sub();
    }
}