package users;

import management.Stock;
import notification.Observer;

public class Consumer implements Observer{

	/*********************************************************************/
	/***************************** ATTRIBUTES ****************************/
	/*********************************************************************/
	private String consName;
	private Stock stock;
	
	
	/*********************************************************************/
	/****************************** BUILDERS *****************************/
	/*********************************************************************/
	/**
	 * @param consName
	 * @param stock
	 */
	public Consumer(String consName, Stock stock) {
		super();
		this.consName = consName;
		this.stock = stock;
	}
	
	
	/*********************************************************************/
	/***************************** GETS/SETS *****************************/
	/*********************************************************************/
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


	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
	
}
