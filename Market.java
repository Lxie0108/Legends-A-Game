import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * Market. Hero can make transaction(buy or sell merchandise) in this place. 
 *
 */

public class Market {
	private Scanner sc;
	private List<Merchandise> weaponList;
	private List<Merchandise> armorList;
	private List<Merchandise> potionList;
	private List<Merchandise> iceSpellList;
	private List<Merchandise> fireSpellList;
	private List<Merchandise> lightningSpellList;
	public static final String BLUE = "\u001B[34m";
	public static final String RED = "\u001B[31m";
	public static final String RESET = "\u001B[0m";
	public static final String GREEN = "\u001B[32m";
	
	
	public Market() throws FileNotFoundException {
		generateMerchandise();
	}
	
	public void generateMerchandise() throws FileNotFoundException {
		MerchandiseGenerator mg = new MerchandiseGenerator();
		weaponList = mg.generateWeapon();
		armorList = mg.generateArmor();
		potionList = mg.generatePotion();
		iceSpellList = mg.generateIceSpell();
		fireSpellList = mg.generateFireSpell();
		lightningSpellList= mg.generateLightningSpell();
	}
	
	public void enterMarket(Player player) {
		TextArt textArt = new TextArt();
		textArt.printWelcome();
		printMerchandise();
		askBuyOrSell(player);
	}
	
	public void askBuyOrSell(Player player) {
		sc = new Scanner(System.in);
		int choice;
		try {
			for(Hero h: player.getHeroes()) {
				boolean transacting = true;
				while(transacting) {
					System.out.println(BLUE+h.getName()+", buy or sell? Type 1 for buy , 2 for sell, 3 for neither"+RESET);
					choice = sc.nextInt();
					if(choice == 1) {
						heroBuyItemPickType(h);
					}
					if(choice == 2) {
						heroSellItemPickType(h);
					}
					if(choice == 3) {
						break;
					}
					if(choice!=1&&choice!=2&&choice!=3) {
						System.out.println("Invalid input.");
					}
					transacting = askIfAnotherDeal(h);
				}
			}
		} catch(Exception e) {
			System.out.println("Invalid input");
		}
	}
	
	public void heroBuyItemPickType(Hero hero) {
		sc = new Scanner(System.in);
		try {
			hero.printNameAndWallet();
			System.out.println(BLUE+"What would you like? Type 1 for Weapon, 2 for Armor, 3 for Potion, 4 for Spell");
			int itemType = sc.nextInt();
			if(itemType == 1) //buy weapon
				heroBuyItem(hero, weaponList, 1);
			if(itemType == 2) //buy armor
				heroBuyItem(hero, armorList, 2);
			if(itemType == 3) //buy potion
				heroBuyItem(hero, potionList, 3);	
			if(itemType == 4) {//buy spell
				System.out.println("What kind of spell do you want? 1 for IceSpell, 2 for FireSpell, 3 for LightningSpell"+RESET);
				int spellType = sc.nextInt();
				if(spellType == 1) {
					heroBuyItem(hero, iceSpellList, 4);
				}
				if(spellType == 2) {
					heroBuyItem(hero, fireSpellList, 5);
				}
				if(spellType == 3) {
					heroBuyItem(hero, lightningSpellList, 6);
				}
				if(spellType!=1&&spellType!=2&&spellType!=3) {
					System.out.print("Invalid input.");	
				}
			} 
			if(itemType!=1&&itemType!=2&&itemType!=3&&itemType!=4) {
				System.out.print("Invalid input. ");
			}
			
		} catch(Exception e) {
			System.out.println("Invalid input");
		}
	}
	public void heroBuyItem(Hero hero, List<Merchandise> list, int itemType) {
		sc = new Scanner(System.in);
		try {
		System.out.println(BLUE+"Which row is this item at?");
			int itemRow = sc.nextInt();
			while(itemRow<1||itemRow>list.size()) {
				System.out.println("invalid input. Try again");
				System.out.println("Which row?"+RESET);
				itemRow = sc.nextInt();
			} 
			Merchandise itemWanted = list.get(itemRow-1);
			if(hero.getLevel()>=itemWanted.getLevelRequired() && hero.getWallet().getMoney()>=itemWanted.getPrice()) {
				hero.getInventory().getItemTypeList(itemType).add(itemWanted);
				hero.getWallet().setMoney(-itemWanted.getPrice());
				System.out.println(RED+"Deal! Bought "+itemWanted.getName()+" for "+itemWanted.getPrice()+RESET);
			} else {
				System.out.println(RED+"Transaction rejected. Check your wallet and level please. "+RESET);
			}
		}catch(Exception e) {
			System.out.println("Invalid input");
		}
	}
	
