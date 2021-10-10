package notification;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {

	// Observers list
	private List<Observer> observers = new ArrayList<Observer>();

	/**
	 * @param observer
	 */
	public void attach(Observer observer) {
		observers.add(observer);
	}

	/**
	 * @param observer
	 */
	public void detach(Observer observer) {
		observers.remove(observer);
	}

	/**
	 * 
	 */
	public void notifyObservers() {
		for (Observer observer : observers) {
			observer.update();
		}
	}

}