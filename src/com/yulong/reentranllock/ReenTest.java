package com.yulong.reentranllock;

import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReenTest {
	private List<Integer> myList;
	private Lock lock = new ReentrantLock();
	public ReenTest(List<Integer> myList){
		this.myList = myList;
	}
	
	public Object get(int index) {
		lock.lock();
		try {
			return myList.get(index);
		} finally {
			lock.unlock();
		}
	}
	
	public boolean insert(int newValue) {
		lock.lock();
		try {
			return myList.add((Integer)newValue);
		} finally {
			lock.unlock();
		}
	}
}
