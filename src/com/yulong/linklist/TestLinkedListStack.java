package com.yulong.linklist;

public class TestLinkedListStack {
    public static void main(String[] args) {
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        for (int i = 0; i < 10; i++){
            linkedListStack.push(i);
        }
        System.out.println(linkedListStack);

        linkedListStack.pop();
        linkedListStack.pop();
        System.out.println(linkedListStack);
        System.out.println(linkedListStack.getSize());

        System.out.println(linkedListStack.peek());
        System.out.println(linkedListStack);
    }
}
