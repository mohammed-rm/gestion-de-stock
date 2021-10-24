package management;

import notification.Subject;

public class Stock extends Subject{
	
	/*********************************************************************/
	/***************************** ATTRIBUTES ****************************/
	/*********************************************************************/
	
	private int top;
	private static final Integer MAX = 2000;
	private int stack[];
	
	
	/*********************************************************************/
	/****************************** BUILDERS *****************************/
	/*********************************************************************/
	
	public Stock() {
		this.top = -1;
		this.stack = new int[MAX];
	}
	
	
	/*********************************************************************/
	/***************************** GETS/SETS *****************************/
	/*********************************************************************/
	
	
	/**
	 * @return the top
	 */
	public int getTop() {
		return top;
	}
	
	
	/**
	 * @return the stack
	 */
	public int[] getStack() {
		return stack;
	}
	

	/**
	 * @return the size
	 */
	public Integer getMAX() {
		return MAX;
	}
	
	
	/*********************************************************************/
	/***************************** METHODS *******************************/
	/*********************************************************************/
	
	
	public void push(int elt)
	{
		if(top >= MAX-1)
		{
			System.out.println("stack overflow");
		}
		else 
		{
			top++;
			stack[top]=elt;
			notifyObservers();
		}
	}
	
	public void display()
	{
		
		for(int i=0; i<=top;i++) 
		{
			System.out.println(stack[i]);
		}
	}
	public void pop()
	{
		if(top<0)
		{
			System.out.println("stack underflow");
		
		}
		else 
		{   
			top--;
			notifyObservers();
		}
	}
	
	
	public int peek() 
	{
		if(top==-1) {
			System.out.println("stack underflow");
			return -1;    //add exception here
		}
		else
		{
			return stack[top];
		}
	}
	
	public boolean isEmpty()
	{
		if(top==-1) return true;
		return false;
	}
	
	public boolean isFull() 
	{
		if(top==MAX) return true;
		return false;
	}

    public void clear() 
{
		while (top>-1) {
			top--;
			 
			notifyObservers();
	    }
}


	/**
	 * @return the max
	 */
	public static Integer getMax() {
		return MAX;
	}


	/**
	 * @param top the top to set
	 */
	public void setTop(int top) {
		this.top = top;
	}


	/**
	 * @param stack the stack to set
	 */
	public void setStack(int[] stack) {
		this.stack = stack;
	}
    
    
}
