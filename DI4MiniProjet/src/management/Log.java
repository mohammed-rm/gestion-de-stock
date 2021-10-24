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
	private boolean fileAppend = true; // To append (true) or to overwrite (false) file content

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

	/**
	 * Method to save stock data into a text file
	 * @param data
	 * @throws IOException
	 */
	public void saveIntoFile(String data) throws IOException {
		FileWriter file = new FileWriter(filePath, fileAppend);
		PrintWriter text = new PrintWriter(file);
		text.printf("%s" + "%n", data);
		text.close();
	}
	/*********************************************************************/
	/***************************** GETS/SETS *****************************/
	/*********************************************************************/
	
	
	/**
	 * @return the filePath
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 * @return the fileAppend
	 */
	public boolean isFileAppend() {
		return fileAppend;
	}

	/**
	 * @param filePath the filePath to set
	 */
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * @param fileAppend the fileAppend to set
	 */
	public void setFileAppend(boolean fileAppend) {
		this.fileAppend = fileAppend;
	}

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
