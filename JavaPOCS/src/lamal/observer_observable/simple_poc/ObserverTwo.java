package lamal.observer_observable.simple_poc;


import java.util.Observable;
import java.util.Observer;

public class ObserverTwo implements Observer
{

	public void update(Observable fromWhere, Object whatIstheMessage) {
		// TODO Auto-generated method stub
		
		System.out.println("You have got sms from--"+Thread.currentThread().getId());
		System.out.println("The sms is from " + fromWhere.getClass().getName());
		System.out.println("Message is " + whatIstheMessage);
	}
}
