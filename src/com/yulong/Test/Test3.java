package com.yulong.Test;

/**
 * @program: JavaInterview
 * @description:
 * @author: Dragon
 * @create: 2019-06-27 14:26
 */
public class Test3 {
    public static void main(String[] args) {
        StringBuffer str = new StringBuffer();
        str.append("Hello World.");
        System.out.println(str.toString());

        int p1 = str.length() - 1;
        for(int i = 0; i <= p1; i++)
            if (str.charAt(i) == ' ')
                str.append("  ");
        System.out.println(str.toString());
        System.out.println(str.length() + "   " + p1);
    }
}
