/**
 * 
 * Each hero has a private wallet. Wallet has money(represented by int)in it.
 *
 */
public class Wallet {
	private int money;
	
	public Wallet() {
		
	}
	
	public void setMoney(int money) {
		this.money += money;
	}
	
	public int getMoney() {
		return money;
	}
}
