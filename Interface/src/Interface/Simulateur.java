package Interface;

import java.util.Vector;

public class Simulateur {
	private Vector<Particule> listeparticules = new Vector<Particule>();
	private Vector<Milieu> milieux = new Vector<Milieu>();
	private int t_step = 100; // intervalle de temps entre deux calculs de la simulation (en ms)

	public Simulateur(int t) {
		t_step = t;
	}

	public Vector<Particule> getListeparticules() {
		return listeparticules;
	}

	public void addParticule(Particule particule) {
		listeparticules.add(particule);
	}

	public void addMilieu(Milieu milieu) {
		milieux.add(milieu);
	}

	public int getT_step() {
		return t_step;
	}

	@Override
	public String toString() {
		return "Simulateur [listeparticules=" + listeparticules + ", milieux=" + milieux + "]";
	}
	
	public void step() {
		// Execution d'une etape de la simulation : mise à jour des positions et vitesses
		System.out.println("Processus lancé");
		/*for (int i = 0; i < listeparticules.length; i++) {
			Particule p_i = listeparticules.get(i);
			
			Vector<Double> previousposition = new Vector<Double>(2);
			previousposition = p_i.getPosition();
			Vector<Double> previousvitesse = new Vector<Double>(2);
			previousvitesse = p_i.getVitesse();
			double newpositionx = previousposition.get(0) + previousvitesse.get(0)*t_step;
			double newpositiony = previousposition.get(1) + previousvitesse.get(1)*t_step;
			
			Vector<Double> newposition = new Vector<Double>(2);
			newposition.add(newpositionx);
			newposition.add(newpositiony);
			
			p_i.setPosition(newposition);

			for (int j = i+1; j < listeparticules.length; i++) {
				Particule p_j = listeparticules.get(j);
				
				double newaccelerationx;
				// Tableau de taille 1 à n
				
				Vector<Double> acc =new Vector<Double>(4);
				acc = p_i.calculAcceleration(p_j);
			}
		}*/
	}

}
