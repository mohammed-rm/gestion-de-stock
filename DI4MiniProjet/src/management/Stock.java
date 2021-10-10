package management;

import java.util.ArrayList;

import notification.Subject;

public class Stock extends Subject{
	
	/*********************************************************************/
	/***************************** ATTRIBUTES ****************************/
	/*********************************************************************/
	private Integer element;
	private Integer top;
	private final Integer size = null;
	private ArrayList<Integer> stack;
	
	
	/*********************************************************************/
	/****************************** BUILDERS *****************************/
	/*********************************************************************/
	/**
	 * @param element
	 * @param top
	 * @param stack
	 */
	public Stock(Integer element, Integer top, ArrayList<Integer> stack) {
		super();
		this.element = element;
		this.top = top;
		this.stack = stack;
	}
	
	
	/*********************************************************************/
	/***************************** GETS/SETS *****************************/
	/*********************************************************************/
	/**
	 * @return the element
	 */
	public Integer getElement() {
		return element;
	}
	/**
	 * @param element the element to set
	 */
	public void setElement(Integer element) {
		this.element = element;
	}
	/**
	 * @return the top
	 */
	public Integer getTop() {
		return top;
	}
	/**
	 * @param top the top to set
	 */
	public void setTop(Integer top) {
		this.top = top;
	}
	/**
	 * @return the stack
	 */
	public ArrayList<Integer> getStack() {
		return stack;
	}
	/**
	 * @param stack the stack to set
	 */
	public void setStack(ArrayList<Integer> stack) {
		this.stack = stack;
	}
	/**
	 * @return the size
	 */
	public Integer getSize() {
		return size;
	}
	
	
	/*********************************************************************/
	/***************************** METHODS *******************************/
	/*********************************************************************/
	
	
}
