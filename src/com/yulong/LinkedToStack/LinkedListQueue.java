package com.yulong.LinkedToStack;

public class LinkedListQueue<E> implements Queue<E> {
    /*
     * 内部类实现节点
     * */
    private class Node{
        //这设计成public使得外部类能直接访问
        public E e;
        public Node next;
        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e,null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head, tail;
    private int size;
    public LinkedListQueue(){
        head = tail = null;
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void enqueue(E e) {
        if (tail == null) {
            tail = new Node(e, tail);
            head = tail;
        }else {
            tail.next = new Node(e, tail.next);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("LinkedListQueue is Empty.");
        Node temp = head;
        head = head.next;
        temp.next = null;
        if (head == null)
            tail = null;
        size--;
        return temp.e;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("LinkedListQueue is Empty.");
        return head.e;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("LinkedListQueue: ");
        res.append("head ");
        Node curr = head;
        while (curr != null){
            res.append(curr.e);
            res.append("->");
            curr = curr.next;
        }
        res.append("NULL tail");
        return res.toString();
    }
}
