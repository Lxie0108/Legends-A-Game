import java.util.ArrayList;
import java.util.List;
/**
 * 
 * A type of Merchandise. It is single-use(consumable), and after consumption hero can get some of her stats boosted 
 * to some amount depending on Potion's attributeIncrease and attributeAffected.
 */
public class Potion extends Merchandise implements Consumable{
	private int attributeIncrease;
	private String attributeAffected;
	private List<String> attributeAffectedList;
	
	public Potion(String name, int cost, int minLevel, int attributeIncrease, String attributeAffected) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.price = cost;
		this.minLevel = minLevel;
		this.attributeIncrease = attributeIncrease;
		this.attributeAffected = attributeAffected;	
		attributeAffectedList = new ArrayList<>();
		attributeAffectedSeparate();
	}
	
	public void attributeAffectedSeparate() {
		String[] str = attributeAffected.split("/");
		for(String s: str) {
			attributeAffectedList.add(s);
		}
	}
	
	public List<String> getAttributeAffectedList(){
		return attributeAffectedList;
	}
	
	public void printMerchandiseInfo() {
		System.out.printf("%20s %10d %10d %10d %20s%n",name,price,minLevel,attributeIncrease,attributeAffected);		
	}
	
	public String getAttributedAffected() {
		return attributeAffected;
	}
	
	public int getAttributeIncrease() {
		return attributeIncrease;
	}

	@Override
	public void consume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isConsumed() {
		// TODO Auto-generated method stub
		return false;
	}

}
