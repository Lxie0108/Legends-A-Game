import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * 
 * It converts txt file to fightable character objects, such as Warrior, Dragon...
 *
 */
public class FightableCharacterGenerator {
	private Scanner sc;
	private List<Warrior> warriorList;
	private List<Sorcerer> sorcererList;
	private List<Paladin> paladinList;
	private List<Dragon> dragonList;
	private List<Exoskeleton> exoskeletonList;
	private List<Spirit> spiritList;
	
	public FightableCharacterGenerator(){
		
	}
	
	public void generateCharacters() throws FileNotFoundException {
		generateHeroes();
		generateMonsters();
	}
	
	public void generateHeroes() throws FileNotFoundException {
		generateWarrior();
		generateSorcerer();
		generatePaladin();
	}
	
	public void generateMonsters() throws FileNotFoundException {
		generateDragon();
		generateExoskeleton();
		generateSpirit();
	}
	
	public List<Warrior> generateWarrior() throws FileNotFoundException{
		warriorList = new ArrayList<>();
		List<String> str = new ArrayList<String>();
		File f = new File("Warriors.txt");
		//File f = new File("src/Warriors.txt");
		sc = new Scanner(f);
		sc.useDelimiter("\n");
	    while(sc.hasNext()){  
	    	str.add(sc.next()); 
	    }
	   
	    for(int i = 1; i<str.size(); i++) {
	    	String[] elements = str.get(i).split("\\s+");
	    	if(elements.length != 0) {
		    	String name = elements[0];
		    	int mana = Integer.parseInt(elements[1]);
		    	int strength = Integer.parseInt(elements[2]);
		    	int agility =  Integer.parseInt(elements[3]);
		    	int dexterity = Integer.parseInt(elements[4]);
		    	int startingMoney = Integer.parseInt(elements[5]);
		    	int startingExp = Integer.parseInt(elements[6]);
		    	Warrior w = new Warrior(name,mana,strength,agility,dexterity,startingMoney,startingExp);
		    	warriorList.add(w);
	    	}
	    }
	    return warriorList;
	}
	
	public List<Sorcerer> generateSorcerer() throws FileNotFoundException{
		sorcererList = new ArrayList<>();
		List<String> str = new ArrayList<String>();
		File f = new File("Sorcerers.txt");
		//File f = new File("src/Sorcerers.txt");
		sc = new Scanner(f);
		sc.useDelimiter("\n");
	    while(sc.hasNext()){  
	    	str.add(sc.next()); 
	    }
	    for(int i = 1; i<str.size(); i++) {
	    	String[] elements = str.get(i).split("\\s+");
	    	if(elements.length != 0) {
		    	String name = elements[0];
		    	int mana = Integer.parseInt(elements[1]);
		    	int strength = Integer.parseInt(elements[2]);
		    	int agility =  Integer.parseInt(elements[3]);
		    	int dexterity = Integer.parseInt(elements[4]);
		    	int startingMoney = Integer.parseInt(elements[5]);
		    	int startingExp = Integer.parseInt(elements[6]);
		    	Sorcerer s  = new Sorcerer(name,mana,strength,agility,dexterity,startingMoney,startingExp);
		    	sorcererList.add(s);
	    	}
	    }
	    return sorcererList;
	}
	
	public List<Paladin> generatePaladin() throws FileNotFoundException{
		paladinList = new ArrayList<>();
		List<String> str = new ArrayList<String>();
		File f = new File("Paladins.txt");
		//File f = new File("src/Paladins.txt");
		sc = new Scanner(f);
		sc.useDelimiter("\n");
	    while(sc.hasNext()){  
	    	str.add(sc.next()); 
	    }
	    for(int i = 1; i<str.size(); i++) {
	    	String[] elements = str.get(i).split("\\s+");
	    	if(elements.length != 0) {
		    	String name = elements[0];
		    	int mana = Integer.parseInt(elements[1]);
		    	int strength = Integer.parseInt(elements[2]);
		    	int agility =  Integer.parseInt(elements[3]);
		    	int dexterity = Integer.parseInt(elements[4]);
		    	int startingMoney = Integer.parseInt(elements[5]);
		    	int startingExp = Integer.parseInt(elements[6]);
		    	Paladin p  = new Paladin(name,mana,strength,agility,dexterity,startingMoney,startingExp);
		    	paladinList.add(p);
	    	}
	    }
	    return paladinList;
	}
	
	public List<Dragon> generateDragon() throws FileNotFoundException{
		dragonList = new ArrayList<>();
		List<String> str = new ArrayList<String>();
		File f = new File("Dragons.txt");
		//File f = new File("src/Dragons.txt");
		sc = new Scanner(f);
		sc.useDelimiter("\n");
	    while(sc.hasNext()){  
	    	str.add(sc.next()); 
	    }
	    for(int i = 1; i<str.size(); i++) {
	    	String[] elements = str.get(i).split("\\s+");
	    	if(elements.length != 0) {
		    	String name = elements[0];
		    	int level = Integer.parseInt(elements[1]);
		    	int damage = Integer.parseInt(elements[2]);
		    	int defense =  Integer.parseInt(elements[3]);
		    	int dodgeChance = Integer.parseInt(elements[4]);
		    	Dragon d = new Dragon(name,level,damage,defense,dodgeChance);
		    	dragonList.add(d);
	    	}
	    }
	    return dragonList;
	}
	
	public List<Exoskeleton> generateExoskeleton() throws FileNotFoundException{
		exoskeletonList = new ArrayList<>();
		List<String> str = new ArrayList<String>();
		File f = new File("Exoskeletons.txt");
		//File f = new File("src/Exoskeletons.txt");
		sc = new Scanner(f);
		sc.useDelimiter("\n");
	    while(sc.hasNext()){  
	    	str.add(sc.next()); 
	    }
	    for(int i = 1; i<str.size(); i++) {
	    	String[] elements = str.get(i).split("\\s+");
	    	if(elements.length != 0) {
		    	String name = elements[0];
		    	int level = Integer.parseInt(elements[1]);
		    	int damage = Integer.parseInt(elements[2]);
		    	int defense =  Integer.parseInt(elements[3]);
		    	int dodgeChance = Integer.parseInt(elements[4]);
		    	Exoskeleton e = new Exoskeleton(name,level,damage,defense,dodgeChance);
		    	exoskeletonList.add(e);
	    	}
	    }
	    return exoskeletonList;
	}
	
	public List<Spirit> generateSpirit() throws FileNotFoundException{
		spiritList = new ArrayList<>();
		List<String> str = new ArrayList<String>();
		File f = new File("Spirits.txt");
		//File f = new File("src/Spirits.txt");
		sc = new Scanner(f);
		sc.useDelimiter("\n");
	    while(sc.hasNext()){  
	    	str.add(sc.next()); 
	    }
	    for(int i = 1; i<str.size(); i++) {
	    	String[] elements = str.get(i).split("\\s+");
	    	if(elements.length != 0) {
		    	String name = elements[0];
		    	int level = Integer.parseInt(elements[1]);
		    	int damage = Integer.parseInt(elements[2]);
		    	int defense =  Integer.parseInt(elements[3]);
		    	int dodgeChance = Integer.parseInt(elements[4]);
		    	Spirit s = new Spirit(name,level,damage,defense,dodgeChance);
		    	spiritList.add(s);
	    	}
	    }
	    return spiritList;
	}
}
