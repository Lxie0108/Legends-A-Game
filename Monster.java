import java.util.Random;
/**
 * 
 * Monster class. Monster attributes: please see constructor. 
 * As a fightable-character, monster can deal damage, receive damage and dodge attack.
 * 
 */
public class Monster extends FightableCharacter{
	protected int damage;
	protected int damageDefault;
	protected int defense;
	protected int defenseDefault;
	protected int dodgeChance;
	protected int dodgeChanceDefault;
	
	public Monster(String name, int level, int damage, int defense, int dodgeChance) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.level = level;
		this.damage = damage;
		this.defense = defense;
		this.dodgeChance = dodgeChance;
		damageDefault = damage;
		defenseDefault = defense;
		dodgeChanceDefault = dodgeChance;
		setHp();
	}
	
	public void reset() {
		setHp();
		damage = damageDefault;
		defense = defenseDefault;
		dodgeChance = dodgeChanceDefault;
		
	}
	
	public void printMonsterInfo(){
		System.out.printf("%20s %10d %10d %10d %10d %10d%n",name,getHp(),level,damage,defense,dodgeChance);		
	}

	public void setDamage(int change) {
		damage += change;
	}
	
	public void setDefense(int change) {
		defense += change;
	}
	
	public void setDodgeChance(int change) {
		dodgeChance += change;
	}
	
	public int getDodgeChance() {
		return dodgeChance;
	}
	
	@Override
	public boolean isFighting() {
		// TODO Auto-generated method stub
		return isFighting;
	}

	@Override
	public int getDamageDone() {
		// TODO Auto-generated method stub
		return damage;
	}

	@Override
	public int getDefense() {
		// TODO Auto-generated method stub
		return defense;
	}
	
	@Override
	public boolean hasDodged() {
		// TODO Auto-generated method stub
		Random rand = new Random();
		int r = rand.nextInt(100);
		if(r<=dodgeChance) {
			return true;
		} else {
			return false;
		}
	}

}
