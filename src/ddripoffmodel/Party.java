package ddripoffmodel;

import java.util.ArrayList;


public class Party {
	private ArrayList<Character> partyMembers = new ArrayList<Character>();

	public Party(ArrayList<Character> members) {
		partyMembers = members;
	}

	public Party() {
	}

	public ArrayList<Character> getMembers() {
		return partyMembers;
	}

	public void addMember(Character c) {
		partyMembers.add(c);
		c.setParty(this);
	}

	public void addMember(Character c,int position){
		partyMembers.add(position,c);
		c.setParty(this);
	}
	
	private boolean ifCharExists(Character c) {
		return partyMembers.contains(c);
	}
	
	public int getPosition(Character c){
		
		return partyMembers.indexOf(c);
	}
	public void reposition(Character c, int newposition) {
		if (ifCharExists(c)) {
			if (partyMembers.size() >= 1&&newposition <= partyMembers.size()) {
				partyMembers.remove(partyMembers.get(partyMembers.indexOf(c)));
				addMember(c, newposition);
			} else {
				addMember(c);
			}
		}
	}
}
