/**
 * 
 * A type of Cell. It is represented by "&" in Map.
 * Heroes can't get access to it.
 *
 */
public class InaccessibleCell extends LegendsGameBoardCell {
	public InaccessibleCell() {
		this.marker = new Marker("&");
	}
}
