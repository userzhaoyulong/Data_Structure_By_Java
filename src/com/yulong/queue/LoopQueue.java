package com.yulong.queue;

public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front;
    private int tail;
//    队列中元素个数，也可以通过front和tail计算得出
//    private int size;

    public LoopQueue(int capacity){
        data = (E[]) new Object[capacity + 1];
        front = 0;
        tail = 0;
//        size = 0;
    }

    public LoopQueue(){
        this(10);
    }

    public int getCapacity(){
        return data.length - 1;
    }

    @Override
    public int getSize() {
        if(front < tail)
            return tail - front;
        if (front > tail)
            return data.length - (front - tail);
        return 0;
//        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public void enqueue(E e) {
        if (front == (tail + 1) % data.length)
            resize(getCapacity() * 2);
        data[tail] = e;
        tail = (tail + 1) % data.length;
//        size++;
    }

    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity + 1];
        int size = 0;
        if(front < tail)
            size = tail - front;
        if (front > tail)
            size = data.length - (front - tail);
        for (int i = 0; i < size; i++){
            newData[i] = data[(front + i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E dequeue() {
        if (isEmpty())
            throw new IllegalArgumentException("LoopQueue is Empty.");
        E temp = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
//        size--;
        int size = getSize();
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0){
            resize(getCapacity() / 2);
        }
        return temp;
    }

    @Override
    public E getFront() {
        if (isEmpty())
            throw new IllegalArgumentException("LoopQueue is Empty.");
        return data[front];
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
//        res.append(String.format("LoopQueue: size = %d, capacity = %d\n", size, getCapacity()));
        res.append(String.format("LoopQueue: size = %d, capacity = %d\n", getSize(), getCapacity()));
        res.append("front [");
       for (int i = front; i != tail; i = (i + 1) % data.length){
            res.append(data[i]);
            if ((i + 1) % data.length != tail)
                res.append(",");
        }
        res.append("] tail");
        return res.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        System.out.println(loopQueue.getCapacity());
        for (int i = 0; i < 10; i++){
            loopQueue.enqueue(i);
            System.out.println(loopQueue);
            if (i % 3 == 2){
                loopQueue.dequeue();
                System.out.println(loopQueue);
            }
        }
       /* loopQueue.dequeue();
        loopQueue.dequeue();
        loopQueue.dequeue();
        loopQueue.dequeue();
        loopQueue.dequeue();
        loopQueue.dequeue();
        loopQueue.dequeue();*/
        System.out.println(loopQueue.getSize() + "Size");
//        System.out.println(loopQueue.getFront());
        /*loopQueue.dequeue();
        System.out.println(loopQueue);*/
    }
}
