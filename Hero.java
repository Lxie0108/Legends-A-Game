import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
/**
 * 
 * Hero class. Hero attributes: please see constructor. Hero also has a wallet class that contains her money
 * and an inventory class that contains the merchandises she gets from Market.
 * Hero can also equip weapons and armors, represented by weaponWearing and armorWearing, cast spell, and use potion from inventory.
 * As a fightable-character, hero can deal damage, receive damage and dodge attack.
 * 
 */
public class Hero extends FightableCharacter {
	protected int mana;
	protected int strength;
	protected int agility;
	protected int dexterity;
	protected int startingMoney;
	protected int startingExp;
	protected int currExp;
	protected int expThreshold;
	protected int damageReduction;
	protected int manaDefault;
	protected boolean isAlive;
	protected Wallet wallet;
	protected Inventory inventory;
	protected List<Weapon> weaponWearing;
	protected List<Armor> armorWearing;
	protected Scanner sc;
	public static final String BLUE = "\u001B[34m";
	public static final String RED = "\u001B[31m";
	public static final String RESET = "\u001B[0m";
	public static final String GREEN = "\u001B[32m";
	
	public Hero(String name, int mana, int strength, int agility, int dexterity, int startingMoney,
			int startingExp) {
		this.name = name;
		this.mana = mana;
		this.strength = strength;
		this.agility = agility;
		this.dexterity = dexterity;
		this.startingMoney = startingMoney;
		this.startingExp = startingExp;
		this.level = 1;
		manaDefault = mana;
		currExp = 0;
		expThreshold = startingExp;
		damageReduction = 0;
		wallet = new Wallet();
		wallet.setMoney(startingMoney);
		inventory = new Inventory();
		weaponWearing = new ArrayList<>();
		armorWearing = new ArrayList<>();
		isAlive = true;
		setHp();
		
	}
	
	public Inventory getInventory() {
		return inventory;
	}
	
	public void levelUp() {
		printLevelUpMessage();
		level += 1;
		setExpThreshold();
		setHp();
		setMana();
		updateSkills();
		favoredSkillsUp();
	}
			
	public void setExpThreshold() {
		expThreshold += (getLevel()*10);
	}
	
	public void setMana() {
		mana = (int) (mana*1.1);
		manaDefault = (int) (mana*1.1);
	}
	
	public void updateMana(int change) {
		if(change+mana>manaDefault) {
			mana = manaDefault;
		} else {
		mana+=change;
		}
	}
	
	public int getMana() {
		return mana;
	}
	
	public int getManaDefault() {
		return manaDefault;
	}
	
	public void updateSkills() {
		updateStrength((int)(strength*0.05));
		updateAgility((int)(agility*0.05));
		updateDexterity((int)(dexterity*0.05));
	}
	
	public void updateDexterity(int change) {
		// TODO Auto-generated method stub
		dexterity += change;
		
	}

	public void updateAgility(int change) {
		// TODO Auto-generated method stub
		agility += change;
	}

	public void updateStrength(int change) {
		// TODO Auto-generated method stub
		strength += change;	
	}

	public void setDamageReduction(int dr) {
		damageReduction = dr;
	}
	
	public void revive() {
		hp = (int)(setHp()*0.5);
	}
	
	public void gainExp(int expGain) {
		currExp += expGain;
		if(currExp>=expThreshold) {
			levelUp();
		}
	}
	
	public Wallet getWallet() {
		return wallet;
	}
	
	public void chooseWearable() {
		inventory.printInventoryHeader();
		inventory.printWeapon();
		inventory.printArmor();
		sc = new Scanner(System.in);
		try {
			System.out.println(BLUE+"Type 1 for equip Weapon, 2 for equip Armor"+RESET);
			int choice = sc.nextInt();
			if(choice == 1) {
				List<Merchandise> weapons = inventory.getWeaponList();
				System.out.println(BLUE+"Which row is this item at?"+RESET);
				int itemRow = sc.nextInt();
				if(itemRow<1||itemRow>weapons.size()) {
					System.out.println("invalid input. ");
				} 
				Merchandise item = weapons.get(itemRow-1);
				if(item instanceof Weapon) {
					Weapon weapon = (Weapon) item;
					wearWeapon(weapon);
				}
			} 
			if(choice == 2) {
				List<Merchandise> armors = inventory.getArmorList();
				System.out.println(BLUE+"Which row is this item at?"+RESET);
				int itemRow = sc.nextInt();
				if(itemRow<1||itemRow>armors.size()) {
					System.out.println("invalid input. ");
				} 
				Merchandise item = armors.get(itemRow-1);
				if(item instanceof Armor) {
					Armor armor = (Armor)item;
					wearArmor(armor);
				}	
			}
		}catch (Exception e) {
			System.out.println("Invalid input");
		}
	}
	
	public void wearArmor(Armor item) {
		if(!armorWearing.isEmpty()) {
			armorWearing.clear();
		}
		armorWearing.add(item);
		setDamageReduction(item.getDamageReduction());
		System.out.println(RED+this.name+" just equipped "+item.getName()+RESET);
	}
	
	public void wearWeapon(Weapon item) {
		if(!weaponWearing.isEmpty()) {
			weaponWearing.clear();
		}
		weaponWearing.add(item);
		System.out.println(RED+name+" just equipped "+item.getName()+RESET);
	}
	
