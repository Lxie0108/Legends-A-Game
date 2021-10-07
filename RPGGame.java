/**
 * 
 * This is the parent class of LegendsMonstersAndHeroes. The main purpose of this class is for future extension.
 *
 */

public abstract class RPGGame {
	protected Player player;
	protected GameBoard gameBoard;
	public abstract void runGame();
	public abstract void generateBoard();
	public abstract void initializePlayer();
	public abstract void setUp();
	public abstract void playerPlay();
	public abstract void moveToNextCell();
	public abstract void triggerCellAction();
}
