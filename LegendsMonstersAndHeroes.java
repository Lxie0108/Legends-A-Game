import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
/**
 * The is the Game Legends:Monsters And Heroes class. It has a LegendGameBoard(map), a Market, a Player with a team of her chosen hero
 * as well as some monsters that player will bumped into if she is "unlucky".
 * The goal of this game is for player to get her team of heroes to gain experience and level up indefinitely. 
 * For general game logic , please see runGame(). For more specific info, please see method description.
 */
public class LegendsMonstersAndHeroes extends RPGGame {
	public static final String BLUE = "\u001B[34m";
	public static final String RED = "\u001B[31m";
	public static final String RESET = "\u001B[0m";
	public static final String GREEN = "\u001B[32m";
	private boolean keepPlaying;
	private int nextRowHero;
	private int nextColHero;
	private int monsterInCellLevel;
	private Player player;
	private Market market;
	private List<Warrior> warriorList;
	private List<Sorcerer> sorcererList;
	private List<Paladin> paladinList;
	private List<Exoskeleton> exoskeletonList;
	private List<Dragon> dragonList;
	private List<Spirit> spiritList;
	private List<Monster> monsterInCell;
	private LegendsGameBoard gameBoard;
	private Scanner sc;
	private TextArt textArt;
	
	public LegendsMonstersAndHeroes() {
		keepPlaying = true;	
		textArt = new TextArt();
	}
	
	public void runGame() {
		try {
			textArt.printGameName();//print Game name is a fancy way.
			askIfNeedBasicInfo();//in case of playing doesn't know how to play the game, print basic game&control info
			setUp();
			printPlayerTeam();//print the initial team members and their stats for display.
			playerPlay();//play the game
		} catch(Exception e) {
			//System.out.print("Exception! Please provide valid input.");
			e.printStackTrace();
		}
	}
	
