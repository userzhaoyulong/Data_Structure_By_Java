package com.yulong.MyBST;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @program: JavaInterview
 * @description:
 * @author: Dragon
 * @create: 2019-06-08 13:07
 */
public class BST<E extends Comparable<E>> {
    private class Node{
        public E e;
        public Node left;
        public Node right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    //获取树中元素个数
    public int size(){
        return size;
    }

    //树是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //向二分搜索树中添加元素
    public void add(E e){
        if (root == null){
            root = new Node(e);
            size++;
        }else
            add1(root,e);

//        root = add2(root,e);
    }

    //以node为根的二分搜索树中插入元素e,递归实现
    private void add1(Node node, E e){
        if (e .equals(node.e))
            return;
        else if (e.compareTo(node.e) < 0 && node.left == null){
            node.left = new Node(e);
            size++;
            return;
        }else if (e.compareTo(node.e) > 0 && node.right == null){
            node.right = new Node(e);
            size++;
            return;
        }
        //递归调用
        if (e.compareTo(node.e) < 0)
            add1(node.left,e);
        if (e.compareTo(node.e) > 0)
            add1(node.right,e);
    }

    //以node为根的二分搜索树中插入元素e,递归实现
    //此处优化了add1()中的判断，首先不管左右孩子是否为空，都可以作为一个二叉树
    //只不过空的就是空的二叉树，这时就可以一直判断，知道下一节点为空，就创建一个节点返回，
    private Node add2(Node node, E e){
        if (node == null){
            size++;
            return new Node(e);
        }
        //递归调用，已经有的元素不做操作
        if (e.compareTo(node.e) < 0) {
            node.left = add2(node.left,e);
        }
        if (e.compareTo(node.e) > 0) {
            node.right = add2(node.right,e);
        }
        //返回最终以node为根节点的二叉树
        return node;
    }

    //查看二叉树中是否包含e
    public boolean contains(E e){
        return contains(root,e);
    }

    //递归查询
    private boolean contains(Node node, E e){
        if (node == null)
            return false;
        if (e.compareTo(node.e) == 0)
            return true;
        else if (e.compareTo(node.e) < 0){
            return contains(node.left,e);
        }else //e.compareTo(node.e) > 0
            return contains(node.right,e);
    }

    //前序遍历
    public void preOrder(){
        preOrder(root);
    }
    //递归遍历
    private void preOrder(Node node){
        if (node == null)
            return;
        System.out.print(node.e + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
    //非递归实现前序遍历
    public void preOrderNR(){
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            Node curr = stack.pop();
            System.out.print(curr.e + " ");

            if (curr.right != null)
                stack.push(curr.right);
            if (curr.left != null)
                stack.push(curr.left);
        }
    }

    //中序遍历
    public void inOrder(){
        inOrder(root);
    }

    private void inOrder(Node node){
        if (node == null)
            return;

        inOrder(node.left);
        System.out.print(node.e + " ");
        inOrder(node.right);
    }

    //后序遍历
    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(Node node){
        if (node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.e + " ");
    }

    //层序遍历
    public void levelOrder(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node curr = queue.remove();
            System.out.print(curr.e + " ");
            if (curr.left != null)
                queue.add(curr.left);
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }
    }

    //查询二分搜索树的最小元素
    public E minimum(){
        if (size == 0)
            throw new IllegalArgumentException("BST is Empty.");
        return minimum(root).e;
    }
    //递归查找最小元素
    private Node minimum(Node node){
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    //查询二分搜索树的最大元素
    public E minimax(){
        if (size == 0)
            throw new IllegalArgumentException("BST is Empty.");
        return minimax(root).e;
    }
    //递归查找最大元素
    private Node minimax(Node node){
        if (node.right == null)
            return node;
        return minimax(node.right);
    }

    //删除最小元素
    public E removeMin(){
        E min = minimum();
        root = removeMin(root);
        return min;
    }
    private Node removeMin(Node node){
        if (node.left == null){
            Node delNode = node.left;
            node.left = null;
            return delNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    //删除最大元素
    public E removeMax(){
        E max = minimax();
        root = removeMax(root);
        return max;
    }
    private Node removeMax(Node node){
        if (node.right == null){
            size--;
            Node delNode = node.left;
            node.left = null;
            return delNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    //删除任意元素
    public void removeEle(E e){
        root = removeEle(root,e);
    }
    private Node removeEle(Node node, E e){
        if (node == null)
            return null;

        if (e.compareTo(node.e) < 0){
            node.left = removeEle(node.left,e);
            return node;
        }else if (e.compareTo(node.e) > 0){
            node.right = removeEle(node.right,e);
            return node;
        }else {
            //如果左子树为空，就把右子树返回，并删除原来指向的右子树
            if (node.left == null){
                Node delNode = node.right;
                size--;
                node.right = null;
                return delNode;
            }
            if (node.right == null){
                Node delNode = node.left;
                size--;
                node.left = null;
                return delNode;
            }

            //左右子树都不为空时，采用Hibbard Deletion，通过找到右子树中最小元素来替代删除元素
            //也可以找出左子树中的最大元素，替代要删除的元素
            // 下面不需要显式写出size--，因为在removeMin(node.right)中已经减过了
            Node tempNode = minimum(node.right);
            tempNode.right = removeMin(node.right);
            tempNode.left = node.left;
            node.left = node.right = null;
            return tempNode;
        }
    }
}
