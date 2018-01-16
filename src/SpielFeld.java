/**
 * SpielFeld ist das Model des Spiels, der alle Eingaben prüft
 * und Figuren bewegt.
 */
public class SpielFeld {
	private Tiger[] tiger = new Tiger[4];
	private Ziege[] ziegen = new Ziege[20];

	private int ziegenGesetzt;
	private int ziegenGefressen;

	private static int[][] zuege = { { 0, 1, 2, 0, 0, 1, 1, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 0, 1, 2, 0, 0, 1, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 2, 1, 0, 1, 2, 0, 1, 1, 1, 0, 2, 0, 2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 2, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 2, 1, 0, 0, 0, 0, 1, 1, 0, 0, 2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 0, 0, 0, 0, 0, 1, 2, 0, 0, 1, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
			{ 1, 1, 1, 0, 0, 1, 0, 1, 2, 0, 1, 1, 1, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 1, 0, 0, 2, 1, 0, 1, 2, 0, 0, 1, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 1, 1, 1, 0, 2, 1, 0, 1, 0, 0, 1, 1, 1, 0, 2, 0, 2, 0, 0, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 1, 0, 0, 2, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0 },
			{ 2, 0, 2, 0, 0, 1, 1, 0, 0, 0, 0, 1, 2, 0, 0, 1, 1, 0, 0, 0, 2, 0, 2, 0, 0 },
			{ 0, 2, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 2, 0, 0, 1, 0, 0, 0, 0, 2, 0, 0, 0 },
			{ 2, 0, 2, 0, 2, 0, 1, 1, 1, 0, 2, 1, 0, 1, 2, 0, 1, 1, 1, 0, 2, 0, 2, 0, 2 },
			{ 0, 0, 0, 2, 0, 0, 0, 0, 1, 0, 0, 2, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 2, 0 },
			{ 0, 0, 2, 0, 2, 0, 0, 0, 1, 1, 0, 0, 2, 1, 0, 0, 0, 0, 1, 1, 0, 0, 2, 0, 2 },
			{ 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 2, 0, 0, 1, 0, 0, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 2, 0, 2, 0, 1, 1, 1, 0, 0, 1, 0, 1, 2, 0, 1, 1, 1, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 1, 0, 0, 2, 1, 0, 1, 2, 0, 0, 1, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 1, 1, 1, 0, 2, 1, 0, 1, 0, 0, 1, 1, 1 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 1, 0, 0, 2, 1, 0, 0, 0, 0, 0, 1 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 2, 0, 0, 1, 1, 0, 0, 0, 0, 1, 2, 0, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 2, 0 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 2, 0, 2, 0, 1, 1, 1, 0, 2, 1, 0, 1, 2 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 1, 0, 0, 2, 1, 0, 1 },
			{ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 1, 1, 0, 0, 2, 1, 0 } };

	/**
	 * Erstellt ein Spielfeld-Objekt.
	 */
	public SpielFeld() {
		tiger[0] = new Tiger(new Position(0, 0));
		tiger[1] = new Tiger(new Position(0, 4));
		tiger[2] = new Tiger(new Position(4, 0));
		tiger[3] = new Tiger(new Position(4, 4));

		for (int i = 0; i < ziegen.length; i++) {
			ziegen[i] = new Ziege(new Position(0, 0));
		}

		ziegenGesetzt = 0;
		ziegenGefressen = 0;
	}

	public int getZiegenGesetzt() {
		return ziegenGesetzt;
	}

	public int getZiegenGefressen() {
		return ziegenGefressen;
	}

	public Tiger[] getTiger() {
		return tiger;
	}

	public Ziege[] getZiegen() {
		return ziegen;
	}

	/**
	 *  setzteZiege setzt eine Ziege auf das Spielfeld
	 * 
	 * @param pos	ist die Position, an die eine neue Ziege gesetzt werden soll.
	 */
	public void setzteZiege(Position pos) {
		if (!validePosition(pos)) {
			throw new IllegalArgumentException("An diese Position kann keine Ziege gesetzt werden: " + pos);
		}
		for (int i = 0; i < ziegen.length; i++) {
			if (ziegen[i].tot) {
				ziegen[i].setPosition(pos);
				ziegen[i].tot = false;
				ziegenGesetzt++;
				return;
			}
		}
		throw new UnsupportedOperationException("Es wurden schon alle Ziegen gesetzt");
	}

	/**
	 * bewegeZiege setzt eine Ziege auf eine neue Position.
	 * 
	 * @param alt	ist die ursprüngliche Position auf dem die Ziege sitzt.
	 * @param neu	ist die neue Position auf die die Ziege bewegt werden soll.
	 */
	public void bewegeZiege(Position alt, Position neu) {
		if (!validePosition(neu)) {
			throw new IllegalArgumentException("An diese Position kann keine Ziege bewegt werden: " + neu);
		}
		if (!validerZug(alt, neu)) {
			throw new IllegalArgumentException("Dieser Zug ist nicht erlaubt: " + alt + " -> " + neu);
		}
		ziegen[ziegeAnPosition(alt)].setPosition(neu);
	}

	/**
	 *  ziegeAnPosition gibt für eine Position den passenden Index im Ziegenarray zurück.
	 *  Wenn auf der Position keine Ziege sitzt wird eine IllegalArgumentException geworfen.
	 * 
	 * @param pos	Die Position, an der eine Ziege sitzt.
	 * 
	 * @return		Der Index im Ziegenarray, der passenden Ziege.
	 */
	private int ziegeAnPosition(Position pos) {
		for (int i = 0; i < ziegen.length; i++) {
			if (!ziegen[i].tot && pos.equals(ziegen[i].getPosition())) {
				return i;
			}
		}
		throw new IllegalArgumentException("Keine Ziege auf dieser Position.");
	}

	/**
	 * bewegeTiger setzt einen Tiger auf eine neue Position.
	 * Das kann bei einem Tiger entweder über einen normalen Zug oder über einen Sprung geschehen.
	 * Diese Unterscheidung übernimmt diese Methode automatisch.
	 * 
	 * @param alt	ist die ursprüngliche Position auf dem der Tiger sitzt.
	 * @param neu	ist die neue Position auf die der Tiger bewegt werden soll.
	 */
	public void bewegeTiger(Position alt, Position neu) {
		boolean sprung = false;
		if (!validePosition(neu)) {
			throw new IllegalArgumentException("An diese Position kann kein Tiger bewegt werden: " + neu);
		}
		if (!validerZug(alt, neu)) {
			if (validerSprung(alt, neu)) {
				sprung = true;
			} else {
				throw new IllegalArgumentException("Dieser Zug/Sprung ist nicht erlaubt: " + alt + " -> " + neu);
			}
		}
		for (int i = 0; i < tiger.length; i++) {
			if (alt.equals(tiger[i].getPosition())) {
				tiger[i].setPosition(neu);
				if (sprung) {
					ziegen[ziegeAnPosition(positionZwischen(alt, neu))].tot = true;
					ziegenGefressen++;
				}
				return;
			}
		}
		throw new IllegalArgumentException("Keine Ziege auf dieser Position.");
	}

	/**
	 * validePosition prüft ob sich eine Postition im Spielfeld befindet und noch kein Tier auf dieser Position sitzt.
	 * 
	 * @param pos	die zu prüfende Position.
	 * 
	 * @return		true wenn valide.
	 */
	private boolean validePosition(Position pos) {
		if (pos.spalte > 4 || pos.spalte < 0 || pos.zeile > 4 || pos.zeile < 0) {
			return false;
		}
		for (int i = 0; i < tiger.length; i++) {
			if (pos.equals(tiger[i].getPosition())) {
				return false;
			}
		}
		for (int i = 0; i < ziegen.length; i++) {
			if (!ziegen[i].tot && pos.equals(ziegen[i].getPosition())) {
				return false;
			}
		}
		return true;
	}

	/**
	 *  validerZug prüft ob ein Zug mit einer Spielfigur erlaubt ist
	 * 
	 * @param alt	die ursprüngliche Position.
	 * @param neu	die neue Position.
	 * 
	 * @return		true wenn Zug erlaubt.
	 */
	private static boolean validerZug(Position alt, Position neu) {
		int u = alt.zeile * 5 + alt.spalte;
		int v = neu.zeile * 5 + neu.spalte;
		if (zuege[u][v] == 1) {
			return true;
		}
		return false;
	}

	/**
	 *  validerSprung prüft ob ein Sprung mit einem Tiger erlaubt ist
	 * 
	 * @param alt	die ursprüngliche Position.
	 * @param neu	die neue Position.
	 * 
	 * @return
	 */
	private boolean validerSprung(Position alt, Position neu) {
		int u = alt.zeile * 5 + alt.spalte;
		int v = neu.zeile * 5 + neu.spalte;
		if (zuege[u][v] == 2) {
			Position mitte = positionZwischen(alt, neu);
			for (int i = 0; i < ziegen.length; i++) {
				if (mitte.equals(ziegen[i].getPosition())) {
					return true;
				}
			}
			return false;
		}
		return false;
	}

	/**
	 *  positionZwischen gibt eine Position zwischen 2 Positionen zurück.
	 * 
	 * @param alt	die ursprüngliche Position.
	 * @param neu	die neue Position.
	 * 
	 * @return		die Position, die sich zwischen den Position alt und neu befindet.
	 */
	private static Position positionZwischen(Position alt, Position neu) {
		Position mitte = new Position();
		if (neu.zeile - alt.zeile != 0) {
			mitte.zeile = (neu.zeile + alt.zeile) / 2;
		} else {
			mitte.zeile = neu.zeile;
		}
		if (neu.spalte - alt.spalte != 0) {
			mitte.spalte = (neu.spalte + alt.spalte) / 2;
		} else {
			mitte.spalte = neu.spalte;
		}
		return mitte;
	}

	/**
	 *  tigerGefangen berechnet die Anzahl der gefangen Tiger.
	 * 
	 * @return 	die Anzahl der gefangenen Tiger.
	 */
	public int tigerGefangen() {
		int gefangen = 0;
		Position neu = new Position();
		for (int i = 0; i < tiger.length; i++) {
			int spalte = 0;
			int moeglichkeiten = 0;
			for (int j = 0; j < 25; j++) {
				if (j % 5 == 0 && j > 0) {
					spalte++;
				}
				neu.spalte = spalte;
				neu.zeile = j % 5;

				if ((validerZug(tiger[i].getPosition(), neu) || validerSprung(tiger[i].getPosition(), neu))
						&& validePosition(neu)) {
					moeglichkeiten++;
				}
			}
			if (moeglichkeiten == 0) {
				gefangen++;
			}
		}
		return gefangen;
	}
}
