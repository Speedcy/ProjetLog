package Interface;

import java.util.Vector;

public class Calculateur {
	
	public static double distance(Particule p1, Particule p2) {
		// Calcul la distance entre deux particules
		Vector<Double> position1 = p1.getPosition();
		Vector<Double> position2 = p2.getPosition();
		return Math.sqrt(Math.pow(position1.get(0)-position2.get(0), 2)+Math.pow(position1.get(1)-position2.get(1), 2));
	}
	
	public static Vector<Double> comp(Particule p1, Particule p2) {
		// Calcul la composante
		Vector<Double> vecteur =new Vector<Double>(2);
		Vector<Double> position1 = p1.getPosition();
		Vector<Double> position2 = p2.getPosition();
		double x = position1.get(0)-position2.get(0);
		double y = position1.get(1)-position2.get(1);
		double cos = y/distance(p1,p2);
		double sin = x/distance(p1,p2);
		vecteur.add(cos);
		vecteur.add(sin);
		return vecteur;
	}

}
