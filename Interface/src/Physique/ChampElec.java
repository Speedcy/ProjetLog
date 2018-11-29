package Physique;

import java.util.Vector;

import Interface.Calculateur;
import Interface.Forme;
import Interface.Milieu;

public class ChampElec extends Milieu {
	private Vector<Double> E;
	
	public ChampElec(Forme forme,Vector<Double> E ) {
		super(forme);
		this.E=E;}
		
	public Vector<Double> calculAcceleration(ParticuleChargee p) {
			if(this.getForme().estDedans(p))
				return Calculateur.multDblVec(p.getcharge()/p.getmasse(),E) ;
			// TODO Auto-generated constructor stub
			Vector<Double> res=new Vector<Double>(2);
			res.add(0.0);
			res.add(0.0);
			return res;
		}
		// TODO Auto-generated constructor stub
		
		
	}

