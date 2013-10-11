package fr.arpinum;

import static fr.arpinum.cocoritest.Affirmations.*;

import org.junit.Before;
import org.junit.Test;

public class TestPartie {

	@Before
	public void avantChaqueTest() {
		partie = new Partie();
	}

	@Test
	public void siUnJoueurFaitTomberUneQuilleIlMarqueLaValeurDeLaQuille() {
		partie.metsAJourLePointagePourLeLancer(3);

		int pointage = partie.pointage();

		alors().le(pointage).est(3);
	}

	@Test
	public void siUnJoueurFaitTomberPlusieursQuillesIlMarqueLeNombreDeQuilles() {
		partie.metsAJourLePointagePourLeLancer(1, 2);

		int pointage = partie.pointage();

		alors().le(pointage).est(2);
	}

	@Test
	public void lePointageEstLeCumulDePlusieursLancers() {
		partie.metsAJourLePointagePourLeLancer(1);
		partie.metsAJourLePointagePourLeLancer(1);

		int pointage = partie.pointage();

		alors().le(pointage).est(2);
	}

	@Test
	public void siUnJoueurAtteint50PointsIlAGagné() {
		leJoueurMarque50Points();

		boolean gagnée = partie.gagnée();

		alors().ceci(gagnée).estVrai();
	}

	private void leJoueurMarque50Points() {
		leJoueurMarque40Points();
		partie.metsAJourLePointagePourLeLancer(10);
	}

	@Test
	public void siUnJoueurAMoinsDe50PointsIlNAPasGagné() {
		partie.metsAJourLePointagePourLeLancer(1);

		boolean gagnée = partie.gagnée();

		alors().ceci(gagnée).estFaux();
	}

	@Test
	public void siUnJoueurDépasse50PointsIlRetombeA25() {
		leJoueurMarque51Points();

		int pointage = partie.pointage();

		alors().le(pointage).est(25);
	}

	private void leJoueurMarque51Points() {
		leJoueurMarque40Points();
		partie.metsAJourLePointagePourLeLancer(11);
	}

	private void leJoueurMarque40Points() {
		for (int i = 0; i < 4; i++) {
			partie.metsAJourLePointagePourLeLancer(10);
		}
	}

	private Partie partie;
}
