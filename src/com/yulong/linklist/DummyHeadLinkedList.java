package com.yulong.linklist;

public class DummyHeadLinkedList<E> {
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

    private Node dummyHead;
    private int size;

    public DummyHeadLinkedList(){
        dummyHead = new Node(null, null);
        size = 0;
    }

    /*
    * 获取链表中的元素的个数
    * */
    public int getSize(){
        return size;
    }

    /*
    * 判断链表是否为空
    * */
    public boolean isEmpty(){
        return size == 0;
    }

    /*
    * 向链表中任意位置之后添加一个节点
    * Java类库中并不会这样添加节点,类库中是在链表末尾添加节点
    * */
    public void addNode(int index, E e){
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed.Illegal index.");

        Node prev = dummyHead;
        //从第一个节点前的那个虚拟节点开始遍历，所以需要遍历到index位置
        for (int i = 0; i < index; i++)
            prev = prev.next;
        //插入节点
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;
        prev.next = new Node(e, prev.next);
        size++;
    }

    /*
     * 向链表头增加节点
     * */
    public void addFirst(E e){
        /*Node node = new Node(e);
        node.next = head;
        head = node;*/

        addNode(0,e);

       /* head = new Node(e,head);
        size++;*/
    }

    /*
    * 向链表末尾添加元素
    * */
    public void addLast(E e){
        /*Node temp = head;
        while (temp.next !=null)
            temp = temp.next;
        temp.next = new Node(e, temp.next);*/

        addNode(size, e);
    }

    /*
    * 获得链表的某一个位置的元素,位置和下标差1
    * 链表中不常用方法，练习
    * */
    public E get(int index){
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed.Illegal index.");
        Node curr = dummyHead.next;
        for (int i = 0; i < index; i++)
            curr = curr.next;
        return curr.e;
    }

    /*
     * 获得链表的第一个位置的元素
     * */
    public E getFirst(){
        return get(0);
    }

    /*
     * 获得链表的最后一个位置的元素
     * */
    public E getLast(){
        return get(size - 1);
    }

    /*
     * 修改链表中的某一个元素
     * */
    public void set(int index, E e){
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed.Illegal is index.");
        Node curr = dummyHead.next;
        for (int i = 0; i < index; i++)
            curr = curr.next;
        curr.e = e;
    }

    /*
     * 查找链表中的某一个元素是否存在
     * */
    public boolean contains(E e){
        Node curr = dummyHead.next;
        while (curr != null){
            if (curr.e.equals(e))
                return true;
            curr = curr.next;
        }
        return false;
    }

    /*
    * 在链表中删除某一个元素
    * */
    public boolean removeElement(E e){
        Node delNode = dummyHead.next;
        Node prev = null;
        boolean flag = false;
        while (delNode != null){
            if (delNode.e.equals(e)){
                prev.next = delNode.next;
                delNode = null;
                flag = true;
                size--;
                break;
            }
            prev = delNode;
            delNode = delNode.next;
        }
        return flag;
    }

    /*
     * 在链表中删除某一个位置的元素
     * */
    public E removeIndex(int index){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed.Illegal is index.");
        Node delNode = dummyHead.next;
        Node prev = null;
        E temp = null;
        for (int i = 0; i < index; i++){
            prev = delNode;
            delNode = delNode.next;
        }
        temp = delNode.e;
        prev.next = delNode.next;
        delNode = null;
        size--;
        return temp;
    }

    /*
     * 在链表中删除某一个位置的元素
     * */
    public E removeIndexYouHua(int index){
        if (index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed.Illegal is index.");
        Node prev = dummyHead;
        E temp = null;
        for (int i = 0; i < index; i++)
            prev = prev.next;
        Node delNode = prev.next;
        prev.next = delNode.next;
        temp = delNode.e;
        delNode = null;
        size--;
        return temp;
    }

    /*
    * 删除第一个元素
    * */
    public E removeFirst(){
        return removeIndexYouHua(0);
    }

    /*
     * 删除最后一个元素
     * */
    public E removeLast(){
        //位置和元素个数差1，所以最后一个元素的位置是size - 1
        return removeIndexYouHua(size - 1);
    }

    /*
    * 遍历链表
    * */
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("LinkedList: [");
        Node nextN = dummyHead.next;
        while (nextN != null){
            res.append(nextN.e);
            res.append("->");
            /*if(nextN.next != null)
                res.append(", ");*/
            nextN = nextN.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
