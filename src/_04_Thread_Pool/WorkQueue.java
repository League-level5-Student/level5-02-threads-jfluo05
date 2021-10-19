package _04_Thread_Pool;
import java.lang.Thread.State;
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
		completeAllJobs();
		isRunning=false;
		synchronized (jobQueue) {
			jobQueue.notifyAll();
		}
	}
	
	public boolean performJob() {
		
		Job j = null;
		synchronized (jobQueue) {
			if (!jobQueue.isEmpty()) {
				j=jobQueue.remove();
				if (j != null) {
					j.perform();
					return true;
				} 
			}
		}
		return false;

	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(isRunning) {
			if(!performJob()) {
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
	public void completeAllJobs() {
		while(!jobQueue.isEmpty()) {
			performJob();
		}
		for (int i = 0; i < threads.length; i++) {
			if(threads[i].getState()!=State.WAITING) {
				i=-1;
			}
		}
	}
	
	
}
