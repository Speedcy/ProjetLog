package Interface;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Fenetre extends JFrame {
	// Inserer simulateur
	private Simulateur sim;

    public Fenetre(Simulateur simulateur) {
    	
        sim = simulateur;
    	initUI(sim);
    }

    private void initUI(Simulateur simu) {

        final Surface surface = new Surface(simu);
        add(surface);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Timer timer = surface.getTimer();
                timer.stop();
            }
        });

        setTitle("Points");
        setSize(10, 10);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
