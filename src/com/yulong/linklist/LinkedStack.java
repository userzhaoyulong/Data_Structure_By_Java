package com.yulong.linklist;

/*
* 使用链表实现栈
* */
public interface LinkedStack<E> {
    void push(E e);

    E pop();

    E peek();

    int getSize();

    boolean isEmpty();
}
