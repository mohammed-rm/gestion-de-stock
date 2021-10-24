package launching;

import management.Stock;
import view.AppView;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stock stock = new Stock();
		AppView appView = new AppView(stock);
	}

}
