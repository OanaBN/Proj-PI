package proiect_joc_java;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyAdapt extends KeyAdapter{
	
	Jucator j;
	
	public KeyAdapt(Jucator jucator) {
		
	j = jucator;
		
	}
	
	public void keyPressed(KeyEvent e) {
		j.keyPressed(e);
	}
	
    public void keyReleased(KeyEvent e) {
    	j.keyReleased(e);
	}

}
