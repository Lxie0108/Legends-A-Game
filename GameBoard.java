/**
 * 
 * This is the parent class of LegendBoardGameBoard. Its main purpose is for future extension.
 *
 */
public abstract class GameBoard {
	protected int width;
	protected int height;
	public abstract void generateNewBoard();
	public abstract int checkCellType();
	public abstract boolean checkValidMove(int r, int c);
	public abstract void setNextMove(int r, int c);
	public abstract void printBoard();
}
