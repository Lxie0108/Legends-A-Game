/**
 * 
 * A type of hero. favored on strength and agility.
 * Favored means that their starting stats on those sectors will be increased and that every time they level up those statistics will be furtherly boosted. 
 */
public class Warrior extends Hero {

	public Warrior(String name, int mana, int strength, int agility, int dexterity, int startingMoney,
			int startingExp) {
		// TODO Auto-generated constructor stub
		super(name,mana,strength,agility,dexterity,startingMoney,startingExp);
	}
	
	@Override
	public void favoredSkillsUp() {
		updateStrength((int)(strength*0.05));
		updateAgility((int)(agility*0.05));
	}
}
