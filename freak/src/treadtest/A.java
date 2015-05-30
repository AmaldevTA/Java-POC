package treadtest;

import java.util.concurrent.locks.ReentrantLock;

public class A extends Thread{
		
	public static boolean FLG=false;
	private static  ReentrantLock lock = new ReentrantLock();;
		
	public A(String threadName) {
		start();
		setName(threadName);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			if(this.getName().equals("dad")){
				System.out.println("dad");
				lock.lock();

			}
			if(this.getName().equals("son")){
				System.out.println("son");
				lock.lock();
				
			}
		}
		
	}
	
	public static void main(String[] args) {
		
		A dad = new A("dad");
		A son = new A("son");
	}

}
