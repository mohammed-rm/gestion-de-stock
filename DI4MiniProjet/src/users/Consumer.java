package users;

import management.Message;
import management.Stock;
import notification.Observer;

public class Consumer implements Observer {

	/*********************************************************************/
	/***************************** ATTRIBUTES ****************************/
	/*********************************************************************/
	private int consID;
	private String consName;
	private Stock stock;

	/*********************************************************************/
	/****************************** BUILDERS *****************************/
	/*********************************************************************/
	/**
	 * Builder
	 * 
	 * @param consName
	 * @param stock
	 */
	public Consumer(String consName, Stock stock) {
		this.consName = consName;
		this.stock = stock;
	}

	/**
	 * Builder
	 * 
	 * @param consName
	 */
	public Consumer(String consName) {
		this.consName = consName;
	}

	/**
	 * Builder
	 * 
	 * @param consName
	 * @param stock
	 */
	public Consumer(String consName, int id) {
		super();
		this.consName = consName;
		this.consID = id;
	}

	/*********************************************************************/
	/***************************** GETS/SETS *****************************/
	/*********************************************************************/
	/**
	 * @return the consID
	 */
	public int getConsID() {
		return consID;
	}

	/**
	 * @param consID the consID to set
	 */
	public void setConsID(int consID) {
		this.consID = consID;
	}

	/**
	 * @return the consName
	 */
	public String getConsName() {
		return consName;
	}

	/**
	 * @param consName the consName to set
	 */
	public void setConsName(String consName) {
		this.consName = consName;
	}

	/**
	 * @return the stock
	 */
	public Stock getStock() {
		return stock;
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
	 * Update method
	 * 
	 * @param msg
	 */
	@Override
	public void update(Message msg) {
		// TODO Auto-generated method stub
		System.out.println(" Consumer " + getConsName() + " got this message : " + msg.getMessageContent());
	}

}
