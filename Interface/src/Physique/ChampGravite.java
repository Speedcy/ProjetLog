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
	@Override
	public Vector<Double> calculAcceleration(Particule p){
		//System.out.println(this.getForme().estDedans(p));
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
	@Override
	public String toString() {
		return "ChampGravite [champ=" + champ + ", toString()=" + super.toString() + ", getForme()=" + getForme()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}
	

}
