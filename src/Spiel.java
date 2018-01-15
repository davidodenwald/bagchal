import java.util.Scanner;

public class Spiel {

	public static void main(String[] args) {
		boolean SpielerZiege = true;

		SpielFeld s = new SpielFeld();
<<<<<<< HEAD
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
=======
		Scanner input = new Scanner(System.in);
		while (true) {
			if (SpielerZiege) {
				System.out.println("Ziege ist am Zug");
			} else {
				System.out.println("Tiger ist am Zug");
			}
			s.anzeigen();

			System.out.println("Anzahl gefressener Ziegen : " + s.getZiegenGefressen());
			System.out.println("Anzahl zu setzender Ziegen : " + (20 - s.getZiegenGesetzt()));
>>>>>>> 0eb051b6aaa244cd9959ab7ea8e73be0dfccdc08

			if (SpielerZiege && s.getZiegenGesetzt() < 20) {
				System.out.print("Zeile (Ziel): ");
				int zeile = input.nextInt();
				System.out.print("Spalte (Ziel): ");
				int spalte = input.nextInt();

				try {
					s.setzteZiege(new Position(zeile, spalte));
					SpielerZiege = !SpielerZiege;
				} catch (Exception e) {
<<<<<<< HEAD
					View.zeigeError(e);
=======
					System.out.print(e + "\n");
>>>>>>> 0eb051b6aaa244cd9959ab7ea8e73be0dfccdc08
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
<<<<<<< HEAD
					View.zeigeError(e);
				}
			}
			view.zeigeSpielInfo();
		}
		input.close();
=======
					System.out.print(e + "\n");
				}
			}
		}
>>>>>>> 0eb051b6aaa244cd9959ab7ea8e73be0dfccdc08
	}
}
