package Interface;

import java.util.Vector;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import Plague.Config2;
import Plague.Monde;
import Physique.Config;
import Physique.ChampGravite;
import Physique.ParticuleChargee;

import java.awt.Color;
import java.awt.EventQueue;

public class Main {

	public static void main(String[] args) {

		// SIMULATION 1 : Particules Charg�es
		/*
		int t_step = 50;
		int x_fenetre = 500;
		int y_fenetre = 500;
		
		int nbParticules = 2;
		double masse = 9.1*Math.pow(10, -31);
		double charge = -1.6*Math.pow(10,-19);
		
		Config config = new Config(t_step, x_fenetre, y_fenetre);
	
		config.ajoutParticules(nbParticules, charge, masse); // ajout de particules � vitesse initiale nulle et de signes al�toires
		
		//config.ajoutChampElec(200., 0., 1., 0., -0.000000000005, 0.);
		*/
		
		// SIMULATION 2 : Plague

		int t_step = 50;
		int x_fenetre = 500;
		int y_fenetre = 500;
		
		double freqMort=10;
		double peur=0.5;
		int nbDocteurs = 3;
		int nbPersonnes = 50;
		int tailleConfinement = 50;
		
		
		Config2 config = new Config2(t_step, x_fenetre, y_fenetre);
		config.ajouteDocteurs(nbDocteurs);
		config.ajoutePersonne(nbPersonnes,freqMort,peur); // ajout de particules � vitesse initiale nulle et de signes al�toires
		config.ajouteConfinement(tailleConfinement);

		
		
		// Affichage

		
		EventQueue.invokeLater(new Runnable() {
			 
			 @Override public void run() { 
				 Fenetre fenetre = new Fenetre(config.getSimulateur(),config.getTaillefenetrex(),config.getTaillefenetrey());
				 fenetre.setVisible(true);
				 startSimulation(config.getSimulateur(), fenetre, config.getT_step());
			 }
			 });
	}
	
	public static void startSimulation(Simulateur simulateur, Fenetre fenetre, int t_step){
		TimerTask timerTask = new TaskForPC(simulateur, fenetre);
		Timer timer = new Timer(true);
		timer.scheduleAtFixedRate(timerTask, 0, t_step);
		System.out.println("Lancement execution");
	}
	
}
