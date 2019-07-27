package com.yulong.linklist;

public class LinkedListStack<E> implements LinkedStack<E>{

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

    private Node head;
    private int size;

    public LinkedListStack(){
        head = null;
        size = 0;
    }

    @Override
    public void push(E e) {
        head = new Node(e, head);
        size++;
    }

    @Override
    public E pop() {
        /*if (head == null)
            System.out.println("head is empty." + head);*/
        E temp = head.e;
        head = head.next;
        size--;
        return temp;
    }

    @Override
    public E peek() {
        return head.e;
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
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("LinkedStack: front [");
        Node curr = head;
        while (curr != null){
            res.append(curr.e);
            res.append(", ");
            curr = curr.next;
        }
        res.append("] tail");
        return res.toString();
    }
}
