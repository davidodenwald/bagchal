/**
 * Ziege ist ein Tier, das sterben kann.
 */
public class Ziege extends Tier {

	/**
	 * tot zeigt an ob eine Ziege tot oder lebendig ist.
	 * Wenn eine Ziege erstellt wird, ist sie tot bis sie 
	 * auf das Spielfeld gesetzt wird.
	 */
	public boolean tot;

	/**
	 * Erstellt ein Ziege-Objekt, das auf einer Position sitzt.
	 */
	public Ziege(Position position) {
		super(position);
		tot = true;
	}

}
