package com.yulong.linklist;

public class LinkedList<E> {
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

        //初始化时有一个元素
        public Node(E e){
            this(e,null);
        }

        //初始化时没有元素
        public Node(){
            this(null,null);
        }

        //重写toString()方法
        @Override
        public String toString() {
            return e.toString();
        }
    }

    //不带虚拟头结点，第一个节点就是头结点
    private Node head;
    private int size;

    //初始化链表，头指针为空，元素个数为0
    public LinkedList(){
        head = null;
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
    * 向链表中指定位置添加一个节点
    * Java类库中并不会这样添加节点,类库中是在链表末尾添加节点
    * 此处只是实现这样实现而已
    * */
    public void addNode(int index, E e){
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Add failed.Illegal index.");
        if (index == 0)
            addFirst(e);
        else {
            Node prev = head;
            for (int i = 0; i < index - 1; i++)
                prev = prev.next;
            //插入节点
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;
            prev.next = new Node(e, prev.next);
            size++;
        }
    }

    /*
     * 向链表头部增加节点
     * */
    public void addFirst(E e){
        /*Node node = new Node(e);
        node.next = head;
        head = node;*/
        head = new Node(e,head);
        size++;
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

    /**
     * @Author Dragon
     * @Description 删除指定元素
     * @Date 18:46 2019/6/4
     * @Param [e]
     * @return boolean
     **/
    public boolean removeElement(E e){
        boolean flag = false;
        while (head != null && head.e == e){
            Node delNode = head;
            head = head.next;
            delNode.next = null;
            flag = true;
            return flag;
        }
        if (head == null){
            flag = true;
            return flag;
        }
        Node prev = head;
        while (prev.next != null){
            if (prev.next.e == e){
               /* Node delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;*/
                prev.next = prev.next.next;   //只是跳过了要被删除的节点，内存没有释放
                flag = true;
                break;
            }
            prev = prev.next;
        }
        return flag;
    }

    public boolean contains(E e){
        Node curr = head;
        while (curr != null){
            if (e.equals(curr.e))
                return true;
            curr = curr.next;
        }
        return false;
    }
    /*public E removeIndex(int index){
        if (index < 0 || index > size)
            throw new IllegalArgumentException("Fail to remove, Illega Index.");

        if (index == 0){

        }

        Node curr = head;
        for (int i = 0; i < index; i++)
            curr = curr.next;


    }*/

    @Override
    public String toString() {
        StringBuilder rb = new StringBuilder();
        rb.append("LinkedList{ ");
        Node curr = head;
        while (curr != null){
            rb.append(curr.e + "->");
            curr = curr.next;
        }
        rb.append("NULL }");
        return rb.toString();
    }
}
