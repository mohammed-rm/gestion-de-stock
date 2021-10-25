package management;

import java.io.IOException;
import java.time.LocalDateTime;

import notification.Subject;

/**
 * Class that contains all operations available on the stock
 *
 */
public class Stock extends Subject {

	/*********************************************************************/
	/***************************** ATTRIBUTES ****************************/
	/*********************************************************************/
	private int top;
	private static final Integer MAX = 20;
	private int stack[];
	private Log data;

	/*********************************************************************/
	/****************************** BUILDERS *****************************/
	/*********************************************************************/
	/**
	 * Default builder
	 */
	public Stock() {
		this.top = -1;
		this.stack = new int[MAX];
		data = new Log("backup/backup_file.txt");
	}

	/*********************************************************************/
	/***************************** METHODS *******************************/
	/*********************************************************************/
	/**
	 * To push element into stock
	 * 
	 * @param elt
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public void push(int elt) throws ArrayIndexOutOfBoundsException {
		if (top >= MAX) {
			System.out.println("Stack overflow");
			notifyUpdate(new Message("Warning ! product not stocked, the stock is full ! "));
			throw new ArrayIndexOutOfBoundsException();
		} else {
			top++;
			stack[top] = elt;
			// write into file
			try {
				data.saveIntoFile(
						"The product : " + elt + " was successfully added to the stock on " + LocalDateTime.now());
			} catch (IOException e1) {
				System.out.println("Something went wrong with saveIntoFile! ");
			}
			// notify observers
			try {
				notifyUpdate(new Message(" The last product produced and still stored is : " + peek()));
			} catch (ArrayIndexOutOfBoundsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (top == MAX - 1) {
				notifyUpdate(new Message("Warning ! the stock is full ! "));
			}
			if (top == MAX - 2) {
				notifyUpdate(new Message("Warning ! the stock is almost full ! "));
			}

		}
	}

	/**
	 * Method to display stock products
	 */
	public void display() {

		for (int i = 0; i <= top; i++) {
			System.out.println(stack[i]);
		}
	}

	/**
	 * Method to remove the head element
	 * 
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public void pop() throws ArrayIndexOutOfBoundsException {
		if (top < 0) {
			System.out.println("stack underflow");
			throw new ArrayIndexOutOfBoundsException();
		} else {
			top--;
			// write into file
			try {
				data.saveIntoFile("Product successfully deleted from the stock on " + LocalDateTime.now());
			} catch (IOException e1) {
				System.out.println("Something went wrong with saveIntoFile!");
			}
			// notify observers
			if (top == 0) {
				notifyUpdate(new Message("Warning ! the stock is almost empty! "));
				notifyUpdate(new Message("The last product produced and still stored is : " + peek()));
			}
			if (top == -1) {
				notifyUpdate(new Message("Warning ! the stock is empty ! "));
			} else {
				try {
					notifyUpdate(new Message("The last product produced and still stored is : " + peek()));
				} catch (ArrayIndexOutOfBoundsException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Peek method
	 * 
	 * @return
	 * @throws ArrayIndexOutOfBoundsException
	 */
	public int peek() throws ArrayIndexOutOfBoundsException {
		if (top == -1) {
			System.out.println("stack underflow ");
			throw new ArrayIndexOutOfBoundsException();
		} else {
			return stack[top];
		}
	}

	/**
	 * Test the state of the stock
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		if (top == -1)
			return true;
		return false;
	}

	/**
	 * Test the state of the stock
	 * 
	 * @return
	 */
	public boolean isFull() {
		if (top == MAX)
			return true;
		return false;
	}

	/**
	 * To empty the stock
	 * 
	 * @throws Exception
	 */
	public void clear() throws Exception {
		if (top <= -1) {
			notifyUpdate(new Message("Warning ! the stock is already CLEARED ! "));
			throw new Exception();
		}

		while (top > -1) {
			top--;
		}
		// write into file
		try {
			data.saveIntoFile("Product successfully deleted from the stock on " + LocalDateTime.now());
		} catch (IOException e1) {
			System.out.println("Something went wrong with saveIntoFile! ");
		}
		// notify observers
		notifyUpdate(new Message("Warning ! the stock is CLEARED! "));
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
