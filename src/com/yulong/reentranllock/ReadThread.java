package com.yulong.reentranllock;

public class ReadThread extends Thread{
	int id;
	ReenTest test;
	int num;
	public ReadThread(int id, ReenTest test, int executeTimes) {
		super();
		this.id = id;
		this.test = test;
		this.num = executeTimes;
	}
	@Override
	public void run() {
		int index;
		for (int i = 0; i < num; i++) {
			index = id * num + i;
			test.get(index);
		}
	}
}
