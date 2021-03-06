package Plague;

import java.awt.Color;
import java.util.Vector;

import Interface.Calculateur;
import Interface.Particule;

public class Personne extends Particule {
	private boolean sante;
	private double peur;
	public boolean kill;
	private double pk;

	public Personne(Vector<Double> p, Vector<Double> v, boolean sante,double pk) {
		super(p, v);
		this.sante=sante;
		kill=false;
		this.pk=pk;
		this.peur=0.1;
	}

	public boolean isKill() {
		return kill;
	}



	public void setKill(boolean kill) {
		this.kill = kill;
	}



	public boolean isSante() {
		return sante;
	}

	public void setPeur(double peur) {
		this.peur = peur;
	}

	public void setSante(boolean sante) {
		this.sante = sante;
	}
	public Vector<Double> calculAcceleration(Particule p) {
		boolean sante2 = true;
		if (!(this.sante)) {
			if (Math.random()<pk) {
				this.setKill(true);
				//System.out.println(this.kill);
			}
		}
		if (!(( ((Personne)p).isSante()))) {
			if (Math.random()<pk) {
				((Personne)p).setKill(true);
			}
		}
		try {
			sante2 = ((Personne) p).isSante();
			
		} catch (Exception e) {
			System.out.println("Particules de types différents : intérraction non prise en charge");
		}
		Vector<Double> vecr=new Vector<Double>(4);
		if (sante2) {
			if (this.sante) {
				vecr.add(0.);
				vecr.add(0.);
				vecr.add(0.0);
				vecr.add(0.0);
			}
			else {
				vecr.addElement(0.0);
				vecr.addElement(0.0);
				Vector<Double> res ;
				double dis;
				dis=Calculateur.distance(this, p);
				if(dis<10) {
					((Personne)p).setSante(false);
					p.setColor(Color.red);
				}
				res=Calculateur.multDblVec(peur*Math.pow(Calculateur.distance(this, p), -2),Calculateur.dif(p.getPosition(),this.getPosition()) );
				vecr.addElement(res.get(0));
				vecr.addElement(res.get(1));
			}
			
		}
		else {
			if(this.sante) {
				Vector<Double> res ;
				double dis;
				dis=Calculateur.distance(this, p);
				if(dis<10) {
					this.setSante(false);
					this.setColor(Color.red);
				}
				
				res=Calculateur.multDblVec(peur*Math.pow(dis, -2),Calculateur.dif(this.getPosition(),p.getPosition()) );
				vecr.addElement(res.get(0));
				vecr.addElement(res.get(1));
				vecr.addElement(0.0);
				vecr.addElement(0.0);
			}
			else {
				vecr.add(0.0);
				vecr.add(0.0);
				vecr.add(0.0);
				vecr.add(0.0);
			}
				
			
			
			}
		
		return vecr;
		}

	}
		
		
	
	


