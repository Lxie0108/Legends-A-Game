/**
 * 
 * some fun textArt.
 *
 */
public class TextArt {

	public static final String BLUE = "\u001B[34m";
	public static final String RED = "\u001B[31m";
	public static final String RESET = "\u001B[0m";
	public static final String GREEN = "\u001B[32m";
	public static final String YELLOW = "\u001B[33m";
	
	public TextArt() {
		
	}
	
	public void printGameName() {
		System.out.println(RED+"╭╮╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╭╮╱╱╱╱╭━╮╭━╮╱╱╱╱╱╱╱╱╭╮╱╱╱╱╱╱╱╱╱╭━━━╮╱╱╱╱╭╮╭╮╱╭╮");
		System.out.println("┃┃╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱╱┃┃╱╱╱╱┃┃╰╯┃┃╱╱╱╱╱╱╱╭╯╰╮╱╱╱╱╱╱╱╱┃╭━╮┃╱╱╱╱┃┃┃┃╱┃┃");
		System.out.println("┃┃╱╱╭━━┳━━┳━━┳━╮╭━╯┣━━┳╮┃╭╮╭╮┣━━┳━╮╭━┻╮╭╋━━┳━┳━━╮┃┃╱┃┣━╮╭━╯┃┃╰━╯┣━━┳━┳━━┳━━┳━━╮");
		System.out.println("┃┃╱╭┫┃━┫╭╮┃┃━┫╭╮┫╭╮┃━━╋╯┃┃┃┃┃┃╭╮┃╭╮┫━━┫┃┃┃━┫╭┫━━┫┃╰━╯┃╭╮┫╭╮┃┃╭━╮┃┃━┫╭┫╭╮┃┃━┫━━┫");
		System.out.println("┃╰━╯┃┃━┫╰╯┃┃━┫┃┃┃╰╯┣━━┣╮┃┃┃┃┃┃╰╯┃┃┃┣━━┃╰┫┃━┫┃┣━━┃┃╭━╮┃┃┃┃╰╯┃┃┃╱┃┃┃━┫┃┃╰╯┃┃━╋━━┃");
		System.out.println("╰━━━┻━━┻━╮┣━━┻╯╰┻━━┻━━┻╯╰╯╰╯╰┻━━┻╯╰┻━━┻━┻━━┻╯╰━━╯╰╯╱╰┻╯╰┻━━╯╰╯╱╰┻━━┻╯╰━━┻━━┻━━╯");
		System.out.println("╱╱╱╱╱╱╱╭━╯┃");
		System.out.println("╱╱╱╱╱╱╱╰━━╯"+RESET);
	}
	
	public void printMarketUI() {
		// TODO Auto-generated method stub
		System.out.println(GREEN+"_.█████████████████ ");
		System.out.println("_ ██████████████████ ");
		System.out.println("████████████████████ ");
		System.out.println("█████████████████████ ");
		System.out.println("_█_________▄▄▄▄_ ▄▄▄▄_█ ");
		System.out.println("_█__█████_▐▓▓▌_▐▓▓▌_█ ");
		System.out.println("_█__█████_▐▓▓▌_▐▓▓▌_█ ");
		System.out.println("_█__█████_▐▓▓▌_▐▓▓▌_█ ");
		System.out.println("_█__█████_▀▀▀▀_ ▀▀▀▀ █✿ ✿ ");
		System.out.println("_█__█████_____________ █(\\|/") ;
		System.out.println("_____________██ _____________██ "+"Market place...");
		System.out.println("_____________█ ");
		System.out.println("______________█ ");
		System.out.println("_______________██ ");
		System.out.println("_________________██ ");
		System.out.println("___________________██ ");
		System.out.println("__________________██ ");
		System.out.println("_________________███ ");
		System.out.println("______________████ ");
		System.out.println("___________█████ ");
		System.out.println("_________██████ ");
		System.out.println("_______██████"+RESET);
	}
		
	public void printNoMonsterUI() {
		// TODO Auto-generated method stub
		System.out.println(GREEN+"──────▄▀─");
		System.out.println("─█▀▀▀█▀█─");
		System.out.println("──▀▄░▄▀──");
		System.out.println("────█────");
		System.out.println("──▄▄█▄▄── Peaceful place..."+RESET);
	}

	public void printMonsterAppearUI() {
		// TODO Auto-generated method stub
		System.out.println(RED+"──▄────▄▄▄▄▄▄▄────▄───");
		System.out.println("─▀▀▄─▄█████████▄─▄▀▀──");
		System.out.println("─────██─▀███▀─██──────");
		System.out.println("───▄─▀████▀████▀─▄────");
		System.out.println("─▀█────██▀█▀██────█▀──"+"Monsters Appear!"+RESET);
	}	

	public void printBasicInfo() {
		System.out.println("─▄▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▄  W/w: move up ");
		System.out.println("█░░░█░░░░░░░░░░▄▄░██░█ A/a: move left");
		System.out.println("█░▀▀█▀▀░▄▀░▄▀░░▀▀░▄▄░█ S/s: move down ");
		System.out.println("█░░░▀░░░▄▄▄▄▄░░██░▀▀░█ D/d: move right  ");
		System.out.println("─▀▄▄▄▄▄▀─────▀▄▄▄▄▄▄▀ You have a team of heroes. Your goal is to beat up as many monsters as possible to LEVEL UP indefinity. ");
	}
	
	public void printWelcome() {
		System.out.println(YELLOW+"	█▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀█");
		System.out.println("	█░░╦─╦╔╗╦─╔╗╔╗╔╦╗╔╗░░█");
		System.out.println("	█░░║║║╠─║─║─║║║║║╠─░░█");
		System.out.println("	█░░╚╩╝╚╝╚╝╚╝╚╝╩─╩╚╝░░█");
		System.out.println("	█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄█"+RESET);
	}

	public void printLevelUP() {
		System.out.println(RED+"───────────────▄▄───▐█");
		System.out.println("───▄▄▄───▄██▄──█▀───█─▄");
		System.out.println("─▄██▀█▌─██▄▄──▐█▀▄─▐█▀");
		System.out.println("▐█▀▀▌───▄▀▌─▌─█─▌──▌─▌");
		System.out.print("▌▀▄─▐──▀▄─▐▄─▐▄▐▄─▐▄─▐▄"+RESET);
	}
}
