package proiect_joc_java;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Magie extends Entitate{
	
	private static int kills = 0;

    public Magie(int x, int y) {
    	super(x,y);
    }
    
    public void update() {
    	x += 3;
    	
    	checkEnemyCollisions();
    	
    	 if (x > 1200) {
             EcranJoc.removeMagie(this);
         }
    }
    
    public void draw(Graphics2D g2d) {
    	g2d.drawImage(getMagieImg(),x,y,null);
    }
    
    public Image getMagieImg() {
		ImageIcon ic = new ImageIcon("C:/Users/Legion/Desktop/Homework/Assets/foc.png");
		return ic.getImage();
	}
    public Rectangle getBounds() {
     	return new Rectangle(x,y,getMagieImg().getWidth(null),getMagieImg().getHeight(null));
    }
     	
     	private void checkEnemyCollisions() {
            ArrayList<Inamic> inamici = EcranJoc.getInamicList();

            for (int i = 0; i < inamici.size(); i++) {
                Inamic tempInamic = inamici.get(i);
                if (getBounds().intersects(tempInamic.getBounds())) {
                    EcranJoc.removeMagie(this);
                    EcranJoc.removeInamic(tempInamic);
                    kills++; // Increment the kill count
                }
            }
}
     	
     	public static int getKills() {
            return kills;
        }
}