	public void setUp()  {
		try {
			generateHeroList();
			generateMonsterList();
			generateBoard();
			generateMarket();
			initializePlayer();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void generateHeroList() throws FileNotFoundException {
		FightableCharacterGenerator fcg = new FightableCharacterGenerator();
		warriorList = fcg.generateWarrior();
		sorcererList = fcg.generateSorcerer();
		paladinList = fcg.generatePaladin();
	}
	public void generateMonsterList() throws FileNotFoundException {
		FightableCharacterGenerator fcg = new FightableCharacterGenerator();
		exoskeletonList = fcg.generateExoskeleton();
		dragonList = fcg.generateDragon();
		spiritList = fcg.generateSpirit();
	}
	public void generateMarket() {
		try {
			market = new Market();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void generateBoard() {
		sc = new Scanner(System.in);
		try {
			System.out.println(" ");
			System.out.println(BLUE+"Choose the width of the Board: (Type a number from 4 to 20)");
			int width = sc.nextInt();
			System.out.println("Choose the height of the Board: (Type a number from 4 to 20)"+RESET);
			int height = sc.nextInt();
			while(width<4|| width>20||height<4||height>20) {
				System.out.println("invalid input. Try again");
				System.out.println("width: ");
				width = sc.nextInt();
				System.out.println("height: ");
				height = sc.nextInt();
			}
			gameBoard = new LegendsGameBoard(width,height);
		} catch (Exception e) {
			System.out.println("invalid input");
		}
	}
	
	/**
	 * Each player has a name and a team of heroes. This method ask player's name and her chosen heroes.
	 * Player can only have unique heroes in her team.
	 */
	public void initializePlayer() {
		sc = new Scanner(System.in);
		try {
			System.out.println(BLUE+"What's your name, player? "+RESET);
			String name = sc.next();
			System.out.println("<<<<<<<<<<<<<<<<<<<<"+name+", CHOOSE YOUR TEAM>>>>>>>>>>>>>>>>>>>>");
			printHeroList();
			int heroNum = 0;
			List<Hero> heroes = new ArrayList<Hero>();
			while(heroNum<3) {
				System.out.println(BLUE+name+", choose your "+(heroNum+1)+" hero");
				System.out.println("Which type of heroes is she gonna be? Type 1 for Warrior, 2 for Sorcerer, 3 for Paladins");
				int heroType = sc.nextInt();
				while(heroType!=1&&heroType!=2&&heroType!=3) {
					System.out.println("invalid input. Try again");
					System.out.println("Which type of hero?");
					heroType = sc.nextInt();
				}
				System.out.println("Which row is she? Type a valid number please");
				int heroRow = sc.nextInt();
				if(heroType == 1) {
					while(heroRow<1||heroRow>warriorList.size()) {
						System.out.println("invalid input. Try again");
						System.out.println("Which row?");
						heroRow = sc.nextInt();
					} 
					if(heroes.contains(warriorList.get(heroRow-1))) {
						System.out.println(name+", you already have the hero in your team. ");
						heroes.remove(warriorList.get(heroRow-1));
						heroNum--;
					}
					heroes.add(warriorList.get(heroRow-1));
					heroNum++;
				} else if(heroType == 2) {
					while(heroRow<1||heroRow>sorcererList.size()) {
						System.out.println("invalid input. Try again");
						System.out.println("Which row?");
						heroRow = sc.nextInt();
					} 
					if(heroes.contains(sorcererList.get(heroRow-1))) {
						System.out.println(name +", you already have the hero in your team. ");
						heroes.remove(sorcererList.get(heroRow-1));
						heroNum--;
					}
					heroes.add(sorcererList.get(heroRow-1));
					heroNum++;
					
				} else if(heroType == 3) {
					while(heroRow<1||heroRow>paladinList.size()) {
						System.out.println("invalid input. Try again");
						System.out.println("Which row?");
						heroRow = sc.nextInt();
					} if(heroes.contains(paladinList.get(heroRow-1))) {
						System.out.println(player.getName()+", you already have the hero in your team. ");
						heroes.remove(paladinList.get(heroRow-1));
						heroNum--;
					}
					heroes.add(paladinList.get(heroRow-1));
					heroNum++;
				}
				if(heroNum<3) {
					System.out.println("Choose another hero? Type 1 for yes and 2 for no"+RESET);
					int choice = sc.nextInt();
					if(choice == 2) {
						break;
					}
					if(choice == 1) {
						continue;
					} if(choice!=1&&choice!=2){
						System.out.println("invalid input.");
						break;
					}
				}
			}
			player = new Player(name,heroes);
		} catch (Exception e) {
			System.out.println("invalid input");
		}
	}
	
	public void askIfNeedBasicInfo() {
		sc = new Scanner(System.in);
		try {
			System.out.println(BLUE+"Would you like to view the basic info of the game? Type 1 for yes and 2 for no"+RESET);
			int ans = sc.nextInt();
			if(ans == 1) {
				textArt.printBasicInfo();
			}
			while(ans!=1&&ans!=2) {
				System.out.println("invalid input. Try again");
				ans = sc.nextInt();
			}
		}catch (Exception e) {
			System.out.println("Invalid input");
		} 
	}
	
	public void playerPlay() {
		while(keepPlaying) {
			moveToNextCell();
		}
	}
	
	public void moveToNextCell() {
		gameBoard.printBoard();
		String move = player.askMoveChoice();
		boolean canMove = false;
		int curRow = gameBoard.getHeroRow();
		int curCol = gameBoard.getHeroCol();
		canMove = checkValidMove(move,curRow,curCol);
		while(canMove == false) {//if player can't go to the chosen cell, ask&check again.
			System.out.println(BLUE+"You can't go there. Try again"+RESET);
			move =  player.askMoveChoice();
			canMove = checkValidMove(move,curRow,curCol);
		}
		gameBoard.restorePrevMarker(curRow,curCol);//restore the symbol of current cell before hero's symbol took its place.
		gameBoard.updateHeroLoc(nextRowHero, nextColHero);//hero moves to her next destination.
		gameBoard.printBoard();//print the updated board.
		triggerCellAction();
	}
	
	public boolean checkValidMove(String move,int curRow, int curCol) {
		try {
			boolean canMove = false;
			if(move.equals("w")||move.equals("W")) {
				nextRowHero = curRow-1;
				nextColHero = curCol;
				canMove = gameBoard.checkValidMove(nextRowHero, nextColHero);
				if(canMove == true)
					gameBoard.setNextMove(nextRowHero, nextColHero);
			}
			if(move.equals("s")||move.equals("S")) {
				nextRowHero = curRow+1;
				nextColHero = curCol;
				canMove = gameBoard.checkValidMove(nextRowHero, nextColHero);
				if(canMove == true)
					gameBoard.setNextMove(nextRowHero, nextColHero);
			}
			if(move.equals("a")||move.equals("A")) {
				nextRowHero = curRow;
				nextColHero = curCol-1;
				canMove = gameBoard.checkValidMove(nextRowHero, nextColHero);
				if(canMove == true)
					gameBoard.setNextMove(nextRowHero, nextColHero);
			}
			if(move.equals("d")||move.equals("D")) {
				nextRowHero = curRow;
				nextColHero = curCol+1;
				canMove = gameBoard.checkValidMove(nextRowHero, nextColHero);
				if(canMove == true)
					gameBoard.setNextMove(nextRowHero, nextColHero);
			}
			return canMove;
		} catch(Exception e){
			System.out.println("Out of Board");
		}
		return false;
	}
	/**
	 * when player moves to a new cell, determine which type of cell it is and trigger the following 
	 * action. 
	 */
	public void triggerCellAction() {
		int cellType;//use int for simplicity. 1: commonCell, 2:marketCell
		cellType = gameBoard.checkCellType();
		if(cellType == 1) {//commonCell
			if(checkMonsterExist()) {//monster appears in the cell
				textArt.printMonsterAppearUI();
				player.askIfQuit();
				generateMonster();
				fight();
			} else {// if monster does not appear in this cell
				textArt.printNoMonsterUI();
				player.askIfQuit();
				boolean checkHeroStats = player.askIfCheckHeroInfo();
				if(checkHeroStats == true) {
					printPlayerTeam();
				}
				boolean checkInventory = player.askIfCheckInventory();
				if(checkInventory == true) {
					inventoryAction();
				}
			}
		}
		if(cellType == 2) {//marketCell
			textArt.printMarketUI();
			player.askIfQuit();
			int choice = player.askIfEnterMarket();
			if(choice == 1) {
			market.enterMarket(player);
			}
		}
	}
	
	/** 
	 * How to implement this is not specified in the assignment
	 * My design: generate a random number from 0-100, if it is even, monster exist. chance 50%.
	 */
	public boolean checkMonsterExist() {
		Random rand = new Random();
		int randNum = rand.nextInt(100);
		if(randNum%2 == 0)
			return true;
		else
			return false;
	}
	
	/**
	 * generate (number of heroes) monsters of the same level as the level of the highest leveled hero.
	 */
	public void generateMonster() {
		int maxLevel = 0;
		int currLevel;
		int heroNum = player.getHeroes().size();
		int countMonster = 0;
		monsterInCell = new ArrayList<>();
		for(Hero h: player.getHeroes()) {//get heroes' max level
			currLevel = h.getLevel();
			maxLevel = Math.max(currLevel, maxLevel);
		}
		monsterInCellLevel = maxLevel;
		if(countMonster<heroNum) {
			for(Exoskeleton e: exoskeletonList) {
				if(e.getLevel() == maxLevel) {
					monsterInCell.add(e);
					countMonster++;
					break;
				}
			}
		}
		if(countMonster<heroNum) {
			for(Spirit s: spiritList) {
				if(s.getLevel() == maxLevel) {
					monsterInCell.add(s);
					countMonster++;
					break;
				}
			}
		}
		if(countMonster<heroNum) {
			for(Dragon d: dragonList) {
				if(d.getLevel() == maxLevel) {
					monsterInCell.add(d);
					countMonster++;
					break;
				}
			}
		}
	}
	/**
	 * 1v1. A hero will always act first. She can equip, do a regular attack, use a potion, or cast a spell
	 * Then monster acts. Fight ends when all heroes or all monster fainted (hp = 0). 
	 */
	public void fight() {
		boolean fightEnd = false;
		printFightUI();
		while(true) {
			printMonsterTeam();
			printPlayerTeamInFight();
			for(Hero h: player.getHeroes()) {
				if(h.isAlive()) {
					int actionType = askHeroAction(h);
					performAction(h,actionType);//hero acts
					Monster monster = (Monster) getEnemy(h);
					if(monster != null) {
						regularAttack(monster); // monster regular attacks
					}
					fightEnd = checkFightEnd();	
					if(fightEnd == true) {
						break;
					}
				}
			}
			restoreHeroStats();
			if(fightEnd == true) {
				break;
			}
		}
		getfightResult();
		printPlayerTeam();
		resetMonster();
	}
	
	public void getfightResult() {
		for(Hero h: player.getHeroes()) {
			if(h.isAlive()) {//get money and 2 exp
				int moneyEarn = 100*monsterInCellLevel;
				h.getWallet().setMoney(moneyEarn);
				h.gainExp(2);
			} 
			if(!h.isAlive()) {//get revived and get set to half hp
				h.revive();
			}
		}
	}
	
	public boolean checkFightEnd() {
		int monsterTotalHp = 0;
		int heroTotalHp = 0;
		for(Monster m : monsterInCell) {
			monsterTotalHp += m.getHp();
		}
		for(Hero h : player.getHeroes()) {
			heroTotalHp += h.getHp();
		}
		if(monsterTotalHp == 0) {
			printWinUI();
			return true;
		}
		if(heroTotalHp == 0) {
			printLoseUI();
			return true;
		}
		return false;
		
	}
	
	public void restoreHeroStats() {
		for(Hero h: player.getHeroes()) {
			if(h.isAlive()) {//restore 10% hp and 10% mana
				if(h.getHp()<h.getHpDefault())
					h.updateHp((int)(h.getHpDefault()*0.1));
				if(h.getMana()<h.getManaDefault())
					h.updateMana((int)(h.getManaDefault()*0.1));
			}
		}
	}
	
	public int askHeroAction(Hero h) {
		sc = new Scanner(System.in);
		try {
			System.out.println(BLUE+"Choose move for "+ h.getName());
			System.out.println("Type 1 for Equip, 2 for Regular Attack, 3 for Cast Spell, 4 for Use Potion"+RESET);
			int choice = sc.nextInt();
			while(choice!=1&&choice!=2&&choice!=3&&choice!=4) {
				System.out.println("Invalid input. Try again.");
				choice = sc.nextInt();
			}
			return choice;
		} catch(Exception e) {
			System.out.println("Invalid input.");
		}
		return 0;
	}
	
	public void performAction(Hero h, int actionType) {
		try {
			if(actionType == 1) {
				h.chooseWearable();
			}
			if(actionType == 2) {
				regularAttack(h);
			}
			if(actionType == 3) {
				castSpell(h);
			}
			if(actionType == 4) {
				h.choosePotion();
			}
		}catch(Exception e) {
			System.out.println("Invalid input.");
		}
	}

	public void regularAttack(FightableCharacter character) {
		int damage = character.getDamageDone();
		FightableCharacter enemy = getEnemy(character);
		int finalDamageDone = getDamageDone(damage,enemy);
		System.out.println(RED+character.getName()+" has dealed "+ finalDamageDone +" to "+enemy.getName()+RESET);
	}
	/**
	 * get the specific enemy given specific character
	 * 
	 */
	public FightableCharacter getEnemy(FightableCharacter character) {
		FightableCharacter enemy = null;
		if(character instanceof Hero) {
			Hero h = (Hero) character;
			enemy =  getEnemyMonster(h);
		}
		if(character instanceof Monster) {
			Monster m = (Monster) character;
			enemy = getEnemyHero(m);
		}
		return enemy;
	}
	
	public Monster getEnemyMonster(Hero h) {
		Monster enemy = null;
		int enemyIndex = player.getHeroes().indexOf(h);
		boolean enemySameIndexAlive = monsterInCell.get(enemyIndex).isAlive();
		if(!enemySameIndexAlive) {
			for(Monster m: monsterInCell) {
				if(m.isAlive()) {
				enemy = m;
				break;
				}
			}
		} else {
			enemy = monsterInCell.get(enemyIndex);		
		}
		return enemy;
	}
	
	public Hero getEnemyHero(Monster m) {
		Hero enemy = null;
		int enemyIndex = monsterInCell.indexOf(m);
		boolean enemySameIndexAlive = player.getHeroes().get(enemyIndex).isAlive();
		if(!enemySameIndexAlive) {
			for(Hero h: player.getHeroes()) {
				if(h.isAlive) {
				enemy = h;
				break;
				}
			}
		} else {
			enemy = player.getHeroes().get(enemyIndex);		
		}
		return enemy;
	}
	
	public int getDamageDone(int damage, FightableCharacter enemy) {
		if(enemy.hasDodged()) {
			System.out.println(RED+enemy.getName()+" dodged attack! "+RESET);
			return 0;
		}
		else {
			int finalDamageDone = damage - enemy.getDefense();
			enemy.updateHp(-finalDamageDone);
			return finalDamageDone;
		}
	}
	public void castSpell(Hero h) {
		Spell spell = h.chooseSpell();
		Monster enemy = (Monster) getEnemy(h);
		if(spell.getManaCost() > h.getMana()) {//not enough mana to cast the spell
			System.out.println(RED+h.getName()+", you can't cast "+ spell.getName());
			System.out.println("Not enough mana"+RESET);
		} else {//cast the spell
			h.updateMana(-spell.getManaCost());
			if(spell instanceof IceSpell) {//reduce damage of enemy
				enemy.setDamage(-(int)(enemy.getDamageDone()*0.1));
			}
			if(spell instanceof FireSpell) {//reduce defense of enemy
				enemy.setDefense(-(int)(enemy.getDefense()*0.1));
			}
			if(spell instanceof LightningSpell) {//reduce dodge chance of enemy
				enemy.setDodgeChance(-(int)(enemy.getDodgeChance()*0.1));
			}
			int finalDamageDone = getSpellDamageDone(spell,h,enemy);
			System.out.println(RED+h.getName()+" has dealed "+ finalDamageDone +" magic damage to "+enemy.getName()+RESET);
		} 
	}
	
	public int getSpellDamageDone(Spell spell, Hero hero, Monster enemy) {
		if(enemy.hasDodged()) {
			System.out.println(RED+enemy.getName()+" dodged attack! "+RESET);
			return 0;
		}
		else {
			int finalDamage = (int) (spell.getDamage() + (hero.getDexterity()/10000.00)*(spell.getDamage()));
			enemy.updateHp(-finalDamage);
			return finalDamage;
		}
	}
	
	public void resetMonster() {
		for(Monster m: monsterInCell) {
			m.reset();
		}
	}
	/**
	 * hero can equip, consume potion when checking inventory.
	 */
	public void inventoryAction() {
		sc = new Scanner(System.in);
		for(Hero h: player.getHeroes()) {//print inventory for all heroes in player's team
			System.out.println(GREEN+"^^^^^^^^^^^^^^"+h.getName()+"^^^^^^^^^^^^^^"+RESET);
			h.getInventory().printInventory();
		}
		
		for(Hero h: player.getHeroes()) {//get action for each hero
			while(true) {
				System.out.println(BLUE+player.getName()+", Type 1 to equip for "+h.getName());
				System.out.println(player.getName()+", Type 2 to consume Potion for "+h.getName());
				System.out.println(player.getName()+", Type any other key to do neither for "+h.getName()+RESET);
				String choice = sc.nextLine();
				if(choice.equals("1")) {
					h.chooseWearable();
				}
				if(choice.equals("2")) {
					h.choosePotion();
				}
				if(!choice.equals("1")&&!choice.equals("2")) {
					break;
				}
				System.out.println(BLUE+"Equip/Consume another item for"+ h.getName()+"?");
				System.out.println("Type y for yes any other key for no"+RESET);
				String another = sc.nextLine();
				if(!another.equalsIgnoreCase("y")) {
					break;
				}
			}
		}
	}
	
	public void printHeroList() {
		printWarrior();
		printSorcerer();
		printPaladin();
	}
	
	public void printBoard() {
		gameBoard.printBoard();
	}
	
	public void printMonsterTeam() {
		System.out.println("MONSTER TEAM: ");
		System.out.printf("%20s %10s %10s %10s %10s %15s%n", "Name","Hp","Level","Damage","Defense","DodgeChance");
		System.out.println("------------------------------------------------------------------------------------------------------------");
		for(Monster m : monsterInCell) {
			m.printMonsterInfo();
		}
	}
	
	public void printPlayerTeam() {
		System.out.println(player.getName()+", YOUR TEAM: ");
		System.out.printf("%20s %10s %10s %10s %10s %10s %10s %10s %10s%n", "Name","Hp","Level","Mana","Strength","Agility", "Dexterity","Exp","Money");
		System.out.println("------------------------------------------------------------------------------------------------------------");
		for(Hero h : player.getHeroes()) {
			h.printHeroInfo();
		}
	}
	
	public void printPlayerTeamInFight() {
		System.out.println(player.getName()+", YOUR TEAM: ");
		System.out.printf("%20s %10s %10s %10s %20s %20s%n", "Name","Hp","Level","Mana","Weapon", "Armor");
		System.out.println("------------------------------------------------------------------------------------------------------------");
		for(Hero h : player.getHeroes()) {
			h.printHeroInfoInFight();
		}
	}
	public void printWarrior() {
		System.out.println("******************");
		System.out.println("Warriors available: ");
		System.out.println("******************");
		System.out.printf("%20s %10s %10s %10s %10s %15s %15s%n", "Name","Mana","Strength","Agility", "Dexterity","startingMoney","startingExp");
		System.out.println("------------------------------------------------------------------------------------------------------------");
		for(Warrior w: warriorList) {
			w.printHeroInfoDefault();
		}
	}
	
	public void printSorcerer() {
		System.out.println("******************");
		System.out.println("Sorcerers available: ");
		System.out.println("******************");
		System.out.printf("%20s %10s %10s %10s %10s %15s %15s%n", "Name","Mana","Strength","Agility", "Dexterity","startingMoney","startingExp");
		System.out.println("------------------------------------------------------------------------------------------------------------");
		for(Sorcerer s: sorcererList) {
			s.printHeroInfoDefault();
		}
	}
	
	public void printPaladin() {
		System.out.println("******************");
		System.out.println("Paladins available: ");
		System.out.println("******************");
		System.out.printf("%20s %10s %10s %10s %10s %15s %15s%n", "Name","Mana","Strength","Agility", "Dexterity","startingMoney","startingExp");
		System.out.println("-----------------------------------------------------------------------------------------------------------");
		for(Paladin p: paladinList) {
			p.printHeroInfoDefault();
		}
	}
	public void printFightUI() {
		System.out.println(GREEN+ "(ง︡'-'︠)ง TIME TO FIGHT, "+player.getName()+"! (ง︡'-'︠)ง"+ RESET);
	}
	
	public void printWinUI() {
		System.out.println(GREEN+ "（っ＾▿＾）"+player.getName()+", you win! （っ＾▿＾)"+ RESET);
	}
	
	public void printLoseUI() {
		System.out.println(GREEN+ "(╥﹏╥)"+player.getName()+", you lose! (╥﹏╥)"+ RESET);
	}
}