package classes;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * @author Alexander J. Cintron Baez
 * @email alexander.cintron1@upr.edu
 * @studentID 802-15-1388 | UPRM
 * @class PuertoRicoPD: Main class. Contains main method. Handles input.txt and runs all cases within it.
 */
public class PuertoRicoPD {
	
	private static InputHandler caseReader;
	private static ArrestOperation SAHURE;
	private static String currentFile;
	private static PrintWriter w;
	private static String inputFile = "input.txt";
	private static String dir = System.getProperty("user.dir");
	
	/**
	 * Main method
	 * The main method creates a new case and handles the PrintWriter.
	 * Also handles any kind of exception that may occur while processing a case.
	 * Contains the main loop.
	 * @param args Unused
	 * @return void
	 */
	public static void main(String[] args) {
		long exeTime = System.currentTimeMillis();
		try {
			caseReader = new InputHandler(inputFile);
			int caseCount = 0;
			
			while(caseReader.hasNextLine()) {
				caseCount++;
				long timeBefore = System.currentTimeMillis();
				try {
					w = new PrintWriter("output"+caseCount+".txt");
					SAHURE = readNewCase();
					SAHURE.writeResults(w);
					SAHURE.clear();
					w.close();
				}catch(NumberFormatException e) {
					w.printf("******************************************************\n"
							+"Unable to process file \""+currentFile+"\""
							+"\nPlease make sure the input files follow the required "
							+"\ninput format in order to process the files properly."
							+"\n******************************************************");
					System.out.println("******************************************************\n"
										+"Unable to process file \""+currentFile+"\""
										+"\nPlease make sure the input files follow the required "
										+"\ninput format in order to process the files properly."
										+"\n******************************************************");
					w.close();
				}catch(ArrayIndexOutOfBoundsException e) {
					w.println("******************************************************");
					w.println("Unable to process file \""+currentFile+"\"");
					w.println("Please make sure the input files follow the required ");
					w.println("input format in order to process the files properly.");
					w.println("******************************************************");
					
					System.out.println("******************************************************\n"
										+"Unable to process file \""+currentFile+"\""
										+"\nPlease make sure the input files follow the required "
										+"\ninput format in order to process the files properly."
										+"\n******************************************************");
					w.close();
				}catch(FileNotFoundException e) {
					w.println("****************************************************************");
					w.println("Something went wrong while trying to open file \""+currentFile+"\"");
					w.println("Please check that \""+currentFile+"\" exists and is properly");
					w.println("located in the directory specified in: \""+inputFile+"\"");
					w.println("****************************************************************");
					
					
					System.out.println("******************************************************\n"
							+"Something went wrong while trying to open file \""+currentFile+"\""
							+"\nPlease check that \""+currentFile+"\" exists and is properly"
							+"\nlocated in the directory specified in: \""+dir+"\""
							+"\n******************************************************");
					
					w.close();
				}
				System.out.println("Time of execution for file \""+currentFile+"\" was "+(System.currentTimeMillis()-timeBefore)+" ms");
			}
			caseReader.close();
			caseReader.clear();
			caseReader = null;
			System.out.println("Total time of execution was "+(System.currentTimeMillis()-exeTime)+" ms");
		}catch(FileNotFoundException e) {
			System.out.println("******************************************************\n"
					+"Something went wrong while trying to open file \""+inputFile+"\""
					+"\nPlease check that \""+inputFile+"\" exists and is properly"
					+"\nlocated in the project's directory: \""+dir+"\""
					+"\n******************************************************");
		}
	}
	
	/**
	 * The readNewCase method extracts the next line from input.txt and creates a new ArrestOperation.
	 *@return ArrestOperation
	 * @throws FileNotFoundException 
	 * @throws NumberFormatException 
	 */
	private static ArrestOperation readNewCase() throws NumberFormatException, FileNotFoundException {
		String[] newCase = caseReader.readInput().split(" ");
		currentFile = newCase[1];
		return new ArrestOperation(Integer.parseInt(newCase[0]), newCase[1]);
	}
	
}
