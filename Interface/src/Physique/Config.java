package Physique;

import java.awt.Color;
import java.util.Vector;

import Interface.DemiPlan;
import Interface.Simulateur;

public class Config {
	
	private int t_step;
	private int taillefenetrex;
	private int taillefenetrey;
	private Simulateur simulateur;
	
	public Config(int t_step, int taillefenetrex, int taillefenetrey) {
		this.t_step = t_step;
		this.taillefenetrex = taillefenetrex;
		this.taillefenetrey = taillefenetrey;
		this.simulateur = new Simulateur(t_step);
	}
	
	public void ajoutParticules(int nbparticules, double charge, double masse) {
		// Particules de vitesse nulle
		Vector<Double> vitesse = new Vector<Double>(2); 
		vitesse.add(0.0); 
		vitesse.add(0.0);
		
		for (int i = 0; i < nbparticules; i++) {
			Vector<Double> position = new Vector<Double>(2);
			position.add(Math.random()*taillefenetrex/5-taillefenetrex/10);
			position.add(Math.random()*taillefenetrey/5-taillefenetrey/10);
			double signealeatoire;
			if (Math.random()<0.5)
				signealeatoire = 1.0;
			else
				signealeatoire = -1.0;
			//System.out.println(signealeatoire);
			ParticuleChargee p = new ParticuleChargee(position, vitesse, signealeatoire*charge, masse);
			simulateur.addParticule(p);
			if (signealeatoire<0)
				p.setColor(Color.red);
		}
	}
	
	public void ajoutUnitaire(Vector<Double> position, Vector<Double> vitesse, double charge, double masse) {
		ParticuleChargee p = new ParticuleChargee(position, vitesse, charge, masse);
		simulateur.addParticule(p);
	}
	
	public void ajoutUnitaire(ParticuleChargee p) {
		simulateur.addParticule(p);
	}
	
	public void ajoutChampGravite(double x_point, double y_point, double x_vect, double y_vect, double x_champ, double y_champ) {
		Vector<Double> point= new Vector<Double>(2);
		point.add(x_point);
		point.add(y_point);
		Vector<Double> vec= new Vector<Double>(2);
		vec.add(x_vect);
		vec.add(y_vect);
		DemiPlan dp=new DemiPlan(point,vec);
		
		Vector<Double> g= new Vector<Double>(2);
		g.add(x_champ);
		g.add(y_champ);
		ChampGravite cg= new ChampGravite(dp,g);
		simulateur.addMilieu(cg);
	}
	
	public void ajoutChampElec(double x_point, double y_point, double x_vect, double y_vect, double x_champ, double y_champ) {
		Vector<Double> point= new Vector<Double>(2);
		point.add(x_point);
		point.add(y_point);
		Vector<Double> vec= new Vector<Double>(2);
		vec.add(x_vect);
		vec.add(y_vect);
		DemiPlan dp=new DemiPlan(point,vec);
		
		Vector<Double> e= new Vector<Double>(2);
		e.add(x_champ);
		e.add(y_champ);
		ChampElec ce= new ChampElec(dp,e);
		simulateur.addMilieu(ce);
	}

	public int getTaillefenetrex() {
		return taillefenetrex;
	}

	public int getTaillefenetrey() {
		return taillefenetrey;
	}

	public Simulateur getSimulateur() {
		return simulateur;
	}

	public int getT_step() {
		return t_step;
	}
	
	
	
	
	
	
	
	

}
