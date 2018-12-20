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
		
		double masse = 9.1*Math.pow(10, -31);
		double charge = -1.6*Math.pow(10,-19);
		
		Config config = new Config(50, 1000, 500);
	
		config.ajoutParticules(2, charge, masse); // ajout de particules � vitesse initiale nulle et de signes al�toires
		
		config.ajoutChampElec(200., 0., 1., 0., -0.000000000005, 0.);
		
		
		// SIMULATION 2 : Plague

		/*double freqMort=10;
		double peur=0.05;
		Config2 config = new Config2(40, 500, 500);
		config.ajouteDocteurs(3);
		config.ajoutePersonne(60,freqMort,peur); // ajout de particules � vitesse initiale nulle et de signes al�toires
		config.ajouteConfinement(50);*/

		
		
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
