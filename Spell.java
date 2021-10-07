/**
 * 
 * A type of merchandise sold on Market. It consumes mana to cast and inflicts damage when cast.
 *
 */
public class Spell extends Merchandise {
	private int damage;
	private int manaCost;
	public Spell(String name, int cost, int minLevel, int damage, int manaCost) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.price = cost;
		this.minLevel = minLevel;
		this.damage = damage;
		this.manaCost = manaCost;
		
	}
	
	public int getDamage() {
		return damage;
	}
	
	public int getManaCost() {
		return manaCost;
	}
	
	public void printMerchandiseInfo() {
		System.out.printf("%20s %10d %10d %10d %10d%n",name,price,minLevel,damage,manaCost);		
	}
}
