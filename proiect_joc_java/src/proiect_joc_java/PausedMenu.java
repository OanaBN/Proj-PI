package proiect_joc_java;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.KeyEvent;

public class PausedMenu {
	public class PauseMenu {
	    private static final KeyEvent KeyEvent = null;
		private Rectangle resumeButton = new Rectangle(400, 150, 200, 50);
	    private Rectangle optionsButton = new Rectangle(400, 250, 200, 50);
	    private Rectangle saveButton = new Rectangle(400, 350, 200, 50);
	    private Rectangle loadButton = new Rectangle(400, 450, 200, 50);
	    private Rectangle quitButton = new Rectangle(400, 550, 200, 50);


	    public void handleClick(int mouseX, int mouseY, EcranJoc ecranJoc) {
	        if (resumeButton.contains(mouseX, mouseY)) {
	            ecranJoc.setPaused(false);
	        } else if (optionsButton.contains(mouseX, mouseY)) {
	            // Implement options functionality
	            // For example: ecranJoc.showOptions();
	        } else if (saveButton.contains(mouseX, mouseY)) {
	            // Implement save functionality
	            // For example: ecranJoc.saveGame();
	        } else if (loadButton.contains(mouseX, mouseY)) {
	            // Implement load functionality
	            // For example: ecranJoc.loadGame();
	        } else if (quitButton.contains(mouseX, mouseY)) {
	        	ecranJoc.quitGame();
	            //System.exit(0); // For simplicity, exiting the program
	        }
	    }
	}

	public void draw(Graphics2D g2d) {
		// Draw menu background
        g2d.setColor(new Color(0, 0, 0, 150)); // Semi-transparent black
        g2d.fillRect(0, 0, 1500, 900);

        // Draw menu components
        g2d.setColor(Color.WHITE);
        g2d.setFont(new Font("Arial", Font.PLAIN, 30));

        g2d.drawString("Paused", 550, 100);

        Shape resumeButton = null;
		g2d.draw(resumeButton);
        g2d.drawString("Resume", 470, 185);

        Shape optionsButton = null;
		g2d.draw(optionsButton);
        g2d.drawString("Options", 470, 285);

        Shape saveButton = null;
		g2d.draw(saveButton);
        g2d.drawString("Save", 490, 385);

        Shape loadButton = null;
		g2d.draw(loadButton);
        g2d.drawString("Load", 490, 485);

        Shape quitButton = null;
		g2d.draw(quitButton);
        g2d.drawString("Quit", 495, 585);
		
	}
}
