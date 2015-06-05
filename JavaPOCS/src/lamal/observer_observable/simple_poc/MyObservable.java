package lamal.observer_observable.simple_poc;

import java.util.Observable;

public class MyObservable extends Observable {
	
	private int balance;
	
	public void informObservers(int b)
	{
		System.out.println("current thread-"+Thread.currentThread().getId());
		setChanged(); //it is a subjective design
		notifyObservers("balance has changed " + (balance+b));
		balance += b;
	}
}
