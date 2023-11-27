package proiect_joc_java;
import java.awt.Graphics;

import javax.swing.JFrame;
public class Main {
	
	public static void main(String[] args) {
	    JFrame frame = new JFrame("ProiectJoc");
	    frame.setSize(1500,800);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setResizable(false);
	    frame.add(new EcranJoc());
	    frame.setVisible(true);

}
	
}
