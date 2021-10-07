/**
 * 
 * Each merchandise has a name, price and minLevel(can only be bought by hero who achieved this level);
 *
 */
public abstract class Merchandise {
	protected String name;
	protected int price;
	protected int minLevel;
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}
	
	public int getSellingPrice() {
		return (int) (price*0.5);
	}
	
	public int getLevelRequired() {
		return minLevel;
	}

	public abstract void printMerchandiseInfo();
}
