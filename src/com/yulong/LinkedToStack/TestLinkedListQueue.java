package com.yulong.LinkedToStack;

public class TestLinkedListQueue {
    public static void main(String[] args) {
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        for (int i = 0; i < 10; i++){
            linkedListQueue.enqueue(i);
        }
        System.out.println(linkedListQueue);

        linkedListQueue.dequeue();
        System.out.println(linkedListQueue);

        System.out.println(linkedListQueue.getFront());
    }
}
