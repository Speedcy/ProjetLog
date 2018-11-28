package Physique;

import java.util.Vector;

import Interface.Calculateur;
import Interface.Particule;

public class ParticuleChargee extends Particule {
	private double charge;
	private double masse;

	public ParticuleChargee(Vector<Double> p, Vector<Double> v, double c, double m) {
		super(p, v);
		charge = c;
		masse = m;
	}

	@Override
	public String toString() {
		return super.toString() + "Masse" + masse + "Charge" + charge;
	}

	/*
	 * @Override public double distance(Particule p) { return super.distance(p); }
	 */

	public Vector<Double> force(Particule p) {
		// NE PREND EN COMPTE QUE L'INTERRACTION ELEC POUR L'INSTANT
		// La force c'est la meme mais pour l'acceleration ?
		double charge1 = charge;
		double masse1 = masse;
		double charge2 = 0.0;
		double masse2 = 0.0;
		double kc = 8.987 * Math.pow(10, 9); // Constante de Coulomb
		double g = 6.674 * Math.pow(10, -11); // Constante gravitationelle

		try {
			charge2 = ((ParticuleChargee) p).charge;
			masse2 = ((ParticuleChargee) p).masse;
		} catch (Exception e) {
			System.out.println("Particules de types différents : intérraction non prise en charge");
		}

		System.out.println(charge1);
		System.out.println(charge2);

		Vector<Double> vecteur = new Vector<Double>(2);
		vecteur = Calculateur.comp(this, p); // vecteur contenant la valeur du cosinus et du sinus de l'angle
		double distanceCarree = Math.pow(Calculateur.distance(this, p), 2);
		double cosReduit = (vecteur.get(0)) / distanceCarree;
		double sinReduit = (vecteur.get(1)) / distanceCarree;

		System.out.println("1 = " + (Math.pow(vecteur.get(0), 2) + Math.pow(vecteur.get(1), 2)));

		// Composantes de la force électrique
		double comp_xc = -kc * charge1 * charge2 * cosReduit;
		double comp_yc = -kc * charge1 * charge2 * sinReduit;

		System.out.println("Comp_x Elec = " + comp_xc);
		System.out.println("Comp_y Elec = " + comp_yc);

		// Composantes de la force gravitationelle
		double comp_xm = g * masse1 * masse2 * cosReduit;
		double comp_ym = g * masse1 * masse2 * sinReduit;

		System.out.println("Comp_x Grav = " + comp_xm);
		System.out.println("Comp_y Grav = " + comp_ym);

		Vector<Double> forceResultante = new Vector<Double>(2);
		forceResultante.add(comp_xc + comp_xm);
		forceResultante.add(comp_yc + comp_ym);
		return forceResultante;
	}

	public Vector<Double> acceleration(Particule p, Vector<Double> force) {
		// Donne l'accélération de la particule courante par rapport à la particule p
		double m = masse;

		Vector<Double> position1 = new Vector<Double>(2);
		position1 = this.getPosition();
		double p1x = position1.get(0);
		double p1y = position1.get(1);

		Vector<Double> position2 = new Vector<Double>(2);
		position2 = p.getPosition();
		double p2x = position2.get(0);
		double p2y = position2.get(1);

		Vector<Double> vect_acc = new Vector<Double>(2);

		if (p1x < p2x)
			vect_acc.add(force.get(0) / m);
		else
			vect_acc.add(-force.get(0) / m);

		if (p1y < p2y)
			vect_acc.add(force.get(1) / m);
		else
			vect_acc.add(-force.get(1) / m);

		return vect_acc;
	}
	
	public Vector<Double> calculAcceleration(ParticuleChargee p) {
		// renvoie les accélérations courante/p et p/courante
		 Vector<Double> force =new Vector<Double>(2);
		 force = this.force(p);
		 System.out.println("Force" + force);
		 
		 Vector<Double> acc =new Vector<Double>(2);
		 acc = this.acceleration(p,force); // acceleration de 21
		 System.out.println("Acc p/Courante" + acc);
		 
		 Vector<Double> acc12 =new Vector<Double>(2); 
		 acc12 = p.acceleration(this,force);
		 System.out.println("Acc Courante/p" + acc12);
		 
		 acc.add(acc12.get(0));
		 acc.add(acc12.get(1));
		
		 return acc;
	}
}
