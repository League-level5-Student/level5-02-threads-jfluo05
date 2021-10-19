package _06_Wait_and_Notify.Example;

import _05_Synchronized_Swimming.SynchronizedSwimming;

public class ThreadPrinter implements Runnable{
	static int totalThreads = 0;
	private int thread;
	public ThreadPrinter() {
		totalThreads++;
		thread = totalThreads;
	}
	
	@Override
	public void run() {
		SynchedThreadPrinter.threadLock(this);
		System.out.println("Thread " + thread + " Line 1");
		System.out.println("Thread " + thread + " Line 2");
		System.out.println("Thread " + thread + " Line 3");
		System.out.println("Thread " + thread + " Line 4");
	}
}
