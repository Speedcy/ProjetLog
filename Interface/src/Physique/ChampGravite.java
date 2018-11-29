package Physique;

import java.util.Vector;

import Interface.Calculateur;
import Interface.Forme;
import Interface.Milieu;
import Interface.Particule;

public class ChampGravite extends Milieu {
	private Vector<Double> champ;
	public ChampGravite(Forme forme, Vector<Double> g) {
		super(forme);
		champ=g;
				}
	public Vector<Double> calculAcceleration(ParticuleChargee p){
		if(this.getForme().estDedans(p))
			return Calculateur.multDblVec(p.getmasse(),champ);
		// TODO Auto-generated constructor stub
		Vector<Double> res=new Vector<Double>(2);
		res.add(0.0);
		res.add(0.0);
		return res;
	}
	

}
