package Interface;

import java.util.Vector;

public class Calculateur {
	
	public static double distance(Particule p1, Particule p2) {
		// Calcul la distance entre deux particules
		Vector<Double> position1 = p1.getPosition();
		Vector<Double> position2 = p2.getPosition();
		return Math.sqrt(Math.pow(position1.get(0)-position2.get(0), 2)+Math.pow(position1.get(1)-position2.get(1), 2));
	}
	
	public static Vector<Double> vecteurDirecteur(Particule p1, Particule p2){
		// Vecteur directeur allant de la particule 2 à la particule 1
		Vector<Double> vecteur =new Vector<Double>(2);
		Vector<Double> position1 = p1.getPosition();
		Vector<Double> position2 = p2.getPosition();
		double x = position1.get(0)-position2.get(0);
		double y = position1.get(1)-position2.get(1);
		vecteur.add(x);
		vecteur.add(y);
		return vecteur;
	}
	
	public static Vector<Double> comp(Particule p1, Particule p2) {
		// Retourne la valeur du cosinus et du sinus de de l'angle allant de l'horizonatle au vecteur reliant p1 à p2
		Vector<Double> vecteur =new Vector<Double>(2);
		Vector<Double> position1 = p1.getPosition();
		Vector<Double> position2 = p2.getPosition();
		double x = position1.get(0)-position2.get(0);
		double y = position1.get(1)-position2.get(1);
		double d = distance(p1,p2);
		
		try {
			if(d==0.0)
				throw new Exception();
		}
		catch(Exception e) {
			System.out.println("Deux particules ont les mêmes positions : calcul impossible");
			vecteur.add(0.0);
			vecteur.add(0.0);
			return vecteur;
		}
		
		double cos = y/d;
		double sin = x/d;
		
		vecteur.add(cos);
		vecteur.add(sin);
		return vecteur;
	}

}
