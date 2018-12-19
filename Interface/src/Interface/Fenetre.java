package Interface;

import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Fenetre extends JFrame {
	// Inserer simulateur
	private Simulateur sim;
	private int tailleFenetrex;
	private int tailleFenetrey;
	private final Surface surface;

	public Fenetre(Simulateur simulateur, int tx, int ty) {
		sim = simulateur;
		tailleFenetrex = tx;
		tailleFenetrey = ty;
		surface = new Surface(simulateur);
		initUI();
	}
	
	public Fenetre(Simulateur simulateur) {
		this(simulateur, 500, 500);
	}

	private void initUI() {

		add(surface);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				Timer timer = surface.getTimer();
				timer.stop();
			}
		});

		setTitle("Points");
		setSize(tailleFenetrex, tailleFenetrey);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void update() {
		surface.update();
	}
}
