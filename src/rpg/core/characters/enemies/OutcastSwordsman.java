package rpg.core.characters.enemies;

import java.util.ArrayList;

import rpg.core.characters.shared.Stat;
import rpg.core.characters.shared.StatEnum;
import rpg.core.characters.shared.StatWrapper;

public class OutcastSwordsman extends Enemy  {

	public OutcastSwordsman() {
		name = "Outcast Swordsman";
		eClass = EnemyClass.OUTCAST_SWORDSMAN;
		subTypes = new ArrayList<EnemySubType>() {
			{
				add(EnemySubType.HUMAN);
			}
		};
		this.stats = new StatWrapper(new ArrayList<Stat>() {
			{
add(new Stat(StatEnum.HEALTH, 30, 30));
				
				add(new Stat(StatEnum.DODGE, 4, 50));
				add(new Stat(StatEnum.PROT, 5, 999));
				add(new Stat(StatEnum.SPEED, 4, 99));
				
				add(new Stat(StatEnum.MOVE_RES, 50, 220));
				add(new Stat(StatEnum.BLEED_RES, 40, 220));
				add(new Stat(StatEnum.BLIGHT_RES, 30, 220));
				add(new Stat(StatEnum.DEBUFF_RES, 30, 220));
				add(new Stat(StatEnum.STUN_RES, 50, 220));
				
				add(new Stat(StatEnum.MOVE_CHANCE, 0, 220));
				add(new Stat(StatEnum.BLIGHT_CHANCE, 0, 220));
				add(new Stat(StatEnum.BLEED_CHANCE, 0, 220));
				add(new Stat(StatEnum.STUN_CHANCE, 0, 220));
				add(new Stat(StatEnum.DEBUFF_CHANCE, 0, 220));
				
				add(new Stat(StatEnum.BEHEMOTH_DMG_MOD, 0, 220));
				add(new Stat(StatEnum.DARKIN_DMG_MOD, 0, 220));
				add(new Stat(StatEnum.DRAGON_DMG_MOD, 0, 220));
				add(new Stat(StatEnum.HUMAN_DMG_MOD, 0, 220));
				add(new Stat(StatEnum.VOIDBORN_DMG_MOD, 0, 220));

			}
		});
		
	}

	
}
