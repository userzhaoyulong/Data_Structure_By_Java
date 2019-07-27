package com.yulong.linklist;

public class TestDummyHeadLinkedList {

    public static void main(String[] args) {
        DummyHeadLinkedList<Integer> dummyHead = new DummyHeadLinkedList<>();
        for (int i = 0; i < 10; i++){
            dummyHead.addFirst(i);
            System.out.println(dummyHead);
        }

        System.out.println(dummyHead.get(8));
        System.out.println(dummyHead.contains(9));
        System.out.println(dummyHead.getFirst());
        System.out.println(dummyHead.getLast());

        dummyHead.addFirst(12);
        System.out.println(dummyHead.getFirst());

        dummyHead.addLast(21);
        System.out.println(dummyHead.getLast());

        System.out.println(dummyHead);

        dummyHead.addNode(5, 555);

        dummyHead.set(5, 111);

        System.out.println(dummyHead);

        System.out.println(dummyHead.removeElement(8));
        System.out.println(dummyHead);
//        System.out.println(dummyHead.removeIndex(3));
        System.out.println(dummyHead.removeIndexYouHua(3));
        System.out.println(dummyHead);

        System.out.println(dummyHead.removeFirst());
        System.out.println(dummyHead);

        System.out.println(dummyHead.removeLast());
        System.out.println(dummyHead);

        System.out.println(dummyHead.getSize());

        System.out.println(dummyHead.removeElement(1110));
        System.out.println(dummyHead.getSize());
    }

}
