package Plague;

import java.awt.Color;
import java.util.Vector;

import Interface.DemiPlan;
import Interface.Particule;
import Interface.Simulateur;

public class Config2 {
	
	private int t_step;
	private int taillefenetrex;
	private int taillefenetrey;
	private Simulateur simulateur;
	
	public Config2(int t_step, int taillefenetrex, int taillefenetrey) {
		this.t_step = t_step;
		this.taillefenetrex = taillefenetrex;
		this.taillefenetrey = taillefenetrey;
		this.simulateur = new Simulateur(t_step);
	}
	
	
		
	public void ajoutePersonne(int nbparticules,double pk) {
		// Particules de vitesse nulle
		Vector<Double> vitesse = new Vector<Double>(2); 
		vitesse.add(0.0); 
		vitesse.add(0.0);
		
		for (int i = 0; i < nbparticules; i++) {
			Vector<Double> position = new Vector<Double>(2);
			position.add(Math.random()*taillefenetrex/5-taillefenetrex/10);
			position.add(Math.random()*taillefenetrey/5-taillefenetrey/10);
			Boolean sante;
			
			if (Math.random()<0.9) {
				sante=true; }
			else {
				sante=false;
			}
			Personne p1 = new Personne(position, vitesse, sante,pk/100000);
			if (!sante) {
				p1.setColor(Color.red);
			}
			//System.out.println(signealeatoire);

			
			simulateur.addParticule(p1);
			}
		}
	
	public void ajouteDocteurs(int nbDocteurs,double pk) {
		Vector<Double> vitesse = new Vector<Double>(2); 
		vitesse.add(0.0); 
		vitesse.add(0.0);
		
		for (int i = 0; i < nbDocteurs; i++) {
			Vector<Double> position = new Vector<Double>(2);
			position.add(Math.random()*taillefenetrex/5-taillefenetrex/10);
			position.add(Math.random()*taillefenetrey/5-taillefenetrey/10);
			Docteur d = new Docteur(position, vitesse,pk);
			simulateur.addParticule(d);
		}
	}
			
	public void ajouteMilieuLimitant(double x_point, double y_point, double x_vect, double y_vect, double x_champ, double y_champ) {
		Vector<Double> point= new Vector<Double>(2);
		point.add(x_point);
		point.add(y_point);
		Vector<Double> vec= new Vector<Double>(2);
		vec.add(x_vect);
		vec.add(y_vect);
		DemiPlan dp=new DemiPlan(point,vec);
		
		Vector<Double> g = new Vector<Double>(2);
		g.add(x_champ);
		g.add(y_champ);
		MilieuLimitant ml = new MilieuLimitant(dp,g);
		simulateur.addMilieu(ml);
	}
	
	public void ajouteConfinement(double x) {
		ajouteMilieuLimitant(0, x, 0, 1, 0, -0.1);
		ajouteMilieuLimitant(x, 0, 1, 0, -0.1, 0);
		ajouteMilieuLimitant(0, -x, 0, -1, 0, 0.1);
		ajouteMilieuLimitant(-x, 0, -1, 0, 0.1, 0);
	}

	public void setT_step(int t_step) {
		this.t_step = t_step;
	}



	public void setTaillefenetrex(int taillefenetrex) {
		this.taillefenetrex = taillefenetrex;
	}



	public void setTaillefenetrey(int taillefenetrey) {
		this.taillefenetrey = taillefenetrey;
	}



	public void setSimulateur(Simulateur simulateur) {
		this.simulateur = simulateur;
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