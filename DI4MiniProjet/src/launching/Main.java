package launching;

import management.Stock;
import view.AppView;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stock stock = new Stock();
		String file_name = "backup/backup_file.txt";
		try {
			AppView appView = new AppView(stock);
			System.out.println("Text File Written To " + file_name);
		} catch (Exception e) {
			System.out.println("Error");
		}

	}

}
