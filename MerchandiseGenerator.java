import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * 
 * It converts txt file to Merchandise objects, such as Weapon, Potion...
 *
 */
public class MerchandiseGenerator {
	private Scanner sc;
	private List<Merchandise> weaponList;
	private List<Merchandise> armorList;
	private List<Merchandise> potionList;
	private List<Merchandise> iceSpellList;
	private List<Merchandise> fireSpellList;
	private List<Merchandise> lightningSpellList;
	
	public MerchandiseGenerator(){
		
	}
	
	public void generateMerchandise() throws FileNotFoundException {
		generateWeapon();
		generateArmor();
		generatePotion();
		generateSpell();
	}
	
	public List<Merchandise> generateWeapon() throws FileNotFoundException{
		weaponList = new ArrayList<>();
		List<String> weaponStr = new ArrayList<String>();
		File f = new File("Weaponry.txt");
		//File f = new File("src/Weaponry.txt");
		sc = new Scanner(f);
		sc.useDelimiter("\n");
	    while(sc.hasNext()){  
	    	weaponStr.add(sc.next()); 
	    }
	    for(int i = 1; i<weaponStr.size(); i++) {
	    	String[] elements = weaponStr.get(i).split("\\s+");
	    	String name = elements[0];
	    	int cost = Integer.parseInt(elements[1]);
	    	int minLevel = Integer.parseInt(elements[2]);
	    	int damage =  Integer.parseInt(elements[3]);
	    	int handReq = Integer.parseInt(elements[4]);
	    	Weapon w = new Weapon(name,cost,minLevel,damage,handReq);
	    	weaponList.add(w);
	    }
	    return weaponList;
	}
	
	public List<Merchandise> generateArmor() throws FileNotFoundException{
		armorList = new ArrayList<>();
		List<String> armorStr = new ArrayList<String>();
		File f = new File("Armory.txt");
		//File f = new File("src/Armory.txt");
		sc = new Scanner(f);
		sc.useDelimiter("\n");
	    while(sc.hasNext()){  
	    	armorStr.add(sc.next()); 
	    }
	    for(int i = 1; i<armorStr.size(); i++) {
	    	String[] elements = armorStr.get(i).split("\\s+");
	    	String name = elements[0];
	    	int cost = Integer.parseInt(elements[1]);
	    	int minLevel = Integer.parseInt(elements[2]);
	    	int damageReduction =  Integer.parseInt(elements[3]);
	    	Armor a = new Armor(name,cost,minLevel,damageReduction);
	    	armorList.add(a);
	    }
	    return armorList;
	}
	
	public List<Merchandise> generatePotion() throws FileNotFoundException{
		potionList = new ArrayList<>();
		List<String> potionStr = new ArrayList<String>();
		File f = new File("Potions.txt");
		//File f = new File("src/Potions.txt");
		sc = new Scanner(f);
		sc.useDelimiter("\n");
	    while(sc.hasNext()){  
	    	potionStr.add(sc.next()); 
	    }
	    for(int i = 1; i<potionStr.size(); i++) {
	    	String[] elements = potionStr.get(i).split("\\s+");
	    	String name = elements[0];
	    	int cost = Integer.parseInt(elements[1]);
	    	int minLevel = Integer.parseInt(elements[2]);
	    	int attributeIncrease =  Integer.parseInt(elements[3]);
	    	String attributeAffected = elements[4];
	    	Potion p = new Potion(name,cost,minLevel,attributeIncrease,attributeAffected);
	    	potionList.add(p);
	    }
	    return potionList;
	}
	
	public void generateSpell() throws FileNotFoundException {
		generateIceSpell();
		generateFireSpell();
		generateLightningSpell();
	}
	
	public List<Merchandise> generateIceSpell() throws FileNotFoundException {
		iceSpellList = new ArrayList<>();
		List<String> strIce = new ArrayList<String>();
		File f = new File("IceSpells.txt");
		//File f = new File("src/IceSpells.txt");
		sc = new Scanner(f);
		sc.useDelimiter("\n");
	    while(sc.hasNext()){  
	    	strIce.add(sc.next()); 
	    }
	    for(int i = 1; i<strIce.size(); i++) {
	    	String[] elements = strIce.get(i).split("\\s+");
	    	String name = elements[0];
	    	int cost = Integer.parseInt(elements[1]);
	    	int minLevel = Integer.parseInt(elements[2]);
	    	int damage =  Integer.parseInt(elements[3]);
	    	int manaCost =  Integer.parseInt(elements[4]);
	    	IceSpell ice = new IceSpell(name,cost,minLevel,damage,manaCost);
	    	iceSpellList.add(ice);
	    }
	    return iceSpellList;
	}
	
	public List<Merchandise> generateFireSpell() throws FileNotFoundException {
		fireSpellList = new ArrayList<>();
		List<String> strFire = new ArrayList<String>();
		File f = new File("FireSpells.txt");
		//File f = new File("src/FireSpells.txt");
		sc = new Scanner(f);
		sc.useDelimiter("\n");
	    while(sc.hasNext()){  
	    	strFire.add(sc.next()); 
	    }
	    for(int i = 1; i<strFire.size(); i++) {
	    	String[] elements = strFire.get(i).split("\\s+");
	    	String name = elements[0];
	    	int cost = Integer.parseInt(elements[1]);
	    	int minLevel = Integer.parseInt(elements[2]);
	    	int damage =  Integer.parseInt(elements[3]);
	    	int manaCost =  Integer.parseInt(elements[4]);
	    	FireSpell fire = new FireSpell(name,cost,minLevel,damage,manaCost);
	    	fireSpellList.add(fire);
	    }
	    return fireSpellList;
	}
	
	public List<Merchandise> generateLightningSpell() throws FileNotFoundException {
		lightningSpellList = new ArrayList<>();
		List<String> strL = new ArrayList<String>();
		File f = new File("LightningSpells.txt");
		//File f = new File("src/LightningSpells.txt");
		sc = new Scanner(f);
		sc.useDelimiter("\n");
	    while(sc.hasNext()){  
	    	strL.add(sc.next()); 
	    }
	    for(int i = 1; i<strL.size(); i++) {
	    	String[] elements = strL.get(i).split("\\s+");
	    	String name = elements[0];
	    	int cost = Integer.parseInt(elements[1]);
	    	int minLevel = Integer.parseInt(elements[2]);
	    	int damage =  Integer.parseInt(elements[3]);
	    	int manaCost =  Integer.parseInt(elements[4]);
	    	LightningSpell l = new LightningSpell(name,cost,minLevel,damage,manaCost);
	    	lightningSpellList.add(l);
	    }
	    return lightningSpellList;
	}
}
