package com.yulong.MySet;

import com.yulong.linklist.LinkedList;

/**
 * @program: JavaInterview
 * @description: 链表实现的集合类
 * 使用的是带虚拟头结点的链表
 * @author: Dragon
 * @create: 2019-07-12 15:43
 */
public class LinkedListSet<E> implements Set<E> {

    private LinkedList<E> list;

    /*一直报空指针异常，我一直以为是没有元素，结果调试时，发现元素也传过来了，一直很是疑惑，才发现没有初始化，平时应该注意这些的。*/
    public LinkedListSet(){
        list = new LinkedList<>();
    }

    @Override
    public void add(E e) {
        if (!list.contains(e))
            list.addFirst(e);
    }

    @Override
    public void remove(E e) {
        list.removeElement(e);
    }

    @Override
    public boolean contains(E e) {
        return list.contains(e);
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }
}
