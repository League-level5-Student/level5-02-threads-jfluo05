package _04_Thread_Pool;

public class ThreadPoolTester {
public static void main(String[] args) {
	WorkQueue wq= new WorkQueue();
	System.out.println("Total threads: "+ wq.getThreadCount());
	try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		e.printStackTrace();
		// TODO: handle exception
	}
	wq.shutdown();
}
public interface Job{
	void perform();
}
}
