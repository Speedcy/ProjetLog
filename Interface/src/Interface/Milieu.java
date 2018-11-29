package Interface;

public class Milieu {
	private Forme forme;
	
	public Milieu(){
		// Si pas de milieu à gérer
	}
	
	public Milieu(Forme forme){
		this.forme=forme;
	}

	@Override
	public String toString() {
		return "Milieu []";
	}

	public Forme getForme() {
		return forme;
	}

	public void setForme(Forme forme) {
		this.forme = forme;
	}

}


