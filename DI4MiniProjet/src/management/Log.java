package management;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class Log {

	/*********************************************************************/
	/***************************** ATTRIBUTES ****************************/
	/*********************************************************************/
	private String fileName;
	private String filePath;
	private boolean fileAppend = true; // To append or to overwrite file content

	/*********************************************************************/
	/****************************** BUILDERS *****************************/
	/*********************************************************************/
	/**
	 * Default builder for the file path
	 * 
	 * @param path
	 */
	public Log(String path) {
		filePath = path;
	}

	public void saveIntoFile(String data) throws IOException {
		FileWriter file = new FileWriter(filePath, fileAppend);
		PrintWriter text = new PrintWriter(file);
		text.printf("%s" + "%n", data);
		text.close();
	}

	public static void main(String arg[]) {
		String file_name = "/DI4MiniProjet/backup";
		/*
		 * try{ ReadFile file = new ReadFile(file_name); String[] aryLines =
		 * file.OpenFile(); int i; for(i=0; i < aryLines.length; i++) {
		 * System.out.println(aryLines[i]); } catch (IOException e) {
		 * System.out.println("Error"); }
		 */
		try {
			Log data = new Log(file_name);
			data.saveIntoFile("Test");
			data.saveIntoFile("This is another line of text");
			System.out.println("Text File Written To");
		} catch (IOException e) {
			System.out.println("Error");
		}
	}

	/*********************************************************************/
	/***************************** GETS/SETS *****************************/
	/*********************************************************************/
	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

}
