package _04_Thread_Pool;
//SLIDE 57
import java.util.ArrayDeque;
import java.util.Iterator;

import _04_Thread_Pool.ThreadPoolTester.Job;

public class WorkQueue implements Runnable{
	private ArrayDeque<Job> jobQueue = new ArrayDeque<Job>();
	private Thread[] threads;
	private volatile boolean isRunning=true;
	
	public WorkQueue() {
	int totalThreads = Runtime.getRuntime().availableProcessors()-1;
	threads= new Thread [totalThreads];
	
	for (int i = 0; i < threads.length; i++) {
		threads[i]= new Thread (this);
		threads[i].start();
	}
	}
	
	
	public void addJob (Job j) {
		synchronized (jobQueue) {
		jobQueue.add(j);
		jobQueue.notify();
		}
	}
	
	public int getThreadCount() {
		return threads.length;
		
	}
	public void shutdown() {
		isRunning=false;
		synchronized (jobQueue) {
			jobQueue.notifyAll();
		}
	}
	
	public boolean performJob() {
		
		Job j=null;
		synchronized(jobQueue) {
			if(!jobQueue.isEmpty()) {
		j.perform();
		return true;
		}
				return false;
			}
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(isRunning) {
			System.out.println("Output from thread #" + Thread.currentThread().getId());
		synchronized (jobQueue) {
			try {
				jobQueue.wait();
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
			}
		}
		}
	}

}
