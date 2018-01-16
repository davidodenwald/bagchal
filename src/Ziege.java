/**
 * Ziege ist ein Tier, das sterben kann.
 */
public class Ziege extends Tier {

	boolean tot;

	public Ziege(Position position) {
		super(position);
		tot = true;
	}

}
