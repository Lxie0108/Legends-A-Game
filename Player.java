import java.util.List;
import java.util.Scanner;
/**
 * 
 * It represents the player in this game. Each player has a name and a team of heroes.
 * Player will be asked for next move action and whether to quit the game, check inventory, heroInfo, enterMarket in different circumstances.
 *	
 */
public class Player {
	private Scanner sc;
	private String name;
	private List<Hero> heroes;// team of heroes that the player has.
	public static final String BLUE = "\u001B[34m";
	public static final String RESET = "\u001B[0m";
	
	public Player(String name, List<Hero> heroes) {
		this.name = name;
		this.heroes = heroes;
	}
	
	public String askMoveChoice() {
		String move;
		sc = new Scanner(System.in);
		System.out.println(BLUE+name+"! Time for next destination. Choose your move: "+RESET);
		move = sc.next();
		while(!move.equals("w")&&!move.equals("W")&&!move.equals("a")&&!move.equals("A")&&!move.equals("s")&&!move.equals("S")&&!move.equals("d")&&!move.equals("D")) {
			System.out.println("Invalid input. Try again");
			move = sc.next();
		}
		return move;
	}
	
	public int askIfEnterMarket() {
		int choice=0;
		sc = new Scanner(System.in);
		try {
			System.out.println(BLUE+name+", you reach market place. Would you like to enter? Type 1 for yes, 2 for no"+RESET);
			choice = sc.nextInt();
			while(choice!=1&&choice!=2) {
				System.out.println("Invalid input. Try again");
				choice = sc.nextInt();
			}
		return choice;
		} catch(Exception e) {
			System.out.println("Invalid input");
		}
		return 0;
	}
	
	public void askIfQuit() {
		sc = new Scanner(System.in);
		System.out.println(BLUE+name+", do you want to quit the game? Press q for quit and any other to resume the game"+RESET);
		String choice = sc.nextLine();
		if(choice.equalsIgnoreCase("q")) {
			System.exit(0);
		}
	}
	
	public boolean askIfCheckHeroInfo() {
		sc = new Scanner(System.in);
		System.out.println(BLUE+name+", do you want to check your hero's stats? Press i to check and any other for no"+RESET);
		String choice = sc.nextLine();
		if(choice.equalsIgnoreCase("i")) {
			return true;
		}
		return false;
	}
		
	public boolean askIfCheckInventory() {
		sc = new Scanner(System.in);
		System.out.println(BLUE+name+", Type 'y' if you want to check inventory/change equipment/consume a potion.");
		System.out.println("Any other key for no"+RESET);
		String choice = sc.nextLine();
		if(choice.equalsIgnoreCase("y")) {
			return true;
		}
		return false;
	}
	
	public String getName() {
		return name;
	}
	
	public List<Hero> getHeroes(){
		return heroes;
	}
}
