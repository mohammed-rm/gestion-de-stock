package management;

import notification.Observer;
import users.*;

/**
 * Admin class to manage the stock and users
 *
 */
public class Admin implements Observer {

	/*********************************************************************/
	/***************************** ATTRIBUTES ****************************/
	/*********************************************************************/
	private Integer AdminId;
	private Stock stock;

	/*********************************************************************/
	/****************************** BUILDERS *****************************/
	/*********************************************************************/
	/**
	 * Builder
	 * 
	 * @param idAD
	 */
	public Admin(int idAD) {
		createStock();
		AdminId = idAD;
	}

	/*********************************************************************/
	/***************************** GETS/SETS *****************************/
	/*********************************************************************/
	/**
	 * @return the adminId
	 */
	public Integer getAdminId() {
		return AdminId;
	}

	/**
	 * @return the stock
	 */
	public Stock getStock() {
		return stock;
	}

	/**
	 * @param adminId the adminId to set
	 */
	public void setAdminId(Integer adminId) {
		AdminId = adminId;
	}

	/**
	 * @param stock the stock to set
	 */
	public void setStock(Stock stock) {
		this.stock = stock;
	}

	/*********************************************************************/
	/***************************** METHODS *******************************/
	/*********************************************************************/
	/**
	 * Allows the administrator to create the stock
	 */
	public void createStock() {
		stock = new Stock();
	}

	/**
	 * Allows the administrator to create a new consumer
	 * 
	 * @param name
	 * @param id
	 */
	public void createConsumer(String name, int id) {
		Consumer consumer = new Consumer(name, id);
	}

	/**
	 * Allows the administrator to create a new producer
	 * 
	 * @param name
	 * @param id
	 */
	public void createProducer(String name, int id) {
		Producer producer = new Producer(name, id);
	}

	/**
	 * Update method
	 * 
	 * @param msg
	 */
	@Override
	public void update(Message msg) {

		System.out.println("Admin " + getAdminId() + " received : " + msg.getMessageContent());

	}

}
