package Physique;

import java.util.Vector;

import Interface.Calculateur;
import Interface.Forme;
import Interface.Milieu;
import Interface.Particule;

public class ChampElec extends Milieu {
	private Vector<Double> E;
	
	public ChampElec(Forme forme,Vector<Double> E ) {
		super(forme);
		this.E=E;}
		
	@Override
	public Vector<Double> calculAcceleration(Particule p) {
			if(this.getForme().estDedans(p))
				return Calculateur.multDblVec(((ParticuleChargee) p).getcharge()/((ParticuleChargee) p).getmasse(),E) ;

			Vector<Double> res=new Vector<Double>(2);
			res.add(0.0);
			res.add(0.0);
			return res;
		}
			
	}


