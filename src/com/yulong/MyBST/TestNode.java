package com.yulong.MyBST;

/**
 * @program: JavaInterview
 * @description:
 * @author: Dragon
 * @create: 2019-06-30 10:23
 */
public class TestNode {
    public static void main(String[] args) {
        Node<Integer> node = new Node<Integer>();
        int[] nums = {5, 3, 6, 8, 4, 2, 7};
        for (int num : nums)
            node.add(num);
        System.out.println();

        node.preOrder();
        System.out.println();
        node.inOrder();
        System.out.println();
    }
}
