package rpg.core.dungeon;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import rpg.core.spawn.events.SpawnableEventType;

public class Corridor {
	Room begin;
	Room end;
	List<CorridorSection> sections;

	public Corridor(Room r1, Room r2) {
		this(r1, r2, 5);
	}

	public Corridor(Room r1, Room r2, int sectionCap) {
		sections = new ArrayList<>();
		for (int i = 0; i < sectionCap; i++) {
			sections.add(new CorridorSection());
		}
		setSections();
		this.begin = r1;
		this.end = r2;
	}

	private void setSections() {
		for (int i = 0; i < sections.size(); i++) {
			if (i + 1 < sections.size()) {
				sections.get(i).setNeighbour(sections.get(i + 1));
			}
			if (i - 1 >= 0) {
				sections.get(i).setNeighbour(sections.get(i - 1));
			}
		}
	}

	public List<CorridorSection> getSections() {
		return sections;
	}

	public void displaySections() {
		for (CorridorSection section : sections) {
			section.display();
			section.displayNeighbours();
		}
	}

	public void display() {
		System.out.println("Corridor " + this.hashCode() + " unites ");
		begin.display();
		end.display();
	}

	public boolean isSameCorridor(Corridor corridor) {
		if ((begin == corridor.begin && end == corridor.end) || (begin == corridor.end && end == corridor.begin)) {
			return true;
		}
		return false;
	}	

	public List<Enterable> getEnterables() {
		return new ArrayList<Enterable>() {
			{
				add(begin);
				addAll(sections);
				add(end);
			}
		};
	}
	
	public int getFightAmount(){
		int count = 0;
		count+=countFights(begin);
		count+=countFights(end);
		for (CorridorSection corridorSection : sections) {
			count+=countFights(corridorSection);
		}
		return count;
	}
	
	private int countFights(Enterable enterable){
		return (int) enterable.getEvents().stream().filter(e->e.getSpawnType()==SpawnableEventType.FIGHT).count();
	}
}