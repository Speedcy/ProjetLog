package Interface;

import java.util.Vector;

public class Intersection extends Forme{
	private Vector<Forme> listeformes = new Vector<Forme>();
	
	public void addForm(Forme forme){
		listeformes.add(forme);
	}
	public boolean estDedans(Particule p) {
		for (Forme uneforme : listeformes)
		{	
			if(!uneforme.estDedans(p)){
				return false;
				
		}
		}
		return true;
	}
	
	
	
	
	

}
