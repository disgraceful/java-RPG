package com.disgrace.ddripoff.characters.shared;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Party {

	private List<Character> partyMembers = new ArrayList<>();

	public Party(List<Character> members) {
		partyMembers = members;
	}

	public Party() {// NOSONAR
	}

	public List<Character> getMembers() {
		return partyMembers;
	}

	public Character getMemberByPos(int pos) {
		return partyMembers.get(pos);
	}

	public void addMember(Character c) {
		if (isPartyFull()) {
			System.err.println("Only 4 members in party");
			return;
		}
		partyMembers.add(c);
		c.setParty(this);
	}

	public void addMember(Character c, int position) {
		if (isPartyFull()) {
			System.err.println("Only 4 members in party");
			return;
		}
		if (position > 3) {
			addMember(c, 3);
		} else if (position < 0) {
			addMember(c, 0);
		} else {
			partyMembers.add(position, c);
		}
		c.setParty(this);
	}

	private boolean ifCharExists(Character c) {
		return partyMembers.contains(c);
	}

	public int getPosition(Character c) {
		return partyMembers.indexOf(c);
	}

	public void reposition(Character c, int newposition) {
		if (ifCharExists(c)) {
			removeMember(c);
			addMember(c, newposition);
			System.out.println(c.getName() + " was repsoition to " + newposition);
		}
	}

	public boolean isPartyDead() {
		for (Character character : partyMembers) {
			if (!character.isCharDead()) {
				return false;
			}
		}
		return true;
	}

	public boolean isPartyEmpty() {
		return partyMembers.isEmpty() ? true : false;
	}

	public void removeMember(Character c) {
		partyMembers.remove(c);
	}

	private boolean isPartyFull() {
		return partyMembers.size() >= 4 ? true : false;
	}

	public boolean isCharAlone() {
		return partyMembers.size() == 1;
	}

	public List<Integer> getAvaliableMovements(Character c) {
		if (!ifCharExists(c) && isCharAlone()) {
			return Collections.emptyList();
		}
		int currentPos = getPosition(c);
		List<Integer> avaliablePos = new ArrayList<>();
		int backPos = currentPos + 1;
		if (backPos < 3 || currentPos != 3) {
			avaliablePos.add(backPos);
		}
		int forwardPos = currentPos - 1;
		if (forwardPos > 0 || currentPos != 0) {
			avaliablePos.add(forwardPos);
		}

		System.out.println(c.getName());
		System.out.println("current Pos: " + currentPos);
		System.out.println("back Pos: " + backPos);
		System.out.println("forward Pos: " + forwardPos);
		System.out.println("avaliabe positions: " + avaliablePos.size());
		avaliablePos.forEach(e -> System.out.println(e));

		return avaliablePos;
	}

	@Override
	public String toString() {
		return "Party members: " + partyMembers;
	}
}
