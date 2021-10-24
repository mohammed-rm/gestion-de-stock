package management;

import notification.Observer;
import users.*;

public class Admin implements Observer{

	private Integer AdminId;
	private Stock stock;
	
	/**
	 * Allows the administrator to create the stock
	 */
	public void createStock()
	{
		stock = new Stock();
	}
	
	/**
	 * Allows the administrator to create a new consumer
	 * @param name
	 * @param id
	 */
	public void createConsumer(String name, int id)
	{
		Consumer consumer = new Consumer(name, id);
	}
	
	/**
	 * Allows the administrator to create a new producer
	 * @param name
	 * @param id
	 */
	public void createProducer(String name, int id) {
		Producer producer = new Producer(name, id);
	}
	/**
	 *
	 */
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
