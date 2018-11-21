package Interface;

import java.util.Vector;

public class Simulateur {
	private Vector<Particule> listeparticules = new Vector<Particule>();
	private Vector<Milieu>	milieux = new Vector<Milieu>();
	
	public Simulateur(){
	}
	
	public Vector<Particule> getListeparticules() {
		return listeparticules;
	}

	public void addParticule(Particule particule){
		listeparticules.add(particule);
	}
	
	public void addMilieu(Milieu milieu){
		milieux.add(milieu);	
	}
	
	@Override
	public String toString() {
		return "Simulateur [listeparticules=" + listeparticules + ", milieux=" + milieux + "]";
	}

	

}
