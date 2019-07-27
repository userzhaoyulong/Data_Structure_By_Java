package com.yulong.MapStudy;

/*
 * @Author Dragon
 * @Description //
 * @Date 11:26 2019/7/13
 * @Param
 * @return
 **/
public class BSTMap<K extends Comparable<K>, V> implements Map<K,V> {

    private class Node{
        public K key;
        public V value;
        public Node left,right;

        public Node(K key, V value){
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BSTMap(){
        root = null;
        size = 0;
    }

    @Override
    public void add(K key, V value) {
        root = add(root,key,value);
    }

    private Node add(Node node,K key, V value){
        if (node == null){
            size++;
            return new Node(key,value);
        }
        if (key.compareTo(node.key) < 0)
            node.left = add(node.left,key,value);
        if (key.compareTo(node.key) > 0)
            node.right = add(node.right,key,value);
        if (key.compareTo(node.key) == 0)
            node.value = value;
        return node;
    }

    private Node getNode(Node node, K key){
        if (node == null)
            return null;
        if (key.compareTo(node.key) < 0)
            return getNode(node.left, key);
        else if (key.compareTo(node.key) > 0)
            return getNode(node.right,key);
        else //key.compareTo(node.key) == 0
            return node;
    }

    @Override
    public V remove(K key) {
        Node node = getNode(root,key);
        if (node != null){
            root = remove(root,key);
            return node.value;
        }
        return null;
    }
    //删除任意元素，即删除树中一键为key的节点，并且返回删除后树的根
    private Node remove(Node node, K key){
        if (node == null)
            return null;

        if (key.compareTo(node.key) < 0){
            node.left = remove(node.left,key);
            return node;
        }else if (key.compareTo(node.key) > 0){
            node.right = remove(node.right,key);
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

    //递归查找最小元素
    private Node minimum(Node node){
        if (node.left == null)
            return node;
        return minimum(node.left);
    }

    //删除最小元素
    private Node removeMin(Node node){
        if (node.left == null){
            Node delNode = node.left;
            node.left = null;
            return delNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    @Override
    public boolean contains(K key) {
        return getNode(root,key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root,key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(root,key);
        if (node == null)
            throw new IllegalArgumentException(key + " does't exits.");
        node.value = value;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
