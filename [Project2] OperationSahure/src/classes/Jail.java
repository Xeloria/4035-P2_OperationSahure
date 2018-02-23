package classes;

import java.util.ArrayList;

/**
 * @author Alexander J. Cintron Baez
 * @email alexander.cintron1@upr.edu
 * @studentID 802-15-1388 | UPRM
 * @class InputHandler: reads files and extracts data by line.
 */
public class Jail {

	ArrayList<Member> arrested;
	int SEIZED_ASSETS;
	
	/**
	 * Main constructor for Jail
	 */
	public Jail() {
		arrested = new ArrayList<Member>();
		SEIZED_ASSETS = 0;
	}
	
	/**
	 * Secondary constructor for Jail
	 * Used only to generate copies of an instanced Jail.
	 * @param arrested Cloned ArrayList from the copied Jail.
	 * @param assets Assets value from the copied Jail.
	 */
	public Jail(ArrayList<Member> arrested, int assets) {
		this.arrested = arrested;
		SEIZED_ASSETS = assets;
	}
	
	/**
	 * The copyJail method
	 * Copies an instaced Jail and constructs a new Jail.
	 * @return Jail new copy of an instanced Jail.
	 */
	@SuppressWarnings("unchecked")
	public Jail copyJail() {
		return new Jail((ArrayList<Member>) this.arrested.clone(), this.SEIZED_ASSETS);
	}
	
	/**
	 * The arrestMember method
	 * Adds a Member to the arrested ArrayList.
	 * @param m Member to be arrested.
	 */
	public void arrestMember(Member m) {
		arrested.add(m);
		SEIZED_ASSETS += m.getAssets();
	}
	
	/**
	 * The releaseMember method
	 * Removes a Member from the arrested ArrayList.
	 * @param m Member to be removed.
	 */
	public void releaseMember(Member m) {
		arrested.remove(m);
		SEIZED_ASSETS -= m.getAssets();
	}
	
	/**
	 * The getSeizedAssets method
	 * Gets Jail's summed assets
	 * @return SEIZED_ASSETS sum of all arrested Member's assets.
	 */
	public int getSeizedAssets() {
		return SEIZED_ASSETS;
	}
	
	/**
	 * The getArrestedList method
	 * Gets ArrayList of Members arrested in the instanced Jail.
	 * @return arrested ArrayList of Members arrested in the instanced Jail
	 */
	public ArrayList<Member> getArrestedList(){
		return arrested;
	}
	
	/**
	 * The clear method clears the instanced Jail to help the garbage collector work more efficiently.
	 * @return void
	 */
	public void clear() {
		arrested.clear();
		try {
			this.finalize();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}