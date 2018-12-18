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
		
		

		// Test sur le temps
		
		double masse = 9.1*Math.pow(10, -31);
		double charge = -1.6*Math.pow(10,-19);
				

		Config2 config = new Config2(50, 500, 500);
		config.ajouteDocteurs(3);
		config.ajoutePersonne(200); // ajout de particules � vitesse initiale nulle et de signes al�toires
		Forme formetout=new FormeTout();
		Monde monde=new Monde(formetout);
		config.getSimulateur().addMilieu(monde);
		config.ajouteConfinement(200);

/*		Config config = new Config(50, 500, 500);
		config.ajoutParticules(10, charge, masse); // ajout de particules � vitesse initiale nulle et de signes al�toires
		
		config.ajoutChampElec(200., 0., 1., 0., -0.000000000005, 0.);
*/
		
		/*Vector<Double> vitesse = new Vector<Double>(2); 
		vitesse.add(0.0);
		vitesse.add(0.0);
		
		Vector<Double> position1 = new Vector<Double>(2); 
		position1.add(0.); 
		position1.add(200.);
		
		Vector<Double> position2 = new Vector<Double>(2); 
		position2.add(Math.random()*100); 
		position2.add(Math.random()*100);
		
		 ParticuleChargee p1 = new ParticuleChargee(position1,vitesse, 1.6*Math.pow(10,-19),9.1*Math.pow(10, 12));
		 ParticuleChargee p2 = new ParticuleChargee(position2,vitesse, 1.6*Math.pow(10,-19),9.1*Math.pow(10, 12));
		 p2.setColor(Color.red);
		 
		 config.ajoutUnitaire(p1);
		 config.ajoutUnitaire(p2);*/
		 
		//Milieu milieu= new Milieu();

		/*Vector<Double> vitesse = new Vector<Double>(2); 
		vitesse.add(0.0); 
		vitesse.add(0.0);
		
		int t_step = 10;
		int nbparticules = 10;
		*/
		
		
		/*
		Vector<Double> vecd= new Vector<Double>(2);
		vecd.add(1.0);
		vecd.add(1.0);
		Vector<Double> point1= new Vector<Double>(2);
		point1.add(0.0);
		point1.add(200.0);
		DemiPlan dp=new DemiPlan(point1,vecd);
		
		Vector<Double> g= new Vector<Double>(2);
		g.add(0.0);
		g.add(-5.0);
		ChampGravite cg= new ChampGravite(dp,g);
		//deuxieme champ
		Vector<Double> vecd2= new Vector<Double>(2);
		vecd2.add(0.0);
		vecd2.add(-1.0);
		Vector<Double> point2= new Vector<Double>(2);
		point2.add(0.0);
		point2.add(-200.0);
		DemiPlan dp2=new DemiPlan(point2,vecd2);
		
		Vector<Double> g2= new Vector<Double>(2);
		g2.add(0.0);
		g2.add(5.0);
		ChampGravite cg2= new ChampGravite(dp2,g2);
		//3 eme champ
		
		Vector<Double> vecd3= new Vector<Double>(2);
		vecd3.add(1.0);
		vecd3.add(0.0);
		Vector<Double> point3= new Vector<Double>(2);
		point3.add(200.0);
		point3.add(0.0);
		DemiPlan dp3=new DemiPlan(point3,vecd3);
		
		Vector<Double> g3= new Vector<Double>(2);
		g3.add(-5.0);
		g3.add(0.);
		ChampGravite cg3= new ChampGravite(dp3,g3);
		//4
		Vector<Double> vecd4= new Vector<Double>(2);
		vecd4.add(-1.0);
		vecd4.add(0.0);
		Vector<Double> point4= new Vector<Double>(2);
		point4.add(-200.0);
		point4.add(0.0);
		DemiPlan dp4=new DemiPlan(point4,vecd4);
		
		Vector<Double> g4= new Vector<Double>(2);
		g4.add(5.0);
		g4.add(0.);
		ChampGravite cg4= new ChampGravite(dp4,g4);

		
		//Simulateur simulateur = new Simulateur(t_step); 

		config.getSimulateur().addMilieu(cg);
		config.getSimulateur().addMilieu(cg2);
		config.getSimulateur().addMilieu(cg3);
		config.getSimulateur().addMilieu(cg4);
		*/


		
		/*
		Vector<Double> pospar0=new Vector<Double>(2);
		/*pospar0.add(0.);
		pospar0.add(0.);
		ParticuleChargee pfixe = new ParticuleChargee(pospar0,vitesse, -10*charge,1);
		simulateur.addParticule(pfixe);*/

		/*
	  for (int i = 0; i < nbparticules; i++) {
			Vector<Double> position =new Vector<Double>(2);
			position.add(-50+Math.random()*100);
			position.add(-50+Math.random()*100);
			ParticuleChargee p = new ParticuleChargee(position,vitesse, -charge,masse);
			simulateur.addParticule(p);
			p.setColor(Color.red);
		}
		*/
		
		
 
		/*
		Vector<Double> vitesse = new Vector<Double>(2); 
		vitesse.add(0.0); 
		vitesse.add(0.0);
		
		Vector<Double> position1 = new Vector<Double>(2); 
		vitesse.add(40.0); 
		vitesse.add(40.0);
		
		Vector<Double> position2 = new Vector<Double>(2); 
		vitesse.add(50.0); 
		vitesse.add(50.0);
		
		 ParticuleChargee p1 = new ParticuleChargee(position1,vitesse, 1.6*Math.pow(10,-19),9.1*Math.pow(10, -31));
		 ParticuleChargee p2 = new ParticuleChargee(position2,vitesse, 1.6*Math.pow(10,-19),9.1*Math.pow(10, -31));
		 
		 config.ajoutUnitaire(p1);
		 config.ajoutUnitaire(p2);
		 
		 //Vector<Double> force =new Vector<Double>(2); force = p1.force(p2);
		 //System.out.println("ForceMain" + force);
		 
		 Vector<Double> acc21 =new Vector<Double>(2); acc21 = p1.calculAcceleration(p2);
		 System.out.println("Acc2/1Main" + acc21);
		 
		 Vector<Double> acc12 =new Vector<Double>(2); acc12 = p2.calculAcceleration(p1); 
		 System.out.println("Acc1/2Main" + acc12);
		 
		 System.out.println("");
		 */

		 //Milieu milieu= new Milieu();
		 
		 
		// Cr�ation Particule, Milieu, Simulateur

		/*
		 * Simulateur simulateur = new Simulateur(); Vector<Double> position =new
		 * Vector<Double>(2); position.add(50.0); position.add(50.0);
		 * System.out.println(position); Vector<Double> vitesse =new Vector<Double>(2);
		 * vitesse.add(2.0); vitesse.add(0.0); System.out.println(vitesse); Particule
		 * particule = new Particule(position,vitesse); System.out.println(particule);
		 * simulateur.addParticule(particule); Milieu milieu= new Milieu();
		 * simulateur.addMilieu(milieu); System.out.println(milieu);
		 * System.out.println(simulateur);
		 * System.out.println(simulateur.getListeparticules());
		 */

		// Affichage

		
		EventQueue.invokeLater(new Runnable() {
			 
			 @Override public void run() { 
				 Fenetre fenetre = new Fenetre(config.getSimulateur(),config.getTaillefenetrex(),config.getTaillefenetrey());
				 fenetre.setVisible(true);
				 // start sim (fenetre)
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
	
	// Gestion du Timer
	/*
	 TimerTask timerTask = new TaskForPC(simulateur);
		Timer timer = new Timer(true);
		timer.scheduleAtFixedRate(timerTask, 0, t_step);
		System.out.println("Lancement execution");

		try {
			Thread.sleep(2000);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		timer.cancel();

		System.out.println("Abandon execution");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		*/

}
