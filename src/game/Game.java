package game;

import java.util.ArrayList;

import ddripoffmodel.Hero;
import ddripoffmodel.Stat;
import ddripoffmodel.Trinket;

public class Game {

	public static void main(String[] args){
		Hero hero1 = new Hero("Hero1");
		printHeroInfo(hero1);
		Trinket item1 = new Trinket("Item1",new ArrayList<Stat>(){{
			add(new Stat("Health",5));
			add(new Stat("Armor",1));
		}});
		hero1.equip(item1);
		printHeroInfo(hero1);
	}
	
	private static void printHeroInfo(Hero hero){
		System.out.println(hero.getStatWrapper().getValueByName("Health"));
		System.out.println(hero.getStatWrapper().getValueByName("Armor"));
		System.out.println(hero.getStatWrapper().getValueByName("Damage"));
		
	}
}
