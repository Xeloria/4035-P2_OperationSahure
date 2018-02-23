package classes;

import java.util.ArrayList;

/**
 * @author Alexander J. Cintron Baez
 * @email alexander.cintron1@upr.edu
 * @studentID 802-15-1388 | UPRM
 * @class Member: Member object that will represent each Member generated from the log files.
 */
public class Member {

	private String NAME;
	private int ASSETS;
	private Member SPONSOR, MENTOR;
	private ArrayList<Member> CHILDREN;
	
	/**
	 * Constructor for Member.
	 * @param name Name of the Member.
	 * @param assets Assets belonging to the Member.
	 */
	public Member(String name, int assets) {
		NAME = name;
		ASSETS = assets;
		CHILDREN = new ArrayList<Member>();
	}

	/**
	 * The getSponsor method.
	 * Gets Member's SPONSOR.
	 * @return SPONSOR reference to another Member
	 */
	public Member getSponsor() {
		return SPONSOR;
	}

	/**
	 * The setSponsor method 
	 * Sets Member's SPONSOR
	 * @param sponsor reference to Member that is the sponsor
	 */
	public void setSponsor(Member sponsor) {
		SPONSOR = sponsor;
	}

	/**
	 * The getMentor method.
	 * Gets Member's MENTOR.
	 * @return MENTOR reference to another Member
	 */
	public Member getMentor() {
		return MENTOR;
	}

	/**
	 * The setMentor method 
	 * Sets Member's MENTOR
	 * @param mentor reference to Member that is the mentor
	 */
	public void setMentor(Member mentor) {
		MENTOR = mentor;
	}

	/**
	 * The getAssets method
	 * Gets Members assets
	 * @return ASSETS Member's assets value
	 */
	public int getAssets() {
		return ASSETS;
	}
	
	/**
	 * The getName method
	 * Gets Members name
	 * @return NAME Member's name
	 */
	public String getName() {
		return NAME;
	}

	/**
	 * The getChildren method
	 * Gets ArrayList of Members sponsored by the instanced Member
	 * @return CHILDREN Members sponsored by the instanced Member.
	 */
	public ArrayList<Member> getChildren() {
		return CHILDREN;
	}
	
	/**
	 * The addChildren method
	 * Adds a Member sposored by the instanced Member.
	 * @param m Member sponsored by instanced Member.
	 */
	public void addChildren(Member m) {
		CHILDREN.add(m);
	}

	/**
	 * The clear method clears the instanced Member to help the garbage collector work more efficiently.
	 * @return void
	 */
	public void clear() {
		CHILDREN.clear();
		NAME = null;
		MENTOR = null;
		SPONSOR = null;
		try {
			this.finalize();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	
	
}
