/** 
 * 
 * A type of Cell. It is represented by " ", white space in Map.
 * There is chance where player encounter monsters in this cell.
 *
 */
public class CommonCell extends LegendsGameBoardCell {
	public CommonCell(){
		this.marker = new Marker(" ");
	}
}
