package Physique;

import java.util.Vector;

import Interface.Calculateur;
import Interface.Particule;

public class ParticuleChargee extends Particule{
	private double charge;
	private double masse;

	public ParticuleChargee(Vector<Double> p, Vector<Double> v, double c, double m) {
		super(p,v);
		charge = c;
		masse = m;
	}

	@Override
	public String toString() {
		return super.toString()+"Masse" + masse+"Charge" + charge;
	}

	/*@Override
	public double distance(Particule p) {
		return super.distance(p);
	}*/

	@Override
	public Vector<Double> acceleration(Particule p) {
		// NE PREND EN COMPTE QUE L'INTERRACTION ELEC POUR L'INSTANT
		// La force c'est la meme mais pour l'acceleration ?
		double charge1 = charge;
		double masse1 = masse;
		double charge2 = 0.0;
		double masse2 = 0.0;
		double kc = 8.987*Math.pow(10,9); // Constante de Coulomb
		try {
			charge2 = ((ParticuleChargee) p).charge;
			masse2 = ((ParticuleChargee) p).masse;
		}
		catch(Exception e) {System.out.println("Particules de types différents : intérraction non prise en charge");}
		
		System.out.println(charge1);
		System.out.println(charge2);
		
		Vector<Double> vecteur =new Vector<Double>(2);
		vecteur = Calculateur.comp(this, p);
		double comp_x = kc*charge1*charge2*(vecteur.get(0));
		double comp_y = kc*charge1*charge2*(vecteur.get(1));
		
		System.out.println(comp_x);
		System.out.println(comp_y);
		
		vecteur.add(comp_x);
		vecteur.add(comp_y);
		return vecteur;
	}
}
