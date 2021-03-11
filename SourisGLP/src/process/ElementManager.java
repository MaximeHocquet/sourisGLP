package process;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import configuration.SimulationConfiguration;
import element.Communication;
import element.Comportement;
import element.Diffuser;
import element.Obstacle;
import element.Receptionner;
import element.Sociabilite;
import element.Source;
import element.Souris;
import map.Block;
import map.Grille;

public class ElementManager {
	private Grille grille;
	
	private ArrayList<Souris> souris= new ArrayList<Souris>();
	private ArrayList<Obstacle> obstacles= new ArrayList<Obstacle>();
	private ArrayList<Source> sources= new ArrayList<Source>();

	public ElementManager(Grille grille) {
		this.grille = grille;
	}
	
	/*add element*/
	public void add(Souris souris) {
		this.souris.add(souris);
	}
	public void add(Obstacle obstacle) {
		this.obstacles.add(obstacle);
	}
	public void add(Source source) {
		this.sources.add(source);
	}
	
	/*remove element*/
	public void remove(Souris souris){
		this.souris.remove(souris);
	}
	public void remove(Obstacle obstacle){
		this.obstacles.remove(obstacle);
	}
	public void remove(Source source){
		this.sources.remove(source);
	}
	
	/*generate element*/
	public void generateSouris() {
		Block position=generatePosition(SimulationConfiguration.COLUMN_COUNT-1,SimulationConfiguration.LINE_COUNT-1);
	
		if(position!=null) {
			Souris souris = new Souris(position,generateSourisSexe(), generateSourisComportement(), SimulationConfiguration.MAX_SOURIS_NOURRITURE,null);
			add(souris);
		}
	}
	public void generateObstacle() {
		Block position= generatePosition(SimulationConfiguration.COLUMN_COUNT-1,SimulationConfiguration.LINE_COUNT-1);
		
		if(position!=null) {
			Obstacle obstacle= new Obstacle(position,generateStatutObstacle());
			add(obstacle);
		}
		
	}
	public void generateSource() {
		Block position= generatePosition(SimulationConfiguration.COLUMN_COUNT-1,SimulationConfiguration.LINE_COUNT-1);
		
		if(position!=null) {
			Source source = new Source(position, generateSourceContent());
			add(source);
		}
	}
	/*next round*/
	public void nextRound() {
		removeSourisNourritureTours();
		addSourisNourritureTours();
		randomMoveAllSouris();
	}
	
	/*methods about souris*/
		/*all souris move*/
		public void randomMoveAllSouris() {
			for(Iterator<Souris> it=souris.iterator();it.hasNext();) {
				Souris souris=it.next();
				
				moveDirectionSouris(souris);
			}
		}
	
		/*souris move*/
		public void moveDirectionSouris(Souris souris) {
			Random random=new Random();
			int randInt=(int)random.nextInt(4);
			
			switch(randInt) {
			case 0:
				moveLeftSouris(souris);
				break;
			case 1:
				moveRightSouris(souris);
				break;
			case 2:
				moveTopSouris(souris);
				break;
			case 3:
				moveBottomSouris(souris);
				break;
			}
		}
		public void moveLeftSouris(Souris souris) {
			Block position=souris.getPosition();
			
			if (position.getColonne() > 0) {
				Block newPosition = grille.getBlock(position.getLigne(), position.getColonne() - 1);
				
				if(newPosition.getStatut().equals("vide")) {
					souris.setPosition(newPosition);
				}
			}
		}
		
		public void moveRightSouris(Souris souris) {
			Block position = souris.getPosition();
	
			if (position.getColonne() < SimulationConfiguration.COLUMN_COUNT - 1) {
				Block newPosition = grille.getBlock(position.getLigne(), position.getColonne() + 1);
				
				if(newPosition.getStatut().equals("vide")) {
					souris.setPosition(newPosition);
				}
			}
		}
		public void moveTopSouris(Souris souris) {
			Block position=souris.getPosition();
			
			if (position.getLigne() > 0) {
				Block newPosition = grille.getBlock(position.getLigne() - 1, position.getColonne());
				
				if(newPosition.getStatut().equals("vide")) {
					souris.setPosition(newPosition);
				}
			}
		}
		
		public void moveBottomSouris(Souris souris) {
			Block position = souris.getPosition();
	
			if (position.getLigne() < SimulationConfiguration.LINE_COUNT - 1) {
				Block newPosition = grille.getBlock(position.getLigne() + 1, position.getColonne());
				
				if(newPosition.getStatut().equals("vide")) {
					souris.setPosition(newPosition);
				}
			}
		}
		
