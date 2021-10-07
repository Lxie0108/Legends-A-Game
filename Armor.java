/**
 * 
 * This is the Armor class. It extends from Merchandise. Other than merchandise fields,
 * it has a damage reduction attribute. Heroes can wear Armor to get damage reduction.
 *
 */
public class Armor extends Merchandise implements Wearable{
	private int damageReduction;
	public Armor(String name, int cost, int minLevel, int damageReduction) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.price = cost;
		this.minLevel = minLevel;
		this.damageReduction = damageReduction;
	}

	@Override
	public void printMerchandiseInfo() {
		// TODO Auto-generated method stub
		System.out.printf("%20s %10d %10d %10d%n",name,price,minLevel,damageReduction);		
		
	}
	
	public int getDamageReduction() {
		return damageReduction;
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
