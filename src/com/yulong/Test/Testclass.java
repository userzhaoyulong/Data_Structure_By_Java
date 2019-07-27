package com.yulong.Test;

/**
 * @program: JavaInterview
 * @description:
 * @author: Dragon
 * @create: 2019-07-23 10:57
 */
public class Testclass {

    static {
        System.out.println("first static running...");
    }

    static public void main(String[] args) {
        /*new A();
        int array[];
        array = new int[3];*/
//        System.out.println("Main test runnong...");

        new A();
    }

    static {
        System.out.println("Last static running...");
    }
}

class B {

    public static int nums;

    static {
        System.out.println("Load B");
    }
    /*public B(){
        System.out.println("Create B");
    }*/

    public B(int i) {
        System.out.println("Create B");
    }
}

class A extends B {

    public int i;
    public String name;

    static {
        System.out.println("Load A");
    }
    public A(){
        super(3);
        System.out.println("Create A");
    }

    public int A(){
        return 3;
    }
}
