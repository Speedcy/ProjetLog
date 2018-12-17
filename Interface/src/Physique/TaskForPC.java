package Physique;

import java.util.Date;
import java.util.TimerTask;

import Interface.Fenetre;
import Interface.Simulateur;

public class TaskForPC extends TimerTask {
	private Simulateur s;
	private Fenetre f;
	
	public TaskForPC(Simulateur sim, Fenetre fenetre) {
		s = sim;
		f = fenetre;
	}

	@Override
	public void run() {
		
		s.step(); // Mise à jour des positions et vitesses
		f.update(); // Mise à jour de l'affichage
		
	}
}
