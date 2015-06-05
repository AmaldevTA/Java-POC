package lamal.threadpool.sigle_thread_cancel_old_task_on_new_submit;

import java.util.concurrent.ThreadPoolExecutor;

public class TestClass {
	
	public static void main(String[] args) {
		ThreadPoolExecutor pool = new InterruptingExecutorService(false);
		pool.execute(new MyJobs());
	}
}




class MyJobs implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		/*
		 * 
		 * do jobs that thake long time
		 * 
		 */
		System.out.println("job done");
	}
	
}
