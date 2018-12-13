package Interface;

import java.util.Vector;

public class Calculateur {

	public static double distance(Particule p1, Particule p2) {
		// Calcul la distance entre deux particules
		Vector<Double> position1 = p1.getPosition();
		Vector<Double> position2 = p2.getPosition();
		return Math.sqrt(
				Math.pow(position1.get(0) - position2.get(0), 2) + Math.pow(position1.get(1) - position2.get(1), 2));
	}

	public static Vector<Double> comp(Particule p1, Particule p2) {
		// Retourne la valeur du cosinus et du sinus de de l'angle allant de
		// l'horizonatle au vecteur reliant p1 à p2
		Vector<Double> vecteur = new Vector<Double>(2);
		Vector<Double> position1 = p1.getPosition();
		Vector<Double> position2 = p2.getPosition();
		double x = position2.get(0) - position1.get(0);
		double y = position2.get(1) - position1.get(1);
		double d = distance(p1, p2);

		try {
			if (d == 0.0)
				throw new Exception();
		} catch (Exception e) {
			System.out.println("Deux particules ont les mêmes positions : calcul impossible");
			vecteur.add(0.0);
			vecteur.add(0.0);
			return vecteur;
		}

		double cos = x / d;
		double sin = y / d;

		vecteur.add(Math.abs(cos));
		vecteur.add(Math.abs(sin));
		return vecteur;
	}
	public static double produitscalaire(Vector<Double> v1,Vector<Double> v2) {
		return v1.get(0)*v2.get(0)+v1.get(1)*v2.get(1);
	
	}
	public static Vector<Double> dif(Vector<Double> v1,Vector<Double> v2) {
		Vector<Double> vec = new Vector<Double>(2);
		vec.add(v1.get(0)-v2.get(0));
		vec.add(v1.get(1)-v2.get(1));
		
		return vec;
	}
		public static Vector<Double> somme(Vector<Double> v1,Vector<Double> v2) {
			Vector<Double> vec = new Vector<Double>(2);
			vec.add(v1.get(0)+v2.get(0));
			vec.add(v1.get(1)+v2.get(1));
			
			return vec;	
	}
	public static Vector<Double> multDblVec(double d, Vector<Double> vec){
		Vector<Double> vecres=new Vector<Double>(2);
		vecres.add(d*vec.get(0));
		vecres.add(d*vec.get(1));
		return vecres;
	}
	

}
