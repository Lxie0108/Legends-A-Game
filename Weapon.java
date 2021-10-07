/**
 * 
 * A type of merchandise. Hero can wear weapon to gain extra damage.
 *
 */
public class Weapon extends Merchandise implements Wearable{
	private int damage;
	private int handReq;
	
	public Weapon(String name, int cost, int minLevel, int damage, int handReq) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.price = cost;
		this.minLevel = minLevel;
		this.damage = damage;
		this.handReq = handReq;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public int getHandReq() {
		return handReq;
	}
	
	public void printMerchandiseInfo() {
		System.out.printf("%20s %10d %10d %10d %10d%n",name,price,minLevel,damage,handReq);		
	}

	@Override
	public boolean isWearing() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void equip() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unequip() {
		// TODO Auto-generated method stub
		
	}

}
