package Physique;

import java.util.Date;
import java.util.TimerTask;

import Interface.Simulateur;

public class TaskForPC extends TimerTask {
	// Mettre a jour la position et la vitesse
	private Simulateur s;
	
	public TaskForPC(Simulateur sim) {
		s = sim;
	}

	@Override
	public void run() {
		System.out.println("Debut execution tache " + new Date());

		try {

			s.step();
			Thread.sleep(s.getT_step());

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Fin execution tache " + new Date());
	}
}
