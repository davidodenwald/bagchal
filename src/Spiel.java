import java.util.Scanner;

/**
 * Spiel ist der Controller, in dem der Spielablauf implementiert ist.
 */
public class Spiel {
	
	/**
	 * main regelt den Spielablauf.
	 * 
	 * @param args	wird nicht verwendet!
	 */
	public static void main(String[] args) {
		boolean SpielerZiege = true;

		SpielFeld s = new SpielFeld();
		View view = new View(s);

		Scanner input = new Scanner(System.in);

		while (true) {
			View.zeigeSpieler(SpielerZiege);
			view.zeigeSpielfeld();

			if (s.tigerGefangen() == 4) {
				View.tigerVerloren();
				break;
			}

			if (s.getZiegenGefressen() > 4) {
				View.ziegeVerloren();
				break;
			}

			if (SpielerZiege && s.getZiegenGesetzt() < 20) {
				System.out.print("Zeile (Ziel): ");
				int zeile = input.nextInt();
				System.out.print("Spalte (Ziel): ");
				int spalte = input.nextInt();

				try {
					s.setzteZiege(new Position(zeile, spalte));
					SpielerZiege = !SpielerZiege;
				} catch (Exception e) {
					View.zeigeError(e);
					System.out.print(e + "\n");
				}
			} else {
				System.out.print("Zeile (Start): ");
				int altZeile = input.nextInt();
				System.out.print("Spalte (Start): ");
				int altSpalte = input.nextInt();
				System.out.print("Zeile (Ziel): ");
				int neuZeile = input.nextInt();
				System.out.print("Spalte (Ziel): ");
				int neuSpalte = input.nextInt();

				try {
					if (SpielerZiege) {
						s.bewegeZiege(new Position(altZeile, altSpalte), new Position(neuZeile, neuSpalte));
					} else {
						s.bewegeTiger(new Position(altZeile, altSpalte), new Position(neuZeile, neuSpalte));
					}
					SpielerZiege = !SpielerZiege;
				} catch (Exception e) {
					View.zeigeError(e);
				}
			}
			view.zeigeSpielInfo();
		}
		input.close();
	}
}
