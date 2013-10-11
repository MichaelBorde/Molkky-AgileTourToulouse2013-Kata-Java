package fr.arpinum;

public class Partie {

	public void metsAJourLePointagePourLeLancer(int... quilles) {
		pointage += uneSeuleQuilleTombée(quilles) ? valeurQuilleTombée(quilles) : nombreQuillesTombées(quilles);
		siLePointageDépasse50IlRetombeA25();
	}

	private void siLePointageDépasse50IlRetombeA25() {
		if (pointage > 50) {
			pointage = 25;
		}
	}

	private int nombreQuillesTombées(int[] quilles) {
		return quilles.length;
	}

	private int valeurQuilleTombée(int[] quilles) {
		return quilles[0];
	}

	private boolean uneSeuleQuilleTombée(int[] quilles) {
		return nombreQuillesTombées(quilles) == 1;
	}

	public int pointage() {
		return pointage;
	}

	public boolean gagnée() {
		return pointage == 50;
	}

	private int pointage;
}
