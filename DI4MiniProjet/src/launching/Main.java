package launching;

import management.Stock;
import users.Consumer;
import users.Producer;
import view.AppView;

public class Main {

	@SuppressWarnings("unused")
	public static void main(String[] args) {

		Consumer c1 = new Consumer("Cons1");
		Producer p1 = new Producer("Prod1");

		Stock s = new Stock();
		s.attach(c1);
		s.attach(p1);

		// fill the stock
		try {
			s.push(1);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Exception catched in push!");
		}

		try {
			s.push(2);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Exception in push!");
		}

		try {
			s.push(3);
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("Exception in push!");
		}

		try {
			s.push(4);
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("Exception in push!");
		}

		try {
			s.push(5);
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("Exception in push!");
		}

		// empty the stock
		try {
			s.pop();
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("Exception in pop!");
		}
		try {
			s.pop();
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("Exception in pop!");
		}
		try {
			s.pop();
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("Exception in pop!");
		}
		try {
			s.pop();
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("Exception in pop!");
		}
		try {
			s.pop();
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
			System.out.println("Exception in pop!");
		}

		/*
		 * s.attach(c1); s.attach(p1);
		 * 
		 * s.notifyUpdate(new Message("First Message")); //s1 and s2 will receive the
		 * update
		 * 
		 * s.detach(c1); s.attach(p2);
		 * 
		 * s.notifyUpdate(new Message("Second Message")); //s2 and s3 will receive the
		 * update
		 */

		String file_name = "backup/backup_file.txt";
		try {
			AppView appView = new AppView(s);
			System.out.println("Data will be saved in : " + file_name);
		} catch (Exception e) {
			System.out.println("Error launching the application!");
		}

	}

}
