package com.yulong.PriorityQueueAndHeap;

/**
 * @program: JavaInterview
 * @description: 最大堆
 * @author: Dragon
 * @create: 2019-07-13 15:59
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MaxHeap(int capacity){
        data = new Array<>(capacity);
    }

    public MaxHeap(){
        data = new Array<>();
    }

    //heapify就是将一个乱序数组改造成一个最大堆
    public MaxHeap(E[] arr){
        data = new Array<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i--)
            siftDown(i);
    }

    //获取堆中元素个数
    public int size(){
        return data.getSize();
    }

    //检查堆中是否还有元素
    public boolean isEmpty(){
        return data.getSize() == 0;
    }

    //返回一个完全二叉树中的数组表示中，一个索引表示的元素的父亲节的索引
    private int parent(int index){
        if (index == 0)
            throw new IllegalArgumentException("index-0 does't have parent.");
        return (index - 1)/2;
    }

    //返回一个完全二叉树中的数组表示中，一个索引表示的元素的左孩子节点的索引
    private int leftChild(int index){
        return index * 2 + 1;
    }

    //返回一个完全二叉树中的数组表示中，一个索引表示的元素的右孩子节点的索引
    private int rightChild(int index){
        return index * 2 + 2;
    }

    //向堆中添加元素
    public void add(E e){
        data.addLast(e);
        sifrUp(data.getSize() - 1);
    }

    //向堆中添加元素，按照堆的定义添加元素
    private void sifrUp(int k){
        //K节点的值如果比其父节点的值小，就上浮（即和其父亲节点交换位置）
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0){
            data.swap(k, parent(k)); //交换两个元素
            k = parent(k);
        }
    }

    //查看堆中最大元素
    public E findMax(){
        if (data.getSize() == 0)
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
        return data.get(0);
    }

    //取出堆中最大元素
    public E extractMax(){
        E ret = findMax();
        data.swap(0,data.getSize() - 1);   //首先将最大元素和堆中最后一个元素交换位置
        data.removeLast();   //删除末尾元素
        //此时堆中的元素顺序是不对的，需要调整
        siftDown(0);
        return ret;
    }

    private void siftDown(int k){
        while (leftChild(k) < data.getSize()){
            int j = leftChild(k);
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0)
                j = rightChild(k); //data[j]是左右孩子中的最大值
            if (data.get(k).compareTo(data.get(j)) >= 0)    //比较父亲节点和孩子节点比较大小，如果父亲结点比孩子节点大，就不需要交换（下沉）
                break;
            data.swap(k,j);//交换（下沉）
            k = j;   //进行下一轮循环下沉
        }
    }

    //去除堆中最大元素，并且替换成e，一次log(n)操作
    public E replace(E e){
        E ret = findMax();
        data.set(0,e);   //将堆顶元素替换成e
        siftDown(0);
        return ret;
    }

}
