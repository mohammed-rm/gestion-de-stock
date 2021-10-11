package management;

import notification.Observer;

public class Admin implements Observer{

	private Integer AdminId;
	private Stock stock;
	
	public void createStock()
	{
		stock = new Stock();
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