	public void heroSellItemPickType(Hero hero) {
		sc = new Scanner(System.in);
		try {
			Inventory heroInventory = hero.getInventory();
			heroInventory.printInventory();
			System.out.println(BLUE+hero.getName()+", what would you like to sell? Type 1 for Weapon, 2 for Armor, 3 for Potion, 4 for Spell");
			int itemType = sc.nextInt();
			if(itemType == 1 && !heroInventory.getWeaponList().isEmpty()) //sell weapon
				heroSellItem(hero, heroInventory.getWeaponList(), 1);
			if(itemType == 2 && !heroInventory.getArmorList().isEmpty()) //sell armor
				heroSellItem(hero, heroInventory.getArmorList(), 2);
			if(itemType == 3 && !heroInventory.getPotionList().isEmpty()) //sell potion
				heroSellItem(hero, heroInventory.getPotionList(), 3);	
			if(itemType == 4) {//sell spell
				System.out.println("What kind of spell do you want to sell? 1 for IceSpell, 2 for FireSpell, 3 for LightningSpell"+RESET);
				int spellType = sc.nextInt();
				if(spellType == 1 && !heroInventory.getIceSpellList().isEmpty()) {
					heroSellItem(hero, heroInventory.getIceSpellList(), 4);
				}
				if(spellType == 2 && !heroInventory.getFireSpellList().isEmpty()) {
					heroSellItem(hero, heroInventory.getFireSpellList(), 5);
				}
				if(spellType == 3 && !heroInventory.getLightningSpellList().isEmpty()) {
					heroSellItem(hero, heroInventory.getLightningSpellList(), 6);
				}
				if(spellType!=1&&spellType!=2&&spellType!=3) {
					System.out.print("Invalid input.");
				}
			}
			if(itemType!=1&&itemType!=2&&itemType!=3&&itemType!=4) {
				System.out.println("Invalid input. ");
			}
		} catch (Exception e) {
			System.out.println("Invalid input");
		}
	}
	
	public void heroSellItem(Hero hero, List<Merchandise> list, int itemType) {
		sc = new Scanner(System.in);
		try {
		System.out.println(BLUE+"Which row is this item at?"+RESET);
			int itemRow = sc.nextInt();
			while(itemRow<1||itemRow>list.size()) {
				System.out.println("invalid input. Try again");
				System.out.println("Which row?");
				itemRow = sc.nextInt();
			} 
			Merchandise itemDeleted = list.get(itemRow-1);
			int moneyEarn = (int) (itemDeleted.getPrice()*0.5);
			list.remove(itemDeleted);
			hero.getWallet().setMoney(moneyEarn);
			System.out.println(RED+"Deal! Sold "+itemDeleted.getName()+" for "+itemDeleted.getSellingPrice()+RESET);
		}catch(Exception e) {
			System.out.println("Invalid input");
		}
	}
	
	public boolean askIfAnotherDeal(Hero hero) {
		sc = new Scanner(System.in);
		try {
			System.out.println(BLUE+hero.getName()+", Type 1 for another transaction, 2 for no"+RESET);
			int choice = sc.nextInt();
			if(choice == 1)
				return true;
			if(choice == 2)
				return false;
			while(choice!=1&&choice!=2) {
				System.out.println("Invalid input. Try again");
				choice = sc.nextInt();
			}			
		}catch(Exception e) {
			System.out.println("Invalid input");
		}
		return false;
	}

	public void printMerchandise() {
		printWeapon();
		printArmory();
		printPotion();
		printSpell();
	}
	
	public void printWeapon() {
		System.out.println("******************");
		System.out.println("Weapons available: ");
		System.out.println("******************");
		System.out.printf("%20s %10s %12s %9s %15s%n", "Name","Cost","minLevel","Damage", "HandsRequired");
		System.out.println("-----------------------------------------------------------------------------");
		for(Merchandise w: weaponList) {
			w.printMerchandiseInfo();
		}
	}
	
	public void printArmory() {
		System.out.println("******************");
		System.out.println("Armors available: ");
		System.out.println("******************");
		System.out.printf("%20s %10s %12s %15s%n", "Name","Cost","minLevel","DamageReduction");
		System.out.println("-----------------------------------------------------------------------------");
		for(Merchandise a: armorList) {
			a.printMerchandiseInfo();
		}
	}
	
	public void printPotion() {
		System.out.println("******************");
		System.out.println("Potions available: ");
		System.out.println("******************");
		System.out.printf("%20s %10s %12s %15s %20s%n", "Name","Cost","minLevel","attributeIncrease", "attributeAffected");
		System.out.println("-----------------------------------------------------------------------------");
		for(Merchandise p: potionList) {
			p.printMerchandiseInfo();
		}
	}
	
	public void printSpell() {
		System.out.println("******************");
		System.out.println("Spells available: ");
		System.out.println("******************");
		System.out.printf("%20s %10s %12s %9s %10s%n", "Name","Cost","minLevel","Damage", "manaCost");
		System.out.println("-----------------------------------------------------------------------------");
		printIceSpell();
		printFireSpell();
		printLightningSpell();	
	}
	
	public void printIceSpell() {
		System.out.println("...........");
		System.out.println("Ice Spells: ");
		System.out.println("...........");
		for(Merchandise ice: iceSpellList) {
			ice.printMerchandiseInfo();
		}
	}
	
	public void printFireSpell() {
		System.out.println("...........");
		System.out.println("Fire Spells: ");
		System.out.println("...........");
		for(Merchandise fire: fireSpellList) {
			fire.printMerchandiseInfo();
		}
	}
	
	public void printLightningSpell() {
		System.out.println("................");
		System.out.println("Lightning Spells: ");
		System.out.println("................");
		for(Merchandise l: lightningSpellList) {
			l.printMerchandiseInfo();
		}
	}

}

