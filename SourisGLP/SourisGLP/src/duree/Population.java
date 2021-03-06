package duree;

import java.util.ArrayList;
import java.util.Iterator;

import element.Souris;
public class Population {
	private ArrayList<Souris> souris;
	
	public Population(ArrayList<Souris> souris) {
		this.souris=souris;
	}
	public void add(Souris souris) {
		this.souris.add(souris);
	}
	public void remove() {
		this.souris.remove(1);
	}
	public int index() {
		int  i=0;
		for(Iterator<Souris> it=souris.iterator();it.hasNext();) {
			i++;
		}
		return i;
	}
}
