package rpg.core.characters.shared;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import rpg.core.characters.enemies.Enemy;
import rpg.core.characters.enemies.EnemySubType;
import rpg.core.spells.TemporaryEffectType;
import rpg.core.utils.CalcHelper;

public class StatWrapper {
	private List<Stat> stats = new ArrayList<>();

	public StatWrapper() {
	}

	public StatWrapper(List<Stat> stats) {
		this.stats = stats;
	}

	public StatWrapper(Stat... stats) {
		this.stats.addAll(Arrays.asList(stats));
	}

	public List<Stat> getStats() {
		return stats;
	}

	public void setStats(List<Stat> stats) {
		this.stats = stats;
	}

	public void addStats(Stat... stats) {
		this.stats.addAll(Arrays.asList(stats));
	}

	private boolean statExist(StatEnum type) {
		return stats.stream().anyMatch(e -> e.getType() == type);
	}

	public Stat getStatbyName(StatEnum type) {
		if (statExist(type)) {
			return stats.stream().filter(e -> e.getType() == type).findFirst().get();
		}
		return null;
	}

	public void updateStats(StatWrapper affectedtats) {
		affectedtats.stats.forEach(e -> updateStats(e));
	}

	public void updateStats(Stat stat) {
		if (statExist(stat.type)) {
			if (stat.statStrategy == StatAffectStrategy.SUMMING_UP) {
				updateStatsSum(stat);
			} else {
				updateStatsMultiply(stat);
			}
		}
	}

	private void updateStatsSum(Stat stat) {
		Stat curStat = getStatbyName(stat.type);
		int curValue = curStat.getCurValue();
		if (stat.affectsMaxValue) {
			curStat.setMaxValue(curStat.getMaxValue() + stat.getCurValue());
		}
		curStat.setValue(curValue + stat.getCurValue());

	}

	private void updateStatsMultiply(Stat stat) {
		Stat curStat = getStatbyName(stat.type);
		int curValue = curStat.getCurValue();
		int percent = curValue * stat.getCurValue() / 100;
		if (stat.affectsMaxValue) {
			curStat.setMaxValue(curStat.getMaxValue() + percent);
		}
		curStat.setValue(curValue + percent);
	}

	public static StatWrapper reverseStats(StatWrapper stat) {
		StatWrapper s = new StatWrapper();
		Stat curStat;
		for (Stat c : stat.getStats()) {
			if (c.getCurValue() < 0) {
				curStat = new Stat(c.getType(), Math.abs(c.getCurValue()));
			} else {
				curStat = new Stat(c.getType(), -c.getCurValue());
			}
			s.addStats(curStat);
		}
		return s;
	}

	public boolean isCharDead() {
		return getStatbyName(StatEnum.HEALTH).getCurValue() <= 0 && isDeathBlown() ? true : false;
	}

	private boolean isDeathBlown() {
		int chance = CalcHelper.randInt(101);
		int deathBlowChance = getStatbyName(StatEnum.DEATH_RES).getCurValue();
		return chance > deathBlowChance ? true : false;
	}

	public int getProperResistValue(TemporaryEffectType eType) {
		switch (eType) {
		case STUN:
			return getStatbyName(StatEnum.STUN_RES).getCurValue();
		case BLEED:
			return getStatbyName(StatEnum.BLEED_RES).getCurValue();
		case BLIGHT:
			return getStatbyName(StatEnum.BLIGHT_RES).getCurValue();
		case DEBUFF:
			return getStatbyName(StatEnum.DEBUFF_RES).getCurValue();
		case CURSE:
			return getStatbyName(StatEnum.CURSE_RES).getCurValue();
		case DISEASE:
			return getStatbyName(StatEnum.DISEASE_RES).getCurValue();
		case MARK:
		case BUFF:
			return 0;
		default:
			return -1;
		}
	}

	public int getProperSpecificDamageMod(Enemy enemy) {
		int damageMod = 0;
		for (EnemySubType type : enemy.getSubTypes()) {
			switch (type) {
			case BEHEMOTH:
				damageMod+= getStatbyName(StatEnum.BEHEMOTH_DMG_MOD).getCurValue();
				break;
			case DARKIN:
				damageMod+= getStatbyName(StatEnum.DARKIN_DMG_MOD).getCurValue();
				break;
			case DRAGON:
				damageMod+= getStatbyName(StatEnum.DRAGON_DMG_MOD).getCurValue();
				break;
			case HUMAN:
				damageMod+= getStatbyName(StatEnum.HUMAN_DMG_MOD).getCurValue();
				break;
			case VOIDBORN:
				damageMod+= getStatbyName(StatEnum.VOIDBORN_DMG_MOD).getCurValue();
				break;				
			}
		}
		return damageMod;
	}

	public int getProperMultiplierValue(TemporaryEffectType eType) {
		switch (eType) {
		case STUN:
			return getStatbyName(StatEnum.STUN_CHANCE).getCurValue();
		case BLEED:
			return getStatbyName(StatEnum.BLEED_CHANCE).getCurValue();
		case BLIGHT:
			return getStatbyName(StatEnum.BLIGHT_CHANCE).getCurValue();
		case DEBUFF:
			return getStatbyName(StatEnum.DEBUFF_CHANCE).getCurValue();
		case CURSE:
			return getStatbyName(StatEnum.CURSE_CHANCE).getCurValue();
		case DISEASE:
			return getStatbyName(StatEnum.DISEASE_CHANCE).getCurValue();
		case MARK:
		case BUFF:
			return 0;
		default:
			return -1;
		}
	}
}
