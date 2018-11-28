package Interface;

import java.util.Vector;

public class DemiPlan extends Forme{
	private Vector<Double> point;
	private Vector<Double> vecteur;
	
	public DemiPlan(Vector<Double> point,Vector<Double> vecteur) {
		super();
		this.point=point;
		this.vecteur=vecteur;
		// TODO Auto-generated constructor stub
	}

	public boolean estDedans(Particule p) {
		Vector<Double> placementParticule=Calculateur.dif(p.getPosition(),point);
		return Calculateur.produitscalaire(placementParticule,vecteur)>0;
		
	}

}
