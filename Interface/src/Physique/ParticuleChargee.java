package Physique;

import java.util.Vector;

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
	public Vector acceleration(Particule p) {
		double charge1 = charge;
		double charge2 = ((ParticuleChargee) p).charge;
		double masse1 = masse;
		double masse2 = ((ParticuleChargee) p).masse;
		
		return charge1*charge2;
		
	}
	
	
	
	
}
