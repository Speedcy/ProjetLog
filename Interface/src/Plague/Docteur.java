package Plague;

import java.awt.Color;
import java.util.Vector;

import Interface.Calculateur;
import Interface.Particule;

public class Docteur extends Personne{
	
	public Docteur(Vector<Double> p, Vector<Double> v,double pk) {
		super(p, v, true,pk);
		this.setColor(Color.CYAN);
	}
	
	public Vector<Double> calculAcceleration(Particule p) {
		//System.out.println("Acceleration docteur");
		boolean sante2 = true;
		try {
			sante2 = ((Personne) p).isSante();
		
		} catch (Exception e) {
			System.out.println("Particules de types différents : intérraction non prise en charge");
		}
		
		if (!sante2) {
			double dis;
			dis=Calculateur.distance(this, p);
			if(dis<30) {
				((Personne)p).setSante(true);
				p.setColor(Color.blue);
			}
		}
		Vector<Double> vecr=new Vector<Double>(4);
		vecr.add(0.0);
		vecr.add(0.0);
		vecr.add(0.0);
		vecr.add(0.0);
		return vecr;
	}
}