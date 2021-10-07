/**
 * 
 * LegendGameCell constitutes LegendGameBoard. Each cell has a marker.
 *
 */
public class LegendsGameBoardCell extends GameBoardCell{
	protected Marker marker;
	public LegendsGameBoardCell() {
		
	}
	public Marker getMarker() {
		return marker;
	}
	public void setMarker(Marker marker) {
		this.marker = marker;
	}
}
