package com.yulong.MapStudy;

/**
 * @program: JavaInterview
 * @description: 以链表为底层数据结构来实现集合
 * @author: Dragon
 * @create: 2019-07-13 10:33
 */
public class LinkedListMap<K, V> implements Map<K, V> {

    /*内部类实现集合的数据结构*/
    private class Node{
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next){
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key){
            this(key,null,null);
        }

        public Node(){
            this(null,null,null);
        }

        @Override
        public String toString() {
            return key.toString() + " : " + value.toString();
        }
    }

    //虚拟头结点
    private Node dummyHead;
    private int size;

    public LinkedListMap(){
        dummyHead = new Node();
        size = 0;
    }

    /*
     * @Author Dragon
     * @Description //辅助方法，获取key所对应的节点
     * @Date 10:42 2019/7/13
     * @Param [key]
     * @return com.yulong.MapStudy.LinkedListMap<K,V>.Node
     **/
    private Node getNode(K key){
        Node curr = dummyHead.next;
        while (curr != null){
            if (curr.key.equals(key))
                return curr;
            curr = curr.next;
        }
        return null;
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (node == null){
            //集合中还没有此元素，可以加入，此时虚拟头结点的下一个元素就是新添加元素的下一个元素，虚拟头结点的下一元素重新指向新添加的元素。
            dummyHead.next = new Node(key,value,dummyHead.next);
            size++;
        }else {
            //元素重复，此时并不抛出异常，而是理解为修改用户原有的值，也可以抛出异常
            node.value = value;
        }
    }

    @Override
    public V remove(K key) {
        Node prev = dummyHead;
        while (prev.next != null){
            if (prev.next.key.equals(key))
                break;;
            prev = prev.next;
        }
        if (prev.next != null){
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            size--;
            return delNode.value;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if (node == null)
            throw new IllegalArgumentException(key + "doesn't exist.");
        else
            node.value = newValue;
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
