package notification;

import java.util.ArrayList;
import java.util.List;

import management.Message;

/**
 * Abstract class to manage the concrete observer of stock
 *
 */
public abstract class Subject {

	// Observers list
	private List<Observer> observers = new ArrayList<Observer>();

	public Subject() 
	{
		observers = new ArrayList<Observer>();
	}
	
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
	 * Notify observers
	 */
	public void notifyUpdate(Message message) 
	{
		for (Observer observer : observers) 
		{
			observer.update(message);
		}
	}

}