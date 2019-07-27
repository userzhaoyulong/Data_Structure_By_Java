package com.yulong.ReadAndWriteLock;

import java.util.ArrayList;
import java.util.List;

public class Index {
	public static void main(String[] args) {
		int numThreads = 10;
		int readNum = 1;
		int exeTimes = 50000;    //读写次数
		List<Integer> myList = new ArrayList<>();
		for (int i = 0; i < readNum; i++) {
			for (int j = 0; j < exeTimes; j++) {
				myList.add(i * exeTimes + j);
			}
		}

		ReWrTest test = new ReWrTest(myList);
		long startTime = System.currentTimeMillis();
		Thread[] rd = new ReadThread[readNum];
		int writeNum = numThreads - readNum;
		Thread[] wd = new WriteThread[writeNum];
		for (int i = 0; i < readNum; i++) {
			rd[i] = new ReadThread(i, test, exeTimes);
			rd[i].start();
		}
		System.out.println("读线程已经开始了。");
		
		for (int i = 0; i < writeNum; i++) {
			wd[i] = new WriteThread(readNum + i, test, exeTimes);
			wd[i].start();
		}
		System.out.println("写线程已经开始了。");
		
		try {
			for (int i = 0; i < readNum; i++)
				rd[i].join();
			for (int j = 0; j < writeNum; j++) 
				wd[j].join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("使用可重入锁花费时间为：" + (endTime - startTime) + "ms");
	}
}
