package classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Alexander J. Cintron Baez
 * @email alexander.cintron1@upr.edu
 * @studentID 802-15-1388 | UPRM
 * @class InputHandler: reads files and extracts data by line.
 */
public class InputHandler {

	private Scanner s;
	
	/**
	 * Constructor for InputHandler
	 * @param filename Name of the file to be opened.
	 * @throws FileNotFoundException 
	 */
	public InputHandler(String filename) throws FileNotFoundException {
		try {
			s = new Scanner(new File(filename));
		} catch (FileNotFoundException e) {
			throw new FileNotFoundException();
		}
	}
	
	/**
	 * The readInput method reads the next line in a file, if any.
	 * @return String containing the line.
	 */
	public String readInput() {
		return s.nextLine();
	}
	
	/**
	 * The hasNextLine method
	 * Allows other classes, that require reading input, to know if there is a nextLine to read.
	 * @return true if there is a nextLine in the file; false otherwise.
	 */
	public boolean hasNextLine() {
		return s.hasNextLine();
	}
	
	/**
	 * The close method
	 * Closes the current file.
	 * @return void
	 */
	public void close() {
		s.close();
	}
	
	/**
	 * The clear method clears the instanced Member to help the garbage collector work more efficiently.
	 * @return void
	 */
	public void clear() {
		s = null;
	}
}
