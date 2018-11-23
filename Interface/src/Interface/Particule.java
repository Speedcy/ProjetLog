package Interface;

import java.util.Vector;

public class Particule {
	private Vector<Double> position;
	private Vector<Double>	vitesse;
	
	public Particule(Vector<Double> p, Vector<Double> v){
		position=p;
		vitesse=v;
	}

	@Override
	public String toString() {
		return "Particule [position=" + position + ", vitesse=" + vitesse + "]";
	}
	
	public Vector<Double> getPosition() {
		return position;
	}

	public Vector<Double> getVitesse() {
		return vitesse;
	}

	// Voir distance dans la classe Calculateur (méthode static)
	/*public double distance(Particule p) {
		Vector<Double> position1 = position;
		Vector<Double> position2 = p.position;
		return Math.sqrt(Math.pow(position1.get(0)-position2.get(0), 2)+Math.pow(position1.get(1)-position2.get(1), 2));
	}*/
	
	public Vector<Double> acceleration(Particule p) {
		Vector<Double> vecteur =new Vector<Double>(2);
		vecteur.add(0.0);
		vecteur.add(0.0);
		return vecteur;
	}

}
