/**
 * Tier ist die Superklasse für Tiger und Ziegen.
 * Hier werden Methoden implementiert, die beide Tiere benutzen.
 */
public class Tier {
	private Position position;

	/**
	 * Erstellt ein Tier Obejt, das auf einer Position sitzt.
	 * 
	 * @param position	die Position auf dem Spielfeld auf dem das Tier sitzt.
	 */
	public Tier(Position position) {
		this.position = position;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public void zug(Position position) {
		this.position = position;
	}
}
