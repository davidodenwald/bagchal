/**
 * Position ist ein Objekt mit x und y Variablen.
 * Kann genutzt werden um eine Position auf einem Spielfeld darzustellen.
 */
public class Position {
	public int zeile;
	public int spalte;

	/**
	 * Erstellt ein Positions-Objekt, mit den Werten (0, 0)
	 */
	public Position() {
		zeile = 0;
		spalte = 0;
	}

	/**
	 * Erstellt ein Positions-Objekt mit übergebenen Werten.
	 * 
	 * @param zeile		die Zeile, in der sich die Position befindet.
	 * @param spalte		die Spalte, in der sich die Position befindet.
	 */
	public Position(int zeile, int spalte) {
		this.zeile = zeile;
		this.spalte = spalte;
	}

	
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "(Zeile: " + zeile + ", Spalte: " + spalte + ")";
	}

	
	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (spalte != other.spalte)
			return false;
		if (zeile != other.zeile)
			return false;
		return true;
	}

}
