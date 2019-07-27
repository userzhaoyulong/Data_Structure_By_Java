package com.yulong.MapStudy;
/*
 * @Author Dragon
 * @Description //集合
 * @Date 10:25 2019/7/13
 * @Param
 * @return
 **/
public interface Map<K, V> {
    //向集合中增加元素
    void add(K key, V value);

    //删除集合中的某一个元素
    V remove(K key);

    //查看集合中是否包含某一个元素
    boolean contains(K key);

    //获取集合中的某一个元素
    V get(K key);

    //修改集合中的某一个元素
    void set(K key, V value);

    //获得集合的元素个数
    int getSize();

    //查看集合是否为空
    boolean isEmpty();
}
