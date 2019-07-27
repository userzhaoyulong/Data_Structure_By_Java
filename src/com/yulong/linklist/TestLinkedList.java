package com.yulong.linklist;

/**
 * @program: JavaInterview
 * @description:
 * @author: Dragon
 * @create: 2019-06-04 18:09
 */
public class TestLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i = 0; i < 10; i++){
            linkedList.addNode(i,i);
        }
        System.out.println(linkedList);
        System.out.println(linkedList.getSize());

        System.out.println(linkedList.removeElement(4));
        System.out.println(linkedList);

        linkedList.addFirst(25);
        System.out.println(linkedList);

        System.out.println(linkedList.contains(50));
    }
}
