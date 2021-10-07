import java.util.ArrayList;
import java.util.List;
/**
 * 
 * Hero's inventory. It contains all the merchandise hero gets from Market.
 *
 */
public class Inventory {
	private List<Merchandise> weaponList;
	private List<Merchandise> armorList;
	private List<Merchandise> potionList;
	private List<Merchandise> fireSpellList;
	private List<Merchandise> iceSpellList;
	private List<Merchandise> lightningSpellList;
	
	
	public Inventory() {
		weaponList = new ArrayList<>();
		armorList = new ArrayList<>();
		potionList = new ArrayList<>();
		fireSpellList = new ArrayList<>();
		iceSpellList = new ArrayList<>();
		lightningSpellList = new ArrayList<>();
	}
	
	public List<Merchandise> getWeaponList(){
		return weaponList;
	}
	
	public List<Merchandise> getArmorList(){
		return armorList;
	}
	
	public List<Merchandise> getPotionList(){
		return potionList;
	}
	
	public List<Merchandise> getFireSpellList(){
		return fireSpellList;
	}
	
	public List<Merchandise> getIceSpellList(){
		return iceSpellList;
	}
	
	public List<Merchandise> getLightningSpellList(){
		return lightningSpellList;
	}
	
	public List<Merchandise> getItemTypeList(int type){
		if(type == 1) 
			return getWeaponList();
		if(type == 2 ) 
			return getArmorList();
		if (type == 3)
			return getPotionList();
		if(type == 4)
			return getIceSpellList();
		if(type == 5)
			return getFireSpellList();
		if(type == 6)
			return getLightningSpellList();
		else
			return null;
	}
	
	public void printInventory() {
		printInventoryHeader();
		if(!weaponList.isEmpty()) {
			printWeapon();
		}
		if(!armorList.isEmpty()) {
			printArmor();
		}
		if(!potionList.isEmpty()) {
			printPotion();
		}
		if(!iceSpellList.isEmpty()) {
			printIceSpell();
		}
		if(!fireSpellList.isEmpty()) {
			printFireSpell();
		}
		if(!lightningSpellList.isEmpty()) {
			printLightningSpell();
		}
	}
	
	public void printWeapon() {
		System.out.println(".................");
		System.out.println("Weapon: ");
		System.out.println(".................");
		System.out.printf("%20s %10s %12s %9s %15s%n", "Name","Cost","minLevel","Damage", "HandsRequired");
		System.out.println("-----------------------------------------------------------------------------");
		for(Merchandise w: weaponList) {
			w.printMerchandiseInfo();
		}
	}
	
	public void printArmor() {
		System.out.println(".................");
		System.out.println("Armor: ");
		System.out.println(".................");
		System.out.printf("%20s %10s %12s %15s%n", "Name","Cost","minLevel","DamageReduction");
		System.out.println("-----------------------------------------------------------------------------");
		for(Merchandise a: armorList) {
			a.printMerchandiseInfo();
		}
	}
	
	public void printPotion() {
		System.out.println(".................");
		System.out.println("Potion: ");
		System.out.println(".................");
		System.out.printf("%20s %10s %12s %15s %20s%n", "Name","Cost","minLevel","attributeIncrease", "attributeAffected");
		System.out.println("-----------------------------------------------------------------------------");
		for(Merchandise p: potionList) {
			p.printMerchandiseInfo();
		}
	}
	
	public void printIceSpell() {
		System.out.println(".................");
		System.out.println("iceSpell: ");
		System.out.println(".................");
		System.out.printf("%20s %10s %12s %9s %10s%n", "Name","Cost","minLevel","Damage", "manaCost");
		System.out.println("-----------------------------------------------------------------------------");
		for(Merchandise ice: iceSpellList) {
			ice.printMerchandiseInfo();
		}
	}
	
	public void printFireSpell() {
		System.out.println(".................");
		System.out.println("fireSpell: ");
		System.out.println(".................");
		System.out.printf("%20s %10s %12s %9s %10s%n", "Name","Cost","minLevel","Damage", "manaCost");
		System.out.println("-----------------------------------------------------------------------------");
		for(Merchandise fire: fireSpellList) {
			fire.printMerchandiseInfo();
		}
	}
	
	public void printLightningSpell() {
		System.out.println(".................");
		System.out.println("lightningSpell: ");
		System.out.println(".................");
		System.out.printf("%20s %10s %12s %9s %10s%n", "Name","Cost","minLevel","Damage", "manaCost");
		System.out.println("-----------------------------------------------------------------------------");
		for(Merchandise l: lightningSpellList) {
			l.printMerchandiseInfo();
		}
	}
	
	public void printInventoryHeader() {
		System.out.println("******************");
		System.out.println("Inventory: ");
		System.out.println("******************");
	}
	
}
