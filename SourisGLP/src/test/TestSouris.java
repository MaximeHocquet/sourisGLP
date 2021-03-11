package test;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import configuration.SimulationConfiguration;
import element.Souris;
import map.Grille;
import process.ElementManager;



public class TestSouris {
	private Grille grille;
	private ElementManager manager;
	
	@Before
	/*on genere un grille*/
	public void prepareGrille() {
		grille= new Grille(SimulationConfiguration.LINE_COUNT, SimulationConfiguration.COLUMN_COUNT);
		manager= new ElementManager(grille);
	}

	@Test
	/*teste si le sexe est bien attribue aux souris*/
	public void testSexSouris() {
		
		for (int i=0;i<SimulationConfiguration.NUMBER_SOURIS;i++) {
			manager.generateSouris();
		}
		for (Iterator<Souris> it=manager.getSouris().iterator();it.hasNext();) {
			Souris souris=it.next();
			if(souris.getSexe()!="male") {
					assertEquals("femele", souris.getSexe());
			}
			else {
				assertEquals("male", souris.getSexe());
			}
		}
		
	}
	
}