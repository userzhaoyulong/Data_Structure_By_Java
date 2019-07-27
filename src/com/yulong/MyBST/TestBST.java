package com.yulong.MyBST;

/**
 * @program: JavaInterview
 * @description:
 * @author: Dragon
 * @create: 2019-06-10 18:16
 */
public class TestBST {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5,3,6,8,4,2};
        for (int num : nums)
            bst.add(num);
        System.out.println();
        /*
         *       5
         *    3     6
         *  2  4      7
         *              8
         **/
        bst.preOrder();
        System.out.println();
        bst.inOrder();
        /*bst.preOrderNR();
        System.out.println();
        System.out.println(bst.contains(2));
        System.out.println(bst.size());
        bst.inOrder();

        System.out.println();
        bst.postOrder();

        System.out.println();
        bst.levelOrder();
        System.out.println();

        System.out.println(bst.minimum());
        System.out.println(bst.minimax());

        System.out.println(bst.removeMin());
        System.out.println(bst.minimum());
        bst.preOrder();
        System.out.println("***************************");*/

        /*bst.removeMax();
        System.out.println(bst.minimax());
        bst.preOrder();

        System.out.println();
        bst.removeEle(3);
        bst.preOrder();*/
    }
}