		/*generate souris sexe*/
		public String generateSourisSexe() {
			int randInt=randomPercentage();
			if(randInt<50) {
				return "male";
			}
			else {
				return "femele";
			}
		}
		/*generate souris comportement*/
		public Comportement generateSourisComportement() {
			
			return new Comportement(generateSourisCommunication(),generateSourisSociabilite());
			
		}
		public Sociabilite generateSourisSociabilite() {
			return new Sociabilite(randomPercentage());
			
		}
		public Communication generateSourisCommunication() {
			return new Communication(generateSourisDiffuser(),generateSourisReceptionner());
		}
		public Diffuser generateSourisDiffuser() {
			int randInt=randomPercentage();
			if(randInt<50) {
				return new Diffuser("egoiste");
			}
			else {
				return new Diffuser("cooperative");
			}
		}
		public Receptionner generateSourisReceptionner() {
			int randInt=randomPercentage();
			if(randInt<50) {
				return new Receptionner("nihiliste");
			}
			else {
				return new Receptionner("receptive");
			}
		}
		
		/*nourriture souris*/
 		public void removeSourisNourritureContent(Souris souris) {	
 			int nourriture=souris.getNourriture();
 			if(nourriture>0) {
 				souris.setNourriture(nourriture-1);
 			}
		}
		public void removeSourisNourritureTours() {
			for (Iterator<Souris> it=souris.iterator();it.hasNext();) {
				Souris souris=it.next();
				
				obstaclePiege(souris);
				removeSourisNourritureContent(souris);
				if(souris.getNourriture()==0) {
					souris.getPosition().setStatut("vide");
					it.remove();
				}
			}
		}
		
		public void addSourisNourritureContent(Souris souris){
			int nourriture=souris.getNourriture();
			
			for (Iterator<Source> it=sources.iterator();it.hasNext();) {
				Source source=it.next();
				
				if(isInArea(souris,source.getPosition())) {
					if(nourriture<SimulationConfiguration.MAX_SOURIS_NOURRITURE) {
		 				souris.setNourriture(nourriture+1);
		 				removeSourceContent(source);
		 				if(source.getNourriture()==0) {
		 					source.getPosition().setStatut("vide");
							it.remove();
						}
		 			}
				}
			}
		}
		public void addSourisNourritureTours() {
			for (Iterator<Souris> it=souris.iterator();it.hasNext();) {
				Souris souris=it.next();
				
				addSourisNourritureContent(souris);
			}
		}
		/*remove souris*/
		public void removeSouris(Block position) {
			for (Iterator<Souris> it=souris.iterator();it.hasNext();) {
				Souris souris=it.next();
				if(souris.getPosition().equals(position)) {
					it.remove();
				}
			}
		}
		
		/*find souris area*/
		public boolean isInArea(Souris souris,Block position) {
			int ligne=souris.getPosition().getLigne();
			int colonne=souris.getPosition().getColonne();
			
			for(int l=0;l<3;l++) {
				if(position.getLigne()==(ligne-1+l)) {
					for(int r=0;r<3;r++) {
						if(position.getColonne()==(colonne-1+r)) {
							return true;
						}
					}
				}
			}
			return false;
		}
	/*methods about obstacle*/
		/*generate obstacle*/
		public String generateStatutObstacle() {
			int randInt=randomPercentage();
			if(randInt<50) {
				return "murs";
			}
			else {
				return "piege";
			}
		}
		public void obstaclePiege(Souris souris) {
			for (Iterator<Obstacle> it=obstacles.iterator();it.hasNext();) {
				Obstacle obstacle=it.next();
				
				if(isInArea(souris,obstacle.getPosition())) {
					removeSourisNourritureContent(souris);
				}
			}
		}
	/*source methods*/
		/*generate source content*/
		public int generateSourceContent() {
			Random random=new Random();
			return(int)random.nextInt(SimulationConfiguration.SOURCE_CONTENT);
		}
		
		public void removeSourceContent(Source source) {
			int nourriture=source.getNourriture();
 			if(nourriture>0) {
 				source.setNourriture(nourriture-1);
 			}
		}
		/*public void removeSourceNourritureTours() {
			for (Iterator<Source> it=sources.iterator();it.hasNext();) {
				Source source=it.next();
				if(source.getNourriture()==0) {
					it.remove();
				}
			}
		}*/
		
	/*position*/
		/*generate random not full position */
		public int randomColonne(int maxColonne) {
			return (int) (Math.random()*(maxColonne+1));
		}
		
		public int randomLigne(int maxLigne) {
			return (int) (Math.random()*(maxLigne+1));
		}
		
		public Block generatePosition(int maxLigne, int maxColonne) {	
			int colonne= randomColonne(maxColonne);
			int ligne= randomLigne(maxLigne);
		
			Block position= grille.getBlock(ligne, colonne);
			if(position.getStatut().equals("vide")) {
				position.setStatut("plein");
				return position;
			}
			else{
				while(position.getStatut().equals("plein")){
					colonne= randomColonne(maxColonne);
					ligne= randomLigne(maxLigne);
				
					position= grille.getBlock(ligne, colonne);
				}
				position.setStatut("plein");
				return position;
			}
		}
	
	/*getters*/
	public ArrayList<Souris> getSouris() {
		return souris;
	}

	public ArrayList<Obstacle> getObstacles() {
		return obstacles;
	}

	public ArrayList<Source> getSources() {
		return sources;
	}
	/*generate random percentage*/
	public int randomPercentage() {
		return (int) (Math.random()*100);
	}
}
