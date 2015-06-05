package lamal.observer_observable.simple_poc;

public class TestClass {

	public static void main(String[] args) {
		
		MyObservable myObservable = new MyObservable();
		ObserverOne observerOne = new ObserverOne();
		ObserverTwo observerTwo = new ObserverTwo();
		
		myObservable.addObserver(observerOne);
		myObservable.addObserver(observerTwo);
		myObservable.informObservers(10);
	}
}
