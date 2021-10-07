/**
 * 
 * Wearable interface. object that implements wearable can be equipped and unequipped by hero.
 *
 */
public interface Wearable {
	public boolean isWearing();
	public void equip();
	public void unequip();
}
