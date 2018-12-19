package Plague;

import java.util.Vector;

import Interface.Forme;
import Interface.FormeTout;
import Interface.Milieu;
import Interface.Particule;

public class Monde extends Milieu {
	
	public Monde(Forme forme) {
		super(forme);
	}

	public Vector<Double> calculAcceleration(Particule p) {
		Vector<Double> res=new Vector<Double>(2);
		res.add(Math.random()-0.5);
		res.add(Math.random()-0.5);
		return res;
	}

}
