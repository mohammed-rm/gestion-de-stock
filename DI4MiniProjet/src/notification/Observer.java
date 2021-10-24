package notification;

import management.Message;

/**
 * Abstract class to allows concrete observers to be notified when stock is
 * modified
 *
 */
public interface Observer {

	public abstract void update(Message msg);
}