/**
 * 
 * FightableCharcter: character that is able to fight another.
 * Both monsters and heroes extend to this class. 
 *
 */
public abstract class FightableCharacter {
	protected String name;
	protected int level;
	protected int hp;
	protected int hpDefault;//max hp given level
	protected boolean isFighting;
	
	public int getLevel() {
		return level;
	}
	
	public int getHp() {
		if(hp <= 0) {
			return 0;
		}
		return hp;
	}
	
	public int getHpDefault() {
		return hpDefault;
	}
	
	public String getName() {
		return name;
	}
	
	public int setHp() {
		hp = level*100;
		hpDefault = level*100;
		return hp;
	}
	
	public void updateHp(int change) {
		if(hp+change>hpDefault) {
			hp = hpDefault;
		} else {
		hp += change;
		}
	}
	public boolean isAlive() {
		if(hp <= 0) {
			return false;
		}
		return true;
	}

	public abstract int getDamageDone();
	public abstract int getDefense();
	public abstract boolean hasDodged();
	public abstract boolean isFighting();
}
