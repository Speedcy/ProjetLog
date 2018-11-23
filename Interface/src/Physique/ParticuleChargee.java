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

	@Override
	public double distance(Particule p) {
		return super.distance(p);
	}

	@Override
	public Vector<Double> acceleration(Particule p) {
		double charge1 = charge;
		double charge2 = ((ParticuleChargee) p).charge;
		double masse1 = masse;
		double masse2 = ((ParticuleChargee) p).masse;
		double kc = 8.987*Math.pow(10,9); // Constante de Coulomb
		
		Vector<Double> vecteur =new Vector<Double>(2);
		comp_x = kc*charge1*charge2*Calculateur.distance(this, p);
		
		vecteur.add(0.0);
		vecteur.add(0.0);
		return vecteur;
	}
	
	
	
	
}
