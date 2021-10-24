package launching;

import java.io.IOException;

import management.Log;
import management.Stock;
import view.AppView;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stock stock = new Stock();
		String file_name = "backup/backup_file.txt";
		try {
			Log data = new Log(file_name);
			data.saveIntoFile("Test");
			data.saveIntoFile("This is another line of text 40");
			System.out.println("Text File Written To " + file_name);
		} catch (IOException e) {
			System.out.println("Error");
		}
		AppView appView = new AppView(stock);
	}

}
