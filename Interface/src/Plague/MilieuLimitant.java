package Plague;

import java.util.Vector;

import Interface.Forme;
import Interface.Milieu;
import Interface.Particule;

public class MilieuLimitant extends Milieu{

	private Vector<Double> champ;
	
	public MilieuLimitant(Forme forme, Vector<Double> g) {
		super(forme);
		champ=g;
				}
	@Override
	public Vector<Double> calculAcceleration(Particule p){
		if(this.getForme().estDedans(p)) {
			//System.out.println(p.getPosition()+"est dedans et son champ est"+champ);
			
			return champ;}
		else {
		Vector<Double> res=new Vector<Double>(2);
		//System.out.println(p.getPosition()+"out");
		res.add(0.0);
		res.add(0.0);
		return res;
		}
	}
}
