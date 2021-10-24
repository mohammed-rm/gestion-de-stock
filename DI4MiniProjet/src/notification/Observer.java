package notification;

/**
 * Abstract class to allows concrete observers to be notified when stock is
 * modified
 *
 */
public interface Observer {

	public abstract void update();
}