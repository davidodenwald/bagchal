/**
 * View ist die Klasse für alle Ausgaben auf dem Terminal.
 */
public class View {

	private SpielFeld spiel;
	
	/**
	 * Erstellt ein View-Objekt.
	 * 
	 * @param spiel	Das Spielfeld auf dem gespielt wird.
	 */
	public View(SpielFeld spiel) {
		this.spiel = spiel;
	}

	/** 
	 * anzeigen gibt das aktuelle Spielfeld auf dem Bildschirm aus.
	 */
	public void zeigeSpielfeld() {
		String[] pfade = { "|\\|/|\\|/|", "|/|\\|/|\\|" };
		Position position = new Position();

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				position.zeile = i;
				position.spalte = j;

				// Prüfen ob an der aktuellen Position ein Tiger sitzt
				boolean tierGefunden = false;
				for (int t = 0; t < spiel.getTiger().length; t++) {
					if (position.equals(spiel.getTiger()[t].getPosition())) {
						System.out.print("T");
						tierGefunden = true;
					}
				}

				// Prüfen ob an der aktuellen Position eine Ziege sitzt
				for (int z = 0; z < spiel.getZiegen().length; z++) {
					if (!spiel.getZiegen()[z].tot && position.equals(spiel.getZiegen()[z].getPosition())) {
						System.out.print("Z");
						tierGefunden = true;
					}
				}
				// leeres Feld anzeigen wenn kein Tier an der Stelle sitzt
				if (!tierGefunden) {
					System.out.print("+");
				}

				// Striche werden zwischen dem ersten und letzen
				// Element gezeichnet
				if (j < 4) {
					System.out.print("-");
				}
			}
			// Pfade werden nach der letzten Zeile nich ausgegeben
			if (i < 4) {
				System.out.println("\n" + pfade[i % 2]);
			}
		}
		System.out.println();
	}

	/**
	 *  zeigeError gibt einer Exception auf dem Bildschirm aus.
	 * 
	 * @param e	ist eine Exception, deren Text ausgegeben wird.
	 */
	public static void zeigeError(Exception e) {
		System.out.println("ERROR: " + e.getMessage());
	}

	/**
	 *  zeigeSpieler gibt auf dem Bildschirm aus, welcher Spieler gerade am Zug ist.
	 * 
	 * @param spieler	wenn true ist die Ziege dran, wenn false der Tiger.
	 */
	public static void zeigeSpieler(Boolean spieler) {
		if (spieler) {
			System.out.println("Ziege ist am Zug");
		} else {
			System.out.println("Tiger ist am Zug");
		}
	}

	/** 
	 * zeigeSpielInfo gibt die Anzahl der gesetzten und gefessenen Ziegen auf dem Bildschirm aus.
	 */
	public void zeigeSpielInfo() {
		System.out.println("Anzahl gefressener Ziegen : " + spiel.getZiegenGefressen());
		System.out.println("Anzahl zu setzender Ziegen : " + (20 - spiel.getZiegenGesetzt()));
		System.out.println("Anzahl gefangener Tiger : " + spiel.tigerGefangen());
	}

	/**
	 *  ziegeVerloren gibt einen Text auf dem Bildschirm aus wenn der Spieler Ziege verloren hat.
	 */
	public static void ziegeVerloren() {
		System.out.println("\nEs wurden 5 Ziegen gefressen!\n Spieler Tiger hat gewonnen!");
	}

	/**
	 *  tigerVerloren gibt einen Text auf dem Bildschirm aus wenn der Spieler Ziege verloren hat.
	 */
	public static void tigerVerloren() {
		System.out.println("\nEs wurden alle Tiger gefangen!\n Spieler Ziege hat gewonnen!");
	}
}
