/** 
 * 
 * A type of Cell. It is represented by "M" in Map.
 * Market appears in this cell where Player can enter
 *
 */
public class MarketCell extends LegendsGameBoardCell{
	public MarketCell() {
		this.marker = new Marker("M");
	}
}
