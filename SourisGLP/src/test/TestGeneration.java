package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import configuration.SimulationConfiguration;
import element.Obstacle;
import element.Source;
import element.Souris;
import map.Grille;
import process.ElementManager;



public class TestGeneration {
	private Grille grille;
	private ElementManager manager;
	
	@Before
	/*on genere un grille*/
	public void prepareGrille() {
		grille= new Grille(SimulationConfiguration.LINE_COUNT, SimulationConfiguration.COLUMN_COUNT);
		manager= new ElementManager(grille);
	}

	@Test
	/*teste si la grille est bien composee exclusivement de blocs vides*/
	public void testEmptyGrille() {
		assertNotNull(grille);
		assertNotNull(manager);
		
		for(int ligne=0;ligne<SimulationConfiguration.LINE_COUNT;ligne++) {
			for(int row=0;row<SimulationConfiguration.COLUMN_COUNT;row++) {
				assertNotNull(grille.getBlock(row, ligne));
				assertEquals("vide", grille.getBlock(row, ligne).getStatut());
			}
		}
	}
	
	@Test
	/*teste si le nombre de souris,obstacles et sources est bien celui attendu*/
	public void testDensityContentGrille() {
		
		for (int i=0;i<SimulationConfiguration.NUMBER_SOURIS;i++) {
			manager.generateSouris();
		}
		for(int i=0;i<SimulationConfiguration.NUMBER_OBSTACLE;i++) {
			manager.generateObstacle();		
		}
		for(int i=0;i<SimulationConfiguration.NUMBER_SOURCE;i++) {
			manager.generateSource();

		}
		assertEquals(SimulationConfiguration.NUMBER_SOURIS,manager.getSouris().size());
		assertEquals(SimulationConfiguration.NUMBER_OBSTACLE,manager.getObstacles().size());
		assertEquals(SimulationConfiguration.NUMBER_OBSTACLE,manager.getSources().size());

	}
	
	@Test
	/*teste si la position des souris,obstacles et sources est differente pour chacun*/
	public void testStatusContentGenerationGrille() {

		for (Iterator<Souris> it=manager.getSouris().iterator();it.hasNext();) {
			assertEquals("plein", it.next().getPosition().getStatut());
		}
		for (Iterator<Obstacle> it=manager.getObstacles().iterator();it.hasNext();) {
			assertEquals("plein", it.next().getPosition().getStatut());
		}
		for (Iterator<Source> it=manager.getSources().iterator();it.hasNext();) {
			assertEquals("plein", it.next().getPosition().getStatut());
		}
		
	}
}