	public void choosePotion() {
		inventory.printInventoryHeader();
		inventory.printPotion();
		sc = new Scanner(System.in);
		try {
			System.out.println(BLUE+"Which row is this item at?"+RESET);
			int itemRow = sc.nextInt();
			List<Merchandise> potions = inventory.getPotionList();
			if(itemRow<1||itemRow>potions.size()) {
				System.out.println("invalid input. ");
			} 
			Merchandise item = potions.get(itemRow-1);
			if(item instanceof Potion) {
				Potion potion = (Potion) item;
				usePotion(potion);
			}	
		} catch (Exception e) {
			System.out.println("Invalid input");
		}
	}
	
	public void usePotion(Potion potion) {//All possible AttributeAffected: Health/Mana/Strength/Dexterity/Defense/Agility
		int attributeIncrease = potion.getAttributeIncrease();
		for(String attributeAffected: potion.getAttributeAffectedList()) {
			if(attributeAffected.equals("Health")) {
				updateHp(attributeIncrease);
			}
			if(attributeAffected.equals("Mana")) {
				updateMana(attributeIncrease);
			}
			if(attributeAffected.equals("Strength")) {
				strength += attributeIncrease;
			}
			if(attributeAffected.equals("Dexterity")) {
				dexterity += attributeIncrease;
			}
			if(attributeAffected.equals("Defense")) {
				damageReduction += attributeIncrease;
			}
			if(attributeAffected.equals("Agility")) {
				agility += attributeIncrease;
			}	
		}
		System.out.println(RED+name+", just consumed "+potion.getName()+RESET);
		inventory.getPotionList().remove(potion);
	}
	
	public Spell chooseSpell() {
		sc = new Scanner(System.in);
		Spell spell = null;
		try {
			inventory.printInventoryHeader();
			inventory.printIceSpell();
			inventory.printFireSpell();
			inventory.printLightningSpell();
			System.out.println(BLUE+"Choose your spell type. Type 1 for IceSpell, 2 for FireSpell, 3 for LightningSpell"+RESET);
			int spellType = sc.nextInt();
			if(spellType == 1) {
				spell = getSpell(inventory.getIceSpellList());
			}
			if(spellType == 2) {
				spell = getSpell(inventory.getFireSpellList());
			}
			if(spellType == 3) {
				spell = getSpell(inventory.getLightningSpellList());
			}
			if(spellType !=1 && spellType !=2 && spellType != 3) {
				System.out.println("Invalid input");
			}
		} catch(Exception e) {
			System.out.println("Invalid input");
		}
		return spell;
	}
	
	public Spell getSpell(List<Merchandise> spellList) {
		sc = new Scanner(System.in);
		try {
			System.out.println(BLUE+"Which row is this spell at? "+RESET);
			int itemRow = sc.nextInt();
			if(itemRow<1||itemRow>spellList.size()) {
				System.out.println("Invalid input");
			}
			Merchandise m = spellList.get(itemRow-1);
			if(m instanceof Spell) {
				Spell spell = (Spell)m;	
				return spell;
			}
		} catch(Exception e) {
			System.out.println("Invalid input");
		}
		return null;
	}
	
	public void printHeroInfoDefault() {
		System.out.printf("%20s %10d %10d %10d %10d %10d %10d%n",name,mana,strength,agility,dexterity,startingMoney,startingExp);		
	}
	
	public void printHeroInfo() {
		System.out.printf("%20s %10d %10d %10d %10d %10d %10d %10d %10d%n",name,getHp(),level,mana,strength,agility,dexterity,currExp,wallet.getMoney());		
	}
	
	public void printNameAndWallet() {
		System.out.printf("%20s %10s%n","Name", "Money");
		System.out.println("------------------------------------");
		System.out.printf("%20s %10d%n",name,wallet.getMoney());
	}
	
	public void printHeroInfoInFight() {
		System.out.printf("%20s %10d %10d %10d %20s %20s%n",name,getHp(),level,mana, weaponWearingToString(), armorWearingToString());		
	}
	
	public void printLevelUpMessage() {
		TextArt textArt = new TextArt();
		textArt.printLevelUP();
		System.out.println(RED+name+" just LEVEL UP !"+RESET);
	}
	public List<Weapon> getWeaponWearing(){
		return weaponWearing;
	}
	
	public List<Armor> getArmorWearing(){
		return armorWearing;
	}
	
	public int getDexterity() {
		return dexterity;
	}
	
	public String weaponWearingToString() {
		if(weaponWearing.isEmpty()) {
			return " ";
		}
		StringBuilder str = new StringBuilder(" ");
		for(Weapon w: weaponWearing) {
			str.append(w.getName());
		}
		return str.toString();		
	}
	
	public String armorWearingToString() {
		if(armorWearing.isEmpty()) {
			return " ";
		}
		StringBuilder str = new StringBuilder(" ");
		for(Armor a: armorWearing) {
			str.append(a.getName());
			str.append(" ");
		}
		return str.toString();		
	}
	
	public void favoredSkillsUp() {
		
	}

	@Override
	public boolean isFighting() {
		// TODO Auto-generated method stub
		return isFighting;
	}
	
	@Override
	public int getDamageDone() {
		// TODO Auto-generated method stub
		int weaponDamage = 0;
		for(Weapon w: weaponWearing) {
			weaponDamage += w.getDamage();
		}
		if(weaponWearing.isEmpty()) {//no weapon.
			return strength;
		}
		return  strength + (int) ((strength + weaponDamage)*0.05);
	}

	@Override
	public int getDefense() {
		// TODO Auto-generated method stub
		return damageReduction;
	}

	@Override
	public boolean hasDodged() {
		// TODO Auto-generated method stub
		int dodgeChance = (int) (agility*0.1);
		Random rand = new Random();
		int r = rand.nextInt(100);
		if(r<=dodgeChance) {
			return true;
		} else {
			return false;
		}
	}
}
