package classes;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @author Alexander J. Cintron Baez
 * @email alexander.cintron1@upr.edu
 * @studentID 802-15-1388 | UPRM
 * @class ArrestOperation: Object that is assigned to be a case. This class reads the log file and creates a new PyramidScheme.
 */
public class ArrestOperation {
	
	private int MAX_ARRESTS;
	private InputHandler logReader;
	private String LOGFILE;
	private PyramidScheme PYRAMID;
	
	/**
	 * Constructor for ArrestOperation.
	 * @param numArrests Maximum number of arrests that can be made.
	 * @param logfile name of the log file containing the members.
	 * @return construct new ArrestOperation.
	 * @throws FileNotFoundException 
	 */
	public ArrestOperation(int numArrests, String logfile) throws FileNotFoundException {
		MAX_ARRESTS = numArrests;
		LOGFILE = logfile;
		PYRAMID = readLogFile();
	}
	
	/**
	 * The writeResults method calls the arrest method from PyramidScheme to generate the lists of
	 * members to be arrested and print them in the output file.
	 * @param w PrintWriter for the output file.
	 * @return void
	 */
	public void writeResults(PrintWriter w) {
		ArrayList<Jail> jails = PYRAMID.arrest(MAX_ARRESTS);
		w.printf("Maximum seized assets: "+PYRAMID.getMaxAssets());
		int listCount = 0;
		for(Jail j : jails) {
			listCount++;
			w.println();
			w.printf("List "+listCount+": ");
			for(int i = 0; i<j.getArrestedList().size(); i++) {
				w.printf(j.getArrestedList().get(i).getName());
				if(i < j.getArrestedList().size()-1)
					w.printf(", ");
			}
		}
	}
	
	/**
	 * The readLogFile methods creates a new InputHandler with the logfile name as a parameter and a new PyramidScheme.
	 * Extracts members' information from the log and creates a new Member for each line and add them to the PyramidScheme
	 * @return PyramidScheme 
	 * @throws FileNotFoundException 
	 * @throws ArrayIndexOutOfBoundsException
	 */
	private PyramidScheme readLogFile() throws FileNotFoundException {
		logReader = new InputHandler(LOGFILE);
		PyramidScheme p = new PyramidScheme();
		if(logReader.hasNextLine()) {
			String[] boss = logReader.readInput().split("#");
			p.addMember(new Member(boss[0], Integer.parseInt(boss[1])), null);
		}
		while(logReader.hasNextLine()) {
			String[] m = logReader.readInput().split("#");
			p.addMember(new Member(m[0], Integer.parseInt(m[1])), m[2]);
		}
		logReader.close();
		return p;
	}
	
	/**
	 * The clear method clears the instanced case to help the garbage collector work more efficiently.
	 * @return void
	 */
	public void clear() {
		LOGFILE = null;
		logReader.clear();
		logReader = null;
		PYRAMID.clear();
	}
	
}
