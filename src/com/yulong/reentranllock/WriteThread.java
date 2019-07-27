package com.yulong.reentranllock;

public class WriteThread extends Thread{
	int id;
	ReenTest test;
	int num;
	
	public WriteThread(int id, ReenTest test, int executeTimes) {
		super();
		this.id = id;
		this.test = test;
		this.num = executeTimes;
	}

	@Override
	public void run() {
		for (int i = 0; i < num; i++) {
			test.insert(id * num + i);
		}
	}
}
