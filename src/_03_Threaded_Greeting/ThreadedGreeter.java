package _03_Threaded_Greeting;

public class ThreadedGreeter implements Runnable{

	int num;
	ThreadedGreeter(int i){
		num=i;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
	System.out.println("Hello from thread number: " + num);	
			ThreadedGreeter tg = new ThreadedGreeter(num+1);

	if (num<50) {
		Thread th= new Thread (tg);
		th.start();
	try {
		th.join();
	}catch(InterruptedException e) {
		e.printStackTrace();
	}
	}
	}

}
